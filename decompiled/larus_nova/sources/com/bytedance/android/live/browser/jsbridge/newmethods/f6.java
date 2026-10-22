package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.live.browser.jsbridge.base.LiveGetLiveEffectInfoResultModel;
import com.bytedance.android.live.effect.api.LiveEffectContext;
import com.bytedance.android.live.effect.api.LiveEffectContextFactoryDelegate$Type;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.effectmanager.EffectManager;
import java.util.List;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@XBridgeMethod(biz = "webcast", name = "live.getLiveEffectInfo")
public final class f6 extends w20.v2<w20.sa, LiveGetLiveEffectInfoResultModel> {
    public f6() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r101) {
        w20.sa r102 = (w20.sa) r100;
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        List<String> r103 = r102.a();
        boolean r104 = false;
        if (r103 != null) goto L5;
    L8:
        boolean r105 = true;
    L9:
        if (r105 == false) goto L18;
        List<String> r106 = r102.b();
        if (r106 != null) goto L13;
    L14:
        r104 = true;
    L15:
        if (r104 == false) goto L17;
        finishWithFailure();
        return;
    L17:
        List<String> r107 = LiveEffectContext.f66734h;
        EffectManager r108 = LiveEffectContext.a.a(LiveEffectContextFactoryDelegate$Type.DEFAULT).d();
        List<String> r109 = r102.b();
        Intrinsics.checkNotNull(r109);
        r108.fetchEffectList(r109, MapsKt.mapOf(TuplesKt.to("panel", r102.c())), new e6(this));
        return;
    L13:
        if (r106.isEmpty() == false) goto L15;
    L18:
        List<String> r110 = LiveEffectContext.f66734h;
        LiveEffectContext.a.a(LiveEffectContextFactoryDelegate$Type.DEFAULT).d().fetchEffectList2(r102.a(), null, new d6(this));
        return;
    L5:
        if (r103.isEmpty() == true) goto L8;
        r105 = false;
        goto L9
    }
}
