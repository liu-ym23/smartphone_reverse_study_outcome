package com.stepos.ability.commoninternal;

import C4.c;
import android.app.Application;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.constraintlayout.core.dsl.a;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.keepalive.StepOSKeepAliveManager;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u000f\u0010\u0006\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0003J\r\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\u0003J\r\u0010\b\u001a\u00020\u0004¢\u0006\u0004\b\b\u0010\u0003R\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\r\u001a\u00020\f8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000f\u0010\u000eR\u0014\u0010\u0011\u001a\u00020\u00108\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0013\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u000eR\u0014\u0010\u0015\u001a\u00020\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0018\u001a\u00020\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019¨\u0006\u001a"}, d2 = {"Lcom/stepos/ability/commoninternal/KeepAliveHelper;", "", AppAgent.CONSTRUCT, "()V", "LC7/r;", "doSetKeepAlive", "doEndKeepAlive", "refreshKeepAlive", "endKeepAlive", "", "TAG", "Ljava/lang/String;", "", "KEEP_ALIVE_TIMEOUT_MS", "J", "JITTER_MS", "", "ENABLE_ALIVE", "I", "lastCallTime", "Landroid/os/Handler;", "handler", "Landroid/os/Handler;", "Ljava/lang/Runnable;", "setKeepAliveRunnable", "Ljava/lang/Runnable;", "commonInternal_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class KeepAliveHelper {
    private static final int ENABLE_ALIVE = 1;
    private static final long JITTER_MS = 10;
    private static final long KEEP_ALIVE_TIMEOUT_MS = 3600000;
    private static final String TAG = "KeepAliveHelper";
    private static volatile long lastCallTime;
    public static final KeepAliveHelper INSTANCE = new KeepAliveHelper();
    private static final Handler handler = new Handler(Looper.getMainLooper());
    private static final Runnable setKeepAliveRunnable = new c(3);

    private KeepAliveHelper() {
    }

    private final void doEndKeepAlive() {
        try {
            StepOSKeepAliveManager stepOSKeepAliveManager = StepOSKeepAliveManager.get();
            String processName = Application.getProcessName();
            stepOSKeepAliveManager.endProcessTempKeepAlive(processName, 1);
            Log.i(TAG, "endProcessTempKeepAlive OK: process=" + processName);
        } catch (Throwable th) {
            a.w("endKeepAlive failed: ", th.getMessage(), TAG);
        }
    }

    private final void doSetKeepAlive() {
        try {
            StepOSKeepAliveManager stepOSKeepAliveManager = StepOSKeepAliveManager.get();
            String processName = Application.getProcessName();
            if (!stepOSKeepAliveManager.setProcessTempKeepAlive(processName, 1, 3600000)) {
                Log.w(TAG, "setProcessTempKeepAlive returned false");
                return;
            }
            Log.i(TAG, "setProcessTempKeepAlive OK: process=" + processName + ", timeout=3600000ms");
        } catch (Throwable th) {
            lastCallTime = 0L;
            a.w("refreshKeepAlive failed: ", th.getMessage(), TAG);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void endKeepAlive$lambda$0() {
        INSTANCE.doEndKeepAlive();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setKeepAliveRunnable$lambda$0() {
        INSTANCE.doSetKeepAlive();
    }

    public final void endKeepAlive() {
        Log.i(TAG, "endKeepAlive");
        lastCallTime = 0L;
        Handler handler2 = handler;
        handler2.removeCallbacks(setKeepAliveRunnable);
        handler2.post(new c(2));
    }

    public final void refreshKeepAlive() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j5 = 3600010 - (jCurrentTimeMillis - lastCallTime);
        lastCallTime = jCurrentTimeMillis;
        Handler handler2 = handler;
        Runnable runnable = setKeepAliveRunnable;
        handler2.removeCallbacks(runnable);
        if (j5 <= 0) {
            Log.i(TAG, "refreshKeepAlive: immediate");
            handler2.post(runnable);
            return;
        }
        Log.d(TAG, "refreshKeepAlive: postDelayed " + j5 + "ms");
        handler2.postDelayed(runnable, j5);
    }
}
