package j9;

import f8.z;

/* loaded from: classes.dex */
public final class j extends g {

    /* renamed from: b, reason: collision with root package name */
    public final String f5411b;

    public j(String str) {
        super(c7.r.f1986a);
        this.f5411b = str;
    }

    @Override // j9.g
    public final v9.v a(z zVar) {
        q7.k.e(zVar, "module");
        return x9.i.c(x9.h.f11319y, this.f5411b);
    }

    @Override // j9.g
    public final Object b() {
        throw new UnsupportedOperationException();
    }

    @Override // j9.g
    public final String toString() {
        return this.f5411b;
    }
}
