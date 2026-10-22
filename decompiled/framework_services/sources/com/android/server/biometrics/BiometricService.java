package com.android.server.biometrics;

import android.R;
import android.app.ActivityManager;
import android.app.IActivityManager;
import android.app.admin.DevicePolicyManager;
import android.app.trust.ITrustManager;
import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.UserInfo;
import android.database.ContentObserver;
import android.hardware.SensorPrivacyManager;
import android.hardware.biometrics.IBiometricAuthenticator;
import android.hardware.biometrics.IBiometricEnabledOnKeyguardCallback;
import android.hardware.biometrics.IBiometricSensorReceiver;
import android.hardware.biometrics.IBiometricService;
import android.hardware.biometrics.IBiometricServiceReceiver;
import android.hardware.biometrics.IBiometricSysuiReceiver;
import android.hardware.biometrics.IInvalidationCallback;
import android.hardware.biometrics.ITestSession;
import android.hardware.biometrics.ITestSessionCallback;
import android.hardware.biometrics.PromptInfo;
import android.hardware.biometrics.SensorPropertiesInternal;
import android.hardware.camera2.CameraManager;
import android.hardware.face.FaceManager;
import android.hardware.fingerprint.FingerprintManager;
import android.hardware.fingerprint.FingerprintSensorPropertiesInternal;
import android.net.Uri;
import android.os.Binder;
import android.os.Build;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.os.UserManager;
import android.provider.Settings;
import android.security.GateKeeper;
import android.security.KeyStoreAuthorization;
import android.service.gatekeeper.IGateKeeperService;
import android.text.TextUtils;
import android.util.ArraySet;
import android.util.Pair;
import android.util.Slog;
import android.util.SparseBooleanArray;
import android.util.proto.ProtoOutputStream;
import com.android.internal.os.SomeArgs;
import com.android.internal.statusbar.IStatusBarService;
import com.android.internal.util.DumpUtils;
import com.android.server.SystemService;
import com.android.server.audio.AudioService$$ExternalSyntheticLambda2;
import com.android.server.biometrics.log.BiometricContext;
import com.android.server.utils.Slogf;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Supplier;

/* JADX INFO: loaded from: classes.dex */
public class BiometricService extends SystemService {
    static final String TAG = "BiometricService";
    AuthSession mAuthSession;
    private final BiometricCameraManager mBiometricCameraManager;
    private final BiometricContext mBiometricContext;
    private final BiometricNotificationLogger mBiometricNotificationLogger;
    BiometricStrengthController mBiometricStrengthController;
    private final DevicePolicyManager mDevicePolicyManager;
    private final List<EnabledOnKeyguardCallback> mEnabledOnKeyguardCallbacks;
    IGateKeeperService mGateKeeper;
    private final Handler mHandler;
    final IBiometricService.Stub mImpl;
    private final Injector mInjector;
    KeyStoreAuthorization mKeyStoreAuthorization;
    private final Random mRandom;
    private final Supplier<Long> mRequestCounter;
    final CopyOnWriteArrayList<BiometricSensor> mSensors;
    final SettingObserver mSettingObserver;
    IStatusBarService mStatusBarService;
    ITrustManager mTrustManager;
    private final UserManager mUserManager;

    /* JADX INFO: renamed from: com.android.server.biometrics.BiometricService$1, reason: invalid class name */
    class AnonymousClass1 extends IBiometricSensorReceiver.Stub {
        final /* synthetic */ BiometricService this$0;
        final /* synthetic */ long val$requestId;

        /* JADX INFO: renamed from: $r8$lambda$-RsHz_cLT-oZPgtEMqO9u-4XBmA, reason: not valid java name */
        public static /* synthetic */ void m2589$r8$lambda$RsHz_cLToZPgtEMqO9u4XBmA(AnonymousClass1 r0, long r1, int r3, int r4, int r5) {
            r0.lambda$onAcquired$4(r1, r3, r4, r5);
        }

        public static /* synthetic */ void $r8$lambda$9Vhtf9xSU0supjr11gxu3poMTEU(AnonymousClass1 r0, long r1, int r3, byte[] r4) {
            r0.lambda$onAuthenticationSucceeded$0(r1, r3, r4);
        }

        public static /* synthetic */ void $r8$lambda$_Em4cVnq9rzZbekdz3Z_NC9vhG8(AnonymousClass1 r0, long r1, int r3, int r4, int r5, int r6) {
            r0.lambda$onError$2(r1, r3, r4, r5, r6);
        }

        public static /* synthetic */ void $r8$lambda$gDDfavOZhoI3Crh0flN4IZ8t43Y(AnonymousClass1 r0, long r1, int r3, int r4, int r5, int r6) {
            r0.lambda$onError$3(r1, r3, r4, r5, r6);
        }

        public static /* synthetic */ void $r8$lambda$iWxjgLBxv5EYm7Y7ILHzC4nAg2E(AnonymousClass1 r0, long r1, int r3) {
            r0.lambda$onAuthenticationFailed$1(r1, r3);
        }

        AnonymousClass1(BiometricService this$0, long r2) {
            this.this$0 = this$0;
            this.val$requestId = r2;
        }

        private /* synthetic */ void lambda$onAuthenticationSucceeded$0(long requestId, int sensorId, byte[] token) {
            BiometricService.m2577$$Nest$mhandleAuthenticationSucceeded(this.this$0, requestId, sensorId, token);
        }

        public void onAuthenticationSucceeded(final int sensorId, final byte[] token) {
            Handler r0 = BiometricService.m2569$$Nest$fgetmHandler(this.this$0);
            final long r3 = this.val$requestId;
            r0.post(new BiometricService$1$$ExternalSyntheticLambda0(this, r3, sensorId, token));
        }

        public void onAuthenticationFailed(final int sensorId) {
            Slog.v(BiometricService.TAG, "onAuthenticationFailed");
            Handler r0 = BiometricService.m2569$$Nest$fgetmHandler(this.this$0);
            final long r1 = this.val$requestId;
            r0.post(new BiometricService$1$$ExternalSyntheticLambda1(this, r1, sensorId));
        }

        private /* synthetic */ void lambda$onAuthenticationFailed$1(long requestId, int sensorId) {
            BiometricService.m2576$$Nest$mhandleAuthenticationRejected(this.this$0, requestId, sensorId);
        }

        public void onError(final int sensorId, final int cookie, final int error, final int vendorCode) {
            if (error != 3) goto L5;
            Handler r8 = BiometricService.m2569$$Nest$fgetmHandler(this.this$0);
            final long r2 = this.val$requestId;
            r8.post(new BiometricService$1$$ExternalSyntheticLambda2(this, r2, sensorId, cookie, error, vendorCode));
            return;
        L5:
            Handler r9 = BiometricService.m2569$$Nest$fgetmHandler(this.this$0);
            final long r3 = this.val$requestId;
            r9.post(new BiometricService$1$$ExternalSyntheticLambda3(this, r3, sensorId, cookie, error, vendorCode));
        }

        private /* synthetic */ void lambda$onError$2(long requestId, int sensorId, int cookie, int error, int vendorCode) {
            BiometricService.m2578$$Nest$mhandleAuthenticationTimedOut(this.this$0, requestId, sensorId, cookie, error, vendorCode);
        }

        private /* synthetic */ void lambda$onError$3(long requestId, int sensorId, int cookie, int error, int vendorCode) {
            BiometricService.m2584$$Nest$mhandleOnError(this.this$0, requestId, sensorId, cookie, error, vendorCode);
        }

        private /* synthetic */ void lambda$onAcquired$4(long requestId, int sensorId, int acquiredInfo, int vendorCode) {
            BiometricService.m2580$$Nest$mhandleOnAcquired(this.this$0, requestId, sensorId, acquiredInfo, vendorCode);
        }

        public void onAcquired(final int sensorId, final int acquiredInfo, final int vendorCode) {
            Handler r0 = BiometricService.m2569$$Nest$fgetmHandler(this.this$0);
            final long r3 = this.val$requestId;
            r0.post(new BiometricService$1$$ExternalSyntheticLambda4(this, r3, sensorId, acquiredInfo, vendorCode));
        }
    }

    /* JADX INFO: renamed from: com.android.server.biometrics.BiometricService$2, reason: invalid class name */
    class AnonymousClass2 extends IBiometricSysuiReceiver.Stub {
        final /* synthetic */ BiometricService this$0;
        final /* synthetic */ long val$requestId;

        public static /* synthetic */ void $r8$lambda$K0ILmnQEKPKaUlvxg0jxO3Y60Vg(AnonymousClass2 r0, long r1, int r3, byte[] r4) {
            r0.lambda$onDialogDismissed$0(r1, r3, r4);
        }

        /* JADX INFO: renamed from: $r8$lambda$YE-YiQ2saRCvTqBcqXv1K20IKxk, reason: not valid java name */
        public static /* synthetic */ void m2590$r8$lambda$YEYiQ2saRCvTqBcqXv1K20IKxk(AnonymousClass2 r0, long r1) {
            r0.lambda$onTryAgainPressed$1(r1);
        }

        public static /* synthetic */ void $r8$lambda$dAwBQ9IdKRHcMUf5kKkOeHbIaFY(AnonymousClass2 r0, long r1, boolean r3) {
            r0.lambda$onDialogAnimatedIn$4(r1, r3);
        }

        public static /* synthetic */ void $r8$lambda$egHlFA_cl45l_2nvE38HnjDNbwo(AnonymousClass2 r0, long r1, int r3) {
            r0.lambda$onSystemEvent$3(r1, r3);
        }

        public static /* synthetic */ void $r8$lambda$j_t6Ey5wcRnsbf1pRuO4yfSV4gE(AnonymousClass2 r0, long r1) {
            r0.lambda$onStartFingerprintNow$5(r1);
        }

        /* JADX INFO: renamed from: $r8$lambda$n1OqD-ty-MTorR4049bVbZ6tG7Y, reason: not valid java name */
        public static /* synthetic */ void m2591$r8$lambda$n1OqDtyMTorR4049bVbZ6tG7Y(AnonymousClass2 r0, long r1) {
            r0.lambda$onDeviceCredentialPressed$2(r1);
        }

        AnonymousClass2(BiometricService this$0, long r2) {
            this.this$0 = this$0;
            this.val$requestId = r2;
        }

        private /* synthetic */ void lambda$onDialogDismissed$0(long requestId, int reason, byte[] credentialAttestation) {
            BiometricService.m2583$$Nest$mhandleOnDismissed(this.this$0, requestId, reason, credentialAttestation);
        }

        public void onDialogDismissed(final int reason, final byte[] credentialAttestation) {
            Handler r0 = BiometricService.m2569$$Nest$fgetmHandler(this.this$0);
            final long r3 = this.val$requestId;
            r0.post(new BiometricService$2$$ExternalSyntheticLambda4(this, r3, reason, credentialAttestation));
        }

