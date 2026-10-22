package com.bytedance.apm6.memory;

import android.app.Activity;
import com.bytedance.apm.constant.PerfConsts;
import com.bytedance.apm.listener.IMemoryReachTopListener;
import com.bytedance.apm6.memory.config.MemoryConfigService;
import com.bytedance.apm6.memory.listener.IMemoryDataListener;
import com.bytedance.apm6.monitor.Monitorable;
import com.bytedance.apm6.service.lifecycle.ActivityLifecycleService;
import com.bytedance.apm6.util.timetask.AsyncTaskManagerType;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes.dex */
public class MemoryCollector {
    private static final long MIN_COLLECT_TIME = 30000;
    private static final String TAG = "MemoryCollector";
    private j3.a config;
    private volatile boolean inited;
    private volatile boolean isPaused;
    private volatile boolean isStart;
    private c lifecycleListener;
    private volatile IMemoryReachTopListener listener;
    private List<IMemoryDataListener> mList;
    private u3.a memoryCollector;
    private Map<Object, Object> mmapInfo;
    private long pollingIntervalMillis;

    public class a extends u3.a {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ MemoryCollector f6815d;

        public a(MemoryCollector r10, long r11, long r12) {
            this.f6815d = r10;
            super(r11, r12);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (MemoryCollector.access$200(this.f6815d) == true) goto L6;
            MemoryCollector.access$300(this.f6815d);
            return;
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final MemoryCollector f6816a = null;

        static {
            f6816a = new MemoryCollector(null);
        }

        public static /* synthetic */ MemoryCollector a() {
            return f6816a;
        }
    }

    public class c extends q3.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MemoryCollector f6817a;

        public c(MemoryCollector r10) {
            this.f6817a = r10;
        }

        @Override // q3.a, com.bytedance.apm6.service.lifecycle.IActivityLifecycleObserver
        public final void onBackground(Activity r10) {
            if (r3.a.c() == false) goto L6;
            s3.a.a("APM-Memory", "isStopWhenBackground:" + MemoryCollector.access$400(this.f6817a));
        L6:
            if (MemoryCollector.access$400(this.f6817a) == false) goto L9;
            MemoryCollector.access$600(this.f6817a);
            return;
        }

        @Override // q3.a, com.bytedance.apm6.service.lifecycle.IActivityLifecycleObserver
        public final void onFront(Activity r10) {
            if (r3.a.c() == false) goto L6;
            s3.a.a("APM-Memory", "isStopWhenBackground:" + MemoryCollector.access$400(this.f6817a));
        L6:
            if (MemoryCollector.access$400(this.f6817a) == false) goto L9;
            MemoryCollector.access$500(this.f6817a);
            return;
        }

        public /* synthetic */ c(MemoryCollector r10, a r11) {
            this(r10);
        }
    }

    static {
    }

    public /* synthetic */ MemoryCollector(a r10) {
        this();
    }

    public static /* synthetic */ boolean access$200(MemoryCollector r10) {
        return r10.isPaused;
    }

    public static /* synthetic */ void access$300(MemoryCollector r10) {
        r10.collect();
    }

    public static /* synthetic */ boolean access$400(MemoryCollector r10) {
        return r10.isStopWhenBackground();
    }

    public static /* synthetic */ void access$500(MemoryCollector r10) {
        r10.start();
    }

    public static /* synthetic */ void access$600(MemoryCollector r10) {
        r10.stop();
    }

    private void cancelCollectMemory() {
        if (r3.a.c() == false) goto L6;
        s3.a.a("APM-Memory", "cancelCollectMemory");
    L6:
        if (this.memoryCollector == null) goto L9;
        u3.b.a(AsyncTaskManagerType.LIGHT_WEIGHT).b(this.memoryCollector);
        this.memoryCollector = null;
        return;
    }

    private void collect() {
        long r10 = System.currentTimeMillis();
        k3.a r11 = h3.a.h().a(this.config);
        if (r11 == null) goto L5;
        r11.i(this.mmapInfo);
        this.mmapInfo = null;
        if (r3.a.c() == false) goto L12;
        s3.a.a("APM-Memory", String.format("collect[isUploadEnable=%s cost=%s]: %s", new Object[]{Boolean.valueOf(this.config.d()), Long.valueOf(System.currentTimeMillis() - r10), r11.toJsonObject().toString()}));
    L12:
        if (this.config.d() == false) goto L15;
        sendPerfData(r11);
    L18:
        if (r11.g() > this.config.f()) goto L20;
    L22:
        List<IMemoryDataListener> r12 = this.mList;
        if (r12 != null) goto L25;
        return;
    L25:
        if (r12.size() <= 0) goto L38;
        i3.a r13 = r11.h();     // Catch: Exception -> L32
        Iterator<IMemoryDataListener> r14 = this.mList.iterator();     // Catch: Exception -> L32
    L28:
        if (r14.hasNext() == false) goto L40;
        r14.next().onMemoryCallback(r13);     // Catch: Exception -> L32
    L40:
        return;
    L39:
        return;
    L38:
        return;
    L20:
        if (this.listener == null) goto L22;
        this.listener.onReachTop(PerfConsts.KEY_REACH_TOP_JAVA);
        goto L22
    L15:
        if (s1.a.e() == false) goto L18;
        s1.a.b(TAG, r11.toJsonObject().toString());
        goto L18
    L5:
        if (r3.a.c() == false) goto L37;
        s3.a.a("APM-Memory", "collectWithConfig return is null");
        return;
    }

    public static MemoryCollector getInstance() {
        return b.a();
    }

