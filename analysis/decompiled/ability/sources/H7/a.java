package H7;

import S7.n;
import kotlin.jvm.internal.k;
import z2.l;

/* loaded from: classes3.dex */
public abstract class a implements f {
    private final g key;

    public a(g key) {
        k.f(key, "key");
        this.key = key;
    }

    @Override // H7.h
    public /* bridge */ <R> R fold(R r5, n nVar) {
        return (R) l.w(this, r5, nVar);
    }

    @Override // H7.h
    public /* bridge */ <E extends f> E get(g gVar) {
        return (E) l.x(this, gVar);
    }

    @Override // H7.f
    public g getKey() {
        return this.key;
    }

    @Override // H7.h
    public /* bridge */ h minusKey(g gVar) {
        return l.C(this, gVar);
    }

    @Override // H7.h
    public /* bridge */ h plus(h hVar) {
        return l.H(this, hVar);
    }
}
