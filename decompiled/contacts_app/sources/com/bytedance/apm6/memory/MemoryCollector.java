package com.bytedance.apm6.memory;

import android.app.Activity;
import com.bytedance.apm.listener.IMemoryReachTopListener;
import com.bytedance.apm.logging.ApmAlogHelper;
import com.bytedance.apm6.foundation.context.ApmContext;
import com.bytedance.apm6.memory.bean.MemoryCollectInfo;
import com.bytedance.apm6.memory.config.MemoryConfig;
import com.bytedance.apm6.memory.config.MemoryConfigService;
import com.bytedance.apm6.memory.listener.IMemoryDataListener;
import com.bytedance.apm6.memory.monitorable.MemoryPerfDataEvent;
import com.bytedance.apm6.monitor.Monitor;
import com.bytedance.apm6.monitor.Monitorable;
import com.bytedance.apm6.service.ServiceManager;
import com.bytedance.apm6.service.lifecycle.ActivityLifecycleService;
import com.bytedance.apm6.service.lifecycle.DummyLifecycleListener;
import com.bytedance.apm6.util.log.Logger;
import com.bytedance.apm6.util.timetask.AsyncTask;
import com.bytedance.apm6.util.timetask.AsyncTaskManager;
import com.bytedance.apm6.util.timetask.AsyncTaskManagerType;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class MemoryCollector {
    private static final long MIN_COLLECT_TIME = 30000;
    private static final String TAG = "MemoryCollector";
    private MemoryConfig config;
    private volatile boolean inited;
    private volatile boolean isPaused;
    private volatile boolean isStart;
    private MemoryLifecycleListener lifecycleListener;
    private volatile IMemoryReachTopListener listener;
    private List<IMemoryDataListener> mList;
    private AsyncTask memoryCollector;
    private Map<Object, Object> mmapInfo;
    private long pollingIntervalMillis;

    private static class InnerHolder {
        private static final MemoryCollector instance = null;

        private InnerHolder() {
        }

        static /* synthetic */ MemoryCollector access$100() {
            return instance;
        }

        static {
            instance = new MemoryCollector(null);
        }
    }

    private class MemoryLifecycleListener extends DummyLifecycleListener {
        final /* synthetic */ MemoryCollector this$0;

        private MemoryLifecycleListener(MemoryCollector r1) {
            this.this$0 = r1;
        }

        /* synthetic */ MemoryLifecycleListener(MemoryCollector r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // com.bytedance.apm6.service.lifecycle.DummyLifecycleListener, com.bytedance.apm6.service.lifecycle.IActivityLifecycleObserver
        public final void onFront(Activity r2) {
            if (ApmContext.isDebugMode() == false) goto L6;
            Logger.d("APM-Memory", "isStopWhenBackground:" + MemoryCollector.access$400(this.this$0));
        L6:
            if (MemoryCollector.access$400(this.this$0) == false) goto L9;
            MemoryCollector.access$500(this.this$0);
            return;
        }

        @Override // com.bytedance.apm6.service.lifecycle.DummyLifecycleListener, com.bytedance.apm6.service.lifecycle.IActivityLifecycleObserver
        public final void onBackground(Activity r2) {
            if (ApmContext.isDebugMode() == false) goto L6;
            Logger.d("APM-Memory", "isStopWhenBackground:" + MemoryCollector.access$400(this.this$0));
        L6:
            if (MemoryCollector.access$400(this.this$0) == false) goto L9;
            MemoryCollector.access$600(this.this$0);
            return;
        }
    }

    static {
    }

    /* synthetic */ MemoryCollector(AnonymousClass1 r1) {
        this();
    }

    static /* synthetic */ boolean access$200(MemoryCollector r0) {
        return r0.isPaused;
    }

    static /* synthetic */ void access$300(MemoryCollector r0) {
        r0.collect();
    }

    static /* synthetic */ boolean access$400(MemoryCollector r0) {
        return r0.isStopWhenBackground();
    }

    static /* synthetic */ void access$500(MemoryCollector r0) {
        r0.start();
    }

    static /* synthetic */ void access$600(MemoryCollector r0) {
        r0.stop();
    }

    private MemoryCollector() {
        this.pollingIntervalMillis = 0;
        this.lifecycleListener = new MemoryLifecycleListener(this, null);
        this.mList = new CopyOnWriteArrayList();
    }

    public static MemoryCollector getInstance() {
        return InnerHolder.access$100();
    }

    public void addMapInfo(Map<Object, Object> r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        HashMap r0 = new HashMap();
        this.mmapInfo = r0;
        r0.putAll(r2);
    }

    public void addMemoryCallBackListener(IMemoryDataListener r1) {
        if (r1 == null) goto L5;
        this.mList.add(r1);
        return;
    }

    public void removeMemoryCallBackListener(IMemoryDataListener r1) {
        if (r1 == null) goto L5;
        this.mList.remove(r1);
        return;
    }

    public final synchronized void init() {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (this.inited == false) goto L8;
        monitor-exit(this);
        return;
    L8:
        this.inited = true;     // Catch: Throwable -> L11
        updateConfig(((MemoryConfigService) ServiceManager.getService(MemoryConfigService.class)).getConfig());     // Catch: Throwable -> L11
        monitor-exit(this);
    }

    public void initGCInfo() {
        MemoryStatistics.getInstance().init();
    }

    public void resume() {
        this.isPaused = false;
    }

    public void pause() {
        this.isPaused = true;
    }

    public synchronized void updateConfig(MemoryConfig r9) {
        monitor-enter(this);
        if (r9 != null) goto L48;
        monitor-exit(this);
        return;
    L48:
        this.config = r9;     // Catch: Throwable -> L45
        if (ApmContext.isDebugMode() == false) goto L11;
        Logger.d("APM-Memory", "updateConfig: " + r9);     // Catch: Throwable -> L45
    L11:
        if (r9.isApm6SampleEnable() == true) goto L20;
        stop();     // Catch: Throwable -> L45
        ActivityLifecycleService r0 = (ActivityLifecycleService) ServiceManager.getService(ActivityLifecycleService.class);     // Catch: Throwable -> L45
        if (r0 == null) goto L16;
        r0.unregister(this.lifecycleListener);     // Catch: Throwable -> L45
    L16:
        if (ApmContext.isDebugMode() == false) goto L18;
        Logger.d("APM-Memory", "isApm6SampleEnable: " + r9.isApm6SampleEnable());     // Catch: Throwable -> L45
    L18:
        monitor-exit(this);
        return;
    L20:
        ActivityLifecycleService r2 = (ActivityLifecycleService) ServiceManager.getService(ActivityLifecycleService.class);     // Catch: Throwable -> L45
        if (r2 != null) goto L23;
    L26:
        long r3 = r9.memoryCollectionInterval() * 1000;     // Catch: Throwable -> L45
        this.pollingIntervalMillis = r3;     // Catch: Throwable -> L45
        if (r3 >= 30000) goto L33;
        if (ApmContext.isDebugMode() == false) goto L31;
        Logger.d("APM-Memory", "pollingIntervalMillis: " + this.pollingIntervalMillis);     // Catch: Throwable -> L45
    L31:
        this.pollingIntervalMillis = 30000;     // Catch: Throwable -> L45
    L33:
        if (ApmContext.isDebugMode() == false) goto L35;
        Logger.d("APM-Memory", "result pollingIntervalMillis: " + this.pollingIntervalMillis);     // Catch: Throwable -> L45
    L35:
        AsyncTask r10 = this.memoryCollector;     // Catch: Throwable -> L45
        if (r10 != null) goto L38;
    L40:
        start();     // Catch: Throwable -> L45
        IMapsCollectService r11 = (IMapsCollectService) ServiceManager.getService(IMapsCollectService.class);     // Catch: Throwable -> L45
        if (r11 == null) goto L43;
        r11.start();     // Catch: Throwable -> L45
    L43:
        monitor-exit(this);
        return;
    L38:
        if (r10.getLoopInterval() == this.pollingIntervalMillis) goto L40;
        stop();     // Catch: Throwable -> L45
        goto L40
    L23:
        if (r9.isStopWhenBackground() == false) goto L25;
        r2.unregister(this.lifecycleListener);     // Catch: Throwable -> L45
        r2.register(this.lifecycleListener);     // Catch: Throwable -> L45
        goto L26
    L25:
        r2.unregister(this.lifecycleListener);     // Catch: Throwable -> L45
    L45:
        th = move-exception;
        throw th;
    }

    public void registerReachTopListener(IMemoryReachTopListener r1) {
        this.listener = r1;
    }

    public void unregisterReachTopListener() {
        this.listener = null;
    }

    private synchronized void start() {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (this.isStart == true) goto L9;
        this.isStart = true;     // Catch: Throwable -> L11
        if (ApmContext.isDebugMode() == false) goto L8;
        Logger.d("APM-Memory", "start");     // Catch: Throwable -> L11
    L8:
        scheduleCollectMemory();     // Catch: Throwable -> L11
    L9:
        monitor-exit(this);
    }

    private synchronized void stop() {
        monitor-enter(this);
    L8:
        th = move-exception;
        throw th;
    L4:
        if (this.isStart == false) goto L6;
        this.isStart = false;     // Catch: Throwable -> L8
        cancelCollectMemory();     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
    }

    private void collect() {
        long r0 = System.currentTimeMillis();
        MemoryPerfDataEvent r2 = MemoryStatistics.getInstance().collectWithConfig(this.config);
        if (r2 == null) goto L5;
        r2.setMmapInfo(this.mmapInfo);
        this.mmapInfo = null;
        if (ApmContext.isDebugMode() == false) goto L12;
        Logger.d("APM-Memory", String.format("collect[isUploadEnable=%s cost=%s]: %s", new Object[]{Boolean.valueOf(this.config.isUploadEnable()), Long.valueOf(System.currentTimeMillis() - r0), r2.toJsonObject().toString()}));
    L12:
        if (this.config.isUploadEnable() == false) goto L15;
        sendPerfData(r2);
    L18:
        if (r2.getJavaUsedMemoryRate() > this.config.memoryTopCheckThreshold()) goto L20;
    L22:
        List<IMemoryDataListener> r1 = this.mList;
        if (r1 != null) goto L25;
        return;
    L25:
        if (r1.size() <= 0) goto L38;
        MemoryCollectInfo r3 = r2.getMemoryCollectInfo();     // Catch: Exception -> L32
        Iterator<IMemoryDataListener> r7 = this.mList.iterator();     // Catch: Exception -> L32
    L28:
        if (r7.hasNext() == false) goto L40;
        r7.next().onMemoryCallback(r3);     // Catch: Exception -> L32
    L40:
        return;
    L39:
        return;
    L38:
        return;
    L20:
        if (this.listener == null) goto L22;
        this.listener.onReachTop("reach_top_java");
        goto L22
    L15:
        if (ApmAlogHelper.isFeedbackALogEnabled() == false) goto L18;
        ApmAlogHelper.feedbackI(TAG, r2.toJsonObject().toString());
        goto L18
    L5:
        if (ApmContext.isDebugMode() == false) goto L37;
        Logger.d("APM-Memory", "collectWithConfig return is null");
        return;
    }

    private void scheduleCollectMemory() {
        if (this.memoryCollector == null) goto L5;
        return;
    L5:
        if (ApmContext.isDebugMode() == false) goto L7;
        Logger.d("APM-Memory", "scheduleCollectMemory");
    L7:
        final long r4 = 0;
        final long r6 = this.pollingIntervalMillis;
        this.memoryCollector = new AnonymousClass1(this, r4, r6);
        AsyncTaskManager.getInstance(AsyncTaskManagerType.LIGHT_WEIGHT).sendTask(this.memoryCollector);
    }

    private void cancelCollectMemory() {
        if (ApmContext.isDebugMode() == false) goto L6;
        Logger.d("APM-Memory", "cancelCollectMemory");
    L6:
        if (this.memoryCollector == null) goto L9;
        AsyncTaskManager.getInstance(AsyncTaskManagerType.LIGHT_WEIGHT).removeTask(this.memoryCollector);
        this.memoryCollector = null;
        return;
    }

    private void sendPerfData(Monitorable r1) {
        if (r1 != null) goto L4;
        return;
    L4:
        Monitor.record(r1);
    }

    private boolean isStopWhenBackground() {
        MemoryConfig r0 = this.config;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.isStopWhenBackground() == false) goto L7;
        return true;
    }
}
