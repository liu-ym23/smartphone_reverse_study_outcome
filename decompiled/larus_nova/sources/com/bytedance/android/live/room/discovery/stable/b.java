package com.bytedance.android.live.room.discovery.stable;

import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class b implements com.bytedance.android.live.broadcast.api.stable.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function1<Integer, Unit> f99592a;

    @Override // com.bytedance.android.live.broadcast.api.stable.b
    public final void getPriority() {
    }

    @Override // java.lang.Comparable
    public final int compareTo(com.bytedance.android.live.broadcast.api.stable.b r100) {
        com.bytedance.android.live.broadcast.api.stable.b r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "other");
        return com.bytedance.android.live.broadcast.api.stable.b.a.a(this, r101);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b(DataCenter r100, Function1<? super Integer, Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "dataCenter");
        Intrinsics.checkNotNullParameter(r101, "onLevelChange");
        this.f99592a = r101;
    }
}
