package com.stepos.widget.list;

import W3.C0403n;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import j4.g;
import j4.k;
import java.util.ArrayList;
import l3.C0844b;
import l3.C0846d;
import l3.C0847e;
import l3.l;
import l3.m;
import q3.C0986a;

/* loaded from: classes.dex */
public class StepOSListGroup extends LinearLayout {

    /* renamed from: g, reason: collision with root package name */
    public static final a f16150g = new a(null);

    /* renamed from: a, reason: collision with root package name */
    private int f16151a;

    /* renamed from: b, reason: collision with root package name */
    private float f16152b;

    /* renamed from: c, reason: collision with root package name */
    private Integer f16153c;

    /* renamed from: d, reason: collision with root package name */
    private int f16154d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f16155e;

    /* renamed from: f, reason: collision with root package name */
    private final C0986a f16156f;

    public static final class a {
        public /* synthetic */ a(g gVar) {
            this();
        }

        private a() {
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StepOSListGroup(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        k.g(context, "context");
    }

    private final void a() throws Resources.NotFoundException {
        if (this.f16151a == 1) {
            setBackground(null);
            setClipToOutline(false);
            int i5 = this.f16154d;
            setPadding(0, i5, 0, i5);
            return;
        }
        Integer num = this.f16153c;
        int iIntValue = num != null ? num.intValue() : getContext().getColor(C0846d.f18308o);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(this.f16152b);
        gradientDrawable.setColor(iIntValue);
        setBackground(gradientDrawable);
        setClipToOutline(true);
        setPadding(0, 0, 0, 0);
        e();
    }

    private final int b() {
        int childCount = getChildCount();
        do {
            childCount--;
            if (-1 >= childCount) {
                return -1;
            }
        } while (getChildAt(childCount).getVisibility() == 8);
        return childCount;
    }

    private final View c(int i5) {
        int childCount = getChildCount();
        for (int i6 = i5 + 1; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            if (childAt.getVisibility() != 8) {
                return childAt;
            }
        }
        return null;
    }

    private final boolean d(View view) {
        if (view == null || !view.isPressed()) {
            return false;
        }
        StepOSListItem stepOSListItem = view instanceof StepOSListItem ? (StepOSListItem) view : null;
        return stepOSListItem != null ? stepOSListItem.getPressFeedbackEnabled() : true;
    }

    private final void e() throws Resources.NotFoundException {
        int i5;
        float[] fArr;
        if (this.f16151a == 1) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        int childCount = getChildCount();
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            if ((childAt instanceof StepOSListItem) && ((StepOSListItem) childAt).getVisibility() != 8) {
                arrayList.add(childAt);
            }
        }
        int size = arrayList.size();
        if (size == 0) {
            return;
        }
        Integer num = this.f16153c;
        int iIntValue = num != null ? num.intValue() : getContext().getColor(C0846d.f18308o);
        float f5 = this.f16152b;
        int dimensionPixelSize = getResources().getDimensionPixelSize(C0847e.f18323D);
        int size2 = arrayList.size();
        int i7 = 0;
        int i8 = 0;
        while (i8 < size2) {
            Object obj = arrayList.get(i8);
            int i9 = i8 + 1;
            int i10 = i7 + 1;
            if (i7 < 0) {
                C0403n.q();
            }
            StepOSListItem stepOSListItem = (StepOSListItem) obj;
            if (size == 1) {
                i5 = 0;
                fArr = new float[]{f5, f5, f5, f5, f5, f5, f5, f5};
            } else {
                i5 = 0;
                fArr = i7 == 0 ? new float[]{f5, f5, f5, f5, 0.0f, 0.0f, 0.0f, 0.0f} : i7 == size + (-1) ? new float[]{0.0f, 0.0f, 0.0f, 0.0f, f5, f5, f5, f5} : new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
            }
            stepOSListItem.J(fArr, iIntValue, false, (size == 1 || i7 == 0) ? dimensionPixelSize : i5, (size == 1 || i7 == size + (-1)) ? dimensionPixelSize : i5);
            i8 = i9;
            i7 = i10;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        k.g(canvas, "canvas");
        super.dispatchDraw(canvas);
        if (!this.f16155e || this.f16156f.f() <= 0) {
            return;
        }
        int iB = b();
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount && i5 != iB; i5++) {
            View childAt = getChildAt(i5);
            if (childAt.getVisibility() != 8) {
                View viewC = c(i5);
                if (!d(childAt) && !d(viewC)) {
                    int dividerInsetStart = childAt instanceof StepOSListItem ? ((StepOSListItem) childAt).getDividerInsetStart() : this.f16156f.e();
                    int iE = this.f16156f.e();
                    this.f16156f.i(dividerInsetStart);
                    C0986a.c(this.f16156f, canvas, childAt.getBottom() - this.f16156f.f(), getWidth(), getLayoutDirection(), 0.0f, 16, null);
                    this.f16156f.i(iE);
                }
            }
        }
    }

