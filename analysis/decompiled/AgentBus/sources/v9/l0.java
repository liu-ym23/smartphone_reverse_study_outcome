package v9;

import java.util.ArrayDeque;

/* loaded from: classes.dex */
public class l0 {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f10566a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f10567b;

    /* renamed from: c, reason: collision with root package name */
    public final w9.c f10568c;

    /* renamed from: d, reason: collision with root package name */
    public final w9.f f10569d;

    /* renamed from: e, reason: collision with root package name */
    public final w9.g f10570e;

    /* renamed from: f, reason: collision with root package name */
    public int f10571f;

    /* renamed from: g, reason: collision with root package name */
    public ArrayDeque f10572g;

    /* renamed from: h, reason: collision with root package name */
    public ea.h f10573h;

    public l0(boolean z4, boolean z10, w9.c cVar, w9.f fVar, w9.g gVar) {
        q7.k.e(cVar, "typeSystemContext");
        q7.k.e(fVar, "kotlinTypePreparator");
        q7.k.e(gVar, "kotlinTypeRefiner");
        this.f10566a = z4;
        this.f10567b = z10;
        this.f10568c = cVar;
        this.f10569d = fVar;
        this.f10570e = gVar;
    }

    public final void a() {
        ArrayDeque arrayDeque = this.f10572g;
        q7.k.b(arrayDeque);
        arrayDeque.clear();
        ea.h hVar = this.f10573h;
        q7.k.b(hVar);
        hVar.clear();
    }

    public final void b() {
        if (this.f10572g == null) {
            this.f10572g = new ArrayDeque(4);
        }
        if (this.f10573h == null) {
            this.f10573h = new ea.h();
        }
    }

    public final z0 c(y9.h hVar) {
        q7.k.e(hVar, "type");
        return this.f10569d.f(hVar);
    }

    public final v d(y9.h hVar) {
        q7.k.e(hVar, "type");
        this.f10570e.getClass();
        return (v) hVar;
    }
}
