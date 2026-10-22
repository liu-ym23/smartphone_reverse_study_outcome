package com.bytedance.android.annie.bridge.method;

import android.content.Context;
import com.bytedance.android.annie.Annie;
import com.bytedance.android.annie.bridge.method.abs.PrerenderParamModel;
import com.bytedance.android.annie.bridge.method.abs.PrerenderResultModel;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.ttvideoengine.preRender.PlayBufferManager;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@XBridgeMethod(biz = "webcast_sdk", name = PlayBufferManager.PRERENDER_KEY)
public final class p1 extends e7.r<PrerenderParamModel, PrerenderResultModel> {
    public p1() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r101) {
        PrerenderParamModel r102 = (PrerenderParamModel) r100;
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (r102.b() != null) goto L5;
        PrerenderResultModel r103 = new PrerenderResultModel();
        r103.a(PrerenderResultModel.Code.Failed);
        r103.b("schema is null");
        finishWithResult(r103);
        return;
    L5:
        ConcurrentHashMap<String, com.bytedance.android.annie.ng.a> r104 = com.bytedance.android.annie.ng.g.f39671c;
        com.bytedance.android.annie.ng.a r105 = r104.get(r101.a());
        if (r105 == null) goto L12;
        o8.g r106 = r105.f39646d;
        if (r106 == null) goto L12;
        boolean r107 = true;
        if (r106.f522333b != true) goto L12;
    L13:
        if (r107 == true) goto L16;
        PrerenderResultModel r108 = new PrerenderResultModel();
        r108.a(PrerenderResultModel.Code.Failed);
        r108.b("not enable");
        finishWithResult(r108);
        return;
    L16:
        if (r102.a() != null) goto L22;
        com.bytedance.android.annie.ng.a r109 = r104.get(r101.a());
        if (r109 == null) goto L26;
        o8.g r110 = r109.f39646d;
        if (r110 == null) goto L26;
        int r111 = r110.f522334c;
    L25:
        int r112 = r111;
    L27:
        PrerenderParamModel.Strategy r113 = r102.c();
        if (r113 != null) goto L30;
        r113 = PrerenderParamModel.Strategy.Onidle;
    L30:
        Context r114 = r101.getContext();
        String r115 = r102.b();
        Intrinsics.checkNotNull(r115);
        String r116 = r101.a();
        Annie.prerenderWithSchema(r114, r115, r116, r112, r113, new o1(this));
        return;
    L26:
        r112 = 10;
        goto L27
    L22:
        Integer r117 = r102.a();
        if (r117 == null) goto L26;
        r111 = r117.intValue();
    L12:
        r107 = false;
        goto L13
    }
}
