package com.android.server.biometrics.sensors.fingerprint;

import android.R;
import android.app.ActivityManager;
import android.app.AppOpsManager;
import android.app.doppelganger.DoppelgangerManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.hardware.biometrics.AuthenticationStateListener;
import android.hardware.biometrics.BiometricPrompt;
import android.hardware.biometrics.IBiometricSensorReceiver;
import android.hardware.biometrics.IBiometricService;
import android.hardware.biometrics.IBiometricServiceLockoutResetCallback;
import android.hardware.biometrics.IBiometricStateListener;
import android.hardware.biometrics.IInvalidationCallback;
import android.hardware.biometrics.ITestSession;
import android.hardware.biometrics.ITestSessionCallback;
import android.hardware.biometrics.fingerprint.IFingerprint;
import android.hardware.biometrics.fingerprint.PointerContext;
import android.hardware.biometrics.fingerprint.SensorProps;
import android.hardware.fingerprint.Fingerprint;
import android.hardware.fingerprint.FingerprintAuthenticateOptions;
import android.hardware.fingerprint.FingerprintEnrollOptions;
import android.hardware.fingerprint.FingerprintSensorConfigurations;
import android.hardware.fingerprint.FingerprintSensorPropertiesInternal;
import android.hardware.fingerprint.IFingerprintAuthenticatorsRegisteredCallback;
import android.hardware.fingerprint.IFingerprintClientActiveCallback;
import android.hardware.fingerprint.IFingerprintService;
import android.hardware.fingerprint.IFingerprintServiceReceiver;
import android.hardware.fingerprint.IUdfpsOverlayController;
import android.os.Binder;
import android.os.Build;
import android.os.CancellationSignal;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.os.ServiceManager;
import android.os.ShellCallback;
import android.os.UserHandle;
import android.os.UserManager;
import android.pico.utils.ExtImplFactory;
import android.util.EventLog;
import android.util.Pair;
import android.util.Slog;
import android.util.proto.ProtoOutputStream;
import com.android.internal.util.ArrayUtils;
import com.android.internal.util.DumpUtils;
import com.android.internal.widget.LockPatternUtils;
import com.android.server.SystemService;
import com.android.server.biometrics.Utils;
import com.android.server.biometrics.log.BiometricContext;
import com.android.server.biometrics.sensors.AuthenticationStateListeners;
import com.android.server.biometrics.sensors.BiometricStateCallback;
import com.android.server.biometrics.sensors.ClientMonitorCallbackConverter;
import com.android.server.biometrics.sensors.LockoutResetDispatcher;
import com.android.server.biometrics.sensors.fingerprint.aidl.FingerprintProvider;
import com.android.server.companion.virtual.VirtualDeviceManagerInternal;
import com.android.server.slice.SliceClientPermissions;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.function.Supplier;

/* JADX INFO: loaded from: classes.dex */
public class FingerprintService extends SystemService {
    protected static final String TAG = "FingerprintService";
    private final Supplier<String[]> mAidlInstanceNameSupplier;
    private final AppOpsManager mAppOps;
    private final AuthenticationStateListeners mAuthenticationStateListeners;
    private final BiometricContext mBiometricContext;
    private final BiometricStateCallback<ServiceProvider, FingerprintSensorPropertiesInternal> mBiometricStateCallback;
    private IExtFingerprintService mExt;
    private final Function<String, FingerprintProvider> mFingerprintProvider;
    private final FingerprintProviderFunction mFingerprintProviderFunction;
    private final GestureAvailabilityDispatcher mGestureAvailabilityDispatcher;
    private final Handler mHandler;
    private final LockPatternUtils mLockPatternUtils;
    private final LockoutResetDispatcher mLockoutResetDispatcher;
    protected final FingerprintServiceRegistry mRegistry;
    final IFingerprintService.Stub mServiceWrapper;

    /* JADX INFO: renamed from: com.android.server.biometrics.sensors.fingerprint.FingerprintService$1, reason: invalid class name */
    class AnonymousClass1 extends IFingerprintService.Stub {
        final /* synthetic */ FingerprintService this$0;

        public static /* synthetic */ List $r8$lambda$_BEBxLUTKEeIgd9BylFMy0pEZcM(AnonymousClass1 r0, FingerprintSensorConfigurations r1) {
            return r0.lambda$registerAuthenticators$1(r1);
        }

        public static /* synthetic */ void $r8$lambda$g64zBxQcWdBvj9LH6t6Qh5SbgVw(IFingerprintServiceReceiver r0, DialogInterface r1, int r2) {
            lambda$authenticateWithPrompt$0(r0, r1, r2);
        }

        AnonymousClass1(FingerprintService this$0) {
            this.this$0 = this$0;
        }

        public ITestSession createTestSession(int sensorId, ITestSessionCallback callback, String opPackageName) {
            super.createTestSession_enforcePermission();
            ServiceProvider provider = this.this$0.mRegistry.getProviderForSensor(sensorId);
            if (provider != null) goto L7;
            Slog.w(FingerprintService.TAG, "Null provider for createTestSession, sensorId: " + sensorId);
            return null;
        L7:
            return provider.createTestSession(sensorId, callback, opPackageName);
        }

        public byte[] dumpSensorServiceStateProto(int sensorId, boolean clearSchedulerBuffer) {
            super.dumpSensorServiceStateProto_enforcePermission();
            ProtoOutputStream proto = new ProtoOutputStream();
            ServiceProvider provider = this.this$0.mRegistry.getProviderForSensor(sensorId);
            if (provider == null) goto L5;
            provider.dumpProtoState(sensorId, proto, clearSchedulerBuffer);
        L5:
            proto.flush();
            return proto.getBytes();
        }

        public List<FingerprintSensorPropertiesInternal> getSensorPropertiesInternal(String opPackageName) {
            if (this.this$0.getContext().checkCallingOrSelfPermission("android.permission.USE_BIOMETRIC_INTERNAL") == 0) goto L6;
            Utils.checkPermission(this.this$0.getContext(), "android.permission.TEST_BIOMETRIC");
        L6:
            return this.this$0.mRegistry.getAllProperties();
        }

        public FingerprintSensorPropertiesInternal getSensorProperties(int sensorId, String opPackageName) {
            super.getSensorProperties_enforcePermission();
            ServiceProvider provider = this.this$0.mRegistry.getProviderForSensor(sensorId);
            if (provider != null) goto L7;
            Slog.w(FingerprintService.TAG, "No matching sensor for getSensorProperties, sensorId: " + sensorId + ", caller: " + opPackageName);
            return null;
        L7:
            return provider.getSensorProperties(sensorId);
        }

