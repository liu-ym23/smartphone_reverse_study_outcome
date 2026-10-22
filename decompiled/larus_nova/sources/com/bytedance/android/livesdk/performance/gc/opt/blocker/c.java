package com.bytedance.android.livesdk.performance.gc.opt.blocker;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class c implements a {
    public c() {
    }

    @Override // com.bytedance.android.livesdk.performance.gc.opt.blocker.a
    public final void a(GcBlockScene r100) {
        Intrinsics.checkNotNullParameter(r100, "scene");
    }

    @Override // com.bytedance.android.livesdk.performance.gc.opt.blocker.a
    public final void b(GcBlockScene r100) {
        Intrinsics.checkNotNullParameter(r100, "scene");
    }

    @Override // com.bytedance.android.livesdk.performance.gc.opt.blocker.a
    public final void prepare() {
    }

    @Override // com.bytedance.android.livesdk.performance.gc.opt.blocker.a
    public final void release() {
    }

    @Override // com.bytedance.android.livesdk.performance.gc.opt.blocker.a
    public final void requestBlockGc(int r100) {
    }
}
