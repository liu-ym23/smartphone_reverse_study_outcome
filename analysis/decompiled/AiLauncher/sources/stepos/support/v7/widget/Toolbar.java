package stepos.support.v7.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.R$styleable;
import androidx.appcompat.widget.C1295h;
import androidx.core.view.C1321i;
import androidx.core.view.C1324l;
import androidx.core.view.C1329q;
import androidx.core.view.C1330s;
import androidx.core.view.N;
import androidx.core.view.U;
import androidx.core.view.V;
import com.stepos.common.R$drawable;
import i.InterfaceC4157c;
import java.util.ArrayList;
import java.util.List;
import stepos.support.v7.app.a;
import stepos.support.v7.appcompat.R$attr;
import stepos.support.v7.appcompat.R$bool;
import stepos.support.v7.appcompat.R$dimen;
import stepos.support.v7.appcompat.R$id;
import stepos.support.v7.view.menu.c;
import stepos.support.v7.view.menu.g;
import stepos.support.v7.widget.ActionMenuView;

@SuppressLint({"RestrictedApi"})
/* loaded from: classes5.dex */
public class Toolbar extends ViewGroup {

    /* renamed from: A, reason: collision with root package name */
    public CharSequence f41445A;

    /* renamed from: B, reason: collision with root package name */
    public int f41446B;

    /* renamed from: C, reason: collision with root package name */
    public int f41447C;

    /* renamed from: D, reason: collision with root package name */
    public boolean f41448D;

    /* renamed from: E, reason: collision with root package name */
    public boolean f41449E;

    /* renamed from: F, reason: collision with root package name */
    public final ArrayList<View> f41450F;

    /* renamed from: G, reason: collision with root package name */
    public final ArrayList<View> f41451G;

    /* renamed from: H, reason: collision with root package name */
    public final int[] f41452H;

    /* renamed from: I, reason: collision with root package name */
    public g f41453I;

    /* renamed from: J, reason: collision with root package name */
    public final ActionMenuView.f f41454J;

    /* renamed from: K, reason: collision with root package name */
    public w f41455K;

    /* renamed from: L, reason: collision with root package name */
    public ActionMenuPresenter f41456L;

    /* renamed from: M, reason: collision with root package name */
    public e f41457M;

    /* renamed from: N, reason: collision with root package name */
    public g.a f41458N;

    /* renamed from: O, reason: collision with root package name */
    public c.a f41459O;

    /* renamed from: P, reason: collision with root package name */
    public boolean f41460P;

    /* renamed from: Q, reason: collision with root package name */
    public final Runnable f41461Q;

    /* renamed from: R, reason: collision with root package name */
    public final C1295h f41462R;

    /* renamed from: S, reason: collision with root package name */
    public ActionMenuView f41463S;

    /* renamed from: T, reason: collision with root package name */
    public boolean f41464T;

    /* renamed from: U, reason: collision with root package name */
    public com.stepos.common.animator.f f41465U;

    /* renamed from: V, reason: collision with root package name */
    public ViewGroup f41466V;

    /* renamed from: W, reason: collision with root package name */
    public boolean f41467W;

    /* renamed from: a, reason: collision with root package name */
    public ActionMenuView f41468a;

    /* renamed from: a0, reason: collision with root package name */
    public boolean f41469a0;

    /* renamed from: b, reason: collision with root package name */
    public HorizontalScrollView f41470b;

    /* renamed from: b0, reason: collision with root package name */
    public View f41471b0;

    /* renamed from: c, reason: collision with root package name */
    public TextView f41472c;

    /* renamed from: c0, reason: collision with root package name */
    public U f41473c0;

    /* renamed from: d, reason: collision with root package name */
    public TextView f41474d;

    /* renamed from: d0, reason: collision with root package name */
    public final h f41475d0;

    /* renamed from: e, reason: collision with root package name */
    public ImageButton f41476e;

    /* renamed from: f, reason: collision with root package name */
    public ImageView f41477f;

    /* renamed from: g, reason: collision with root package name */
    public Drawable f41478g;

    /* renamed from: h, reason: collision with root package name */
    public CharSequence f41479h;

    /* renamed from: i, reason: collision with root package name */
    public ImageButton f41480i;

    /* renamed from: j, reason: collision with root package name */
    public View f41481j;

    /* renamed from: k, reason: collision with root package name */
    public Context f41482k;

    /* renamed from: l, reason: collision with root package name */
    public int f41483l;

    /* renamed from: m, reason: collision with root package name */
    public int f41484m;

    /* renamed from: n, reason: collision with root package name */
    public int f41485n;

    /* renamed from: o, reason: collision with root package name */
    public int f41486o;

    /* renamed from: p, reason: collision with root package name */
    public int f41487p;

    /* renamed from: q, reason: collision with root package name */
    public int f41488q;

    /* renamed from: r, reason: collision with root package name */
    public int f41489r;

    /* renamed from: s, reason: collision with root package name */
    public int f41490s;

    /* renamed from: t, reason: collision with root package name */
    public int f41491t;

    /* renamed from: u, reason: collision with root package name */
    public int f41492u;

    /* renamed from: v, reason: collision with root package name */
    public int f41493v;

    /* renamed from: w, reason: collision with root package name */
    public int f41494w;

    /* renamed from: x, reason: collision with root package name */
    public final q f41495x;

    /* renamed from: y, reason: collision with root package name */
    public int f41496y;

    /* renamed from: z, reason: collision with root package name */
    public CharSequence f41497z;

    public class a implements ActionMenuView.f {
        public a() {
        }

        @Override // stepos.support.v7.widget.ActionMenuView.f
        public boolean onMenuItemClick(MenuItem menuItem) {
            if (Toolbar.this.f41453I != null) {
                return Toolbar.this.f41453I.onMenuItemClick(menuItem);
            }
            return false;
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Toolbar.this.a0();
        }
    }

