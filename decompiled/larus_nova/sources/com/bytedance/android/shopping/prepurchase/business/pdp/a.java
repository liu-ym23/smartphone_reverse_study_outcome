package com.bytedance.android.shopping.prepurchase.business.pdp;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class a implements com.bytedance.android.shopping.prepurchase.arch.container.state.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f181035a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f181036b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.bytedance.android.shopping.prepurchase.arch.container.state.d<Float> f181037c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.bytedance.android.shopping.prepurchase.arch.container.state.d<Boolean> f181038d;

    public a() {
        throw null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    public final int hashCode() {
        boolean r100 = this.f181035a;
        ?? r101 = r100;
        if (r100 == false) goto L5;
        r101 = 1;
    L5:
        int r102 = ((r101 * 31) + this.f181036b) * 31;
        com.bytedance.android.shopping.prepurchase.arch.container.state.d<Float> r103 = this.f181037c;
        int r104 = 0;
        if (r103 == null) goto L8;
        int r105 = r103.hashCode();
    L9:
        int r106 = (r102 + r105) * 31;
        com.bytedance.android.shopping.prepurchase.arch.container.state.d<Boolean> r107 = this.f181038d;
        if (r107 == null) goto L13;
        r104 = r107.hashCode();
    L13:
        return r106 + r104;
    L8:
        r105 = 0;
        goto L9
    }

    public final String toString() {
        return "ContainerState(inSplitScreen=" + this.f181035a + ", initialHeight=" + this.f181036b + ", draggableOffset=" + this.f181037c + ", bottomSheetExpended=" + this.f181038d + ")";
    }

    public a(boolean r100) {
        com.bytedance.android.shopping.prepurchase.arch.container.state.d<Float> r101 = new com.bytedance.android.shopping.prepurchase.arch.container.state.d(Float.valueOf(0.0f));
        com.bytedance.android.shopping.prepurchase.arch.container.state.d<Boolean> r102 = new com.bytedance.android.shopping.prepurchase.arch.container.state.d();
        Intrinsics.checkNotNullParameter(r101, "draggableOffset");
        Intrinsics.checkNotNullParameter(r102, "bottomSheetExpended");
        this.f181035a = r100;
        this.f181036b = 0;
        this.f181037c = r101;
        this.f181038d = r102;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L14;
        a r101 = (a) r100;
        if (this.f181035a == r101.f181035a) goto L8;
        return false;
    L8:
        if (this.f181036b == r101.f181036b) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f181037c, r101.f181037c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f181038d, r101.f181038d) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }
}
