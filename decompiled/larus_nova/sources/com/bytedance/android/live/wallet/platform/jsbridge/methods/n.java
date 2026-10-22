package com.bytedance.android.live.wallet.platform.jsbridge.methods;

import android.app.Activity;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.android.live.revenue.common.v;
import com.bytedance.android.live.wallet.platform.business.verify.u;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.annotations.SerializedName;
import io.reactivex.disposables.Disposable;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
@XBridgeMethod(biz = "webcast", name = "withdrawVerify")
public final class n extends com.bytedance.ies.web.jsbridge2.f<a, JSONObject> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Activity f102760a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Disposable f102761b;

    public static class a {

        @SerializedName("type")
        List<String> checkList;

        @SerializedName("tag")
        String tag;

        public a() {
        }
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
        Disposable r100 = this.f102761b;
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.isDisposed() == true) goto L9;
        this.f102761b.dispose();
        return;
    }

    public n() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(a r100, CallContext r101) throws Exception {
        a r102 = r100;
        Activity r103 = ContextUtil.contextToActivity(r101.getContext());
        this.f102760a = r103;
        if (r103 != null) goto L5;
        int r104 = v.f91009a;
        v.e("VerifyZhimaCreditMethod", "activity is null");
        finishWithFailure();
        return;
    L5:
        Disposable r105 = this.f102761b;
        if (r105 != null) goto L8;
    L10:
        List<String> r106 = r102.checkList;
        JSONObject r107 = new JSONObject();
        this.f102761b = u.a(this.f102760a, r102.tag, r106).subscribe(new l(this, r107), new m(this));
        return;
    L8:
        if (r105.isDisposed() == true) goto L10;
        this.f102761b.dispose();
        goto L10
    }
}
