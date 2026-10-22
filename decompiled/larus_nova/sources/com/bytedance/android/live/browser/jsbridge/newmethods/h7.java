package com.bytedance.android.live.browser.jsbridge.newmethods;

import android.os.Bundle;
import com.bytedance.android.live.browser.jsbridge.base.LiveTaskOperationResultModel;
import com.bytedance.ies.utility.SharedPrefHelper;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@XBridgeMethod(biz = "webcast", name = "liveTaskOperation")
public final class h7 extends w20.n3<w20.ib, LiveTaskOperationResultModel> {
    public h7() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r101) {
        w20.ib r102 = (w20.ib) r100;
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        zg1.h1 r103 = new zg1.h1(6);
        Integer r104 = r102.a();
        if (r104 != null) goto L6;
    L11:
        if (r104 != null) goto L14;
    L19:
        if (r104 != null) goto L22;
        return;
    L22:
        if (r104.intValue() != 3) goto L27;
        SharedPrefHelper r105 = SharedPrefHelper.b(r101.getContext());
        r105.l("live.pref.SHOW_COIN_TASK_POPUP_COUNTS", Integer.valueOf(r105.h("live.pref.SHOW_COIN_TASK_POPUP_COUNTS", 0) + 1));
        r105.a();
        Bundle r106 = new Bundle();
        r106.putBoolean("DATA_BOOLEAN_SKIP_INTERCEPTOR", true);
        r103.f571839d = r106;
        xs2.b.a().post(r103);
        return;
    L27:
        return;
    L14:
        if (r104.intValue() != 2) goto L19;
        xs2.b.a().post(new zg1.j1());
        SharedPrefHelper r107 = SharedPrefHelper.b(r101.getContext());
        if (r107.f249253b != null) goto L18;
        r107.f249253b = r107.f249252a.edit();
    L18:
        r107.f249253b.remove("live.pref.SHOW_COIN_TASK_POPUP_COUNTS");
        r107.a();
        return;
    L6:
        if (r104.intValue() != 1) goto L11;
        SharedPrefHelper r108 = SharedPrefHelper.b(r101.getContext());
        if (r108.f249253b != null) goto L10;
        r108.f249253b = r108.f249252a.edit();
    L10:
        r108.f249253b.remove("live.pref.SHOW_COIN_TASK_POPUP_COUNTS");
        r108.a();
    }
}
