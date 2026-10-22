package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.live.base.model.UrlModel;
import com.bytedance.android.livesdkapi.business.ILiveDouPlusService;
import com.bytedance.common.utility.Logger;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import w20.je;
import w20.ke;

/* JADX INFO: loaded from: classes45.dex */
@XBridgeMethod(biz = "webcast", name = "sendThirdTrack")
public final class zb extends w20.d6<je, ke> {
    public zb() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r101) {
        je r102 = (je) r100;
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        String r103 = r102.a();
        if (r103 != null) goto L5;
    L8:
        boolean r104 = true;
    L9:
        if (r104 == true) goto L22;
        ILiveDouPlusService r105 = (ILiveDouPlusService) jc1.k.n(ILiveDouPlusService.class);     // Catch: Exception -> L17
        String r106 = r102.c();     // Catch: Exception -> L17
        UrlModel r107 = new UrlModel();     // Catch: Exception -> L17
        r107.setUrlList(r102.d());     // Catch: Exception -> L17
        Unit r108 = Unit.INSTANCE;     // Catch: Exception -> L17
        String r109 = r102.a();     // Catch: Exception -> L17
        if (r109 == null) goto L14;
        long r110 = CastLongProtector.parseLong(r109);     // Catch: Exception -> L17
    L15:
        r105.sendThirdTrack(r106, r107, Long.valueOf(r110), r102.b());     // Catch: Exception -> L17
        return;
    L14:
        r110 = 0;
    L17:
        e = move-exception;
        Logger.e("SendThirdTrackMethod", String.valueOf(e.getMessage()));
        return;
    L22:
        return;
    L5:
        if (r103.length() == 0) goto L8;
        r104 = false;
        goto L9
    }
}
