package com.bytedance.android.livesdkapi.depend.model.live;

import am3.c;
import am3.g;
import am3.h;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: loaded from: classes12.dex */
public final class _LinkerDetail_ProtoDecoder implements c<LinkerDetail> {
    public _LinkerDetail_ProtoDecoder() {
    }

    public static LinkerDetail decodeStatic(g r110) throws Exception {
        LinkerDetail r100 = new LinkerDetail();
        r100.setThreadSafe(false);
        r100.playModes = new ArrayList();
        r100.featureList = new ArrayList();
        r100.playModeDetail = new HashMap();
        long r101 = r110.c();
    L3:
        int r102 = r110.f();
        if (r102 == (-1)) goto L39;
        g.a r103 = r100.decodeExtensionFields(r102, r110);
        switch(r102) {
            case 1: goto L38;
            case 2: goto L37;
            case 3: goto L36;
            case 4: goto L35;
            case 5: goto L34;
            case 6: goto L33;
            case 7: goto L7;
            case 8: goto L32;
            case 9: goto L31;
            case 10: goto L30;
            case 11: goto L29;
            case 12: goto L28;
            case 13: goto L11;
            case 14: goto L10;
            case 15: goto L9;
            case 16: goto L8;
            default: goto L7;
        };
    L8:
        r100.featureList.add(Long.valueOf(r110.j()));
        goto L3
    L9:
        r100.anchorManualOpenUiLayout = (int) r110.j();
        goto L3
    L10:
        r100.clientUiInfo = h.c(r110);
        goto L3
    L11:
        long r104 = r110.c();
        String r105 = null;
        String r106 = null;
    L12:
        int r107 = r110.f();
        if (r107 == (-1)) goto L20;
        if (r107 != 1) goto L16;
        r105 = h.c(r110);
        goto L12
    L16:
        if (r107 != 2) goto L12;
        r106 = h.c(r110);
        goto L12
    L20:
        r110.d(r104);
        if (r105 == null) goto L27;
        if (r106 == null) goto L25;
        r100.playModeDetail.put(r105, r106);
        goto L3
    L25:
        throw new IllegalStateException("Map value must not be null!");
    L27:
        throw new IllegalStateException("Map key must not be null!");
    L28:
        r100.enlargeGuestTurnOnSource = r110.j();
        goto L3
    L29:
        r100.ktvExhibitMode = r110.i();
        goto L3
    L30:
        r100.forbidApplyFromOther = h.a(r110);
        goto L3
    L31:
        r100.initSource = h.c(r110);
        goto L3
    L32:
        r100.ktvLyricMode = h.c(r110);
        goto L3
    L33:
        r100.functionType2 = h.c(r110);
        goto L3
    L34:
        r100.integrationAnchorEnableAudienceLinkmic = r110.i();
        goto L3
    L35:
        r100.uiLayout = (int) r110.j();
        goto L3
    L36:
        r100.anchorAcceptAudiencePreApply = h.a(r110);
        goto L3
    L37:
        r100.layoutConfigVersion = r110.i();
        goto L3
    L38:
        r100.playModes.add(Long.valueOf(r110.j()));
        goto L3
    L7:
        h.d(r103, r110);
        goto L3
    L39:
        r110.d(r101);
        r100.setThreadSafe(true);
        return r100;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // am3.c
    public final LinkerDetail decode(g r100) throws Exception {
        return decodeStatic(r100);
    }

    @Override // am3.c
    public /* bridge */ /* synthetic */ LinkerDetail decode(g r100) throws Exception {
        return decode(r100);
    }
}
