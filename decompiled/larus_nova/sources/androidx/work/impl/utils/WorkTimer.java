package androidx.work.impl.utils;

import androidx.work.Logger;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes28.dex */
public class WorkTimer {
    private static final String TAG = null;
    private final ThreadFactory mBackgroundThreadFactory;
    private final ScheduledExecutorService mExecutorService;
    final Map<String, TimeLimitExceededListener> mListeners;
    final Object mLock;
    final Map<String, WorkTimerRunnable> mTimerMap;

    public interface TimeLimitExceededListener {
        void onTimeLimitExceeded(String r100);
    }

    public static class WorkTimerRunnable implements Runnable {
        static final String TAG = "WrkTimerRunnable";
        private final String mWorkSpecId;
        private final WorkTimer mWorkTimer;

        @Override // java.lang.Runnable
        public void run() {
            androidx_work_impl_utils_WorkTimer$WorkTimerRunnable_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        public void androidx_work_impl_utils_WorkTimer$WorkTimerRunnable__run$___twin___() {
            Object r100 = this.mWorkTimer.mLock;
            monitor-enter(r100);
        L12:
            th = move-exception;
            throw th;
        L5:
            if (this.mWorkTimer.mTimerMap.remove(this.mWorkSpecId) == null) goto L9;
            TimeLimitExceededListener r101 = this.mWorkTimer.mListeners.remove(this.mWorkSpecId);     // Catch: Throwable -> L12
            if (r101 == null) goto L10;
            r101.onTimeLimitExceeded(this.mWorkSpecId);     // Catch: Throwable -> L12
        L10:
            monitor-exit(r100);     // Catch: Throwable -> L12
            return;
        L9:
            Logger.get().debug(TAG, String.format("Timer with %s is already marked as complete.", new Object[]{this.mWorkSpecId}), new Throwable[0]);     // Catch: Throwable -> L12
            goto L10
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void androidx_work_impl_utils_WorkTimer$WorkTimerRunnable_com_larus_apm_impl_protector_RunnableLancet_run(WorkTimerRunnable r100) {
            r100.androidx_work_impl_utils_WorkTimer$WorkTimerRunnable__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public WorkTimerRunnable(WorkTimer r100, String r101) {
            this.mWorkTimer = r100;
            this.mWorkSpecId = r101;
        }
    }

    public synchronized Map<String, TimeLimitExceededListener> getListeners() {
        monitor-enter(this);
        Map<String, TimeLimitExceededListener> r100 = this.mListeners;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized Map<String, WorkTimerRunnable> getTimerMap() {
        monitor-enter(this);
        Map<String, WorkTimerRunnable> r100 = this.mTimerMap;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    static {
        TAG = Logger.tagWithPrefix("WorkTimer");
    }

    public void onDestroy() {
        if (this.mExecutorService.isShutdown() == true) goto L6;
        this.mExecutorService.shutdownNow();
        return;
    }

    public WorkTimer() {
        ThreadFactory r100 = new AnonymousClass1(this);
        this.mBackgroundThreadFactory = r100;
        this.mTimerMap = new HashMap();
        this.mListeners = new HashMap();
        this.mLock = new Object();
        this.mExecutorService = PThreadExecutorsUtils.newSingleThreadScheduledExecutor(r100);
    }

    public ScheduledExecutorService getExecutorService() {
        return this.mExecutorService;
    }

    public void stopTimer(String r100) {
        Object r101 = this.mLock;
        monitor-enter(r101);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mTimerMap.remove(r100) == null) goto L7;
        Logger.get().debug(TAG, String.format("Stopping timer for %s", new Object[]{r100}), new Throwable[0]);     // Catch: Throwable -> L9
        this.mListeners.remove(r100);     // Catch: Throwable -> L9
    L7:
        monitor-exit(r101);     // Catch: Throwable -> L9
    }

    public void startTimer(String r100, long r101, TimeLimitExceededListener r110) {
        Object r102 = this.mLock;
        monitor-enter(r102);
        Logger.get().debug(TAG, String.format("Starting timer for %s", new Object[]{r100}), new Throwable[0]);     // Catch: Throwable -> L7
        stopTimer(r100);     // Catch: Throwable -> L7
        WorkTimerRunnable r103 = new WorkTimerRunnable(this, r100);     // Catch: Throwable -> L7
        this.mTimerMap.put(r100, r103);     // Catch: Throwable -> L7
        this.mListeners.put(r100, r110);     // Catch: Throwable -> L7
        this.mExecutorService.schedule(r103, r101, TimeUnit.MILLISECONDS);     // Catch: Throwable -> L7
        monitor-exit(r102);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
