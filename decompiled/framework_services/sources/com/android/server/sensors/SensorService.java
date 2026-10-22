package com.android.server.sensors;

import android.content.Context;
import android.util.ArrayMap;
import com.android.internal.util.ConcurrentUtils;
import com.android.server.LocalServices;
import com.android.server.SystemServerInitThreadPool;
import com.android.server.SystemService;
import com.android.server.utils.TimingsTraceAndSlog;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;

/* JADX INFO: loaded from: classes3.dex */
public class SensorService extends SystemService {
    private static final String START_NATIVE_SENSOR_SERVICE = "StartNativeSensorService";
    private final Object mLock;
    private final ArrayMap<SensorManagerInternal.ProximityActiveListener, ProximityListenerProxy> mProximityListeners;
    private long mPtr;
    private final Set<Integer> mRuntimeSensorHandles;
    private Future<?> mSensorServiceStart;

    class LocalService extends SensorManagerInternal {
        final /* synthetic */ SensorService this$0;

        LocalService(SensorService this$0) {
            this.this$0 = this$0;
        }

        @Override // com.android.server.sensors.SensorManagerInternal
        public int createRuntimeSensor(int deviceId, int type, String name, String vendor2, float maximumRange, float resolution, float power, int minDelay, int maxDelay, int flags, SensorManagerInternal.RuntimeSensorCallback callback) {
            Object r2 = SensorService.m8133$$Nest$fgetmLock(this.this$0);
            monitor-enter(r2);
            int handle = SensorService.m8138$$Nest$smregisterRuntimeSensorNative(SensorService.m8135$$Nest$fgetmPtr(this.this$0), deviceId, type, name, vendor2, maximumRange, resolution, power, minDelay, maxDelay, flags, callback);     // Catch: Throwable -> L7
            SensorService.m8136$$Nest$fgetmRuntimeSensorHandles(this.this$0).add(Integer.valueOf(handle));     // Catch: Throwable -> L7
            monitor-exit(r2);     // Catch: Throwable -> L7
            return handle;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.android.server.sensors.SensorManagerInternal
        public void removeRuntimeSensor(int handle) {
            Object r0 = SensorService.m8133$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
        L7:
            th = move-exception;
            throw th;
        L5:
            if (SensorService.m8136$$Nest$fgetmRuntimeSensorHandles(this.this$0).contains(Integer.valueOf(handle)) == false) goto L9;
            SensorService.m8136$$Nest$fgetmRuntimeSensorHandles(this.this$0).remove(Integer.valueOf(handle));     // Catch: Throwable -> L7
            SensorService.m8142$$Nest$smunregisterRuntimeSensorNative(SensorService.m8135$$Nest$fgetmPtr(this.this$0), handle);     // Catch: Throwable -> L7
        L9:
            monitor-exit(r0);     // Catch: Throwable -> L7
        }

        @Override // com.android.server.sensors.SensorManagerInternal
        public boolean sendSensorEvent(int handle, int type, long timestampNanos, float[] values) {
            Object r1 = SensorService.m8133$$Nest$fgetmLock(this.this$0);
            monitor-enter(r1);
        L16:
            th = th;
        L20:
            monitor-exit(r1);     // Catch: Throwable -> L16
            throw th;
        L18:
            th = th;
            goto L20
        L5:
            if (SensorService.m8136$$Nest$fgetmRuntimeSensorHandles(this.this$0).contains(Integer.valueOf(handle)) == false) goto L24;
            boolean r10 = SensorService.m8140$$Nest$smsendRuntimeSensorEventNative(SensorService.m8135$$Nest$fgetmPtr(this.this$0), handle, type, timestampNanos, values);     // Catch: Throwable -> L16
            monitor-exit(r1);     // Catch: Throwable -> L16
            return r10;
        L24:
            monitor-exit(r1);     // Catch: Throwable -> L9
            return false;
        L9:
            th = th;
            goto L20
        }

        @Override // com.android.server.sensors.SensorManagerInternal
        public boolean sendSensorAdditionalInfo(int handle, int type, int serial, long timestampNanos, float[] values) {
            Object r1 = SensorService.m8133$$Nest$fgetmLock(this.this$0);
            monitor-enter(r1);
        L9:
            th = move-exception;
            throw th;
        L5:
            if (SensorService.m8136$$Nest$fgetmRuntimeSensorHandles(this.this$0).contains(Integer.valueOf(handle)) == true) goto L11;
            monitor-exit(r1);     // Catch: Throwable -> L9
            return false;
        L11:
            boolean r0 = SensorService.m8139$$Nest$smsendRuntimeSensorAdditionalInfoNative(SensorService.m8135$$Nest$fgetmPtr(this.this$0), handle, type, serial, timestampNanos, values);     // Catch: Throwable -> L9
            monitor-exit(r1);     // Catch: Throwable -> L9
            return r0;
        }

        @Override // com.android.server.sensors.SensorManagerInternal
        public void addProximityActiveListener(Executor executor, SensorManagerInternal.ProximityActiveListener listener) {
            executor.getClass();
            listener.getClass();
            ProximityListenerProxy proxy = new ProximityListenerProxy(executor, listener);
            Object r1 = SensorService.m8133$$Nest$fgetmLock(this.this$0);
            monitor-enter(r1);
        L9:
            th = move-exception;
            throw th;
        L5:
            if (SensorService.m8134$$Nest$fgetmProximityListeners(this.this$0).containsKey(listener) == true) goto L14;
            SensorService.m8134$$Nest$fgetmProximityListeners(this.this$0).put(listener, proxy);     // Catch: Throwable -> L9
            if (SensorService.m8134$$Nest$fgetmProximityListeners(this.this$0).size() != 1) goto L11;
            SensorService.m8137$$Nest$smregisterProximityActiveListenerNative(SensorService.m8135$$Nest$fgetmPtr(this.this$0));     // Catch: Throwable -> L9
        L11:
            monitor-exit(r1);     // Catch: Throwable -> L9
            return;
        L14:
            throw new IllegalArgumentException("listener already registered");     // Catch: Throwable -> L9
        }

        @Override // com.android.server.sensors.SensorManagerInternal
        public void removeProximityActiveListener(SensorManagerInternal.ProximityActiveListener listener) {
            listener.getClass();
            Object r0 = SensorService.m8133$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
            ProximityListenerProxy proxy = (ProximityListenerProxy) SensorService.m8134$$Nest$fgetmProximityListeners(this.this$0).remove(listener);     // Catch: Throwable -> L9
            if (proxy == null) goto L14;
            if (SensorService.m8134$$Nest$fgetmProximityListeners(this.this$0).isEmpty() == false) goto L11;
            SensorService.m8141$$Nest$smunregisterProximityActiveListenerNative(SensorService.m8135$$Nest$fgetmPtr(this.this$0));     // Catch: Throwable -> L9
        L11:
            monitor-exit(r0);     // Catch: Throwable -> L9
            return;
        L14:
            throw new IllegalArgumentException("listener was not registered with sensor service");     // Catch: Throwable -> L9
        L9:
            th = move-exception;
            throw th;
        }
    }

