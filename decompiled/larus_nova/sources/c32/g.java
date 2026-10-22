package c32;

import am3.h;
import com.bytedance.android.live.base.model.message.a5;
import java.util.HashMap;

/* JADX INFO: loaded from: classes9.dex */
public final class g implements am3.c<d> {
    public g() {
    }

    public static d a(am3.g r110) throws Exception {
        d r100 = new d();
        r100.extraMap = new HashMap();
        r100.trackMap = new HashMap();
        long r101 = r110.c();
    L3:
        int r102 = r110.f();
        if (r102 == (-1)) goto L51;
        if (r102 != 1) goto L8;
        r100.actionType = r110.i();
        goto L3
    L8:
        if (r102 != 2) goto L10;
        r100.associationDisplayText = (a5) vh7.f.a(r110, a5.class);
        goto L3
    L10:
        if (r102 != 3) goto L11;
        r100.schemaUrl = h.c(r110);
        goto L3
    L11:
        String r111 = null;
        if (r102 != 4) goto L14;
        long r112 = r110.c();
        String r103 = null;
    L33:
        int r104 = r110.f();
        if (r104 == (-1)) goto L40;
        if (r104 != 1) goto L36;
        r111 = h.c(r110);
        goto L33
    L36:
        if (r104 != 2) goto L33;
        r103 = h.c(r110);
        goto L33
    L40:
        r110.d(r112);
        if (r111 == null) goto L47;
        if (r103 == null) goto L45;
        r100.trackMap.put(r111, r103);
        goto L3
    L45:
        throw new IllegalStateException("Map value must not be null!");
    L47:
        throw new IllegalStateException("Map key must not be null!");
    L14:
        if (r102 != 100) goto L15;
        long r113 = r110.c();
        String r105 = null;
    L17:
        int r106 = r110.f();
        if (r106 == (-1)) goto L24;
        if (r106 != 1) goto L20;
        r111 = h.c(r110);
        goto L17
    L20:
        if (r106 != 2) goto L17;
        r105 = h.c(r110);
        goto L17
    L24:
        r110.d(r113);
        if (r111 == null) goto L31;
        if (r105 == null) goto L29;
        r100.extraMap.put(r111, r105);
        goto L3
    L29:
        throw new IllegalStateException("Map value must not be null!");
    L31:
        throw new IllegalStateException("Map key must not be null!");
    L15:
        h.e(r110);
        goto L3
    L51:
        r110.d(r101);
        return r100;
    }

    @Override // am3.c
    public final d decode(am3.g r100) throws Exception {
        return a(r100);
    }
}
