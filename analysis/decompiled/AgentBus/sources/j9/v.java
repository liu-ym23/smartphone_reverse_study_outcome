package j9;

import f8.z;

/* loaded from: classes.dex */
public final class v extends o {
    public v(short s10) {
        super(Short.valueOf(s10));
    }

    @Override // j9.g
    public final v9.v a(z zVar) {
        q7.k.e(zVar, "module");
        c8.h hVarN = zVar.n();
        hVarN.getClass();
        return hVarN.s(c8.j.SHORT);
    }

    @Override // j9.g
    public final String toString() {
        return ((Number) this.f5408a).intValue() + ".toShort()";
    }
}
