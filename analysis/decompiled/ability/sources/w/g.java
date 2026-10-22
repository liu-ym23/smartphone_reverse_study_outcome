package w;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

/* loaded from: classes2.dex */
public final class g {
    public static volatile g b;

    /* renamed from: a, reason: collision with root package name */
    public final CopyOnWriteArraySet f6803a = new CopyOnWriteArraySet();

    public static g a() {
        if (b == null) {
            synchronized (g.class) {
                b = new g();
            }
        }
        return b;
    }

    public final void b() {
        Iterator it = this.f6803a.iterator();
        while (it.hasNext()) {
            ((g) it.next()).b();
        }
    }

    public final void c() {
        Iterator it = this.f6803a.iterator();
        while (it.hasNext()) {
            ((g) it.next()).c();
        }
    }
}
