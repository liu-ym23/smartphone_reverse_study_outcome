package com.stepos.core.common.memory;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.SystemClock;
import android.util.Log;
import com.stepos.aicgroup.e;
import com.stepos.cpuset.c;
import kotlin.Result;
import kotlin.b;
import lb.d;
import zb.a;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class NativeMemoryBridge {
    private static final long DEBOUNCE_MS = 2000;
    private static final long DEFER_MS = 3000;
    private static final int MAX_DEFER = 5;
    private static final String TAG = "NativeMemoryBridge";
    private static volatile int deferCount;
    private static volatile a<Boolean> idleGate;
    private static volatile long lastPurgeCostMs;
    private static volatile boolean nativeUnavailable;
    private static volatile long purgeCount;
    public static final NativeMemoryBridge INSTANCE = new NativeMemoryBridge();
    private static volatile boolean enabled = true;
    private static final d purgeHandler$delegate = b.b(new c(20));
    private static final Runnable purgeTask = new e(3);

    static {
        try {
            System.loadLibrary("aiengine_crash");
        } catch (UnsatisfiedLinkError e10) {
            nativeUnavailable = true;
            a0.a.A("Failed to load native library: ", e10.getMessage(), TAG);
        }
    }

    private NativeMemoryBridge() {
    }

    public static final boolean getEnabled() {
        return enabled;
    }

    public static final a<Boolean> getIdleGate() {
        return idleGate;
    }

    public static final long getLastPurgeCostMs() {
        return lastPurgeCostMs;
    }

    public static final long getPurgeCount() {
        return purgeCount;
    }

    private final Handler getPurgeHandler() {
        return (Handler) purgeHandler$delegate.getValue();
    }

    private static final native boolean nativePurgeFreePages();

    /* JADX INFO: Access modifiers changed from: private */
    public static final Handler purgeHandler_delegate$lambda$1() {
        HandlerThread handlerThread = new HandlerThread("aiengine-mem-purge");
        handlerThread.start();
        return new Handler(handlerThread.getLooper());
    }

    private final boolean purgeNow() {
        if (enabled && !nativeUnavailable) {
            long jElapsedRealtimeNanos = SystemClock.elapsedRealtimeNanos();
            try {
                boolean zNativePurgeFreePages = nativePurgeFreePages();
                lastPurgeCostMs = (SystemClock.elapsedRealtimeNanos() - jElapsedRealtimeNanos) / 1000000;
                purgeCount++;
                Log.i(TAG, "purge done: accepted=" + zNativePurgeFreePages + " costMs=" + lastPurgeCostMs + " count=" + purgeCount);
                return zNativePurgeFreePages;
            } catch (UnsatisfiedLinkError unused) {
                nativeUnavailable = true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void purgeTask$lambda$2() {
        INSTANCE.purgeWhenIdle();
    }

    private final void purgeWhenIdle() {
        Object objA;
        a<Boolean> aVar = idleGate;
        if (aVar != null) {
            try {
                objA = (Boolean) aVar.invoke();
                objA.getClass();
            } catch (Throwable th) {
                objA = kotlin.c.a(th);
            }
            Object obj = Boolean.TRUE;
            if (objA instanceof Result.Failure) {
                objA = obj;
            }
            if (!((Boolean) objA).booleanValue()) {
                if (deferCount < 5) {
                    deferCount++;
                    Log.d(TAG, "purge deferred (" + deferCount + "/5): inference in flight");
                    getPurgeHandler().postDelayed(purgeTask, 3000L);
                    return;
                }
                Log.i(TAG, "purge forced after 5 defers");
            }
        }
        deferCount = 0;
        purgeNow();
    }

    public static final void requestPurge() {
        if (!enabled || nativeUnavailable) {
            return;
        }
        NativeMemoryBridge nativeMemoryBridge = INSTANCE;
        Handler purgeHandler = nativeMemoryBridge.getPurgeHandler();
        Runnable runnable = purgeTask;
        purgeHandler.removeCallbacks(runnable);
        deferCount = 0;
        nativeMemoryBridge.getPurgeHandler().postDelayed(runnable, 2000L);
    }

    public static final void setEnabled(boolean z) {
        enabled = z;
    }

    public static final void setIdleGate(a<Boolean> aVar) {
        idleGate = aVar;
    }

    public static /* synthetic */ void getEnabled$annotations() {
    }

    public static /* synthetic */ void getIdleGate$annotations() {
    }

    public static /* synthetic */ void getLastPurgeCostMs$annotations() {
    }

    public static /* synthetic */ void getPurgeCount$annotations() {
    }
}
