package com.google.android.material.timepicker;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.stepos.alphame.R;
import m1.AbstractC0769a;

/* loaded from: classes.dex */
public abstract class h extends ConstraintLayout {

    /* renamed from: s, reason: collision with root package name */
    public final g f11166s;

    /* renamed from: t, reason: collision with root package name */
    public int f11167t;

    /* renamed from: u, reason: collision with root package name */
    public final y1.j f11168u;

    /* JADX WARN: Type inference failed for: r6v2, types: [com.google.android.material.timepicker.g] */
    public h(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, R.attr.materialClockStyle);
        LayoutInflater.from(context).inflate(R.layout.material_radial_view_group, this);
        y1.j jVar = new y1.j();
        this.f11168u = jVar;
        y1.k kVar = new y1.k(0.5f);
        y1.m mVarF = jVar.f16234b.f16203a.f();
        mVarF.f16264e = kVar;
        mVarF.f16265f = kVar;
        mVarF.f16266g = kVar;
        mVarF.f16267h = kVar;
        jVar.setShapeAppearanceModel(mVarF.a());
        this.f11168u.o(ColorStateList.valueOf(-1));
        setBackground(this.f11168u);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC0769a.f13526A, R.attr.materialClockStyle, 0);
        this.f11167t = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.f11166s = new Runnable() { // from class: com.google.android.material.timepicker.g
            @Override // java.lang.Runnable
            public final void run() {
                this.f11165a.h();
            }
        };
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // android.view.ViewGroup
    public final void addView(View view, int i4, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i4, layoutParams);
        if (view.getId() == -1) {
            view.setId(View.generateViewId());
        }
        Handler handler = getHandler();
        if (handler != null) {
            g gVar = this.f11166s;
            handler.removeCallbacks(gVar);
            handler.post(gVar);
        }
    }

    public abstract void h();

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        h();
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup
    public final void onViewRemoved(View view) {
        super.onViewRemoved(view);
        Handler handler = getHandler();
        if (handler != null) {
            g gVar = this.f11166s;
            handler.removeCallbacks(gVar);
            handler.post(gVar);
        }
    }

    @Override // android.view.View
    public final void setBackgroundColor(int i4) {
        this.f11168u.o(ColorStateList.valueOf(i4));
    }
}
