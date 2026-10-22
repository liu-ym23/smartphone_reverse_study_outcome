package s2;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageManager;
import com.google.android.apps.common.proguard.SideEffectFree;

/* loaded from: classes2.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public static Boolean f40055a;

    /* renamed from: b, reason: collision with root package name */
    public static Boolean f40056b;

    /* renamed from: c, reason: collision with root package name */
    public static Boolean f40057c;

    /* renamed from: d, reason: collision with root package name */
    public static Boolean f40058d;

    public static boolean a(Context context) {
        PackageManager packageManager = context.getPackageManager();
        if (f40058d == null) {
            boolean z10 = false;
            if (j.f() && packageManager.hasSystemFeature("android.hardware.type.automotive")) {
                z10 = true;
            }
            f40058d = Boolean.valueOf(z10);
        }
        return f40058d.booleanValue();
    }

    @SideEffectFree
    @TargetApi(20)
    public static boolean b(Context context) {
        return f(context.getPackageManager());
    }

    @TargetApi(26)
    public static boolean c(Context context) {
        if (b(context) && !j.e()) {
            return true;
        }
        if (d(context)) {
            return !j.f() || j.h();
        }
        return false;
    }

    @TargetApi(21)
    public static boolean d(Context context) {
        if (f40056b == null) {
            boolean z10 = false;
            if (j.d() && context.getPackageManager().hasSystemFeature("cn.google")) {
                z10 = true;
            }
            f40056b = Boolean.valueOf(z10);
        }
        return f40056b.booleanValue();
    }

    public static boolean e(Context context) {
        if (f40057c == null) {
            boolean z10 = true;
            if (!context.getPackageManager().hasSystemFeature("android.hardware.type.iot") && !context.getPackageManager().hasSystemFeature("android.hardware.type.embedded")) {
                z10 = false;
            }
            f40057c = Boolean.valueOf(z10);
        }
        return f40057c.booleanValue();
    }

    @SideEffectFree
    @TargetApi(20)
    public static boolean f(PackageManager packageManager) {
        if (f40055a == null) {
            boolean z10 = false;
            if (j.c() && packageManager.hasSystemFeature("android.hardware.type.watch")) {
                z10 = true;
            }
            f40055a = Boolean.valueOf(z10);
        }
        return f40055a.booleanValue();
    }
}
