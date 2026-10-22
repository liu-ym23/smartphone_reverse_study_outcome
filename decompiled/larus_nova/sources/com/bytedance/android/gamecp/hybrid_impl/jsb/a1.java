package com.bytedance.android.gamecp.hybrid_impl.jsb;

import android.content.Context;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.Gson;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@XBridgeMethod(biz = "webcast", name = "giftPackReserveButtonClick")
public final class a1 extends h0<m4, n4> {

    public static final class a {
    }

    static {
    }

    public a1() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r110) {
        m4 r101 = (m4) r100;
        Intrinsics.checkNotNullParameter(r101, "paramModel");
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        n1.a("giftPackReserveButtonClick", GsonProtectorUtils.toJson(new Gson(), r101));
        xr.f r102 = (xr.f) xr.s.a(xr.f.class);
        if (r102 == null) goto L18;
        Context r103 = r110.getContext();
        String r111 = r101.b();
        if (r111 != null) goto L7;
        String r104 = "";
    L8:
        String r112 = r101.c();
        if (r112 != null) goto L11;
        String r105 = "";
    L12:
        String r106 = r101.a();
        if (r106 != null) goto L15;
        String r107 = "";
    L16:
        r102.O1(r103, r104, r105, r107, null, new b1(this));
        return;
    L15:
        r107 = r106;
        goto L16
    L11:
        r105 = r112;
        goto L12
    L7:
        r104 = r111;
        goto L8
    }
}
