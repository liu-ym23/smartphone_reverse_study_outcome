package com.bytedance.android.shopping.abscontainer.common_biz.module.hybrid_event;

import com.bytedance.android.ecom.arch.slice.action.SlcCommonAction;
import java.util.HashMap;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import u33.a;
import v43.p;

/* JADX INFO: loaded from: classes12.dex */
public final class f<STATE extends p, PROPS extends u33.a> extends s33.b<STATE, PROPS> implements o33.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f164337b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f164338c;

    @Override // o33.b
    public final String getEventName() {
        return this.f164338c;
    }

    @Override // s33.b
    public final String j() {
        return this.f164337b;
    }

    public f(l33.b<STATE, PROPS> r100) {
        Intrinsics.checkNotNullParameter(r100, "containerContext");
        super(r100);
        this.f164337b = "TradeEventModule";
        this.f164338c = "buynow_trade_event";
    }

    @Override // o33.b
    public final void a(Map<String, ? extends Object> r110) {
        Intrinsics.checkNotNullParameter(r110, "params");
        HashMap r111 = (HashMap) r110;
        Object r100 = r111.get("unique_session_id");
        Object r101 = null;
        if ((r100 instanceof String) == true) goto L5;
        r100 = null;
    L5:
        String r102 = (String) r100;
        if (r102 != null) goto L8;
        r102 = "";
    L8:
        Object r103 = r111.get("type");
        if ((r103 instanceof String) == true) goto L11;
        r103 = null;
    L11:
        String r104 = (String) r103;
        if (r104 != null) goto L14;
        String r105 = "";
    L15:
        b43.c r106 = b43.c.f17507a;
        if (b43.c.c(r102) == false) goto L18;
    L20:
        Object r112 = r111.get(SlcCommonAction.KEY_PARAMS);
        if ((r112 instanceof Map) == false) goto L24;
        r101 = r112;
    L24:
        Map<String, ? extends Object> r107 = (Map) r101;
        if (r107 != null) goto L27;
        Map<String, ? extends Object> r108 = MapsKt.emptyMap();
    L28:
        String r109 = ((p) this.f540457a.f507247a).O();
        if (r109 == null) goto L32;
        this.f540457a.f507250d.c().j(null, r109, r105, r108, this.f164338c);
        return;
    L32:
        return;
    L27:
        r108 = r107;
        goto L28
    L18:
        if ((!Intrinsics.areEqual(r102, this.f540457a.f507249c.f548574a.getSessionID())) == false) goto L20;
        return;
    L14:
        r105 = r104;
        goto L15
    }
}
