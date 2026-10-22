package com.bytedance.android.live.core.utils.fresco;

import android.content.Context;
import com.facebook.cache.common.CacheKey;
import com.facebook.drawee.backends.pipeline.PipelineDraweeController;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.facebook.fresco.animation.frame.DropFramesFrameScheduler;
import com.facebook.imagepipeline.cache.CountingMemoryCache;
import com.facebook.imagepipeline.image.CloseableImage;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class c {
    public static final void b(AnimatedDrawable2 r100) {
        CountingMemoryCache<CacheKey, CloseableImage> r101 = e.f66139a;
        e.b(r100, new DropFramesFrameScheduler(r100.getAnimationBackend()));
    }

    public static final void c(AnimatedDrawable2 r100) {
        CountingMemoryCache<CacheKey, CloseableImage> r101 = e.f66139a;
        if (r100 != null) goto L5;
        m r102 = null;
    L6:
        if (r102 == null) goto L9;
        e.b(r100, r102);
        return;
    L9:
        return;
    L5:
        r102 = new m(r100.getAnimationBackend());
        goto L6
    }

    public static void a(PipelineDraweeController r100, Context r101, String r102) {
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, "sourceUri");
        e.a(r101, r100, r102, false);
    }
}
