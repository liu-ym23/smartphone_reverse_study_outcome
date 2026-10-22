package com.bytedance.android.livesdk.gift.platform.business.jsbridge.methods;

import com.bytedance.android.live.browser.jsbridge.base.LiveRequireGiftEffectLynxViewResultModel;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;
import w20.cb;
import w20.i3;

/* JADX INFO: loaded from: classes9.dex */
public final class k extends i3<cb, LiveRequireGiftEffectLynxViewResultModel> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final rh6.a f129719a;

    public k(rh6.a r100) {
        Intrinsics.checkNotNullParameter(r100, "scope");
        this.f129719a = r100;
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r110) {
        cb r101 = (cb) r100;
        Intrinsics.checkNotNullParameter(r101, "params");
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        rh6.a r111 = this.f129719a;
        com.bytedance.android.livesdk.gift.platform.business.effect.service.feed.d r102 = (com.bytedance.android.livesdk.gift.platform.business.effect.service.feed.d) com.bytedance.android.scope.m.f163449e.d(r111, com.bytedance.android.livesdk.gift.platform.business.effect.service.feed.d.class);
        if (r102 == null) goto L25;
        Integer r112 = r101.getAction();
        if (r112 == null) goto L7;
        int r113 = r112.intValue();
    L8:
        Integer r103 = r101.getType();
        if (r103 == null) goto L11;
        int r104 = r103.intValue();
    L12:
        Boolean r105 = r101.U2();
        if (r105 == null) goto L15;
        boolean r106 = r105.booleanValue();
    L16:
        String r107 = r101.getSchema();
        if (r107 != null) goto L19;
        r107 = "";
    L19:
        Boolean r108 = r101.I5();
        if (r108 == null) goto L22;
        boolean r109 = r108.booleanValue();
    L23:
        int r114 = r113;
        r102.a(r114, r104, r106, r107, r109, r101.getChannel(), r101.i2());
        return;
    L22:
        r109 = false;
        goto L23
    L15:
        r106 = false;
        goto L16
    L11:
        r104 = 0;
        goto L12
    L7:
        r113 = 0;
        goto L8
    }
}
