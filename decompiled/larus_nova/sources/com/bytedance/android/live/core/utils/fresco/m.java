package com.bytedance.android.live.core.utils.fresco;

import com.facebook.fresco.animation.backend.AnimationBackend;
import com.facebook.fresco.animation.backend.AnimationInformation;
import com.facebook.fresco.animation.frame.FrameScheduler;

/* JADX INFO: loaded from: classes45.dex */
public final class m implements FrameScheduler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f66157a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f66158b;

    public static class a implements AnimationInformation {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AnimationInformation f66159a;

        @Override // com.facebook.fresco.animation.backend.AnimationInformation
        public final int getLoopCount() {
            return 1;
        }

        @Override // com.facebook.fresco.animation.backend.AnimationInformation
        public final int getFrameCount() {
            return this.f66159a.getFrameCount();
        }

        public a(AnimationBackend r100) {
            this.f66159a = r100;
        }

        @Override // com.facebook.fresco.animation.backend.AnimationInformation
        public final int getFrameDurationMs(int r100) {
            return this.f66159a.getFrameDurationMs(r100);
        }
    }

    @Override // com.facebook.fresco.animation.frame.FrameScheduler
    public final FrameScheduler forNewFrameScheduler(FrameScheduler r100) {
        return null;
    }

    @Override // com.facebook.fresco.animation.frame.FrameScheduler
    public final void setStartTime(long r100) {
    }

    @Override // com.facebook.fresco.animation.frame.FrameScheduler
    public final long getLoopDurationMs() {
        long r100 = this.f66158b;
        if (r100 == (-1)) goto L5;
        return r100;
    L5:
        this.f66158b = 0;
        int r101 = this.f66157a.getFrameCount();
        int r102 = 0;
    L6:
        if (r102 >= r101) goto L9;
        this.f66158b += (long) this.f66157a.getFrameDurationMs(r102);
        r102 = r102 + 1;
        goto L6
    L9:
        return this.f66158b;
    }

    @Override // com.facebook.fresco.animation.frame.FrameScheduler
    public final boolean isInfiniteAnimation() {
        this.f66157a.getClass();
        return false;
    }

    public m(AnimationBackend r100) {
        this.f66158b = -1;
        this.f66157a = new a(r100);
    }

    @Override // com.facebook.fresco.animation.frame.FrameScheduler
    public final long getTargetRenderTimeForNextFrameMs(long r110) {
        long r100 = getLoopDurationMs();
        long r101 = 0;
        if (r100 != 0) goto L5;
        return -1;
    L5:
        isInfiniteAnimation();
        long r102 = r110 / getLoopDurationMs();
        this.f66157a.getClass();
        if (r102 < 1) goto L8;
        return -1;
    L8:
        long r103 = r110 % r100;
        int r104 = this.f66157a.getFrameCount();
        int r105 = 0;
    L9:
        if (r105 >= r104) goto L14;
        if (r101 > r103) goto L14;
        r101 = r101 + ((long) this.f66157a.getFrameDurationMs(r105));
        r105 = r105 + 1;
    L14:
        return r110 + (r101 - r103);
    }

    @Override // com.facebook.fresco.animation.frame.FrameScheduler
    public final long getTargetRenderTimeMs(int r100) {
        long r101 = 0;
        int r102 = 0;
    L3:
        if (r102 >= r100) goto L5;
        r101 = r101 + ((long) this.f66157a.getFrameDurationMs(r100));
        r102 = r102 + 1;
        goto L3
    L5:
        return r101;
    }

    @Override // com.facebook.fresco.animation.frame.FrameScheduler
    public final int getFrameNumberToRender(long r100, long r101) {
        isInfiniteAnimation();
        long r102 = r100 / getLoopDurationMs();
        this.f66157a.getClass();
        if (r102 < 1) goto L5;
        return -1;
    L5:
        long r103 = r100 % getLoopDurationMs();
        int r104 = 0;
        long r105 = 0;
    L6:
        r105 = r105 + ((long) this.f66157a.getFrameDurationMs(r104));
        r104 = r104 + 1;
        if (r103 >= r105) goto L6;
        return r104 - 1;
    }
}
