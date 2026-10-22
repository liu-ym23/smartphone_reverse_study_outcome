package com.bytedance.android.live.initialize;

import android.os.Looper;
import com.bytedance.android.live.initialize.api.IWTOLogger;
import com.bytedance.android.live.initialize.model.WTOTaskProxy;
import com.bytedance.android.live.initialize.model.c;
import com.bytedance.android.live.initialize.scheduler.WTOSchedulerNotify;
import com.bytedance.android.live.initialize.scheduler.WTOTaskScheduler;
import com.bytedance.android.live.initialize.state.WTOSchedulerStatus;
import com.bytedance.android.live.initialize.state.WTOTaskStatus;
import com.bytedance.android.livesdkapi.init.ILiveInitTaskController;
import com.bytedance.android.livesdkapi.init.ILiveInitTaskListener;
import com.ss.android.dypay.api.DyPayConstant;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\bL\u0010MJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bJ\u000e\u0010\u000b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bJ\u000e\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fJ\u000e\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000fJ\u000e\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u0013J\u000e\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u0015J\u000e\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\fJ\u000e\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\fJ\u0010\u0010\u001d\u001a\u00020\u00002\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bJ\u000e\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u0004J\u0012\u0010\"\u001a\u00020\u00062\b\u0010!\u001a\u0004\u0018\u00010 H\u0016R\"\u0010#\u001a\u00020\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\"\u0010)\u001a\u00020\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b)\u0010$\u001a\u0004\b*\u0010&\"\u0004\b+\u0010(R$\u0010,\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\"\u00102\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b2\u00103\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\u001b\u0010=\u001a\u0002088BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<R\u001b\u0010B\u001a\u00020>8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b?\u0010:\u001a\u0004\b@\u0010AR\u0018\u0010D\u001a\u0004\u0018\u00010C8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bD\u0010ER'\u0010K\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020G0F8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bH\u0010:\u001a\u0004\bI\u0010J¨\u0006N"}, d2 = {"Lcom/bytedance/android/live/initialize/LiveWTO;", "Lcom/bytedance/android/livesdkapi/init/ILiveInitTaskController;", "Lcom/bytedance/android/live/initialize/a;", "period", "", "isInit", "", "triggerWTOPeriodTaskExecute", "Lcom/bytedance/android/live/initialize/IWTOTask;", "iWTOTask", "commitRepeatableTask", "cancelRepeatableTask", "", DBDefinition.TASK_ID, "ensureTaskReady", "Lwa0/c;", "listener", "Lwa0/a;", "observeTaskState", "Lwa0/b;", "observeScheduleState", "Lcom/bytedance/android/live/initialize/api/IWTOLogger;", "IWTOLogger", "configLogger", "size", "configThreadPoolSize", "configIoThreadPoolSize", "Ljava/util/concurrent/Executor;", "executor", "configInitExecutor", "jatoOpt", "configJatoOpt", "Lcom/bytedance/android/livesdkapi/init/ILiveInitTaskListener;", "taskListener", "setInitTaskListener", "initThreadPoolSize", "I", "getInitThreadPoolSize", "()I", "setInitThreadPoolSize", "(I)V", "ioThreadPoolSize", "getIoThreadPoolSize", "setIoThreadPoolSize", "initExecutor", "Ljava/util/concurrent/Executor;", "getInitExecutor", "()Ljava/util/concurrent/Executor;", "setInitExecutor", "(Ljava/util/concurrent/Executor;)V", "enableJatoOpt", "Z", "getEnableJatoOpt", "()Z", "setEnableJatoOpt", "(Z)V", "Lcom/bytedance/android/live/initialize/scheduler/WTOSchedulerNotify;", "mSchedulerNotify$delegate", "Lkotlin/Lazy;", "getMSchedulerNotify", "()Lcom/bytedance/android/live/initialize/scheduler/WTOSchedulerNotify;", "mSchedulerNotify", "Lcom/bytedance/android/live/initialize/model/b;", "mWTOTaskManager$delegate", "getMWTOTaskManager", "()Lcom/bytedance/android/live/initialize/model/b;", "mWTOTaskManager", "Lcom/bytedance/android/live/initialize/b;", "taskListenerAdapter", "Lcom/bytedance/android/live/initialize/b;", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/bytedance/android/live/initialize/scheduler/WTOTaskScheduler;", "mWTOPeriodTaskSchedulers$delegate", "getMWTOPeriodTaskSchedulers", "()Ljava/util/concurrent/ConcurrentHashMap;", "mWTOPeriodTaskSchedulers", "<init>", "()V", "live-initialize-scheduler_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveWTO implements ILiveInitTaskController {
    public static final LiveWTO INSTANCE = null;
    private static boolean enableJatoOpt;
    private static Executor initExecutor;
    private static int initThreadPoolSize;
    private static int ioThreadPoolSize;
    private static final Lazy mSchedulerNotify$delegate = null;
    private static final Lazy mWTOPeriodTaskSchedulers$delegate = null;
    private static final Lazy mWTOTaskManager$delegate = null;
    private static b taskListenerAdapter;

    private LiveWTO() {
    }

    private final WTOSchedulerNotify getMSchedulerNotify() {
        return (WTOSchedulerNotify) mSchedulerNotify$delegate.getValue();
    }

    private final ConcurrentHashMap<a, WTOTaskScheduler> getMWTOPeriodTaskSchedulers() {
        return (ConcurrentHashMap) mWTOPeriodTaskSchedulers$delegate.getValue();
    }

    private final com.bytedance.android.live.initialize.model.b getMWTOTaskManager() {
        return (com.bytedance.android.live.initialize.model.b) mWTOTaskManager$delegate.getValue();
    }

    static {
        INSTANCE = new LiveWTO();
        initThreadPoolSize = 5;
        ioThreadPoolSize = 5;
        mSchedulerNotify$delegate = LazyKt.lazy(LiveWTO$mSchedulerNotify$2.INSTANCE);
        mWTOTaskManager$delegate = LazyKt.lazy(LiveWTO$mWTOTaskManager$2.INSTANCE);
        mWTOPeriodTaskSchedulers$delegate = LazyKt.lazy(LiveWTO$mWTOPeriodTaskSchedulers$2.INSTANCE);
    }

    public final boolean getEnableJatoOpt() {
        return enableJatoOpt;
    }

    public final Executor getInitExecutor() {
        return initExecutor;
    }

    public final int getInitThreadPoolSize() {
        return initThreadPoolSize;
    }

    public final int getIoThreadPoolSize() {
        return ioThreadPoolSize;
    }

    public static final /* synthetic */ WTOSchedulerNotify access$getMSchedulerNotify$p(LiveWTO r100) {
        return r100.getMSchedulerNotify();
    }

    public static final /* synthetic */ com.bytedance.android.live.initialize.model.b access$getMWTOTaskManager$p(LiveWTO r100) {
        return r100.getMWTOTaskManager();
    }

    public final void cancelRepeatableTask(IWTOTask r100) {
        Intrinsics.checkNotNullParameter(r100, "iWTOTask");
        com.bytedance.android.live.initialize.model.b r101 = getMWTOTaskManager();
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "mWTOTask");
        r101.f69407b.remove(r100);
        if (r101.f69408c.get(r100.taskExecutePeriod()) == null) goto L12;
        CopyOnWriteArrayList<IWTOTask> r102 = r101.f69408c.get(r100.taskExecutePeriod());
        if (r102 != null) goto L7;
        return;
    L7:
        if (r102.contains(r100) != true) goto L14;
        CopyOnWriteArrayList<IWTOTask> r103 = r101.f69408c.get(r100.taskExecutePeriod());
        if (r103 == null) goto L15;
        r103.remove(r100);
        return;
    L15:
        return;
    L14:
        return;
    }

    public final void commitRepeatableTask(IWTOTask r100) {
        Intrinsics.checkNotNullParameter(r100, "iWTOTask");
        com.bytedance.android.live.initialize.model.b r101 = getMWTOTaskManager();
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "mWTOTask");
        r101.f69407b.add(r100);
        if (r101.f69408c.get(r100.taskExecutePeriod()) != null) goto L5;
        r101.f69408c.put(r100.taskExecutePeriod(), new CopyOnWriteArrayList());
    L5:
        CopyOnWriteArrayList<IWTOTask> r102 = r101.f69408c.get(r100.taskExecutePeriod());
        if (r102 == null) goto L8;
        r102.add(r100);
    L8:
        triggerWTOPeriodTaskExecute$default(this, r100.taskExecutePeriod(), false, 2, null);
    }

    public final LiveWTO configInitExecutor(Executor r100) {
        initExecutor = r100;
        return this;
    }

    public final LiveWTO configIoThreadPoolSize(int r100) {
        ioThreadPoolSize = r100;
        return this;
    }

    public final void configJatoOpt(boolean r100) {
        enableJatoOpt = r100;
    }

    public final LiveWTO configLogger(IWTOLogger r100) {
        Intrinsics.checkNotNullParameter(r100, "IWTOLogger");
        IWTOLogger r101 = ya0.a.f567013a;
        ya0.a.f567013a = r100;
        return this;
    }

    public final LiveWTO configThreadPoolSize(int r100) {
        initThreadPoolSize = r100;
        return this;
    }

    public final boolean ensureTaskReady(int r100) {
        IWTOTask r101 = getMWTOTaskManager().f69406a.get(Integer.valueOf(r100));
        boolean r102 = false;
        if (r101 != null) goto L5;
        return false;
    L5:
        if (c.a(r101).f69393a == WTOTaskStatus.IDLE) goto L19;
        b r103 = taskListenerAdapter;
        if (r103 == null) goto L11;
        ILiveInitTaskListener r104 = r103.f69390d;
        if (r104 == null) goto L11;
        r104.onWaitTask(r101.taskBusinessInfo());
    L11:
        WTOTaskProxy r105 = c.a(r101);
        ReentrantLock r106 = r105.f69394b;
        r106.lock();
        if (r105.f69393a != WTOTaskStatus.FINISHED) goto L15;
        r102 = true;
    L15:
        r106.unlock();
        return r102;
    L16:
        th = move-exception;
        r106.unlock();
        throw th;
    L19:
        WTOTaskProxy r107 = c.a(r101);
        WTOTaskScheduler r108 = INSTANCE.getMWTOPeriodTaskSchedulers().get(r101.taskExecutePeriod());
        if (r108 == null) goto L23;
        WTOTaskScheduler.g(r108, r107, "ensureReady", null, 4);
    L23:
        if (r107.f69393a != WTOTaskStatus.FINISHED) goto L30;
        return true;
    L30:
        return false;
    }

    public final wa0.a observeScheduleState(wa0.b r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        return getMSchedulerNotify().b(r100);
    }

    public final wa0.a observeTaskState(wa0.c r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        return getMSchedulerNotify().c(r100);
    }

    public final void setEnableJatoOpt(boolean r100) {
        enableJatoOpt = r100;
    }

    public final void setInitExecutor(Executor r100) {
        initExecutor = r100;
    }

    @Override // com.bytedance.android.livesdkapi.init.ILiveInitTaskController
    public void setInitTaskListener(ILiveInitTaskListener r100) {
        if (r100 == null) goto L7;
        b r101 = taskListenerAdapter;
        if (r101 != null) goto L6;
        taskListenerAdapter = new b(getMSchedulerNotify(), r100);
        return;
    L6:
        r101.f69390d = r100;
        return;
    L7:
        b r102 = taskListenerAdapter;
        if (r102 == null) goto L10;
        WTOSchedulerNotify r103 = r102.f69389c;
        b.C1129b r104 = r102.f69387a;
        r103.getClass();
        Intrinsics.checkNotNullParameter(r104, "listener");
        r103.a().remove(r104);
        WTOSchedulerNotify r105 = r102.f69389c;
        b.a r106 = r102.f69388b;
        r105.getClass();
        Intrinsics.checkNotNullParameter(r106, "listener");
        ((CopyOnWriteArrayList) r105.f69418b.getValue()).remove(r106);
    L10:
        b r107 = taskListenerAdapter;
        if (r107 == null) goto L13;
        r107.f69390d = null;
    L13:
        taskListenerAdapter = null;
    }

    public final void setInitThreadPoolSize(int r100) {
        initThreadPoolSize = r100;
    }

    public final void setIoThreadPoolSize(int r100) {
        ioThreadPoolSize = r100;
    }

    public final void triggerWTOPeriodTaskExecute(a r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "period");
        int r102 = 0;
        if (Intrinsics.areEqual(r100, a.i.f69383c) == false) goto L5;
    L8:
        boolean r103 = true;
    L9:
        if (r103 == false) goto L28;
        com.bytedance.android.live.initialize.model.b r104 = getMWTOTaskManager();
        r104.getClass();
        Intrinsics.checkNotNullParameter(r100, "executePeriod");
        com.bytedance.android.live.initialize.model.b.a r105 = (com.bytedance.android.live.initialize.model.b.a) ((LinkedHashMap) r104.f69409d).get(r100);
        if (r105 == null) goto L28;
        if (r105.f69415e == false) goto L28;
        LinkedHashSet r106 = new LinkedHashSet();
        ArrayList r107 = new ArrayList();
        ArrayList r108 = new ArrayList();
        int r109 = r105.f69414d.size();
    L15:
        if (r102 >= r109) goto L22;
        if (r106.contains(Integer.valueOf(r105.f69414d.get(r102).taskID())) == true) goto L21;
        if (r105.a(r105.f69414d.get(r102), r106, r107, r108) == false) goto L21;
        List r110 = r108.subList(r108.indexOf(CollectionsKt.last(r108)), r108.size());
    L23:
        if (r110 == null) goto L28;
        throw new RuntimeException("启动任务存在环：" + r110);
    L21:
        r102 = r102 + 1;
        goto L15
    L22:
        r110 = null;
    L28:
        if (getMWTOPeriodTaskSchedulers().get(r100) != null) goto L30;
        LiveWTO r111 = INSTANCE;
        r111.getMWTOPeriodTaskSchedulers().put(r100, new WTOTaskScheduler(r100, r111.getMWTOTaskManager(), WTOThreadPoolHelper.INSTANCE.getMCpuMixedCommonThreadPool(), r111.getMSchedulerNotify()));
        Unit r112 = Unit.INSTANCE;
    L30:
        WTOTaskScheduler r113 = getMWTOPeriodTaskSchedulers().get(r100);
        if (r113 != null) goto L33;
        return;
    L33:
        if (r113.f69421a != WTOSchedulerStatus.IDLE) goto L75;
        Looper r114 = Looper.myLooper();
        if (r114 == null) goto L39;
        r113.f69430j = new com.bytedance.android.live.initialize.scheduler.a(r113, r114);
    L39:
        r113.f69429i.lock();
        r113.f69426f = System.currentTimeMillis();
        r113.f69421a = WTOSchedulerStatus.RUNNING;
        r113.f69435o.d(10004, r113.f69432l);
        IWTOLogger r115 = ya0.a.f567013a;
        a r116 = r113.f69432l;
        LinkedHashMap r117 = new LinkedHashMap();
        r117.put(DyPayConstant.KEY_START_TIME, Long.valueOf(r113.f69426f));
        r117.put("scheduleThreadId", Long.valueOf(ThreadMethodProxy.currentThread().getId()));
        r117.put("allTaskSize", Integer.valueOf(r113.f69424d));
        r117.put("blockTaskSize", Integer.valueOf(r113.f69422b));
        Unit r118 = Unit.INSTANCE;
        ya0.a.d(r116, "______SCHEDULE STARTED______", r117);
        if (r101 == false) goto L42;
        r113.i();
        return;
    L42:
        monitor-enter(r113);
    L62:
        th = move-exception;
        throw th;
    L44:
        if (r113.f69422b <= 0) goto L57;
        Object r119 = r113.f69428h;     // Catch: Throwable -> L62
        monitor-enter(r119);     // Catch: Throwable -> L62
    L67:
    L53:
        th = move-exception;
        throw th;     // Catch: Throwable -> L62
    L48:
        if (r113.f69423c.get() == r113.f69422b) goto L50;
        r113.h();     // Catch: Throwable -> L53
        r113.f69428h.wait();     // Catch: Throwable -> L53
        goto L67
    L50:
        Unit r120 = Unit.INSTANCE;     // Catch: Throwable -> L53
        monitor-exit(r119);     // Catch: Throwable -> L62
        r113.e();     // Catch: Throwable -> L62
        goto L57
    L57:
        if (r113.f69425e.get() == r113.f69424d) goto L59;
        r113.f69427g = r113.f69435o.c(r113);     // Catch: Throwable -> L62
        r113.h();     // Catch: Throwable -> L62
    L60:
        monitor-exit(r113);
        return;
    L59:
        r113.f();     // Catch: Throwable -> L62
        goto L60
    L75:
        return;
    L5:
        if (Intrinsics.areEqual(r100, a.c.f69378c) == true) goto L8;
        r103 = false;
        goto L9
    }

    public static /* synthetic */ void triggerWTOPeriodTaskExecute$default(LiveWTO r100, a r101, boolean r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L5;
        r102 = false;
    L5:
        r100.triggerWTOPeriodTaskExecute(r101, r102);
    }
}
