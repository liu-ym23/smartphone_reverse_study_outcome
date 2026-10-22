package com.android.ttcjpaysdk.ttcjpayapi;

import java.util.Map;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0001\tJ$\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0007H&¨\u0006\n"}, d2 = {"Lcom/android/ttcjpaysdk/ttcjpayapi/ICustomActionListener;", "", "onAction", "", "action", "Lcom/android/ttcjpaysdk/ttcjpayapi/ICustomActionListener$ActionType;", "params", "", "", "ActionType", "cj-host-service-api_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface ICustomActionListener {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/android/ttcjpaysdk/ttcjpayapi/ICustomActionListener$ActionType;", "", "(Ljava/lang/String;I)V", "CASHIER_IMP", "CASHIER_CONFIRM_CLICK", "cj-host-service-api_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final enum ActionType extends Enum<ActionType> {
        private static final /* synthetic */ ActionType[] $VALUES = null;
        public static final ActionType CASHIER_CONFIRM_CLICK = null;
        public static final ActionType CASHIER_IMP = null;

        private static final /* synthetic */ ActionType[] $values() {
            return new ActionType[]{CASHIER_IMP, CASHIER_CONFIRM_CLICK};
        }

        public static ActionType valueOf(String r100) {
            return (ActionType) a.a(ActionType.class, r100);
        }

        public static ActionType[] values() {
            return (ActionType[]) $VALUES.clone();
        }

        static {
            CASHIER_IMP = new ActionType("CASHIER_IMP", 0);
            CASHIER_CONFIRM_CLICK = new ActionType("CASHIER_CONFIRM_CLICK", 1);
            $VALUES = $values();
        }

        private ActionType(String r100, int r101) {
            super(r100, r101);
        }
    }

    void onAction(ActionType r100, Map<String, String> r101);
}
