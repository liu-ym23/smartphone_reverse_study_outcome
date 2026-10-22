package r3;

import android.app.Application;
import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f23719a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f23720b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Application f23721c;

    static {
    }

    public static Application a(Context r10) {
        if (r10 != null) goto L6;
        return null;
    L6:
        if ((r10 instanceof Application) == true) goto L9;
        r10 = r10.getApplicationContext();
    L9:
        return (Application) r10;
    }

    public static Application b() {
        return f23721c;
    }

    public static boolean c() {
        if (f23719a == true) goto L5;
    L7:
        return false;
    L5:
        if (f23720b == true) goto L7;
        return true;
    }

    public static boolean d() {
        return f23720b;
    }

    public static void e(Context r10) {
        if (r10 == null) goto L5;
        f23721c = a(r10);
        return;
    }

    public static void f(boolean r10) {
        f23719a = r10;
    }
}
