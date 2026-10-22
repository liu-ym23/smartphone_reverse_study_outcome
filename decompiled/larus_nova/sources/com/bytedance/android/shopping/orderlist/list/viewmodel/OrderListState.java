package com.bytedance.android.shopping.orderlist.list.viewmodel;

import com.bytedance.jedi.arch.State;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/shopping/orderlist/list/viewmodel/OrderListState;", "Lcom/bytedance/jedi/arch/State;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class OrderListState implements State {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f180385a;

    public OrderListState() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof OrderListState) == true) goto L6;
        return false;
    L6:
        if (this.f180385a == ((OrderListState) r100).f180385a) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        boolean r100 = this.f180385a;
        if (r100 == false) goto L6;
        return 1;
    L6:
        return r100 ? 1 : 0;
    }

    public final String toString() {
        return "OrderListState(none=" + this.f180385a + ")";
    }

    public OrderListState(int r100) {
        this.f180385a = true;
    }
}
