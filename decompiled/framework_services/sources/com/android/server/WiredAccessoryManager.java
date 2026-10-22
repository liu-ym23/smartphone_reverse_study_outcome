package com.android.server;

import android.R;
import android.content.Context;
import android.hardware.audio.common.V2_0.AudioDevice;
import android.media.AudioManager;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.PowerManager;
import android.os.UEventObserver;
import android.util.Log;
import android.util.Pair;
import android.util.Slog;
import com.android.server.input.InputManagerService;
import com.android.server.slice.SliceClientPermissions;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
final class WiredAccessoryManager implements InputManagerService.WiredAccessoryCallbacks {
    private static final int BIT_HDMI_AUDIO = 16;
    private static final int BIT_HEADSET = 1;
    private static final int BIT_HEADSET_NO_MIC = 2;
    private static final int BIT_LINEOUT = 32;
    private static final int BIT_USB_HEADSET_ANLG = 4;
    private static final int BIT_USB_HEADSET_DGTL = 8;
    private static final String[] DP_AUDIO_CONNS = null;
    private static final String INTF_DP = "DP";
    private static final String INTF_HDMI = "HDMI";
    private static final boolean LOG = true;
    private static final int MAX_DP_COUNT = 2;
    private static final int MSG_NEW_DEVICE_STATE = 1;
    private static final int MSG_SYSTEM_READY = 2;
    private static final String NAME_DP_AUDIO = "soc:qcom,msm-ext-disp";
    private static final String NAME_H2W = "h2w";
    private static final String NAME_HDMI = "hdmi";
    private static final String NAME_HDMI_AUDIO = "hdmi_audio";
    private static final String NAME_USB_AUDIO = "usb_audio";
    private static final int SUPPORTED_HEADSETS = 63;
    private static final String TAG = null;
    private final AudioManager mAudioManager;
    private String mDetectedIntf;
    private int mDpCount;
    private final WiredAccessoryExtconObserver mExtconObserver;
    private final Handler mHandler;
    private int mHeadsetState;
    private final InputManagerService mInputManager;
    private final Object mLock;
    private final WiredAccessoryObserver mObserver;
    private int mSwitchValues;
    private final boolean mUseDevInputEventForAudioJack;
    private final PowerManager.WakeLock mWakeLock;

    private class WiredAccessoryExtconObserver extends ExtconStateObserver<Pair<Integer, Integer>> {
        private final List<ExtconUEventObserver.ExtconInfo> mExtconInfos;
        final /* synthetic */ WiredAccessoryManager this$0;

        @Override // com.android.server.ExtconStateObserver
        public /* bridge */ /* synthetic */ Pair<Integer, Integer> parseState(ExtconUEventObserver.ExtconInfo r1, String r2) {
            return parseState(r1, r2);
        }

        @Override // com.android.server.ExtconStateObserver
        public /* bridge */ /* synthetic */ void updateState(ExtconUEventObserver.ExtconInfo r1, String r2, Pair<Integer, Integer> r3) {
            updateState2(r1, r2, r3);
        }

        WiredAccessoryExtconObserver(WiredAccessoryManager r4) {
            this.this$0 = r4;
            this.mExtconInfos = ExtconUEventObserver.ExtconInfo.getExtconInfoForTypes(new String[]{ExtconUEventObserver.ExtconInfo.EXTCON_HEADPHONE, ExtconUEventObserver.ExtconInfo.EXTCON_MICROPHONE, "HDMI", ExtconUEventObserver.ExtconInfo.EXTCON_LINE_OUT});
        }

        private void init() {
            Iterator<ExtconUEventObserver.ExtconInfo> r0 = this.mExtconInfos.iterator();
        L4:
            if (r0.hasNext() == false) goto L18;
            ExtconUEventObserver.ExtconInfo extconInfo = r0.next();
            Pair<Integer, Integer> state = null;
            state = parseStateFromFile(extconInfo);     // Catch: IOException -> L9 FileNotFoundException -> L11
        L15:
            if (state == null) goto L17;
            updateState2(extconInfo, extconInfo.getName(), state);
        L17:
            Slog.d(WiredAccessoryManager.m525$$Nest$sfgetTAG(), "observing " + extconInfo.getName());
            startObserving(extconInfo);
            goto L4
        L11:
            e = move-exception;
            Slog.w(WiredAccessoryManager.m525$$Nest$sfgetTAG(), extconInfo.getStatePath() + " not found while attempting to determine initial state", e);
        L9:
            e = move-exception;
            Slog.e(WiredAccessoryManager.m525$$Nest$sfgetTAG(), "Error reading " + extconInfo.getStatePath() + " while attempting to determine initial state", e);
            goto L15
        }

