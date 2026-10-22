package com.stepos.common.animator;

import android.view.MotionEvent;
import android.view.View;
import androidx.dynamicanimation.animation.i;
import androidx.dynamicanimation.animation.j;

/* loaded from: classes3.dex */
public class a {
    private static final float DEFAULT_DAMPING = 0.89f;
    private static final float DEFAULT_STIFFNESS = 250.0f;
    private static final String TAG = "a";
    private i mScaleXAnim;
    private i mScaleYAnim;
    private View mSeekBar;
    private float mTouchScaledX = 1.0f;
    private float mTouchScaledY = 1.0f;
    private boolean mTouchScaleEnable = true;

    public a(View view) {
        this.mSeekBar = view;
    }

    public final void a() {
        i iVar = this.mScaleXAnim;
        if (iVar != null && iVar.i()) {
            this.mScaleXAnim.d();
        }
        i iVar2 = this.mScaleYAnim;
        if (iVar2 == null || !iVar2.i()) {
            return;
        }
        this.mScaleYAnim.d();
    }

    public final i b(boolean z10) {
        i iVar = new i(this.mSeekBar, androidx.dynamicanimation.animation.e.f13693q);
        j jVar = new j();
        jVar.g(z10 ? this.mTouchScaledX : 1.0f);
        jVar.h(DEFAULT_STIFFNESS).f(0.89f);
        iVar.B(jVar);
        return iVar;
    }

    public final i c(boolean z10) {
        i iVar = new i(this.mSeekBar, androidx.dynamicanimation.animation.e.f13694r);
        j jVar = new j();
        jVar.g(z10 ? this.mTouchScaledY : 1.0f);
        jVar.h(DEFAULT_STIFFNESS).f(0.89f);
        iVar.B(jVar);
        return iVar;
    }

    public final void d(boolean z10) {
        a();
        i iVarC = c(z10);
        this.mScaleYAnim = iVarC;
        iVarC.t();
        i iVarB = b(z10);
        this.mScaleXAnim = iVarB;
        iVarB.t();
    }

    public boolean e(MotionEvent motionEvent) {
        if (!this.mTouchScaleEnable) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            d(true);
        } else if (actionMasked == 1 || actionMasked == 3) {
            d(false);
        }
        return false;
    }

    public void f(float f10, float f11) {
        this.mTouchScaledX = f10;
        this.mTouchScaledY = f11;
    }

    public void g(boolean z10) {
        this.mTouchScaleEnable = z10;
    }
}
