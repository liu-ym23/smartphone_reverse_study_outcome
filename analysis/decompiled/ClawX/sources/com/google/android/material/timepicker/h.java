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
import com.stepos.stepclaw.R;
import t1.m;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public abstract class h extends ConstraintLayout {

    /* renamed from: t, reason: collision with root package name */
    public final g f1422t;

    /* renamed from: u, reason: collision with root package name */
    public int f1423u;

    /* renamed from: v, reason: collision with root package name */
    public final t1.j f1424v;

    /* JADX WARN: Type inference failed for: r6v2, types: [com.google.android.material.timepicker.g] */
    public h(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, R.attr.materialClockStyle);
        LayoutInflater.from(context).inflate(R.layout.material_radial_view_group, this);
        t1.j jVar = new t1.j();
        this.f1424v = jVar;
        t1.k kVar = new t1.k(0.5f);
        m mVarF = jVar.f5475b.f5457a.f();
        mVarF.f5500e = kVar;
        mVarF.f5501f = kVar;
        mVarF.f5502g = kVar;
        mVarF.f5503h = kVar;
        jVar.setShapeAppearanceModel(mVarF.a());
        this.f1424v.m(ColorStateList.valueOf(-1));
        setBackground(this.f1424v);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d1.a.f1775q, R.attr.materialClockStyle, 0);
        this.f1423u = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.f1422t = new Runnable() { // from class: com.google.android.material.timepicker.g
            @Override // java.lang.Runnable
            public final void run() {
                this.f1421a.m();
            }
        };
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // android.view.ViewGroup
    public final void addView(View view, int i8, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i8, layoutParams);
        if (view.getId() == -1) {
            view.setId(View.generateViewId());
        }
        Handler handler = getHandler();
        if (handler != null) {
            g gVar = this.f1422t;
            handler.removeCallbacks(gVar);
            handler.post(gVar);
        }
    }

    public abstract void m();

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        m();
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup
    public final void onViewRemoved(View view) {
        super.onViewRemoved(view);
        Handler handler = getHandler();
        if (handler != null) {
            g gVar = this.f1422t;
            handler.removeCallbacks(gVar);
            handler.post(gVar);
        }
    }

    @Override // android.view.View
    public final void setBackgroundColor(int i8) {
        this.f1424v.m(ColorStateList.valueOf(i8));
    }
}