        public void generateChallenge(IBinder token, int sensorId, int userId, IFingerprintServiceReceiver receiver, String opPackageName) {
            super.generateChallenge_enforcePermission();
            ServiceProvider provider = this.this$0.mRegistry.getProviderForSensor(sensorId);
            if (provider != null) goto L6;
            Slog.w(FingerprintService.TAG, "No matching sensor for generateChallenge, sensorId: " + sensorId);
            return;
        L6:
            provider.scheduleGenerateChallenge(sensorId, userId, token, receiver, opPackageName);
        }

        public void revokeChallenge(IBinder token, int sensorId, int userId, String opPackageName, long challenge) {
            super.revokeChallenge_enforcePermission();
            ServiceProvider provider = this.this$0.mRegistry.getProviderForSensor(sensorId);
            if (provider != null) goto L6;
            Slog.w(FingerprintService.TAG, "No matching sensor for revokeChallenge, sensorId: " + sensorId);
            return;
        L6:
            provider.scheduleRevokeChallenge(sensorId, userId, token, opPackageName, challenge);
        }

        public long enroll(IBinder token, byte[] hardwareAuthToken, int userId, IFingerprintServiceReceiver receiver, String opPackageName, int enrollReason, FingerprintEnrollOptions options) {
            super.enroll_enforcePermission();
            long enrollId = FingerprintService.m2695$$Nest$fgetmExt(this.this$0).enroll(token, hardwareAuthToken, userId, receiver, opPackageName, enrollReason, options);
            if (enrollId >= 0) goto L10;
            Slog.e(FingerprintService.TAG, "enroll failed, fallback to default");
            Pair<Integer, ServiceProvider> provider = this.this$0.mRegistry.getSingleProvider();
            if (provider != null) goto L9;
            Slog.w(FingerprintService.TAG, "Null provider for enroll");
            return -1;
        L9:
            return ((ServiceProvider) provider.second).scheduleEnroll(((Integer) provider.first).intValue(), token, hardwareAuthToken, userId, receiver, opPackageName, enrollReason, options);
        L10:
            return enrollId;
        }

        public void cancelEnrollment(IBinder token, long requestId) {
            super.cancelEnrollment_enforcePermission();
            int ret = FingerprintService.m2695$$Nest$fgetmExt(this.this$0).cancelEnrollment(token, requestId);
            if (ret >= 0) goto L10;
            Slog.e(FingerprintService.TAG, "enroll failed, fallback to default");
            Pair<Integer, ServiceProvider> provider = this.this$0.mRegistry.getSingleProvider();
            if (provider != null) goto L8;
            Slog.w(FingerprintService.TAG, "Null provider for cancelEnrollment");
            return;
        L8:
            ((ServiceProvider) provider.second).cancelEnrollment(((Integer) provider.first).intValue(), token, requestId);
            return;
        }

        public long authenticate(IBinder token, long operationId, IFingerprintServiceReceiver receiver, FingerprintAuthenticateOptions options) {
            int callingUid = Binder.getCallingUid();
            int callingPid = Binder.getCallingPid();
            int callingUserId = UserHandle.getCallingUserId();
            String opPackageName = options.getOpPackageName();
            String attributionTag = options.getAttributionTag();
            int userId = options.getUserId();
            if (FingerprintService.m2699$$Nest$mcanUseFingerprint(this.this$0, opPackageName, attributionTag, true, callingUid, callingPid, callingUserId) == true) goto L6;
            Slog.w(FingerprintService.TAG, "Authenticate rejecting package: " + opPackageName);
            return -1;
        L6:
            boolean isKeyguard = Utils.isKeyguard(this.this$0.getContext(), opPackageName);
            long identity1 = Binder.clearCallingIdentity();
            if (isKeyguard == true) goto L73;
        L16:
            Binder.restoreCallingIdentity(identity1);
            if (this.this$0.getContext().checkCallingPermission("android.permission.MANAGE_FINGERPRINT") == 0) goto L19;
            boolean restricted = true;
        L20:
            if (isKeyguard == false) goto L22;
            int statsClient = 1;
        L24:
            if (options.getSensorId() != (-1)) goto L26;
            Pair<Integer, ServiceProvider> provider = this.this$0.mRegistry.getSingleProvider();
        L27:
            if (provider != null) goto L30;
            Slog.w(FingerprintService.TAG, "Null provider for authenticate");
            return -1;
        L30:
            options.setSensorId(((Integer) provider.first).intValue());
            FingerprintSensorPropertiesInternal sensorProps = ((ServiceProvider) provider.second).getSensorProperties(options.getSensorId());
            if (isKeyguard == true) goto L54;
            if (Utils.isSettings(this.this$0.getContext(), opPackageName) == true) goto L54;
            if (sensorProps == null) goto L54;
            if (sensorProps.isAnyUdfpsType() == false) goto L38;
        L71:
            return authenticateWithPrompt(operationId, sensorProps, callingUid, callingUserId, receiver, opPackageName, options.isIgnoreEnrollmentState());
        L47:
            e = e;
        L51:
            Slog.e(FingerprintService.TAG, "Invalid package", e);
            return -1;
        L49:
            e = e;
            goto L51
        L38:
            if (sensorProps.isAnySidefpsType() == true) goto L71;
        L54:
            long identity2 = Binder.clearCallingIdentity();
            VirtualDeviceManagerInternal vdm = (VirtualDeviceManagerInternal) FingerprintService.access$000(this.this$0, VirtualDeviceManagerInternal.class);     // Catch: Throwable -> L63
            if (vdm != null) goto L75;
        L61:
            Binder.restoreCallingIdentity(identity2);
            long requestId = ((ServiceProvider) provider.second).scheduleAuthenticate(token, operationId, 0, new ClientMonitorCallbackConverter(receiver), options, restricted, statsClient, isKeyguard);
            FingerprintService.m2695$$Nest$fgetmExt(this.this$0).recordAuthInfo(requestId, options.getSensorId());
            return requestId;
        L75:
            vdm.onAuthenticationPrompt(callingUid);     // Catch: Throwable -> L59
        L59:
            th = th;
        L65:
            Binder.restoreCallingIdentity(identity2);
            throw th;
        L63:
            th = th;
            goto L65
        L26:
            Utils.checkPermission(this.this$0.getContext(), "android.permission.USE_BIOMETRIC_INTERNAL");
            provider = new Pair(Integer.valueOf(options.getSensorId()), this.this$0.mRegistry.getProviderForSensor(options.getSensorId()));
            goto L27
        L22:
            statsClient = 3;
            goto L24
        L19:
            restricted = false;
            goto L20
        L73:
        L13:
            th = move-exception;
            Binder.restoreCallingIdentity(identity1);
            throw th;
        L9:
            if (Utils.isUserEncryptedOrLockdown(FingerprintService.m2697$$Nest$fgetmLockPatternUtils(this.this$0), userId) == false) goto L16;
            EventLog.writeEvent(1397638484, "79776455");     // Catch: Throwable -> L13
            Slog.e(FingerprintService.TAG, "Authenticate invoked when user is encrypted or lockdown");     // Catch: Throwable -> L13
            Binder.restoreCallingIdentity(identity1);
            return -1;
        }

