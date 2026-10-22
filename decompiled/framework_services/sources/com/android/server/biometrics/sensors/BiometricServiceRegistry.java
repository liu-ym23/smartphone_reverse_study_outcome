package com.android.server.biometrics.sensors;

import android.hardware.biometrics.IBiometricService;
import android.hardware.biometrics.SensorPropertiesInternal;
import android.os.Handler;
import android.os.IInterface;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.util.Pair;
import android.util.Slog;
import com.android.server.ServiceThread;
import com.android.server.biometrics.sensors.BiometricServiceProvider;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.function.Supplier;

/* JADX INFO: loaded from: classes.dex */
public abstract class BiometricServiceRegistry<T extends BiometricServiceProvider<P>, P extends SensorPropertiesInternal, C extends IInterface> {
    private static final String TAG = "BiometricServiceRegistry";
    public volatile List<P> mAllProps;
    private final Supplier<IBiometricService> mBiometricServiceSupplier;
    private final RemoteCallbackList<C> mRegisteredCallbacks;
    private volatile List<T> mServiceProviders;

    public static /* synthetic */ void $r8$lambda$x0WsIKdzUnRnfbom1Yua11lD2N0(BiometricServiceRegistry r0, Supplier r1) {
        r0.lambda$registerAll$0(r1);
    }

    protected abstract void invokeRegisteredCallback(C r1, List<P> r2) throws RemoteException;

    protected abstract void registerService(IBiometricService r1, P r2);

    public BiometricServiceRegistry(Supplier<IBiometricService> biometricSupplier) {
        this.mRegisteredCallbacks = new RemoteCallbackList();
        this.mBiometricServiceSupplier = biometricSupplier;
    }

    public void registerAll(final Supplier<List<T>> serviceProvider) {
        ServiceThread thread = new ServiceThread(TAG, 10, true);
        thread.start();
        Handler handler = new Handler(thread.getLooper());
        handler.post(new BiometricServiceRegistry$$ExternalSyntheticLambda0(this, serviceProvider));
        thread.quitSafely();
    }

    private /* synthetic */ void lambda$registerAll$0(Supplier serviceProvider) {
        registerAllInBackground(serviceProvider);
    }

    public void registerAllInBackground(Supplier<List<T>> serviceProvider) {
        List<T> providers = serviceProvider.get();
        if (providers != null) goto L5;
        providers = new ArrayList();
    L5:
        IBiometricService biometricService = this.mBiometricServiceSupplier.get();
        if (biometricService == null) goto L21;
        List<P> allProps = new ArrayList();
        Iterator<T> r3 = providers.iterator();
    L9:
        if (r3.hasNext() == false) goto L18;
        T provider = r3.next();
        if (provider == null) goto L9;
        List<P> props = provider.getSensorProperties();
        Iterator<P> r6 = props.iterator();
    L14:
        if (r6.hasNext() == false) goto L16;
        P prop = r6.next();
        registerService(biometricService, prop);
        goto L14
    L16:
        allProps.addAll(props);
        goto L9
    L18:
        finishRegistration(providers, allProps);
        return;
    L21:
        throw new IllegalStateException("biometric service cannot be null");
    }

