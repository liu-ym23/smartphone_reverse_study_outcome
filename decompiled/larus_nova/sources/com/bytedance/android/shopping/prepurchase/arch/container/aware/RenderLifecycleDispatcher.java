package com.bytedance.android.shopping.prepurchase.arch.container.aware;

import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class RenderLifecycleDispatcher implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<e> f180719a;

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.aware.e
    public final void onFirstScreen() {
        AnonymousClass1 r100 = AnonymousClass1.INSTANCE;
        Iterator<T> r101 = this.f180719a.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        r100.invoke((e) r101.next());
        goto L4
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.aware.e
    public final void onRenderStart() {
        C103881 r100 = C103881.INSTANCE;
        Iterator<T> r101 = this.f180719a.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        r100.invoke((e) r101.next());
        goto L4
    }

    /* JADX WARN: Multi-variable type inference failed */
    public RenderLifecycleDispatcher(List<? extends e> r100) {
        Intrinsics.checkNotNullParameter(r100, "listeners");
        this.f180719a = r100;
    }
}
