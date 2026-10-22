package com.stepos.pps.reflect;

import android.util.Log;
import com.stepos.pps.data.util.Constants;
import java.lang.reflect.Field;

/* loaded from: classes.dex */
public class BuildExtStepOS {
    public static final String APP_NAME_DIAL = "com.android.dialer";
    public static final String APP_NAME_MMS = "com.android.mms";
    public static final String APP_NAME_SMS;
    public static final String APP_NAME_SMS_OEU = "com.google.android.apps.messaging";
    public static final String DEFAULT_SELECT_APP;
    public static String DEVICE = null;
    public static final Boolean IS_M1813;
    public static final Boolean IS_M1816;
    private static final String TAG = "BuildExtStepOS";
    public static final boolean IS_PRODUCT_INTERNATIONAL = isProductInternational().booleanValue();
    public static final Boolean IS_MX2 = isMX("IS_MX2");
    public static final Boolean IS_MX3 = isMX("IS_MX3");
    public static final Boolean IS_MX4 = isMX("IS_MX4");
    public static final Boolean IS_MX4_Pro = isMX("IS_MX4_Pro");
    public static final Boolean IS_M1_NOTE = isMX("IS_M1_NOTE");
    public static final Boolean IS_M1 = isMX("IS_M1");
    public static final Boolean IS_MX5_PRO = isMX("IS_MX5_PRO");
    public static final Boolean IS_MTK_PLATFORM = isMTKPlatform();

    static {
        String device = getDevice();
        DEVICE = device;
        IS_M1816 = Boolean.valueOf(device != null && device.equals("m1816"));
        String str = DEVICE;
        IS_M1813 = Boolean.valueOf(str != null && str.equals("m1813"));
        String str2 = isProductInternational().booleanValue() ? APP_NAME_SMS_OEU : APP_NAME_MMS;
        APP_NAME_SMS = str2;
        DEFAULT_SELECT_APP = "com.android.dialer," + str2;
    }

    private static Boolean isMTKPlatform() {
        return Boolean.valueOf((IS_MX4_Pro.booleanValue() || IS_MX5_PRO.booleanValue()) ? false : true);
    }

    private static Boolean isMX(String str) throws NoSuchFieldException, ClassNotFoundException {
        try {
            Class<?> cls = Class.forName("android.os.BuildExt");
            Field declaredField = cls.getDeclaredField(str);
            declaredField.setAccessible(true);
            return (Boolean) declaredField.get(cls);
        } catch (Exception e) {
            Log.e(TAG, "isMX exception: " + e);
            return false;
        }
    }

    public static Boolean isProductInternational() {
        try {
            Object objInvoke = ReflectCache.on("android.os.BuildExt", "isProductInternational", (Class<?>[]) new Class[0]).invoke(new Object[0]);
            if (objInvoke == null) {
                return false;
            }
            Boolean bool = (Boolean) objInvoke;
            Log.d(TAG, "is international: " + bool.booleanValue());
            return bool;
        } catch (Exception e) {
            Log.e(TAG, "isProductInternational exception: " + e);
            return false;
        }
    }

    private static String getDevice() {
        String str = SystemPropertiesStepOS.get("ro.vendor.product.stepos.model", "default");
        if ("default".equalsIgnoreCase(str)) {
            str = SystemPropertiesStepOS.get("ro.product.stepos.model", "default");
        }
        if ("default".equalsIgnoreCase(str)) {
            str = SystemPropertiesStepOS.get("ro.product.model", "default");
        }
        return !"default".equalsIgnoreCase(str) ? str.toLowerCase() : str;
    }

    public static boolean isQcomPlatform() {
        return "qcom".equals(SystemPropertiesStepOS.get(Constants.DEVICE_SYSTEM_PROPERY, ""));
    }

    public static boolean isSprdPlatform() {
        return "sprd".equals(SystemPropertiesStepOS.get(Constants.DEVICE_SYSTEM_PROPERY, ""));
    }
}
