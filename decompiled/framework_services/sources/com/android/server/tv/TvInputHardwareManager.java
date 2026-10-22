package com.android.server.tv;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.hardware.hdmi.HdmiDeviceInfo;
import android.hardware.hdmi.HdmiHotplugEvent;
import android.hardware.hdmi.IHdmiControlService;
import android.hardware.hdmi.IHdmiDeviceEventListener;
import android.hardware.hdmi.IHdmiHotplugEventListener;
import android.hardware.hdmi.IHdmiSystemAudioModeChangeListener;
import android.media.AudioDevicePort;
import android.media.AudioDevicePortConfig;
import android.media.AudioFormat;
import android.media.AudioGain;
import android.media.AudioGainConfig;
import android.media.AudioManager;
import android.media.AudioPatch;
import android.media.AudioPortConfig;
import android.media.AudioSystem;
import android.media.tv.ITvInputHardware;
import android.media.tv.ITvInputHardwareCallback;
import android.media.tv.TvInputHardwareInfo;
import android.media.tv.TvInputInfo;
import android.media.tv.TvStreamConfig;
import android.media.tv.tunerresourcemanager.ResourceClientProfile;
import android.media.tv.tunerresourcemanager.TunerResourceManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.util.ArrayMap;
import android.util.Slog;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.view.Surface;
import com.android.internal.os.SomeArgs;
import com.android.internal.util.DumpUtils;
import com.android.internal.util.IndentingPrintWriter;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
class TvInputHardwareManager implements TvInputHal.Callback {
    private static final String TAG = null;
    private final AudioManager mAudioManager;
    private final SparseArray<Connection> mConnections;
    private final Context mContext;
    private int mCurrentIndex;
    private int mCurrentMaxIndex;
    private final TvInputHal mHal;
    private final Handler mHandler;
    private final SparseArray<String> mHardwareInputIdMap;
    private final List<TvInputHardwareInfo> mHardwareList;
    private final IHdmiDeviceEventListener mHdmiDeviceEventListener;
    private final List<HdmiDeviceInfo> mHdmiDeviceList;
    private final IHdmiHotplugEventListener mHdmiHotplugEventListener;
    private final SparseArray<String> mHdmiInputIdMap;
    private final Map<String, List<String>> mHdmiParentInputMap;
    private final SparseBooleanArray mHdmiStateMap;
    private final IHdmiSystemAudioModeChangeListener mHdmiSystemAudioModeChangeListener;
    private final Map<String, TvInputInfo> mInputMap;
    private final Listener mListener;
    private final Object mLock;
    private final List<Message> mPendingHdmiDeviceEvents;
    private final List<Message> mPendingTvinputInfoEvents;
    private final BroadcastReceiver mVolumeReceiver;

    private class Connection implements IBinder.DeathRecipient {
        private ITvInputHardwareCallback mCallback;
        private Integer mCallingUid;
        private TvStreamConfig[] mConfigs;
        private TvInputHardwareImpl mHardware;
        private TvInputHardwareInfo mHardwareInfo;
        private TvInputInfo mInfo;
        private boolean mIsCableConnectionStatusUpdated;
        private Runnable mOnFirstFrameCaptured;
        private Integer mResolvedUserId;
        private ResourceClientProfile mResourceClientProfile;
        final /* synthetic */ TvInputHardwareManager this$0;

        /* JADX INFO: renamed from: -$$Nest$mgetConfigsLengthLocked, reason: not valid java name */
        static /* bridge */ /* synthetic */ int m8743$$Nest$mgetConfigsLengthLocked(Connection r0) {
            return r0.getConfigsLengthLocked();
        }

        /* JADX INFO: renamed from: -$$Nest$mgetInputStateLocked, reason: not valid java name */
        static /* bridge */ /* synthetic */ int m8744$$Nest$mgetInputStateLocked(Connection r0) {
            return r0.getInputStateLocked();
        }

        public Connection(TvInputHardwareManager r1, TvInputHardwareInfo hardwareInfo) {
            this.this$0 = r1;
            this.mHardware = null;
            this.mConfigs = null;
            this.mCallingUid = null;
            this.mResolvedUserId = null;
            this.mResourceClientProfile = null;
            this.mIsCableConnectionStatusUpdated = false;
            this.mHardwareInfo = hardwareInfo;
        }

        public void resetLocked(TvInputHardwareImpl hardware, ITvInputHardwareCallback callback, TvInputInfo info, Integer callingUid, Integer resolvedUserId, ResourceClientProfile profile) {
            if (this.mHardware != null) goto L18;
        L9:
            this.mHardware = hardware;
            this.mCallback = callback;
            this.mInfo = info;
            this.mCallingUid = callingUid;
            this.mResolvedUserId = resolvedUserId;
            this.mOnFirstFrameCaptured = null;
            this.mResourceClientProfile = profile;
            if (this.mHardware != null) goto L12;
            return;
        L12:
            if (this.mCallback == null) goto L23;
            this.mCallback.onStreamConfigChanged(getConfigsLocked());     // Catch: RemoteException -> L15
            return;
        L15:
            e = move-exception;
            Slog.e(TvInputHardwareManager.m8741$$Nest$sfgetTAG(), "error in Connection::resetLocked", e);
            return;
        L23:
            return;
        L18:
            this.mCallback.onReleased();     // Catch: RemoteException -> L6
        L8:
            this.mHardware.release();
        L6:
            e = move-exception;
            Slog.e(TvInputHardwareManager.m8741$$Nest$sfgetTAG(), "error in Connection::resetLocked", e);
            goto L8
        }

        public void updateConfigsLocked(TvStreamConfig[] configs) {
            this.mConfigs = configs;
        }

        public TvInputHardwareInfo getHardwareInfoLocked() {
            return this.mHardwareInfo;
        }

        public TvInputInfo getInfoLocked() {
            return this.mInfo;
        }

        public ITvInputHardware getHardwareLocked() {
            return this.mHardware;
        }

        public TvInputHardwareImpl getHardwareImplLocked() {
            return this.mHardware;
        }

        public ITvInputHardwareCallback getCallbackLocked() {
            return this.mCallback;
        }

        public TvStreamConfig[] getConfigsLocked() {
            return this.mConfigs;
        }

        public Integer getCallingUidLocked() {
            return this.mCallingUid;
        }

        public Integer getResolvedUserIdLocked() {
            return this.mResolvedUserId;
        }

        public void setOnFirstFrameCapturedLocked(Runnable runnable) {
            this.mOnFirstFrameCaptured = runnable;
        }

        public Runnable getOnFirstFrameCapturedLocked() {
            return this.mOnFirstFrameCaptured;
        }

        public ResourceClientProfile getResourceClientProfileLocked() {
            return this.mResourceClientProfile;
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            Object r1 = TvInputHardwareManager.m8735$$Nest$fgetmLock(this.this$0);
            monitor-enter(r1);
            resetLocked(null, null, null, null, null, null);     // Catch: Throwable -> L8
            monitor-exit(r1);     // Catch: Throwable -> L8
            return;
        L8:
            th = move-exception;
            throw th;
        }

        public String toString() {
            return "Connection{ mHardwareInfo: " + this.mHardwareInfo + ", mInfo: " + this.mInfo + ", mCallback: " + this.mCallback + ", mHardware: " + this.mHardware + ", mConfigs: " + Arrays.toString(this.mConfigs) + ", mCallingUid: " + this.mCallingUid + ", mResolvedUserId: " + this.mResolvedUserId + ", mResourceClientProfile: " + this.mResourceClientProfile + " }";
        }

        public boolean updateCableConnectionStatusLocked(int cableConnectionStatus) {
            if (cableConnectionStatus == 0) goto L4;
        L5:
            this.mIsCableConnectionStatusUpdated = true;
            this.mHardwareInfo = this.mHardwareInfo.toBuilder().cableConnectionStatus(cableConnectionStatus).build();
        L7:
            return this.mIsCableConnectionStatusUpdated;
        L4:
            if (this.mIsCableConnectionStatusUpdated == false) goto L7;
            goto L5
        }

        private int getConfigsLengthLocked() {
            if (this.mConfigs != null) goto L6;
            return 0;
        L6:
            return this.mConfigs.length;
        }

        private int getInputStateLocked() {
            int configsLength = getConfigsLengthLocked();
            if (configsLength <= 0) goto L8;
            if (this.mIsCableConnectionStatusUpdated == true) goto L8;
            return 0;
        L8:
            switch(this.mHardwareInfo.getCableConnectionStatus()) {
                case 1: goto L13;
                case 2: goto L11;
                default: goto L9;
            };
        L9:
            return 1;
        L11:
            return 2;
        L13:
            return 0;
        }
    }

    private final class HdmiDeviceEventListener extends IHdmiDeviceEventListener.Stub {
        final /* synthetic */ TvInputHardwareManager this$0;

        /* synthetic */ HdmiDeviceEventListener(TvInputHardwareManager r1, TvInputHardwareManagerIA r2) {
            this(r1);
        }

        private HdmiDeviceEventListener(TvInputHardwareManager r1) {
            this.this$0 = r1;
        }

