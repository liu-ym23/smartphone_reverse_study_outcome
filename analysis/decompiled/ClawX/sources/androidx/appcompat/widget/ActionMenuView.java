package androidx.appcompat.widget;

import a8.b;
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
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.emoji2.text.m;
import f.i;
import f.j;
import g.h;
import g.k;
import g.l;
import g.v1;
import g.w0;
import g.x0;
import t1.f;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public class ActionMenuView extends x0 implements i {

    /* renamed from: q, reason: collision with root package name */
    public j f312q;

    /* renamed from: r, reason: collision with root package name */
    public Context f313r;

    /* renamed from: s, reason: collision with root package name */
    public int f314s;

    /* renamed from: t, reason: collision with root package name */
    public g.i f315t;

    /* renamed from: u, reason: collision with root package name */
    public v1 f316u;

    /* renamed from: v, reason: collision with root package name */
    public boolean f317v;

    /* renamed from: w, reason: collision with root package name */
    public int f318w;

    /* renamed from: x, reason: collision with root package name */
    public final int f319x;
    public final int y;
    public l z;

    public ActionMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        setBaselineAligned(false);
        float f3 = context.getResources().getDisplayMetrics().density;
        this.f319x = (int) (56.0f * f3);
        this.y = (int) (f3 * 4.0f);
        this.f313r = context;
        this.f314s = 0;
    }

    public static k i() {
        k kVar = new k(-2, -2);
        kVar.f2759a = false;
        ((LinearLayout.LayoutParams) kVar).gravity = 16;
        return kVar;
    }

    public static k j(ViewGroup.LayoutParams layoutParams) {
        k kVar;
        if (layoutParams == null) {
            return i();
        }
        if (layoutParams instanceof k) {
            k kVar2 = (k) layoutParams;
            kVar = new k(kVar2);
            kVar.f2759a = kVar2.f2759a;
        } else {
            kVar = new k(layoutParams);
        }
        if (((LinearLayout.LayoutParams) kVar).gravity <= 0) {
            ((LinearLayout.LayoutParams) kVar).gravity = 16;
        }
        return kVar;
    }

    @Override // f.i
    public final boolean a(f.k kVar) {
        return this.f312q.p(kVar, null, 0);
    }

    @Override // g.x0, android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof k;
    }

    @Override // android.view.View
    public final boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return false;
    }

    @Override // g.x0
    /* renamed from: e */
    public final /* bridge */ /* synthetic */ w0 generateDefaultLayoutParams() {
        return i();
    }

    @Override // g.x0
    /* renamed from: f */
    public final w0 generateLayoutParams(AttributeSet attributeSet) {
        return new k(getContext(), attributeSet);
    }

    @Override // g.x0
    /* renamed from: g */
    public final /* bridge */ /* synthetic */ w0 generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return j(layoutParams);
    }

    @Override // g.x0, android.view.ViewGroup
    public final /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return i();
    }

    @Override // g.x0, android.view.ViewGroup
    public final /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return j(layoutParams);
    }

    public Menu getMenu() {
        if (this.f312q == null) {
            Context context = getContext();
            j jVar = new j(context);
            this.f312q = jVar;
            jVar.f2457e = new m(this);
            g.i iVar = new g.i(context);
            this.f315t = iVar;
            iVar.f2721l = true;
            iVar.f2722m = true;
            iVar.f2715e = new f(14);
            this.f312q.b(iVar, this.f313r);
            g.i iVar2 = this.f315t;
            iVar2.f2717g = this;
            this.f312q = iVar2.f2714c;
        }
        return this.f312q;
    }

    public Drawable getOverflowIcon() {
        getMenu();
        g.i iVar = this.f315t;
        h hVar = iVar.f2718h;
        if (hVar != null) {
            return hVar.getDrawable();
        }
        if (iVar.f2720k) {
            return iVar.f2719j;
        }
        return null;
    }

    public int getPopupTheme() {
        return this.f314s;
    }

    public int getWindowAnimations() {
        return 0;
    }

    public final boolean k(int i8) {
        boolean zA = false;
        if (i8 == 0) {
            return false;
        }
        KeyEvent.Callback childAt = getChildAt(i8 - 1);
        KeyEvent.Callback childAt2 = getChildAt(i8);
        if (i8 < getChildCount() && (childAt instanceof g.j)) {
            zA = ((g.j) childAt).a();
        }
        return (i8 <= 0 || !(childAt2 instanceof g.j)) ? zA : ((g.j) childAt2).c() | zA;
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        g.i iVar = this.f315t;
        if (iVar != null) {
            iVar.e();
            g.f fVar = this.f315t.f2728s;
            if (fVar == null || !fVar.b()) {
                return;
            }
            this.f315t.g();
            this.f315t.k();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        g.i iVar = this.f315t;
        if (iVar != null) {
            iVar.g();
            g.f fVar = iVar.f2729t;
            if (fVar == null || !fVar.b()) {
                return;
            }
            fVar.f2505i.dismiss();
        }
    }

    @Override // g.x0, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i8, int i9, int i10, int i11) {
        int width;
        int paddingLeft;
        if (!this.f317v) {
            super.onLayout(z, i8, i9, i10, i11);
            return;
        }
        int childCount = getChildCount();
        int i12 = (i11 - i9) / 2;
        int dividerWidth = getDividerWidth();
        int i13 = i10 - i8;
        int paddingRight = (i13 - getPaddingRight()) - getPaddingLeft();
        boolean z2 = getLayoutDirection() == 1;
        int i14 = 0;
        int i15 = 0;
        for (int i16 = 0; i16 < childCount; i16++) {
            View childAt = getChildAt(i16);
            if (childAt.getVisibility() != 8) {
                k kVar = (k) childAt.getLayoutParams();
                if (kVar.f2759a) {
                    int measuredWidth = childAt.getMeasuredWidth();
                    if (k(i16)) {
                        measuredWidth += dividerWidth;
                    }
                    int measuredHeight = childAt.getMeasuredHeight();
                    if (z2) {
                        paddingLeft = getPaddingLeft() + ((LinearLayout.LayoutParams) kVar).leftMargin;
                        width = paddingLeft + measuredWidth;
                    } else {
                        width = (getWidth() - getPaddingRight()) - ((LinearLayout.LayoutParams) kVar).rightMargin;
                        paddingLeft = width - measuredWidth;
                    }
                    int i17 = i12 - (measuredHeight / 2);
                    childAt.layout(paddingLeft, i17, width, measuredHeight + i17);
                    paddingRight -= measuredWidth;
                    i14 = 1;
                } else {
                    paddingRight -= (childAt.getMeasuredWidth() + ((LinearLayout.LayoutParams) kVar).leftMargin) + ((LinearLayout.LayoutParams) kVar).rightMargin;
                    k(i16);
                    i15++;
                }
            }
        }
        if (childCount == 1 && i14 == 0) {
            View childAt2 = getChildAt(0);
            int measuredWidth2 = childAt2.getMeasuredWidth();
            int measuredHeight2 = childAt2.getMeasuredHeight();
            int i18 = (i13 / 2) - (measuredWidth2 / 2);
            int i19 = i12 - (measuredHeight2 / 2);
            childAt2.layout(i18, i19, measuredWidth2 + i18, measuredHeight2 + i19);
            return;
        }
        int i20 = i15 - (i14 ^ 1);
        int iMax = Math.max(0, i20 > 0 ? paddingRight / i20 : 0);
        if (z2) {
            int width2 = getWidth() - getPaddingRight();
            for (int i21 = 0; i21 < childCount; i21++) {
                View childAt3 = getChildAt(i21);
                k kVar2 = (k) childAt3.getLayoutParams();
                if (childAt3.getVisibility() != 8 && !kVar2.f2759a) {
                    int i22 = width2 - ((LinearLayout.LayoutParams) kVar2).rightMargin;
                    int measuredWidth3 = childAt3.getMeasuredWidth();
                    int measuredHeight3 = childAt3.getMeasuredHeight();
                    int i23 = i12 - (measuredHeight3 / 2);
                    childAt3.layout(i22 - measuredWidth3, i23, i22, measuredHeight3 + i23);
                    width2 = i22 - ((measuredWidth3 + ((LinearLayout.LayoutParams) kVar2).leftMargin) + iMax);
                }
            }
            return;
        }
        int paddingLeft2 = getPaddingLeft();
        for (int i24 = 0; i24 < childCount; i24++) {
            View childAt4 = getChildAt(i24);
            k kVar3 = (k) childAt4.getLayoutParams();
            if (childAt4.getVisibility() != 8 && !kVar3.f2759a) {
                int i25 = paddingLeft2 + ((LinearLayout.LayoutParams) kVar3).leftMargin;
                int measuredWidth4 = childAt4.getMeasuredWidth();
                int measuredHeight4 = childAt4.getMeasuredHeight();
                int i26 = i12 - (measuredHeight4 / 2);
                childAt4.layout(i25, i26, i25 + measuredWidth4, measuredHeight4 + i26);
                paddingLeft2 = b.D(measuredWidth4, ((LinearLayout.LayoutParams) kVar3).rightMargin, iMax, i25);
            }
        }
    }

    /* JADX WARN: Type inference failed for: r11v15 */
    /* JADX WARN: Type inference failed for: r11v16, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r11v18 */
    /* JADX WARN: Type inference failed for: r11v41 */
    @Override // g.x0, android.view.View
    public final void onMeasure(int i8, int i9) {
        int i10;
        int i11;
        ?? r11;
        int i12;
        int i13;
        j jVar;
        boolean z = this.f317v;
        boolean z2 = View.MeasureSpec.getMode(i8) == 1073741824;
        this.f317v = z2;
        if (z != z2) {
            this.f318w = 0;
        }
        int size = View.MeasureSpec.getSize(i8);
        if (this.f317v && (jVar = this.f312q) != null && size != this.f318w) {
            this.f318w = size;
            jVar.o(true);
        }
        int childCount = getChildCount();
        if (!this.f317v || childCount <= 0) {
            for (int i14 = 0; i14 < childCount; i14++) {
                k kVar = (k) getChildAt(i14).getLayoutParams();
                ((LinearLayout.LayoutParams) kVar).rightMargin = 0;
                ((LinearLayout.LayoutParams) kVar).leftMargin = 0;
            }
            super.onMeasure(i8, i9);
            return;
        }
        int mode = View.MeasureSpec.getMode(i9);
        int size2 = View.MeasureSpec.getSize(i8);
        int size3 = View.MeasureSpec.getSize(i9);
        int paddingRight = getPaddingRight() + getPaddingLeft();
        int paddingBottom = getPaddingBottom() + getPaddingTop();
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i9, paddingBottom, -2);
        int i15 = size2 - paddingRight;
        int i16 = this.f319x;
        int i17 = i15 / i16;
        int i18 = i15 % i16;
        if (i17 == 0) {
            setMeasuredDimension(i15, 0);
            return;
        }
        int i19 = (i18 / i17) + i16;
        int childCount2 = getChildCount();
        int iMax = 0;
        int i20 = 0;
        int iMax2 = 0;
        int i21 = 0;
        boolean z8 = false;
        int i22 = 0;
        long j4 = 0;
        while (true) {
            i10 = this.y;
            if (i21 >= childCount2) {
                break;
            }
            View childAt = getChildAt(i21);
            int i23 = size3;
            int i24 = paddingBottom;
            if (childAt.getVisibility() == 8) {
                i12 = i19;
            } else {
                boolean z9 = childAt instanceof ActionMenuItemView;
                i20++;
                if (z9) {
                    childAt.setPadding(i10, 0, i10, 0);
                }
                k kVar2 = (k) childAt.getLayoutParams();
                kVar2.f2763f = false;
                kVar2.f2761c = 0;
                kVar2.f2760b = 0;
                kVar2.d = false;
                ((LinearLayout.LayoutParams) kVar2).leftMargin = 0;
                ((LinearLayout.LayoutParams) kVar2).rightMargin = 0;
                kVar2.f2762e = z9 && !TextUtils.isEmpty(((ActionMenuItemView) childAt).getText());
                int i25 = kVar2.f2759a ? 1 : i17;
                k kVar3 = (k) childAt.getLayoutParams();
                int i26 = i17;
                i12 = i19;
                int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(childMeasureSpec) - i24, View.MeasureSpec.getMode(childMeasureSpec));
                ActionMenuItemView actionMenuItemView = z9 ? (ActionMenuItemView) childAt : null;
                boolean z10 = (actionMenuItemView == null || TextUtils.isEmpty(actionMenuItemView.getText())) ? false : true;
                boolean z11 = z10;
                if (i25 <= 0 || (z10 && i25 < 2)) {
                    i13 = 0;
                } else {
                    childAt.measure(View.MeasureSpec.makeMeasureSpec(i12 * i25, Integer.MIN_VALUE), iMakeMeasureSpec);
                    int measuredWidth = childAt.getMeasuredWidth();
                    i13 = measuredWidth / i12;
                    if (measuredWidth % i12 != 0) {
                        i13++;
                    }
                    if (z11 && i13 < 2) {
                        i13 = 2;
                    }
                }
                kVar3.d = !kVar3.f2759a && z11;
                kVar3.f2760b = i13;
                childAt.measure(View.MeasureSpec.makeMeasureSpec(i13 * i12, 1073741824), iMakeMeasureSpec);
                iMax2 = Math.max(iMax2, i13);
                if (kVar2.d) {
                    i22++;
                }
                if (kVar2.f2759a) {
                    z8 = true;
                }
                i17 = i26 - i13;
                iMax = Math.max(iMax, childAt.getMeasuredHeight());
                if (i13 == 1) {
                    j4 |= 1 << i21;
                }
            }
            i21++;
            size3 = i23;
            paddingBottom = i24;
            i19 = i12;
        }
        int i27 = size3;
        int i28 = i17;
        int i29 = i19;
        boolean z12 = z8 && i20 == 2;
        int i30 = i28;
        boolean z13 = false;
        while (i22 > 0 && i30 > 0) {
            int i31 = Integer.MAX_VALUE;
            long j8 = 0;
            int i32 = 0;
            int i33 = 0;
            while (i33 < childCount2) {
                int i34 = iMax;
                k kVar4 = (k) getChildAt(i33).getLayoutParams();
                boolean z14 = z12;
                if (kVar4.d) {
                    int i35 = kVar4.f2760b;
                    if (i35 < i31) {
                        j8 = 1 << i33;
                        i31 = i35;
                        i32 = 1;
                    } else if (i35 == i31) {
                        j8 |= 1 << i33;
                        i32++;
                    }
                }
                i33++;
                z12 = z14;
                iMax = i34;
            }
            i11 = iMax;
            boolean z15 = z12;
            j4 |= j8;
            if (i32 > i30) {
                break;
            }
            int i36 = i31 + 1;
            int i37 = 0;
            while (i37 < childCount2) {
                View childAt2 = getChildAt(i37);
                k kVar5 = (k) childAt2.getLayoutParams();
                boolean z16 = z8;
                long j9 = 1 << i37;
                if ((j8 & j9) != 0) {
                    if (z15 && kVar5.f2762e) {
                        r11 = 1;
                        r11 = 1;
                        if (i30 == 1) {
                            childAt2.setPadding(i10 + i29, 0, i10, 0);
                        }
                    } else {
                        r11 = 1;
                    }
                    kVar5.f2760b += r11;
                    kVar5.f2763f = r11;
                    i30--;
                } else if (kVar5.f2760b == i36) {
                    j4 |= j9;
                }
                i37++;
                z8 = z16;
            }
            z12 = z15;
            iMax = i11;
            z13 = true;
        }
        i11 = iMax;
        boolean z17 = !z8 && i20 == 1;
        if (i30 > 0 && j4 != 0 && (i30 < i20 - 1 || z17 || iMax2 > 1)) {
            float fBitCount = Long.bitCount(j4);
            if (!z17) {
                if ((j4 & 1) != 0 && !((k) getChildAt(0).getLayoutParams()).f2762e) {
                    fBitCount -= 0.5f;
                }
                int i38 = childCount2 - 1;
                if ((j4 & (1 << i38)) != 0 && !((k) getChildAt(i38).getLayoutParams()).f2762e) {
                    fBitCount -= 0.5f;
                }
            }
            int i39 = fBitCount > 0.0f ? (int) ((i30 * i29) / fBitCount) : 0;
            boolean z18 = z13;
            for (int i40 = 0; i40 < childCount2; i40++) {
                if ((j4 & (1 << i40)) != 0) {
                    View childAt3 = getChildAt(i40);
                    k kVar6 = (k) childAt3.getLayoutParams();
                    if (childAt3 instanceof ActionMenuItemView) {
                        kVar6.f2761c = i39;
                        kVar6.f2763f = true;
                        if (i40 == 0 && !kVar6.f2762e) {
                            ((LinearLayout.LayoutParams) kVar6).leftMargin = (-i39) / 2;
                        }
                        z18 = true;
                    } else if (kVar6.f2759a) {
                        kVar6.f2761c = i39;
                        kVar6.f2763f = true;
                        ((LinearLayout.LayoutParams) kVar6).rightMargin = (-i39) / 2;
                        z18 = true;
                    } else {
                        if (i40 != 0) {
                            ((LinearLayout.LayoutParams) kVar6).leftMargin = i39 / 2;
                        }
                        if (i40 != childCount2 - 1) {
                            ((LinearLayout.LayoutParams) kVar6).rightMargin = i39 / 2;
                        }
                    }
                }
            }
            z13 = z18;
        }
        if (z13) {
            for (int i41 = 0; i41 < childCount2; i41++) {
                View childAt4 = getChildAt(i41);
                k kVar7 = (k) childAt4.getLayoutParams();
                if (kVar7.f2763f) {
                    childAt4.measure(View.MeasureSpec.makeMeasureSpec((kVar7.f2760b * i29) + kVar7.f2761c, 1073741824), childMeasureSpec);
                }
            }
        }
        setMeasuredDimension(i15, mode != 1073741824 ? i11 : i27);
    }

    public void setExpandedActionViewsExclusive(boolean z) {
        this.f315t.f2726q = z;
    }

    public void setOnMenuItemClickListener(l lVar) {
        this.z = lVar;
    }

    public void setOverflowIcon(Drawable drawable) {
        getMenu();
        g.i iVar = this.f315t;
        h hVar = iVar.f2718h;
        if (hVar != null) {
            hVar.setImageDrawable(drawable);
        } else {
            iVar.f2720k = true;
            iVar.f2719j = drawable;
        }
    }

    public void setPopupTheme(int i8) {
        if (this.f314s != i8) {
            this.f314s = i8;
            if (i8 == 0) {
                this.f313r = getContext();
            } else {
                this.f313r = new ContextThemeWrapper(getContext(), i8);
            }
        }
    }

    public void setPresenter(g.i iVar) {
        this.f315t = iVar;
        iVar.f2717g = this;
        this.f312q = iVar.f2714c;
    }

    @Override // g.x0, android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new k(getContext(), attributeSet);
    }

    public void setOverflowReserved(boolean z) {
    }
}
