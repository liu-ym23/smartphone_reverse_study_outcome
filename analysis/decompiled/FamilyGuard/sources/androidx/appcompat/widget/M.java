package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import g.C0728a;
import l.InterfaceC0820e;

/* loaded from: classes.dex */
public class M implements InterfaceC0820e {

    /* renamed from: A, reason: collision with root package name */
    private Runnable f8189A;

    /* renamed from: B, reason: collision with root package name */
    final Handler f8190B;

    /* renamed from: C, reason: collision with root package name */
    private final Rect f8191C;

    /* renamed from: D, reason: collision with root package name */
    private Rect f8192D;

    /* renamed from: E, reason: collision with root package name */
    private boolean f8193E;

    /* renamed from: F, reason: collision with root package name */
    PopupWindow f8194F;

    /* renamed from: a, reason: collision with root package name */
    private Context f8195a;

    /* renamed from: b, reason: collision with root package name */
    private ListAdapter f8196b;

    /* renamed from: c, reason: collision with root package name */
    J f8197c;

    /* renamed from: d, reason: collision with root package name */
    private int f8198d;

    /* renamed from: e, reason: collision with root package name */
    private int f8199e;

    /* renamed from: f, reason: collision with root package name */
    private int f8200f;

    /* renamed from: g, reason: collision with root package name */
    private int f8201g;

    /* renamed from: h, reason: collision with root package name */
    private int f8202h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f8203i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f8204j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f8205k;

    /* renamed from: l, reason: collision with root package name */
    private int f8206l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f8207m;

    /* renamed from: n, reason: collision with root package name */
    private boolean f8208n;

    /* renamed from: o, reason: collision with root package name */
    int f8209o;

    /* renamed from: p, reason: collision with root package name */
    private View f8210p;

    /* renamed from: q, reason: collision with root package name */
    private int f8211q;

    /* renamed from: r, reason: collision with root package name */
    private DataSetObserver f8212r;

    /* renamed from: s, reason: collision with root package name */
    private View f8213s;

    /* renamed from: t, reason: collision with root package name */
    private Drawable f8214t;

    /* renamed from: u, reason: collision with root package name */
    private AdapterView.OnItemClickListener f8215u;

    /* renamed from: v, reason: collision with root package name */
    private AdapterView.OnItemSelectedListener f8216v;

    /* renamed from: w, reason: collision with root package name */
    final i f8217w;

    /* renamed from: x, reason: collision with root package name */
    private final h f8218x;

    /* renamed from: y, reason: collision with root package name */
    private final g f8219y;