    @Override // android.view.ViewGroup
    public void onViewAdded(View view) throws Resources.NotFoundException {
        super.onViewAdded(view);
        e();
    }

    @Override // android.view.ViewGroup
    public void onViewRemoved(View view) throws Resources.NotFoundException {
        super.onViewRemoved(view);
        e();
    }

    public final void setBackgroundMode(int i5) throws Resources.NotFoundException {
        this.f16151a = i5;
        a();
    }

    public final void setDividerColor(int i5) {
        this.f16156f.g(i5);
        invalidate();
    }

    public final void setGroupColor(Integer num) throws Resources.NotFoundException {
        this.f16153c = num;
        a();
    }

    public final void setGroupCornerRadius(float f5) throws Resources.NotFoundException {
        this.f16152b = f5;
        a();
    }

    public final void setShowDividers(boolean z5) {
        this.f16155e = z5;
        invalidate();
    }

    public /* synthetic */ StepOSListGroup(Context context, AttributeSet attributeSet, int i5, int i6, g gVar) {
        this(context, (i6 & 2) != 0 ? null : attributeSet, (i6 & 4) != 0 ? C0844b.f18285f : i5);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StepOSListGroup(Context context, AttributeSet attributeSet, int i5) throws Resources.NotFoundException {
        super(context, attributeSet, i5);
        k.g(context, "context");
        this.f16155e = true;
        C0986a c0986a = new C0986a();
        this.f16156f = c0986a;
        setOrientation(1);
        Resources resources = getResources();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, m.f18557K1, i5, l.f18492o);
        k.f(typedArrayObtainStyledAttributes, "obtainStyledAttributes(...)");
        this.f16151a = typedArrayObtainStyledAttributes.getInt(m.f18563L1, 0);
        this.f16152b = typedArrayObtainStyledAttributes.getDimension(m.f18575N1, resources.getDimension(C0847e.f18322C));
        int i6 = m.f18569M1;
        this.f16153c = typedArrayObtainStyledAttributes.hasValue(i6) ? Integer.valueOf(typedArrayObtainStyledAttributes.getColor(i6, 0)) : null;
        this.f16154d = typedArrayObtainStyledAttributes.getDimensionPixelSize(m.f18605S1, resources.getDimensionPixelSize(C0847e.f18323D));
        this.f16155e = typedArrayObtainStyledAttributes.getBoolean(m.f18611T1, true);
        c0986a.j(typedArrayObtainStyledAttributes.getDimensionPixelSize(m.f18587P1, resources.getDimensionPixelSize(C0847e.f18394z)));
        c0986a.i(typedArrayObtainStyledAttributes.getDimensionPixelSize(m.f18599R1, resources.getDimensionPixelSize(C0847e.f18321B)));
        c0986a.h(typedArrayObtainStyledAttributes.getDimensionPixelSize(m.f18593Q1, resources.getDimensionPixelSize(C0847e.f18320A)));
        c0986a.g(typedArrayObtainStyledAttributes.getColor(m.f18581O1, context.getColor(C0846d.f18307n)));
        typedArrayObtainStyledAttributes.recycle();
        setWillNotDraw(false);
        a();
    }
}
