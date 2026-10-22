package com.bytedance.android.live.revenue.platform.room.impl;

import kotlin.jvm.internal.Intrinsics;
import yz0.o;

/* JADX INFO: loaded from: classes47.dex */
public final class n extends h {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.android.live.revenue.core.a f91631b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.bytedance.android.scope.a<g> f91632c;

    @Override // com.bytedance.android.live.revenue.platform.room.impl.h, com.bytedance.android.scope.o
    public final void onStart() {
        com.bytedance.android.live.revenue.core.a r100 = this.f91631b;
        r100.b(o.class, r100.getScope());
    }

    public n(com.bytedance.android.live.revenue.core.a r100, e33.a r101) {
        Intrinsics.checkNotNullParameter(r100, "inst");
        Intrinsics.checkNotNullParameter(r101, "roomStateDispatcher");
        super(r101);
        this.f91631b = r100;
        this.f91632c = r101;
    }
}
