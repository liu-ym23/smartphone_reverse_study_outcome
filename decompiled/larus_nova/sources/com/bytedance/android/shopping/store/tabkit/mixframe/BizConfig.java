package com.bytedance.android.shopping.store.tabkit.mixframe;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00032\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0005HÖ\u0001R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/shopping/store/tabkit/mixframe/BizConfig;", "Ljava/io/Serializable;", "canRefresh", "", "NoMoreText", "", "(ZLjava/lang/String;)V", "getNoMoreText", "()Ljava/lang/String;", "setNoMoreText", "(Ljava/lang/String;)V", "getCanRefresh", "()Z", "setCanRefresh", "(Z)V", "component1", "component2", "copy", "equals", "other", "", "hashCode", "", "toString", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class BizConfig implements Serializable {

    @SerializedName("no_more_text")
    private String NoMoreText;

    @SerializedName("can_refresh")
    private boolean canRefresh;

    /* JADX WARN: Multi-variable type inference failed */
    public BizConfig() {
        boolean r100 = false;
        this(r100, null, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ BizConfig copy$default(BizConfig r100, boolean r101, String r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.canRefresh;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.NoMoreText;
    L9:
        return r100.copy(r101, r102);
    }

    public final boolean component1() {
        return this.canRefresh;
    }

    public final String component2() {
        return this.NoMoreText;
    }

    public final BizConfig copy(boolean r100, String r101) {
        return new BizConfig(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof BizConfig) == false) goto L10;
        BizConfig r101 = (BizConfig) r100;
        if (this.canRefresh == r101.canRefresh) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.NoMoreText, r101.NoMoreText) == true) goto L16;
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
    public int hashCode() {
        boolean r100 = this.canRefresh;
        ?? r101 = r100;
        if (r100 == false) goto L5;
        r101 = 1;
    L5:
        int r102 = r101 * 31;
        String r103 = this.NoMoreText;
        if (r103 == null) goto L8;
        int r104 = r103.hashCode();
    L10:
        return r102 + r104;
    L8:
        r104 = 0;
        goto L10
    }

    public String toString() {
        return "BizConfig(canRefresh=" + this.canRefresh + ", NoMoreText=" + this.NoMoreText + ")";
    }

    public final boolean getCanRefresh() {
        return this.canRefresh;
    }

    public final String getNoMoreText() {
        return this.NoMoreText;
    }

    public final void setCanRefresh(boolean r100) {
        this.canRefresh = r100;
    }

    public final void setNoMoreText(String r100) {
        this.NoMoreText = r100;
    }

    public BizConfig(boolean r100, String r101) {
        this.canRefresh = r100;
        this.NoMoreText = r101;
    }

    public /* synthetic */ BizConfig(boolean r100, String r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = false;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = "没有更多了～";
    L8:
        this(r100, r101);
    }
}
