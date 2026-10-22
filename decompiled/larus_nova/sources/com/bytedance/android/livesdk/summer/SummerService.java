package com.bytedance.android.livesdk.summer;

import android.os.Handler;
import android.os.Looper;
import androidx.lifecycle.LiveData;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.strategy.api.IStrategyService;
import com.bytedance.android.livesdk.config.me;
import com.bytedance.android.livesdk.config.ms;
import com.bytedance.android.livesdk.config.vt0;
import com.bytedance.android.livesdkapi.service.ISummerService;
import com.bytedance.android.livesdkapi.service.ISummerServiceForSaas;
import com.bytedance.android.livesdkapi.summer.ISummerTask;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PThreadPoolExecutor;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import com.ss.android.ugc.effectmanager.common.ConcurrentHashSet;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes11.dex */
public class SummerService implements ISummerService {
    private static final String TAG = "BDLog";
    private int liveTheme;
    private final ConcurrentHashMap<Integer, ISummerTask> mAllTasks;
    private volatile ThreadPoolExecutor mExecutor;
    private final CopyOnWriteArrayList<Integer> mHighPriorityTasks;
    private final Handler mMainHandler;
    private final CopyOnWriteArrayList<Integer> mNormalPriorityTasks;
    private final ConcurrentHashSet<Integer> mPendingCancelTasks;
    private Map<String, Boolean> strategyMap;

    public class a implements Consumer<Map<String, Boolean>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SummerService f158435a;

