package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.live.browser.jsbridge.base.LiveOpenLiveEffectSelectPanelResultModel;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@XBridgeMethod(biz = "webcast", name = "live.openLiveEffectSelectPanel")
public final class s6 extends w20.c3<w20.wa, LiveOpenLiveEffectSelectPanelResultModel> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<String> f63646a;

    public s6() {
        this.f63646a = CollectionsKt.listOf("zongyiyouxi");
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r101) {
        w20.wa r102 = (w20.wa) r100;
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (r102.b() != null) goto L5;
    L18:
        finishWithFailure();
        return;
    L5:
        if (CollectionsKt.contains(this.f63646a, r102.b()) == false) goto L18;
        xs2.b r103 = xs2.b.a();
        String r104 = r102.b();
        String r105 = "";
        if (r104 != null) goto L10;
        r104 = "";
    L10:
        String r106 = r102.a();
        if (r106 != null) goto L13;
        r106 = "";
    L13:
        String r107 = r102.c();
        if (r107 == null) goto L17;
        r105 = r107;
    L17:
        r103.post(new zg1.d2(r104, r106, r105, new r6(this)));
    }
}
