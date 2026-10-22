package com.android.server.biometrics.sensors;

import android.content.pm.UserInfo;
import android.hardware.biometrics.IBiometricStateListener;
import android.hardware.biometrics.SensorPropertiesInternal;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.UserManager;
import android.util.Slog;
import com.android.server.biometrics.Utils;
import com.android.server.biometrics.sensors.BiometricServiceProvider;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes.dex */
public class BiometricStateCallback<T extends BiometricServiceProvider<P>, P extends SensorPropertiesInternal> implements ClientMonitorCallback, IBinder.DeathRecipient {
    private static final String TAG = "BiometricStateCallback";
    private int mBiometricState;
    private final CopyOnWriteArrayList<IBiometricStateListener> mBiometricStateListeners;
    private List<T> mProviders;
    private final UserManager mUserManager;

    public static /* synthetic */ boolean $r8$lambda$gra2Sznc6rayrA1p1NXhswU9tqo(IBinder r0, IBiometricStateListener r1) {
        return lambda$binderDied$0(r0, r1);
    }

    public BiometricStateCallback(UserManager userManager) {
        this.mBiometricStateListeners = new CopyOnWriteArrayList();
        this.mProviders = List.of();
        this.mBiometricState = 0;
        this.mUserManager = userManager;
    }

    public synchronized void start(List<T> allProviders) {
        monitor-enter(this);
        this.mProviders = Collections.unmodifiableList(allProviders);     // Catch: Throwable -> L6
        broadcastCurrentEnrollmentState(null);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public int getBiometricState() {
        return this.mBiometricState;
    }

    @Override // com.android.server.biometrics.sensors.ClientMonitorCallback
    public void onClientStarted(BaseClientMonitor client) {
        int previousBiometricState = this.mBiometricState;
        if ((client instanceof AuthenticationClient) == false) goto L13;
        AuthenticationClient<?, ?> authClient = (AuthenticationClient) client;
        if (authClient.isKeyguard() == false) goto L8;
        this.mBiometricState = 2;
    L16:
        Slog.d(TAG, "State updated from " + previousBiometricState + " to " + this.mBiometricState + ", client " + client);
        notifyBiometricStateListeners(this.mBiometricState);
        return;
    L8:
        if (authClient.isBiometricPrompt() == false) goto L10;
        this.mBiometricState = 3;
        goto L16
    L10:
        this.mBiometricState = 4;
        goto L16
    L13:
        if ((client instanceof EnrollClient) == false) goto L15;
        this.mBiometricState = 1;
        goto L16
    L15:
        Slog.w(TAG, "Other authentication client: " + Utils.getClientName(client));
        this.mBiometricState = 0;
        goto L16
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.android.server.biometrics.sensors.ClientMonitorCallback
    public void onClientFinished(BaseClientMonitor r6, boolean success) {
        this.mBiometricState = 0;
        Slog.d(TAG, "Client finished, state updated to " + this.mBiometricState + ", client " + r6);
        if ((r6 instanceof EnrollmentModifier) == false) goto L7;
        EnrollmentModifier enrollmentModifier = (EnrollmentModifier) r6;
        boolean enrollmentStateChanged = enrollmentModifier.hasEnrollmentStateChanged();
        Slog.d(TAG, "Enrollment state changed: " + enrollmentStateChanged);
        if (enrollmentStateChanged == false) goto L7;
        notifyAllEnrollmentStateChanged(r6.getTargetUserId(), r6.getSensorId(), enrollmentModifier.hasEnrollments());
    L7:
        notifyBiometricStateListeners(this.mBiometricState);
    }

    private void notifyBiometricStateListeners(int newState) {
        Iterator<IBiometricStateListener> r0 = this.mBiometricStateListeners.iterator();
    L4:
        if (r0.hasNext() == false) goto L11;
        IBiometricStateListener listener = r0.next();
        listener.onStateChanged(newState);     // Catch: RemoteException -> L8
    L8:
        e = move-exception;
        Slog.e(TAG, "Remote exception in biometric state change", e);
        goto L4
    }

    @Override // com.android.server.biometrics.sensors.ClientMonitorCallback
    public void onBiometricAction(int action) {
        Iterator<IBiometricStateListener> r0 = this.mBiometricStateListeners.iterator();
    L4:
        if (r0.hasNext() == false) goto L11;
        IBiometricStateListener listener = r0.next();
        listener.onBiometricAction(action);     // Catch: RemoteException -> L8
    L8:
        e = move-exception;
        Slog.e(TAG, "Remote exception in onBiometricAction", e);
        goto L4
    }

    public synchronized void registerBiometricStateListener(IBiometricStateListener listener) {
        monitor-enter(this);
        this.mBiometricStateListeners.add(listener);     // Catch: Throwable -> L6
        broadcastCurrentEnrollmentState(listener);     // Catch: Throwable -> L6
        listener.asBinder().linkToDeath(this, 0);     // Catch: Throwable -> L6 RemoteException -> L8
    L10:
        monitor-exit(this);
        return;
    L8:
        e = move-exception;
        Slog.e(TAG, "Failed to link to death", e);     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        throw th;
    }

    private synchronized void broadcastCurrentEnrollmentState(IBiometricStateListener listener) {
        monitor-enter(this);
        Iterator<T> r0 = this.mProviders.iterator();     // Catch: Throwable -> L15
    L4:
        if (r0.hasNext() == false) goto L21;
        T provider = r0.next();     // Catch: Throwable -> L15
        Iterator r2 = provider.getSensorProperties().iterator();     // Catch: Throwable -> L15
    L8:
        if (r2.hasNext() == false) goto L4;
        SensorPropertiesInternal prop = (SensorPropertiesInternal) r2.next();     // Catch: Throwable -> L15
        Iterator r4 = this.mUserManager.getAliveUsers().iterator();     // Catch: Throwable -> L15
    L11:
        if (r4.hasNext() == false) goto L8;
        UserInfo userInfo = (UserInfo) r4.next();     // Catch: Throwable -> L15
        boolean enrolled = provider.hasEnrollments(prop.sensorId, userInfo.id);     // Catch: Throwable -> L15
        if (listener != null) goto L14;
        notifyAllEnrollmentStateChanged(userInfo.id, prop.sensorId, enrolled);     // Catch: Throwable -> L15
        goto L11
    L14:
        notifyEnrollmentStateChanged(listener, userInfo.id, prop.sensorId, enrolled);     // Catch: Throwable -> L15
        goto L11
    L21:
        monitor-exit(this);
        return;
    L15:
        th = move-exception;
        throw th;
    }

    private void notifyAllEnrollmentStateChanged(int userId, int sensorId, boolean hasEnrollments) {
        Iterator<IBiometricStateListener> r0 = this.mBiometricStateListeners.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        IBiometricStateListener listener = r0.next();
        notifyEnrollmentStateChanged(listener, userId, sensorId, hasEnrollments);
        goto L4
    }

    private void notifyEnrollmentStateChanged(IBiometricStateListener listener, int userId, int sensorId, boolean hasEnrollments) {
        listener.onEnrollmentsChanged(userId, sensorId, hasEnrollments);     // Catch: RemoteException -> L4
        return;
    L4:
        e = move-exception;
        Slog.e(TAG, "Remote exception", e);
    }

    @Override // android.os.IBinder.DeathRecipient
    public void binderDied() {
    }

    @Override // android.os.IBinder.DeathRecipient
    public void binderDied(final IBinder who) {
        Slog.w(TAG, "Callback binder died: " + who);
        if (this.mBiometricStateListeners.removeIf(new BiometricStateCallback$$ExternalSyntheticLambda0(who)) == false) goto L5;
        Slog.w(TAG, "Removed dead listener for " + who);
        return;
    L5:
        Slog.w(TAG, "No dead listeners found");
    }

    private static /* synthetic */ boolean lambda$binderDied$0(IBinder who, IBiometricStateListener listener) {
        return listener.asBinder().equals(who);
    }
}
