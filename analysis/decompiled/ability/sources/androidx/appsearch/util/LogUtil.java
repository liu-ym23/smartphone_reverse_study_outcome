package androidx.appsearch.util;

import androidx.annotation.RestrictTo;
import androidx.annotation.Size;
import androidx.appsearch.app.AppSearchEnvironmentFactory;
import com.stepos.policy.sdk.config.PolicySdkConstants;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes.dex */
public final class LogUtil {
    public static final boolean DEBUG = false;
    public static final boolean INFO = AppSearchEnvironmentFactory.getEnvironmentInstance().isInfoLoggingEnabled();
    private static final int PII_TRACE_LEVEL = 0;

    private LogUtil() {
    }

    public static boolean isPiiTraceEnabled() {
        return false;
    }

    public static void piiTrace(@Size(max = 23, min = PolicySdkConstants.POLICY_NEWEST_VERSION_DEFAULT) String str, String str2, Object obj, Object obj2) {
    }

    public static void piiTrace(@Size(max = 23, min = PolicySdkConstants.POLICY_NEWEST_VERSION_DEFAULT) String str, String str2) {
        piiTrace(str, str2, null, null);
    }

    public static void piiTrace(@Size(max = 23, min = PolicySdkConstants.POLICY_NEWEST_VERSION_DEFAULT) String str, String str2, Object obj) {
        piiTrace(str, str2, obj, null);
    }
}
