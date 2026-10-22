package stepos.support.v7.app.palette;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes5.dex */
public final class b {

    /* renamed from: b, reason: collision with root package name */
    public static b f40682b;

    /* renamed from: a, reason: collision with root package name */
    public final List<a> f40683a = new ArrayList();

    public static synchronized b b() {
        try {
            if (f40682b == null) {
                f40682b = new b();
            }
        } catch (Throwable th) {
            throw th;
        }
        return f40682b;
    }

    public void a(a aVar) {
        this.f40683a.add(aVar);
    }

    public void c(int i10) {
        Iterator<a> it = this.f40683a.iterator();
        while (it.hasNext()) {
            it.next().a(i10);
        }
    }

    public void d(float f10) {
        Iterator<a> it = this.f40683a.iterator();
        while (it.hasNext()) {
            it.next().b(f10);
        }
    }

    public void e(float f10) {
        Iterator<a> it = this.f40683a.iterator();
        while (it.hasNext()) {
            it.next().c(f10);
        }
    }
}
