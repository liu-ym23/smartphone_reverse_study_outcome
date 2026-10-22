package com.bytedance.android.shopping.abscontainer.common_biz.module.hybrid_event;

import com.bytedance.android.ecom.arch.slice.action.SlcCommonAction;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import u33.a;
import v43.p;

/* JADX INFO: loaded from: classes12.dex */
public final class e<STATE extends p, PROPS extends u33.a> extends s33.b<STATE, PROPS> implements o33.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Map<String, ? extends Object> f164334b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f164335c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f164336d;

    @Override // s33.b
    public final void x() {
        Map<String, ? extends Object> r100 = this.f164334b;
        if (r100 == null) goto L17;
        Object r101 = r100.get(SlcCommonAction.KEY_PARAMS);
        if ((r101 instanceof Map) == true) goto L7;
        r101 = null;
    L7:
        Map<String, ? extends Object> r102 = (Map) r101;
        Object r103 = r100.get("type");
        if ((r103 instanceof String) == true) goto L10;
        r103 = null;
    L10:
        String r104 = (String) r103;
        if (r104 != null) goto L13;
        r104 = "";
    L13:
        String r105 = r104;
        String r106 = ((p) this.f540457a.f507247a).O();
        if (r106 == null) goto L18;
        this.f540457a.f507250d.c().j(null, r106, r105, r102, "handleAsyncEvent");
        this.f164334b = null;
        return;
    L18:
        return;
    }

    @Override // o33.b
    public final String getEventName() {
        return this.f164336d;
    }

    @Override // s33.b
    public final String j() {
        return this.f164335c;
    }

    public e(l33.b<STATE, PROPS> r100) {
        Intrinsics.checkNotNullParameter(r100, "containerContext");
        super(r100);
        this.f164335c = "TradeEventAsyncModule";
        this.f164336d = "buynow_trade_event_async";
    }

    @Override // o33.b
    public final void a(Map<String, ? extends Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Object r101 = ((HashMap) r100).get("unique_session_id");
        if ((r101 instanceof String) == true) goto L5;
        r101 = null;
    L5:
        String r102 = (String) r101;
        b43.c r103 = b43.c.f17507a;
        if (b43.c.c(r102) == false) goto L8;
    L10:
        this.f164334b = r100;
        return;
    L8:
        if ((!Intrinsics.areEqual(r102, this.f540457a.f507249c.f548574a.getSessionID())) == false) goto L10;
    }
}
