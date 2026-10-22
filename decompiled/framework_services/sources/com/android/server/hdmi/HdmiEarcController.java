package com.android.server.hdmi;

import android.hardware.tv.hdmi.earc.IEArc;
import android.hardware.tv.hdmi.earc.IEArcCallback;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.os.ServiceSpecificException;

/* JADX INFO: loaded from: classes2.dex */
final class HdmiEarcController {
    private static final String TAG = "HdmiEarcController";
    private Handler mControlHandler;
    private EarcNativeWrapper mEarcNativeWrapperImpl;
    private final HdmiControlService mService;

    final class EarcAidlCallback extends IEArcCallback.Stub {
        final /* synthetic */ HdmiEarcController this$0;

        public static /* synthetic */ void $r8$lambda$8vjd6gbVvZl0hxTNM9b_Uqcoh9U(EarcAidlCallback r0, byte[] r1, int r2) {
            r0.lambda$onCapabilitiesReported$1(r1, r2);
        }

        public static /* synthetic */ void $r8$lambda$vhYwqByGtnoO73BiDrSvktyH_xU(EarcAidlCallback r0, byte r1, int r2) {
            r0.lambda$onStateChange$0(r1, r2);
        }

        EarcAidlCallback(HdmiEarcController this$0) {
            this.this$0 = this$0;
        }

        @Override // android.hardware.tv.hdmi.earc.IEArcCallback
        public void onStateChange(final byte status, final int portId) {
            this.this$0.runOnServiceThread(new HdmiEarcController$EarcAidlCallback$$ExternalSyntheticLambda0(this, status, portId));
        }

        private /* synthetic */ void lambda$onStateChange$0(byte status, int portId) {
            HdmiEarcController.m4421$$Nest$fgetmService(this.this$0).handleEarcStateChange(status, portId);
        }

        @Override // android.hardware.tv.hdmi.earc.IEArcCallback
        public void onCapabilitiesReported(final byte[] rawCapabilities, final int portId) {
            this.this$0.runOnServiceThread(new HdmiEarcController$EarcAidlCallback$$ExternalSyntheticLambda1(this, rawCapabilities, portId));
        }

        private /* synthetic */ void lambda$onCapabilitiesReported$1(byte[] rawCapabilities, int portId) {
            HdmiEarcController.m4421$$Nest$fgetmService(this.this$0).handleEarcCapabilitiesReported(rawCapabilities, portId);
        }

        /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
        @Override // android.hardware.tv.hdmi.earc.IEArcCallback
        public synchronized String getInterfaceHash() throws RemoteException {
            monitor-enter(this);
            monitor-exit(this);
            return "101230f18c7b8438921e517e80eea4ccc7c1e463";
        }

        @Override // android.hardware.tv.hdmi.earc.IEArcCallback
        public int getInterfaceVersion() throws RemoteException {
            return 1;
        }
    }

    protected interface EarcNativeWrapper {
        byte[] nativeGetLastReportedAudioCapabilities(int r1);

        byte nativeGetState(int r1);

        boolean nativeInit();

        boolean nativeIsEarcEnabled();

        void nativeSetCallback(EarcAidlCallback r1);

        void nativeSetEarcEnabled(boolean r1);
    }

    private static final class EarcNativeWrapperImpl implements EarcNativeWrapper, IBinder.DeathRecipient {
        private IEArc mEarc;
        private EarcAidlCallback mEarcCallback;

        /* synthetic */ EarcNativeWrapperImpl(HdmiEarcControllerIA r1) {
            this();
        }

        private EarcNativeWrapperImpl() {
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            this.mEarc.asBinder().unlinkToDeath(this, 0);
            connectToHal();
            if (this.mEarcCallback == null) goto L6;
            nativeSetCallback(this.mEarcCallback);
            return;
        }

        boolean connectToHal() {
            this.mEarc = IEArc.Stub.asInterface(ServiceManager.getService(IEArc.DESCRIPTOR + "/default"));
            if (this.mEarc != null) goto L11;
            return false;
        L11:
            this.mEarc.asBinder().linkToDeath(this, 0);     // Catch: RemoteException -> L7
            return true;
        L7:
            e = move-exception;
            HdmiLogger.error("Couldn't link callback object: ", e, new Object[0]);
            return true;
        }

        @Override // com.android.server.hdmi.HdmiEarcController.EarcNativeWrapper
        public boolean nativeInit() {
            return connectToHal();
        }