        public int uEventCount() {
            return this.mExtconInfos.size();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.android.server.ExtconStateObserver
        public Pair<Integer, Integer> parseState(ExtconUEventObserver.ExtconInfo extconInfo, String status) {
            Slog.v(WiredAccessoryManager.m525$$Nest$sfgetTAG(), "status  " + status);
            int[] maskAndState = {0, 0};
            if (extconInfo.hasCableType(ExtconUEventObserver.ExtconInfo.EXTCON_HEADPHONE) == false) goto L6;
            WiredAccessoryManager.m526$$Nest$smupdateBit(maskAndState, 2, status, ExtconUEventObserver.ExtconInfo.EXTCON_HEADPHONE);
        L6:
            if (extconInfo.hasCableType(ExtconUEventObserver.ExtconInfo.EXTCON_MICROPHONE) == false) goto L9;
            WiredAccessoryManager.m526$$Nest$smupdateBit(maskAndState, 1, status, ExtconUEventObserver.ExtconInfo.EXTCON_MICROPHONE);
        L9:
            if (extconInfo.hasCableType("HDMI") == false) goto L12;
            WiredAccessoryManager.m526$$Nest$smupdateBit(maskAndState, 16, status, "HDMI");
        L12:
            if (extconInfo.hasCableType(ExtconUEventObserver.ExtconInfo.EXTCON_LINE_OUT) == false) goto L14;
            WiredAccessoryManager.m526$$Nest$smupdateBit(maskAndState, 32, status, ExtconUEventObserver.ExtconInfo.EXTCON_LINE_OUT);
        L14:
            Slog.v(WiredAccessoryManager.m525$$Nest$sfgetTAG(), "mask " + maskAndState[0] + " state " + maskAndState[1]);
            return Pair.create(Integer.valueOf(maskAndState[0]), Integer.valueOf(maskAndState[1]));
        }

        /* JADX INFO: renamed from: updateState, reason: avoid collision after fix types in other method */
        public void updateState2(ExtconUEventObserver.ExtconInfo extconInfo, String name, Pair<Integer, Integer> maskAndState) {
            Object r0 = WiredAccessoryManager.m517$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
            int mask = ((Integer) maskAndState.first).intValue();     // Catch: Throwable -> L7
            int state = ((Integer) maskAndState.second).intValue();     // Catch: Throwable -> L7
            WiredAccessoryManager.m523$$Nest$mupdateLocked(this.this$0, name, "", (WiredAccessoryManager.m516$$Nest$fgetmHeadsetState(this.this$0) & (~((~state) & mask))) | (mask & state), false);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }
    }

    class WiredAccessoryObserver extends UEventObserver {
        private List<String> mDevPath;
        private final List<UEventInfo> mUEventInfo;
        final /* synthetic */ WiredAccessoryManager this$0;

        private final class UEventInfo {
            static final /* synthetic */ boolean $assertionsDisabled = false;
            private int mCableIndex;
            private int mController;
            private String mDevAddress;
            private int mDevIndex;
            private final String mDevName;
            private final int mState1Bits;
            private final int mState2Bits;
            private final int mStateNbits;
            private int mStream;

            static {
            }

            public UEventInfo(WiredAccessoryObserver r5, String devName, int state1Bits, int state2Bits, int stateNbits) {
                this.mDevName = devName;
                this.mState1Bits = state1Bits;
                this.mState2Bits = state2Bits;
                this.mStateNbits = stateNbits;
                this.mDevAddress = "controller=0;stream=0";
                this.mDevIndex = -1;
                this.mCableIndex = -1;
                this.mStream = 0;
                this.mController = 0;
                if (this.mDevName.startsWith(WiredAccessoryManager.NAME_DP_AUDIO) == false) goto L8;
                int idx = this.mDevName.indexOf(SliceClientPermissions.SliceAuthority.DELIMITER);
                if (idx == (-1)) goto L9;
                int idx2 = this.mDevName.indexOf(SliceClientPermissions.SliceAuthority.DELIMITER, idx + 1);
                int dev = Integer.parseInt(this.mDevName.substring(idx + 1, idx2));
                int cable = Integer.parseInt(this.mDevName.substring(idx2 + 1));
                checkDevIndex(dev);
                checkCableIndex(cable);
                return;
            L9:
                return;
            }

            public String getDevName() {
                return this.mDevName;
            }

            public String getDevPath() {
                if (this.mDevName.startsWith(WiredAccessoryManager.NAME_DP_AUDIO) == false) goto L7;
                return String.format(Locale.US, "/devices/platform/soc/%s/extcon/extcon%d", new Object[]{WiredAccessoryManager.NAME_DP_AUDIO, Integer.valueOf(this.mDevIndex)});
            L7:
                return String.format(Locale.US, "/devices/virtual/switch/%s", new Object[]{this.mDevName});
            }

            public String getSwitchStatePath() {
                if (this.mDevName.startsWith(WiredAccessoryManager.NAME_DP_AUDIO) == false) goto L7;
                return String.format(Locale.US, "/sys/devices/platform/soc/%s/extcon/extcon%d/cable.%d/state", new Object[]{WiredAccessoryManager.NAME_DP_AUDIO, Integer.valueOf(this.mDevIndex), Integer.valueOf(this.mCableIndex)});
            L7:
                return String.format(Locale.US, "/sys/class/switch/%s/state", new Object[]{this.mDevName});
            }

