package com.android.server.soundtrigger_middleware;

import android.hardware.soundtrigger.V2_0.ISoundTriggerHw;
import android.os.HwBinder;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.os.SystemProperties;
import android.util.Slog;
import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
class DefaultHalFactory implements HalFactory {
    private static final String TAG = "SoundTriggerMiddlewareDefaultHalFactory";
    private static final int USE_DEFAULT_HAL = 0;
    private static final int USE_MOCK_HAL_V2 = 2;
    private static final int USE_MOCK_HAL_V3 = 3;
    private static final ICaptureStateNotifier mCaptureStateNotifier = null;

    public static /* synthetic */ void $r8$lambda$KMbWZyi6Wv3YpFRRKdm5GTe9ZOA() {
        lambda$create$1();
    }

    public static /* synthetic */ void $r8$lambda$Pxdhb9m8jsI1gtn_NyOQbXw8Zcw(ISoundTriggerHw r0) {
        lambda$create$2(r0);
    }

    public static /* synthetic */ void $r8$lambda$jikGhW3JoTsqidubW1AhGp2sJgw(String r0) {
        lambda$create$3(r0);
    }

    public static /* synthetic */ void $r8$lambda$tAE1IsGlpBsm9yI0s4845AfKTSs() {
        lambda$create$0();
    }

    DefaultHalFactory() {
    }

    static {
        mCaptureStateNotifier = new ExternalCaptureStateTracker();
    }

    @Override // com.android.server.soundtrigger_middleware.HalFactory
    public ISoundTriggerHal create() {
        int mockHal = SystemProperties.getInt("debug.soundtrigger_middleware.use_mock_hal", 0);     // Catch: RemoteException -> L9
        if (mockHal != 0) goto L14;
        String aidlServiceName = android.hardware.soundtrigger3.ISoundTriggerHw.class.getCanonicalName() + "/default";     // Catch: RemoteException -> L9
        if (ServiceManager.isDeclared(aidlServiceName) == false) goto L11;
        Slog.i(TAG, "Connecting to default soundtrigger3.ISoundTriggerHw");     // Catch: RemoteException -> L9
        return new SoundTriggerHw3Compat(ServiceManager.waitForService(aidlServiceName), new DefaultHalFactory$$ExternalSyntheticLambda0());
    L11:
        Slog.i(TAG, "Connecting to default soundtrigger-V2.x.ISoundTriggerHw");     // Catch: RemoteException -> L9
        return SoundTriggerHw2Compat.create(ISoundTriggerHw.getService(true), new DefaultHalFactory$$ExternalSyntheticLambda1(), mCaptureStateNotifier);
    L14:
        if (mockHal != 2) goto L23;
        Slog.i(TAG, "Connecting to mock soundtrigger-V2.x.ISoundTriggerHw");     // Catch: RemoteException -> L9
        HwBinder.setTrebleTestingOverride(true);     // Catch: RemoteException -> L9
        final ISoundTriggerHw driver = ISoundTriggerHw.getService("mock", true);     // Catch: Throwable -> L19
        ISoundTriggerHal r3 = SoundTriggerHw2Compat.create(driver, new DefaultHalFactory$$ExternalSyntheticLambda2(driver), mCaptureStateNotifier);     // Catch: Throwable -> L19
        HwBinder.setTrebleTestingOverride(false);     // Catch: RemoteException -> L9
        return r3;
    L19:
        th = move-exception;
        HwBinder.setTrebleTestingOverride(false);     // Catch: RemoteException -> L9
        throw th;     // Catch: RemoteException -> L9
    L23:
        if (mockHal != 3) goto L27;
        final String aidlServiceName2 = android.hardware.soundtrigger3.ISoundTriggerHw.class.getCanonicalName() + "/mock";     // Catch: RemoteException -> L9
        Slog.i(TAG, "Connecting to mock soundtrigger3.ISoundTriggerHw");     // Catch: RemoteException -> L9
        return new SoundTriggerHw3Compat(ServiceManager.waitForService(aidlServiceName2), new DefaultHalFactory$$ExternalSyntheticLambda3(aidlServiceName2));
    L27:
        throw new RuntimeException("Unknown HAL mock version: " + mockHal);     // Catch: RemoteException -> L9
    L9:
        e = move-exception;
        throw e.rethrowAsRuntimeException();
    }

    private static /* synthetic */ void lambda$create$0() {
        SystemProperties.set("sys.audio.restart.hal", "1");
    }

    private static /* synthetic */ void lambda$create$1() {
        SystemProperties.set("sys.audio.restart.hal", "1");
    }

    private static /* synthetic */ void lambda$create$2(ISoundTriggerHw driver) {
        driver.debug(null, new ArrayList(Arrays.asList(new String[]{"reboot"})));     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        Slog.e(TAG, "Failed to reboot mock HAL", e);
    }

    private static /* synthetic */ void lambda$create$3(String aidlServiceName) {
        ServiceManager.waitForService(aidlServiceName).shellCommand(null, null, null, new String[]{"reboot"}, null, null);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        Slog.e(TAG, "Failed to reboot mock HAL", e);
    }
}
