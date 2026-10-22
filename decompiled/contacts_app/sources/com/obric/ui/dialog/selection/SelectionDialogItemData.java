package com.obric.ui.dialog.selection;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SelectionDialogAdapter.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0006HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\b\"\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/obric/ui/dialog/selection/SelectionDialogItemData;", "", "title", "", "subTitle", "isChecked", "", "(Ljava/lang/String;Ljava/lang/String;Z)V", "()Z", "setChecked", "(Z)V", "getSubTitle", "()Ljava/lang/String;", "getTitle", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SelectionDialogItemData {
    private boolean isChecked;
    private final String subTitle;
    private final String title;

    public static /* synthetic */ SelectionDialogItemData copy$default(SelectionDialogItemData r0, String r1, String r2, boolean r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.title;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.subTitle;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.isChecked;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final String component1() {
        return this.title;
    }

    public final String component2() {
        return this.subTitle;
    }

    public final boolean component3() {
        return this.isChecked;
    }

    public final SelectionDialogItemData copy(String r1, String r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r1, "title");
        Intrinsics.checkNotNullParameter(r2, "subTitle");
        return new SelectionDialogItemData(r1, r2, r3);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof SelectionDialogItemData) == true) goto L8;
        return false;
    L8:
        SelectionDialogItemData r6 = (SelectionDialogItemData) r5;
        if (Intrinsics.areEqual(this.title, r6.title) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.subTitle, r6.subTitle) == true) goto L15;
        return false;
    L15:
        if (this.isChecked == r6.isChecked) goto L17;
        return false;
    L17:
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2, types: [int] */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4 */
    public int hashCode() {
        int r0 = ((this.title.hashCode() * 31) + this.subTitle.hashCode()) * 31;
        boolean r2 = this.isChecked;
        ?? r3 = r2;
        if (r2 == false) goto L6;
        r3 = 1;
    L6:
        return r0 + r3;
    }

    public String toString() {
        return "SelectionDialogItemData(title=" + this.title + ", subTitle=" + this.subTitle + ", isChecked=" + this.isChecked + ')';
    }

    public SelectionDialogItemData(String r2, String r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "title");
        Intrinsics.checkNotNullParameter(r3, "subTitle");
        this.title = r2;
        this.subTitle = r3;
        this.isChecked = r4;
    }

    public /* synthetic */ SelectionDialogItemData(String r1, String r2, boolean r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = false;
    L5:
        this(r1, r2, r3);
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getSubTitle() {
        return this.subTitle;
    }

    public final boolean isChecked() {
        return this.isChecked;
    }

    public final void setChecked(boolean r1) {
        this.isChecked = r1;
    }
}
