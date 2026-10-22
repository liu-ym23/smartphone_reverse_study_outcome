package com.bytedance.android.live.browser.jsbridge.newmethods;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.android.live.browser.jsbridge.base.ImageToastResultModel;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@XBridgeMethod(biz = "webcast", name = "imageToast")
public final class m5 extends w20.d2<w20.ba, ImageToastResultModel> {
    public m5() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r101) {
        w20.ba r102 = (w20.ba) r100;
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        String r103 = r102.a();
        String r104 = r102.c();
        String r105 = "";
        if (r104 != null) goto L5;
        r104 = "";
    L5:
        String r106 = r102.b();
        if (r106 == null) goto L10;
        r105 = r106;
    L10:
        if (TextUtils.isEmpty(r103) == false) goto L14;
        Context r107 = r101.getContext();
        if (r107 == null) goto L18;
        com.bytedance.android.live.core.utils.f2.e(r107, null, r104, r105);
        return;
    L18:
        return;
    L14:
        Context r108 = r101.getContext();
        if (r108 == null) goto L20;
        com.bytedance.android.live.core.utils.f2.e(r108, r103, r104, r105);
        return;
    }
}
