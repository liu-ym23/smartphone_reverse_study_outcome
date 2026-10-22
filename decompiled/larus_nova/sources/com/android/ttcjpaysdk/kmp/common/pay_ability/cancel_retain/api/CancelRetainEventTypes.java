package com.android.ttcjpaysdk.kmp.common.pay_ability.cancel_retain.api;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0012\u0010\u0004\u001a\u00060\u0005j\u0002`\u0006X\u0086T¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00060\u0005j\u0002`\u0006X\u0086T¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00060\u0005j\u0002`\u0006X\u0086T¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u00060\u0005j\u0002`\u0006X\u0086T¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u00060\u0005j\u0002`\u0006X\u0086T¢\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u00060\u0005j\u0002`\u0006X\u0086T¢\u0006\u0002\n\u0000R\u0012\u0010\f\u001a\u00060\u0005j\u0002`\u0006X\u0086T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/android/ttcjpaysdk/kmp/common/pay_ability/cancel_retain/api/CancelRetainEventTypes;", "", "<init>", "()V", "OnCancel", "", "Lcom/android/ttcjpaysdk/kmp/common/pay_ability/cancel_retain/api/CJPayRetainEventType;", "OnStayCurrentPage", "OnCancelAndLeave", "OnChangePayMethod", "OnContinuePayProcess", "OnChangeOtherVerify", "OnCancelAndBack", "cj_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CancelRetainEventTypes {
    public static final int $stable = 0;
    public static final CancelRetainEventTypes INSTANCE = null;
    public static final String OnCancel = "on_cancel";
    public static final String OnCancelAndBack = "on_cancel_and_back";
    public static final String OnCancelAndLeave = "on_cancel_and_leave";
    public static final String OnChangeOtherVerify = "on_change_other_verify";
    public static final String OnChangePayMethod = "on_change_pay_method";
    public static final String OnContinuePayProcess = "on_continue_pay_process";
    public static final String OnStayCurrentPage = "on_stay_current_page";

    static {
        INSTANCE = new CancelRetainEventTypes();
    }

    private CancelRetainEventTypes() {
    }
}
