package com.mdisdk.capability.framework;

import android.content.ComponentName;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.constraintlayout.core.dsl.a;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes3.dex */
public class StepOsFrameworkUtils {
    private static final String KEY_GET_ACTIVITY_INTENT_BY_PACKAGE = "getActivityIntentByPackage";
    public static final String KEY_SCREENSHOT_RESULT_BITMAP = "android.view.screenshot.result_bitmap";
    public static final String KEY_SCREENSHOT_RESULT_CODE = "android.view.screenshot.result_code";
    public static final String KEY_SCREENSHOT_RESULT_MESSAGE = "android.view.screenshot.result_message";
    private static final String KEY_SET_REDIRECT_ACTIVITY = "setRedirectActivity";
    private static final String METHOD_ADD_DISPLAY_CONTROL_PACKAGE = "addOmniDisplayControlPackage";
    private static final String METHOD_APEX_REQUEST = "apexRequest";
    private static final String METHOD_GET_TOP_ACTIVITY_INTENT = "getTopActivityIntent";
    private static final String METHOD_MOVE_APP_TO_DISPLAY = "moveAppToDisplay";
    private static final String METHOD_OMNI_CALL = "omniCall";
    private static final String METHOD_TAKE_SCREENSHOT = "takeScreenshot";
    private static final String METHOD_TAKE_SCREENSHOT_WITH_SCALE_RESULT = "takeScreenshotWithScaleResult";
    private static final String PARAM_COMPONENT = "component";
    private static final String PARAM_DISPLAY_ID = "displayId";
    private static final String PARAM_INTENT = "intent";
    private static final String PARAM_PACKAGE_NAME = "packageName";
    public static final int SCREENSHOT_RESULT_ERROR_CAPTURE_FAILED = 3;
    public static final int SCREENSHOT_RESULT_ERROR_SECURE = 2;
    public static final int SCREENSHOT_RESULT_ERROR_UNKNOWN = 1;
    public static final int SCREENSHOT_RESULT_ERROR_UNSUPPORTED = 4;
    public static final int SCREENSHOT_RESULT_SUCCESS = 0;
    private static final String TAG = "StepOsFrameworkUtils";
    private static Method addDisplayControlPackage;
    private static Method addEventListenerMethod;
    private static Method addOmniDisplayCallbackMethod;
    private static Method apexRequest;
    private static Method getShowingDisplayIdMethod;
    private static Method getTopActivityIntentMethod;
    private static Method isOmniDisplayIdMethod;
    private static Method isOmniDisplayImeEnabledMethod;
    private static Method isOmniDisplayTakeoverMethod;
    private static Method moveAppToDisplay;
    private static Method omniCallMethod;
    private static Method omniManagerAddCallbackMethod;
    private static Boolean omniManagerAvailable;
    private static Method omniManagerRemoveCallbackMethod;
    private static Method removeEventListenerMethod;
    private static Method removeOmniDisplayCallbackMethod;
    private static Method setOmniDisplayImeEnabledMethod;
    private static Method setOmniDisplayTakeoverMethod;
    private static Method takeScreenShot;
    private static Method takeScreenshotWithScaleResultMethod;
    private static Object windowManager;