    private class ProximityListenerDelegate implements SensorManagerInternal.ProximityActiveListener {
        final /* synthetic */ SensorService this$0;

        /* synthetic */ ProximityListenerDelegate(SensorService r1, SensorServiceIA r2) {
            this(r1);
        }

        private ProximityListenerDelegate(SensorService r1) {
            this.this$0 = r1;
        }

        @Override // com.android.server.sensors.SensorManagerInternal.ProximityActiveListener
        public void onProximityActive(boolean isActive) {
            Object r0 = SensorService.m8133$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
            int r2 = 0;
            ProximityListenerProxy[] listeners = (ProximityListenerProxy[]) SensorService.m8134$$Nest$fgetmProximityListeners(this.this$0).values().toArray(new ProximityListenerProxy[0]);     // Catch: Throwable -> L10
            monitor-exit(r0);     // Catch: Throwable -> L10
            int r1 = listeners.length;
        L7:
            if (r2 >= r1) goto L9;
            ProximityListenerProxy listener = listeners[r2];
            listener.onProximityActive(isActive);
            r2 = r2 + 1;
            goto L7
        L9:
            return;
        L10:
            th = move-exception;
            throw th;
        }
    }

    private static class ProximityListenerProxy implements SensorManagerInternal.ProximityActiveListener {
        private final Executor mExecutor;
        private final SensorManagerInternal.ProximityActiveListener mListener;

        public static /* synthetic */ void $r8$lambda$lZwMJTdMAI1bCMIxj5Bw6uRSXWw(ProximityListenerProxy r0, boolean r1) {
            r0.lambda$onProximityActive$0(r1);
        }

        ProximityListenerProxy(Executor executor, SensorManagerInternal.ProximityActiveListener listener) {
            this.mExecutor = executor;
            this.mListener = listener;
        }

        private /* synthetic */ void lambda$onProximityActive$0(boolean isActive) {
            this.mListener.onProximityActive(isActive);
        }

        @Override // com.android.server.sensors.SensorManagerInternal.ProximityActiveListener
        public void onProximityActive(final boolean isActive) {
            this.mExecutor.execute(new SensorService$ProximityListenerProxy$$ExternalSyntheticLambda0(this, isActive));
        }
    }

