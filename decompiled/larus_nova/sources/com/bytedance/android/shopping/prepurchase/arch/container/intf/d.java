package com.bytedance.android.shopping.prepurchase.arch.container.intf;

import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.shopping.base.event.EventActionImpl;
import com.google.gson.internal.LinkedTreeMap;
import java.util.Arrays;
import java.util.Map;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class d implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final EventActionImpl f180789a;

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.intf.h
    public final Map<String, Object> getEventParams() {
        return this.f180789a.c();
    }

    public d() {
        this.f180789a = new EventActionImpl();
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.intf.h
    public final void appendEventParams(Pair<String, ? extends Object>... r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        this.f180789a.appendEventParams((Pair[]) Arrays.copyOf(r100, r100.length));
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.intf.h
    public final void o(String r100) {
        Intrinsics.checkNotNullParameter(com.bytedance.android.ec.core.event.a.KEY_SHARE_WITH_HEAD, "key");
        Intrinsics.checkNotNullParameter(r100, "value");
        this.f180789a.appendEventParamToEntranceInfo(com.bytedance.android.ec.core.event.a.KEY_SHARE_WITH_HEAD, r100);
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.intf.h
    public final void p(LinkedTreeMap r100) {
        Intrinsics.checkNotNullParameter(r100, "paramsMap");
        this.f180789a.appendEventParams(r100);
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.intf.h
    public final void q(String r100, PageFinder r101, Map<String, ? extends Object> r102) {
        Intrinsics.checkNotNullParameter(r100, "actionName");
        Intrinsics.checkNotNullParameter(r102, "params");
        this.f180789a.doEventAction(r100, r101, r102);
    }
}
