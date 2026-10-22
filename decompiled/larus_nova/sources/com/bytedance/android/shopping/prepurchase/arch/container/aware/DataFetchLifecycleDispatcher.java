package com.bytedance.android.shopping.prepurchase.arch.container.aware;

import com.bytedance.android.shopping.prepurchase.arch.container.intf.k;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class DataFetchLifecycleDispatcher implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<a> f180717a;

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.aware.a
    public final void t() {
        a(DataFetchLifecycleDispatcher$onQueryStart$1.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DataFetchLifecycleDispatcher(List<? extends a> r100) {
        Intrinsics.checkNotNullParameter(r100, "listeners");
        this.f180717a = r100;
    }

    public final void a(Function1<? super a, Unit> r100) {
        Iterator<T> r101 = this.f180717a.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        r100.invoke((a) r101.next());
        goto L4
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.aware.a
    public final void u(final k.a r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
        a(new DataFetchLifecycleDispatcher$onQueryFailed$1(r100));
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.aware.a
    public final void v(final k.d r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
        a(new DataFetchLifecycleDispatcher$onQuerySuccess$1(r100));
    }
}
