package com.bytedance.android.livesdk.player.layout;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class l implements com.bytedance.android.live.platformplayer.layout.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.bytedance.android.live.platformplayer.layout.c f155552a;

    public l() {
    }

    @Override // com.bytedance.android.live.platformplayer.layout.b
    public final String d() {
        return "pad default";
    }

    @Override // com.bytedance.android.live.platformplayer.layout.b
    public final void e() {
    }

    @Override // com.bytedance.android.live.platformplayer.layout.b
    public final void reset() {
        this.f155552a = null;
    }

    @Override // com.bytedance.android.live.platformplayer.layout.b
    public final void b(com.bytedance.android.live.platformplayer.layout.c r100) {
        Intrinsics.checkNotNullParameter(r100, "playPosition");
        this.f155552a = r100;
    }

    @Override // com.bytedance.android.live.platformplayer.layout.b
    public final boolean c(String r100, com.bytedance.android.live.platformplayer.layout.f r101) {
        Intrinsics.checkNotNullParameter(r101, "layoutContext");
        return r101.f85610a;
    }

    @Override // com.bytedance.android.live.platformplayer.layout.b
    public final void a(String r100, com.bytedance.android.live.platformplayer.layout.f r101, String r102) {
        Intrinsics.checkNotNullParameter(r101, "layoutContext");
        Intrinsics.checkNotNullParameter(r102, "from");
        com.bytedance.android.live.platformplayer.layout.c r103 = this.f155552a;
        if (r103 == null) goto L28;
        int r104 = r101.f85616g;
        int r105 = 1;
        if (r104 != (-1)) goto L7;
    L9:
        boolean r106 = false;
    L10:
        if (r106 == false) goto L21;
        if (r101.f85613d == true) goto L14;
        int r107 = 0;
    L25:
        r105 = 17;
    L23:
        int r108 = 0;
    L26:
        r103.setWidth(-1);
        r103.setHeight(-1);
        r103.setScaleType(r107);
        r103.setGravity(r105);
        r103.b(0);
        r103.f(r108);
        r103.requestLayout(r102);
        return;
    L14:
        if (r104 <= r101.f85617h) goto L16;
        boolean r109 = true;
    L17:
        if (r109 == false) goto L24;
        r108 = r101.f85626q;
        r107 = 0;
    L24:
        r107 = 2;
        goto L25
    L16:
        r109 = false;
        goto L17
    L21:
        if (r101.f85613d == true) goto L24;
        r107 = 0;
        goto L23
    L7:
        if (r101.f85617h == (-1)) goto L9;
        r106 = true;
        goto L10
    }
}
