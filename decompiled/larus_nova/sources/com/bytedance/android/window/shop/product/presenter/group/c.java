package com.bytedance.android.window.shop.product.presenter.group;

import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class c implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<d> f189319a;

    @Override // com.bytedance.android.window.shop.product.presenter.group.d
    public final void a() {
        Iterator<T> r100 = this.f189319a.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((d) r100.next()).a();
        goto L4
    }

    /* JADX WARN: Multi-variable type inference failed */
    public c(List<? extends d> r100) {
        Intrinsics.checkNotNullParameter(r100, "children");
        this.f189319a = r100;
    }
}
