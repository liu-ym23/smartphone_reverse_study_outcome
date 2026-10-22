package com.android.server.biometrics.sensors.face;

import android.content.Context;
import android.hardware.biometrics.AuthenticationStateListener;
import android.hardware.biometrics.IBiometricSensorReceiver;
import android.hardware.biometrics.IBiometricService;
import android.hardware.biometrics.IBiometricServiceLockoutResetCallback;
import android.hardware.biometrics.IBiometricStateListener;
import android.hardware.biometrics.IInvalidationCallback;
import android.hardware.biometrics.ITestSession;
import android.hardware.biometrics.ITestSessionCallback;
import android.hardware.biometrics.face.IFace;
import android.hardware.biometrics.face.SensorProps;
import android.hardware.face.Face;
import android.hardware.face.FaceAuthenticateOptions;
import android.hardware.face.FaceEnrollOptions;
import android.hardware.face.FaceSensorConfigurations;
import android.hardware.face.FaceSensorPropertiesInternal;
import android.hardware.face.IFaceAuthenticatorsRegisteredCallback;
import android.hardware.face.IFaceService;
import android.hardware.face.IFaceServiceReceiver;
import android.os.Binder;
import android.os.Build;
import android.os.IBinder;
import android.os.NativeHandle;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.os.ServiceManager;
import android.os.ShellCallback;
import android.os.UserHandle;
import android.os.UserManager;
import android.util.Pair;
import android.util.Slog;
import android.util.proto.ProtoOutputStream;
import android.view.Surface;
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
import com.android.server.biometrics.sensors.face.aidl.FaceProvider;
import com.android.server.slice.SliceClientPermissions;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

/* JADX INFO: loaded from: classes.dex */
public class FaceService extends SystemService {
    protected static final String TAG = "FaceService";
    private final Supplier<String[]> mAidlInstanceNameSupplier;
    private final AuthenticationStateListeners mAuthenticationStateListeners;
    private final BiometricStateCallback<ServiceProvider, FaceSensorPropertiesInternal> mBiometricStateCallback;
    private final Function<String, FaceProvider> mFaceProvider;
    private final FaceProviderFunction mFaceProviderFunction;
    private final LockPatternUtils mLockPatternUtils;
    private final LockoutResetDispatcher mLockoutResetDispatcher;
    private final FaceServiceRegistry mRegistry;
    final FaceServiceWrapper mServiceWrapper;

    interface FaceProviderFunction {
        FaceProvider getFaceProvider(Pair<String, SensorProps[]> r1, boolean r2);
    }

    final class FaceServiceWrapper extends IFaceService.Stub {
        final /* synthetic */ FaceService this$0;

        /* JADX INFO: renamed from: $r8$lambda$PVF4Rbb91-Vs1Wnhn3o8HZ3asNk, reason: not valid java name */
        public static /* synthetic */ List m2644$r8$lambda$PVF4Rbb91Vs1Wnhn3o8HZ3asNk(FaceServiceWrapper r0, FaceSensorConfigurations r1) {
            return r0.lambda$registerAuthenticators$0(r1);
        }

        FaceServiceWrapper(FaceService this$0) {
            this.this$0 = this$0;
        }

        public ITestSession createTestSession(int sensorId, ITestSessionCallback callback, String opPackageName) {
            super.createTestSession_enforcePermission();
            ServiceProvider provider = FaceService.m2643$$Nest$fgetmRegistry(this.this$0).getProviderForSensor(sensorId);
            if (provider != null) goto L7;
            Slog.w(FaceService.TAG, "Null provider for createTestSession, sensorId: " + sensorId);
            return null;
        L7:
            return provider.createTestSession(sensorId, callback, opPackageName);
        }

        public byte[] dumpSensorServiceStateProto(int sensorId, boolean clearSchedulerBuffer) {
            super.dumpSensorServiceStateProto_enforcePermission();
            ProtoOutputStream proto = new ProtoOutputStream();
            ServiceProvider provider = FaceService.m2643$$Nest$fgetmRegistry(this.this$0).getProviderForSensor(sensorId);
            if (provider == null) goto L5;
            provider.dumpProtoState(sensorId, proto, clearSchedulerBuffer);
        L5:
            proto.flush();
            return proto.getBytes();
        }

