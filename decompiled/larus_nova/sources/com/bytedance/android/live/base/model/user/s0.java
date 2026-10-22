package com.bytedance.android.live.base.model.user;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes45.dex */
public final class s0 implements am3.c<ProfileText> {
    public static ProfileText a(am3.g r110) throws Exception {
        ProfileText r100 = new ProfileText();
        r100.pieces = new ArrayList();
        long r101 = r110.c();
    L3:
        int r102 = r110.f();
        int r103 = -1;
        if (r102 == (-1)) goto L68;
        if (r102 != 1) goto L7;
        List<ProfileTextPiece> r104 = r100.pieces;
        ProfileTextPiece r105 = new ProfileTextPiece();
        long r106 = r110.c();
    L9:
        int r111 = r110.f();
        if (r111 == r103) goto L67;
        if (r111 == 1) goto L64;
        int r112 = 2;
        if (r111 == 2) goto L63;
        if (r111 != 3) goto L16;
        ProfileTextPieceString r113 = new ProfileTextPieceString();
        long r114 = r110.c();
    L38:
        int r115 = r110.f();
        if (r115 == r103) goto L62;
        if (r115 != 1) goto L42;
        ProfileTextFormat r116 = new ProfileTextFormat();
        long r117 = r110.c();
        ProfileText r118 = r100;
    L46:
        int r107 = r110.f();
        if (r107 == r103) goto L61;
        if (r107 != 1) goto L50;
        r116.fontType = r110.i();
    L60:
        r103 = -1;
        goto L46
    L50:
        if (r107 != 2) goto L52;
        r116.fontSize = r110.i();
        goto L60
    L52:
        if (r107 != 3) goto L54;
        r116.fontStyle = r110.i();
        goto L60
    L54:
        if (r107 == 4) goto L56;
        am3.h.e(r110);
        goto L60
    L56:
        r116.fontColor = am3.h.c(r110);
        goto L60
    L61:
        r110.d(r117);
        r113.format = r116;
        r100 = r118;
        r103 = -1;
        goto L38
    L42:
        if (r115 != 2) goto L43;
        r113.value = am3.h.c(r110);
        goto L38
    L43:
        am3.h.e(r110);
        goto L38
    L62:
        r110.d(r114);
        r105.stringValue = r113;
    L66:
        r103 = -1;
        goto L9
    L16:
        if (r111 != 4) goto L17;
        ProfileTextPieceImage r119 = new ProfileTextPieceImage();
        long r120 = r110.c();
    L19:
        int r121 = r110.f();
        if (r121 == r103) goto L36;
        if (r121 == 1) goto L34;
        if (r121 != r112) goto L23;
        ProfileImageFormat r122 = new ProfileImageFormat();
        long r123 = r120;
        long r124 = r110.c();
    L25:
        int r125 = r110.f();
        if (r125 == r103) goto L33;
        if (r125 != 1) goto L29;
        r122.imageRadius = Float.intBitsToFloat(r110.g());
        goto L25
    L29:
        if (r125 != 2) goto L30;
        r122.isImageFillet = am3.h.a(r110);
        goto L25
    L30:
        am3.h.e(r110);
        goto L25
    L33:
        r110.d(r124);
        r119.imageFormat = r122;
        r120 = r123;
    L35:
        r112 = 2;
        goto L19
    L23:
        am3.h.e(r110);
        goto L19
    L34:
        r119.imageModel = (py.k) vh7.f.a(r110, py.k.class);
        goto L35
    L36:
        r110.d(r120);
        r105.imageValue = r119;
        goto L9
    L17:
        am3.h.e(r110);
        goto L9
    L63:
        r105.alignment = r110.i();
    L65:
        r100 = r100;
        goto L66
    L64:
        r105.type = r110.i();
        goto L65
    L67:
        r110.d(r106);
        r104.add(r105);
        r100 = r100;
        goto L3
    L7:
        am3.h.e(r110);
        goto L3
    L68:
        ProfileText r126 = r100;
        r110.d(r101);
        return r126;
    }
}