        @Override // com.android.server.hdmi.HdmiEarcController.EarcNativeWrapper
        public void nativeSetEarcEnabled(boolean enabled) {
            this.mEarc.setEArcEnabled(enabled);     // Catch: Throwable -> L5 ServiceSpecificException -> L7
        L14:
            return;
        L5:
            e = move-exception;
            HdmiLogger.error("Could not set eARC enabled to " + enabled + ":. Exception: ", e, new Object[0]);
            return;
        L7:
            sse = move-exception;
            HdmiLogger.error("Could not set eARC enabled to " + enabled + ". Error: ", new Object[]{Integer.valueOf(sse.errorCode)});
        }

        @Override // com.android.server.hdmi.HdmiEarcController.EarcNativeWrapper
        public boolean nativeIsEarcEnabled() {
            return this.mEarc.isEArcEnabled();
        L4:
            e = move-exception;
            HdmiLogger.error("Could not read if eARC is enabled. Exception: ", e, new Object[0]);
            return false;
        }

        @Override // com.android.server.hdmi.HdmiEarcController.EarcNativeWrapper
        public void nativeSetCallback(EarcAidlCallback callback) {
            this.mEarcCallback = callback;
            this.mEarc.setCallback(callback);     // Catch: Throwable -> L5
            return;
        L5:
            e = move-exception;
            HdmiLogger.error("Could not set callback. Exception: ", e, new Object[0]);
        }

        @Override // com.android.server.hdmi.HdmiEarcController.EarcNativeWrapper
        public byte nativeGetState(int portId) {
            return this.mEarc.getState(portId);
        L4:
            e = move-exception;
            HdmiLogger.error("Could not get eARC state. Exception: ", e, new Object[0]);
            return -1;
        }

        @Override // com.android.server.hdmi.HdmiEarcController.EarcNativeWrapper
        public byte[] nativeGetLastReportedAudioCapabilities(int portId) {
            return this.mEarc.getLastReportedAudioCapabilities(portId);
        L4:
            e = move-exception;
            HdmiLogger.error("Could not read last reported audio capabilities. Exception: ", e, new Object[0]);
            return null;
        }
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmService, reason: not valid java name */
    static /* bridge */ /* synthetic */ HdmiControlService m4421$$Nest$fgetmService(HdmiEarcController r0) {
        return r0.mService;
    }

    private HdmiEarcController(HdmiControlService service, EarcNativeWrapper nativeWrapper) {
        this.mService = service;
        this.mEarcNativeWrapperImpl = nativeWrapper;
    }

    static HdmiEarcController create(HdmiControlService service) {
        return createWithNativeWrapper(service, new EarcNativeWrapperImpl(null));
    }

    static HdmiEarcController createWithNativeWrapper(HdmiControlService service, EarcNativeWrapper nativeWrapper) {
        HdmiEarcController controller = new HdmiEarcController(service, nativeWrapper);
        if (controller.init(nativeWrapper) == true) goto L6;
        HdmiLogger.warning("Could not connect to eARC AIDL HAL.", new Object[0]);
        return null;
    L6:
        return controller;
    }

    private boolean init(EarcNativeWrapper nativeWrapper) {
        if (nativeWrapper.nativeInit() == false) goto L6;
        this.mControlHandler = new Handler(this.mService.getServiceLooper());
        this.mEarcNativeWrapperImpl.nativeSetCallback(new EarcAidlCallback(this));
        return true;
    L6:
        return false;
    }

    private void assertRunOnServiceThread() {
        if (Looper.myLooper() != this.mControlHandler.getLooper()) goto L6;
        return;
    L6:
        throw new IllegalStateException("Should run on service thread.");
    }

    void runOnServiceThread(Runnable runnable) {
        this.mControlHandler.post(new WorkSourceUidPreservingRunnable(runnable));
    }

    @HdmiAnnotations.ServiceThreadOnly
    void setEarcEnabled(boolean enabled) {
        assertRunOnServiceThread();
        this.mEarcNativeWrapperImpl.nativeSetEarcEnabled(enabled);
    }

    @HdmiAnnotations.ServiceThreadOnly
    int getState(int portId) {
        return this.mEarcNativeWrapperImpl.nativeGetState(portId);
    }

    @HdmiAnnotations.ServiceThreadOnly
    byte[] getLastReportedCaps(int portId) {
        return this.mEarcNativeWrapperImpl.nativeGetLastReportedAudioCapabilities(portId);
    }
}
