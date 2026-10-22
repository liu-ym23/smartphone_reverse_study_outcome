package com.bytedance.android.gamecp.hybrid_impl.jsb;

import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.Gson;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@XBridgeMethod(biz = "webcast", name = "openHeliumGame")
public final class f2 extends o0<c5, OpenHeliumGameResultModel> {

    public static final class a {
    }

    static {
    }

    public f2() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r110) {
        c5 r101 = (c5) r100;
        Intrinsics.checkNotNullParameter(r101, "params");
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        n1.a("openHeliumGame", GsonProtectorUtils.toJson(new Gson(), r101));
        xr.f r111 = (xr.f) xr.s.a(xr.f.class);
        if (r111 == null) goto L17;
        xr.h r102 = r111.getGameService();
        if (r102 == null) goto L18;
        Integer r112 = r101.b();
        if (r112 == null) goto L9;
        int r103 = r112.intValue();
    L10:
        String r104 = r101.c();
        Integer r113 = r101.f();
        if (r113 == null) goto L14;
        String r114 = String.valueOf(r113.intValue());
        if (r114 == null) goto L14;
    L15:
        xr.h.a.a(r102, r103, r104, Intrinsics.areEqual(r114, "1"), r101.a(), r101.d(), r101.e(), new g2(this));
        return;
    L14:
        r114 = "0";
        goto L15
    L9:
        r103 = 3;
        goto L10
    L18:
        return;
    }
}
