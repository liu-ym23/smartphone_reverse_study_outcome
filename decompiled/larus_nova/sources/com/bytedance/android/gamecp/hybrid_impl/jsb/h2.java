package com.bytedance.android.gamecp.hybrid_impl.jsb;

import com.bytedance.android.gamecp.common.utils.ToastUtil;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes44.dex */
@XBridgeMethod(biz = "webcast", name = "openInteractGame")
public final class h2 extends p0<d5, OpenInteractGameResultModel> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f57511a = 0;

    public static final class a {
    }

    static {
    }

    public h2() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r110) {
        d5 r101 = (d5) r100;
        Intrinsics.checkNotNullParameter(r101, "params");
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        n1.a("openInteractGame", GsonProtectorUtils.toJson(new Gson(), r101));
        String r102 = r101.b();
        JsonObject r103 = r101.a();
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L5
        Object r105 = Result.m9449constructorimpl((Map) com.bytedance.android.gamecp.common.utils.e0.f(com.bytedance.android.gamecp.common.utils.e0.h(r101.a()), new i2().getType()));     // Catch: Throwable -> L5
    L7:
        Throwable r106 = Result.m9452exceptionOrNullimpl(r105);
        if (r106 == null) goto L11;
        yr.b.b(4, "OpenLiveMiniPlayMethod", "onFailure:" + r106.getMessage());
    L11:
        if (Result.m9455isFailureimpl(r105) == false) goto L13;
        r105 = null;
    L13:
        Map<String, ? extends Object> r107 = (Map) r105;
        if (r102 != null) goto L16;
    L19:
        boolean r108 = true;
    L20:
        if (r108 == true) goto L28;
        if (r107 == null) goto L28;
        xr.f r109 = (xr.f) xr.s.a(xr.f.class);
        if (r109 == null) goto L32;
        xr.h r111 = r109.getGameService();
        if (r111 == null) goto L33;
        r111.openLiveMiniPlay(r110.getContext(), r102, r107, new GameCpOpenInteractGameMethod$invoke$2(this), new GameCpOpenInteractGameMethod$invoke$3(this));
        return;
    L33:
        return;
    L32:
        return;
    L28:
        ToastUtil.b("启动失败", 0);
        yr.b.b(4, "OpenLiveMiniPlayMethod", r102 + " -> " + r103);
        OpenInteractGameResultModel r112 = new OpenInteractGameResultModel();
        r112.a(OpenInteractGameResultModel.Code.Failed);
        Unit r113 = Unit.INSTANCE;
        finishWithResult(r112);
        return;
    L16:
        if (StringsKt.isBlank(r102) == true) goto L19;
        r108 = false;
    L5:
        th = move-exception;
        Result.Companion r114 = Result.Companion;
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    }
}
