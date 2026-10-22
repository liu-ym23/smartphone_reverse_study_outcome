package com.android.server.hdmi;

import android.hardware.hdmi.HdmiPortInfo;
import android.hardware.tv.cec.V1_0.CecMessage;
import android.hardware.tv.cec.V1_0.HotplugEvent;
import android.hardware.tv.cec.V1_0.IHdmiCec;
import android.hardware.tv.cec.V1_0.IHdmiCecCallback;
import android.hardware.tv.hdmi.connection.IHdmiConnection;
import android.hardware.tv.hdmi.connection.IHdmiConnectionCallback;
import android.icu.util.IllformedLocaleException;
import android.icu.util.ULocale;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.os.IHwBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.os.ServiceSpecificException;
import android.util.Slog;
import com.android.internal.util.IndentingPrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.function.Predicate;
import libcore.util.EmptyArray;

/* JADX INFO: loaded from: classes2.dex */
final class HdmiCecController {
    private static final int ACTION_ON_RECEIVE_MSG = 2;
    private static final int CEC_DISABLED_DROP_MSG = 4;
    private static final int CEC_DISABLED_IGNORE = 1;
    private static final int CEC_DISABLED_LOG_WARNING = 2;
    private static final byte[] EMPTY_BODY = null;
    protected static final int HDMI_CEC_HAL_DEATH_COOKIE = 353;
    private static final int INITIAL_HDMI_MESSAGE_HISTORY_SIZE = 250;
    private static final int INVALID_PHYSICAL_ADDRESS = 65535;
    private static final int MAX_DEDICATED_ADDRESS = 11;
    private static final int NUM_LOGICAL_ADDRESS = 16;
    private static final String TAG = "HdmiCecController";
    private Handler mControlHandler;
    private final HdmiCecAtomWriter mHdmiCecAtomWriter;
    private Handler mIoHandler;
    private long mLogicalAddressAllocationDelay;
    private ArrayBlockingQueue<Dumpable> mMessageHistory;
    private final Object mMessageHistoryLock;
    private final NativeWrapper mNativeWrapperImpl;
    private long mPollDevicesDelay;
    private final Predicate<Integer> mRemoteDeviceAddressPredicate;
    private final HdmiControlService mService;
    private final Predicate<Integer> mSystemAudioAddressPredicate;

    interface AllocateAddressCallback {
        void onAllocated(int r1, int r2);
    }

    public static abstract class Dumpable {
        protected final long mTime;

        abstract void dump(IndentingPrintWriter r1, SimpleDateFormat r2);

        Dumpable() {
            this.mTime = System.currentTimeMillis();
        }
    }

    final class HdmiCecCallback {
        final /* synthetic */ HdmiCecController this$0;

        public static /* synthetic */ void $r8$lambda$64Lq_TVyrO6LL4RuWOath5E1NyU(HdmiCecCallback r0, int r1, boolean r2) {
            r0.lambda$onHotplugEvent$1(r1, r2);
        }

        public static /* synthetic */ void $r8$lambda$6Ja3ntMSTmh16Ywcdz7BtZ3rRGA(HdmiCecCallback r0, int r1, int r2, byte[] r3) {
            r0.lambda$onCecMessage$0(r1, r2, r3);
        }

        HdmiCecCallback(HdmiCecController this$0) {
            this.this$0 = this$0;
        }

        public void onCecMessage(final int initiator, final int destination, final byte[] body) {
            this.this$0.runOnServiceThread(new HdmiCecController$HdmiCecCallback$$ExternalSyntheticLambda1(this, initiator, destination, body));
        }

        private /* synthetic */ void lambda$onCecMessage$0(int initiator, int destination, byte[] body) {
            HdmiCecController.m4283$$Nest$mhandleIncomingCecCommand(this.this$0, initiator, destination, body);
        }

        private /* synthetic */ void lambda$onHotplugEvent$1(int portId, boolean connected) {
            HdmiCecController.m4282$$Nest$mhandleHotplug(this.this$0, portId, connected);
        }

        public void onHotplugEvent(final int portId, final boolean connected) {
            this.this$0.runOnServiceThread(new HdmiCecController$HdmiCecCallback$$ExternalSyntheticLambda0(this, portId, connected));
        }
    }

    private static final class HdmiCecCallback10 extends IHdmiCecCallback.Stub {
        private final HdmiCecCallback mHdmiCecCallback;

        HdmiCecCallback10(HdmiCecCallback hdmiCecCallback) {
            this.mHdmiCecCallback = hdmiCecCallback;
        }

        @Override // android.hardware.tv.cec.V1_0.IHdmiCecCallback
        public void onCecMessage(CecMessage message) throws RemoteException {
            byte[] body = new byte[message.body.size()];
            int i = 0;
        L4:
            if (i >= message.body.size()) goto L6;
            body[i] = message.body.get(i).byteValue();
            i = i + 1;
            goto L4
        L6:
            this.mHdmiCecCallback.onCecMessage(message.initiator, message.destination, body);
        }

        @Override // android.hardware.tv.cec.V1_0.IHdmiCecCallback
        public void onHotplugEvent(HotplugEvent event) throws RemoteException {
            this.mHdmiCecCallback.onHotplugEvent(event.portId, event.connected);
        }
    }

    private static final class HdmiCecCallback11 extends android.hardware.tv.cec.V1_1.IHdmiCecCallback.Stub {
        private final HdmiCecCallback mHdmiCecCallback;

        HdmiCecCallback11(HdmiCecCallback hdmiCecCallback) {
            this.mHdmiCecCallback = hdmiCecCallback;
        }

        @Override // android.hardware.tv.cec.V1_1.IHdmiCecCallback
        public void onCecMessage_1_1(android.hardware.tv.cec.V1_1.CecMessage message) throws RemoteException {
            byte[] body = new byte[message.body.size()];
            int i = 0;
        L4:
            if (i >= message.body.size()) goto L6;
            body[i] = message.body.get(i).byteValue();
            i = i + 1;
            goto L4
        L6:
            this.mHdmiCecCallback.onCecMessage(message.initiator, message.destination, body);
        }

        @Override // android.hardware.tv.cec.V1_0.IHdmiCecCallback
        public void onCecMessage(CecMessage message) throws RemoteException {
            byte[] body = new byte[message.body.size()];
            int i = 0;
        L4:
            if (i >= message.body.size()) goto L6;
            body[i] = message.body.get(i).byteValue();
            i = i + 1;
            goto L4
        L6:
            this.mHdmiCecCallback.onCecMessage(message.initiator, message.destination, body);
        }

        @Override // android.hardware.tv.cec.V1_0.IHdmiCecCallback
        public void onHotplugEvent(HotplugEvent event) throws RemoteException {
            this.mHdmiCecCallback.onHotplugEvent(event.portId, event.connected);
        }
    }

    private static final class HdmiCecCallbackAidl extends android.hardware.tv.hdmi.cec.IHdmiCecCallback.Stub {
        private final HdmiCecCallback mHdmiCecCallback;

        HdmiCecCallbackAidl(HdmiCecCallback hdmiCecCallback) {
            this.mHdmiCecCallback = hdmiCecCallback;
        }

        @Override // android.hardware.tv.hdmi.cec.IHdmiCecCallback
        public void onCecMessage(android.hardware.tv.hdmi.cec.CecMessage message) throws RemoteException {
            this.mHdmiCecCallback.onCecMessage(message.initiator, message.destination, message.body);
        }

        /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
        @Override // android.hardware.tv.hdmi.cec.IHdmiCecCallback
        public synchronized String getInterfaceHash() throws RemoteException {
            monitor-enter(this);
            monitor-exit(this);
            return "cd956e3a0c2e6ade71693c85e9f0aeffa221ea26";
        }

        @Override // android.hardware.tv.hdmi.cec.IHdmiCecCallback
        public int getInterfaceVersion() throws RemoteException {
            return 1;
        }
    }

    private static final class HdmiConnectionCallbackAidl extends IHdmiConnectionCallback.Stub {
        private final HdmiCecCallback mHdmiCecCallback;

