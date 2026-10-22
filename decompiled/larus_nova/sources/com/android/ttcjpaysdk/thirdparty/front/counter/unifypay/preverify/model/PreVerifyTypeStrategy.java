package com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.preverify.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0016\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\b\u0018\u0000 %2\u00020\u0001:\u0001%B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0002\u0010\nJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0019\u001a\u00020\bHÆ\u0003J\t\u0010\u001a\u001a\u00020\bHÆ\u0003J;\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\bHÆ\u0001J\u0013\u0010\u001c\u001a\u00020\b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\u0006\u0010 \u001a\u00020\bJ\u0006\u0010!\u001a\u00020\bJ\u0006\u0010\"\u001a\u00020\bJ\u0006\u0010#\u001a\u00020\bJ\t\u0010$\u001a\u00020\u0006HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\t\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\f¨\u0006&"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/preverify/model/PreVerifyTypeStrategy;", "", "curPreVerifyType", "Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/preverify/model/UnifyPreVerifyType;", "secondPreVerifyType", "secondPreVerifyDesc", "", "hasSecondPreVerifyConfig", "", "isDecidedByMethod", "(Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/preverify/model/UnifyPreVerifyType;Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/preverify/model/UnifyPreVerifyType;Ljava/lang/String;ZZ)V", "getCurPreVerifyType", "()Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/preverify/model/UnifyPreVerifyType;", "setCurPreVerifyType", "(Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/preverify/model/UnifyPreVerifyType;)V", "getHasSecondPreVerifyConfig", "()Z", "setDecidedByMethod", "(Z)V", "getSecondPreVerifyDesc", "()Ljava/lang/String;", "getSecondPreVerifyType", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "", "isCurrentTypeEmbedded", "isNeedHomepage", "isSecondTypeUsable", "needCurTypeHideKeyboard", "toString", "Companion", "bdpay-front-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PreVerifyTypeStrategy {
    public static final Companion Companion = null;
    private UnifyPreVerifyType curPreVerifyType;
    private final boolean hasSecondPreVerifyConfig;
    private boolean isDecidedByMethod;
    private final String secondPreVerifyDesc;
    private final UnifyPreVerifyType secondPreVerifyType;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006J\u0010\u0010\u0007\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¨\u0006\b"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/preverify/model/PreVerifyTypeStrategy$Companion;", "", "()V", "isConfirmGateType", "", "preVerifyType", "Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/preverify/model/UnifyPreVerifyType;", "isPreVerifyTypeEmbedded", "bdpay-front-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final boolean isConfirmGateType(UnifyPreVerifyType r100) {
            if (r100 != UnifyPreVerifyType.VERIFY_TYPE_CARRIER) goto L5;
            return true;
        L5:
            return false;
        }

        public final boolean isPreVerifyTypeEmbedded(UnifyPreVerifyType r100) {
            if (r100 != UnifyPreVerifyType.VERIFY_TYPE_PWD) goto L5;
        L10:
            return true;
        L5:
            if (r100 == UnifyPreVerifyType.VERIFY_TYPE_SMS) goto L10;
            if (r100 == UnifyPreVerifyType.VERIFY_TYPE_CVV) goto L10;
            return false;
        }
    }

    static {
        Companion = new Companion(null);
    }

    public static /* synthetic */ PreVerifyTypeStrategy copy$default(PreVerifyTypeStrategy r100, UnifyPreVerifyType r101, UnifyPreVerifyType r102, String r103, boolean r104, boolean r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.curPreVerifyType;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.secondPreVerifyType;
    L8:
        UnifyPreVerifyType r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.secondPreVerifyDesc;
    L11:
        String r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.hasSecondPreVerifyConfig;
    L14:
        boolean r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.isDecidedByMethod;
    L17:
        UnifyPreVerifyType r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
    }

    public final UnifyPreVerifyType component1() {
        return this.curPreVerifyType;
    }

    public final UnifyPreVerifyType component2() {
        return this.secondPreVerifyType;
    }

    public final String component3() {
        return this.secondPreVerifyDesc;
    }

    public final boolean component4() {
        return this.hasSecondPreVerifyConfig;
    }

    public final boolean component5() {
        return this.isDecidedByMethod;
    }

    public final PreVerifyTypeStrategy copy(UnifyPreVerifyType r100, UnifyPreVerifyType r101, String r110, boolean r111, boolean r112) {
        Intrinsics.checkNotNullParameter(r100, "curPreVerifyType");
        Intrinsics.checkNotNullParameter(r101, "secondPreVerifyType");
        Intrinsics.checkNotNullParameter(r110, "secondPreVerifyDesc");
        return new PreVerifyTypeStrategy(r100, r101, r110, r111, r112);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof PreVerifyTypeStrategy) == true) goto L8;
        return false;
    L8:
        PreVerifyTypeStrategy r101 = (PreVerifyTypeStrategy) r100;
        if (this.curPreVerifyType == r101.curPreVerifyType) goto L12;
        return false;
    L12:
        if (this.secondPreVerifyType == r101.secondPreVerifyType) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.secondPreVerifyDesc, r101.secondPreVerifyDesc) == true) goto L18;
        return false;
    L18:
        if (this.hasSecondPreVerifyConfig == r101.hasSecondPreVerifyConfig) goto L21;
        return false;
    L21:
        if (this.isDecidedByMethod == r101.isDecidedByMethod) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        int r100 = ((((this.curPreVerifyType.hashCode() * 31) + this.secondPreVerifyType.hashCode()) * 31) + this.secondPreVerifyDesc.hashCode()) * 31;
        int r101 = 1231;
        if (this.hasSecondPreVerifyConfig == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (r100 + r102) * 31;
        if (this.isDecidedByMethod == true) goto L11;
        r101 = 1237;
    L11:
        return r103 + r101;
    L5:
        r102 = 1237;
        goto L6
    }

    public String toString() {
        return "PreVerifyTypeStrategy(curPreVerifyType=" + this.curPreVerifyType + ", secondPreVerifyType=" + this.secondPreVerifyType + ", secondPreVerifyDesc=" + this.secondPreVerifyDesc + ", hasSecondPreVerifyConfig=" + this.hasSecondPreVerifyConfig + ", isDecidedByMethod=" + this.isDecidedByMethod + ')';
    }

    public final boolean isCurrentTypeEmbedded() {
        return Companion.isPreVerifyTypeEmbedded(this.curPreVerifyType);
    }

    public final boolean isSecondTypeUsable() {
        if (this.curPreVerifyType != UnifyPreVerifyType.VERIFY_TYPE_CARD_SIGN) goto L5;
    L13:
        return false;
    L5:
        if (this.hasSecondPreVerifyConfig == false) goto L13;
        UnifyPreVerifyType r100 = this.secondPreVerifyType;
        if (r100 == UnifyPreVerifyType.VERIFY_TYPE_UNKNOWN) goto L13;
        if (r100 == UnifyPreVerifyType.VERIFY_TYPE_CLIENT_DEGRADE) goto L13;
        if ((!StringsKt.isBlank(this.secondPreVerifyDesc)) == false) goto L13;
        return true;
    }

    public final boolean needCurTypeHideKeyboard() {
        if (this.curPreVerifyType != UnifyPreVerifyType.VERIFY_TYPE_SMS) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isNeedHomepage() {
        if (isCurrentTypeEmbedded() == false) goto L5;
    L8:
        return true;
    L5:
        if (this.curPreVerifyType == UnifyPreVerifyType.VERIFY_TYPE_VOICE_PRINT) goto L8;
        return false;
    }

    public final UnifyPreVerifyType getCurPreVerifyType() {
        return this.curPreVerifyType;
    }

    public final boolean getHasSecondPreVerifyConfig() {
        return this.hasSecondPreVerifyConfig;
    }

    public final String getSecondPreVerifyDesc() {
        return this.secondPreVerifyDesc;
    }

    public final UnifyPreVerifyType getSecondPreVerifyType() {
        return this.secondPreVerifyType;
    }

    public final boolean isDecidedByMethod() {
        return this.isDecidedByMethod;
    }

    public final void setCurPreVerifyType(UnifyPreVerifyType r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.curPreVerifyType = r100;
    }

    public final void setDecidedByMethod(boolean r100) {
        this.isDecidedByMethod = r100;
    }

    public PreVerifyTypeStrategy(UnifyPreVerifyType r100, UnifyPreVerifyType r101, String r102, boolean r103, boolean r104) {
        Intrinsics.checkNotNullParameter(r100, "curPreVerifyType");
        Intrinsics.checkNotNullParameter(r101, "secondPreVerifyType");
        Intrinsics.checkNotNullParameter(r102, "secondPreVerifyDesc");
        this.curPreVerifyType = r100;
        this.secondPreVerifyType = r101;
        this.secondPreVerifyDesc = r102;
        this.hasSecondPreVerifyConfig = r103;
        this.isDecidedByMethod = r104;
    }

    public /* synthetic */ PreVerifyTypeStrategy(UnifyPreVerifyType r100, UnifyPreVerifyType r101, String r102, boolean r110, boolean r111, int r112, DefaultConstructorMarker r113) {
        if ((r112 & 2) == 0) goto L5;
        r101 = UnifyPreVerifyType.VERIFY_TYPE_UNKNOWN;
    L5:
        UnifyPreVerifyType r103 = r101;
        if ((r112 & 4) == 0) goto L8;
        r102 = "";
    L8:
        String r104 = r102;
        if ((r112 & 8) == 0) goto L11;
        boolean r105 = true;
    L13:
        if ((r112 & 16) == 0) goto L15;
        boolean r106 = false;
    L16:
        this(r100, r103, r104, r105, r106);
        return;
    L15:
        r106 = r111;
        goto L16
    L11:
        r105 = r110;
        goto L13
    }
}
