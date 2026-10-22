package com.bytedance.android.gamecp.hybrid_impl.jsb;

import com.bytedance.android.gamecp.common.utils.GsonMap;
import com.bytedance.android.gamecp.common.utils.ToastUtil;
import com.bytedance.android.gamecp.common.utils.UtilsKt;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.JsonObject;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes44.dex */
@XBridgeMethod(biz = "webcast", name = "openLiveMiniPlay")
public final class e5 extends q0<f5, OpenLiveMiniPlayResultModel> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f57496a = 0;

    public static final class a {
    }

    static {
    }

    public e5() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r101) {
        f5 r102 = (f5) r100;
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        String r103 = r102.a();
        JsonObject r104 = r102.b();
        if (r104 == null) goto L5;
        Lazy r105 = UtilsKt.f57195a;
        Intrinsics.checkNotNullParameter(r104, "$this$toMap");
        GsonMap r106 = new GsonMap(r104);
    L7:
        if (r103 != null) goto L9;
    L12:
        boolean r107 = true;
    L13:
        if (r107 == true) goto L19;
        if (r106 == null) goto L19;
        xr.f r108 = (xr.f) xr.s.a(xr.f.class);
        if (r108 == null) goto L21;
        r108.openLiveMiniPlay(r101.getContext(), r103, r106, new OpenLiveMiniPlayMethod$invoke$2(this), new OpenLiveMiniPlayMethod$invoke$3(this));
        return;
    L21:
        return;
    L19:
        ToastUtil.b("启动失败", 0);
        yr.b.b(4, "OpenLiveMiniPlayMethod", r103 + " -> " + r106);
        OpenLiveMiniPlayResultModel r109 = new OpenLiveMiniPlayResultModel();
        r109.a(OpenLiveMiniPlayResultModel.Code.Failed);
        Unit r110 = Unit.INSTANCE;
        finishWithResult(r109);
        return;
    L9:
        if (StringsKt.isBlank(r103) == true) goto L12;
        r107 = false;
        goto L13
    L5:
        r106 = null;
        goto L7
    }
}
