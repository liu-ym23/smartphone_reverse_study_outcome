package com.bytedance.android.live.platformplayer.effect;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f85480a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f85481b;

    public final int getType() {
        return this.f85481b;
    }

    public a(String r100, int r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r102, "description");
        this.f85480a = r100;
        this.f85481b = r101;
    }
}
