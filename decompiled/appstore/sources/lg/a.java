package lg;

import androidx.lifecycle.p;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes4.dex */
public final class a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f21994b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicReference f21995a;

    static {
        f21994b = new a();
    }

    public a() {
        this.f21995a = new AtomicReference();
    }

    public static a a() {
        return f21994b;
    }

    public b b() {
        if (this.f21995a.get() != null) goto L6;
        p.a(this.f21995a, null, b.a());
    L6:
        return (b) this.f21995a.get();
    }
}