        private /* synthetic */ void lambda$onTryAgainPressed$1(long requestId) {
            BiometricService.m2588$$Nest$mhandleOnTryAgainPressed(this.this$0, requestId);
        }

        public void onTryAgainPressed() {
            Handler r0 = BiometricService.m2569$$Nest$fgetmHandler(this.this$0);
            final long r1 = this.val$requestId;
            r0.post(new BiometricService$2$$ExternalSyntheticLambda5(this, r1));
        }

        private /* synthetic */ void lambda$onDeviceCredentialPressed$2(long requestId) {
            BiometricService.m2581$$Nest$mhandleOnDeviceCredentialPressed(this.this$0, requestId);
        }

        public void onDeviceCredentialPressed() {
            Handler r0 = BiometricService.m2569$$Nest$fgetmHandler(this.this$0);
            final long r1 = this.val$requestId;
            r0.post(new BiometricService$2$$ExternalSyntheticLambda3(this, r1));
        }

        private /* synthetic */ void lambda$onSystemEvent$3(long requestId, int event) {
            BiometricService.m2587$$Nest$mhandleOnSystemEvent(this.this$0, requestId, event);
        }

        public void onSystemEvent(final int event) {
            Handler r0 = BiometricService.m2569$$Nest$fgetmHandler(this.this$0);
            final long r1 = this.val$requestId;
            r0.post(new BiometricService$2$$ExternalSyntheticLambda0(this, r1, event));
        }

        private /* synthetic */ void lambda$onDialogAnimatedIn$4(long requestId, boolean startFingerprintNow) {
            BiometricService.m2582$$Nest$mhandleOnDialogAnimatedIn(this.this$0, requestId, startFingerprintNow);
        }

        public void onDialogAnimatedIn(final boolean startFingerprintNow) {
            Handler r0 = BiometricService.m2569$$Nest$fgetmHandler(this.this$0);
            final long r1 = this.val$requestId;
            r0.post(new BiometricService$2$$ExternalSyntheticLambda2(this, r1, startFingerprintNow));
        }

        private /* synthetic */ void lambda$onStartFingerprintNow$5(long requestId) {
            BiometricService.m2586$$Nest$mhandleOnStartFingerprintNow(this.this$0, requestId);
        }

        public void onStartFingerprintNow() {
            Handler r0 = BiometricService.m2569$$Nest$fgetmHandler(this.this$0);
            final long r1 = this.val$requestId;
            r0.post(new BiometricService$2$$ExternalSyntheticLambda1(this, r1));
        }
    }

    private final class BiometricServiceWrapper extends IBiometricService.Stub {
        final /* synthetic */ BiometricService this$0;

        /* JADX INFO: renamed from: $r8$lambda$BlPSUYUcNH-O7bNwQaHF3OgvMGk, reason: not valid java name */
        public static /* synthetic */ void m2592$r8$lambda$BlPSUYUcNHO7bNwQaHF3OgvMGk(BiometricServiceWrapper r0, int r1) {
            r0.lambda$resetLockout$3(r1);
        }

        public static /* synthetic */ void $r8$lambda$IFr0AWJ8XoySKrDyUgHTCUCsyHE(BiometricServiceWrapper r0, IBinder r1, long r2, long r4, int r6, IBiometricServiceReceiver r7, String r8, PromptInfo r9) {
            r0.lambda$authenticate$1(r1, r2, r4, r6, r7, r8, r9);
        }

        public static /* synthetic */ void $r8$lambda$PZFSVFB5tNc_XSeZcV_9CE2IwhQ(BiometricServiceWrapper r0, long r1, int r3) {
            r0.lambda$onReadyForAuthentication$0(r1, r3);
        }

        public static /* synthetic */ void $r8$lambda$qBf0_iWTcbFNRwTKvYJS02kM5s0(BiometricServiceWrapper r0, long r1) {
            r0.lambda$cancelAuthentication$2(r1);
        }

        /* synthetic */ BiometricServiceWrapper(BiometricService r1, BiometricServiceIA r2) {
            this(r1);
        }

        private BiometricServiceWrapper(BiometricService r1) {
            this.this$0 = r1;
        }

        public ITestSession createTestSession(int sensorId, ITestSessionCallback callback, String opPackageName) throws RemoteException {
            super.createTestSession_enforcePermission();
            Iterator<BiometricSensor> r0 = this.this$0.mSensors.iterator();
        L4:
            if (r0.hasNext() == false) goto L10;
            BiometricSensor sensor = r0.next();
            if (sensor.id != sensorId) goto L4;
            return sensor.impl.createTestSession(callback, opPackageName);
        L10:
            Slog.e(BiometricService.TAG, "Unknown sensor for createTestSession: " + sensorId);
            return null;
        }

        public List<SensorPropertiesInternal> getSensorProperties(String opPackageName) throws RemoteException {
            super.getSensorProperties_enforcePermission();
            List<SensorPropertiesInternal> sensors = new ArrayList();
            Iterator<BiometricSensor> r1 = this.this$0.mSensors.iterator();
        L4:
            if (r1.hasNext() == false) goto L6;
            BiometricSensor sensor = r1.next();
            SensorPropertiesInternal prop = SensorPropertiesInternal.from(sensor.impl.getSensorProperties(opPackageName));
            sensors.add(prop);
            goto L4
        L6:
            return sensors;
        }

        public void onReadyForAuthentication(final long requestId, final int cookie) {
            super.onReadyForAuthentication_enforcePermission();
            BiometricService.m2569$$Nest$fgetmHandler(this.this$0).post(new BiometricService$BiometricServiceWrapper$$ExternalSyntheticLambda0(this, requestId, cookie));
        }

        private /* synthetic */ void lambda$onReadyForAuthentication$0(long requestId, int cookie) {
            BiometricService.m2585$$Nest$mhandleOnReadyForAuthentication(this.this$0, requestId, cookie);
        }

        public long authenticate(final IBinder token, final long operationId, final int userId, final IBiometricServiceReceiver receiver, final String opPackageName, final PromptInfo promptInfo) {
            super.authenticate_enforcePermission();
            if (token == null) goto L14;
            if (receiver == null) goto L14;
            if (opPackageName == null) goto L14;
            if (promptInfo == null) goto L14;
            if (Utils.isValidAuthenticatorConfig(this.this$0.getContext(), promptInfo) == false) goto L13;
            Utils.combineAuthenticatorBundles(promptInfo);
            final long requestId = ((Long) BiometricService.m2570$$Nest$fgetmRequestCounter(this.this$0).get()).longValue();
            BiometricService.m2569$$Nest$fgetmHandler(this.this$0).post(new BiometricService$BiometricServiceWrapper$$ExternalSyntheticLambda2(this, token, requestId, operationId, userId, receiver, opPackageName, promptInfo));
            return requestId;
        L13:
            throw new SecurityException("Invalid authenticator configuration");
        L14:
            Slog.e(BiometricService.TAG, "Unable to authenticate, one or more null arguments");
            return -1;
        }

        private /* synthetic */ void lambda$authenticate$1(IBinder token, long requestId, long operationId, int userId, IBiometricServiceReceiver receiver, String opPackageName, PromptInfo promptInfo) {
            BiometricService.m2575$$Nest$mhandleAuthenticate(this.this$0, token, requestId, operationId, userId, receiver, opPackageName, promptInfo);
        }

        public void cancelAuthentication(IBinder token, String opPackageName, final long requestId) {
            super.cancelAuthentication_enforcePermission();
            SomeArgs args = SomeArgs.obtain();
            args.arg1 = token;
            args.arg2 = opPackageName;
            args.arg3 = Long.valueOf(requestId);
            BiometricService.m2569$$Nest$fgetmHandler(this.this$0).post(new BiometricService$BiometricServiceWrapper$$ExternalSyntheticLambda3(this, requestId));
        }

        private /* synthetic */ void lambda$cancelAuthentication$2(long requestId) {
            BiometricService.m2579$$Nest$mhandleCancelAuthentication(this.this$0, requestId);
        }

        public int canAuthenticate(String opPackageName, int userId, int callingUserId, int authenticators) {
            super.canAuthenticate_enforcePermission();
            Slog.d(BiometricService.TAG, "canAuthenticate: User=" + userId + ", Caller=" + callingUserId + ", Authenticators=" + authenticators);
            if (Utils.isValidAuthenticatorConfig(this.this$0.getContext(), authenticators) == false) goto L10;
            PreAuthInfo preAuthInfo = BiometricService.m2572$$Nest$mcreatePreAuthInfo(this.this$0, opPackageName, userId, authenticators);     // Catch: RemoteException -> L6
            return preAuthInfo.getCanAuthenticateResult();
        L6:
            e = move-exception;
            Slog.e(BiometricService.TAG, "Remote exception", e);
            return 1;
        L10:
            throw new SecurityException("Invalid authenticator configuration");
        }

        public long getLastAuthenticationTime(int userId, int authenticators) {
            super.getLastAuthenticationTime_enforcePermission();
            Slogf.d(BiometricService.TAG, "getLastAuthenticationTime(userId=%d, authenticators=0x%x)", new Object[]{Integer.valueOf(userId), Integer.valueOf(authenticators)});
            long secureUserId = this.this$0.mGateKeeper.getSecureUserId(userId);     // Catch: RemoteException -> L20
            if (secureUserId != 0) goto L8;
            Slogf.w(BiometricService.TAG, "No secure user id for " + userId);
            return -1;
        L8:
            ArrayList<Integer> hardwareAuthenticators = new ArrayList(2);
            if ((32768 & authenticators) == 0) goto L12;
            hardwareAuthenticators.add(1);
        L12:
            if ((authenticators & 15) == 0) goto L15;
            hardwareAuthenticators.add(2);
        L15:
            if (hardwareAuthenticators.isEmpty() == true) goto L19;
            int[] authTypesArray = hardwareAuthenticators.stream().mapToInt(new AudioService$$ExternalSyntheticLambda2()).toArray();
            return this.this$0.mKeyStoreAuthorization.getLastAuthTime(secureUserId, authTypesArray);
        L19:
            throw new IllegalArgumentException("authenticators must not be empty");
        L20:
            e = move-exception;
            Slogf.w(BiometricService.TAG, "Failed to get secure user id for " + userId, e);
            return -1;
        }

        public boolean hasEnrolledBiometrics(int userId, String opPackageName) {
            super.hasEnrolledBiometrics_enforcePermission();
            Iterator<BiometricSensor> r0 = this.this$0.mSensors.iterator();     // Catch: RemoteException -> L11
        L5:
            if (r0.hasNext() == false) goto L22;
            BiometricSensor sensor = r0.next();     // Catch: RemoteException -> L11
            if (sensor.impl.hasEnrolledTemplates(userId, opPackageName) == false) goto L5;
            return true;
        L22:
            return false;
        L11:
            e = move-exception;
            Slog.e(BiometricService.TAG, "Remote exception", e);
            return false;
        }

