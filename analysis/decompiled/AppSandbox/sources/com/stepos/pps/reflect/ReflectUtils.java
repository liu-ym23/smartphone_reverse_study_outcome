package com.stepos.pps.reflect;

import android.content.Context;
import android.hardware.stepos.StepOSAtoms;
import android.os.IBinder;
import android.util.Log;
import android.util.StatsEvent;
import android.util.StatsLog;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Locale;

/* loaded from: classes.dex */
public class ReflectUtils {
    private static final String TAG = "ReflectUtils";

    public static Object getIPackageManager() {
        try {
            Class<?> clsForName = ReflectionCache.build().forName("android.content.pm.IPackageManager$Stub");
            ReflectionCache.build();
            Method cachedMethod = ReflectionCache.getCachedMethod(clsForName, "asInterface", false, IBinder.class);
            IBinder iBinder = getIBinder(ExceptionManagerStepOS.PACKAGE);
            if (cachedMethod == null) {
                return null;
            }
            return cachedMethod.invoke(clsForName, iBinder);
        } catch (Exception e) {
            Log.w(TAG, "getIPackageManager exception: " + e);
            return null;
        }
    }

    public static Object getIPowerManager() {
        try {
            Class<?> clsForName = ReflectionCache.build().forName("android.os.IPowerManager$Stub");
            ReflectionCache.build();
            Method cachedMethod = ReflectionCache.getCachedMethod(clsForName, "asInterface", false, IBinder.class);
            IBinder iBinder = getIBinder("power");
            if (cachedMethod == null) {
                return null;
            }
            return cachedMethod.invoke(clsForName, iBinder);
        } catch (Exception e) {
            Log.w(TAG, "getIPowerManager exception: " + e);
            return null;
        }
    }

    public static Object getITelephonyExt() {
        try {
            Class<?> clsForName = ReflectionCache.build().forName("android.telephony.ITelephonyExt$Stub");
            ReflectionCache.build();
            Method cachedMethod = ReflectionCache.getCachedMethod(clsForName, "asInterface", false, IBinder.class);
            IBinder iBinder = getIBinder("phone_ext");
            if (cachedMethod == null) {
                return null;
            }
            return cachedMethod.invoke(clsForName, iBinder);
        } catch (Exception e) {
            Log.w(TAG, "getITelephonyExt exception: " + e);
            return null;
        }
    }

    public static Object getTelephonyManager(Context context) {
        try {
            Class<?> clsForName = ReflectionCache.build().forName("android.telephony.TelephonyManager");
            ReflectionCache.build();
            Method cachedMethod = ReflectionCache.getCachedMethod(clsForName, "from", false, Context.class);
            if (cachedMethod == null) {
                return null;
            }
            return cachedMethod.invoke(clsForName, context);
        } catch (Exception e) {
            Log.w(TAG, "getTelephonyManager exception: " + e);
            return null;
        }
    }

    public static Object getIVoiceSenseService() {
        try {
            Class<?> clsForName = ReflectionCache.build().forName("android.os.IVoiceSenseService$Stub");
            ReflectionCache.build();
            Method cachedMethod = ReflectionCache.getCachedMethod(clsForName, "asInterface", false, IBinder.class);
            IBinder iBinder = getIBinder("voicesense");
            if (cachedMethod == null) {
                return null;
            }
            return cachedMethod.invoke(clsForName, iBinder);
        } catch (Exception e) {
            Log.w(TAG, "getIVoiceSenseService exception: " + e);
            return null;
        }
    }

    public static Object getILockSettingsService() {
        try {
            Class<?> clsForName = ReflectionCache.build().forName("com.android.internal.widget.ILockSettings$Stub");
            ReflectionCache.build();
            Method cachedMethod = ReflectionCache.getCachedMethod(clsForName, "asInterface", false, IBinder.class);
            IBinder iBinder = getIBinder("lock_settings");
            if (cachedMethod == null) {
                return null;
            }
            return cachedMethod.invoke(clsForName, iBinder);
        } catch (Exception e) {
            Log.w(TAG, "getILockSettingsService exception: " + e);
            return null;
        }
    }

    public static Object getIActivityTaskManagerService() {
        try {
            Class<?> clsForName = ReflectionCache.build().forName("android.app.IActivityTaskManager$Stub");
            ReflectionCache.build();
            Method cachedMethod = ReflectionCache.getCachedMethod(clsForName, "asInterface", false, IBinder.class);
            IBinder iBinder = getIBinder("activity_task");
            if (cachedMethod == null) {
                return null;
            }
            return cachedMethod.invoke(clsForName, iBinder);
        } catch (Exception e) {
            Log.w(TAG, "getIActivityTaskManagerService exception: " + e);
            return null;
        }
    }

    public static Object registerTaskStackListener() {
        try {
            Class<?> clsForName = ReflectionCache.build().forName("android.app.IActivityTaskManager$Stub");
            ReflectionCache.build();
            Method cachedMethod = ReflectionCache.getCachedMethod(clsForName, "asInterface", false, IBinder.class);
            IBinder iBinder = getIBinder("activity_task");
            if (cachedMethod == null) {
                return null;
            }
            return cachedMethod.invoke(clsForName, iBinder);
        } catch (Exception e) {
            Log.w(TAG, "getIActivityTaskManagerService exception: " + e);
            return null;
        }
    }

