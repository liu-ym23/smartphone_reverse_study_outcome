package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.appcompat.view.menu.ActionMenuItemView;
import com.stepos.alphame.utils.Property;
import d.C0527a;
import e.EnumC0546d;
import k.C0661o;
import k.C0663q;
import k.InterfaceC0642C;
import k.InterfaceC0659m;
import k.InterfaceC0660n;
import k.InterfaceC0672z;

/* loaded from: classes.dex */
public class ActionMenuView extends LinearLayoutCompat implements InterfaceC0660n, InterfaceC0642C {

    /* renamed from: A, reason: collision with root package name */
    public InterfaceC0224s f2786A;

    /* renamed from: p, reason: collision with root package name */
    public C0661o f2787p;

    /* renamed from: q, reason: collision with root package name */
    public Context f2788q;

    /* renamed from: r, reason: collision with root package name */
    public int f2789r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f2790s;

    /* renamed from: t, reason: collision with root package name */
    public C0217o f2791t;

    /* renamed from: u, reason: collision with root package name */
    public InterfaceC0672z f2792u;

    /* renamed from: v, reason: collision with root package name */
    public InterfaceC0659m f2793v;

    /* renamed from: w, reason: collision with root package name */
    public boolean f2794w;

    /* renamed from: x, reason: collision with root package name */
    public int f2795x;

    /* renamed from: y, reason: collision with root package name */
    public final int f2796y;

    /* renamed from: z, reason: collision with root package name */
    public final int f2797z;

