package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J'\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0007R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftGroupMostlyUsedInfo;", "", "show", "", "isCurMostlyUsed", "isLoading", "(ZZZ)V", "()Z", "getShow", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GiftGroupMostlyUsedInfo {
    private final boolean isCurMostlyUsed;
    private final boolean isLoading;
    private final boolean show;

    public static /* synthetic */ GiftGroupMostlyUsedInfo copy$default(GiftGroupMostlyUsedInfo r100, boolean r101, boolean r102, boolean r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.show;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.isCurMostlyUsed;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.isLoading;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final boolean component1() {
        return this.show;
    }

    public final boolean component2() {
        return this.isCurMostlyUsed;
    }

    public final boolean component3() {
        return this.isLoading;
    }

    public final GiftGroupMostlyUsedInfo copy(boolean r100, boolean r101, boolean r102) {
        return new GiftGroupMostlyUsedInfo(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof GiftGroupMostlyUsedInfo) == false) goto L12;
        GiftGroupMostlyUsedInfo r101 = (GiftGroupMostlyUsedInfo) r100;
        if (this.show == r101.show) goto L8;
        return false;
    L8:
        if (this.isCurMostlyUsed == r101.isCurMostlyUsed) goto L10;
        return false;
    L10:
        if (this.isLoading == r101.isLoading) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4 */
    public int hashCode() {
        boolean r100 = this.show;
        ?? r101 = 1;
        ?? r102 = r100;
        if (r100 == false) goto L5;
        r102 = 1;
    L5:
        int r103 = r102 * 31;
        boolean r104 = this.isCurMostlyUsed;
        ?? r105 = r104;
        if (r104 == false) goto L8;
        r105 = 1;
    L8:
        int r106 = (r103 + r105) * 31;
        boolean r107 = this.isLoading;
        if (r107 == true) goto L13;
        r101 = r107;
    L13:
        return r106 + r101;
    }

    public String toString() {
        return "GiftGroupMostlyUsedInfo(show=" + this.show + ", isCurMostlyUsed=" + this.isCurMostlyUsed + ", isLoading=" + this.isLoading + ")";
    }

    public final boolean getShow() {
        return this.show;
    }

    public final boolean isCurMostlyUsed() {
        return this.isCurMostlyUsed;
    }

    public final boolean isLoading() {
        return this.isLoading;
    }

    public GiftGroupMostlyUsedInfo(boolean r100, boolean r101, boolean r102) {
        this.show = r100;
        this.isCurMostlyUsed = r101;
        this.isLoading = r102;
    }
}