    public class c implements View.OnLayoutChangeListener {
        public c() {
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
            View view2 = (View) view.getParent();
            int i18 = (int) (Toolbar.this.getResources().getDisplayMetrics().density * 56.0f);
            int i19 = i12 - i10;
            if (i19 < i18) {
                int i20 = (i18 - i19) / 2;
                view2.setTouchDelegate(new TouchDelegate(new Rect(i10 - i20, i11, i12 + i20, i13), view));
            }
        }
    }

    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Toolbar.this.j();
        }
    }

    public class e implements stepos.support.v7.view.menu.g {

        /* renamed from: a, reason: collision with root package name */
        public stepos.support.v7.view.menu.c f41502a;

        /* renamed from: b, reason: collision with root package name */
        public stepos.support.v7.view.menu.e f41503b;

        public e() {
        }

        @Override // stepos.support.v7.view.menu.g
        public void a(stepos.support.v7.view.menu.c cVar, boolean z10) {
        }

        @Override // stepos.support.v7.view.menu.g
        public void b(boolean z10) {
            if (this.f41503b != null) {
                stepos.support.v7.view.menu.c cVar = this.f41502a;
                if (cVar != null) {
                    int size = cVar.size();
                    for (int i10 = 0; i10 < size; i10++) {
                        if (this.f41502a.getItem(i10) == this.f41503b) {
                            return;
                        }
                    }
                }
                d(this.f41502a, this.f41503b);
            }
        }

        @Override // stepos.support.v7.view.menu.g
        public boolean c() {
            return false;
        }

        @Override // stepos.support.v7.view.menu.g
        public boolean d(stepos.support.v7.view.menu.c cVar, stepos.support.v7.view.menu.e eVar) {
            KeyEvent.Callback callback = Toolbar.this.f41481j;
            if (callback instanceof InterfaceC4157c) {
                ((InterfaceC4157c) callback).onActionViewCollapsed();
            }
            Toolbar toolbar = Toolbar.this;
            toolbar.removeView(toolbar.f41481j);
            Toolbar toolbar2 = Toolbar.this;
            toolbar2.removeView(toolbar2.f41480i);
            Toolbar toolbar3 = Toolbar.this;
            toolbar3.f41481j = null;
            toolbar3.f();
            this.f41503b = null;
            Toolbar.this.requestLayout();
            eVar.v(false);
            return true;
        }

        @Override // stepos.support.v7.view.menu.g
        public boolean e(stepos.support.v7.view.menu.i iVar) {
            return false;
        }

        @Override // stepos.support.v7.view.menu.g
        public boolean f(stepos.support.v7.view.menu.c cVar, stepos.support.v7.view.menu.e eVar) {
            Toolbar.this.m();
            ViewParent parent = Toolbar.this.f41480i.getParent();
            Toolbar toolbar = Toolbar.this;
            if (parent != toolbar) {
                toolbar.addView(toolbar.f41480i);
            }
            Toolbar.this.f41481j = eVar.getActionView();
            this.f41503b = eVar;
            ViewParent parent2 = Toolbar.this.f41481j.getParent();
            Toolbar toolbar2 = Toolbar.this;
            if (parent2 != toolbar2) {
                f fVarGenerateDefaultLayoutParams = toolbar2.generateDefaultLayoutParams();
                fVarGenerateDefaultLayoutParams.f40399a = (Toolbar.this.f41487p & 112) | 8388611;
                fVarGenerateDefaultLayoutParams.f41505b = 2;
                Toolbar.this.f41481j.setLayoutParams(fVarGenerateDefaultLayoutParams);
                Toolbar toolbar3 = Toolbar.this;
                toolbar3.addView(toolbar3.f41481j);
            }
            Toolbar.this.Q();
            Toolbar.this.requestLayout();
            eVar.v(true);
            KeyEvent.Callback callback = Toolbar.this.f41481j;
            if (callback instanceof InterfaceC4157c) {
                ((InterfaceC4157c) callback).onActionViewExpanded();
            }
            return true;
        }

        @Override // stepos.support.v7.view.menu.g
        public void g(Context context, stepos.support.v7.view.menu.c cVar) {
            stepos.support.v7.view.menu.e eVar;
            stepos.support.v7.view.menu.c cVar2 = this.f41502a;
            if (cVar2 != null && (eVar = this.f41503b) != null) {
                cVar2.f(eVar);
            }
            this.f41502a = cVar;
        }

        public /* synthetic */ e(Toolbar toolbar, a aVar) {
            this();
        }
    }

    public interface g {
        boolean onMenuItemClick(MenuItem menuItem);
    }

    public class h implements V {

        /* renamed from: a, reason: collision with root package name */
        public boolean f41506a = false;

        /* renamed from: b, reason: collision with root package name */
        public int f41507b;

        public h() {
        }

        public h a(U u10, int i10) {
            Toolbar.this.f41473c0 = u10;
            this.f41507b = i10;
            return this;
        }

        @Override // androidx.core.view.V
        public void c(View view) {
            this.f41506a = true;
        }

        @Override // androidx.core.view.V
        public void d(View view) {
            if (this.f41506a) {
                return;
            }
            Toolbar toolbar = Toolbar.this;
            toolbar.f41473c0 = null;
            if (toolbar.f41468a != null) {
                Toolbar.this.f41468a.setVisibility(this.f41507b);
            }
        }

        @Override // androidx.core.view.V
        public void e(View view) {
            if (Toolbar.this.f41468a != null) {
                Toolbar.this.f41468a.setVisibility(0);
            }
            this.f41506a = false;
        }
    }

    public Toolbar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, O6.c.c() ? R$attr.steposToolbarStyleFullScreen : androidx.appcompat.R$attr.toolbarStyle);
    }

    private MenuInflater getMenuInflater() {
        return new Ic.k(getContext());
    }

    public boolean A() {
        e eVar = this.f41457M;
        return (eVar == null || eVar.f41503b == null) ? false : true;
    }

    public boolean B() {
        ActionMenuView actionMenuView = this.f41468a;
        return actionMenuView != null && actionMenuView.p();
    }

    public final boolean C(ViewGroup viewGroup) {
        int childCount = viewGroup.getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = viewGroup.getChildAt(i10);
            if (childAt instanceof Button) {
                return true;
            }
            if ((childAt instanceof ViewGroup) && C((ViewGroup) childAt)) {
                return true;
            }
        }
        return false;
    }

    public final boolean D(View view) {
        return view.getParent() == this || this.f41451G.contains(view);
    }

    public boolean E() {
        ActionMenuView actionMenuView = this.f41468a;
        return actionMenuView != null && actionMenuView.q();
    }

    public boolean F() {
        ActionMenuView actionMenuView = this.f41468a;
        return actionMenuView != null && actionMenuView.r();
    }

    public boolean G() {
        return this.f41464T;
    }

    public final int H(View view, int i10, int[] iArr, int i11) {
        f fVar = (f) view.getLayoutParams();
        int i12 = ((ViewGroup.MarginLayoutParams) fVar).leftMargin - iArr[0];
        int iMax = i10 + Math.max(0, i12);
        iArr[0] = Math.max(0, -i12);
        int iV = v(view, i11);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(iMax, iV, iMax + measuredWidth, view.getMeasuredHeight() + iV);
        return iMax + measuredWidth + ((ViewGroup.MarginLayoutParams) fVar).rightMargin;
    }

    public final int I(View view, int i10, int[] iArr, int i11) {
        f fVar = (f) view.getLayoutParams();
        int i12 = ((ViewGroup.MarginLayoutParams) fVar).rightMargin - iArr[1];
        int iMax = i10 - Math.max(0, i12);
        iArr[1] = Math.max(0, -i12);
        int iV = v(view, i11);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(iMax - measuredWidth, iV, iMax, view.getMeasuredHeight() + iV);
        return iMax - (measuredWidth + ((ViewGroup.MarginLayoutParams) fVar).leftMargin);
    }

    public final int J(View view, int i10, int i11, int i12, int i13, int[] iArr) {
        return K(view, i10, i11, i12, i13, iArr, false);
    }

    public final int K(View view, int i10, int i11, int i12, int i13, int[] iArr, boolean z10) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int i14 = marginLayoutParams.leftMargin - iArr[0];
        int i15 = marginLayoutParams.rightMargin - iArr[1];
        int iMax = Math.max(0, i14) + Math.max(0, i15);
        iArr[0] = Math.max(0, -i14);
        iArr[1] = Math.max(0, -i15);
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i10, getPaddingLeft() + getPaddingRight() + iMax + i11, marginLayoutParams.width);
        int childMeasureSpec2 = ViewGroup.getChildMeasureSpec(i12, getPaddingTop() + getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i13, marginLayoutParams.height);
        if (z10 && view.getMinimumWidth() > View.MeasureSpec.getSize(childMeasureSpec)) {
            childMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.getMode(childMeasureSpec));
        }
        view.measure(childMeasureSpec, childMeasureSpec2);
        return view.getMeasuredWidth() + iMax;
    }

    public final void L(View view, int i10, int i11, int i12, int i13, int i14) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i10, getPaddingLeft() + getPaddingRight() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i11, marginLayoutParams.width);
        int childMeasureSpec2 = ViewGroup.getChildMeasureSpec(i12, getPaddingTop() + getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i13, marginLayoutParams.height);
        int mode = View.MeasureSpec.getMode(childMeasureSpec2);
        if (mode != 1073741824 && i14 >= 0) {
            if (mode != 0) {
                i14 = Math.min(View.MeasureSpec.getSize(childMeasureSpec2), i14);
            }
            childMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i14, 1073741824);
        }
        view.measure(childMeasureSpec, childMeasureSpec2);
    }

    /* JADX WARN: Removed duplicated region for block: B:117:0x02e0 A[LOOP:0: B:116:0x02de->B:117:0x02e0, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:120:0x02fe A[LOOP:1: B:119:0x02fc->B:120:0x02fe, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0326  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0335 A[LOOP:2: B:128:0x0333->B:129:0x0335, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0166  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x01a2  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x01af  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x021c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void M(boolean r21, int r22, int r23, int r24, int r25) {
        /*
            Method dump skipped, instructions count: 842
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: stepos.support.v7.widget.Toolbar.M(boolean, int, int, int, int):void");
    }

    public final void N(int i10, int i11) {
        int iX;
        int iMax;
        int iH;
        int i12;
        int[] iArr;
        int iMax2;
        int iH2;
        int measuredHeight;
        int[] iArr2 = this.f41452H;
        boolean zM = y.m(this);
        int i13 = !zM ? 1 : 0;
        int i14 = this.f41490s;
        if (Z(this.f41476e)) {
            L(this.f41476e, i10, 0, i11, 0, this.f41488q);
            int measuredWidth = this.f41476e.getMeasuredWidth() + x(this.f41476e);
            iMax = Math.max(0, this.f41476e.getMeasuredHeight() + y(this.f41476e));
            iH = y.h(0, N.v(this.f41476e));
            iX = measuredWidth;
            i14 = this.f41491t;
        } else {
            iX = 0;
            iMax = 0;
            iH = 0;
        }
        this.f41489r = i14;
        if (Z(this.f41480i)) {
            L(this.f41480i, i10, 0, i11, 0, this.f41488q);
            iX = x(this.f41480i) + this.f41480i.getMeasuredWidth();
            iMax = Math.max(iMax, this.f41480i.getMeasuredHeight() + y(this.f41480i));
            iH = y.h(iH, N.v(this.f41480i));
        }
        int contentInsetStart = getContentInsetStart();
        int iMax3 = Math.max(contentInsetStart, iX);
        iArr2[zM ? 1 : 0] = Math.max(0, contentInsetStart - iX);
        if (Z(this.f41468a)) {
            L(this.f41468a, i10, iMax3, i11, 0, this.f41488q);
            int measuredWidth2 = this.f41468a.getMeasuredWidth() + x(this.f41468a);
            iMax = Math.max(iMax, this.f41468a.getMeasuredHeight() + y(this.f41468a));
            iH = y.h(iH, N.v(this.f41468a));
            i12 = measuredWidth2;
        } else {
            i12 = 0;
        }
        int contentInsetEnd = getContentInsetEnd();
        int iMax4 = iMax3 + Math.max(contentInsetEnd, i12);
        iArr2[i13] = Math.max(0, contentInsetEnd - i12);
        if (Z(this.f41481j)) {
            iArr = iArr2;
            iMax4 += J(this.f41481j, i10, iMax4, i11, 0, iArr);
            iMax = Math.max(iMax, this.f41481j.getMeasuredHeight() + y(this.f41481j));
            iH = y.h(iH, N.v(this.f41481j));
        } else {
            iArr = iArr2;
        }
        if (Z(this.f41477f)) {
            iMax4 += J(this.f41477f, i10, iMax4, i11, 0, iArr);
            iMax = Math.max(iMax, this.f41477f.getMeasuredHeight() + y(this.f41477f));
            iH = y.h(iH, N.v(this.f41477f));
        }
        int childCount = getChildCount();
        for (int i15 = 0; i15 < childCount; i15++) {
            View childAt = getChildAt(i15);
            if (((f) childAt.getLayoutParams()).f41505b == 0 && Z(childAt)) {
                iMax4 += J(childAt, i10, iMax4, i11, 0, iArr);
                int iMax5 = Math.max(iMax, childAt.getMeasuredHeight() + y(childAt));
                iH = y.h(iH, N.v(childAt));
                iMax = iMax5;
            } else {
                iMax4 = iMax4;
            }
        }
        int i16 = iMax4;
        int i17 = this.f41493v + this.f41494w;
        int i18 = this.f41489r + this.f41492u;
        int i19 = (this.f41496y & 7) != 1 ? i16 : i12 * 2;
        if (Z(this.f41470b)) {
            K(this.f41470b, i10, i19 + i18, i11, i17, iArr, true);
            int measuredWidth3 = this.f41470b.getMeasuredWidth() + x(this.f41470b);
            int measuredHeight2 = this.f41470b.getMeasuredHeight() + y(this.f41470b);
            iMax2 = measuredWidth3;
            iH2 = y.h(iH, N.v(this.f41470b));
            measuredHeight = measuredHeight2;
        } else {
            iMax2 = 0;
            iH2 = iH;
            measuredHeight = 0;
        }
        if (Z(this.f41474d)) {
            iMax2 = Math.max(iMax2, J(this.f41474d, i10, i19 + i18, i11, i17 + measuredHeight, iArr));
            measuredHeight += this.f41474d.getMeasuredHeight() + y(this.f41474d);
            iH2 = y.h(iH2, N.v(this.f41474d));
        }
        setMeasuredDimension(N.f0(Math.max(i16 + iMax2 + getPaddingLeft() + getPaddingRight(), getSuggestedMinimumWidth()), i10, (-16777216) & iH2), Y() ? 0 : N.f0(Math.max(Math.max(iMax, measuredHeight) + getPaddingTop() + getPaddingBottom(), getSuggestedMinimumHeight()), i11, iH2 << 16));
    }

    public final void O() {
        removeCallbacks(this.f41461Q);
        post(this.f41461Q);
    }

    public void P(ViewGroup viewGroup) {
        ViewGroup viewGroup2 = this.f41466V;
        if (viewGroup2 == null || viewGroup == null || !C(viewGroup2)) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = this.f41466V.getLayoutParams();
        layoutParams.height = ((int) O6.s.a(80.0f, getContext())) + viewGroup.getPaddingBottom();
        this.f41466V.setLayoutParams(layoutParams);
    }

    public void Q() {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            if (((f) childAt.getLayoutParams()).f41505b != 2 && childAt != this.f41468a) {
                removeViewAt(childCount);
                this.f41451G.add(childAt);
            }
        }
    }

    public void R(stepos.support.v7.view.menu.c cVar, ActionMenuPresenter actionMenuPresenter) {
        l();
        stepos.support.v7.view.menu.c cVarY = this.f41463S.y();
        if (cVarY == cVar) {
            return;
        }
        if (cVarY != null) {
            cVarY.N(this.f41456L);
        }
        actionMenuPresenter.S(true);
        if (cVar != null) {
            cVar.c(actionMenuPresenter, this.f41482k);
        }
        this.f41463S.setPopupTheme(this.f41483l);
        this.f41463S.setPresenter(actionMenuPresenter);
    }

    public void S(int i10, int i11) {
        this.f41495x.g(i10, i11);
    }

    public void T(stepos.support.v7.view.menu.c cVar, ActionMenuPresenter actionMenuPresenter) {
        if (cVar == null && this.f41468a == null) {
            return;
        }
        p();
        stepos.support.v7.view.menu.c cVarY = this.f41468a.y();
        if (cVarY == cVar) {
            return;
        }
        if (cVarY != null) {
            cVarY.N(this.f41456L);
            cVarY.N(this.f41457M);
        }
        a aVar = null;
        if (this.f41457M == null) {
            this.f41457M = new e(this, aVar);
        }
        actionMenuPresenter.S(true);
        if (cVar != null) {
            cVar.c(actionMenuPresenter, this.f41482k);
            cVar.c(this.f41457M, this.f41482k);
        } else {
            actionMenuPresenter.g(this.f41482k, null);
            this.f41457M.g(this.f41482k, null);
            actionMenuPresenter.b(true);
            this.f41457M.b(true);
        }
        this.f41468a.setPopupTheme(this.f41483l);
        this.f41468a.setPresenter(actionMenuPresenter);
        this.f41456L = actionMenuPresenter;
    }

    public void U(g.a aVar, c.a aVar2) {
        this.f41458N = aVar;
        this.f41459O = aVar2;
        ActionMenuView actionMenuView = this.f41468a;
        if (actionMenuView != null) {
            actionMenuView.z(aVar, aVar2);
        }
    }

    public void V(int i10, long j10) {
        if ((!this.f41467W || this.f41468a == null) && this.f41463S == null && this.f41471b0 != null) {
            return;
        }
        View view = this.f41471b0;
        if (view == null && (view = this.f41463S) == null) {
            view = this.f41468a;
        }
        if (i10 != 0) {
            U uB = N.d(view).b(0.0f);
            uB.f(j10);
            uB.h(this.f41475d0.a(uB, i10));
            uB.l();
            return;
        }
        N.l0(view, 0.0f);
        U uB2 = N.d(view).b(1.0f);
        uB2.f(j10);
        uB2.h(this.f41475d0.a(uB2, i10));
        uB2.l();
    }

    public void W(Context context, int i10) {
        this.f41486o = i10;
        TextView textView = this.f41474d;
        if (textView != null) {
            textView.setTextAppearance(context, i10);
        }
    }

    public void X(Context context, int i10) {
        this.f41484m = i10;
        TextView textView = this.f41472c;
        if (textView != null) {
            textView.setTextAppearance(context, i10);
        }
    }

    public final boolean Y() {
        if (!this.f41460P) {
            return false;
        }
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            if (Z(childAt) && childAt.getMeasuredWidth() > 0 && childAt.getMeasuredHeight() > 0) {
                return false;
            }
        }
        return true;
    }

    public final boolean Z(View view) {
        return (view == null || view.getParent() != this || view.getVisibility() == 8) ? false : true;
    }

    public boolean a0() {
        ActionMenuView actionMenuView = this.f41468a;
        return actionMenuView != null && actionMenuView.A();
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return super.checkLayoutParams(layoutParams) && (layoutParams instanceof f);
    }

    public void f() {
        for (int size = this.f41451G.size() - 1; size >= 0; size--) {
            addView(this.f41451G.get(size));
        }
        this.f41451G.clear();
    }

    public final void g(List<View> list, int i10) {
        boolean z10 = N.u(this) == 1;
        int childCount = getChildCount();
        int iB = C1321i.b(i10, N.u(this));
        list.clear();
        if (!z10) {
            for (int i11 = 0; i11 < childCount; i11++) {
                View childAt = getChildAt(i11);
                f fVar = (f) childAt.getLayoutParams();
                if (fVar.f41505b == 0 && Z(childAt) && u(fVar.f40399a) == iB) {
                    list.add(childAt);
                }
            }
            return;
        }
        for (int i12 = childCount - 1; i12 >= 0; i12--) {
            View childAt2 = getChildAt(i12);
            f fVar2 = (f) childAt2.getLayoutParams();
            if (fVar2.f41505b == 0 && Z(childAt2) && u(fVar2.f40399a) == iB) {
                list.add(childAt2);
            }
        }
    }

    public int getContentInsetEnd() {
        return this.f41495x.a();
    }

    public int getContentInsetLeft() {
        return this.f41495x.b();
    }

    public int getContentInsetRight() {
        return this.f41495x.c();
    }

    public int getContentInsetStart() {
        return this.f41495x.d();
    }

    public Drawable getLogo() {
        ImageView imageView = this.f41477f;
        if (imageView != null) {
            return imageView.getDrawable();
        }
        return null;
    }

    public CharSequence getLogoDescription() {
        ImageView imageView = this.f41477f;
        if (imageView != null) {
            return imageView.getContentDescription();
        }
        return null;
    }

    public Menu getMenu() {
        o();
        return this.f41468a.getMenu();
    }

    public CharSequence getNavigationContentDescription() {
        ImageButton imageButton = this.f41476e;
        if (imageButton != null) {
            return imageButton.getContentDescription();
        }
        return null;
    }

    public Drawable getNavigationIcon() {
        ImageButton imageButton = this.f41476e;
        if (imageButton != null) {
            return imageButton.getDrawable();
        }
        return null;
    }

    public Drawable getOverflowIcon() {
        o();
        return this.f41468a.getOverflowIcon();
    }

    public int getPopupTheme() {
        return this.f41483l;
    }

    public View getSplitBarCustomView() {
        return this.f41471b0;
    }

    public CharSequence getSubtitle() {
        return this.f41445A;
    }

    public CharSequence getTitle() {
        return this.f41497z;
    }

    public int getTitleMarginBottom() {
        return this.f41494w;
    }

    public int getTitleMarginEnd() {
        return this.f41492u;
    }

    public int getTitleMarginStart() {
        return this.f41489r;
    }

    public int getTitleMarginTop() {
        return this.f41493v;
    }

    public k getWrapper() {
        if (this.f41455K == null) {
            this.f41455K = new w(this, true);
        }
        return this.f41455K;
    }

    public final void h(View view, boolean z10) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        f fVarGenerateDefaultLayoutParams = layoutParams == null ? generateDefaultLayoutParams() : !checkLayoutParams(layoutParams) ? generateLayoutParams(layoutParams) : (f) layoutParams;
        fVarGenerateDefaultLayoutParams.f41505b = 1;
        if (!z10 || this.f41481j == null) {
            addView(view, fVarGenerateDefaultLayoutParams);
        } else {
            view.setLayoutParams(fVarGenerateDefaultLayoutParams);
            this.f41451G.add(view);
        }
    }

    public boolean i() {
        ActionMenuView actionMenuView;
        return getVisibility() == 0 && (actionMenuView = this.f41468a) != null && actionMenuView.s();
    }

    public void j() {
        e eVar = this.f41457M;
        stepos.support.v7.view.menu.e eVar2 = eVar == null ? null : eVar.f41503b;
        if (eVar2 != null) {
            eVar2.collapseActionView();
        }
    }

    public void k() {
        ActionMenuView actionMenuView = this.f41468a;
        if (actionMenuView != null) {
            actionMenuView.j();
        }
    }

    public final void l() {
        if (this.f41463S == null) {
            ActionMenuView actionMenuView = new ActionMenuView(getContext());
            this.f41463S = actionMenuView;
            actionMenuView.setPopupTheme(this.f41483l);
            this.f41463S.setOnMenuItemClickListener(this.f41454J);
            f fVarGenerateDefaultLayoutParams = generateDefaultLayoutParams();
            fVarGenerateDefaultLayoutParams.f40399a = (this.f41487p & 112) | 8388613;
            this.f41463S.setLayoutParams(fVarGenerateDefaultLayoutParams);
            this.f41463S.setId(R$id.stepos_action_bottom_menu_view);
            ViewGroup viewGroup = this.f41466V;
            if (viewGroup != null) {
                ((ViewGroup.MarginLayoutParams) fVarGenerateDefaultLayoutParams).width = -1;
                viewGroup.addView(this.f41463S, 0, fVarGenerateDefaultLayoutParams);
            }
        }
    }

    public final void m() {
        if (this.f41480i == null) {
            ImageButton imageButton = new ImageButton(getContext(), null, androidx.appcompat.R$attr.toolbarNavigationButtonStyle);
            this.f41480i = imageButton;
            imageButton.setImageDrawable(this.f41478g);
            this.f41480i.setContentDescription(this.f41479h);
            f fVarGenerateDefaultLayoutParams = generateDefaultLayoutParams();
            fVarGenerateDefaultLayoutParams.f40399a = (this.f41487p & 112) | 8388611;
            fVarGenerateDefaultLayoutParams.f41505b = 2;
            this.f41480i.setLayoutParams(fVarGenerateDefaultLayoutParams);
            this.f41480i.setOnClickListener(new d());
        }
    }

    public final void n() {
        if (this.f41477f == null) {
            this.f41477f = new ImageView(getContext());
        }
    }

    public final void o() {
        p();
        if (this.f41468a.y() == null) {
            stepos.support.v7.view.menu.c cVar = (stepos.support.v7.view.menu.c) this.f41468a.getMenu();
            if (this.f41457M == null) {
                this.f41457M = new e(this, null);
            }
            this.f41468a.setExpandedActionViewsExclusive(true);
            cVar.c(this.f41457M, this.f41482k);
        }
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        if (this.f41469a0) {
            setSplitToolbar(getContext().getResources().getBoolean(R$bool.stepos_split_action_bar_is_narrow));
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.f41461Q);
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        int iA = C1330s.a(motionEvent);
        if (iA == 9) {
            this.f41449E = false;
        }
        if (!this.f41449E) {
            boolean zOnHoverEvent = super.onHoverEvent(motionEvent);
            if (iA == 9 && !zOnHoverEvent) {
                this.f41449E = true;
            }
        }
        if (iA == 10 || iA == 3) {
            this.f41449E = false;
        }
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        M(z10, i10, i11, i12, i13);
    }

    @Override // android.view.View
    public void onMeasure(int i10, int i11) {
        N(i10, i11);
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        MenuItem menuItemFindItem;
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        ActionMenuView actionMenuView = this.f41468a;
        stepos.support.v7.view.menu.c cVarY = actionMenuView != null ? actionMenuView.y() : null;
        int i10 = savedState.expandedMenuItemId;
        if (i10 != 0 && this.f41457M != null && cVarY != null && (menuItemFindItem = cVarY.findItem(i10)) != null) {
            C1329q.a(menuItemFindItem);
        }
        if (savedState.isOverflowOpen) {
            O();
        }
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i10) {
        super.onRtlPropertiesChanged(i10);
        q qVar = this.f41495x;
        if (qVar != null) {
            qVar.f(i10 == 1);
        }
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        stepos.support.v7.view.menu.e eVar;
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        e eVar2 = this.f41457M;
        if (eVar2 != null && (eVar = eVar2.f41503b) != null) {
            savedState.expandedMenuItemId = eVar.getItemId();
        }
        savedState.isOverflowOpen = F();
        return savedState;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int iA = C1330s.a(motionEvent);
        if (iA == 0) {
            this.f41448D = false;
        }
        if (!this.f41448D) {
            boolean zOnTouchEvent = super.onTouchEvent(motionEvent);
            if (iA == 0 && !zOnTouchEvent) {
                this.f41448D = true;
            }
        }
        if (iA == 1 || iA == 3) {
            this.f41448D = false;
        }
        return true;
    }

    public final void p() {
        if (this.f41468a == null) {
            ActionMenuView actionMenuView = new ActionMenuView(getContext());
            this.f41468a = actionMenuView;
            actionMenuView.setPopupTheme(this.f41483l);
            this.f41468a.setOnMenuItemClickListener(this.f41454J);
            this.f41468a.z(this.f41458N, this.f41459O);
            f fVarGenerateDefaultLayoutParams = generateDefaultLayoutParams();
            fVarGenerateDefaultLayoutParams.f40399a = (this.f41487p & 112) | 8388613;
            this.f41468a.setLayoutParams(fVarGenerateDefaultLayoutParams);
            this.f41468a.setId(R$id.stepos_action_menu_view);
            if (!this.f41467W) {
                h(this.f41468a, false);
            } else {
                ((ViewGroup.MarginLayoutParams) fVarGenerateDefaultLayoutParams).width = -1;
                this.f41466V.addView(this.f41468a, 0, fVarGenerateDefaultLayoutParams);
            }
        }
    }

    public final void q() {
        if (this.f41476e == null) {
            ImageButton imageButton = new ImageButton(getContext(), null, androidx.appcompat.R$attr.toolbarNavigationButtonStyle);
            this.f41476e = imageButton;
            this.f41465U.f(imageButton, false, com.stepos.common.animator.f.CUSTOM_PRESS_EFFECT_SCALE | com.stepos.common.animator.f.CUSTOM_PRESS_EFFECT_ALPHA);
            f fVarGenerateDefaultLayoutParams = generateDefaultLayoutParams();
            fVarGenerateDefaultLayoutParams.f40399a = (this.f41487p & 112) | 8388611;
            this.f41476e.setLayoutParams(fVarGenerateDefaultLayoutParams);
            this.f41476e.setImageDrawable(s0.h.e(getResources(), R$drawable.stepos_titlebar_ic_back_dark, null));
            this.f41476e.setLayoutDirection(3);
            this.f41476e.setId(R$id.stepos_toolbar_nav_button);
            this.f41476e.addOnLayoutChangeListener(new c());
        }
    }

    @Override // android.view.ViewGroup
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public f generateDefaultLayoutParams() {
        return new f(-2, -2);
    }

    @Override // android.view.ViewGroup
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public f generateLayoutParams(AttributeSet attributeSet) {
        return new f(getContext(), attributeSet);
    }

    public void setCollapsible(boolean z10) {
        this.f41460P = z10;
        requestLayout();
    }

    public void setLogo(int i10) {
        setLogo(this.f41462R.c(getContext(), i10));
    }

    public void setLogoDescription(int i10) {
        setLogoDescription(getContext().getText(i10));
    }

    public void setMenuVisibility(int i10) {
        ActionMenuView actionMenuView = this.f41468a;
        if (actionMenuView == null || !this.f41467W) {
            return;
        }
        actionMenuView.setVisibility(i10);
    }

    public void setNavigationContentDescription(int i10) {
        setNavigationContentDescription(i10 != 0 ? getContext().getText(i10) : null);
    }

    public void setNavigationIcon(int i10) {
        setNavigationIcon(this.f41462R.c(getContext(), i10));
    }

    public void setNavigationOnClickListener(View.OnClickListener onClickListener) {
        q();
        this.f41476e.setOnClickListener(onClickListener);
    }

    public void setOnMenuItemClickListener(g gVar) {
        this.f41453I = gVar;
    }

    public void setOverflowIcon(Drawable drawable) {
        o();
        this.f41468a.setOverflowIcon(drawable);
    }

    public void setPopupTheme(int i10) {
        if (this.f41483l != i10) {
            this.f41483l = i10;
            if (i10 == 0) {
                this.f41482k = getContext();
            } else {
                this.f41482k = new ContextThemeWrapper(getContext(), i10);
            }
        }
    }

    public void setShowBottomMenu(boolean z10) {
        if (this.f41464T != z10) {
            this.f41464T = z10;
            ActionMenuView actionMenuView = this.f41463S;
            if (actionMenuView != null) {
                ViewGroup viewGroup = (ViewGroup) actionMenuView.getParent();
                if (viewGroup != null) {
                    viewGroup.removeView(this.f41463S);
                }
                if (this.f41464T) {
                    ViewGroup viewGroup2 = this.f41466V;
                    if (viewGroup2 != null) {
                        viewGroup2.addView(this.f41463S);
                    }
                    this.f41463S.getLayoutParams().width = -1;
                }
                this.f41463S.requestLayout();
            }
        }
    }

    public void setSplitCustomView(View view) {
        FrameLayout.LayoutParams layoutParams;
        if (this.f41466V == null) {
            return;
        }
        View view2 = this.f41471b0;
        if (view2 != null) {
            ((ViewGroup) view2.getParent()).removeView(this.f41471b0);
        }
        if (view != null && view.getParent() != null) {
            ((ViewGroup) view.getParent()).removeView(view);
        }
        this.f41471b0 = view;
        if (view != null) {
            ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
            if (layoutParams2 != null) {
                layoutParams = new FrameLayout.LayoutParams(layoutParams2);
                if (!(layoutParams2 instanceof FrameLayout.LayoutParams)) {
                    layoutParams.gravity = 17;
                }
            } else {
                layoutParams = new FrameLayout.LayoutParams(-1, -1);
                layoutParams.gravity = 17;
            }
            this.f41466V.addView(view, layoutParams);
        }
    }

    public void setSplitToolbar(boolean z10) {
        if (this.f41467W != z10) {
            this.f41467W = z10;
            ActionMenuView actionMenuView = this.f41468a;
            if (actionMenuView != null) {
                ViewGroup viewGroup = (ViewGroup) actionMenuView.getParent();
                if (viewGroup != null) {
                    viewGroup.removeView(this.f41468a);
                }
                if (z10) {
                    ViewGroup viewGroup2 = this.f41466V;
                    if (viewGroup2 != null) {
                        viewGroup2.addView(this.f41468a);
                    }
                    this.f41468a.getLayoutParams().width = -1;
                } else {
                    h(this.f41468a, false);
                    this.f41468a.getLayoutParams().width = -2;
                }
                this.f41468a.requestLayout();
            }
        }
    }

    public void setSplitView(ViewGroup viewGroup) {
        this.f41466V = viewGroup;
    }

    public void setSubtitle(int i10) {
        setSubtitle(getContext().getText(i10));
    }

    public void setSubtitleTextColor(int i10) {
        this.f41447C = i10;
        TextView textView = this.f41474d;
        if (textView != null) {
            textView.setTextColor(i10);
        }
    }

    public void setTitle(int i10) {
        setTitle(getContext().getText(i10));
    }

    public void setTitleTextColor(int i10) {
        this.f41446B = i10;
        TextView textView = this.f41472c;
        if (textView != null) {
            textView.setTextColor(i10);
        }
    }

    @Override // android.view.ViewGroup
    /* renamed from: t, reason: merged with bridge method [inline-methods] */
    public f generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof f ? new f((f) layoutParams) : layoutParams instanceof a.d ? new f((a.d) layoutParams) : layoutParams instanceof ViewGroup.MarginLayoutParams ? new f((ViewGroup.MarginLayoutParams) layoutParams) : new f(layoutParams);
    }

    public final int u(int i10) {
        int iU = N.u(this);
        int iB = C1321i.b(i10, iU) & 7;
        return (iB == 1 || iB == 3 || iB == 5) ? iB : iU == 1 ? 5 : 3;
    }

    public final int v(View view, int i10) {
        f fVar = (f) view.getLayoutParams();
        int measuredHeight = view.getMeasuredHeight();
        int i11 = i10 > 0 ? (measuredHeight - i10) / 2 : 0;
        int iW = w(fVar.f40399a);
        if (iW == 48) {
            return getPaddingTop() - i11;
        }
        if (iW == 80) {
            return (((getHeight() - getPaddingBottom()) - measuredHeight) - ((ViewGroup.MarginLayoutParams) fVar).bottomMargin) - i11;
        }
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int height = getHeight();
        int iMax = (((height - paddingTop) - paddingBottom) - measuredHeight) / 2;
        int i12 = ((ViewGroup.MarginLayoutParams) fVar).topMargin;
        if (iMax < i12) {
            iMax = i12;
        } else {
            int i13 = (((height - paddingBottom) - measuredHeight) - iMax) - paddingTop;
            int i14 = ((ViewGroup.MarginLayoutParams) fVar).bottomMargin;
            if (i13 < i14) {
                iMax = Math.max(0, iMax - (i14 - i13));
            }
        }
        return paddingTop + iMax;
    }

    public final int w(int i10) {
        int i11 = i10 & 112;
        return (i11 == 16 || i11 == 48 || i11 == 80) ? i11 : this.f41496y & 112;
    }

    public final int x(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return C1324l.b(marginLayoutParams) + C1324l.a(marginLayoutParams);
    }

    public final int y(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
    }

    public final int z(List<View> list, int[] iArr) {
        int i10 = iArr[0];
        int i11 = iArr[1];
        int size = list.size();
        int i12 = 0;
        int measuredWidth = 0;
        while (i12 < size) {
            View view = list.get(i12);
            f fVar = (f) view.getLayoutParams();
            int i13 = ((ViewGroup.MarginLayoutParams) fVar).leftMargin - i10;
            int i14 = ((ViewGroup.MarginLayoutParams) fVar).rightMargin - i11;
            int iMax = Math.max(0, i13);
            int iMax2 = Math.max(0, i14);
            int iMax3 = Math.max(0, -i13);
            int iMax4 = Math.max(0, -i14);
            measuredWidth += iMax + view.getMeasuredWidth() + iMax2;
            i12++;
            i11 = iMax4;
            i10 = iMax3;
        }
        return measuredWidth;
    }

    public static class f extends a.d {

        /* renamed from: b, reason: collision with root package name */
        public int f41505b;

        public f(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f41505b = 0;
        }

        public void a(ViewGroup.MarginLayoutParams marginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this).leftMargin = marginLayoutParams.leftMargin;
            ((ViewGroup.MarginLayoutParams) this).topMargin = marginLayoutParams.topMargin;
            ((ViewGroup.MarginLayoutParams) this).rightMargin = marginLayoutParams.rightMargin;
            ((ViewGroup.MarginLayoutParams) this).bottomMargin = marginLayoutParams.bottomMargin;
        }

        public f(int i10, int i11) {
            super(i10, i11);
            this.f41505b = 0;
            this.f40399a = 8388627;
        }

        public f(f fVar) {
            super((a.d) fVar);
            this.f41505b = 0;
            this.f41505b = fVar.f41505b;
        }

        public f(a.d dVar) {
            super(dVar);
            this.f41505b = 0;
        }

        public f(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f41505b = 0;
            a(marginLayoutParams);
        }

        public f(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f41505b = 0;
        }
    }

    public Toolbar(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        q qVar = new q();
        this.f41495x = qVar;
        this.f41496y = 8388627;
        this.f41450F = new ArrayList<>();
        this.f41451G = new ArrayList<>();
        this.f41452H = new int[2];
        this.f41454J = new a();
        this.f41461Q = new b();
        this.f41465U = new com.stepos.common.animator.f();
        this.f41475d0 = new h();
        androidx.appcompat.widget.U uV = androidx.appcompat.widget.U.v(getContext(), attributeSet, R$styleable.Toolbar, i10, 0);
        this.f41484m = uV.n(R$styleable.Toolbar_titleTextAppearance, 0);
        this.f41485n = uV.n(stepos.support.v7.appcompat.R$styleable.Toolbar_steposTitleTextAppearanceBack, 0);
        this.f41486o = uV.n(R$styleable.Toolbar_subtitleTextAppearance, 0);
        this.f41496y = uV.l(R$styleable.Toolbar_android_gravity, this.f41496y);
        this.f41487p = uV.l(stepos.support.v7.appcompat.R$styleable.Toolbar_steposButtonGravity, 48);
        int iE = uV.e(R$styleable.Toolbar_titleMargins, 0);
        this.f41494w = iE;
        this.f41493v = iE;
        this.f41492u = iE;
        this.f41490s = iE;
        int iE2 = uV.e(R$styleable.Toolbar_titleMarginStart, -1);
        if (iE2 >= 0) {
            this.f41490s = iE2;
        }
        int iE3 = uV.e(R$styleable.Toolbar_titleMarginEnd, -1);
        if (iE3 >= 0) {
            this.f41492u = iE3;
        }
        int iE4 = uV.e(R$styleable.Toolbar_titleMarginTop, -1);
        if (iE4 >= 0) {
            this.f41493v = iE4;
        }
        int iE5 = uV.e(R$styleable.Toolbar_titleMarginBottom, -1);
        if (iE5 >= 0) {
            this.f41494w = iE5;
        }
        this.f41488q = uV.f(R$styleable.Toolbar_maxButtonHeight, -1);
        int iE6 = uV.e(R$styleable.Toolbar_contentInsetStart, Integer.MIN_VALUE);
        int iE7 = uV.e(R$styleable.Toolbar_contentInsetEnd, Integer.MIN_VALUE);
        qVar.e(uV.f(R$styleable.Toolbar_contentInsetLeft, 0), uV.f(R$styleable.Toolbar_contentInsetRight, 0));
        if (iE6 != Integer.MIN_VALUE || iE7 != Integer.MIN_VALUE) {
            qVar.g(iE6, iE7);
        }
        this.f41478g = uV.g(R$styleable.Toolbar_collapseIcon);
        this.f41479h = uV.p(R$styleable.Toolbar_collapseContentDescription);
        CharSequence charSequenceP = uV.p(R$styleable.Toolbar_title);
        if (!TextUtils.isEmpty(charSequenceP)) {
            setTitle(charSequenceP);
        }
        CharSequence charSequenceP2 = uV.p(R$styleable.Toolbar_subtitle);
        if (!TextUtils.isEmpty(charSequenceP2)) {
            setSubtitle(charSequenceP2);
        }
        this.f41482k = getContext();
        setPopupTheme(uV.n(R$styleable.Toolbar_popupTheme, 0));
        Drawable drawableG = uV.g(R$styleable.Toolbar_navigationIcon);
        if (drawableG != null) {
            setNavigationIcon(drawableG);
        }
        CharSequence charSequenceP3 = uV.p(R$styleable.Toolbar_navigationContentDescription);
        if (!TextUtils.isEmpty(charSequenceP3)) {
            setNavigationContentDescription(charSequenceP3);
        }
        Drawable drawableG2 = uV.g(R$styleable.Toolbar_logo);
        if (drawableG2 != null) {
            setLogo(drawableG2);
        }
        CharSequence charSequenceP4 = uV.p(R$styleable.Toolbar_logoDescription);
        if (!TextUtils.isEmpty(charSequenceP4)) {
            setLogoDescription(charSequenceP4);
        }
        int i11 = R$styleable.Toolbar_titleTextColor;
        if (uV.s(i11)) {
            setTitleTextColor(uV.b(i11, -1));
        }
        int i12 = R$styleable.Toolbar_subtitleTextColor;
        if (uV.s(i12)) {
            setSubtitleTextColor(uV.b(i12, -1));
        }
        this.f41491t = uV.f(stepos.support.v7.appcompat.R$styleable.Toolbar_steposTitleMarginStartBack, this.f41489r);
        this.f41489r = this.f41490s;
        uV.x();
        this.f41462R = C1295h.b();
    }

    public void setLogo(Drawable drawable) {
        if (drawable != null) {
            n();
            if (!D(this.f41477f)) {
                h(this.f41477f, true);
            }
        } else {
            ImageView imageView = this.f41477f;
            if (imageView != null && D(imageView)) {
                removeView(this.f41477f);
                this.f41451G.remove(this.f41477f);
            }
        }
        ImageView imageView2 = this.f41477f;
        if (imageView2 != null) {
            imageView2.setImageDrawable(drawable);
        }
    }

    public void setLogoDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            n();
        }
        ImageView imageView = this.f41477f;
        if (imageView != null) {
            imageView.setContentDescription(charSequence);
        }
    }

    public void setNavigationContentDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            q();
        }
        ImageButton imageButton = this.f41476e;
        if (imageButton != null) {
            imageButton.setContentDescription(charSequence);
        }
    }

    public void setNavigationIcon(Drawable drawable) {
        TextView textView;
        TextView textView2;
        if (drawable != null) {
            q();
            if (!D(this.f41476e)) {
                h(this.f41476e, true);
            }
            if (this.f41485n != 0 && (textView2 = this.f41472c) != null) {
                textView2.setTextAppearance(getContext(), this.f41485n);
            }
        } else {
            ImageButton imageButton = this.f41476e;
            if (imageButton != null && D(imageButton)) {
                removeView(this.f41476e);
                this.f41451G.remove(this.f41476e);
                setTouchDelegate(null);
                if (this.f41484m != 0 && (textView = this.f41472c) != null) {
                    textView.setTextAppearance(getContext(), this.f41484m);
                }
            }
        }
        ImageButton imageButton2 = this.f41476e;
        if (imageButton2 != null) {
            imageButton2.setImageDrawable(drawable);
        }
    }

    public void setSubtitle(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            TextView textView = this.f41474d;
            if (textView != null && D(textView)) {
                removeView(this.f41474d);
                this.f41451G.remove(this.f41474d);
            }
        } else {
            if (this.f41474d == null) {
                Context context = getContext();
                TextView textView2 = new TextView(context);
                this.f41474d = textView2;
                textView2.setSingleLine();
                this.f41474d.setEllipsize(TextUtils.TruncateAt.END);
                int i10 = this.f41486o;
                if (i10 != 0) {
                    this.f41474d.setTextAppearance(context, i10);
                }
                int i11 = this.f41447C;
                if (i11 != 0) {
                    this.f41474d.setTextColor(i11);
                }
            }
            if (!D(this.f41474d)) {
                h(this.f41474d, true);
            }
        }
        TextView textView3 = this.f41474d;
        if (textView3 != null) {
            textView3.setText(charSequence);
        }
        this.f41445A = charSequence;
    }

    public void setTitle(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            HorizontalScrollView horizontalScrollView = this.f41470b;
            if (horizontalScrollView != null && D(horizontalScrollView)) {
                removeView(this.f41470b);
                this.f41451G.remove(this.f41470b);
            }
        } else {
            if (this.f41470b == null) {
                HorizontalScrollView horizontalScrollView2 = new HorizontalScrollView(getContext());
                this.f41470b = horizontalScrollView2;
                horizontalScrollView2.setHorizontalFadingEdgeEnabled(true);
                this.f41470b.setOverScrollMode(2);
                this.f41470b.setHorizontalScrollBarEnabled(false);
                this.f41470b.setMinimumWidth(getContext().getResources().getDimensionPixelSize(R$dimen.stepos_toolbar_title_min_width));
            }
            if (this.f41472c == null) {
                TextView textView = new TextView(getContext());
                this.f41472c = textView;
                textView.setSingleLine();
            }
            if (Z(this.f41476e) && this.f41485n != 0) {
                this.f41472c.setTextAppearance(getContext(), this.f41485n);
            } else if (this.f41484m != 0) {
                this.f41472c.setTextAppearance(getContext(), this.f41484m);
            }
            int i10 = this.f41446B;
            if (i10 != 0) {
                this.f41472c.setTextColor(i10);
            }
            this.f41470b.removeAllViews();
            this.f41470b.addView(this.f41472c);
            if (!D(this.f41470b)) {
                h(this.f41470b, true);
            }
        }
        TextView textView2 = this.f41472c;
        if (textView2 != null) {
            textView2.setText(charSequence);
        }
        this.f41497z = charSequence;
    }

    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();
        int expandedMenuItemId;
        boolean isOverflowOpen;

        public class a implements Parcelable.Creator<SavedState> {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i10) {
                return new SavedState[i10];
            }
        }

        public SavedState(Parcel parcel) {
            super(parcel);
            this.expandedMenuItemId = parcel.readInt();
            this.isOverflowOpen = parcel.readInt() != 0;
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeInt(this.expandedMenuItemId);
            parcel.writeInt(this.isOverflowOpen ? 1 : 0);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }
}
