package com.bytedance.android.live.revlink.impl.jsb;

import com.bytedance.android.live.browser.jsbridge.base.GetLiveServiceTimeResultModel;
import com.bytedance.ies.web.jsbridge2.CallContext;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class h extends wy0.a<Object, GetLiveServiceTimeResultModel> {
    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
    }

    public h() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r101) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, "callContext");
        jy0.b.d("NotifyPKEventMethod", "param: " + r100);
        GetLiveServiceTimeResultModel r102 = new GetLiveServiceTimeResultModel();
        r102.a(GetLiveServiceTimeResultModel.Code.Success);
        r102.b(Long.valueOf(com.bytedance.live.kmp.util.e.b()));
        Unit r103 = Unit.INSTANCE;
        j(r102);
    }
}
