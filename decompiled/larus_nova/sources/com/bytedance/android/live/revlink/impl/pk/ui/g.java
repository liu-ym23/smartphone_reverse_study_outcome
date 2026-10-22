package com.bytedance.android.live.revlink.impl.pk.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.bytedance.android.live.revlink.api.ILinkService;
import com.bytedance.android.live.revlink.impl.LinkCrossRoomDataHolder;
import com.bytedance.android.live.revlink.impl.pk.service.IPKLinkBizDataService;
import com.bytedance.android.livesdk.chatroom.interact.model.h0;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes47.dex */
public final class g extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Map<Integer, View> f97036a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final IRoom f97037b;

    public final View a(int r100) {
        if (this.f97036a != null) goto L5;
        this.f97036a = new LinkedHashMap();
    L5:
        View r101 = this.f97036a.get(Integer.valueOf(r100));
        if (r101 != null) goto L12;
        View r102 = findViewById(r100);
        if (r102 == null) goto L10;
        this.f97036a.put(Integer.valueOf(r100), r102);
        return r102;
    L10:
        return null;
    L12:
        return r101;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public g(Context r110, IRoom r111, DataCenter r112) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r112, "dataCenter");
        super(r110);
        this.f97036a = new LinkedHashMap();
        this.f97037b = r111;
        LayoutInflater.from(getContext()).inflate(R.layout.ttlive_view_pk_rematch_finished, this);
        ((Button) a(R.id.finish_idl)).setOnClickListener(new c(this));
        String r100 = null;
        boolean r113 = false;
        if (((Number) l51.a.f507451h0.getValue(null, l51.a.f507436a[69])).intValue() != 0) goto L5;
        ((LinearLayout) a(R.id.idl)).setVisibility(0);
        ((FrameLayout) a(R.id.matching)).setVisibility(8);
    L61:
        ((Button) a(R.id.rematch)).setOnClickListener(new d(this));
        ((Button) a(R.id.finish_match)).setOnClickListener(new e(this));
        ((LinearLayout) a(R.id.rb_layout)).setOnClickListener(new f(this));
        return;
    L5:
        IPKLinkBizDataService r114 = com.bytedance.android.live.revlink.impl.global.b.P();
        if (r114 == null) goto L8;
        r114.setIsRandomReMatch(true);
    L8:
        com.bytedance.android.live.revlink.impl.pk.service.a r115 = com.bytedance.android.live.revlink.impl.global.b.M();
        long r101 = 0;
        if (r115 == null) goto L13;
        h0 r116 = r115.d();
        if (r116 == null) goto L13;
        r116.f106761c = 0;
    L13:
        com.bytedance.android.live.revlink.impl.pk.service.a r117 = com.bytedance.android.live.revlink.impl.global.b.M();
        if (r117 == null) goto L18;
        h0 r118 = r117.d();
        if (r118 == null) goto L18;
        r118.f106760b = System.currentTimeMillis();
    L18:
        i41.a r119 = com.bytedance.android.live.revlink.impl.global.b.g();
        if (r119 == null) goto L23;
        if (r111 == null) goto L22;
        r101 = r111.getId();
    L22:
        i41.a.e(r119, r101, false);
    L23:
        ((LinearLayout) a(R.id.idl)).setVisibility(8);
        ((FrameLayout) a(R.id.matching)).setVisibility(0);
        com.bytedance.android.live.revlink.impl.pk.utils.w.a((SimpleDraweeView) a(R.id.anim), "https://lf3-webcastcdn-tos.douyinstatic.com/obj/live-android/dy_pk_rematch_loading.webp");
        com.bytedance.android.live.revlink.impl.global.b.j();
        h41.g.c("reinvite");
        HashMap r120 = new HashMap();
        r120.put("is_oncemore", "0");
        r120.put("connection_type", "random_pk");
        r120.put("pk_description", "routine");
        p11.h r121 = ((ILinkService) com.bytedance.android.live.revenue.core.util.f.a(ILinkService.class)).getPkService();
        if (r121 == null) goto L26;
        String r122 = r121.getInviteMode();
    L27:
        if (r122 != null) goto L29;
    L32:
        boolean r102 = true;
    L33:
        if (r102 == false) goto L36;
        r122 = "routine_pk";
    L36:
        r120.put("invite_mode", r122);
        p11.h r123 = ((ILinkService) com.bytedance.android.live.revenue.core.util.f.a(ILinkService.class)).getPkService();
        if (r123 == null) goto L39;
        String r124 = r123.getTheme();
    L40:
        if (r124 != null) goto L42;
    L45:
        boolean r103 = true;
    L46:
        if (r103 == true) goto L48;
        r120.put("theme", r124);
    L48:
        String r104 = "";
        r120.put("pk_activity_type", "");
        com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.e r125 = com.bytedance.android.live.revlink.impl.global.b.l();
        if (r125 == null) goto L51;
        r104 = r125.a();
    L51:
        r120.put("from_room_status", r104);
        IPKLinkBizDataService r126 = com.bytedance.android.live.revlink.impl.global.b.P();
        if (r126 == null) goto L54;
        r100 = IPKLinkBizDataService.b.a(r126, null);
    L54:
        if (r100 != null) goto L56;
    L57:
        r113 = true;
    L58:
        if (r113 == true) goto L60;
        r120.put("transform_reason", r100);
    L60:
        mz0.n r127 = new mz0.n();
        Map<String, String> r128 = r127.f516447a;
        Intrinsics.checkNotNullParameter(r128, "map");
        Intrinsics.checkNotNullParameter(r120, "map");
        r128.putAll(r120);
        mz0.m r129 = new mz0.m();
        com.bytedance.android.livesdk.revenue.log.h r130 = ((kr2.a) vh6.c.b(kr2.a.class)).be();
        Intrinsics.checkNotNullParameter(r130, "linkInfoLog");
        am2.m r131 = r130.f157175a;
        r131.f4310i = 300;
        ((ArrayList) r129.f516446a).add(r131);
        LinkCrossRoomDataHolder.a r132 = LinkCrossRoomDataHolder.f92004c;
        com.bytedance.android.live.revlink.impl.a.b(r129);
        r129.b(LogCommon.ROOM);
        ((ArrayList) r127.f516448b).addAll(r129.f516446a);
        cy0.e.f465759a.getClass();
        cy0.j r133 = cy0.e.a.f465760a;
        com.bytedance.android.scope.m.f163449e.getClass();
        Object r134 = com.bytedance.android.scope.m.b(r133).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r134);
        ((mz0.i) ((f80.a) r134)).w3("connection_invite", r127.f516447a, r127.f516448b);
        goto L61
    L56:
        if (r100.length() != 0) goto L58;
    L42:
        if (r124.length() == 0) goto L45;
        r103 = false;
        goto L46
    L39:
        r124 = null;
        goto L40
    L29:
        if (r122.length() == 0) goto L32;
        r102 = false;
        goto L33
    L26:
        r122 = null;
        goto L27
    }
}
