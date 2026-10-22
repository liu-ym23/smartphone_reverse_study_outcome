package com.android.server.biometrics.sensors.face.aidl;

import android.content.Context;
import android.hardware.biometrics.face.IFace;
import android.hardware.biometrics.face.ISession;
import android.hardware.biometrics.face.ISessionCallback;
import android.os.Binder;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Slog;
import com.android.server.biometrics.log.BiometricContext;
import com.android.server.biometrics.log.BiometricLogger;
import com.android.server.biometrics.sensors.ClientMonitorCallback;
import com.android.server.biometrics.sensors.StartUserClient;
import java.util.function.Supplier;

/* JADX INFO: loaded from: classes.dex */
public class FaceStartUserClient extends StartUserClient<IFace, ISession> {
    private static final String TAG = "FaceStartUserClient";
    private final ISessionCallback mSessionCallback;

    public FaceStartUserClient(Context context, Supplier<IFace> lazyDaemon, IBinder token, int userId, int sensorId, BiometricLogger logger, BiometricContext biometricContext, ISessionCallback sessionCallback, StartUserClient.UserStartedCallback<ISession> callback) {
        super(context, lazyDaemon, token, userId, sensorId, logger, biometricContext, callback);
        this.mSessionCallback = sessionCallback;
    }

    @Override // com.android.server.biometrics.sensors.BaseClientMonitor
    public void start(ClientMonitorCallback callback) {
        super.start(callback);
        startHalOperation();
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
        IFace hal = getFreshDaemon();     // Catch: RemoteException -> L4
        int version = hal.getInterfaceVersion();     // Catch: RemoteException -> L4
        ISession newSession = hal.createSession(getSensorId(), getTargetUserId(), this.mSessionCallback);     // Catch: RemoteException -> L4
        Binder.allowBlocking(newSession.asBinder());     // Catch: RemoteException -> L4
        this.mUserStartedCallback.onUserStarted(getTargetUserId(), newSession, version);     // Catch: RemoteException -> L4
        getCallback().onClientFinished(this, true);     // Catch: RemoteException -> L4
        return;
    L4:
        e = move-exception;
        Slog.e(TAG, "Remote exception", e);
        getCallback().onClientFinished(this, false);
    }

    @Override // com.android.server.biometrics.sensors.HalClientMonitor
    public void unableToStart() {
    }
}
