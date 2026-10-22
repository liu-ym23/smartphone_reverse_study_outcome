package androidx.webkit;

import android.webkit.WebSettings;
import androidx.webkit.internal.o;
import androidx.webkit.internal.p;
import androidx.webkit.internal.q;

/* JADX INFO: compiled from: WebSettingsCompat.java */
/* JADX INFO: loaded from: classes.dex */
public class i {
    public static void a(WebSettings r1, boolean r2) {
        if (p.Y.d() == false) goto L7;
        b(r1).a(r2);
        return;
    L7:
        throw p.a();
    }

    public static boolean a(WebSettings r1) {
        if (p.Y.d() == false) goto L7;
        return b(r1).a();
    L7:
        throw p.a();
    }

    private static o b(WebSettings r1) {
        return q.b().a(r1);
    }
}
