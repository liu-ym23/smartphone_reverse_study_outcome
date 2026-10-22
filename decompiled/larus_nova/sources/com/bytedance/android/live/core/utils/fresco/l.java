package com.bytedance.android.live.core.utils.fresco;

import com.facebook.common.references.CloseableReference;
import com.facebook.fresco.animation.factory.ExperimentalBitmapAnimationDrawableFactory;
import com.facebook.imagepipeline.animated.impl.AnimatedFrameCache;
import com.facebook.imagepipeline.cache.CountingMemoryCache;
import com.facebook.imagepipeline.image.CloseableImage;

/* JADX INFO: loaded from: classes45.dex */
public final class l extends AnimatedFrameCache {
    @Override // com.facebook.imagepipeline.animated.impl.AnimatedFrameCache
    public final void clear(int r100) {
    }

    @Override // com.facebook.imagepipeline.animated.impl.AnimatedFrameCache
    public final CloseableReference<CloseableImage> get(int r100) {
        CloseableReference<CloseableImage> r101 = super.get(r100);
        if (r101 != null) goto L5;
    L7:
        return r101;
    L5:
        if (r101.getSharedReference() == null) goto L7;
        r101.getSharedReference().isValid();
        goto L7
    }

    public l(ExperimentalBitmapAnimationDrawableFactory.AnimationFrameCacheKey r100, CountingMemoryCache r101) {
        super(r100, r101);
    }
}
