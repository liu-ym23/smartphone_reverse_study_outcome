package com.bytedance.android.livesdk.gift.platform.core.scope.service;

import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes9.dex */
public final class v0 implements u2, com.bytedance.android.scope.o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap<String, List<com.bytedance.android.livesdk.gift.model.n>> f131810a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashMap<String, List<com.bytedance.android.livesdk.gift.model.e3>> f131811b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final sc6.a f131812c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final jy0.a f131813d;

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
        this.f131810a.clear();
        this.f131811b.clear();
    }

    public v0(sc6.a r100, jy0.a r101) {
        Intrinsics.checkNotNullParameter(r100, "giftDetailRepository");
        Intrinsics.checkNotNullParameter(r101, "aLogService");
        this.f131812c = r100;
        this.f131813d = r101;
        this.f131810a = new HashMap();
        this.f131811b = new HashMap();
    }

    public final void a(ArrayList<com.bytedance.android.livesdk.gift.model.n> r110, long r111) {
        ArrayList r100 = new ArrayList();
        Iterator<com.bytedance.android.livesdk.gift.model.n> r112 = r110.iterator();
    L3:
        Object r101 = null;
        boolean r102 = false;
        if (r112.hasNext() == false) goto L58;
        com.bytedance.android.livesdk.gift.model.n r103 = r112.next();
        Intrinsics.checkNotNullParameter(r103, "$this$convertToString");
        JSONObject r104 = new JSONObject();
        r104.put("main_text", r103.getMainText());
        r104.put("sub_text", r103.getSubText());
        r104.put(com.bytedance.android.livesdk.gift.model.n.KEY_PLUGINS, gz1.c.a(gz1.c.g(r103), 1));
        r104.put("total_diamonds", r103.getTotalDiamonds());
        KProperty[] r105 = com.bytedance.android.livesdk.gift.model.o.f126396a;
        Intrinsics.checkNotNullParameter(r103, "$this$localIconBitmap");
        vh7.i r106 = com.bytedance.android.livesdk.gift.model.o.f126397b;
        KProperty[] r107 = com.bytedance.android.livesdk.gift.model.o.f126396a;
        KProperty r108 = r107[0];
        boolean r109 = r103 instanceof FlexModelBase;
        if (r109 == true) goto L8;
        Object r113 = null;
    L9:
        FlexModelBase r114 = (FlexModelBase) r113;
        if (r114 == null) goto L12;
        Object r115 = r114.get(r106.f554986a);
    L13:
        String r116 = (String) r115;
        String r117 = "";
        if (r116 != null) goto L16;
        r116 = "";
    L16:
        r104.put("image_url", r116);
        com.bytedance.android.livesdk.gift.model.j r118 = com.bytedance.android.livesdk.gift.model.o.b(r103);
        if (r118 == null) goto L19;
        JSONObject r119 = gz1.b.b(r118);
    L20:
        r104.put(sz1.a.KEY_GIFT_TOOLBAR_FRAME, r119);
        com.bytedance.android.livesdk.gift.model.j r120 = com.bytedance.android.livesdk.gift.model.o.a(r103);
        if (r120 == null) goto L23;
        JSONObject r121 = gz1.b.b(r120);
    L24:
        r104.put(sz1.a.KEY_GIFT_CELL_FRAME, r121);
        Intrinsics.checkNotNullParameter(r103, "$this$isRecommend");
        vh7.i r122 = com.bytedance.android.livesdk.gift.model.o.f126400e;
        KProperty r123 = r107[3];
        if (r109 == true) goto L27;
        Object r124 = null;
    L28:
        FlexModelBase r125 = (FlexModelBase) r124;
        if (r125 == null) goto L31;
        Object r126 = r125.get(r122.f554986a);
    L32:
        r104.put(sz1.a.KEY_IS_RECOMMEND, Intrinsics.areEqual((Boolean) r126, Boolean.TRUE) ? 1 : 0);
        String r127 = r103.getMainTextAfterSend();
        if (r127 == null) goto L36;
        r117 = r127;
    L36:
        r104.put("main_text_after_send", r117);
        Intrinsics.checkNotNullParameter(r103, "$this$isNewCard");
        vh7.i r128 = com.bytedance.android.livesdk.gift.model.o.f126401f;
        KProperty r129 = r107[4];
        if (r109 == true) goto L39;
        Object r130 = null;
    L40:
        FlexModelBase r131 = (FlexModelBase) r130;
        if (r131 == null) goto L43;
        Object r132 = r131.get(r128.f554986a);
    L44:
        Boolean r133 = (Boolean) r132;
        if (r133 == null) goto L47;
        boolean r134 = r133.booleanValue();
    L48:
        r104.put("is_new_card", r134);
        Intrinsics.checkNotNullParameter(r103, "$this$isLocal");
        vh7.i r135 = com.bytedance.android.livesdk.gift.model.o.f126402g;
        KProperty r136 = r107[5];
        Object r137 = r103;
        if (r109 == true) goto L51;
        r137 = null;
    L51:
        FlexModelBase r138 = (FlexModelBase) r137;
        if (r138 == null) goto L54;
        r101 = r138.get(r135.f554986a);
    L54:
        Boolean r139 = (Boolean) r101;
        if (r139 == null) goto L57;
        r102 = r139.booleanValue();
    L57:
        r104.put(BdpAppEventConstant.PARAMS_IS_LOCAL, r102);
        r100.add(r104.toString());
        goto L3
    L47:
        r134 = false;
        goto L48
    L43:
        r132 = null;
        goto L44
    L39:
        r130 = r103;
        goto L40
    L31:
        r126 = null;
        goto L32
    L27:
        r124 = r103;
        goto L28
    L23:
        r121 = new JSONObject();
        goto L24
    L19:
        r119 = new JSONObject();
        goto L20
    L12:
        r115 = null;
        goto L13
    L8:
        r113 = r103;
        goto L9
    L58:
        com.bytedance.tools.kcp.spongepreference.runtime.a r140 = cd6.a.f23396b;
        KProperty<?>[] r141 = cd6.a.f23395a;
        Map r142 = MapsKt.toMutableMap((Map) r140.getValue(null, r141[0]));
        r142.put(String.valueOf(r111), r100);
        Intrinsics.checkNotNullParameter(r142, "<set-?>");
        r140.setValue(null, r141[0], r142);
    }
}
