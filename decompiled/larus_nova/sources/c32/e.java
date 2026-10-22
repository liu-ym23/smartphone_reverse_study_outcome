package c32;

import am3.h;

/* JADX INFO: loaded from: classes9.dex */
public final class e implements am3.c<b> {
    public e() {
    }

    @Override // am3.c
    public final b decode(am3.g r100) throws Exception {
        b r101 = new b();
        long r102 = r100.c();
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L15;
        if (r103 != 1) goto L8;
        r101.roomId = r100.j();
        goto L3
    L8:
        if (r103 != 2) goto L10;
        r101.contentEncode = h.c(r100);
        goto L3
    L10:
        if (r103 != 3) goto L11;
        r101.spellingContentEncode = h.c(r100);
        goto L3
    L11:
        h.e(r100);
        goto L3
    L15:
        r100.d(r102);
        return r101;
    }
}