            public boolean checkSwitchExists() {
                File f = new File(getSwitchStatePath());
                return f.exists();
            }

            public int computeNewHeadsetState(int headsetState, int switchState) {
                int preserveMask = ~((this.mState1Bits | this.mState2Bits) | this.mStateNbits);
                if (switchState != 1) goto L6;
                int setBits = this.mState1Bits;
            L13:
                return (headsetState & preserveMask) | setBits;
            L6:
                if (switchState != 2) goto L9;
                setBits = this.mState2Bits;
                goto L13
            L9:
                if (switchState != this.mStateNbits) goto L11;
                setBits = this.mStateNbits;
                goto L13
            L11:
                setBits = 0;
                goto L13
            }

            public String getDevAddress() {
                return this.mDevAddress;
            }

            private void checkDevIndex(int index) {
                char[] buffer = new char[1024];
                String devPath = String.format(Locale.US, "/sys/devices/platform/soc/%s/extcon/extcon%d/name", new Object[]{WiredAccessoryManager.NAME_DP_AUDIO, Integer.valueOf(index)});
                File f = new File(devPath);
                if (f.exists() == true) goto L29;
                Slog.e(WiredAccessoryManager.m525$$Nest$sfgetTAG(), "file " + devPath + " not found");
                return;
            L29:
                FileReader file = new FileReader(f);     // Catch: Exception -> L16
                int len = file.read(buffer, 0, 1024);     // Catch: Throwable -> L12
                String devName = new String(buffer, 0, len).trim();     // Catch: Throwable -> L12
                if (devName.startsWith(WiredAccessoryManager.NAME_DP_AUDIO) == false) goto L14;
                Slog.e(WiredAccessoryManager.m525$$Nest$sfgetTAG(), "set mDevIndex " + index + " devPath " + devPath);     // Catch: Throwable -> L12
                this.mDevIndex = index;     // Catch: Throwable -> L12
            L14:
                file.close();     // Catch: Exception -> L16
                return;
            L12:
                th = move-exception;
                file.close();     // Catch: Throwable -> L20
            L22:
                throw th;     // Catch: Exception -> L16
            L20:
                th = move-exception;
                th.addSuppressed(th);     // Catch: Exception -> L16
            L16:
                e = move-exception;
                Slog.e(WiredAccessoryManager.m525$$Nest$sfgetTAG(), "checkDevIndex exception ", e);
            }

            private void checkCableIndex(int cable_index) {
                if (this.mDevIndex != (-1)) goto L5;
                return;
            L5:
                char[] buffer = new char[1024];
                String cablePath = String.format(Locale.US, "/sys/devices/platform/soc/%s/extcon/extcon%d/cable.%d/name", new Object[]{WiredAccessoryManager.NAME_DP_AUDIO, Integer.valueOf(this.mDevIndex), Integer.valueOf(cable_index)});
                Slog.v(WiredAccessoryManager.m525$$Nest$sfgetTAG(), "checkCableIndex " + cablePath);
                File f = new File(cablePath);
                if (f.exists() == true) goto L34;
                Slog.e(WiredAccessoryManager.m525$$Nest$sfgetTAG(), "file " + cablePath + " not found");
                return;
            L34:
                FileReader file = new FileReader(f);     // Catch: Exception -> L22
                int len = file.read(buffer, 0, 1024);     // Catch: Throwable -> L17
                String cableName = new String(buffer, 0, len).trim();     // Catch: Throwable -> L17
                if ("HDMI".equals(cableName) == true) goto L19;
                if (WiredAccessoryManager.INTF_DP.equals(cableName) == true) goto L19;
                Slog.i(WiredAccessoryManager.m525$$Nest$sfgetTAG(), "checkCableIndex no name match, skip for cable " + cablePath);     // Catch: Throwable -> L17
            L20:
                file.close();     // Catch: Exception -> L22
                return;
            L19:
                this.mCableIndex = cable_index;     // Catch: Throwable -> L17
                Slog.i(WiredAccessoryManager.m525$$Nest$sfgetTAG(), "checkCableIndex set cable for " + cableName + " " + cable_index + " cable " + cablePath);     // Catch: Throwable -> L17
            L17:
                th = move-exception;
                file.close();     // Catch: Throwable -> L26
            L28:
                throw th;     // Catch: Exception -> L22
            L26:
                th = move-exception;
                th.addSuppressed(th);     // Catch: Exception -> L22
            L22:
                e = move-exception;
                Slog.e(WiredAccessoryManager.m525$$Nest$sfgetTAG(), "checkCableIndex exception", e);
            }

            public void setStreamIndex(int streamIndex) {
                this.mStream = streamIndex;
                this.mDevAddress = String.format("controller=%d;stream=%d", new Object[]{Integer.valueOf(this.mController), Integer.valueOf(this.mStream)});
            }

