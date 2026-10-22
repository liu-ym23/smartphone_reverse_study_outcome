package androidx.core.telephony;

import android.annotation.SuppressLint;
import android.telephony.TelephonyManager;
import androidx.annotation.RequiresApi;
import androidx.annotation.RequiresPermission;
import com.stepos.policy.sdk.util.PolicySdkPermissionManifestUtils;
import java.lang.reflect.Method;

/* loaded from: classes2.dex */
public class TelephonyManagerCompat {
    private static Method sGetDeviceIdMethod;
    private static Method sGetSubIdMethod;

    @RequiresApi(23)
    public static class Api23Impl {
        private Api23Impl() {
        }

        @RequiresPermission(PolicySdkPermissionManifestUtils.READ_PHONE_STATE)
        @SuppressLint({"MissingPermission"})
        public static String getDeviceId(TelephonyManager telephonyManager, int i) {
            return telephonyManager.getDeviceId(i);
        }
    }

    @RequiresApi(26)
    public static class Api26Impl {
        private Api26Impl() {
        }

        @RequiresPermission(PolicySdkPermissionManifestUtils.READ_PHONE_STATE)
        @SuppressLint({"MissingPermission"})
        public static String getImei(TelephonyManager telephonyManager) {
            return telephonyManager.getImei();
        }
    }

    @RequiresApi(30)
    public static class Api30Impl {
        private Api30Impl() {
        }

        public static int getSubscriptionId(TelephonyManager telephonyManager) {
            return telephonyManager.getSubscriptionId();
        }
    }

    private TelephonyManagerCompat() {
    }

    @RequiresPermission(PolicySdkPermissionManifestUtils.READ_PHONE_STATE)
    @SuppressLint({"MissingPermission"})
    public static String getImei(TelephonyManager telephonyManager) {
        return Api26Impl.getImei(telephonyManager);
    }

    @SuppressLint({"SoonBlockedPrivateApi"})
    public static int getSubscriptionId(TelephonyManager telephonyManager) {
        return Api30Impl.getSubscriptionId(telephonyManager);
    }
}
