package com.bytedance.android.livesdk.jsbridge.methods;

import android.app.Activity;
import android.os.Bundle;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.config.ao0;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@XBridgeMethod(biz = "webcast", name = "closeLiveRoom")
public final class CloseLiveRoomMethod extends b<h0, CloseLiveRoomResultModel> {
    public CloseLiveRoomMethod() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final /* bridge */ /* synthetic */ void invoke(Object r100, CallContext r101) {
        j((h0) r100, r101);
    }

    public final void j(h0 r100, final CallContext r110) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (ao0.f119808a.getValue().booleanValue() == true) goto L5;
        finishWithFailure(new Throwable("客户端关闭了此功能"));
        return;
    L5:
        if ((r110.getContext() instanceof Activity) == false) goto L21;
        String r101 = r100.a();
        if (r101 != null) goto L9;
    L20:
        zg1.h1 r102 = new zg1.h1(6);
        Bundle r111 = new Bundle();
        r111.putBoolean("DATA_BOOLEAN_SKIP_INTERCEPTOR", true);
        r102.f571839d = r111;
        xs2.b.a().post(r102);
        finishWithSuccess();
        return;
    L9:
        if (r101.length() <= 0) goto L11;
        boolean r103 = true;
    L12:
        if (r103 != true) goto L20;
        String r104 = UriProtector.getQueryParameter(UriProtector.parse(r101), "type");
        if (r104 != null) goto L16;
    L19:
        com.bytedance.android.livesdk.service.l.d().a().handle(r110.getContext(), r100.a());
        UtilityKotlinExtentionsKt.s(100, false, true, new AnonymousClass1(this, r110), 2);
        return;
    L16:
        if (r104.equals("fullscreen") == true) goto L19;
        finishWithFailure(new Throwable("new FE page is not fullscreen"));
        return;
    L11:
        r103 = false;
        goto L12
    L21:
        finishWithFailure(new Throwable("context is not activity"));
    }
}