        public List<FaceSensorPropertiesInternal> getSensorPropertiesInternal(String opPackageName) {
            super.getSensorPropertiesInternal_enforcePermission();
            return FaceService.m2643$$Nest$fgetmRegistry(this.this$0).getAllProperties();
        }

        public FaceSensorPropertiesInternal getSensorProperties(int sensorId, String opPackageName) {
            super.getSensorProperties_enforcePermission();
            ServiceProvider provider = FaceService.m2643$$Nest$fgetmRegistry(this.this$0).getProviderForSensor(sensorId);
            if (provider != null) goto L7;
            Slog.w(FaceService.TAG, "No matching sensor for getSensorProperties, sensorId: " + sensorId + ", caller: " + opPackageName);
            return null;
        L7:
            return provider.getSensorProperties(sensorId);
        }

        public void generateChallenge(IBinder token, int sensorId, int userId, IFaceServiceReceiver receiver, String opPackageName) {
            super.generateChallenge_enforcePermission();
            ServiceProvider provider = FaceService.m2643$$Nest$fgetmRegistry(this.this$0).getProviderForSensor(sensorId);
            if (provider != null) goto L6;
            Slog.w(FaceService.TAG, "No matching sensor for generateChallenge, sensorId: " + sensorId);
            return;
        L6:
            provider.scheduleGenerateChallenge(sensorId, userId, token, receiver, opPackageName);
        }

        public void revokeChallenge(IBinder token, int sensorId, int userId, String opPackageName, long challenge) {
            super.revokeChallenge_enforcePermission();
            ServiceProvider provider = FaceService.m2643$$Nest$fgetmRegistry(this.this$0).getProviderForSensor(sensorId);
            if (provider != null) goto L6;
            Slog.w(FaceService.TAG, "No matching sensor for revokeChallenge, sensorId: " + sensorId);
            return;
        L6:
            provider.scheduleRevokeChallenge(sensorId, userId, token, opPackageName, challenge);
        }

        public long enroll(int userId, IBinder token, byte[] hardwareAuthToken, IFaceServiceReceiver receiver, String opPackageName, int[] disabledFeatures, Surface previewSurface, boolean debugConsent, FaceEnrollOptions options) {
            super.enroll_enforcePermission();
            Pair<Integer, ServiceProvider> provider = FaceService.m2643$$Nest$fgetmRegistry(this.this$0).getSingleProvider();
            if (provider != null) goto L7;
            Slog.w(FaceService.TAG, "Null provider for enroll");
            return -1;
        L7:
            return ((ServiceProvider) provider.second).scheduleEnroll(((Integer) provider.first).intValue(), token, hardwareAuthToken, userId, receiver, opPackageName, disabledFeatures, previewSurface, debugConsent, options);
        }

        public void scheduleWatchdog() {
            super.scheduleWatchdog_enforcePermission();
            Pair<Integer, ServiceProvider> provider = FaceService.m2643$$Nest$fgetmRegistry(this.this$0).getSingleProvider();
            if (provider != null) goto L6;
            Slog.w(FaceService.TAG, "Null provider for scheduling watchdog");
            return;
        L6:
            ((ServiceProvider) provider.second).scheduleWatchdog(((Integer) provider.first).intValue());
        }

        public long enrollRemotely(int userId, IBinder token, byte[] hardwareAuthToken, IFaceServiceReceiver receiver, String opPackageName, int[] disabledFeatures) {
            super.enrollRemotely_enforcePermission();
            return -1;
        }

        public void cancelEnrollment(IBinder token, long requestId) {
            super.cancelEnrollment_enforcePermission();
            Pair<Integer, ServiceProvider> provider = FaceService.m2643$$Nest$fgetmRegistry(this.this$0).getSingleProvider();
            if (provider != null) goto L6;
            Slog.w(FaceService.TAG, "Null provider for cancelEnrollment");
            return;
        L6:
            ((ServiceProvider) provider.second).cancelEnrollment(((Integer) provider.first).intValue(), token, requestId);
        }

