package com.bytedance.android.live.revlink.impl.behavior;

import com.facebook.fresco.animation.backend.AnimationBackend;
import com.facebook.fresco.animation.backend.AnimationBackendDelegate;

/* JADX INFO: loaded from: classes47.dex */
public final class g extends AnimationBackendDelegate<AnimationBackend> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f92153a;

    @Override // com.facebook.fresco.animation.backend.AnimationBackendDelegate, com.facebook.fresco.animation.backend.AnimationInformation
    public final int getLoopCount() {
        return this.f92153a;
    }

    public g(AnimationBackend r100) {
        super(r100);
        this.f92153a = 999;
    }

    @Override // com.facebook.fresco.animation.backend.AnimationBackendDelegate, com.facebook.fresco.animation.backend.AnimationBackend
    public final boolean hasCacheFrame(int r100) {
        if (((Boolean) o.f92185c.getValue(null, o.f92183a[1])).booleanValue() == false) goto L6;
        return true;
    L6:
        return super.hasCacheFrame(r100);
    }
}
