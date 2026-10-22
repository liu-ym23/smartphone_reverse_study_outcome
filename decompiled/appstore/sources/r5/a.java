package r5;

import android.os.Looper;
import android.util.Printer;
import java.lang.reflect.Field;
import u5.d;

/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Field f23763a;

    public static Printer a() {
        if (f23763a == null) goto L12;
    L10:
        return (Printer) f23763a.get(Looper.getMainLooper());
    L7:
        return null;
    L12:
        f23763a = d.a(Looper.class, "mLogging");     // Catch: Throwable -> L9
        goto L10
    }

    public static void b(String r10) {
        Printer r11 = a();
        if (r11 == null) goto L6;
        r11.println(r10);
        return;
    }
}
