package com.bytedance.android.marketing.sdk.impl.actions;

import android.content.Context;
import com.bytedance.android.marketing.sdk.impl.MarketingServiceImplV2;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class ActionHide extends a {
    @Override // com.bytedance.android.marketing.sdk.impl.actions.a
    public final String a() {
        return "ecom.marketing.hide";
    }

    public ActionHide() {
    }

    @Override // com.bytedance.android.marketing.sdk.impl.actions.a
    public final void c(Map<String, ? extends Object> r100, Context r101, final p r102) {
        Intrinsics.checkNotNullParameter(r102, "callback");
        super.c(r100, r101, r102);
        if (r100 == null) goto L6;
        ji.a r103 = com.bytedance.android.marketing.sdk.impl.utils.b.f162814a;
        String r104 = this.f162691a;
        String r105 = this.f162692b;
        String r106 = this.f162693c;
        long r107 = this.f162696f;
        com.bytedance.android.marketing.sdk.impl.utils.b.d("[HIDE]");
        com.bytedance.android.marketing.sdk.impl.utils.b.c(r104, r105, r106, r107);
        new MarketingServiceImplV2();
        MarketingServiceImplV2.k(this.f162693c, this.f162691a, this.f162692b, false, new ActionHide$performAction$1(r102));
        return;
    }
}
