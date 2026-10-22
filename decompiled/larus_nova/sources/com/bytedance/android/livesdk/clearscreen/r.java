package com.bytedance.android.livesdk.clearscreen;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f119482a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ZoomType f119483b;

    public final ZoomType getType() {
        return this.f119483b;
    }

    public r(boolean r100, ZoomType r101) {
        Intrinsics.checkNotNullParameter(r101, "type");
        this.f119482a = r100;
        this.f119483b = r101;
    }
}
