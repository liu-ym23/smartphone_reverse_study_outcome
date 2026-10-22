package com.bytedance.android.live.liveinteract.plantform.dynamicframe;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.plantform.dynamicframe.model.AnimUpdateType;
import com.bytedance.android.live.liveinteract.utils.MultiSceneEnterRoomStatisticsUtils;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.larus.nova.R;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public class e implements kh0.a.InterfaceC6552a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final JsonObject f76906a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, h> f76907b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public kh0.h f76908c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Context f76909d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ih0.b f76910e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ViewGroup f76911f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f76912g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final IRoom f76913h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f76914i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f76915j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final DataCenter f76916k;

    public static final class a {
    }

    static {
    }

    @Override // kh0.a.InterfaceC6552a
    public final boolean a() {
        JsonElement r100 = this.f76906a.get("is_biz_showing");
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.getAsBoolean() != true) goto L7;
        return true;
    }

    public FrameLayout c() {
        View r100 = this.f76911f.findViewById(R.id.talkroom_root_container);
        if (r100 != null) goto L7;
        return null;
    L7:
        return (FrameLayout) r100.findViewById(R.id.dynamic_layers_background);
    }

    public FrameLayout d() {
        return (FrameLayout) this.f76911f.findViewById(R.id.talkroom_root_container).findViewById(R.id.dynamic_layers_front);
    }

    public FrameLayout e() {
        return (FrameLayout) this.f76911f.findViewById(R.id.talkroom_root_container).findViewById(R.id.multi_link_dynamic_container);
    }

    public final void f(String r100) {
        Intrinsics.checkNotNullParameter(r100, "source");
        ALogger.i("MultiLinkDynamicWidget", "onDestroy, mBizId: " + this.f76912g);
        kh0.h r101 = this.f76908c;
        if (r101 == null) goto L8;
        Iterator r102 = ((LinkedHashMap) r101.f503430a).entrySet().iterator();
    L6:
        if (r102.hasNext() == false) goto L8;
        Map.Entry r103 = (Map.Entry) r102.next();
        String r104 = (String) r103.getKey();
        ((kh0.a) r103.getValue()).b();
    L8:
        Iterator r105 = ((LinkedHashMap) this.f76907b).entrySet().iterator();
    L10:
        if (r105.hasNext() == false) goto L23;
        Map.Entry r106 = (Map.Entry) r105.next();
        ih0.c r107 = ((h) r106.getValue()).f76947a;
        if (r107 == null) goto L22;
        View r108 = r107.S0();
        if (r108 == null) goto L22;
        ViewGroup r109 = UtilityKotlinExtentionsKt.p(r108);
        if (r109 == null) goto L22;
        ih0.c r110 = ((h) r106.getValue()).f76947a;
        if (r110 == null) goto L20;
        View r111 = r110.S0();
    L21:
        r109.removeView(r111);
        goto L22
    L20:
        r111 = null;
    L22:
        ((h) r106.getValue()).b();
        goto L10
    L23:
        ((LinkedHashMap) this.f76907b).clear();
        jh0.c r112 = jh0.b.f499067a;
        String r113 = this.f76912g;
        Intrinsics.checkNotNullParameter(r113, "bizId");
        if (Intrinsics.areEqual(r113, "adventure") == false) goto L26;
        ALogger.i("DynamicBizExtController", "adventure unload");
        com.bytedance.android.live.liveinteract.revenue.adventure.linkcore.a r114 = com.bytedance.android.live.liveinteract.revenue.adventure.linkcore.g.f77934a;
        com.bytedance.android.live.liveinteract.revenue.adventure.linkcore.g.d("adventure unload");
    L26:
        int r115 = com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.s.f77144a;
        com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.s.c(this.f76912g, r100);
    }

    public final void g(String r100) {
        h r101 = this.f76907b.remove(r100);
        if (r101 == null) goto L21;
        IInteractService r102 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r102 == null) goto L9;
        ih0.b r103 = r102.dynamicService(this.f76916k);
        if (r103 == null) goto L9;
        r103.Tl(r101.f76947a);
    L9:
        r101.b();
        ih0.c r104 = r101.f76947a;
        if (r104 == null) goto L22;
        View r105 = r104.S0();
        if (r105 == null) goto L23;
        ViewGroup r106 = UtilityKotlinExtentionsKt.p(r105);
        if (r106 == null) goto L24;
        ih0.c r107 = r101.f76947a;
        if (r107 == null) goto L18;
        View r108 = r107.S0();
    L19:
        r106.removeView(r108);
        return;
    L18:
        r108 = null;
        goto L19
    L24:
        return;
    L23:
        return;
    L22:
        return;
    }

    public final void h(ih0.f r110) {
        Intrinsics.checkNotNullParameter(r110, "updateStatusData");
        int r100 = f.f76936a[r110.getType().ordinal()];
        if (r100 == 1) goto L63;
        if (r100 != 2) goto L177;
        JsonObject r101 = r110.f489772d;
        if (r101 != null) goto L161;
    L30:
        final nh0.b r102 = null;
    L31:
        if (r102 == null) goto L178;
        ALogger.i("MultiLinkDynamicWidget-Time", "start updateAnim");
        String r103 = r102.f519109c;
        boolean r104 = false;
        if (r103 != null) goto L36;
    L39:
        boolean r105 = true;
    L40:
        if (r105 == false) goto L42;
        ALogger.i("MultiLinkDynamicWidget-Time", "start updateAnim webpUrl is null");
        return;
    L42:
        int r106 = f.f76940e[r102.getType().ordinal()];
        if (r106 == 1) goto L62;
        if (r106 != 2) goto L179;
        ALogger.i("MultiLinkDynamicWidget", "START_Seat_ANIM :" + r102);
        String r107 = r102.f519111e;
        if (r107 != null) goto L49;
        return;
    L49:
        if (r107.length() <= 0) goto L51;
        boolean r108 = true;
    L52:
        if (r108 != true) goto L164;
        String r109 = r102.f519109c;
        if (r109 != null) goto L56;
        return;
    L56:
        if (r109.length() <= 0) goto L58;
        r104 = true;
    L58:
        if (r104 != true) goto L166;
        sh0.i0 r111 = sh0.j0.a(this.f76916k);
        if (r111 == null) goto L167;
        r111.d0(sh0.b0.f541900b, new sh0.c0(r102.f519108b, r102.f519109c, r102.f519111e));
        return;
    L167:
        return;
    L166:
        return;
    L164:
        return;
    L51:
        r108 = false;
        goto L52
    L179:
        return;
    L62:
        new MultiLinkBizHybridCardController$updateAnim$1(this, r102).invoke2();
        return;
    L36:
        if (r103.length() == 0) goto L39;
        r105 = false;
        goto L40
    L178:
        return;
    L161:
        String r112 = r101.get("type").getAsString();     // Catch: Exception -> L28
        Locale r113 = Locale.ROOT;     // Catch: Exception -> L28
        if (r112 == null) goto L27;
        AnimUpdateType r114 = AnimUpdateType.valueOf(r112.toUpperCase(r113));     // Catch: Exception -> L28
        String r115 = r101.get("item_id").getAsString();     // Catch: Exception -> L28
        JsonElement r116 = r101.get("extra");     // Catch: Exception -> L28
        if (r116 == null) goto L24;
        JsonObject r117 = r116.getAsJsonObject();     // Catch: Exception -> L28
        String r118 = r117.get("url").getAsString();     // Catch: Exception -> L28
        JsonElement r119 = r117.get("frame");     // Catch: Exception -> L28
        if (r119 == null) goto L15;
        JsonObject r120 = r119.getAsJsonObject();     // Catch: Exception -> L28
    L16:
        if (r120 == null) goto L18;
        nh0.a r121 = new nh0.a(r120.get("x").getAsInt(), r120.get("y").getAsInt(), r120.get("w").getAsInt(), r120.get("h").getAsInt());     // Catch: Exception -> L28
    L19:
        JsonElement r122 = r117.get("uid");     // Catch: Exception -> L28
        if (r122 == null) goto L22;
        String r123 = r122.getAsString();     // Catch: Exception -> L28
    L23:
        nh0.b r124 = new nh0.b(r114, r115, r118, r121, r123);     // Catch: Exception -> L28
    L25:
        r102 = r124;
        goto L31
    L22:
        r123 = null;
        goto L23
    L18:
        r121 = null;
        goto L19
    L15:
        r120 = null;
        goto L16
    L24:
        r124 = new nh0.b(r114, r115, "", null, null);     // Catch: Exception -> L28
        goto L25
    L27:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");     // Catch: Exception -> L28
    L28:
        e = move-exception;
        ALogger.e("MultiLinkDynamicWidget", "parseToAnimExtraObject: " + r101, e);
        goto L30
    L177:
        return;
    L63:
        nh0.o r125 = com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.f.b(r110.f489772d);
        if (r125 == null) goto L180;
        ALogger.i("MultiLinkDynamicWidget-Time", "start load stage card loadTime=" + r125.f519148g);
        String r126 = r125.f519143b;
        int r127 = f.f76939d[r125.getType().ordinal()];
        if (r127 == 1) goto L93;
        if (r127 == 2) goto L72;
        if (r127 != 3) goto L181;
        g(r126);
        return;
    L181:
        return;
    L72:
        h r128 = (h) ((LinkedHashMap) this.f76907b).get(r126);
        if (r128 == null) goto L171;
        ih0.c r129 = r128.f76947a;
        if (r129 == null) goto L182;
        nh0.n r130 = r125.f519147f;
        if (r130 == null) goto L183;
        View r131 = r129.S0();
        if (r131 == null) goto L83;
        ViewGroup.LayoutParams r132 = r131.getLayoutParams();
    L85:
        if ((r132 instanceof FrameLayout.LayoutParams) == true) goto L87;
        r132 = null;
    L87:
        FrameLayout.LayoutParams r133 = (FrameLayout.LayoutParams) r132;
        if (r133 == null) goto L184;
        r133.topMargin = s1.f(r130.f519139b);
        r133.leftMargin = s1.f(r130.f519138a);
        View r134 = r129.S0();
        if (r134 == null) goto L172;
        r134.setLayoutParams(r133);
        return;
    L172:
        return;
    L184:
        return;
    L83:
        r132 = null;
        goto L85
    L183:
        return;
    L182:
        return;
    L171:
        return;
    L93:
        h r135 = (h) ((LinkedHashMap) this.f76907b).get(r126);
        if (r135 != null) goto L96;
    L99:
        h r136 = new h(this.f76909d, r125.f519144c, r125.f519145d, r125.f519149h, this.f76912g, new g(this, r125, r126));
        this.f76907b.put(r126, r136);
        ih0.c r137 = r136.a(this.f76916k);
        if (r137 == null) goto L186;
        this.f76910e.fa(r137);
        nh0.n r138 = r125.f519147f;
        if (r138 == null) goto L187;
        int r139 = f.f76938c[r125.f519146e.ordinal()];
        if (r139 == 1) goto L112;
        if (r139 == 2) goto L111;
        if (r139 == 3) goto L110;
        FrameLayout r140 = null;
    L113:
        if (r140 == null) goto L154;
        UtilityKotlinExtentionsKt.w(r140);
        FrameLayout.LayoutParams r141 = new FrameLayout.LayoutParams(s1.f(r138.f519140c), s1.f(r138.f519141d));
        r141.topMargin = s1.f(r138.f519139b);
        r141.leftMargin = s1.f(r138.f519138a);
        View r142 = r137.S0();
        if (r142 == null) goto L117;
        r142.setLayoutParams(r141);
    L117:
        r140.addView(r137.S0());
        if (je0.d.r() == true) goto L136;
        if (Intrinsics.areEqual(this.f76912g, "team_fight") == false) goto L136;
        if (Intrinsics.areEqual(r125.f519143b, "teamfight_foreground") == false) goto L136;
        com.bytedance.android.livesdk.chatroom.u r143 = com.bytedance.android.live.liveinteract.api.utils.m.h(this.f76916k, null, 2);
        if (r143 == null) goto L128;
        com.bytedance.live.datacontext.n<Object> r144 = r143.x();
        if (r144 == null) goto L128;
        Object r145 = r144.getValue();
    L130:
        if ((r145 instanceof MultiSceneEnterRoomStatisticsUtils) == true) goto L132;
        r145 = null;
    L132:
        MultiSceneEnterRoomStatisticsUtils r146 = (MultiSceneEnterRoomStatisticsUtils) r145;
        if (r146 == null) goto L136;
        int r147 = MultiSceneEnterRoomStatisticsUtils.f78650u;
        r146.j(null);
    L128:
        r145 = null;
    L136:
        if (je0.d.r() == true) goto L154;
        if (Intrinsics.areEqual(this.f76912g, "room_battle") == false) goto L154;
        if (Intrinsics.areEqual(r125.f519143b, "teamfight_foreground") == false) goto L154;
        com.bytedance.android.livesdk.chatroom.u r148 = com.bytedance.android.live.liveinteract.api.utils.m.h(this.f76916k, null, 2);
        if (r148 == null) goto L146;
        com.bytedance.live.datacontext.n<Object> r149 = r148.x();
        if (r149 == null) goto L146;
        Object r150 = r149.getValue();
    L148:
        if ((r150 instanceof MultiSceneEnterRoomStatisticsUtils) == true) goto L150;
        r150 = null;
    L150:
        MultiSceneEnterRoomStatisticsUtils r151 = (MultiSceneEnterRoomStatisticsUtils) r150;
        if (r151 == null) goto L154;
        int r152 = MultiSceneEnterRoomStatisticsUtils.f78650u;
        r151.j(null);
    L146:
        r150 = null;
    L154:
        if (r125.f519150i == false) goto L174;
        IInteractService r153 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r153 == null) goto L175;
        ih0.b r154 = r153.dynamicService(this.f76916k);
        if (r154 == null) goto L176;
        r154.Gb(r125.f519143b, r137);
        return;
    L176:
        return;
    L175:
        return;
    L174:
        return;
    L110:
        r140 = d();
        goto L113
    L111:
        r140 = e();
        goto L113
    L112:
        r140 = c();
        goto L113
    L187:
        return;
    L186:
        return;
    L96:
        if (Intrinsics.areEqual(r135.f76950d, r125.f519145d) == true) goto L185;
        r135.b();
        h r155 = this.f76907b.remove(r126);
        goto L99
    L185:
        return;
    }

    public static final void b(e r100, nh0.o r101, int r102) {
        r100.getClass();
        JsonObject r103 = new JsonObject();
        r103.addProperty("item_id", r101.f519143b);
        r103.addProperty("status", Integer.valueOf(r102));
        ih0.b r104 = ((IInteractService) jc1.k.n(IInteractService.class)).dynamicService(r100.f76916k);
        if (r104 == null) goto L6;
        r104.Dk(r100.f76912g, "layer_element_result", r103, false);
    L6:
        if (je0.d.r() == true) goto L25;
        if (Intrinsics.areEqual(r100.f76912g, "team_fight") == false) goto L25;
        if (Intrinsics.areEqual(r101.f519143b, "teamfight_foreground") == false) goto L25;
        if (r102 != 1) goto L25;
        com.bytedance.android.livesdk.chatroom.u r105 = com.bytedance.android.live.liveinteract.api.utils.m.h(r100.f76916k, null, 2);
        if (r105 == null) goto L17;
        com.bytedance.live.datacontext.n<Object> r106 = r105.x();
        if (r106 == null) goto L17;
        Object r107 = r106.getValue();
    L19:
        if ((r107 instanceof MultiSceneEnterRoomStatisticsUtils) == true) goto L21;
        r107 = null;
    L21:
        MultiSceneEnterRoomStatisticsUtils r108 = (MultiSceneEnterRoomStatisticsUtils) r107;
        if (r108 == null) goto L25;
        int r109 = MultiSceneEnterRoomStatisticsUtils.f78650u;
        r108.i(null);
    L17:
        r107 = null;
    L25:
        if (je0.d.r() == false) goto L27;
        return;
    L27:
        if (Intrinsics.areEqual(r100.f76912g, "room_battle") == true) goto L29;
        return;
    L29:
        if (Intrinsics.areEqual(r101.f519143b, "teamfight_foreground") == false) goto L46;
        if (r102 != 1) goto L47;
        com.bytedance.android.livesdk.chatroom.u r110 = com.bytedance.android.live.liveinteract.api.utils.m.h(r100.f76916k, null, 2);
        if (r110 == null) goto L36;
        com.bytedance.live.datacontext.n<Object> r111 = r110.x();
        if (r111 == null) goto L36;
        Object r112 = r111.getValue();
    L38:
        if ((r112 instanceof MultiSceneEnterRoomStatisticsUtils) == true) goto L40;
        r112 = null;
    L40:
        MultiSceneEnterRoomStatisticsUtils r113 = (MultiSceneEnterRoomStatisticsUtils) r112;
        if (r113 == null) goto L48;
        int r114 = MultiSceneEnterRoomStatisticsUtils.f78650u;
        r113.i(null);
        return;
    L48:
        return;
    L36:
        r112 = null;
        goto L38
    L47:
        return;
    }

    public e(Context r100, ih0.b r101, ViewGroup r102, String r103, IRoom r104, boolean r105, String r106, DataCenter r107) {
        Intrinsics.checkNotNullParameter(r100, "mContext");
        Intrinsics.checkNotNullParameter(r101, "service");
        Intrinsics.checkNotNullParameter(r102, "mLinkRootView");
        Intrinsics.checkNotNullParameter(r103, "mBizId");
        Intrinsics.checkNotNullParameter(r104, "mRoom");
        this.f76909d = r100;
        this.f76910e = r101;
        this.f76911f = r102;
        this.f76912g = r103;
        this.f76913h = r104;
        this.f76914i = r105;
        this.f76915j = r106;
        this.f76916k = r107;
        this.f76906a = new JsonObject();
        this.f76907b = new LinkedHashMap();
    }
}
