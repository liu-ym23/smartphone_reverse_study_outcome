package a84;

import android.os.Build;
import i84.p;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public interface a {

    /* JADX INFO: renamed from: a84.a$a, reason: collision with other inner class name */
    public static class C0026a implements a {
        public C0026a() {
        }

        @Override // a84.a
        public long a() {
            return 100;
        }

        @Override // a84.a
        public final boolean b() {
            p.a r100 = p.f488631a;
            String r101 = Build.BRAND;
            if (r101 != null) goto L5;
            boolean r102 = false;
        L7:
            return !r102;
        L5:
            r102 = r101.toLowerCase(Locale.ENGLISH).contains("meizu");
            goto L7
        }
    }

    long a();

    boolean b();
}
