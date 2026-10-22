package com.android.ttcjpaysdk.base;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\b\u0086\u0001\u0018\u0000 \u000f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000fB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u0010"}, d2 = {"Lcom/android/ttcjpaysdk/base/OuterOrderType;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "AP_SIGN", "CREDIT_ORDER_CONFIRM", "CREDIT_SIGN", "SIGN", "SIGN_DY_PAY", "SIGN_PAY", "COM_DOU_YIN", "DEFAULT", "Companion", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final enum OuterOrderType extends Enum<OuterOrderType> {
    private static final /* synthetic */ OuterOrderType[] $VALUES = null;
    public static final OuterOrderType AP_SIGN = null;
    public static final OuterOrderType COM_DOU_YIN = null;
    public static final OuterOrderType CREDIT_ORDER_CONFIRM = null;
    public static final OuterOrderType CREDIT_SIGN = null;
    public static final Companion Companion = null;
    public static final OuterOrderType DEFAULT = null;
    public static final OuterOrderType SIGN = null;
    public static final OuterOrderType SIGN_DY_PAY = null;
    public static final OuterOrderType SIGN_PAY = null;
    private final String value;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006J\u0010\u0010\u0007\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u0010\u0010\t\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¨\u0006\n"}, d2 = {"Lcom/android/ttcjpaysdk/base/OuterOrderType$Companion;", "", "()V", "isBdPayAPSign", "", "bdPayPackage", "", "isBdPayCreditOnlySign", "isBdPayOnlySign", "isBdPaySign", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final boolean isBdPayAPSign(String r100) {
            if (r100 == null) goto L4;
            Boolean r101 = Boolean.valueOf(StringsKt.equals(r100, OuterOrderType.AP_SIGN.getValue(), true));
        L5:
            if (r101 != null) goto L9;
            return false;
        L9:
            return r101.booleanValue();
        L4:
            r101 = null;
            goto L5
        }

        public final boolean isBdPayCreditOnlySign(String r100) {
            if (r100 == null) goto L5;
            Boolean r101 = Boolean.valueOf(StringsKt.equals(r100, OuterOrderType.CREDIT_SIGN.getValue(), true));
        L7:
            if (r101 == null) goto L9;
            boolean r102 = r101.booleanValue();
        L10:
            if (r102 == false) goto L12;
            return true;
        L12:
            if (StringsKt.equals(r100, OuterOrderType.CREDIT_ORDER_CONFIRM.getValue(), true) == true) goto L17;
            return false;
        L17:
            return true;
        L9:
            r102 = false;
            goto L10
        L5:
            r101 = null;
            goto L7
        }

        public final boolean isBdPayOnlySign(String r100) {
            Intrinsics.checkNotNullParameter(r100, "bdPayPackage");
            if (StringsKt.equals(r100, OuterOrderType.SIGN.getValue(), true) == false) goto L5;
            return true;
        L5:
            if (StringsKt.equals(r100, OuterOrderType.CREDIT_SIGN.getValue(), true) == false) goto L7;
            return true;
        L7:
            if (StringsKt.equals(r100, OuterOrderType.CREDIT_ORDER_CONFIRM.getValue(), true) == false) goto L9;
            return true;
        L9:
            if (StringsKt.equals(r100, OuterOrderType.AP_SIGN.getValue(), true) == true) goto L16;
            return false;
        L16:
            return true;
        }

        public final boolean isBdPaySign(String r100) {
            if (r100 == null) goto L4;
            Boolean r101 = Boolean.valueOf(StringsKt.equals(r100, OuterOrderType.SIGN.getValue(), true));
        L5:
            if (r101 != null) goto L9;
            return false;
        L9:
            return r101.booleanValue();
        L4:
            r101 = null;
            goto L5
        }
    }

    private static final /* synthetic */ OuterOrderType[] $values() {
        return new OuterOrderType[]{AP_SIGN, CREDIT_ORDER_CONFIRM, CREDIT_SIGN, SIGN, SIGN_DY_PAY, SIGN_PAY, COM_DOU_YIN, DEFAULT};
    }

    public static OuterOrderType valueOf(String r100) {
        return (OuterOrderType) r27.a.a(OuterOrderType.class, r100);
    }

    public static OuterOrderType[] values() {
        return (OuterOrderType[]) $VALUES.clone();
    }

    static {
        AP_SIGN = new OuterOrderType("AP_SIGN", 0, "apple_pay_sign");
        CREDIT_ORDER_CONFIRM = new OuterOrderType("CREDIT_ORDER_CONFIRM", 1, "credit_order_confirm");
        CREDIT_SIGN = new OuterOrderType("CREDIT_SIGN", 2, "credit_sign");
        SIGN = new OuterOrderType("SIGN", 3, "Sign");
        SIGN_DY_PAY = new OuterOrderType("SIGN_DY_PAY", 4, "Sign=DYPay");
        SIGN_PAY = new OuterOrderType("SIGN_PAY", 5, "sign=pay");
        COM_DOU_YIN = new OuterOrderType("COM_DOU_YIN", 6, "com.douyin");
        DEFAULT = new OuterOrderType("DEFAULT", 7, "");
        $VALUES = $values();
        Companion = new Companion(null);
    }

    public final String getValue() {
        return this.value;
    }

    private OuterOrderType(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
