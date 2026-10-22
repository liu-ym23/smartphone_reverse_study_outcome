package br6;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u000e\u001a\u0004\b\u0012\u0010\u0010R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0014\u0010\u0010R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u000e\u001a\u0004\b\u0016\u0010\u0010¨\u0006\u0017"}, d2 = {"Lbr6/b;", "", "Lbr6/d;", "frequency", "Lbr6/d;", "getFrequency", "()Lbr6/d;", "", "maxGuideTimes", "I", "getMaxGuideTimes", "()I", "", "guideText", "Ljava/lang/String;", "getGuideText", "()Ljava/lang/String;", "fullBtnName", "getFullBtnName", "dualBtnName", "getDualBtnName", "confirmText", "getConfirmText", "locallife-groupon-api_release"}, k = 1, mv = {1, 4, 3})
public final class b {

    @SerializedName("confirm_text")
    private final String confirmText;

    @SerializedName("dual_btn_name")
    private final String dualBtnName;

    @SerializedName("frequency")
    private final d frequency;

    @SerializedName("full_btn_name")
    private final String fullBtnName;

    @SerializedName("guide_text")
    private final String guideText;

    @SerializedName("max_guide_times")
    private final int maxGuideTimes;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.frequency, r101.frequency) == true) goto L12;
        return false;
    L12:
        if (this.maxGuideTimes == r101.maxGuideTimes) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.guideText, r101.guideText) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.fullBtnName, r101.fullBtnName) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.dualBtnName, r101.dualBtnName) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.confirmText, r101.confirmText) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.frequency.hashCode() * 31) + this.maxGuideTimes) * 31;
        String r101 = this.guideText;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.fullBtnName;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        String r108 = this.dualBtnName;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        String r111 = this.confirmText;
        if (r111 == null) goto L19;
        r102 = r111.hashCode();
    L19:
        return r110 + r102;
    L13:
        r109 = r108.hashCode();
        goto L14
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "FullSwitchGuideRule(frequency=" + this.frequency + ", maxGuideTimes=" + this.maxGuideTimes + ", guideText=" + this.guideText + ", fullBtnName=" + this.fullBtnName + ", dualBtnName=" + this.dualBtnName + ", confirmText=" + this.confirmText + ')';
    }

    public b() {
        d r100 = new d(0);
        Intrinsics.checkNotNullParameter(r100, "frequency");
        this.frequency = r100;
        this.maxGuideTimes = 0;
        this.guideText = null;
        this.fullBtnName = null;
        this.dualBtnName = null;
        this.confirmText = null;
    }
}
