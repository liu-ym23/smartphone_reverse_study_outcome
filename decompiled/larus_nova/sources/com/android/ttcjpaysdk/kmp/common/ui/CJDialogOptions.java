package com.android.ttcjpaysdk.kmp.common.ui;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b1\b\u0087\b\u0018\u00002\u00020\u0001B\u0083\u0001\b\u0007\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\u0013\u0010\u0014J\t\u00102\u001a\u00020\u0003HÆ\u0003J\t\u00103\u001a\u00020\u0005HÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0010\u00106\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010#J\u0011\u00107\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bHÆ\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\u000b\u00109\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0010\u0010:\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0002\u0010.J\u0010\u0010;\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0002\u0010.J\u0088\u0001\u0010<\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0011HÆ\u0001¢\u0006\u0002\u0010=J\u0013\u0010>\u001a\u00020\u00032\b\u0010?\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010@\u001a\u00020\u0005HÖ\u0001J\t\u0010A\u001a\u00020\u0007HÖ\u0001R\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0019\u0010\u0016\u001a\u0004\b\u001a\u0010\u001bR\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001c\u0010\u0016\u001a\u0004\b\u001d\u0010\u001eR\u001e\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001f\u0010\u0016\u001a\u0004\b \u0010\u001eR \u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010$\u0012\u0004\b!\u0010\u0016\u001a\u0004\b\"\u0010#R$\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b%\u0010\u0016\u001a\u0004\b&\u0010'R\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u001e\u0010\u000f\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b*\u0010\u0016\u001a\u0004\b+\u0010\u001eR \u0010\u0010\u001a\u0004\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010/\u0012\u0004\b,\u0010\u0016\u001a\u0004\b-\u0010.R \u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010/\u0012\u0004\b0\u0010\u0016\u001a\u0004\b1\u0010.¨\u0006B"}, d2 = {"Lcom/android/ttcjpaysdk/kmp/common/ui/CJDialogOptions;", "", "showClose", "", "buttonType", "", "mainTitle", "", "subTitle", "subTitleAlignStart", "buttonInfos", "", "Lcom/android/ttcjpaysdk/kmp/common/ui/CJDialogButtonOptions;", "closeListener", "Lcom/android/ttcjpaysdk/kmp/common/ui/CJDialogButtonEventListener;", "headerIconUrl", "headerIconWidth", "", "headerIconHeight", "<init>", "(ZILjava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/util/List;Lcom/android/ttcjpaysdk/kmp/common/ui/CJDialogButtonEventListener;Ljava/lang/String;Ljava/lang/Float;Ljava/lang/Float;)V", "getShowClose$annotations", "()V", "getShowClose", "()Z", "getButtonType$annotations", "getButtonType", "()I", "getMainTitle$annotations", "getMainTitle", "()Ljava/lang/String;", "getSubTitle$annotations", "getSubTitle", "getSubTitleAlignStart$annotations", "getSubTitleAlignStart", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getButtonInfos$annotations", "getButtonInfos", "()Ljava/util/List;", "getCloseListener", "()Lcom/android/ttcjpaysdk/kmp/common/ui/CJDialogButtonEventListener;", "getHeaderIconUrl$annotations", "getHeaderIconUrl", "getHeaderIconWidth$annotations", "getHeaderIconWidth", "()Ljava/lang/Float;", "Ljava/lang/Float;", "getHeaderIconHeight$annotations", "getHeaderIconHeight", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "(ZILjava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/util/List;Lcom/android/ttcjpaysdk/kmp/common/ui/CJDialogButtonEventListener;Ljava/lang/String;Ljava/lang/Float;Ljava/lang/Float;)Lcom/android/ttcjpaysdk/kmp/common/ui/CJDialogOptions;", "equals", "other", "hashCode", "toString", "cj_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CJDialogOptions {
    public static final int $stable = 8;
    private final List<CJDialogButtonOptions> buttonInfos;
    private final int buttonType;
    private final CJDialogButtonEventListener closeListener;
    private final Float headerIconHeight;
    private final String headerIconUrl;
    private final Float headerIconWidth;
    private final String mainTitle;
    private final boolean showClose;
    private final String subTitle;
    private final Boolean subTitleAlignStart;

    public CJDialogOptions() {
        this(false, 0, null, null, null, null, null, null, null, null, 1023, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CJDialogOptions copy$default(CJDialogOptions r110, boolean r111, int r112, String r113, String r114, Boolean r115, List r116, CJDialogButtonEventListener r117, String r118, Float r210, Float r211, int r212, Object r213) {
        if ((r212 & 1) == 0) goto L5;
        boolean r100 = r110.showClose;
    L7:
        if ((r212 & 2) == 0) goto L9;
        int r101 = r110.buttonType;
    L11:
        if ((r212 & 4) == 0) goto L13;
        String r102 = r110.mainTitle;
    L15:
        if ((r212 & 8) == 0) goto L17;
        String r103 = r110.subTitle;
    L19:
        if ((r212 & 16) == 0) goto L21;
        Boolean r104 = r110.subTitleAlignStart;
    L23:
        if ((r212 & 32) == 0) goto L25;
        List r105 = r110.buttonInfos;
    L27:
        if ((r212 & 64) == 0) goto L29;
        CJDialogButtonEventListener r106 = r110.closeListener;
    L31:
        if ((r212 & 128) == 0) goto L33;
        String r107 = r110.headerIconUrl;
    L35:
        if ((r212 & 256) == 0) goto L37;
        Float r119 = r110.headerIconWidth;
    L39:
        if ((r212 & 512) == 0) goto L41;
        Float r108 = r110.headerIconHeight;
    L43:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r119, r108);
    L41:
        r108 = r211;
        goto L43
    L37:
        r119 = r210;
        goto L39
    L33:
        r107 = r118;
        goto L35
    L29:
        r106 = r117;
        goto L31
    L25:
        r105 = r116;
        goto L27
    L21:
        r104 = r115;
        goto L23
    L17:
        r103 = r114;
        goto L19
    L13:
        r102 = r113;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    public static /* synthetic */ void getButtonInfos$annotations() {
    }

    public static /* synthetic */ void getButtonType$annotations() {
    }

    public static /* synthetic */ void getHeaderIconHeight$annotations() {
    }

    public static /* synthetic */ void getHeaderIconUrl$annotations() {
    }

    public static /* synthetic */ void getHeaderIconWidth$annotations() {
    }

    public static /* synthetic */ void getMainTitle$annotations() {
    }

    public static /* synthetic */ void getShowClose$annotations() {
    }

    public static /* synthetic */ void getSubTitle$annotations() {
    }

    public static /* synthetic */ void getSubTitleAlignStart$annotations() {
    }

    public final boolean component1() {
        return this.showClose;
    }

    public final Float component10() {
        return this.headerIconHeight;
    }

    public final int component2() {
        return this.buttonType;
    }

    public final String component3() {
        return this.mainTitle;
    }

    public final String component4() {
        return this.subTitle;
    }

    public final Boolean component5() {
        return this.subTitleAlignStart;
    }

    public final List<CJDialogButtonOptions> component6() {
        return this.buttonInfos;
    }

    public final CJDialogButtonEventListener component7() {
        return this.closeListener;
    }

    public final String component8() {
        return this.headerIconUrl;
    }

    public final Float component9() {
        return this.headerIconWidth;
    }

    public final CJDialogOptions copy(boolean r110, int r111, String r112, String r113, Boolean r114, List<CJDialogButtonOptions> r115, CJDialogButtonEventListener r116, String r210, Float r211, Float r212) {
        return new CJDialogOptions(r110, r111, r112, r113, r114, r115, r116, r210, r211, r212);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof CJDialogOptions) == true) goto L8;
        return false;
    L8:
        CJDialogOptions r101 = (CJDialogOptions) r100;
        if (this.showClose == r101.showClose) goto L12;
        return false;
    L12:
        if (this.buttonType == r101.buttonType) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.mainTitle, r101.mainTitle) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.subTitle, r101.subTitle) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.subTitleAlignStart, r101.subTitleAlignStart) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.buttonInfos, r101.buttonInfos) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.closeListener, r101.closeListener) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.headerIconUrl, r101.headerIconUrl) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.headerIconWidth, r101.headerIconWidth) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.headerIconHeight, r101.headerIconHeight) == true) goto L38;
        return false;
    L38:
        return true;
    }

    public int hashCode() {
        if (this.showClose == false) goto L5;
        int r100 = 1231;
    L6:
        int r101 = ((r100 * 31) + this.buttonType) * 31;
        String r102 = this.mainTitle;
        int r103 = 0;
        if (r102 != null) goto L9;
        int r104 = 0;
    L10:
        int r105 = (r101 + r104) * 31;
        String r106 = this.subTitle;
        if (r106 != null) goto L13;
        int r107 = 0;
    L14:
        int r108 = (r105 + r107) * 31;
        Boolean r109 = this.subTitleAlignStart;
        if (r109 != null) goto L17;
        int r110 = 0;
    L18:
        int r111 = (r108 + r110) * 31;
        List<CJDialogButtonOptions> r112 = this.buttonInfos;
        if (r112 != null) goto L21;
        int r113 = 0;
    L22:
        int r114 = (r111 + r113) * 31;
        CJDialogButtonEventListener r115 = this.closeListener;
        if (r115 != null) goto L25;
        int r116 = 0;
    L26:
        int r117 = (r114 + r116) * 31;
        String r118 = this.headerIconUrl;
        if (r118 != null) goto L29;
        int r119 = 0;
    L30:
        int r120 = (r117 + r119) * 31;
        Float r121 = this.headerIconWidth;
        if (r121 != null) goto L33;
        int r122 = 0;
    L34:
        int r123 = (r120 + r122) * 31;
        Float r124 = this.headerIconHeight;
        if (r124 == null) goto L39;
        r103 = r124.hashCode();
    L39:
        return r123 + r103;
    L33:
        r122 = r121.hashCode();
        goto L34
    L29:
        r119 = r118.hashCode();
        goto L30
    L25:
        r116 = r115.hashCode();
        goto L26
    L21:
        r113 = r112.hashCode();
        goto L22
    L17:
        r110 = r109.hashCode();
        goto L18
    L13:
        r107 = r106.hashCode();
        goto L14
    L9:
        r104 = r102.hashCode();
        goto L10
    L5:
        r100 = 1237;
        goto L6
    }

    public String toString() {
        return "CJDialogOptions(showClose=" + this.showClose + ", buttonType=" + this.buttonType + ", mainTitle=" + this.mainTitle + ", subTitle=" + this.subTitle + ", subTitleAlignStart=" + this.subTitleAlignStart + ", buttonInfos=" + this.buttonInfos + ", closeListener=" + this.closeListener + ", headerIconUrl=" + this.headerIconUrl + ", headerIconWidth=" + this.headerIconWidth + ", headerIconHeight=" + this.headerIconHeight + ')';
    }

    public final List<CJDialogButtonOptions> getButtonInfos() {
        return this.buttonInfos;
    }

    public final int getButtonType() {
        return this.buttonType;
    }

    public final CJDialogButtonEventListener getCloseListener() {
        return this.closeListener;
    }

    public final Float getHeaderIconHeight() {
        return this.headerIconHeight;
    }

    public final String getHeaderIconUrl() {
        return this.headerIconUrl;
    }

    public final Float getHeaderIconWidth() {
        return this.headerIconWidth;
    }

    public final String getMainTitle() {
        return this.mainTitle;
    }

    public final boolean getShowClose() {
        return this.showClose;
    }

    public final String getSubTitle() {
        return this.subTitle;
    }

    public final Boolean getSubTitleAlignStart() {
        return this.subTitleAlignStart;
    }

    public CJDialogOptions(boolean r100, int r101, String r102, String r103, Boolean r104, List<CJDialogButtonOptions> r105, CJDialogButtonEventListener r106, String r107, Float r108, Float r110) {
        this.showClose = r100;
        this.buttonType = r101;
        this.mainTitle = r102;
        this.subTitle = r103;
        this.subTitleAlignStart = r104;
        this.buttonInfos = r105;
        this.closeListener = r106;
        this.headerIconUrl = r107;
        this.headerIconWidth = r108;
        this.headerIconHeight = r110;
    }

    public /* synthetic */ CJDialogOptions(boolean r110, int r111, String r112, String r113, Boolean r114, List r115, CJDialogButtonEventListener r116, String r117, Float r210, Float r211, int r212, DefaultConstructorMarker r213) {
        int r100 = 0;
        if ((r212 & 1) == 0) goto L5;
        boolean r101 = false;
    L7:
        if ((r212 & 2) != 0) goto L10;
        r100 = r111;
    L10:
        Float r102 = null;
        if ((r212 & 4) == 0) goto L13;
        String r103 = null;
    L15:
        if ((r212 & 8) == 0) goto L17;
        String r104 = null;
    L19:
        if ((r212 & 16) == 0) goto L21;
        Boolean r105 = Boolean.FALSE;
    L23:
        if ((r212 & 32) == 0) goto L25;
        List r106 = null;
    L27:
        if ((r212 & 64) == 0) goto L29;
        CJDialogButtonEventListener r107 = null;
    L31:
        if ((r212 & 128) == 0) goto L33;
        String r108 = null;
    L35:
        if ((r212 & 256) == 0) goto L37;
        Float r118 = null;
    L39:
        if ((r212 & 512) != 0) goto L42;
        r102 = r211;
    L42:
        this(r101, r100, r103, r104, r105, r106, r107, r108, r118, r102);
        return;
    L37:
        r118 = r210;
        goto L39
    L33:
        r108 = r117;
        goto L35
    L29:
        r107 = r116;
        goto L31
    L25:
        r106 = r115;
        goto L27
    L21:
        r105 = r114;
        goto L23
    L17:
        r104 = r113;
        goto L19
    L13:
        r103 = r112;
        goto L15
    L5:
        r101 = r110;
        goto L7
    }
}
