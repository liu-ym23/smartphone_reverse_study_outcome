package com.bytedance.android.gamecp.hybrid_impl.jsb;

import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.JsonObject;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@XBridgeMethod(biz = "webcast", name = "game.unSubscribeResourceDownload")
public final class c6 extends r<j3, GameUnSubscribeResourceDownloadResultModel> {

    public static final class a {
    }

    static {
    }

    public c6() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r101) {
        j3 r102 = (j3) r100;
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        JsonObject r103 = r102.a();
        JsonObject r104 = r102.a();     // Catch: AssertionError -> L9
        if (r104 == null) goto L6;
        String r105 = r104.toString();     // Catch: AssertionError -> L9
    L7:
        yr.b.b(4, "RESOURCE_DOWNLOAD_UNREGISTER", String.valueOf(r105));     // Catch: AssertionError -> L9
    L11:
        if (r103 != null) goto L13;
        GameUnSubscribeResourceDownloadResultModel r106 = new GameUnSubscribeResourceDownloadResultModel();
        r106.a(GameUnSubscribeResourceDownloadResultModel.Code.Failed);
        Unit r107 = Unit.INSTANCE;
        finishWithResult(r106);
        return;
    L13:
        xr.f r108 = (xr.f) xr.s.a(xr.f.class);
        if (r108 == null) goto L16;
        r101.getContext();
        r108.v2(r103);
    L16:
        GameUnSubscribeResourceDownloadResultModel r109 = new GameUnSubscribeResourceDownloadResultModel();
        r109.a(GameUnSubscribeResourceDownloadResultModel.Code.Success);
        Unit r110 = Unit.INSTANCE;
        finishWithResult(r109);
        return;
    L6:
        r105 = null;
    L9:
        e = move-exception;
        yr.b.b(4, "RESOURCE_DOWNLOAD_UNREGISTER", String.valueOf(e.getMessage()));
        goto L11
    }
}
