package stepos.support.v7.widget;

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
import androidx.appcompat.widget.C0441k;
import androidx.appcompat.widget.a0;
import androidx.core.view.C0464i;
import androidx.core.view.C0467l;
import androidx.core.view.C0472q;
import androidx.core.view.C0473s;
import androidx.core.view.H;
import androidx.core.view.S;
import androidx.core.view.T;
import g.C0728a;
import java.util.ArrayList;
import java.util.List;
import stepos.support.v7.app.a;
import stepos.support.v7.view.menu.d;
import stepos.support.v7.view.menu.h;
import stepos.support.v7.widget.ActionMenuView;

/* loaded from: classes.dex */
public class Toolbar extends ViewGroup {

    /* renamed from: A, reason: collision with root package name */
    private CharSequence f21826A;

    /* renamed from: B, reason: collision with root package name */
    private int f21827B;

    /* renamed from: C, reason: collision with root package name */
    private int f21828C;

    /* renamed from: D, reason: collision with root package name */
    private boolean f21829D;

    /* renamed from: E, reason: collision with root package name */
    private boolean f21830E;

    /* renamed from: F, reason: collision with root package name */
    private final ArrayList<View> f21831F;

    /* renamed from: G, reason: collision with root package name */
    private final ArrayList<View> f21832G;

    /* renamed from: H, reason: collision with root package name */
    private final int[] f21833H;

    /* renamed from: I, reason: collision with root package name */
    private g f21834I;

    /* renamed from: J, reason: collision with root package name */
    private final ActionMenuView.f f21835J;

    /* renamed from: K, reason: collision with root package name */
    private A f21836K;

    /* renamed from: L, reason: collision with root package name */
    private stepos.support.v7.widget.d f21837L;

    /* renamed from: M, reason: collision with root package name */
    private e f21838M;

    /* renamed from: Q, reason: collision with root package name */
    private h.a f21839Q;

    /* renamed from: R, reason: collision with root package name */
    private d.a f21840R;

    /* renamed from: S, reason: collision with root package name */
    private boolean f21841S;

    /* renamed from: T, reason: collision with root package name */
    private final Runnable f21842T;

    /* renamed from: U, reason: collision with root package name */
    private final C0441k f21843U;

    /* renamed from: V, reason: collision with root package name */
    private ActionMenuView f21844V;

    /* renamed from: W, reason: collision with root package name */
    private boolean f21845W;

    /* renamed from: a, reason: collision with root package name */
    private ActionMenuView f21846a;

    /* renamed from: a0, reason: collision with root package name */
    private I1.f f21847a0;

    /* renamed from: b, reason: collision with root package name */
    private HorizontalScrollView f21848b;

    /* renamed from: b0, reason: collision with root package name */
    protected ViewGroup f21849b0;

    /* renamed from: c, reason: collision with root package name */
    private TextView f21850c;

    /* renamed from: c0, reason: collision with root package name */
    protected boolean f21851c0;

    /* renamed from: d, reason: collision with root package name */
    private TextView f21852d;

    /* renamed from: d0, reason: collision with root package name */
    protected boolean f21853d0;

    /* renamed from: e, reason: collision with root package name */
    private ImageButton f21854e;

    /* renamed from: e0, reason: collision with root package name */
    private View f21855e0;

    /* renamed from: f, reason: collision with root package name */
    private ImageView f21856f;

    /* renamed from: f0, reason: collision with root package name */
    protected S f21857f0;

    /* renamed from: g, reason: collision with root package name */
    private Drawable f21858g;

    /* renamed from: g0, reason: collision with root package name */
    protected final i f21859g0;

    /* renamed from: h, reason: collision with root package name */
    private CharSequence f21860h;

    /* renamed from: i, reason: collision with root package name */
    private ImageButton f21861i;

    /* renamed from: j, reason: collision with root package name */
    View f21862j;

    /* renamed from: k, reason: collision with root package name */
    private Context f21863k;

    /* renamed from: l, reason: collision with root package name */
    private int f21864l;

    /* renamed from: m, reason: collision with root package name */
    private int f21865m;

    /* renamed from: n, reason: collision with root package name */
    private int f21866n;

    /* renamed from: o, reason: collision with root package name */
    private int f21867o;

    /* renamed from: p, reason: collision with root package name */
    private int f21868p;

    /* renamed from: q, reason: collision with root package name */
    private int f21869q;

    /* renamed from: r, reason: collision with root package name */
    private int f21870r;

    /* renamed from: s, reason: collision with root package name */
    private int f21871s;

    /* renamed from: t, reason: collision with root package name */
    private int f21872t;

    /* renamed from: u, reason: collision with root package name */
    private int f21873u;

    /* renamed from: v, reason: collision with root package name */
    private int f21874v;

    /* renamed from: w, reason: collision with root package name */
    private int f21875w;

    /* renamed from: x, reason: collision with root package name */
    private final u f21876x;

    /* renamed from: y, reason: collision with root package name */
    private int f21877y;

    /* renamed from: z, reason: collision with root package name */
    private CharSequence f21878z;

    class a implements ActionMenuView.f {
        a() {
        }

