package com.stepos.common.animator;

import h1.d;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class c implements d.l {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ StepOSPressAnimationDrawable f6466a;

    public c(StepOSPressAnimationDrawable stepOSPressAnimationDrawable) {
        this.f6466a = stepOSPressAnimationDrawable;
    }

    @Override // h1.d.l
    public final void a(float f8) {
        StepOSPressAnimationDrawable stepOSPressAnimationDrawable = this.f6466a;
        stepOSPressAnimationDrawable.f6428e = f8 / 100.0f;
        stepOSPressAnimationDrawable.invalidateSelf();
    }
}
