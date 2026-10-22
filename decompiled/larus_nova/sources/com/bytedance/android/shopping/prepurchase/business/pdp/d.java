package com.bytedance.android.shopping.prepurchase.business.pdp;

import com.bytedance.android.btm.api.model.PageFinder;
import com.google.gson.internal.LinkedTreeMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class d implements com.bytedance.android.shopping.prepurchase.arch.container.intf.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.android.shopping.prepurchase.arch.container.intf.h f181841a;

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.intf.h
    public final void appendEventParams(Pair<String, ? extends Object>... r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        this.f181841a.appendEventParams(r100);
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.intf.h
    public final Map<String, Object> getEventParams() {
        return this.f181841a.getEventParams();
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.intf.h
    public final void o(String r100) {
        Intrinsics.checkNotNullParameter(com.bytedance.android.ec.core.event.a.KEY_SHARE_WITH_HEAD, "key");
        Intrinsics.checkNotNullParameter(r100, "value");
        this.f181841a.o(r100);
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.intf.h
    public final void p(LinkedTreeMap r100) {
        Intrinsics.checkNotNullParameter(r100, "paramsMap");
        this.f181841a.p(r100);
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.intf.h
    public final void q(String r100, PageFinder r101, Map<String, ? extends Object> r102) {
        Intrinsics.checkNotNullParameter(r100, "actionName");
        Intrinsics.checkNotNullParameter(r102, "params");
        this.f181841a.q(r100, r101, r102);
    }

    public d(boolean r100) {
        com.bytedance.android.shopping.prepurchase.arch.container.intf.d r101 = new com.bytedance.android.shopping.prepurchase.arch.container.intf.d();
        Intrinsics.checkNotNullParameter(r101, "base");
        this.f181841a = r101;
        appendEventParams(new Pair[]{TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_IS_FROM_RESTORE, Integer.valueOf(r100 ? 1 : 0))});
    }
}
