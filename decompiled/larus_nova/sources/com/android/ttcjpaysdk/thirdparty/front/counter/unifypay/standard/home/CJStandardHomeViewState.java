package com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.standard.home;

import com.android.ttcjpaysdk.kmp.common.pay_ability.cancel_retain.api.CancelRetainContactInfoFunctions;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/standard/home/CJStandardHomeViewState;", "", "(Ljava/lang/String;I)V", UserProfileEvent.POSITION_NONE, "PASSWORD", CancelRetainContactInfoFunctions.SMS, CancelRetainContactInfoFunctions.CVV, "STAY", "ONE_STEP_PAY", "DOUBLE_CONFIRM", "bdpay-front-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final enum CJStandardHomeViewState extends Enum<CJStandardHomeViewState> {
    private static final /* synthetic */ CJStandardHomeViewState[] $VALUES = null;
    public static final CJStandardHomeViewState CVV = null;
    public static final CJStandardHomeViewState DOUBLE_CONFIRM = null;
    public static final CJStandardHomeViewState NONE = null;
    public static final CJStandardHomeViewState ONE_STEP_PAY = null;
    public static final CJStandardHomeViewState PASSWORD = null;
    public static final CJStandardHomeViewState SMS = null;
    public static final CJStandardHomeViewState STAY = null;

    private static final /* synthetic */ CJStandardHomeViewState[] $values() {
        return new CJStandardHomeViewState[]{NONE, PASSWORD, SMS, CVV, STAY, ONE_STEP_PAY, DOUBLE_CONFIRM};
    }

    public static CJStandardHomeViewState valueOf(String r100) {
        return (CJStandardHomeViewState) a.a(CJStandardHomeViewState.class, r100);
    }

    public static CJStandardHomeViewState[] values() {
        return (CJStandardHomeViewState[]) $VALUES.clone();
    }

    static {
        NONE = new CJStandardHomeViewState(UserProfileEvent.POSITION_NONE, 0);
        PASSWORD = new CJStandardHomeViewState("PASSWORD", 1);
        SMS = new CJStandardHomeViewState(CancelRetainContactInfoFunctions.SMS, 2);
        CVV = new CJStandardHomeViewState(CancelRetainContactInfoFunctions.CVV, 3);
        STAY = new CJStandardHomeViewState("STAY", 4);
        ONE_STEP_PAY = new CJStandardHomeViewState("ONE_STEP_PAY", 5);
        DOUBLE_CONFIRM = new CJStandardHomeViewState("DOUBLE_CONFIRM", 6);
        $VALUES = $values();
    }

    private CJStandardHomeViewState(String r100, int r101) {
        super(r100, r101);
    }
}
