package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.live.base.abtest.ClientABTestKey;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@XBridgeMethod(biz = "webcast", name = "exposeAccurateExperiment")
public final class v2 extends c<w2, ExposeAccurateExperimentResultModel> {
    public v2() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r101) {
        w2 r102 = (w2) r100;
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (r102.c() != null) goto L5;
        ExposeAccurateExperimentResultModel r103 = new ExposeAccurateExperimentResultModel();
        r103.a(ExposeAccurateExperimentResultModel.Code.Failed);
        r103.c("key未定义");
        Unit r104 = Unit.INSTANCE;
        finishWithResult(r103);
        return;
    L5:
        String r105 = com.bytedance.android.livesdk.config.q9.f121036a.getValue().get(r102.c());
        if (r105 != null) goto L8;
        ExposeAccurateExperimentResultModel r106 = new ExposeAccurateExperimentResultModel();
        r106.a(ExposeAccurateExperimentResultModel.Code.Failed);
        r106.c("不能映射精准实验key，请去https://cloud.bytedance.net/dolphin/cn/bizline/45/group/1246891/rules进行配置");
        Unit r107 = Unit.INSTANCE;
        finishWithResult(r106);
        return;
    L8:
        Class r108 = Integer.TYPE;
        String r109 = r102.a();
        boolean r110 = false;
        if (r109 == null) goto L11;
        int r111 = CastIntegerProtector.parseInt(r109);
    L12:
        Integer r112 = Integer.valueOf(r111);
        Boolean r113 = r102.d();
        if (r113 == null) goto L15;
        r113.booleanValue();
    L15:
        ClientABTestKey r114 = new ClientABTestKey(r105, r108, r112, 1);
        com.bytedance.android.live.base.abtest.b.a r115 = com.bytedance.android.live.base.abtest.b.f58812b;
        Boolean r116 = r102.b();
        if (r116 == null) goto L18;
        r110 = r116.booleanValue();
    L18:
        r115.getClass();
        Integer r117 = (Integer) com.bytedance.android.live.base.abtest.b.a.b(r114, r110);
        ExposeAccurateExperimentResultModel r118 = new ExposeAccurateExperimentResultModel();
        r118.a(ExposeAccurateExperimentResultModel.Code.Success);
        ExposeAccurateExperimentResultModel.a r119 = new ExposeAccurateExperimentResultModel.a();
        if (r117 != null) goto L22;
    L24:
        String r120 = String.valueOf(r117.intValue());
    L25:
        r119.a(r120);
        Unit r121 = Unit.INSTANCE;
        r118.b(r119);
        finishWithResult(r118);
        return;
    L22:
        if (r117.intValue() != 9999) goto L24;
        r120 = r102.a();
        goto L25
    L11:
        r111 = 0;
        goto L12
    }
}
