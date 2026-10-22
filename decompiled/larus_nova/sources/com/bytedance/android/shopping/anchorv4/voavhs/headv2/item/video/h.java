package com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.video;

import com.bytedance.android.ec.host.api.player.HeaderCtrLynxPendant;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.HeaderPendantLynx;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.n;
import com.google.gson.JsonObject;

/* JADX INFO: loaded from: classes13.dex */
public final class h {
    public static final fj.f a(n r100) {
        JsonObject r101 = null;
        if (r100 != null) goto L5;
        return null;
    L5:
        HeaderPendantLynx r102 = r100.b();
        if (r102 == null) goto L8;
        String r103 = r102.getLynxId();
    L9:
        String r104 = "";
        if (r103 != null) goto L12;
        r103 = "";
    L12:
        HeaderPendantLynx r105 = r100.b();
        if (r105 == null) goto L15;
        String r106 = r105.getLynxUrl();
    L16:
        if (r106 != null) goto L18;
        r106 = "";
    L18:
        HeaderPendantLynx r107 = r100.b();
        if (r107 == null) goto L21;
        JsonObject r108 = r107.getLynxData();
    L22:
        HeaderCtrLynxPendant r109 = new HeaderCtrLynxPendant(r103, r106, r108);
        HeaderPendantLynx r110 = r100.a();
        if (r110 == null) goto L25;
        String r111 = r110.getLynxId();
    L26:
        if (r111 != null) goto L28;
        r111 = "";
    L28:
        HeaderPendantLynx r112 = r100.a();
        if (r112 == null) goto L31;
        String r113 = r112.getLynxUrl();
    L32:
        if (r113 == null) goto L35;
        r104 = r113;
    L35:
        HeaderPendantLynx r114 = r100.a();
        if (r114 == null) goto L39;
        r101 = r114.getLynxData();
    L39:
        return new fj.f(r109, new HeaderCtrLynxPendant(r111, r104, r101));
    L31:
        r113 = null;
        goto L32
    L25:
        r111 = null;
        goto L26
    L21:
        r108 = null;
        goto L22
    L15:
        r106 = null;
        goto L16
    L8:
        r103 = null;
        goto L9
    }
}
