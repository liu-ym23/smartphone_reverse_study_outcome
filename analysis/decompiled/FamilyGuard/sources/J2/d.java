package J2;

import android.util.Log;
import j4.k;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public static final d f3217a = new d();

    /* renamed from: b, reason: collision with root package name */
    private static boolean f3218b = true;

    private d() {
    }

    public final void a(String str, String str2, Throwable th) {
        k.g(str, "subtag");
        k.g(str2, "msg");
        if (f3218b) {
            Log.e("MotionKit/" + str, str2, th);
        }
    }

    public final void b(String str, String str2, Throwable th) {
        k.g(str, "subtag");
        k.g(str2, "msg");
        if (f3218b) {
            Log.w("MotionKit/" + str, str2, th);
        }
    }
}
