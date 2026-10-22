package androidx.appcompat.widget;

import a2.i;
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
import com.google.crypto.tink.shaded.protobuf.Reader;
import f8.b;
import java.lang.invoke.VarHandle;
import l.k;
import l.l;
import l.z;
import m.g;
import m.j;
import m.m;
import m.n;
import m.n1;
import m.o1;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public class ActionMenuView extends o1 implements k, z {
    public int A;
    public final int B;
    public final int C;
    public n D;

    /* renamed from: t, reason: collision with root package name */
    public l f792t;

    /* renamed from: u, reason: collision with root package name */
    public Context f793u;

    /* renamed from: v, reason: collision with root package name */
    public int f794v;

    /* renamed from: w, reason: collision with root package name */
    public boolean f795w;

    /* renamed from: x, reason: collision with root package name */
    public m.k f796x;

    /* renamed from: y, reason: collision with root package name */
    public i f797y;

    /* renamed from: z, reason: collision with root package name */
    public boolean f798z;

    public ActionMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        setBaselineAligned(false);
        float f5 = context.getResources().getDisplayMetrics().density;
        this.B = (int) (56.0f * f5);
        this.C = (int) (f5 * 4.0f);
        this.f793u = context;
        this.f794v = 0;
    }

    public static m k() {
        m mVar = new m(-2, -2);
        mVar.f7996a = false;
        ((LinearLayout.LayoutParams) mVar).gravity = 16;
        return mVar;
    }

    public static m l(ViewGroup.LayoutParams layoutParams) {
        m mVar;
        if (layoutParams == null) {
            return k();
        }
        if (layoutParams instanceof m) {
            m mVar2 = (m) layoutParams;
            mVar = new m(mVar2);
            mVar.f7996a = mVar2.f7996a;
        } else {
            mVar = new m(layoutParams);
        }
        if (((LinearLayout.LayoutParams) mVar).gravity <= 0) {
            ((LinearLayout.LayoutParams) mVar).gravity = 16;
        }
        return mVar;
    }

    @Override // l.k
    public final boolean a(l.n nVar) {
        return this.f792t.q(nVar, null, 0);
    }

    @Override // l.z
    public final void c(l lVar) {
        this.f792t = lVar;
    }

    @Override // m.o1, android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof m;
    }

    @Override // android.view.View
    public final boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return false;
    }

    @Override // m.o1
    /* renamed from: g */
    public final /* bridge */ /* synthetic */ n1 generateDefaultLayoutParams() {
        return k();
    }

    @Override // m.o1, android.view.ViewGroup
    public final /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return k();
    }

    @Override // m.o1, android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new m(getContext(), attributeSet);
    }

    public Menu getMenu() {
        if (this.f792t == null) {
            Context context = getContext();
            l lVar = new l(context);
            this.f792t = lVar;
            i iVar = new i(17);
            iVar.f49f = this;
            VarHandle.storeStoreFence();
            lVar.f7587e = iVar;
            m.k kVar = new m.k(context);
            this.f796x = kVar;
            kVar.f7954p = true;
            kVar.f7955q = true;
            kVar.i = new b(16);
            this.f792t.b(kVar, this.f793u);
            m.k kVar2 = this.f796x;
            kVar2.f7950l = this;
            this.f792t = kVar2.f7946g;
        }
        return this.f792t;
    }

    public Drawable getOverflowIcon() {
        getMenu();
        m.k kVar = this.f796x;
        j jVar = kVar.f7951m;
        if (jVar != null) {
            return jVar.getDrawable();
        }
        if (kVar.f7953o) {
            return kVar.f7952n;
        }
        return null;
    }

    public int getPopupTheme() {
        return this.f794v;
    }

    public int getWindowAnimations() {
        return 0;
    }

    @Override // m.o1
    /* renamed from: h */
    public final n1 generateLayoutParams(AttributeSet attributeSet) {
        return new m(getContext(), attributeSet);
    }

    @Override // m.o1
    /* renamed from: i */
    public final /* bridge */ /* synthetic */ n1 generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return l(layoutParams);
    }

    public final boolean m(int i) {
        boolean zA = false;
        if (i == 0) {
            return false;
        }
        KeyEvent.Callback childAt = getChildAt(i - 1);
        KeyEvent.Callback childAt2 = getChildAt(i);
        if (i < getChildCount() && (childAt instanceof m.l)) {
            zA = ((m.l) childAt).a();
        }
        return (i <= 0 || !(childAt2 instanceof m.l)) ? zA : ((m.l) childAt2).b() | zA;
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        m.k kVar = this.f796x;
        if (kVar != null) {
            kVar.c();
            if (this.f796x.h()) {
                this.f796x.f();
                this.f796x.l();
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        m.k kVar = this.f796x;
        if (kVar != null) {
            kVar.f();
            g gVar = kVar.f7962x;
            if (gVar == null || !gVar.b()) {
                return;
            }
            gVar.i.dismiss();
        }
    }

    @Override // m.o1, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z10, int i, int i3, int i10, int i11) {
        int width;
        int paddingLeft;
        if (!this.f798z) {
            super.onLayout(z10, i, i3, i10, i11);
            return;
        }
        int childCount = getChildCount();
        int i12 = (i11 - i3) / 2;
        int dividerWidth = getDividerWidth();
        int i13 = i10 - i;
        int paddingRight = (i13 - getPaddingRight()) - getPaddingLeft();
        boolean z11 = getLayoutDirection() == 1;
        int i14 = 0;
        int i15 = 0;
        for (int i16 = 0; i16 < childCount; i16++) {
            View childAt = getChildAt(i16);
            if (childAt.getVisibility() != 8) {
                m mVar = (m) childAt.getLayoutParams();
                if (mVar.f7996a) {
                    int measuredWidth = childAt.getMeasuredWidth();
                    if (m(i16)) {
                        measuredWidth += dividerWidth;
                    }
                    int measuredHeight = childAt.getMeasuredHeight();
                    if (z11) {
                        paddingLeft = getPaddingLeft() + ((LinearLayout.LayoutParams) mVar).leftMargin;
                        width = paddingLeft + measuredWidth;
                    } else {
                        width = (getWidth() - getPaddingRight()) - ((LinearLayout.LayoutParams) mVar).rightMargin;
                        paddingLeft = width - measuredWidth;
                    }
                    int i17 = i12 - (measuredHeight / 2);
                    childAt.layout(paddingLeft, i17, width, measuredHeight + i17);
                    paddingRight -= measuredWidth;
                    i14 = 1;
                } else {
                    paddingRight -= (childAt.getMeasuredWidth() + ((LinearLayout.LayoutParams) mVar).leftMargin) + ((LinearLayout.LayoutParams) mVar).rightMargin;
                    m(i16);
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
        if (z11) {
            int width2 = getWidth() - getPaddingRight();
            for (int i21 = 0; i21 < childCount; i21++) {
                View childAt3 = getChildAt(i21);
                m mVar2 = (m) childAt3.getLayoutParams();
                if (childAt3.getVisibility() != 8 && !mVar2.f7996a) {
                    int i22 = width2 - ((LinearLayout.LayoutParams) mVar2).rightMargin;
                    int measuredWidth3 = childAt3.getMeasuredWidth();
                    int measuredHeight3 = childAt3.getMeasuredHeight();
                    int i23 = i12 - (measuredHeight3 / 2);
                    childAt3.layout(i22 - measuredWidth3, i23, i22, measuredHeight3 + i23);
                    width2 = i22 - ((measuredWidth3 + ((LinearLayout.LayoutParams) mVar2).leftMargin) + iMax);
                }
            }
            return;
        }
        int paddingLeft2 = getPaddingLeft();
        for (int i24 = 0; i24 < childCount; i24++) {
            View childAt4 = getChildAt(i24);
            m mVar3 = (m) childAt4.getLayoutParams();
            if (childAt4.getVisibility() != 8 && !mVar3.f7996a) {
                int i25 = paddingLeft2 + ((LinearLayout.LayoutParams) mVar3).leftMargin;
                int measuredWidth4 = childAt4.getMeasuredWidth();
                int measuredHeight4 = childAt4.getMeasuredHeight();
                int i26 = i12 - (measuredHeight4 / 2);
                childAt4.layout(i25, i26, i25 + measuredWidth4, measuredHeight4 + i26);
                paddingLeft2 = measuredWidth4 + ((LinearLayout.LayoutParams) mVar3).rightMargin + iMax + i25;
            }
        }
    }

    /* JADX WARN: Type inference failed for: r11v15 */
    /* JADX WARN: Type inference failed for: r11v16, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r11v18 */
    /* JADX WARN: Type inference failed for: r11v41 */
    @Override // m.o1, android.view.View
    public final void onMeasure(int i, int i3) {
        int i10;
        int i11;
        ?? r11;
        int i12;
        int i13;
        l lVar;
        boolean z10 = this.f798z;
        boolean z11 = View.MeasureSpec.getMode(i) == 1073741824;
        this.f798z = z11;
        if (z10 != z11) {
            this.A = 0;
        }
        int size = View.MeasureSpec.getSize(i);
        if (this.f798z && (lVar = this.f792t) != null && size != this.A) {
            this.A = size;
            lVar.p(true);
        }
        int childCount = getChildCount();
        if (!this.f798z || childCount <= 0) {
            for (int i14 = 0; i14 < childCount; i14++) {
                m mVar = (m) getChildAt(i14).getLayoutParams();
                ((LinearLayout.LayoutParams) mVar).rightMargin = 0;
                ((LinearLayout.LayoutParams) mVar).leftMargin = 0;
            }
            super.onMeasure(i, i3);
            return;
        }
        int mode = View.MeasureSpec.getMode(i3);
        int size2 = View.MeasureSpec.getSize(i);
        int size3 = View.MeasureSpec.getSize(i3);
        int paddingRight = getPaddingRight() + getPaddingLeft();
        int paddingBottom = getPaddingBottom() + getPaddingTop();
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i3, paddingBottom, -2);
        int i15 = size2 - paddingRight;
        int i16 = this.B;
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
        boolean z12 = false;
        int i22 = 0;
        long j10 = 0;
        while (true) {
            i10 = this.C;
            if (i21 >= childCount2) {
                break;
            }
            View childAt = getChildAt(i21);
            int i23 = size3;
            int i24 = paddingBottom;
            if (childAt.getVisibility() == 8) {
                i12 = i19;
            } else {
                boolean z13 = childAt instanceof ActionMenuItemView;
                i20++;
                if (z13) {
                    childAt.setPadding(i10, 0, i10, 0);
                }
                m mVar2 = (m) childAt.getLayoutParams();
                mVar2.f8001f = false;
                mVar2.f7998c = 0;
                mVar2.f7997b = 0;
                mVar2.f7999d = false;
                ((LinearLayout.LayoutParams) mVar2).leftMargin = 0;
                ((LinearLayout.LayoutParams) mVar2).rightMargin = 0;
                mVar2.f8000e = z13 && !TextUtils.isEmpty(((ActionMenuItemView) childAt).getText());
                int i25 = mVar2.f7996a ? 1 : i17;
                m mVar3 = (m) childAt.getLayoutParams();
                int i26 = i17;
                i12 = i19;
                int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(childMeasureSpec) - i24, View.MeasureSpec.getMode(childMeasureSpec));
                ActionMenuItemView actionMenuItemView = z13 ? (ActionMenuItemView) childAt : null;
                boolean z14 = (actionMenuItemView == null || TextUtils.isEmpty(actionMenuItemView.getText())) ? false : true;
                boolean z15 = z14;
                if (i25 <= 0 || (z14 && i25 < 2)) {
                    i13 = 0;
                } else {
                    childAt.measure(View.MeasureSpec.makeMeasureSpec(i12 * i25, Integer.MIN_VALUE), iMakeMeasureSpec);
                    int measuredWidth = childAt.getMeasuredWidth();
                    i13 = measuredWidth / i12;
                    if (measuredWidth % i12 != 0) {
                        i13++;
                    }
                    if (z15 && i13 < 2) {
                        i13 = 2;
                    }
                }
                mVar3.f7999d = !mVar3.f7996a && z15;
                mVar3.f7997b = i13;
                childAt.measure(View.MeasureSpec.makeMeasureSpec(i13 * i12, 1073741824), iMakeMeasureSpec);
                iMax2 = Math.max(iMax2, i13);
                if (mVar2.f7999d) {
                    i22++;
                }
                if (mVar2.f7996a) {
                    z12 = true;
                }
                i17 = i26 - i13;
                iMax = Math.max(iMax, childAt.getMeasuredHeight());
                if (i13 == 1) {
                    j10 |= 1 << i21;
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
        boolean z16 = z12 && i20 == 2;
        int i30 = i28;
        boolean z17 = false;
        while (i22 > 0 && i30 > 0) {
            int i31 = Reader.READ_DONE;
            long j11 = 0;
            int i32 = 0;
            int i33 = 0;
            while (i33 < childCount2) {
                int i34 = iMax;
                m mVar4 = (m) getChildAt(i33).getLayoutParams();
                boolean z18 = z16;
                if (mVar4.f7999d) {
                    int i35 = mVar4.f7997b;
                    if (i35 < i31) {
                        j11 = 1 << i33;
                        i31 = i35;
                        i32 = 1;
                    } else if (i35 == i31) {
                        j11 |= 1 << i33;
                        i32++;
                    }
                }
                i33++;
                z16 = z18;
                iMax = i34;
            }
            i11 = iMax;
            boolean z19 = z16;
            j10 |= j11;
            if (i32 > i30) {
                break;
            }
            int i36 = i31 + 1;
            int i37 = 0;
            while (i37 < childCount2) {
                View childAt2 = getChildAt(i37);
                m mVar5 = (m) childAt2.getLayoutParams();
                boolean z20 = z12;
                long j12 = 1 << i37;
                if ((j11 & j12) != 0) {
                    if (z19 && mVar5.f8000e) {
                        r11 = 1;
                        r11 = 1;
                        if (i30 == 1) {
                            childAt2.setPadding(i10 + i29, 0, i10, 0);
                        }
                    } else {
                        r11 = 1;
                    }
                    mVar5.f7997b += r11;
                    mVar5.f8001f = r11;
                    i30--;
                } else if (mVar5.f7997b == i36) {
                    j10 |= j12;
                }
                i37++;
                z12 = z20;
            }
            z16 = z19;
            iMax = i11;
            z17 = true;
        }
        i11 = iMax;
        boolean z21 = !z12 && i20 == 1;
        if (i30 > 0 && j10 != 0 && (i30 < i20 - 1 || z21 || iMax2 > 1)) {
            float fBitCount = Long.bitCount(j10);
            if (!z21) {
                if ((j10 & 1) != 0 && !((m) getChildAt(0).getLayoutParams()).f8000e) {
                    fBitCount -= 0.5f;
                }
                int i38 = childCount2 - 1;
                if ((j10 & (1 << i38)) != 0 && !((m) getChildAt(i38).getLayoutParams()).f8000e) {
                    fBitCount -= 0.5f;
                }
            }
            int i39 = fBitCount > 0.0f ? (int) ((i30 * i29) / fBitCount) : 0;
            boolean z22 = z17;
            for (int i40 = 0; i40 < childCount2; i40++) {
                if ((j10 & (1 << i40)) != 0) {
                    View childAt3 = getChildAt(i40);
                    m mVar6 = (m) childAt3.getLayoutParams();
                    if (childAt3 instanceof ActionMenuItemView) {
                        mVar6.f7998c = i39;
                        mVar6.f8001f = true;
                        if (i40 == 0 && !mVar6.f8000e) {
                            ((LinearLayout.LayoutParams) mVar6).leftMargin = (-i39) / 2;
                        }
                        z22 = true;
                    } else if (mVar6.f7996a) {
                        mVar6.f7998c = i39;
                        mVar6.f8001f = true;
                        ((LinearLayout.LayoutParams) mVar6).rightMargin = (-i39) / 2;
                        z22 = true;
                    } else {
                        if (i40 != 0) {
                            ((LinearLayout.LayoutParams) mVar6).leftMargin = i39 / 2;
                        }
                        if (i40 != childCount2 - 1) {
                            ((LinearLayout.LayoutParams) mVar6).rightMargin = i39 / 2;
                        }
                    }
                }
            }
            z17 = z22;
        }
        if (z17) {
            for (int i41 = 0; i41 < childCount2; i41++) {
                View childAt4 = getChildAt(i41);
                m mVar7 = (m) childAt4.getLayoutParams();
                if (mVar7.f8001f) {
                    childAt4.measure(View.MeasureSpec.makeMeasureSpec((mVar7.f7997b * i29) + mVar7.f7998c, 1073741824), childMeasureSpec);
                }
            }
        }
        setMeasuredDimension(i15, mode != 1073741824 ? i11 : i27);
    }

    public void setExpandedActionViewsExclusive(boolean z10) {
        this.f796x.f7959u = z10;
    }

    public void setOnMenuItemClickListener(n nVar) {
        this.D = nVar;
    }

    public void setOverflowIcon(Drawable drawable) {
        getMenu();
        m.k kVar = this.f796x;
        j jVar = kVar.f7951m;
        if (jVar != null) {
            jVar.setImageDrawable(drawable);
        } else {
            kVar.f7953o = true;
            kVar.f7952n = drawable;
        }
    }

    public void setOverflowReserved(boolean z10) {
        this.f795w = z10;
    }

    public void setPopupTheme(int i) {
        if (this.f794v != i) {
            this.f794v = i;
            if (i == 0) {
                this.f793u = getContext();
            } else {
                this.f793u = new ContextThemeWrapper(getContext(), i);
            }
        }
    }

    public void setPresenter(m.k kVar) {
        this.f796x = kVar;
        kVar.f7950l = this;
        this.f792t = kVar.f7946g;
    }

    @Override // m.o1, android.view.ViewGroup
    public final /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return l(layoutParams);
    }

    public ActionMenuView(Context context) {
        this(context, null);
    }
}
