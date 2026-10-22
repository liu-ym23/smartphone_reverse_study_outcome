package s7;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static final AtomicBoolean f11897a = new AtomicBoolean(false);

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
        return ai.onnxruntime.a.l("[", str, "] ", str2);
    }

    public static void e(String str, String str2) {
        Log.w("[Cloud]Push.SDK", d(str, str2));
    }
}