            public void setController(int controller) {
                this.mController = controller;
                this.mDevAddress = String.format("controller=%d;stream=%d", new Object[]{Integer.valueOf(this.mController), Integer.valueOf(this.mStream)});
            }

            public String toString() {
                return "UEventInfo  name=" + this.mDevName + " mDevAddress=" + this.mDevAddress;
            }
        }

        public WiredAccessoryObserver(WiredAccessoryManager this$0) {
            this.this$0 = this$0;
            this.mDevPath = new ArrayList();
            this.mUEventInfo = makeObservedUEventList();
        }

        void init() {
            Object r0 = WiredAccessoryManager.m517$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
            Slog.v(WiredAccessoryManager.m525$$Nest$sfgetTAG(), "init()");     // Catch: Throwable -> L13
            char[] buffer = new char[1024];     // Catch: Throwable -> L13
            int i = 0;
        L6:
            if (i >= this.mUEventInfo.size()) goto L26;
            UEventInfo uei = this.mUEventInfo.get(i);     // Catch: Throwable -> L13
            String switchStatePath = uei.getSwitchStatePath();     // Catch: Throwable -> L13 Exception -> L15 FileNotFoundException -> L17
            FileReader file = new FileReader(switchStatePath);     // Catch: Throwable -> L13 Exception -> L15 FileNotFoundException -> L17
            int len = file.read(buffer, 0, 1024);     // Catch: Throwable -> L13 Exception -> L15 FileNotFoundException -> L17
            file.close();     // Catch: Throwable -> L13 Exception -> L15 FileNotFoundException -> L17
            int curState = Integer.parseInt(new String(buffer, 0, len).trim());     // Catch: Throwable -> L13 Exception -> L15 FileNotFoundException -> L17
            if (curState <= 0) goto L24;
            int index = switchStatePath.lastIndexOf(".");     // Catch: Throwable -> L13 Exception -> L15 FileNotFoundException -> L17
            if (switchStatePath.substring(index + 1, index + 2).equals("1") == false) goto L19;
            WiredAccessoryManager.m520$$Nest$fputmDetectedIntf(this.this$0, "HDMI");     // Catch: Throwable -> L13 Exception -> L15 FileNotFoundException -> L17
        L19:
            updateStateLocked(uei.getDevPath(), uei.getDevName(), curState);     // Catch: Throwable -> L13 Exception -> L15 FileNotFoundException -> L17
        L24:
            i = i + 1;     // Catch: Throwable -> L13
            goto L6
        L15:
            e = move-exception;
            Slog.e(WiredAccessoryManager.m525$$Nest$sfgetTAG(), "Error while attempting to determine initial switch state for " + uei.getDevName(), e);     // Catch: Throwable -> L13
        L23:
            Slog.w(WiredAccessoryManager.m525$$Nest$sfgetTAG(), uei.getSwitchStatePath() + " not found while attempting to determine initial switch state");     // Catch: Throwable -> L13
            goto L24
        L26:
            monitor-exit(r0);     // Catch: Throwable -> L13
            int i2 = 0;
        L29:
            if (i2 >= this.mUEventInfo.size()) goto L36;
            UEventInfo uei2 = this.mUEventInfo.get(i2);
            String devPath = uei2.getDevPath();
            if (this.mDevPath.contains(devPath) == true) goto L34;
            startObserving("DEVPATH=" + uei2.getDevPath());
            this.mDevPath.add(devPath);
        L34:
            i2 = i2 + 1;
            goto L29
        L36:
            return;
        L13:
            th = move-exception;
            throw th;
        }

        private List<UEventInfo> makeObservedUEventList() {
            List<UEventInfo> retVal = new ArrayList();
            if (WiredAccessoryManager.m518$$Nest$fgetmUseDevInputEventForAudioJack(this.this$0) == true) goto L8;
            UEventInfo uei = new UEventInfo(this, WiredAccessoryManager.NAME_H2W, 1, 2, 32);
            if (uei.checkSwitchExists() == false) goto L7;
            retVal.add(uei);
            goto L8
        L7:
            Slog.w(WiredAccessoryManager.m525$$Nest$sfgetTAG(), "This kernel does not have wired headset support");
        L8:
            UEventInfo uei2 = new UEventInfo(this, WiredAccessoryManager.NAME_USB_AUDIO, 4, 8, 0);
            if (uei2.checkSwitchExists() == false) goto L11;
            retVal.add(uei2);
        L12:
            UEventInfo uei3 = new UEventInfo(this, WiredAccessoryManager.NAME_HDMI_AUDIO, 16, 0, 0);
            if (uei3.checkSwitchExists() == false) goto L15;
            retVal.add(uei3);
        L19:
            int streamIndex = 1;
            String[] r3 = WiredAccessoryManager.m524$$Nest$sfgetDP_AUDIO_CONNS();
            int r4 = r3.length;
            int r5 = 0;
        L20:
            if (r5 >= r4) goto L25;
            String conn = r3[r5];
            UEventInfo uei4 = new UEventInfo(this, conn, 16, 0, 0);
            if (uei4.checkSwitchExists() == false) goto L24;
            uei4.setStreamIndex(streamIndex);
            streamIndex = streamIndex - 1;
            Slog.i(WiredAccessoryManager.m525$$Nest$sfgetTAG(), "Adding " + conn + " with " + uei4.toString() + " to monitor list");
            retVal.add(uei4);
        L24:
            r5 = r5 + 1;
            goto L20
        L25:
            return retVal;
        L15:
            UEventInfo uei5 = new UEventInfo(this, WiredAccessoryManager.NAME_HDMI, 16, 0, 0);
            if (uei5.checkSwitchExists() == false) goto L18;
            retVal.add(uei5);
            goto L19
        L18:
            Slog.w(WiredAccessoryManager.m525$$Nest$sfgetTAG(), "This kernel does not have HDMI audio support");
            goto L19
        L11:
            Slog.w(WiredAccessoryManager.m525$$Nest$sfgetTAG(), "This kernel does not have usb audio support");
            goto L12
        }

