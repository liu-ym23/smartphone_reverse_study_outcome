package com.bytedance.android.shopping.abscontainer.common_biz.module.hybrid_event;

import java.util.HashMap;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import u33.a;
import w33.g;

/* JADX INFO: loaded from: classes12.dex */
public final class g<STATE extends w33.g, PROPS extends u33.a> extends s33.b<STATE, PROPS> implements o33.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f164339b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f164340c;

    @Override // o33.b
    public final String getEventName() {
        return this.f164340c;
    }

    @Override // s33.b
    public final String j() {
        return this.f164339b;
    }

    public g(l33.b<STATE, PROPS> r100) {
        Intrinsics.checkNotNullParameter(r100, "containerContext");
        super(r100);
        this.f164339b = "TradeTrackProxyModule";
        this.f164340c = "buynow_trade_track_proxy";
    }

    @Override // o33.b
    public final void a(Map<String, ? extends Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        HashMap r101 = (HashMap) r100;
        Object r102 = r101.get("unique_session_id");
        Object r103 = null;
        if ((r102 instanceof String) == true) goto L5;
        r102 = null;
    L5:
        String r104 = (String) r102;
        String r105 = "";
        if (r104 != null) goto L8;
        r104 = "";
    L8:
        Object r106 = r101.get("eventName");
        if ((r106 instanceof String) == true) goto L11;
        r106 = null;
    L11:
        String r107 = (String) r106;
        if (r107 == null) goto L15;
        r105 = r107;
    L15:
        b43.c r108 = b43.c.f17507a;
        if (b43.c.c(r104) == false) goto L18;
    L20:
        Object r109 = r101.get("params");
        if ((r109 instanceof Map) == false) goto L24;
        r103 = r109;
    L24:
        Map<String, ? extends Object> r110 = (Map) r103;
        if (r110 != null) goto L27;
        r110 = MapsKt.emptyMap();
    L27:
        this.f540457a.f507250d.a().a(r105, r110);
        return;
    L18:
        if ((!Intrinsics.areEqual(r104, this.f540457a.f507249c.f548574a.getSessionID())) == false) goto L20;
    }
}
