package androidx.core.telephony;

import android.os.Build;
import android.telephony.TelephonyManager;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import f06.b;
import f06.c;
import f06.d;
import g06.a;
import java.lang.reflect.Method;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes17.dex */
public class TelephonyManagerCompat {
    private static Method sGetDeviceIdMethod;
    private static Method sGetSubIdMethod;

    public static class Api23Impl {
        private Api23Impl() {
        }

        private static String androidx_core_telephony_TelephonyManagerCompat$Api23Impl_android_telephony_TelephonyManager_getDeviceId(TelephonyManager r110, int r111) {
            c r100 = new c();
            Object[] r101 = {Integer.valueOf(r111)};
            b r112 = new b();
            d r113 = r100.b(101600, "android/telephony/TelephonyManager", "getDeviceId", r110, r101, "java.lang.String", r112);
            if (r113.f474982a == false) goto L6;
            r100.a(101600, "android/telephony/TelephonyManager", "getDeviceId", r110, r101, null, r112, false);
            return (String) r113.f474983b;
        L6:
            String r114 = r110.getDeviceId(r111);
            r100.a(101600, "android/telephony/TelephonyManager", "getDeviceId", r110, r101, r114, r112, true);
            return r114;
        }

        public static String getDeviceId(TelephonyManager r100, int r101) {
            return androidx_core_telephony_TelephonyManagerCompat$Api23Impl_android_telephony_TelephonyManager_getDeviceId(r100, r101);
        }
    }

    public static class Api26Impl {
        private Api26Impl() {
        }

        private static String androidx_core_telephony_TelephonyManagerCompat$Api26Impl_android_telephony_TelephonyManager_getImei(TelephonyManager r110) {
            c r100 = new c();
            Object[] r101 = new Object[0];
            b r111 = new b();
            d r112 = r100.b(101601, "android/telephony/TelephonyManager", "getImei", r110, r101, "java.lang.String", r111);
            if (r112.f474982a == false) goto L6;
            r100.a(101601, "android/telephony/TelephonyManager", "getImei", r110, r101, null, r111, false);
            return (String) r112.f474983b;
        L6:
            String r113 = r110.getImei();
            r100.a(101601, "android/telephony/TelephonyManager", "getImei", r110, r101, r113, r111, true);
            return r113;
        }

        public static String getImei(TelephonyManager r100) {
            return androidx_core_telephony_TelephonyManagerCompat$Api26Impl_android_telephony_TelephonyManager_getImei(r100);
        }
    }

    public static class Api30Impl {
        private Api30Impl() {
        }

        private static int androidx_core_telephony_TelephonyManagerCompat$Api30Impl_android_telephony_TelephonyManager_getSubscriptionId(TelephonyManager r110) {
            ArrayList r100 = new ArrayList();
            Object[] r111 = new Object[0];
            b r112 = new b();
            a r101 = ApiHookConfig.f245611b.get(102014);
            if (r101 == null) goto L5;
            f06.a[] r102 = r101.f479473i;
        L6:
            f06.a[] r113 = r102;
            int r103 = r113.length;
            int r104 = 0;
        L8:
            if (r104 >= r103) goto L15;
            f06.a r105 = r113[r104];
            int r114 = r104;
            int r115 = r103;
            d r106 = r105.preInvoke(102014, "android/telephony/TelephonyManager", "getSubscriptionId", r110, r111, "int", r112);     // Catch: Exception -> L22
            if (r106.f474982a == true) goto L17;
            r100.add(r105);     // Catch: Exception -> L22
        L17:
            if (r106.f474982a == false) goto L21;
            return ((Integer) r106.f474983b).intValue();
        L21:
            return r110.getSubscriptionId();
        L14:
            r104 = r114 + 1;
            r103 = r115;
            goto L8
        L15:
            r106 = new d(false, null);
            goto L17
        L5:
            r102 = ApiHookConfig.f245613d;
            goto L6
        }

        public static int getSubscriptionId(TelephonyManager r100) {
            return androidx_core_telephony_TelephonyManagerCompat$Api30Impl_android_telephony_TelephonyManager_getSubscriptionId(r100);
        }
    }

    private TelephonyManagerCompat() {
    }

    private static String androidx_core_telephony_TelephonyManagerCompat_android_telephony_TelephonyManager_getDeviceId(TelephonyManager r110) {
        c r100 = new c();
        Object[] r101 = new Object[0];
        b r111 = new b();
        d r112 = r100.b(101600, "android/telephony/TelephonyManager", "getDeviceId", r110, r101, "java.lang.String", r111);
        if (r112.f474982a == false) goto L6;
        r100.a(101600, "android/telephony/TelephonyManager", "getDeviceId", r110, r101, null, r111, false);
        return (String) r112.f474983b;
    L6:
        String r113 = r110.getDeviceId();
        r100.a(101600, "android/telephony/TelephonyManager", "getDeviceId", r110, r101, r113, r111, true);
        return r113;
    }

    public static String getImei(TelephonyManager r100) {
        int r101 = Build.VERSION.SDK_INT;
        if (r101 < 26) goto L7;
        return Api26Impl.getImei(r100);
    L7:
        if (r101 < 22) goto L24;
        int r102 = getSubscriptionId(r100);
        if (r102 == Integer.MAX_VALUE) goto L24;
        if (r102 == (-1)) goto L24;
        int r103 = SubscriptionManagerCompat.getSlotIndex(r102);
        if (r101 >= 23) goto L15;
    L21:
        return null;
    L17:
        if (sGetDeviceIdMethod != null) goto L19;
        Method r104 = TelephonyManager.class.getDeclaredMethod("getDeviceId", new Class[]{Integer.TYPE});     // Catch: Throwable -> L21
        sGetDeviceIdMethod = r104;     // Catch: Throwable -> L21
        r104.setAccessible(true);     // Catch: Throwable -> L21
    L19:
        return (String) sGetDeviceIdMethod.invoke(r100, new Object[]{Integer.valueOf(r103)});
    L15:
        return Api23Impl.getDeviceId(r100, r103);
    L24:
        return androidx_core_telephony_TelephonyManagerCompat_android_telephony_TelephonyManager_getDeviceId(r100);
    }

    public static int getSubscriptionId(TelephonyManager r100) {
        int r101 = Build.VERSION.SDK_INT;
        if (r101 < 30) goto L7;
        return Api30Impl.getSubscriptionId(r100);
    L7:
        if (r101 >= 22) goto L20;
        return Integer.MAX_VALUE;
    L20:
        if (sGetSubIdMethod != null) goto L11;
        Method r102 = TelephonyManager.class.getDeclaredMethod("getSubId", new Class[0]);     // Catch: Throwable -> L19
        sGetSubIdMethod = r102;     // Catch: Throwable -> L19
        r102.setAccessible(true);     // Catch: Throwable -> L19
    L11:
        Integer r103 = (Integer) sGetSubIdMethod.invoke(r100, new Object[0]);     // Catch: Throwable -> L19
        if (r103 != null) goto L14;
        return Integer.MAX_VALUE;
    L14:
        if (r103.intValue() == (-1)) goto L23;
        return r103.intValue();
    L23:
        return Integer.MAX_VALUE;
    L24:
        return Integer.MAX_VALUE;
    }
}
