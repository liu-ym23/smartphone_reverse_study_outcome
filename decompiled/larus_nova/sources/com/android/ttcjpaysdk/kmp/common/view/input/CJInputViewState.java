package com.android.ttcjpaysdk.kmp.common.view.input;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\bU\b\u0087\b\u0018\u00002\u00020\u0001B¿\u0002\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010 \u001a\u00020\u0003\u0012\b\b\u0002\u0010!\u001a\u00020\u000e¢\u0006\u0004\b\"\u0010#J\u000b\u0010C\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010D\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010E\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006HÆ\u0003J\t\u0010F\u001a\u00020\tHÆ\u0003J\u000b\u0010G\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010H\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010I\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010J\u001a\u00020\u000eHÆ\u0003J\t\u0010K\u001a\u00020\u000eHÆ\u0003J\u000b\u0010L\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010M\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010N\u001a\u00020\u0003HÆ\u0003J\t\u0010O\u001a\u00020\u000eHÆ\u0003J\u000b\u0010P\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010Q\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010R\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010S\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010T\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010U\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010V\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010W\u001a\u00020\u000eHÆ\u0003J\t\u0010X\u001a\u00020\u000eHÆ\u0003J\u000b\u0010Y\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010Z\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010[\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\\\u001a\u00020\u0003HÆ\u0003J\t\u0010]\u001a\u00020\u000eHÆ\u0003JÁ\u0002\u0010^\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u000e2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u001b\u001a\u00020\u000e2\b\b\u0002\u0010\u001c\u001a\u00020\u000e2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010 \u001a\u00020\u00032\b\b\u0002\u0010!\u001a\u00020\u000eHÆ\u0001J\u0013\u0010_\u001a\u00020\u000e2\b\u0010`\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010a\u001a\u00020\tHÖ\u0001J\t\u0010b\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b&\u0010%R\u0019\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b+\u0010%R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b,\u0010%R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b-\u0010%R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u0011\u0010\u000f\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b0\u0010/R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b1\u0010%R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b2\u0010%R\u0011\u0010\u0012\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b3\u0010%R\u0011\u0010\u0013\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b4\u0010/R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b5\u0010%R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b6\u0010%R\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b7\u0010%R\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b8\u0010%R\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b9\u0010%R\u0013\u0010\u0019\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b:\u0010%R\u0013\u0010\u001a\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b;\u0010%R\u0011\u0010\u001b\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b<\u0010/R\u0011\u0010\u001c\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b=\u0010/R\u0013\u0010\u001d\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b>\u0010%R\u0013\u0010\u001e\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b?\u0010%R\u0013\u0010\u001f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b@\u0010%R\u0011\u0010 \u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bA\u0010%R\u0011\u0010!\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\bB\u0010/¨\u0006c"}, d2 = {"Lcom/android/ttcjpaysdk/kmp/common/view/input/CJInputViewState;", "", "leftIconUrl", "", "leftTitle", "leftListTitle", "", "Lcom/android/ttcjpaysdk/kmp/common/view/input/CJInputListItem;", "leftListDefaultIndex", "", "rightHintIconUrl", "rightHintText", "rightHintTips", "rightHintDot", "", "rightArrowVisible", "inputLeftIconUrl", "inputEditHint", "inputEditText", "inputEditable", "inputRightIconUrl", "inputRightIconText", "inputRightButtonText", "inputTips", "selectHintText", "selectText", "selectTips", "selectEditable", "showLeftAmount", "amountTips", "amountFlag", "amountEditHint", "amountEditText", "showBottomLine", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "getLeftIconUrl", "()Ljava/lang/String;", "getLeftTitle", "getLeftListTitle", "()Ljava/util/List;", "getLeftListDefaultIndex", "()I", "getRightHintIconUrl", "getRightHintText", "getRightHintTips", "getRightHintDot", "()Z", "getRightArrowVisible", "getInputLeftIconUrl", "getInputEditHint", "getInputEditText", "getInputEditable", "getInputRightIconUrl", "getInputRightIconText", "getInputRightButtonText", "getInputTips", "getSelectHintText", "getSelectText", "getSelectTips", "getSelectEditable", "getShowLeftAmount", "getAmountTips", "getAmountFlag", "getAmountEditHint", "getAmountEditText", "getShowBottomLine", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "copy", "equals", "other", "hashCode", "toString", "cj_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CJInputViewState {
    public static final int $stable = 8;
    private final String amountEditHint;
    private final String amountEditText;
    private final String amountFlag;
    private final String amountTips;
    private final String inputEditHint;
    private final String inputEditText;
    private final boolean inputEditable;
    private final String inputLeftIconUrl;
    private final String inputRightButtonText;
    private final String inputRightIconText;
    private final String inputRightIconUrl;
    private final String inputTips;
    private final String leftIconUrl;
    private final int leftListDefaultIndex;
    private final List<CJInputListItem> leftListTitle;
    private final String leftTitle;
    private final boolean rightArrowVisible;
    private final boolean rightHintDot;
    private final String rightHintIconUrl;
    private final String rightHintText;
    private final String rightHintTips;
    private final boolean selectEditable;
    private final String selectHintText;
    private final String selectText;
    private final String selectTips;
    private final boolean showBottomLine;
    private final boolean showLeftAmount;

    public CJInputViewState() {
        this(null, null, null, 0, null, null, null, false, false, null, null, null, false, null, null, null, null, null, null, null, false, false, null, null, null, null, false, 134217727, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CJInputViewState copy$default(CJInputViewState r110, String r111, String r112, List r210, int r211, String r212, String r213, String r214, boolean r215, boolean r216, String r217, String r218, String r219, boolean r310, String r311, String r312, String r313, String r314, String r315, String r316, String r317, boolean r318, boolean r319, String r410, String r411, String r412, String r413, boolean r414, int r415, Object r416) {
        if ((r415 & 1) == 0) goto L5;
        String r100 = r110.leftIconUrl;
    L7:
        if ((r415 & 2) == 0) goto L9;
        String r101 = r110.leftTitle;
    L11:
        if ((r415 & 4) == 0) goto L13;
        List r102 = r110.leftListTitle;
    L15:
        if ((r415 & 8) == 0) goto L17;
        int r103 = r110.leftListDefaultIndex;
    L19:
        if ((r415 & 16) == 0) goto L21;
        String r104 = r110.rightHintIconUrl;
    L23:
        if ((r415 & 32) == 0) goto L25;
        String r105 = r110.rightHintText;
    L27:
        if ((r415 & 64) == 0) goto L29;
        String r106 = r110.rightHintTips;
    L31:
        if ((r415 & 128) == 0) goto L33;
        boolean r107 = r110.rightHintDot;
    L35:
        if ((r415 & 256) == 0) goto L37;
        boolean r113 = r110.rightArrowVisible;
    L39:
        if ((r415 & 512) == 0) goto L41;
        String r114 = r110.inputLeftIconUrl;
    L43:
        if ((r415 & 1024) == 0) goto L45;
        String r115 = r110.inputEditHint;
    L47:
        if ((r415 & 2048) == 0) goto L49;
        String r116 = r110.inputEditText;
    L51:
        if ((r415 & 4096) == 0) goto L53;
        boolean r117 = r110.inputEditable;
    L55:
        if ((r415 & 8192) == 0) goto L57;
        String r118 = r110.inputRightIconUrl;
    L58:
        String r320 = r118;
        if ((r415 & 16384) == 0) goto L61;
        String r119 = r110.inputRightIconText;
    L62:
        String r321 = r119;
        if ((r415 & 32768) == 0) goto L65;
        String r120 = r110.inputRightButtonText;
    L66:
        String r322 = r120;
        if ((r415 & 65536) == 0) goto L69;
        String r121 = r110.inputTips;
    L70:
        String r323 = r121;
        if ((r415 & 131072) == 0) goto L73;
        String r122 = r110.selectHintText;
    L74:
        String r324 = r122;
        if ((r415 & 262144) == 0) goto L77;
        String r123 = r110.selectText;
    L78:
        String r325 = r123;
        if ((r415 & 524288) == 0) goto L81;
        String r124 = r110.selectTips;
    L82:
        String r326 = r124;
        if ((r415 & 1048576) == 0) goto L85;
        boolean r125 = r110.selectEditable;
    L86:
        boolean r327 = r125;
        if ((r415 & 2097152) == 0) goto L89;
        boolean r126 = r110.showLeftAmount;
    L90:
        boolean r328 = r126;
        if ((r415 & 4194304) == 0) goto L93;
        String r127 = r110.amountTips;
    L94:
        String r417 = r127;
        if ((r415 & 8388608) == 0) goto L97;
        String r128 = r110.amountFlag;
    L98:
        String r418 = r128;
        if ((r415 & 16777216) == 0) goto L101;
        String r129 = r110.amountEditHint;
    L102:
        String r419 = r129;
        if ((r415 & 33554432) == 0) goto L105;
        String r130 = r110.amountEditText;
    L107:
        if ((r415 & 67108864) == 0) goto L109;
        boolean r108 = r110.showBottomLine;
    L111:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r113, r114, r115, r116, r117, r320, r321, r322, r323, r324, r325, r326, r327, r328, r417, r418, r419, r130, r108);
    L109:
        r108 = r414;
        goto L111
    L105:
        r130 = r413;
        goto L107
    L101:
        r129 = r412;
        goto L102
    L97:
        r128 = r411;
        goto L98
    L93:
        r127 = r410;
        goto L94
    L89:
        r126 = r319;
        goto L90
    L85:
        r125 = r318;
        goto L86
    L81:
        r124 = r317;
        goto L82
    L77:
        r123 = r316;
        goto L78
    L73:
        r122 = r315;
        goto L74
    L69:
        r121 = r314;
        goto L70
    L65:
        r120 = r313;
        goto L66
    L61:
        r119 = r312;
        goto L62
    L57:
        r118 = r311;
        goto L58
    L53:
        r117 = r310;
        goto L55
    L49:
        r116 = r219;
        goto L51
    L45:
        r115 = r218;
        goto L47
    L41:
        r114 = r217;
        goto L43
    L37:
        r113 = r216;
        goto L39
    L33:
        r107 = r215;
        goto L35
    L29:
        r106 = r214;
        goto L31
    L25:
        r105 = r213;
        goto L27
    L21:
        r104 = r212;
        goto L23
    L17:
        r103 = r211;
        goto L19
    L13:
        r102 = r210;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    public final String component1() {
        return this.leftIconUrl;
    }

    public final String component10() {
        return this.inputLeftIconUrl;
    }

    public final String component11() {
        return this.inputEditHint;
    }

    public final String component12() {
        return this.inputEditText;
    }

    public final boolean component13() {
        return this.inputEditable;
    }

    public final String component14() {
        return this.inputRightIconUrl;
    }

    public final String component15() {
        return this.inputRightIconText;
    }

    public final String component16() {
        return this.inputRightButtonText;
    }

    public final String component17() {
        return this.inputTips;
    }

    public final String component18() {
        return this.selectHintText;
    }

    public final String component19() {
        return this.selectText;
    }

    public final String component2() {
        return this.leftTitle;
    }

    public final String component20() {
        return this.selectTips;
    }

    public final boolean component21() {
        return this.selectEditable;
    }

    public final boolean component22() {
        return this.showLeftAmount;
    }

    public final String component23() {
        return this.amountTips;
    }

    public final String component24() {
        return this.amountFlag;
    }

    public final String component25() {
        return this.amountEditHint;
    }

    public final String component26() {
        return this.amountEditText;
    }

    public final boolean component27() {
        return this.showBottomLine;
    }

    public final List<CJInputListItem> component3() {
        return this.leftListTitle;
    }

    public final int component4() {
        return this.leftListDefaultIndex;
    }

    public final String component5() {
        return this.rightHintIconUrl;
    }

    public final String component6() {
        return this.rightHintText;
    }

    public final String component7() {
        return this.rightHintTips;
    }

    public final boolean component8() {
        return this.rightHintDot;
    }

    public final boolean component9() {
        return this.rightArrowVisible;
    }

    public final CJInputViewState copy(String r310, String r311, List<CJInputListItem> r312, int r313, String r314, String r315, String r316, boolean r317, boolean r318, String r319, String r410, String r411, boolean r412, String r413, String r414, String r415, String r416, String r417, String r418, String r419, boolean r510, boolean r511, String r512, String r513, String r514, String r515, boolean r516) {
        Intrinsics.checkNotNullParameter(r411, "inputEditText");
        Intrinsics.checkNotNullParameter(r515, "amountEditText");
        return new CJInputViewState(r310, r311, r312, r313, r314, r315, r316, r317, r318, r319, r410, r411, r412, r413, r414, r415, r416, r417, r418, r419, r510, r511, r512, r513, r514, r515, r516);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof CJInputViewState) == true) goto L8;
        return false;
    L8:
        CJInputViewState r101 = (CJInputViewState) r100;
        if (Intrinsics.areEqual(this.leftIconUrl, r101.leftIconUrl) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.leftTitle, r101.leftTitle) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.leftListTitle, r101.leftListTitle) == true) goto L18;
        return false;
    L18:
        if (this.leftListDefaultIndex == r101.leftListDefaultIndex) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.rightHintIconUrl, r101.rightHintIconUrl) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.rightHintText, r101.rightHintText) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.rightHintTips, r101.rightHintTips) == true) goto L30;
        return false;
    L30:
        if (this.rightHintDot == r101.rightHintDot) goto L33;
        return false;
    L33:
        if (this.rightArrowVisible == r101.rightArrowVisible) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.inputLeftIconUrl, r101.inputLeftIconUrl) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.inputEditHint, r101.inputEditHint) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.inputEditText, r101.inputEditText) == true) goto L45;
        return false;
    L45:
        if (this.inputEditable == r101.inputEditable) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.inputRightIconUrl, r101.inputRightIconUrl) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.inputRightIconText, r101.inputRightIconText) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.inputRightButtonText, r101.inputRightButtonText) == true) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.inputTips, r101.inputTips) == true) goto L60;
        return false;
    L60:
        if (Intrinsics.areEqual(this.selectHintText, r101.selectHintText) == true) goto L63;
        return false;
    L63:
        if (Intrinsics.areEqual(this.selectText, r101.selectText) == true) goto L66;
        return false;
    L66:
        if (Intrinsics.areEqual(this.selectTips, r101.selectTips) == true) goto L69;
        return false;
    L69:
        if (this.selectEditable == r101.selectEditable) goto L72;
        return false;
    L72:
        if (this.showLeftAmount == r101.showLeftAmount) goto L75;
        return false;
    L75:
        if (Intrinsics.areEqual(this.amountTips, r101.amountTips) == true) goto L78;
        return false;
    L78:
        if (Intrinsics.areEqual(this.amountFlag, r101.amountFlag) == true) goto L81;
        return false;
    L81:
        if (Intrinsics.areEqual(this.amountEditHint, r101.amountEditHint) == true) goto L84;
        return false;
    L84:
        if (Intrinsics.areEqual(this.amountEditText, r101.amountEditText) == true) goto L87;
        return false;
    L87:
        if (this.showBottomLine == r101.showBottomLine) goto L89;
        return false;
    L89:
        return true;
    }

    public int hashCode() {
        String r100 = this.leftIconUrl;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.leftTitle;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        List<CJInputListItem> r107 = this.leftListTitle;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (((r106 + r108) * 31) + this.leftListDefaultIndex) * 31;
        String r110 = this.rightHintIconUrl;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.rightHintText;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.rightHintTips;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        int r119 = 1231;
        if (this.rightHintDot == false) goto L29;
        int r120 = 1231;
    L30:
        int r121 = (r118 + r120) * 31;
        if (this.rightArrowVisible == false) goto L33;
        int r122 = 1231;
    L34:
        int r123 = (r121 + r122) * 31;
        String r124 = this.inputLeftIconUrl;
        if (r124 != null) goto L37;
        int r125 = 0;
    L38:
        int r126 = (r123 + r125) * 31;
        String r127 = this.inputEditHint;
        if (r127 != null) goto L41;
        int r128 = 0;
    L42:
        int r129 = (((r126 + r128) * 31) + this.inputEditText.hashCode()) * 31;
        if (this.inputEditable == false) goto L45;
        int r130 = 1231;
    L46:
        int r131 = (r129 + r130) * 31;
        String r132 = this.inputRightIconUrl;
        if (r132 != null) goto L49;
        int r133 = 0;
    L50:
        int r134 = (r131 + r133) * 31;
        String r135 = this.inputRightIconText;
        if (r135 != null) goto L53;
        int r136 = 0;
    L54:
        int r137 = (r134 + r136) * 31;
        String r138 = this.inputRightButtonText;
        if (r138 != null) goto L57;
        int r139 = 0;
    L58:
        int r140 = (r137 + r139) * 31;
        String r141 = this.inputTips;
        if (r141 != null) goto L61;
        int r142 = 0;
    L62:
        int r143 = (r140 + r142) * 31;
        String r144 = this.selectHintText;
        if (r144 != null) goto L65;
        int r145 = 0;
    L66:
        int r146 = (r143 + r145) * 31;
        String r147 = this.selectText;
        if (r147 != null) goto L69;
        int r148 = 0;
    L70:
        int r149 = (r146 + r148) * 31;
        String r150 = this.selectTips;
        if (r150 != null) goto L73;
        int r151 = 0;
    L74:
        int r152 = (r149 + r151) * 31;
        if (this.selectEditable == false) goto L77;
        int r153 = 1231;
    L78:
        int r154 = (r152 + r153) * 31;
        if (this.showLeftAmount == false) goto L81;
        int r155 = 1231;
    L82:
        int r156 = (r154 + r155) * 31;
        String r157 = this.amountTips;
        if (r157 != null) goto L85;
        int r158 = 0;
    L86:
        int r159 = (r156 + r158) * 31;
        String r160 = this.amountFlag;
        if (r160 != null) goto L89;
        int r161 = 0;
    L90:
        int r162 = (r159 + r161) * 31;
        String r163 = this.amountEditHint;
        if (r163 == null) goto L94;
        r101 = r163.hashCode();
    L94:
        int r164 = (((r162 + r101) * 31) + this.amountEditText.hashCode()) * 31;
        if (this.showBottomLine == true) goto L99;
        r119 = 1237;
    L99:
        return r164 + r119;
    L89:
        r161 = r160.hashCode();
        goto L90
    L85:
        r158 = r157.hashCode();
        goto L86
    L81:
        r155 = 1237;
        goto L82
    L77:
        r153 = 1237;
        goto L78
    L73:
        r151 = r150.hashCode();
        goto L74
    L69:
        r148 = r147.hashCode();
        goto L70
    L65:
        r145 = r144.hashCode();
        goto L66
    L61:
        r142 = r141.hashCode();
        goto L62
    L57:
        r139 = r138.hashCode();
        goto L58
    L53:
        r136 = r135.hashCode();
        goto L54
    L49:
        r133 = r132.hashCode();
        goto L50
    L45:
        r130 = 1237;
        goto L46
    L41:
        r128 = r127.hashCode();
        goto L42
    L37:
        r125 = r124.hashCode();
        goto L38
    L33:
        r122 = 1237;
        goto L34
    L29:
        r120 = 1237;
        goto L30
    L25:
        r117 = r116.hashCode();
        goto L26
    L21:
        r114 = r113.hashCode();
        goto L22
    L17:
        r111 = r110.hashCode();
        goto L18
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "CJInputViewState(leftIconUrl=" + this.leftIconUrl + ", leftTitle=" + this.leftTitle + ", leftListTitle=" + this.leftListTitle + ", leftListDefaultIndex=" + this.leftListDefaultIndex + ", rightHintIconUrl=" + this.rightHintIconUrl + ", rightHintText=" + this.rightHintText + ", rightHintTips=" + this.rightHintTips + ", rightHintDot=" + this.rightHintDot + ", rightArrowVisible=" + this.rightArrowVisible + ", inputLeftIconUrl=" + this.inputLeftIconUrl + ", inputEditHint=" + this.inputEditHint + ", inputEditText=" + this.inputEditText + ", inputEditable=" + this.inputEditable + ", inputRightIconUrl=" + this.inputRightIconUrl + ", inputRightIconText=" + this.inputRightIconText + ", inputRightButtonText=" + this.inputRightButtonText + ", inputTips=" + this.inputTips + ", selectHintText=" + this.selectHintText + ", selectText=" + this.selectText + ", selectTips=" + this.selectTips + ", selectEditable=" + this.selectEditable + ", showLeftAmount=" + this.showLeftAmount + ", amountTips=" + this.amountTips + ", amountFlag=" + this.amountFlag + ", amountEditHint=" + this.amountEditHint + ", amountEditText=" + this.amountEditText + ", showBottomLine=" + this.showBottomLine + ')';
    }

    public final String getAmountEditHint() {
        return this.amountEditHint;
    }

    public final String getAmountEditText() {
        return this.amountEditText;
    }

    public final String getAmountFlag() {
        return this.amountFlag;
    }

    public final String getAmountTips() {
        return this.amountTips;
    }

    public final String getInputEditHint() {
        return this.inputEditHint;
    }

    public final String getInputEditText() {
        return this.inputEditText;
    }

    public final boolean getInputEditable() {
        return this.inputEditable;
    }

    public final String getInputLeftIconUrl() {
        return this.inputLeftIconUrl;
    }

    public final String getInputRightButtonText() {
        return this.inputRightButtonText;
    }

    public final String getInputRightIconText() {
        return this.inputRightIconText;
    }

    public final String getInputRightIconUrl() {
        return this.inputRightIconUrl;
    }

    public final String getInputTips() {
        return this.inputTips;
    }

    public final String getLeftIconUrl() {
        return this.leftIconUrl;
    }

    public final int getLeftListDefaultIndex() {
        return this.leftListDefaultIndex;
    }

    public final List<CJInputListItem> getLeftListTitle() {
        return this.leftListTitle;
    }

    public final String getLeftTitle() {
        return this.leftTitle;
    }

    public final boolean getRightArrowVisible() {
        return this.rightArrowVisible;
    }

    public final boolean getRightHintDot() {
        return this.rightHintDot;
    }

    public final String getRightHintIconUrl() {
        return this.rightHintIconUrl;
    }

    public final String getRightHintText() {
        return this.rightHintText;
    }

    public final String getRightHintTips() {
        return this.rightHintTips;
    }

    public final boolean getSelectEditable() {
        return this.selectEditable;
    }

    public final String getSelectHintText() {
        return this.selectHintText;
    }

    public final String getSelectText() {
        return this.selectText;
    }

    public final String getSelectTips() {
        return this.selectTips;
    }

    public final boolean getShowBottomLine() {
        return this.showBottomLine;
    }

    public final boolean getShowLeftAmount() {
        return this.showLeftAmount;
    }

    public CJInputViewState(String r100, String r101, List<CJInputListItem> r102, int r103, String r104, String r110, String r111, boolean r112, boolean r113, String r114, String r115, String r116, boolean r117, String r118, String r119, String r210, String r211, String r212, String r213, String r214, boolean r215, boolean r216, String r217, String r218, String r219, String r310, boolean r311) {
        Intrinsics.checkNotNullParameter(r116, "inputEditText");
        Intrinsics.checkNotNullParameter(r310, "amountEditText");
        this.leftIconUrl = r100;
        this.leftTitle = r101;
        this.leftListTitle = r102;
        this.leftListDefaultIndex = r103;
        this.rightHintIconUrl = r104;
        this.rightHintText = r110;
        this.rightHintTips = r111;
        this.rightHintDot = r112;
        this.rightArrowVisible = r113;
        this.inputLeftIconUrl = r114;
        this.inputEditHint = r115;
        this.inputEditText = r116;
        this.inputEditable = r117;
        this.inputRightIconUrl = r118;
        this.inputRightIconText = r119;
        this.inputRightButtonText = r210;
        this.inputTips = r211;
        this.selectHintText = r212;
        this.selectText = r213;
        this.selectTips = r214;
        this.selectEditable = r215;
        this.showLeftAmount = r216;
        this.amountTips = r217;
        this.amountFlag = r218;
        this.amountEditHint = r219;
        this.amountEditText = r310;
        this.showBottomLine = r311;
    }

    public /* synthetic */ CJInputViewState(String r310, String r311, List r312, int r313, String r314, String r315, String r316, boolean r317, boolean r318, String r319, String r410, String r411, boolean r412, String r413, String r414, String r415, String r416, String r417, String r418, String r419, boolean r510, boolean r511, String r512, String r513, String r514, String r515, boolean r516, int r517, DefaultConstructorMarker r518) {
        if ((r517 & 1) == 0) goto L5;
        String r100 = null;
    L7:
        if ((r517 & 2) == 0) goto L9;
        String r101 = null;
    L11:
        if ((r517 & 4) == 0) goto L13;
        List r102 = null;
    L15:
        if ((r517 & 8) == 0) goto L17;
        int r103 = 0;
    L19:
        if ((r517 & 16) == 0) goto L21;
        String r104 = null;
    L23:
        if ((r517 & 32) == 0) goto L25;
        String r105 = null;
    L27:
        if ((r517 & 64) == 0) goto L29;
        String r106 = null;
    L31:
        if ((r517 & 128) == 0) goto L33;
        boolean r110 = false;
    L35:
        if ((r517 & 256) == 0) goto L37;
        boolean r111 = false;
    L39:
        if ((r517 & 512) == 0) goto L41;
        String r112 = null;
    L43:
        if ((r517 & 1024) == 0) goto L45;
        String r113 = null;
    L47:
        if ((r517 & 2048) == 0) goto L49;
        String r114 = "";
    L50:
        boolean r115 = true;
        if ((r517 & 4096) == 0) goto L53;
        boolean r107 = true;
    L55:
        if ((r517 & 8192) == 0) goto L57;
        String r108 = null;
    L59:
        if ((r517 & 16384) == 0) goto L61;
        String r116 = null;
    L63:
        if ((r517 & 32768) == 0) goto L65;
        String r117 = null;
    L67:
        if ((r517 & 65536) == 0) goto L69;
        String r118 = null;
    L71:
        if ((r517 & 131072) == 0) goto L73;
        String r119 = null;
    L75:
        if ((r517 & 262144) == 0) goto L77;
        String r210 = null;
    L79:
        if ((r517 & 524288) == 0) goto L81;
        String r211 = null;
    L83:
        if ((r517 & 1048576) == 0) goto L85;
        boolean r212 = true;
    L87:
        if ((r517 & 2097152) == 0) goto L89;
        boolean r213 = false;
    L91:
        if ((r517 & 4194304) == 0) goto L93;
        String r214 = null;
    L95:
        if ((r517 & 8388608) == 0) goto L97;
        String r215 = null;
    L99:
        if ((r517 & 16777216) == 0) goto L101;
        String r216 = null;
    L103:
        if ((r517 & 33554432) == 0) goto L105;
        String r217 = "";
    L107:
        if ((r517 & 67108864) != 0) goto L110;
        r115 = r516;
    L110:
        this(r100, r101, r102, r103, r104, r105, r106, r110, r111, r112, r113, r114, r107, r108, r116, r117, r118, r119, r210, r211, r212, r213, r214, r215, r216, r217, r115);
        return;
    L105:
        r217 = r515;
        goto L107
    L101:
        r216 = r514;
        goto L103
    L97:
        r215 = r513;
        goto L99
    L93:
        r214 = r512;
        goto L95
    L89:
        r213 = r511;
        goto L91
    L85:
        r212 = r510;
        goto L87
    L81:
        r211 = r419;
        goto L83
    L77:
        r210 = r418;
        goto L79
    L73:
        r119 = r417;
        goto L75
    L69:
        r118 = r416;
        goto L71
    L65:
        r117 = r415;
        goto L67
    L61:
        r116 = r414;
        goto L63
    L57:
        r108 = r413;
        goto L59
    L53:
        r107 = r412;
        goto L55
    L49:
        r114 = r411;
        goto L50
    L45:
        r113 = r410;
        goto L47
    L41:
        r112 = r319;
        goto L43
    L37:
        r111 = r318;
        goto L39
    L33:
        r110 = r317;
        goto L35
    L29:
        r106 = r316;
        goto L31
    L25:
        r105 = r315;
        goto L27
    L21:
        r104 = r314;
        goto L23
    L17:
        r103 = r313;
        goto L19
    L13:
        r102 = r312;
        goto L15
    L9:
        r101 = r311;
        goto L11
    L5:
        r100 = r310;
        goto L7
    }
}