        HdmiConnectionCallbackAidl(HdmiCecCallback hdmiCecCallback) {
            this.mHdmiCecCallback = hdmiCecCallback;
        }

        @Override // android.hardware.tv.hdmi.connection.IHdmiConnectionCallback
        public void onHotplugEvent(boolean connected, int portId) throws RemoteException {
            this.mHdmiCecCallback.onHotplugEvent(portId, connected);
        }

        /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
        @Override // android.hardware.tv.hdmi.connection.IHdmiConnectionCallback
        public synchronized String getInterfaceHash() throws RemoteException {
            monitor-enter(this);
            monitor-exit(this);
            return "85c26fa47f3c3062aa93ffc8bb0897a85c8cb118";
        }

        @Override // android.hardware.tv.hdmi.connection.IHdmiConnectionCallback
        public int getInterfaceVersion() throws RemoteException {
            return 1;
        }
    }

    private static final class HotplugHistoryRecord extends Dumpable {
        private final boolean mConnected;
        private final int mPort;

        HotplugHistoryRecord(int port, boolean connected) {
            this.mPort = port;
            this.mConnected = connected;
        }

        @Override // com.android.server.hdmi.HdmiCecController.Dumpable
        void dump(IndentingPrintWriter pw, SimpleDateFormat sdf) {
            pw.print("[H]");
            pw.print(" time=");
            pw.print(sdf.format(new Date(this.mTime)));
            pw.print(" hotplug port=");
            pw.print(this.mPort);
            pw.print(" connected=");
            pw.println(this.mConnected);
        }
    }

    private static final class MessageHistoryRecord extends Dumpable {
        private final boolean mIsReceived;
        private final HdmiCecMessage mMessage;
        private final List<String> mSendResults;

        MessageHistoryRecord(boolean isReceived, HdmiCecMessage message, List<String> sendResults) {
            this.mIsReceived = isReceived;
            this.mMessage = message;
            this.mSendResults = sendResults;
        }

        @Override // com.android.server.hdmi.HdmiCecController.Dumpable
        void dump(IndentingPrintWriter pw, SimpleDateFormat sdf) {
            if (this.mIsReceived == false) goto L5;
            String r0 = "[R]";
        L6:
            pw.print(r0);
            pw.print(" time=");
            pw.print(sdf.format(new Date(this.mTime)));
            pw.print(" message=");
            pw.print(this.mMessage);
            StringBuilder results = new StringBuilder();
            if (this.mIsReceived == false) goto L9;
        L11:
            pw.println(results);
            return;
        L9:
            if (this.mSendResults == null) goto L11;
            results.append(" (");
            results.append(String.join(", ", this.mSendResults));
            results.append(")");
            goto L11
        L5:
            r0 = "[S]";
            goto L6
        }
    }

    protected interface NativeWrapper {
        void enableCec(boolean r1);

        void enableSystemCecControl(boolean r1);

        void enableWakeupByOtp(boolean r1);

        int nativeAddLogicalAddress(int r1);

        void nativeClearLogicalAddress();

        void nativeEnableAudioReturnChannel(int r1, boolean r2);

        int nativeGetHpdSignalType(int r1);

        int nativeGetPhysicalAddress();

        HdmiPortInfo[] nativeGetPortInfos();

        int nativeGetVendorId();

        int nativeGetVersion();

        String nativeInit();

        boolean nativeIsConnected(int r1);

        int nativeSendCecCommand(int r1, int r2, byte[] r3);

        void nativeSetHpdSignalType(int r1, int r2);

        void nativeSetLanguage(String r1);

        void setCallback(HdmiCecCallback r1);
    }

    private static final class NativeWrapperImpl implements NativeWrapper, IHwBinder.DeathRecipient, IHdmiCec.getPhysicalAddressCallback {
        private HdmiCecCallback mCallback;
        private IHdmiCec mHdmiCec;
        private final Object mLock;
        private int mPhysicalAddress;

        /* synthetic */ NativeWrapperImpl(HdmiCecControllerIA r1) {
            this();
        }

        private NativeWrapperImpl() {
            this.mLock = new Object();
            this.mPhysicalAddress = 65535;
        }

        @Override // com.android.server.hdmi.HdmiCecController.NativeWrapper
        public String nativeInit() {
            if (connectToHal() == true) goto L7;
            return null;
        L7:
            return this.mHdmiCec.toString();
        }

        boolean connectToHal() {
            this.mHdmiCec = IHdmiCec.getService(true);     // Catch: Throwable -> L6
            this.mHdmiCec.linkToDeath(this, 353);     // Catch: Throwable -> L6 RemoteException -> L8
        L11:
            return true;
        L8:
            e = move-exception;
            HdmiLogger.error("Couldn't link to death : ", e, new Object[0]);     // Catch: Throwable -> L6 Throwable -> L6
        L6:
            e = move-exception;
            HdmiLogger.error("Couldn't connect to cec@1.0", e, new Object[0]);
            return false;
        }

        @Override // com.android.server.hdmi.HdmiCecController.NativeWrapper
        public void setCallback(HdmiCecCallback callback) {
            this.mCallback = callback;
            this.mHdmiCec.setCallback(new HdmiCecCallback10(callback));     // Catch: RemoteException -> L5
            return;
        L5:
            e = move-exception;
            HdmiLogger.error("Couldn't initialise tv.cec callback : ", e, new Object[0]);
        }

        @Override // com.android.server.hdmi.HdmiCecController.NativeWrapper
        public int nativeSendCecCommand(int srcAddress, int dstAddress, byte[] body) {
            CecMessage message = new CecMessage();
            message.initiator = srcAddress;
            message.destination = dstAddress;
            message.body = new ArrayList(body.length);
            int r1 = body.length;
            int r3 = 0;
        L3:
            if (r3 >= r1) goto L10;
            byte b = body[r3];
            message.body.add(Byte.valueOf(b));
            r3 = r3 + 1;
            goto L3
        L10:
            return this.mHdmiCec.sendMessage(message);
        L7:
            e = move-exception;
            HdmiLogger.error("Failed to send CEC message : ", e, new Object[0]);
            return 3;
        }

        @Override // com.android.server.hdmi.HdmiCecController.NativeWrapper
        public int nativeAddLogicalAddress(int logicalAddress) {
            return this.mHdmiCec.addLogicalAddress(logicalAddress);
        L4:
            e = move-exception;
            HdmiLogger.error("Failed to add a logical address : ", e, new Object[0]);
            return 2;
        }

        @Override // com.android.server.hdmi.HdmiCecController.NativeWrapper
        public void nativeClearLogicalAddress() {
            this.mHdmiCec.clearLogicalAddress();     // Catch: RemoteException -> L4
            return;
        L4:
            e = move-exception;
            HdmiLogger.error("Failed to clear logical address : ", e, new Object[0]);
        }

        @Override // com.android.server.hdmi.HdmiCecController.NativeWrapper
        public int nativeGetPhysicalAddress() {
            this.mHdmiCec.getPhysicalAddress(this);     // Catch: RemoteException -> L4
            return this.mPhysicalAddress;
        L4:
            e = move-exception;
            HdmiLogger.error("Failed to get physical address : ", e, new Object[0]);
            return 65535;
        }

        @Override // com.android.server.hdmi.HdmiCecController.NativeWrapper
        public int nativeGetVersion() {
            return this.mHdmiCec.getCecVersion();
        L4:
            e = move-exception;
            HdmiLogger.error("Failed to get cec version : ", e, new Object[0]);
            return 1;
        }

        @Override // com.android.server.hdmi.HdmiCecController.NativeWrapper
        public int nativeGetVendorId() {
            return this.mHdmiCec.getVendorId();
        L4:
            e = move-exception;
            HdmiLogger.error("Failed to get vendor id : ", e, new Object[0]);
            return 1;
        }

