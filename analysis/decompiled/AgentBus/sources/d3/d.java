package d3;

import java.util.LinkedHashSet;

/* loaded from: classes.dex */
public abstract class d {

    /* renamed from: a, reason: collision with root package name */
    public a.a f2807a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f2808b;

    /* renamed from: c, reason: collision with root package name */
    public i5.f f2809c;

    public abstract void a();

    public abstract void b();

    public abstract void c(b bVar);

    public abstract void d(b bVar);

    public final void e() {
        i5.f fVar = this.f2809c;
        if (fVar == null || !((LinkedHashSet) fVar.f4655i).remove(this)) {
            return;
        }
        g gVar = (g) fVar.f4654h;
        gVar.getClass();
        if (equals(gVar.f2819f)) {
            if (gVar.f2820g == -1) {
                a();
            }
            gVar.f2819f = null;
            gVar.f2820g = 0;
            gVar.f2821h = null;
        }
        gVar.f2817d.remove(this);
        gVar.f2818e.remove(this);
        this.f2809c = null;
        gVar.b();
    }
}
