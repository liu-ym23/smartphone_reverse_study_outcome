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
import androidx.constraintlayout.widget.c;
import com.stepos.aiengine.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import y4.j;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class i extends ConstraintLayout {

    /* renamed from: t, reason: collision with root package name */
    public final h f5388t;

    /* renamed from: u, reason: collision with root package name */
    public int f5389u;

    /* renamed from: v, reason: collision with root package name */
    public final y4.g f5390v;

    public i(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // android.view.ViewGroup
    public final void addView(View view, int i10, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i10, layoutParams);
        if (view.getId() == -1) {
            view.setId(View.generateViewId());
        }
        Handler handler = getHandler();
        if (handler != null) {
            h hVar = this.f5388t;
            handler.removeCallbacks(hVar);
            handler.post(hVar);
        }
    }

    public void m() {
        androidx.constraintlayout.widget.c cVar = new androidx.constraintlayout.widget.c();
        cVar.b(this);
        HashMap map = new HashMap();
        for (int i10 = 0; i10 < getChildCount(); i10++) {
            View childAt = getChildAt(i10);
            if (childAt.getId() != R.id.circle_center && !"skip".equals(childAt.getTag())) {
                int i11 = (Integer) childAt.getTag(R.id.material_clock_level);
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
            List list = (List) entry.getValue();
            int iRound = ((Integer) entry.getKey()).intValue() == 2 ? Math.round(this.f5389u * 0.66f) : this.f5389u;
            Iterator it = list.iterator();
            float size = 0.0f;
            while (it.hasNext()) {
                int id2 = ((View) it.next()).getId();
                Integer numValueOf = Integer.valueOf(id2);
                HashMap<Integer, c.a> map2 = cVar.f1341c;
                if (!map2.containsKey(numValueOf)) {
                    map2.put(Integer.valueOf(id2), new c.a());
                }
                c.b bVar = map2.get(Integer.valueOf(id2)).f1345d;
                bVar.z = R.id.circle_center;
                bVar.A = iRound;
                bVar.B = size;
                size += 360.0f / list.size();
            }
        }
        cVar.a(this);
        setConstraintSet(null);
        requestLayout();
    }

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
            h hVar = this.f5388t;
            handler.removeCallbacks(hVar);
            handler.post(hVar);
        }
    }

    @Override // android.view.View
    public final void setBackgroundColor(int i10) {
        this.f5390v.n(ColorStateList.valueOf(i10));
    }

    /* JADX WARN: Type inference failed for: r5v2, types: [com.google.android.material.timepicker.h] */
    public i(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        LayoutInflater.from(context).inflate(R.layout.material_radial_view_group, this);
        y4.g gVar = new y4.g();
        this.f5390v = gVar;
        y4.h hVar = new y4.h(0.5f);
        j.a aVarF = gVar.f14023b.f14044a.f();
        aVarF.f14077e = hVar;
        aVarF.f14078f = hVar;
        aVarF.f14079g = hVar;
        aVarF.h = hVar;
        gVar.setShapeAppearanceModel(aVarF.a());
        this.f5390v.n(ColorStateList.valueOf(-1));
        setBackground(this.f5390v);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, k4.a.B, i10, 0);
        this.f5389u = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.f5388t = new Runnable() { // from class: com.google.android.material.timepicker.h
            @Override // java.lang.Runnable
            public final void run() {
                this.f5387a.m();
            }
        };
        typedArrayObtainStyledAttributes.recycle();
    }
}
