package com.bytedance.android.ec.hybrid.card.impl;

import com.bytedance.android.ec.hybrid.card.api.IECLynxCardLifeCycle;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes44.dex */
public final class j extends zz6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<IECLynxCardLifeCycle> f46546a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Long f46547b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f46548c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f46549d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final IECLynxCardLifeCycle f46550e;

    public static final class a {
    }

    static {
    }

    public j(xj.b r100, Long r101) {
        this.f46550e = r100;
        ArrayList r102 = new ArrayList();
        this.f46546a = r102;
        if (r100 == null) goto L5;
        r102.add(r100);
    L5:
        this.f46547b = r101;
        this.f46548c = LazyKt.lazy(new HybridKitLifeCycleImpl$timeoutNotifier$2(this));
        this.f46549d = LazyKt.lazy(HybridKitLifeCycleImpl$mainHandler$2.INSTANCE);
    }
}
