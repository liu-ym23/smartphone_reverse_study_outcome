package com.bytedance.android.shopping.prepurchase.arch.container.aware;

import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class PageCreateLifecycleDispatcher implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<b> f180718a;

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.aware.b
    public final void a() {
        PageCreateLifecycleDispatcher$onPageCreateFinish$1 r100 = PageCreateLifecycleDispatcher$onPageCreateFinish$1.INSTANCE;
        Iterator<T> r101 = this.f180718a.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        r100.invoke((b) r101.next());
        goto L4
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.aware.b
    public final void b() {
        PageCreateLifecycleDispatcher$onPageCreateStart$1 r100 = PageCreateLifecycleDispatcher$onPageCreateStart$1.INSTANCE;
        Iterator<T> r101 = this.f180718a.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        r100.invoke((b) r101.next());
        goto L4
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PageCreateLifecycleDispatcher(List<? extends b> r100) {
        Intrinsics.checkNotNullParameter(r100, "listeners");
        this.f180718a = r100;
    }
}
