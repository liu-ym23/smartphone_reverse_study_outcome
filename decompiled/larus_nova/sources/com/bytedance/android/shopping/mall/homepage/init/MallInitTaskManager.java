package com.bytedance.android.shopping.mall.homepage.init;

import android.util.SparseArray;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.bytedance.android.shopping.api.mall.init.NativeMallInitStage;
import com.bytedance.common.utility.Logger;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.PriorityQueue;
import jf3.b;
import jf3.c;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\tB\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u0005\u001a\u00020\u0004H\u0007J\b\u0010\u0006\u001a\u00020\u0004H\u0007¨\u0006\n"}, d2 = {"Lcom/bytedance/android/shopping/mall/homepage/init/MallInitTaskManager;", "", "Landroidx/lifecycle/LifecycleObserver;", "Ljf3/b;", "", "onHostCreate", "onHostDestory", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "mall_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MallInitTaskManager implements LifecycleObserver, b {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Map<String, MallInitTaskManager> f178174e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile int f178175a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public WeakReference<c> f178176b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final SparseArray<PriorityQueue<x93.a>> f178177c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final SparseArray<PriorityQueue<x93.a>> f178178d;

    public static final class a {
    }

    @Override // jf3.b
    public final void b(boolean r100) {
    }

    @Override // jf3.b
    public final void c() {
        i(3);
    }

    @Override // jf3.b
    public final void e() {
    }

    @Override // jf3.b
    public final void f() {
        i(4);
    }

    @Override // jf3.b
    public final void g() {
    }

    static {
        f178174e = new LinkedHashMap();
    }

    @Override // jf3.b
    public final void d() {
        Logger.d("MallInitTaskManager", "onNADestroy");
        WeakReference<c> r100 = this.f178176b;
        if (r100 == null) goto L7;
        c r101 = r100.get();
        if (r101 == null) goto L7;
        r101.h(this);
    L7:
        this.f178176b = null;
        if (this.f178175a < 2) goto L10;
        this.f178175a = 1;
    L10:
        h(2);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public final void onHostCreate() {
        Logger.d("MallInitTaskManager", "onHostCreate");
        i(1);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void onHostDestory() {
        Logger.d("MallInitTaskManager", "onHostDestory");
        WeakReference<c> r100 = this.f178176b;
        if (r100 == null) goto L7;
        c r101 = r100.get();
        if (r101 == null) goto L7;
        r101.h(this);
    L7:
        this.f178176b = null;
        this.f178175a = 0;
        h(0);
    }

    private MallInitTaskManager() {
        this.f178177c = new SparseArray();
        this.f178178d = new SparseArray();
    }

    public /* synthetic */ MallInitTaskManager(int r100) {
        this();
    }

    @Override // jf3.b
    public final void a(boolean r100) {
        i(2);
    }

    public final void h(@NativeMallInitStage int r100) {
        Logger.d("MallInitTaskManager", "clearTasks");
    L4:
        if (r100 > 3) goto L12;
        Logger.d("MallInitTaskManager", "clearTasks ,stage = " + r100);
        PriorityQueue<x93.a> r101 = this.f178177c.get(r100);
        if (r101 == null) goto L8;
        r101.clear();
    L8:
        PriorityQueue<x93.a> r102 = this.f178178d.get(r100);
        if (r102 == null) goto L11;
        r102.clear();
    L11:
        r100 = r100 + 1;
        goto L4
    }

    public final void i(@NativeMallInitStage int r100) {
        Logger.d("MallInitTaskManager", "onMallInitStateChanged newStage  =" + r100);
        this.f178175a = r100;
        if (r100 < 0) goto L28;
        int r101 = 0;
    L5:
        Logger.d("MallInitTaskManager", "run stage task   stage =" + r101);
    L6:
        PriorityQueue<x93.a> r102 = this.f178178d.get(r101);
        if (r102 == null) goto L9;
        x93.a r103 = r102.peek();
    L10:
        if (r103 == null) goto L16;
        PriorityQueue<x93.a> r104 = this.f178178d.get(r101);
        if (r104 == null) goto L6;
        x93.a r105 = r104.poll();
        if (r105 == null) goto L6;
        Logger.d("MallInitTaskManager", "async run stage task,task =" + r105.F());
        Single.just(0).observeOn(Schedulers.computation()).subscribe(new kf3.a(this, r105), kf3.b.f503196a);
    L16:
        PriorityQueue<x93.a> r106 = this.f178177c.get(r101);
        if (r106 == null) goto L19;
        x93.a r107 = r106.peek();
    L20:
        if (r107 == null) goto L26;
        PriorityQueue<x93.a> r108 = this.f178177c.get(r101);
        if (r108 == null) goto L16;
        x93.a r109 = r108.poll();
        if (r109 == null) goto L16;
        Logger.d("MallInitTaskManager", "run stage task,task =" + r109.F());
        r109.run();
        goto L16
    L26:
        if (r101 == r100) goto L44;
        r101 = r101 + 1;
        goto L5
    L44:
        return;
    L19:
        r107 = null;
        goto L20
    L9:
        r103 = null;
        goto L10
    }
}
