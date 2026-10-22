package com.bytedance.android.livesdk.jsbridge.methods;

import com.bytedance.android.live.browser.jsbridge.base.LiveRunAiServiceResultModel;
import com.bytedance.android.livesdkapi.ai.callback.IAiCallback;
import com.bytedance.common.utility.Logger;
import com.google.gson.JsonObject;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes9.dex */
public final class i1 implements IAiCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ j1 f142137a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ LiveRunAiServiceResultModel f142138b;

    @Override // com.bytedance.android.livesdkapi.ai.callback.IAiCallback
    public final void onCompleted(JSONObject r100) {
        this.f142137a.getClass();
        String r101 = null;
        j1.j("ai result", null);
        this.f142138b.c(LiveRunAiServiceResultModel.Code.Success);
        LiveRunAiServiceResultModel r102 = this.f142138b;
        if (r100 == null) goto L7;
        JSONObject r103 = r100.optJSONObject("result");
        if (r103 == null) goto L7;
        JsonObject r104 = this.f142137a.l(r103);
    L8:
        r102.setResult(r104);
        LiveRunAiServiceResultModel r105 = this.f142138b;
        if (r100 == null) goto L11;
        Integer r106 = Integer.valueOf(r100.optInt("result_code"));
    L12:
        r105.e(r106);
        if (Intrinsics.areEqual(this.f142138b.b(), 0) == false) goto L15;
        this.f142137a.getClass();
        j1.j("ai success", null);
    L21:
        LiveRunAiServiceResultModel r107 = this.f142138b;
        if (r100 == null) goto L24;
        r101 = r100.optString("error_msg");
    L24:
        r107.d(r101);
        this.f142137a.finishWithResult(this.f142138b);
        Logger.d(this.f142137a.f142144a, "onCompleted: code=" + this.f142138b.a() + ", result=" + r100);
        return;
    L15:
        j1 r108 = this.f142137a;
        if (r100 == null) goto L19;
        String r109 = r100.optString("error_msg");
        if (r109 == null) goto L19;
    L20:
        r108.getClass();
        j1.j("ai fail", r109);
    L19:
        r109 = "";
        goto L20
    L11:
        r106 = null;
    L7:
        r104 = null;
        goto L8
    }

    public i1(j1 r100, LiveRunAiServiceResultModel r101) {
        this.f142137a = r100;
        this.f142138b = r101;
    }
}
