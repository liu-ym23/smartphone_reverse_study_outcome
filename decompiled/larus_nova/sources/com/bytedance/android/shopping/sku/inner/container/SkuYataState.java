package com.bytedance.android.shopping.sku.inner.container;

import com.bytedance.jedi.arch.State;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/shopping/sku/inner/container/SkuYataState;", "Lcom/bytedance/jedi/arch/State;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SkuYataState implements State {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final o f182831a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final rg.a<f0> f182832b;

    public SkuYataState() {
        this(null, null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof SkuYataState) == false) goto L10;
        SkuYataState r101 = (SkuYataState) r100;
        if (Intrinsics.areEqual(this.f182831a, r101.f182831a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f182832b, r101.f182832b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        o r100 = this.f182831a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        rg.a<f0> r104 = this.f182832b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "SkuYataState(skuLoadingStatus=" + this.f182831a + ", refreshProtocolAction=" + this.f182832b + ")";
    }

    public SkuYataState(o r100, rg.a<f0> r101) {
        this.f182831a = r100;
        this.f182832b = r101;
    }
}
