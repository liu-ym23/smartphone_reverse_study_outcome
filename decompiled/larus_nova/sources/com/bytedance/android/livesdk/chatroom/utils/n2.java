package com.bytedance.android.livesdk.chatroom.utils;

import com.facebook.fresco.animation.backend.AnimationBackend;
import com.facebook.fresco.animation.frame.DropFramesFrameScheduler;
import com.facebook.fresco.animation.frame.FrameScheduler;
import com.facebook.fresco.animation.frame.FrameSchedulerFactory;
import com.facebook.imageformat.ImageFormat;

/* JADX INFO: loaded from: classes8.dex */
public final class n2 implements FrameSchedulerFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final n2 f114563a = null;

    static {
        f114563a = new n2();
    }

    public n2() {
    }

    @Override // com.facebook.fresco.animation.frame.FrameSchedulerFactory
    public final FrameScheduler build(AnimationBackend r100, Object r101, ImageFormat r102, int r103) {
        return new DropFramesFrameScheduler(r100);
    }
}
