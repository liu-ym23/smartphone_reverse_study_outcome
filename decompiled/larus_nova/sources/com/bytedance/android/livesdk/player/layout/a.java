package com.bytedance.android.livesdk.player.layout;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class a implements com.bytedance.android.live.platformplayer.layout.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.bytedance.android.live.platformplayer.layout.c f155513a;

    public a() {
    }

    @Override // com.bytedance.android.live.platformplayer.layout.b
    public final String d() {
        return "fold_screen default";
    }

    @Override // com.bytedance.android.live.platformplayer.layout.b
    public final void e() {
    }

    @Override // com.bytedance.android.live.platformplayer.layout.b
    public final void reset() {
        this.f155513a = null;
    }

    @Override // com.bytedance.android.live.platformplayer.layout.b
    public final void b(com.bytedance.android.live.platformplayer.layout.c r100) {
        Intrinsics.checkNotNullParameter(r100, "playPosition");
        this.f155513a = r100;
    }

    @Override // com.bytedance.android.live.platformplayer.layout.b
    public final boolean c(String r100, com.bytedance.android.live.platformplayer.layout.f r101) {
        Intrinsics.checkNotNullParameter(r101, "layoutContext");
        if (r101.f85611b == true) goto L5;
    L7:
        return false;
    L5:
        if (r101.f85612c == false) goto L7;
        return true;
    }

    @Override // com.bytedance.android.live.platformplayer.layout.b
    public final void a(String r100, com.bytedance.android.live.platformplayer.layout.f r110, String r111) {
        Intrinsics.checkNotNullParameter(r110, "layoutContext");
        Intrinsics.checkNotNullParameter(r111, "from");
        com.bytedance.android.live.platformplayer.layout.c r101 = this.f155513a;
        if (r101 == null) goto L26;
        int r102 = r110.f85616g;
        int r103 = 1;
        if (r102 != (-1)) goto L7;
    L9:
        boolean r104 = false;
    L10:
        if (r104 == false) goto L20;
        if (r110.f85613d == true) goto L14;
    L22:
        r103 = 17;
    L23:
        int r112 = 0;
    L24:
        r101.setWidth(-1);
        r101.setHeight(-1);
        r101.setGravity(r103);
        r101.setScaleType(0);
        r101.f(r112);
        r101.requestLayout(r111);
        return;
    L14:
        if (r102 <= r110.f85617h) goto L16;
        boolean r105 = true;
    L17:
        if (r105 == false) goto L22;
        r112 = r110.f85626q;
        goto L24
    L16:
        r105 = false;
        goto L17
    L20:
        if (r110.f85613d == true) goto L22;
    L7:
        if (r110.f85617h == (-1)) goto L9;
        r104 = true;
        goto L10
    }
}
