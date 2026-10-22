package com.bytedance.android.shopping.prepurchase.arch.container.state;

import androidx.lifecycle.Observer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class b<T> implements Observer<T> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Object f180834e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f180835a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f180836b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final i<T> f180837c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final g<? super T> f180838d;

    public static final class a {
    }

    static {
        f180834e = new Object();
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(T r100) {
        boolean r101 = true;
        if (this.f180837c.f180839a == true) goto L5;
    L8:
        Object r102 = this.f180836b;
        if (Intrinsics.areEqual(r102, f180834e) == true) goto L14;
        this.f180837c.f180840b.getClass();
        if (Intrinsics.areEqual(r102, r100) == false) goto L14;
        r101 = false;
    L14:
        if (r101 == false) goto L17;
        this.f180836b = r100;
        this.f180838d.onChanged(r100);
        return;
    L17:
        return;
    L5:
        if (this.f180835a == true) goto L8;
        this.f180835a = true;
    }

    public b(i<T> r100, g<? super T> r101) {
        Intrinsics.checkNotNullParameter(r100, "config");
        Intrinsics.checkNotNullParameter(r101, "block");
        this.f180837c = r100;
        this.f180838d = r101;
        this.f180836b = f180834e;
    }
}
