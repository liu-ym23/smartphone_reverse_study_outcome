package com.bytedance.android.shopping.pre_purchase.arch.launch;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CopyOnWriteArrayList<d> f180653a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public g<?, ?> f180654b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public g<?, ?> f180655c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f180656d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ChainName f180657e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final e f180658f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final j f180659g;

    public final Monitor a() {
        return (Monitor) this.f180656d.getValue();
    }

    public final void b(Throwable r100) {
        Iterator<T> r101 = this.f180653a.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((d) r101.next()).i(r100);
        goto L4
    L6:
        a().i(r100);
    }

    public c(ChainName r100, e r101, com.bytedance.android.shopping.anchorv4.launcher.a r102) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r101, "launchContext");
        Intrinsics.checkNotNullParameter(r102, "input");
        this.f180657e = r100;
        this.f180658f = r101;
        this.f180659g = r102;
        this.f180653a = new CopyOnWriteArrayList();
        this.f180656d = LazyKt.lazy(new LaunchChain$launchMonitor$2(this));
    }
}