        @Override // com.android.server.hdmi.HdmiCecController.NativeWrapper
        public HdmiPortInfo[] nativeGetPortInfos() {
            ArrayList<android.hardware.tv.cec.V1_0.HdmiPortInfo> hdmiPortInfos = this.mHdmiCec.getPortInfo();     // Catch: RemoteException -> L8
            HdmiPortInfo[] hdmiPortInfo = new HdmiPortInfo[hdmiPortInfos.size()];     // Catch: RemoteException -> L8
            int i = 0;
            Iterator<android.hardware.tv.cec.V1_0.HdmiPortInfo> r4 = hdmiPortInfos.iterator();     // Catch: RemoteException -> L8
        L5:
            if (r4.hasNext() == false) goto L10;
            android.hardware.tv.cec.V1_0.HdmiPortInfo portInfo = r4.next();     // Catch: RemoteException -> L8
            hdmiPortInfo[i] = new HdmiPortInfo.Builder(portInfo.portId, portInfo.type, Short.toUnsignedInt(portInfo.physicalAddress)).setCecSupported(portInfo.cecSupported).setMhlSupported(false).setArcSupported(portInfo.arcSupported).setEarcSupported(false).build();     // Catch: RemoteException -> L8
            i = i + 1;
            goto L5
        L10:
            return hdmiPortInfo;
        L8:
            e = move-exception;
            HdmiLogger.error("Failed to get port information : ", e, new Object[0]);
            return null;
        }

        private void nativeSetOption(int flag, boolean enabled) {
            this.mHdmiCec.setOption(flag, enabled);     // Catch: RemoteException -> L4
            return;
        L4:
            e = move-exception;
            HdmiLogger.error("Failed to set option : ", e, new Object[0]);
        }

        @Override // com.android.server.hdmi.HdmiCecController.NativeWrapper
        public void enableWakeupByOtp(boolean enabled) {
            nativeSetOption(1, enabled);
        }

        @Override // com.android.server.hdmi.HdmiCecController.NativeWrapper
        public void enableCec(boolean enabled) {
            nativeSetOption(2, enabled);
        }

        @Override // com.android.server.hdmi.HdmiCecController.NativeWrapper
        public void enableSystemCecControl(boolean enabled) {
            nativeSetOption(3, enabled);
        }

        @Override // com.android.server.hdmi.HdmiCecController.NativeWrapper
        public void nativeSetLanguage(String language) {
            this.mHdmiCec.setLanguage(language);     // Catch: RemoteException -> L4
            return;
        L4:
            e = move-exception;
            HdmiLogger.error("Failed to set language : ", e, new Object[0]);
        }

        @Override // com.android.server.hdmi.HdmiCecController.NativeWrapper
        public void nativeEnableAudioReturnChannel(int port, boolean flag) {
            this.mHdmiCec.enableAudioReturnChannel(port, flag);     // Catch: RemoteException -> L4
            return;
        L4:
            e = move-exception;
            HdmiLogger.error("Failed to enable/disable ARC : ", e, new Object[0]);
        }

        @Override // com.android.server.hdmi.HdmiCecController.NativeWrapper
        public boolean nativeIsConnected(int port) {
            return this.mHdmiCec.isConnected(port);
        L4:
            e = move-exception;
            HdmiLogger.error("Failed to get connection info : ", e, new Object[0]);
            return false;
        }

        @Override // com.android.server.hdmi.HdmiCecController.NativeWrapper
        public void nativeSetHpdSignalType(int signal, int portId) {
            HdmiLogger.error("Failed to set HPD signal type: not supported by HAL.", new Object[0]);
        }

        @Override // com.android.server.hdmi.HdmiCecController.NativeWrapper
        public int nativeGetHpdSignalType(int portId) {
            HdmiLogger.error("Failed to get HPD signal type: not supported by HAL.", new Object[0]);
            return 0;
        }

        public void serviceDied(long cookie) {
            if (cookie != 353) goto L8;
            HdmiLogger.error("Service died cookie : " + cookie + "; reconnecting", new Object[0]);
            connectToHal();
            if (this.mCallback == null) goto L9;
            setCallback(this.mCallback);
            return;
        L9:
            return;
        }

        @Override // android.hardware.tv.cec.V1_0.IHdmiCec.getPhysicalAddressCallback
        public void onValues(int result, short addr) {
            Object r0 = this.mLock;
            monitor-enter(r0);
            if (result != 0) goto L8;
            this.mPhysicalAddress = Short.toUnsignedInt(addr);     // Catch: Throwable -> L6
        L9:
            monitor-exit(r0);     // Catch: Throwable -> L6
            return;
        L8:
            this.mPhysicalAddress = 65535;     // Catch: Throwable -> L6
        L6:
            th = move-exception;
            throw th;
        }
    }

    private static final class NativeWrapperImpl11 implements NativeWrapper, IHwBinder.DeathRecipient, IHdmiCec.getPhysicalAddressCallback {
        private HdmiCecCallback mCallback;
        private android.hardware.tv.cec.V1_1.IHdmiCec mHdmiCec;
        private final Object mLock;
        private int mPhysicalAddress;

        /* synthetic */ NativeWrapperImpl11(HdmiCecControllerIA r1) {
            this();
        }

        private NativeWrapperImpl11() {
            this.mLock = new Object();
            this.mPhysicalAddress = 65535;
        }

        @Override // com.android.server.hdmi.HdmiCecController.NativeWrapper
        public String nativeInit() {
            if (connectToHal() == true) goto L7;
            return null;
        L7:
            return this.mHdmiCec.toString();
        }

        boolean connectToHal() {
            this.mHdmiCec = android.hardware.tv.cec.V1_1.IHdmiCec.getService(true);     // Catch: Throwable -> L6
            this.mHdmiCec.linkToDeath(this, 353);     // Catch: Throwable -> L6 RemoteException -> L8
        L11:
            return true;
        L8:
            e = move-exception;
            HdmiLogger.error("Couldn't link to death : ", e, new Object[0]);     // Catch: Throwable -> L6 Throwable -> L6
        L6:
            e = move-exception;
            HdmiLogger.error("Couldn't connect to cec@1.1", e, new Object[0]);
            return false;
        }

        @Override // android.hardware.tv.cec.V1_0.IHdmiCec.getPhysicalAddressCallback
        public void onValues(int result, short addr) {
            Object r0 = this.mLock;
            monitor-enter(r0);
            if (result != 0) goto L8;
            this.mPhysicalAddress = Short.toUnsignedInt(addr);     // Catch: Throwable -> L6
        L9:
            monitor-exit(r0);     // Catch: Throwable -> L6
            return;
        L8:
            this.mPhysicalAddress = 65535;     // Catch: Throwable -> L6
        L6:
            th = move-exception;
            throw th;
        }

        public void serviceDied(long cookie) {
            if (cookie != 353) goto L8;
            HdmiLogger.error("Service died cookie : " + cookie + "; reconnecting", new Object[0]);
            connectToHal();
            if (this.mCallback == null) goto L9;
            setCallback(this.mCallback);
            return;
        L9:
            return;
        }

        @Override // com.android.server.hdmi.HdmiCecController.NativeWrapper
        public void setCallback(HdmiCecCallback callback) {
            this.mCallback = callback;
            this.mHdmiCec.setCallback_1_1(new HdmiCecCallback11(callback));     // Catch: RemoteException -> L5
            return;
        L5:
            e = move-exception;
            HdmiLogger.error("Couldn't initialise tv.cec callback : ", e, new Object[0]);
        }

        @Override // com.android.server.hdmi.HdmiCecController.NativeWrapper
        public int nativeSendCecCommand(int srcAddress, int dstAddress, byte[] body) {
            android.hardware.tv.cec.V1_1.CecMessage message = new android.hardware.tv.cec.V1_1.CecMessage();
            message.initiator = srcAddress;
            message.destination = dstAddress;
            message.body = new ArrayList(body.length);
            int r1 = body.length;
            int r3 = 0;
        L3:
            if (r3 >= r1) goto L10;
            byte b = body[r3];
            message.body.add(Byte.valueOf(b));
            r3 = r3 + 1;
            goto L3
        L10:
            return this.mHdmiCec.sendMessage_1_1(message);
        L7:
            e = move-exception;
            HdmiLogger.error("Failed to send CEC message : ", e, new Object[0]);
            return 3;
        }

