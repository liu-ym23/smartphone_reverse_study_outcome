package com.bytedance.android.live.liveinteract.hamlet.view;

import com.facebook.fresco.animation.backend.AnimationBackend;
import com.facebook.fresco.animation.backend.AnimationBackendDelegate;

/* JADX INFO: loaded from: classes46.dex */
public final class a extends AnimationBackendDelegate<AnimationBackend> {
    @Override // com.facebook.fresco.animation.backend.AnimationBackendDelegate, com.facebook.fresco.animation.backend.AnimationInformation
    public final int getLoopCount() {
        return Integer.MAX_VALUE;
    }

    public a(AnimationBackend r100) {
        super(r100);
    }
}
