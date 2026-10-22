package com.bytedance.android.ec.model.sku;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ul.f;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\n\u001a\u00020\u0006¢\u0006\u0004\b\u001b\u0010\u001cJ\t\u0010\u0003\u001a\u00020\u0002HÆ\u0003J\u000b\u0010\u0005\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\t\u0010\u0007\u001a\u00020\u0006HÆ\u0003J)\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\n\u001a\u00020\u0006HÆ\u0001J\t\u0010\r\u001a\u00020\fHÖ\u0001J\t\u0010\u000f\u001a\u00020\u000eHÖ\u0001J\u0013\u0010\u0012\u001a\u00020\u00022\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÖ\u0003R\u0017\u0010\b\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\b\u0010\u0013\u001a\u0004\b\b\u0010\u0014R\u0019\u0010\t\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\t\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\n\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\n\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/ec/model/sku/SkuShowAndDismissState;", "Ljava/io/Serializable;", "", "component1", "Lcom/bytedance/android/ec/model/sku/SkuRestoreState;", "component2", "Lul/f;", "component3", "isShow", "restoreState", "pageState", "copy", "", "toString", "", "hashCode", "", "other", "equals", "Z", "()Z", "Lcom/bytedance/android/ec/model/sku/SkuRestoreState;", "getRestoreState", "()Lcom/bytedance/android/ec/model/sku/SkuRestoreState;", "Lul/f;", "getPageState", "()Lul/f;", "<init>", "(ZLcom/bytedance/android/ec/model/sku/SkuRestoreState;Lul/f;)V", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class SkuShowAndDismissState implements Serializable {
    private final boolean isShow;
    private final f pageState;
    private final SkuRestoreState restoreState;

    public static /* synthetic */ SkuShowAndDismissState copy$default(SkuShowAndDismissState r100, boolean r101, SkuRestoreState r102, f r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.isShow;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.restoreState;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.pageState;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final boolean component1() {
        return this.isShow;
    }

    public final SkuRestoreState component2() {
        return this.restoreState;
    }

    public final f component3() {
        return this.pageState;
    }

    public final SkuShowAndDismissState copy(boolean r100, SkuRestoreState r101, f r102) {
        Intrinsics.checkNotNullParameter(r102, "pageState");
        return new SkuShowAndDismissState(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof SkuShowAndDismissState) == false) goto L12;
        SkuShowAndDismissState r101 = (SkuShowAndDismissState) r100;
        if (this.isShow == r101.isShow) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.restoreState, r101.restoreState) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.pageState, r101.pageState) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    public int hashCode() {
        boolean r100 = this.isShow;
        ?? r101 = r100;
        if (r100 == false) goto L5;
        r101 = 1;
    L5:
        int r102 = r101 * 31;
        SkuRestoreState r103 = this.restoreState;
        int r104 = 0;
        if (r103 == null) goto L8;
        int r105 = r103.hashCode();
    L9:
        int r106 = (r102 + r105) * 31;
        f r107 = this.pageState;
        if (r107 == null) goto L13;
        r104 = r107.hashCode();
    L13:
        return r106 + r104;
    L8:
        r105 = 0;
        goto L9
    }

    public String toString() {
        return "SkuShowAndDismissState(isShow=" + this.isShow + ", restoreState=" + this.restoreState + ", pageState=" + this.pageState + ")";
    }

    public final f getPageState() {
        return this.pageState;
    }

    public final SkuRestoreState getRestoreState() {
        return this.restoreState;
    }

    public final boolean isShow() {
        return this.isShow;
    }

    public SkuShowAndDismissState(boolean r100, SkuRestoreState r101, f r102) {
        Intrinsics.checkNotNullParameter(r102, "pageState");
        this.isShow = r100;
        this.restoreState = r101;
        this.pageState = r102;
    }
}
