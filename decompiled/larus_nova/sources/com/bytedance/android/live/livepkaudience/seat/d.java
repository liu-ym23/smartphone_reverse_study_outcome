package com.bytedance.android.live.livepkaudience.seat;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class d extends a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public a f82237b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public a f82238c;

    @Override // com.bytedance.android.live.livepkaudience.seat.a
    public final void b(PkDynamicEmojiTask r100) {
    }

    public d() {
    }

    @Override // com.bytedance.android.live.livepkaudience.seat.a
    public final void a(h r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        a r101 = this.f82237b;
        if (r101 == null) goto L6;
        r101.a(r100);
        return;
    }
}