        private long authenticateWithPrompt(long operationId, final FingerprintSensorPropertiesInternal props, int uId, final int userId, final IFingerprintServiceReceiver receiver, String opPackageName, boolean ignoreEnrollmentState) throws PackageManager.NameNotFoundException {
            Context context = this.this$0.getUiContext();
            Context promptContext = context.createPackageContextAsUser(opPackageName, 0, UserHandle.getUserHandleForUid(uId));
            Executor executor = context.getMainExecutor();
            BiometricPrompt biometricPrompt = new BiometricPrompt.Builder(promptContext).setTitle(context.getString(R.string.capability_desc_canTakeScreenshot)).setSubtitle(context.getString(R.string.harmful_app_warning_open_anyway)).setNegativeButton(context.getString(R.string.cancel), executor, new FingerprintService$1$$ExternalSyntheticLambda0(receiver)).setIsForLegacyFingerprintManager(props.sensorId).setIgnoreEnrollmentState(ignoreEnrollmentState).build();
            BiometricPrompt.AuthenticationCallback promptCallback = new C00101(this, receiver, props, userId);
            return biometricPrompt.authenticateForOperation(new CancellationSignal(), executor, promptCallback, operationId);
        }

        private static /* synthetic */ void lambda$authenticateWithPrompt$0(IFingerprintServiceReceiver receiver, DialogInterface dialog, int which) {
            receiver.onError(10, 0);     // Catch: RemoteException -> L5
            return;
        L5:
            e = move-exception;
            Slog.e(FingerprintService.TAG, "Remote exception in negative button onClick()", e);
        }

        public long detectFingerprint(IBinder token, IFingerprintServiceReceiver receiver, FingerprintAuthenticateOptions options) {
            super.detectFingerprint_enforcePermission();
            String opPackageName = options.getOpPackageName();
            if (Utils.isKeyguard(this.this$0.getContext(), opPackageName) == true) goto L6;
            Slog.w(FingerprintService.TAG, "detectFingerprint called from non-sysui package: " + opPackageName);
            return -1;
        L6:
            Pair<Integer, ServiceProvider> provider = this.this$0.mRegistry.getSingleProvider();
            if (provider != null) goto L10;
            Slog.w(FingerprintService.TAG, "Null provider for detectFingerprint");
            return -1;
        L10:
            options.setSensorId(((Integer) provider.first).intValue());
            return ((ServiceProvider) provider.second).scheduleFingerDetect(token, new ClientMonitorCallbackConverter(receiver), options, 1);
        }

        public void prepareForAuthentication(IBinder token, long operationId, IBiometricSensorReceiver sensorReceiver, FingerprintAuthenticateOptions options, long requestId, int cookie, boolean allowBackgroundAuthentication, boolean isForLegacyFingerprintManager) {
            super.prepareForAuthentication_enforcePermission();
            ServiceProvider provider = this.this$0.mRegistry.getProviderForSensor(options.getSensorId());
            if (provider != null) goto L6;
            Slog.w(FingerprintService.TAG, "Null provider for prepareForAuthentication");
            return;
        L6:
            if (isForLegacyFingerprintManager == false) goto L8;
            int statsClient = 3;
        L9:
            provider.scheduleAuthenticate(token, operationId, cookie, new ClientMonitorCallbackConverter(sensorReceiver), options, requestId, true, statsClient, allowBackgroundAuthentication);
            return;
        L8:
            statsClient = 2;
            goto L9
        }

        public void startPreparedClient(int sensorId, int cookie) {
            super.startPreparedClient_enforcePermission();
            ServiceProvider provider = this.this$0.mRegistry.getProviderForSensor(sensorId);
            if (provider != null) goto L6;
            Slog.w(FingerprintService.TAG, "Null provider for startPreparedClient");
            return;
        L6:
            provider.startPreparedClient(sensorId, cookie);
        }

        public void cancelAuthentication(IBinder token, String opPackageName, String attributionTag, long requestId) {
            int callingUid = Binder.getCallingUid();
            int callingPid = Binder.getCallingPid();
            int callingUserId = UserHandle.getCallingUserId();
            if (FingerprintService.m2699$$Nest$mcanUseFingerprint(this.this$0, opPackageName, attributionTag, true, callingUid, callingPid, callingUserId) == true) goto L7;
            Slog.w(FingerprintService.TAG, "cancelAuthentication rejecting package: " + opPackageName);
            return;
        L7:
            if (FingerprintService.m2695$$Nest$fgetmExt(this.this$0).cancelAuthentication(token, requestId) >= 0) goto L14;
            Slog.e(FingerprintService.TAG, "cancelAuthentication failed, fallback to default");
            Pair<Integer, ServiceProvider> provider = this.this$0.mRegistry.getSingleProvider();
            if (provider != null) goto L12;
            Slog.w(FingerprintService.TAG, "Null provider for cancelAuthentication");
            return;
        L12:
            ((ServiceProvider) provider.second).cancelAuthentication(((Integer) provider.first).intValue(), token, requestId);
            return;
        }

        public void cancelFingerprintDetect(IBinder token, String opPackageName, long requestId) {
            super.cancelFingerprintDetect_enforcePermission();
            if (Utils.isKeyguard(this.this$0.getContext(), opPackageName) == true) goto L6;
            Slog.w(FingerprintService.TAG, "cancelFingerprintDetect called from non-sysui package: " + opPackageName);
            return;
        L6:
            Pair<Integer, ServiceProvider> provider = this.this$0.mRegistry.getSingleProvider();
            if (provider != null) goto L10;
            Slog.w(FingerprintService.TAG, "Null provider for cancelFingerprintDetect");
            return;
        L10:
            ((ServiceProvider) provider.second).cancelAuthentication(((Integer) provider.first).intValue(), token, requestId);
        }

        public void cancelAuthenticationFromService(int sensorId, IBinder token, String opPackageName, long requestId) {
            super.cancelAuthenticationFromService_enforcePermission();
            Slog.d(FingerprintService.TAG, "cancelAuthenticationFromService, sensorId: " + sensorId);
            ServiceProvider provider = this.this$0.mRegistry.getProviderForSensor(sensorId);
            if (provider != null) goto L6;
            Slog.w(FingerprintService.TAG, "Null provider for cancelAuthenticationFromService");
            return;
        L6:
            provider.cancelAuthentication(sensorId, token, requestId);
        }