        public void onStatusChanged(HdmiDeviceInfo deviceInfo, int status) {
            if (deviceInfo.isSourceType() == true) goto L5;
            return;
        L5:
            Object r0 = TvInputHardwareManager.m8735$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
            int messageType = 0;
            Object obj = null;
            switch(status) {
                case 1: goto L25;
                case 2: goto L18;
                case 3: goto L10;
                default: goto L27;
            };
        L10:
            HdmiDeviceInfo originalDeviceInfo = findHdmiDeviceInfo(deviceInfo.getId());     // Catch: Throwable -> L15
            if (TvInputHardwareManager.m8731$$Nest$fgetmHdmiDeviceList(this.this$0).remove(originalDeviceInfo) == true) goto L17;
            Slog.w(TvInputHardwareManager.m8741$$Nest$sfgetTAG(), "The list doesn't contain " + deviceInfo + "; ignoring.");     // Catch: Throwable -> L15
            monitor-exit(r0);     // Catch: Throwable -> L15
            return;
        L17:
            TvInputHardwareManager.m8731$$Nest$fgetmHdmiDeviceList(this.this$0).add(deviceInfo);     // Catch: Throwable -> L15
            messageType = 6;
            obj = deviceInfo;
            goto L27
        L18:
            HdmiDeviceInfo originalDeviceInfo2 = findHdmiDeviceInfo(deviceInfo.getId());     // Catch: Throwable -> L15
            if (TvInputHardwareManager.m8731$$Nest$fgetmHdmiDeviceList(this.this$0).remove(originalDeviceInfo2) == true) goto L23;
            Slog.w(TvInputHardwareManager.m8741$$Nest$sfgetTAG(), "The list doesn't contain " + deviceInfo + "; ignoring.");     // Catch: Throwable -> L15
            monitor-exit(r0);     // Catch: Throwable -> L15
            return;
        L23:
            messageType = 5;
            obj = deviceInfo;
        L27:
            Message msg = TvInputHardwareManager.m8729$$Nest$fgetmHandler(this.this$0).obtainMessage(messageType, 0, 0, obj);     // Catch: Throwable -> L15
            if (TvInputHardwareManager.m8737$$Nest$mfindHardwareInfoForHdmiPortLocked(this.this$0, deviceInfo.getPortId()) == null) goto L30;
            msg.sendToTarget();     // Catch: Throwable -> L15
        L31:
            monitor-exit(r0);     // Catch: Throwable -> L15
            return;
        L30:
            TvInputHardwareManager.m8736$$Nest$fgetmPendingHdmiDeviceEvents(this.this$0).add(msg);     // Catch: Throwable -> L15
            goto L31
        L25:
            if (findHdmiDeviceInfo(deviceInfo.getId()) != null) goto L33;
            TvInputHardwareManager.m8731$$Nest$fgetmHdmiDeviceList(this.this$0).add(deviceInfo);     // Catch: Throwable -> L15
            messageType = 4;
            obj = deviceInfo;
            goto L27
        L33:
            Slog.w(TvInputHardwareManager.m8741$$Nest$sfgetTAG(), "The list already contains " + deviceInfo + "; ignoring.");     // Catch: Throwable -> L15
            monitor-exit(r0);     // Catch: Throwable -> L15
            return;
        L15:
            th = move-exception;
            throw th;
        }

        private HdmiDeviceInfo findHdmiDeviceInfo(int id) {
            Iterator r0 = TvInputHardwareManager.m8731$$Nest$fgetmHdmiDeviceList(this.this$0).iterator();
        L4:
            if (r0.hasNext() == false) goto L9;
            HdmiDeviceInfo info = (HdmiDeviceInfo) r0.next();
            if (info.getId() != id) goto L4;
            return info;
        L9:
            return null;
        }
    }

    private final class HdmiHotplugEventListener extends IHdmiHotplugEventListener.Stub {
        final /* synthetic */ TvInputHardwareManager this$0;

        /* synthetic */ HdmiHotplugEventListener(TvInputHardwareManager r1, TvInputHardwareManagerIA r2) {
            this(r1);
        }

        private HdmiHotplugEventListener(TvInputHardwareManager r1) {
            this.this$0 = r1;
        }

        public void onReceived(HdmiHotplugEvent event) {
            Object r0 = TvInputHardwareManager.m8735$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
            TvInputHardwareManager.m8733$$Nest$fgetmHdmiStateMap(this.this$0).put(event.getPort(), event.isConnected());     // Catch: Throwable -> L8
            TvInputHardwareInfo hardwareInfo = TvInputHardwareManager.m8737$$Nest$mfindHardwareInfoForHdmiPortLocked(this.this$0, event.getPort());     // Catch: Throwable -> L8
            if (hardwareInfo != null) goto L10;
            monitor-exit(r0);     // Catch: Throwable -> L8
            return;
        L10:
            String inputId = (String) TvInputHardwareManager.m8730$$Nest$fgetmHardwareInputIdMap(this.this$0).get(hardwareInfo.getDeviceId());     // Catch: Throwable -> L8
            if (inputId != null) goto L15;
            monitor-exit(r0);     // Catch: Throwable -> L8
            return;
        L15:
            if (event.isConnected() == false) goto L17;
            int state = 0;
        L18:
            TvInputHardwareManager.m8729$$Nest$fgetmHandler(this.this$0).obtainMessage(1, state, 0, inputId).sendToTarget();     // Catch: Throwable -> L8
            monitor-exit(r0);     // Catch: Throwable -> L8
            return;
        L17:
            state = 1;
        L8:
            th = move-exception;
            throw th;
        }
    }

    private final class HdmiSystemAudioModeChangeListener extends IHdmiSystemAudioModeChangeListener.Stub {
        final /* synthetic */ TvInputHardwareManager this$0;

        /* synthetic */ HdmiSystemAudioModeChangeListener(TvInputHardwareManager r1, TvInputHardwareManagerIA r2) {
            this(r1);
        }

        private HdmiSystemAudioModeChangeListener(TvInputHardwareManager r1) {
            this.this$0 = r1;
        }

        public void onStatusChanged(boolean enabled) throws RemoteException {
            Object r0 = TvInputHardwareManager.m8735$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
            int i = 0;
        L18:
        L10:
            th = move-exception;
            throw th;
        L6:
            if (i >= TvInputHardwareManager.m8727$$Nest$fgetmConnections(this.this$0).size()) goto L14;
            TvInputHardwareImpl impl = ((Connection) TvInputHardwareManager.m8727$$Nest$fgetmConnections(this.this$0).valueAt(i)).getHardwareImplLocked();     // Catch: Throwable -> L10
            if (impl == null) goto L12;
            TvInputHardwareImpl.m8750$$Nest$mhandleAudioSinkUpdated(impl);     // Catch: Throwable -> L10
        L12:
            i = i + 1;     // Catch: Throwable -> L10
            goto L18
        L14:
            monitor-exit(r0);     // Catch: Throwable -> L10
        }
    }

    interface Listener {
        void onHardwareDeviceAdded(TvInputHardwareInfo r1);

        void onHardwareDeviceRemoved(TvInputHardwareInfo r1);

        void onHdmiDeviceAdded(HdmiDeviceInfo r1);

        void onHdmiDeviceRemoved(HdmiDeviceInfo r1);

        void onHdmiDeviceUpdated(String r1, HdmiDeviceInfo r2);

        void onStateChanged(String r1, int r2);

        void onTvMessage(String r1, int r2, Bundle r3);
    }

    private class ListenerHandler extends Handler {
        private static final int HARDWARE_DEVICE_ADDED = 2;
        private static final int HARDWARE_DEVICE_REMOVED = 3;
        private static final int HDMI_DEVICE_ADDED = 4;
        private static final int HDMI_DEVICE_REMOVED = 5;
        private static final int HDMI_DEVICE_UPDATED = 6;
        private static final int STATE_CHANGED = 1;
        private static final int TVINPUT_INFO_ADDED = 7;
        private static final int TV_MESSAGE_RECEIVED = 8;
        final /* synthetic */ TvInputHardwareManager this$0;

        /* synthetic */ ListenerHandler(TvInputHardwareManager r1, TvInputHardwareManagerIA r2) {
            this(r1);
        }

        private ListenerHandler(TvInputHardwareManager r1) {
            this.this$0 = r1;
        }

        @Override // android.os.Handler
        public final void handleMessage(Message msg) {
            switch(msg.what) {
                case 1: goto L44;
                case 2: goto L43;
                case 3: goto L42;
                case 4: goto L41;
                case 5: goto L40;
                case 6: goto L30;
                case 7: goto L6;
                case 8: goto L5;
                default: goto L4;
            };
        L4:
            Slog.w(TvInputHardwareManager.m8741$$Nest$sfgetTAG(), "Unhandled message: " + msg);
            return;
        L5:
            SomeArgs args = (SomeArgs) msg.obj;
            String inputId = (String) args.arg1;
            Bundle data = (Bundle) args.arg2;
            int type = msg.arg1;
            TvInputHardwareManager.m8734$$Nest$fgetmListener(this.this$0).onTvMessage(inputId, type, data);
            args.recycle();
            return;
        L6:
            int deviceId = msg.arg1;
            int cableConnectionStatus = msg.arg2;
            Connection connection = (Connection) msg.obj;
            int previousConfigsLength = Connection.m8743$$Nest$mgetConfigsLengthLocked(connection);
            int previousCableConnectionStatus = Connection.m8744$$Nest$mgetInputStateLocked(connection);
            String inputId2 = (String) TvInputHardwareManager.m8730$$Nest$fgetmHardwareInputIdMap(this.this$0).get(deviceId);
            if (inputId2 == null) goto L52;
            Object r6 = TvInputHardwareManager.m8735$$Nest$fgetmLock(this.this$0);
            monitor-enter(r6);
        L15:
            th = move-exception;
            throw th;
        L11:
            if (connection.updateCableConnectionStatusLocked(cableConnectionStatus) == true) goto L13;
            if (previousConfigsLength != 0) goto L19;
            boolean r7 = true;
        L21:
            if (Connection.m8743$$Nest$mgetConfigsLengthLocked(connection) != 0) goto L23;
            boolean r10 = true;
        L24:
            if (r7 == r10) goto L26;
            TvInputHardwareManager.m8729$$Nest$fgetmHandler(this.this$0).obtainMessage(1, Connection.m8744$$Nest$mgetInputStateLocked(connection), 0, inputId2).sendToTarget();     // Catch: Throwable -> L15
        L26:
            monitor-exit(r6);     // Catch: Throwable -> L15
            return;
        L23:
            r10 = false;
            goto L24
        L19:
            r7 = false;
            goto L21
        L13:
            if (previousCableConnectionStatus == Connection.m8744$$Nest$mgetInputStateLocked(connection)) goto L26;
            TvInputHardwareManager.m8729$$Nest$fgetmHandler(this.this$0).obtainMessage(1, Connection.m8744$$Nest$mgetInputStateLocked(connection), 0, inputId2).sendToTarget();     // Catch: Throwable -> L15
            goto L26
        L52:
            return;
        L30:
            HdmiDeviceInfo info = (HdmiDeviceInfo) msg.obj;
            Object r1 = TvInputHardwareManager.m8735$$Nest$fgetmLock(this.this$0);
            monitor-enter(r1);
            String inputId3 = (String) TvInputHardwareManager.m8732$$Nest$fgetmHdmiInputIdMap(this.this$0).get(info.getId());     // Catch: Throwable -> L37
            monitor-exit(r1);     // Catch: Throwable -> L37
            if (inputId3 == null) goto L36;
            TvInputHardwareManager.m8734$$Nest$fgetmListener(this.this$0).onHdmiDeviceUpdated(inputId3, info);
            return;
        L36:
            Slog.w(TvInputHardwareManager.m8741$$Nest$sfgetTAG(), "Could not resolve input ID matching the device info; ignoring.");
            return;
        L37:
            th = move-exception;
            throw th;
        L40:
            HdmiDeviceInfo info2 = (HdmiDeviceInfo) msg.obj;
            TvInputHardwareManager.m8734$$Nest$fgetmListener(this.this$0).onHdmiDeviceRemoved(info2);
            return;
        L41:
            HdmiDeviceInfo info3 = (HdmiDeviceInfo) msg.obj;
            TvInputHardwareManager.m8734$$Nest$fgetmListener(this.this$0).onHdmiDeviceAdded(info3);
            return;
        L42:
            TvInputHardwareInfo info4 = (TvInputHardwareInfo) msg.obj;
            TvInputHardwareManager.m8734$$Nest$fgetmListener(this.this$0).onHardwareDeviceRemoved(info4);
            return;
        L43:
            TvInputHardwareInfo info5 = (TvInputHardwareInfo) msg.obj;
            TvInputHardwareManager.m8734$$Nest$fgetmListener(this.this$0).onHardwareDeviceAdded(info5);
            return;
        L44:
            String inputId4 = (String) msg.obj;
            int state = msg.arg1;
            TvInputHardwareManager.m8734$$Nest$fgetmListener(this.this$0).onStateChanged(inputId4, state);
        }
    }