        public long authenticate(IBinder token, long operationId, IFaceServiceReceiver receiver, FaceAuthenticateOptions options) {
            super.authenticate_enforcePermission();
            String opPackageName = options.getOpPackageName();
            if (Utils.isKeyguard(this.this$0.getContext(), opPackageName) == false) goto L5;
            int r2 = 1;
        L6:
            int statsClient = r2;
            boolean isKeyguard = Utils.isKeyguard(this.this$0.getContext(), opPackageName);
            Pair<Integer, ServiceProvider> provider = FaceService.m2643$$Nest$fgetmRegistry(this.this$0).getSingleProvider();
            if (provider != null) goto L10;
            Slog.w(FaceService.TAG, "Null provider for authenticate");
            return -1;
        L10:
            options.setSensorId(((Integer) provider.first).intValue());
            return ((ServiceProvider) provider.second).scheduleAuthenticate(token, operationId, 0, new ClientMonitorCallbackConverter(receiver), options, false, statsClient, isKeyguard);
        L5:
            r2 = 0;
            goto L6
        }

        public long detectFace(IBinder token, IFaceServiceReceiver receiver, FaceAuthenticateOptions options) {
            super.detectFace_enforcePermission();
            String opPackageName = options.getOpPackageName();
            if (Utils.isKeyguard(this.this$0.getContext(), opPackageName) == true) goto L6;
            Slog.w(FaceService.TAG, "detectFace called from non-sysui package: " + opPackageName);
            return -1;
        L6:
            Pair<Integer, ServiceProvider> provider = FaceService.m2643$$Nest$fgetmRegistry(this.this$0).getSingleProvider();
            if (provider != null) goto L10;
            Slog.w(FaceService.TAG, "Null provider for detectFace");
            return -1;
        L10:
            options.setSensorId(((Integer) provider.first).intValue());
            return ((ServiceProvider) provider.second).scheduleFaceDetect(token, new ClientMonitorCallbackConverter(receiver), options, 1);
        }

        public void prepareForAuthentication(boolean requireConfirmation, IBinder token, long operationId, IBiometricSensorReceiver sensorReceiver, FaceAuthenticateOptions options, long requestId, int cookie, boolean allowBackgroundAuthentication) {
            super.prepareForAuthentication_enforcePermission();
            ServiceProvider provider = FaceService.m2643$$Nest$fgetmRegistry(this.this$0).getProviderForSensor(options.getSensorId());
            if (provider != null) goto L6;
            Slog.w(FaceService.TAG, "Null provider for prepareForAuthentication");
            return;
        L6:
            provider.scheduleAuthenticate(token, operationId, cookie, new ClientMonitorCallbackConverter(sensorReceiver), options, requestId, true, 2, allowBackgroundAuthentication);
        }

        public void startPreparedClient(int sensorId, int cookie) {
            super.startPreparedClient_enforcePermission();
            ServiceProvider provider = FaceService.m2643$$Nest$fgetmRegistry(this.this$0).getProviderForSensor(sensorId);
            if (provider != null) goto L6;
            Slog.w(FaceService.TAG, "Null provider for startPreparedClient");
            return;
        L6:
            provider.startPreparedClient(sensorId, cookie);
        }

        public void cancelAuthentication(IBinder token, String opPackageName, long requestId) {
            super.cancelAuthentication_enforcePermission();
            Pair<Integer, ServiceProvider> provider = FaceService.m2643$$Nest$fgetmRegistry(this.this$0).getSingleProvider();
            if (provider != null) goto L6;
            Slog.w(FaceService.TAG, "Null provider for cancelAuthentication");
            return;
        L6:
            ((ServiceProvider) provider.second).cancelAuthentication(((Integer) provider.first).intValue(), token, requestId);
        }

        public void cancelFaceDetect(IBinder token, String opPackageName, long requestId) {
            super.cancelFaceDetect_enforcePermission();
            if (Utils.isKeyguard(this.this$0.getContext(), opPackageName) == true) goto L6;
            Slog.w(FaceService.TAG, "cancelFaceDetect called from non-sysui package: " + opPackageName);
            return;
        L6:
            Pair<Integer, ServiceProvider> provider = FaceService.m2643$$Nest$fgetmRegistry(this.this$0).getSingleProvider();
            if (provider != null) goto L10;
            Slog.w(FaceService.TAG, "Null provider for cancelFaceDetect");
            return;
        L10:
            ((ServiceProvider) provider.second).cancelFaceDetect(((Integer) provider.first).intValue(), token, requestId);
        }

