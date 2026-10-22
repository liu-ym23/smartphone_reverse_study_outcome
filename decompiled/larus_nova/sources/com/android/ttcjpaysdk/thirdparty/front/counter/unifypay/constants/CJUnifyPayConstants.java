package com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.constants;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0005"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/constants/CJUnifyPayConstants;", "", "()V", "IntegratedCode", "Method", "bdpay-front-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJUnifyPayConstants {
    public static final CJUnifyPayConstants INSTANCE = null;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/constants/CJUnifyPayConstants$IntegratedCode;", "", "()V", "RESPONSE_LOGIN_INVALID", "", "SUCCESS", "bdpay-front-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class IntegratedCode {
        public static final IntegratedCode INSTANCE = null;
        public static final String RESPONSE_LOGIN_INVALID = "GW400008";
        public static final String SUCCESS = "CA0000";

        static {
            INSTANCE = new IntegratedCode();
        }

        private IntegratedCode() {
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/constants/CJUnifyPayConstants$Method;", "", "()V", "NEW_CARD_PRE_CHARGE", "", "THREE_DOMAIN_SECURITY_SET_UP", "TRADE_CONFIRM", "TRADE_CONFIRM_INTEGRATED", "TRADE_QUERY", "TRADE_QUERY_INTEGRATED", "TRADE_VERIFY", "bdpay-front-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Method {
        public static final Method INSTANCE = null;
        public static final String NEW_CARD_PRE_CHARGE = "bytepay.cashdesk.new_card_pre_charge";
        public static final String THREE_DOMAIN_SECURITY_SET_UP = "bytepay.cashdesk.three_domain_security_set_up";
        public static final String TRADE_CONFIRM = "bytepay.cashdesk.trade_confirm";
        public static final String TRADE_CONFIRM_INTEGRATED = "tp.cashier.trade_confirm";
        public static final String TRADE_QUERY = "bytepay.cashdesk.trade_query";
        public static final String TRADE_QUERY_INTEGRATED = "tp.cashier.trade_query";
        public static final String TRADE_VERIFY = "bytepay.cashdesk.trade_verify";

        static {
            INSTANCE = new Method();
        }

        private Method() {
        }
    }

    static {
        INSTANCE = new CJUnifyPayConstants();
    }

    private CJUnifyPayConstants() {
    }
}
