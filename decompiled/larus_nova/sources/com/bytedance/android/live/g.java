package com.bytedance.android.live;

import com.facebook.fresco.animation.backend.AnimationBackend;
import com.facebook.fresco.animation.frame.FrameScheduler;

/* JADX INFO: loaded from: classes45.dex */
public final class g implements FrameScheduler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AnimationBackend f68995a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f68996b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f68997c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f68998d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f68999e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f69000f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f69001g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f69002h;

    @Override // com.facebook.fresco.animation.frame.FrameScheduler
    public final long getLoopDurationMs() {
        long r100 = this.f68996b;
        if (r100 == (-1)) goto L5;
        return r100;
    L5:
        this.f68996b = 0;
        int r101 = this.f68995a.getFrameCount();
        int r102 = 0;
    L6:
        if (r102 >= r101) goto L9;
        this.f68996b += (long) this.f68995a.getFrameDurationMs(r102);
        r102 = r102 + 1;
        goto L6
    L9:
        return this.f68996b;
    }

    @Override // com.facebook.fresco.animation.frame.FrameScheduler
    public final boolean isInfiniteAnimation() {
        if (this.f68995a.getLoopCount() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.facebook.fresco.animation.frame.FrameScheduler
    public final FrameScheduler forNewFrameScheduler(FrameScheduler r100) {
        if ((r100 instanceof g) == false) goto L6;
        g r101 = (g) r100;
        g r102 = new g(r101.f68995a, r101.f69002h);
        r102.f68998d = this.f68998d;
        r102.f69000f = this.f69000f;
        r102.f68997c = this.f68997c;
        r102.f68999e = this.f68999e;
        return r102;
    L6:
        return null;
    }

    @Override // com.facebook.fresco.animation.frame.FrameScheduler
    public final long getTargetRenderTimeForNextFrameMs(long r100) {
        if (getLoopDurationMs() != 0) goto L6;
        return -1;
    L6:
        if (isInfiniteAnimation() == false) goto L8;
    L10:
        long r101 = this.f68995a.getFrameDurationMs(this.f68998d);
        long r102 = this.f68999e + r101;
        if (r102 >= r100) goto L14;
        r102 = r100 + r101;
    L14:
        long r103 = this.f69001g;
        return ((((r102 + r103) / 34) + 1) * 34) - r103;
    L8:
        if (this.f68997c < this.f68995a.getLoopCount()) goto L10;
        return -1;
    }

    @Override // com.facebook.fresco.animation.frame.FrameScheduler
    public final long getTargetRenderTimeMs(int r100) {
        long r101 = 0;
        int r102 = 0;
    L3:
        if (r102 >= r100) goto L5;
        r101 = r101 + ((long) this.f68995a.getFrameDurationMs(r100));
        r102 = r102 + 1;
        goto L3
    L5:
        return r101;
    }

    @Override // com.facebook.fresco.animation.frame.FrameScheduler
    public final void setStartTime(long r100) {
        this.f69001g = r100;
    }

    public g(AnimationBackend r100, int r101) {
        this.f68996b = -1;
        this.f68997c = 0;
        this.f68998d = -1;
        this.f68999e = -1;
        this.f69000f = -1;
        this.f69001g = -1;
        this.f68995a = r100;
        this.f69002h = r101;
    }

    @Override // com.facebook.fresco.animation.frame.FrameScheduler
    public final int getFrameNumberToRender(long r110, long r111) {
        long r100 = getLoopDurationMs();
        long r101 = 0;
        if (r100 != 0) goto L6;
        return -1;
    L6:
        if (isInfiniteAnimation() == false) goto L8;
    L10:
        long r102 = r110 % r100;
        int r103 = 0;
        int r104 = 0;
    L11:
        r101 = r101 + ((long) this.f68995a.getFrameDurationMs(r104));
        r104 = r104 + 1;
        if (r102 >= r101) goto L11;
        int r105 = r104 - 1;
        int r106 = this.f68998d;
        if (r106 != (-1)) goto L16;
    L38:
        this.f68999e = r110;
        this.f69000f = r110;
        this.f68998d = r105;
        this.f68997c = 0;
        return r105;
    L16:
        if (r111 != this.f69000f) goto L38;
        this.f69000f = r110;
        if ((this.f68999e + this.f68995a.getFrameDurationMs(r106)) > r110) goto L21;
        this.f68999e = r110;
        int r112 = this.f68998d + 1;
        if (r112 < this.f68995a.getFrameCount()) goto L31;
        int r113 = this.f69002h;
        if (r113 != 0) goto L27;
    L30:
        this.f68997c++;
    L33:
        if (this.f68995a.hasCacheFrame(r103) == false) goto L37;
        this.f68998d = r103;
        return r103;
    L37:
        return this.f68998d;
    L27:
        if (r113 == 3) goto L30;
        r103 = r112 - 1;
        goto L33
    L31:
        r103 = r112;
        goto L33
    L21:
        return this.f68998d;
    L8:
        if ((r110 / r100) < this.f68995a.getLoopCount()) goto L10;
        return -1;
    }
}