    public static Object getIStepOSPermissionService() {
        try {
            Class<?> clsForName = ReflectionCache.build().forName("stepos.security.IStepOSPermissionService$Stub");
            ReflectionCache.build();
            Method cachedMethod = ReflectionCache.getCachedMethod(clsForName, "asInterface", false, IBinder.class);
            IBinder iBinder = getIBinder("stepos_permission");
            if (cachedMethod == null) {
                return null;
            }
            return cachedMethod.invoke(clsForName, iBinder);
        } catch (Exception e) {
            Log.w(TAG, "getIStepOSPermissionService exception: " + e);
            return null;
        }
    }

    public static Object getIActivityManager() {
        try {
            Class<?> clsForName = ReflectionCache.build().forName("android.app.ActivityManagerNative");
            ReflectionCache.build();
            Method cachedMethod = ReflectionCache.getCachedMethod(clsForName, "getDefault", false, new Class[0]);
            if (cachedMethod == null) {
                return null;
            }
            return cachedMethod.invoke(null, null);
        } catch (Exception e) {
            Log.w(TAG, "getIActivityManager exception: ", e);
            return null;
        }
    }

    public static Object getIAppOpsManager() {
        try {
            Class<?> clsForName = ReflectionCache.build().forName("com.android.internal.app.IAppOpsService$Stub");
            ReflectionCache.build();
            Method cachedMethod = ReflectionCache.getCachedMethod(clsForName, "asInterface", false, IBinder.class);
            IBinder iBinder = getIBinder("appops");
            if (cachedMethod == null) {
                return null;
            }
            return cachedMethod.invoke(clsForName, iBinder);
        } catch (Exception e) {
            Log.w(TAG, "getIAppOpsManager exception: " + e);
            return null;
        }
    }

    public static Object getIBatteryStats() {
        try {
            Class<?> clsForName = ReflectionCache.build().forName("com.android.internal.app.IBatteryStats$Stub");
            ReflectionCache.build();
            Method cachedMethod = ReflectionCache.getCachedMethod(clsForName, "asInterface", false, IBinder.class);
            IBinder iBinder = getIBinder("batterystats");
            if (cachedMethod == null) {
                return null;
            }
            return cachedMethod.invoke(clsForName, iBinder);
        } catch (Exception e) {
            Log.w(TAG, "getIBatteryStats exception: " + e);
            return null;
        }
    }

    public static IBinder getIBinder(String str) {
        try {
            Class<?> clsForName = ReflectionCache.build().forName("android.os.ServiceManager");
            ReflectionCache.build();
            Method cachedMethod = ReflectionCache.getCachedMethod(clsForName, "getService", false, String.class);
            if (cachedMethod == null) {
                return null;
            }
            return (IBinder) cachedMethod.invoke(clsForName, str);
        } catch (Exception e) {
            Log.w(TAG, "getIBinder exception: " + e);
            return null;
        }
    }

    public static Object getService(String str) {
        try {
            Class<?> clsForName = ReflectionCache.build().forName("android.os.ServiceManager");
            ReflectionCache.build();
            Method cachedMethod = ReflectionCache.getCachedMethod(clsForName, "getService", false, String.class);
            if (cachedMethod == null) {
                return null;
            }
            return cachedMethod.invoke(clsForName, str);
        } catch (Exception e) {
            Log.w(TAG, "getService exception: " + e);
            return null;
        }
    }

    public static String getStaticVariableString(String str, String str2) {
        try {
            Class<?> clsForName = ReflectionCache.build().forName(str);
            ReflectionCache.build();
            Field cachedField = ReflectionCache.getCachedField(clsForName, str2, true);
            if (cachedField == null) {
                return str2.toLowerCase(Locale.US);
            }
            cachedField.setAccessible(true);
            return (String) cachedField.get(clsForName);
        } catch (Exception unused) {
            return str2.toLowerCase(Locale.US);
        }
    }

    public static int getStaticVariableInt(String str, String str2) {
        try {
            Class<?> clsForName = ReflectionCache.build().forName(str);
            ReflectionCache.build();
            Field cachedField = ReflectionCache.getCachedField(clsForName, str2, true);
            if (cachedField == null) {
                return -1;
            }
            cachedField.setAccessible(true);
            return ((Integer) cachedField.get(clsForName)).intValue();
        } catch (Exception unused) {
            return -1;
        }
    }

    public static Object getWifiManager(Context context) {
        try {
            Class<?> clsForName = ReflectionCache.build().forName("android.net.WifiManager");
            ReflectionCache.build();
            Method cachedMethod = ReflectionCache.getCachedMethod(clsForName, "from", false, Context.class);
            if (cachedMethod == null) {
                return null;
            }
            return cachedMethod.invoke(clsForName, context);
        } catch (Exception e) {
            Log.e(TAG, "getWifiManager exception: " + e);
            return null;
        }
    }

