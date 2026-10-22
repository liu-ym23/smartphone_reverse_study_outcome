package u2;

import android.content.Context;
import s2.j;

/* renamed from: u2.a, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C5570a {

    /* renamed from: a, reason: collision with root package name */
    public static Context f42420a;

    /* renamed from: b, reason: collision with root package name */
    public static Boolean f42421b;

    public static synchronized boolean a(Context context) {
        Boolean bool;
        Context applicationContext = context.getApplicationContext();
        Context context2 = f42420a;
        if (context2 != null && (bool = f42421b) != null && context2 == applicationContext) {
            return bool.booleanValue();
        }
        f42421b = null;
        if (j.f()) {
            f42421b = Boolean.valueOf(applicationContext.getPackageManager().isInstantApp());
        } else {
            try {
                context.getClassLoader().loadClass("com.google.android.instantapps.supervisor.InstantAppsRuntime");
                f42421b = Boolean.TRUE;
            } catch (ClassNotFoundException unused) {
                f42421b = Boolean.FALSE;
            }
        }
        f42420a = applicationContext;
        return f42421b.booleanValue();
    }
}
