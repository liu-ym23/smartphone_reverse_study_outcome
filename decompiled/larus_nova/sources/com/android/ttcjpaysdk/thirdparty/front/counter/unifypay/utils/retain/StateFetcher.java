package com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.utils.retain;

import com.android.ttcjpaysdk.thirdparty.data.CJPayUserInfo;
import com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.preverify.model.UnifyPreVerifyType;
import com.android.ttcjpaysdk.thirdparty.utils.retaindialog.bean.CJPayBehavior;
import com.android.ttcjpaysdk.thirdparty.utils.retaindialog.bean.CJPayFunction;
import com.android.ttcjpaysdk.thirdparty.utils.retaindialog.bean.CJPayProcess;
import com.android.ttcjpaysdk.thirdparty.utils.retaindialog.bean.CJPayRetainContactInfo;
import com.android.ttcjpaysdk.thirdparty.utils.retaindialog.bean.CJPayUserState;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B=\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\rR\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u000e\u001a\u00020\u000f8F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0012R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/utils/retain/StateFetcher;", "", "curPreVerifyType", "Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/preverify/model/UnifyPreVerifyType;", "hasPrePay", "", "payAndXStatus", "process", "Lcom/android/ttcjpaysdk/thirdparty/utils/retaindialog/bean/CJPayProcess;", "behavior", "Lcom/android/ttcjpaysdk/thirdparty/utils/retaindialog/bean/CJPayBehavior;", "cjPayUserInfo", "Lcom/android/ttcjpaysdk/thirdparty/data/CJPayUserInfo;", "(Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/preverify/model/UnifyPreVerifyType;ZLjava/lang/Boolean;Lcom/android/ttcjpaysdk/thirdparty/utils/retaindialog/bean/CJPayProcess;Lcom/android/ttcjpaysdk/thirdparty/utils/retaindialog/bean/CJPayBehavior;Lcom/android/ttcjpaysdk/thirdparty/data/CJPayUserInfo;)V", "curContactInfo", "Lcom/android/ttcjpaysdk/thirdparty/utils/retaindialog/bean/CJPayRetainContactInfo;", "getCurContactInfo", "()Lcom/android/ttcjpaysdk/thirdparty/utils/retaindialog/bean/CJPayRetainContactInfo;", "Ljava/lang/Boolean;", "bdpay-front-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class StateFetcher {
    private final CJPayBehavior behavior;
    private final CJPayUserInfo cjPayUserInfo;
    private final UnifyPreVerifyType curPreVerifyType;
    private final boolean hasPrePay;
    private final Boolean payAndXStatus;
    private final CJPayProcess process;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1 = null;

        static {
            int[] r100 = new int[UnifyPreVerifyType.values().length];
            r100[UnifyPreVerifyType.VERIFY_TYPE_PWD.ordinal()] = 1;     // Catch: NoSuchFieldError -> L18
        L31:
            r100[UnifyPreVerifyType.VERIFY_TYPE_FINGERPRINT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L19
        L47:
            r100[UnifyPreVerifyType.VERIFY_TYPE_LOCAL_FINGERPRINT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L20
        L37:
            r100[UnifyPreVerifyType.VERIFY_TYPE_OPEN_FINGERPRINT.ordinal()] = 4;     // Catch: NoSuchFieldError -> L21
        L39:
            r100[UnifyPreVerifyType.VERIFY_TYPE_SMS.ordinal()] = 5;     // Catch: NoSuchFieldError -> L22
        L29:
            r100[UnifyPreVerifyType.VERIFY_TYPE_ONE_STEP_PAY.ordinal()] = 6;     // Catch: NoSuchFieldError -> L23
        L41:
            r100[UnifyPreVerifyType.VERIFY_TYPE_SKIP_VERIFY.ordinal()] = 7;     // Catch: NoSuchFieldError -> L24
        L43:
            r100[UnifyPreVerifyType.VERIFY_TYPE_TOKEN.ordinal()] = 8;     // Catch: NoSuchFieldError -> L25
        L33:
            r100[UnifyPreVerifyType.VERIFY_TYPE_FACE.ordinal()] = 9;     // Catch: NoSuchFieldError -> L26
        L13:
            $EnumSwitchMapping$0 = r100;
            int[] r101 = new int[CJPayProcess.values().length];
            r101[CJPayProcess.ConfirmPayment.ordinal()] = 1;     // Catch: NoSuchFieldError -> L27
        L49:
            r101[CJPayProcess.ConfirmAndVerify.ordinal()] = 2;     // Catch: NoSuchFieldError -> L28
        L16:
            $EnumSwitchMapping$1 = r101;
        }
    }

    public final CJPayRetainContactInfo getCurContactInfo() {
        if (this.hasPrePay == false) goto L5;
        CJPayFunction r100 = CJPayFunction.Default;
    L29:
        Boolean r101 = this.payAndXStatus;
        if (Intrinsics.areEqual(r101, Boolean.TRUE) == false) goto L33;
        String r102 = "PayAndX#open";
    L37:
        CJPayBehavior r103 = this.behavior;
        CJPayProcess r104 = this.process;
        int r105 = WhenMappings.$EnumSwitchMapping$1[r104.ordinal()];
        if (r105 != 1) goto L40;
        CJPayRetainContactInfo r106 = new CJPayRetainContactInfo(this.process, r100, r103, new CJPayUserState(r102));
    L45:
        return r106;
    L40:
        if (r105 != 2) goto L48;
        r106 = new CJPayRetainContactInfo(this.process, r100, r103, new CJPayUserState(r102));
        goto L45
    L48:
        return new CJPayRetainContactInfo(this.process, null, null, null, 14, null);
    L33:
        if (Intrinsics.areEqual(r101, Boolean.FALSE) == false) goto L35;
        r102 = "PayAndX#close";
        goto L37
    L35:
        if (r101 != null) goto L47;
        r102 = "";
        goto L37
    L47:
        throw new NoWhenBranchMatchedException();
    L5:
        UnifyPreVerifyType r107 = this.curPreVerifyType;
        if (r107 != null) goto L8;
        int r108 = -1;
    L9:
        switch(r108) {
            case 1: goto L19;
            case 2: goto L18;
            case 3: goto L17;
            case 4: goto L16;
            case 5: goto L15;
            case 6: goto L14;
            case 7: goto L13;
            case 8: goto L12;
            case 9: goto L11;
            default: goto L10;
        };
    L10:
        r100 = CJPayFunction.Default;
        goto L29
    L11:
        r100 = CJPayFunction.Live;
        goto L29
    L12:
        r100 = CJPayFunction.Token;
        goto L29
    L13:
        r100 = CJPayFunction.SkipVerify;
        goto L29
    L14:
        r100 = CJPayFunction.NoPassword;
        goto L29
    L15:
        r100 = CJPayFunction.SMS;
        goto L29
    L16:
        r100 = CJPayFunction.Finger;
        goto L29
    L17:
        r100 = CJPayFunction.Finger;
        goto L29
    L18:
        r100 = CJPayFunction.Finger;
        goto L29
    L19:
        CJPayUserInfo r109 = this.cjPayUserInfo;
        if (r109 == null) goto L24;
        CJPayUserInfo.ExtInfo r110 = r109.ext_info;
        if (r110 == null) goto L24;
        String r111 = r110.pwd_type;
    L26:
        if (Intrinsics.areEqual(r111, "set_pwd") == false) goto L28;
        r100 = CJPayFunction.SetPassword;
        goto L29
    L28:
        r100 = CJPayFunction.Password;
    L24:
        r111 = null;
        goto L26
    L8:
        r108 = WhenMappings.$EnumSwitchMapping$0[r107.ordinal()];
        goto L9
    }

    public StateFetcher(UnifyPreVerifyType r100, boolean r101, Boolean r102, CJPayProcess r103, CJPayBehavior r104, CJPayUserInfo r105) {
        Intrinsics.checkNotNullParameter(r103, "process");
        this.curPreVerifyType = r100;
        this.hasPrePay = r101;
        this.payAndXStatus = r102;
        this.process = r103;
        this.behavior = r104;
        this.cjPayUserInfo = r105;
    }
}
