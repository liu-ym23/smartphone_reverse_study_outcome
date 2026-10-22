package com.bytedance.android.gamecp.hybrid_impl.jsb;

import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.JsonObject;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@XBridgeMethod(biz = "webcast", name = "game.performGameResourceDownloadAction")
public final class j5 extends m<w2, GamePerformGameResourceDownloadActionResultModel> {

    public static final class a {
    }

    static {
    }

    public j5() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r101) {
        w2 r102 = (w2) r100;
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        JsonObject r103 = r102.a();
        JsonObject r104 = r102.a();     // Catch: AssertionError -> L9
        if (r104 == null) goto L6;
        String r105 = r104.toString();     // Catch: AssertionError -> L9
    L7:
        yr.b.b(4, "RESOURCE_DOWNLOAD_ACTION", String.valueOf(r105));     // Catch: AssertionError -> L9
    L11:
        if (r103 != null) goto L13;
        GamePerformGameResourceDownloadActionResultModel r106 = new GamePerformGameResourceDownloadActionResultModel();
        r106.a(GamePerformGameResourceDownloadActionResultModel.Code.Failed);
        GamePerformGameResourceDownloadActionResultModel.a r107 = new GamePerformGameResourceDownloadActionResultModel.a();
        r107.a(-1);
        r107.b("invalid arguments ");
        Unit r108 = Unit.INSTANCE;
        r106.b(r107);
        finishWithResult(r106);
        return;
    L13:
        xr.f r109 = (xr.f) xr.s.a(xr.f.class);
        if (r109 == null) goto L16;
        r109.q0(r101.getContext(), r103, new k5(this));
        return;
    L16:
        yr.b.b(4, "RESOURCE_DOWNLOAD_ACTION", "performGameResourceDownloadAction service not find.");
        GamePerformGameResourceDownloadActionResultModel r110 = new GamePerformGameResourceDownloadActionResultModel();
        r110.a(GamePerformGameResourceDownloadActionResultModel.Code.Failed);
        GamePerformGameResourceDownloadActionResultModel.a r111 = new GamePerformGameResourceDownloadActionResultModel.a();
        r111.a(10003);
        Unit r112 = Unit.INSTANCE;
        r110.b(r111);
        finishWithResult(r110);
        return;
    L6:
        r105 = null;
    L9:
        e = move-exception;
        yr.b.b(4, "RESOURCE_DOWNLOAD_ACTION", String.valueOf(e.getMessage()));
        goto L11
    }
}
