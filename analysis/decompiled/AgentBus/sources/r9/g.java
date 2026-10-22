package r9;

import java.util.Set;

/* loaded from: classes.dex */
public final class g {

    /* renamed from: c, reason: collision with root package name */
    public static final Set f9043c = ib.k.S(e9.b.j(c8.m.f2031c.g()));

    /* renamed from: a, reason: collision with root package name */
    public final i f9044a;

    /* renamed from: b, reason: collision with root package name */
    public final b0.e f9045b;

    public g(i iVar) {
        this.f9044a = iVar;
        this.f9045b = iVar.f9047a.c(new r8.c(3, this));
    }

    public final f8.e a(e9.b bVar, d dVar) {
        q7.k.e(bVar, "classId");
        return (f8.e) this.f9045b.invoke(new f(bVar, dVar));
    }
}
