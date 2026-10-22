package com.stepos.personal.info;

/* loaded from: classes.dex */
public class PersonalInfoHelper {
    private static IPersonalInfoListener sPersonalInfoListener;

    public static String getAaid() {
        IPersonalInfoListener iPersonalInfoListener = sPersonalInfoListener;
        if (iPersonalInfoListener == null) {
            return "";
        }
        Object objOnOutputInfo = iPersonalInfoListener.onOutputInfo(4);
        return !(objOnOutputInfo instanceof String) ? "" : (String) objOnOutputInfo;
    }

    public static String getAdvertisingId() {
        IPersonalInfoListener iPersonalInfoListener = sPersonalInfoListener;
        if (iPersonalInfoListener == null) {
            return "";
        }
        Object objOnOutputInfo = iPersonalInfoListener.onOutputInfo(18);
        return !(objOnOutputInfo instanceof String) ? "" : (String) objOnOutputInfo;
    }

    public static String getAndroidId() {
        IPersonalInfoListener iPersonalInfoListener = sPersonalInfoListener;
        if (iPersonalInfoListener == null) {
            return "";
        }
        Object objOnOutputInfo = iPersonalInfoListener.onOutputInfo(17);
        return !(objOnOutputInfo instanceof String) ? "" : (String) objOnOutputInfo;
    }

    public static String getEncryptImei() {
        IPersonalInfoListener iPersonalInfoListener = sPersonalInfoListener;
        if (iPersonalInfoListener == null) {
            return "";
        }
        Object objOnOutputInfo = iPersonalInfoListener.onOutputInfo(19);
        return !(objOnOutputInfo instanceof String) ? "" : (String) objOnOutputInfo;
    }

    public static String getEncryptSn() {
        IPersonalInfoListener iPersonalInfoListener = sPersonalInfoListener;
        if (iPersonalInfoListener == null) {
            return "";
        }
        Object objOnOutputInfo = iPersonalInfoListener.onOutputInfo(20);
        return !(objOnOutputInfo instanceof String) ? "" : (String) objOnOutputInfo;
    }

    public static String getImei() {
        IPersonalInfoListener iPersonalInfoListener = sPersonalInfoListener;
        if (iPersonalInfoListener == null) {
            return "";
        }
        Object objOnOutputInfo = iPersonalInfoListener.onOutputInfo(10);
        return !(objOnOutputInfo instanceof String) ? "" : (String) objOnOutputInfo;
    }

    public static String getImsi1() {
        IPersonalInfoListener iPersonalInfoListener = sPersonalInfoListener;
        if (iPersonalInfoListener == null) {
            return "";
        }
        Object objOnOutputInfo = iPersonalInfoListener.onOutputInfo(7);
        return !(objOnOutputInfo instanceof String) ? "" : (String) objOnOutputInfo;
    }

    public static String getImsi2() {
        IPersonalInfoListener iPersonalInfoListener = sPersonalInfoListener;
        if (iPersonalInfoListener == null) {
            return "";
        }
        Object objOnOutputInfo = iPersonalInfoListener.onOutputInfo(8);
        return !(objOnOutputInfo instanceof String) ? "" : (String) objOnOutputInfo;
    }

    public static double getLocationLatitude() {
        IPersonalInfoListener iPersonalInfoListener = sPersonalInfoListener;
        if (iPersonalInfoListener == null) {
            return 0.0d;
        }
        Object objOnOutputInfo = iPersonalInfoListener.onOutputInfo(12);
        if (objOnOutputInfo instanceof Double) {
            return ((Double) objOnOutputInfo).doubleValue();
        }
        return 0.0d;
    }

    public static double getLocationLongitude() {
        IPersonalInfoListener iPersonalInfoListener = sPersonalInfoListener;
        if (iPersonalInfoListener == null) {
            return 0.0d;
        }
        Object objOnOutputInfo = iPersonalInfoListener.onOutputInfo(11);
        if (objOnOutputInfo instanceof Double) {
            return ((Double) objOnOutputInfo).doubleValue();
        }
        return 0.0d;
    }

