package com.bytedance.android.livesdk.interactivity.enteranim.utils;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import com.bytedance.android.livesdk.utils.q4;

/* JADX INFO: loaded from: classes9.dex */
public final class c extends Animator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f136784a;

    @Override // android.animation.Animator
    public final long getDuration() {
        return 0;
    }

    @Override // android.animation.Animator
    public final long getStartDelay() {
        return 0;
    }

    @Override // android.animation.Animator
    public final boolean isRunning() {
        return false;
    }

    @Override // android.animation.Animator
    public final Animator setDuration(long r100) {
        return this;
    }

    @Override // android.animation.Animator
    public final void setInterpolator(TimeInterpolator r100) {
    }

    @Override // android.animation.Animator
    public final void setStartDelay(long r100) {
    }

    @Override // android.animation.Animator
    public final void cancel() {
        super.cancel();
        ((q4.b) this.f136784a.f136775c.getValue()).a();
        ((q4.b) this.f136784a.f136778f.getValue()).a();
        ((q4.b) this.f136784a.f136779g.getValue()).a();
    }

    public c(b r100) {
        this.f136784a = r100;
    }
}