    public static Object getIWindowManager() {
        try {
            Class<?> clsForName = ReflectionCache.build().forName("android.view.IWindowManager$Stub");
            ReflectionCache.build();
            Method cachedMethod = ReflectionCache.getCachedMethod(clsForName, "asInterface", false, IBinder.class);
            IBinder iBinder = getIBinder("window");
            if (cachedMethod == null) {
                return null;
            }
            return cachedMethod.invoke(clsForName, iBinder);
        } catch (Exception e) {
            Log.w(TAG, "getIBatteryStats exception: " + e);
            return null;
        }
    }

    public static Object getIDeviceIdleController() {
        try {
            Class<?> clsForName = ReflectionCache.build().forName("android.os.IDeviceIdleController$Stub");
            ReflectionCache.build();
            Method cachedMethod = ReflectionCache.getCachedMethod(clsForName, "asInterface", false, IBinder.class);
            IBinder iBinder = getIBinder("deviceidle");
            if (cachedMethod == null) {
                return null;
            }
            return cachedMethod.invoke(clsForName, iBinder);
        } catch (Exception e) {
            Log.w(TAG, "getIDeviceIdleController exception: " + e);
            return null;
        }
    }

    public static Object getIGraphicsStats() {
        try {
            Class<?> clsForName = ReflectionCache.build().forName("android.view.IGraphicsStats$Stub");
            ReflectionCache.build();
            Method cachedMethod = ReflectionCache.getCachedMethod(clsForName, "asInterface", false, IBinder.class);
            if (cachedMethod != null) {
                return cachedMethod.invoke(clsForName, getIBinder("graphicsstats"));
            }
            return null;
        } catch (Exception e) {
            Log.w(TAG, "getIGraphicsStats exception: " + e);
            return null;
        }
    }

    public static Object getStepOSHipsService() {
        try {
            Class<?> clsForName = ReflectionCache.build().forName("stepos.hips.IStepOSHipsService$Stub");
            ReflectionCache.build();
            Method cachedMethod = ReflectionCache.getCachedMethod(clsForName, "asInterface", false, IBinder.class);
            if (cachedMethod != null) {
                return cachedMethod.invoke(clsForName, getIBinder("hips_service"));
            }
            return null;
        } catch (Exception e) {
            Log.w(TAG, "getStepOSHipsService exception: " + e);
            return null;
        }
    }

    public static Object getExceptionManager() {
        try {
            Class<?> clsForName = ReflectionCache.build().forName("com.stepos.ems.ExceptionManager");
            ReflectionCache.build();
            Method cachedMethod = ReflectionCache.getCachedMethod(clsForName, "getInstance", false, new Class[0]);
            if (cachedMethod == null) {
                return null;
            }
            return cachedMethod.invoke(clsForName, null);
        } catch (Exception e) {
            Log.e(TAG, "getExceptionManager exception: " + e);
            return null;
        }
    }

    public static Object getWindowManagerExt(Context context) {
        try {
            Class<?> clsForName = ReflectionCache.build().forName("stepos.view.WindowManagerExt");
            ReflectionCache.build();
            Method cachedMethod = ReflectionCache.getCachedMethod(clsForName, "getInstance", false, Context.class);
            if (cachedMethod == null) {
                return null;
            }
            return cachedMethod.invoke(clsForName, context);
        } catch (Exception e) {
            Log.e(TAG, "getWindowManagerExt exception: " + e);
            return null;
        }
    }

    public static Object getIThermalManagerService() {
        try {
            Class<?> clsForName = ReflectionCache.build().forName("android.os.IThermalService$Stub");
            ReflectionCache.build();
            Method cachedMethod = ReflectionCache.getCachedMethod(clsForName, "asInterface", false, IBinder.class);
            if (cachedMethod != null) {
                return cachedMethod.invoke(clsForName, getIBinder("thermalservice"));
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Object getIGameManagerService() {
        try {
            Class<?> clsForName = ReflectionCache.build().forName("android.app.IGameManagerService$Stub");
            ReflectionCache.build();
            Method cachedMethod = ReflectionCache.getCachedMethod(clsForName, "asInterface", false, IBinder.class);
            if (cachedMethod != null) {
                return cachedMethod.invoke(clsForName, getIBinder("game"));
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void writeStatsLog(String str, String str2, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, String str3) {
        StatsEvent.Builder builderNewBuilder = StatsEvent.newBuilder();
        builderNewBuilder.setAtomId(StepOSAtoms.Atom.STEPOS_GAME_POWER_INFO_REPORT_FIELD_NUMBER);
        builderNewBuilder.writeString(str);
        builderNewBuilder.writeString(str2);
        builderNewBuilder.writeFloat(f);
        builderNewBuilder.writeFloat(f2);
        builderNewBuilder.writeFloat(f3);
        builderNewBuilder.writeFloat(f4);
        builderNewBuilder.writeFloat(f5);
        builderNewBuilder.writeFloat(f6);
        builderNewBuilder.writeFloat(f7);
        builderNewBuilder.writeFloat(f8);
        builderNewBuilder.writeString(str3);
        builderNewBuilder.usePooledBuffer();
        StatsLog.write(builderNewBuilder.build());
    }
}
