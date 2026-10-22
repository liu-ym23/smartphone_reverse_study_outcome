package com.bytedance.android.livesdk.livecommerce.eventcenter;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class c implements d {
    public c() {
    }

    @Override // com.bytedance.android.livesdk.livecommerce.eventcenter.d
    public final void a(d.a r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
    }

    @Override // com.bytedance.android.livesdk.livecommerce.eventcenter.d
    public final void b(d.a r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
    }

    @Override // com.bytedance.android.livesdk.livecommerce.eventcenter.d
    public final void sendEvent(String r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
    }
}
