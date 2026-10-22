package com.android.ttcjpaysdk.bindcard.base.constants;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0006"}, d2 = {"Lcom/android/ttcjpaysdk/bindcard/base/constants/BindCardPayConfirmConstants;", "", "()V", "Event", "Key", "Value", "bdpay-bindcard-base_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class BindCardPayConfirmConstants {
    public static final BindCardPayConfirmConstants INSTANCE = null;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087T¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u00048\u0006X\u0087T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/android/ttcjpaysdk/bindcard/base/constants/BindCardPayConfirmConstants$Event;", "", "()V", "WALLET_CASHIER_BANKCARD_TIP_CLICK", "", "WALLET_CASHIER_BANKCARD_TIP_IMP", "bdpay-bindcard-base_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Event {
        public static final Event INSTANCE = null;
        public static final String WALLET_CASHIER_BANKCARD_TIP_CLICK = "wallet_cashier_bankcard_tip_click";
        public static final String WALLET_CASHIER_BANKCARD_TIP_IMP = "wallet_cashier_bankcard_tip_imp";

        static {
            INSTANCE = new Event();
        }

        private Event() {
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/android/ttcjpaysdk/bindcard/base/constants/BindCardPayConfirmConstants$Key;", "", "()V", "ACTIVITY_TITLE", "", "BUTTON_NAME", "IS_SHOW_FOREIGN_CARD_FEE", "POP_STYLE", "TRACE_ID", "bdpay-bindcard-base_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Key {
        public static final String ACTIVITY_TITLE = "activity_title";
        public static final String BUTTON_NAME = "button_name";
        public static final Key INSTANCE = null;
        public static final String IS_SHOW_FOREIGN_CARD_FEE = "is_show_foreign_card_fee";
        public static final String POP_STYLE = "pop_style";
        public static final String TRACE_ID = "trace_id";

        static {
            INSTANCE = new Key();
        }

        private Key() {
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/android/ttcjpaysdk/bindcard/base/constants/BindCardPayConfirmConstants$Value;", "", "()V", "BUTTON_NAME_CLOSE", "", "BUTTON_NAME_HELP", "bdpay-bindcard-base_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Value {
        public static final String BUTTON_NAME_CLOSE = "关闭";
        public static final String BUTTON_NAME_HELP = "helpInfo";
        public static final Value INSTANCE = null;

        static {
            INSTANCE = new Value();
        }

        private Value() {
        }
    }

    static {
        INSTANCE = new BindCardPayConfirmConstants();
    }

    private BindCardPayConfirmConstants() {
    }
}
