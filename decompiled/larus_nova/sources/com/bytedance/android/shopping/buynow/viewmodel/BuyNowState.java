package com.bytedance.android.shopping.buynow.viewmodel;

import com.bytedance.jedi.arch.State;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/shopping/buynow/viewmodel/BuyNowState;", "Lcom/bytedance/jedi/arch/State;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class BuyNowState implements State {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final rg.a<String> f171225a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f171226b;

    public BuyNowState() {
        this(null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof BuyNowState) == false) goto L10;
        BuyNowState r101 = (BuyNowState) r100;
        if (Intrinsics.areEqual(this.f171225a, r101.f171225a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f171226b, r101.f171226b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        rg.a<String> r100 = this.f171225a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f171226b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "BuyNowState(openSchemaAction=" + this.f171225a + ", queryLogID=" + this.f171226b + ")";
    }

    public BuyNowState(Object r100) {
        this.f171225a = null;
        this.f171226b = null;
    }
}
