package com.google.android.material.timepicker;

import a1.C0413f;
import a1.C0415h;
import a1.C0418k;
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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import t1.C1115h;
import t1.j;

/* loaded from: classes.dex */
class d extends ConstraintLayout {

    /* renamed from: A, reason: collision with root package name */
    private C1115h f13494A;

    /* renamed from: y, reason: collision with root package name */
    private final Runnable f13495y;

    /* renamed from: z, reason: collision with root package name */
    private int f13496z;

    public d(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void B(List<View> list, androidx.constraintlayout.widget.d dVar, int i5) {
        Iterator<View> it = list.iterator();
        float size = 0.0f;
        while (it.hasNext()) {
            dVar.k(it.next().getId(), C0413f.f6840c, i5, size);
            size += 360.0f / list.size();
        }
    }

    private Drawable C() {
        C1115h c1115h = new C1115h();
        this.f13494A = c1115h;
        c1115h.d0(new j(0.5f));
        this.f13494A.g0(ColorStateList.valueOf(-1));
        return this.f13494A;
    }

    private static boolean G(View view) {
        return "skip".equals(view.getTag());
    }

    private void I() {
        Handler handler = getHandler();
        if (handler != null) {
            handler.removeCallbacks(this.f13495y);
            handler.post(this.f13495y);
        }
    }

    int D(int i5) {
        int i6 = this.f13496z;
        return i5 == 2 ? Math.round(i6 * 0.66f) : i6;
    }

    public int E() {
        return this.f13496z;
    }

    public void F(int i5) {
        this.f13496z = i5;
        H();
    }

    protected void H() {
        androidx.constraintlayout.widget.d dVar = new androidx.constraintlayout.widget.d();
        dVar.g(this);
        HashMap map = new HashMap();
        for (int i5 = 0; i5 < getChildCount(); i5++) {
            View childAt = getChildAt(i5);
            if (childAt.getId() != C0413f.f6840c && !G(childAt)) {
                int i6 = (Integer) childAt.getTag(C0413f.f6848k);
                if (i6 == null) {
                    i6 = 1;
                }
                if (!map.containsKey(i6)) {
                    map.put(i6, new ArrayList());
                }
                ((List) map.get(i6)).add(childAt);
            }
        }
        for (Map.Entry entry : map.entrySet()) {
            B((List) entry.getValue(), dVar, D(((Integer) entry.getKey()).intValue()));
        }
        dVar.c(this);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i5, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i5, layoutParams);
        if (view.getId() == -1) {
            view.setId(View.generateViewId());
        }
        I();
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        H();
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup
    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        I();
    }

    @Override // android.view.View
    public void setBackgroundColor(int i5) {
        this.f13494A.g0(ColorStateList.valueOf(i5));
    }

    public d(Context context, AttributeSet attributeSet, int i5) {
        super(context, attributeSet, i5);
        LayoutInflater.from(context).inflate(C0415h.f6872f, this);
        setBackground(C());
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0418k.f7029P3, i5, 0);
        this.f13496z = typedArrayObtainStyledAttributes.getDimensionPixelSize(C0418k.f7035Q3, 0);
        this.f13495y = new Runnable() { // from class: com.google.android.material.timepicker.c
            @Override // java.lang.Runnable
            public final void run() {
                this.f13493a.H();
            }
        };
        typedArrayObtainStyledAttributes.recycle();
    }
}
