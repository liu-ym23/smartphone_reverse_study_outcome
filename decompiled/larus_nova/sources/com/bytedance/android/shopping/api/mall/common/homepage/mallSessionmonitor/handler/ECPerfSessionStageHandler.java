package com.bytedance.android.shopping.api.mall.common.homepage.mallSessionmonitor.handler;

import android.net.Uri;
import com.bytedance.android.ec.hybrid.delivery.MallTransparentTransformer;
import com.bytedance.android.shopping.api.mall.common.homepage.mallSessionmonitor.ECHandlerType;
import com.bytedance.android.shopping.api.mall.common.homepage.mallSessionmonitor.SessionSettingUtil;
import com.bytedance.mt.protector.impl.UriProtector;
import com.google.gson.Gson;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class ECPerfSessionStageHandler extends a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f170360e;

    @Override // com.bytedance.android.shopping.api.mall.common.homepage.mallSessionmonitor.handler.a
    public final Function6<String, String, String, Double, String, Map<String, ? extends Object>, Unit> c() {
        return new ECPerfSessionStageHandler$defaultAction$1(this);
    }

    @Override // com.bytedance.android.shopping.api.mall.common.homepage.mallSessionmonitor.handler.a
    public final Map<String, Object> e() {
        Gson r100 = SessionSettingUtil.f170344a;
        ECHandlerType r101 = ECHandlerType.EC_PERF_SESSION;
        Intrinsics.checkNotNullParameter(r101, "handlerType");
        Map r102 = (Map) SessionSettingUtil.f170350g.getValue();
        if (r102 != null) goto L7;
        return null;
    L7:
        return (Map) r102.get(r101.getType());
    }

    public ECPerfSessionStageHandler() {
        this.f170360e = "ec_perf_session_id";
    }

    @Override // com.bytedance.android.shopping.api.mall.common.homepage.mallSessionmonitor.handler.a
    public final ECHandlerType d() {
        return ECHandlerType.EC_PERF_SESSION;
    }

    @Override // com.bytedance.android.shopping.api.mall.common.homepage.mallSessionmonitor.handler.a, com.bytedance.android.shopping.api.mall.common.homepage.mallSessionmonitor.handler.c
    public final String a(String r100, Map<String, ? extends Object> r101) {
        Intrinsics.checkNotNullParameter(r100, "scheme");
        Object r102 = null;
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L11
        Uri r104 = UriProtector.parse(r100);     // Catch: Throwable -> L11
        if (r104 != null) goto L6;
    L8:
        r104 = null;
    L9:
        Object r105 = Result.m9449constructorimpl(r104);     // Catch: Throwable -> L11
    L14:
        if (Result.m9455isFailureimpl(r105) == false) goto L16;
        r105 = null;
    L16:
        Uri r106 = (Uri) r105;
        if (r106 == null) goto L20;
        String r107 = UriProtector.getQueryParameter(r106, this.f170360e);
        if (r107 == null) goto L20;
        return r107;
    L20:
        String r108 = this.f170360e;
        Intrinsics.checkNotNullParameter(r108, "sessionKey");
        if (r101 == null) goto L23;
        Object r109 = r101.get(r108);
    L25:
        if ((r109 instanceof String) == true) goto L27;
        r109 = null;
    L27:
        String r110 = (String) r109;
        if (r110 != null) goto L30;
    L33:
        boolean r111 = true;
    L34:
        if (r111 == false) goto L53;
        if (r101 == null) goto L37;
        Object r112 = r101.get("pdp_event_transparent_id");
    L39:
        if ((r112 instanceof String) == false) goto L42;
        r102 = r112;
    L42:
        String r113 = (String) r102;
        if (MallTransparentTransformer.b(r113) == false) goto L53;
        String r114 = (String) MallTransparentTransformer.c(r113).get(r108);     // Catch: Throwable -> L49
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L47
        return r114;
    L47:
        Throwable th10 = th;
        r110 = r114;
    L51:
        Result.Companion r115 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th10));
    L49:
        th = move-exception;
        th10 = th;
        goto L51
    L37:
        r112 = null;
    L53:
        return r110;
    L30:
        if (r110.length() == 0) goto L33;
        r111 = false;
        goto L34
    L23:
        r109 = null;
        goto L25
    L6:
        if (r104.isHierarchical() == false) goto L8;
    L11:
        th = move-exception;
        Result.Companion r116 = Result.Companion;
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L14
    }
}