        public void registerAuthenticator(final int id, final int modality, final int strength, final IBiometricAuthenticator authenticator) {
            super.registerAuthenticator_enforcePermission();
            Slog.d(BiometricService.TAG, "Registering ID: " + id + " Modality: " + modality + " Strength: " + strength);
            if (authenticator == null) goto L24;
            if (strength != 15) goto L7;
        L13:
            Iterator<BiometricSensor> r0 = this.this$0.mSensors.iterator();
        L15:
            if (r0.hasNext() == false) goto L21;
            BiometricSensor sensor = r0.next();
            if (sensor.id != id) goto L15;
            throw new IllegalStateException("Cannot register duplicate authenticator");
        L21:
            CopyOnWriteArrayList<BiometricSensor> r1 = this.this$0.mSensors;
            final Context r3 = this.this$0.getContext();
            r1.add(new AnonymousClass1(this, r3, id, modality, strength, authenticator));
            this.this$0.mBiometricStrengthController.updateStrengths();
            return;
        L7:
            if (strength == 255) goto L13;
            if (strength == 4095) goto L13;
            throw new IllegalStateException("Unsupported strength");
        L24:
            throw new IllegalArgumentException("Authenticator must not be null. Did you forget to modify the core/res/res/values/xml overlay for config_biometric_sensors?");
        }

        public void registerEnabledOnKeyguardCallback(IBiometricEnabledOnKeyguardCallback callback) {
            super.registerEnabledOnKeyguardCallback_enforcePermission();
            BiometricService.m2568$$Nest$fgetmEnabledOnKeyguardCallbacks(this.this$0).add(new EnabledOnKeyguardCallback(this.this$0, callback));
            List<UserInfo> aliveUsers = BiometricService.m2571$$Nest$fgetmUserManager(this.this$0).getAliveUsers();
            Iterator<UserInfo> r1 = aliveUsers.iterator();     // Catch: RemoteException -> L8
        L5:
            if (r1.hasNext() == false) goto L17;
            UserInfo userInfo = r1.next();     // Catch: RemoteException -> L8
            int userId = userInfo.id;     // Catch: RemoteException -> L8
            callback.onChanged(this.this$0.mSettingObserver.getEnabledOnKeyguard(userId, 14), userId, 14);     // Catch: RemoteException -> L8
            goto L5
        L17:
            return;
        L8:
            e = move-exception;
            Slog.w(BiometricService.TAG, "Remote exception", e);
        }

        public void invalidateAuthenticatorIds(int userId, int fromSensorId, IInvalidationCallback callback) {
            super.invalidateAuthenticatorIds_enforcePermission();
            InvalidationTracker.start(this.this$0.getContext(), this.this$0.mSensors, userId, fromSensorId, callback);
        }

        public long[] getAuthenticatorIds(int callingUserId) {
            super.getAuthenticatorIds_enforcePermission();
            List<Long> authenticatorIds = new ArrayList();
            Iterator<BiometricSensor> r2 = this.this$0.mSensors.iterator();
        L4:
            if (r2.hasNext() == false) goto L17;
            BiometricSensor sensor = r2.next();
            boolean hasEnrollments = sensor.impl.hasEnrolledTemplates(callingUserId, this.this$0.getContext().getOpPackageName());     // Catch: RemoteException -> L11
            long authenticatorId = sensor.impl.getAuthenticatorId(callingUserId);     // Catch: RemoteException -> L11
            if (hasEnrollments == false) goto L13;
            if (Utils.isAtLeastStrength(sensor.getCurrentStrength(), 15) == false) goto L13;
            authenticatorIds.add(Long.valueOf(authenticatorId));     // Catch: RemoteException -> L11
        L13:
            Slog.d(BiometricService.TAG, "Sensor " + sensor + ", sensorId " + sensor.id + ", hasEnrollments: " + hasEnrollments + " cannot participate in Keystore operations");     // Catch: RemoteException -> L11
        L11:
            e = move-exception;
            Slog.e(BiometricService.TAG, "RemoteException", e);
            goto L4
        L17:
            long[] result = new long[authenticatorIds.size()];
            int i = 0;
        L19:
            if (i >= authenticatorIds.size()) goto L22;
            result[i] = authenticatorIds.get(i).longValue();
            i = i + 1;
            goto L19
        L22:
            return result;
        }

        public void resetLockoutTimeBound(IBinder token, String opPackageName, int fromSensorId, int userId, byte[] hardwareAuthToken) {
            super.resetLockoutTimeBound_enforcePermission();
            boolean disableResetLockout = !Utils.isAtLeastStrength(BiometricService.m2574$$Nest$mgetSensorForId(this.this$0, fromSensorId).getCurrentStrength(), 255);
            if (disableResetLockout == false) goto L6;
            Slog.w(BiometricService.TAG, "Sensor: " + fromSensorId + " is does not meet the required strength to request resetLockout");
            return;
        L6:
            Iterator<BiometricSensor> r3 = this.this$0.mSensors.iterator();
        L8:
            if (r3.hasNext() == false) goto L27;
            BiometricSensor sensor = r3.next();
            if (sensor.id == fromSensorId) goto L8;
            SensorPropertiesInternal props = sensor.impl.getSensorProperties(this.this$0.getContext().getOpPackageName());     // Catch: RemoteException -> L17
            if (props.resetLockoutRequiresHardwareAuthToken == true) goto L15;
        L19:
            boolean supportsChallengelessHat = false;
        L20:
            boolean doesNotRequireHat = !props.resetLockoutRequiresHardwareAuthToken;     // Catch: RemoteException -> L17
            if (supportsChallengelessHat == true) goto L23;
            if (doesNotRequireHat == false) goto L8;
        L23:
            Slog.d(BiometricService.TAG, "resetLockout from: " + fromSensorId + ", for: " + sensor.id + ", userId: " + userId);     // Catch: RemoteException -> L17
            sensor.impl.resetLockout(token, opPackageName, userId, hardwareAuthToken);     // Catch: RemoteException -> L17
            goto L8
        L15:
            if (props.resetLockoutRequiresChallenge == true) goto L19;
            supportsChallengelessHat = true;
        L17:
            e = move-exception;
            Slog.e(BiometricService.TAG, "Remote exception", e);
            goto L8
        }

        public void resetLockout(final int userId, byte[] hardwareAuthToken) {
            super.resetLockout_enforcePermission();
            StringBuilder r0 = new StringBuilder();
            r0.append("resetLockout(userId=");
            r0.append(userId);
            r0.append(", hat=");
            if (hardwareAuthToken != null) goto L5;
            String r1 = "null ";
        L6:
            r0.append(r1);
            r0.append(")");
            Slog.d(BiometricService.TAG, r0.toString());
            BiometricService.m2569$$Nest$fgetmHandler(this.this$0).post(new BiometricService$BiometricServiceWrapper$$ExternalSyntheticLambda1(this, userId));
            return;
        L5:
            r1 = "present";
            goto L6
        }

        private /* synthetic */ void lambda$resetLockout$3(int userId) {
            BiometricService.m2566$$Nest$fgetmBiometricContext(this.this$0).getAuthSessionCoordinator().resetLockoutFor(userId, 15, -1);
        }

        public int getCurrentStrength(int sensorId) {
            super.getCurrentStrength_enforcePermission();
            Iterator<BiometricSensor> r0 = this.this$0.mSensors.iterator();
        L4:
            if (r0.hasNext() == false) goto L10;
            BiometricSensor sensor = r0.next();
            if (sensor.id != sensorId) goto L4;
            return sensor.getCurrentStrength();
        L10:
            Slog.e(BiometricService.TAG, "Unknown sensorId: " + sensorId);
            return 0;
        }

        public int getCurrentModality(String opPackageName, int userId, int callingUserId, int authenticators) {
            super.getCurrentModality_enforcePermission();
            Slog.d(BiometricService.TAG, "getCurrentModality: User=" + userId + ", Caller=" + callingUserId + ", Authenticators=" + authenticators);
            if (Utils.isValidAuthenticatorConfig(this.this$0.getContext(), authenticators) == false) goto L10;
            PreAuthInfo preAuthInfo = BiometricService.m2572$$Nest$mcreatePreAuthInfo(this.this$0, opPackageName, userId, authenticators);     // Catch: RemoteException -> L6
            return ((Integer) preAuthInfo.getPreAuthenticateStatus().first).intValue();
        L6:
            e = move-exception;
            Slog.e(BiometricService.TAG, "Remote exception", e);
            return 0;
        L10:
            throw new SecurityException("Invalid authenticator configuration");
        }

        public int getSupportedModalities(int authenticators) {
            super.getSupportedModalities_enforcePermission();
            Slog.d(BiometricService.TAG, "getSupportedModalities: Authenticators=" + authenticators);
            if (Utils.isValidAuthenticatorConfig(this.this$0.getContext(), authenticators) == false) goto L19;
            if (Utils.isCredentialRequested(authenticators) == false) goto L7;
            int modality = 1;
        L9:
            if (Utils.isBiometricRequested(authenticators) == false) goto L17;
            int requestedStrength = Utils.getPublicBiometricStrength(authenticators);
            Iterator<BiometricSensor> r2 = this.this$0.mSensors.iterator();
        L12:
            if (r2.hasNext() == false) goto L17;
            BiometricSensor sensor = r2.next();
            int sensorStrength = sensor.getCurrentStrength();
            if (Utils.isAtLeastStrength(sensorStrength, requestedStrength) == false) goto L12;
            modality = modality | sensor.modality;
        L17:
            return modality;
        L7:
            modality = 0;
            goto L9
        L19:
            throw new SecurityException("Invalid authenticator configuration");
        }

        protected void dump(FileDescriptor fd, PrintWriter pw, String[] args) {
            if (DumpUtils.checkDumpPermission(this.this$0.getContext(), BiometricService.TAG, pw) == true) goto L5;
            return;
        L5:
            long ident = Binder.clearCallingIdentity();
        L15:
            th = move-exception;
            Binder.restoreCallingIdentity(ident);
            throw th;
        L17:
            e = move-exception;
            Slog.e(BiometricService.TAG, "Remote exception", e);     // Catch: Throwable -> L15
        L30:
            Binder.restoreCallingIdentity(ident);
            return;
        L7:
            if (args.length <= 0) goto L28;
            int r4 = 0;
            if ("--proto".equals(args[0]) == false) goto L28;
            boolean clearSchedulerBuffer = true;
            if (args.length > 1) goto L13;
        L19:
            clearSchedulerBuffer = false;
        L20:
            Slog.d(BiometricService.TAG, "ClearSchedulerBuffer: " + clearSchedulerBuffer);     // Catch: Throwable -> L15 RemoteException -> L17
            ProtoOutputStream proto = new ProtoOutputStream(fd);     // Catch: Throwable -> L15 RemoteException -> L17
            if (this.this$0.mAuthSession == null) goto L23;
            r4 = this.this$0.mAuthSession.getState();     // Catch: Throwable -> L15 RemoteException -> L17
        L23:
            proto.write(1159641169922L, r4);     // Catch: Throwable -> L15 RemoteException -> L17
            Iterator<BiometricSensor> r5 = this.this$0.mSensors.iterator();     // Catch: Throwable -> L15 RemoteException -> L17
        L25:
            if (r5.hasNext() == false) goto L27;
            BiometricSensor sensor = r5.next();     // Catch: Throwable -> L15 RemoteException -> L17
            byte[] serviceState = sensor.impl.dumpSensorServiceStateProto(clearSchedulerBuffer);     // Catch: Throwable -> L15 RemoteException -> L17
            proto.write(2246267895809L, serviceState);     // Catch: Throwable -> L15 RemoteException -> L17
            goto L25
        L27:
            proto.flush();     // Catch: Throwable -> L15 RemoteException -> L17
            goto L30
        L13:
            if ("--clear-scheduler-buffer".equals(args[1]) == false) goto L19;
        L28:
            BiometricService.m2573$$Nest$mdumpInternal(this.this$0, pw);     // Catch: Throwable -> L15 RemoteException -> L17
            goto L30
        }
    }

