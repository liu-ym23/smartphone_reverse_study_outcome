package j6;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static final AtomicBoolean f5399a = new AtomicBoolean(false);

    static {
        new Handler(Looper.getMainLooper());
    }

    public static void a(String str, String str2) {
        Log.d("[Cloud]Push.SDK", d(str, str2));
    }

    public static void b(String str, String str2) {
        Log.i("[Cloud]Push.SDK", d(str, str2));
    }

    public static void c(String str, String str2) {
        Log.e("[Cloud]Push.SDK", d(str, str2));
    }

    public static String d(String str, String str2) {
        return a1.a.k("[", str, "] ", str2);
    }
}