        public void onUEvent(UEventObserver.UEvent event) {
            String devPath = event.get("DEVPATH");
            String name = event.get("NAME");
            int state = 0;
            Slog.v(WiredAccessoryManager.m525$$Nest$sfgetTAG(), "onUEvent event=" + event.toString());
            if (name != null) goto L53;
            name = event.get("SWITCH_NAME");
        L53:
            if (name.startsWith(WiredAccessoryManager.NAME_DP_AUDIO) == false) goto L24;
            String state_str = event.get("STATE");     // Catch: NumberFormatException -> L16
            int offset = 0;
            int length = state_str.length();     // Catch: NumberFormatException -> L16
        L8:
            if (offset >= length) goto L45;
            int equals = state_str.indexOf(61, offset);     // Catch: NumberFormatException -> L16
            if (equals <= offset) goto L21;
            String intf_name = state_str.substring(offset, equals);     // Catch: NumberFormatException -> L16
            if (intf_name.equals(WiredAccessoryManager.INTF_DP) == true) goto L18;
            if (intf_name.equals("HDMI") == false) goto L21;
        L18:
            state = Integer.parseInt(state_str.substring(equals + 1, equals + 2));     // Catch: NumberFormatException -> L16
            if (state != 1) goto L21;
            WiredAccessoryManager.m520$$Nest$fputmDetectedIntf(this.this$0, intf_name);     // Catch: NumberFormatException -> L16
        L21:
            offset = equals + 3;     // Catch: NumberFormatException -> L16
        L45:
            Object r3 = WiredAccessoryManager.m517$$Nest$fgetmLock(this.this$0);
            monitor-enter(r3);
            updateStateLocked(devPath, name, state);     // Catch: Throwable -> L50
            monitor-exit(r3);     // Catch: Throwable -> L50
            return;
        L50:
            th = move-exception;
            throw th;
        L24:
            state = Integer.parseInt(event.get("SWITCH_STATE"));     // Catch: NumberFormatException -> L16
            goto L45
        L26:
            Slog.i(WiredAccessoryManager.m525$$Nest$sfgetTAG(), "couldn't get state from event, checking node");
            int i = 0;
        L28:
            if (i >= this.mUEventInfo.size()) goto L45;
            UEventInfo uei = this.mUEventInfo.get(i);
            if (name.equals(uei.getDevName()) == true) goto L31;
            i = i + 1;
            goto L28
        L31:
            char[] buffer = new char[1024];
            int len = 0;
            FileReader file = new FileReader(uei.getSwitchStatePath());     // Catch: Exception -> L34 FileNotFoundException -> L36
            len = file.read(buffer, 0, 1024);     // Catch: Exception -> L34 FileNotFoundException -> L36
            file.close();     // Catch: Exception -> L34 FileNotFoundException -> L36
        L54:
            state = Integer.parseInt(new String(buffer, 0, len).trim());     // Catch: NumberFormatException -> L41
        L42:
            Slog.e(WiredAccessoryManager.m525$$Nest$sfgetTAG(), "could not convert to number");
            goto L45
        L34:
            e11 = move-exception;
            Slog.e(WiredAccessoryManager.m525$$Nest$sfgetTAG(), "", e11);
        L43:
            Slog.e(WiredAccessoryManager.m525$$Nest$sfgetTAG(), "file not found");
            goto L45
        }