    final class EnabledOnKeyguardCallback implements IBinder.DeathRecipient {
        private final IBiometricEnabledOnKeyguardCallback mCallback;
        final /* synthetic */ BiometricService this$0;

        EnabledOnKeyguardCallback(BiometricService this$0, IBiometricEnabledOnKeyguardCallback callback) {
            this.this$0 = this$0;
            this.mCallback = callback;
            this.mCallback.asBinder().linkToDeath(this, 0);     // Catch: RemoteException -> L5
            return;
        L5:
            e = move-exception;
            Slog.w(BiometricService.TAG, "Unable to linkToDeath", e);
        }

        void notify(boolean enabled, int userId, int modality) {
            this.mCallback.onChanged(enabled, userId, modality);     // Catch: RemoteException -> L5 DeadObjectException -> L7
        L14:
            return;
        L7:
            e = move-exception;
            Slog.w(BiometricService.TAG, "Death while invoking notify", e);
            BiometricService.m2568$$Nest$fgetmEnabledOnKeyguardCallbacks(this.this$0).remove(this);
            return;
        L5:
            e = move-exception;
            Slog.w(BiometricService.TAG, "Failed to invoke onChanged", e);
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            Slog.e(BiometricService.TAG, "Enabled callback binder died");
            BiometricService.m2568$$Nest$fgetmEnabledOnKeyguardCallbacks(this.this$0).remove(this);
        }
    }

    public static class Injector {
        public static /* synthetic */ Long $r8$lambda$hj2FW_KKwVogCJ9AY5YUaMgILng(AtomicLong r0) {
            return lambda$getRequestGenerator$0(r0);
        }

        public Injector() {
        }

        public IActivityManager getActivityManagerService() {
            return ActivityManager.getService();
        }

        public KeyStoreAuthorization getKeyStoreAuthorization() {
            return KeyStoreAuthorization.getInstance();
        }

        public IGateKeeperService getGateKeeperService() {
            return GateKeeper.getService();
        }

        public ITrustManager getTrustManager() {
            return ITrustManager.Stub.asInterface(ServiceManager.getService("trust"));
        }

        public IStatusBarService getStatusBarService() {
            return IStatusBarService.Stub.asInterface(ServiceManager.getService("statusbar"));
        }

        public SettingObserver getSettingObserver(Context context, Handler handler, List<EnabledOnKeyguardCallback> callbacks) {
            return new SettingObserver(context, handler, callbacks, (UserManager) context.getSystemService(UserManager.class), (FingerprintManager) context.getSystemService(FingerprintManager.class), (FaceManager) context.getSystemService(FaceManager.class));
        }

        public boolean isDebugEnabled(Context context, int userId) {
            return Utils.isDebugEnabled(context, userId);
        }

        public void publishBinderService(BiometricService service, IBiometricService.Stub impl) {
            BiometricService.access$000(service, "biometric", impl);
        }

        public BiometricStrengthController getBiometricStrengthController(BiometricService service) {
            return new BiometricStrengthController(service);
        }

        public String[] getConfiguration(Context context) {
            return context.getResources().getStringArray(R.array.config_convert_to_emergency_number_map);
        }

        public DevicePolicyManager getDevicePolicyManager(Context context) {
            return (DevicePolicyManager) context.getSystemService(DevicePolicyManager.class);
        }

        public List<FingerprintSensorPropertiesInternal> getFingerprintSensorProperties(Context context) {
            if (context.getPackageManager().hasSystemFeature("android.hardware.fingerprint") == false) goto L9;
            FingerprintManager fpm = (FingerprintManager) context.getSystemService(FingerprintManager.class);
            if (fpm == null) goto L9;
            return fpm.getSensorPropertiesInternal();
        L9:
            return new ArrayList();
        }

        public Supplier<Long> getRequestGenerator() {
            final AtomicLong generator = new AtomicLong(0);
            return new BiometricService$Injector$$ExternalSyntheticLambda0(generator);
        }

        private static /* synthetic */ Long lambda$getRequestGenerator$0(AtomicLong generator) {
            return Long.valueOf(generator.incrementAndGet());
        }

        public BiometricContext getBiometricContext(Context context) {
            return BiometricContext.getInstance(context);
        }

        public UserManager getUserManager(Context context) {
            return (UserManager) context.getSystemService(UserManager.class);
        }

        public BiometricCameraManager getBiometricCameraManager(Context context) {
            return new BiometricCameraManagerImpl((CameraManager) context.getSystemService(CameraManager.class), (SensorPrivacyManager) context.getSystemService(SensorPrivacyManager.class));
        }

        public BiometricNotificationLogger getNotificationLogger() {
            return new BiometricNotificationLogger();
        }
    }

    static class InvalidationTracker {
        private final IInvalidationCallback mClientCallback;
        private final Set<Integer> mSensorsPendingInvalidation;

        public static /* synthetic */ boolean $r8$lambda$ACn9ar7gd6wRXB8coX4eHCKrx9o(int r0, BiometricSensor r1) {
            return lambda$new$0(r0, r1);
        }

        public static InvalidationTracker start(Context context, List<BiometricSensor> sensors, int userId, int fromSensorId, IInvalidationCallback clientCallback) {
            return new InvalidationTracker(context, sensors, userId, fromSensorId, clientCallback);
        }

        private InvalidationTracker(Context context, List<BiometricSensor> sensors, int userId, final int fromSensorId, IInvalidationCallback clientCallback) {
            this.mClientCallback = clientCallback;
            this.mSensorsPendingInvalidation = new ArraySet();
            BiometricSensor fromSensor = sensors.stream().filter(new BiometricService$InvalidationTracker$$ExternalSyntheticLambda0(fromSensorId)).findFirst().orElse(null);
            if (fromSensor != null) goto L5;
        L47:
            Slog.d(BiometricService.TAG, "fromSensorId=" + fromSensorId + " strength is not strong or sensor not found, ignore invalidation");
            this.mClientCallback.onCompleted();     // Catch: RemoteException -> L50
            return;
        L50:
            e = move-exception;
            Slog.e(BiometricService.TAG, "Remote Exception", e);
            return;
        L5:
            if (Utils.isAtLeastStrength(fromSensor.oemStrength, 15) == false) goto L47;
            Iterator<BiometricSensor> r1 = sensors.iterator();
        L9:
            if (r1.hasNext() == false) goto L34;
            final BiometricSensor sensor = r1.next();
            if (sensor.id == fromSensorId) goto L9;
            if (Utils.isAtLeastStrength(sensor.oemStrength, 15) == false) goto L9;
            if (sensor.impl.hasEnrolledTemplates(userId, context.getOpPackageName()) == false) goto L9;
        L22:
            Slog.d(BiometricService.TAG, "Requesting authenticatorId invalidation for sensor: " + sensor.id);
            monitor-enter(this);
            this.mSensorsPendingInvalidation.add(Integer.valueOf(sensor.id));     // Catch: Throwable -> L31
            monitor-exit(this);     // Catch: Throwable -> L31
            sensor.impl.invalidateAuthenticatorId(userId, new AnonymousClass1(this, sensor));     // Catch: RemoteException -> L28
        L28:
            e = move-exception;
            Slog.d(BiometricService.TAG, "RemoteException", e);
        L31:
            th = move-exception;
            throw th;
        L20:
            e = move-exception;
            Slog.e(BiometricService.TAG, "Remote Exception", e);
            goto L22
        L34:
            monitor-enter(this);
        L39:
            th = move-exception;
            throw th;
        L36:
            if (this.mSensorsPendingInvalidation.isEmpty() == true) goto L59;
        L43:
            monitor-exit(this);     // Catch: Throwable -> L39
            return;
        L59:
            Slog.d(BiometricService.TAG, "No sensors require invalidation");     // Catch: Throwable -> L39 RemoteException -> L41
            this.mClientCallback.onCompleted();     // Catch: Throwable -> L39 RemoteException -> L41
        L41:
            e = move-exception;
            Slog.e(BiometricService.TAG, "Remote Exception", e);     // Catch: Throwable -> L39
            goto L43
        }

        private static /* synthetic */ boolean lambda$new$0(int fromSensorId, BiometricSensor sensor) {
            if (sensor.id != fromSensorId) goto L5;
            return true;
        L5:
            return false;
        }

        void onInvalidated(int sensorId) {
            monitor-enter(this);
            this.mSensorsPendingInvalidation.remove(Integer.valueOf(sensorId));     // Catch: Throwable -> L7
            Slog.d(BiometricService.TAG, "Sensor " + sensorId + " invalidated, remaining size: " + this.mSensorsPendingInvalidation.size());     // Catch: Throwable -> L7
            if (this.mSensorsPendingInvalidation.isEmpty() == true) goto L15;
        L11:
            monitor-exit(this);     // Catch: Throwable -> L7
            return;
        L15:
            this.mClientCallback.onCompleted();     // Catch: Throwable -> L7 RemoteException -> L9
        L9:
            e = move-exception;
            Slog.e(BiometricService.TAG, "Remote Exception", e);     // Catch: Throwable -> L7
        L7:
            th = move-exception;
            throw th;
        }
    }

