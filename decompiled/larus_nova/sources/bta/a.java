package bta;

import android.app.Activity;
import com.bytedance.sdk.bridge.model.BridgeResult;
import com.ss.android.bytedcert.flow.cert.BytedCertFlow;
import com.ss.android.cert.manager.utils.CertLog;
import com.ss.android.cert.manager.web.jsb.IBridgeContext;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
public final class a implements IBridgeContext {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.sdk.bridge.model.IBridgeContext f20703a;

    @Override // com.ss.android.cert.manager.web.jsb.IBridgeContext
    public Activity getActivity() {
        return this.f20703a.getActivity();
    }

    public a(com.bytedance.sdk.bridge.model.IBridgeContext r100) {
        this.f20703a = r100;
    }

    @Override // com.ss.android.cert.manager.web.jsb.IBridgeContext
    public final void onSuccess(JSONObject r100) {
        if (r100 != null) goto L5;
        CertLog.d(BytedCertFlow.TAG, "jsb on success");
        this.f20703a.callback(BridgeResult.Companion.createSuccessResult());
        return;
    L5:
        CertLog.d(BytedCertFlow.TAG, "jsb on success:" + r100);
        this.f20703a.callback(BridgeResult.Companion.createSuccessResult(r100));
    }

    @Override // com.ss.android.cert.manager.web.jsb.IBridgeContext
    public final void onError(String r100, JSONObject r101) {
        CertLog.d(BytedCertFlow.TAG, "jsb on error");
        this.f20703a.callback(BridgeResult.Companion.createErrorResult(r100, r101));
    }
}