        public void cancelAuthenticationFromService(int sensorId, IBinder token, String opPackageName, long requestId) {
            super.cancelAuthenticationFromService_enforcePermission();
            ServiceProvider provider = FaceService.m2643$$Nest$fgetmRegistry(this.this$0).getProviderForSensor(sensorId);
            if (provider != null) goto L6;
            Slog.w(FaceService.TAG, "Null provider for cancelAuthenticationFromService");
            return;
        L6:
            provider.cancelAuthentication(sensorId, token, requestId);
        }

        public void remove(IBinder token, int faceId, int userId, IFaceServiceReceiver receiver, String opPackageName) {
            super.remove_enforcePermission();
            Pair<Integer, ServiceProvider> provider = FaceService.m2643$$Nest$fgetmRegistry(this.this$0).getSingleProvider();
            if (provider != null) goto L6;
            Slog.w(FaceService.TAG, "Null provider for remove");
            return;
        L6:
            ((ServiceProvider) provider.second).scheduleRemove(((Integer) provider.first).intValue(), token, faceId, userId, receiver, opPackageName);
        }

        public void removeAll(IBinder token, int userId, final IFaceServiceReceiver receiver, String opPackageName) {
            super.removeAll_enforcePermission();
            IFaceServiceReceiver r0 = new AnonymousClass1(this, receiver);
            Iterator<ServiceProvider> r1 = FaceService.m2643$$Nest$fgetmRegistry(this.this$0).getProviders().iterator();
        L4:
            if (r1.hasNext() == false) goto L10;
            ServiceProvider provider = r1.next();
            List<FaceSensorPropertiesInternal> props = provider.getSensorProperties();
            Iterator<FaceSensorPropertiesInternal> r8 = props.iterator();
        L7:
            if (r8.hasNext() == false) goto L4;
            FaceSensorPropertiesInternal prop = r8.next();
            provider.scheduleRemoveAll(prop.sensorId, token, userId, r0, opPackageName);
            goto L7
        }