    public static class SettingObserver extends ContentObserver {
        private static final boolean DEFAULT_ALWAYS_REQUIRE_CONFIRMATION = false;
        private static final boolean DEFAULT_APP_ENABLED = true;
        private static final boolean DEFAULT_KEYGUARD_ENABLED = true;
        private static final boolean DEFAULT_MANDATORY_BIOMETRICS_REQUIREMENTS_SATISFIED_STATUS = true;
        private static final boolean DEFAULT_MANDATORY_BIOMETRICS_STATUS = false;
        private final Uri BIOMETRIC_APP_ENABLED;
        private final Uri BIOMETRIC_KEYGUARD_ENABLED;
        private final Uri FACE_APP_ENABLED;
        private final Uri FACE_KEYGUARD_ENABLED;
        private final Uri FACE_UNLOCK_ALWAYS_REQUIRE_CONFIRMATION;
        private final Uri FACE_UNLOCK_APP_ENABLED;
        private final Uri FACE_UNLOCK_KEYGUARD_ENABLED;
        private final Uri FINGERPRINT_APP_ENABLED;
        private final Uri FINGERPRINT_KEYGUARD_ENABLED;
        private final Uri MANDATORY_BIOMETRICS_ENABLED;
        private final Uri MANDATORY_BIOMETRICS_REQUIREMENTS_SATISFIED;
        private final Map<Integer, Boolean> mBiometricEnabledForApps;
        private final Map<Integer, Boolean> mBiometricEnabledOnKeyguard;
        private final List<EnabledOnKeyguardCallback> mCallbacks;
        private final ContentResolver mContentResolver;
        private final Map<Integer, Boolean> mFaceAlwaysRequireConfirmation;
        private final SparseBooleanArray mFaceEnabledForApps;
        private final SparseBooleanArray mFaceEnabledOnKeyguard;
        private final Map<Integer, Boolean> mFaceEnrolledForUser;
        private final SparseBooleanArray mFingerprintEnabledForApps;
        private final SparseBooleanArray mFingerprintEnabledOnKeyguard;
        private final Map<Integer, Boolean> mFingerprintEnrolledForUser;
        private final Map<Integer, Boolean> mMandatoryBiometricsEnabled;
        private final Map<Integer, Boolean> mMandatoryBiometricsRequirementsSatisfied;
        private final boolean mUseLegacyFaceOnlySettings;
        private final UserManager mUserManager;

