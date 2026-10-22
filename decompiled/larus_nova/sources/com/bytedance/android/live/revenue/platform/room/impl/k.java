package com.bytedance.android.live.revenue.platform.room.impl;

import com.bytedance.android.scope.o;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class k implements p01.a, o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<is2.b> f91623a;

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
    }

    @Override // p01.a
    public final List<is2.b> getRoomBackendHandlers() {
        return this.f91623a;
    }

    public k(e33.a r100) {
        Intrinsics.checkNotNullParameter(r100, "roomBackendHandlers");
        this.f91623a = CollectionsKt.toList(r100);
    }
}
