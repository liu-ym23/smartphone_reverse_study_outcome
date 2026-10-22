package com.bytedance.android.live.liveinteract.revenue.adventure.linkcore;

import io.reactivex.disposables.CompositeDisposable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final long f77925d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CompositeDisposable f77926a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f77927b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final m f77928c;

    public static final class a {
    }

    static {
        f77925d = vm2.d.n().joinTimeoutDuration;
    }

    public b() {
        g r100 = g.f77945l;
        Intrinsics.checkNotNullParameter(r100, "linkService");
        this.f77928c = r100;
        this.f77926a = new CompositeDisposable();
    }
}
