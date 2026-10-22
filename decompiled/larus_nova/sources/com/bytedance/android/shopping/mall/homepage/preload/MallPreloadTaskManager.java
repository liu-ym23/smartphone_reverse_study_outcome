package com.bytedance.android.shopping.mall.homepage.preload;

import com.bytedance.android.ec.hybrid.log.mall.ECMallLogUtil;
import com.bytedance.android.ec.hybrid.log.mall.r;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class MallPreloadTaskManager implements com.bytedance.android.shopping.api.mall.m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f178374a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap<String, com.bytedance.android.shopping.api.mall.l<? extends Object>> f178375b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<String> f178376c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Object f178377d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile int f178378e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile Boolean f178379f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final List<com.bytedance.android.shopping.api.mall.m.b> f178380g;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.shopping.api.mall.m
    public final void a() {
    }

    @Override // com.bytedance.android.shopping.api.mall.m
    public final void b() {
        this.f178378e = 4;
        if (this.f178378e == 1) goto L6;
        this.f178375b.clear();
        return;
    }

    public MallPreloadTaskManager() {
        r.a r100 = r.a.f47516b;
        this.f178374a = LazyKt.lazy(MallPreloadTaskManager$preloadCachedDataOptEnable$2.INSTANCE);
        this.f178375b = new ConcurrentHashMap();
        this.f178376c = new ArrayList();
        this.f178377d = new Object();
        this.f178380g = new ArrayList();
        new AtomicBoolean(false);
    }

    @Override // com.bytedance.android.shopping.api.mall.m
    public final Boolean c() {
        return this.f178379f;
    }

    @Override // com.bytedance.android.shopping.api.mall.m
    public final <T> T d(String r100, Map<String, ? extends Object> r101) {
        Intrinsics.checkNotNullParameter(r100, "name");
        T r102 = null;
        if (this.f178378e != 4) goto L5;
        return null;
    L5:
        Object r103 = this.f178377d;
        monitor-enter(r103);
    L23:
        th = move-exception;
        throw th;
    L8:
        if (((ArrayList) this.f178376c).contains(r100) == false) goto L11;
        monitor-exit(r103);
        return null;
    L11:
        Unit r104 = Unit.INSTANCE;     // Catch: Throwable -> L23
        monitor-exit(r103);
        com.bytedance.android.shopping.api.mall.l<? extends Object> r105 = this.f178375b.get(r100);
        if (r105 == null) goto L16;
        Object r106 = r105.a();
    L18:
        if ((r106 instanceof Object) == false) goto L21;
        r102 = (T) r106;
    L21:
        Lazy r107 = ECMallLogUtil.f47441a;
        ECMallLogUtil.c(com.bytedance.android.ec.hybrid.log.mall.m.a.f47507b, "preload task " + r100 + " result is " + r102);
        this.f178375b.remove(r100);
        return r102;
    L16:
        r106 = null;
        goto L18
    }
}
