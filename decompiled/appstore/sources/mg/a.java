package mg;

import android.os.Looper;
import androidx.lifecycle.p;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes4.dex */
public final class a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AtomicReference f22302b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final jg.a f22303a;

    static {
        f22302b = new AtomicReference();
    }

    public a() {
        jg.a r10 = lg.a.a().b().b();
        if (r10 == null) goto L5;
        this.f22303a = r10;
        return;
    L5:
        this.f22303a = new b(Looper.getMainLooper());
    }

    public static a a() {
    L2:
        AtomicReference r10 = f22302b;
        a r11 = (a) r10.get();
        if (r11 != null) goto L4;
        a r12 = new a();
        if (p.a(r10, null, r12) == false) goto L2;
        return r12;
    L4:
        return r11;
    }

    public static jg.a b() {
        return a().f22303a;
    }
}
