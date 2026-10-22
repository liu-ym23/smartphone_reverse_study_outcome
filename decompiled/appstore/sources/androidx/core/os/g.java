package androidx.core.os;

import android.os.Trace;
import androidx.annotation.DoNotInline;

/* JADX INFO: loaded from: classes.dex */
public abstract class g {

    public static class a {
        @DoNotInline
        public static void a(String r10) {
            Trace.beginSection(r10);
        }

        @DoNotInline
        public static void b() {
            Trace.endSection();
        }
    }

    static {
    }

    public static void a(String r10) {
        a.a(r10);
    }

    public static void b() {
        a.b();
    }
}
