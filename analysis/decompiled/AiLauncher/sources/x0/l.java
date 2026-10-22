package x0;

import android.os.Trace;

@Deprecated
/* loaded from: classes.dex */
public final class l {

    public static class a {
        public static boolean a() {
            return Trace.isEnabled();
        }
    }

    public static void a(String str) {
        Trace.beginSection(str);
    }

    public static void b() {
        Trace.endSection();
    }

    public static boolean c() {
        return a.a();
    }
}
