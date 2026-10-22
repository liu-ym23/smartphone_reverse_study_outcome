package com.bytedance.android.livesdk.interactivity.zdanmaku.layout;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f141655a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public a f141656b;

    public b(a r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "danmakuConfig");
        this.f141656b = r100;
        int r102 = r100.f141652e;
        this.f141655a = (r101 - r102) / (r100.f141651d + r102);
    }
}
