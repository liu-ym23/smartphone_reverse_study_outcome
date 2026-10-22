package c32;

import am3.h;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes9.dex */
public final class f implements am3.c<c> {
    public f() {
    }

    @Override // am3.c
    public final c decode(am3.g r100) throws Exception {
        c r101 = new c();
        r101.results = new ArrayList();
        long r102 = r100.c();
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L15;
        if (r103 != 1) goto L8;
        r101.results.add(g.a(r100));
        goto L3
    L8:
        if (r103 != 2) goto L10;
        r101.associationId = r100.j();
        goto L3
    L10:
        if (r103 != 3) goto L11;
        r101.associationIdStr = h.c(r100);
        goto L3
    L11:
        h.e(r100);
        goto L3
    L15:
        r100.d(r102);
        return r101;
    }
}