    private class TvInputHardwareImpl extends ITvInputHardware.Stub {
        private TvStreamConfig mActiveConfig;
        private final AudioManager.OnAudioPortUpdateListener mAudioListener;
        private AudioPatch mAudioPatch;
        private List<AudioDevicePort> mAudioSink;
        private AudioDevicePort mAudioSource;
        private float mCommittedVolume;
        private int mDesiredChannelMask;
        private int mDesiredFormat;
        private int mDesiredSamplingRate;
        private final Object mImplLock;
        private final TvInputHardwareInfo mInfo;
        private String mOverrideAudioAddress;
        private int mOverrideAudioType;
        private boolean mReleased;
        private float mSourceVolume;
        final /* synthetic */ TvInputHardwareManager this$0;

        /* JADX INFO: renamed from: -$$Nest$fgetmAudioPatch, reason: not valid java name */
        static /* bridge */ /* synthetic */ AudioPatch m8745$$Nest$fgetmAudioPatch(TvInputHardwareImpl r0) {
            return r0.mAudioPatch;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmAudioSink, reason: not valid java name */
        static /* bridge */ /* synthetic */ List m8746$$Nest$fgetmAudioSink(TvInputHardwareImpl r0) {
            return r0.mAudioSink;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmImplLock, reason: not valid java name */
        static /* bridge */ /* synthetic */ Object m8747$$Nest$fgetmImplLock(TvInputHardwareImpl r0) {
            return r0.mImplLock;
        }

        /* JADX INFO: renamed from: -$$Nest$fputmAudioPatch, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m8748$$Nest$fputmAudioPatch(TvInputHardwareImpl r0, AudioPatch r1) {
            r0.mAudioPatch = r1;
        }

        /* JADX INFO: renamed from: -$$Nest$fputmAudioSource, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m8749$$Nest$fputmAudioSource(TvInputHardwareImpl r0, AudioDevicePort r1) {
            r0.mAudioSource = r1;
        }

        /* JADX INFO: renamed from: -$$Nest$mhandleAudioSinkUpdated, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m8750$$Nest$mhandleAudioSinkUpdated(TvInputHardwareImpl r0) {
            r0.handleAudioSinkUpdated();
        }

        /* JADX INFO: renamed from: -$$Nest$mstartCapture, reason: not valid java name */
        static /* bridge */ /* synthetic */ boolean m8751$$Nest$mstartCapture(TvInputHardwareImpl r0, Surface r1, TvStreamConfig r2) {
            return r0.startCapture(r1, r2);
        }

        /* JADX INFO: renamed from: -$$Nest$mstopCapture, reason: not valid java name */
        static /* bridge */ /* synthetic */ boolean m8752$$Nest$mstopCapture(TvInputHardwareImpl r0, TvStreamConfig r1) {
            return r0.stopCapture(r1);
        }

        /* JADX INFO: renamed from: -$$Nest$mupdateAudioConfigLocked, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m8753$$Nest$mupdateAudioConfigLocked(TvInputHardwareImpl r0) {
            r0.updateAudioConfigLocked();
        }

        public TvInputHardwareImpl(TvInputHardwareManager r4, TvInputHardwareInfo info) {
            this.this$0 = r4;
            this.mImplLock = new Object();
            this.mAudioListener = new AnonymousClass1(this);
            this.mReleased = false;
            this.mOverrideAudioType = 0;
            this.mOverrideAudioAddress = "";
            this.mAudioSink = new ArrayList();
            this.mAudioPatch = null;
            this.mCommittedVolume = -1.0f;
            this.mSourceVolume = 0.0f;
            this.mActiveConfig = null;
            this.mDesiredSamplingRate = 0;
            this.mDesiredChannelMask = 1;
            this.mDesiredFormat = 1;
            this.mInfo = info;
            TvInputHardwareManager.m8726$$Nest$fgetmAudioManager(r4).registerAudioPortUpdateListener(this.mAudioListener);
            if (this.mInfo.getAudioType() == 0) goto L12;
            Object r5 = this.mImplLock;
            monitor-enter(r5);
            this.mAudioSource = findAudioDevicePort(this.mInfo.getAudioType(), this.mInfo.getAudioAddress());     // Catch: Throwable -> L9
            findAudioSinkFromAudioPolicy(this.mAudioSink);     // Catch: Throwable -> L9
            monitor-exit(r5);     // Catch: Throwable -> L9
            return;
        L9:
            th = move-exception;
            throw th;
        }

        private void findAudioSinkFromAudioPolicy(List<AudioDevicePort> sinks) {
            sinks.clear();
            ArrayList<AudioDevicePort> devicePorts = new ArrayList();
            TvInputHardwareManager.m8726$$Nest$fgetmAudioManager(this.this$0);
            if (AudioManager.listAudioDevicePorts(devicePorts) == 0) goto L5;
            return;
        L5:
            int sinkDevice = TvInputHardwareManager.m8726$$Nest$fgetmAudioManager(this.this$0).getDevicesForStream(3);
            Iterator<AudioDevicePort> r2 = devicePorts.iterator();
        L7:
            if (r2.hasNext() == false) goto L14;
            AudioDevicePort port = r2.next();
            if ((port.type() & sinkDevice) == 0) goto L7;
            if (AudioSystem.isInputDevice(port.type()) == true) goto L7;
            sinks.add(port);
            goto L7
        }

        private AudioDevicePort findAudioDevicePort(int type, String address) {
            if (type != 0) goto L5;
            return null;
        L5:
            ArrayList<AudioDevicePort> devicePorts = new ArrayList();
            TvInputHardwareManager.m8726$$Nest$fgetmAudioManager(this.this$0);
            if (AudioManager.listAudioDevicePorts(devicePorts) == 0) goto L8;
            return null;
        L8:
            Iterator<AudioDevicePort> r2 = devicePorts.iterator();
        L10:
            if (r2.hasNext() == false) goto L17;
            AudioDevicePort port = r2.next();
            if (port.type() != type) goto L10;
            if (port.address().equals(address) == false) goto L10;
            return port;
        L17:
            return null;
        }

        public void release() {
            Object r0 = this.mImplLock;
            monitor-enter(r0);
            TvInputHardwareManager.m8726$$Nest$fgetmAudioManager(this.this$0).unregisterAudioPortUpdateListener(this.mAudioListener);     // Catch: Throwable -> L7
            if (this.mAudioPatch == null) goto L9;
            TvInputHardwareManager.m8726$$Nest$fgetmAudioManager(this.this$0);     // Catch: Throwable -> L7
            AudioManager.releaseAudioPatch(this.mAudioPatch);     // Catch: Throwable -> L7
            this.mAudioPatch = null;     // Catch: Throwable -> L7
        L9:
            this.mReleased = true;     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        public boolean setSurface(Surface surface, TvStreamConfig config) throws RemoteException {
            Object r0 = this.mImplLock;
            monitor-enter(r0);
        L11:
            th = move-exception;
            throw th;
        L5:
            if (this.mReleased == true) goto L36;
            int result = 0;
            boolean r2 = false;
            if (surface == null) goto L9;
            if (config != null) goto L19;
            monitor-exit(r0);     // Catch: Throwable -> L11
            return false;
        L19:
            if (this.mActiveConfig != null) goto L21;
        L25:
            if (result != 0) goto L29;
            int result2 = TvInputHardwareManager.m8728$$Nest$fgetmHal(this.this$0).addOrUpdateStream(this.mInfo.getDeviceId(), surface, config);     // Catch: Throwable -> L11
            if (result2 != 0) goto L30;
            this.mActiveConfig = config;     // Catch: Throwable -> L11
        L30:
            updateAudioConfigLocked();     // Catch: Throwable -> L11
            if (result2 != 0) goto L33;
            r2 = true;
        L33:
            monitor-exit(r0);     // Catch: Throwable -> L11
            return r2;
        L29:
            result2 = result;
            goto L30
        L21:
            if (config.equals(this.mActiveConfig) == true) goto L25;
            result = TvInputHardwareManager.m8728$$Nest$fgetmHal(this.this$0).removeStream(this.mInfo.getDeviceId(), this.mActiveConfig);     // Catch: Throwable -> L11
            if (result == 0) goto L25;
            this.mActiveConfig = null;     // Catch: Throwable -> L11
            goto L25
        L9:
            if (this.mActiveConfig == null) goto L13;
            result2 = TvInputHardwareManager.m8728$$Nest$fgetmHal(this.this$0).removeStream(this.mInfo.getDeviceId(), this.mActiveConfig);     // Catch: Throwable -> L11
            this.mActiveConfig = null;     // Catch: Throwable -> L11
            goto L30
        L13:
            monitor-exit(r0);     // Catch: Throwable -> L11
            return true;
        L36:
            throw new IllegalStateException("Device already released.");     // Catch: Throwable -> L11
        }

        private void updateAudioConfigLocked() {
            boolean sinkUpdated = updateAudioSinkLocked();
            boolean sourceUpdated = updateAudioSourceLocked();
            if (this.mAudioSource == null) goto L103;
            if (this.mAudioSink.isEmpty() == true) goto L103;
            if (this.mActiveConfig == null) goto L103;
            TvInputHardwareManager.m8740$$Nest$mupdateVolume(this.this$0);
            float volume = this.mSourceVolume * TvInputHardwareManager.m8738$$Nest$mgetMediaStreamVolume(this.this$0);
            AudioGainConfig sourceGainConfig = null;
            int r7 = 1;
            int sinkChannelMask = 0;
            if (this.mAudioSource.gains().length > 0) goto L12;
        L27:
            AudioPortConfig sourceConfig = this.mAudioSource.activeConfig();
            List<AudioPortConfig> sinkConfigs = new ArrayList();
            AudioPatch[] audioPatchArray = {this.mAudioPatch};
            if (sourceUpdated == true) goto L34;
            if (sinkUpdated == true) goto L34;
            if (this.mAudioPatch == null) goto L34;
            boolean shouldRecreateAudioPatch = false;
        L35:
            Iterator<AudioDevicePort> r12 = this.mAudioSink.iterator();
        L37:
            if (r12.hasNext() == false) goto L66;
            AudioDevicePort audioSink = r12.next();
            AudioDevicePortConfig r14 = audioSink.activeConfig();
            int sinkSamplingRate = this.mDesiredSamplingRate;
            int r16 = sinkChannelMask;
            int sinkChannelMask2 = this.mDesiredChannelMask;
            int sinkFormat = this.mDesiredFormat;
            if (r14 == null) goto L46;
            if (sinkSamplingRate != 0) goto L42;
            sinkSamplingRate = r14.samplingRate();
        L42:
            if (sinkChannelMask2 != r7) goto L44;
            sinkChannelMask2 = r14.channelMask();
        L44:
            if (sinkFormat != r7) goto L46;
            sinkFormat = r14.format();
        L46:
            if (r14 == null) goto L54;
            if (r14.samplingRate() != sinkSamplingRate) goto L54;
            if (r14.channelMask() != sinkChannelMask2) goto L54;
            if (r14.format() != sinkFormat) goto L54;
        L65:
            sinkConfigs.add(r14);
            sinkChannelMask = r16;
            r7 = 1;
        L54:
            if (TvInputHardwareManager.m8742$$Nest$smintArrayContains(audioSink.samplingRates(), sinkSamplingRate) == true) goto L59;
            if (audioSink.samplingRates().length <= 0) goto L59;
            sinkSamplingRate = audioSink.samplingRates()[r16];
        L59:
            if (TvInputHardwareManager.m8742$$Nest$smintArrayContains(audioSink.channelMasks(), sinkChannelMask2) == true) goto L62;
            sinkChannelMask2 = 1;
        L62:
            if (TvInputHardwareManager.m8742$$Nest$smintArrayContains(audioSink.formats(), sinkFormat) == true) goto L64;
            sinkFormat = 1;
        L64:
            r14 = audioSink.buildConfig(sinkSamplingRate, sinkChannelMask2, sinkFormat, null);
            shouldRecreateAudioPatch = true;
            goto L65
        L66:
            AudioPortConfig sinkConfig = sinkConfigs.get(sinkChannelMask);
            if (sourceConfig == null) goto L71;
            if (sourceGainConfig != null) goto L71;
            boolean sinkUpdated2 = sinkUpdated;
            boolean sourceUpdated2 = sourceUpdated;
        L88:
            if (shouldRecreateAudioPatch == false) goto L98;
            this.mCommittedVolume = volume;
            if (this.mAudioPatch == null) goto L94;
            if (sinkUpdated2 == true) goto L94;
            if (sourceUpdated2 == false) goto L98;
        L94:
            if (this.mAudioPatch == null) goto L96;
            TvInputHardwareManager.m8726$$Nest$fgetmAudioManager(this.this$0);
            AudioManager.releaseAudioPatch(this.mAudioPatch);
            char r17 = 0;
            audioPatchArray[0] = null;
        L97:
            TvInputHardwareManager.m8726$$Nest$fgetmAudioManager(this.this$0);
            AudioPortConfig[] r1 = new AudioPortConfig[1];
            r1[r17] = sourceConfig;
            AudioManager.createAudioPatch(audioPatchArray, r1, (AudioPortConfig[]) sinkConfigs.toArray(new AudioPortConfig[sinkConfigs.size()]));
            this.mAudioPatch = audioPatchArray[r17];
            goto L98
        L96:
            r17 = 0;
        L98:
            if (sourceGainConfig == null) goto L113;
            TvInputHardwareManager.m8726$$Nest$fgetmAudioManager(this.this$0);
            AudioManager.setAudioPortGain(this.mAudioSource, sourceGainConfig);
            return;
        L113:
            return;
        L71:
            int sourceSamplingRate = 0;
            if (TvInputHardwareManager.m8742$$Nest$smintArrayContains(this.mAudioSource.samplingRates(), sinkConfig.samplingRate()) == false) goto L75;
            sourceSamplingRate = sinkConfig.samplingRate();
        L77:
            int sourceChannelMask = 1;
            int[] r13 = this.mAudioSource.channelMasks();
            int r15 = r13.length;
            int r18 = 0;
        L78:
            if (r18 >= r15) goto L83;
            int inChannelMask = r13[r18];
            sinkUpdated2 = sinkUpdated;
            sourceUpdated2 = sourceUpdated;
            if (AudioFormat.channelCountFromOutChannelMask(sinkConfig.channelMask()) == AudioFormat.channelCountFromInChannelMask(inChannelMask)) goto L81;
            r18 = r18 + 1;
            sourceUpdated = sourceUpdated2;
            sinkUpdated = sinkUpdated2;
            goto L78
        L81:
            sourceChannelMask = inChannelMask;
        L84:
            int sourceFormat = 1;
            if (TvInputHardwareManager.m8742$$Nest$smintArrayContains(this.mAudioSource.formats(), sinkConfig.format()) == false) goto L87;
            sourceFormat = sinkConfig.format();
        L87:
            sourceConfig = this.mAudioSource.buildConfig(sourceSamplingRate, sourceChannelMask, sourceFormat, sourceGainConfig);
            shouldRecreateAudioPatch = true;
            goto L88
        L83:
            sinkUpdated2 = sinkUpdated;
            sourceUpdated2 = sourceUpdated;
            goto L84
        L75:
            if (this.mAudioSource.samplingRates().length <= 0) goto L77;
            sourceSamplingRate = this.mAudioSource.samplingRates()[0];
        L34:
            shouldRecreateAudioPatch = true;
            goto L35
        L12:
            if (volume == this.mCommittedVolume) goto L27;
            AudioGain sourceGain = null;
            AudioGain[] r9 = this.mAudioSource.gains();
            int r10 = r9.length;
            int r11 = 0;
        L15:
            if (r11 >= r10) goto L20;
            AudioGain gain = r9[r11];
            if ((gain.mode() & 1) != 0) goto L18;
            r11 = r11 + 1;
            goto L15
        L18:
            sourceGain = gain;
        L20:
            if (sourceGain == null) goto L26;
            int steps = (sourceGain.maxValue() - sourceGain.minValue()) / sourceGain.stepValue();
            int gainValue = sourceGain.minValue();
            if (volume >= 1.0f) goto L24;
            int gainValue2 = gainValue + (sourceGain.stepValue() * ((int) (((double) (steps * volume)) + 0.5d)));
        L25:
            int[] gainValues = {gainValue2};
            sourceGainConfig = sourceGain.buildConfig(1, sourceGain.channelMask(), gainValues, 0);
            goto L27
        L24:
            gainValue2 = sourceGain.maxValue();
            goto L25
        L26:
            Slog.w(TvInputHardwareManager.m8741$$Nest$sfgetTAG(), "No audio source gain with MODE_JOINT support exists.");
        L103:
            if (this.mAudioPatch == null) goto L114;
            TvInputHardwareManager.m8726$$Nest$fgetmAudioManager(this.this$0);
            AudioManager.releaseAudioPatch(this.mAudioPatch);
            this.mAudioPatch = null;
            return;
        }

        public void setStreamVolume(float volume) throws RemoteException {
            Object r0 = this.mImplLock;
            monitor-enter(r0);
        L9:
            th = move-exception;
            throw th;
        L5:
            if (this.mReleased == true) goto L12;
            this.mSourceVolume = volume;     // Catch: Throwable -> L9
            updateAudioConfigLocked();     // Catch: Throwable -> L9
            monitor-exit(r0);     // Catch: Throwable -> L9
            return;
        L12:
            throw new IllegalStateException("Device already released.");     // Catch: Throwable -> L9
        }

        private boolean startCapture(Surface surface, TvStreamConfig config) {
            Object r0 = this.mImplLock;
            monitor-enter(r0);
            boolean r2 = false;
            if (this.mReleased == false) goto L10;
            monitor-exit(r0);     // Catch: Throwable -> L8
            return false;
        L10:
            if (surface == null) goto L22;
            if (config == null) goto L22;
            if (config.getType() == 2) goto L17;
            monitor-exit(r0);     // Catch: Throwable -> L8
            return false;
        L17:
            int result = TvInputHardwareManager.m8728$$Nest$fgetmHal(this.this$0).addOrUpdateStream(this.mInfo.getDeviceId(), surface, config);     // Catch: Throwable -> L8
            if (result != 0) goto L20;
            r2 = true;
        L20:
            monitor-exit(r0);     // Catch: Throwable -> L8
            return r2;
        L22:
            monitor-exit(r0);     // Catch: Throwable -> L8
            return false;
        L8:
            th = move-exception;
            throw th;
        }

        private boolean stopCapture(TvStreamConfig config) {
            Object r0 = this.mImplLock;
            monitor-enter(r0);
            boolean r2 = false;
            if (this.mReleased == false) goto L10;
            monitor-exit(r0);     // Catch: Throwable -> L8
            return false;
        L10:
            if (config != null) goto L13;
            monitor-exit(r0);     // Catch: Throwable -> L8
            return false;
        L13:
            int result = TvInputHardwareManager.m8728$$Nest$fgetmHal(this.this$0).removeStream(this.mInfo.getDeviceId(), config);     // Catch: Throwable -> L8
            if (result != 0) goto L16;
            r2 = true;
        L16:
            monitor-exit(r0);     // Catch: Throwable -> L8
            return r2;
        L8:
            th = move-exception;
            throw th;
        }

        private boolean updateAudioSourceLocked() {
            if (this.mInfo.getAudioType() != 0) goto L5;
            return false;
        L5:
            AudioDevicePort previousSource = this.mAudioSource;
            this.mAudioSource = findAudioDevicePort(this.mInfo.getAudioType(), this.mInfo.getAudioAddress());
            if (this.mAudioSource != null) goto L10;
            if (previousSource != null) goto L14;
            return false;
        L14:
            return true;
        L10:
            if (this.mAudioSource.equals(previousSource) == false) goto L12;
            return false;
        L12:
            return true;
        }

        private boolean updateAudioSinkLocked() {
            if (this.mInfo.getAudioType() != 0) goto L6;
            return false;
        L6:
            List<AudioDevicePort> previousSink = this.mAudioSink;
            this.mAudioSink = new ArrayList();
            if (this.mOverrideAudioType != 0) goto L9;
            findAudioSinkFromAudioPolicy(this.mAudioSink);
        L13:
            if (this.mAudioSink.size() == previousSink.size()) goto L15;
            return true;
        L15:
            previousSink.removeAll(this.mAudioSink);
            return !previousSink.isEmpty();
        L9:
            AudioDevicePort audioSink = findAudioDevicePort(this.mOverrideAudioType, this.mOverrideAudioAddress);
            if (audioSink == null) goto L13;
            this.mAudioSink.add(audioSink);
            goto L13
        }

        private void handleAudioSinkUpdated() {
            Object r0 = this.mImplLock;
            monitor-enter(r0);
            updateAudioConfigLocked();     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        public void overrideAudioSink(int audioType, String audioAddress, int samplingRate, int channelMask, int format) {
            Object r0 = this.mImplLock;
            monitor-enter(r0);
            this.mOverrideAudioType = audioType;     // Catch: Throwable -> L7
            this.mOverrideAudioAddress = audioAddress;     // Catch: Throwable -> L7
            this.mDesiredSamplingRate = samplingRate;     // Catch: Throwable -> L7
            this.mDesiredChannelMask = channelMask;     // Catch: Throwable -> L7
            this.mDesiredFormat = format;     // Catch: Throwable -> L7
            updateAudioConfigLocked();     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        public void onMediaStreamVolumeChanged() {
            Object r0 = this.mImplLock;
            monitor-enter(r0);
            updateAudioConfigLocked();     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }
    }

    public static /* synthetic */ boolean $r8$lambda$mfdHR10UQyGUomMp8GNDbepfK2Q(int r0, Message r1) {
        return lambda$onStreamConfigurationChanged$0(r0, r1);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmAudioManager, reason: not valid java name */
    static /* bridge */ /* synthetic */ AudioManager m8726$$Nest$fgetmAudioManager(TvInputHardwareManager r0) {
        return r0.mAudioManager;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmConnections, reason: not valid java name */
    static /* bridge */ /* synthetic */ SparseArray m8727$$Nest$fgetmConnections(TvInputHardwareManager r0) {
        return r0.mConnections;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmHal, reason: not valid java name */
    static /* bridge */ /* synthetic */ TvInputHal m8728$$Nest$fgetmHal(TvInputHardwareManager r0) {
        return r0.mHal;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmHandler, reason: not valid java name */
    static /* bridge */ /* synthetic */ Handler m8729$$Nest$fgetmHandler(TvInputHardwareManager r0) {
        return r0.mHandler;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmHardwareInputIdMap, reason: not valid java name */
    static /* bridge */ /* synthetic */ SparseArray m8730$$Nest$fgetmHardwareInputIdMap(TvInputHardwareManager r0) {
        return r0.mHardwareInputIdMap;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmHdmiDeviceList, reason: not valid java name */
    static /* bridge */ /* synthetic */ List m8731$$Nest$fgetmHdmiDeviceList(TvInputHardwareManager r0) {
        return r0.mHdmiDeviceList;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmHdmiInputIdMap, reason: not valid java name */
    static /* bridge */ /* synthetic */ SparseArray m8732$$Nest$fgetmHdmiInputIdMap(TvInputHardwareManager r0) {
        return r0.mHdmiInputIdMap;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmHdmiStateMap, reason: not valid java name */
    static /* bridge */ /* synthetic */ SparseBooleanArray m8733$$Nest$fgetmHdmiStateMap(TvInputHardwareManager r0) {
        return r0.mHdmiStateMap;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmListener, reason: not valid java name */
    static /* bridge */ /* synthetic */ Listener m8734$$Nest$fgetmListener(TvInputHardwareManager r0) {
        return r0.mListener;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmLock, reason: not valid java name */
    static /* bridge */ /* synthetic */ Object m8735$$Nest$fgetmLock(TvInputHardwareManager r0) {
        return r0.mLock;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmPendingHdmiDeviceEvents, reason: not valid java name */
    static /* bridge */ /* synthetic */ List m8736$$Nest$fgetmPendingHdmiDeviceEvents(TvInputHardwareManager r0) {
        return r0.mPendingHdmiDeviceEvents;
    }

    /* JADX INFO: renamed from: -$$Nest$mfindHardwareInfoForHdmiPortLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ TvInputHardwareInfo m8737$$Nest$mfindHardwareInfoForHdmiPortLocked(TvInputHardwareManager r0, int r1) {
        return r0.findHardwareInfoForHdmiPortLocked(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mgetMediaStreamVolume, reason: not valid java name */
    static /* bridge */ /* synthetic */ float m8738$$Nest$mgetMediaStreamVolume(TvInputHardwareManager r0) {
        return r0.getMediaStreamVolume();
    }

    /* JADX INFO: renamed from: -$$Nest$mhandleVolumeChange, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m8739$$Nest$mhandleVolumeChange(TvInputHardwareManager r0, Context r1, Intent r2) {
        r0.handleVolumeChange(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mupdateVolume, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m8740$$Nest$mupdateVolume(TvInputHardwareManager r0) {
        r0.updateVolume();
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetTAG, reason: not valid java name */
    static /* bridge */ /* synthetic */ String m8741$$Nest$sfgetTAG() {
        return TAG;
    }

    /* JADX INFO: renamed from: -$$Nest$smintArrayContains, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m8742$$Nest$smintArrayContains(int[] r0, int r1) {
        return intArrayContains(r0, r1);
    }

    static {
        TAG = TvInputHardwareManager.class.getSimpleName();
    }

    public TvInputHardwareManager(Context context, Listener listener) {
        this.mHal = new TvInputHal(this);
        this.mLock = new Object();
        this.mConnections = new SparseArray();
        this.mHardwareList = new ArrayList();
        this.mHdmiDeviceList = new ArrayList();
        this.mHardwareInputIdMap = new SparseArray();
        this.mHdmiInputIdMap = new SparseArray();
        this.mInputMap = new ArrayMap();
        this.mHdmiParentInputMap = new ArrayMap();
        TvInputHardwareManagerIA r1 = null;
        this.mHdmiHotplugEventListener = new HdmiHotplugEventListener(this, r1);
        this.mHdmiDeviceEventListener = new HdmiDeviceEventListener(this, r1);
        this.mHdmiSystemAudioModeChangeListener = new HdmiSystemAudioModeChangeListener(this, r1);
        this.mVolumeReceiver = new AnonymousClass1(this);
        this.mCurrentIndex = 0;
        this.mCurrentMaxIndex = 0;
        this.mHdmiStateMap = new SparseBooleanArray();
        this.mPendingHdmiDeviceEvents = new ArrayList();
        this.mPendingTvinputInfoEvents = new ArrayList();
        this.mHandler = new ListenerHandler(this, r1);
        this.mContext = context;
        this.mListener = listener;
        this.mAudioManager = (AudioManager) context.getSystemService("audio");
        this.mHal.init();
    }

    public void onBootPhase(int phase) {
        if (phase != 500) goto L22;
        IHdmiControlService hdmiControlService = IHdmiControlService.Stub.asInterface(ServiceManager.getService("hdmi_control"));
        if (hdmiControlService != null) goto L19;
        Slog.w(TAG, "HdmiControlService is not available");
    L17:
        IntentFilter filter = new IntentFilter();
        filter.addAction("android.media.VOLUME_CHANGED_ACTION");
        filter.addAction("android.media.STREAM_MUTE_CHANGED_ACTION");
        this.mContext.registerReceiver(this.mVolumeReceiver, filter);
        updateVolume();
        return;
    L19:
        hdmiControlService.addHotplugEventListener(this.mHdmiHotplugEventListener);     // Catch: RemoteException -> L14
        hdmiControlService.addDeviceEventListener(this.mHdmiDeviceEventListener);     // Catch: RemoteException -> L14
        hdmiControlService.addSystemAudioModeChangeListener(this.mHdmiSystemAudioModeChangeListener);     // Catch: RemoteException -> L14
        Object r1 = this.mLock;     // Catch: RemoteException -> L14
        monitor-enter(r1);     // Catch: RemoteException -> L14
        this.mHdmiDeviceList.addAll(hdmiControlService.getInputDevices());     // Catch: Throwable -> L11
        monitor-exit(r1);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;     // Catch: RemoteException -> L14
    L14:
        e = move-exception;
        Slog.w(TAG, "Error registering listeners to HdmiControlService:", e);
        goto L17
    }

    @Override // com.android.server.tv.TvInputHal.Callback
    public void onDeviceAvailable(TvInputHardwareInfo info, TvStreamConfig[] configs) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        Connection connection = new Connection(this, info);     // Catch: Throwable -> L7
        connection.updateConfigsLocked(configs);     // Catch: Throwable -> L7
        connection.updateCableConnectionStatusLocked(info.getCableConnectionStatus());     // Catch: Throwable -> L7
        this.mConnections.put(info.getDeviceId(), connection);     // Catch: Throwable -> L7
        buildHardwareListLocked();     // Catch: Throwable -> L7
        this.mHandler.obtainMessage(2, 0, 0, info).sendToTarget();     // Catch: Throwable -> L7
        if (info.getType() != 9) goto L9;
        processPendingHdmiDeviceEventsLocked();     // Catch: Throwable -> L7
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private void buildHardwareListLocked() {
        this.mHardwareList.clear();
        int i = 0;
    L4:
        if (i >= this.mConnections.size()) goto L7;
        this.mHardwareList.add(this.mConnections.valueAt(i).getHardwareInfoLocked());
        i = i + 1;
        goto L4
    }

    @Override // com.android.server.tv.TvInputHal.Callback
    public void onDeviceUnavailable(int deviceId) {
        Object r1 = this.mLock;
        monitor-enter(r1);
        Connection connection = this.mConnections.get(deviceId);     // Catch: Throwable -> L9
        if (connection != null) goto L11;
        Slog.e(TAG, "onDeviceUnavailable: Cannot find a connection with " + deviceId);     // Catch: Throwable -> L9
        monitor-exit(r1);     // Catch: Throwable -> L9
        return;
    L11:
        connection.resetLocked(null, null, null, null, null, null);     // Catch: Throwable -> L9
        this.mConnections.remove(deviceId);     // Catch: Throwable -> L9
        buildHardwareListLocked();     // Catch: Throwable -> L9
        TvInputHardwareInfo info = connection.getHardwareInfoLocked();     // Catch: Throwable -> L9
        if (info.getType() != 9) goto L20;
        Iterator<HdmiDeviceInfo> it = this.mHdmiDeviceList.iterator();     // Catch: Throwable -> L9
    L15:
        if (it.hasNext() == false) goto L20;
        HdmiDeviceInfo deviceInfo = it.next();     // Catch: Throwable -> L9
        if (deviceInfo.getPortId() != info.getHdmiPortId()) goto L15;
        this.mHandler.obtainMessage(5, 0, 0, deviceInfo).sendToTarget();     // Catch: Throwable -> L9
        it.remove();     // Catch: Throwable -> L9
    L20:
        this.mHandler.obtainMessage(3, 0, 0, info).sendToTarget();     // Catch: Throwable -> L9
        monitor-exit(r1);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.tv.TvInputHal.Callback
    public void onStreamConfigurationChanged(final int deviceId, TvStreamConfig[] configs, int cableConnectionStatus) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        Connection connection = this.mConnections.get(deviceId);     // Catch: Throwable -> L9
        if (connection != null) goto L11;
        Slog.e(TAG, "StreamConfigurationChanged: Cannot find a connection with " + deviceId);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L11:
        int previousConfigsLength = Connection.m8743$$Nest$mgetConfigsLengthLocked(connection);     // Catch: Throwable -> L9
        int previousCableConnectionStatus = Connection.m8744$$Nest$mgetInputStateLocked(connection);     // Catch: Throwable -> L9
        connection.updateConfigsLocked(configs);     // Catch: Throwable -> L9
        String inputId = this.mHardwareInputIdMap.get(deviceId);     // Catch: Throwable -> L9
        if (inputId != null) goto L14;
        Message msg = this.mHandler.obtainMessage(7, deviceId, cableConnectionStatus, connection);     // Catch: Throwable -> L9
        this.mPendingTvinputInfoEvents.removeIf(new TvInputHardwareManager$$ExternalSyntheticLambda0(deviceId));     // Catch: Throwable -> L9
        this.mPendingTvinputInfoEvents.add(msg);     // Catch: Throwable -> L9
    L28:
        ITvInputHardwareCallback callback = connection.getCallbackLocked();     // Catch: Throwable -> L9
        if (callback != null) goto L39;
    L34:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L39:
        callback.onStreamConfigChanged(configs);     // Catch: Throwable -> L9 RemoteException -> L32
    L32:
        e = move-exception;
        Slog.e(TAG, "error in onStreamConfigurationChanged", e);     // Catch: Throwable -> L9
        goto L34
    L14:
        if (connection.updateCableConnectionStatusLocked(cableConnectionStatus) == true) goto L16;
        if (previousConfigsLength != 0) goto L20;
        boolean r5 = true;
    L22:
        if (Connection.m8743$$Nest$mgetConfigsLengthLocked(connection) != 0) goto L24;
        boolean r8 = true;
    L25:
        if (r5 == r8) goto L28;
        this.mHandler.obtainMessage(1, Connection.m8744$$Nest$mgetInputStateLocked(connection), 0, inputId).sendToTarget();     // Catch: Throwable -> L9
        goto L28
    L24:
        r8 = false;
        goto L25
    L20:
        r5 = false;
        goto L22
    L16:
        if (previousCableConnectionStatus == Connection.m8744$$Nest$mgetInputStateLocked(connection)) goto L28;
        this.mHandler.obtainMessage(1, Connection.m8744$$Nest$mgetInputStateLocked(connection), 0, inputId).sendToTarget();     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    }

    private static /* synthetic */ boolean lambda$onStreamConfigurationChanged$0(int deviceId, Message message) {
        if (message.arg1 != deviceId) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.android.server.tv.TvInputHal.Callback
    public void onFirstFrameCaptured(int deviceId, int streamId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        Connection connection = this.mConnections.get(deviceId);     // Catch: Throwable -> L9
        if (connection != null) goto L11;
        Slog.e(TAG, "FirstFrameCaptured: Cannot find a connection with " + deviceId);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L11:
        Runnable runnable = connection.getOnFirstFrameCapturedLocked();     // Catch: Throwable -> L9
        if (runnable == null) goto L14;
        runnable.run();     // Catch: Throwable -> L9
        connection.setOnFirstFrameCapturedLocked(null);     // Catch: Throwable -> L9
    L14:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.tv.TvInputHal.Callback
    public void onTvMessage(int deviceId, int type, Bundle data) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        String inputId = this.mHardwareInputIdMap.get(deviceId);     // Catch: Throwable -> L8
        if (inputId != null) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        SomeArgs args = SomeArgs.obtain();     // Catch: Throwable -> L8
        args.arg1 = this.mHardwareInputIdMap.get(deviceId);     // Catch: Throwable -> L8
        args.arg2 = data;     // Catch: Throwable -> L8
        this.mHandler.obtainMessage(8, type, 0, args).sendToTarget();     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public List<TvInputHardwareInfo> getHardwareList() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        List<TvInputHardwareInfo> r1 = Collections.unmodifiableList(this.mHardwareList);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public List<HdmiDeviceInfo> getHdmiDeviceList() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        List<HdmiDeviceInfo> r1 = Collections.unmodifiableList(this.mHdmiDeviceList);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public SparseArray<String> getHardwareInputIdMap() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        SparseArray<String> r1 = this.mHardwareInputIdMap.clone();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public SparseArray<String> getHdmiInputIdMap() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        SparseArray<String> r1 = this.mHdmiInputIdMap.clone();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public Map<String, TvInputInfo> getInputMap() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        Map<String, TvInputInfo> r1 = Collections.unmodifiableMap(this.mInputMap);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public Map<String, List<String>> getHdmiParentInputMap() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        Map<String, List<String>> r1 = Collections.unmodifiableMap(this.mHdmiParentInputMap);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    private boolean checkUidChangedLocked(Connection connection, int callingUid, int resolvedUserId) {
        Integer connectionCallingUid = connection.getCallingUidLocked();
        Integer connectionResolvedUserId = connection.getResolvedUserIdLocked();
        if (connectionCallingUid == null) goto L11;
        if (connectionResolvedUserId == null) goto L11;
        if (connectionCallingUid.intValue() != callingUid) goto L11;
        if (connectionResolvedUserId.intValue() != resolvedUserId) goto L11;
        return false;
    L11:
        return true;
    }

    public void addHardwareInput(int deviceId, TvInputInfo info) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        String oldInputId = this.mHardwareInputIdMap.get(deviceId);     // Catch: Throwable -> L7
        if (oldInputId == null) goto L9;
        Slog.w(TAG, "Trying to override previous registration: old = " + this.mInputMap.get(oldInputId) + ":" + deviceId + ", new = " + info + ":" + deviceId);     // Catch: Throwable -> L7
    L9:
        this.mHardwareInputIdMap.put(deviceId, info.getId());     // Catch: Throwable -> L7
        this.mInputMap.put(info.getId(), info);     // Catch: Throwable -> L7
        processPendingTvInputInfoEventsLocked();     // Catch: Throwable -> L7
        Slog.d(TAG, "deviceId =" + deviceId + ", tvinputinfo = " + info);     // Catch: Throwable -> L7
        int i = 0;
    L11:
        if (i >= this.mHdmiStateMap.size()) goto L27;
        TvInputHardwareInfo hardwareInfo = findHardwareInfoForHdmiPortLocked(this.mHdmiStateMap.keyAt(i));     // Catch: Throwable -> L7
        if (hardwareInfo == null) goto L26;
        String inputId = this.mHardwareInputIdMap.get(hardwareInfo.getDeviceId());     // Catch: Throwable -> L7
        if (inputId == null) goto L26;
        if (inputId.equals(info.getId()) == false) goto L26;
        if (this.mHdmiStateMap.valueAt(i) == false) goto L22;
        int state = 0;
    L23:
        this.mHandler.obtainMessage(1, state, 0, inputId).sendToTarget();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L22:
        state = 1;
    L26:
        i = i + 1;     // Catch: Throwable -> L7
        goto L11
    L27:
        Connection connection = this.mConnections.get(deviceId);     // Catch: Throwable -> L7
        if (connection == null) goto L30;
        this.mHandler.obtainMessage(1, Connection.m8744$$Nest$mgetInputStateLocked(connection), 0, info.getId()).sendToTarget();     // Catch: Throwable -> L7
    L30:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private static <T> int indexOfEqualValue(SparseArray<T> map, T value) {
        int i = 0;
    L4:
        if (i >= map.size()) goto L9;
        if (map.valueAt(i).equals(value) == true) goto L7;
        i = i + 1;
        goto L4
    L7:
        return i;
    L9:
        return -1;
    }

    private static boolean intArrayContains(int[] array, int value) {
        int r0 = array.length;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L9;
        int element = array[r2];
        if (element == value) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        return true;
    L9:
        return false;
    }

    public void addHdmiInput(int id, TvInputInfo info) {
        if (info.getType() != 1007) goto L24;
        Object r0 = this.mLock;
        monitor-enter(r0);
        String parentId = info.getParentId();     // Catch: Throwable -> L11
        int parentIndex = indexOfEqualValue(this.mHardwareInputIdMap, parentId);     // Catch: Throwable -> L11
        if (parentIndex < 0) goto L20;
        String oldInputId = this.mHdmiInputIdMap.get(id);     // Catch: Throwable -> L11
        if (oldInputId == null) goto L13;
        Slog.w(TAG, "Trying to override previous registration: old = " + this.mInputMap.get(oldInputId) + ":" + id + ", new = " + info + ":" + id);     // Catch: Throwable -> L11
    L13:
        this.mHdmiInputIdMap.put(id, info.getId());     // Catch: Throwable -> L11
        this.mInputMap.put(info.getId(), info);     // Catch: Throwable -> L11
        if (this.mHdmiParentInputMap.containsKey(parentId) == true) goto L16;
        this.mHdmiParentInputMap.put(parentId, new ArrayList());     // Catch: Throwable -> L11
    L16:
        this.mHdmiParentInputMap.get(parentId).add(info.getId());     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L20:
        throw new IllegalArgumentException("info (" + info + ") has invalid parentId.");     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    L24:
        throw new IllegalArgumentException("info (" + info + ") has non-HDMI type.");
    }

    public void removeHardwareInput(String inputId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        int hardwareIndex = indexOfEqualValue(this.mHardwareInputIdMap, inputId);     // Catch: Throwable -> L7
        if (hardwareIndex < 0) goto L9;
        this.mHardwareInputIdMap.removeAt(hardwareIndex);     // Catch: Throwable -> L7
    L9:
        int deviceIndex = indexOfEqualValue(this.mHdmiInputIdMap, inputId);     // Catch: Throwable -> L7
        if (deviceIndex < 0) goto L13;
        this.mHdmiInputIdMap.removeAt(deviceIndex);     // Catch: Throwable -> L7
    L13:
        if (this.mInputMap.containsKey(inputId) == false) goto L22;
        String parentId = this.mInputMap.get(inputId).getParentId();     // Catch: Throwable -> L7
        if (parentId != null) goto L17;
    L21:
        this.mInputMap.remove(inputId);     // Catch: Throwable -> L7
        goto L22
    L17:
        if (this.mHdmiParentInputMap.containsKey(parentId) == false) goto L21;
        List<String> parentInputList = this.mHdmiParentInputMap.get(parentId);     // Catch: Throwable -> L7
        parentInputList.remove(inputId);     // Catch: Throwable -> L7
        if (parentInputList.isEmpty() == false) goto L21;
        this.mHdmiParentInputMap.remove(parentId);     // Catch: Throwable -> L7
    L22:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void updateInputInfo(TvInputInfo info) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (this.mInputMap.containsKey(info.getId()) == true) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        Slog.w(TAG, "update inputInfo for input id " + info.getId());     // Catch: Throwable -> L8
        this.mInputMap.put(info.getId(), info);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
    }

    public ITvInputHardware acquireHardware(int deviceId, ITvInputHardwareCallback callback, TvInputInfo info, int callingUid, int resolvedUserId, String tvInputSessionId, int priorityHint) {
        if (callback == null) goto L42;
        TunerResourceManager trm = (TunerResourceManager) this.mContext.getSystemService("tv_tuner_resource_mgr");
        Object r2 = this.mLock;
        monitor-enter(r2);
        Connection connection = this.mConnections.get(deviceId);     // Catch: Throwable -> L10
        if (connection != null) goto L13;
        Slog.e(TAG, "Invalid deviceId : " + deviceId);     // Catch: Throwable -> L10
        monitor-exit(r2);     // Catch: Throwable -> L10
        return null;
    L13:
        ResourceClientProfile profile = new ResourceClientProfile();     // Catch: Throwable -> L10
        profile.tvInputSessionId = tvInputSessionId;     // Catch: Throwable -> L37
        profile.useCase = priorityHint;     // Catch: Throwable -> L25
        ResourceClientProfile holderProfile = connection.getResourceClientProfileLocked();     // Catch: Throwable -> L25
        if (holderProfile == null) goto L27;
        if (trm == null) goto L27;
        if (trm.isHigherPriority(profile, holderProfile) == true) goto L27;
        Slog.d(TAG, "Acquiring does not show higher priority than the current holder. Device id:" + deviceId);     // Catch: Throwable -> L25
        monitor-exit(r2);     // Catch: Throwable -> L25
        return null;
    L27:
        TvInputHardwareImpl hardware = new TvInputHardwareImpl(this, connection.getHardwareInfoLocked());     // Catch: Throwable -> L25
        callback.asBinder().linkToDeath(connection, 0);     // Catch: Throwable -> L25 RemoteException -> L33
        connection.resetLocked(hardware, callback, info, Integer.valueOf(callingUid), Integer.valueOf(resolvedUserId), profile);     // Catch: Throwable -> L25
        ITvInputHardware r0 = connection.getHardwareLocked();     // Catch: Throwable -> L25
        monitor-exit(r2);     // Catch: Throwable -> L25
        return r0;
    L34:
        hardware.release();     // Catch: Throwable -> L25
        return null;
    L25:
        e = th;
    L39:
        monitor-exit(r2);     // Catch: Throwable -> L25
        throw e;
    L37:
        e = th;
    L10:
        e = th;
        goto L39
    L42:
        throw new NullPointerException();
    }

    public void releaseHardware(int deviceId, ITvInputHardware hardware, int callingUid, int resolvedUserId) {
        Object r1 = this.mLock;
        monitor-enter(r1);
        Connection connection = this.mConnections.get(deviceId);     // Catch: Throwable -> L9
        if (connection != null) goto L12;
        Slog.e(TAG, "Invalid deviceId : " + deviceId);     // Catch: Throwable -> L9
        monitor-exit(r1);     // Catch: Throwable -> L9
        return;
    L12:
        if (connection.getHardwareLocked() == hardware) goto L14;
    L22:
        monitor-exit(r1);     // Catch: Throwable -> L9
        return;
    L14:
        if (checkUidChangedLocked(connection, callingUid, resolvedUserId) == true) goto L22;
        ITvInputHardwareCallback callback = connection.getCallbackLocked();     // Catch: Throwable -> L9
        if (callback == null) goto L19;
        callback.asBinder().unlinkToDeath(connection, 0);     // Catch: Throwable -> L9
    L19:
        connection.resetLocked(null, null, null, null, null, null);     // Catch: Throwable -> L9
        monitor-exit(r1);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    private TvInputHardwareInfo findHardwareInfoForHdmiPortLocked(int port) {
        Iterator<TvInputHardwareInfo> r0 = this.mHardwareList.iterator();
    L4:
        if (r0.hasNext() == false) goto L11;
        TvInputHardwareInfo hardwareInfo = r0.next();
        if (hardwareInfo.getType() != 9) goto L4;
        if (hardwareInfo.getHdmiPortId() != port) goto L4;
        return hardwareInfo;
    L11:
        return null;
    }

    private int findDeviceIdForInputIdLocked(String inputId) {
        int i = 0;
    L4:
        if (i >= this.mConnections.size()) goto L13;
        int key = this.mConnections.keyAt(i);
        Connection connection = this.mConnections.get(key);
        if (connection == null) goto L12;
        if (connection.getInfoLocked() == null) goto L12;
        if (connection.getInfoLocked().getId().equals(inputId) == false) goto L12;
        return key;
    L12:
        i = i + 1;
        goto L4
    L13:
        return -1;
    }

    public List<TvStreamConfig> getAvailableTvStreamConfigList(String inputId, int callingUid, int resolvedUserId) {
        List<TvStreamConfig> configsList = new ArrayList();
        Object r1 = this.mLock;
        monitor-enter(r1);
        int deviceId = findDeviceIdForInputIdLocked(inputId);     // Catch: Throwable -> L9
        if (deviceId >= 0) goto L11;
        Slog.e(TAG, "Invalid inputId : " + inputId);     // Catch: Throwable -> L9
        monitor-exit(r1);     // Catch: Throwable -> L9
        return configsList;
    L11:
        Connection connection = this.mConnections.get(deviceId);     // Catch: Throwable -> L9
        TvStreamConfig[] r4 = connection.getConfigsLocked();     // Catch: Throwable -> L9
        int r5 = r4.length;     // Catch: Throwable -> L9
        int r6 = 0;
    L13:
        if (r6 >= r5) goto L18;
        TvStreamConfig config = r4[r6];     // Catch: Throwable -> L9
        if (config.getType() != 2) goto L17;
        configsList.add(config);     // Catch: Throwable -> L9
    L17:
        r6 = r6 + 1;     // Catch: Throwable -> L9
        goto L13
    L18:
        monitor-exit(r1);     // Catch: Throwable -> L9
        return configsList;
    L9:
        th = move-exception;
        throw th;
    }

    public boolean setTvMessageEnabled(String inputId, int type, boolean enabled) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        int deviceId = findDeviceIdForInputIdLocked(inputId);     // Catch: Throwable -> L9
        if (deviceId >= 0) goto L11;
        Slog.e(TAG, "Invalid inputId : " + inputId);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return false;
    L11:
        Connection connection = this.mConnections.get(deviceId);     // Catch: Throwable -> L9
        boolean success = true;
        TvStreamConfig[] r5 = connection.getConfigsLocked();     // Catch: Throwable -> L9
        int r6 = r5.length;     // Catch: Throwable -> L9
        int r7 = 0;
    L12:
        if (r7 >= r6) goto L20;
        TvStreamConfig config = r5[r7];     // Catch: Throwable -> L9
        if (success == true) goto L16;
    L18:
        boolean r9 = false;
    L19:
        success = r9;
        r7 = r7 + 1;     // Catch: Throwable -> L9
        goto L12
    L16:
        if (this.mHal.setTvMessageEnabled(deviceId, config, type, enabled) != 0) goto L18;
        r9 = true;
        goto L19
    L20:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return success;
    L9:
        th = move-exception;
        throw th;
    }

    public boolean setPictureProfile(String inputId, long profileHandle) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        int deviceId = findDeviceIdForInputIdLocked(inputId);     // Catch: Throwable -> L9
        if (deviceId >= 0) goto L11;
        Slog.e(TAG, "Invalid inputId : " + inputId);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return false;
    L11:
        Connection connection = this.mConnections.get(deviceId);     // Catch: Throwable -> L9
        boolean success = true;
        TvStreamConfig[] r5 = connection.getConfigsLocked();     // Catch: Throwable -> L9
        int r6 = r5.length;     // Catch: Throwable -> L9
        int r7 = 0;
    L12:
        if (r7 >= r6) goto L20;
        TvStreamConfig config = r5[r7];     // Catch: Throwable -> L9
        if (success == true) goto L16;
    L18:
        boolean r9 = false;
    L19:
        success = r9;
        r7 = r7 + 1;     // Catch: Throwable -> L9
        goto L12
    L16:
        if (this.mHal.setPictureProfile(deviceId, config, profileHandle) != 0) goto L18;
        r9 = true;
        goto L19
    L20:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return success;
    L9:
        th = move-exception;
        throw th;
    }

    public boolean captureFrame(String inputId, Surface surface, final TvStreamConfig config, int callingUid, int resolvedUserId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        int deviceId = findDeviceIdForInputIdLocked(inputId);     // Catch: Throwable -> L9
        if (deviceId >= 0) goto L11;
        Slog.e(TAG, "Invalid inputId : " + inputId);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return false;
    L11:
        Connection connection = this.mConnections.get(deviceId);     // Catch: Throwable -> L9
        final TvInputHardwareImpl hardwareImpl = connection.getHardwareImplLocked();     // Catch: Throwable -> L9
        if (hardwareImpl == null) goto L22;
        Runnable runnable = connection.getOnFirstFrameCapturedLocked();     // Catch: Throwable -> L9
        if (runnable == null) goto L16;
        runnable.run();     // Catch: Throwable -> L9
        connection.setOnFirstFrameCapturedLocked(null);     // Catch: Throwable -> L9
    L16:
        boolean result = TvInputHardwareImpl.m8751$$Nest$mstartCapture(hardwareImpl, surface, config);     // Catch: Throwable -> L9
        if (result == false) goto L19;
        connection.setOnFirstFrameCapturedLocked(new AnonymousClass2(this, hardwareImpl, config));     // Catch: Throwable -> L9
    L19:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return result;
    L22:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return false;
    L9:
        th = move-exception;
        throw th;
    }

    private void processPendingHdmiDeviceEventsLocked() {
        Iterator<Message> it = this.mPendingHdmiDeviceEvents.iterator();
    L4:
        if (it.hasNext() == false) goto L10;
        Message msg = it.next();
        HdmiDeviceInfo deviceInfo = (HdmiDeviceInfo) msg.obj;
        TvInputHardwareInfo hardwareInfo = findHardwareInfoForHdmiPortLocked(deviceInfo.getPortId());
        if (hardwareInfo == null) goto L4;
        msg.sendToTarget();
        it.remove();
        goto L4
    }

    private void processPendingTvInputInfoEventsLocked() {
        Iterator<Message> it = this.mPendingTvinputInfoEvents.iterator();
    L4:
        if (it.hasNext() == false) goto L10;
        Message msg = it.next();
        int deviceId = msg.arg1;
        String inputId = this.mHardwareInputIdMap.get(deviceId);
        if (inputId == null) goto L4;
        msg.sendToTarget();
        it.remove();
        goto L4
    }

    private void updateVolume() {
        this.mCurrentMaxIndex = this.mAudioManager.getStreamMaxVolume(3);
        this.mCurrentIndex = this.mAudioManager.getStreamVolume(3);
    }

    private void handleVolumeChange(Context context, Intent intent) {
        String action = intent.getAction();
        switch(action.hashCode()) {
            case -1940635523: goto L9;
            case 1920758225: goto L6;
            default: goto L11;
        };
    L11:
        byte r1 = -1;
    L13:
        switch(r1) {
            case 0: goto L19;
            case 1: goto L16;
            default: goto L14;
        };
    L14:
        Slog.w(TAG, "Unrecognized intent: " + intent);
        return;
    L16:
        int streamType = intent.getIntExtra("android.media.EXTRA_VOLUME_STREAM_TYPE", -1);
        if (streamType == 3) goto L26;
        return;
    L26:
        Object r2 = this.mLock;
        monitor-enter(r2);
        int i = 0;
    L42:
    L34:
        th = move-exception;
        throw th;
    L30:
        if (i >= this.mConnections.size()) goto L38;
        TvInputHardwareImpl hardwareImpl = this.mConnections.valueAt(i).getHardwareImplLocked();     // Catch: Throwable -> L34
        if (hardwareImpl == null) goto L36;
        hardwareImpl.onMediaStreamVolumeChanged();     // Catch: Throwable -> L34
    L36:
        i = i + 1;     // Catch: Throwable -> L34
        goto L42
    L38:
        monitor-exit(r2);     // Catch: Throwable -> L34
        return;
    L19:
        int streamType2 = intent.getIntExtra("android.media.EXTRA_VOLUME_STREAM_TYPE", -1);
        if (streamType2 == 3) goto L22;
        return;
    L22:
        int index = intent.getIntExtra("android.media.EXTRA_VOLUME_STREAM_VALUE", 0);
        if (index != this.mCurrentIndex) goto L25;
        return;
    L25:
        this.mCurrentIndex = index;
        goto L26
    L6:
        if (action.equals("android.media.STREAM_MUTE_CHANGED_ACTION") == false) goto L47;
        r1 = 1;
        goto L13
    L47:
        r1 = -1;
        goto L13
    L9:
        if (action.equals("android.media.VOLUME_CHANGED_ACTION") == false) goto L48;
        r1 = 0;
        goto L13
    L48:
        r1 = -1;
        goto L13
    }

    private float getMediaStreamVolume() {
        return this.mCurrentIndex / this.mCurrentMaxIndex;
    }

    public void dump(FileDescriptor fd, PrintWriter writer, String[] args) {
        IndentingPrintWriter pw = new IndentingPrintWriter(writer, "  ");
        if (DumpUtils.checkDumpPermission(this.mContext, TAG, pw) == true) goto L5;
        return;
    L5:
        Object r1 = this.mLock;
        monitor-enter(r1);
        pw.println("TvInputHardwareManager Info:");     // Catch: Throwable -> L11
        pw.increaseIndent();     // Catch: Throwable -> L11
        pw.println("mConnections: deviceId -> Connection");     // Catch: Throwable -> L11
        pw.increaseIndent();     // Catch: Throwable -> L11
        int i = 0;
    L9:
        if (i >= this.mConnections.size()) goto L13;
        int deviceId = this.mConnections.keyAt(i);     // Catch: Throwable -> L11
        Connection mConnection = this.mConnections.valueAt(i);     // Catch: Throwable -> L11
        pw.println(deviceId + ": " + mConnection);     // Catch: Throwable -> L11
        i = i + 1;     // Catch: Throwable -> L11
        goto L9
    L13:
        pw.decreaseIndent();     // Catch: Throwable -> L11
        pw.println("mHardwareList:");     // Catch: Throwable -> L11
        pw.increaseIndent();     // Catch: Throwable -> L11
        Iterator<TvInputHardwareInfo> r2 = this.mHardwareList.iterator();     // Catch: Throwable -> L11
    L15:
        if (r2.hasNext() == false) goto L17;
        TvInputHardwareInfo tvInputHardwareInfo = r2.next();     // Catch: Throwable -> L11
        pw.println(tvInputHardwareInfo);     // Catch: Throwable -> L11
        goto L15
    L17:
        pw.decreaseIndent();     // Catch: Throwable -> L11
        pw.println("mHdmiDeviceList:");     // Catch: Throwable -> L11
        pw.increaseIndent();     // Catch: Throwable -> L11
        Iterator<HdmiDeviceInfo> r3 = this.mHdmiDeviceList.iterator();     // Catch: Throwable -> L11
    L19:
        if (r3.hasNext() == false) goto L21;
        HdmiDeviceInfo hdmiDeviceInfo = r3.next();     // Catch: Throwable -> L11
        pw.println(hdmiDeviceInfo);     // Catch: Throwable -> L11
        goto L19
    L21:
        pw.decreaseIndent();     // Catch: Throwable -> L11
        pw.println("mHardwareInputIdMap: deviceId -> inputId");     // Catch: Throwable -> L11
        pw.increaseIndent();     // Catch: Throwable -> L11
        int i2 = 0;
    L23:
        if (i2 >= this.mHardwareInputIdMap.size()) goto L25;
        int deviceId2 = this.mHardwareInputIdMap.keyAt(i2);     // Catch: Throwable -> L11
        String inputId = this.mHardwareInputIdMap.valueAt(i2);     // Catch: Throwable -> L11
        pw.println(deviceId2 + ": " + inputId);     // Catch: Throwable -> L11
        i2 = i2 + 1;     // Catch: Throwable -> L11
        goto L23
    L25:
        pw.decreaseIndent();     // Catch: Throwable -> L11
        pw.println("mHdmiInputIdMap: id -> inputId");     // Catch: Throwable -> L11
        pw.increaseIndent();     // Catch: Throwable -> L11
        int i3 = 0;
    L27:
        if (i3 >= this.mHdmiInputIdMap.size()) goto L29;
        int id = this.mHdmiInputIdMap.keyAt(i3);     // Catch: Throwable -> L11
        String inputId2 = this.mHdmiInputIdMap.valueAt(i3);     // Catch: Throwable -> L11
        pw.println(id + ": " + inputId2);     // Catch: Throwable -> L11
        i3 = i3 + 1;     // Catch: Throwable -> L11
        goto L27
    L29:
        pw.decreaseIndent();     // Catch: Throwable -> L11
        pw.println("mInputMap: inputId -> inputInfo");     // Catch: Throwable -> L11
        pw.increaseIndent();     // Catch: Throwable -> L11
        Iterator<Map.Entry<String, TvInputInfo>> r4 = this.mInputMap.entrySet().iterator();     // Catch: Throwable -> L11
    L31:
        if (r4.hasNext() == false) goto L33;
        Map.Entry<String, TvInputInfo> entry = r4.next();     // Catch: Throwable -> L11
        pw.println(entry.getKey() + ": " + entry.getValue());     // Catch: Throwable -> L11
        goto L31
    L33:
        pw.decreaseIndent();     // Catch: Throwable -> L11
        pw.decreaseIndent();     // Catch: Throwable -> L11
        monitor-exit(r1);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    }
}