        public a(SummerService r100) {
            this.f158435a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Map<String, Boolean> r100) throws Exception {
            Map<String, Boolean> r101 = r100;
            SummerService.access$002(this.f158435a, r101);
            if (SummerService.access$100(this.f158435a) > 0) goto L5;
            SummerService.access$200(this.f158435a);
        L6:
            SummerService.access$300(this.f158435a).postDelayed(new n(this), SummerService.access$500(this.f158435a));
            ALogger.i(SummerService.TAG, r101.toString());
            return;
        L5:
            SummerService.access$300(this.f158435a).postDelayed(new m(this), SummerService.access$100(this.f158435a));
            goto L6
        }
    }

    public class b implements ObservableOnSubscribe<Map<String, Boolean>> {
        public b() {
        }

        @Override // io.reactivex.ObservableOnSubscribe
        public final void subscribe(ObservableEmitter<Map<String, Boolean>> r100) throws Exception {
            IStrategyService r101 = (IStrategyService) jc1.k.f(IStrategyService.class);
            if (r101 == null) goto L8;
            LiveData r102 = r101.getFactor("live_preload", new LinkedHashMap(), true, true);
            if (r102 == null) goto L7;
            r100.onNext((Map) r102.getValue());
            return;
        L7:
            r100.onNext(new LinkedHashMap());
            return;
        L8:
            r100.onNext(new LinkedHashMap());
        }
    }

    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ISummerTask f158436a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f158437b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ SummerService f158438c;

        public final void a() {
            if (this.f158436a != null) goto L5;
            return;
        L5:
            ALogger.i(SummerService.TAG, "summer task process: " + this.f158436a.toString() + "; in " + ThreadMethodProxy.currentThread().getName());
            if (SummerService.access$600(this.f158438c).contains(Integer.valueOf(this.f158437b)) == false) goto L8;
            this.f158436a.cancelTask();
            SummerService.access$600(this.f158438c).remove(Integer.valueOf(this.f158437b));
        L8:
            this.f158436a.processTask();
            this.f158436a.releaseTask();
            SummerService.access$700(this.f158438c).remove(Integer.valueOf(this.f158437b));
            ALogger.i(SummerService.TAG, "summer sync task end: " + this.f158436a.toString());
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public c(SummerService r100, ISummerTask r101, int r102) {
            this.f158438c = r100;
            this.f158436a = r101;
            this.f158437b = r102;
        }
    }

    @Override // com.bytedance.android.livesdkapi.service.ISummerServiceForSaas
    public final /* synthetic */ void onHostTriggerByActivity() {
        ISummerServiceForSaas.CC.$default$onHostTriggerByActivity(this);
    }

    private boolean enable() {
        return vt0.f121477a.getValue().mEnable;
    }

    private void ensureThreadPool() {
        if (this.mExecutor != null) goto L6;
        this.mExecutor = new PThreadPoolExecutor(1, 5, 100, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(50), new DefaultThreadFactory("SummerService"));
        this.mExecutor.allowCoreThreadTimeOut(true);
        return;
    }

    private long getHighPriorityDelay() {
        long r100 = vt0.f121477a.getValue().mHighPriorityDelay;
        if (r100 <= 0) goto L6;
        return r100;
    L6:
        return 0;
    }

    private long getNormalPriorityDelay() {
        long r100 = vt0.f121477a.getValue().mNormalPriorityDelay;
        if (r100 > 0) goto L7;
        return 60000;
    L7:
        return r100;
    }

    private void triggerHighPriorityTasks() {
        ALogger.i(TAG, "summer triggerHighPriorityTasks");
        Iterator<Integer> r100 = this.mHighPriorityTasks.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        processTask(r100.next().intValue());
        goto L4
    }

    private void triggerNormalPriorityTasks() {
        ALogger.i(TAG, "summer triggerNormalPriorityTasks");
        Iterator<Integer> r100 = this.mNormalPriorityTasks.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        processTask(r100.next().intValue());
        goto L4
    }

    public SummerService() {
        this.mAllTasks = new ConcurrentHashMap();
        this.mPendingCancelTasks = new ConcurrentHashSet();
        this.mHighPriorityTasks = new CopyOnWriteArrayList();
        this.mNormalPriorityTasks = new CopyOnWriteArrayList();
        this.mMainHandler = new Handler(Looper.getMainLooper());
        this.mExecutor = null;
        this.strategyMap = null;
        jc1.k.l(ISummerService.class, this);
        ALogger.i(TAG, "summer service registered");
    }

    @Override // com.bytedance.android.livesdkapi.service.ISummerService
    public void onHostTrigger() {
        if (enable() == true) goto L5;
        return;
    L5:
        ALogger.i(TAG, "summer trigger");
        if (ms.f120779a.getValue().booleanValue() == true) goto L12;
        ((ISummerService) jc1.k.f(ISummerService.class)).registerTask(1, new kt2.f());
        ((ISummerService) jc1.k.f(ISummerService.class)).registerTask(2, new kt2.k());
        if (me.f120748a.getValue().booleanValue() == false) goto L11;
        ((ISummerService) jc1.k.f(ISummerService.class)).registerTask(3, new kt2.d());
    L11:
        ((ISummerService) jc1.k.f(ISummerService.class)).registerTask(4, new kt2.b());
    L12:
        Observable.create(new b()).subscribeOn(AndroidSchedulers.mainThread()).observeOn(Schedulers.computation()).subscribe(new a(this));
    }

    @Override // com.bytedance.android.livesdkapi.service.ISummerService
    public int getLiveTheme() {
        return this.liveTheme;
    }

    @Override // com.bytedance.android.livesdkapi.service.ISummerService
    public Map<String, Boolean> getStrategyMap() {
        return this.strategyMap;
    }

    public static /* synthetic */ long access$100(SummerService r100) {
        return r100.getHighPriorityDelay();
    }

    public static /* synthetic */ void access$200(SummerService r100) {
        r100.triggerHighPriorityTasks();
    }

    public static /* synthetic */ Handler access$300(SummerService r100) {
        return r100.mMainHandler;
    }

    public static /* synthetic */ void access$400(SummerService r100) {
        r100.triggerNormalPriorityTasks();
    }

    public static /* synthetic */ long access$500(SummerService r100) {
        return r100.getNormalPriorityDelay();
    }

    public static /* synthetic */ ConcurrentHashSet access$600(SummerService r100) {
        return r100.mPendingCancelTasks;
    }

    public static /* synthetic */ ConcurrentHashMap access$700(SummerService r100) {
        return r100.mAllTasks;
    }

    private CopyOnWriteArrayList<Integer> getTargetTaskList(ISummerTask r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        if (r100.getPriority() != 0) goto L10;
        return this.mHighPriorityTasks;
    L10:
        if (r100.getPriority() == 1) goto L12;
        return null;
    L12:
        return this.mNormalPriorityTasks;
    }

    private void processTask(int r100) {
        ISummerTask r101 = this.mAllTasks.get(Integer.valueOf(r100));
        if (r101 != null) goto L6;
        return;
    L6:
        if (r101.getTaskType() != 0) goto L8;
        this.mMainHandler.post(getTaskWrapper(r100, r101));
        return;
    L8:
        ensureThreadPool();
        this.mExecutor.submit(getTaskWrapper(r100, r101));
    }

    @Override // com.bytedance.android.livesdkapi.service.ISummerService
    public void cancelTask(int r100) {
        ISummerTask r101 = this.mAllTasks.get(Integer.valueOf(r100));
        if (r101 == null) goto L5;
        r101.cancelTask();
        ALogger.i(TAG, "cancel summer task : " + r101.toString());
        return;
    L5:
        this.mPendingCancelTasks.add(Integer.valueOf(r100));
        ALogger.i(TAG, "add pending cancel summer task id=" + r100);
    }

    @Override // com.bytedance.android.livesdkapi.service.ISummerService
    public ISummerTask findTask(int r100) {
        return this.mAllTasks.get(Integer.valueOf(r100));
    }

    @Override // com.bytedance.android.livesdkapi.service.ISummerService
    public void setLiveTheme(int r100) {
        this.liveTheme = r100;
    }

    public static /* synthetic */ Map access$002(SummerService r100, Map r101) {
        r100.strategyMap = r101;
        return r101;
    }

    private Runnable getTaskWrapper(int r100, ISummerTask r101) {
        return new c(this, r101, r100);
    }

    @Override // com.bytedance.android.livesdkapi.service.ISummerService
    public void registerTask(int r100, ISummerTask r101) {
        if (r101 != null) goto L4;
        return;
    L4:
        if (this.mPendingCancelTasks.contains(Integer.valueOf(r100)) == false) goto L6;
        r101.cancelTask();
        this.mPendingCancelTasks.remove(Integer.valueOf(r100));
    L6:
        ALogger.i(TAG, "summer register task : " + r101.toString());
        CopyOnWriteArrayList<Integer> r102 = getTargetTaskList(r101);
        if (r102 == null) goto L11;
        r102.addIfAbsent(Integer.valueOf(r100));
        this.mAllTasks.put(Integer.valueOf(r100), r101);
        return;
    }
}