        public void remove(IBinder token, int fingerId, int userId, IFingerprintServiceReceiver receiver, String opPackageName) {
            super.remove_enforcePermission();
            if (FingerprintService.m2695$$Nest$fgetmExt(this.this$0).remove(token, fingerId, userId, receiver, opPackageName) >= 0) goto L10;
            Slog.e(FingerprintService.TAG, "remove failed, fallback to default");
            Pair<Integer, ServiceProvider> provider = this.this$0.mRegistry.getSingleProvider();
            if (provider != null) goto L8;
            Slog.w(FingerprintService.TAG, "Null provider for remove");
            return;
        L8:
            ((ServiceProvider) provider.second).scheduleRemove(((Integer) provider.first).intValue(), token, receiver, fingerId, userId, opPackageName);
            return;
        }

        public void removeAll(IBinder token, int userId, final IFingerprintServiceReceiver receiver, String opPackageName) {
            super.removeAll_enforcePermission();
            IFingerprintServiceReceiver r0 = new AnonymousClass2(this, receiver);
            Iterator<ServiceProvider> r1 = this.this$0.mRegistry.getProviders().iterator();
        L4:
            if (r1.hasNext() == false) goto L10;
            ServiceProvider provider = r1.next();
            List<FingerprintSensorPropertiesInternal> props = provider.getSensorProperties();
            Iterator<FingerprintSensorPropertiesInternal> r8 = props.iterator();
        L7:
            if (r8.hasNext() == false) goto L4;
            FingerprintSensorPropertiesInternal prop = r8.next();
            provider.scheduleRemoveAll(prop.sensorId, token, r0, userId, opPackageName);
            goto L7
        }