    public static boolean addDisplayControlPackage(String str) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        try {
            if (windowManager == null) {
                windowManager = Class.forName("stepos.app.IStepOSWindowManager$Stub").getMethod("asInterface", IBinder.class).invoke(null, (IBinder) Class.forName("android.os.ServiceManager").getMethod("getService", String.class).invoke(null, "window_ext"));
            }
            if (addDisplayControlPackage == null) {
                addDisplayControlPackage = Class.forName("stepos.app.IStepOSWindowManager").getMethod(METHOD_ADD_DISPLAY_CONTROL_PACKAGE, String.class);
            }
            addDisplayControlPackage.invoke(windowManager, str);
            Log.d(TAG, "addOmniDisplayControlPackage method invoked successfully");
            return true;
        } catch (ClassNotFoundException e) {
            a.s(e, new StringBuilder("addOmniDisplayControlPackage ClassNotFoundException: "), TAG);
            return false;
        } catch (IllegalAccessException e6) {
            a.u(e6, new StringBuilder("addOmniDisplayControlPackage IllegalAccessException: "), TAG);
            return false;
        } catch (NoSuchMethodException e9) {
            a.v(e9, new StringBuilder("addOmniDisplayControlPackage NoSuchMethodException: "), TAG);
            return false;
        } catch (InvocationTargetException e10) {
            a.B(e10, new StringBuilder("addOmniDisplayControlPackage InvocationTargetException: "), TAG);
            return false;
        } catch (Exception e11) {
            a.t(e11, new StringBuilder("addOmniDisplayControlPackage Exception: "), TAG);
            return false;
        }
    }

    public static void addEventListener(Handler handler, int i, int i6) throws IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        try {
            if (addEventListenerMethod == null) {
                Class<?> cls = Class.forName("android.app.usage.StepOSAppUsageUtils");
                Class cls2 = Integer.TYPE;
                addEventListenerMethod = cls.getMethod("addEventListener", Handler.class, cls2, cls2);
            }
            addEventListenerMethod.invoke(null, handler, Integer.valueOf(i), Integer.valueOf(i6));
            Log.d(TAG, "addEventListener invoked successfully, eventType=0x" + Integer.toHexString(i6));
        } catch (ClassNotFoundException e) {
            a.s(e, new StringBuilder("addEventListener ClassNotFoundException: "), TAG);
        } catch (NoSuchMethodException e6) {
            a.v(e6, new StringBuilder("addEventListener NoSuchMethodException: "), TAG);
        } catch (Exception e9) {
            a.t(e9, new StringBuilder("addEventListener Exception: "), TAG);
        }
    }

    public static void addOmniDisplayCallback(Handler handler, int i) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Boolean bool = omniManagerAvailable;
        Class cls = Integer.TYPE;
        if (bool == null || bool.booleanValue()) {
            try {
                if (omniManagerAddCallbackMethod == null) {
                    omniManagerAddCallbackMethod = Class.forName("stepos.app.OmniManager").getMethod("addOmniDisplayCallback", Handler.class, cls);
                    omniManagerAvailable = Boolean.TRUE;
                }
                omniManagerAddCallbackMethod.invoke(null, handler, Integer.valueOf(i));
                Log.d(TAG, "addOmniDisplayCallback (OmniManager) invoked successfully, handler=" + handler + ", message=" + i);
                return;
            } catch (ClassNotFoundException | NoSuchMethodException e) {
                omniManagerAvailable = Boolean.FALSE;
                Log.d(TAG, "OmniManager unavailable, fallback to StepOSViewContentUtils: " + e.getMessage());
            } catch (Exception e6) {
                a.t(e6, new StringBuilder("addOmniDisplayCallback (OmniManager) Exception: "), TAG);
                return;
            }
        }
        try {
            if (addOmniDisplayCallbackMethod == null) {
                addOmniDisplayCallbackMethod = Class.forName("android.view.StepOSViewContentUtils").getMethod("addOmniDisplayCallback", Handler.class, cls);
            }
            addOmniDisplayCallbackMethod.invoke(null, handler, Integer.valueOf(i));
            Log.d(TAG, "addOmniDisplayCallback (legacy) invoked successfully, handler=" + handler + ", message=" + i);
        } catch (ClassNotFoundException e9) {
            a.s(e9, new StringBuilder("addOmniDisplayCallback ClassNotFoundException: "), TAG);
        } catch (NoSuchMethodException e10) {
            a.v(e10, new StringBuilder("addOmniDisplayCallback NoSuchMethodException: "), TAG);
        } catch (Exception e11) {
            a.t(e11, new StringBuilder("addOmniDisplayCallback Exception: "), TAG);
        }
    }

    public static void apexRequest(Intent intent) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        try {
            if (apexRequest == null) {
                apexRequest = Class.forName("android.view.StepOSViewContentUtils").getMethod(METHOD_APEX_REQUEST, Intent.class);
            }
            apexRequest.invoke(null, intent);
            Log.d(TAG, "apexRequest method invoked successfully");
        } catch (ClassNotFoundException e) {
            a.s(e, new StringBuilder("apexRequest ClassNotFoundException: "), TAG);
        } catch (IllegalAccessException e6) {
            a.u(e6, new StringBuilder("apexRequest IllegalAccessException: "), TAG);
        } catch (NoSuchMethodException e9) {
            a.v(e9, new StringBuilder("apexRequest NoSuchMethodException: "), TAG);
        } catch (InvocationTargetException e10) {
            a.B(e10, new StringBuilder("apexRequest InvocationTargetException: "), TAG);
        } catch (Exception e11) {
            a.t(e11, new StringBuilder("apexRequest Exception: "), TAG);
        }
    }

    @Nullable
    public static Intent getActivityIntentByPackage(String str, int i) {
        Bundle bundle = new Bundle();
        bundle.putString(PARAM_PACKAGE_NAME, str);
        bundle.putInt("displayId", i);
        Bundle bundleOmniCall = omniCall(KEY_GET_ACTIVITY_INTENT_BY_PACKAGE, bundle);
        if (bundleOmniCall != null) {
            return (Intent) bundleOmniCall.getParcelable(PARAM_INTENT);
        }
        return null;
    }

    public static int getShowingDisplayId(String str) {
        try {
            if (windowManager == null) {
                windowManager = Class.forName("stepos.app.IStepOSWindowManager$Stub").getMethod("asInterface", IBinder.class).invoke(null, (IBinder) Class.forName("android.os.ServiceManager").getMethod("getService", String.class).invoke(null, "window_ext"));
            }
            if (getShowingDisplayIdMethod == null) {
                getShowingDisplayIdMethod = Class.forName("stepos.app.IStepOSWindowManager").getMethod("getShowingDisplayId", String.class);
            }
            Integer num = (Integer) getShowingDisplayIdMethod.invoke(windowManager, str);
            Log.d(TAG, "getShowingDisplayId invoked successfully, packageName=" + str + ", displayId=" + num);
            if (num != null) {
                return num.intValue();
            }
            return -1;
        } catch (ClassNotFoundException e) {
            a.s(e, new StringBuilder("getShowingDisplayId ClassNotFoundException: "), TAG);
            return -1;
        } catch (IllegalAccessException e6) {
            a.u(e6, new StringBuilder("getShowingDisplayId IllegalAccessException: "), TAG);
            return -1;
        } catch (NoSuchMethodException e9) {
            a.v(e9, new StringBuilder("getShowingDisplayId NoSuchMethodException: "), TAG);
            return -1;
        } catch (InvocationTargetException e10) {
            a.B(e10, new StringBuilder("getShowingDisplayId InvocationTargetException: "), TAG);
            return -1;
        } catch (Exception e11) {
            a.t(e11, new StringBuilder("getShowingDisplayId Exception: "), TAG);
            return -1;
        }
    }

    @Nullable
    public static Intent getTopActivityIntent(int i) {
        try {
            if (windowManager == null) {
                windowManager = Class.forName("stepos.app.IStepOSWindowManager$Stub").getMethod("asInterface", IBinder.class).invoke(null, (IBinder) Class.forName("android.os.ServiceManager").getMethod("getService", String.class).invoke(null, "window_ext"));
            }
            if (getTopActivityIntentMethod == null) {
                getTopActivityIntentMethod = Class.forName("stepos.app.IStepOSWindowManager").getMethod(METHOD_GET_TOP_ACTIVITY_INTENT, Integer.TYPE);
            }
            Intent intent = (Intent) getTopActivityIntentMethod.invoke(windowManager, Integer.valueOf(i));
            Log.d(TAG, "getTopActivityIntent method invoked successfully, intent: " + intent);
            return intent;
        } catch (ClassNotFoundException e) {
            a.s(e, new StringBuilder("getTopActivityIntent ClassNotFoundException: "), TAG);
            return null;
        } catch (IllegalAccessException e6) {
            a.u(e6, new StringBuilder("getTopActivityIntent IllegalAccessException: "), TAG);
            return null;
        } catch (NoSuchMethodException e9) {
            a.v(e9, new StringBuilder("getTopActivityIntent NoSuchMethodException: "), TAG);
            return null;
        } catch (InvocationTargetException e10) {
            a.B(e10, new StringBuilder("getTopActivityIntent InvocationTargetException: "), TAG);
            return null;
        } catch (Exception e11) {
            a.t(e11, new StringBuilder("getTopActivityIntent Exception: "), TAG);
            return null;
        }
    }

    public static boolean isOmniDisplayId(String str) {
        try {
            if (windowManager == null) {
                windowManager = Class.forName("stepos.app.IStepOSWindowManager$Stub").getMethod("asInterface", IBinder.class).invoke(null, (IBinder) Class.forName("android.os.ServiceManager").getMethod("getService", String.class).invoke(null, "window_ext"));
            }
            if (isOmniDisplayIdMethod == null) {
                isOmniDisplayIdMethod = Class.forName("stepos.app.IStepOSWindowManager").getMethod("isOmniDisplayId", String.class);
            }
            Boolean bool = (Boolean) isOmniDisplayIdMethod.invoke(windowManager, str);
            Log.d(TAG, "isOmniDisplayId invoked successfully, packageName=" + str + ", result=" + bool);
            if (bool != null) {
                return bool.booleanValue();
            }
            return false;
        } catch (ClassNotFoundException e) {
            a.s(e, new StringBuilder("isOmniDisplayId ClassNotFoundException: "), TAG);
            return false;
        } catch (IllegalAccessException e6) {
            a.u(e6, new StringBuilder("isOmniDisplayId IllegalAccessException: "), TAG);
            return false;
        } catch (NoSuchMethodException e9) {
            a.v(e9, new StringBuilder("isOmniDisplayId NoSuchMethodException: "), TAG);
            return false;
        } catch (InvocationTargetException e10) {
            a.B(e10, new StringBuilder("isOmniDisplayId InvocationTargetException: "), TAG);
            return false;
        } catch (Exception e11) {
            a.t(e11, new StringBuilder("isOmniDisplayId Exception: "), TAG);
            return false;
        }
    }

    public static boolean isOmniDisplayImeEnabled(int i) {
        try {
            if (windowManager == null) {
                windowManager = Class.forName("stepos.app.IStepOSWindowManager$Stub").getMethod("asInterface", IBinder.class).invoke(null, (IBinder) Class.forName("android.os.ServiceManager").getMethod("getService", String.class).invoke(null, "window_ext"));
            }
            if (isOmniDisplayImeEnabledMethod == null) {
                isOmniDisplayImeEnabledMethod = Class.forName("stepos.app.IStepOSWindowManager").getMethod("isOmniDisplayImeEnabled", Integer.TYPE);
            }
            Boolean bool = (Boolean) isOmniDisplayImeEnabledMethod.invoke(windowManager, Integer.valueOf(i));
            Log.d(TAG, "isOmniDisplayImeEnabled invoked successfully, displayId=" + i + ", result=" + bool);
            if (bool != null) {
                return bool.booleanValue();
            }
            return false;
        } catch (ClassNotFoundException e) {
            a.s(e, new StringBuilder("isOmniDisplayImeEnabled ClassNotFoundException: "), TAG);
            return false;
        } catch (IllegalAccessException e6) {
            a.u(e6, new StringBuilder("isOmniDisplayImeEnabled IllegalAccessException: "), TAG);
            return false;
        } catch (NoSuchMethodException e9) {
            a.v(e9, new StringBuilder("isOmniDisplayImeEnabled NoSuchMethodException: "), TAG);
            return false;
        } catch (InvocationTargetException e10) {
            a.B(e10, new StringBuilder("isOmniDisplayImeEnabled InvocationTargetException: "), TAG);
            return false;
        } catch (Exception e11) {
            a.t(e11, new StringBuilder("isOmniDisplayImeEnabled Exception: "), TAG);
            return false;
        }
    }

    public static boolean isOmniDisplayTakeover(int i) {
        try {
            if (windowManager == null) {
                windowManager = Class.forName("stepos.app.IStepOSWindowManager$Stub").getMethod("asInterface", IBinder.class).invoke(null, (IBinder) Class.forName("android.os.ServiceManager").getMethod("getService", String.class).invoke(null, "window_ext"));
            }
            if (isOmniDisplayTakeoverMethod == null) {
                isOmniDisplayTakeoverMethod = Class.forName("stepos.app.IStepOSWindowManager").getMethod("isOmniDisplayTakeover", Integer.TYPE);
            }
            Boolean bool = (Boolean) isOmniDisplayTakeoverMethod.invoke(windowManager, Integer.valueOf(i));
            Log.d(TAG, "isOmniDisplayTakeover invoked successfully, displayId=" + i + ", result=" + bool);
            if (bool != null) {
                return bool.booleanValue();
            }
            return false;
        } catch (ClassNotFoundException e) {
            a.s(e, new StringBuilder("isOmniDisplayTakeover ClassNotFoundException: "), TAG);
            return false;
        } catch (IllegalAccessException e6) {
            a.u(e6, new StringBuilder("isOmniDisplayTakeover IllegalAccessException: "), TAG);
            return false;
        } catch (NoSuchMethodException e9) {
            a.v(e9, new StringBuilder("isOmniDisplayTakeover NoSuchMethodException: "), TAG);
            return false;
        } catch (InvocationTargetException e10) {
            a.B(e10, new StringBuilder("isOmniDisplayTakeover InvocationTargetException: "), TAG);
            return false;
        } catch (Exception e11) {
            a.t(e11, new StringBuilder("isOmniDisplayTakeover Exception: "), TAG);
            return false;
        }
    }

    public static boolean moveAppToDisplay(String str, int i, boolean z10, int i6) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        try {
            if (windowManager == null) {
                windowManager = Class.forName("stepos.app.IStepOSWindowManager$Stub").getMethod("asInterface", IBinder.class).invoke(null, (IBinder) Class.forName("android.os.ServiceManager").getMethod("getService", String.class).invoke(null, "window_ext"));
            }
            if (moveAppToDisplay == null) {
                moveAppToDisplay = Class.forName("stepos.app.IStepOSWindowManager").getMethod(METHOD_MOVE_APP_TO_DISPLAY, String.class, Integer.TYPE, Boolean.TYPE);
            }
            moveAppToDisplay.invoke(windowManager, str, Integer.valueOf(i), Boolean.valueOf(z10));
            Log.d(TAG, "moveAppToDisplay method invoked successfully");
            return true;
        } catch (ClassNotFoundException e) {
            a.s(e, new StringBuilder("moveAppToDisplay ClassNotFoundException: "), TAG);
            return false;
        } catch (IllegalAccessException e6) {
            a.u(e6, new StringBuilder("moveAppToDisplay IllegalAccessException: "), TAG);
            return false;
        } catch (NoSuchMethodException e9) {
            a.v(e9, new StringBuilder("moveAppToDisplay NoSuchMethodException: "), TAG);
            return false;
        } catch (InvocationTargetException e10) {
            a.B(e10, new StringBuilder("moveAppToDisplay InvocationTargetException: "), TAG);
            return false;
        } catch (Exception e11) {
            a.t(e11, new StringBuilder("moveAppToDisplay Exception: "), TAG);
            return false;
        }
    }

    @Nullable
    public static Bundle omniCall(String str, @Nullable Bundle bundle) {
        try {
            if (windowManager == null) {
                windowManager = Class.forName("stepos.app.IStepOSWindowManager$Stub").getMethod("asInterface", IBinder.class).invoke(null, (IBinder) Class.forName("android.os.ServiceManager").getMethod("getService", String.class).invoke(null, "window_ext"));
            }
            if (omniCallMethod == null) {
                omniCallMethod = Class.forName("stepos.app.IStepOSWindowManager").getMethod(METHOD_OMNI_CALL, String.class, Bundle.class);
            }
            Bundle bundle2 = (Bundle) omniCallMethod.invoke(windowManager, str, bundle);
            Log.d(TAG, "omniCall invoked successfully, key=" + str);
            return bundle2;
        } catch (ClassNotFoundException e) {
            a.s(e, new StringBuilder("omniCall ClassNotFoundException: "), TAG);
            return null;
        } catch (IllegalAccessException e6) {
            a.u(e6, new StringBuilder("omniCall IllegalAccessException: "), TAG);
            return null;
        } catch (NoSuchMethodException e9) {
            a.v(e9, new StringBuilder("omniCall NoSuchMethodException: "), TAG);
            return null;
        } catch (InvocationTargetException e10) {
            a.B(e10, new StringBuilder("omniCall InvocationTargetException: "), TAG);
            return null;
        } catch (Exception e11) {
            a.t(e11, new StringBuilder("omniCall Exception: "), TAG);
            return null;
        }
    }

    public static void removeEventListener(Handler handler, int i, int i6) throws IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        try {
            if (removeEventListenerMethod == null) {
                Class<?> cls = Class.forName("android.app.usage.StepOSAppUsageUtils");
                Class cls2 = Integer.TYPE;
                removeEventListenerMethod = cls.getMethod("removeEventListener", Handler.class, cls2, cls2);
            }
            removeEventListenerMethod.invoke(null, handler, Integer.valueOf(i), Integer.valueOf(i6));
            Log.d(TAG, "removeEventListener invoked successfully");
        } catch (ClassNotFoundException e) {
            a.s(e, new StringBuilder("removeEventListener ClassNotFoundException: "), TAG);
        } catch (NoSuchMethodException e6) {
            a.v(e6, new StringBuilder("removeEventListener NoSuchMethodException: "), TAG);
        } catch (Exception e9) {
            a.t(e9, new StringBuilder("removeEventListener Exception: "), TAG);
        }
    }

    public static void removeOmniDisplayCallback(Handler handler, int i) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Boolean bool = omniManagerAvailable;
        Class cls = Integer.TYPE;
        if (bool == null || bool.booleanValue()) {
            try {
                if (omniManagerRemoveCallbackMethod == null) {
                    omniManagerRemoveCallbackMethod = Class.forName("stepos.app.OmniManager").getMethod("removeOmniDisplayCallback", Handler.class, cls);
                    omniManagerAvailable = Boolean.TRUE;
                }
                omniManagerRemoveCallbackMethod.invoke(null, handler, Integer.valueOf(i));
                Log.d(TAG, "removeOmniDisplayCallback (OmniManager) invoked successfully");
                return;
            } catch (ClassNotFoundException | NoSuchMethodException e) {
                omniManagerAvailable = Boolean.FALSE;
                Log.d(TAG, "OmniManager unavailable, fallback to StepOSViewContentUtils: " + e.getMessage());
            } catch (Exception e6) {
                a.t(e6, new StringBuilder("removeOmniDisplayCallback (OmniManager) Exception: "), TAG);
                return;
            }
        }
        try {
            if (removeOmniDisplayCallbackMethod == null) {
                removeOmniDisplayCallbackMethod = Class.forName("android.view.StepOSViewContentUtils").getMethod("removeOmniDisplayCallback", Handler.class, cls);
            }
            removeOmniDisplayCallbackMethod.invoke(null, handler, Integer.valueOf(i));
            Log.d(TAG, "removeOmniDisplayCallback (legacy) invoked successfully");
        } catch (ClassNotFoundException e9) {
            a.s(e9, new StringBuilder("removeOmniDisplayCallback ClassNotFoundException: "), TAG);
        } catch (NoSuchMethodException e10) {
            a.v(e10, new StringBuilder("removeOmniDisplayCallback NoSuchMethodException: "), TAG);
        } catch (Exception e11) {
            a.t(e11, new StringBuilder("removeOmniDisplayCallback Exception: "), TAG);
        }
    }

    public static void setOmniDisplayImeEnabled(int i, boolean z10) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        try {
            if (windowManager == null) {
                windowManager = Class.forName("stepos.app.IStepOSWindowManager$Stub").getMethod("asInterface", IBinder.class).invoke(null, (IBinder) Class.forName("android.os.ServiceManager").getMethod("getService", String.class).invoke(null, "window_ext"));
            }
            if (setOmniDisplayImeEnabledMethod == null) {
                setOmniDisplayImeEnabledMethod = Class.forName("stepos.app.IStepOSWindowManager").getMethod("setOmniDisplayImeEnabled", Integer.TYPE, Boolean.TYPE);
            }
            setOmniDisplayImeEnabledMethod.invoke(windowManager, Integer.valueOf(i), Boolean.valueOf(z10));
            Log.d(TAG, "setOmniDisplayImeEnabled invoked successfully, displayId=" + i + ", enabled=" + z10);
        } catch (ClassNotFoundException e) {
            a.s(e, new StringBuilder("setOmniDisplayImeEnabled ClassNotFoundException: "), TAG);
        } catch (IllegalAccessException e6) {
            a.u(e6, new StringBuilder("setOmniDisplayImeEnabled IllegalAccessException: "), TAG);
        } catch (NoSuchMethodException e9) {
            a.v(e9, new StringBuilder("setOmniDisplayImeEnabled NoSuchMethodException: "), TAG);
        } catch (InvocationTargetException e10) {
            a.B(e10, new StringBuilder("setOmniDisplayImeEnabled InvocationTargetException: "), TAG);
        } catch (Exception e11) {
            a.t(e11, new StringBuilder("setOmniDisplayImeEnabled Exception: "), TAG);
        }
    }

    public static void setOmniDisplayTakeover(int i, boolean z10) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        try {
            if (windowManager == null) {
                windowManager = Class.forName("stepos.app.IStepOSWindowManager$Stub").getMethod("asInterface", IBinder.class).invoke(null, (IBinder) Class.forName("android.os.ServiceManager").getMethod("getService", String.class).invoke(null, "window_ext"));
            }
            if (setOmniDisplayTakeoverMethod == null) {
                setOmniDisplayTakeoverMethod = Class.forName("stepos.app.IStepOSWindowManager").getMethod("setOmniDisplayTakeover", Integer.TYPE, Boolean.TYPE);
            }
            setOmniDisplayTakeoverMethod.invoke(windowManager, Integer.valueOf(i), Boolean.valueOf(z10));
            Log.d(TAG, "setOmniDisplayTakeover invoked successfully, displayId=" + i + ", takeover=" + z10);
        } catch (ClassNotFoundException e) {
            a.s(e, new StringBuilder("setOmniDisplayTakeover ClassNotFoundException: "), TAG);
        } catch (IllegalAccessException e6) {
            a.u(e6, new StringBuilder("setOmniDisplayTakeover IllegalAccessException: "), TAG);
        } catch (NoSuchMethodException e9) {
            a.v(e9, new StringBuilder("setOmniDisplayTakeover NoSuchMethodException: "), TAG);
        } catch (InvocationTargetException e10) {
            a.B(e10, new StringBuilder("setOmniDisplayTakeover InvocationTargetException: "), TAG);
        } catch (Exception e11) {
            a.t(e11, new StringBuilder("setOmniDisplayTakeover Exception: "), TAG);
        }
    }

    public static void setRedirectActivity(@Nullable ComponentName componentName) {
        Bundle bundle = new Bundle();
        if (componentName != null) {
            bundle.putString(PARAM_COMPONENT, componentName.flattenToString());
        }
        omniCall(KEY_SET_REDIRECT_ACTIVITY, bundle);
    }

    public static Bitmap takeScreenShot(int i, @Nullable String str) {
        return takeScreenShot(i, (str == null || str.isEmpty()) ? 1 : 0, str);
    }

    public static Bundle takeScreenshotWithScaleResult(int i, int i6, @Nullable String str, float f) throws ClassNotFoundException {
        try {
            if (windowManager == null) {
                windowManager = Class.forName("stepos.app.IStepOSWindowManager$Stub").getMethod("asInterface", IBinder.class).invoke(null, (IBinder) Class.forName("android.os.ServiceManager").getMethod("getService", String.class).invoke(null, "window_ext"));
            }
            if (takeScreenshotWithScaleResultMethod == null) {
                Class<?> cls = Class.forName("stepos.app.IStepOSWindowManager");
                Class cls2 = Integer.TYPE;
                takeScreenshotWithScaleResultMethod = cls.getMethod(METHOD_TAKE_SCREENSHOT_WITH_SCALE_RESULT, cls2, cls2, String.class, Float.TYPE);
            }
            Bundle bundle = (Bundle) takeScreenshotWithScaleResultMethod.invoke(windowManager, Integer.valueOf(i), Integer.valueOf(i6), str, Float.valueOf(f));
            Log.d(TAG, "takeScreenshotWithScaleResult method invoked successfully");
            return bundle;
        } catch (ClassNotFoundException e) {
            a.s(e, new StringBuilder("takeScreenshotWithScaleResult ClassNotFoundException: "), TAG);
            return null;
        } catch (IllegalAccessException e6) {
            a.u(e6, new StringBuilder("takeScreenshotWithScaleResult IllegalAccessException: "), TAG);
            return null;
        } catch (NoSuchMethodException e9) {
            a.v(e9, new StringBuilder("takeScreenshotWithScaleResult NoSuchMethodException: "), TAG);
            return null;
        } catch (InvocationTargetException e10) {
            a.B(e10, new StringBuilder("takeScreenshotWithScaleResult InvocationTargetException: "), TAG);
            return null;
        } catch (Exception e11) {
            a.t(e11, new StringBuilder("takeScreenshotWithScaleResult Exception: "), TAG);
            return null;
        }
    }

    private static Bitmap takeScreenShot(int i, int i6, String str) throws ClassNotFoundException {
        try {
            if (windowManager == null) {
                windowManager = Class.forName("stepos.app.IStepOSWindowManager$Stub").getMethod("asInterface", IBinder.class).invoke(null, (IBinder) Class.forName("android.os.ServiceManager").getMethod("getService", String.class).invoke(null, "window_ext"));
            }
            if (takeScreenShot == null) {
                Class<?> cls = Class.forName("stepos.app.IStepOSWindowManager");
                Class cls2 = Integer.TYPE;
                takeScreenShot = cls.getMethod(METHOD_TAKE_SCREENSHOT, cls2, cls2, String.class);
            }
            Bitmap bitmap = (Bitmap) takeScreenShot.invoke(windowManager, Integer.valueOf(i), Integer.valueOf(i6), str);
            Log.d(TAG, "takeScreenshot method invoked successfully, bitmap: " + bitmap);
            return bitmap;
        } catch (ClassNotFoundException e) {
            a.s(e, new StringBuilder("takeScreenshot ClassNotFoundException: "), TAG);
            return null;
        } catch (IllegalAccessException e6) {
            a.u(e6, new StringBuilder("takeScreenshot IllegalAccessException: "), TAG);
            return null;
        } catch (NoSuchMethodException e9) {
            a.v(e9, new StringBuilder("takeScreenshot NoSuchMethodException: "), TAG);
            return null;
        } catch (InvocationTargetException e10) {
            a.B(e10, new StringBuilder("takeScreenshot InvocationTargetException: "), TAG);
            return null;
        } catch (Exception e11) {
            a.t(e11, new StringBuilder("takeScreenshot Exception: "), TAG);
            return null;
        }
    }
}
