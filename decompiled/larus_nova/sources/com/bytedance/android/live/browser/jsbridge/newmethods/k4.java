package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.annie.bridge.method.abs.GetDownloadGiftAssetsResultModel;
import com.bytedance.android.live.gift.IGiftService;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class k4 extends e7.h<e7.h0, GetDownloadGiftAssetsResultModel> {

    public static final class a {
    }

    static {
    }

    public k4() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r101) {
        e7.h0 r102 = (e7.h0) r100;
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        ((IGiftService) jc1.k.n(IGiftService.class)).initGiftResourceManager(com.bytedance.android.live.core.utils.s1.getContext());     // Catch: Exception -> L19
        Integer r103 = r102.b();
        if (r103 != null) goto L8;
    L10:
        int r104 = 1007;
    L11:
        IGiftService r105 = (IGiftService) jc1.k.n(IGiftService.class);
        String r106 = r102.c();
        if (r106 != null) goto L14;
        r106 = "JSB";
    L14:
        String r107 = r106;
        Integer r108 = r102.a();
        if (r108 == null) goto L17;
        long r109 = r108.intValue();
    L18:
        r105.downloadAssets(r107, r109, new l4(this), r104);
        return;
    L17:
        r109 = 0;
        goto L18
    L8:
        if (r103.intValue() != 0) goto L10;
        r104 = 1008;
    L19:
        e = move-exception;
        finishWithFailure(e);
    }
}
