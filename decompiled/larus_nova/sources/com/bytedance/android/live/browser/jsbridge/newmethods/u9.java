package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.livehostapi.platform.depend.IPopTuringVerifyCallback;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
public final class u9 implements IPopTuringVerifyCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ t9 f63684a;

    public u9(t9 r100) {
        this.f63684a = r100;
    }

    @Override // com.bytedance.android.livehostapi.platform.depend.IPopTuringVerifyCallback
    public final void onFail(int r100, JSONObject r101) {
        if (r100 != (-1)) goto L6;
        this.f63684a.finishWithFailure();
        return;
    L6:
        JSONObject r102 = new JSONObject();
        r102.put("code", r100);
        r102.put("success", false);
        this.f63684a.finishWithResult(r102);
    }

    @Override // com.bytedance.android.livehostapi.platform.depend.IPopTuringVerifyCallback
    public final void onSuccess(int r100, JSONObject r101) {
        JSONObject r102 = new JSONObject();
        r102.put("code", r100);
        r102.put("success", true);
        this.f63684a.finishWithResult(r102);
    }
}
