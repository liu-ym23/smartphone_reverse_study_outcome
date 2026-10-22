package com.bytedance.android.gamecp.hybrid_impl.jsb;

import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@XBridgeMethod(biz = "webcast", name = "forceUpdateOrientation")
public final class a2 extends e<o1, ForceUpdateOrientationResultModel> {

    public static final class a {
    }

    static {
    }

    public a2() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r101) {
        o1 r102 = (o1) r100;
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (r102.a() == null) goto L30;
        Integer r103 = r102.a();
        if (r103 != null) goto L8;
    L9:
        Integer r104 = r102.a();
        if (r104 == null) goto L30;
        if (r104.intValue() != 2) goto L30;
    L15:
        boolean r105 = !com.bytedance.android.gamecp.common.utils.p0.a();
        if (r105 == true) goto L22;
        Integer r106 = r102.a();
        if (r106 == null) goto L22;
        if (r106.intValue() != 2) goto L22;
    L28:
        ForceUpdateOrientationResultModel r107 = new ForceUpdateOrientationResultModel();
        r107.a(ForceUpdateOrientationResultModel.Code.Success);
        Unit r108 = Unit.INSTANCE;
        finishWithResult(r107);
        return;
    L22:
        if (r105 == false) goto L29;
        Integer r109 = r102.a();
        if (r109 == null) goto L29;
        if (r109.intValue() == 1) goto L28;
    L29:
        bw.i r110 = com.bytedance.android.gamecp.host_api.a.b().getLiveService();
        Integer r111 = r102.a();
        Intrinsics.checkNotNull(r111);
        r111.intValue();
        r110.Q();
        ForceUpdateOrientationResultModel r112 = new ForceUpdateOrientationResultModel();
        r112.a(ForceUpdateOrientationResultModel.Code.Success);
        Unit r113 = Unit.INSTANCE;
        finishWithResult(r112);
        return;
    L8:
        if (r103.intValue() == 1) goto L15;
    L30:
        ForceUpdateOrientationResultModel r114 = new ForceUpdateOrientationResultModel();
        r114.a(ForceUpdateOrientationResultModel.Code.Success);
        Unit r115 = Unit.INSTANCE;
        finishWithResult(r114);
    }
}
