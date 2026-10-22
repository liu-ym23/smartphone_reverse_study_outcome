package com.bytedance.android.livesdkapi.message;

import am3.c;
import am3.g;
import am3.h;
import com.bytedance.android.live.base.model.message.b5;
import com.bytedance.android.live.base.model.message.m6;
import java.util.ArrayList;
import java.util.HashMap;
import vh7.f;

/* JADX INFO: loaded from: classes12.dex */
public final class _Text_ProtoDecoder implements c<Text> {
    public _Text_ProtoDecoder() {
    }

    public static Text decodeStatic(g r110) throws Exception {
        Text r100 = new Text();
        r100.setThreadSafe(false);
        r100.pieces = new ArrayList();
        r100.schemaInfos = new HashMap();
        long r101 = r110.c();
    L3:
        int r102 = r110.f();
        if (r102 == (-1)) goto L36;
        g.a r103 = r100.decodeExtensionFields(r102, r110);
        if (r102 != 1) goto L8;
        r100.key = h.c(r110);
        goto L3
    L8:
        if (r102 != 2) goto L10;
        r100.defaultPattern = h.c(r110);
        goto L3
    L10:
        if (r102 != 3) goto L12;
        r100.defaultFormat = (b5) f.a(r110, b5.class);
        goto L3
    L12:
        if (r102 != 4) goto L14;
        r100.pieces.add((TextPiece) f.a(r110, TextPiece.class));
        goto L3
    L14:
        if (r102 != 20) goto L15;
        long r104 = r110.c();
        String r105 = null;
        m6 r106 = null;
    L17:
        int r111 = r110.f();
        if (r111 == (-1)) goto L24;
        if (r111 != 1) goto L20;
        r105 = h.c(r110);
        goto L17
    L20:
        if (r111 != 2) goto L17;
        r106 = new m6(r110);
        goto L17
    L24:
        r110.d(r104);
        if (r105 == null) goto L31;
        if (r106 == null) goto L29;
        r100.schemaInfos.put(r105, r106);
        goto L3
    L29:
        throw new IllegalStateException("Map value must not be null!");
    L31:
        throw new IllegalStateException("Map key must not be null!");
    L15:
        h.d(r103, r110);
        goto L3
    L36:
        r110.d(r101);
        r100.setThreadSafe(true);
        return r100;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // am3.c
    public final Text decode(g r100) throws Exception {
        return decodeStatic(r100);
    }

    @Override // am3.c
    public /* bridge */ /* synthetic */ Text decode(g r100) throws Exception {
        return decode(r100);
    }
}
