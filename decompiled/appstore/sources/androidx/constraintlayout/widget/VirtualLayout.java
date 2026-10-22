package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import androidx.constraintlayout.core.widgets.h;

/* JADX INFO: loaded from: classes.dex */
public abstract class VirtualLayout extends ConstraintHelper {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f2387j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f2388k;

    public VirtualLayout(Context r10) {
        super(r10);
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    public void f(ConstraintLayout r10) {
        e(r10);
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    public void k(AttributeSet r10) {
        super.k(r10);
        if (r10 == null) goto L19;
        TypedArray r11 = getContext().obtainStyledAttributes(r10, R$styleable.ConstraintLayout_Layout);
        int r12 = r11.getIndexCount();
        int r13 = 0;
    L5:
        if (r13 >= r12) goto L13;
        int r14 = r11.getIndex(r13);
        if (r14 != R$styleable.ConstraintLayout_Layout_android_visibility) goto L10;
        this.f2387j = true;
    L12:
        r13 = r13 + 1;
        goto L5
    L10:
        if (r14 != R$styleable.ConstraintLayout_Layout_android_elevation) goto L12;
        this.f2388k = true;
        goto L12
    L13:
        r11.recycle();
        return;
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f2387j == false) goto L5;
    L6:
        ViewParent r10 = getParent();
        if ((r10 instanceof ConstraintLayout) == false) goto L28;
        ConstraintLayout r11 = (ConstraintLayout) r10;
        int r12 = getVisibility();
        float r13 = getElevation();
        int r14 = 0;
    L10:
        if (r14 >= this.f2178b) goto L29;
        View r15 = r11.getViewById(this.f2177a[r14]);
        if (r15 == null) goto L21;
        if (this.f2387j == false) goto L17;
        r15.setVisibility(r12);
    L17:
        if (this.f2388k == false) goto L21;
        if (r13 <= 0.0f) goto L21;
        r15.setTranslationZ(r15.getTranslationZ() + r13);
    L21:
        r14 = r14 + 1;
        goto L10
    L29:
        return;
    L28:
        return;
    L5:
        if (this.f2388k == true) goto L6;
    }

    @Override // android.view.View
    public void setElevation(float r10) {
        super.setElevation(r10);
        d();
    }

    @Override // android.view.View
    public void setVisibility(int r10) {
        super.setVisibility(r10);
        d();
    }

    public void t(h r10, int r11, int r12) {
    }

    public VirtualLayout(Context r10, AttributeSet r11) {
        super(r10, r11);
    }

    public VirtualLayout(Context r10, AttributeSet r11, int r12) {
        super(r10, r11, r12);
    }
}