        @Override // stepos.support.v7.widget.ActionMenuView.f
        public boolean onMenuItemClick(MenuItem menuItem) {
            if (Toolbar.this.f21834I != null) {
                return Toolbar.this.f21834I.onMenuItemClick(menuItem);
            }
            return false;
        }
    }

    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Toolbar.this.a0();
        }
    }

    class c implements View.OnLayoutChangeListener {
        c() {
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12) {
            View view2 = (View) view.getParent();
            int i13 = (int) (Toolbar.this.getResources().getDisplayMetrics().density * 56.0f);
            int i14 = i7 - i5;
            if (i14 < i13) {
                int i15 = (i13 - i14) / 2;
                view2.setTouchDelegate(new TouchDelegate(new Rect(i5 - i15, i6, i7 + i15, i8), view));
            }
        }
    }

    class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Toolbar.this.j();
        }
    }

    private class e implements stepos.support.v7.view.menu.h {

        /* renamed from: a, reason: collision with root package name */
        stepos.support.v7.view.menu.d f21883a;

        /* renamed from: b, reason: collision with root package name */
        stepos.support.v7.view.menu.f f21884b;

        private e() {
        }

        @Override // stepos.support.v7.view.menu.h
        public void a(stepos.support.v7.view.menu.d dVar, boolean z5) {
        }

        @Override // stepos.support.v7.view.menu.h
        public void b(boolean z5) {
            if (this.f21884b != null) {
                stepos.support.v7.view.menu.d dVar = this.f21883a;
                if (dVar != null) {
                    int size = dVar.size();
                    for (int i5 = 0; i5 < size; i5++) {
                        if (this.f21883a.getItem(i5) == this.f21884b) {
                            return;
                        }
                    }
                }
                d(this.f21883a, this.f21884b);
            }
        }

        @Override // stepos.support.v7.view.menu.h
        public boolean c() {
            return false;
        }

        @Override // stepos.support.v7.view.menu.h
        public boolean d(stepos.support.v7.view.menu.d dVar, stepos.support.v7.view.menu.f fVar) {
            KeyEvent.Callback callback = Toolbar.this.f21862j;
            if (callback instanceof androidx.appcompat.view.c) {
                ((androidx.appcompat.view.c) callback).onActionViewCollapsed();
            }
            Toolbar toolbar = Toolbar.this;
            toolbar.removeView(toolbar.f21862j);
            Toolbar toolbar2 = Toolbar.this;
            toolbar2.removeView(toolbar2.f21861i);
            Toolbar toolbar3 = Toolbar.this;
            toolbar3.f21862j = null;
            toolbar3.f();
            this.f21884b = null;
            Toolbar.this.requestLayout();
            fVar.v(false);
            return true;
        }

        @Override // stepos.support.v7.view.menu.h
        public boolean e(stepos.support.v7.view.menu.j jVar) {
            return false;
        }

        @Override // stepos.support.v7.view.menu.h
        public void f(Context context, stepos.support.v7.view.menu.d dVar) {
            stepos.support.v7.view.menu.f fVar;
            stepos.support.v7.view.menu.d dVar2 = this.f21883a;
            if (dVar2 != null && (fVar = this.f21884b) != null) {
                dVar2.f(fVar);
            }
            this.f21883a = dVar;
        }

        @Override // stepos.support.v7.view.menu.h
        public boolean g(stepos.support.v7.view.menu.d dVar, stepos.support.v7.view.menu.f fVar) {
            Toolbar.this.m();
            ViewParent parent = Toolbar.this.f21861i.getParent();
            Toolbar toolbar = Toolbar.this;
            if (parent != toolbar) {
                toolbar.addView(toolbar.f21861i);
            }
            Toolbar.this.f21862j = fVar.getActionView();
            this.f21884b = fVar;
            ViewParent parent2 = Toolbar.this.f21862j.getParent();
            Toolbar toolbar2 = Toolbar.this;
            if (parent2 != toolbar2) {
                f fVarGenerateDefaultLayoutParams = toolbar2.generateDefaultLayoutParams();
                fVarGenerateDefaultLayoutParams.f20663a = (Toolbar.this.f21868p & 112) | 8388611;
                fVarGenerateDefaultLayoutParams.f21886b = 2;
                Toolbar.this.f21862j.setLayoutParams(fVarGenerateDefaultLayoutParams);
                Toolbar toolbar3 = Toolbar.this;
                toolbar3.addView(toolbar3.f21862j);
            }
            Toolbar.this.Q();
            Toolbar.this.requestLayout();
            fVar.v(true);
            KeyEvent.Callback callback = Toolbar.this.f21862j;
            if (callback instanceof androidx.appcompat.view.c) {
                ((androidx.appcompat.view.c) callback).onActionViewExpanded();
            }
            return true;
        }

        /* synthetic */ e(Toolbar toolbar, a aVar) {
            this();
        }
    }

    public interface g {
        boolean onMenuItemClick(MenuItem menuItem);
    }

    protected class i implements T {

        /* renamed from: a, reason: collision with root package name */
        private boolean f21889a = false;

        /* renamed from: b, reason: collision with root package name */
        int f21890b;

        protected i() {
        }

        public i a(S s5, int i5) {
            Toolbar.this.f21857f0 = s5;
            this.f21890b = i5;
            return this;
        }

        @Override // androidx.core.view.T
        public void c(View view) {
            this.f21889a = true;
        }

        @Override // androidx.core.view.T
        public void d(View view) {
            if (this.f21889a) {
                return;
            }
            Toolbar toolbar = Toolbar.this;
            toolbar.f21857f0 = null;
            if (toolbar.f21846a != null) {
                Toolbar.this.f21846a.setVisibility(this.f21890b);
            }
        }

        @Override // androidx.core.view.T
        public void e(View view) {
            if (Toolbar.this.f21846a != null) {
                Toolbar.this.f21846a.setVisibility(0);
            }
            this.f21889a = false;
        }
    }

    public Toolbar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, N1.a.c() ? X4.a.f5823A : C0728a.f16823T);
    }

    private boolean C(ViewGroup viewGroup) {
        int childCount = viewGroup.getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = viewGroup.getChildAt(i5);
            if (childAt instanceof Button) {
                return true;
            }
            if ((childAt instanceof ViewGroup) && C((ViewGroup) childAt)) {
                return true;
            }
        }
        return false;
    }

    private boolean D(View view) {
        return view.getParent() == this || this.f21832G.contains(view);
    }

    private int H(View view, int i5, int[] iArr, int i6) {
        f fVar = (f) view.getLayoutParams();
        int i7 = ((ViewGroup.MarginLayoutParams) fVar).leftMargin - iArr[0];
        int iMax = i5 + Math.max(0, i7);
        iArr[0] = Math.max(0, -i7);
        int iV = v(view, i6);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(iMax, iV, iMax + measuredWidth, view.getMeasuredHeight() + iV);
        return iMax + measuredWidth + ((ViewGroup.MarginLayoutParams) fVar).rightMargin;
    }

    private int I(View view, int i5, int[] iArr, int i6) {
        f fVar = (f) view.getLayoutParams();
        int i7 = ((ViewGroup.MarginLayoutParams) fVar).rightMargin - iArr[1];
        int iMax = i5 - Math.max(0, i7);
        iArr[1] = Math.max(0, -i7);
        int iV = v(view, i6);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(iMax - measuredWidth, iV, iMax, view.getMeasuredHeight() + iV);
        return iMax - (measuredWidth + ((ViewGroup.MarginLayoutParams) fVar).leftMargin);
    }

    private int J(View view, int i5, int i6, int i7, int i8, int[] iArr) {
        return K(view, i5, i6, i7, i8, iArr, false);
    }

    private int K(View view, int i5, int i6, int i7, int i8, int[] iArr, boolean z5) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int i9 = marginLayoutParams.leftMargin - iArr[0];
        int i10 = marginLayoutParams.rightMargin - iArr[1];
        int iMax = Math.max(0, i9) + Math.max(0, i10);
        iArr[0] = Math.max(0, -i9);
        iArr[1] = Math.max(0, -i10);
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i5, getPaddingLeft() + getPaddingRight() + iMax + i6, marginLayoutParams.width);
        int childMeasureSpec2 = ViewGroup.getChildMeasureSpec(i7, getPaddingTop() + getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i8, marginLayoutParams.height);
        if (z5 && view.getMinimumWidth() > View.MeasureSpec.getSize(childMeasureSpec)) {
            childMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.getMode(childMeasureSpec));
        }
        view.measure(childMeasureSpec, childMeasureSpec2);
        return view.getMeasuredWidth() + iMax;
    }

    private void L(View view, int i5, int i6, int i7, int i8, int i9) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i5, getPaddingLeft() + getPaddingRight() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i6, marginLayoutParams.width);
        int childMeasureSpec2 = ViewGroup.getChildMeasureSpec(i7, getPaddingTop() + getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i8, marginLayoutParams.height);
        int mode = View.MeasureSpec.getMode(childMeasureSpec2);
        if (mode != 1073741824 && i9 >= 0) {
            if (mode != 0) {
                i9 = Math.min(View.MeasureSpec.getSize(childMeasureSpec2), i9);
            }
            childMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i9, 1073741824);
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
    private void M(boolean r21, int r22, int r23, int r24, int r25) {
        /*
            Method dump skipped, instructions count: 842
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: stepos.support.v7.widget.Toolbar.M(boolean, int, int, int, int):void");
    }

    private void N(int i5, int i6) {
        int iX;
        int iMax;
        int iH;
        int i7;
        int[] iArr;
        int iMax2;
        int iH2;
        int measuredHeight;
        int[] iArr2 = this.f21833H;
        boolean zM = C.m(this);
        int i8 = !zM ? 1 : 0;
        int i9 = this.f21871s;
        if (Z(this.f21854e)) {
            L(this.f21854e, i5, 0, i6, 0, this.f21869q);
            int measuredWidth = this.f21854e.getMeasuredWidth() + x(this.f21854e);
            iMax = Math.max(0, this.f21854e.getMeasuredHeight() + y(this.f21854e));
            iH = C.h(0, H.y(this.f21854e));
            iX = measuredWidth;
            i9 = this.f21872t;
        } else {
            iX = 0;
            iMax = 0;
            iH = 0;
        }
        this.f21870r = i9;
        if (Z(this.f21861i)) {
            L(this.f21861i, i5, 0, i6, 0, this.f21869q);
            iX = x(this.f21861i) + this.f21861i.getMeasuredWidth();
            iMax = Math.max(iMax, this.f21861i.getMeasuredHeight() + y(this.f21861i));
            iH = C.h(iH, H.y(this.f21861i));
        }
        int contentInsetStart = getContentInsetStart();
        int iMax3 = Math.max(contentInsetStart, iX);
        iArr2[zM ? 1 : 0] = Math.max(0, contentInsetStart - iX);
        if (Z(this.f21846a)) {
            L(this.f21846a, i5, iMax3, i6, 0, this.f21869q);
            int measuredWidth2 = this.f21846a.getMeasuredWidth() + x(this.f21846a);
            iMax = Math.max(iMax, this.f21846a.getMeasuredHeight() + y(this.f21846a));
            iH = C.h(iH, H.y(this.f21846a));
            i7 = measuredWidth2;
        } else {
            i7 = 0;
        }
        int contentInsetEnd = getContentInsetEnd();
        int iMax4 = iMax3 + Math.max(contentInsetEnd, i7);
        iArr2[i8] = Math.max(0, contentInsetEnd - i7);
        if (Z(this.f21862j)) {
            iArr = iArr2;
            iMax4 += J(this.f21862j, i5, iMax4, i6, 0, iArr);
            iMax = Math.max(iMax, this.f21862j.getMeasuredHeight() + y(this.f21862j));
            iH = C.h(iH, H.y(this.f21862j));
        } else {
            iArr = iArr2;
        }
        if (Z(this.f21856f)) {
            iMax4 += J(this.f21856f, i5, iMax4, i6, 0, iArr);
            iMax = Math.max(iMax, this.f21856f.getMeasuredHeight() + y(this.f21856f));
            iH = C.h(iH, H.y(this.f21856f));
        }
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            if (((f) childAt.getLayoutParams()).f21886b == 0 && Z(childAt)) {
                iMax4 += J(childAt, i5, iMax4, i6, 0, iArr);
                int iMax5 = Math.max(iMax, childAt.getMeasuredHeight() + y(childAt));
                iH = C.h(iH, H.y(childAt));
                iMax = iMax5;
            } else {
                iMax4 = iMax4;
            }
        }
        int i11 = iMax4;
        int i12 = this.f21874v + this.f21875w;
        int i13 = this.f21870r + this.f21873u;
        int i14 = (this.f21877y & 7) != 1 ? i11 : i7 * 2;
        if (Z(this.f21848b)) {
            K(this.f21848b, i5, i14 + i13, i6, i12, iArr, true);
            int measuredWidth3 = this.f21848b.getMeasuredWidth() + x(this.f21848b);
            int measuredHeight2 = this.f21848b.getMeasuredHeight() + y(this.f21848b);
            iMax2 = measuredWidth3;
            iH2 = C.h(iH, H.y(this.f21848b));
            measuredHeight = measuredHeight2;
        } else {
            iMax2 = 0;
            iH2 = iH;
            measuredHeight = 0;
        }
        if (Z(this.f21852d)) {
            iMax2 = Math.max(iMax2, J(this.f21852d, i5, i14 + i13, i6, i12 + measuredHeight, iArr));
            measuredHeight += this.f21852d.getMeasuredHeight() + y(this.f21852d);
            iH2 = C.h(iH2, H.y(this.f21852d));
        }
        setMeasuredDimension(H.h0(Math.max(i11 + iMax2 + getPaddingLeft() + getPaddingRight(), getSuggestedMinimumWidth()), i5, (-16777216) & iH2), Y() ? 0 : H.h0(Math.max(Math.max(iMax, measuredHeight) + getPaddingTop() + getPaddingBottom(), getSuggestedMinimumHeight()), i6, iH2 << 16));
    }

    private void O() {
        removeCallbacks(this.f21842T);
        post(this.f21842T);
    }

    private boolean Y() {
        if (!this.f21841S) {
            return false;
        }
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (Z(childAt) && childAt.getMeasuredWidth() > 0 && childAt.getMeasuredHeight() > 0) {
                return false;
            }
        }
        return true;
    }

    private boolean Z(View view) {
        return (view == null || view.getParent() != this || view.getVisibility() == 8) ? false : true;
    }

    private void g(List<View> list, int i5) {
        boolean z5 = H.x(this) == 1;
        int childCount = getChildCount();
        int iB = C0464i.b(i5, H.x(this));
        list.clear();
        if (!z5) {
            for (int i6 = 0; i6 < childCount; i6++) {
                View childAt = getChildAt(i6);
                f fVar = (f) childAt.getLayoutParams();
                if (fVar.f21886b == 0 && Z(childAt) && u(fVar.f20663a) == iB) {
                    list.add(childAt);
                }
            }
            return;
        }
        for (int i7 = childCount - 1; i7 >= 0; i7--) {
            View childAt2 = getChildAt(i7);
            f fVar2 = (f) childAt2.getLayoutParams();
            if (fVar2.f21886b == 0 && Z(childAt2) && u(fVar2.f20663a) == iB) {
                list.add(childAt2);
            }
        }
    }

    private MenuInflater getMenuInflater() {
        return new b5.k(getContext());
    }

    private void h(View view, boolean z5) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        f fVarGenerateDefaultLayoutParams = layoutParams == null ? generateDefaultLayoutParams() : !checkLayoutParams(layoutParams) ? generateLayoutParams(layoutParams) : (f) layoutParams;
        fVarGenerateDefaultLayoutParams.f21886b = 1;
        if (!z5 || this.f21862j == null) {
            addView(view, fVarGenerateDefaultLayoutParams);
        } else {
            view.setLayoutParams(fVarGenerateDefaultLayoutParams);
            this.f21832G.add(view);
        }
    }

    private void l() {
        if (this.f21844V == null) {
            ActionMenuView actionMenuView = new ActionMenuView(getContext());
            this.f21844V = actionMenuView;
            actionMenuView.setPopupTheme(this.f21864l);
            this.f21844V.setOnMenuItemClickListener(this.f21835J);
            f fVarGenerateDefaultLayoutParams = generateDefaultLayoutParams();
            fVarGenerateDefaultLayoutParams.f20663a = (this.f21868p & 112) | 8388613;
            this.f21844V.setLayoutParams(fVarGenerateDefaultLayoutParams);
            this.f21844V.setId(X4.f.f5968P);
            ViewGroup viewGroup = this.f21849b0;
            if (viewGroup != null) {
                ((ViewGroup.MarginLayoutParams) fVarGenerateDefaultLayoutParams).width = -1;
                viewGroup.addView(this.f21844V, 0, fVarGenerateDefaultLayoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        if (this.f21861i == null) {
            ImageButton imageButton = new ImageButton(getContext(), null, C0728a.f16822S);
            this.f21861i = imageButton;
            imageButton.setImageDrawable(this.f21858g);
            this.f21861i.setContentDescription(this.f21860h);
            f fVarGenerateDefaultLayoutParams = generateDefaultLayoutParams();
            fVarGenerateDefaultLayoutParams.f20663a = (this.f21868p & 112) | 8388611;
            fVarGenerateDefaultLayoutParams.f21886b = 2;
            this.f21861i.setLayoutParams(fVarGenerateDefaultLayoutParams);
            this.f21861i.setOnClickListener(new d());
        }
    }

    private void n() {
        if (this.f21856f == null) {
            this.f21856f = new ImageView(getContext());
        }
    }

    private void o() {
        p();
        if (this.f21846a.T() == null) {
            stepos.support.v7.view.menu.d dVar = (stepos.support.v7.view.menu.d) this.f21846a.getMenu();
            if (this.f21838M == null) {
                this.f21838M = new e(this, null);
            }
            this.f21846a.setExpandedActionViewsExclusive(true);
            dVar.c(this.f21838M, this.f21863k);
        }
    }

    private void p() {
        if (this.f21846a == null) {
            ActionMenuView actionMenuView = new ActionMenuView(getContext());
            this.f21846a = actionMenuView;
            actionMenuView.setPopupTheme(this.f21864l);
            this.f21846a.setOnMenuItemClickListener(this.f21835J);
            this.f21846a.U(this.f21839Q, this.f21840R);
            f fVarGenerateDefaultLayoutParams = generateDefaultLayoutParams();
            fVarGenerateDefaultLayoutParams.f20663a = (this.f21868p & 112) | 8388613;
            this.f21846a.setLayoutParams(fVarGenerateDefaultLayoutParams);
            this.f21846a.setId(X4.f.f5969Q);
            if (!this.f21851c0) {
                h(this.f21846a, false);
            } else {
                ((ViewGroup.MarginLayoutParams) fVarGenerateDefaultLayoutParams).width = -1;
                this.f21849b0.addView(this.f21846a, 0, fVarGenerateDefaultLayoutParams);
            }
        }
    }

    private void q() {
        if (this.f21854e == null) {
            ImageButton imageButton = new ImageButton(getContext(), null, C0728a.f16822S);
            this.f21854e = imageButton;
            this.f21847a0.f(imageButton, false, I1.f.f2929e | I1.f.f2931g);
            f fVarGenerateDefaultLayoutParams = generateDefaultLayoutParams();
            fVarGenerateDefaultLayoutParams.f20663a = (this.f21868p & 112) | 8388611;
            this.f21854e.setLayoutParams(fVarGenerateDefaultLayoutParams);
            this.f21854e.setImageDrawable(androidx.core.content.res.h.f(getResources(), H1.g.f2182R, null));
            this.f21854e.setLayoutDirection(3);
            this.f21854e.setId(X4.f.f6004m0);
            this.f21854e.addOnLayoutChangeListener(new c());
        }
    }

    private int u(int i5) {
        int iX = H.x(this);
        int iB = C0464i.b(i5, iX) & 7;
        return (iB == 1 || iB == 3 || iB == 5) ? iB : iX == 1 ? 5 : 3;
    }

    private int v(View view, int i5) {
        f fVar = (f) view.getLayoutParams();
        int measuredHeight = view.getMeasuredHeight();
        int i6 = i5 > 0 ? (measuredHeight - i5) / 2 : 0;
        int iW = w(fVar.f20663a);
        if (iW == 48) {
            return getPaddingTop() - i6;
        }
        if (iW == 80) {
            return (((getHeight() - getPaddingBottom()) - measuredHeight) - ((ViewGroup.MarginLayoutParams) fVar).bottomMargin) - i6;
        }
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int height = getHeight();
        int iMax = (((height - paddingTop) - paddingBottom) - measuredHeight) / 2;
        int i7 = ((ViewGroup.MarginLayoutParams) fVar).topMargin;
        if (iMax < i7) {
            iMax = i7;
        } else {
            int i8 = (((height - paddingBottom) - measuredHeight) - iMax) - paddingTop;
            int i9 = ((ViewGroup.MarginLayoutParams) fVar).bottomMargin;
            if (i8 < i9) {
                iMax = Math.max(0, iMax - (i9 - i8));
            }
        }
        return paddingTop + iMax;
    }

    private int w(int i5) {
        int i6 = i5 & 112;
        return (i6 == 16 || i6 == 48 || i6 == 80) ? i6 : this.f21877y & 112;
    }

    private int x(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return C0467l.b(marginLayoutParams) + C0467l.a(marginLayoutParams);
    }

    private int y(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
    }

    private int z(List<View> list, int[] iArr) {
        int i5 = iArr[0];
        int i6 = iArr[1];
        int size = list.size();
        int i7 = 0;
        int measuredWidth = 0;
        while (i7 < size) {
            View view = list.get(i7);
            f fVar = (f) view.getLayoutParams();
            int i8 = ((ViewGroup.MarginLayoutParams) fVar).leftMargin - i5;
            int i9 = ((ViewGroup.MarginLayoutParams) fVar).rightMargin - i6;
            int iMax = Math.max(0, i8);
            int iMax2 = Math.max(0, i9);
            int iMax3 = Math.max(0, -i8);
            int iMax4 = Math.max(0, -i9);
            measuredWidth += iMax + view.getMeasuredWidth() + iMax2;
            i7++;
            i6 = iMax4;
            i5 = iMax3;
        }
        return measuredWidth;
    }

    public boolean A() {
        e eVar = this.f21838M;
        return (eVar == null || eVar.f21884b == null) ? false : true;
    }

    public boolean B() {
        ActionMenuView actionMenuView = this.f21846a;
        return actionMenuView != null && actionMenuView.K();
    }

    public boolean E() {
        ActionMenuView actionMenuView = this.f21846a;
        return actionMenuView != null && actionMenuView.L();
    }

    public boolean F() {
        ActionMenuView actionMenuView = this.f21846a;
        return actionMenuView != null && actionMenuView.M();
    }

    public boolean G() {
        return this.f21845W;
    }

    public void P(ViewGroup viewGroup) {
        ViewGroup viewGroup2 = this.f21849b0;
        if (viewGroup2 == null || viewGroup == null || !C(viewGroup2)) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = this.f21849b0.getLayoutParams();
        layoutParams.height = ((int) N1.i.a(80.0f, getContext())) + viewGroup.getPaddingBottom();
        this.f21849b0.setLayoutParams(layoutParams);
    }

    void Q() {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            if (((f) childAt.getLayoutParams()).f21886b != 2 && childAt != this.f21846a) {
                removeViewAt(childCount);
                this.f21832G.add(childAt);
            }
        }
    }

    public void R(stepos.support.v7.view.menu.d dVar, stepos.support.v7.widget.d dVar2) {
        l();
        stepos.support.v7.view.menu.d dVarT = this.f21844V.T();
        if (dVarT == dVar) {
            return;
        }
        if (dVarT != null) {
            dVarT.N(this.f21837L);
        }
        dVar2.S(true);
        if (dVar != null) {
            dVar.c(dVar2, this.f21863k);
        }
        this.f21844V.setPopupTheme(this.f21864l);
        this.f21844V.setPresenter(dVar2);
    }

    public void S(int i5, int i6) {
        this.f21876x.g(i5, i6);
    }

    public void T(stepos.support.v7.view.menu.d dVar, stepos.support.v7.widget.d dVar2) {
        if (dVar == null && this.f21846a == null) {
            return;
        }
        p();
        stepos.support.v7.view.menu.d dVarT = this.f21846a.T();
        if (dVarT == dVar) {
            return;
        }
        if (dVarT != null) {
            dVarT.N(this.f21837L);
            dVarT.N(this.f21838M);
        }
        a aVar = null;
        if (this.f21838M == null) {
            this.f21838M = new e(this, aVar);
        }
        dVar2.S(true);
        if (dVar != null) {
            dVar.c(dVar2, this.f21863k);
            dVar.c(this.f21838M, this.f21863k);
        } else {
            dVar2.f(this.f21863k, null);
            this.f21838M.f(this.f21863k, null);
            dVar2.b(true);
            this.f21838M.b(true);
        }
        this.f21846a.setPopupTheme(this.f21864l);
        this.f21846a.setPresenter(dVar2);
        this.f21837L = dVar2;
    }

    public void U(h.a aVar, d.a aVar2) {
        this.f21839Q = aVar;
        this.f21840R = aVar2;
        ActionMenuView actionMenuView = this.f21846a;
        if (actionMenuView != null) {
            actionMenuView.U(aVar, aVar2);
        }
    }

    public void V(int i5, long j5) {
        if ((!this.f21851c0 || this.f21846a == null) && this.f21844V == null && this.f21855e0 != null) {
            return;
        }
        View view = this.f21855e0;
        if (view == null && (view = this.f21844V) == null) {
            view = this.f21846a;
        }
        if (i5 != 0) {
            S sB = H.d(view).b(0.0f);
            sB.h(j5);
            sB.j(this.f21859g0.a(sB, i5));
            sB.n();
            return;
        }
        H.n0(view, 0.0f);
        S sB2 = H.d(view).b(1.0f);
        sB2.h(j5);
        sB2.j(this.f21859g0.a(sB2, i5));
        sB2.n();
    }

    public void W(Context context, int i5) {
        this.f21867o = i5;
        TextView textView = this.f21852d;
        if (textView != null) {
            textView.setTextAppearance(context, i5);
        }
    }

    public void X(Context context, int i5) {
        this.f21865m = i5;
        TextView textView = this.f21850c;
        if (textView != null) {
            textView.setTextAppearance(context, i5);
        }
    }

    public boolean a0() {
        ActionMenuView actionMenuView = this.f21846a;
        return actionMenuView != null && actionMenuView.V();
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return super.checkLayoutParams(layoutParams) && (layoutParams instanceof f);
    }

    void f() {
        for (int size = this.f21832G.size() - 1; size >= 0; size--) {
            addView(this.f21832G.get(size));
        }
        this.f21832G.clear();
    }

    public int getContentInsetEnd() {
        return this.f21876x.a();
    }

    public int getContentInsetLeft() {
        return this.f21876x.b();
    }

    public int getContentInsetRight() {
        return this.f21876x.c();
    }

    public int getContentInsetStart() {
        return this.f21876x.d();
    }

    public Drawable getLogo() {
        ImageView imageView = this.f21856f;
        if (imageView != null) {
            return imageView.getDrawable();
        }
        return null;
    }

    public CharSequence getLogoDescription() {
        ImageView imageView = this.f21856f;
        if (imageView != null) {
            return imageView.getContentDescription();
        }
        return null;
    }

    public Menu getMenu() {
        o();
        return this.f21846a.getMenu();
    }

    public CharSequence getNavigationContentDescription() {
        ImageButton imageButton = this.f21854e;
        if (imageButton != null) {
            return imageButton.getContentDescription();
        }
        return null;
    }

    public Drawable getNavigationIcon() {
        ImageButton imageButton = this.f21854e;
        if (imageButton != null) {
            return imageButton.getDrawable();
        }
        return null;
    }

    public Drawable getOverflowIcon() {
        o();
        return this.f21846a.getOverflowIcon();
    }

    public int getPopupTheme() {
        return this.f21864l;
    }

    public View getSplitBarCustomView() {
        return this.f21855e0;
    }

    public CharSequence getSubtitle() {
        return this.f21826A;
    }

    public CharSequence getTitle() {
        return this.f21878z;
    }

    public int getTitleMarginBottom() {
        return this.f21875w;
    }

    public int getTitleMarginEnd() {
        return this.f21873u;
    }

    public int getTitleMarginStart() {
        return this.f21870r;
    }

    public int getTitleMarginTop() {
        return this.f21874v;
    }

    public m getWrapper() {
        if (this.f21836K == null) {
            this.f21836K = new A(this, true);
        }
        return this.f21836K;
    }

    public boolean i() {
        ActionMenuView actionMenuView;
        return getVisibility() == 0 && (actionMenuView = this.f21846a) != null && actionMenuView.N();
    }

    public void j() {
        e eVar = this.f21838M;
        stepos.support.v7.view.menu.f fVar = eVar == null ? null : eVar.f21884b;
        if (fVar != null) {
            fVar.collapseActionView();
        }
    }

    public void k() {
        ActionMenuView actionMenuView = this.f21846a;
        if (actionMenuView != null) {
            actionMenuView.E();
        }
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        if (this.f21853d0) {
            setSplitToolbar(getContext().getResources().getBoolean(X4.b.f5854d));
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.f21842T);
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        int iC = C0473s.c(motionEvent);
        if (iC == 9) {
            this.f21830E = false;
        }
        if (!this.f21830E) {
            boolean zOnHoverEvent = super.onHoverEvent(motionEvent);
            if (iC == 9 && !zOnHoverEvent) {
                this.f21830E = true;
            }
        }
        if (iC == 10 || iC == 3) {
            this.f21830E = false;
        }
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z5, int i5, int i6, int i7, int i8) {
        M(z5, i5, i6, i7, i8);
    }

    @Override // android.view.View
    protected void onMeasure(int i5, int i6) {
        N(i5, i6);
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        MenuItem menuItemFindItem;
        if (!(parcelable instanceof h)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        h hVar = (h) parcelable;
        super.onRestoreInstanceState(hVar.getSuperState());
        ActionMenuView actionMenuView = this.f21846a;
        stepos.support.v7.view.menu.d dVarT = actionMenuView != null ? actionMenuView.T() : null;
        int i5 = hVar.f21887a;
        if (i5 != 0 && this.f21838M != null && dVarT != null && (menuItemFindItem = dVarT.findItem(i5)) != null) {
            C0472q.a(menuItemFindItem);
        }
        if (hVar.f21888b) {
            O();
        }
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i5) {
        super.onRtlPropertiesChanged(i5);
        u uVar = this.f21876x;
        if (uVar != null) {
            uVar.f(i5 == 1);
        }
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        stepos.support.v7.view.menu.f fVar;
        h hVar = new h(super.onSaveInstanceState());
        e eVar = this.f21838M;
        if (eVar != null && (fVar = eVar.f21884b) != null) {
            hVar.f21887a = fVar.getItemId();
        }
        hVar.f21888b = F();
        return hVar;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int iC = C0473s.c(motionEvent);
        if (iC == 0) {
            this.f21829D = false;
        }
        if (!this.f21829D) {
            boolean zOnTouchEvent = super.onTouchEvent(motionEvent);
            if (iC == 0 && !zOnTouchEvent) {
                this.f21829D = true;
            }
        }
        if (iC == 1 || iC == 3) {
            this.f21829D = false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
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

    public void setCollapsible(boolean z5) {
        this.f21841S = z5;
        requestLayout();
    }

    public void setLogo(int i5) {
        setLogo(this.f21843U.c(getContext(), i5));
    }

    public void setLogoDescription(int i5) {
        setLogoDescription(getContext().getText(i5));
    }

    public void setMenuVisibility(int i5) {
        ActionMenuView actionMenuView = this.f21846a;
        if (actionMenuView == null || !this.f21851c0) {
            return;
        }
        actionMenuView.setVisibility(i5);
    }

    public void setNavigationContentDescription(int i5) {
        setNavigationContentDescription(i5 != 0 ? getContext().getText(i5) : null);
    }

    public void setNavigationIcon(int i5) {
        setNavigationIcon(this.f21843U.c(getContext(), i5));
    }

    public void setNavigationOnClickListener(View.OnClickListener onClickListener) {
        q();
        this.f21854e.setOnClickListener(onClickListener);
    }

    public void setOnMenuItemClickListener(g gVar) {
        this.f21834I = gVar;
    }

    public void setOverflowIcon(Drawable drawable) {
        o();
        this.f21846a.setOverflowIcon(drawable);
    }

    public void setPopupTheme(int i5) {
        if (this.f21864l != i5) {
            this.f21864l = i5;
            if (i5 == 0) {
                this.f21863k = getContext();
            } else {
                this.f21863k = new ContextThemeWrapper(getContext(), i5);
            }
        }
    }

    public void setShowBottomMenu(boolean z5) {
        if (this.f21845W != z5) {
            this.f21845W = z5;
            ActionMenuView actionMenuView = this.f21844V;
            if (actionMenuView != null) {
                ViewGroup viewGroup = (ViewGroup) actionMenuView.getParent();
                if (viewGroup != null) {
                    viewGroup.removeView(this.f21844V);
                }
                if (this.f21845W) {
                    ViewGroup viewGroup2 = this.f21849b0;
                    if (viewGroup2 != null) {
                        viewGroup2.addView(this.f21844V);
                    }
                    this.f21844V.getLayoutParams().width = -1;
                }
                this.f21844V.requestLayout();
            }
        }
    }

    public void setSplitCustomView(View view) {
        FrameLayout.LayoutParams layoutParams;
        if (this.f21849b0 == null) {
            return;
        }
        View view2 = this.f21855e0;
        if (view2 != null) {
            ((ViewGroup) view2.getParent()).removeView(this.f21855e0);
        }
        if (view != null && view.getParent() != null) {
            ((ViewGroup) view.getParent()).removeView(view);
        }
        this.f21855e0 = view;
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
            this.f21849b0.addView(view, layoutParams);
        }
    }

    public void setSplitToolbar(boolean z5) {
        if (this.f21851c0 != z5) {
            this.f21851c0 = z5;
            ActionMenuView actionMenuView = this.f21846a;
            if (actionMenuView != null) {
                ViewGroup viewGroup = (ViewGroup) actionMenuView.getParent();
                if (viewGroup != null) {
                    viewGroup.removeView(this.f21846a);
                }
                if (z5) {
                    ViewGroup viewGroup2 = this.f21849b0;
                    if (viewGroup2 != null) {
                        viewGroup2.addView(this.f21846a);
                    }
                    this.f21846a.getLayoutParams().width = -1;
                } else {
                    h(this.f21846a, false);
                    this.f21846a.getLayoutParams().width = -2;
                }
                this.f21846a.requestLayout();
            }
        }
    }

    public void setSplitView(ViewGroup viewGroup) {
        this.f21849b0 = viewGroup;
    }

    public void setSubtitle(int i5) {
        setSubtitle(getContext().getText(i5));
    }

    public void setSubtitleTextColor(int i5) {
        this.f21828C = i5;
        TextView textView = this.f21852d;
        if (textView != null) {
            textView.setTextColor(i5);
        }
    }

    public void setTitle(int i5) {
        setTitle(getContext().getText(i5));
    }

    public void setTitleTextColor(int i5) {
        this.f21827B = i5;
        TextView textView = this.f21850c;
        if (textView != null) {
            textView.setTextColor(i5);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* renamed from: t, reason: merged with bridge method [inline-methods] */
    public f generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof f ? new f((f) layoutParams) : layoutParams instanceof a.e ? new f((a.e) layoutParams) : layoutParams instanceof ViewGroup.MarginLayoutParams ? new f((ViewGroup.MarginLayoutParams) layoutParams) : new f(layoutParams);
    }

    public static class f extends a.e {

        /* renamed from: b, reason: collision with root package name */
        int f21886b;

        public f(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f21886b = 0;
        }

        void a(ViewGroup.MarginLayoutParams marginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this).leftMargin = marginLayoutParams.leftMargin;
            ((ViewGroup.MarginLayoutParams) this).topMargin = marginLayoutParams.topMargin;
            ((ViewGroup.MarginLayoutParams) this).rightMargin = marginLayoutParams.rightMargin;
            ((ViewGroup.MarginLayoutParams) this).bottomMargin = marginLayoutParams.bottomMargin;
        }

        public f(int i5, int i6) {
            super(i5, i6);
            this.f21886b = 0;
            this.f20663a = 8388627;
        }

        public f(int i5, int i6, int i7) {
            super(i5, i6);
            this.f21886b = 0;
            this.f20663a = i7;
        }

        public f(f fVar) {
            super((a.e) fVar);
            this.f21886b = 0;
            this.f21886b = fVar.f21886b;
        }

        public f(a.e eVar) {
            super(eVar);
            this.f21886b = 0;
        }

        public f(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f21886b = 0;
            a(marginLayoutParams);
        }

        public f(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f21886b = 0;
        }
    }

    public Toolbar(Context context, AttributeSet attributeSet, int i5) {
        super(context, attributeSet, i5);
        u uVar = new u();
        this.f21876x = uVar;
        this.f21877y = 8388627;
        this.f21831F = new ArrayList<>();
        this.f21832G = new ArrayList<>();
        this.f21833H = new int[2];
        this.f21835J = new a();
        this.f21842T = new b();
        this.f21847a0 = new I1.f();
        this.f21859g0 = new i();
        a0 a0VarV = a0.v(getContext(), attributeSet, g.j.f17069T2, i5, 0);
        this.f21865m = a0VarV.n(g.j.f17203v3, 0);
        this.f21866n = a0VarV.n(X4.l.f6214W4, 0);
        this.f21867o = a0VarV.n(g.j.f17158m3, 0);
        this.f21877y = a0VarV.l(g.j.f17073U2, this.f21877y);
        this.f21868p = a0VarV.l(X4.l.f6202U4, 48);
        int iE = a0VarV.e(g.j.f17198u3, 0);
        this.f21875w = iE;
        this.f21874v = iE;
        this.f21873u = iE;
        this.f21871s = iE;
        int iE2 = a0VarV.e(g.j.f17188s3, -1);
        if (iE2 >= 0) {
            this.f21871s = iE2;
        }
        int iE3 = a0VarV.e(g.j.f17183r3, -1);
        if (iE3 >= 0) {
            this.f21873u = iE3;
        }
        int iE4 = a0VarV.e(g.j.f17193t3, -1);
        if (iE4 >= 0) {
            this.f21874v = iE4;
        }
        int iE5 = a0VarV.e(g.j.f17178q3, -1);
        if (iE5 >= 0) {
            this.f21875w = iE5;
        }
        this.f21869q = a0VarV.f(g.j.f17128g3, -1);
        int iE6 = a0VarV.e(g.j.f17108c3, Integer.MIN_VALUE);
        int iE7 = a0VarV.e(g.j.f17089Y2, Integer.MIN_VALUE);
        uVar.e(a0VarV.f(g.j.f17098a3, 0), a0VarV.f(g.j.f17103b3, 0));
        if (iE6 != Integer.MIN_VALUE || iE7 != Integer.MIN_VALUE) {
            uVar.g(iE6, iE7);
        }
        this.f21858g = a0VarV.g(g.j.f17085X2);
        this.f21860h = a0VarV.p(g.j.f17081W2);
        CharSequence charSequenceP = a0VarV.p(g.j.f17168o3);
        if (!TextUtils.isEmpty(charSequenceP)) {
            setTitle(charSequenceP);
        }
        CharSequence charSequenceP2 = a0VarV.p(g.j.f17153l3);
        if (!TextUtils.isEmpty(charSequenceP2)) {
            setSubtitle(charSequenceP2);
        }
        this.f21863k = getContext();
        setPopupTheme(a0VarV.n(g.j.f17148k3, 0));
        Drawable drawableG = a0VarV.g(g.j.f17143j3);
        if (drawableG != null) {
            setNavigationIcon(drawableG);
        }
        CharSequence charSequenceP3 = a0VarV.p(g.j.f17138i3);
        if (!TextUtils.isEmpty(charSequenceP3)) {
            setNavigationContentDescription(charSequenceP3);
        }
        Drawable drawableG2 = a0VarV.g(g.j.f17118e3);
        if (drawableG2 != null) {
            setLogo(drawableG2);
        }
        CharSequence charSequenceP4 = a0VarV.p(g.j.f17123f3);
        if (!TextUtils.isEmpty(charSequenceP4)) {
            setLogoDescription(charSequenceP4);
        }
        int i6 = g.j.f17208w3;
        if (a0VarV.s(i6)) {
            setTitleTextColor(a0VarV.b(i6, -1));
        }
        int i7 = g.j.f17163n3;
        if (a0VarV.s(i7)) {
            setSubtitleTextColor(a0VarV.b(i7, -1));
        }
        this.f21872t = a0VarV.f(X4.l.f6208V4, this.f21870r);
        this.f21870r = this.f21871s;
        a0VarV.x();
        this.f21843U = C0441k.b();
    }

    public void setLogo(Drawable drawable) {
        if (drawable != null) {
            n();
            if (!D(this.f21856f)) {
                h(this.f21856f, true);
            }
        } else {
            ImageView imageView = this.f21856f;
            if (imageView != null && D(imageView)) {
                removeView(this.f21856f);
                this.f21832G.remove(this.f21856f);
            }
        }
        ImageView imageView2 = this.f21856f;
        if (imageView2 != null) {
            imageView2.setImageDrawable(drawable);
        }
    }

    public void setLogoDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            n();
        }
        ImageView imageView = this.f21856f;
        if (imageView != null) {
            imageView.setContentDescription(charSequence);
        }
    }

    public void setNavigationContentDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            q();
        }
        ImageButton imageButton = this.f21854e;
        if (imageButton != null) {
            imageButton.setContentDescription(charSequence);
        }
    }

    public void setNavigationIcon(Drawable drawable) {
        TextView textView;
        TextView textView2;
        if (drawable != null) {
            q();
            if (!D(this.f21854e)) {
                h(this.f21854e, true);
            }
            if (this.f21866n != 0 && (textView2 = this.f21850c) != null) {
                textView2.setTextAppearance(getContext(), this.f21866n);
            }
        } else {
            ImageButton imageButton = this.f21854e;
            if (imageButton != null && D(imageButton)) {
                removeView(this.f21854e);
                this.f21832G.remove(this.f21854e);
                setTouchDelegate(null);
                if (this.f21865m != 0 && (textView = this.f21850c) != null) {
                    textView.setTextAppearance(getContext(), this.f21865m);
                }
            }
        }
        ImageButton imageButton2 = this.f21854e;
        if (imageButton2 != null) {
            imageButton2.setImageDrawable(drawable);
        }
    }

    public void setSubtitle(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            TextView textView = this.f21852d;
            if (textView != null && D(textView)) {
                removeView(this.f21852d);
                this.f21832G.remove(this.f21852d);
            }
        } else {
            if (this.f21852d == null) {
                Context context = getContext();
                TextView textView2 = new TextView(context);
                this.f21852d = textView2;
                textView2.setSingleLine();
                this.f21852d.setEllipsize(TextUtils.TruncateAt.END);
                int i5 = this.f21867o;
                if (i5 != 0) {
                    this.f21852d.setTextAppearance(context, i5);
                }
                int i6 = this.f21828C;
                if (i6 != 0) {
                    this.f21852d.setTextColor(i6);
                }
            }
            if (!D(this.f21852d)) {
                h(this.f21852d, true);
            }
        }
        TextView textView3 = this.f21852d;
        if (textView3 != null) {
            textView3.setText(charSequence);
        }
        this.f21826A = charSequence;
    }

    public void setTitle(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            HorizontalScrollView horizontalScrollView = this.f21848b;
            if (horizontalScrollView != null && D(horizontalScrollView)) {
                removeView(this.f21848b);
                this.f21832G.remove(this.f21848b);
            }
        } else {
            if (this.f21848b == null) {
                HorizontalScrollView horizontalScrollView2 = new HorizontalScrollView(getContext());
                this.f21848b = horizontalScrollView2;
                horizontalScrollView2.setHorizontalFadingEdgeEnabled(true);
                this.f21848b.setOverScrollMode(2);
                this.f21848b.setHorizontalScrollBarEnabled(false);
                this.f21848b.setMinimumWidth(getContext().getResources().getDimensionPixelSize(X4.d.f5911k0));
            }
            if (this.f21850c == null) {
                TextView textView = new TextView(getContext());
                this.f21850c = textView;
                textView.setSingleLine();
            }
            if (Z(this.f21854e) && this.f21866n != 0) {
                this.f21850c.setTextAppearance(getContext(), this.f21866n);
            } else if (this.f21865m != 0) {
                this.f21850c.setTextAppearance(getContext(), this.f21865m);
            }
            int i5 = this.f21827B;
            if (i5 != 0) {
                this.f21850c.setTextColor(i5);
            }
            this.f21848b.removeAllViews();
            this.f21848b.addView(this.f21850c);
            if (!D(this.f21848b)) {
                h(this.f21848b, true);
            }
        }
        TextView textView2 = this.f21850c;
        if (textView2 != null) {
            textView2.setText(charSequence);
        }
        this.f21878z = charSequence;
    }

    public static class h extends View.BaseSavedState {
        public static final Parcelable.Creator<h> CREATOR = new a();

        /* renamed from: a, reason: collision with root package name */
        int f21887a;

        /* renamed from: b, reason: collision with root package name */
        boolean f21888b;

        class a implements Parcelable.Creator<h> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public h createFromParcel(Parcel parcel) {
                return new h(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public h[] newArray(int i5) {
                return new h[i5];
            }
        }

        public h(Parcel parcel) {
            super(parcel);
            this.f21887a = parcel.readInt();
            this.f21888b = parcel.readInt() != 0;
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i5) {
            super.writeToParcel(parcel, i5);
            parcel.writeInt(this.f21887a);
            parcel.writeInt(this.f21888b ? 1 : 0);
        }

        public h(Parcelable parcelable) {
            super(parcelable);
        }
    }
}
