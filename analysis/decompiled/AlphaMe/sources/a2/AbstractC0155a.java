package a2;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: a2.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0155a {

    /* renamed from: a, reason: collision with root package name */
    public static final AtomicBoolean f2266a = new AtomicBoolean(false);

    static {
        new Handler(Looper.getMainLooper());
    }

    public static void a(String str, String str2) {
        Log.d("ZyqlPush.SDK", d(str, str2));
    }

    public static void b(String str, String str2) {
        Log.i("ZyqlPush.SDK", d(str, str2));
    }

    public static void c(String str, String str2) {
        Log.e("ZyqlPush.SDK", d(str, str2));
    }

    public static String d(String str, String str2) {
        return "[" + str + "] " + str2;
    }
}
