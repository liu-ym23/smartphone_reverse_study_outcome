package com.bytedance.android.anniex.detect;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SnapshotPipeline f40647a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final DetectionPipeline f40648b;

    public b(SnapshotPipeline r100, DetectionPipeline r101) {
        Intrinsics.checkNotNullParameter(r100, "snapShotPipeline");
        Intrinsics.checkNotNullParameter(r101, "detectPipeline");
        this.f40647a = r100;
        this.f40648b = r101;
    }
}
