package com.bytedance.android.livesdk.interactivity.square;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class j extends l52.b {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final i f141170h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final c f141171i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final com.bytedance.android.livesdk.interactivity.api.publicscreen.l f141172j;

    public j(k52.a r100, h r101, com.bytedance.android.livesdk.interactivity.api.publicscreen.l r102) {
        Intrinsics.checkNotNullParameter(r100, "pipelineConfig");
        Intrinsics.checkNotNullParameter(r101, "repo");
        Intrinsics.checkNotNullParameter(r102, "publicScreenContext");
        super(r100, r101, r102);
        this.f141172j = r102;
        this.f141170h = new i(this);
        this.f141171i = new c(r100.f501826b);
    }
}
