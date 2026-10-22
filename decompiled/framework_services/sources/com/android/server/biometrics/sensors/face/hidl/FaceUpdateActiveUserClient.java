package com.android.server.biometrics.sensors.face.hidl;

import android.content.Context;
import android.hardware.biometrics.face.V1_0.IBiometricsFace;
import android.os.Environment;
import android.os.RemoteException;
import android.util.Slog;
import com.android.server.biometrics.log.BiometricContext;
import com.android.server.biometrics.log.BiometricLogger;
import com.android.server.biometrics.sensors.ClientMonitorCallback;
import com.android.server.biometrics.sensors.StartUserClient;
import com.android.server.biometrics.sensors.face.aidl.AidlSession;
import java.io.File;
import java.util.Map;
import java.util.function.Supplier;

/* JADX INFO: loaded from: classes.dex */
public class FaceUpdateActiveUserClient extends StartUserClient<IBiometricsFace, AidlSession> {
    private static final String FACE_DATA_DIR = "facedata";
    private static final String TAG = "FaceUpdateActiveUserClient";
    private final Map<Integer, Long> mAuthenticatorIds;
    private final boolean mHasEnrolledBiometrics;

    public static /* synthetic */ void $r8$lambda$BA6BN3UdvQAQX5t64Dns_8Ck6gY(int r0, Object r1, int r2) {
        lambda$new$0(r0, r1, r2);
    }

    FaceUpdateActiveUserClient(Context context, Supplier<IBiometricsFace> lazyDaemon, int userId, String owner, int sensorId, BiometricLogger logger, BiometricContext biometricContext, boolean hasEnrolledBiometrics, Map<Integer, Long> authenticatorIds) {
        this(context, lazyDaemon, new FaceUpdateActiveUserClient$$ExternalSyntheticLambda0(), userId, owner, sensorId, logger, biometricContext, hasEnrolledBiometrics, authenticatorIds);
    }

    private static /* synthetic */ void lambda$new$0(int newUserId, Object newUser, int halInterfaceVersion) {
    }

    FaceUpdateActiveUserClient(Context context, Supplier<IBiometricsFace> lazyDaemon, StartUserClient.UserStartedCallback userStartedCallback, int userId, String owner, int sensorId, BiometricLogger logger, BiometricContext biometricContext, boolean hasEnrolledBiometrics, Map<Integer, Long> authenticatorIds) {
        super(context, lazyDaemon, null, userId, sensorId, logger, biometricContext, userStartedCallback);
        this.mHasEnrolledBiometrics = hasEnrolledBiometrics;
        this.mAuthenticatorIds = authenticatorIds;
    }

    @Override // com.android.server.biometrics.sensors.BaseClientMonitor
    public void start(ClientMonitorCallback callback) {
        super.start(callback);
        startHalOperation();
    }

    @Override // com.android.server.biometrics.sensors.HalClientMonitor
    public void unableToStart() {
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.android.server.biometrics.sensors.HalClientMonitor
    protected void startHalOperation() {
        File storePath = new File(Environment.getDataVendorDeDirectory(getTargetUserId()), FACE_DATA_DIR);
        if (storePath.exists() == true) goto L16;
        Slog.e(TAG, "vold has not created the directory?");
        this.mCallback.onClientFinished(this, false);
        return;
    L16:
        IBiometricsFace daemon = getFreshDaemon();     // Catch: RemoteException -> L9
        daemon.setActiveUser(getTargetUserId(), storePath.getAbsolutePath());     // Catch: RemoteException -> L9
        Map<Integer, Long> r4 = this.mAuthenticatorIds;     // Catch: RemoteException -> L9
        Integer r5 = Integer.valueOf(getTargetUserId());     // Catch: RemoteException -> L9
        if (this.mHasEnrolledBiometrics == false) goto L11;
        long r6 = daemon.getAuthenticatorId().value;     // Catch: RemoteException -> L9
    L12:
        r4.put(r5, Long.valueOf(r6));     // Catch: RemoteException -> L9
        this.mUserStartedCallback.onUserStarted(getTargetUserId(), null, 0);     // Catch: RemoteException -> L9
        this.mCallback.onClientFinished(this, true);     // Catch: RemoteException -> L9
        return;
    L11:
        r6 = 0;
    L9:
        e = move-exception;
        Slog.e(TAG, "Failed to setActiveUser: " + e);
        this.mCallback.onClientFinished(this, false);
    }

    @Override // com.android.server.biometrics.sensors.StartUserClient, com.android.server.biometrics.sensors.BaseClientMonitor
    public int getProtoEnum() {
        return 1;
    }
}