        @Override // com.android.server.hdmi.HdmiCecController.NativeWrapper
        public int nativeAddLogicalAddress(int logicalAddress) {
            return this.mHdmiCec.addLogicalAddress_1_1(logicalAddress);
        L4:
            e = move-exception;
            HdmiLogger.error("Failed to add a logical address : ", e, new Object[0]);
            return 2;
        }

        @Override // com.android.server.hdmi.HdmiCecController.NativeWrapper
        public void nativeClearLogicalAddress() {
            this.mHdmiCec.clearLogicalAddress();     // Catch: RemoteException -> L4
            return;
        L4:
            e = move-exception;
            HdmiLogger.error("Failed to clear logical address : ", e, new Object[0]);
        }

        @Override // com.android.server.hdmi.HdmiCecController.NativeWrapper
        public int nativeGetPhysicalAddress() {
            this.mHdmiCec.getPhysicalAddress(this);     // Catch: RemoteException -> L4
            return this.mPhysicalAddress;
        L4:
            e = move-exception;
            HdmiLogger.error("Failed to get physical address : ", e, new Object[0]);
            return 65535;
        }

        @Override // com.android.server.hdmi.HdmiCecController.NativeWrapper
        public int nativeGetVersion() {
            return this.mHdmiCec.getCecVersion();
        L4:
            e = move-exception;
            HdmiLogger.error("Failed to get cec version : ", e, new Object[0]);
            return 1;
        }

        @Override // com.android.server.hdmi.HdmiCecController.NativeWrapper
        public int nativeGetVendorId() {
            return this.mHdmiCec.getVendorId();
        L4:
            e = move-exception;
            HdmiLogger.error("Failed to get vendor id : ", e, new Object[0]);
            return 1;
        }

        @Override // com.android.server.hdmi.HdmiCecController.NativeWrapper
        public HdmiPortInfo[] nativeGetPortInfos() {
            ArrayList<android.hardware.tv.cec.V1_0.HdmiPortInfo> hdmiPortInfos = this.mHdmiCec.getPortInfo();     // Catch: RemoteException -> L8
            HdmiPortInfo[] hdmiPortInfo = new HdmiPortInfo[hdmiPortInfos.size()];     // Catch: RemoteException -> L8
            int i = 0;
            Iterator<android.hardware.tv.cec.V1_0.HdmiPortInfo> r4 = hdmiPortInfos.iterator();     // Catch: RemoteException -> L8
        L5:
            if (r4.hasNext() == false) goto L10;
            android.hardware.tv.cec.V1_0.HdmiPortInfo portInfo = r4.next();     // Catch: RemoteException -> L8
            hdmiPortInfo[i] = new HdmiPortInfo.Builder(portInfo.portId, portInfo.type, Short.toUnsignedInt(portInfo.physicalAddress)).setCecSupported(portInfo.cecSupported).setMhlSupported(false).setArcSupported(portInfo.arcSupported).setEarcSupported(false).build();     // Catch: RemoteException -> L8
            i = i + 1;
            goto L5
        L10:
            return hdmiPortInfo;
        L8:
            e = move-exception;
            HdmiLogger.error("Failed to get port information : ", e, new Object[0]);
            return null;
        }

        private void nativeSetOption(int flag, boolean enabled) {
            this.mHdmiCec.setOption(flag, enabled);     // Catch: RemoteException -> L4
            return;
        L4:
            e = move-exception;
            HdmiLogger.error("Failed to set option : ", e, new Object[0]);
        }

        @Override // com.android.server.hdmi.HdmiCecController.NativeWrapper
        public void enableWakeupByOtp(boolean enabled) {
            nativeSetOption(1, enabled);
        }

        @Override // com.android.server.hdmi.HdmiCecController.NativeWrapper
        public void enableCec(boolean enabled) {
            nativeSetOption(2, enabled);
        }

        @Override // com.android.server.hdmi.HdmiCecController.NativeWrapper
        public void enableSystemCecControl(boolean enabled) {
            nativeSetOption(3, enabled);
        }

        @Override // com.android.server.hdmi.HdmiCecController.NativeWrapper
        public void nativeSetLanguage(String language) {
            this.mHdmiCec.setLanguage(language);     // Catch: RemoteException -> L4
            return;
        L4:
            e = move-exception;
            HdmiLogger.error("Failed to set language : ", e, new Object[0]);
        }

        @Override // com.android.server.hdmi.HdmiCecController.NativeWrapper
        public void nativeEnableAudioReturnChannel(int port, boolean flag) {
            this.mHdmiCec.enableAudioReturnChannel(port, flag);     // Catch: RemoteException -> L4
            return;
        L4:
            e = move-exception;
            HdmiLogger.error("Failed to enable/disable ARC : ", e, new Object[0]);
        }

        @Override // com.android.server.hdmi.HdmiCecController.NativeWrapper
        public boolean nativeIsConnected(int port) {
            return this.mHdmiCec.isConnected(port);
        L4:
            e = move-exception;
            HdmiLogger.error("Failed to get connection info : ", e, new Object[0]);
            return false;
        }

        @Override // com.android.server.hdmi.HdmiCecController.NativeWrapper
        public void nativeSetHpdSignalType(int signal, int portId) {
            HdmiLogger.error("Failed to set HPD signal type: not supported by HAL.", new Object[0]);
        }

        @Override // com.android.server.hdmi.HdmiCecController.NativeWrapper
        public int nativeGetHpdSignalType(int portId) {
            HdmiLogger.error("Failed to get HPD signal type: not supported by HAL.", new Object[0]);
            return 0;
        }
    }

    private static final class NativeWrapperImplAidl implements NativeWrapper, IBinder.DeathRecipient {
        private HdmiCecCallback mCallback;
        private android.hardware.tv.hdmi.cec.IHdmiCec mHdmiCec;
        private IHdmiConnection mHdmiConnection;
        private final Object mLock;

        /* synthetic */ NativeWrapperImplAidl(HdmiCecControllerIA r1) {
            this();
        }

        private NativeWrapperImplAidl() {
            this.mLock = new Object();
        }

        @Override // com.android.server.hdmi.HdmiCecController.NativeWrapper
        public String nativeInit() {
            if (connectToHal() == true) goto L7;
            return null;
        L7:
            return this.mHdmiCec.toString() + " " + this.mHdmiConnection.toString();
        }

        boolean connectToHal() {
            this.mHdmiCec = android.hardware.tv.hdmi.cec.IHdmiCec.Stub.asInterface(ServiceManager.getService(android.hardware.tv.hdmi.cec.IHdmiCec.DESCRIPTOR + "/default"));
            if (this.mHdmiCec != null) goto L22;
            HdmiLogger.error("Could not initialize HDMI CEC AIDL HAL", new Object[0]);
            return false;
        L22:
            this.mHdmiCec.asBinder().linkToDeath(this, 0);     // Catch: RemoteException -> L8
        L10:
            this.mHdmiConnection = IHdmiConnection.Stub.asInterface(ServiceManager.getService(IHdmiConnection.DESCRIPTOR + "/default"));
            if (this.mHdmiConnection != null) goto L20;
            HdmiLogger.error("Could not initialize HDMI Connection AIDL HAL", new Object[0]);
            return false;
        L20:
            this.mHdmiConnection.asBinder().linkToDeath(this, 0);     // Catch: RemoteException -> L16
            return true;
        L16:
            e = move-exception;
            HdmiLogger.error("Couldn't link to death : ", e, new Object[0]);
            return true;
        L8:
            e = move-exception;
            HdmiLogger.error("Couldn't link to death : ", e, new Object[0]);
            goto L10
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            this.mHdmiCec.asBinder().unlinkToDeath(this, 0);
            this.mHdmiConnection.asBinder().unlinkToDeath(this, 0);
            HdmiLogger.error("HDMI Connection or CEC service died, reconnecting", new Object[0]);
            connectToHal();
            if (this.mCallback == null) goto L6;
            setCallback(this.mCallback);
            return;
        }

