package com.android.ttcjpaysdk.bdpay.counter.outer.bean;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/android/ttcjpaysdk/bdpay/counter/outer/bean/CJOuterPayErrorInfo;", "", "()V", "ERROR_CODE_CASHIER_FREE_LOGIN_FAILED", "", "ERROR_CODE_GW_FREE_LOGIN_FAILED", "ERROR_CODE_TOKEN_INVALID_V1", "ERROR_CODE_TOKEN_INVALID_V2", "ERROR_CODE_UPGRADE", "bdpay-counter-outer_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJOuterPayErrorInfo {
    public static final String ERROR_CODE_CASHIER_FREE_LOGIN_FAILED = "CD000509";
    public static final String ERROR_CODE_GW_FREE_LOGIN_FAILED = "GW400024";
    public static final String ERROR_CODE_TOKEN_INVALID_V1 = "GW400008";
    public static final String ERROR_CODE_TOKEN_INVALID_V2 = "GW400009";
    public static final String ERROR_CODE_UPGRADE = "CD000026";
    public static final CJOuterPayErrorInfo INSTANCE = null;

    static {
        INSTANCE = new CJOuterPayErrorInfo();
    }

    private CJOuterPayErrorInfo() {
    }
}
