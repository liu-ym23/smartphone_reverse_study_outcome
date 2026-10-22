package g8;

import f8.n0;
import java.util.Map;
import v9.v;

/* loaded from: classes.dex */
public final class l implements c {

    /* renamed from: a, reason: collision with root package name */
    public final c8.h f3891a;

    /* renamed from: b, reason: collision with root package name */
    public final e9.c f3892b;

    /* renamed from: c, reason: collision with root package name */
    public final Map f3893c;

    /* renamed from: d, reason: collision with root package name */
    public final Object f3894d;

    public l(c8.h hVar, e9.c cVar, Map map) {
        q7.k.e(cVar, "fqName");
        this.f3891a = hVar;
        this.f3892b = cVar;
        this.f3893c = map;
        this.f3894d = s7.a.G(c7.h.f1970f, new a8.c(7, this));
    }

    @Override // g8.c
    public final e9.c a() {
        return this.f3892b;
    }

    @Override // g8.c
    public final Map b() {
        return this.f3893c;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [c7.f, java.lang.Object] */
    @Override // g8.c
    public final v getType() {
        Object value = this.f3894d.getValue();
        q7.k.d(value, "<get-type>(...)");
        return (v) value;
    }

    @Override // g8.c
    public final n0 q() {
        return n0.f3487b;
    }
}
