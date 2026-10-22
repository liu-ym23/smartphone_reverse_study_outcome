package com.bytedance.android.shopping.orderlist.search.viewmodel;

import com.bytedance.jedi.arch.State;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/shopping/orderlist/search/viewmodel/OrderSearchResultState;", "Lcom/bytedance/jedi/arch/State;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class OrderSearchResultState implements State {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f180588a;

    public OrderSearchResultState() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof OrderSearchResultState) == true) goto L6;
        return false;
    L6:
        if (this.f180588a == ((OrderSearchResultState) r100).f180588a) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        boolean r100 = this.f180588a;
        if (r100 == false) goto L6;
        return 1;
    L6:
        return r100 ? 1 : 0;
    }

    public final String toString() {
        return "OrderSearchResultState(none=" + this.f180588a + ")";
    }

    public OrderSearchResultState(int r100) {
        this.f180588a = true;
    }
}
