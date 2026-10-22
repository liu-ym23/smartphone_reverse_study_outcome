package com.android.ttcjpaysdk.base.ui.dialog;

import com.android.ttcjpaysdk.kmp.common.pay_ability.cancel_retain.api.CancelRetainEventTypes;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import r27.a;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001f\b\u0086\u0001\u0018\u0000 !2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001!B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b ¨\u0006\""}, d2 = {"Lcom/android/ttcjpaysdk/base/ui/dialog/LynxDialogEvent;", "", "eventName", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getEventName", "()Ljava/lang/String;", "CCM_EVENT_CLOSE_AWARD_POPUP", "ON_CONFIRM", "ON_CANCEL", "ON_CANCEL_AND_LEAVE", "ON_CANCEL_AND_BACK", "ON_CHANGE_PAY_METHOD", "ON_OTHER_VERIFY", "ON_CHANGE_OTHER_VERIFY", "ON_REINPUT_PWD", "STATUS_PAGE_LOAD_SUCCESS", "ON_PAY", "ON_SELECT_PAY", "ON_SMS_VERIFY", "ON_BIO_VERIFY", "ON_RESET_PWD", "ON_MODIFY_PWD", "ON_SELECT_AGREEMENT", "ON_UNSELECT_AGREEMENT", "ON_CONFIRM_WITHOUT_AGREEMENT", "ON_AGREEMENT_POPUP_CONFIRM", "ON_AGREEMENT_POPUP_CANCEL", "ON_BIO_OPEN_AND_VERIFY", "ON_STAY_CURRENT_PAGE", "ON_CONTINUE_PAY_PROCESS", "CJPAY_GO_TO_PROMOTION", "ON_UNKNOWN", "Companion", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final enum LynxDialogEvent extends Enum<LynxDialogEvent> {
    private static final /* synthetic */ LynxDialogEvent[] $VALUES = null;
    public static final LynxDialogEvent CCM_EVENT_CLOSE_AWARD_POPUP = null;
    public static final LynxDialogEvent CJPAY_GO_TO_PROMOTION = null;
    public static final Companion Companion = null;
    public static final LynxDialogEvent ON_AGREEMENT_POPUP_CANCEL = null;
    public static final LynxDialogEvent ON_AGREEMENT_POPUP_CONFIRM = null;
    public static final LynxDialogEvent ON_BIO_OPEN_AND_VERIFY = null;
    public static final LynxDialogEvent ON_BIO_VERIFY = null;
    public static final LynxDialogEvent ON_CANCEL = null;
    public static final LynxDialogEvent ON_CANCEL_AND_BACK = null;
    public static final LynxDialogEvent ON_CANCEL_AND_LEAVE = null;
    public static final LynxDialogEvent ON_CHANGE_OTHER_VERIFY = null;
    public static final LynxDialogEvent ON_CHANGE_PAY_METHOD = null;
    public static final LynxDialogEvent ON_CONFIRM = null;
    public static final LynxDialogEvent ON_CONFIRM_WITHOUT_AGREEMENT = null;
    public static final LynxDialogEvent ON_CONTINUE_PAY_PROCESS = null;
    public static final LynxDialogEvent ON_MODIFY_PWD = null;
    public static final LynxDialogEvent ON_OTHER_VERIFY = null;
    public static final LynxDialogEvent ON_PAY = null;
    public static final LynxDialogEvent ON_REINPUT_PWD = null;
    public static final LynxDialogEvent ON_RESET_PWD = null;
    public static final LynxDialogEvent ON_SELECT_AGREEMENT = null;
    public static final LynxDialogEvent ON_SELECT_PAY = null;
    public static final LynxDialogEvent ON_SMS_VERIFY = null;
    public static final LynxDialogEvent ON_STAY_CURRENT_PAGE = null;
    public static final LynxDialogEvent ON_UNKNOWN = null;
    public static final LynxDialogEvent ON_UNSELECT_AGREEMENT = null;
    public static final LynxDialogEvent STATUS_PAGE_LOAD_SUCCESS = null;
    private final String eventName;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/android/ttcjpaysdk/base/ui/dialog/LynxDialogEvent$Companion;", "", "()V", "fromString", "Lcom/android/ttcjpaysdk/base/ui/dialog/LynxDialogEvent;", "value", "", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final LynxDialogEvent fromString(String r100) {
            Intrinsics.checkNotNullParameter(r100, "value");
            LynxDialogEvent[] r101 = LynxDialogEvent.values();
            int r102 = r101.length;
            int r103 = 0;
        L3:
            if (r103 >= r102) goto L9;
            LynxDialogEvent r104 = r101[r103];
            if (Intrinsics.areEqual(r104.getEventName(), r100) == true) goto L6;
            r103 = r103 + 1;
            goto L3
        L6:
            return r104;
        L9:
            throw new NoSuchElementException("Array contains no element matching the predicate.");
        }
    }

    private static final /* synthetic */ LynxDialogEvent[] $values() {
        return new LynxDialogEvent[]{CCM_EVENT_CLOSE_AWARD_POPUP, ON_CONFIRM, ON_CANCEL, ON_CANCEL_AND_LEAVE, ON_CANCEL_AND_BACK, ON_CHANGE_PAY_METHOD, ON_OTHER_VERIFY, ON_CHANGE_OTHER_VERIFY, ON_REINPUT_PWD, STATUS_PAGE_LOAD_SUCCESS, ON_PAY, ON_SELECT_PAY, ON_SMS_VERIFY, ON_BIO_VERIFY, ON_RESET_PWD, ON_MODIFY_PWD, ON_SELECT_AGREEMENT, ON_UNSELECT_AGREEMENT, ON_CONFIRM_WITHOUT_AGREEMENT, ON_AGREEMENT_POPUP_CONFIRM, ON_AGREEMENT_POPUP_CANCEL, ON_BIO_OPEN_AND_VERIFY, ON_STAY_CURRENT_PAGE, ON_CONTINUE_PAY_PROCESS, CJPAY_GO_TO_PROMOTION, ON_UNKNOWN};
    }

    public static LynxDialogEvent valueOf(String r100) {
        return (LynxDialogEvent) a.a(LynxDialogEvent.class, r100);
    }

    public static LynxDialogEvent[] values() {
        return (LynxDialogEvent[]) $VALUES.clone();
    }

    static {
        CCM_EVENT_CLOSE_AWARD_POPUP = new LynxDialogEvent("CCM_EVENT_CLOSE_AWARD_POPUP", 0, "ccm_event_close_award_popup");
        ON_CONFIRM = new LynxDialogEvent("ON_CONFIRM", 1, "on_confirm");
        ON_CANCEL = new LynxDialogEvent("ON_CANCEL", 2, CancelRetainEventTypes.OnCancel);
        ON_CANCEL_AND_LEAVE = new LynxDialogEvent("ON_CANCEL_AND_LEAVE", 3, CancelRetainEventTypes.OnCancelAndLeave);
        ON_CANCEL_AND_BACK = new LynxDialogEvent("ON_CANCEL_AND_BACK", 4, CancelRetainEventTypes.OnCancelAndBack);
        ON_CHANGE_PAY_METHOD = new LynxDialogEvent("ON_CHANGE_PAY_METHOD", 5, CancelRetainEventTypes.OnChangePayMethod);
        ON_OTHER_VERIFY = new LynxDialogEvent("ON_OTHER_VERIFY", 6, "on_other_verify");
        ON_CHANGE_OTHER_VERIFY = new LynxDialogEvent("ON_CHANGE_OTHER_VERIFY", 7, CancelRetainEventTypes.OnChangeOtherVerify);
        ON_REINPUT_PWD = new LynxDialogEvent("ON_REINPUT_PWD", 8, "on_reinput_pwd");
        STATUS_PAGE_LOAD_SUCCESS = new LynxDialogEvent("STATUS_PAGE_LOAD_SUCCESS", 9, "status_page_load_success");
        ON_PAY = new LynxDialogEvent("ON_PAY", 10, "on_pay");
        ON_SELECT_PAY = new LynxDialogEvent("ON_SELECT_PAY", 11, "on_select_pay");
        ON_SMS_VERIFY = new LynxDialogEvent("ON_SMS_VERIFY", 12, "on_sms_verify");
        ON_BIO_VERIFY = new LynxDialogEvent("ON_BIO_VERIFY", 13, "on_bio_verify");
        ON_RESET_PWD = new LynxDialogEvent("ON_RESET_PWD", 14, "on_reset_pwd");
        ON_MODIFY_PWD = new LynxDialogEvent("ON_MODIFY_PWD", 15, "on_modify_pwd");
        ON_SELECT_AGREEMENT = new LynxDialogEvent("ON_SELECT_AGREEMENT", 16, "on_select_agreement");
        ON_UNSELECT_AGREEMENT = new LynxDialogEvent("ON_UNSELECT_AGREEMENT", 17, "on_unselect_agreement");
        ON_CONFIRM_WITHOUT_AGREEMENT = new LynxDialogEvent("ON_CONFIRM_WITHOUT_AGREEMENT", 18, "on_confirm_without_agreement");
        ON_AGREEMENT_POPUP_CONFIRM = new LynxDialogEvent("ON_AGREEMENT_POPUP_CONFIRM", 19, "on_agreement_popup_confirm");
        ON_AGREEMENT_POPUP_CANCEL = new LynxDialogEvent("ON_AGREEMENT_POPUP_CANCEL", 20, "on_agreement_popup_cancel");
        ON_BIO_OPEN_AND_VERIFY = new LynxDialogEvent("ON_BIO_OPEN_AND_VERIFY", 21, "on_bio_open_and_verify");
        ON_STAY_CURRENT_PAGE = new LynxDialogEvent("ON_STAY_CURRENT_PAGE", 22, CancelRetainEventTypes.OnStayCurrentPage);
        ON_CONTINUE_PAY_PROCESS = new LynxDialogEvent("ON_CONTINUE_PAY_PROCESS", 23, CancelRetainEventTypes.OnContinuePayProcess);
        CJPAY_GO_TO_PROMOTION = new LynxDialogEvent("CJPAY_GO_TO_PROMOTION", 24, "cjpay_go_to_promotion");
        ON_UNKNOWN = new LynxDialogEvent("ON_UNKNOWN", 25, "unknown");
        $VALUES = $values();
        Companion = new Companion(null);
    }

    public final String getEventName() {
        return this.eventName;
    }

    private LynxDialogEvent(String r100, int r101, String r102) {
        super(r100, r101);
        this.eventName = r102;
    }
}
