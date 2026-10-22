package io.reactivex.internal.schedulers;

import androidx.lifecycle.LifecycleKt$$ExternalSyntheticBackportWithForwarding0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes4.dex */
public final class SchedulerPoolFactory {
    static final Map<ScheduledThreadPoolExecutor, Object> POOLS = null;
    public static final boolean PURGE_ENABLED = false;
    static final String PURGE_ENABLED_KEY = "rx2.purge-enabled";
    public static final int PURGE_PERIOD_SECONDS = 0;
    static final String PURGE_PERIOD_SECONDS_KEY = "rx2.purge-period-seconds";
    static final AtomicReference<ScheduledExecutorService> PURGE_THREAD = null;

    static final class PurgeProperties {
        boolean purgeEnable;
        int purgePeriod;

        PurgeProperties() {
        }

        void load(Properties r4) {
            if (r4.containsKey(SchedulerPoolFactory.PURGE_ENABLED_KEY) == false) goto L5;
            this.purgeEnable = Boolean.parseBoolean(r4.getProperty(SchedulerPoolFactory.PURGE_ENABLED_KEY));
        L7:
            if (this.purgeEnable == true) goto L9;
        L13:
            this.purgePeriod = 1;
            return;
        L9:
            if (r4.containsKey(SchedulerPoolFactory.PURGE_PERIOD_SECONDS_KEY) == false) goto L13;
            this.purgePeriod = Integer.parseInt(r4.getProperty(SchedulerPoolFactory.PURGE_PERIOD_SECONDS_KEY));     // Catch: NumberFormatException -> L12
            return;
        L12:
            this.purgePeriod = 1;
            return;
        L5:
            this.purgeEnable = true;
            goto L7
        }
    }

    static final class ScheduledTask implements Runnable {
        ScheduledTask() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator r2 = new ArrayList(SchedulerPoolFactory.POOLS.keySet()).iterator();
        L4:
            if (r2.hasNext() == false) goto L9;
            ScheduledThreadPoolExecutor r0 = (ScheduledThreadPoolExecutor) r2.next();
            if (r0.isShutdown() == true) goto L7;
            r0.purge();
            goto L4
        L7:
            SchedulerPoolFactory.POOLS.remove(r0);
            goto L4
        }
    }

    private SchedulerPoolFactory() {
        throw new IllegalStateException("No instances!");
    }

    static {
        PURGE_THREAD = new AtomicReference();
        POOLS = new ConcurrentHashMap();
        Properties r0 = System.getProperties();
        PurgeProperties r1 = new PurgeProperties();
        r1.load(r0);
        PURGE_ENABLED = r1.purgeEnable;
        PURGE_PERIOD_SECONDS = r1.purgePeriod;
        start();
    }

    public static void start() {
        tryStart(PURGE_ENABLED);
    }

    static void tryStart(boolean r10) {
        if (r10 == false) goto L11;
    L3:
        AtomicReference<ScheduledExecutorService> r11 = PURGE_THREAD;
        ScheduledExecutorService r0 = r11.get();
        if (r0 != null) goto L5;
        ScheduledExecutorService r3 = Executors.newScheduledThreadPool(1, new RxThreadFactory("RxSchedulerPurge"));
        if (LifecycleKt$$ExternalSyntheticBackportWithForwarding0.m(r11, r0, r3) == true) goto L8;
        r3.shutdownNow();
        goto L3
    L8:
        ScheduledTask r4 = new ScheduledTask();
        int r12 = PURGE_PERIOD_SECONDS;
        r3.scheduleAtFixedRate(r4, r12, r12, TimeUnit.SECONDS);
        return;
    L5:
        return;
    }

    public static void shutdown() {
        ScheduledExecutorService r0 = PURGE_THREAD.getAndSet(null);
        if (r0 == null) goto L5;
        r0.shutdownNow();
    L5:
        POOLS.clear();
    }

    public static ScheduledExecutorService create(ThreadFactory r1) {
        ScheduledExecutorService r2 = Executors.newScheduledThreadPool(1, r1);
        tryPutIntoPool(PURGE_ENABLED, r2);
        return r2;
    }

    static void tryPutIntoPool(boolean r1, ScheduledExecutorService r2) {
        if (r1 == true) goto L4;
        return;
    L4:
        if ((r2 instanceof ScheduledThreadPoolExecutor) == false) goto L8;
        Map<ScheduledThreadPoolExecutor, Object> r0 = POOLS;
        r0.put((ScheduledThreadPoolExecutor) r2, r2);
        return;
    }
}
