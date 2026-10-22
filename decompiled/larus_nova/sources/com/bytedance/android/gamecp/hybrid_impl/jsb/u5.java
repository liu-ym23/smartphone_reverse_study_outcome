package com.bytedance.android.gamecp.hybrid_impl.jsb;

import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
@XBridgeMethod(biz = "webcast", name = "game.registerGameResourceDownload")
public final class u5 extends q<h3, GameRegisterGameResourceDownloadResultModel> {

    public static final class a {
    }

    static {
    }

    public u5() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r110) {
        h3 r101 = (h3) r100;
        Intrinsics.checkNotNullParameter(r101, "params");
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        yr.b.b(3, "RESOURCE_DOWNLOAD_REGISTER", GsonProtectorUtils.toJson(new Gson(), r101));
        if (r101.a() != null) goto L5;
        yr.b.b(6, "RESOURCE_DOWNLOAD_REGISTER", "下载信息参数不能为空");
        GameRegisterGameResourceDownloadResultModel r102 = new GameRegisterGameResourceDownloadResultModel();
        r102.a(GameRegisterGameResourceDownloadResultModel.Code.Failed);
        Unit r103 = Unit.INSTANCE;
        finishWithResult(r102);
    L5:
        xr.f r104 = (xr.f) xr.s.a(xr.f.class);
        if (r104 != null) goto L8;
        yr.b.b(6, "RESOURCE_DOWNLOAD_REGISTER", "联运服务未初始化完成 " + r101);
        GameRegisterGameResourceDownloadResultModel r105 = new GameRegisterGameResourceDownloadResultModel();
        r105.a(GameRegisterGameResourceDownloadResultModel.Code.Failed);
        Unit r111 = Unit.INSTANCE;
        finishWithResult(r105);
        return;
    L8:
        JsonObject r106 = r101.a();
        Object r107 = null;
        if (r106 == null) goto L11;
        JsonElement r108 = r106.get("token");
    L36:
        Result.Companion r109 = Result.Companion;     // Catch: Throwable -> L18
        if (r108 == null) goto L15;
        String r112 = r108.getAsString();     // Catch: Throwable -> L18
    L16:
        Object r113 = Result.m9449constructorimpl(r112);     // Catch: Throwable -> L18
    L21:
        if (Result.m9455isFailureimpl(r113) == true) goto L24;
        r107 = r113;
    L24:
        String r114 = (String) r107;
        if (r114 != null) goto L27;
        r114 = "";
    L27:
        Integer r115 = StringsKt.toIntOrNull(r114);
        if (r115 == null) goto L30;
        int r116 = r115.intValue();
    L34:
        r110.getContext();
        JsonObject r117 = r101.a();
        Intrinsics.checkNotNull(r117);
        r104.T(r117, new v5(this, r116));
        yr.b.b(3, "RESOURCE_DOWNLOAD_REGISTER", "注册监听并获取 token =" + r116 + ' ');
        GameRegisterGameResourceDownloadResultModel r118 = new GameRegisterGameResourceDownloadResultModel();
        r118.a(GameRegisterGameResourceDownloadResultModel.Code.Success);
        GameRegisterGameResourceDownloadResultModel.a r119 = new GameRegisterGameResourceDownloadResultModel.a();
        r119.a(Integer.valueOf(r116));
        Unit r120 = Unit.INSTANCE;
        r118.b(r119);
        finishWithResult(r118);
        return;
    L30:
        int r121 = r104.genDownloadToken();
        if (r106 == null) goto L33;
        r106.addProperty("token", Integer.valueOf(r121));
    L33:
        r116 = r121;
        goto L34
    L15:
        r112 = null;
    L18:
        th = move-exception;
        Result.Companion r122 = Result.Companion;
        r113 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L21
    L11:
        r108 = null;
        goto L36
    }

    public static void j(int r100, int r101, int r102, int r103) {
        JSONObject r104 = new JSONObject();
        r104.put("download_status", r100);
        r104.put("token", r101);
        r104.put("process", r102);
        r104.put("errorCode", r103);
        jw.c r105 = (jw.c) xr.s.a(jw.c.class);
        if (r105 == null) goto L6;
        r105.sendEventToAllJsBridges("game.notifyResourceDownloadStatus", r104);
        return;
    }

    public static /* synthetic */ void k(u5 r100, int r101, int r102, int r103, int r104) {
        if ((r104 & 2) == 0) goto L6;
        r102 = 0;
    L6:
        if ((r104 & 4) == 0) goto L8;
        r103 = 0;
    L8:
        r100.getClass();
        j(r101, r102, r103, 0);
    }
}
