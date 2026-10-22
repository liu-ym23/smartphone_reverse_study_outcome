package m0;

import b0.p;
import c0.h0;
import d7.z;
import g7.j;
import g7.k;
import g7.l;
import h4.n;
import java.util.List;

/* loaded from: classes.dex */
public final class c implements h0, j {

    /* renamed from: g, reason: collision with root package name */
    public static final n f6123g = new n(9, false);

    /* renamed from: f, reason: collision with root package name */
    public final p f6124f;

    public c(p pVar) {
        this.f6124f = pVar;
    }

    @Override // g7.l
    public final l Q(l lVar) {
        return g7.i.plus(this, lVar);
    }

    @Override // g7.j
    public final k getKey() {
        return f6123g;
    }

    @Override // g7.l
    public final j o(k kVar) {
        return g7.i.get(this, kVar);
    }

    @Override // g7.l
    public final Object r(Object obj, p7.n nVar) {
        return g7.i.fold(this, obj, nVar);
    }

    @Override // c0.h0
    public final List w(Integer num) {
        return z.f2978f;
    }

    @Override // g7.l
    public final l z(k kVar) {
        return g7.i.minusKey(this, kVar);
    }
}