    public static long getLocationTime() {
        IPersonalInfoListener iPersonalInfoListener = sPersonalInfoListener;
        if (iPersonalInfoListener == null) {
            return 0L;
        }
        Object objOnOutputInfo = iPersonalInfoListener.onOutputInfo(13);
        if (objOnOutputInfo instanceof Long) {
            return ((Long) objOnOutputInfo).longValue();
        }
        return 0L;
    }

    public static String getMacAddress() {
        IPersonalInfoListener iPersonalInfoListener = sPersonalInfoListener;
        if (iPersonalInfoListener == null) {
            return "";
        }
        Object objOnOutputInfo = iPersonalInfoListener.onOutputInfo(5);
        return !(objOnOutputInfo instanceof String) ? "" : (String) objOnOutputInfo;
    }

    public static String getOaid() {
        IPersonalInfoListener iPersonalInfoListener = sPersonalInfoListener;
        if (iPersonalInfoListener == null) {
            return "";
        }
        Object objOnOutputInfo = iPersonalInfoListener.onOutputInfo(2);
        return !(objOnOutputInfo instanceof String) ? "" : (String) objOnOutputInfo;
    }

    public static String getOperator() {
        IPersonalInfoListener iPersonalInfoListener = sPersonalInfoListener;
        if (iPersonalInfoListener == null) {
            return "";
        }
        Object objOnOutputInfo = iPersonalInfoListener.onOutputInfo(6);
        return !(objOnOutputInfo instanceof String) ? "" : ((String) objOnOutputInfo).replace("\n", "").replace("\r", "");
    }

    public static String getSn() {
        IPersonalInfoListener iPersonalInfoListener = sPersonalInfoListener;
        if (iPersonalInfoListener == null) {
            return "";
        }
        Object objOnOutputInfo = iPersonalInfoListener.onOutputInfo(14);
        return !(objOnOutputInfo instanceof String) ? "" : (String) objOnOutputInfo;
    }

    public static String getSn1() {
        IPersonalInfoListener iPersonalInfoListener = sPersonalInfoListener;
        if (iPersonalInfoListener == null) {
            return "";
        }
        Object objOnOutputInfo = iPersonalInfoListener.onOutputInfo(15);
        return !(objOnOutputInfo instanceof String) ? "" : (String) objOnOutputInfo;
    }

    public static String getSn2() {
        IPersonalInfoListener iPersonalInfoListener = sPersonalInfoListener;
        if (iPersonalInfoListener == null) {
            return "";
        }
        Object objOnOutputInfo = iPersonalInfoListener.onOutputInfo(16);
        return !(objOnOutputInfo instanceof String) ? "" : (String) objOnOutputInfo;
    }

    public static String getStepOSUid() {
        IPersonalInfoListener iPersonalInfoListener = sPersonalInfoListener;
        if (iPersonalInfoListener == null) {
            return "";
        }
        Object objOnOutputInfo = iPersonalInfoListener.onOutputInfo(9);
        return !(objOnOutputInfo instanceof String) ? "" : (String) objOnOutputInfo;
    }

    public static String getUdid() {
        IPersonalInfoListener iPersonalInfoListener = sPersonalInfoListener;
        if (iPersonalInfoListener == null) {
            return "";
        }
        Object objOnOutputInfo = iPersonalInfoListener.onOutputInfo(1);
        return !(objOnOutputInfo instanceof String) ? "" : (String) objOnOutputInfo;
    }

    public static String getVaid() {
        IPersonalInfoListener iPersonalInfoListener = sPersonalInfoListener;
        if (iPersonalInfoListener == null) {
            return "";
        }
        Object objOnOutputInfo = iPersonalInfoListener.onOutputInfo(3);
        return !(objOnOutputInfo instanceof String) ? "" : (String) objOnOutputInfo;
    }

    public static boolean isRoot() {
        IPersonalInfoListener iPersonalInfoListener = sPersonalInfoListener;
        if (iPersonalInfoListener == null) {
            return false;
        }
        Object objOnOutputInfo = iPersonalInfoListener.onOutputInfo(21);
        if (objOnOutputInfo instanceof Boolean) {
            return ((Boolean) objOnOutputInfo).booleanValue();
        }
        return false;
    }

    public static void setPersonalInfoListener(IPersonalInfoListener iPersonalInfoListener) {
        sPersonalInfoListener = iPersonalInfoListener;
    }
}
