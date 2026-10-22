package b9a;

import java.util.Enumeration;

/* JADX INFO: loaded from: classes4.dex */
public final class k implements a9a.b {
    public k() {
    }

    @Override // a9a.b
    public final boolean b(z8a.a r100) {
        Enumeration r101 = x8a.c.b().f562943a.elements();
        if (r101 != null) goto L5;
    L11:
        return false;
    L5:
        if (r101.hasMoreElements() == false) goto L11;
        e9a.a r102 = (e9a.a) r101.nextElement();
        if (r102 == null) goto L5;
        if (r102.a() == false) goto L5;
        g9a.a.c(new i9a.b(r100.f570967c, null));
        return true;
    }
}
