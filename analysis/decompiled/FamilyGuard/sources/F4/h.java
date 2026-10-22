package F4;

import C4.H;
import java.util.LinkedHashSet;
import java.util.Set;

/* loaded from: classes.dex */
final class h {

    /* renamed from: a, reason: collision with root package name */
    private final Set<H> f1810a = new LinkedHashSet();

    h() {
    }

    public synchronized void a(H h5) {
        this.f1810a.remove(h5);
    }

    public synchronized void b(H h5) {
        this.f1810a.add(h5);
    }

    public synchronized boolean c(H h5) {
        return this.f1810a.contains(h5);
    }
}
