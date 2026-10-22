package W7;

import V7.b;
import Z7.O;
import android.content.Context;

/* loaded from: classes4.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static Context f6665a;

    /* renamed from: W7.a$a, reason: collision with other inner class name */
    public static class C0116a extends V7.a {
    }

    public static void a(Context context, String str, boolean z10) {
        b(context, str, z10, null);
    }

    public static void b(Context context, String str, boolean z10, C0116a c0116a) {
        if (context == null) {
            return;
        }
        f6665a = context;
        O.a(b.h());
        O.b(context, str, z10, c0116a);
    }

    public static void c(Context context) {
        f6665a = context;
    }
}
