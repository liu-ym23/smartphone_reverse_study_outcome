package com.bytedance.android.live.browser.jsbridge.newmethods;

import android.app.Activity;
import android.content.Context;
import com.bytedance.android.livehostapi.business.IHostShare;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@XBridgeMethod(biz = "webcast", name = "live.publishVSMessageBoardStory")
public final class t6 extends j<u6, v6> {
    public t6() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r110, CallContext r111) {
        u6 r112 = (u6) r110;
        Intrinsics.checkNotNullParameter(r112, "params");
        Intrinsics.checkNotNullParameter(r111, PerfLog.PARAM_KEY_CONTEXT_ID);
        Context r113 = r111.getContext();
        if ((r113 instanceof Activity) == true) goto L5;
        r113 = null;
    L5:
        Activity r100 = (Activity) r113;
        if (r100 != null) goto L8;
        v6 r114 = new v6();
        r114.a(-1001);
        r114.b("context is not activity");
        Unit r115 = Unit.INSTANCE;
        finishWithResult(r114);
        return;
    L8:
        String r116 = r112.a();
        if (r116 == null) goto L43;
        boolean r101 = false;
        if (r116.length() <= 0) goto L13;
        boolean r102 = true;
    L14:
        if (r102 == false) goto L16;
        String r103 = r116;
    L17:
        if (r103 == null) goto L43;
        String r117 = r112.b();
        if (r117 != null) goto L22;
    L42:
        v6 r118 = new v6();
        r118.a(-1003);
        r118.b("shootWay is null or empty");
        Unit r119 = Unit.INSTANCE;
        finishWithResult(r118);
        return;
    L22:
        if (r117.length() <= 0) goto L24;
        boolean r104 = true;
    L25:
        if (r104 == false) goto L27;
        String r105 = r117;
    L28:
        if (r105 == null) goto L42;
        String r120 = r112.b();
        if (r120 != null) goto L33;
    L41:
        v6 r121 = new v6();
        r121.a(-1004);
        r121.b("enterFrom is null or empty");
        Unit r122 = Unit.INSTANCE;
        finishWithResult(r121);
        return;
    L33:
        if (r120.length() <= 0) goto L35;
        r101 = true;
    L35:
        if (r101 == false) goto L37;
        String r106 = r120;
    L38:
        if (r106 == null) goto L41;
        ((IHostShare) jc1.k.n(IHostShare.class)).publishToStory(r100, r112.c(), r103, r105, r106, null);
        finishWithSuccess();
        return;
    L37:
        r106 = null;
        goto L38
    L27:
        r105 = null;
        goto L28
    L24:
        r104 = false;
        goto L25
    L16:
        r103 = null;
        goto L17
    L13:
        r102 = false;
    L43:
        v6 r123 = new v6();
        r123.a(-1002);
        r123.b("content is null or empty");
        Unit r124 = Unit.INSTANCE;
        finishWithResult(r123);
    }
}
