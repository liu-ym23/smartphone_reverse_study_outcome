package com.bytedance.android.live.lynx.ui;

import com.facebook.fresco.animation.backend.AnimationBackend;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class n extends l8a.b {
    @Override // com.facebook.fresco.animation.backend.AnimationBackendDelegate, com.facebook.fresco.animation.backend.AnimationBackend
    public final boolean hasCacheFrame(int r100) {
        return true;
    }

    public n(AnimationBackend r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "animationBackend");
        super(r100, r101);
    }
}