        @Override // com.android.server.hdmi.HdmiCecController.NativeWrapper
        public void setCallback(HdmiCecCallback callback) {
            this.mCallback = callback;
            this.mHdmiCec.setCallback(new HdmiCecCallbackAidl(callback));     // Catch: RemoteException -> L5
        L12:
            this.mHdmiConnection.setCallback(new HdmiConnectionCallbackAidl(callback));     // Catch: Throwable -> L9
            return;
        L9:
            e = move-exception;
            HdmiLogger.error("Couldn't initialise tv.hdmi callback : ", e, new Object[0]);
            return;
        L5:
            e = move-exception;
            HdmiLogger.error("Couldn't initialise tv.cec callback : ", e, new Object[0]);
            goto L12
        }

        @Override // com.android.server.hdmi.HdmiCecController.NativeWrapper
        public int nativeSendCecCommand(int srcAddress, int dstAddress, byte[] body) {
            android.hardware.tv.hdmi.cec.CecMessage message = new android.hardware.tv.hdmi.cec.CecMessage();
            message.initiator = (byte) (srcAddress & 15);
            message.destination = (byte) (dstAddress & 15);
            message.body = body;
            return this.mHdmiCec.sendMessage(message);
        L5:
            e = move-exception;
            HdmiLogger.error("Failed to send CEC message : ", e, new Object[0]);
            return 3;
        }

        @Override // com.android.server.hdmi.HdmiCecController.NativeWrapper
        public int nativeAddLogicalAddress(int logicalAddress) {
            return this.mHdmiCec.addLogicalAddress((byte) logicalAddress);
        L4:
            e = move-exception;
            HdmiLogger.error("Failed to add a logical address : ", e, new Object[0]);
            return 2;
        }

        @Override // com.android.server.hdmi.HdmiCecController.NativeWrapper
        public void nativeClearLogicalAddress() {
            this.mHdmiCec.clearLogicalAddress();     // Catch: RemoteException -> L4
            return;
        L4:
            e = move-exception;
            HdmiLogger.error("Failed to clear logical address : ", e, new Object[0]);
        }

        @Override // com.android.server.hdmi.HdmiCecController.NativeWrapper
        public int nativeGetPhysicalAddress() {
            return this.mHdmiCec.getPhysicalAddress();
        L4:
            e = move-exception;
            HdmiLogger.error("Failed to get physical address : ", e, new Object[0]);
            return 65535;
        }

        @Override // com.android.server.hdmi.HdmiCecController.NativeWrapper
        public int nativeGetVersion() {
            return this.mHdmiCec.getCecVersion();
        L4:
            e = move-exception;
            HdmiLogger.error("Failed to get cec version : ", e, new Object[0]);
            return 1;
        }

        @Override // com.android.server.hdmi.HdmiCecController.NativeWrapper
        public int nativeGetVendorId() {
            return this.mHdmiCec.getVendorId();
        L4:
            e = move-exception;
            HdmiLogger.error("Failed to get vendor id : ", e, new Object[0]);
            return 1;
        }

        @Override // com.android.server.hdmi.HdmiCecController.NativeWrapper
        public void enableWakeupByOtp(boolean enabled) {
            this.mHdmiCec.enableWakeupByOtp(enabled);     // Catch: RemoteException -> L4
            return;
        L4:
            e = move-exception;
            HdmiLogger.error("Failed call to enableWakeupByOtp : ", e, new Object[0]);
        }

        @Override // com.android.server.hdmi.HdmiCecController.NativeWrapper
        public void enableCec(boolean enabled) {
            this.mHdmiCec.enableCec(enabled);     // Catch: RemoteException -> L4
            return;
        L4:
            e = move-exception;
            HdmiLogger.error("Failed call to enableCec : ", e, new Object[0]);
        }

        @Override // com.android.server.hdmi.HdmiCecController.NativeWrapper
        public void enableSystemCecControl(boolean enabled) {
            this.mHdmiCec.enableSystemCecControl(enabled);     // Catch: RemoteException -> L4
            return;
        L4:
            e = move-exception;
            HdmiLogger.error("Failed call to enableSystemCecControl : ", e, new Object[0]);
        }

        @Override // com.android.server.hdmi.HdmiCecController.NativeWrapper
        public void nativeSetLanguage(String language) {
            this.mHdmiCec.setLanguage(language);     // Catch: RemoteException -> L4
            return;
        L4:
            e = move-exception;
            HdmiLogger.error("Failed to set language : ", e, new Object[0]);
        }

        @Override // com.android.server.hdmi.HdmiCecController.NativeWrapper
        public void nativeEnableAudioReturnChannel(int port, boolean flag) {
            this.mHdmiCec.enableAudioReturnChannel(port, flag);     // Catch: RemoteException -> L4
            return;
        L4:
            e = move-exception;
            HdmiLogger.error("Failed to enable/disable ARC : ", e, new Object[0]);
        }

        @Override // com.android.server.hdmi.HdmiCecController.NativeWrapper
        public HdmiPortInfo[] nativeGetPortInfos() {
            android.hardware.tv.hdmi.connection.HdmiPortInfo[] hdmiPortInfos = this.mHdmiConnection.getPortInfo();     // Catch: Throwable -> L7
            HdmiPortInfo[] hdmiPortInfo = new HdmiPortInfo[hdmiPortInfos.length];     // Catch: Throwable -> L7
            int i = 0;
            int r4 = hdmiPortInfos.length;     // Catch: Throwable -> L7
            int r5 = 0;
        L4:
            if (r5 >= r4) goto L9;
            android.hardware.tv.hdmi.connection.HdmiPortInfo portInfo = hdmiPortInfos[r5];     // Catch: Throwable -> L7
            hdmiPortInfo[i] = new HdmiPortInfo.Builder(portInfo.portId, portInfo.type, portInfo.physicalAddress).setCecSupported(portInfo.cecSupported).setMhlSupported(false).setArcSupported(portInfo.arcSupported).setEarcSupported(portInfo.eArcSupported).build();     // Catch: Throwable -> L7
            i = i + 1;
            r5 = r5 + 1;
            goto L4
        L9:
            return hdmiPortInfo;
        L7:
            e = move-exception;
            HdmiLogger.error("Failed to get port information : ", e, new Object[0]);
            return null;
        }

        @Override // com.android.server.hdmi.HdmiCecController.NativeWrapper
        public boolean nativeIsConnected(int port) {
            return this.mHdmiConnection.isConnected(port);
        L4:
            e = move-exception;
            HdmiLogger.error("Failed to get connection info : ", e, new Object[0]);
            return false;
        }

        @Override // com.android.server.hdmi.HdmiCecController.NativeWrapper
        public void nativeSetHpdSignalType(int signal, int portId) {
            this.mHdmiConnection.setHpdSignal((byte) signal, portId);     // Catch: Throwable -> L5 ServiceSpecificException -> L7
        L14:
            return;
        L7:
            sse = move-exception;
            HdmiLogger.error("Could not set HPD signal type for portId " + portId + " to " + signal + ". Error: ", new Object[]{Integer.valueOf(sse.errorCode)});
            return;
        L5:
            e = move-exception;
            HdmiLogger.error("Could not set HPD signal type for portId " + portId + " to " + signal + ". Exception: ", e, new Object[0]);
        }

        @Override // com.android.server.hdmi.HdmiCecController.NativeWrapper
        public int nativeGetHpdSignalType(int portId) {
            return this.mHdmiConnection.getHpdSignal(portId);
        L4:
            e = move-exception;
            HdmiLogger.error("Could not get HPD signal type for portId " + portId + ". Exception: ", e, new Object[0]);
            return 0;
        }
    }

