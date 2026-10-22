package ec;

import android.content.Context;
import java.io.File;

/* renamed from: ec.b, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC4023b {

    /* renamed from: ec.b$a */
    public interface a {
        void a(Context context, String[] strArr, String str, File file, C4024c c4024c);
    }

    /* renamed from: ec.b$b, reason: collision with other inner class name */
    public interface InterfaceC0400b {
        String a(String str);

        String[] a();

        void b(String str);

        String c(String str);

        void h(String str);
    }

    /* renamed from: ec.b$c */
    public interface c {
        void a(Throwable th);
    }

    public static void a(Context context, String str) {
        b(context, str, null, null);
    }

    public static void b(Context context, String str, String str2, c cVar) {
        new C4024c().d(context, str, str2, cVar);
    }
}
