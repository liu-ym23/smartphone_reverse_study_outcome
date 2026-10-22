package com.bytedance.android.shopping.orderlist.common.controller;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class e extends com.bytedance.kmp.ec.yata.store.core.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ OrderBottomBarHandler f179724a;

    public e(OrderBottomBarHandler r100) {
        this.f179724a = r100;
    }

    @Override // com.bytedance.kmp.ec.yata.store.core.a
    public final void c(com.bytedance.kmp.ec.yata.store.core.a.C3594a r100) {
        Intrinsics.checkNotNullParameter(r100, "modifier");
        Map<String, Object> r101 = r100.d();
        if (r101 == null) goto L5;
        Object r102 = r101.get("is_bottom_bar");
    L7:
        if (Intrinsics.areEqual(r102, Boolean.TRUE) == false) goto L10;
        this.f179724a.f179687b = true;
        return;
    L10:
        return;
    L5:
        r102 = null;
        goto L7
    }
}
