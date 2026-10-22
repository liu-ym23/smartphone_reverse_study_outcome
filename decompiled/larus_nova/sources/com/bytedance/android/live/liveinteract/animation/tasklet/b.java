package com.bytedance.android.live.liveinteract.animation.tasklet;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public abstract class b implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.android.live.liveinteract.videotalk.emoji.model.p f71167a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.android.live.liveinteract.videotalk.emoji.model.f f71168b;

    public void a() {
    }

    public b(com.bytedance.android.live.liveinteract.videotalk.emoji.model.p r100, com.bytedance.android.live.liveinteract.videotalk.emoji.model.f r101) {
        Intrinsics.checkNotNullParameter(r100, "mData");
        Intrinsics.checkNotNullParameter(r101, "mAnimationData");
        this.f71167a = r100;
        this.f71168b = r101;
    }
}
