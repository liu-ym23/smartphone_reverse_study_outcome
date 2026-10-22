package com.bytedance.android.live.revlink.link.biz.component;

import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.livesdk.link.model.bridge.n0;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.common.wschannel.WsConstants;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.disposables.CompositeDisposable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes47.dex */
public final class g extends com.bytedance.android.live.revenuelink.connect.c implements com.bytedance.android.live.revlink.link.biz.service.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f98033a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CompositeDisposable f98034b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f98035c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.bytedance.android.live.revlink.link.infra.lifecontrol.context.a f98036d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final com.bytedance.android.live.revlink.impl.multianchor.ui.i f98037e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final com.bytedance.android.live.revenuelink.rtc.i f98038f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final h f98039g;

    @Override // com.bytedance.android.live.revlink.link.biz.service.e
    public final String getTAG() {
        return "RevenueLinkAnchorComponent";
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.e
    public final void attach() {
        com.bytedance.android.live.revenuelink.connect.f r100 = com.bytedance.android.live.revlink.link.biz.service.i.c(this);
        if (r100 == null) goto L6;
        r100.addLinkInListener(7, this);
        return;
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.e
    public final void detach() {
        com.bytedance.android.live.revenuelink.connect.f r100 = com.bytedance.android.live.revlink.link.biz.service.i.c(this);
        if (r100 == null) goto L5;
        r100.removeLinkInListener(7, this);
    L5:
        this.f98034b.clear();
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.c, com.bytedance.android.live.revlink.link.biz.service.e, com.bytedance.android.live.revlink.link.biz.service.j
    public /* bridge */ /* synthetic */ com.bytedance.android.live.revlink.link.infra.lifecontrol.context.d getContext() {
        return getContext();
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.k
    public final com.bytedance.android.live.revlink.impl.global.c getLinkInstanceService() {
        return getContext();
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.e
    public final String getComponentName() {
        return this.f98033a;
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.c, com.bytedance.android.live.revlink.link.biz.service.e, com.bytedance.android.live.revlink.link.biz.service.j
    public com.bytedance.android.live.revlink.link.infra.lifecontrol.context.a getContext() {
        return this.f98036d;
    }

    @Override // com.bytedance.android.live.revenuelink.connect.c, com.bytedance.android.live.revenuelink.connect.i
    public final void k3(fy.h r100, ExtraResponse<n0, Extra> r101) {
        Intrinsics.checkNotNullParameter(r100, "leaveParams");
        cy0.e.f465759a.getClass();
        cy0.j r102 = cy0.e.a.f465760a;
        com.bytedance.android.scope.m.f163449e.getClass();
        Object r103 = com.bytedance.android.scope.m.b(r102).b(er2.b.class);
        Intrinsics.checkNotNull(r103);
        iq2.b r104 = ((er2.b) ((com.bytedance.live.kmp.core.c) r103)).getChorusService();
        if (r104 != null) goto L5;
        return;
    L5:
        if (r104.e() != true) goto L16;
        Object r105 = com.bytedance.android.scope.m.b(r102).b(er2.b.class);
        Intrinsics.checkNotNull(r105);
        iq2.b r106 = ((er2.b) ((com.bytedance.live.kmp.core.c) r105)).getChorusService();
        long r107 = 0;
        if (r106 == null) goto L13;
        com.bytedance.android.live.liveinteract.model.a r108 = r106.c();
        if (r108 == null) goto L13;
        if (r108.getStartTime() <= 0) goto L13;
        i97.a r109 = i97.a.f488802a;
        r107 = (System.currentTimeMillis() / ((long) 1000)) - r108.getStartTime();
    L13:
        a(0, this.f98039g.f98042f, r107);
        return;
    }

    public final void a(int r100, boolean r101, long r110) {
        if (r100 != 2) goto L12;
        f21.a r102 = com.bytedance.android.live.revlink.link.biz.service.i.i(this);
        if (r102 == null) goto L12;
        if (r102.f475116f != true) goto L12;
        if (this.f98035c == true) goto L12;
        this.f98035c = true;
        return;
    L12:
        LinkedHashMap r103 = new LinkedHashMap();
        r103.put("channel_id", String.valueOf(com.bytedance.android.live.revlink.link.biz.service.i.A(this).a()));
        r103.put("anchor_connect_status", "2");
        r103.put("invite_mode", WsConstants.KEY_CONNECTION);
        String r104 = "0";
        r103.put("is_oncemore", "0");
        r103.put("room_status", WsConstants.KEY_CONNECTION);
        cy0.e.f465759a.getClass();
        cy0.j r105 = cy0.e.a.f465760a;
        com.bytedance.android.scope.m.f163449e.getClass();
        Object r106 = com.bytedance.android.scope.m.b(r105).b(er2.b.class);
        Intrinsics.checkNotNull(r106);
        iq2.b r107 = ((er2.b) ((com.bytedance.live.kmp.core.c) r106)).getChorusService();
        if (r107 != null) goto L15;
    L17:
        String r108 = "follower";
    L18:
        r103.put("role_type", r108);
        if (r100 == 1) goto L23;
        if (r100 == 2) goto L22;
        String r109 = "disconnect";
    L24:
        r103.put("over_type", r109);
        if (r101 == false) goto L27;
        r104 = "1";
    L27:
        r103.put("if_active", r104);
        r103.put("chorus_time", String.valueOf(r110));
        Object r111 = com.bytedance.android.scope.m.b(r105).b(er2.b.class);
        Intrinsics.checkNotNull(r111);
        iq2.b r112 = ((er2.b) ((com.bytedance.live.kmp.core.c) r111)).getChorusService();
        if (r112 == null) goto L33;
        com.bytedance.android.live.liveinteract.model.a r113 = r112.c();
        if (r113 == null) goto L33;
        String r114 = String.valueOf(r113.getChorusId());
        if (r114 == null) goto L33;
    L34:
        r103.put("chorus_id", r114);
        mz0.n r115 = new mz0.n();
        Map<String, String> r116 = r115.f516447a;
        Intrinsics.checkNotNullParameter(r116, "map");
        Intrinsics.checkNotNullParameter(r103, "map");
        r116.putAll(r103);
        mz0.m r117 = new mz0.m();
        com.bytedance.android.live.revlink.link.biz.service.i.m(this).a(r117);
        r117.b(LogCommon.ROOM);
        r117.b(LogCommon.PAGE_SOURCE_LOG);
        List<Object> r118 = r115.f516448b;
        ArrayList r119 = (ArrayList) r118;
        r119.addAll(r117.f516446a);
        Object r120 = com.bytedance.android.scope.m.b(r105).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r120);
        ((mz0.i) ((f80.a) r120)).w3("livesdk_connection_chorus_over", r115.f516447a, r115.f516448b);
        return;
    L33:
        r114 = "";
        goto L34
    L22:
        r109 = "join";
        goto L24
    L23:
        r109 = "shut_down";
        goto L24
    L15:
        if (r107.d() != 1) goto L17;
        r108 = "leader";
        goto L18
    }

    public g(com.bytedance.android.live.revlink.link.infra.lifecontrol.context.g r100, com.bytedance.android.live.revlink.link.domain.service.a r101, com.bytedance.android.live.revenuelink.rtc.i r102, h r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "muteManager");
        Intrinsics.checkNotNullParameter(r102, "rtcManager");
        Intrinsics.checkNotNullParameter(r103, "bizDataContext");
        this.f98036d = r100;
        this.f98037e = r101;
        this.f98038f = r102;
        this.f98039g = r103;
        this.f98033a = "MultiChorusComponent";
        this.f98034b = new CompositeDisposable();
    }
}
