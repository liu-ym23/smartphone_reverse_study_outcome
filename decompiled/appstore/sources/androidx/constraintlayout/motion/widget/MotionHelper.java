package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintHelper;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.R$styleable;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public class MotionHelper extends ConstraintHelper implements MotionHelperInterface {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f1721j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f1722k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public float f1723l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public View[] f1724m;

    public MotionHelper(Context r10) {
        super(r10);
        this.f1721j = false;
        this.f1722k = false;
    }

    @Override // androidx.constraintlayout.motion.widget.Animatable
    public float getProgress() {
        return this.f1723l;
    }

    public boolean isDecorator() {
        return false;
    }

    @Override // androidx.constraintlayout.motion.widget.MotionHelperInterface
    public boolean isUseOnHide() {
        return this.f1722k;
    }

    @Override // androidx.constraintlayout.motion.widget.MotionHelperInterface
    public boolean isUsedOnShow() {
        return this.f1721j;
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    public void k(AttributeSet r10) {
        super.k(r10);
        if (r10 == null) goto L19;
        TypedArray r11 = getContext().obtainStyledAttributes(r10, R$styleable.MotionHelper);
        int r12 = r11.getIndexCount();
        int r13 = 0;
    L5:
        if (r13 >= r12) goto L13;
        int r14 = r11.getIndex(r13);
        if (r14 != R$styleable.MotionHelper_onShow) goto L10;
        this.f1721j = r11.getBoolean(r14, this.f1721j);
    L12:
        r13 = r13 + 1;
        goto L5
    L10:
        if (r14 != R$styleable.MotionHelper_onHide) goto L12;
        this.f1722k = r11.getBoolean(r14, this.f1722k);
        goto L12
    L13:
        r11.recycle();
        return;
    }

    @Override // androidx.constraintlayout.motion.widget.MotionHelperInterface
    public void onFinishedMotionScene(MotionLayout r10) {
    }

    @Override // androidx.constraintlayout.motion.widget.MotionHelperInterface
    public void onPostDraw(Canvas r10) {
    }

    @Override // androidx.constraintlayout.motion.widget.MotionHelperInterface
    public void onPreDraw(Canvas r10) {
    }

    public void onPreSetup(MotionLayout r10, HashMap r11) {
    }

    public void onTransitionChange(MotionLayout r10, int r11, int r12, float r13) {
    }

    public void onTransitionCompleted(MotionLayout r10, int r11) {
    }

    @Override // androidx.constraintlayout.motion.widget.MotionLayout.TransitionListener
    public void onTransitionStarted(MotionLayout r10, int r11, int r12) {
    }

    @Override // androidx.constraintlayout.motion.widget.MotionLayout.TransitionListener
    public void onTransitionTrigger(MotionLayout r10, int r11, boolean r12, float r13) {
    }

    @Override // androidx.constraintlayout.motion.widget.Animatable
    public void setProgress(float r10) {
        this.f1723l = r10;
        int r11 = 0;
        if (this.f2178b <= 0) goto L8;
        this.f1724m = j((ConstraintLayout) getParent());
    L6:
        if (r11 >= this.f2178b) goto L15;
        t(this.f1724m[r11], r10);
        r11 = r11 + 1;
        goto L6
    L15:
        return;
    L8:
        ViewGroup r12 = (ViewGroup) getParent();
        int r13 = r12.getChildCount();
    L9:
        if (r11 >= r13) goto L20;
        View r14 = r12.getChildAt(r11);
        if ((r14 instanceof MotionHelper) == true) goto L14;
        t(r14, r10);
    L14:
        r11 = r11 + 1;
        goto L9
    }

    public void t(View r10, float r11) {
    }

    public MotionHelper(Context r10, AttributeSet r11) {
        super(r10, r11);
        this.f1721j = false;
        this.f1722k = false;
        k(r11);
    }

    public MotionHelper(Context r10, AttributeSet r11, int r12) {
        super(r10, r11, r12);
        this.f1721j = false;
        this.f1722k = false;
        k(r11);
    }
}