    /* renamed from: z, reason: collision with root package name */
    private final e f8220z;

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            View viewT = M.this.t();
            if (viewT == null || viewT.getWindowToken() == null) {
                return;
            }
            M.this.a();
        }
    }

    class b implements AdapterView.OnItemSelectedListener {
        b() {
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView<?> adapterView, View view, int i5, long j5) {
            J j6;
            if (i5 == -1 || (j6 = M.this.f8197c) == null) {
                return;
            }
            j6.setListSelectionHidden(false);
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    static class c {
        static int a(PopupWindow popupWindow, View view, int i5, boolean z5) {
            return popupWindow.getMaxAvailableHeight(view, i5, z5);
        }
    }

    static class d {
        static void a(PopupWindow popupWindow, Rect rect) {
            popupWindow.setEpicenterBounds(rect);
        }

        static void b(PopupWindow popupWindow, boolean z5) {
            popupWindow.setIsClippedToScreen(z5);
        }
    }

    private class e implements Runnable {
        e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            M.this.e();
        }
    }

    private class f extends DataSetObserver {
        f() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            if (M.this.h()) {
                M.this.a();
            }
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            M.this.dismiss();
        }
    }

    private class g implements AbsListView.OnScrollListener {
        g() {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i5, int i6, int i7) {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i5) {
            if (i5 != 1 || M.this.A() || M.this.f8194F.getContentView() == null) {
                return;
            }
            M m5 = M.this;
            m5.f8190B.removeCallbacks(m5.f8217w);
            M.this.f8217w.run();
        }
    }

    private class h implements View.OnTouchListener {
        h() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            PopupWindow popupWindow;
            int action = motionEvent.getAction();
            int x5 = (int) motionEvent.getX();
            int y5 = (int) motionEvent.getY();
            if (action == 0 && (popupWindow = M.this.f8194F) != null && popupWindow.isShowing() && x5 >= 0 && x5 < M.this.f8194F.getWidth() && y5 >= 0 && y5 < M.this.f8194F.getHeight()) {
                M m5 = M.this;
                m5.f8190B.postDelayed(m5.f8217w, 250L);
                return false;
            }
            if (action != 1) {
                return false;
            }
            M m6 = M.this;
            m6.f8190B.removeCallbacks(m6.f8217w);
            return false;
        }
    }

    private class i implements Runnable {
        i() {
        }

        @Override // java.lang.Runnable
        public void run() {
            J j5 = M.this.f8197c;
            if (j5 == null || !j5.isAttachedToWindow() || M.this.f8197c.getCount() <= M.this.f8197c.getChildCount()) {
                return;
            }
            int childCount = M.this.f8197c.getChildCount();
            M m5 = M.this;
            if (childCount <= m5.f8209o) {
                m5.f8194F.setInputMethodMode(2);
                M.this.a();
            }
        }
    }

    public M(Context context) {
        this(context, null, C0728a.f16812I);
    }

    private void C() {
        View view = this.f8210p;
        if (view != null) {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.f8210p);
            }
        }
    }

    private void O(boolean z5) {
        d.b(this.f8194F, z5);
    }

    private int d() {
        int measuredHeight;
        int i5;
        int iMakeMeasureSpec;
        int i6;
        if (this.f8197c == null) {
            Context context = this.f8195a;
            this.f8189A = new a();
            J jF = f(context, !this.f8193E);
            this.f8197c = jF;
            Drawable drawable = this.f8214t;
            if (drawable != null) {
                jF.setSelector(drawable);
            }
            this.f8197c.setAdapter(this.f8196b);
            this.f8197c.setOnItemClickListener(this.f8215u);
            this.f8197c.setFocusable(true);
            this.f8197c.setFocusableInTouchMode(true);
            this.f8197c.setOnItemSelectedListener(new b());
            this.f8197c.setOnScrollListener(this.f8219y);
            AdapterView.OnItemSelectedListener onItemSelectedListener = this.f8216v;
            if (onItemSelectedListener != null) {
                this.f8197c.setOnItemSelectedListener(onItemSelectedListener);
            }
            View view = this.f8197c;
            View view2 = this.f8210p;
            if (view2 != null) {
                LinearLayout linearLayout = new LinearLayout(context);
                linearLayout.setOrientation(1);
                ViewGroup.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 0, 1.0f);
                int i7 = this.f8211q;
                if (i7 == 0) {
                    linearLayout.addView(view2);
                    linearLayout.addView(view, layoutParams);
                } else if (i7 != 1) {
                    Log.e("ListPopupWindow", "Invalid hint position " + this.f8211q);
                } else {
                    linearLayout.addView(view, layoutParams);
                    linearLayout.addView(view2);
                }
                int i8 = this.f8199e;
                if (i8 >= 0) {
                    i6 = Integer.MIN_VALUE;
                } else {
                    i8 = 0;
                    i6 = 0;
                }
                view2.measure(View.MeasureSpec.makeMeasureSpec(i8, i6), 0);
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) view2.getLayoutParams();
                measuredHeight = view2.getMeasuredHeight() + layoutParams2.topMargin + layoutParams2.bottomMargin;
                view = linearLayout;
            } else {
                measuredHeight = 0;
            }
            this.f8194F.setContentView(view);
        } else {
            View view3 = this.f8210p;
            if (view3 != null) {
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) view3.getLayoutParams();
                measuredHeight = view3.getMeasuredHeight() + layoutParams3.topMargin + layoutParams3.bottomMargin;
            } else {
                measuredHeight = 0;
            }
        }
        Drawable background = this.f8194F.getBackground();
        if (background != null) {
            background.getPadding(this.f8191C);
            Rect rect = this.f8191C;
            int i9 = rect.top;
            i5 = rect.bottom + i9;
            if (!this.f8203i) {
                this.f8201g = -i9;
            }
        } else {
            this.f8191C.setEmpty();
            i5 = 0;
        }
        int iU = u(t(), this.f8201g, this.f8194F.getInputMethodMode() == 2);
        if (this.f8207m || this.f8198d == -1) {
            return iU + i5;
        }
        int i10 = this.f8199e;
        if (i10 == -2) {
            int i11 = this.f8195a.getResources().getDisplayMetrics().widthPixels;
            Rect rect2 = this.f8191C;
            iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i11 - (rect2.left + rect2.right), Integer.MIN_VALUE);
        } else if (i10 != -1) {
            iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i10, 1073741824);
        } else {
            int i12 = this.f8195a.getResources().getDisplayMetrics().widthPixels;
            Rect rect3 = this.f8191C;
            iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i12 - (rect3.left + rect3.right), 1073741824);
        }
        int iD = this.f8197c.d(iMakeMeasureSpec, 0, -1, iU - measuredHeight, -1);
        if (iD > 0) {
            measuredHeight += i5 + this.f8197c.getPaddingTop() + this.f8197c.getPaddingBottom();
        }
        return iD + measuredHeight;
    }

    private int u(View view, int i5, boolean z5) {
        return c.a(this.f8194F, view, i5, z5);
    }

    public boolean A() {
        return this.f8194F.getInputMethodMode() == 2;
    }

    public boolean B() {
        return this.f8193E;
    }

    public void D(View view) {
        this.f8213s = view;
    }

    public void E(int i5) {
        this.f8194F.setAnimationStyle(i5);
    }

    public void F(int i5) {
        Drawable background = this.f8194F.getBackground();
        if (background == null) {
            R(i5);
            return;
        }
        background.getPadding(this.f8191C);
        Rect rect = this.f8191C;
        this.f8199e = rect.left + rect.right + i5;
    }

    public void G(int i5) {
        this.f8206l = i5;
    }

    public void H(Rect rect) {
        this.f8192D = rect != null ? new Rect(rect) : null;
    }

    public void I(int i5) {
        this.f8194F.setInputMethodMode(i5);
    }

    public void J(boolean z5) {
        this.f8193E = z5;
        this.f8194F.setFocusable(z5);
    }

    public void K(PopupWindow.OnDismissListener onDismissListener) {
        this.f8194F.setOnDismissListener(onDismissListener);
    }

    public void L(AdapterView.OnItemClickListener onItemClickListener) {
        this.f8215u = onItemClickListener;
    }

    public void M(AdapterView.OnItemSelectedListener onItemSelectedListener) {
        this.f8216v = onItemSelectedListener;
    }

    public void N(boolean z5) {
        this.f8205k = true;
        this.f8204j = z5;
    }

    public void P(int i5) {
        this.f8211q = i5;
    }

    public void Q(int i5) {
        J j5 = this.f8197c;
        if (!h() || j5 == null) {
            return;
        }
        j5.setListSelectionHidden(false);
        j5.setSelection(i5);
        if (j5.getChoiceMode() != 0) {
            j5.setItemChecked(i5, true);
        }
    }

    public void R(int i5) {
        this.f8199e = i5;
    }

    @Override // l.InterfaceC0820e
    public void a() {
        int iD = d();
        boolean zA = A();
        androidx.core.widget.g.b(this.f8194F, this.f8202h);
        if (this.f8194F.isShowing()) {
            if (t().isAttachedToWindow()) {
                int width = this.f8199e;
                if (width == -1) {
                    width = -1;
                } else if (width == -2) {
                    width = t().getWidth();
                }
                int i5 = this.f8198d;
                if (i5 == -1) {
                    if (!zA) {
                        iD = -1;
                    }
                    if (zA) {
                        this.f8194F.setWidth(this.f8199e == -1 ? -1 : 0);
                        this.f8194F.setHeight(0);
                    } else {
                        this.f8194F.setWidth(this.f8199e == -1 ? -1 : 0);
                        this.f8194F.setHeight(-1);
                    }
                } else if (i5 != -2) {
                    iD = i5;
                }
                this.f8194F.setOutsideTouchable((this.f8208n || this.f8207m) ? false : true);
                this.f8194F.update(t(), this.f8200f, this.f8201g, width < 0 ? -1 : width, iD < 0 ? -1 : iD);
                return;
            }
            return;
        }
        int width2 = this.f8199e;
        if (width2 == -1) {
            width2 = -1;
        } else if (width2 == -2) {
            width2 = t().getWidth();
        }
        int i6 = this.f8198d;
        if (i6 == -1) {
            iD = -1;
        } else if (i6 != -2) {
            iD = i6;
        }
        this.f8194F.setWidth(width2);
        this.f8194F.setHeight(iD);
        O(true);
        this.f8194F.setOutsideTouchable((this.f8208n || this.f8207m) ? false : true);
        this.f8194F.setTouchInterceptor(this.f8218x);
        if (this.f8205k) {
            androidx.core.widget.g.a(this.f8194F, this.f8204j);
        }
        d.a(this.f8194F, this.f8192D);
        androidx.core.widget.g.c(this.f8194F, t(), this.f8200f, this.f8201g, this.f8206l);
        this.f8197c.setSelection(-1);
        if (!this.f8193E || this.f8197c.isInTouchMode()) {
            e();
        }
        if (this.f8193E) {
            return;
        }
        this.f8190B.post(this.f8220z);
    }

    @Override // l.InterfaceC0820e
    public void dismiss() {
        this.f8194F.dismiss();
        C();
        this.f8194F.setContentView(null);
        this.f8197c = null;
        this.f8190B.removeCallbacks(this.f8217w);
    }

    public void e() {
        J j5 = this.f8197c;
        if (j5 != null) {
            j5.setListSelectionHidden(true);
            j5.requestLayout();
        }
    }

    J f(Context context, boolean z5) {
        return new J(context, z5);
    }

    public void g(Drawable drawable) {
        this.f8194F.setBackgroundDrawable(drawable);
    }

    @Override // l.InterfaceC0820e
    public boolean h() {
        return this.f8194F.isShowing();
    }

    public int i() {
        return this.f8200f;
    }

    public void j(int i5) {
        this.f8200f = i5;
    }

    public Drawable l() {
        return this.f8194F.getBackground();
    }

    @Override // l.InterfaceC0820e
    public ListView m() {
        return this.f8197c;
    }

    public void o(int i5) {
        this.f8201g = i5;
        this.f8203i = true;
    }

    public int r() {
        if (this.f8203i) {
            return this.f8201g;
        }
        return 0;
    }

    public void s(ListAdapter listAdapter) {
        DataSetObserver dataSetObserver = this.f8212r;
        if (dataSetObserver == null) {
            this.f8212r = new f();
        } else {
            ListAdapter listAdapter2 = this.f8196b;
            if (listAdapter2 != null) {
                listAdapter2.unregisterDataSetObserver(dataSetObserver);
            }
        }
        this.f8196b = listAdapter;
        if (listAdapter != null) {
            listAdapter.registerDataSetObserver(this.f8212r);
        }
        J j5 = this.f8197c;
        if (j5 != null) {
            j5.setAdapter(this.f8196b);
        }
    }

    public View t() {
        return this.f8213s;
    }

    public Object v() {
        if (h()) {
            return this.f8197c.getSelectedItem();
        }
        return null;
    }

    public long w() {
        if (h()) {
            return this.f8197c.getSelectedItemId();
        }
        return Long.MIN_VALUE;
    }

    public int x() {
        if (h()) {
            return this.f8197c.getSelectedItemPosition();
        }
        return -1;
    }

    public View y() {
        if (h()) {
            return this.f8197c.getSelectedView();
        }
        return null;
    }

    public int z() {
        return this.f8199e;
    }

    public M(Context context, AttributeSet attributeSet, int i5) {
        this(context, attributeSet, i5, 0);
    }

    public M(Context context, AttributeSet attributeSet, int i5, int i6) {
        this.f8198d = -2;
        this.f8199e = -2;
        this.f8202h = 1002;
        this.f8206l = 0;
        this.f8207m = false;
        this.f8208n = false;
        this.f8209o = Integer.MAX_VALUE;
        this.f8211q = 0;
        this.f8217w = new i();
        this.f8218x = new h();
        this.f8219y = new g();
        this.f8220z = new e();
        this.f8191C = new Rect();
        this.f8195a = context;
        this.f8190B = new Handler(context.getMainLooper());
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, g.j.f17151l1, i5, i6);
        this.f8200f = typedArrayObtainStyledAttributes.getDimensionPixelOffset(g.j.f17156m1, 0);
        int dimensionPixelOffset = typedArrayObtainStyledAttributes.getDimensionPixelOffset(g.j.f17161n1, 0);
        this.f8201g = dimensionPixelOffset;
        if (dimensionPixelOffset != 0) {
            this.f8203i = true;
        }
        typedArrayObtainStyledAttributes.recycle();
        C0449t c0449t = new C0449t(context, attributeSet, i5, i6);
        this.f8194F = c0449t;
        c0449t.setInputMethodMode(1);
    }
}