        /* JADX INFO: renamed from: -$$Nest$fgetmFaceEnrolledForUser, reason: not valid java name */
        static /* bridge */ /* synthetic */ Map m2593$$Nest$fgetmFaceEnrolledForUser(SettingObserver r0) {
            return r0.mFaceEnrolledForUser;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmFingerprintEnrolledForUser, reason: not valid java name */
        static /* bridge */ /* synthetic */ Map m2594$$Nest$fgetmFingerprintEnrolledForUser(SettingObserver r0) {
            return r0.mFingerprintEnrolledForUser;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmUseLegacyFaceOnlySettings, reason: not valid java name */
        static /* bridge */ /* synthetic */ boolean m2595$$Nest$fgetmUseLegacyFaceOnlySettings(SettingObserver r0) {
            return r0.mUseLegacyFaceOnlySettings;
        }

        public SettingObserver(Context context, Handler handler, List<EnabledOnKeyguardCallback> callbacks, UserManager userManager, FingerprintManager fingerprintManager, FaceManager faceManager) {
            super(handler);
            this.FACE_UNLOCK_KEYGUARD_ENABLED = Settings.Secure.getUriFor("face_unlock_keyguard_enabled");
            this.FACE_UNLOCK_APP_ENABLED = Settings.Secure.getUriFor("face_unlock_app_enabled");
            this.FACE_UNLOCK_ALWAYS_REQUIRE_CONFIRMATION = Settings.Secure.getUriFor("face_unlock_always_require_confirmation");
            this.BIOMETRIC_KEYGUARD_ENABLED = Settings.Secure.getUriFor("biometric_keyguard_enabled");
            this.BIOMETRIC_APP_ENABLED = Settings.Secure.getUriFor("biometric_app_enabled");
            this.FACE_KEYGUARD_ENABLED = Settings.Secure.getUriFor("face_keyguard_enabled");
            this.FACE_APP_ENABLED = Settings.Secure.getUriFor("face_app_enabled");
            this.FINGERPRINT_KEYGUARD_ENABLED = Settings.Secure.getUriFor("fingerprint_keyguard_enabled");
            this.FINGERPRINT_APP_ENABLED = Settings.Secure.getUriFor("fingerptint_app_enabled");
            this.MANDATORY_BIOMETRICS_ENABLED = Settings.Secure.getUriFor("mandatory_biometrics");
            this.MANDATORY_BIOMETRICS_REQUIREMENTS_SATISFIED = Settings.Secure.getUriFor("mandatory_biometrics_requirements_satisfied");
            this.mBiometricEnabledOnKeyguard = new HashMap();
            this.mBiometricEnabledForApps = new HashMap();
            this.mFaceEnabledOnKeyguard = new SparseBooleanArray();
            this.mFaceEnabledForApps = new SparseBooleanArray();
            this.mFingerprintEnabledOnKeyguard = new SparseBooleanArray();
            this.mFingerprintEnabledForApps = new SparseBooleanArray();
            this.mFaceAlwaysRequireConfirmation = new HashMap();
            this.mMandatoryBiometricsEnabled = new HashMap();
            this.mMandatoryBiometricsRequirementsSatisfied = new HashMap();
            this.mFingerprintEnrolledForUser = new HashMap();
            this.mFaceEnrolledForUser = new HashMap();
            this.mContentResolver = context.getContentResolver();
            this.mCallbacks = callbacks;
            this.mUserManager = userManager;
            boolean hasFingerprint = context.getPackageManager().hasSystemFeature("android.hardware.fingerprint");
            boolean hasFace = context.getPackageManager().hasSystemFeature("android.hardware.biometrics.face");
            if (Build.VERSION.DEVICE_INITIAL_SDK_INT > 29) goto L7;
            if (hasFace == false) goto L7;
            if (hasFingerprint == true) goto L7;
            boolean r2 = true;
        L8:
            this.mUseLegacyFaceOnlySettings = r2;
            addBiometricListenersForMandatoryBiometrics(context, fingerprintManager, faceManager);
            updateContentObserver();
            return;
        L7:
            r2 = false;
            goto L8
        }

        public void updateContentObserver() {
            this.mContentResolver.unregisterContentObserver(this);
            if (this.mUseLegacyFaceOnlySettings == false) goto L5;
            this.mContentResolver.registerContentObserver(this.FACE_UNLOCK_KEYGUARD_ENABLED, false, this, -1);
            this.mContentResolver.registerContentObserver(this.FACE_UNLOCK_APP_ENABLED, false, this, -1);
        L6:
            this.mContentResolver.registerContentObserver(this.FACE_UNLOCK_ALWAYS_REQUIRE_CONFIRMATION, false, this, -1);
            this.mContentResolver.registerContentObserver(this.MANDATORY_BIOMETRICS_ENABLED, false, this, -1);
            this.mContentResolver.registerContentObserver(this.MANDATORY_BIOMETRICS_REQUIREMENTS_SATISFIED, false, this, -1);
            return;
        L5:
            this.mContentResolver.registerContentObserver(this.BIOMETRIC_KEYGUARD_ENABLED, false, this, -1);
            this.mContentResolver.registerContentObserver(this.BIOMETRIC_APP_ENABLED, false, this, -1);
            goto L6
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean selfChange, Uri uri, int userId) {
            boolean r2 = false;
            if (this.FACE_UNLOCK_KEYGUARD_ENABLED.equals(uri) == false) goto L12;
            Map<Integer, Boolean> r0 = this.mBiometricEnabledOnKeyguard;
            Integer r4 = Integer.valueOf(userId);
            if (Settings.Secure.getIntForUser(this.mContentResolver, "face_unlock_keyguard_enabled", 1, userId) == 0) goto L7;
            r2 = true;
        L7:
            r0.put(r4, Boolean.valueOf(r2));
            if (userId != ActivityManager.getCurrentUser()) goto L75;
            if (selfChange == true) goto L76;
            notifyEnabledOnKeyguardCallbacks(userId, 8);
            return;
        L76:
            return;
        L75:
            return;
        L12:
            if (this.FACE_UNLOCK_APP_ENABLED.equals(uri) == false) goto L18;
            Map<Integer, Boolean> r1 = this.mBiometricEnabledForApps;
            Integer r3 = Integer.valueOf(userId);
            if (Settings.Secure.getIntForUser(this.mContentResolver, "face_unlock_app_enabled", 1, userId) == 0) goto L16;
            r2 = true;
        L16:
            r1.put(r3, Boolean.valueOf(r2));
            return;
        L18:
            if (this.FACE_UNLOCK_ALWAYS_REQUIRE_CONFIRMATION.equals(uri) == false) goto L24;
            Map<Integer, Boolean> r5 = this.mFaceAlwaysRequireConfirmation;
            Integer r6 = Integer.valueOf(userId);
            if (Settings.Secure.getIntForUser(this.mContentResolver, "face_unlock_always_require_confirmation", 0, userId) == 0) goto L22;
            r2 = true;
        L22:
            r5.put(r6, Boolean.valueOf(r2));
            return;
        L24:
            if (this.BIOMETRIC_KEYGUARD_ENABLED.equals(uri) == false) goto L33;
            Map<Integer, Boolean> r7 = this.mBiometricEnabledOnKeyguard;
            Integer r8 = Integer.valueOf(userId);
            if (Settings.Secure.getIntForUser(this.mContentResolver, "biometric_keyguard_enabled", 1, userId) == 0) goto L28;
            r2 = true;
        L28:
            r7.put(r8, Boolean.valueOf(r2));
            if (userId != ActivityManager.getCurrentUser()) goto L80;
            if (selfChange == true) goto L81;
            notifyEnabledOnKeyguardCallbacks(userId, 14);
            return;
        L81:
            return;
        L80:
            return;
        L33:
            if (this.FACE_KEYGUARD_ENABLED.equals(uri) == false) goto L42;
            SparseBooleanArray r9 = this.mFaceEnabledOnKeyguard;
            if (Settings.Secure.getIntForUser(this.mContentResolver, "face_keyguard_enabled", 1, userId) == 0) goto L37;
            r2 = true;
        L37:
            r9.put(userId, r2);
            if (userId != ActivityManager.getCurrentUser()) goto L83;
            if (selfChange == true) goto L84;
            notifyEnabledOnKeyguardCallbacks(userId, 8);
            return;
        L84:
            return;
        L83:
            return;
        L42:
            if (this.FINGERPRINT_KEYGUARD_ENABLED.equals(uri) == false) goto L51;
            SparseBooleanArray r10 = this.mFingerprintEnabledOnKeyguard;
            if (Settings.Secure.getIntForUser(this.mContentResolver, "fingerprint_keyguard_enabled", 1, userId) == 0) goto L46;
            r2 = true;
        L46:
            r10.put(userId, r2);
            if (userId != ActivityManager.getCurrentUser()) goto L86;
            if (selfChange == true) goto L87;
            notifyEnabledOnKeyguardCallbacks(userId, 2);
            return;
        L87:
            return;
        L86:
            return;
        L51:
            if (this.BIOMETRIC_APP_ENABLED.equals(uri) == false) goto L57;
            Map<Integer, Boolean> r11 = this.mBiometricEnabledForApps;
            Integer r12 = Integer.valueOf(userId);
            if (Settings.Secure.getIntForUser(this.mContentResolver, "biometric_app_enabled", 1, userId) == 0) goto L55;
            r2 = true;
        L55:
            r11.put(r12, Boolean.valueOf(r2));
            return;
        L57:
            if (this.FACE_APP_ENABLED.equals(uri) == false) goto L63;
            SparseBooleanArray r13 = this.mFaceEnabledForApps;
            if (Settings.Secure.getIntForUser(this.mContentResolver, "face_app_enabled", 1, userId) == 0) goto L61;
            r2 = true;
        L61:
            r13.put(userId, r2);
            return;
        L63:
            if (this.FINGERPRINT_APP_ENABLED.equals(uri) == false) goto L69;
            SparseBooleanArray r14 = this.mFingerprintEnabledForApps;
            if (Settings.Secure.getIntForUser(this.mContentResolver, "fingerptint_app_enabled", 1, userId) == 0) goto L67;
            r2 = true;
        L67:
            r14.put(userId, r2);
            return;
        L69:
            if (this.MANDATORY_BIOMETRICS_ENABLED.equals(uri) == false) goto L72;
            updateMandatoryBiometricsForAllProfiles(userId);
            return;
        L72:
            if (this.MANDATORY_BIOMETRICS_REQUIREMENTS_SATISFIED.equals(uri) == false) goto L93;
            updateMandatoryBiometricsRequirementsForAllProfiles(userId);
            return;
        }

        public boolean getEnabledOnKeyguard(int userId, int modality) {
            if (this.mBiometricEnabledOnKeyguard.containsKey(Integer.valueOf(userId)) == true) goto L9;
            if (this.mUseLegacyFaceOnlySettings == false) goto L7;
            onChange(true, this.FACE_UNLOCK_KEYGUARD_ENABLED, userId);
            goto L9
        L7:
            onChange(true, this.BIOMETRIC_KEYGUARD_ENABLED, userId);
        L9:
            return this.mBiometricEnabledOnKeyguard.get(Integer.valueOf(userId)).booleanValue();
        }

        public boolean getEnabledForApps(int userId, int modality) {
            if (this.mBiometricEnabledForApps.containsKey(Integer.valueOf(userId)) == true) goto L9;
            if (this.mUseLegacyFaceOnlySettings == false) goto L7;
            onChange(true, this.FACE_UNLOCK_APP_ENABLED, userId);
            goto L9
        L7:
            onChange(true, this.BIOMETRIC_APP_ENABLED, userId);
        L9:
            return this.mBiometricEnabledForApps.getOrDefault(Integer.valueOf(userId), true).booleanValue();
        }

        public boolean getConfirmationAlwaysRequired(int modality, int userId) {
            switch(modality) {
                case 8: goto L6;
                default: goto L3;
            };
        L3:
            return false;
        L6:
            if (this.mFaceAlwaysRequireConfirmation.containsKey(Integer.valueOf(userId)) == true) goto L9;
            onChange(true, this.FACE_UNLOCK_ALWAYS_REQUIRE_CONFIRMATION, userId);
        L9:
            return this.mFaceAlwaysRequireConfirmation.get(Integer.valueOf(userId)).booleanValue();
        }

        public boolean getMandatoryBiometricsEnabledAndRequirementsSatisfiedForUser(int userId) {
            if (this.mMandatoryBiometricsEnabled.containsKey(Integer.valueOf(userId)) == true) goto L6;
            updateMandatoryBiometricsForAllProfiles(userId);
        L6:
            if (this.mMandatoryBiometricsRequirementsSatisfied.containsKey(Integer.valueOf(userId)) == true) goto L9;
            updateMandatoryBiometricsRequirementsForAllProfiles(userId);
        L9:
            if (this.mMandatoryBiometricsEnabled.getOrDefault(Integer.valueOf(userId), false).booleanValue() == true) goto L11;
            return false;
        L11:
            if (this.mMandatoryBiometricsRequirementsSatisfied.getOrDefault(Integer.valueOf(userId), true).booleanValue() == true) goto L13;
            return false;
        L13:
            if (getBiometricStatusForIdentityCheck(userId) == true) goto L16;
            return false;
        L16:
            return true;
        }

        private boolean getBiometricStatusForIdentityCheck(int userId) {
            if (this.mFingerprintEnrolledForUser.getOrDefault(Integer.valueOf(userId), false).booleanValue() == true) goto L8;
            if (this.mFaceEnrolledForUser.getOrDefault(Integer.valueOf(userId), false).booleanValue() == true) goto L8;
            return false;
        L8:
            if (getEnabledForApps(userId, 14) == false) goto L13;
            return true;
        L13:
            return false;
        }

        void notifyEnabledOnKeyguardCallbacks(int userId, int modality) {
            List<EnabledOnKeyguardCallback> callbacks = this.mCallbacks;
            boolean enabled = getEnabledOnKeyguard(userId, modality);
            int i = 0;
        L4:
            if (i >= callbacks.size()) goto L7;
            callbacks.get(i).notify(enabled, userId, modality);
            i = i + 1;
            goto L4
        }

        private void updateMandatoryBiometricsForAllProfiles(int userId) {
            int effectiveUserId = userId;
            UserInfo parentProfile = this.mUserManager.getProfileParent(userId);
            if (parentProfile == null) goto L5;
            effectiveUserId = parentProfile.id;
        L5:
            int[] enabledProfileIds = this.mUserManager.getEnabledProfileIds(effectiveUserId);
            boolean r4 = true;
            if (enabledProfileIds == null) goto L15;
            int r6 = enabledProfileIds.length;
            int r7 = 0;
        L9:
            if (r7 >= r6) goto L24;
            int profileUserId = enabledProfileIds[r7];
            Map<Integer, Boolean> r9 = this.mMandatoryBiometricsEnabled;
            Integer r10 = Integer.valueOf(profileUserId);
            if (Settings.Secure.getIntForUser(this.mContentResolver, "mandatory_biometrics", 0, effectiveUserId) == 0) goto L13;
            boolean r11 = true;
        L14:
            r9.put(r10, Boolean.valueOf(r11));
            r7 = r7 + 1;
            goto L9
        L13:
            r11 = false;
            goto L14
        L24:
            return;
        L15:
            Map<Integer, Boolean> r8 = this.mMandatoryBiometricsEnabled;
            Integer r12 = Integer.valueOf(userId);
            if (Settings.Secure.getIntForUser(this.mContentResolver, "mandatory_biometrics", 0, effectiveUserId) != 0) goto L19;
            r4 = false;
        L19:
            r8.put(r12, Boolean.valueOf(r4));
        }

        private void updateMandatoryBiometricsRequirementsForAllProfiles(int userId) {
            int effectiveUserId = userId;
            UserInfo parentProfile = this.mUserManager.getProfileParent(userId);
            if (parentProfile == null) goto L5;
            effectiveUserId = parentProfile.id;
        L5:
            int[] enabledProfileIds = this.mUserManager.getEnabledProfileIds(effectiveUserId);
            boolean r4 = false;
            if (enabledProfileIds == null) goto L15;
            int r6 = enabledProfileIds.length;
            int r7 = 0;
        L9:
            if (r7 >= r6) goto L23;
            int profileUserId = enabledProfileIds[r7];
            Map<Integer, Boolean> r9 = this.mMandatoryBiometricsRequirementsSatisfied;
            Integer r10 = Integer.valueOf(profileUserId);
            if (Settings.Secure.getIntForUser(this.mContentResolver, "mandatory_biometrics_requirements_satisfied", 1, effectiveUserId) == 0) goto L13;
            boolean r11 = true;
        L14:
            r9.put(r10, Boolean.valueOf(r11));
            r7 = r7 + 1;
            goto L9
        L13:
            r11 = false;
            goto L14
        L23:
            return;
        L15:
            Map<Integer, Boolean> r8 = this.mMandatoryBiometricsRequirementsSatisfied;
            Integer r12 = Integer.valueOf(userId);
            if (Settings.Secure.getIntForUser(this.mContentResolver, "mandatory_biometrics_requirements_satisfied", 1, effectiveUserId) == 0) goto L18;
            r4 = true;
        L18:
            r8.put(r12, Boolean.valueOf(r4));
        }

        private void addBiometricListenersForMandatoryBiometrics(Context context, final FingerprintManager fingerprintManager, final FaceManager faceManager) {
            if (fingerprintManager == null) goto L4;
            fingerprintManager.addAuthenticatorsRegisteredCallback(new AnonymousClass1(this, fingerprintManager));
        L4:
            if (faceManager == null) goto L7;
            faceManager.addAuthenticatorsRegisteredCallback(new AnonymousClass2(this, faceManager));
            return;
        }
    }

    public static /* synthetic */ void $r8$lambda$CmVOENY8IdAaMEf_QUxGOSguP4U(BiometricService r0, int r1, PromptInfo r2, String r3, long r4, IBinder r6, long r7, IBiometricServiceReceiver r9) {
        r0.lambda$handleAuthenticate$2(r1, r2, r3, r4, r6, r7, r9);
    }

    /* JADX INFO: renamed from: $r8$lambda$CvTgGFu-J4JV962Mv6dITI6-xBY, reason: not valid java name */
    public static /* synthetic */ void m2565$r8$lambda$CvTgGFuJ4JV962Mv6dITI6xBY(BiometricService r0, long r1) {
        r0.lambda$createClientDeathReceiver$1(r1);
    }

    public static /* synthetic */ void $r8$lambda$JBJAJrsZwlWaoxKYP2XZFmwTfLA(BiometricService r0, long r1) {
        r0.lambda$createClientDeathReceiver$0(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmBiometricContext, reason: not valid java name */
    static /* bridge */ /* synthetic */ BiometricContext m2566$$Nest$fgetmBiometricContext(BiometricService r0) {
        return r0.mBiometricContext;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmBiometricNotificationLogger, reason: not valid java name */
    static /* bridge */ /* synthetic */ BiometricNotificationLogger m2567$$Nest$fgetmBiometricNotificationLogger(BiometricService r0) {
        return r0.mBiometricNotificationLogger;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmEnabledOnKeyguardCallbacks, reason: not valid java name */
    static /* bridge */ /* synthetic */ List m2568$$Nest$fgetmEnabledOnKeyguardCallbacks(BiometricService r0) {
        return r0.mEnabledOnKeyguardCallbacks;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmHandler, reason: not valid java name */
    static /* bridge */ /* synthetic */ Handler m2569$$Nest$fgetmHandler(BiometricService r0) {
        return r0.mHandler;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmRequestCounter, reason: not valid java name */
    static /* bridge */ /* synthetic */ Supplier m2570$$Nest$fgetmRequestCounter(BiometricService r0) {
        return r0.mRequestCounter;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmUserManager, reason: not valid java name */
    static /* bridge */ /* synthetic */ UserManager m2571$$Nest$fgetmUserManager(BiometricService r0) {
        return r0.mUserManager;
    }

    /* JADX INFO: renamed from: -$$Nest$mcreatePreAuthInfo, reason: not valid java name */
    static /* bridge */ /* synthetic */ PreAuthInfo m2572$$Nest$mcreatePreAuthInfo(BiometricService r0, String r1, int r2, int r3) {
        return r0.createPreAuthInfo(r1, r2, r3);
    }

    /* JADX INFO: renamed from: -$$Nest$mdumpInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2573$$Nest$mdumpInternal(BiometricService r0, PrintWriter r1) {
        r0.dumpInternal(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mgetSensorForId, reason: not valid java name */
    static /* bridge */ /* synthetic */ BiometricSensor m2574$$Nest$mgetSensorForId(BiometricService r0, int r1) {
        return r0.getSensorForId(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mhandleAuthenticate, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2575$$Nest$mhandleAuthenticate(BiometricService r0, IBinder r1, long r2, long r4, int r6, IBiometricServiceReceiver r7, String r8, PromptInfo r9) {
        r0.handleAuthenticate(r1, r2, r4, r6, r7, r8, r9);
    }

    /* JADX INFO: renamed from: -$$Nest$mhandleAuthenticationRejected, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2576$$Nest$mhandleAuthenticationRejected(BiometricService r0, long r1, int r3) {
        r0.handleAuthenticationRejected(r1, r3);
    }

    /* JADX INFO: renamed from: -$$Nest$mhandleAuthenticationSucceeded, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2577$$Nest$mhandleAuthenticationSucceeded(BiometricService r0, long r1, int r3, byte[] r4) {
        r0.handleAuthenticationSucceeded(r1, r3, r4);
    }

    /* JADX INFO: renamed from: -$$Nest$mhandleAuthenticationTimedOut, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2578$$Nest$mhandleAuthenticationTimedOut(BiometricService r0, long r1, int r3, int r4, int r5, int r6) {
        r0.handleAuthenticationTimedOut(r1, r3, r4, r5, r6);
    }

    /* JADX INFO: renamed from: -$$Nest$mhandleCancelAuthentication, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2579$$Nest$mhandleCancelAuthentication(BiometricService r0, long r1) {
        r0.handleCancelAuthentication(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mhandleOnAcquired, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2580$$Nest$mhandleOnAcquired(BiometricService r0, long r1, int r3, int r4, int r5) {
        r0.handleOnAcquired(r1, r3, r4, r5);
    }

    /* JADX INFO: renamed from: -$$Nest$mhandleOnDeviceCredentialPressed, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2581$$Nest$mhandleOnDeviceCredentialPressed(BiometricService r0, long r1) {
        r0.handleOnDeviceCredentialPressed(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mhandleOnDialogAnimatedIn, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2582$$Nest$mhandleOnDialogAnimatedIn(BiometricService r0, long r1, boolean r3) {
        r0.handleOnDialogAnimatedIn(r1, r3);
    }

    /* JADX INFO: renamed from: -$$Nest$mhandleOnDismissed, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2583$$Nest$mhandleOnDismissed(BiometricService r0, long r1, int r3, byte[] r4) {
        r0.handleOnDismissed(r1, r3, r4);
    }

    /* JADX INFO: renamed from: -$$Nest$mhandleOnError, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2584$$Nest$mhandleOnError(BiometricService r0, long r1, int r3, int r4, int r5, int r6) {
        r0.handleOnError(r1, r3, r4, r5, r6);
    }

    /* JADX INFO: renamed from: -$$Nest$mhandleOnReadyForAuthentication, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2585$$Nest$mhandleOnReadyForAuthentication(BiometricService r0, long r1, int r3) {
        r0.handleOnReadyForAuthentication(r1, r3);
    }

    /* JADX INFO: renamed from: -$$Nest$mhandleOnStartFingerprintNow, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2586$$Nest$mhandleOnStartFingerprintNow(BiometricService r0, long r1) {
        r0.handleOnStartFingerprintNow(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mhandleOnSystemEvent, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2587$$Nest$mhandleOnSystemEvent(BiometricService r0, long r1, int r3) {
        r0.handleOnSystemEvent(r1, r3);
    }

    /* JADX INFO: renamed from: -$$Nest$mhandleOnTryAgainPressed, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2588$$Nest$mhandleOnTryAgainPressed(BiometricService r0, long r1) {
        r0.handleOnTryAgainPressed(r1);
    }

    static /* synthetic */ void access$000(BiometricService x0, String x1, IBinder x2) {
        x0.publishBinderService(x1, x2);
    }

    private IBiometricSensorReceiver createBiometricSensorReceiver(long requestId) {
        return new AnonymousClass1(this, requestId);
    }

    private IBiometricSysuiReceiver createSysuiReceiver(long requestId) {
        return new AnonymousClass2(this, requestId);
    }

    private AuthSession.ClientDeathReceiver createClientDeathReceiver(final long requestId) {
        return new BiometricService$$ExternalSyntheticLambda0(this, requestId);
    }

    private /* synthetic */ void lambda$createClientDeathReceiver$0(long requestId) {
        handleClientDied(requestId);
    }

    private /* synthetic */ void lambda$createClientDeathReceiver$1(final long requestId) {
        this.mHandler.post(new BiometricService$$ExternalSyntheticLambda1(this, requestId));
    }

    private void checkInternalPermission() {
        getContext().enforceCallingOrSelfPermission("android.permission.USE_BIOMETRIC_INTERNAL", "Must have USE_BIOMETRIC_INTERNAL permission");
    }

    private PreAuthInfo createPreAuthInfo(String opPackageName, int userId, int authenticators) throws RemoteException {
        PromptInfo promptInfo = new PromptInfo();
        promptInfo.setAuthenticators(authenticators);
        return PreAuthInfo.create(this.mTrustManager, this.mDevicePolicyManager, this.mSettingObserver, this.mSensors, userId, promptInfo, opPackageName, false, getContext(), this.mBiometricCameraManager, this.mUserManager);
    }

    public BiometricService(Context context) {
        this(context, new Injector(), BiometricHandlerProvider.getInstance());
    }

    BiometricService(Context context, Injector injector, BiometricHandlerProvider biometricHandlerProvider) {
        super(context);
        this.mRandom = new Random();
        this.mSensors = new CopyOnWriteArrayList();
        this.mInjector = injector;
        this.mHandler = biometricHandlerProvider.getBiometricCallbackHandler();
        this.mDevicePolicyManager = this.mInjector.getDevicePolicyManager(context);
        this.mImpl = new BiometricServiceWrapper(this, null);
        this.mEnabledOnKeyguardCallbacks = new ArrayList();
        this.mSettingObserver = this.mInjector.getSettingObserver(context, this.mHandler, this.mEnabledOnKeyguardCallbacks);
        this.mRequestCounter = this.mInjector.getRequestGenerator();
        this.mBiometricContext = injector.getBiometricContext(context);
        this.mUserManager = injector.getUserManager(context);
        this.mBiometricCameraManager = injector.getBiometricCameraManager(context);
        this.mKeyStoreAuthorization = injector.getKeyStoreAuthorization();
        this.mGateKeeper = injector.getGateKeeperService();
        this.mBiometricNotificationLogger = injector.getNotificationLogger();
        injector.getActivityManagerService().registerUserSwitchObserver(new AnonymousClass3(this), BiometricService.class.getName());     // Catch: RemoteException -> L5
        return;
    L5:
        e = move-exception;
        Slog.e(TAG, "Failed to register user switch observer", e);
    }

    @Override // com.android.server.SystemService
    public void onStart() {
        this.mStatusBarService = this.mInjector.getStatusBarService();
        this.mTrustManager = this.mInjector.getTrustManager();
        this.mInjector.publishBinderService(this, this.mImpl);
        this.mBiometricStrengthController = this.mInjector.getBiometricStrengthController(this);
        this.mBiometricStrengthController.startListening();
        this.mHandler.post(new AnonymousClass4(this));
    }

    private boolean isStrongBiometric(int id) {
        Iterator<BiometricSensor> r0 = this.mSensors.iterator();
    L4:
        if (r0.hasNext() == false) goto L10;
        BiometricSensor sensor = r0.next();
        if (sensor.id != id) goto L4;
        return Utils.isAtLeastStrength(sensor.getCurrentStrength(), 15);
    L10:
        Slog.e(TAG, "Unknown sensorId: " + id);
        return false;
    }

    private AuthSession getAuthSessionIfCurrent(long requestId) {
        AuthSession session = this.mAuthSession;
        if (session != null) goto L5;
        return null;
    L5:
        if (session.getRequestId() != requestId) goto L9;
        return session;
    L9:
        return null;
    }

    private void handleAuthenticationSucceeded(long requestId, int sensorId, byte[] token) {
        Slog.v(TAG, "handleAuthenticationSucceeded(), sensorId: " + sensorId);
        AuthSession session = getAuthSessionIfCurrent(requestId);
        if (session != null) goto L6;
        Slog.e(TAG, "handleAuthenticationSucceeded: AuthSession is null");
        return;
    L6:
        session.onAuthenticationSucceeded(sensorId, isStrongBiometric(sensorId), token);
    }

    private void handleAuthenticationRejected(long requestId, int sensorId) {
        Slog.v(TAG, "handleAuthenticationRejected()");
        AuthSession session = getAuthSessionIfCurrent(requestId);
        if (session != null) goto L6;
        Slog.w(TAG, "handleAuthenticationRejected: AuthSession is not current");
        return;
    L6:
        session.onAuthenticationRejected(sensorId);
    }

    private void handleAuthenticationTimedOut(long requestId, int sensorId, int cookie, int error, int vendorCode) {
        Slog.v(TAG, "handleAuthenticationTimedOut(), sensorId: " + sensorId + ", cookie: " + cookie + ", error: " + error + ", vendorCode: " + vendorCode);
        AuthSession session = getAuthSessionIfCurrent(requestId);
        if (session != null) goto L6;
        Slog.w(TAG, "handleAuthenticationTimedOut: AuthSession is not current");
        return;
    L6:
        session.onAuthenticationTimedOut(sensorId, cookie, error, vendorCode);
    }

    private void handleOnError(long requestId, int sensorId, int cookie, int error, int vendorCode) {
        Slog.d(TAG, "handleOnError() sensorId: " + sensorId + ", cookie: " + cookie + ", error: " + error + ", vendorCode: " + vendorCode);
        AuthSession session = getAuthSessionIfCurrent(requestId);
        if (session != null) goto L15;
        Slog.w(TAG, "handleOnError: AuthSession is not current");
        return;
    L15:
        boolean finished = session.onErrorReceived(sensorId, cookie, error, vendorCode);     // Catch: RemoteException -> L10
        if (finished == false) goto L17;
        Slog.d(TAG, "handleOnError: AuthSession finished");     // Catch: RemoteException -> L10
        this.mAuthSession = null;     // Catch: RemoteException -> L10
        return;
    L17:
        return;
    L10:
        e = move-exception;
        Slog.e(TAG, "RemoteException", e);
    }

    private void handleOnAcquired(long requestId, int sensorId, int acquiredInfo, int vendorCode) {
        AuthSession session = getAuthSessionIfCurrent(requestId);
        if (session != null) goto L6;
        Slog.w(TAG, "onAcquired: AuthSession is not current");
        return;
    L6:
        session.onAcquired(sensorId, acquiredInfo, vendorCode);
    }

    private void handleOnDismissed(long requestId, int reason, byte[] credentialAttestation) {
        AuthSession session = getAuthSessionIfCurrent(requestId);
        if (session != null) goto L6;
        Slog.e(TAG, "onDismissed: " + reason + ", AuthSession is not current");
        return;
    L6:
        session.onDialogDismissed(reason, credentialAttestation);
        this.mAuthSession = null;
    }

    private void handleOnTryAgainPressed(long requestId) {
        Slog.d(TAG, "onTryAgainPressed");
        AuthSession session = getAuthSessionIfCurrent(requestId);
        if (session != null) goto L6;
        Slog.w(TAG, "handleOnTryAgainPressed: AuthSession is not current");
        return;
    L6:
        session.onTryAgainPressed();
    }

    private void handleOnDeviceCredentialPressed(long requestId) {
        Slog.d(TAG, "onDeviceCredentialPressed");
        AuthSession session = getAuthSessionIfCurrent(requestId);
        if (session != null) goto L6;
        Slog.w(TAG, "handleOnDeviceCredentialPressed: AuthSession is not current");
        return;
    L6:
        session.onDeviceCredentialPressed();
    }

    private void handleOnSystemEvent(long requestId, int event) {
        Slog.d(TAG, "onSystemEvent: " + event);
        AuthSession session = getAuthSessionIfCurrent(requestId);
        if (session != null) goto L6;
        Slog.w(TAG, "handleOnSystemEvent: AuthSession is not current");
        return;
    L6:
        session.onSystemEvent(event);
    }

    private void handleClientDied(long requestId) {
        AuthSession session = getAuthSessionIfCurrent(requestId);
        if (session != null) goto L6;
        Slog.w(TAG, "handleClientDied: AuthSession is not current");
        return;
    L6:
        Slog.e(TAG, "Session: " + session);
        boolean finished = session.onClientDied();
        if (finished == false) goto L10;
        this.mAuthSession = null;
        return;
    }

    private void handleOnDialogAnimatedIn(long requestId, boolean startFingerprintNow) {
        Slog.d(TAG, "handleOnDialogAnimatedIn requestId=" + requestId + " startFingerprintNow=" + startFingerprintNow);
        AuthSession session = getAuthSessionIfCurrent(requestId);
        if (session != null) goto L6;
        Slog.w(TAG, "handleOnDialogAnimatedIn: AuthSession is not current");
        return;
    L6:
        session.onDialogAnimatedIn(startFingerprintNow);
    }

    private void handleOnStartFingerprintNow(long requestId) {
        Slog.d(TAG, "handleOnStartFingerprintNow");
        AuthSession session = getAuthSessionIfCurrent(requestId);
        if (session != null) goto L6;
        Slog.w(TAG, "handleOnStartFingerprintNow: AuthSession is not current");
        return;
    L6:
        session.onStartFingerprint();
    }

    private void handleOnReadyForAuthentication(long requestId, int cookie) {
        AuthSession session = getAuthSessionIfCurrent(requestId);
        if (session != null) goto L6;
        Slog.w(TAG, "handleOnReadyForAuthentication: AuthSession is not current");
        return;
    L6:
        session.onCookieReceived(cookie);
    }

    private void handleAuthenticate(final IBinder token, final long requestId, final long operationId, final int userId, final IBiometricServiceReceiver receiver, final String opPackageName, final PromptInfo promptInfo) {
        this.mHandler.post(new BiometricService$$ExternalSyntheticLambda2(this, userId, promptInfo, opPackageName, requestId, token, operationId, receiver));
    }

    private /* synthetic */ void lambda$handleAuthenticate$2(int userId, PromptInfo promptInfo, String opPackageName, long requestId, IBinder token, long operationId, IBiometricServiceReceiver receiver) {
        PreAuthInfo preAuthInfo = PreAuthInfo.create(this.mTrustManager, this.mDevicePolicyManager, this.mSettingObserver, this.mSensors, userId, promptInfo, opPackageName, promptInfo.isDisallowBiometricsIfPolicyExists(), getContext(), this.mBiometricCameraManager, this.mUserManager);     // Catch: RemoteException -> L8
        if (promptInfo.isUseDefaultTitle() == true) goto L6;
    L10:
        int eligible = preAuthInfo.getEligibleModalities();     // Catch: RemoteException -> L8
        boolean r3 = true;
        if ((eligible & 2) != 2) goto L13;
        boolean r2 = true;
    L14:
        boolean hasEligibleFingerprintSensor = r2;
        if ((eligible & 8) == 8) goto L18;
        r3 = false;
    L18:
        boolean hasEligibleFaceSensor = r3;
        if (promptInfo.isUseDefaultSubtitle() == false) goto L28;
        if (hasEligibleFingerprintSensor == false) goto L23;
        if (hasEligibleFaceSensor == false) goto L23;
        promptInfo.setSubtitle(getContext().getString(R.string.capability_desc_canRetrieveWindowContent));     // Catch: RemoteException -> L8
    L23:
        if (hasEligibleFingerprintSensor == false) goto L25;
        promptInfo.setSubtitle(getContext().getString(R.string.harmful_app_warning_open_anyway));     // Catch: RemoteException -> L8
        goto L28
    L25:
        if (hasEligibleFaceSensor == false) goto L27;
        promptInfo.setSubtitle(getContext().getString(R.string.font_family_button_material));     // Catch: RemoteException -> L8
        goto L28
    L27:
        promptInfo.setSubtitle(getContext().getString(R.string.usb_device_resolve_prompt_warn));     // Catch: RemoteException -> L8
    L28:
        Pair<Integer, Integer> preAuthStatus = preAuthInfo.getPreAuthenticateStatus();     // Catch: RemoteException -> L8
        Slog.d(TAG, "handleAuthenticate: modality(" + preAuthStatus.first + "), status(" + preAuthStatus.second + "), preAuthInfo: " + preAuthInfo + " requestId: " + requestId + " promptInfo.isIgnoreEnrollmentState: " + promptInfo.isIgnoreEnrollmentState());     // Catch: RemoteException -> L8
        if (((Integer) preAuthStatus.second).intValue() != 0) goto L46;
        if (preAuthInfo.credentialRequested == true) goto L33;
    L37:
        authenticateInternal(token, requestId, operationId, preAuthInfo.userId, receiver, opPackageName, promptInfo, preAuthInfo);     // Catch: RemoteException -> L8
        return;
    L33:
        if (preAuthInfo.credentialAvailable == false) goto L37;
        if (preAuthInfo.eligibleSensors.isEmpty() == false) goto L37;
        promptInfo.setAuthenticators(32768);     // Catch: RemoteException -> L8
        goto L37
    L46:
        receiver.onError(((Integer) preAuthStatus.first).intValue(), ((Integer) preAuthStatus.second).intValue(), 0);     // Catch: RemoteException -> L42
        return;
    L42:
        e = e;
    L43:
        Slog.e(TAG, "Remote exception", e);
        return;
    L13:
        r2 = false;
        goto L14
    L6:
        if (TextUtils.isEmpty(promptInfo.getTitle()) == false) goto L10;
        promptInfo.setTitle(getContext().getString(R.string.capability_desc_canTakeScreenshot));     // Catch: RemoteException -> L8
    L8:
        e = e;
        goto L43
    }

    private void authenticateInternal(IBinder token, long requestId, long operationId, int userId, IBiometricServiceReceiver receiver, String opPackageName, PromptInfo promptInfo, PreAuthInfo preAuthInfo) {
        Slog.d(TAG, "Creating authSession with authRequest: " + preAuthInfo);
        if (this.mAuthSession == null) goto L5;
        Slog.w(TAG, "Existing AuthSession: " + this.mAuthSession);
        this.mAuthSession.onCancelAuthSession(true);
        this.mAuthSession = null;
    L5:
        boolean debugEnabled = this.mInjector.isDebugEnabled(getContext(), userId);
        this.mAuthSession = new AuthSession(getContext(), this.mBiometricContext, this.mStatusBarService, createSysuiReceiver(requestId), this.mKeyStoreAuthorization, this.mRandom, createClientDeathReceiver(requestId), preAuthInfo, token, requestId, operationId, userId, createBiometricSensorReceiver(requestId), receiver, opPackageName, promptInfo, debugEnabled, this.mInjector.getFingerprintSensorProperties(getContext()));
        this.mAuthSession.goToInitialState();     // Catch: RemoteException -> L8
        return;
    L8:
        e = move-exception;
        Slog.e(TAG, "RemoteException", e);
    }

    private void handleCancelAuthentication(long requestId) {
        AuthSession session = getAuthSessionIfCurrent(requestId);
        if (session != null) goto L6;
        Slog.w(TAG, "handleCancelAuthentication: AuthSession is not current");
        return;
    L6:
        boolean finished = session.onCancelAuthSession(false);
        if (finished == false) goto L10;
        Slog.d(TAG, "handleCancelAuthentication: AuthSession finished");
        this.mAuthSession = null;
        return;
    }

    private BiometricSensor getSensorForId(int sensorId) {
        Iterator<BiometricSensor> r0 = this.mSensors.iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        BiometricSensor sensor = r0.next();
        if (sensor.id != sensorId) goto L4;
        return sensor;
    L9:
        return null;
    }

    private void dumpInternal(PrintWriter pw) {
        pw.println("Legacy Settings: " + SettingObserver.m2595$$Nest$fgetmUseLegacyFaceOnlySettings(this.mSettingObserver));
        pw.println();
        pw.println("Sensors:");
        Iterator<BiometricSensor> r1 = this.mSensors.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        pw.println(" " + r1.next());
        goto L4
    L6:
        int currentUserId = ActivityManager.getCurrentUser();
        pw.println("AuthenticatorIds for current user: " + currentUserId);
        Iterator<BiometricSensor> r2 = this.mSensors.iterator();
    L8:
        if (r2.hasNext() == false) goto L15;
        BiometricSensor sensor = r2.next();
        boolean hasEnrollments = sensor.impl.hasEnrolledTemplates(currentUserId, getContext().getOpPackageName());     // Catch: RemoteException -> L12
        long authenticatorId = sensor.impl.getAuthenticatorId(currentUserId);     // Catch: RemoteException -> L12
        pw.println(" sensorId=" + sensor.id + " modality=" + sensor.modality + " strength=" + sensor.getCurrentStrength() + " hasEnrollments=" + hasEnrollments + " authenticatorId=" + authenticatorId);     // Catch: RemoteException -> L12
    L12:
        e = move-exception;
        pw.println(" sensorId=" + sensor.id + " error=" + e);
        goto L8
    L15:
        pw.println();
        pw.println("CurrentSession: " + this.mAuthSession);
        pw.println();
    }
}