    public static /* synthetic */ void $r8$lambda$tuvhrgJDhAzfGFTh_3IUBIw3Spg(SensorService r0) {
        r0.lambda$new$0();
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmLock, reason: not valid java name */
    static /* bridge */ /* synthetic */ Object m8133$$Nest$fgetmLock(SensorService r0) {
        return r0.mLock;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmProximityListeners, reason: not valid java name */
    static /* bridge */ /* synthetic */ ArrayMap m8134$$Nest$fgetmProximityListeners(SensorService r0) {
        return r0.mProximityListeners;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmPtr, reason: not valid java name */
    static /* bridge */ /* synthetic */ long m8135$$Nest$fgetmPtr(SensorService r2) {
        return r2.mPtr;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmRuntimeSensorHandles, reason: not valid java name */
    static /* bridge */ /* synthetic */ Set m8136$$Nest$fgetmRuntimeSensorHandles(SensorService r0) {
        return r0.mRuntimeSensorHandles;
    }

    /* JADX INFO: renamed from: -$$Nest$smregisterProximityActiveListenerNative, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m8137$$Nest$smregisterProximityActiveListenerNative(long r0) {
        registerProximityActiveListenerNative(r0);
    }

    /* JADX INFO: renamed from: -$$Nest$smregisterRuntimeSensorNative, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m8138$$Nest$smregisterRuntimeSensorNative(long r0, int r2, int r3, String r4, String r5, float r6, float r7, float r8, int r9, int r10, int r11, SensorManagerInternal.RuntimeSensorCallback r12) {
        return registerRuntimeSensorNative(r0, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12);
    }

    /* JADX INFO: renamed from: -$$Nest$smsendRuntimeSensorAdditionalInfoNative, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m8139$$Nest$smsendRuntimeSensorAdditionalInfoNative(long r0, int r2, int r3, int r4, long r5, float[] r7) {
        return sendRuntimeSensorAdditionalInfoNative(r0, r2, r3, r4, r5, r7);
    }

    /* JADX INFO: renamed from: -$$Nest$smsendRuntimeSensorEventNative, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m8140$$Nest$smsendRuntimeSensorEventNative(long r0, int r2, int r3, long r4, float[] r6) {
        return sendRuntimeSensorEventNative(r0, r2, r3, r4, r6);
    }

    /* JADX INFO: renamed from: -$$Nest$smunregisterProximityActiveListenerNative, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m8141$$Nest$smunregisterProximityActiveListenerNative(long r0) {
        unregisterProximityActiveListenerNative(r0);
    }

    /* JADX INFO: renamed from: -$$Nest$smunregisterRuntimeSensorNative, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m8142$$Nest$smunregisterRuntimeSensorNative(long r0, int r2) {
        unregisterRuntimeSensorNative(r0, r2);
    }

    private static native void registerProximityActiveListenerNative(long r0);

    private static native int registerRuntimeSensorNative(long r0, int r2, int r3, String r4, String r5, float r6, float r7, float r8, int r9, int r10, int r11, SensorManagerInternal.RuntimeSensorCallback r12);

    private static native boolean sendRuntimeSensorAdditionalInfoNative(long r0, int r2, int r3, int r4, long r5, float[] r7);

    private static native boolean sendRuntimeSensorEventNative(long r0, int r2, int r3, long r4, float[] r6);

    private static native long startSensorServiceNative(SensorManagerInternal.ProximityActiveListener r0);

    private static native void unregisterProximityActiveListenerNative(long r0);

    private static native void unregisterRuntimeSensorNative(long r0, int r2);

    public SensorService(Context ctx) {
        super(ctx);
        this.mLock = new Object();
        this.mProximityListeners = new ArrayMap();
        this.mRuntimeSensorHandles = new HashSet();
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mSensorServiceStart = SystemServerInitThreadPool.submit(new SensorService$$ExternalSyntheticLambda0(this), START_NATIVE_SENSOR_SERVICE);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private /* synthetic */ void lambda$new$0() {
        TimingsTraceAndSlog traceLog = TimingsTraceAndSlog.newAsyncLog();
        traceLog.traceBegin(START_NATIVE_SENSOR_SERVICE);
        long ptr = startSensorServiceNative(new ProximityListenerDelegate(this, null));
        Object r3 = this.mLock;
        monitor-enter(r3);
        this.mPtr = ptr;     // Catch: Throwable -> L8
        monitor-exit(r3);     // Catch: Throwable -> L8
        traceLog.traceEnd();
        return;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.SystemService
    public void onStart() {
        LocalServices.addService(SensorManagerInternal.class, new LocalService(this));
    }

    @Override // com.android.server.SystemService
    public void onBootPhase(int phase) {
        if (phase != 200) goto L13;
        ConcurrentUtils.waitForFutureNoInterrupt(this.mSensorServiceStart, START_NATIVE_SENSOR_SERVICE);
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mSensorServiceStart = null;     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }
}