        public void addLockoutResetCallback(IBiometricServiceLockoutResetCallback callback, String opPackageName) {
            super.addLockoutResetCallback_enforcePermission();
            FaceService.m2642$$Nest$fgetmLockoutResetDispatcher(this.this$0).addCallback(callback, opPackageName);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void onShellCommand(FileDescriptor in, FileDescriptor out, FileDescriptor err, String[] args, ShellCallback callback, ResultReceiver resultReceiver) throws RemoteException {
            new FaceShellCommand(this.this$0).exec(this, in, out, err, args, callback, resultReceiver);
        }

        protected void dump(FileDescriptor fd, PrintWriter pw, String[] args) {
            if (DumpUtils.checkDumpPermission(this.this$0.getContext(), FaceService.TAG, pw) == true) goto L5;
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
            Iterator<ServiceProvider> r3 = FaceService.m2643$$Nest$fgetmRegistry(this.this$0).getProviders().iterator();     // Catch: Throwable -> L20
        L15:
            if (r3.hasNext() == false) goto L23;
            ServiceProvider provider = r3.next();     // Catch: Throwable -> L20
            Iterator<FaceSensorPropertiesInternal> r6 = provider.getSensorProperties().iterator();     // Catch: Throwable -> L20
        L18:
            if (r6.hasNext() == false) goto L15;
            provider.dumpProtoState(r6.next().sensorId, proto, false);     // Catch: Throwable -> L20
            goto L18
        L23:
            proto.flush();     // Catch: Throwable -> L20
        L59:
            Binder.restoreCallingIdentity(ident);
            return;
        L25:
            if (args.length <= 0) goto L38;
            if ("--proto".equals(args[0]) == false) goto L38;
            Iterator<ServiceProvider> r2 = FaceService.m2643$$Nest$fgetmRegistry(this.this$0).getProviders().iterator();     // Catch: Throwable -> L20
        L30:
            if (r2.hasNext() == false) goto L59;
            ServiceProvider provider2 = r2.next();     // Catch: Throwable -> L20
            Iterator<FaceSensorPropertiesInternal> r4 = provider2.getSensorProperties().iterator();     // Catch: Throwable -> L20
        L33:
            if (r4.hasNext() == false) goto L30;
            provider2.dumpProtoMetrics(r4.next().sensorId, fd);     // Catch: Throwable -> L20
        L38:
            if (args.length > 1) goto L40;
        L50:
            Iterator<ServiceProvider> r5 = FaceService.m2643$$Nest$fgetmRegistry(this.this$0).getProviders().iterator();     // Catch: Throwable -> L20
        L52:
            if (r5.hasNext() == false) goto L59;
            ServiceProvider provider3 = r5.next();     // Catch: Throwable -> L20
            Iterator<FaceSensorPropertiesInternal> r7 = provider3.getSensorProperties().iterator();     // Catch: Throwable -> L20
        L55:
            if (r7.hasNext() == false) goto L52;
            FaceSensorPropertiesInternal props = r7.next();     // Catch: Throwable -> L20
            pw.println("Dumping for sensorId: " + props.sensorId + ", provider: " + provider3.getClass().getSimpleName());     // Catch: Throwable -> L20
            provider3.dumpInternal(props.sensorId, pw);     // Catch: Throwable -> L20
            pw.println();     // Catch: Throwable -> L20
            goto L55
        L40:
            if ("--hal".equals(args[0]) == false) goto L50;
            Iterator<ServiceProvider> r8 = FaceService.m2643$$Nest$fgetmRegistry(this.this$0).getProviders().iterator();     // Catch: Throwable -> L20
        L43:
            if (r8.hasNext() == false) goto L59;
            ServiceProvider provider4 = r8.next();     // Catch: Throwable -> L20
            Iterator<FaceSensorPropertiesInternal> r9 = provider4.getSensorProperties().iterator();     // Catch: Throwable -> L20
        L46:
            if (r9.hasNext() == false) goto L43;
            provider4.dumpHal(r9.next().sensorId, fd, (String[]) Arrays.copyOfRange(args, 1, args.length, args.getClass()));     // Catch: Throwable -> L20
            goto L46
        }

        public boolean isHardwareDetected(int sensorId, String opPackageName) {
            super.isHardwareDetected_enforcePermission();
            long token = Binder.clearCallingIdentity();
            ServiceProvider provider = FaceService.m2643$$Nest$fgetmRegistry(this.this$0).getProviderForSensor(sensorId);     // Catch: Throwable -> L8
            if (provider != null) goto L10;
            Slog.w(FaceService.TAG, "Null provider for isHardwareDetected, caller: " + opPackageName);     // Catch: Throwable -> L8
            Binder.restoreCallingIdentity(token);
            return false;
        L10:
            boolean r3 = provider.isHardwareDetected(sensorId);     // Catch: Throwable -> L8
            Binder.restoreCallingIdentity(token);
            return r3;
        L8:
            th = move-exception;
            Binder.restoreCallingIdentity(token);
            throw th;
        }

        public List<Face> getEnrolledFaces(int sensorId, int userId, String opPackageName) {
            super.getEnrolledFaces_enforcePermission();
            if (userId == UserHandle.getCallingUserId()) goto L5;
            Utils.checkPermission(this.this$0.getContext(), "android.permission.INTERACT_ACROSS_USERS");
        L5:
            ServiceProvider provider = FaceService.m2643$$Nest$fgetmRegistry(this.this$0).getProviderForSensor(sensorId);
            if (provider != null) goto L10;
            Slog.w(FaceService.TAG, "Null provider for getEnrolledFaces, caller: " + opPackageName);
            return Collections.emptyList();
        L10:
            return provider.getEnrolledFaces(sensorId, userId);
        }

        public boolean hasEnrolledFaces(int sensorId, int userId, String opPackageName) {
            super.hasEnrolledFaces_enforcePermission();
            if (userId == UserHandle.getCallingUserId()) goto L5;
            Utils.checkPermission(this.this$0.getContext(), "android.permission.INTERACT_ACROSS_USERS");
        L5:
            ServiceProvider provider = FaceService.m2643$$Nest$fgetmRegistry(this.this$0).getProviderForSensor(sensorId);
            if (provider != null) goto L10;
            Slog.w(FaceService.TAG, "Null provider for hasEnrolledFaces, caller: " + opPackageName);
            return false;
        L10:
            if (provider.getEnrolledFaces(sensorId, userId).size() <= 0) goto L13;
            return true;
        L13:
            return false;
        }

        public int getLockoutModeForUser(int sensorId, int userId) {
            super.getLockoutModeForUser_enforcePermission();
            ServiceProvider provider = FaceService.m2643$$Nest$fgetmRegistry(this.this$0).getProviderForSensor(sensorId);
            if (provider != null) goto L7;
            Slog.w(FaceService.TAG, "Null provider for getLockoutModeForUser");
            return 0;
        L7:
            return provider.getLockoutModeForUser(sensorId, userId);
        }

        public void invalidateAuthenticatorId(int sensorId, int userId, IInvalidationCallback callback) {
            super.invalidateAuthenticatorId_enforcePermission();
            ServiceProvider provider = FaceService.m2643$$Nest$fgetmRegistry(this.this$0).getProviderForSensor(sensorId);
            if (provider != null) goto L6;
            Slog.w(FaceService.TAG, "Null provider for invalidateAuthenticatorId");
            return;
        L6:
            provider.scheduleInvalidateAuthenticatorId(sensorId, userId, callback);
        }

        public long getAuthenticatorId(int sensorId, int userId) {
            super.getAuthenticatorId_enforcePermission();
            ServiceProvider provider = FaceService.m2643$$Nest$fgetmRegistry(this.this$0).getProviderForSensor(sensorId);
            if (provider != null) goto L7;
            Slog.w(FaceService.TAG, "Null provider for getAuthenticatorId");
            return 0;
        L7:
            return provider.getAuthenticatorId(sensorId, userId);
        }

        public void resetLockout(IBinder token, int sensorId, int userId, byte[] hardwareAuthToken, String opPackageName) {
            super.resetLockout_enforcePermission();
            ServiceProvider provider = FaceService.m2643$$Nest$fgetmRegistry(this.this$0).getProviderForSensor(sensorId);
            if (provider != null) goto L6;
            Slog.w(FaceService.TAG, "Null provider for resetLockout, caller: " + opPackageName);
            return;
        L6:
            provider.scheduleResetLockout(sensorId, userId, hardwareAuthToken);
        }

        public void setFeature(IBinder token, int userId, int feature, boolean enabled, byte[] hardwareAuthToken, IFaceServiceReceiver receiver, String opPackageName) {
            super.setFeature_enforcePermission();
            Pair<Integer, ServiceProvider> provider = FaceService.m2643$$Nest$fgetmRegistry(this.this$0).getSingleProvider();
            if (provider != null) goto L6;
            Slog.w(FaceService.TAG, "Null provider for setFeature");
            return;
        L6:
            ((ServiceProvider) provider.second).scheduleSetFeature(((Integer) provider.first).intValue(), token, userId, feature, enabled, hardwareAuthToken, receiver, opPackageName);
        }

        public void getFeature(IBinder token, int userId, int feature, IFaceServiceReceiver receiver, String opPackageName) {
            super.getFeature_enforcePermission();
            Pair<Integer, ServiceProvider> provider = FaceService.m2643$$Nest$fgetmRegistry(this.this$0).getSingleProvider();
            if (provider != null) goto L6;
            Slog.w(FaceService.TAG, "Null provider for getFeature");
            return;
        L6:
            ((ServiceProvider) provider.second).scheduleGetFeature(((Integer) provider.first).intValue(), token, userId, feature, new ClientMonitorCallbackConverter(receiver), opPackageName);
        }

        public void registerAuthenticators(final FaceSensorConfigurations faceSensorConfigurations) {
            super.registerAuthenticators_enforcePermission();
            if (faceSensorConfigurations.hasSensorConfigurations() == true) goto L6;
            Slog.d(FaceService.TAG, "No face sensors to register.");
            return;
        L6:
            FaceService.m2643$$Nest$fgetmRegistry(this.this$0).registerAll(new FaceService$FaceServiceWrapper$$ExternalSyntheticLambda0(this, faceSensorConfigurations));
        }

        private /* synthetic */ List lambda$registerAuthenticators$0(FaceSensorConfigurations faceSensorConfigurations) {
            return getProviders(faceSensorConfigurations);
        }

        private List<ServiceProvider> getProviders(FaceSensorConfigurations faceSensorConfigurations) {
            List<ServiceProvider> providers = new ArrayList();
            Pair<String, SensorProps[]> filteredSensorProps = filterAvailableHalInstances(faceSensorConfigurations);
            providers.add(FaceService.m2641$$Nest$fgetmFaceProviderFunction(this.this$0).getFaceProvider(filteredSensorProps, faceSensorConfigurations.getResetLockoutRequiresChallenge()));
            return providers;
        }

        private Pair<String, SensorProps[]> filterAvailableHalInstances(FaceSensorConfigurations faceSensorConfigurations) {
            String finalSensorInstance = faceSensorConfigurations.getSensorInstance();
            if (faceSensorConfigurations.isSingleSensorConfigurationPresent() == true) goto L5;
            boolean isVirtualHalPresent = faceSensorConfigurations.doesInstanceExist("virtual");
            if (isVirtualHalPresent == false) goto L13;
            String notAVirtualInstance = faceSensorConfigurations.getSensorNameNotForInstance("virtual");
            if (notAVirtualInstance == null) goto L13;
            return new Pair(notAVirtualInstance, faceSensorConfigurations.getSensorPropForInstance(notAVirtualInstance));
        L13:
            return new Pair(finalSensorInstance, faceSensorConfigurations.getSensorPropForInstance(finalSensorInstance));
        L5:
            return new Pair(finalSensorInstance, faceSensorConfigurations.getSensorPropForInstance(finalSensorInstance));
        }

        public void addAuthenticatorsRegisteredCallback(IFaceAuthenticatorsRegisteredCallback callback) {
            Utils.checkPermission(this.this$0.getContext(), "android.permission.USE_BIOMETRIC_INTERNAL");
            FaceService.m2643$$Nest$fgetmRegistry(this.this$0).addAllRegisteredCallback(callback);
        }

        public void registerBiometricStateListener(IBiometricStateListener listener) {
            FaceService.m2640$$Nest$fgetmBiometricStateCallback(this.this$0).registerBiometricStateListener(listener);
        }

        public void registerAuthenticationStateListener(AuthenticationStateListener listener) {
            super.registerAuthenticationStateListener_enforcePermission();
            FaceService.m2639$$Nest$fgetmAuthenticationStateListeners(this.this$0).registerAuthenticationStateListener(listener);
        }

        public void unregisterAuthenticationStateListener(AuthenticationStateListener listener) {
            super.unregisterAuthenticationStateListener_enforcePermission();
            FaceService.m2639$$Nest$fgetmAuthenticationStateListeners(this.this$0).unregisterAuthenticationStateListener(listener);
        }
    }