    public static /* synthetic */ void $r8$lambda$tdLKXEjHPp_1RAsHvqBRm0azGJ4(HdmiCecController r0, int r1, List r2, int r3, HdmiControlService.DevicePollingCallback r4, ArrayList r5, long r6) {
        r0.lambda$pollDevices$0(r1, r2, r3, r4, r5, r6);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmHdmiCecAtomWriter, reason: not valid java name */
    static /* bridge */ /* synthetic */ HdmiCecAtomWriter m4277$$Nest$fgetmHdmiCecAtomWriter(HdmiCecController r0) {
        return r0.mHdmiCecAtomWriter;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmNativeWrapperImpl, reason: not valid java name */
    static /* bridge */ /* synthetic */ NativeWrapper m4278$$Nest$fgetmNativeWrapperImpl(HdmiCecController r0) {
        return r0.mNativeWrapperImpl;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmService, reason: not valid java name */
    static /* bridge */ /* synthetic */ HdmiControlService m4279$$Nest$fgetmService(HdmiCecController r0) {
        return r0.mService;
    }

    /* JADX INFO: renamed from: -$$Nest$mgetCallingUid, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m4280$$Nest$mgetCallingUid(HdmiCecController r0) {
        return r0.getCallingUid();
    }

    /* JADX INFO: renamed from: -$$Nest$mhandleAllocateLogicalAddress, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4281$$Nest$mhandleAllocateLogicalAddress(HdmiCecController r0, int r1, int r2, AllocateAddressCallback r3) {
        r0.handleAllocateLogicalAddress(r1, r2, r3);
    }

    /* JADX INFO: renamed from: -$$Nest$mhandleHotplug, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4282$$Nest$mhandleHotplug(HdmiCecController r0, int r1, boolean r2) {
        r0.handleHotplug(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mhandleIncomingCecCommand, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4283$$Nest$mhandleIncomingCecCommand(HdmiCecController r0, int r1, int r2, byte[] r3) {
        r0.handleIncomingCecCommand(r1, r2, r3);
    }

    /* JADX INFO: renamed from: -$$Nest$mrunDevicePolling, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4284$$Nest$mrunDevicePolling(HdmiCecController r0, int r1, List r2, int r3, HdmiControlService.DevicePollingCallback r4, List r5, long r6, boolean r8) {
        r0.runDevicePolling(r1, r2, r3, r4, r5, r6, r8);
    }

    /* JADX INFO: renamed from: -$$Nest$msendPollMessage, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m4285$$Nest$msendPollMessage(HdmiCecController r0, int r1, int r2, int r3) {
        return r0.sendPollMessage(r1, r2, r3);
    }

    /* JADX INFO: renamed from: -$$Nest$smbuildBody, reason: not valid java name */
    static /* bridge */ /* synthetic */ byte[] m4286$$Nest$smbuildBody(int r0, byte[] r1) {
        return buildBody(r0, r1);
    }

    static {
        EMPTY_BODY = EmptyArray.BYTE;
    }

    private HdmiCecController(HdmiControlService service, NativeWrapper nativeWrapper, HdmiCecAtomWriter atomWriter) {
        this.mRemoteDeviceAddressPredicate = new AnonymousClass1(this);
        this.mSystemAudioAddressPredicate = new AnonymousClass2(this);
        this.mMessageHistory = new ArrayBlockingQueue(250);
        this.mMessageHistoryLock = new Object();
        this.mLogicalAddressAllocationDelay = 0;
        this.mPollDevicesDelay = 0;
        this.mService = service;
        this.mNativeWrapperImpl = nativeWrapper;
        this.mHdmiCecAtomWriter = atomWriter;
    }

    static HdmiCecController create(HdmiControlService service, HdmiCecAtomWriter atomWriter) {
        HdmiCecControllerIA r1 = null;
        HdmiCecController controller = createWithNativeWrapper(service, new NativeWrapperImplAidl(r1), atomWriter);
        if (controller == null) goto L5;
        return controller;
    L5:
        HdmiLogger.warning("Unable to use CEC and HDMI Connection AIDL HALs", new Object[0]);
        HdmiCecController controller2 = createWithNativeWrapper(service, new NativeWrapperImpl11(r1), atomWriter);
        if (controller2 == null) goto L8;
        return controller2;
    L8:
        HdmiLogger.warning("Unable to use cec@1.1", new Object[0]);
        return createWithNativeWrapper(service, new NativeWrapperImpl(r1), atomWriter);
    }

    static HdmiCecController createWithNativeWrapper(HdmiControlService service, NativeWrapper nativeWrapper, HdmiCecAtomWriter atomWriter) {
        HdmiCecController controller = new HdmiCecController(service, nativeWrapper, atomWriter);
        String nativePtr = nativeWrapper.nativeInit();
        if (nativePtr != null) goto L6;
        HdmiLogger.warning("Couldn't get tv.cec service.", new Object[0]);
        return null;
    L6:
        controller.init(nativeWrapper);
        return controller;
    }

    private void init(NativeWrapper nativeWrapper) {
        this.mIoHandler = new Handler(this.mService.getIoLooper());
        this.mControlHandler = new Handler(this.mService.getServiceLooper());
        nativeWrapper.setCallback(new HdmiCecCallback(this));
    }

    @HdmiAnnotations.ServiceThreadOnly
    void allocateLogicalAddress(final int deviceType, final int preferredAddress, final AllocateAddressCallback callback) {
        assertRunOnServiceThread();
        this.mIoHandler.postDelayed(new AnonymousClass3(this, deviceType, preferredAddress, callback), this.mLogicalAddressAllocationDelay);
    }

    @HdmiAnnotations.IoThreadOnly
    private void handleAllocateLogicalAddress(final int deviceType, int preferredAddress, final AllocateAddressCallback callback) {
        assertRunOnIoThread();
        List<Integer> logicalAddressesToPoll = new ArrayList();
        if (HdmiUtils.isEligibleAddressForDevice(deviceType, preferredAddress) == false) goto L5;
        logicalAddressesToPoll.add(Integer.valueOf(preferredAddress));
    L5:
        int i = 0;
    L7:
        if (i >= 16) goto L16;
        if (logicalAddressesToPoll.contains(Integer.valueOf(i)) == true) goto L15;
        if (HdmiUtils.isEligibleAddressForDevice(deviceType, i) == false) goto L15;
        if (HdmiUtils.isEligibleAddressForCecVersion(this.mService.getCecVersion(), i) == false) goto L15;
        logicalAddressesToPoll.add(Integer.valueOf(i));
    L15:
        i = i + 1;
        goto L7
    L16:
        int logicalAddress = 15;
        Iterator<Integer> r2 = logicalAddressesToPoll.iterator();
    L18:
        if (r2.hasNext() == false) goto L29;
        Integer logicalAddressToPoll = r2.next();
        boolean acked = false;
        int j = 0;
    L21:
        if (j >= 3) goto L26;
        if (sendPollMessage(logicalAddressToPoll.intValue(), logicalAddressToPoll.intValue(), 1) == true) goto L24;
        j = j + 1;
        goto L21
    L24:
        acked = true;
    L26:
        if (acked == true) goto L18;
        logicalAddress = logicalAddressToPoll.intValue();
    L29:
        final int assignedAddress = logicalAddress;
        HdmiLogger.debug("New logical address for device [%d]: [preferred:%d, assigned:%d]", new Object[]{Integer.valueOf(deviceType), Integer.valueOf(preferredAddress), Integer.valueOf(assignedAddress)});
        if (callback == null) goto L44;
        runOnServiceThread(new AnonymousClass4(this, callback, deviceType, assignedAddress));
        return;
    }

    private static byte[] buildBody(int opcode, byte[] params) {
        byte[] body = new byte[params.length + 1];
        body[0] = (byte) opcode;
        System.arraycopy(params, 0, body, 1, params.length);
        return body;
    }

    HdmiPortInfo[] getPortInfos() {
        return this.mNativeWrapperImpl.nativeGetPortInfos();
    }

    @HdmiAnnotations.ServiceThreadOnly
    int addLogicalAddress(int newLogicalAddress) {
        assertRunOnServiceThread();
        if (HdmiUtils.isValidAddress(newLogicalAddress) == true) goto L5;
        return 2;
    L5:
        return this.mNativeWrapperImpl.nativeAddLogicalAddress(newLogicalAddress);
    }

    @HdmiAnnotations.ServiceThreadOnly
    void clearLogicalAddress() {
        assertRunOnServiceThread();
        this.mNativeWrapperImpl.nativeClearLogicalAddress();
    }

    @HdmiAnnotations.ServiceThreadOnly
    int getPhysicalAddress() {
        assertRunOnServiceThread();
        return this.mNativeWrapperImpl.nativeGetPhysicalAddress();
    }

    @HdmiAnnotations.ServiceThreadOnly
    int getVersion() {
        assertRunOnServiceThread();
        return this.mNativeWrapperImpl.nativeGetVersion();
    }

    @HdmiAnnotations.ServiceThreadOnly
    int getVendorId() {
        assertRunOnServiceThread();
        return this.mNativeWrapperImpl.nativeGetVendorId();
    }

    @HdmiAnnotations.ServiceThreadOnly
    void enableWakeupByOtp(boolean enabled) {
        assertRunOnServiceThread();
        HdmiLogger.debug("enableWakeupByOtp: %b", new Object[]{Boolean.valueOf(enabled)});
        this.mNativeWrapperImpl.enableWakeupByOtp(enabled);
    }

    @HdmiAnnotations.ServiceThreadOnly
    void enableCec(boolean enabled) {
        assertRunOnServiceThread();
        HdmiLogger.debug("enableCec: %b", new Object[]{Boolean.valueOf(enabled)});
        this.mNativeWrapperImpl.enableCec(enabled);
    }

    @HdmiAnnotations.ServiceThreadOnly
    void enableSystemCecControl(boolean enabled) {
        assertRunOnServiceThread();
        HdmiLogger.debug("enableSystemCecControl: %b", new Object[]{Boolean.valueOf(enabled)});
        this.mNativeWrapperImpl.enableSystemCecControl(enabled);
    }

    @HdmiAnnotations.ServiceThreadOnly
    void setHpdSignalType(int signal, int portId) {
        assertRunOnServiceThread();
        HdmiLogger.debug("setHpdSignalType: portId %d, signal %d", new Object[]{Integer.valueOf(portId), Integer.valueOf(signal)});
        this.mNativeWrapperImpl.nativeSetHpdSignalType(signal, portId);
    }

    @HdmiAnnotations.ServiceThreadOnly
    int getHpdSignalType(int portId) {
        assertRunOnServiceThread();
        HdmiLogger.debug("getHpdSignalType: portId %d ", new Object[]{Integer.valueOf(portId)});
        return this.mNativeWrapperImpl.nativeGetHpdSignalType(portId);
    }

    @HdmiAnnotations.ServiceThreadOnly
    void setLanguage(String language) {
        assertRunOnServiceThread();
        if (isLanguage(language) == true) goto L5;
        return;
    L5:
        this.mNativeWrapperImpl.nativeSetLanguage(language);
    }

    void setLogicalAddressAllocationDelay(long delay) {
        this.mLogicalAddressAllocationDelay = delay;
    }

    void setPollDevicesDelay(long delay) {
        this.mPollDevicesDelay = delay;
    }

    static boolean isLanguage(String language) {
        if (language != null) goto L5;
    L13:
        return false;
    L5:
        if (language.isEmpty() == true) goto L13;
        ULocale.Builder builder = new ULocale.Builder();
        builder.setLanguage(language);     // Catch: IllformedLocaleException -> L11
        return true;
    L12:
        return false;
    }

    @HdmiAnnotations.ServiceThreadOnly
    void enableAudioReturnChannel(int port, boolean enabled) {
        assertRunOnServiceThread();
        this.mNativeWrapperImpl.nativeEnableAudioReturnChannel(port, enabled);
    }

    @HdmiAnnotations.ServiceThreadOnly
    boolean isConnected(int port) {
        assertRunOnServiceThread();
        return this.mNativeWrapperImpl.nativeIsConnected(port);
    }

    @HdmiAnnotations.ServiceThreadOnly
    void pollDevices(final HdmiControlService.DevicePollingCallback callback, final int sourceAddress, int pickStrategy, final int retryCount, final long pollingMessageInterval) {
        assertRunOnServiceThread();
        final List<Integer> pollingCandidates = pickPollCandidates(pickStrategy);
        final ArrayList<Integer> allocated = new ArrayList();
        this.mControlHandler.postDelayed(new HdmiCecController$$ExternalSyntheticLambda0(this, sourceAddress, pollingCandidates, retryCount, callback, allocated, pollingMessageInterval), this.mPollDevicesDelay);
    }

    private /* synthetic */ void lambda$pollDevices$0(int sourceAddress, List pollingCandidates, int retryCount, HdmiControlService.DevicePollingCallback callback, ArrayList allocated, long pollingMessageInterval) {
        runDevicePolling(sourceAddress, pollingCandidates, retryCount, callback, allocated, pollingMessageInterval, false);
    }

    private List<Integer> pickPollCandidates(int pickStrategy) {
        int strategy = pickStrategy & 3;
        switch(strategy) {
            case 2: goto L5;
            default: goto L4;
        };
    L4:
        Predicate<Integer> pickPredicate = this.mRemoteDeviceAddressPredicate;
    L6:
        int iterationStrategy = 196608 & pickStrategy;
        ArrayList<Integer> pollingCandidates = new ArrayList();
        switch(iterationStrategy) {
            case 65536: goto L14;
            default: goto L8;
        };
    L8:
        int i = 14;
    L9:
        if (i < 0) goto L22;
        if (pickPredicate.test(Integer.valueOf(i)) == false) goto L13;
        pollingCandidates.add(Integer.valueOf(i));
    L13:
        i = i - 1;
    L22:
        return pollingCandidates;
    L14:
        int i2 = 0;
    L16:
        if (i2 > 14) goto L22;
        if (pickPredicate.test(Integer.valueOf(i2)) == false) goto L20;
        pollingCandidates.add(Integer.valueOf(i2));
    L20:
        i2 = i2 + 1;
        goto L16
    L5:
        pickPredicate = this.mSystemAudioAddressPredicate;
        goto L6
    }

    @HdmiAnnotations.ServiceThreadOnly
    private void runDevicePolling(final int sourceAddress, final List<Integer> candidates, final int retryCount, final HdmiControlService.DevicePollingCallback callback, final List<Integer> allocated, final long pollingMessageInterval, boolean pollStarted) {
        assertRunOnServiceThread();
        if (candidates.isEmpty() == false) goto L7;
        if (callback == null) goto L13;
        HdmiLogger.debug("[P]:AllocatedAddress=%s", new Object[]{allocated.toString()});
        callback.onPollingFinished(allocated);
        return;
    L13:
        return;
    L7:
        final Integer candidate = candidates.remove(0);
        Handler r0 = this.mIoHandler;
        Runnable r1 = new AnonymousClass5(this, sourceAddress, candidate, retryCount, allocated, candidates, callback, pollingMessageInterval);
        if (pollStarted == false) goto L10;
        long r2 = pollingMessageInterval;
    L11:
        r0.postDelayed(r1, r2);
        return;
    L10:
        r2 = 0;
        goto L11
    }

    @HdmiAnnotations.IoThreadOnly
    private boolean sendPollMessage(int sourceAddress, int destinationAddress, int retryCount) {
        assertRunOnIoThread();
        int i = 0;
    L3:
        if (i >= retryCount) goto L10;
        int ret = this.mNativeWrapperImpl.nativeSendCecCommand(sourceAddress, destinationAddress, EMPTY_BODY);
        if (ret == 0) goto L6;
        if (ret == 1) goto L9;
        HdmiLogger.warning("Failed to send a polling message(%d->%d) with return code %d", new Object[]{Integer.valueOf(sourceAddress), Integer.valueOf(destinationAddress), Integer.valueOf(ret)});
    L9:
        i = i + 1;
        goto L3
    L6:
        return true;
    L10:
        return false;
    }

    private void assertRunOnIoThread() {
        if (Looper.myLooper() != this.mIoHandler.getLooper()) goto L6;
        return;
    L6:
        throw new IllegalStateException("Should run on io thread.");
    }

    private void assertRunOnServiceThread() {
        if (Looper.myLooper() != this.mControlHandler.getLooper()) goto L6;
        return;
    L6:
        throw new IllegalStateException("Should run on service thread.");
    }

    void runOnIoThread(Runnable runnable) {
        this.mIoHandler.post(new WorkSourceUidPreservingRunnable(runnable));
    }

    void runOnServiceThread(Runnable runnable) {
        this.mControlHandler.post(new WorkSourceUidPreservingRunnable(runnable));
    }

    @HdmiAnnotations.ServiceThreadOnly
    void flush(final Runnable runnable) {
        assertRunOnServiceThread();
        runOnIoThread(new AnonymousClass6(this, runnable));
    }

    private boolean isAcceptableAddress(int address) {
        if (address != 15) goto L7;
        return true;
    L7:
        return this.mService.getHdmiCecNetwork().isAllocatedLocalDeviceAddress(address);
    }

    @HdmiAnnotations.ServiceThreadOnly
    void onReceiveCommand(HdmiCecMessage message) {
        assertRunOnServiceThread();
        if (this.mService.isCecControlEnabled() == true) goto L8;
        if (HdmiCecMessage.isCecTransportMessage(message.getOpcode()) == true) goto L8;
        HdmiLogger.warning("Message " + message + " received when cec disabled", new Object[0]);
    L8:
        if (this.mService.isAddressAllocated() == true) goto L10;
    L12:
        int messageState = this.mService.handleCecCommand(message);
        if (messageState != (-2)) goto L16;
        maySendFeatureAbortCommand(message, 0);
        return;
    L16:
        if (messageState == (-1)) goto L20;
        maySendFeatureAbortCommand(message, messageState);
        return;
    L20:
        return;
    L10:
        if (isAcceptableAddress(message.getDestination()) == true) goto L12;
    }

    @HdmiAnnotations.ServiceThreadOnly
    void maySendFeatureAbortCommand(HdmiCecMessage message, int reason) {
        assertRunOnServiceThread();
        int src = message.getDestination();
        int dest = message.getSource();
        if (src == 15) goto L11;
        if (dest == 15) goto L12;
        int originalOpcode = message.getOpcode();
        if (originalOpcode != 0) goto L9;
        return;
    L9:
        sendCommand(HdmiCecMessageBuilder.buildFeatureAbortCommand(src, dest, originalOpcode, reason));
        return;
    L12:
        return;
    }

    @HdmiAnnotations.ServiceThreadOnly
    void sendCommand(HdmiCecMessage cecMessage) {
        assertRunOnServiceThread();
        sendCommand(cecMessage, null);
    }

    private int getCallingUid() {
        int workSourceUid = Binder.getCallingWorkSourceUid();
        if (workSourceUid == (-1)) goto L5;
        return workSourceUid;
    L5:
        return Binder.getCallingUid();
    }

    @HdmiAnnotations.ServiceThreadOnly
    void sendCommand(final HdmiCecMessage cecMessage, final HdmiControlService.SendMessageCallback callback) {
        assertRunOnServiceThread();
        final List<String> sendResults = new ArrayList();
        runOnIoThread(new AnonymousClass7(this, cecMessage, sendResults, callback));
        addCecMessageToHistory(false, cecMessage, sendResults);
    }

    @HdmiAnnotations.ServiceThreadOnly
    private void handleIncomingCecCommand(int srcAddress, int dstAddress, byte[] body) {
        assertRunOnServiceThread();
        if (body.length != 0) goto L6;
        Slog.e(TAG, "Message with empty body received.");
        return;
    L6:
        HdmiCecMessage command = HdmiCecMessage.build(srcAddress, dstAddress, body[0], Arrays.copyOfRange(body, 1, body.length));
        if (command.getValidationResult() == 0) goto L9;
        Slog.e(TAG, "Invalid message received: " + command);
    L9:
        HdmiLogger.debug("[R]:" + command, new Object[0]);
        addCecMessageToHistory(true, command, null);
        this.mHdmiCecAtomWriter.messageReported(command, incomingMessageDirection(srcAddress, dstAddress), getCallingUid());
        onReceiveCommand(command);
    }

    private int incomingMessageDirection(int srcAddress, int dstAddress) {
        boolean sourceIsLocal = false;
        if (dstAddress != 15) goto L5;
        boolean destinationIsLocal = true;
    L6:
        Iterator<HdmiCecLocalDevice> r3 = this.mService.getHdmiCecNetwork().getLocalDeviceList().iterator();
    L8:
        if (r3.hasNext() == false) goto L15;
        HdmiCecLocalDevice localDevice = r3.next();
        int logicalAddress = localDevice.getDeviceInfo().getLogicalAddress();
        if (logicalAddress != srcAddress) goto L12;
        sourceIsLocal = true;
    L12:
        if (logicalAddress != dstAddress) goto L8;
        destinationIsLocal = true;
        goto L8
    L15:
        if (sourceIsLocal == true) goto L19;
        if (destinationIsLocal == false) goto L19;
        return 3;
    L19:
        if (sourceIsLocal == false) goto L23;
        if (destinationIsLocal == false) goto L23;
        return 4;
    L23:
        return 1;
    L5:
        destinationIsLocal = false;
        goto L6
    }

    @HdmiAnnotations.ServiceThreadOnly
    private void handleHotplug(int port, boolean connected) {
        assertRunOnServiceThread();
        HdmiLogger.debug("Hotplug event:[port:%d, connected:%b]", new Object[]{Integer.valueOf(port), Boolean.valueOf(connected)});
        addHotplugEventToHistory(port, connected);
        this.mService.onHotplug(port, connected);
    }

    @HdmiAnnotations.ServiceThreadOnly
    private void addHotplugEventToHistory(int port, boolean connected) {
        assertRunOnServiceThread();
        addEventToHistory(new HotplugHistoryRecord(port, connected));
    }

    @HdmiAnnotations.ServiceThreadOnly
    private void addCecMessageToHistory(boolean isReceived, HdmiCecMessage message, List<String> sendResults) {
        assertRunOnServiceThread();
        addEventToHistory(new MessageHistoryRecord(isReceived, message, sendResults));
    }

    private void addEventToHistory(Dumpable event) {
        Object r0 = this.mMessageHistoryLock;
        monitor-enter(r0);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (this.mMessageHistory.offer(event) == true) goto L9;
        this.mMessageHistory.poll();     // Catch: Throwable -> L7
        this.mMessageHistory.offer(event);     // Catch: Throwable -> L7
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L7
    }

    int getMessageHistorySize() {
        Object r0 = this.mMessageHistoryLock;
        monitor-enter(r0);
        int r1 = this.mMessageHistory.size() + this.mMessageHistory.remainingCapacity();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    boolean setMessageHistorySize(int newSize) {
        if (newSize >= 250) goto L6;
        return false;
    L6:
        ArrayBlockingQueue<Dumpable> newMessageHistory = new ArrayBlockingQueue(newSize);
        Object r1 = this.mMessageHistoryLock;
        monitor-enter(r1);
    L14:
        th = move-exception;
        throw th;
    L9:
        if (newSize >= this.mMessageHistory.size()) goto L16;
        int i = 0;
    L12:
        if (i >= (this.mMessageHistory.size() - newSize)) goto L16;
        this.mMessageHistory.poll();     // Catch: Throwable -> L14
        i = i + 1;     // Catch: Throwable -> L14
    L16:
        newMessageHistory.addAll(this.mMessageHistory);     // Catch: Throwable -> L14
        this.mMessageHistory = newMessageHistory;     // Catch: Throwable -> L14
        monitor-exit(r1);     // Catch: Throwable -> L14
        return true;
    }

    void dump(IndentingPrintWriter pw) {
        pw.println("CEC message history:");
        pw.increaseIndent();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Iterator<Dumpable> r1 = this.mMessageHistory.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        Dumpable record = r1.next();
        record.dump(pw, sdf);
        goto L4
    L6:
        pw.decreaseIndent();
    }
}
