package N4;

import android.content.Context;
import java.io.File;

/* loaded from: classes.dex */
public class c {

    public interface a {
        void a(Context context, String[] strArr, String str, File file, d dVar);
    }

    public interface b {
        String[] a();

        void b(String str);

        String c(String str);

        void d(String str);

        String e(String str);
    }

    /* renamed from: N4.c$c, reason: collision with other inner class name */
    public interface InterfaceC0066c {
        void a(Throwable th);
    }

    public static void a(Context context, String str) {
        b(context, str, null, null);
    }

    public static void b(Context context, String str, String str2, InterfaceC0066c interfaceC0066c) {
        new d().e(context, str, str2, interfaceC0066c);
    }
}
