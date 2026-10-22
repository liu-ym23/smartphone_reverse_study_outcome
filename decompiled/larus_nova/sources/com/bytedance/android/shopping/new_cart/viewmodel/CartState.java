package com.bytedance.android.shopping.new_cart.viewmodel;

import com.bytedance.jedi.arch.State;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/shopping/new_cart/viewmodel/CartState;", "Lcom/bytedance/jedi/arch/State;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CartState implements State {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f179367a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f179368b;

    public CartState() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof CartState) == false) goto L10;
        CartState r101 = (CartState) r100;
        if (this.f179367a == r101.f179367a) goto L8;
        return false;
    L8:
        if (this.f179368b == r101.f179368b) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public final int hashCode() {
        boolean r100 = this.f179367a;
        ?? r101 = r100;
        if (r100 == false) goto L6;
        r101 = 1;
    L6:
        return (r101 * 31) + this.f179368b;
    }

    public final String toString() {
        return "CartState(hasMore=" + this.f179367a + ", fpsValue=" + this.f179368b + ")";
    }

    public /* synthetic */ CartState(int r100) {
        this(true, 0);
    }

    public CartState(boolean r100, int r101) {
        this.f179367a = r100;
        this.f179368b = r101;
    }
}
