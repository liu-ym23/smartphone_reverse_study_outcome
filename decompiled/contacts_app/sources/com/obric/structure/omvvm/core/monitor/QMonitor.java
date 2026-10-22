package com.obric.structure.omvvm.core.monitor;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.obric.structure.omvvm.core.Q;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes4.dex */
class QMonitor {
    private static final QMonitor INSTANCE = null;
    private long delay;
    ErrorRunnable errorRunnable;
    private boolean isInit;
    private final Map<Long, QMonitorEntity> issues;
    private Handler mIoHandler;
    private final LogRunnable mLogRunnable;
    private final HandlerThread mLogThread;

    /* JADX INFO: renamed from: com.obric.structure.omvvm.core.monitor.QMonitor$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static class ErrorRunnable implements Runnable {
        long errorKey;

        private ErrorRunnable() {
            this.errorKey = 0;
        }

        /* synthetic */ ErrorRunnable(AnonymousClass1 r1) {
            this();
        }

        @Override // java.lang.Runnable
        public void run() {
            Object r0 = QLooperMonitor.INSTANCE.lock();
            monitor-enter(r0);
            Looper r1 = QLooperMonitor.INSTANCE.myLooper();     // Catch: Throwable -> L11
            if (r1 == null) goto L9;
            QMonitorEntity r5 = (QMonitorEntity) QMonitor.access$100(QMonitor.getInstance()).get(Long.valueOf(this.errorKey));     // Catch: Throwable -> L11
            if (r5 == null) goto L9;
            r5.setEnd(System.currentTimeMillis());     // Catch: Throwable -> L11
            r5.setError(true);     // Catch: Throwable -> L11
            r5.setStack(r1.getThread().getStackTrace());     // Catch: Throwable -> L11
            Q.INSTANCE.getMonitorCig().monitorReporter(r5);     // Catch: Throwable -> L11
        L9:
            monitor-exit(r0);     // Catch: Throwable -> L11
            return;
        L11:
            th = move-exception;
            throw th;
        }
    }

    private static class LogRunnable implements Runnable {
        private long key;

        private LogRunnable() {
            this.key = 0;
        }

        /* synthetic */ LogRunnable(AnonymousClass1 r1) {
            this();
        }

        static /* synthetic */ long access$202(LogRunnable r0, long r1) {
            r0.key = r1;
            return r1;
        }

        @Override // java.lang.Runnable
        public void run() {
            Object r0 = QLooperMonitor.INSTANCE.lock();
            monitor-enter(r0);
            Looper r1 = QLooperMonitor.INSTANCE.myLooper();     // Catch: Throwable -> L11
            if (r1 == null) goto L9;
            QMonitorEntity r5 = (QMonitorEntity) QMonitor.access$100(QMonitor.getInstance()).get(Long.valueOf(this.key));     // Catch: Throwable -> L11
            if (r5 == null) goto L9;
            r5.setStack(r1.getThread().getStackTrace());     // Catch: Throwable -> L11
        L9:
            monitor-exit(r0);     // Catch: Throwable -> L11
            return;
        L11:
            th = move-exception;
            throw th;
        }
    }

    static /* synthetic */ Map access$100(QMonitor r0) {
        return r0.issues;
    }

    static {
        INSTANCE = new QMonitor();
    }

    private QMonitor() {
        this.mLogThread = new HandlerThread(QLooperMonitor.getTAG());
        this.delay = 4000;
        this.isInit = false;
        AnonymousClass1 r1 = null;
        this.mLogRunnable = new LogRunnable(r1);
        this.issues = new ConcurrentHashMap();
        this.errorRunnable = new ErrorRunnable(r1);
        this.delay = (long) (((double) QLooperMonitor.INSTANCE.getInterval()) * 0.8d);
    }

    void start(long r4) {
        if (this.isInit == true) goto L5;
        this.isInit = true;
        this.mLogThread.start();
        this.mIoHandler = new Handler(this.mLogThread.getLooper());
    L5:
        LogRunnable.access$202(this.mLogRunnable, r4);
        QMonitorEntity r0 = new QMonitorEntity(r4);
        r0.setStart(System.currentTimeMillis());
        this.issues.put(Long.valueOf(r4), r0);
        this.mIoHandler.postDelayed(this.mLogRunnable, this.delay);
    }

    void stop(long r6) {
        final QMonitorEntity r0 = this.issues.get(Long.valueOf(r6));
        if (r0 == null) goto L9;
        r0.setEnd(System.currentTimeMillis());
        if ((r0.getEnd() - r0.getStart()) <= Q.INSTANCE.getMonitorCig().monitorInterval()) goto L9;
        if (r0.getStack() == null) goto L9;
        this.mIoHandler.post(new QMonitor$$ExternalSyntheticLambda0(r0));
    L9:
        this.mIoHandler.removeCallbacks(this.mLogRunnable);
        this.issues.remove(Long.valueOf(r6));
    }

    static /* synthetic */ void lambda$stop$0(QMonitorEntity r1) {
        Q.INSTANCE.getMonitorCig().monitorReporter(r1);
    }

    public static QMonitor getInstance() {
        return INSTANCE;
    }

    public void addMonitorPoint(long r5) {
        this.errorRunnable.errorKey = r5;
        Handler r6 = this.mIoHandler;
        if (r6 == null) goto L6;
        r6.postDelayed(this.errorRunnable, (long) (((double) Q.INSTANCE.getMonitorCig().errorInterval()) * 0.8d));
        return;
    }

    public void removeMonitorPoint() {
        this.mIoHandler.removeCallbacks(this.errorRunnable);
    }
}
