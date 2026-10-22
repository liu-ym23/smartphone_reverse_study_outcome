package com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.preverify.model;

import com.android.ttcjpaysdk.base.ui.data.CJPayTopRightBtnInfo;
import com.android.ttcjpaysdk.thirdparty.data.unifypay.UnifyCashierRenderInfo;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import faceverify.w;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import r27.a;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0013\b\u0086\u0001\u0018\u0000 \u001a2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u001aB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0007\u001a\u00020\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019¨\u0006\u001b"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/preverify/model/UnifyPreVerifyType;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "toCheckType", "", "VERIFY_TYPE_CLIENT_DEGRADE", "VERIFY_TYPE_PWD", "VERIFY_TYPE_FINGERPRINT", "VERIFY_TYPE_LOCAL_FINGERPRINT", "VERIFY_TYPE_OPEN_FINGERPRINT", "VERIFY_TYPE_FACE", "VERIFY_TYPE_VOICE_PRINT", "VERIFY_TYPE_CARRIER", "VERIFY_TYPE_SMS", "VERIFY_TYPE_RISK_SMS", "VERIFY_TYPE_CARD_SIGN", "VERIFY_TYPE_ONE_STEP_PAY", "VERIFY_TYPE_SKIP_VERIFY", "VERIFY_TYPE_TOKEN", "VERIFY_TYPE_SET_PWD", "VERIFY_TYPE_UNKNOWN", "VERIFY_TYPE_CVV", "Companion", "bdpay-front-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final enum UnifyPreVerifyType extends Enum<UnifyPreVerifyType> {
    private static final /* synthetic */ UnifyPreVerifyType[] $VALUES = null;
    public static final Companion Companion = null;
    public static final UnifyPreVerifyType VERIFY_TYPE_CARD_SIGN = null;
    public static final UnifyPreVerifyType VERIFY_TYPE_CARRIER = null;
    public static final UnifyPreVerifyType VERIFY_TYPE_CLIENT_DEGRADE = null;
    public static final UnifyPreVerifyType VERIFY_TYPE_CVV = null;
    public static final UnifyPreVerifyType VERIFY_TYPE_FACE = null;
    public static final UnifyPreVerifyType VERIFY_TYPE_FINGERPRINT = null;
    public static final UnifyPreVerifyType VERIFY_TYPE_LOCAL_FINGERPRINT = null;
    public static final UnifyPreVerifyType VERIFY_TYPE_ONE_STEP_PAY = null;
    public static final UnifyPreVerifyType VERIFY_TYPE_OPEN_FINGERPRINT = null;
    public static final UnifyPreVerifyType VERIFY_TYPE_PWD = null;
    public static final UnifyPreVerifyType VERIFY_TYPE_RISK_SMS = null;
    public static final UnifyPreVerifyType VERIFY_TYPE_SET_PWD = null;
    public static final UnifyPreVerifyType VERIFY_TYPE_SKIP_VERIFY = null;
    public static final UnifyPreVerifyType VERIFY_TYPE_SMS = null;
    public static final UnifyPreVerifyType VERIFY_TYPE_TOKEN = null;
    public static final UnifyPreVerifyType VERIFY_TYPE_UNKNOWN = null;
    public static final UnifyPreVerifyType VERIFY_TYPE_VOICE_PRINT = null;
    private final String value;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¨\u0006\u0007"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/preverify/model/UnifyPreVerifyType$Companion;", "", "()V", "fromTopRightBtnInfo", "Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/preverify/model/UnifyPreVerifyType;", "btnInfo", "Lcom/android/ttcjpaysdk/base/ui/data/CJPayTopRightBtnInfo;", "bdpay-front-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final UnifyPreVerifyType fromTopRightBtnInfo(CJPayTopRightBtnInfo r100) {
            if (r100 == null) goto L4;
            String r101 = r100.action;
        L5:
            if (r101 == null) goto L41;
            switch(r101.hashCode()) {
                case -1776785786: goto L37;
                case -1541143826: goto L33;
                case -897951205: goto L29;
                case -815673456: goto L25;
                case -475465479: goto L21;
                case -220465025: goto L17;
                case 1833222387: goto L14;
                case 2103775565: goto L10;
                default: goto L41;
            };
        L10:
            if (r101.equals("forget_pwd_verify") == false) goto L41;
            return UnifyPreVerifyType.VERIFY_TYPE_FACE;
        L14:
            if (r101.equals("forget_pwd_sms_verify") == false) goto L41;
        L43:
            return UnifyPreVerifyType.VERIFY_TYPE_SMS;
        L17:
            if (r101.equals("on_sms_verify") == true) goto L43;
        L21:
            if (r101.equals("no_pwd_verify") == false) goto L41;
            return UnifyPreVerifyType.VERIFY_TYPE_ONE_STEP_PAY;
        L25:
            if (r101.equals("bio_verify") == false) goto L41;
            return UnifyPreVerifyType.VERIFY_TYPE_FINGERPRINT;
        L29:
            if (r101.equals("on_pwd_verify") == false) goto L41;
            return UnifyPreVerifyType.VERIFY_TYPE_PWD;
        L33:
            if (r101.equals(UnifyCashierRenderInfo.StandardVerifyInfo.ACTION_CARRIER) == false) goto L41;
            return UnifyPreVerifyType.VERIFY_TYPE_CARRIER;
        L37:
            if (r101.equals("on_voice_verify") == false) goto L41;
            return UnifyPreVerifyType.VERIFY_TYPE_VOICE_PRINT;
        L41:
            return UnifyPreVerifyType.VERIFY_TYPE_UNKNOWN;
        L4:
            r101 = null;
            goto L5
        }
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r100 = new int[UnifyPreVerifyType.values().length];
            r100[UnifyPreVerifyType.VERIFY_TYPE_PWD.ordinal()] = 1;     // Catch: NoSuchFieldError -> L20
        L53:
            r100[UnifyPreVerifyType.VERIFY_TYPE_SET_PWD.ordinal()] = 2;     // Catch: NoSuchFieldError -> L21
        L63:
            r100[UnifyPreVerifyType.VERIFY_TYPE_FINGERPRINT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L22
        L39:
            r100[UnifyPreVerifyType.VERIFY_TYPE_LOCAL_FINGERPRINT.ordinal()] = 4;     // Catch: NoSuchFieldError -> L23
        L41:
            r100[UnifyPreVerifyType.VERIFY_TYPE_OPEN_FINGERPRINT.ordinal()] = 5;     // Catch: NoSuchFieldError -> L24
        L49:
            r100[UnifyPreVerifyType.VERIFY_TYPE_SMS.ordinal()] = 6;     // Catch: NoSuchFieldError -> L25
        L59:
            r100[UnifyPreVerifyType.VERIFY_TYPE_RISK_SMS.ordinal()] = 7;     // Catch: NoSuchFieldError -> L26
        L45:
            r100[UnifyPreVerifyType.VERIFY_TYPE_CARD_SIGN.ordinal()] = 8;     // Catch: NoSuchFieldError -> L27
        L55:
            r100[UnifyPreVerifyType.VERIFY_TYPE_ONE_STEP_PAY.ordinal()] = 9;     // Catch: NoSuchFieldError -> L28
        L57:
            r100[UnifyPreVerifyType.VERIFY_TYPE_SKIP_VERIFY.ordinal()] = 10;     // Catch: NoSuchFieldError -> L29
        L37:
            r100[UnifyPreVerifyType.VERIFY_TYPE_TOKEN.ordinal()] = 11;     // Catch: NoSuchFieldError -> L30
        L51:
            r100[UnifyPreVerifyType.VERIFY_TYPE_CVV.ordinal()] = 12;     // Catch: NoSuchFieldError -> L31
        L61:
            r100[UnifyPreVerifyType.VERIFY_TYPE_FACE.ordinal()] = 13;     // Catch: NoSuchFieldError -> L32
        L35:
            r100[UnifyPreVerifyType.VERIFY_TYPE_VOICE_PRINT.ordinal()] = 14;     // Catch: NoSuchFieldError -> L33
        L43:
            r100[UnifyPreVerifyType.VERIFY_TYPE_CARRIER.ordinal()] = 15;     // Catch: NoSuchFieldError -> L34
        L18:
            $EnumSwitchMapping$0 = r100;
        }
    }

    private static final /* synthetic */ UnifyPreVerifyType[] $values() {
        return new UnifyPreVerifyType[]{VERIFY_TYPE_CLIENT_DEGRADE, VERIFY_TYPE_PWD, VERIFY_TYPE_FINGERPRINT, VERIFY_TYPE_LOCAL_FINGERPRINT, VERIFY_TYPE_OPEN_FINGERPRINT, VERIFY_TYPE_FACE, VERIFY_TYPE_VOICE_PRINT, VERIFY_TYPE_CARRIER, VERIFY_TYPE_SMS, VERIFY_TYPE_RISK_SMS, VERIFY_TYPE_CARD_SIGN, VERIFY_TYPE_ONE_STEP_PAY, VERIFY_TYPE_SKIP_VERIFY, VERIFY_TYPE_TOKEN, VERIFY_TYPE_SET_PWD, VERIFY_TYPE_UNKNOWN, VERIFY_TYPE_CVV};
    }

    public static UnifyPreVerifyType valueOf(String r100) {
        return (UnifyPreVerifyType) a.a(UnifyPreVerifyType.class, r100);
    }

    public static UnifyPreVerifyType[] values() {
        return (UnifyPreVerifyType[]) $VALUES.clone();
    }

    static {
        VERIFY_TYPE_CLIENT_DEGRADE = new UnifyPreVerifyType("VERIFY_TYPE_CLIENT_DEGRADE", 0, "client_degrade");
        VERIFY_TYPE_PWD = new UnifyPreVerifyType("VERIFY_TYPE_PWD", 1, "pwd");
        VERIFY_TYPE_FINGERPRINT = new UnifyPreVerifyType("VERIFY_TYPE_FINGERPRINT", 2, HiAnalyticsConstant.HaKey.BI_KEY_FINGERPRINT);
        VERIFY_TYPE_LOCAL_FINGERPRINT = new UnifyPreVerifyType("VERIFY_TYPE_LOCAL_FINGERPRINT", 3, "local_fingerprint");
        VERIFY_TYPE_OPEN_FINGERPRINT = new UnifyPreVerifyType("VERIFY_TYPE_OPEN_FINGERPRINT", 4, "open_fingerprint");
        VERIFY_TYPE_FACE = new UnifyPreVerifyType("VERIFY_TYPE_FACE", 5, w.BLOB_ELEM_TYPE_FACE);
        VERIFY_TYPE_VOICE_PRINT = new UnifyPreVerifyType("VERIFY_TYPE_VOICE_PRINT", 6, "on_voice_verify");
        VERIFY_TYPE_CARRIER = new UnifyPreVerifyType("VERIFY_TYPE_CARRIER", 7, UnifyCashierRenderInfo.StandardVerifyInfo.ACTION_CARRIER);
        VERIFY_TYPE_SMS = new UnifyPreVerifyType("VERIFY_TYPE_SMS", 8, "sms");
        VERIFY_TYPE_RISK_SMS = new UnifyPreVerifyType("VERIFY_TYPE_RISK_SMS", 9, "risk_sms");
        VERIFY_TYPE_CARD_SIGN = new UnifyPreVerifyType("VERIFY_TYPE_CARD_SIGN", 10, "card_sign");
        VERIFY_TYPE_ONE_STEP_PAY = new UnifyPreVerifyType("VERIFY_TYPE_ONE_STEP_PAY", 11, "one_step_pay");
        VERIFY_TYPE_SKIP_VERIFY = new UnifyPreVerifyType("VERIFY_TYPE_SKIP_VERIFY", 12, "skip_verify");
        VERIFY_TYPE_TOKEN = new UnifyPreVerifyType("VERIFY_TYPE_TOKEN", 13, "token");
        VERIFY_TYPE_SET_PWD = new UnifyPreVerifyType("VERIFY_TYPE_SET_PWD", 14, "set_pwd");
        VERIFY_TYPE_UNKNOWN = new UnifyPreVerifyType("VERIFY_TYPE_UNKNOWN", 15, "unknown");
        VERIFY_TYPE_CVV = new UnifyPreVerifyType("VERIFY_TYPE_CVV", 16, "cvv");
        $VALUES = $values();
        Companion = new Companion(null);
    }

    public final int toCheckType() {
        switch(WhenMappings.$EnumSwitchMapping$0[ordinal()]) {
            case 1: goto L16;
            case 2: goto L16;
            case 3: goto L14;
            case 4: goto L14;
            case 5: goto L14;
            case 6: goto L13;
            case 7: goto L13;
            case 8: goto L12;
            case 9: goto L11;
            case 10: goto L10;
            case 11: goto L9;
            case 12: goto L8;
            case 13: goto L7;
            case 14: goto L6;
            case 15: goto L5;
            default: goto L4;
        };
    L4:
        return -1;
    L5:
        return 13;
    L6:
        return 12;
    L7:
        return 11;
    L8:
        return 7;
    L9:
        return 6;
    L10:
        return 5;
    L11:
        return 3;
    L12:
        return 100;
    L13:
        return 8;
    L14:
        return 1;
    L16:
        return 0;
    }

    public final String getValue() {
        return this.value;
    }

    private UnifyPreVerifyType(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
