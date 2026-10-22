package com.stepos.common.alphame;

import android.os.IBinder;
import android.util.Log;
import java.lang.reflect.Method;
import org.libpag.BuildConfig;

/* loaded from: classes.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private static String f13554a = "AlphaMe";

    /* renamed from: b, reason: collision with root package name */
    private static Method f13555b;

    public static IBinder a(String str) {
        try {
            if (f13555b == null) {
                f13555b = Class.forName("android.os.ServiceManager").getMethod("checkService", String.class);
            }
            return (IBinder) f13555b.invoke(null, str);
        } catch (Exception e6) {
            Log.e(f13554a, BuildConfig.FLAVOR + e6);
            return null;
        }
    }
}
