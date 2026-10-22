package com.bytedance.android.shopping.mall.homepage.card.headercard.util;

import com.bytedance.android.shopping.api.mall.common.homepage.card.headercard.model.Bcm;
import com.bytedance.android.shopping.api.mall.common.homepage.card.headercard.model.BtmData;
import com.bytedance.android.shopping.api.mall.common.tools.b0;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes13.dex */
public final class b {
    public static final String b(int r110, String r111, String r112) {
        Intrinsics.checkNotNullParameter(r111, "componentId");
        boolean r100 = false;
        if (r112 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        String r102 = "c9627.d153041";
        if (r101 == true) goto L31;
        List r103 = StringsKt.split$default(r112, new String[]{"."}, false, 0, 6, null);
        String r104 = (String) CollectionsKt.firstOrNull(r103);
        String r105 = (String) CollectionsKt.getOrNull(r103, 1);
        if (r104 != null) goto L15;
    L18:
        boolean r106 = true;
    L19:
        if (r106 == true) goto L25;
        if (r105 != null) goto L22;
    L23:
        r100 = true;
    L24:
        if (r100 == true) goto L25;
    L27:
        if ((!Intrinsics.areEqual(r104, "c9627")) == false) goto L29;
        r102 = "c9627." + r105;
        goto L31
    L29:
        r102 = r112;
        goto L31
    L22:
        if (r105.length() != 0) goto L24;
    L25:
        r112 = "c9627.d153041";
        goto L27
    L15:
        if (r104.length() == 0) goto L18;
        r106 = false;
    L31:
        return r102 + "_i" + r110 + "_w" + r111;
    L5:
        if (r112.length() == 0) goto L8;
        r101 = false;
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r21v2, types: [java.util.Map] */
    /* JADX WARN: Type inference failed for: r22v3, types: [com.bytedance.android.shopping.api.mall.common.homepage.card.headercard.model.Bcm] */
    public static BtmPositionResult a(BtmData r110, boolean r210, int r211, int r212, String r213, int r214) {
        boolean r100 = false;
        if ((r214 & 1) == 0) goto L5;
        boolean r101 = false;
    L7:
        if ((r214 & 2) == 0) goto L9;
        int r102 = 0;
    L11:
        if ((r214 & 4) == 0) goto L13;
        int r103 = 0;
    L15:
        if ((r214 & 8) == 0) goto L17;
        String r104 = "0";
    L18:
        Intrinsics.checkNotNullParameter(r104, "componentID");
        Intrinsics.checkNotNullParameter(r104, "componentID");
        Object r105 = null;
        if (r110 != null) goto L164;
        List<String> r111 = null;
    L24:
        List<String> r112 = r111;     // Catch: Exception -> L21
        if (r112 != null) goto L27;
    L30:
        boolean r113 = true;
    L32:
        if (r113 == true) goto L67;
        List<String> r114 = r110.getBtmCodeList();     // Catch: Exception -> L21
        if (r114 == null) goto L36;
        String r115 = (String) CollectionsKt.getOrNull(r114, 0);     // Catch: Exception -> L21
    L37:
        if (r115 == null) goto L39;
        List r116 = StringsKt.split$default(r115, new String[]{"."}, false, 0, 6, null);     // Catch: Exception -> L21
    L40:
        if (r116 == null) goto L42;
        String r117 = (String) CollectionsKt.firstOrNull(r116);     // Catch: Exception -> L21
    L43:
        if (r116 == null) goto L49;
        String r118 = (String) CollectionsKt.lastOrNull(r116);     // Catch: Exception -> L21
        if (r118 == null) goto L49;
        List r119 = StringsKt.split$default(r118, new String[]{"_"}, false, 0, 6, null);     // Catch: Exception -> L21
        if (r119 == null) goto L49;
        String r120 = (String) CollectionsKt.firstOrNull(r119);     // Catch: Exception -> L21
    L50:
        String r106 = "w" + r104;     // Catch: Exception -> L21
        if (r117 != null) goto L53;
    L56:
        boolean r121 = true;
    L57:
        if (r121 == true) goto L114;
        if (r120 != null) goto L60;
    L63:
        boolean r122 = true;
    L64:
        if (r122 == true) goto L114;
        BtmInfo r123 = new BtmInfo(r117, r120, r106, r110);     // Catch: Exception -> L21
    L115:
        if (r123 != null) goto L118;
        return null;
    L118:
        if (r101 == false) goto L124;
        String r107 = r123.getC() + '.' + r123.getD();
        BtmData r108 = r123.getBtmInfo();
        if (r108 == null) goto L122;
        r105 = r108.getBcm();
    L122:
        BtmPositionResult r109 = new BtmPositionResult(r107, null, r105, 2, null);
    L165:
        return r109;
    L124:
        String r124 = r123.getC();
        if (r124 != null) goto L127;
    L130:
        boolean r125 = true;
    L131:
        if (r125 == true) goto L166;
        String r126 = r123.getD();
        if (r126 != null) goto L135;
    L138:
        boolean r127 = true;
    L139:
        if (r127 == true) goto L167;
        String r128 = r123.getW();
        if (r128 != null) goto L143;
    L144:
        r100 = true;
    L145:
        if (r100 == false) goto L147;
        return null;
    L147:
        if (r123.getBtmInfo() != null) goto L149;
        return null;
    L149:
        if (Intrinsics.areEqual(r104, "0") == true) goto L171;
        if (r102 < 0) goto L163;
        StringBuilder r129 = new StringBuilder();
        r129.append(r123.getC());
        r129.append('.');
        r129.append(r123.getD());
        r129.append("_i");
        r129.append(r102);
        if (r103 < 0) goto L155;
        String r130 = "_i" + r103;
    L156:
        r129.append(r130);
        r129.append('_');
        r129.append(r123.getW());
        String r131 = r129.toString();
        BtmData r132 = r123.getBtmInfo();
        if (r132 == null) goto L161;
        Bcm r133 = r132.getBcm();
        if (r133 == null) goto L161;
        r105 = r133.getExtra();
    L161:
        r109 = new BtmPositionResult(r131, r105, null, 4, null);
        goto L165
    L155:
        r130 = "";
        goto L156
    L163:
        return new BtmPositionResult(r123.getC() + '.' + r123.getD(), null, null, 6, null);
    L171:
        return null;
    L143:
        if (r128.length() != 0) goto L145;
    L167:
        return null;
    L135:
        if (r126.length() == 0) goto L138;
        r127 = false;
        goto L139
    L166:
        return null;
    L127:
        if (r124.length() == 0) goto L130;
        r125 = false;
        goto L131
    L60:
        if (r120.length() == 0) goto L63;
        r122 = false;
    L114:
        r123 = null;
        goto L115
    L53:
        if (r117.length() == 0) goto L56;
        r121 = false;
    L49:
        r120 = null;
        goto L50
    L42:
        r117 = null;
        goto L43
    L39:
        r116 = null;
        goto L40
    L36:
        r115 = null;
        goto L37
    L67:
        if (r110 == null) goto L69;
        String r134 = r110.getBtm();     // Catch: Exception -> L21
    L70:
        if (r134 == null) goto L114;
        String r135 = r110.getBtm();     // Catch: Exception -> L21
        if (r135 == null) goto L74;
        List r136 = StringsKt.split$default(r135, new String[]{"."}, false, 0, 6, null);     // Catch: Exception -> L21
    L75:
        if (r136 == null) goto L77;
        String r137 = (String) CollectionsKt.firstOrNull(r136);     // Catch: Exception -> L21
    L78:
        if (r136 == null) goto L82;
        String r138 = (String) CollectionsKt.lastOrNull(r136);     // Catch: Exception -> L21
        if (r138 == null) goto L82;
        List r139 = StringsKt.split$default(r138, new String[]{"_"}, false, 0, 6, null);     // Catch: Exception -> L21
    L83:
        if (r139 == null) goto L85;
        String r140 = (String) CollectionsKt.firstOrNull(r139);     // Catch: Exception -> L21
    L86:
        if (r139 == null) goto L88;
        String r141 = (String) CollectionsKt.lastOrNull(r139);     // Catch: Exception -> L21
    L89:
        if (r137 != null) goto L91;
    L94:
        boolean r142 = true;
    L95:
        if (r142 == true) goto L114;
        if (r140 != null) goto L98;
    L101:
        boolean r143 = true;
    L102:
        if (r143 == true) goto L114;
        if (r141 != null) goto L105;
    L108:
        boolean r144 = true;
    L109:
        if (r144 == true) goto L114;
        r123 = new BtmInfo(r137, r140, r141, r110);     // Catch: Exception -> L21
        goto L115
    L105:
        if (r141.length() == 0) goto L108;
        r144 = false;
        goto L109
    L98:
        if (r140.length() == 0) goto L101;
        r143 = false;
        goto L102
    L91:
        if (r137.length() == 0) goto L94;
        r142 = false;
        goto L95
    L88:
        r141 = null;
        goto L89
    L85:
        r140 = null;
    L82:
        r139 = null;
        goto L83
    L77:
        r137 = null;
        goto L78
    L74:
        r136 = null;
        goto L75
    L69:
        r134 = null;
        goto L70
    L27:
        if (r112.isEmpty() == true) goto L30;
        r113 = false;
        goto L32
    L164:
        r111 = r110.getBtmCodeList();     // Catch: Exception -> L21
    L21:
        e = move-exception;
        b0.l("getBtm", e);
        goto L114
    L17:
        r104 = r213;
        goto L18
    L13:
        r103 = r212;
        goto L15
    L9:
        r102 = r211;
        goto L11
    L5:
        r101 = r210;
        goto L7
    }
}
