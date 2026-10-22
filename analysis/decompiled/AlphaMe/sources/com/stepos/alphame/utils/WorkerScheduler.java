package com.stepos.alphame.utils;

import android.os.HandlerThread;
import android.os.Looper;
import android.os.Process;
import androidx.annotation.NonNull;
import androidx.room.AbstractC0351g;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import t3.f;
import v3.d;

/* loaded from: classes.dex */
public class WorkerScheduler {
    private static final String TAG = "WorkerScheduler";
    private static final AtomicInteger sIndex = new AtomicInteger(0);
    private static final f[] SCHEDULER_LIST = new f[13];
    public static final f SINGLE = newSingleScheduler("ass_single", 5);
    public static final f SINGLE_QUICK = newSingleScheduler("ass_single_quick", 9);
    public static final f APP_START = newSingleScheduler("ass_app_start", 5);
    public static final f CARDS_MAIN = newSingleScheduler("ass_cards", 8);
    public static final f HOME_CONTROL = newSingleScheduler("home_control", 5);
    public static final f ANDROID_MAIN = androidMainScheduler();
    public static final f IO = newIoScheduler("ass_io", 5);
    public static final f NEW_THREAD = newNewThreadScheduler("ass_new", 5);
    public static final f SETTING_SYNC = newSingleScheduler("setting_key_sync", 1);
    public static final f SMART_REMIND = newSingleScheduler("smart_remind", 5);

    public interface IWorkerThread {
        int getIndex();
    }

    public static class SingletonLooper {

        public static class SingletonLooperContainer {
            private static f sLooperScheduler = WorkerScheduler.a();

            private SingletonLooperContainer() {
            }
        }

        public static f looper() {
            return SingletonLooperContainer.sLooperScheduler;
        }
    }

    public static class WorkerHandlerThread extends HandlerThread implements IWorkerThread {
        private final int index;

        public WorkerHandlerThread(String str, int i4) {
            super(str);
            this.index = i4;
        }

        @Override // com.stepos.alphame.utils.WorkerScheduler.IWorkerThread
        public int getIndex() {
            return this.index;
        }
    }

    public static class WorkerThread extends Thread implements IWorkerThread {
        private final int index;
        private final int priority;
        private boolean set;

        public WorkerThread(ThreadGroup threadGroup, Runnable runnable, String str, long j4, int i4, int i5) {
            super(threadGroup, runnable, str, j4);
            this.index = i4;
            this.priority = i5;
        }

        @Override // com.stepos.alphame.utils.WorkerScheduler.IWorkerThread
        public int getIndex() {
            return this.index;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() throws SecurityException, IllegalArgumentException {
            try {
                if (!this.set) {
                    this.set = true;
                    int i4 = this.priority;
                    if (i4 != 5) {
                        Process.setThreadPriority(20 - (i4 * 4));
                    }
                }
                super.run();
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        }
    }

    public static class WorkerThreadFactory implements ThreadFactory {
        private final ThreadGroup group;
        private final int index;
        private final String namePrefix;
        private final int priority;
        private final AtomicInteger threadNumber = new AtomicInteger(1);

        public WorkerThreadFactory(String str, int i4, int i5) {
            SecurityManager securityManager = System.getSecurityManager();
            this.group = securityManager != null ? securityManager.getThreadGroup() : Thread.currentThread().getThreadGroup();
            this.namePrefix = AbstractC0351g.p(str, "-");
            this.index = i4;
            this.priority = i5;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(@NonNull Runnable runnable) {
            WorkerThread workerThread = new WorkerThread(this.group, runnable, this.namePrefix + this.threadNumber.getAndIncrement(), 0L, this.index, this.priority);
            int i4 = this.priority;
            if (i4 != 5) {
                workerThread.setPriority(i4);
            }
            workerThread.setDaemon(true);
            return workerThread;
        }
    }

    public static /* bridge */ /* synthetic */ f a() {
        return newLooperScheduler("ass_looper");
    }

    private static f androidMainScheduler() {
        int iIncrementAndGet = sIndex.incrementAndGet();
        Looper mainLooper = Looper.getMainLooper();
        int i4 = v3.a.f15723a;
        if (mainLooper == null) {
            throw new NullPointerException("looper == null");
        }
        d dVar = new d(mainLooper);
        SCHEDULER_LIST[iIncrementAndGet] = dVar;
        return dVar;
    }

    public static f getThreadScheduler() {
        int index;
        Object objCurrentThread = Thread.currentThread();
        if (Looper.myLooper() == Looper.getMainLooper()) {
            return ANDROID_MAIN;
        }
        if (!(objCurrentThread instanceof IWorkerThread) || (index = ((IWorkerThread) objCurrentThread).getIndex()) < 0) {
            return null;
        }
        f[] fVarArr = SCHEDULER_LIST;
        if (index < fVarArr.length) {
            return fVarArr[index];
        }
        return null;
    }

    public static boolean isThreadOn(f fVar) {
        return fVar != null && fVar == getThreadScheduler();
    }

    private static f newIoScheduler(String str, int i4) {
        int iIncrementAndGet = sIndex.incrementAndGet();
        A3.d dVar = new A3.d(new WorkerThreadFactory(str, iIncrementAndGet, i4));
        SCHEDULER_LIST[iIncrementAndGet] = dVar;
        return dVar;
    }

    private static f newLooperScheduler(String str) {
        int iIncrementAndGet = sIndex.incrementAndGet();
        WorkerHandlerThread workerHandlerThread = new WorkerHandlerThread(str, iIncrementAndGet);
        workerHandlerThread.start();
        Looper looper = workerHandlerThread.getLooper();
        int i4 = v3.a.f15723a;
        if (looper == null) {
            throw new NullPointerException("looper == null");
        }
        d dVar = new d(looper);
        SCHEDULER_LIST[iIncrementAndGet] = dVar;
        return dVar;
    }

    private static f newNewThreadScheduler(String str, int i4) {
        int iIncrementAndGet = sIndex.incrementAndGet();
        d dVar = new d(2, new WorkerThreadFactory(str, iIncrementAndGet, i4));
        SCHEDULER_LIST[iIncrementAndGet] = dVar;
        return dVar;
    }

    private static f newSingleScheduler(String str, int i4) {
        int iIncrementAndGet = sIndex.incrementAndGet();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), new WorkerThreadFactory(str, iIncrementAndGet, i4), new ThreadPoolExecutor.DiscardPolicy());
        AtomicReference atomicReference = F3.a.f455d;
        d dVar = new d(1, threadPoolExecutor);
        SCHEDULER_LIST[iIncrementAndGet] = dVar;
        return dVar;
    }
}
