package com.stepos.common.animator;

import android.view.animation.Interpolator;

/* loaded from: classes.dex */
public final /* synthetic */ class e implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f11290a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ W.m f11291b;

    public /* synthetic */ e(W.m mVar, int i4) {
        this.f11290a = i4;
        this.f11291b = mVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i4 = this.f11290a;
        W.m mVar = this.f11291b;
        switch (i4) {
            case 0:
                Interpolator interpolator = StepOSPressAnimationDrawable.f11238C;
                if (mVar != null) {
                    mVar.i();
                    break;
                }
                break;
            default:
                if (mVar != null) {
                    mVar.i();
                    break;
                }
                break;
        }
    }
}
