package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0019\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0002\u0010\tJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000eJ\t\u0010\u0018\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0007HÆ\u0003J8\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0007HÆ\u0001¢\u0006\u0002\u0010\u001bJ\u0013\u0010\u001c\u001a\u00020\u00072\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\n\"\u0004\b\u000b\u0010\fR\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0011\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\b\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\n\"\u0004\b\u0013\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006 "}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftTabData;", "", "title", "", "orderIcon", "", "isSelected", "", "showRedDot", "(Ljava/lang/String;Ljava/lang/Integer;ZZ)V", "()Z", "setSelected", "(Z)V", "getOrderIcon", "()Ljava/lang/Integer;", "setOrderIcon", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getShowRedDot", "setShowRedDot", "getTitle", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/lang/Integer;ZZ)Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftTabData;", "equals", "other", "hashCode", "toString", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GiftTabData {
    private boolean isSelected;
    private Integer orderIcon;
    private boolean showRedDot;
    private final String title;

    public static /* synthetic */ GiftTabData copy$default(GiftTabData r100, String r101, Integer r102, boolean r103, boolean r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.title;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.orderIcon;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.isSelected;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.showRedDot;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final String component1() {
        return this.title;
    }

    public final Integer component2() {
        return this.orderIcon;
    }

    public final boolean component3() {
        return this.isSelected;
    }

    public final boolean component4() {
        return this.showRedDot;
    }

    public final GiftTabData copy(String r100, Integer r101, boolean r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r100, "title");
        return new GiftTabData(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof GiftTabData) == false) goto L14;
        GiftTabData r101 = (GiftTabData) r100;
        if (Intrinsics.areEqual(this.title, r101.title) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.orderIcon, r101.orderIcon) == true) goto L10;
        return false;
    L10:
        if (this.isSelected == r101.isSelected) goto L12;
        return false;
    L12:
        if (this.showRedDot == r101.showRedDot) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v2, types: [int] */
    /* JADX WARN: Type inference failed for: r2v3 */
    public int hashCode() {
        String r100 = this.title;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Integer r104 = this.orderIcon;
        if (r104 == null) goto L9;
        r101 = r104.hashCode();
    L9:
        int r105 = (r103 + r101) * 31;
        boolean r106 = this.isSelected;
        ?? r107 = 1;
        ?? r108 = r106;
        if (r106 == false) goto L12;
        r108 = 1;
    L12:
        int r109 = (r105 + r108) * 31;
        boolean r110 = this.showRedDot;
        if (r110 == true) goto L17;
        r107 = r110;
    L17:
        return r109 + r107;
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "GiftTabData(title=" + this.title + ", orderIcon=" + this.orderIcon + ", isSelected=" + this.isSelected + ", showRedDot=" + this.showRedDot + ")";
    }

    public final Integer getOrderIcon() {
        return this.orderIcon;
    }

    public final boolean getShowRedDot() {
        return this.showRedDot;
    }

    public final String getTitle() {
        return this.title;
    }

    public final boolean isSelected() {
        return this.isSelected;
    }

    public final void setOrderIcon(Integer r100) {
        this.orderIcon = r100;
    }

    public final void setSelected(boolean r100) {
        this.isSelected = r100;
    }

    public final void setShowRedDot(boolean r100) {
        this.showRedDot = r100;
    }

    public GiftTabData(String r100, Integer r101, boolean r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r100, "title");
        this.title = r100;
        this.orderIcon = r101;
        this.isSelected = r102;
        this.showRedDot = r103;
    }

    public /* synthetic */ GiftTabData(String r100, Integer r101, boolean r102, boolean r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 4) == 0) goto L6;
        r102 = false;
    L6:
        if ((r104 & 8) == 0) goto L8;
        r103 = false;
    L8:
        this(r100, r101, r102, r103);
    }
}
