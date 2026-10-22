package com.bytedance.android.shopping.anchorv4.bottom;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\bJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J7\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00052\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/bottom/BottomTipMeta;", "Ljava/io/Serializable;", "tipUrl", "", "displayAsCountDown", "", "countDownTemplate", "trackParamsJStr", "(Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;)V", "getCountDownTemplate", "()Ljava/lang/String;", "getDisplayAsCountDown", "()Z", "getTipUrl", "getTrackParamsJStr", "component1", "component2", "component3", "component4", "copy", "equals", "other", "", "hashCode", "", "toString", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class BottomTipMeta implements Serializable {

    @SerializedName("count_down_template")
    private final String countDownTemplate;

    @SerializedName("display_as_count_down")
    private final boolean displayAsCountDown;

    @SerializedName("tip_url")
    private final String tipUrl;

    @SerializedName("track_params")
    private final String trackParamsJStr;

    public BottomTipMeta() {
        this(null, false, null, null, 15, null);
    }

    public static /* synthetic */ BottomTipMeta copy$default(BottomTipMeta r100, String r101, boolean r102, String r103, String r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.tipUrl;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.displayAsCountDown;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.countDownTemplate;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.trackParamsJStr;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final String component1() {
        return this.tipUrl;
    }

    public final boolean component2() {
        return this.displayAsCountDown;
    }

    public final String component3() {
        return this.countDownTemplate;
    }

    public final String component4() {
        return this.trackParamsJStr;
    }

    public final BottomTipMeta copy(String r100, boolean r101, String r102, String r103) {
        return new BottomTipMeta(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof BottomTipMeta) == false) goto L14;
        BottomTipMeta r101 = (BottomTipMeta) r100;
        if (Intrinsics.areEqual(this.tipUrl, r101.tipUrl) == true) goto L8;
        return false;
    L8:
        if (this.displayAsCountDown == r101.displayAsCountDown) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.countDownTemplate, r101.countDownTemplate) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.trackParamsJStr, r101.trackParamsJStr) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v8 */
    public int hashCode() {
        String r100 = this.tipUrl;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        boolean r104 = this.displayAsCountDown;
        ?? r105 = r104;
        if (r104 == false) goto L9;
        r105 = 1;
    L9:
        int r106 = (r103 + r105) * 31;
        String r107 = this.countDownTemplate;
        if (r107 == null) goto L12;
        int r108 = r107.hashCode();
    L13:
        int r109 = (r106 + r108) * 31;
        String r110 = this.trackParamsJStr;
        if (r110 == null) goto L17;
        r101 = r110.hashCode();
    L17:
        return r109 + r101;
    L12:
        r108 = 0;
        goto L13
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "BottomTipMeta(tipUrl=" + this.tipUrl + ", displayAsCountDown=" + this.displayAsCountDown + ", countDownTemplate=" + this.countDownTemplate + ", trackParamsJStr=" + this.trackParamsJStr + ")";
    }

    public final String getCountDownTemplate() {
        return this.countDownTemplate;
    }

    public final boolean getDisplayAsCountDown() {
        return this.displayAsCountDown;
    }

    public final String getTipUrl() {
        return this.tipUrl;
    }

    public final String getTrackParamsJStr() {
        return this.trackParamsJStr;
    }

    public BottomTipMeta(String r100, boolean r101, String r102, String r103) {
        this.tipUrl = r100;
        this.displayAsCountDown = r101;
        this.countDownTemplate = r102;
        this.trackParamsJStr = r103;
    }

    public /* synthetic */ BottomTipMeta(String r100, boolean r101, String r102, String r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = false;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = null;
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = null;
    L14:
        this(r100, r101, r102, r103);
    }
}
