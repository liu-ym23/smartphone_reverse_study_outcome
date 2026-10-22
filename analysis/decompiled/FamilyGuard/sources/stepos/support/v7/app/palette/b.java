package stepos.support.v7.app.palette;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
final class b {

    /* renamed from: b, reason: collision with root package name */
    private static b f20946b;

    /* renamed from: a, reason: collision with root package name */
    private final List<a> f20947a = new ArrayList();

    private b() {
    }

    public static synchronized b b() {
        try {
            if (f20946b == null) {
                f20946b = new b();
            }
        } catch (Throwable th) {
            throw th;
        }
        return f20946b;
    }

    public void a(a aVar) {
        this.f20947a.add(aVar);
    }

    public void c(int i5) {
        Iterator<a> it = this.f20947a.iterator();
        while (it.hasNext()) {
            it.next().b(i5);
        }
    }

    public void d(float f5) {
        Iterator<a> it = this.f20947a.iterator();
        while (it.hasNext()) {
            it.next().a(f5);
        }
    }

    public void e(float f5) {
        Iterator<a> it = this.f20947a.iterator();
        while (it.hasNext()) {
            it.next().c(f5);
        }
    }
}