        private void updateStateLocked(String r7, String r8, int r9) {
            int r0 = 0;
        L4:
            if (r0 >= this.mUEventInfo.size()) goto L14;
            UEventInfo r1 = this.mUEventInfo.get(r0);
            if (r7.equals(r1.getDevPath()) == true) goto L7;
            r0 = r0 + 1;
            goto L4
        L7:
            Slog.v(WiredAccessoryManager.m525$$Nest$sfgetTAG(), "uei.getDevPath=" + r1.getDevPath() + " uei=" + r1.toString());
            if (r9 != 1) goto L10;
            r1.setController(1 ^ (WiredAccessoryManager.m515$$Nest$fgetmDetectedIntf(this.this$0).equals(WiredAccessoryManager.INTF_DP) ? 1 : 0));
        L10:
            WiredAccessoryManager.m523$$Nest$mupdateLocked(this.this$0, r8, r1.getDevAddress(), r1.computeNewHeadsetState(WiredAccessoryManager.m516$$Nest$fgetmHeadsetState(this.this$0), r9), false);
            return;
        }
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmDetectedIntf, reason: not valid java name */
    static /* bridge */ /* synthetic */ String m515$$Nest$fgetmDetectedIntf(WiredAccessoryManager r0) {
        return r0.mDetectedIntf;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmHeadsetState, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m516$$Nest$fgetmHeadsetState(WiredAccessoryManager r0) {
        return r0.mHeadsetState;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmLock, reason: not valid java name */
    static /* bridge */ /* synthetic */ Object m517$$Nest$fgetmLock(WiredAccessoryManager r0) {
        return r0.mLock;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmUseDevInputEventForAudioJack, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m518$$Nest$fgetmUseDevInputEventForAudioJack(WiredAccessoryManager r0) {
        return r0.mUseDevInputEventForAudioJack;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmWakeLock, reason: not valid java name */
    static /* bridge */ /* synthetic */ PowerManager.WakeLock m519$$Nest$fgetmWakeLock(WiredAccessoryManager r0) {
        return r0.mWakeLock;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmDetectedIntf, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m520$$Nest$fputmDetectedIntf(WiredAccessoryManager r0, String r1) {
        r0.mDetectedIntf = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$monSystemReady, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m521$$Nest$monSystemReady(WiredAccessoryManager r0) {
        r0.onSystemReady();
    }

    /* JADX INFO: renamed from: -$$Nest$msetDevicesState, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m522$$Nest$msetDevicesState(WiredAccessoryManager r0, int r1, int r2, String r3) {
        r0.setDevicesState(r1, r2, r3);
    }

    /* JADX INFO: renamed from: -$$Nest$mupdateLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m523$$Nest$mupdateLocked(WiredAccessoryManager r0, String r1, String r2, int r3, boolean r4) {
        r0.updateLocked(r1, r2, r3, r4);
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetDP_AUDIO_CONNS, reason: not valid java name */
    static /* bridge */ /* synthetic */ String[] m524$$Nest$sfgetDP_AUDIO_CONNS() {
        return DP_AUDIO_CONNS;
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetTAG, reason: not valid java name */
    static /* bridge */ /* synthetic */ String m525$$Nest$sfgetTAG() {
        return TAG;
    }

    /* JADX INFO: renamed from: -$$Nest$smupdateBit, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m526$$Nest$smupdateBit(int[] r0, int r1, String r2, String r3) {
        updateBit(r0, r1, r2, r3);
    }

    static {
        TAG = WiredAccessoryManager.class.getSimpleName();
        DP_AUDIO_CONNS = new String[]{"soc:qcom,msm-ext-disp/3/0", "soc:qcom,msm-ext-disp/2/0", "soc:qcom,msm-ext-disp/1/0", "soc:qcom,msm-ext-disp/0/0"};
    }

    public WiredAccessoryManager(Context context, InputManagerService inputManager) {
        this.mLock = new Object();
        this.mDetectedIntf = INTF_DP;
        final Looper r1 = Looper.myLooper();
        final Handler.Callback r2 = null;
        final boolean r3 = true;
        this.mHandler = new AnonymousClass1(this, r1, r2, r3);
        PowerManager pm = (PowerManager) context.getSystemService("power");
        this.mWakeLock = pm.newWakeLock(1, "WiredAccessoryManager");
        this.mWakeLock.setReferenceCounted(false);
        this.mAudioManager = (AudioManager) context.getSystemService("audio");
        this.mInputManager = inputManager;
        this.mUseDevInputEventForAudioJack = context.getResources().getBoolean(R.bool.config_use_strict_phone_number_comparation_for_kazakhstan);
        this.mExtconObserver = new WiredAccessoryExtconObserver(this);
        this.mObserver = new WiredAccessoryObserver(this);
    }

    private void onSystemReady() {
        if (this.mUseDevInputEventForAudioJack == false) goto L15;
        int switchValues = 0;
        if (this.mInputManager.getSwitchState(-1, -256, 2) != 1) goto L8;
        switchValues = 0 | 4;
    L8:
        if (this.mInputManager.getSwitchState(-1, -256, 4) != 1) goto L11;
        switchValues = switchValues | 16;
    L11:
        if (this.mInputManager.getSwitchState(-1, -256, 6) != 1) goto L13;
        int switchValues2 = switchValues | 64;
    L14:
        WiredAccessoryManager r1 = this;
        r1.notifyWiredAccessoryChanged(0, switchValues2, 84, true);
    L17:
        if (ExtconUEventObserver.extconExists() == false) goto L19;
        r1.mExtconObserver.uEventCount();
    L19:
        r1.mObserver.init();
        return;
    L13:
        switchValues2 = switchValues;
        goto L14
    L15:
        r1 = this;
        goto L17
    }

    @Override // com.android.server.input.InputManagerService.WiredAccessoryCallbacks
    public void notifyWiredAccessoryChanged(long whenNanos, int switchValues, int switchMask) {
        notifyWiredAccessoryChanged(whenNanos, switchValues, switchMask, false);
    }

    public void notifyWiredAccessoryChanged(long whenNanos, int switchValues, int switchMask, boolean isSynchronous) {
        Slog.v(TAG, "notifyWiredAccessoryChanged: when=" + whenNanos + " bits=" + switchCodeToString(switchValues, switchMask) + " mask=" + Integer.toHexString(switchMask));
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mSwitchValues = (this.mSwitchValues & (~switchMask)) | switchValues;     // Catch: Throwable -> L15
        switch((this.mSwitchValues & 84)) {
            case 0: goto L11;
            case 4: goto L10;
            case 16: goto L9;
            case 20: goto L8;
            case 64: goto L7;
            default: goto L6;
        };     // Catch: Throwable -> L15
    L6:
        int headset = 0;
    L12:
        updateLocked(NAME_H2W, "", (this.mHeadsetState & (-36)) | headset, isSynchronous);     // Catch: Throwable -> L15
        monitor-exit(r0);     // Catch: Throwable -> L15
        return;
    L7:
        headset = 32;
        goto L12
    L8:
        headset = 1;
        goto L12
    L9:
        headset = 1;
        goto L12
    L10:
        headset = 2;
        goto L12
    L11:
        headset = 0;
    L15:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.input.InputManagerService.WiredAccessoryCallbacks
    public void systemReady() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mWakeLock.acquire();     // Catch: Throwable -> L7
        Message msg = this.mHandler.obtainMessage(2, 0, 0, null);     // Catch: Throwable -> L7
        this.mHandler.sendMessage(msg);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private void updateLocked(String newName, String address, int newState, boolean isSynchronous) {
        int headsetState = newState & 63;
        int newDpState = newState & 16;
        int usb_headset_anlg = headsetState & 4;
        int usb_headset_dgtl = headsetState & 8;
        int h2w_headset = headsetState & 35;
        boolean h2wStateChange = true;
        boolean usbStateChange = true;
        boolean dpCountState = false;
        if ((this.mHeadsetState & 16) <= 0) goto L5;
        boolean dpBitState = true;
    L7:
        if (this.mDpCount == 0) goto L10;
        dpCountState = true;
    L10:
        Slog.v(TAG, "newName=" + newName + " newState=" + newState + " address=" + address + " headsetState=" + headsetState + " prev headsetState=" + this.mHeadsetState + " num of active dp conns= " + this.mDpCount);
        if (this.mHeadsetState != headsetState) goto L17;
        if (newName.startsWith(NAME_DP_AUDIO) == true) goto L17;
        Log.e(TAG, "No state change.");
        return;
    L17:
        if (h2w_headset != 35) goto L20;
        Log.e(TAG, "Invalid combination, unsetting h2w flag");
        h2wStateChange = false;
    L20:
        if (usb_headset_anlg == 4) goto L22;
    L24:
        if (h2wStateChange == true) goto L29;
        if (usbStateChange == true) goto L29;
        Log.e(TAG, "invalid transition, returning ...");
        return;
    L29:
        if (newName.startsWith(NAME_DP_AUDIO) == false) goto L41;
        if (newDpState > 0) goto L32;
    L35:
        if (newDpState == 0) goto L37;
    L39:
        Log.e(TAG, "No state change for DP.");
        return;
    L37:
        if (this.mDpCount <= 0) goto L39;
        this.mDpCount--;
        goto L41
    L32:
        if (this.mDpCount >= DP_AUDIO_CONNS.length) goto L35;
        if (dpBitState != dpCountState) goto L35;
        this.mDpCount++;
    L41:
        this.mWakeLock.acquire();
        Log.i(TAG, "MSG_NEW_DEVICE_STATE");
        if (newName.startsWith(NAME_DP_AUDIO) == false) goto L52;
        int pseudoHeadsetState = this.mHeadsetState;
        if (dpBitState == false) goto L47;
        if (newDpState == 0) goto L47;
        pseudoHeadsetState = this.mHeadsetState & (-17);
    L47:
        Message msg = this.mHandler.obtainMessage(1, headsetState, pseudoHeadsetState, "soc:qcom,msm-ext-disp/" + address);
        this.mHandler.sendMessage(msg);
        if (this.mDpCount == 0) goto L55;
        headsetState = headsetState | 16;
    L55:
        this.mHeadsetState = headsetState;
        return;
    L52:
        if (isSynchronous == false) goto L54;
        setDevicesState(headsetState, this.mHeadsetState, newName + SliceClientPermissions.SliceAuthority.DELIMITER + address);
        goto L55
    L54:
        Message msg2 = this.mHandler.obtainMessage(1, headsetState, this.mHeadsetState, newName + SliceClientPermissions.SliceAuthority.DELIMITER + address);
        this.mHandler.sendMessage(msg2);
        goto L55
    L22:
        if (usb_headset_dgtl != 8) goto L24;
        Log.e(TAG, "Invalid combination, unsetting usb flag");
        usbStateChange = false;
        goto L24
    L5:
        dpBitState = false;
        goto L7
    }

    private void setDevicesState(int headsetState, int prevHeadsetState, String headsetNameAddr) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        int allHeadsets = 63;
        int curHeadset = 1;
    L5:
        if (allHeadsets == 0) goto L13;
        if ((curHeadset & allHeadsets) == 0) goto L11;
        setDeviceStateLocked(curHeadset, headsetState, prevHeadsetState, headsetNameAddr);     // Catch: Throwable -> L9
        allHeadsets = allHeadsets & (~curHeadset);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    L11:
        curHeadset = curHeadset << 1;     // Catch: Throwable -> L9
        goto L5
    L13:
        monitor-exit(r0);     // Catch: Throwable -> L9
    }

    private void setDeviceStateLocked(int headset, int headsetState, int prevHeadsetState, String headsetNameAddr) {
        if ((headsetState & headset) == (prevHeadsetState & headset)) goto L48;
        int inDevice = 0;
        if ((headsetState & headset) == 0) goto L7;
        int state = 1;
    L9:
        if (headset != 1) goto L12;
        int outDevice = 4;
        inDevice = AudioDevice.IN_WIRED_HEADSET;
    L26:
        String r4 = TAG;
        StringBuilder r5 = new StringBuilder();
        r5.append("headset: ");
        r5.append(headsetNameAddr);
        if (state != 1) goto L29;
        String r6 = " connected";
    L30:
        r5.append(r6);
        Slog.v(r4, r5.toString());
        String[] hs = headsetNameAddr.split(SliceClientPermissions.SliceAuthority.DELIMITER);
        String r7 = "";
        if (outDevice == 0) goto L41;
        String r8 = TAG;
        StringBuilder r9 = new StringBuilder();
        r9.append("Output device address ");
        if (hs.length <= 1) goto L35;
        String r10 = hs[1];
    L36:
        r9.append(r10);
        r9.append(" name ");
        r9.append(hs[0]);
        Slog.v(r8, r9.toString());
        AudioManager r11 = this.mAudioManager;
        if (hs.length <= 1) goto L39;
        String r12 = hs[1];
    L40:
        r11.setWiredDeviceConnectionState(outDevice, state, r12, hs[0]);
        goto L41
    L39:
        r12 = "";
        goto L40
    L35:
        r10 = "";
    L41:
        if (inDevice == 0) goto L49;
        AudioManager r13 = this.mAudioManager;
        if (hs.length <= 1) goto L45;
        r7 = hs[1];
    L45:
        r13.setWiredDeviceConnectionState(inDevice, state, r7, hs[0]);
        return;
    L49:
        return;
    L29:
        r6 = " disconnected";
        goto L30
    L12:
        if (headset != 2) goto L15;
        outDevice = 8;
        goto L26
    L15:
        if (headset != 32) goto L18;
        outDevice = 131072;
        goto L26
    L18:
        if (headset != 4) goto L21;
        outDevice = 2048;
        goto L26
    L21:
        if (headset != 8) goto L24;
        outDevice = 4096;
        goto L26
    L24:
        if (headset != 16) goto L46;
        outDevice = 1024;
        goto L26
    L46:
        Slog.e(TAG, "setDeviceState() invalid headset type: " + headset);
        return;
    L7:
        state = 0;
        goto L9
    }

    private String switchCodeToString(int switchValues, int switchMask) {
        StringBuilder sb = new StringBuilder();
        if ((switchMask & 4) == 0) goto L8;
        if ((switchValues & 4) == 0) goto L8;
        sb.append("SW_HEADPHONE_INSERT ");
    L8:
        if ((switchMask & 16) == 0) goto L13;
        if ((switchValues & 16) == 0) goto L13;
        sb.append("SW_MICROPHONE_INSERT");
    L13:
        return sb.toString();
    }

    private static void updateBit(int[] maskAndState, int position, String state, String name) {
        maskAndState[0] = maskAndState[0] | position;
        if (state.contains(name + "=1") == false) goto L6;
        maskAndState[0] = maskAndState[0] | position;
        maskAndState[1] = maskAndState[1] | position;
        return;
    L6:
        if (state.contains(name + "=0") == false) goto L10;
        maskAndState[0] = maskAndState[0] | position;
        maskAndState[1] = maskAndState[1] & (~position);
        return;
    }
}
