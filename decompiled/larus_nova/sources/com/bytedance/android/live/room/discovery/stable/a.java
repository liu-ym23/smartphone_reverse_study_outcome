package com.bytedance.android.live.room.discovery.stable;

import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class a implements com.bytedance.android.live.broadcast.api.stable.b {
    @Override // com.bytedance.android.live.broadcast.api.stable.b
    public final void getPriority() {
    }

    public a(DataCenter r100) {
        Intrinsics.checkNotNullParameter(r100, "dataCenter");
    }

    @Override // java.lang.Comparable
    public final int compareTo(com.bytedance.android.live.broadcast.api.stable.b r100) {
        com.bytedance.android.live.broadcast.api.stable.b r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "other");
        return com.bytedance.android.live.broadcast.api.stable.b.a.a(this, r101);
    }
}
