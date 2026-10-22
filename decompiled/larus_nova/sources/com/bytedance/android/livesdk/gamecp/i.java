package com.bytedance.android.livesdk.gamecp;

import com.bytedance.android.gamecp.host_api.callback.TTCJPayResult;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class i implements zv0.l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ sv.b f125438a;

    public i(com.bytedance.android.gamecp.business.props.k r100) {
        this.f125438a = r100;
    }

    @Override // zv0.l
    public final void a(zv0.m r100) {
        Intrinsics.checkNotNullParameter(r100, "result");
        sv.b r101 = this.f125438a;
        if (r101 == null) goto L6;
        TTCJPayResult r102 = new TTCJPayResult();
        r102.setCallBackInfo(r100.f573677a);
        r102.setCode(r100.f573678b);
        Unit r103 = Unit.INSTANCE;
        r101.a(r102);
        return;
    }

    @Override // zv0.l
    public final void onEvent(String r100, Map<String, String> r101) {
        Intrinsics.checkNotNullParameter(r100, "action");
        Intrinsics.checkNotNullParameter(r101, "paramMap");
        sv.b r102 = this.f125438a;
        if (r102 == null) goto L6;
        r102.onEvent(r100, r101);
        return;
    }
}