    private boolean isStopWhenBackground() {
        j3.a r10 = this.config;
        if (r10 != null) goto L5;
    L7:
        return false;
    L5:
        if (r10.c() == false) goto L7;
        return true;
    }

    private void scheduleCollectMemory() {
        if (this.memoryCollector == null) goto L5;
        return;
    L5:
        if (r3.a.c() == false) goto L7;
        s3.a.a("APM-Memory", "scheduleCollectMemory");
    L7:
        this.memoryCollector = new a(this, 0, this.pollingIntervalMillis);
        u3.b.a(AsyncTaskManagerType.LIGHT_WEIGHT).c(this.memoryCollector);
    }

    private void sendPerfData(Monitorable r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        l3.a.d(r10);
    }

    private synchronized void start() {
        monitor-enter(this);
    L8:
        th = move-exception;
        throw th;
    L4:
        if (this.isStart == true) goto L11;
        this.isStart = true;     // Catch: Throwable -> L8
        if (r3.a.c() == false) goto L10;
        s3.a.a("APM-Memory", "start");     // Catch: Throwable -> L8
    L10:
        scheduleCollectMemory();     // Catch: Throwable -> L8
    L11:
        monitor-exit(this);
    }

    private synchronized void stop() {
        monitor-enter(this);
    L7:
        th = move-exception;
        throw th;
    L4:
        if (this.isStart == false) goto L9;
        this.isStart = false;     // Catch: Throwable -> L7
        cancelCollectMemory();     // Catch: Throwable -> L7
    L9:
        monitor-exit(this);
    }

    public void addMapInfo(Map<Object, Object> r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        HashMap r11 = new HashMap();
        this.mmapInfo = r11;
        r11.putAll(r10);
    }

    public void addMemoryCallBackListener(IMemoryDataListener r10) {
        if (r10 == null) goto L5;
        this.mList.add(r10);
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
        updateConfig(((MemoryConfigService) o3.a.a(MemoryConfigService.class)).getConfig());     // Catch: Throwable -> L11
        monitor-exit(this);
    }

    public void initGCInfo() {
        h3.a.h().l();
    }

    public void pause() {
        this.isPaused = true;
    }

    public void registerReachTopListener(IMemoryReachTopListener r10) {
        this.listener = r10;
    }

    public void removeMemoryCallBackListener(IMemoryDataListener r10) {
        if (r10 == null) goto L5;
        this.mList.remove(r10);
        return;
    }

    public void resume() {
        this.isPaused = false;
    }

    public void unregisterReachTopListener() {
        this.listener = null;
    }

    public synchronized void updateConfig(j3.a r10) {
        monitor-enter(this);
        if (r10 != null) goto L48;
        monitor-exit(this);
        return;
    L48:
        this.config = r10;     // Catch: Throwable -> L9
        if (r3.a.c() == false) goto L12;
        s3.a.a("APM-Memory", "updateConfig: " + r10);     // Catch: Throwable -> L9
    L12:
        if (r10.a() == true) goto L21;
        stop();     // Catch: Throwable -> L9
        ActivityLifecycleService r11 = (ActivityLifecycleService) o3.a.a(ActivityLifecycleService.class);     // Catch: Throwable -> L9
        if (r11 == null) goto L17;
        r11.unregister(this.lifecycleListener);     // Catch: Throwable -> L9
    L17:
        if (r3.a.c() == false) goto L19;
        s3.a.a("APM-Memory", "isApm6SampleEnable: " + r10.a());     // Catch: Throwable -> L9
    L19:
        monitor-exit(this);
        return;
    L21:
        ActivityLifecycleService r12 = (ActivityLifecycleService) o3.a.a(ActivityLifecycleService.class);     // Catch: Throwable -> L9
        if (r12 != null) goto L24;
    L27:
        long r13 = r10.e() * 1000;     // Catch: Throwable -> L9
        this.pollingIntervalMillis = r13;     // Catch: Throwable -> L9
        if (r13 >= 30000) goto L34;
        if (r3.a.c() == false) goto L32;
        s3.a.a("APM-Memory", "pollingIntervalMillis: " + this.pollingIntervalMillis);     // Catch: Throwable -> L9
    L32:
        this.pollingIntervalMillis = 30000;     // Catch: Throwable -> L9
    L34:
        if (r3.a.c() == false) goto L36;
        s3.a.a("APM-Memory", "result pollingIntervalMillis: " + this.pollingIntervalMillis);     // Catch: Throwable -> L9
    L36:
        u3.a r14 = this.memoryCollector;     // Catch: Throwable -> L9
        if (r14 != null) goto L39;
    L41:
        start();     // Catch: Throwable -> L9
        IMapsCollectService r15 = (IMapsCollectService) o3.a.a(IMapsCollectService.class);     // Catch: Throwable -> L9
        if (r15 == null) goto L44;
        r15.start();     // Catch: Throwable -> L9
    L44:
        monitor-exit(this);
        return;
    L39:
        if (r14.b() == this.pollingIntervalMillis) goto L41;
        stop();     // Catch: Throwable -> L9
        goto L41
    L24:
        if (r10.c() == false) goto L26;
        r12.unregister(this.lifecycleListener);     // Catch: Throwable -> L9
        r12.register(this.lifecycleListener);     // Catch: Throwable -> L9
        goto L27
    L26:
        r12.unregister(this.lifecycleListener);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    }

    private MemoryCollector() {
        this.pollingIntervalMillis = 0;
        this.lifecycleListener = new c(this, null);
        this.mList = new CopyOnWriteArrayList();
    }
}
