package f6;

import android.util.Log;
import kotlin.jvm.internal.k;

/* renamed from: f6.a, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC1436a {

    /* renamed from: a, reason: collision with root package name */
    public static final boolean f4439a;
    public static final String b;

    static {
        boolean zBooleanValue;
        try {
            Object objInvoke = Class.forName("android.os.SystemProperties").getMethod("getBoolean", String.class, Boolean.TYPE).invoke(null, "debug.zyql.log", Boolean.FALSE);
            k.d(objInvoke, "null cannot be cast to non-null type kotlin.Boolean");
            zBooleanValue = ((Boolean) objInvoke).booleanValue();
        } catch (Exception unused) {
            zBooleanValue = false;
        }
        f4439a = zBooleanValue;
        b = "com.stepos.taskrobot::";
    }

    public static final void a(String tag, String msg, boolean z10) {
        k.f(tag, "tag");
        k.f(msg, "msg");
        if (f4439a) {
            if (z10) {
                Log.d(b + tag, msg);
            }
            l6.c.f5288a.d(B7.a.B(tag, " : ", msg), new Object[0]);
        }
    }

    public static final void b(String tag, String msg, boolean z10) {
        k.f(tag, "tag");
        k.f(msg, "msg");
        if (f4439a) {
            if (z10) {
                Log.e(b + tag, msg);
            }
            l6.c.f5288a.e(null, B7.a.B(tag, " : ", msg), new Object[0]);
        }
    }

    public static void c(String str, String msg, Throwable th) {
        k.f(msg, "msg");
        if (f4439a) {
            Log.e(b + str, msg, th);
            l6.c.f5288a.e(null, str + " : " + msg + "  e: " + th, new Object[0]);
        }
    }

    public static final void d(String tag, String msg, boolean z10) {
        k.f(tag, "tag");
        k.f(msg, "msg");
        if (f4439a) {
            if (z10) {
                Log.i(b + tag, msg);
            }
            l6.c.f5288a.i(B7.a.B(tag, " : ", msg), new Object[0]);
        }
    }

    public static final void e(String tag, String msg, boolean z10) {
        k.f(tag, "tag");
        k.f(msg, "msg");
        if (f4439a) {
            if (z10) {
                Log.w(b + tag, msg);
            }
            l6.c.f5288a.w(B7.a.B(tag, " : ", msg), new Object[0]);
        }
    }
}
