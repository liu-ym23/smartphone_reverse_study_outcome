package com.bytedance.android.shopping.collect.container;

import com.bytedance.jedi.arch.State;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/shopping/collect/container/CollectYataState;", "Lcom/bytedance/jedi/arch/State;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CollectYataState implements State {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f172145a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final rg.a<d> f172146b;

    public CollectYataState() {
        this(null, null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof CollectYataState) == false) goto L10;
        CollectYataState r101 = (CollectYataState) r100;
        if (Intrinsics.areEqual(this.f172145a, r101.f172145a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f172146b, r101.f172146b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        a r100 = this.f172145a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        rg.a<d> r104 = this.f172146b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "CollectYataState(collectLoadingStatus=" + this.f172145a + ", refreshProtocolAction=" + this.f172146b + ")";
    }

    public CollectYataState(a r100, rg.a<d> r101) {
        this.f172145a = r100;
        this.f172146b = r101;
    }
}
