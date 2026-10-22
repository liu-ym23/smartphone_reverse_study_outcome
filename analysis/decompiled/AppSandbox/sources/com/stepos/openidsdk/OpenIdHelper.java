package com.stepos.openidsdk;

import android.content.Context;
import android.util.Log;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public class OpenIdHelper {
    private static final String TAG = "OpenIdHelper";
    private static Method sContextMethod;

    public static final boolean isSupported() throws NoSuchMethodException, SecurityException {
        Context context = null;
        try {
            if (sContextMethod == null) {
                Class[] clsArr = new Class[0];
                Method method = Class.forName("android.app.ActivityThread").getMethod("currentApplication", null);
                sContextMethod = method;
                method.setAccessible(true);
            }
            context = (Context) sContextMethod.invoke(null, null);
        } catch (Exception e) {
            Log.e(TAG, "ActivityThread:currentApplication --> " + e.toString());
        }
        if (context == null) {
            return false;
        }
        return OpenIdManager.getInstance().isSupported(context);
    }

    public static String getUDID(Context context) {
        return OpenIdManager.getInstance().getUDID(context.getApplicationContext());
    }

    public static String getOAID(Context context) {
        return OpenIdManager.getInstance().getOAID(context.getApplicationContext());
    }

    public static String getVAID(Context context) {
        return OpenIdManager.getInstance().getVAID(context.getApplicationContext());
    }

    public static String getAAID(Context context) {
        return OpenIdManager.getInstance().getAAID(context.getApplicationContext());
    }

    public static String getDeviceDsid(Context context) {
        return OpenIdManager.getInstance().getDeviceDsid(context.getApplicationContext());
    }

    public static void setLogEnable(boolean z) {
        OpenIdManager.getInstance().setDebug(z);
    }

    public static void setOAIDChangeListener(Context context, IOAIDChangeListener iOAIDChangeListener) {
        OpenIdManager.getInstance().setOAIDChangeListener(iOAIDChangeListener);
    }

    public static void clearOAIDChangeListener() {
        OpenIdManager.getInstance().clearOAIDChangeListener();
    }
}
