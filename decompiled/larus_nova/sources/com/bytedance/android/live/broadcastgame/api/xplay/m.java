package com.bytedance.android.live.broadcastgame.api.xplay;

import com.bytedance.android.live.broadcastgame.api.model.q0;
import com.bytedance.android.live.broadcastgame.api.model.u;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class m {
    public static final l a(u r110) {
        Intrinsics.checkNotNullParameter(r110, "$this$toXplayGameItem");
        int r100 = r110.interactId;
        com.bytedance.android.live.broadcastgame.api.model.r r101 = r110.c();
        if (r101 == null) goto L8;
        String r102 = r101.b();
        if (r102 == null) goto L8;
        String r103 = r102;
    L9:
        String r104 = r110.name;
        com.bytedance.android.live.broadcastgame.api.model.r r105 = r110.c();
        if (r105 == null) goto L12;
        long r106 = r105.p();
    L13:
        String r107 = (String) CollectionsKt.firstOrNull(r110.iconUrl);
        if (r107 != null) goto L16;
        String r108 = "";
    L17:
        com.bytedance.android.live.broadcastgame.api.model.r r109 = r110.c();
        if (r109 == null) goto L22;
        com.bytedance.android.live.broadcastgame.api.model.g r111 = r109.n();
        if (r111 == null) goto L22;
        q0 r112 = r111.b();
    L23:
        q0 r113 = r112;
        com.bytedance.android.live.broadcastgame.api.model.r r114 = r110.c();
        if (r114 == null) goto L29;
        String r115 = r114.C();
        if (r115 == null) goto L29;
        String r116 = r115;
    L30:
        com.bytedance.android.live.broadcastgame.api.model.r r117 = r110.c();
        if (r117 == null) goto L33;
        int r118 = r117.g();
    L34:
        com.bytedance.android.live.broadcastgame.api.model.r r119 = r110.c();
        if (r119 == null) goto L40;
        String r120 = r119.c();
        if (r120 == null) goto L40;
        String r121 = r120;
    L41:
        com.bytedance.android.live.broadcastgame.api.model.r r122 = r110.c();
        if (r122 == null) goto L49;
        com.bytedance.android.live.broadcastgame.api.model.g r123 = r122.n();
        if (r123 == null) goto L49;
        String r124 = r123.a();
        if (r124 == null) goto L49;
        String r125 = r124;
    L50:
        com.bytedance.android.live.broadcastgame.api.model.r r126 = r110.c();
        if (r126 == null) goto L55;
        com.bytedance.android.live.broadcastgame.api.model.g r127 = r126.n();
        if (r127 == null) goto L55;
        boolean r128 = r127.c();
    L56:
        com.bytedance.android.live.broadcastgame.api.model.r r129 = r110.c();
        if (r129 == null) goto L62;
        String r130 = r129.j();
        if (r130 == null) goto L62;
        String r131 = r130;
    L63:
        com.bytedance.android.live.broadcastgame.api.model.r r132 = r110.c();
        if (r132 == null) goto L67;
        List<Integer> r133 = r132.H();
        if (r133 == null) goto L67;
    L68:
        List<Integer> r134 = r133;
        com.bytedance.android.live.broadcastgame.api.model.r r135 = r110.c();
        if (r135 == null) goto L72;
        String r136 = r135.A();
        if (r136 == null) goto L72;
    L74:
        return new l(r100, r103, r104, r106, r108, r116, r118, r131, r121, r125, r128, r113, r134, r136);
    L72:
        r136 = "";
    L67:
        r133 = CollectionsKt.emptyList();
    L62:
        r131 = "";
    L55:
        r128 = false;
    L49:
        r125 = "";
    L40:
        r121 = "";
        goto L41
    L33:
        r118 = 0;
    L29:
        r116 = "";
    L22:
        r112 = null;
        goto L23
    L16:
        r108 = r107;
        goto L17
    L12:
        r106 = 0;
    L8:
        r103 = "";
        goto L9
    }
}
