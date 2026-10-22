package com.bytedance.android.livesdkapi.message;

import am3.c;
import am3.g;
import am3.h;

/* JADX INFO: loaded from: classes12.dex */
public final class _TextFormat_ProtoDecoder implements c<TextFormat> {
    public _TextFormat_ProtoDecoder() {
    }

    public static TextFormat decodeStatic(g r100) throws Exception {
        TextFormat r101 = new TextFormat();
        r101.setThreadSafe(false);
        long r102 = r100.c();
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L15;
        g.a r104 = r101.decodeExtensionFields(r103, r100);
        switch(r103) {
            case 1: goto L14;
            case 2: goto L7;
            case 3: goto L13;
            case 4: goto L12;
            case 5: goto L7;
            case 6: goto L11;
            case 7: goto L10;
            case 8: goto L9;
            case 9: goto L8;
            default: goto L7;
        };
    L8:
        r101.ignoreColorMapping = h.a(r100);
        goto L3
    L9:
        r101.useRemoteColor = h.a(r100);
        goto L3
    L10:
        r101.useHeighLight = h.a(r100);
        goto L3
    L11:
        r101.fontSize = r100.i();
        goto L3
    L12:
        r101.weight = r100.i();
        goto L3
    L13:
        r101.italic = h.a(r100);
        goto L3
    L14:
        r101.color = h.c(r100);
        goto L3
    L7:
        h.d(r104, r100);
        goto L3
    L15:
        r100.d(r102);
        r101.setThreadSafe(true);
        return r101;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // am3.c
    public final TextFormat decode(g r100) throws Exception {
        return decodeStatic(r100);
    }

    @Override // am3.c
    public /* bridge */ /* synthetic */ TextFormat decode(g r100) throws Exception {
        return decode(r100);
    }
}
