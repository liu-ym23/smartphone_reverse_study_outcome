package com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.utils.retain;

import com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.preverify.model.UnifyPreVerifyType;
import com.android.ttcjpaysdk.thirdparty.utils.retaindialog.bean.CJPayBehavior;
import com.android.ttcjpaysdk.thirdparty.utils.retaindialog.bean.CJPayFunction;
import com.android.ttcjpaysdk.thirdparty.utils.retaindialog.bean.CJPayProcess;
import com.android.ttcjpaysdk.thirdparty.utils.retaindialog.bean.CJPayRetainContactInfo;
import com.android.ttcjpaysdk.thirdparty.utils.retaindialog.bean.CJPayUserState;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/utils/retain/SubmitPayStateFetcher;", "", "curPreVerifyType", "Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/preverify/model/UnifyPreVerifyType;", "hasPwdInput", "", "(Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/preverify/model/UnifyPreVerifyType;Z)V", "curContactInfo", "Lcom/android/ttcjpaysdk/thirdparty/utils/retaindialog/bean/CJPayRetainContactInfo;", "getCurContactInfo", "()Lcom/android/ttcjpaysdk/thirdparty/utils/retaindialog/bean/CJPayRetainContactInfo;", "bdpay-front-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SubmitPayStateFetcher {
    private final UnifyPreVerifyType curPreVerifyType;
    private final boolean hasPwdInput;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1 = null;

        static {
            int[] r100 = new int[UnifyPreVerifyType.values().length];
            r100[UnifyPreVerifyType.VERIFY_TYPE_ONE_STEP_PAY.ordinal()] = 1;     // Catch: NoSuchFieldError -> L14
        L24:
            r100[UnifyPreVerifyType.VERIFY_TYPE_PWD.ordinal()] = 2;     // Catch: NoSuchFieldError -> L15
        L36:
            r100[UnifyPreVerifyType.VERIFY_TYPE_SMS.ordinal()] = 3;     // Catch: NoSuchFieldError -> L16
        L26:
            r100[UnifyPreVerifyType.VERIFY_TYPE_FINGERPRINT.ordinal()] = 4;     // Catch: NoSuchFieldError -> L17
        L28:
            r100[UnifyPreVerifyType.VERIFY_TYPE_LOCAL_FINGERPRINT.ordinal()] = 5;     // Catch: NoSuchFieldError -> L18
        L22:
            r100[UnifyPreVerifyType.VERIFY_TYPE_OPEN_FINGERPRINT.ordinal()] = 6;     // Catch: NoSuchFieldError -> L19
        L30:
            r100[UnifyPreVerifyType.VERIFY_TYPE_CARRIER.ordinal()] = 7;     // Catch: NoSuchFieldError -> L20
        L10:
            $EnumSwitchMapping$0 = r100;
            int[] r101 = new int[CJPayFunction.values().length];
            r101[CJPayFunction.Password.ordinal()] = 1;     // Catch: NoSuchFieldError -> L21
        L12:
            $EnumSwitchMapping$1 = r101;
        }
    }

    public final CJPayRetainContactInfo getCurContactInfo() {
        UnifyPreVerifyType r100 = this.curPreVerifyType;
        if (r100 != null) goto L5;
        int r101 = -1;
    L6:
        switch(r101) {
            case 1: goto L14;
            case 2: goto L13;
            case 3: goto L12;
            case 4: goto L11;
            case 5: goto L10;
            case 6: goto L9;
            case 7: goto L8;
            default: goto L7;
        };
    L7:
        CJPayFunction r102 = CJPayFunction.Default;
    L16:
        if (WhenMappings.$EnumSwitchMapping$1[r102.ordinal()] == 1) goto L18;
        String r103 = "Default";
    L23:
        return new CJPayRetainContactInfo(CJPayProcess.SubmitPay, r102, CJPayBehavior.ClosePage, new CJPayUserState(r103));
    L18:
        if (this.hasPwdInput == false) goto L20;
        r103 = "Input";
        goto L23
    L20:
        r103 = "Unput";
        goto L23
    L8:
        r102 = CJPayFunction.OnCarrierVerify;
        goto L16
    L9:
        r102 = CJPayFunction.Finger;
        goto L16
    L10:
        r102 = CJPayFunction.Finger;
        goto L16
    L11:
        r102 = CJPayFunction.Finger;
        goto L16
    L12:
        r102 = CJPayFunction.SMS;
        goto L16
    L13:
        r102 = CJPayFunction.Password;
        goto L16
    L14:
        r102 = CJPayFunction.NoPassword;
        goto L16
    L5:
        r101 = WhenMappings.$EnumSwitchMapping$0[r100.ordinal()];
        goto L6
    }

    public SubmitPayStateFetcher(UnifyPreVerifyType r100, boolean r101) {
        this.curPreVerifyType = r100;
        this.hasPwdInput = r101;
    }

    public /* synthetic */ SubmitPayStateFetcher(UnifyPreVerifyType r100, boolean r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = false;
    L5:
        this(r100, r101);
    }
}
