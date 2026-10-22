package com.bytedance.android.shopping.prepurchase.business.pdp.repository;

import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class b implements com.bytedance.android.shopping.prepurchase.arch.container.aware.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicBoolean f181920a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.android.shopping.prepurchase.arch.container.aware.a f181921b;

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.aware.a
    public final void t() {
        if (this.f181920a.compareAndSet(false, true) == false) goto L6;
        this.f181921b.t();
        return;
    }

    public b(com.bytedance.android.shopping.prepurchase.arch.container.aware.a r100) {
        Intrinsics.checkNotNullParameter(r100, "contentQueryListener");
        this.f181921b = r100;
        this.f181920a = new AtomicBoolean(false);
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.aware.a
    public final void u(com.bytedance.android.shopping.prepurchase.arch.container.intf.k.a r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
        if (this.f181920a.compareAndSet(true, false) == false) goto L6;
        this.f181921b.u(r100);
        return;
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.aware.a
    public final void v(com.bytedance.android.shopping.prepurchase.arch.container.intf.k.d r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
        if (this.f181920a.compareAndSet(true, false) == false) goto L6;
        this.f181921b.v(r100);
        return;
    }
}
