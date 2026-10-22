package com.bytedance.android.live.room.discovery.drawer.processor;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class e implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f99463a;

    @Override // com.bytedance.android.live.room.discovery.drawer.processor.a
    public final boolean a() {
        return false;
    }

    @Override // com.bytedance.android.live.room.discovery.drawer.processor.a
    public final String identifier() {
        return "MoreLiveFloatViewEnterProcessor";
    }

    @Override // com.bytedance.android.live.room.discovery.drawer.processor.a
    public final boolean b() {
        if (this.f99463a.b().f99448d == true) goto L5;
    L7:
        return false;
    L5:
        if (this.f99463a.b().f99449e == false) goto L7;
        return true;
    }

    public e(b r100) {
        Intrinsics.checkNotNullParameter(r100, "chain");
        this.f99463a = r100;
    }

    @Override // com.bytedance.android.live.room.discovery.drawer.processor.a
    public final void c(MarqueeType r100) {
        Intrinsics.checkNotNullParameter(r100, "marqueeType");
        Intrinsics.checkNotNullParameter(r100, "marqueeType");
    }
}
