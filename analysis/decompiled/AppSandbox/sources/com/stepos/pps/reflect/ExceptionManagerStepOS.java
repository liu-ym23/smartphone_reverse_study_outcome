package com.stepos.pps.reflect;

import android.os.PersistableBundle;
import android.util.Log;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class ExceptionManagerStepOS {
    public static final String CLASS_PATH_EMSEVENTTYPE = "com.stepos.ems.type.EmsEventType";
    public static final String EXCEPTION_LEVEL_TYPE_FATAL = "FATAL";
    public static final String EXCEPTION_LOG_PATH = "path";
    public static final String EXCEPTION_TYPE_KE = "KE";
    public static final String EXCEPTION_TYPE_POWER_EXCESSIVE = "POWER_STANDBY";
    public static final String FIELD_NAME_FAULTCODES_QUERY = "EMS_EVENT_FAULTCODES_QUERY";
    public static final String PACKAGE = "package";
    public static final String PID = "pid";
    public static final String PROCESS = "process";
    public static final String SUBJECT = "Subject";
    private static final String TAG = "ExceptionManagerStepOS";
    public static final String UID = "uid";
    public static final String USER_CONFIG_BUNDLE_DATA = "data";
    public static final String USER_CONFIG_INFO_KEY = "userConfig";
    private static Object mFatalExceptionLevelObj;
    private static Object mPowerExcessiveExceptionTypeObj;

    public static void updateConfig(String str) {
        Object exceptionManager = ReflectUtils.getExceptionManager();
        if (exceptionManager != null) {
            try {
                ReflectCache.on(exceptionManager, "updateConfig", (Class<?>[]) new Class[]{String.class}).invoke(str);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static PersistableBundle getInfo(String str) {
        Object exceptionManager = ReflectUtils.getExceptionManager();
        if (exceptionManager == null) {
            return null;
        }
        try {
            return (PersistableBundle) ReflectCache.on(exceptionManager, "getInfo", (Class<?>[]) new Class[]{String.class}).invoke(str);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static PersistableBundle getEmsConfigUpdateInfo() {
        return getInfo("updateInfo");
    }

    public static void updateUserConfig(String str) {
        Object exceptionManager = ReflectUtils.getExceptionManager();
        if (exceptionManager != null) {
            try {
                ReflectCache.on(exceptionManager, "updateUserConfig", (Class<?>[]) new Class[]{String.class}).invoke(str);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static String getUserConfig() {
        PersistableBundle info = getInfo(USER_CONFIG_INFO_KEY);
        if (info != null) {
            return info.getString(USER_CONFIG_BUNDLE_DATA);
        }
        return null;
    }

    public static void setExceptionConfig(int i, PersistableBundle persistableBundle) throws ClassNotFoundException {
        Object exceptionManager = ReflectUtils.getExceptionManager();
        if (exceptionManager != null) {
            try {
                Class<?> cls = Class.forName("com.stepos.ems.type.ExceptionType");
                Class[] clsArr = new Class[0];
                ReflectCache.on(exceptionManager, "setExceptionConfig", (Class<?>[]) new Class[]{cls, PersistableBundle.class}).invoke(((Object[]) cls.getMethod("values", null).invoke(null, null))[i], persistableBundle);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void stopPerfetto() throws ClassNotFoundException {
        PersistableBundle persistableBundle = new PersistableBundle();
        persistableBundle.putString("command", "stopPerfetto");
        setExceptionConfig(0, persistableBundle);
    }

    public static Object getExceptionType(String str) {
        try {
            Object[] enumConstants = Class.forName("com.stepos.ems.type.ExceptionType").getEnumConstants();
            if (enumConstants == null || enumConstants.length <= 0) {
                return null;
            }
            for (Object obj : enumConstants) {
                if (obj.toString().equalsIgnoreCase(str)) {
                    return obj;
                }
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            Log.e(TAG, "getExceptionType error, exceptionType: " + str + "  " + e.getMessage());
            return null;
        }
    }

    public static Object getExceptionLevel(String str) {
        try {
            Object[] enumConstants = Class.forName("com.stepos.ems.type.LevelType").getEnumConstants();
            if (enumConstants == null || enumConstants.length <= 0) {
                return null;
            }
            for (Object obj : enumConstants) {
                if (obj.toString().equalsIgnoreCase(str)) {
                    return obj;
                }
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            Log.e(TAG, "getExceptionType error, exceptionLevel: " + str + "  " + e.getMessage());
            return null;
        }
    }

    public static Object getExceptionConfig(String str) {
        Object exceptionType;
        try {
            Object exceptionManager = ReflectUtils.getExceptionManager();
            if (exceptionManager == null || (exceptionType = getExceptionType(str)) == null) {
                return null;
            }
            return ReflectCache.on(exceptionManager, "getExceptionConfig", (Class<?>[]) new Class[]{exceptionType.getClass()}).invoke(exceptionType);
        } catch (Exception e) {
            e.printStackTrace();
            Log.e(TAG, "getExceptionConfig error, exceptionType: " + str + "  " + e.getMessage());
            return null;
        }
    }

    public static String getExceptionConfigValue(Object obj, String str, String str2) {
        if (obj != null) {
            try {
                return (String) ReflectCache.on(obj, "getConfig", (Class<?>[]) new Class[]{String.class, String.class}).invoke(str, str2);
            } catch (Exception e) {
                e.printStackTrace();
                Log.e(TAG, "getExceptionConfigValue error" + e.getMessage());
            }
        }
        return str2;
    }

    public static String getExceptionConfigValue(String str, String str2, String str3) {
        try {
            getExceptionConfigValue(getExceptionConfig(str), str2, str3);
            return str3;
        } catch (Exception e) {
            e.printStackTrace();
            Log.e(TAG, "getExceptionConfigValue error, exceptionType: " + str + "  " + e.getMessage());
            return str3;
        }
    }

    public static void reportException(Object obj, Object obj2, PersistableBundle persistableBundle) {
        try {
            Object exceptionManager = ReflectUtils.getExceptionManager();
            if (exceptionManager == null || obj == null || obj2 == null) {
                Log.e(TAG, "reportException error: reflect obj is null");
            } else {
                ReflectCache.on(exceptionManager, "reportException", (Class<?>[]) new Class[]{obj.getClass(), obj2.getClass(), PersistableBundle.class, Class.forName("com.stepos.ems.IExceptionManagerListener")}).invoke(obj, obj2, persistableBundle, null);
            }
        } catch (Exception e) {
            e.printStackTrace();
            Log.e(TAG, "reportException: " + e.getMessage());
        }
    }

    public static void reportPowerExcessiveException(PersistableBundle persistableBundle) {
        try {
            if (mPowerExcessiveExceptionTypeObj == null) {
                mPowerExcessiveExceptionTypeObj = getExceptionType(EXCEPTION_TYPE_POWER_EXCESSIVE);
            }
            if (mFatalExceptionLevelObj == null) {
                mFatalExceptionLevelObj = getExceptionLevel(EXCEPTION_LEVEL_TYPE_FATAL);
            }
            reportException(mPowerExcessiveExceptionTypeObj, mFatalExceptionLevelObj, persistableBundle);
        } catch (Exception e) {
            e.printStackTrace();
            Log.e(TAG, "reportPowerExcessiveException: " + e.getMessage());
        }
    }

    public static void reportExcessiveException(String str, String str2, PersistableBundle persistableBundle) {
        try {
            reportException(getExceptionType(str), getExceptionLevel(str2), persistableBundle);
        } catch (Exception e) {
            e.printStackTrace();
            Log.e(TAG, "reportPowerExcessiveException2: " + e.getMessage());
        }
    }

    public static void setExceptionReportingStatus(boolean z) throws ClassNotFoundException {
        PersistableBundle persistableBundle = new PersistableBundle();
        if (z) {
            persistableBundle.putString("enableExceptionReport", "true");
        } else {
            persistableBundle.putString("disableExceptionReport", "true");
        }
        setExceptionConfig(0, persistableBundle);
    }

    public static void writeExceptionCode(String str, HashMap<String, String> map) {
        try {
            Object exceptionManager = ReflectUtils.getExceptionManager();
            if (exceptionManager != null) {
                ReflectCache.on(exceptionManager, "writeExceptionCode", (Class<?>[]) new Class[]{String.class, Map.class}).invoke(str, map);
            } else {
                Log.e(TAG, "writeExceptionCode error: reflect obj is null");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void reportScanResults(Object obj, List<PersistableBundle> list) {
        try {
            Object exceptionManager = ReflectUtils.getExceptionManager();
            if (exceptionManager == null || obj == null) {
                Log.e(TAG, "reportScanResults error: reflect obj is null");
            } else {
                ReflectCache.on(exceptionManager, "reportScanResults", (Class<?>[]) new Class[]{obj.getClass(), List.class}).invoke(obj, list);
            }
        } catch (Exception e) {
            e.printStackTrace();
            Log.e(TAG, "reportScanResults: " + e.getMessage());
        }
    }

    public static void registerEmsRunnable(int i, Runnable runnable) {
        try {
            Object exceptionManager = ReflectUtils.getExceptionManager();
            if (exceptionManager == null) {
                Log.e(TAG, "registerEmsRunnable error: reflect obj is null");
            } else {
                ReflectCache.on(exceptionManager, "registerEmsRunnable", (Class<?>[]) new Class[]{Integer.TYPE, Runnable.class}).invoke(Integer.valueOf(i), runnable);
            }
        } catch (Exception e) {
            e.printStackTrace();
            Log.e(TAG, "registerEmsRunnable: " + e.getMessage());
        }
    }

    public static void unregisterEmsRunnable(int i, Runnable runnable) {
        try {
            Object exceptionManager = ReflectUtils.getExceptionManager();
            if (exceptionManager == null) {
                Log.e(TAG, "registerEmsRunnable error: reflect obj is null");
            } else {
                ReflectCache.on(exceptionManager, "unregisterEmsRunnable", (Class<?>[]) new Class[]{Integer.TYPE, Runnable.class}).invoke(Integer.valueOf(i), runnable);
            }
        } catch (Exception e) {
            e.printStackTrace();
            Log.e(TAG, "registerEmsRunnable: " + e.getMessage());
        }
    }

    public static void registerEmsRunnableWrapper(Runnable runnable) throws NoSuchFieldException {
        try {
            Field declaredField = Class.forName(CLASS_PATH_EMSEVENTTYPE).getDeclaredField(FIELD_NAME_FAULTCODES_QUERY);
            declaredField.setAccessible(true);
            registerEmsRunnable(((Integer) declaredField.get(null)).intValue(), runnable);
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException e) {
            Log.e(TAG, "registerEmsRunnableWrapper: error:" + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void unregisterEmsRunnableWrapper(Runnable runnable) throws NoSuchFieldException {
        try {
            Field declaredField = Class.forName(CLASS_PATH_EMSEVENTTYPE).getDeclaredField(FIELD_NAME_FAULTCODES_QUERY);
            declaredField.setAccessible(true);
            unregisterEmsRunnable(((Integer) declaredField.get(null)).intValue(), runnable);
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException e) {
            Log.e(TAG, "unregisterEmsRunnableWrapper: error:" + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void reportScanResultsWrapper(List<PersistableBundle> list) {
        try {
            reportScanResults(Enum.valueOf(Class.forName("com.stepos.ems.type.FaultcodeType"), "FAULT_CODES"), list);
        } catch (ClassNotFoundException e) {
            Log.e(TAG, "reportScanResultsWrapper: error:" + e.getMessage());
            e.printStackTrace();
        }
    }
}
