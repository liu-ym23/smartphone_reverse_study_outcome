package com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.standard.front.doubleconfirm;

import com.android.ttcjpaysdk.base.service.bean.VoucherDialogExpandResult;
import com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.preverify.vm.base.UnifyPreVerifyBaseVM;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001f\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Bi\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005\u0012\b\b\u0002\u0010\n\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\f\u001a\u00020\u0005\u0012\b\b\u0002\u0010\r\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0007¢\u0006\u0002\u0010\u000fJ\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0007HÆ\u0003J\t\u0010 \u001a\u00020\u0005HÆ\u0003J\t\u0010!\u001a\u00020\u0005HÆ\u0003J\t\u0010\"\u001a\u00020\u0005HÆ\u0003Jo\u0010#\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u00072\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u0007HÆ\u0001J\u0013\u0010$\u001a\u00020\u00052\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010&\u001a\u00020'HÖ\u0001J\t\u0010(\u001a\u00020\u0007HÖ\u0001R\u0011\u0010\u000b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\n\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\r\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0011R\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0011R\u0011\u0010\f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0011R\u0011\u0010\u000e\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0014¨\u0006)"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/standard/front/doubleconfirm/CJStandardDoubleConfirmCallbackData;", "", "expandResult", "Lcom/android/ttcjpaysdk/base/service/bean/VoucherDialogExpandResult;", "isShowBankCardPointGuide", "", "bankCardPointGuideKey", "", "bankCardPointGuideChecked", "isShowBankCardPoint", "bankCardPointKey", "bankCardPointChecked", "isShowRecommendVerify", "isRecommendChecked", UnifyPreVerifyBaseVM.KEY_POP_SOURCE, "(Lcom/android/ttcjpaysdk/base/service/bean/VoucherDialogExpandResult;ZLjava/lang/String;ZZLjava/lang/String;ZZZLjava/lang/String;)V", "getBankCardPointChecked", "()Z", "getBankCardPointGuideChecked", "getBankCardPointGuideKey", "()Ljava/lang/String;", "getBankCardPointKey", "getExpandResult", "()Lcom/android/ttcjpaysdk/base/service/bean/VoucherDialogExpandResult;", "getPopSource", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "", "toString", "bdpay-front-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJStandardDoubleConfirmCallbackData {
    private final boolean bankCardPointChecked;
    private final boolean bankCardPointGuideChecked;
    private final String bankCardPointGuideKey;
    private final String bankCardPointKey;
    private final VoucherDialogExpandResult expandResult;
    private final boolean isRecommendChecked;
    private final boolean isShowBankCardPoint;
    private final boolean isShowBankCardPointGuide;
    private final boolean isShowRecommendVerify;
    private final String popSource;

    public static /* synthetic */ CJStandardDoubleConfirmCallbackData copy$default(CJStandardDoubleConfirmCallbackData r110, VoucherDialogExpandResult r111, boolean r112, String r113, boolean r114, boolean r115, String r116, boolean r117, boolean r118, boolean r210, String r211, int r212, Object r213) {
        if ((r212 & 1) == 0) goto L5;
        VoucherDialogExpandResult r100 = r110.expandResult;
    L7:
        if ((r212 & 2) == 0) goto L9;
        boolean r101 = r110.isShowBankCardPointGuide;
    L11:
        if ((r212 & 4) == 0) goto L13;
        String r102 = r110.bankCardPointGuideKey;
    L15:
        if ((r212 & 8) == 0) goto L17;
        boolean r103 = r110.bankCardPointGuideChecked;
    L19:
        if ((r212 & 16) == 0) goto L21;
        boolean r104 = r110.isShowBankCardPoint;
    L23:
        if ((r212 & 32) == 0) goto L25;
        String r105 = r110.bankCardPointKey;
    L27:
        if ((r212 & 64) == 0) goto L29;
        boolean r106 = r110.bankCardPointChecked;
    L31:
        if ((r212 & 128) == 0) goto L33;
        boolean r107 = r110.isShowRecommendVerify;
    L35:
        if ((r212 & 256) == 0) goto L37;
        boolean r119 = r110.isRecommendChecked;
    L39:
        if ((r212 & 512) == 0) goto L41;
        String r108 = r110.popSource;
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

    public final VoucherDialogExpandResult component1() {
        return this.expandResult;
    }

    public final String component10() {
        return this.popSource;
    }

    public final boolean component2() {
        return this.isShowBankCardPointGuide;
    }

    public final String component3() {
        return this.bankCardPointGuideKey;
    }

    public final boolean component4() {
        return this.bankCardPointGuideChecked;
    }

    public final boolean component5() {
        return this.isShowBankCardPoint;
    }

    public final String component6() {
        return this.bankCardPointKey;
    }

    public final boolean component7() {
        return this.bankCardPointChecked;
    }

    public final boolean component8() {
        return this.isShowRecommendVerify;
    }

    public final boolean component9() {
        return this.isRecommendChecked;
    }

    public final CJStandardDoubleConfirmCallbackData copy(VoucherDialogExpandResult r110, boolean r111, String r112, boolean r113, boolean r114, String r115, boolean r116, boolean r210, boolean r211, String r212) {
        Intrinsics.checkNotNullParameter(r112, "bankCardPointGuideKey");
        Intrinsics.checkNotNullParameter(r115, "bankCardPointKey");
        Intrinsics.checkNotNullParameter(r212, UnifyPreVerifyBaseVM.KEY_POP_SOURCE);
        return new CJStandardDoubleConfirmCallbackData(r110, r111, r112, r113, r114, r115, r116, r210, r211, r212);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof CJStandardDoubleConfirmCallbackData) == true) goto L8;
        return false;
    L8:
        CJStandardDoubleConfirmCallbackData r101 = (CJStandardDoubleConfirmCallbackData) r100;
        if (Intrinsics.areEqual(this.expandResult, r101.expandResult) == true) goto L12;
        return false;
    L12:
        if (this.isShowBankCardPointGuide == r101.isShowBankCardPointGuide) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.bankCardPointGuideKey, r101.bankCardPointGuideKey) == true) goto L18;
        return false;
    L18:
        if (this.bankCardPointGuideChecked == r101.bankCardPointGuideChecked) goto L21;
        return false;
    L21:
        if (this.isShowBankCardPoint == r101.isShowBankCardPoint) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.bankCardPointKey, r101.bankCardPointKey) == true) goto L27;
        return false;
    L27:
        if (this.bankCardPointChecked == r101.bankCardPointChecked) goto L30;
        return false;
    L30:
        if (this.isShowRecommendVerify == r101.isShowRecommendVerify) goto L33;
        return false;
    L33:
        if (this.isRecommendChecked == r101.isRecommendChecked) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.popSource, r101.popSource) == true) goto L38;
        return false;
    L38:
        return true;
    }

    public int hashCode() {
        VoucherDialogExpandResult r100 = this.expandResult;
        if (r100 != null) goto L5;
        int r101 = 0;
    L6:
        int r102 = r101 * 31;
        int r103 = 1231;
        if (this.isShowBankCardPointGuide == false) goto L9;
        int r104 = 1231;
    L10:
        int r105 = (((r102 + r104) * 31) + this.bankCardPointGuideKey.hashCode()) * 31;
        if (this.bankCardPointGuideChecked == false) goto L13;
        int r106 = 1231;
    L14:
        int r107 = (r105 + r106) * 31;
        if (this.isShowBankCardPoint == false) goto L17;
        int r108 = 1231;
    L18:
        int r109 = (((r107 + r108) * 31) + this.bankCardPointKey.hashCode()) * 31;
        if (this.bankCardPointChecked == false) goto L21;
        int r110 = 1231;
    L22:
        int r111 = (r109 + r110) * 31;
        if (this.isShowRecommendVerify == false) goto L25;
        int r112 = 1231;
    L26:
        int r113 = (r111 + r112) * 31;
        if (this.isRecommendChecked == true) goto L31;
        r103 = 1237;
    L31:
        return ((r113 + r103) * 31) + this.popSource.hashCode();
    L25:
        r112 = 1237;
        goto L26
    L21:
        r110 = 1237;
        goto L22
    L17:
        r108 = 1237;
        goto L18
    L13:
        r106 = 1237;
        goto L14
    L9:
        r104 = 1237;
        goto L10
    L5:
        r101 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "CJStandardDoubleConfirmCallbackData(expandResult=" + this.expandResult + ", isShowBankCardPointGuide=" + this.isShowBankCardPointGuide + ", bankCardPointGuideKey=" + this.bankCardPointGuideKey + ", bankCardPointGuideChecked=" + this.bankCardPointGuideChecked + ", isShowBankCardPoint=" + this.isShowBankCardPoint + ", bankCardPointKey=" + this.bankCardPointKey + ", bankCardPointChecked=" + this.bankCardPointChecked + ", isShowRecommendVerify=" + this.isShowRecommendVerify + ", isRecommendChecked=" + this.isRecommendChecked + ", popSource=" + this.popSource + ')';
    }

    public final boolean getBankCardPointChecked() {
        return this.bankCardPointChecked;
    }

    public final boolean getBankCardPointGuideChecked() {
        return this.bankCardPointGuideChecked;
    }

    public final String getBankCardPointGuideKey() {
        return this.bankCardPointGuideKey;
    }

    public final String getBankCardPointKey() {
        return this.bankCardPointKey;
    }

    public final VoucherDialogExpandResult getExpandResult() {
        return this.expandResult;
    }

    public final String getPopSource() {
        return this.popSource;
    }

    public final boolean isRecommendChecked() {
        return this.isRecommendChecked;
    }

    public final boolean isShowBankCardPoint() {
        return this.isShowBankCardPoint;
    }

    public final boolean isShowBankCardPointGuide() {
        return this.isShowBankCardPointGuide;
    }

    public final boolean isShowRecommendVerify() {
        return this.isShowRecommendVerify;
    }

    public CJStandardDoubleConfirmCallbackData(VoucherDialogExpandResult r100, boolean r101, String r102, boolean r103, boolean r104, String r105, boolean r106, boolean r107, boolean r110, String r111) {
        Intrinsics.checkNotNullParameter(r102, "bankCardPointGuideKey");
        Intrinsics.checkNotNullParameter(r105, "bankCardPointKey");
        Intrinsics.checkNotNullParameter(r111, UnifyPreVerifyBaseVM.KEY_POP_SOURCE);
        this.expandResult = r100;
        this.isShowBankCardPointGuide = r101;
        this.bankCardPointGuideKey = r102;
        this.bankCardPointGuideChecked = r103;
        this.isShowBankCardPoint = r104;
        this.bankCardPointKey = r105;
        this.bankCardPointChecked = r106;
        this.isShowRecommendVerify = r107;
        this.isRecommendChecked = r110;
        this.popSource = r111;
    }

    public /* synthetic */ CJStandardDoubleConfirmCallbackData(VoucherDialogExpandResult r110, boolean r111, String r112, boolean r113, boolean r114, String r115, boolean r116, boolean r117, boolean r210, String r211, int r212, DefaultConstructorMarker r213) {
        boolean r100 = false;
        if ((r212 & 2) == 0) goto L5;
        boolean r101 = false;
    L6:
        String r102 = "";
        if ((r212 & 4) == 0) goto L9;
        String r103 = "";
    L11:
        if ((r212 & 8) == 0) goto L13;
        boolean r104 = false;
    L15:
        if ((r212 & 16) == 0) goto L17;
        boolean r105 = false;
    L19:
        if ((r212 & 32) == 0) goto L21;
        String r106 = "";
    L23:
        if ((r212 & 64) == 0) goto L25;
        boolean r107 = false;
    L27:
        if ((r212 & 128) == 0) goto L29;
        boolean r108 = false;
    L31:
        if ((r212 & 256) != 0) goto L35;
        r100 = r210;
    L35:
        if ((r212 & 512) != 0) goto L38;
        r102 = r211;
    L38:
        this(r110, r101, r103, r104, r105, r106, r107, r108, r100, r102);
        return;
    L29:
        r108 = r117;
        goto L31
    L25:
        r107 = r116;
        goto L27
    L21:
        r106 = r115;
        goto L23
    L17:
        r105 = r114;
        goto L19
    L13:
        r104 = r113;
        goto L15
    L9:
        r103 = r112;
        goto L11
    L5:
        r101 = r111;
        goto L6
    }
}
