package com.bytedance.android.live.room.discovery.drawer.processor;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class c implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f99462a;

    @Override // com.bytedance.android.live.room.discovery.drawer.processor.a
    public final boolean a() {
        return false;
    }

    @Override // com.bytedance.android.live.room.discovery.drawer.processor.a
    public final String identifier() {
        return "MoreLiveEntranceInfoValidProcessor";
    }

    @Override // com.bytedance.android.live.room.discovery.drawer.processor.a
    public final boolean b() {
        if (this.f99462a.b().f99457m == null) goto L15;
        com.bytedance.android.live.base.model.moreliveentrance.b r100 = this.f99462a.b().f99457m;
        if (r100 == null) goto L16;
        String r101 = r100.e();
        if (r101 != null) goto L9;
        return false;
    L9:
        if (r101.length() <= 0) goto L11;
        boolean r102 = true;
    L12:
        if (r102 != true) goto L18;
        return true;
    L18:
        return false;
    L11:
        r102 = false;
        goto L12
    L16:
        return false;
    L15:
        return false;
    }

    public c(b r100) {
        Intrinsics.checkNotNullParameter(r100, "chain");
        this.f99462a = r100;
    }

    @Override // com.bytedance.android.live.room.discovery.drawer.processor.a
    public final void c(MarqueeType r100) {
        Intrinsics.checkNotNullParameter(r100, "marqueeType");
        Intrinsics.checkNotNullParameter(r100, "marqueeType");
    }
}
