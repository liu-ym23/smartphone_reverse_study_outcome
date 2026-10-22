package com.android.ttcjpaysdk.thirdparty.utils.retaindialog;

import com.android.ttcjpaysdk.kmp.common.pay_ability.cancel_retain.api.CancelRetainBizTypes;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/utils/retaindialog/CJPayRetainDialogBusiness;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "UNIFY_CASHIER_HOME", "STANDARD_CASHIER_HOME", "bdpay-base_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final enum CJPayRetainDialogBusiness extends Enum<CJPayRetainDialogBusiness> {
    private static final /* synthetic */ CJPayRetainDialogBusiness[] $VALUES = null;
    public static final CJPayRetainDialogBusiness STANDARD_CASHIER_HOME = null;
    public static final CJPayRetainDialogBusiness UNIFY_CASHIER_HOME = null;
    private final String value;

    private static final /* synthetic */ CJPayRetainDialogBusiness[] $values() {
        return new CJPayRetainDialogBusiness[]{UNIFY_CASHIER_HOME, STANDARD_CASHIER_HOME};
    }

    public static CJPayRetainDialogBusiness valueOf(String r100) {
        return (CJPayRetainDialogBusiness) a.a(CJPayRetainDialogBusiness.class, r100);
    }

    public static CJPayRetainDialogBusiness[] values() {
        return (CJPayRetainDialogBusiness[]) $VALUES.clone();
    }

    static {
        UNIFY_CASHIER_HOME = new CJPayRetainDialogBusiness("UNIFY_CASHIER_HOME", 0, CancelRetainBizTypes.UnitedCashdesk);
        STANDARD_CASHIER_HOME = new CJPayRetainDialogBusiness("STANDARD_CASHIER_HOME", 1, "StandardCashdesk");
        $VALUES = $values();
    }

    public final String getValue() {
        return this.value;
    }

    private CJPayRetainDialogBusiness(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
