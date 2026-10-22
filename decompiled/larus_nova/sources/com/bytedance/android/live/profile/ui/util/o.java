package com.bytedance.android.live.profile.ui.util;

import com.facebook.fresco.animation.backend.AnimationBackend;
import com.facebook.fresco.animation.frame.DropFramesFrameScheduler;
import com.facebook.fresco.animation.frame.FrameScheduler;
import com.facebook.fresco.animation.frame.FrameSchedulerFactory;
import com.facebook.imageformat.ImageFormat;

/* JADX INFO: loaded from: classes47.dex */
public final class o implements FrameSchedulerFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final o f86957a = null;

    static {
        f86957a = new o();
    }

    public o() {
    }

    @Override // com.facebook.fresco.animation.frame.FrameSchedulerFactory
    public final FrameScheduler build(AnimationBackend r100, Object r101, ImageFormat r102, int r103) {
        return new DropFramesFrameScheduler(r100);
    }
}
