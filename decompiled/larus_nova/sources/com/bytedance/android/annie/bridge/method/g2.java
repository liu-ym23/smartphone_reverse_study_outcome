package com.bytedance.android.annie.bridge.method;

import com.bytedance.android.annie.api.container.HybridDialog;
import com.bytedance.android.annie.container.dialog.BaseDialogFragment;
import com.bytedance.android.livesdkapi.app.AppConstants;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
@XBridgeMethod(biz = "webcast_sdk", name = AppConstants.BUNDLE_PULL_DOWN_HEIGHT)
public final class g2 extends com.bytedance.ies.web.jsbridge2.g<JSONObject, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HybridDialog f38656a;

    public g2(m16.b r100) {
        Intrinsics.checkNotNullParameter(r100, "providerFactory");
        HybridDialog r101 = (HybridDialog) r100.c(HybridDialog.class);
        if (r101 == null) goto L6;
        this.f38656a = r101;
        return;
    }

    public g2(HybridDialog r100) {
        Intrinsics.checkNotNullParameter(r100, "dialogFragment");
        this.f38656a = r100;
    }

    @Override // com.bytedance.ies.web.jsbridge2.g
    public final Object invoke(JSONObject r100, CallContext r101) {
        JSONObject r102 = r100;
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        JSONObject r103 = r102.optJSONObject("args");
        int r104 = 0;
        if (r103 == null) goto L5;
        r104 = r103.optInt(AppConstants.BUNDLE_PULL_DOWN_HEIGHT, 0);
    L5:
        HybridDialog r105 = this.f38656a;
        if ((r105 instanceof BaseDialogFragment) == false) goto L8;
        BaseDialogFragment r106 = (BaseDialogFragment) r105;
    L9:
        if (r106 == null) goto L11;
        com.bytedance.android.annie.scheme.helper.a.d(r106.f39242e, AppConstants.BUNDLE_PULL_DOWN_HEIGHT, Integer.valueOf(r104));
    L11:
        return null;
    L8:
        r106 = null;
        goto L9
    }
}
