package a7;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f59a;

    static {
        f59a = Log.isLoggable("watson_assist", 3);
    }

    public static void a(String r10) {
        b("watson_assist", r10);
    }

    public static void b(String r10, String r11) {
        if (f59a == false) goto L6;
        Log.d(r10, r11);
        return;
    }

    public static void c(String r10) {
        d("watson_assist", r10);
    }

    public static void d(String r10, String r11) {
        Log.e(r10, r11);
    }

    public static void e(String r10) {
        f("watson_assist", r10);
    }

    public static void f(String r10, String r11) {
        Log.i(r10, r11);
    }

    public static void g(Context r10, String r11) {
        Toast.makeText(r10, r11, 1).show();
    }

    public static void h(String r10) {
        i("watson_assist", r10);
    }

    public static void i(String r10, String r11) {
        Log.w(r10, r11);
    }
}
