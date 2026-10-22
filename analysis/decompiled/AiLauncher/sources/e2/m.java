package e2;

import android.util.Base64;
import com.google.android.datatransport.Priority;
import e2.C3976c;

/* loaded from: classes2.dex */
public abstract class m {

    public static abstract class a {
        public abstract m a();

        public abstract a b(String str);

        public abstract a c(byte[] bArr);

        public abstract a d(Priority priority);
    }

    public static a a() {
        return new C3976c.b().d(Priority.DEFAULT);
    }

    public abstract String b();

    public abstract byte[] c();

    public abstract Priority d();

    public m e(Priority priority) {
        return a().b(b()).d(priority).c(c()).a();
    }

    public final String toString() {
        return String.format("TransportContext(%s, %s, %s)", b(), d(), c() == null ? "" : Base64.encodeToString(c(), 2));
    }
}
