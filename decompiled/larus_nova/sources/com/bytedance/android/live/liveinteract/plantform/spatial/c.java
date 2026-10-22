package com.bytedance.android.live.liveinteract.plantform.spatial;

import com.bytedance.android.livesdk.model.y0;
import java.util.HashMap;

/* JADX INFO: loaded from: classes46.dex */
public final class c implements a {
    public c() {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.spatial.a
    public final y0 a() {
        return com.bytedance.android.live.liveinteract.spatial.a.b(2);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.spatial.a
    public final aj6.b b() {
        return com.bytedance.android.live.liveinteract.spatial.a.a(2);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.spatial.a
    public final String c() {
        return "video_dynamic_equal_window_spatial_enable";
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.spatial.a
    public final y0 d(int r100, int r101) {
        HashMap r102 = (HashMap) com.bytedance.android.live.liveinteract.spatial.a.c(2);
        if (r102 == null) goto L7;
        HashMap r103 = (HashMap) r102.get(Integer.valueOf(r101));
        if (r103 == null) goto L7;
        y0 r104 = (y0) r103.get(Integer.valueOf(r100));
    L8:
        if (r104 == null) goto L10;
        return r104;
    L10:
        int r105 = vm2.d.W0();
        switch(r101) {
            case 1: goto L84;
            case 2: goto L84;
            case 3: goto L77;
            case 4: goto L68;
            case 5: goto L57;
            case 6: goto L43;
            case 7: goto L34;
            case 8: goto L24;
            case 9: goto L13;
            default: goto L90;
        };
    L13:
        switch(r100) {
            case 0: goto L100;
            case 1: goto L99;
            case 2: goto L98;
            case 3: goto L97;
            case 4: goto L96;
            case 5: goto L95;
            case 6: goto L17;
            case 7: goto L93;
            case 8: goto L92;
            default: goto L91;
        };
    L17:
        int r106 = 0 - r105;
        return new y0(r106, r106, 0);
    L91:
        return new y0(0, 0, 0);
    L92:
        return new y0(0 - r105, r105, 0);
    L93:
        return new y0(0 - r105, 0, 0);
    L95:
        return new y0(0, r105, 0);
    L96:
        return new y0(0, 0, 0);
    L97:
        return new y0(0, 0 - r105, 0);
    L98:
        return new y0(r105, r105, 0);
    L99:
        return new y0(r105, 0, 0);
    L100:
        return new y0(r105, 0 - r105, 0);
    L24:
        switch(r100) {
            case 0: goto L109;
            case 1: goto L108;
            case 2: goto L107;
            case 3: goto L106;
            case 4: goto L105;
            case 5: goto L104;
            case 6: goto L27;
            case 7: goto L102;
            default: goto L101;
        };
    L27:
        int r107 = 0 - r105;
        return new y0(r107, r107, 0);
    L101:
        return new y0(0, 0, 0);
    L102:
        return new y0(0 - r105, r105, 0);
    L104:
        return new y0(0, r105, 0);
    L105:
        return new y0(0, 0, 0);
    L106:
        return new y0(0, 0 - r105, 0);
    L107:
        return new y0(r105, r105, 0);
    L108:
        return new y0(r105, 0, 0);
    L109:
        return new y0(r105, 0 - r105, 0);
    L34:
        switch(r100) {
            case 0: goto L117;
            case 1: goto L116;
            case 2: goto L115;
            case 3: goto L114;
            case 4: goto L113;
            case 5: goto L112;
            case 6: goto L111;
            default: goto L110;
        };
    L110:
        return new y0(0, 0, 0);
    L111:
        return new y0(0 - r105, 0, 0);
    L112:
        return new y0(0, r105, 0);
    L113:
        return new y0(0, 0, 0);
    L114:
        return new y0(0, 0 - r105, 0);
    L115:
        return new y0(r105, r105, 0);
    L116:
        return new y0(r105, 0, 0);
    L117:
        return new y0(r105, 0 - r105, 0);
    L43:
        if (r100 == 0) goto L124;
        if (r100 == 1) goto L123;
        if (r100 == 2) goto L122;
        if (r100 == 3) goto L53;
        if (r100 == 4) goto L120;
        if (r100 == 5) goto L119;
        return new y0(0, 0, 0);
    L119:
        return new y0(0 - r105, r105, 0);
    L120:
        return new y0(0 - r105, 0, 0);
    L53:
        int r108 = 0 - r105;
        return new y0(r108, r108, 0);
    L122:
        return new y0(r105, r105, 0);
    L123:
        return new y0(r105, 0, 0);
    L124:
        return new y0(r105, 0 - r105, 0);
    L57:
        if (r100 == 0) goto L130;
        if (r100 == 1) goto L129;
        if (r100 == 2) goto L128;
        if (r100 == 3) goto L64;
        if (r100 == 4) goto L126;
        return new y0(0, 0, 0);
    L126:
        return new y0(0 - r105, r105, 0);
    L64:
        int r109 = 0 - r105;
        return new y0(r109, r109, 0);
    L128:
        return new y0(r105, r105, 0);
    L129:
        return new y0(r105, 0, 0);
    L130:
        return new y0(r105, 0 - r105, 0);
    L68:
        if (r100 == 0) goto L135;
        if (r100 == 1) goto L134;
        if (r100 == 2) goto L74;
        if (r100 == 3) goto L132;
        return new y0(0, 0, 0);
    L132:
        return new y0(0 - r105, r105, 0);
    L74:
        int r110 = 0 - r105;
        return new y0(r110, r110, 0);
    L134:
        return new y0(r105, r105, 0);
    L135:
        return new y0(r105, 0 - r105, 0);
    L77:
        if (r100 == 0) goto L139;
        if (r100 == 1) goto L138;
        if (r100 == 2) goto L137;
        return new y0(0, r105, 0);
    L137:
        return new y0(0 - r105, r105, 0);
    L138:
        return new y0(r105, r105, 0);
    L139:
        return new y0(0, 0 - r105, 0);
    L84:
        if (r100 == 0) goto L89;
        if (r100 == 1) goto L141;
        return new y0(0, 0, 0);
    L141:
        return new y0(0, r105, 0);
    L89:
        return new y0(0, 0 - r105, 0);
    L90:
        return new y0(0, 0, 0);
    L7:
        r104 = null;
        goto L8
    }
}