        public void addLockoutResetCallback(IBiometricServiceLockoutResetCallback callback, String opPackageName) {
            super.addLockoutResetCallback_enforcePermission();
            FingerprintService.m2698$$Nest$fgetmLockoutResetDispatcher(this.this$0).addCallback(callback, opPackageName);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void onShellCommand(FileDescriptor in, FileDescriptor out, FileDescriptor err, String[] args, ShellCallback callback, ResultReceiver resultReceiver) throws RemoteException {
            new FingerprintShellCommand(this.this$0.getContext(), this.this$0).exec(this, in, out, err, args, callback, resultReceiver);
        }

        protected void dump(FileDescriptor fd, PrintWriter pw, String[] args) {
            if (DumpUtils.checkDumpPermission(this.this$0.getContext(), FingerprintService.TAG, pw) == true) goto L5;
            return;
        L5:
            long ident = Binder.clearCallingIdentity();
        L20:
            th = move-exception;
            Binder.restoreCallingIdentity(ident);
            throw th;
        L8:
            if (args.length <= 1) goto L25;
            if ("--proto".equals(args[0]) == false) goto L25;
            if ("--state".equals(args[1]) == false) goto L25;
            ProtoOutputStream proto = new ProtoOutputStream(fd);     // Catch: Throwable -> L20
            Iterator<ServiceProvider> r3 = this.this$0.mRegistry.getProviders().iterator();     // Catch: Throwable -> L20
        L15:
            if (r3.hasNext() == false) goto L23;
            ServiceProvider provider = r3.next();     // Catch: Throwable -> L20
            Iterator<FingerprintSensorPropertiesInternal> r6 = provider.getSensorProperties().iterator();     // Catch: Throwable -> L20
        L18:
            if (r6.hasNext() == false) goto L15;
            provider.dumpProtoState(r6.next().sensorId, proto, false);     // Catch: Throwable -> L20
            goto L18
        L23:
            proto.flush();     // Catch: Throwable -> L20
        L46:
            Binder.restoreCallingIdentity(ident);
            return;
        L25:
            if (args.length > 0) goto L27;
        L37:
            Iterator<ServiceProvider> r2 = this.this$0.mRegistry.getProviders().iterator();     // Catch: Throwable -> L20
        L39:
            if (r2.hasNext() == false) goto L46;
            ServiceProvider provider2 = r2.next();     // Catch: Throwable -> L20
            Iterator<FingerprintSensorPropertiesInternal> r4 = provider2.getSensorProperties().iterator();     // Catch: Throwable -> L20
        L42:
            if (r4.hasNext() == false) goto L39;
            FingerprintSensorPropertiesInternal props = r4.next();     // Catch: Throwable -> L20
            pw.println("Dumping for sensorId: " + props.sensorId + ", provider: " + provider2.getClass().getSimpleName() + " " + provider2);     // Catch: Throwable -> L20
            StringBuilder r7 = new StringBuilder();     // Catch: Throwable -> L20
            r7.append("Fps state: ");     // Catch: Throwable -> L20
            r7.append(FingerprintService.m2694$$Nest$fgetmBiometricStateCallback(this.this$0).getBiometricState());     // Catch: Throwable -> L20
            pw.println(r7.toString());     // Catch: Throwable -> L20
            provider2.dumpInternal(props.sensorId, pw);     // Catch: Throwable -> L20
            pw.println();     // Catch: Throwable -> L20
            goto L42
        L27:
            if ("--proto".equals(args[0]) == false) goto L37;
            Iterator<ServiceProvider> r5 = this.this$0.mRegistry.getProviders().iterator();     // Catch: Throwable -> L20
        L30:
            if (r5.hasNext() == false) goto L46;
            ServiceProvider provider3 = r5.next();     // Catch: Throwable -> L20
            Iterator<FingerprintSensorPropertiesInternal> r8 = provider3.getSensorProperties().iterator();     // Catch: Throwable -> L20
        L33:
            if (r8.hasNext() == false) goto L30;
            provider3.dumpProtoMetrics(r8.next().sensorId, fd);     // Catch: Throwable -> L20
            goto L33
        }

        public boolean isHardwareDetectedDeprecated(String opPackageName, String attributionTag) {
            if (FingerprintService.m2699$$Nest$mcanUseFingerprint(this.this$0, opPackageName, attributionTag, false, Binder.getCallingUid(), Binder.getCallingPid(), UserHandle.getCallingUserId()) == true) goto L5;
            return false;
        L5:
            long token = Binder.clearCallingIdentity();
            Pair<Integer, ServiceProvider> provider = this.this$0.mRegistry.getSingleProvider();     // Catch: Throwable -> L11
            if (provider != null) goto L13;
            Slog.w(FingerprintService.TAG, "Null provider for isHardwareDetectedDeprecated, caller: " + opPackageName);     // Catch: Throwable -> L11
            Binder.restoreCallingIdentity(token);
            return false;
        L13:
            boolean r9 = ((ServiceProvider) provider.second).isHardwareDetected(((Integer) provider.first).intValue());     // Catch: Throwable -> L11
            Binder.restoreCallingIdentity(token);
            return r9;
        L11:
            th = move-exception;
            Binder.restoreCallingIdentity(token);
            throw th;
        }

        public boolean isHardwareDetected(int sensorId, String opPackageName) {
            super.isHardwareDetected_enforcePermission();
            ServiceProvider provider = this.this$0.mRegistry.getProviderForSensor(sensorId);
            if (provider != null) goto L7;
            Slog.w(FingerprintService.TAG, "Null provider for isHardwareDetected, caller: " + opPackageName);
            return false;
        L7:
            return provider.isHardwareDetected(sensorId);
        }

        public void rename(int fingerId, int userId, String name) {
            super.rename_enforcePermission();
            if (Utils.isCurrentUserOrProfile(this.this$0.getContext(), userId) == true) goto L6;
            return;
        L6:
            if (FingerprintService.m2695$$Nest$fgetmExt(this.this$0).rename(fingerId, userId, name) < 0) goto L8;
            return;
        L8:
            Pair<Integer, ServiceProvider> provider = this.this$0.mRegistry.getSingleProvider();
            if (provider != null) goto L12;
            Slog.w(FingerprintService.TAG, "Null provider for rename");
            return;
        L12:
            ((ServiceProvider) provider.second).rename(((Integer) provider.first).intValue(), fingerId, userId, name);
        }

        public List<Fingerprint> getEnrolledFingerprints(int userId, String opPackageName, String attributionTag) {
            if (FingerprintService.m2699$$Nest$mcanUseFingerprint(this.this$0, opPackageName, attributionTag, false, Binder.getCallingUid(), Binder.getCallingPid(), UserHandle.getCallingUserId()) == true) goto L7;
            return Collections.emptyList();
        L7:
            if (userId != 10) goto L10;
            userId = 0;
        L10:
            if (userId == UserHandle.getCallingUserId()) goto L13;
            Utils.checkPermission(this.this$0.getContext(), "android.permission.INTERACT_ACROSS_USERS");
        L13:
            return FingerprintService.m2700$$Nest$mgetEnrolledFingerprintsDeprecated(this.this$0, userId, opPackageName);
        }

        public boolean hasEnrolledFingerprintsDeprecated(int userId, String opPackageName, String attributionTag) {
            if (FingerprintService.m2699$$Nest$mcanUseFingerprint(this.this$0, opPackageName, attributionTag, false, Binder.getCallingUid(), Binder.getCallingPid(), UserHandle.getCallingUserId()) == true) goto L7;
            return false;
        L7:
            if (userId != 10) goto L12;
            if (DoppelgangerManager.allowCrossUser(userId, UserHandle.getCallingUserId()) == true) goto L12;
            userId = 0;
        L12:
            if (userId == UserHandle.getCallingUserId()) goto L15;
            Utils.checkPermission(this.this$0.getContext(), "android.permission.INTERACT_ACROSS_USERS");
        L15:
            return !FingerprintService.m2700$$Nest$mgetEnrolledFingerprintsDeprecated(this.this$0, userId, opPackageName).isEmpty();
        }

        public boolean hasEnrolledFingerprints(int sensorId, int userId, String opPackageName) {
            super.hasEnrolledFingerprints_enforcePermission();
            ServiceProvider provider = this.this$0.mRegistry.getProviderForSensor(sensorId);
            if (provider != null) goto L7;
            Slog.w(FingerprintService.TAG, "Null provider for hasEnrolledFingerprints, caller: " + opPackageName);
            return false;
        L7:
            if (provider.getEnrolledFingerprints(sensorId, userId).size() <= 0) goto L10;
            return true;
        L10:
            return false;
        }

        public int getLockoutModeForUser(int sensorId, int userId) {
            super.getLockoutModeForUser_enforcePermission();
            ServiceProvider provider = this.this$0.mRegistry.getProviderForSensor(sensorId);
            if (provider != null) goto L7;
            Slog.w(FingerprintService.TAG, "Null provider for getLockoutModeForUser");
            return 0;
        L7:
            return provider.getLockoutModeForUser(sensorId, userId);
        }

        public void invalidateAuthenticatorId(int sensorId, int userId, IInvalidationCallback callback) {
            super.invalidateAuthenticatorId_enforcePermission();
            Slog.i(FingerprintService.TAG, "invalidateAuthenticatorId: sensorId=" + sensorId + ", userId=" + userId + ", callingUid=" + Binder.getCallingUid() + ", callingPid=" + Binder.getCallingPid());
            ServiceProvider provider = this.this$0.mRegistry.getProviderForSensor(sensorId);
            if (provider != null) goto L6;
            Slog.w(FingerprintService.TAG, "Null provider for invalidateAuthenticatorId");
            return;
        L6:
            provider.scheduleInvalidateAuthenticatorId(sensorId, userId, callback);
        }

        public long getAuthenticatorId(int sensorId, int userId) {
            super.getAuthenticatorId_enforcePermission();
            ServiceProvider provider = this.this$0.mRegistry.getProviderForSensor(sensorId);
            if (provider != null) goto L6;
            Slog.w(FingerprintService.TAG, "Null provider for getAuthenticatorId");
            return 0;
        L6:
            long authenticatorId = provider.getAuthenticatorId(sensorId, userId);
            Slog.i(FingerprintService.TAG, "getAuthenticatorId: sensorId=" + sensorId + ", userId=" + userId + ", authenticatorId=" + authenticatorId + ", callingUid=" + Binder.getCallingUid() + ", callingPid=" + Binder.getCallingPid());
            return authenticatorId;
        }

        public void resetLockout(IBinder token, int sensorId, int userId, byte[] hardwareAuthToken, String opPackageName) {
            super.resetLockout_enforcePermission();
            ServiceProvider provider = this.this$0.mRegistry.getProviderForSensor(sensorId);
            if (provider != null) goto L6;
            Slog.w(FingerprintService.TAG, "Null provider for resetLockout, caller: " + opPackageName);
            return;
        L6:
            provider.scheduleResetLockout(sensorId, userId, hardwareAuthToken);
        }

        public boolean isClientActive() {
            super.isClientActive_enforcePermission();
            return FingerprintService.m2696$$Nest$fgetmGestureAvailabilityDispatcher(this.this$0).isAnySensorActive();
        }

        public void addClientActiveCallback(IFingerprintClientActiveCallback callback) {
            super.addClientActiveCallback_enforcePermission();
            FingerprintService.m2696$$Nest$fgetmGestureAvailabilityDispatcher(this.this$0).registerCallback(callback);
        }

        public void removeClientActiveCallback(IFingerprintClientActiveCallback callback) {
            super.removeClientActiveCallback_enforcePermission();
            FingerprintService.m2696$$Nest$fgetmGestureAvailabilityDispatcher(this.this$0).removeCallback(callback);
        }

        public void registerAuthenticators(final FingerprintSensorConfigurations fingerprintSensorConfigurations) {
            super.registerAuthenticators_enforcePermission();
            if (fingerprintSensorConfigurations.hasSensorConfigurations() == true) goto L6;
            Slog.d(FingerprintService.TAG, "No fingerprint sensors available.");
            return;
        L6:
            this.this$0.mRegistry.registerAll(new FingerprintService$1$$ExternalSyntheticLambda1(this, fingerprintSensorConfigurations));
        }

        private /* synthetic */ List lambda$registerAuthenticators$1(FingerprintSensorConfigurations fingerprintSensorConfigurations) {
            return FingerprintService.m2701$$Nest$mgetProviders(this.this$0, fingerprintSensorConfigurations);
        }

        public void addAuthenticatorsRegisteredCallback(IFingerprintAuthenticatorsRegisteredCallback callback) {
            super.addAuthenticatorsRegisteredCallback_enforcePermission();
            this.this$0.mRegistry.addAllRegisteredCallback(callback);
        }

        public void registerAuthenticationStateListener(AuthenticationStateListener listener) {
            super.registerAuthenticationStateListener_enforcePermission();
            FingerprintService.m2693$$Nest$fgetmAuthenticationStateListeners(this.this$0).registerAuthenticationStateListener(listener);
        }

        public void unregisterAuthenticationStateListener(AuthenticationStateListener listener) {
            super.unregisterAuthenticationStateListener_enforcePermission();
            FingerprintService.m2693$$Nest$fgetmAuthenticationStateListeners(this.this$0).unregisterAuthenticationStateListener(listener);
        }

        public void registerBiometricStateListener(IBiometricStateListener listener) {
            super.registerBiometricStateListener_enforcePermission();
            FingerprintService.m2694$$Nest$fgetmBiometricStateCallback(this.this$0).registerBiometricStateListener(listener);
        }

        public void onPointerDown(long requestId, int sensorId, PointerContext pc) {
            super.onPointerDown_enforcePermission();
            ServiceProvider provider = this.this$0.mRegistry.getProviderForSensor(sensorId);
            if (provider != null) goto L6;
            Slog.w(FingerprintService.TAG, "No matching provider for onFingerDown, sensorId: " + sensorId);
            return;
        L6:
            provider.onPointerDown(requestId, sensorId, pc);
        }

        public void onPointerUp(long requestId, int sensorId, PointerContext pc) {
            super.onPointerUp_enforcePermission();
            ServiceProvider provider = this.this$0.mRegistry.getProviderForSensor(sensorId);
            if (provider != null) goto L6;
            Slog.w(FingerprintService.TAG, "No matching provider for onFingerUp, sensorId: " + sensorId);
            return;
        L6:
            provider.onPointerUp(requestId, sensorId, pc);
        }

        public void onUdfpsUiEvent(int event, long requestId, int sensorId) {
            super.onUdfpsUiEvent_enforcePermission();
            ServiceProvider provider = this.this$0.mRegistry.getProviderForSensor(sensorId);
            if (provider != null) goto L6;
            Slog.w(FingerprintService.TAG, "No matching provider for onUdfpsUiEvent, sensorId: " + sensorId);
            return;
        L6:
            provider.onUdfpsUiEvent(event, requestId, sensorId);
        }

        public void setIgnoreDisplayTouches(long requestId, int sensorId, boolean ignoreTouches) {
            super.setIgnoreDisplayTouches_enforcePermission();
            ServiceProvider provider = this.this$0.mRegistry.getProviderForSensor(sensorId);
            if (provider != null) goto L6;
            Slog.w(FingerprintService.TAG, "No matching provider for setIgnoreDisplayTouches, sensorId: " + sensorId);
            return;
        L6:
            provider.setIgnoreDisplayTouches(requestId, sensorId, ignoreTouches);
        }

        public void setUdfpsOverlayController(IUdfpsOverlayController controller) {
            super.setUdfpsOverlayController_enforcePermission();
            Iterator<ServiceProvider> r0 = this.this$0.mRegistry.getProviders().iterator();
        L4:
            if (r0.hasNext() == false) goto L6;
            ServiceProvider provider = r0.next();
            provider.setUdfpsOverlayController(controller);
            goto L4
        }

        public void onPowerPressed() {
            super.onPowerPressed_enforcePermission();
            Iterator<ServiceProvider> r0 = this.this$0.mRegistry.getProviders().iterator();
        L4:
            if (r0.hasNext() == false) goto L6;
            ServiceProvider provider = r0.next();
            provider.onPowerPressed();
            goto L4
        }

        public void scheduleWatchdog() {
            super.scheduleWatchdog_enforcePermission();
            Pair<Integer, ServiceProvider> provider = this.this$0.mRegistry.getSingleProvider();
            if (provider != null) goto L6;
            Slog.w(FingerprintService.TAG, "Null provider for scheduling watchdog");
            return;
        L6:
            ((ServiceProvider) provider.second).scheduleWatchdog(((Integer) provider.first).intValue());
        }
    }

