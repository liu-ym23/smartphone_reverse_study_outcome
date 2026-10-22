package com.bytedance.android.shopping.prepurchase.arch.container.aware;

import com.bytedance.android.shopping.prepurchase.arch.container.intf.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class d implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final xi.b f180727a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.android.shopping.prepurchase.arch.container.f<?, ?> f180728b;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.aware.b
    public final void a() {
        this.f180727a.d("PageShowLog", "onPageCreateFinish " + this.f180728b.f180775a.f523190b);
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.aware.b
    public final void b() {
        this.f180727a.d("PageShowLog", "onPageCreateStart " + this.f180728b.f180775a.f523190b);
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.aware.e
    public final void onFirstScreen() {
        this.f180727a.d("PageShowLog", "onFirstScreen " + this.f180728b.f180775a.f523190b);
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.aware.e
    public final void onRenderStart() {
        this.f180727a.d("PageShowLog", "onRenderStart " + this.f180728b.f180775a.f523190b);
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.aware.a
    public final void t() {
        this.f180727a.d("PageShowLog", "onQueryStart " + this.f180728b.f180775a.f523190b);
    }

    public d(com.bytedance.android.shopping.prepurchase.arch.container.f<?, ?> r100) {
        Intrinsics.checkNotNullParameter(r100, "pageParam");
        this.f180728b = r100;
        this.f180727a = r100.f180776b;
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.aware.a
    public final void u(k.a r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
        this.f180727a.d("PageShowLog", "onQueryFailed " + r100 + ' ' + this.f180728b.f180775a.f523190b);
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.aware.a
    public final void v(k.d r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
        this.f180727a.d("PageShowLog", "onQuerySuccess " + r100 + ' ' + this.f180728b.f180775a.f523190b);
    }
}
