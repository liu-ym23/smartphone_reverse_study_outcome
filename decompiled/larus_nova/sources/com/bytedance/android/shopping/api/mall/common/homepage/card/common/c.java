package com.bytedance.android.shopping.api.mall.common.homepage.card.common;

import com.facebook.fresco.animation.backend.AnimationBackend;
import com.facebook.fresco.animation.backend.AnimationBackendDelegate;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class c extends AnimationBackendDelegate<AnimationBackend> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f170306a;

    @Override // com.facebook.fresco.animation.backend.AnimationBackendDelegate, com.facebook.fresco.animation.backend.AnimationInformation
    public final int getLoopCount() {
        return this.f170306a;
    }

    public c(AnimationBackend r100) {
        Intrinsics.checkNotNullParameter(r100, "animationBackend");
        super(r100);
        this.f170306a = 1;
    }
}
