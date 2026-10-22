package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.live.browser.jsbridge.base.MuteLiveRoomResultModel;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@XBridgeMethod(biz = "webcast", name = "muteLiveRoom")
public final class b8 extends w20.z3<w20.vb, MuteLiveRoomResultModel> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.android.live.browser.webview.fragment.m f63318a;

    public b8(m16.b r100) {
        Intrinsics.checkNotNullParameter(r100, "contextProviderFactory");
        this.f63318a = (com.bytedance.android.live.browser.webview.fragment.m) r100.c(com.bytedance.android.live.browser.webview.fragment.m.class);
    }

    public b8(com.bytedance.android.live.browser.webview.fragment.m r100) {
        Intrinsics.checkNotNullParameter(r100, "control");
        this.f63318a = r100;
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r101) {
        w20.vb r102 = (w20.vb) r100;
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (r102.b() != null) goto L5;
        MuteLiveRoomResultModel r103 = new MuteLiveRoomResultModel();
        r103.a(MuteLiveRoomResultModel.Code.Failed);
        Unit r104 = Unit.INSTANCE;
        finishWithResult(r103);
        return;
    L5:
        com.bytedance.android.live.browser.webview.fragment.m r105 = this.f63318a;
        if (r105 == null) goto L15;
        Boolean r106 = r102.b();
        boolean r107 = false;
        if (r106 == null) goto L10;
        boolean r108 = r106.booleanValue();
    L11:
        Boolean r109 = r102.a();
        if (r109 == null) goto L14;
        r107 = r109.booleanValue();
    L14:
        r105.setMuteStatus(r108, r107);
        goto L15
    L10:
        r108 = false;
    L15:
        MuteLiveRoomResultModel r110 = new MuteLiveRoomResultModel();
        r110.a(MuteLiveRoomResultModel.Code.Success);
        Unit r111 = Unit.INSTANCE;
        finishWithResult(r110);
    }
}
