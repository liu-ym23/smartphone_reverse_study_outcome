package com.stepos.openidsdk;

import android.content.Context;
import android.util.Log;
import java.lang.reflect.Method;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public class OpenIdHelper {
    private static final String TAG = "OpenIdHelper";
    private static Method sContextMethod;

    public static void clearOAIDChangeListener() {
        b bVarA = b.a();
        synchronized (bVarA) {
            bVarA.f2772h = null;
        }
    }

    public static String getAAID(Context context) {
        b bVarA = b.a();
        return bVarA.a(context.getApplicationContext(), bVarA.f2767c);
    }

    public static String getOAID(Context context) {
        b bVarA = b.a();
        return bVarA.a(context.getApplicationContext(), bVarA.f2766b);
    }

    public static String getUDID(Context context) {
        b bVarA = b.a();
        return bVarA.a(context.getApplicationContext(), bVarA.f2765a);
    }

    public static String getVAID(Context context) {
        b bVarA = b.a();
        return bVarA.a(context.getApplicationContext(), bVarA.f2768d);
    }

    public static final boolean isSupported() throws NoSuchMethodException, SecurityException {
        Context context = null;
        try {
            if (sContextMethod == null) {
                Method method = Class.forName("android.app.ActivityThread").getMethod("currentApplication", null);
                sContextMethod = method;
                method.setAccessible(true);
            }
            context = (Context) sContextMethod.invoke(null, null);
        } catch (Exception e10) {
            Log.e(TAG, "ActivityThread:currentApplication --> " + e10.toString());
        }
        if (context == null) {
            return false;
        }
        return b.a().a(context, false);
    }

    public static void setLogEnable(boolean z10) {
        b.a().getClass();
        b.f2764j = z10;
    }

    public static void setOAIDChangeListener(Context context, IOAIDChangeListener iOAIDChangeListener) {
        b bVarA = b.a();
        synchronized (bVarA) {
            bVarA.f2772h = iOAIDChangeListener;
        }
    }
}
