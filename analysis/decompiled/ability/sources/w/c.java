package w;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

/* loaded from: classes2.dex */
public final class c {
    public static volatile c b;

    /* renamed from: a, reason: collision with root package name */
    public final CopyOnWriteArraySet f6800a = new CopyOnWriteArraySet();

    public static c a() {
        if (b == null) {
            synchronized (c.class) {
                try {
                    if (b == null) {
                        b = new c();
                    }
                } finally {
                }
            }
        }
        return b;
    }

    public final void b() {
        Iterator it = this.f6800a.iterator();
        while (it.hasNext()) {
            ((c) it.next()).b();
        }
    }

    public final void c() {
        Iterator it = this.f6800a.iterator();
        while (it.hasNext()) {
            ((c) it.next()).c();
        }
    }
}
