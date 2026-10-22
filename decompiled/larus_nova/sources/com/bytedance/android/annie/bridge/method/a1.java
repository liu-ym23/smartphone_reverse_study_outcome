package com.bytedance.android.annie.bridge.method;

import com.bytedance.android.annie.Annie;
import com.bytedance.android.annie.bridge.method.abs.MakePhoneCallResultModel;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes43.dex */
@XBridgeMethod(biz = "webcast_sdk", name = "makePhoneCall")
public final class a1 extends e7.m<e7.m0, MakePhoneCallResultModel> {
    public a1() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r101) {
        e7.m0 r102 = (e7.m0) r100;
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (r101.getContext() != null) goto L6;
        MakePhoneCallResultModel r103 = new MakePhoneCallResultModel();
        r103.a(MakePhoneCallResultModel.Code.Failed);
        r103.b("Context not provided in host");
        finishWithResult(r103);
        return;
    L6:
        if (r102.a() != null) goto L8;
        MakePhoneCallResultModel r104 = new MakePhoneCallResultModel();
        r104.a(MakePhoneCallResultModel.Code.Failed);
        r104.b("phoneNumber is null");
        finishWithResult(r104);
        return;
    L8:
        String r105 = r102.a();
        Intrinsics.checkNotNull(r105);
        if (StringsKt.isBlank(r105) == false) goto L11;
        MakePhoneCallResultModel r106 = new MakePhoneCallResultModel();
        r106.a(MakePhoneCallResultModel.Code.Failed);
        r106.b("phoneNumber is  blank");
        finishWithResult(r106);
        return;
    L11:
        ((o9.b) Annie.getService(o9.b.class, r101.a())).q1(r102, r101.getContext(), new z0(this));
    }
}
