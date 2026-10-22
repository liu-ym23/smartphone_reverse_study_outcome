package com.google.android.material.timepicker;

import Z2.h;
import Z2.j;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.material.R$id;
import com.google.android.material.R$layout;
import com.google.android.material.R$styleable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public class d extends ConstraintLayout {

    /* renamed from: a, reason: collision with root package name */
    public final Runnable f21761a;

    /* renamed from: b, reason: collision with root package name */
    public int f21762b;

    /* renamed from: c, reason: collision with root package name */
    public h f21763c;

    public d(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public static boolean h(View view) {
        return "skip".equals(view.getTag());
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i10, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i10, layoutParams);
        if (view.getId() == -1) {
            view.setId(View.generateViewId());
        }
        j();
    }

    public final void c(List<View> list, androidx.constraintlayout.widget.c cVar, int i10) {
        Iterator<View> it = list.iterator();
        float size = 0.0f;
        while (it.hasNext()) {
            cVar.u(it.next().getId(), R$id.circle_center, i10, size);
            size += 360.0f / list.size();
        }
    }

    public final Drawable d() {
        h hVar = new h();
        this.f21763c = hVar;
        hVar.d0(new j(0.5f));
        this.f21763c.g0(ColorStateList.valueOf(-1));
        return this.f21763c;
    }

    public int e(int i10) {
        int i11 = this.f21762b;
        return i10 == 2 ? Math.round(i11 * 0.66f) : i11;
    }

    public int f() {
        return this.f21762b;
    }

    public void g(int i10) {
        this.f21762b = i10;
        i();
    }

    public void i() {
        androidx.constraintlayout.widget.c cVar = new androidx.constraintlayout.widget.c();
        cVar.p(this);
        HashMap map = new HashMap();
        for (int i10 = 0; i10 < getChildCount(); i10++) {
            View childAt = getChildAt(i10);
            if (childAt.getId() != R$id.circle_center && !h(childAt)) {
                int i11 = (Integer) childAt.getTag(R$id.material_clock_level);
                if (i11 == null) {
                    i11 = 1;
                }
                if (!map.containsKey(i11)) {
                    map.put(i11, new ArrayList());
                }
                ((List) map.get(i11)).add(childAt);
            }
        }
        for (Map.Entry entry : map.entrySet()) {
            c((List) entry.getValue(), cVar, e(((Integer) entry.getKey()).intValue()));
        }
        cVar.i(this);
    }

    public final void j() {
        Handler handler = getHandler();
        if (handler != null) {
            handler.removeCallbacks(this.f21761a);
            handler.post(this.f21761a);
        }
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        i();
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup
    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        j();
    }

    @Override // android.view.View
    public void setBackgroundColor(int i10) {
        this.f21763c.g0(ColorStateList.valueOf(i10));
    }

    public d(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        LayoutInflater.from(context).inflate(R$layout.material_radial_view_group, this);
        setBackground(d());
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.RadialViewGroup, i10, 0);
        this.f21762b = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.RadialViewGroup_materialCircleRadius, 0);
        this.f21761a = new Runnable() { // from class: com.google.android.material.timepicker.c
            @Override // java.lang.Runnable
            public final void run() {
                this.f21760a.i();
            }
        };
        typedArrayObtainStyledAttributes.recycle();
    }
}
