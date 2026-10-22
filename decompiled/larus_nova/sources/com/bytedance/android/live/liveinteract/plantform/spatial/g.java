package com.bytedance.android.live.liveinteract.plantform.spatial;

import com.bytedance.android.livesdk.model.y0;
import java.util.HashMap;

/* JADX INFO: loaded from: classes46.dex */
public final class g implements a {
    public g() {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.spatial.a
    public final y0 a() {
        return com.bytedance.android.live.liveinteract.spatial.a.b(1);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.spatial.a
    public final aj6.b b() {
        return com.bytedance.android.live.liveinteract.spatial.a.a(1);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.spatial.a
    public final String c() {
        return "video_float_1v6_window_spatial_enable";
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.spatial.a
    public final y0 d(int r100, int r101) {
        HashMap r102 = (HashMap) com.bytedance.android.live.liveinteract.spatial.a.c(1);
        if (r102 == null) goto L5;
        y0 r103 = (y0) r102.get(Integer.valueOf(r100));
    L6:
        if (r103 == null) goto L8;
        return r103;
    L8:
        int r104 = vm2.d.W0();
        switch(r100) {
            case 0: goto L18;
            case 1: goto L25;
            case 2: goto L24;
            case 3: goto L23;
            case 4: goto L22;
            case 5: goto L21;
            case 6: goto L20;
            default: goto L19;
        };
    L19:
        return new y0(0, 0, 0);
    L20:
        return new y0(0 - (r104 * 3), r104, 0);
    L21:
        return new y0(0 - (r104 * 2), r104, 0);
    L22:
        return new y0(0 - r104, r104, 0);
    L23:
        return new y0(r104, r104, 0);
    L24:
        return new y0(r104 * 2, r104, 0);
    L25:
        return new y0(r104 * 3, r104, 0);
    L18:
        return new y0(0, 0 - r104, 0);
    L5:
        r103 = null;
        goto L6
    }
}
