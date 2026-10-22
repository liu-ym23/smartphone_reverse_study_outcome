package com.bytedance.android.livesdk.ktvimpl.realtimechorus.concert;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class a extends com.bytedance.android.livesdk.ktvimpl.realtimechorus.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ld2.a f146537b;

    public a(ConcertTuner r100, com.bytedance.android.livesdk.ktvimpl.realtimechorus.jsb.a r101) {
        Intrinsics.checkNotNullParameter(r100, "concertTuner");
        Intrinsics.checkNotNullParameter(r101, "chorusEventHandler");
        super(r101);
        this.f146537b = r100;
    }

    @Override // fd2.d
    public final void b(String r100, int r101, boolean r102, Context r103) {
        Intrinsics.checkNotNullParameter(r100, "source");
        this.f146537b.b(r100, r101, r102);
    }
}
