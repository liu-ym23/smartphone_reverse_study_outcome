package android.security.obric.guard;

import android.content.Context;
import android.os.Bundle;

/* JADX INFO: loaded from: classes.dex */
public abstract class ObricSecurityGuardStub {

    public interface PermissionInfoKey {
        public static final String PER_LEVEL = "permission_level";
        public static final String PER_NAME = "permission_name";
        public static final String USE_REASON = "use_reason";
    }

    public interface PermissionLevel {
        public static final String PERMISSION_LEVEL_ALWAYS = "always";
        public static final String PERMISSION_LEVEL_DENY = "deny";
        public static final String PERMISSION_LEVEL_DURING_USE = "duringUse";
        public static final String PERMISSION_LEVEL_ONE_TIME = "oneTime";
    }

    public interface RiskType {
        public static final int RISK_TYPE_DOUBLE_CHECK = 4;
        public static final int RISK_TYPE_ELE_FLOW_APPROVAL = 3;
        public static final int RISK_TYPE_NORMAL = 0;
        public static final int RISK_TYPE_PASSWORD_FREE_PAYMENT = 2;
        public static final int RISK_TYPE_PASSWORD_INPUT = 1;
    }

    public interface SettingsEventConst {
        public static final String BUNDLE_KEY_EVENT_RESULT = "event_result";
        public static final String EVENT_RESULT_CANCEL = "cancel";
        public static final String EVENT_RESULT_CONFIRM = "confirm";
    }

    public static ObricSecurityGuardStub getInstance() {
        return null;
    }

    public abstract void bdSettingsEventEnd(Context r1, int r2, Bundle r3);

    public abstract void bdSettingsEventStart(Context r1, int r2, Bundle r3);

    public abstract int getActivityRiskType(String r1, String r2, Bundle r3);

    public abstract Bundle getAppGrantPermissionInfo(String r1, String r2);

    public abstract Bundle getCurrentAppGrantPermissionInfo(String r1);

    public abstract String getSecurityPolicy(String r1);

    public abstract void updateMinPerPolicy(String r1, String r2);

    public abstract void updatePolicyFile(String r1, String r2);

    public ObricSecurityGuardStub() {
    }
}
