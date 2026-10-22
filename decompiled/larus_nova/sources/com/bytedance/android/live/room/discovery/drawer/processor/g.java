package com.bytedance.android.live.room.discovery.drawer.processor;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class g implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f99465a;

    @Override // com.bytedance.android.live.room.discovery.drawer.processor.a
    public final boolean a() {
        return false;
    }

    @Override // com.bytedance.android.live.room.discovery.drawer.processor.a
    public final String identifier() {
        return "LiveTabEnterRoomSourceProcessor";
    }

    @Override // com.bytedance.android.live.room.discovery.drawer.processor.a
    public final boolean b() {
        return this.f99465a.b().f99447c;
    }

    public g(b r100) {
        Intrinsics.checkNotNullParameter(r100, "chain");
        this.f99465a = r100;
    }

    @Override // com.bytedance.android.live.room.discovery.drawer.processor.a
    public final void c(MarqueeType r100) {
        Intrinsics.checkNotNullParameter(r100, "marqueeType");
        Intrinsics.checkNotNullParameter(r100, "marqueeType");
    }
}