    public static /* synthetic */ String[] $r8$lambda$Ryx1sR9F_PaQGRNlhvwBdbGK1jk() {
        return lambda$new$1();
    }

    public static /* synthetic */ FaceProvider $r8$lambda$bIkHAVcg0tf2Ct7hUIVRvm66_Ik(FaceService r0, String r1) {
        return r0.lambda$new$2(r1);
    }

    public static /* synthetic */ IBiometricService $r8$lambda$p0mDtP9bFd18n3eGZfcWpAszxpc() {
        return lambda$new$0();
    }

    public static /* synthetic */ FaceProvider $r8$lambda$yI_yHRSI1YBE1A5gm_71HpmT2rA(FaceService r0, Pair r1, boolean r2) {
        return r0.lambda$new$3(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmAuthenticationStateListeners, reason: not valid java name */
    static /* bridge */ /* synthetic */ AuthenticationStateListeners m2639$$Nest$fgetmAuthenticationStateListeners(FaceService r0) {
        return r0.mAuthenticationStateListeners;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmBiometricStateCallback, reason: not valid java name */
    static /* bridge */ /* synthetic */ BiometricStateCallback m2640$$Nest$fgetmBiometricStateCallback(FaceService r0) {
        return r0.mBiometricStateCallback;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmFaceProviderFunction, reason: not valid java name */
    static /* bridge */ /* synthetic */ FaceProviderFunction m2641$$Nest$fgetmFaceProviderFunction(FaceService r0) {
        return r0.mFaceProviderFunction;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmLockoutResetDispatcher, reason: not valid java name */
    static /* bridge */ /* synthetic */ LockoutResetDispatcher m2642$$Nest$fgetmLockoutResetDispatcher(FaceService r0) {
        return r0.mLockoutResetDispatcher;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmRegistry, reason: not valid java name */
    static /* bridge */ /* synthetic */ FaceServiceRegistry m2643$$Nest$fgetmRegistry(FaceService r0) {
        return r0.mRegistry;
    }

    public static native NativeHandle acquireSurfaceHandle(Surface r0);

    public static native void releaseSurfaceHandle(NativeHandle r0);

    public FaceService(Context context) {
        this(context, null, new FaceService$$ExternalSyntheticLambda2(), null, new FaceService$$ExternalSyntheticLambda3());
    }

    private static /* synthetic */ IBiometricService lambda$new$0() {
        return IBiometricService.Stub.asInterface(ServiceManager.getService("biometric"));
    }

    private static /* synthetic */ String[] lambda$new$1() {
        return getDeclaredInstances();
    }

    FaceService(Context context, FaceProviderFunction faceProviderFunction, Supplier<IBiometricService> biometricServiceSupplier, Function<String, FaceProvider> faceProvider, Supplier<String[]> aidlInstanceNameSupplier) {
        super(context);
        this.mServiceWrapper = new FaceServiceWrapper(this);
        this.mLockoutResetDispatcher = new LockoutResetDispatcher(context);
        this.mLockPatternUtils = new LockPatternUtils(context);
        this.mBiometricStateCallback = new BiometricStateCallback(UserManager.get(context));
        this.mAuthenticationStateListeners = new AuthenticationStateListeners();
        this.mRegistry = new FaceServiceRegistry(this.mServiceWrapper, biometricServiceSupplier);
        this.mRegistry.addAllRegisteredCallback(new AnonymousClass1(this));
        this.mAidlInstanceNameSupplier = aidlInstanceNameSupplier;
        if (faceProvider == null) goto L5;
        Function<String, FaceProvider> r0 = faceProvider;
    L6:
        this.mFaceProvider = r0;
        if (faceProviderFunction == null) goto L9;
        FaceProviderFunction r1 = faceProviderFunction;
    L10:
        this.mFaceProviderFunction = r1;
        return;
    L9:
        r1 = new FaceService$$ExternalSyntheticLambda1(this);
        goto L10
    L5:
        r0 = new FaceService$$ExternalSyntheticLambda0(this);
        goto L6
    }

    private /* synthetic */ FaceProvider lambda$new$2(String name) {
        String fqName = IFace.DESCRIPTOR + SliceClientPermissions.SliceAuthority.DELIMITER + name;
        IFace face = FaceSensorConfigurations.getIFace(fqName);
        if (face != null) goto L18;
        Slog.e(TAG, "Unable to get declared service: " + fqName);
        return null;
    L18:
        SensorProps[] props = face.getSensorProps();     // Catch: RemoteException -> L12
        return new FaceProvider(getContext(), this.mBiometricStateCallback, this.mAuthenticationStateListeners, props, name, this.mLockoutResetDispatcher, BiometricContext.getInstance(getContext()), false);
    L14:
        Slog.e(TAG, "Remote exception in getSensorProps: " + fqName);
        return null;
    }

    private /* synthetic */ FaceProvider lambda$new$3(Pair filteredSensorProps, boolean resetLockoutRequiresChallenge) {
        return new FaceProvider(getContext(), this.mBiometricStateCallback, this.mAuthenticationStateListeners, (SensorProps[]) filteredSensorProps.second, (String) filteredSensorProps.first, this.mLockoutResetDispatcher, BiometricContext.getInstance(getContext()), resetLockoutRequiresChallenge);
    }

    @Override // com.android.server.SystemService
    public void onStart() {
        publishBinderService("face", this.mServiceWrapper);
    }

    public static String[] getDeclaredInstances() {
        String[] a = ServiceManager.getDeclaredInstances(IFace.DESCRIPTOR);
        Slog.i(TAG, "Before:getDeclaredInstances: IFace instance found, a.length=" + a.length);
        if (ArrayUtils.contains(a, "virtual") == true) goto L5;
        a = (String[]) ArrayUtils.appendElement(String.class, a, "virtual");
    L5:
        Slog.i(TAG, "After:getDeclaredInstances: a.length=" + a.length);
        return a;
    }

    void syncEnrollmentsNow() {
        Utils.checkPermissionOrShell(getContext(), "android.permission.MANAGE_FACE");
    }

    void sendFaceReEnrollNotification() {
        Utils.checkPermissionOrShell(getContext(), "android.permission.MANAGE_FACE");
        if (Build.IS_DEBUGGABLE == false) goto L14;
        long identity = Binder.clearCallingIdentity();
        Pair<Integer, ServiceProvider> provider = this.mRegistry.getSingleProvider();     // Catch: Throwable -> L8
        if (provider == null) goto L10;
        FaceProvider faceProvider = (FaceProvider) provider.second;     // Catch: Throwable -> L8
        faceProvider.sendFaceReEnrollNotification();     // Catch: Throwable -> L8
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
}
