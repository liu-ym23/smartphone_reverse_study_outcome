package com.bytedance.android.gamecp.hybrid_impl.jsb;

import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
public final class q2 implements com.bytedance.android.gamecp.base.core.service.depend.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ p2 f57530a;

    public q2(p2 r100) {
        this.f57530a = r100;
    }

    @Override // com.bytedance.android.gamecp.base.core.service.depend.c
    public final void onResult(JSONObject r100) {
        p2 r101 = this.f57530a;
        GameGetDownloadListResultModel r102 = new GameGetDownloadListResultModel();
        r102.a(GameGetDownloadListResultModel.Code.Success);
        GameGetDownloadListResultModel.a r103 = new GameGetDownloadListResultModel.a();
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L5
        r103.setResult(r100.toString());     // Catch: Throwable -> L5
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L7:
        Unit r105 = Unit.INSTANCE;
        r102.b(r103);
        r101.finishWithResult(r102);
        return;
    L5:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    }
}