    private synchronized void finishRegistration(List<T> providers, List<P> allProps) {
        monitor-enter(this);
        this.mServiceProviders = Collections.unmodifiableList(providers);     // Catch: Throwable -> L6
        this.mAllProps = Collections.unmodifiableList(allProps);     // Catch: Throwable -> L6
        broadcastAllAuthenticatorsRegistered();     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized void addAllRegisteredCallback(C callback) {
        monitor-enter(this);
        if (callback != null) goto L9;
        Slog.e(TAG, "addAllRegisteredCallback, callback is null");     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L9:
        boolean registered = this.mRegisteredCallbacks.register(callback);     // Catch: Throwable -> L7
        if (this.mServiceProviders == null) goto L12;
        boolean allRegistered = true;
    L13:
        if (registered == false) goto L16;
        if (allRegistered == false) goto L16;
        broadcastAllAuthenticatorsRegistered();     // Catch: Throwable -> L7
    L18:
        monitor-exit(this);
        return;
    L16:
        if (registered == true) goto L18;
        Slog.e(TAG, "addAllRegisteredCallback failed to register callback");     // Catch: Throwable -> L7
        goto L18
    L12:
        allRegistered = false;
    L7:
        th = move-exception;
        throw th;
    }

    private synchronized void broadcastAllAuthenticatorsRegistered() {
        monitor-enter(this);
        int n = this.mRegisteredCallbacks.beginBroadcast();     // Catch: Throwable -> L9
        int i = 0;
    L4:
        if (i >= n) goto L19;
        IInterface r2 = this.mRegisteredCallbacks.getBroadcastItem(i);     // Catch: Throwable -> L9
        invokeRegisteredCallback(r2, this.mAllProps);     // Catch: Throwable -> L11 RemoteException -> L13
        this.mRegisteredCallbacks.unregister(r2);     // Catch: Throwable -> L9
    L16:
        i = i + 1;     // Catch: Throwable -> L9
        goto L4
    L13:
        e = move-exception;
        Slog.e(TAG, "Remote exception in broadcastAllAuthenticatorsRegistered", e);     // Catch: Throwable -> L11
        this.mRegisteredCallbacks.unregister(r2);     // Catch: Throwable -> L9
    L11:
        th = move-exception;
        this.mRegisteredCallbacks.unregister(r2);     // Catch: Throwable -> L9
        throw th;     // Catch: Throwable -> L9
    L19:
        this.mRegisteredCallbacks.finishBroadcast();     // Catch: Throwable -> L9
        monitor-exit(this);
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public List<T> getProviders() {
        if (this.mServiceProviders == null) goto L6;
        return this.mServiceProviders;
    L6:
        return Collections.emptyList();
    }

    public T getProviderForSensor(int sensorId) {
        if (this.mServiceProviders == null) goto L11;
        Iterator<T> r0 = this.mServiceProviders.iterator();
    L6:
        if (r0.hasNext() == false) goto L16;
        T provider = r0.next();
        if (provider.containsSensor(sensorId) == false) goto L6;
        return provider;
    L16:
        return null;
    L11:
        return null;
    }

    public Pair<Integer, T> getSingleProvider() {
        if (this.mAllProps != null) goto L5;
    L24:
        Slog.e(TAG, "No sensors found");
        return null;
    L5:
        if (this.mAllProps.isEmpty() == true) goto L24;
    L10:
        e = move-exception;
        if (this.mAllProps != null) goto L21;
        String extra = "mAllProps: null";
    L22:
        Slog.e(TAG, "This shouldn't happen. " + extra, e);
        throw e;
    L21:
        extra = "mAllProps.size(): " + this.mAllProps.size();
        goto L22
    L8:
        if (this.mAllProps.size() <= 1) goto L12;
        Slog.e(TAG, "getSingleProvider() called but multiple sensors present: " + this.mAllProps.size());     // Catch: NullPointerException -> L10
    L12:
        int sensorId = ((SensorPropertiesInternal) this.mAllProps.get(0)).sensorId;     // Catch: NullPointerException -> L10
        BiometricServiceProvider r3 = getProviderForSensor(sensorId);     // Catch: NullPointerException -> L10
        if (r3 != null) goto L15;
        Slog.e(TAG, "Single sensor: " + sensorId + ", but provider not found");     // Catch: NullPointerException -> L10
        return null;
    L15:
        return new Pair(Integer.valueOf(sensorId), r3);
    }

    public List<P> getAllProperties() {
        if (this.mAllProps == null) goto L6;
        return this.mAllProps;
    L6:
        return Collections.emptyList();
    }
}
