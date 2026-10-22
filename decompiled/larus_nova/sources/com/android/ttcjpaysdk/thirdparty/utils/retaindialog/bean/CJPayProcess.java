package com.android.ttcjpaysdk.thirdparty.utils.retaindialog.bean;

import com.android.ttcjpaysdk.base.json.CJPayObject;
import com.android.ttcjpaysdk.kmp.common.pay_ability.cancel_retain.api.CancelRetainContactInfoProcesses;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import r27.a;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0001\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002:\u0001\rB\u000f\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u000e"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/utils/retaindialog/bean/CJPayProcess;", "", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", CancelRetainContactInfoProcesses.ConfirmPayment, CancelRetainContactInfoProcesses.ConfirmAndVerify, "ConfirmFrontHomePage", "SubmitPay", "UNKNOWN", "Companion", "bdpay-base_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final enum CJPayProcess extends Enum<CJPayProcess> implements CJPayObject {
    private static final /* synthetic */ CJPayProcess[] $VALUES = null;
    public static final Companion Companion = null;
    public static final CJPayProcess ConfirmAndVerify = null;
    public static final CJPayProcess ConfirmFrontHomePage = null;
    public static final CJPayProcess ConfirmPayment = null;
    public static final CJPayProcess SubmitPay = null;
    public static final CJPayProcess UNKNOWN = null;
    private final String value;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/utils/retaindialog/bean/CJPayProcess$Companion;", "", "()V", "fromString", "Lcom/android/ttcjpaysdk/thirdparty/utils/retaindialog/bean/CJPayProcess;", "value", "", "bdpay-base_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final CJPayProcess fromString(String r100) {
            Intrinsics.checkNotNullParameter(r100, "value");
            CJPayProcess[] r101 = CJPayProcess.values();
            int r102 = r101.length;
            int r103 = 0;
        L3:
            if (r103 >= r102) goto L8;
            CJPayProcess r104 = r101[r103];
            if (Intrinsics.areEqual(r104.getValue(), r100) == true) goto L9;
            r103 = r103 + 1;
        L9:
            if (r104 == null) goto L11;
            return r104;
        L11:
            return CJPayProcess.UNKNOWN;
        L8:
            r104 = null;
            goto L9
        }
    }

    private static final /* synthetic */ CJPayProcess[] $values() {
        return new CJPayProcess[]{ConfirmPayment, ConfirmAndVerify, ConfirmFrontHomePage, SubmitPay, UNKNOWN};
    }

    public static CJPayProcess valueOf(String r100) {
        return (CJPayProcess) a.a(CJPayProcess.class, r100);
    }

    public static CJPayProcess[] values() {
        return (CJPayProcess[]) $VALUES.clone();
    }

    static {
        ConfirmPayment = new CJPayProcess(CancelRetainContactInfoProcesses.ConfirmPayment, 0, CancelRetainContactInfoProcesses.ConfirmPayment);
        ConfirmAndVerify = new CJPayProcess(CancelRetainContactInfoProcesses.ConfirmAndVerify, 1, CancelRetainContactInfoProcesses.ConfirmAndVerify);
        ConfirmFrontHomePage = new CJPayProcess("ConfirmFrontHomePage", 2, "ConfirmFrontHomePage");
        SubmitPay = new CJPayProcess("SubmitPay", 3, "SubmitPay");
        UNKNOWN = new CJPayProcess("UNKNOWN", 4, "UNKNOWN");
        $VALUES = $values();
        Companion = new Companion(null);
    }

    public final String getValue() {
        return this.value;
    }

    private CJPayProcess(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
