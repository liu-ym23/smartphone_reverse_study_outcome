package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.ies.web.jsbridge2.CallContext;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes45.dex */
public final class la implements ca0.s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CallContext f63546a;

    public la(CallContext r100) {
        this.f63546a = r100;
    }

    @Override // ca0.s
    public final void j(com.bytedance.android.livesdk.gift.platform.business.sendGift.f r100) {
        Intrinsics.checkNotNullParameter(r100, "result");
        CallContext r101 = this.f63546a;
        Pair[] r102 = new Pair[3];
        r102[0] = TuplesKt.to("giftIds", new JSONArray(r100.f130109a));
        r102[1] = TuplesKt.to("succeed", Boolean.valueOf(r100.f130111c));
        Exception r103 = r100.f130112d;
        if (r103 == null) goto L5;
        String r104 = r103.getMessage();
    L6:
        r102[2] = TuplesKt.to("error", r104);
        r101.b("Hybrid_sendGiftSucceed", com.bytedance.android.live.revenue.common.q.b(r102));
        return;
    L5:
        r104 = null;
        goto L6
    }
}
