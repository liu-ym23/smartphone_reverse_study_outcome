package com.bytedance.android.live;

import com.facebook.fresco.animation.backend.AnimationBackend;
import com.facebook.fresco.animation.frame.DropFramesFrameScheduler;
import com.facebook.fresco.animation.frame.FrameScheduler;
import com.facebook.fresco.animation.frame.FrameSchedulerFactory;
import com.facebook.imageformat.ImageFormat;

/* JADX INFO: loaded from: classes45.dex */
public final /* synthetic */ class j implements FrameSchedulerFactory {
    public /* synthetic */ j() {
    }

    @Override // com.facebook.fresco.animation.frame.FrameSchedulerFactory
    public final FrameScheduler build(AnimationBackend r100, Object r101, ImageFormat r102, int r103) {
        return new DropFramesFrameScheduler(r100);
    }
}
