package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/SelectGiftHonorData;", "", "selectedText", "", "showScore", "", "(Ljava/lang/String;J)V", "getSelectedText", "()Ljava/lang/String;", "getShowScore", "()J", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SelectGiftHonorData {
    private final String selectedText;
    private final long showScore;

    public SelectGiftHonorData() {
        this(null, 0, 3, null);
    }

    public static /* synthetic */ SelectGiftHonorData copy$default(SelectGiftHonorData r100, String r101, long r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.selectedText;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.showScore;
    L9:
        return r100.copy(r101, r102);
    }

    public final String component1() {
        return this.selectedText;
    }

    public final long component2() {
        return this.showScore;
    }

    public final SelectGiftHonorData copy(String r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "selectedText");
        return new SelectGiftHonorData(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof SelectGiftHonorData) == false) goto L10;
        SelectGiftHonorData r101 = (SelectGiftHonorData) r100;
        if (Intrinsics.areEqual(this.selectedText, r101.selectedText) == true) goto L8;
        return false;
    L8:
        if (this.showScore == r101.showScore) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public int hashCode() {
        String r100 = this.selectedText;
        if (r100 == null) goto L5;
        int r101 = r100.hashCode();
    L6:
        long r102 = this.showScore;
        return (r101 * 31) + ((int) (r102 ^ (r102 >>> 32)));
    L5:
        r101 = 0;
        goto L6
    }

    public String toString() {
        return "SelectGiftHonorData(selectedText=" + this.selectedText + ", showScore=" + this.showScore + ")";
    }

    public final String getSelectedText() {
        return this.selectedText;
    }

    public final long getShowScore() {
        return this.showScore;
    }

    public SelectGiftHonorData(String r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "selectedText");
        this.selectedText = r100;
        this.showScore = r101;
    }

    public /* synthetic */ SelectGiftHonorData(String r100, long r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = "";
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = 0;
    L8:
        this(r100, r101);
    }
}
