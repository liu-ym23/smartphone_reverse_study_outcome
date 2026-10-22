package com.bytedance.android.annie.bridge.method;

import com.bytedance.android.annie.Annie;
import com.bytedance.android.annie.bridge.ShowModalResultModel;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@XBridgeMethod(biz = "webcast_sdk", name = "showModal")
public final class m2 extends com.bytedance.android.annie.bridge.e<com.bytedance.android.annie.bridge.t, ShowModalResultModel> {
    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
    }

    public m2() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r110, CallContext r111) {
        com.bytedance.android.annie.bridge.t r112 = (com.bytedance.android.annie.bridge.t) r110;
        Intrinsics.checkNotNullParameter(r112, "params");
        Intrinsics.checkNotNullParameter(r111, PerfLog.PARAM_KEY_CONTEXT_ID);
        Boolean r113 = r112.e();
        String r100 = r112.b();
        boolean r101 = false;
        if (r100 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == true) goto L11;
        String r103 = r112.b();
    L12:
        String r104 = r103;
        String r105 = r112.c();
        String r106 = r112.f();
        l2 r107 = new l2(this);
        Boolean r108 = r112.d();
        Boolean r109 = Boolean.TRUE;
        if (Intrinsics.areEqual(r108, r109) == false) goto L23;
        String r114 = r112.a();
        if (r114 != null) goto L17;
    L18:
        r101 = true;
    L19:
        if (r101 == true) goto L21;
        String r115 = r112.a();
    L22:
        j2 r116 = new j2(this);
    L25:
        if (Intrinsics.areEqual(r113, r109) == false) goto L27;
        k2 r117 = new k2(this);
    L28:
        ((a9.h) Annie.getService$default(a9.h.class, null, 2, null)).B0(new b1(r111.getContext(), r106, r105, r104, r107, r115, r116, r117, r113));
        return;
    L27:
        r117 = null;
        goto L28
    L21:
        r115 = "cancel";
        goto L22
    L17:
        if (r114.length() != 0) goto L19;
    L23:
        r115 = null;
        r116 = null;
        goto L25
    L11:
        r103 = "confirm";
        goto L12
    L5:
        if (r100.length() == 0) goto L8;
        r102 = false;
        goto L9
    }
}
