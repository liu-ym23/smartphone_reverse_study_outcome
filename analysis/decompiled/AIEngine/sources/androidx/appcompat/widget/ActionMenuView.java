package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.widget.LinearLayout;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.view.menu.f;
import androidx.appcompat.view.menu.j;
import androidx.appcompat.widget.ActionMenuPresenter;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.appcompat.widget.Toolbar;
import java.util.Iterator;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class ActionMenuView extends LinearLayoutCompat implements f.b, androidx.appcompat.view.menu.k {
    public final int A;
    public final int B;
    public e C;

    /* renamed from: s, reason: collision with root package name */
    public androidx.appcompat.view.menu.f f617s;

    /* renamed from: t, reason: collision with root package name */
    public Context f618t;

    /* renamed from: u, reason: collision with root package name */
    public int f619u;

    /* renamed from: v, reason: collision with root package name */
    public boolean f620v;

    /* renamed from: w, reason: collision with root package name */
    public ActionMenuPresenter f621w;

    /* renamed from: x, reason: collision with root package name */
    public Toolbar.c f622x;

    /* renamed from: y, reason: collision with root package name */
    public boolean f623y;
    public int z;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public interface a {
        boolean a();

        boolean b();
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class c extends LinearLayoutCompat.a {

        /* renamed from: a, reason: collision with root package name */
        @ViewDebug.ExportedProperty
        public boolean f624a;

        /* renamed from: b, reason: collision with root package name */
        @ViewDebug.ExportedProperty
        public int f625b;

        /* renamed from: c, reason: collision with root package name */
        @ViewDebug.ExportedProperty
        public int f626c;

        /* renamed from: d, reason: collision with root package name */
        @ViewDebug.ExportedProperty
        public boolean f627d;

        /* renamed from: e, reason: collision with root package name */
        @ViewDebug.ExportedProperty
        public boolean f628e;

        /* renamed from: f, reason: collision with root package name */
        public boolean f629f;
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class d implements f.a {
        public d() {
        }

        @Override // androidx.appcompat.view.menu.f.a
        public final boolean a(androidx.appcompat.view.menu.f fVar, MenuItem menuItem) {
            e eVar = ActionMenuView.this.C;
            if (eVar == null) {
                return false;
            }
            Iterator<v0.l> it = Toolbar.this.J.f13295b.iterator();
            while (it.hasNext()) {
                if (it.next().c(menuItem)) {
                    return true;
                }
            }
            return false;
        }

        @Override // androidx.appcompat.view.menu.f.a
        public final void b(androidx.appcompat.view.menu.f fVar) {
            Toolbar.c cVar = ActionMenuView.this.f622x;
            if (cVar != null) {
                cVar.b(fVar);
            }
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public interface e {
    }

    public ActionMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setBaselineAligned(false);
        float f8 = context.getResources().getDisplayMetrics().density;
        this.A = (int) (56.0f * f8);
        this.B = (int) (f8 * 4.0f);
        this.f618t = context;
        this.f619u = 0;
    }

    public static c l() {
        c cVar = new c(-2, -2);
        cVar.f624a = false;
        ((LinearLayout.LayoutParams) cVar).gravity = 16;
        return cVar;
    }

    public static c m(ViewGroup.LayoutParams layoutParams) {
        c cVar;
        if (layoutParams == null) {
            return l();
        }
        if (layoutParams instanceof c) {
            c cVar2 = (c) layoutParams;
            cVar = new c(cVar2);
            cVar.f624a = cVar2.f624a;
        } else {
            cVar = new c(layoutParams);
        }
        if (((LinearLayout.LayoutParams) cVar).gravity <= 0) {
            ((LinearLayout.LayoutParams) cVar).gravity = 16;
        }
        return cVar;
    }

    @Override // androidx.appcompat.view.menu.k
    public final void c(androidx.appcompat.view.menu.f fVar) {
        this.f617s = fVar;
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof c;
    }

    @Override // android.view.View
    public final boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.f.b
    public final boolean e(androidx.appcompat.view.menu.h hVar) {
        return this.f617s.q(hVar, null, 0);
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup
    public final /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return l();
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup
    public final /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return m(layoutParams);
    }

    public Menu getMenu() {
        if (this.f617s == null) {
            Context context = getContext();
            androidx.appcompat.view.menu.f fVar = new androidx.appcompat.view.menu.f(context);
            this.f617s = fVar;
            fVar.f482e = new d();
            ActionMenuPresenter actionMenuPresenter = new ActionMenuPresenter(context);
            this.f621w = actionMenuPresenter;
            actionMenuPresenter.f599o = true;
            actionMenuPresenter.f600p = true;
            actionMenuPresenter.f434e = new b();
            this.f617s.b(actionMenuPresenter, this.f618t);
            ActionMenuPresenter actionMenuPresenter2 = this.f621w;
            actionMenuPresenter2.f436k = this;
            this.f617s = actionMenuPresenter2.f432c;
        }
        return this.f617s;
    }

    public Drawable getOverflowIcon() {
        getMenu();
        ActionMenuPresenter actionMenuPresenter = this.f621w;
        ActionMenuPresenter.d dVar = actionMenuPresenter.f596l;
        if (dVar != null) {
            return dVar.getDrawable();
        }
        if (actionMenuPresenter.f598n) {
            return actionMenuPresenter.f597m;
        }
        return null;
    }

    public int getPopupTheme() {
        return this.f619u;
    }

    public int getWindowAnimations() {
        return 0;
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat
    /* renamed from: h */
    public final /* bridge */ /* synthetic */ LinearLayoutCompat.a generateDefaultLayoutParams() {
        return l();
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat
    /* renamed from: i */
    public final LinearLayoutCompat.a generateLayoutParams(AttributeSet attributeSet) {
        return new c(getContext(), attributeSet);
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat
    /* renamed from: j */
    public final /* bridge */ /* synthetic */ LinearLayoutCompat.a generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return m(layoutParams);
    }

    public final boolean n(int i10) {
        boolean zA = false;
        if (i10 == 0) {
            return false;
        }
        KeyEvent.Callback childAt = getChildAt(i10 - 1);
        KeyEvent.Callback childAt2 = getChildAt(i10);
        if (i10 < getChildCount() && (childAt instanceof a)) {
            zA = ((a) childAt).a();
        }
        return (i10 <= 0 || !(childAt2 instanceof a)) ? zA : ((a) childAt2).b() | zA;
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        ActionMenuPresenter actionMenuPresenter = this.f621w;
        if (actionMenuPresenter != null) {
            actionMenuPresenter.b();
            if (this.f621w.k()) {
                this.f621w.j();
                this.f621w.l();
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ActionMenuPresenter actionMenuPresenter = this.f621w;
        if (actionMenuPresenter != null) {
            actionMenuPresenter.j();
            ActionMenuPresenter.a aVar = actionMenuPresenter.f606w;
            if (aVar == null || !aVar.b()) {
                return;
            }
            aVar.f529i.dismiss();
        }
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i10, int i11, int i12, int i13) {
        int width;
        int paddingLeft;
        if (!this.f623y) {
            super.onLayout(z, i10, i11, i12, i13);
            return;
        }
        int childCount = getChildCount();
        int i14 = (i13 - i11) / 2;
        int dividerWidth = getDividerWidth();
        int i15 = i12 - i10;
        int paddingRight = (i15 - getPaddingRight()) - getPaddingLeft();
        boolean z3 = getLayoutDirection() == 1;
        int i16 = 0;
        int i17 = 0;
        for (int i18 = 0; i18 < childCount; i18++) {
            View childAt = getChildAt(i18);
            if (childAt.getVisibility() != 8) {
                c cVar = (c) childAt.getLayoutParams();
                if (cVar.f624a) {
                    int measuredWidth = childAt.getMeasuredWidth();
                    if (n(i18)) {
                        measuredWidth += dividerWidth;
                    }
                    int measuredHeight = childAt.getMeasuredHeight();
                    if (z3) {
                        paddingLeft = getPaddingLeft() + ((LinearLayout.LayoutParams) cVar).leftMargin;
                        width = paddingLeft + measuredWidth;
                    } else {
                        width = (getWidth() - getPaddingRight()) - ((LinearLayout.LayoutParams) cVar).rightMargin;
                        paddingLeft = width - measuredWidth;
                    }
                    int i19 = i14 - (measuredHeight / 2);
                    childAt.layout(paddingLeft, i19, width, measuredHeight + i19);
                    paddingRight -= measuredWidth;
                    i16 = 1;
                } else {
                    paddingRight -= (childAt.getMeasuredWidth() + ((LinearLayout.LayoutParams) cVar).leftMargin) + ((LinearLayout.LayoutParams) cVar).rightMargin;
                    n(i18);
                    i17++;
                }
            }
        }
        if (childCount == 1 && i16 == 0) {
            View childAt2 = getChildAt(0);
            int measuredWidth2 = childAt2.getMeasuredWidth();
            int measuredHeight2 = childAt2.getMeasuredHeight();
            int i20 = (i15 / 2) - (measuredWidth2 / 2);
            int i21 = i14 - (measuredHeight2 / 2);
            childAt2.layout(i20, i21, measuredWidth2 + i20, measuredHeight2 + i21);
            return;
        }
        int i22 = i17 - (i16 ^ 1);
        int iMax = Math.max(0, i22 > 0 ? paddingRight / i22 : 0);
        if (z3) {
            int width2 = getWidth() - getPaddingRight();
            for (int i23 = 0; i23 < childCount; i23++) {
                View childAt3 = getChildAt(i23);
                c cVar2 = (c) childAt3.getLayoutParams();
                if (childAt3.getVisibility() != 8 && !cVar2.f624a) {
                    int i24 = width2 - ((LinearLayout.LayoutParams) cVar2).rightMargin;
                    int measuredWidth3 = childAt3.getMeasuredWidth();
                    int measuredHeight3 = childAt3.getMeasuredHeight();
                    int i25 = i14 - (measuredHeight3 / 2);
                    childAt3.layout(i24 - measuredWidth3, i25, i24, measuredHeight3 + i25);
                    width2 = i24 - ((measuredWidth3 + ((LinearLayout.LayoutParams) cVar2).leftMargin) + iMax);
                }
            }
            return;
        }
        int paddingLeft2 = getPaddingLeft();
        for (int i26 = 0; i26 < childCount; i26++) {
            View childAt4 = getChildAt(i26);
            c cVar3 = (c) childAt4.getLayoutParams();
            if (childAt4.getVisibility() != 8 && !cVar3.f624a) {
                int i27 = paddingLeft2 + ((LinearLayout.LayoutParams) cVar3).leftMargin;
                int measuredWidth4 = childAt4.getMeasuredWidth();
                int measuredHeight4 = childAt4.getMeasuredHeight();
                int i28 = i14 - (measuredHeight4 / 2);
                childAt4.layout(i27, i28, i27 + measuredWidth4, measuredHeight4 + i28);
                paddingLeft2 = measuredWidth4 + ((LinearLayout.LayoutParams) cVar3).rightMargin + iMax + i27;
            }
        }
    }

    /* JADX WARN: Type inference failed for: r11v15 */
    /* JADX WARN: Type inference failed for: r11v16, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r11v18 */
    /* JADX WARN: Type inference failed for: r11v41 */
    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.View
    public final void onMeasure(int i10, int i11) {
        int i12;
        int i13;
        ?? r11;
        int i14;
        int i15;
        androidx.appcompat.view.menu.f fVar;
        boolean z = this.f623y;
        boolean z3 = View.MeasureSpec.getMode(i10) == 1073741824;
        this.f623y = z3;
        if (z != z3) {
            this.z = 0;
        }
        int size = View.MeasureSpec.getSize(i10);
        if (this.f623y && (fVar = this.f617s) != null && size != this.z) {
            this.z = size;
            fVar.p(true);
        }
        int childCount = getChildCount();
        if (!this.f623y || childCount <= 0) {
            for (int i16 = 0; i16 < childCount; i16++) {
                c cVar = (c) getChildAt(i16).getLayoutParams();
                ((LinearLayout.LayoutParams) cVar).rightMargin = 0;
                ((LinearLayout.LayoutParams) cVar).leftMargin = 0;
            }
            super.onMeasure(i10, i11);
            return;
        }
        int mode = View.MeasureSpec.getMode(i11);
        int size2 = View.MeasureSpec.getSize(i10);
        int size3 = View.MeasureSpec.getSize(i11);
        int paddingRight = getPaddingRight() + getPaddingLeft();
        int paddingBottom = getPaddingBottom() + getPaddingTop();
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i11, paddingBottom, -2);
        int i17 = size2 - paddingRight;
        int i18 = this.A;
        int i19 = i17 / i18;
        int i20 = i17 % i18;
        if (i19 == 0) {
            setMeasuredDimension(i17, 0);
            return;
        }
        int i21 = (i20 / i19) + i18;
        int childCount2 = getChildCount();
        int iMax = 0;
        int i22 = 0;
        int iMax2 = 0;
        int i23 = 0;
        boolean z10 = false;
        int i24 = 0;
        long j10 = 0;
        while (true) {
            i12 = this.B;
            if (i23 >= childCount2) {
                break;
            }
            View childAt = getChildAt(i23);
            int i25 = size3;
            int i26 = paddingBottom;
            if (childAt.getVisibility() == 8) {
                i14 = i21;
            } else {
                boolean z11 = childAt instanceof ActionMenuItemView;
                i22++;
                if (z11) {
                    childAt.setPadding(i12, 0, i12, 0);
                }
                c cVar2 = (c) childAt.getLayoutParams();
                cVar2.f629f = false;
                cVar2.f626c = 0;
                cVar2.f625b = 0;
                cVar2.f627d = false;
                ((LinearLayout.LayoutParams) cVar2).leftMargin = 0;
                ((LinearLayout.LayoutParams) cVar2).rightMargin = 0;
                cVar2.f628e = z11 && !TextUtils.isEmpty(((ActionMenuItemView) childAt).getText());
                int i27 = cVar2.f624a ? 1 : i19;
                c cVar3 = (c) childAt.getLayoutParams();
                int i28 = i19;
                i14 = i21;
                int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(childMeasureSpec) - i26, View.MeasureSpec.getMode(childMeasureSpec));
                ActionMenuItemView actionMenuItemView = z11 ? (ActionMenuItemView) childAt : null;
                boolean z12 = (actionMenuItemView == null || TextUtils.isEmpty(actionMenuItemView.getText())) ? false : true;
                boolean z13 = z12;
                if (i27 <= 0 || (z12 && i27 < 2)) {
                    i15 = 0;
                } else {
                    childAt.measure(View.MeasureSpec.makeMeasureSpec(i14 * i27, Integer.MIN_VALUE), iMakeMeasureSpec);
                    int measuredWidth = childAt.getMeasuredWidth();
                    i15 = measuredWidth / i14;
                    if (measuredWidth % i14 != 0) {
                        i15++;
                    }
                    if (z13 && i15 < 2) {
                        i15 = 2;
                    }
                }
                cVar3.f627d = !cVar3.f624a && z13;
                cVar3.f625b = i15;
                childAt.measure(View.MeasureSpec.makeMeasureSpec(i15 * i14, 1073741824), iMakeMeasureSpec);
                iMax2 = Math.max(iMax2, i15);
                if (cVar2.f627d) {
                    i24++;
                }
                if (cVar2.f624a) {
                    z10 = true;
                }
                i19 = i28 - i15;
                iMax = Math.max(iMax, childAt.getMeasuredHeight());
                if (i15 == 1) {
                    j10 |= 1 << i23;
                }
            }
            i23++;
            size3 = i25;
            paddingBottom = i26;
            i21 = i14;
        }
        int i29 = size3;
        int i30 = i19;
        int i31 = i21;
        boolean z14 = z10 && i22 == 2;
        int i32 = i30;
        boolean z15 = false;
        while (i24 > 0 && i32 > 0) {
            int i33 = Integer.MAX_VALUE;
            long j11 = 0;
            int i34 = 0;
            int i35 = 0;
            while (i35 < childCount2) {
                int i36 = iMax;
                c cVar4 = (c) getChildAt(i35).getLayoutParams();
                boolean z16 = z14;
                if (cVar4.f627d) {
                    int i37 = cVar4.f625b;
                    if (i37 < i33) {
                        j11 = 1 << i35;
                        i33 = i37;
                        i34 = 1;
                    } else if (i37 == i33) {
                        j11 |= 1 << i35;
                        i34++;
                    }
                }
                i35++;
                z14 = z16;
                iMax = i36;
            }
            i13 = iMax;
            boolean z17 = z14;
            j10 |= j11;
            if (i34 > i32) {
                break;
            }
            int i38 = i33 + 1;
            int i39 = 0;
            while (i39 < childCount2) {
                View childAt2 = getChildAt(i39);
                c cVar5 = (c) childAt2.getLayoutParams();
                boolean z18 = z10;
                long j12 = 1 << i39;
                if ((j11 & j12) != 0) {
                    if (z17 && cVar5.f628e) {
                        r11 = 1;
                        r11 = 1;
                        if (i32 == 1) {
                            childAt2.setPadding(i12 + i31, 0, i12, 0);
                        }
                    } else {
                        r11 = 1;
                    }
                    cVar5.f625b += r11;
                    cVar5.f629f = r11;
                    i32--;
                } else if (cVar5.f625b == i38) {
                    j10 |= j12;
                }
                i39++;
                z10 = z18;
            }
            z14 = z17;
            iMax = i13;
            z15 = true;
        }
        i13 = iMax;
        boolean z19 = !z10 && i22 == 1;
        if (i32 > 0 && j10 != 0 && (i32 < i22 - 1 || z19 || iMax2 > 1)) {
            float fBitCount = Long.bitCount(j10);
            if (!z19) {
                if ((j10 & 1) != 0 && !((c) getChildAt(0).getLayoutParams()).f628e) {
                    fBitCount -= 0.5f;
                }
                int i40 = childCount2 - 1;
                if ((j10 & (1 << i40)) != 0 && !((c) getChildAt(i40).getLayoutParams()).f628e) {
                    fBitCount -= 0.5f;
                }
            }
            int i41 = fBitCount > 0.0f ? (int) ((i32 * i31) / fBitCount) : 0;
            boolean z20 = z15;
            for (int i42 = 0; i42 < childCount2; i42++) {
                if ((j10 & (1 << i42)) != 0) {
                    View childAt3 = getChildAt(i42);
                    c cVar6 = (c) childAt3.getLayoutParams();
                    if (childAt3 instanceof ActionMenuItemView) {
                        cVar6.f626c = i41;
                        cVar6.f629f = true;
                        if (i42 == 0 && !cVar6.f628e) {
                            ((LinearLayout.LayoutParams) cVar6).leftMargin = (-i41) / 2;
                        }
                        z20 = true;
                    } else if (cVar6.f624a) {
                        cVar6.f626c = i41;
                        cVar6.f629f = true;
                        ((LinearLayout.LayoutParams) cVar6).rightMargin = (-i41) / 2;
                        z20 = true;
                    } else {
                        if (i42 != 0) {
                            ((LinearLayout.LayoutParams) cVar6).leftMargin = i41 / 2;
                        }
                        if (i42 != childCount2 - 1) {
                            ((LinearLayout.LayoutParams) cVar6).rightMargin = i41 / 2;
                        }
                    }
                }
            }
            z15 = z20;
        }
        if (z15) {
            for (int i43 = 0; i43 < childCount2; i43++) {
                View childAt4 = getChildAt(i43);
                c cVar7 = (c) childAt4.getLayoutParams();
                if (cVar7.f629f) {
                    childAt4.measure(View.MeasureSpec.makeMeasureSpec((cVar7.f625b * i31) + cVar7.f626c, 1073741824), childMeasureSpec);
                }
            }
        }
        setMeasuredDimension(i17, mode != 1073741824 ? i13 : i29);
    }

    public void setExpandedActionViewsExclusive(boolean z) {
        this.f621w.f603t = z;
    }

    public void setOnMenuItemClickListener(e eVar) {
        this.C = eVar;
    }

    public void setOverflowIcon(Drawable drawable) {
        getMenu();
        ActionMenuPresenter actionMenuPresenter = this.f621w;
        ActionMenuPresenter.d dVar = actionMenuPresenter.f596l;
        if (dVar != null) {
            dVar.setImageDrawable(drawable);
        } else {
            actionMenuPresenter.f598n = true;
            actionMenuPresenter.f597m = drawable;
        }
    }

    public void setOverflowReserved(boolean z) {
        this.f620v = z;
    }

    public void setPopupTheme(int i10) {
        if (this.f619u != i10) {
            this.f619u = i10;
            if (i10 == 0) {
                this.f618t = getContext();
            } else {
                this.f618t = new ContextThemeWrapper(getContext(), i10);
            }
        }
    }

    public void setPresenter(ActionMenuPresenter actionMenuPresenter) {
        this.f621w = actionMenuPresenter;
        actionMenuPresenter.f436k = this;
        this.f617s = actionMenuPresenter.f432c;
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new c(getContext(), attributeSet);
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class b implements j.a {
        @Override // androidx.appcompat.view.menu.j.a
        public final boolean b(androidx.appcompat.view.menu.f fVar) {
            return false;
        }

        @Override // androidx.appcompat.view.menu.j.a
        public final void a(androidx.appcompat.view.menu.f fVar, boolean z) {
        }
    }
}
