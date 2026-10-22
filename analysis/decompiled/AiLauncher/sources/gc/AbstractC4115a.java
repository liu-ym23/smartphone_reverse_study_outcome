package gc;

import android.app.ActivityThread;
import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import ec.AbstractC4023b;
import java.io.File;

/* renamed from: gc.a, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC4115a {

    /* renamed from: a, reason: collision with root package name */
    public static final String f32872a = "a";

    /* renamed from: b, reason: collision with root package name */
    public static Context f32873b;

    public static Context a() {
        return f32873b;
    }

    public static boolean b(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
                System.load((context.getApplicationInfo().dataDir + "/lib") + File.separator + "lib" + str + ".so");
                return true;
            } catch (Throwable th) {
                Log.i(f32872a, "load  fail! Error: " + th.getMessage());
            }
        }
        return false;
    }

    public static boolean c(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            System.loadLibrary(str);
            return true;
        } catch (Throwable th) {
            Log.i(f32872a, "loadLibrary " + str + " fail! Error: " + th.getMessage());
            return false;
        }
    }

    public static void d(Context context, String str) {
        if (c(str) || b(context, str)) {
            return;
        }
        f(context, str);
    }

    public static void e(String str) {
        try {
            f32873b = ((Application) ActivityThread.class.getMethod("currentApplication", null).invoke(null, null)).getApplicationContext();
        } catch (Exception unused) {
        }
        d(f32873b, str);
    }

    public static boolean f(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
                AbstractC4023b.a(context, str);
                return true;
            } catch (Throwable unused) {
            }
        }
        return false;
    }
}
