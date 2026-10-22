package P4;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import java.io.File;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static final String f4850a = "a";

    /* renamed from: b, reason: collision with root package name */
    private static Context f4851b;

    public static void a(String str) {
        try {
            f4851b = ((Application) Class.forName("android.app.ActivityThread").getMethod("currentApplication", null).invoke(null, null)).getApplicationContext();
        } catch (Exception unused) {
        }
        c(f4851b, str);
    }

    private static boolean b(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
                StringBuilder sb = new StringBuilder();
                sb.append(context.getApplicationInfo().dataDir);
                sb.append("/lib");
                String string = sb.toString();
                StringBuilder sb2 = new StringBuilder();
                sb2.append(string);
                sb2.append(File.separator);
                sb2.append("lib");
                sb2.append(str);
                sb2.append(".so");
                System.load(sb2.toString());
                return true;
            } catch (Throwable th) {
                Log.i(f4850a, "load  fail! Error: " + th.getMessage());
            }
        }
        return false;
    }

    private static void c(Context context, String str) {
        if (d(str) || b(context, str)) {
            return;
        }
        e(context, str);
    }

    private static boolean d(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            System.loadLibrary(str);
            return true;
        } catch (Throwable th) {
            Log.i(f4850a, "loadLibrary " + str + " fail! Error: " + th.getMessage());
            return false;
        }
    }

    private static boolean e(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
                N4.c.a(context, str);
                return true;
            } catch (Throwable unused) {
            }
        }
        return false;
    }
}
