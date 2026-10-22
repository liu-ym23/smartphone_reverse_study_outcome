package com.bytedance.android.livehostapi.business.castscreen.bean;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0019\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\u0007¢\u0006\u0002\u0010\u000bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0007HÆ\u0003JE\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u00032\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001f\u001a\u00020\u0007HÖ\u0001R\u0011\u0010\n\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\t\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\r¨\u0006 "}, d2 = {"Lcom/bytedance/android/livehostapi/business/castscreen/bean/LiveCastOptionResolutionStrategyInfo;", "", "resolutionStrategyEnabled", "", "resolutionLimit", "", "xsgOnlyResolutionLabelText", "", "xsgGuideResolutionLabelText", "recommendSubtitle", "otherSubtitle", "(ZILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getOtherSubtitle", "()Ljava/lang/String;", "getRecommendSubtitle", "getResolutionLimit", "()I", "getResolutionStrategyEnabled", "()Z", "getXsgGuideResolutionLabelText", "getXsgOnlyResolutionLabelText", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "toString", "hostapp-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveCastOptionResolutionStrategyInfo {
    private final String otherSubtitle;
    private final String recommendSubtitle;
    private final int resolutionLimit;
    private final boolean resolutionStrategyEnabled;
    private final String xsgGuideResolutionLabelText;
    private final String xsgOnlyResolutionLabelText;

    public static /* synthetic */ LiveCastOptionResolutionStrategyInfo copy$default(LiveCastOptionResolutionStrategyInfo r100, boolean r101, int r102, String r103, String r104, String r105, String r110, int r111, Object r112) {
        if ((r111 & 1) == 0) goto L6;
        r101 = r100.resolutionStrategyEnabled;
    L6:
        if ((r111 & 2) == 0) goto L8;
        r102 = r100.resolutionLimit;
    L8:
        int r113 = r102;
        if ((r111 & 4) == 0) goto L11;
        r103 = r100.xsgOnlyResolutionLabelText;
    L11:
        String r106 = r103;
        if ((r111 & 8) == 0) goto L14;
        r104 = r100.xsgGuideResolutionLabelText;
    L14:
        String r107 = r104;
        if ((r111 & 16) == 0) goto L17;
        r105 = r100.recommendSubtitle;
    L17:
        String r108 = r105;
        if ((r111 & 32) == 0) goto L20;
        r110 = r100.otherSubtitle;
    L20:
        boolean r109 = r101;
        return r100.copy(r109, r113, r106, r107, r108, r110);
    }

    public final boolean component1() {
        return this.resolutionStrategyEnabled;
    }

    public final int component2() {
        return this.resolutionLimit;
    }

    public final String component3() {
        return this.xsgOnlyResolutionLabelText;
    }

    public final String component4() {
        return this.xsgGuideResolutionLabelText;
    }

    public final String component5() {
        return this.recommendSubtitle;
    }

    public final String component6() {
        return this.otherSubtitle;
    }

    public final LiveCastOptionResolutionStrategyInfo copy(boolean r100, int r110, String r111, String r112, String r113, String r114) {
        Intrinsics.checkNotNullParameter(r111, "xsgOnlyResolutionLabelText");
        Intrinsics.checkNotNullParameter(r112, "xsgGuideResolutionLabelText");
        Intrinsics.checkNotNullParameter(r113, "recommendSubtitle");
        Intrinsics.checkNotNullParameter(r114, "otherSubtitle");
        return new LiveCastOptionResolutionStrategyInfo(r100, r110, r111, r112, r113, r114);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof LiveCastOptionResolutionStrategyInfo) == false) goto L18;
        LiveCastOptionResolutionStrategyInfo r101 = (LiveCastOptionResolutionStrategyInfo) r100;
        if (this.resolutionStrategyEnabled == r101.resolutionStrategyEnabled) goto L8;
        return false;
    L8:
        if (this.resolutionLimit == r101.resolutionLimit) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.xsgOnlyResolutionLabelText, r101.xsgOnlyResolutionLabelText) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.xsgGuideResolutionLabelText, r101.xsgGuideResolutionLabelText) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.recommendSubtitle, r101.recommendSubtitle) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.otherSubtitle, r101.otherSubtitle) == true) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13 */
    public int hashCode() {
        boolean r100 = this.resolutionStrategyEnabled;
        ?? r101 = r100;
        if (r100 == false) goto L5;
        r101 = 1;
    L5:
        int r102 = ((r101 * 31) + this.resolutionLimit) * 31;
        String r103 = this.xsgOnlyResolutionLabelText;
        int r104 = 0;
        if (r103 == null) goto L8;
        int r105 = r103.hashCode();
    L9:
        int r106 = (r102 + r105) * 31;
        String r107 = this.xsgGuideResolutionLabelText;
        if (r107 == null) goto L12;
        int r108 = r107.hashCode();
    L13:
        int r109 = (r106 + r108) * 31;
        String r110 = this.recommendSubtitle;
        if (r110 == null) goto L16;
        int r111 = r110.hashCode();
    L17:
        int r112 = (r109 + r111) * 31;
        String r113 = this.otherSubtitle;
        if (r113 == null) goto L21;
        r104 = r113.hashCode();
    L21:
        return r112 + r104;
    L16:
        r111 = 0;
        goto L17
    L12:
        r108 = 0;
        goto L13
    L8:
        r105 = 0;
        goto L9
    }

    public String toString() {
        return "LiveCastOptionResolutionStrategyInfo(resolutionStrategyEnabled=" + this.resolutionStrategyEnabled + ", resolutionLimit=" + this.resolutionLimit + ", xsgOnlyResolutionLabelText=" + this.xsgOnlyResolutionLabelText + ", xsgGuideResolutionLabelText=" + this.xsgGuideResolutionLabelText + ", recommendSubtitle=" + this.recommendSubtitle + ", otherSubtitle=" + this.otherSubtitle + ")";
    }

    public final String getOtherSubtitle() {
        return this.otherSubtitle;
    }

    public final String getRecommendSubtitle() {
        return this.recommendSubtitle;
    }

    public final int getResolutionLimit() {
        return this.resolutionLimit;
    }

    public final boolean getResolutionStrategyEnabled() {
        return this.resolutionStrategyEnabled;
    }

    public final String getXsgGuideResolutionLabelText() {
        return this.xsgGuideResolutionLabelText;
    }

    public final String getXsgOnlyResolutionLabelText() {
        return this.xsgOnlyResolutionLabelText;
    }

    public LiveCastOptionResolutionStrategyInfo(boolean r100, int r101, String r102, String r103, String r104, String r105) {
        Intrinsics.checkNotNullParameter(r102, "xsgOnlyResolutionLabelText");
        Intrinsics.checkNotNullParameter(r103, "xsgGuideResolutionLabelText");
        Intrinsics.checkNotNullParameter(r104, "recommendSubtitle");
        Intrinsics.checkNotNullParameter(r105, "otherSubtitle");
        this.resolutionStrategyEnabled = r100;
        this.resolutionLimit = r101;
        this.xsgOnlyResolutionLabelText = r102;
        this.xsgGuideResolutionLabelText = r103;
        this.recommendSubtitle = r104;
        this.otherSubtitle = r105;
    }
}
