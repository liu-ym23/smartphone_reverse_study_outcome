package com.bytedance.apm.launch;

import android.util.Log;
import com.bytedance.apm.ApmContext;
import com.bytedance.apm.trace.LaunchTrace;

/* JADX INFO: loaded from: classes2.dex */
public class LaunchAnalysisContext {
    private static final String TAG = "LaunchAnalysis";
    private LaunchInitConfig config;
    private LaunchTrace.LaunchMonitor monitor;

    /* JADX INFO: renamed from: com.bytedance.apm.launch.LaunchAnalysisContext$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static final class SingletonHolder {
        private static final LaunchAnalysisContext instance = null;

        private SingletonHolder() {
        }

        static /* synthetic */ LaunchAnalysisContext access$100() {
            return instance;
        }

        static {
            instance = new LaunchAnalysisContext(null);
        }
    }

    /* synthetic */ LaunchAnalysisContext(AnonymousClass1 r1) {
        this();
    }

    private LaunchAnalysisContext() {
    }

    public static LaunchAnalysisContext getInstance() {
        return SingletonHolder.access$100();
    }

    public synchronized void setConfig(LaunchInitConfig r1) {
        monitor-enter(this);
        this.config = r1;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized LaunchInitConfig getConfig() {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (this.config != null) goto L6;
        this.config = new LaunchInitConfig.Builder().build();     // Catch: Throwable -> L9
    L6:
        LaunchInitConfig r0 = this.config;     // Catch: Throwable -> L9
        monitor-exit(this);
        return r0;
    }

    public synchronized void setMonitorConfig(LaunchTrace.LaunchMonitor r1) {
        monitor-enter(this);
        this.monitor = r1;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized LaunchTrace.LaunchMonitor getMonitorConfig() {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (this.monitor != null) goto L6;
        this.monitor = new LaunchTrace.LaunchMonitor.LaunchMonitorBuilder().build();     // Catch: Throwable -> L9
    L6:
        LaunchTrace.LaunchMonitor r0 = this.monitor;     // Catch: Throwable -> L9
        monitor-exit(this);
        return r0;
    }

    public void logE(String r2) {
        Log.e(TAG, "notice!!!+ " + r2);
    }

    public void logI(String r1) {
        Log.i(TAG, r1);
    }

    public void logD(String r1) {
        if (ApmContext.isDebugMode() == false) goto L6;
        Log.d(TAG, r1);
        return;
    }
}
