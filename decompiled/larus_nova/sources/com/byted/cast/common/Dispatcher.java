package com.byted.cast.common;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.text.TextUtils;
import com.byted.cast.common.threadpool.CastScheduledThreadPoolExecutor;
import com.byted.cast.common.threadpool.CastThreadFactory;
import com.byted.cast.common.threadpool.CastThreadPoolExecutor;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes39.dex */
public class Dispatcher {
    private static final String BYTE_CAST_THREAD_NAME = "ByteCast";
    private static int CORE_POOL_SIZE = 16;
    private static int MAX_POOL_SIZE = 64;
    public static final String SCHEDULE_BDLE_DLNA_SOCKET_CHECK = "bdle_dlna_socket_check";
    public static final String SCHEDULE_BDLINK_BROWSE_TASK = "bdlink_browse";
    public static final String SCHEDULE_DLNA_BROWSE_TASK = "dlna_browse";
    public static final String SCHEDULE_DLNA_TRACK_TASK = "dlna_state_track";
    public static final String SCHEDULE_NET_STATISTIC_TASK = "net_statistic";
    public static final String SCHEDULE_SINK_PLAY_TIME_TASK = "sink_play_time";
    private static final String TAG = "Dispatcher";
    private static volatile Dispatcher sInstance;
    private final Handler byteCastHandler;
    private final HandlerThread byteCastHandlerThread;
    private CastThreadPoolExecutor executorService;
    private final MainThreadExecutor mainThreadExecutor;
    private CastScheduledThreadPoolExecutor scheduledExecutorService;
    private Map<String, ScheduledFuture> scheduledExecutorServiceMap;

    private Dispatcher() {
        this(CORE_POOL_SIZE, MAX_POOL_SIZE);
    }

    public static Dispatcher getInstance() {
        if (sInstance != null) goto L15;
        monitor-enter(Dispatcher.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new Dispatcher();     // Catch: Throwable -> L11
    L9:
        monitor-exit(Dispatcher.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    public Looper getByteCastThreadLooper() {
        return this.byteCastHandlerThread.getLooper();
    }

    public boolean isMainThread() {
        if (Looper.myLooper() != Looper.getMainLooper()) goto L5;
        return true;
    L5:
        return false;
    }

    public Handler getByteCastHandler() {
        return this.byteCastHandler;
    }

    public Executor getExecutor() {
        return this.executorService;
    }

    public static void enableCompatibleConfig(String r100) {
        if (TextUtils.equals(r100, Constants.ROLE_SINK) == false) goto L5;
        CORE_POOL_SIZE = 8;
        MAX_POOL_SIZE = 32;
        return;
    L5:
        CORE_POOL_SIZE = 16;
        MAX_POOL_SIZE = 64;
    }

    public void enqueue(Runnable r100) {
        this.executorService.execute(r100);
    }

    public void remove(Runnable r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        this.executorService.remove(r100);
    }

    public void runOnByteCastThread(Runnable r100) {
        this.byteCastHandler.post(r100);
    }

    public void runOnMainThread(Runnable r100) {
        if (isMainThread() == false) goto L5;
        r100.run();
        return;
    L5:
        this.mainThreadExecutor.execute(r100);
    }

    public void shutdownScheduleService(String r100) {
        Logger.i(TAG, "shutdownScheduleService, key:" + r100);
        ScheduledFuture r101 = this.scheduledExecutorServiceMap.get(r100);
        if (r101 == null) goto L6;
        r101.cancel(true);
        this.scheduledExecutorServiceMap.remove(r100);
        return;
    }

    public boolean taskIsAlive(String r100) {
        return this.scheduledExecutorServiceMap.containsKey(r100);
    }

    private Dispatcher(int r110, int r111) {
        this.mainThreadExecutor = new MainThreadExecutor();
        Logger.d(TAG, "Dispatcher, corePoolSize:" + r110 + ", maxPoolSize:" + r111);
        this.executorService = new CastThreadPoolExecutor(r110, r111, 60, TimeUnit.SECONDS, new ArrayBlockingQueue(128), new CastThreadFactory(TAG), new ThreadPoolExecutor.DiscardOldestPolicy());
        this.scheduledExecutorService = new CastScheduledThreadPoolExecutor(8, new CastThreadFactory(TAG));
        this.scheduledExecutorServiceMap = new ConcurrentHashMap();
        PthreadHandlerThreadV2 r112 = new PthreadHandlerThreadV2("ByteCast");
        this.byteCastHandlerThread = r112;
        ThreadMethodProxy.start(r112);
        this.byteCastHandler = new Handler(r112.getLooper());
    }

    public void delaySchedule(Runnable r100, int r101) {
        this.scheduledExecutorService.schedule(r100, r101, TimeUnit.SECONDS);
    }

    public void delaySchedule(String r100, Runnable r101, int r102) {
        if (this.scheduledExecutorServiceMap.containsKey(r100) == false) goto L5;
        return;
    L5:
        this.scheduledExecutorServiceMap.put(r100, this.scheduledExecutorService.schedule(r101, r102, TimeUnit.SECONDS));
    }

    public void printThreadPool(ContextManager.CastContext r100, String r101, String r102) {
        String r103 = r102 + ", dispatcher info: queueSize: " + this.executorService.getQueue().size() + ", activeCount: " + this.executorService.getActiveCount() + ", largestSize: " + this.executorService.getLargestPoolSize() + ", taskCount: " + this.executorService.getTaskCount();
        ContextManager.getLogger(r100).d(TAG, r103);
        ContextManager.getMonitor(r100).sendCustomEvent(r101, CastMonitor.DISPATCHER_COUNT, r103);
    }

    public void schedule(String r100, Runnable r110, int r111) {
        Logger.i(TAG, "schedule, taskName:" + r100);
        if (this.scheduledExecutorServiceMap.containsKey(r100) == false) goto L5;
        return;
    L5:
        this.scheduledExecutorServiceMap.put(r100, this.scheduledExecutorService.scheduleAtFixedRate(r110, 3, r111, TimeUnit.SECONDS));
    }

    public void schedule(String r100, Runnable r110, int r111, int r112) {
        Logger.i(TAG, "schedule, taskName:" + r100 + ", initDelayTime:" + r112);
        if (this.scheduledExecutorServiceMap.containsKey(r100) == false) goto L5;
        return;
    L5:
        this.scheduledExecutorServiceMap.put(r100, this.scheduledExecutorService.scheduleAtFixedRate(r110, r112, r111, TimeUnit.SECONDS));
    }
}
