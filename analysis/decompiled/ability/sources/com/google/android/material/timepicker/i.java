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
import com.stepos.ability.R;
import e3.o;

/* loaded from: classes3.dex */
public abstract class i extends ConstraintLayout {

    /* renamed from: a, reason: collision with root package name */
    public final h f2716a;
    public int b;
    public final e3.k c;

    /* JADX WARN: Type inference failed for: r6v2, types: [com.google.android.material.timepicker.h] */
    public i(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, R.attr.materialClockStyle);
        LayoutInflater.from(context).inflate(R.layout.material_radial_view_group, this);
        e3.k kVar = new e3.k();
        this.c = kVar;
        e3.m mVar = new e3.m(0.5f);
        o oVarF = kVar.b.f4345a.f();
        oVarF.e = mVar;
        oVarF.f = mVar;
        oVarF.g = mVar;
        oVarF.h = mVar;
        kVar.setShapeAppearanceModel(oVarF.a());
        this.c.q(ColorStateList.valueOf(-1));
        setBackground(this.c);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, P2.a.f1063B, R.attr.materialClockStyle, 0);
        this.b = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.f2716a = new Runnable() { // from class: com.google.android.material.timepicker.h
            @Override // java.lang.Runnable
            public final void run() {
                this.f2715a.a();
            }
        };
        typedArrayObtainStyledAttributes.recycle();
    }

    public abstract void a();

    @Override // android.view.ViewGroup
    public final void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i, layoutParams);
        if (view.getId() == -1) {
            view.setId(View.generateViewId());
        }
        Handler handler = getHandler();
        if (handler != null) {
            h hVar = this.f2716a;
            handler.removeCallbacks(hVar);
            handler.post(hVar);
        }
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        a();
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup
    public final void onViewRemoved(View view) {
        super.onViewRemoved(view);
        Handler handler = getHandler();
        if (handler != null) {
            h hVar = this.f2716a;
            handler.removeCallbacks(hVar);
            handler.post(hVar);
        }
    }

    @Override // android.view.View
    public final void setBackgroundColor(int i) {
        this.c.q(ColorStateList.valueOf(i));
    }
}