    interface FingerprintProviderFunction {
        FingerprintProvider getFingerprintProvider(Pair<String, SensorProps[]> r1, boolean r2);
    }

    public static /* synthetic */ IBiometricService $r8$lambda$2dqdPrnRQF3k2uWjNXHSpd6EHTE() {
        return lambda$new$0();
    }

    public static /* synthetic */ String[] $r8$lambda$XDtt2AUszEsa9j5pwwmMw_9nEIs() {
        return lambda$new$1();
    }

    /* JADX INFO: renamed from: $r8$lambda$YPwvFsZyTxv31sAZsJbpW04iZ-Q, reason: not valid java name */
    public static /* synthetic */ FingerprintProvider m2692$r8$lambda$YPwvFsZyTxv31sAZsJbpW04iZQ(FingerprintService r0, String r1) {
        return r0.lambda$new$2(r1);
    }

    public static /* synthetic */ FingerprintProvider $r8$lambda$oEJy3E8rNN13Qe2QWcgAJIKmT0A(FingerprintService r0, Pair r1, boolean r2) {
        return r0.lambda$new$3(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmAuthenticationStateListeners, reason: not valid java name */
    static /* bridge */ /* synthetic */ AuthenticationStateListeners m2693$$Nest$fgetmAuthenticationStateListeners(FingerprintService r0) {
        return r0.mAuthenticationStateListeners;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmBiometricStateCallback, reason: not valid java name */
    static /* bridge */ /* synthetic */ BiometricStateCallback m2694$$Nest$fgetmBiometricStateCallback(FingerprintService r0) {
        return r0.mBiometricStateCallback;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmExt, reason: not valid java name */
    static /* bridge */ /* synthetic */ IExtFingerprintService m2695$$Nest$fgetmExt(FingerprintService r0) {
        return r0.mExt;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmGestureAvailabilityDispatcher, reason: not valid java name */
    static /* bridge */ /* synthetic */ GestureAvailabilityDispatcher m2696$$Nest$fgetmGestureAvailabilityDispatcher(FingerprintService r0) {
        return r0.mGestureAvailabilityDispatcher;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmLockPatternUtils, reason: not valid java name */
    static /* bridge */ /* synthetic */ LockPatternUtils m2697$$Nest$fgetmLockPatternUtils(FingerprintService r0) {
        return r0.mLockPatternUtils;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmLockoutResetDispatcher, reason: not valid java name */
    static /* bridge */ /* synthetic */ LockoutResetDispatcher m2698$$Nest$fgetmLockoutResetDispatcher(FingerprintService r0) {
        return r0.mLockoutResetDispatcher;
    }

    /* JADX INFO: renamed from: -$$Nest$mcanUseFingerprint, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m2699$$Nest$mcanUseFingerprint(FingerprintService r0, String r1, String r2, boolean r3, int r4, int r5, int r6) {
        return r0.canUseFingerprint(r1, r2, r3, r4, r5, r6);
    }

    /* JADX INFO: renamed from: -$$Nest$mgetEnrolledFingerprintsDeprecated, reason: not valid java name */
    static /* bridge */ /* synthetic */ List m2700$$Nest$mgetEnrolledFingerprintsDeprecated(FingerprintService r0, int r1, String r2) {
        return r0.getEnrolledFingerprintsDeprecated(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mgetProviders, reason: not valid java name */
    static /* bridge */ /* synthetic */ List m2701$$Nest$mgetProviders(FingerprintService r0, FingerprintSensorConfigurations r1) {
        return r0.getProviders(r1);
    }

    static /* synthetic */ Object access$000(FingerprintService x0, Class x1) {
        return x0.getLocalService(x1);
    }

    public FingerprintService(Context context) {
        this(context, BiometricContext.getInstance(context), new FingerprintService$$ExternalSyntheticLambda2(), new FingerprintService$$ExternalSyntheticLambda3(), null, null);
    }

    private static /* synthetic */ IBiometricService lambda$new$0() {
        return IBiometricService.Stub.asInterface(ServiceManager.getService("biometric"));
    }

    private static /* synthetic */ String[] lambda$new$1() {
        return getDeclaredInstances();
    }

    FingerprintService(Context context, BiometricContext biometricContext, Supplier<IBiometricService> biometricServiceSupplier, Supplier<String[]> aidlInstanceNameSupplier, Function<String, FingerprintProvider> fingerprintProvider, FingerprintProviderFunction fingerprintProviderFunction) {
        super(context);
        this.mServiceWrapper = new AnonymousClass1(this);
        this.mExt = (IExtFingerprintService) ExtImplFactory.getImpl(IExtFingerprintService.class, new Object[]{this});
        this.mBiometricContext = biometricContext;
        this.mAidlInstanceNameSupplier = aidlInstanceNameSupplier;
        this.mAppOps = (AppOpsManager) context.getSystemService(AppOpsManager.class);
        this.mGestureAvailabilityDispatcher = new GestureAvailabilityDispatcher();
        this.mLockoutResetDispatcher = new LockoutResetDispatcher(context);
        this.mLockPatternUtils = new LockPatternUtils(context);
        this.mBiometricStateCallback = new BiometricStateCallback(UserManager.get(context));
        this.mAuthenticationStateListeners = new AuthenticationStateListeners();
        if (fingerprintProvider == null) goto L5;
        Function<String, FingerprintProvider> r0 = fingerprintProvider;
    L6:
        this.mFingerprintProvider = r0;
        if (fingerprintProviderFunction == null) goto L9;
        FingerprintProviderFunction r1 = fingerprintProviderFunction;
    L10:
        this.mFingerprintProviderFunction = r1;
        this.mHandler = new Handler(Looper.getMainLooper());
        this.mRegistry = new FingerprintServiceRegistry(this.mServiceWrapper, biometricServiceSupplier);
        this.mRegistry.addAllRegisteredCallback(new AnonymousClass2(this));
        return;
    L9:
        r1 = new FingerprintService$$ExternalSyntheticLambda1(this);
        goto L10
    L5:
        r0 = new FingerprintService$$ExternalSyntheticLambda0(this);
        goto L6
    }

    private /* synthetic */ FingerprintProvider lambda$new$2(String name) {
        String fqName = IFingerprint.DESCRIPTOR + SliceClientPermissions.SliceAuthority.DELIMITER + name;
        IFingerprint fp = FingerprintSensorConfigurations.getIFingerprint(fqName);
        if (fp != null) goto L18;
        Slog.e(TAG, "Unable to get declared service: " + fqName);
        return null;
    L18:
        return new FingerprintProvider(getContext(), this.mBiometricStateCallback, this.mAuthenticationStateListeners, fp.getSensorProps(), name, this.mLockoutResetDispatcher, this.mGestureAvailabilityDispatcher, this.mBiometricContext, true);
    L12:
        Slog.e(TAG, "Remote exception in getSensorProps: " + fqName);
        return null;
    }

    private /* synthetic */ FingerprintProvider lambda$new$3(Pair filteredSensorProps, boolean resetLockoutRequiresHardwareAuthToken) {
        return new FingerprintProvider(getContext(), this.mBiometricStateCallback, this.mAuthenticationStateListeners, (SensorProps[]) filteredSensorProps.second, (String) filteredSensorProps.first, this.mLockoutResetDispatcher, this.mGestureAvailabilityDispatcher, this.mBiometricContext, resetLockoutRequiresHardwareAuthToken);
    }

    private List<ServiceProvider> getProviders(FingerprintSensorConfigurations fingerprintSensorConfigurations) {
        List<ServiceProvider> providers = new ArrayList();
        Pair<String, SensorProps[]> filteredSensorProps = filterAvailableHalInstances(fingerprintSensorConfigurations);
        providers.add(this.mFingerprintProviderFunction.getFingerprintProvider(filteredSensorProps, fingerprintSensorConfigurations.getResetLockoutRequiresHardwareAuthToken()));
        return providers;
    }

    private Pair<String, SensorProps[]> filterAvailableHalInstances(FingerprintSensorConfigurations fingerprintSensorConfigurations) {
        String finalSensorInstance = fingerprintSensorConfigurations.getSensorInstance();
        if (fingerprintSensorConfigurations.isSingleSensorConfigurationPresent() == true) goto L5;
        boolean isVirtualHalPresent = fingerprintSensorConfigurations.doesInstanceExist("virtual");
        if (Utils.isFingerprintVirtualEnabled(getContext()) == false) goto L13;
        if (isVirtualHalPresent == true) goto L10;
        Slog.e(TAG, "Could not find virtual interface while it is enabled");
        return new Pair(finalSensorInstance, fingerprintSensorConfigurations.getSensorPropForInstance(finalSensorInstance));
    L10:
        return new Pair("virtual", fingerprintSensorConfigurations.getSensorPropForInstance("virtual"));
    L13:
        if (isVirtualHalPresent == false) goto L19;
        String notAVirtualInstance = fingerprintSensorConfigurations.getSensorNameNotForInstance("virtual");
        if (notAVirtualInstance == null) goto L19;
        return new Pair(notAVirtualInstance, fingerprintSensorConfigurations.getSensorPropForInstance(notAVirtualInstance));
    L19:
        return new Pair(finalSensorInstance, fingerprintSensorConfigurations.getSensorPropForInstance(finalSensorInstance));
    L5:
        return new Pair(finalSensorInstance, fingerprintSensorConfigurations.getSensorPropForInstance(finalSensorInstance));
    }

    @Override // com.android.server.SystemService
    public void onStart() {
        publishBinderService("fingerprint", this.mServiceWrapper);
    }

    public static String[] getDeclaredInstances() {
        String[] a = ServiceManager.getDeclaredInstances(IFingerprint.DESCRIPTOR);
        Slog.i(TAG, "Before:getDeclaredInstances: IFingerprint instance found, a.length=" + a.length);
        if (ArrayUtils.contains(a, "virtual") == true) goto L5;
        a = (String[]) ArrayUtils.appendElement(String.class, a, "virtual");
    L5:
        Slog.i(TAG, "After:getDeclaredInstances: a.length=" + a.length);
        return a;
    }

    private List<Fingerprint> getEnrolledFingerprintsDeprecated(int userId, String opPackageName) {
        return this.mExt.getEnrolledFingerprints(userId, opPackageName);
    }

    private boolean canUseFingerprint(String opPackageName, String attributionTag, boolean requireForeground, int uid, int pid, int userId) {
        if (getContext().checkCallingPermission("android.permission.USE_FINGERPRINT") == 0) goto L6;
        Utils.checkPermission(getContext(), "android.permission.USE_BIOMETRIC");
    L6:
        if (Binder.getCallingUid() != 1000) goto L9;
        return true;
    L9:
        if (Utils.isKeyguard(getContext(), opPackageName) == false) goto L12;
        return true;
    L12:
        if (Utils.isCurrentUserOrProfile(getContext(), userId) == true) goto L16;
        Slog.w(TAG, "Rejecting " + opPackageName + "; not a current user or profile");
        return false;
    L16:
        if (checkAppOps(uid, opPackageName, attributionTag) == true) goto L19;
        Slog.w(TAG, "Rejecting " + opPackageName + "; permission denied");
        return false;
    L19:
        if (requireForeground == true) goto L21;
    L24:
        return true;
    L21:
        if (Utils.isForeground(uid, pid) == true) goto L24;
        Slog.w(TAG, "Rejecting " + opPackageName + "; not in foreground");
        return false;
    }

    private boolean checkAppOps(int uid, String opPackageName, String attributionTag) {
        if (this.mAppOps.noteOp(78, uid, opPackageName, attributionTag, null) != 0) goto L6;
        return true;
    L6:
        if (this.mAppOps.noteOp(55, uid, opPackageName, attributionTag, null) != 0) goto L10;
        return true;
    L10:
        return false;
    }

    void syncEnrollmentsNow() {
        Utils.checkPermissionOrShell(getContext(), "android.permission.MANAGE_FINGERPRINT");
        if (Utils.isFingerprintVirtualEnabled(getContext()) == false) goto L20;
        Slog.i(TAG, "Sync virtual enrollments");
        int userId = ActivityManager.getCurrentUser();
        final CountDownLatch latch = new CountDownLatch(this.mRegistry.getProviders().size());
        Iterator<ServiceProvider> r3 = this.mRegistry.getProviders().iterator();
    L6:
        if (r3.hasNext() == false) goto L17;
        ServiceProvider provider = r3.next();
        Iterator<FingerprintSensorPropertiesInternal> r5 = provider.getSensorProperties().iterator();
    L9:
        if (r5.hasNext() == false) goto L6;
        FingerprintSensorPropertiesInternal props = r5.next();
        provider.scheduleInternalCleanup(props.sensorId, userId, new AnonymousClass3(this, latch), true);
        goto L9
    L17:
        latch.await(3, TimeUnit.SECONDS);     // Catch: Exception -> L14
        return;
    L14:
        e = move-exception;
        Slog.e(TAG, "Failed to wait for sync finishing", e);
        return;
    }

    void simulateVhalFingerDown() {
        if (Utils.isFingerprintVirtualEnabled(getContext()) == false) goto L8;
        Slog.i(TAG, "Simulate virtual HAL finger down event");
        Pair<Integer, ServiceProvider> provider = this.mRegistry.getSingleProvider();
        if (provider == null) goto L9;
        ((ServiceProvider) provider.second).simulateVhalFingerDown(UserHandle.getCallingUserId(), ((Integer) provider.first).intValue());
        return;
    L9:
        return;
    }

    void sendFingerprintReEnrollNotification() {
        Utils.checkPermissionOrShell(getContext(), "android.permission.MANAGE_FINGERPRINT");
        if (Build.IS_DEBUGGABLE == false) goto L14;
        long identity = Binder.clearCallingIdentity();
        Pair<Integer, ServiceProvider> provider = this.mRegistry.getSingleProvider();     // Catch: Throwable -> L8
        if (provider == null) goto L10;
        FingerprintProvider fingerprintProvider = (FingerprintProvider) provider.second;     // Catch: Throwable -> L8
        fingerprintProvider.sendFingerprintReEnrollNotification();     // Catch: Throwable -> L8
    L11:
        Binder.restoreCallingIdentity(identity);
        return;
    L10:
        Slog.w(TAG, "Null provider for notification");     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        Binder.restoreCallingIdentity(identity);
        throw th;
    }

    public IExtFingerprintService getExt() {
        return this.mExt;
    }
}