    public ActionMenuView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        setBaselineAligned(false);
        float f4 = context.getResources().getDisplayMetrics().density;
        this.f2796y = (int) (56.0f * f4);
        this.f2797z = (int) (f4 * 4.0f);
        this.f2788q = context;
        this.f2789r = 0;
    }

    public static r n() {
        r rVar = new r(-2, -2);
        rVar.f3150a = false;
        ((LinearLayout.LayoutParams) rVar).gravity = 16;
        return rVar;
    }

    public static r o(ViewGroup.LayoutParams layoutParams) {
        r rVar;
        if (layoutParams == null) {
            return n();
        }
        if (layoutParams instanceof r) {
            r rVar2 = (r) layoutParams;
            rVar = new r(rVar2);
            rVar.f3150a = rVar2.f3150a;
        } else {
            rVar = new r(layoutParams);
        }
        if (((LinearLayout.LayoutParams) rVar).gravity <= 0) {
            ((LinearLayout.LayoutParams) rVar).gravity = 16;
        }
        return rVar;
    }

    @Override // k.InterfaceC0660n
    public final boolean a(C0663q c0663q) {
        return this.f2787p.q(c0663q, null, 0);
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof r;
    }

    @Override // android.view.View
    public final boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return false;
    }

    @Override // k.InterfaceC0642C
    public final void f(C0661o c0661o) {
        this.f2787p = c0661o;
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup
    public final /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return n();
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup
    public final /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return o(layoutParams);
    }

    public Menu getMenu() {
        if (this.f2787p == null) {
            Context context = getContext();
            C0661o c0661o = new C0661o(context);
            this.f2787p = c0661o;
            c0661o.f13242e = new C0527a(6, this);
            C0217o c0217o = new C0217o(context);
            this.f2791t = c0217o;
            c0217o.f3137l = true;
            c0217o.f3138m = true;
            InterfaceC0672z c0221q = this.f2792u;
            if (c0221q == null) {
                c0221q = new C0221q();
            }
            c0217o.f3130e = c0221q;
            this.f2787p.b(c0217o, this.f2788q);
            C0217o c0217o2 = this.f2791t;
            c0217o2.f3133h = this;
            this.f2787p = c0217o2.f3128c;
        }
        return this.f2787p;
    }

    @Nullable
    public Drawable getOverflowIcon() {
        getMenu();
        C0217o c0217o = this.f2791t;
        C0213m c0213m = c0217o.f3134i;
        if (c0213m != null) {
            return c0213m.getDrawable();
        }
        if (c0217o.f3136k) {
            return c0217o.f3135j;
        }
        return null;
    }

    public int getPopupTheme() {
        return this.f2789r;
    }

    @RestrictTo({EnumC0546d.f12494c})
    public int getWindowAnimations() {
        return 0;
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat
    /* renamed from: j */
    public final /* bridge */ /* synthetic */ C0237y0 generateDefaultLayoutParams() {
        return n();
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat
    /* renamed from: k */
    public final C0237y0 generateLayoutParams(AttributeSet attributeSet) {
        return new r(getContext(), attributeSet);
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat
    /* renamed from: l */
    public final /* bridge */ /* synthetic */ C0237y0 generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return o(layoutParams);
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        C0217o c0217o = this.f2791t;
        if (c0217o != null) {
            c0217o.a();
            if (this.f2791t.i()) {
                this.f2791t.g();
                this.f2791t.l();
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        C0217o c0217o = this.f2791t;
        if (c0217o != null) {
            c0217o.g();
            C0205i c0205i = c0217o.f3145t;
            if (c0205i == null || !c0205i.b()) {
                return;
            }
            c0205i.f13316j.dismiss();
        }
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z4, int i4, int i5, int i6, int i7) {
        int width;
        int paddingLeft;
        if (!this.f2794w) {
            super.onLayout(z4, i4, i5, i6, i7);
            return;
        }
        int childCount = getChildCount();
        int i8 = (i7 - i5) / 2;
        int dividerWidth = getDividerWidth();
        int i9 = i6 - i4;
        int paddingRight = (i9 - getPaddingRight()) - getPaddingLeft();
        boolean z5 = getLayoutDirection() == 1;
        int i10 = 0;
        int i11 = 0;
        for (int i12 = 0; i12 < childCount; i12++) {
            View childAt = getChildAt(i12);
            if (childAt.getVisibility() != 8) {
                r rVar = (r) childAt.getLayoutParams();
                if (rVar.f3150a) {
                    int measuredWidth = childAt.getMeasuredWidth();
                    if (p(i12)) {
                        measuredWidth += dividerWidth;
                    }
                    int measuredHeight = childAt.getMeasuredHeight();
                    if (z5) {
                        paddingLeft = getPaddingLeft() + ((LinearLayout.LayoutParams) rVar).leftMargin;
                        width = paddingLeft + measuredWidth;
                    } else {
                        width = (getWidth() - getPaddingRight()) - ((LinearLayout.LayoutParams) rVar).rightMargin;
                        paddingLeft = width - measuredWidth;
                    }
                    int i13 = i8 - (measuredHeight / 2);
                    childAt.layout(paddingLeft, i13, width, measuredHeight + i13);
                    paddingRight -= measuredWidth;
                    i10 = 1;
                } else {
                    paddingRight -= (childAt.getMeasuredWidth() + ((LinearLayout.LayoutParams) rVar).leftMargin) + ((LinearLayout.LayoutParams) rVar).rightMargin;
                    p(i12);
                    i11++;
                }
            }
        }
        if (childCount == 1 && i10 == 0) {
            View childAt2 = getChildAt(0);
            int measuredWidth2 = childAt2.getMeasuredWidth();
            int measuredHeight2 = childAt2.getMeasuredHeight();
            int i14 = (i9 / 2) - (measuredWidth2 / 2);
            int i15 = i8 - (measuredHeight2 / 2);
            childAt2.layout(i14, i15, measuredWidth2 + i14, measuredHeight2 + i15);
            return;
        }
        int i16 = i11 - (i10 ^ 1);
        int iMax = Math.max(0, i16 > 0 ? paddingRight / i16 : 0);
        if (z5) {
            int width2 = getWidth() - getPaddingRight();
            for (int i17 = 0; i17 < childCount; i17++) {
                View childAt3 = getChildAt(i17);
                r rVar2 = (r) childAt3.getLayoutParams();
                if (childAt3.getVisibility() != 8 && !rVar2.f3150a) {
                    int i18 = width2 - ((LinearLayout.LayoutParams) rVar2).rightMargin;
                    int measuredWidth3 = childAt3.getMeasuredWidth();
                    int measuredHeight3 = childAt3.getMeasuredHeight();
                    int i19 = i8 - (measuredHeight3 / 2);
                    childAt3.layout(i18 - measuredWidth3, i19, i18, measuredHeight3 + i19);
                    width2 = i18 - ((measuredWidth3 + ((LinearLayout.LayoutParams) rVar2).leftMargin) + iMax);
                }
            }
            return;
        }
        int paddingLeft2 = getPaddingLeft();
        for (int i20 = 0; i20 < childCount; i20++) {
            View childAt4 = getChildAt(i20);
            r rVar3 = (r) childAt4.getLayoutParams();
            if (childAt4.getVisibility() != 8 && !rVar3.f3150a) {
                int i21 = paddingLeft2 + ((LinearLayout.LayoutParams) rVar3).leftMargin;
                int measuredWidth4 = childAt4.getMeasuredWidth();
                int measuredHeight4 = childAt4.getMeasuredHeight();
                int i22 = i8 - (measuredHeight4 / 2);
                childAt4.layout(i21, i22, i21 + measuredWidth4, measuredHeight4 + i22);
                paddingLeft2 = measuredWidth4 + ((LinearLayout.LayoutParams) rVar3).rightMargin + iMax + i21;
            }
        }
    }

    /* JADX WARN: Type inference failed for: r1v20 */
    /* JADX WARN: Type inference failed for: r1v21, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r1v23 */
    /* JADX WARN: Type inference failed for: r1v26 */
    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.View
    public final void onMeasure(int i4, int i5) {
        int i6;
        int i7;
        int i8;
        boolean z4;
        int i9;
        int i10;
        int i11;
        int i12;
        ?? r12;
        int i13;
        int i14;
        int i15;
        C0661o c0661o;
        boolean z5 = this.f2794w;
        boolean z6 = View.MeasureSpec.getMode(i4) == 1073741824;
        this.f2794w = z6;
        if (z5 != z6) {
            this.f2795x = 0;
        }
        int size = View.MeasureSpec.getSize(i4);
        if (this.f2794w && (c0661o = this.f2787p) != null && size != this.f2795x) {
            this.f2795x = size;
            c0661o.p(true);
        }
        int childCount = getChildCount();
        if (!this.f2794w || childCount <= 0) {
            for (int i16 = 0; i16 < childCount; i16++) {
                r rVar = (r) getChildAt(i16).getLayoutParams();
                ((LinearLayout.LayoutParams) rVar).rightMargin = 0;
                ((LinearLayout.LayoutParams) rVar).leftMargin = 0;
            }
            super.onMeasure(i4, i5);
            return;
        }
        int mode = View.MeasureSpec.getMode(i5);
        int size2 = View.MeasureSpec.getSize(i4);
        int size3 = View.MeasureSpec.getSize(i5);
        int paddingRight = getPaddingRight() + getPaddingLeft();
        int paddingBottom = getPaddingBottom() + getPaddingTop();
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i5, paddingBottom, -2);
        int i17 = size2 - paddingRight;
        int i18 = this.f2796y;
        int i19 = i17 / i18;
        int i20 = i17 % i18;
        if (i19 == 0) {
            setMeasuredDimension(i17, 0);
            return;
        }
        int i21 = (i20 / i19) + i18;
        int childCount2 = getChildCount();
        int i22 = 0;
        int iMax = 0;
        int i23 = 0;
        boolean z7 = false;
        int i24 = 0;
        int iMax2 = 0;
        long j4 = 0;
        while (true) {
            i6 = this.f2797z;
            if (i23 >= childCount2) {
                break;
            }
            View childAt = getChildAt(i23);
            int i25 = size3;
            if (childAt.getVisibility() == 8) {
                i13 = i17;
                i14 = paddingBottom;
            } else {
                boolean z8 = childAt instanceof ActionMenuItemView;
                int i26 = i22 + 1;
                if (z8) {
                    childAt.setPadding(i6, 0, i6, 0);
                }
                r rVar2 = (r) childAt.getLayoutParams();
                rVar2.f3155f = false;
                rVar2.f3152c = 0;
                rVar2.f3151b = 0;
                rVar2.f3153d = false;
                ((LinearLayout.LayoutParams) rVar2).leftMargin = 0;
                ((LinearLayout.LayoutParams) rVar2).rightMargin = 0;
                rVar2.f3154e = z8 && (TextUtils.isEmpty(((ActionMenuItemView) childAt).getText()) ^ true);
                int i27 = rVar2.f3150a ? 1 : i19;
                r rVar3 = (r) childAt.getLayoutParams();
                i13 = i17;
                i14 = paddingBottom;
                int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(childMeasureSpec) - paddingBottom, View.MeasureSpec.getMode(childMeasureSpec));
                ActionMenuItemView actionMenuItemView = z8 ? (ActionMenuItemView) childAt : null;
                boolean z9 = actionMenuItemView != null && (TextUtils.isEmpty(actionMenuItemView.getText()) ^ true);
                if (i27 <= 0 || (z9 && i27 < 2)) {
                    i15 = 0;
                } else {
                    childAt.measure(View.MeasureSpec.makeMeasureSpec(i27 * i21, Integer.MIN_VALUE), iMakeMeasureSpec);
                    int measuredWidth = childAt.getMeasuredWidth();
                    i15 = measuredWidth / i21;
                    if (measuredWidth % i21 != 0) {
                        i15++;
                    }
                    if (z9 && i15 < 2) {
                        i15 = 2;
                    }
                }
                rVar3.f3153d = !rVar3.f3150a && z9;
                rVar3.f3151b = i15;
                childAt.measure(View.MeasureSpec.makeMeasureSpec(i15 * i21, 1073741824), iMakeMeasureSpec);
                iMax = Math.max(iMax, i15);
                if (rVar2.f3153d) {
                    i24++;
                }
                if (rVar2.f3150a) {
                    z7 = true;
                }
                i19 -= i15;
                iMax2 = Math.max(iMax2, childAt.getMeasuredHeight());
                if (i15 == 1) {
                    j4 |= 1 << i23;
                }
                i22 = i26;
            }
            i23++;
            size3 = i25;
            paddingBottom = i14;
            i17 = i13;
        }
        int i28 = i17;
        int i29 = size3;
        int i30 = iMax2;
        boolean z10 = z7 && i22 == 2;
        boolean z11 = false;
        while (i24 > 0 && i19 > 0) {
            int i31 = Integer.MAX_VALUE;
            int i32 = 0;
            int i33 = 0;
            long j5 = 0;
            while (i33 < childCount2) {
                int i34 = i30;
                r rVar4 = (r) getChildAt(i33).getLayoutParams();
                boolean z12 = z11;
                if (rVar4.f3153d) {
                    int i35 = rVar4.f3151b;
                    if (i35 < i31) {
                        j5 = 1 << i33;
                        i31 = i35;
                        i32 = 1;
                    } else if (i35 == i31) {
                        i32++;
                        j5 |= 1 << i33;
                    }
                }
                i33++;
                z11 = z12;
                i30 = i34;
            }
            i8 = i30;
            z4 = z11;
            j4 |= j5;
            if (i32 > i19) {
                i7 = mode;
                break;
            }
            int i36 = i31 + 1;
            int i37 = 0;
            while (i37 < childCount2) {
                View childAt2 = getChildAt(i37);
                r rVar5 = (r) childAt2.getLayoutParams();
                int i38 = mode;
                int i39 = childMeasureSpec;
                int i40 = childCount2;
                long j6 = 1 << i37;
                if ((j5 & j6) != 0) {
                    if (z10 && rVar5.f3154e) {
                        r12 = 1;
                        r12 = 1;
                        if (i19 == 1) {
                            childAt2.setPadding(i6 + i21, 0, i6, 0);
                        }
                    } else {
                        r12 = 1;
                    }
                    rVar5.f3151b += r12;
                    rVar5.f3155f = r12;
                    i19--;
                } else if (rVar5.f3151b == i36) {
                    j4 |= j6;
                }
                i37++;
                childMeasureSpec = i39;
                mode = i38;
                childCount2 = i40;
            }
            i30 = i8;
            z11 = true;
        }
        i7 = mode;
        i8 = i30;
        z4 = z11;
        int i41 = childMeasureSpec;
        int i42 = childCount2;
        boolean z13 = !z7 && i22 == 1;
        if (i19 <= 0 || j4 == 0 || (i19 >= i22 - 1 && !z13 && iMax <= 1)) {
            i9 = i42;
        } else {
            float fBitCount = Long.bitCount(j4);
            if (!z13) {
                if ((j4 & 1) != 0 && !((r) getChildAt(0).getLayoutParams()).f3154e) {
                    fBitCount -= 0.5f;
                }
                int i43 = i42 - 1;
                if ((j4 & (1 << i43)) != 0 && !((r) getChildAt(i43).getLayoutParams()).f3154e) {
                    fBitCount -= 0.5f;
                }
            }
            int i44 = fBitCount > Property.DEFAULT_FLOAT_VALUE ? (int) ((i19 * i21) / fBitCount) : 0;
            i9 = i42;
            for (int i45 = 0; i45 < i9; i45++) {
                if ((j4 & (1 << i45)) != 0) {
                    View childAt3 = getChildAt(i45);
                    r rVar6 = (r) childAt3.getLayoutParams();
                    if (childAt3 instanceof ActionMenuItemView) {
                        rVar6.f3152c = i44;
                        rVar6.f3155f = true;
                        if (i45 == 0 && !rVar6.f3154e) {
                            ((LinearLayout.LayoutParams) rVar6).leftMargin = (-i44) / 2;
                        }
                        z4 = true;
                    } else if (rVar6.f3150a) {
                        rVar6.f3152c = i44;
                        rVar6.f3155f = true;
                        ((LinearLayout.LayoutParams) rVar6).rightMargin = (-i44) / 2;
                        z4 = true;
                    } else {
                        if (i45 != 0) {
                            ((LinearLayout.LayoutParams) rVar6).leftMargin = i44 / 2;
                        }
                        if (i45 != i9 - 1) {
                            ((LinearLayout.LayoutParams) rVar6).rightMargin = i44 / 2;
                        }
                    }
                }
            }
        }
        if (z4) {
            int i46 = 0;
            while (i46 < i9) {
                View childAt4 = getChildAt(i46);
                r rVar7 = (r) childAt4.getLayoutParams();
                if (rVar7.f3155f) {
                    i12 = i41;
                    childAt4.measure(View.MeasureSpec.makeMeasureSpec((rVar7.f3151b * i21) + rVar7.f3152c, 1073741824), i12);
                } else {
                    i12 = i41;
                }
                i46++;
                i41 = i12;
            }
        }
        if (i7 != 1073741824) {
            i11 = i28;
            i10 = i8;
        } else {
            i10 = i29;
            i11 = i28;
        }
        setMeasuredDimension(i11, i10);
    }

    public final boolean p(int i4) {
        boolean zA = false;
        if (i4 == 0) {
            return false;
        }
        KeyEvent.Callback childAt = getChildAt(i4 - 1);
        KeyEvent.Callback childAt2 = getChildAt(i4);
        if (i4 < getChildCount() && (childAt instanceof InterfaceC0219p)) {
            zA = ((InterfaceC0219p) childAt).a();
        }
        return (i4 <= 0 || !(childAt2 instanceof InterfaceC0219p)) ? zA : zA | ((InterfaceC0219p) childAt2).b();
    }

    @RestrictTo({EnumC0546d.f12494c})
    public void setExpandedActionViewsExclusive(boolean z4) {
        this.f2791t.f3142q = z4;
    }

    public void setOnMenuItemClickListener(InterfaceC0224s interfaceC0224s) {
        this.f2786A = interfaceC0224s;
    }

    public void setOverflowIcon(@Nullable Drawable drawable) {
        getMenu();
        C0217o c0217o = this.f2791t;
        C0213m c0213m = c0217o.f3134i;
        if (c0213m != null) {
            c0213m.setImageDrawable(drawable);
        } else {
            c0217o.f3136k = true;
            c0217o.f3135j = drawable;
        }
    }

    @RestrictTo({EnumC0546d.f12494c})
    public void setOverflowReserved(boolean z4) {
        this.f2790s = z4;
    }

    public void setPopupTheme(@StyleRes int i4) {
        if (this.f2789r != i4) {
            this.f2789r = i4;
            if (i4 == 0) {
                this.f2788q = getContext();
            } else {
                this.f2788q = new ContextThemeWrapper(getContext(), i4);
            }
        }
    }

    @RestrictTo({EnumC0546d.f12492a})
    public void setPresenter(C0217o c0217o) {
        this.f2791t = c0217o;
        c0217o.f3133h = this;
        this.f2787p = c0217o.f3128c;
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new r(getContext(), attributeSet);
    }
}
