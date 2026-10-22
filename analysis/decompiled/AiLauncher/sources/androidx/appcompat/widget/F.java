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
import androidx.appcompat.R$attr;
import androidx.appcompat.R$styleable;
import j.InterfaceC4741f;

/* loaded from: classes.dex */
public class F implements InterfaceC4741f {

    /* renamed from: A, reason: collision with root package name */
    public Runnable f8899A;

    /* renamed from: B, reason: collision with root package name */
    public final Handler f8900B;

    /* renamed from: C, reason: collision with root package name */
    public final Rect f8901C;

    /* renamed from: D, reason: collision with root package name */
    public Rect f8902D;

    /* renamed from: E, reason: collision with root package name */
    public boolean f8903E;

    /* renamed from: F, reason: collision with root package name */
    public PopupWindow f8904F;

    /* renamed from: a, reason: collision with root package name */
    public Context f8905a;

    /* renamed from: b, reason: collision with root package name */
    public ListAdapter f8906b;

    /* renamed from: c, reason: collision with root package name */
    public C f8907c;

    /* renamed from: d, reason: collision with root package name */
    public int f8908d;

    /* renamed from: e, reason: collision with root package name */
    public int f8909e;

    /* renamed from: f, reason: collision with root package name */
    public int f8910f;

    /* renamed from: g, reason: collision with root package name */
    public int f8911g;

    /* renamed from: h, reason: collision with root package name */
    public int f8912h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f8913i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f8914j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f8915k;

    /* renamed from: l, reason: collision with root package name */
    public int f8916l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f8917m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f8918n;

    /* renamed from: o, reason: collision with root package name */
    public int f8919o;

    /* renamed from: p, reason: collision with root package name */
    public View f8920p;

    /* renamed from: q, reason: collision with root package name */
    public int f8921q;

    /* renamed from: r, reason: collision with root package name */
    public DataSetObserver f8922r;

    /* renamed from: s, reason: collision with root package name */
    public View f8923s;

    /* renamed from: t, reason: collision with root package name */
    public Drawable f8924t;

    /* renamed from: u, reason: collision with root package name */
    public AdapterView.OnItemClickListener f8925u;

    /* renamed from: v, reason: collision with root package name */
    public AdapterView.OnItemSelectedListener f8926v;

    /* renamed from: w, reason: collision with root package name */
    public final i f8927w;

    /* renamed from: x, reason: collision with root package name */
    public final h f8928x;

    /* renamed from: y, reason: collision with root package name */
    public final g f8929y;

    /* renamed from: z, reason: collision with root package name */
    public final e f8930z;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            View viewR = F.this.r();
            if (viewR == null || viewR.getWindowToken() == null) {
                return;
            }
            F.this.show();
        }
    }

    public class b implements AdapterView.OnItemSelectedListener {
        public b() {
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView<?> adapterView, View view, int i10, long j10) {
            C c10;
            if (i10 == -1 || (c10 = F.this.f8907c) == null) {
                return;
            }
            c10.setListSelectionHidden(false);
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    public static class c {
        public static int a(PopupWindow popupWindow, View view, int i10, boolean z10) {
            return popupWindow.getMaxAvailableHeight(view, i10, z10);
        }
    }

    public static class d {
        public static void a(PopupWindow popupWindow, Rect rect) {
            popupWindow.setEpicenterBounds(rect);
        }

        public static void b(PopupWindow popupWindow, boolean z10) {
            popupWindow.setIsClippedToScreen(z10);
        }
    }

    public class e implements Runnable {
        public e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            F.this.p();
        }
    }

    public class f extends DataSetObserver {
        public f() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            if (F.this.isShowing()) {
                F.this.show();
            }
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            F.this.dismiss();
        }
    }

    public class g implements AbsListView.OnScrollListener {
        public g() {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i10, int i11, int i12) {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i10) {
            if (i10 != 1 || F.this.y() || F.this.f8904F.getContentView() == null) {
                return;
            }
            F f10 = F.this;
            f10.f8900B.removeCallbacks(f10.f8927w);
            F.this.f8927w.run();
        }
    }

    public class h implements View.OnTouchListener {
        public h() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            PopupWindow popupWindow;
            int action = motionEvent.getAction();
            int x10 = (int) motionEvent.getX();
            int y10 = (int) motionEvent.getY();
            if (action == 0 && (popupWindow = F.this.f8904F) != null && popupWindow.isShowing() && x10 >= 0 && x10 < F.this.f8904F.getWidth() && y10 >= 0 && y10 < F.this.f8904F.getHeight()) {
                F f10 = F.this;
                f10.f8900B.postDelayed(f10.f8927w, 250L);
                return false;
            }
            if (action != 1) {
                return false;
            }
            F f11 = F.this;
            f11.f8900B.removeCallbacks(f11.f8927w);
            return false;
        }
    }

    public class i implements Runnable {
        public i() {
        }

        @Override // java.lang.Runnable
        public void run() {
            C c10 = F.this.f8907c;
            if (c10 == null || !c10.isAttachedToWindow() || F.this.f8907c.getCount() <= F.this.f8907c.getChildCount()) {
                return;
            }
            int childCount = F.this.f8907c.getChildCount();
            F f10 = F.this;
            if (childCount <= f10.f8919o) {
                f10.f8904F.setInputMethodMode(2);
                F.this.show();
            }
        }
    }

    public F(Context context) {
        this(context, null, R$attr.listPopupWindowStyle);
    }

    public final void A() {
        View view = this.f8920p;
        if (view != null) {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.f8920p);
            }
        }
    }

    public void B(View view) {
        this.f8923s = view;
    }

    public void C(int i10) {
        this.f8904F.setAnimationStyle(i10);
    }

    public void D(int i10) {
        Drawable background = this.f8904F.getBackground();
        if (background == null) {
            P(i10);
            return;
        }
        background.getPadding(this.f8901C);
        Rect rect = this.f8901C;
        this.f8909e = rect.left + rect.right + i10;
    }

    public void E(int i10) {
        this.f8916l = i10;
    }

    public void F(Rect rect) {
        this.f8902D = rect != null ? new Rect(rect) : null;
    }

    public void G(int i10) {
        this.f8904F.setInputMethodMode(i10);
    }

    public void H(boolean z10) {
        this.f8903E = z10;
        this.f8904F.setFocusable(z10);
    }

    public void I(PopupWindow.OnDismissListener onDismissListener) {
        this.f8904F.setOnDismissListener(onDismissListener);
    }

    public void J(AdapterView.OnItemClickListener onItemClickListener) {
        this.f8925u = onItemClickListener;
    }

    public void K(AdapterView.OnItemSelectedListener onItemSelectedListener) {
        this.f8926v = onItemSelectedListener;
    }

    public void L(boolean z10) {
        this.f8915k = true;
        this.f8914j = z10;
    }

    public final void M(boolean z10) {
        d.b(this.f8904F, z10);
    }

    public void N(int i10) {
        this.f8921q = i10;
    }

    public void O(int i10) {
        C c10 = this.f8907c;
        if (!isShowing() || c10 == null) {
            return;
        }
        c10.setListSelectionHidden(false);
        c10.setSelection(i10);
        if (c10.getChoiceMode() != 0) {
            c10.setItemChecked(i10, true);
        }
    }

    public void P(int i10) {
        this.f8909e = i10;
    }

    public int a() {
        return this.f8910f;
    }

    public void b(Drawable drawable) {
        this.f8904F.setBackgroundDrawable(drawable);
    }

    public void d(int i10) {
        this.f8910f = i10;
    }

    @Override // j.InterfaceC4741f
    public void dismiss() {
        this.f8904F.dismiss();
        A();
        this.f8904F.setContentView(null);
        this.f8907c = null;
        this.f8900B.removeCallbacks(this.f8927w);
    }

    public Drawable f() {
        return this.f8904F.getBackground();
    }

    public void h(int i10) {
        this.f8911g = i10;
        this.f8913i = true;
    }

    @Override // j.InterfaceC4741f
    public boolean isShowing() {
        return this.f8904F.isShowing();
    }

    public int k() {
        if (this.f8913i) {
            return this.f8911g;
        }
        return 0;
    }

    public void l(ListAdapter listAdapter) {
        DataSetObserver dataSetObserver = this.f8922r;
        if (dataSetObserver == null) {
            this.f8922r = new f();
        } else {
            ListAdapter listAdapter2 = this.f8906b;
            if (listAdapter2 != null) {
                listAdapter2.unregisterDataSetObserver(dataSetObserver);
            }
        }
        this.f8906b = listAdapter;
        if (listAdapter != null) {
            listAdapter.registerDataSetObserver(this.f8922r);
        }
        C c10 = this.f8907c;
        if (c10 != null) {
            c10.setAdapter(this.f8906b);
        }
    }

    @Override // j.InterfaceC4741f
    public ListView n() {
        return this.f8907c;
    }

    public final int o() {
        int measuredHeight;
        int i10;
        int iMakeMeasureSpec;
        int i11;
        if (this.f8907c == null) {
            Context context = this.f8905a;
            this.f8899A = new a();
            C cQ = q(context, !this.f8903E);
            this.f8907c = cQ;
            Drawable drawable = this.f8924t;
            if (drawable != null) {
                cQ.setSelector(drawable);
            }
            this.f8907c.setAdapter(this.f8906b);
            this.f8907c.setOnItemClickListener(this.f8925u);
            this.f8907c.setFocusable(true);
            this.f8907c.setFocusableInTouchMode(true);
            this.f8907c.setOnItemSelectedListener(new b());
            this.f8907c.setOnScrollListener(this.f8929y);
            AdapterView.OnItemSelectedListener onItemSelectedListener = this.f8926v;
            if (onItemSelectedListener != null) {
                this.f8907c.setOnItemSelectedListener(onItemSelectedListener);
            }
            View view = this.f8907c;
            View view2 = this.f8920p;
            if (view2 != null) {
                LinearLayout linearLayout = new LinearLayout(context);
                linearLayout.setOrientation(1);
                ViewGroup.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 0, 1.0f);
                int i12 = this.f8921q;
                if (i12 == 0) {
                    linearLayout.addView(view2);
                    linearLayout.addView(view, layoutParams);
                } else if (i12 != 1) {
                    Log.e("ListPopupWindow", "Invalid hint position " + this.f8921q);
                } else {
                    linearLayout.addView(view, layoutParams);
                    linearLayout.addView(view2);
                }
                int i13 = this.f8909e;
                if (i13 >= 0) {
                    i11 = Integer.MIN_VALUE;
                } else {
                    i13 = 0;
                    i11 = 0;
                }
                view2.measure(View.MeasureSpec.makeMeasureSpec(i13, i11), 0);
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) view2.getLayoutParams();
                measuredHeight = view2.getMeasuredHeight() + layoutParams2.topMargin + layoutParams2.bottomMargin;
                view = linearLayout;
            } else {
                measuredHeight = 0;
            }
            this.f8904F.setContentView(view);
        } else {
            View view3 = this.f8920p;
            if (view3 != null) {
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) view3.getLayoutParams();
                measuredHeight = view3.getMeasuredHeight() + layoutParams3.topMargin + layoutParams3.bottomMargin;
            } else {
                measuredHeight = 0;
            }
        }
        Drawable background = this.f8904F.getBackground();
        if (background != null) {
            background.getPadding(this.f8901C);
            Rect rect = this.f8901C;
            int i14 = rect.top;
            i10 = rect.bottom + i14;
            if (!this.f8913i) {
                this.f8911g = -i14;
            }
        } else {
            this.f8901C.setEmpty();
            i10 = 0;
        }
        int iS = s(r(), this.f8911g, this.f8904F.getInputMethodMode() == 2);
        if (this.f8917m || this.f8908d == -1) {
            return iS + i10;
        }
        int i15 = this.f8909e;
        if (i15 == -2) {
            int i16 = this.f8905a.getResources().getDisplayMetrics().widthPixels;
            Rect rect2 = this.f8901C;
            iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i16 - (rect2.left + rect2.right), Integer.MIN_VALUE);
        } else if (i15 != -1) {
            iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i15, 1073741824);
        } else {
            int i17 = this.f8905a.getResources().getDisplayMetrics().widthPixels;
            Rect rect3 = this.f8901C;
            iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i17 - (rect3.left + rect3.right), 1073741824);
        }
        int iD = this.f8907c.d(iMakeMeasureSpec, 0, -1, iS - measuredHeight, -1);
        if (iD > 0) {
            measuredHeight += i10 + this.f8907c.getPaddingTop() + this.f8907c.getPaddingBottom();
        }
        return iD + measuredHeight;
    }

    public void p() {
        C c10 = this.f8907c;
        if (c10 != null) {
            c10.setListSelectionHidden(true);
            c10.requestLayout();
        }
    }

    public C q(Context context, boolean z10) {
        return new C(context, z10);
    }

    public View r() {
        return this.f8923s;
    }

    public final int s(View view, int i10, boolean z10) {
        return c.a(this.f8904F, view, i10, z10);
    }

    @Override // j.InterfaceC4741f
    public void show() {
        int iO = o();
        boolean zY = y();
        androidx.core.widget.g.b(this.f8904F, this.f8912h);
        if (this.f8904F.isShowing()) {
            if (r().isAttachedToWindow()) {
                int width = this.f8909e;
                if (width == -1) {
                    width = -1;
                } else if (width == -2) {
                    width = r().getWidth();
                }
                int i10 = this.f8908d;
                if (i10 == -1) {
                    if (!zY) {
                        iO = -1;
                    }
                    if (zY) {
                        this.f8904F.setWidth(this.f8909e == -1 ? -1 : 0);
                        this.f8904F.setHeight(0);
                    } else {
                        this.f8904F.setWidth(this.f8909e == -1 ? -1 : 0);
                        this.f8904F.setHeight(-1);
                    }
                } else if (i10 != -2) {
                    iO = i10;
                }
                this.f8904F.setOutsideTouchable((this.f8918n || this.f8917m) ? false : true);
                this.f8904F.update(r(), this.f8910f, this.f8911g, width < 0 ? -1 : width, iO < 0 ? -1 : iO);
                return;
            }
            return;
        }
        int width2 = this.f8909e;
        if (width2 == -1) {
            width2 = -1;
        } else if (width2 == -2) {
            width2 = r().getWidth();
        }
        int i11 = this.f8908d;
        if (i11 == -1) {
            iO = -1;
        } else if (i11 != -2) {
            iO = i11;
        }
        this.f8904F.setWidth(width2);
        this.f8904F.setHeight(iO);
        M(true);
        this.f8904F.setOutsideTouchable((this.f8918n || this.f8917m) ? false : true);
        this.f8904F.setTouchInterceptor(this.f8928x);
        if (this.f8915k) {
            androidx.core.widget.g.a(this.f8904F, this.f8914j);
        }
        d.a(this.f8904F, this.f8902D);
        androidx.core.widget.g.c(this.f8904F, r(), this.f8910f, this.f8911g, this.f8916l);
        this.f8907c.setSelection(-1);
        if (!this.f8903E || this.f8907c.isInTouchMode()) {
            p();
        }
        if (this.f8903E) {
            return;
        }
        this.f8900B.post(this.f8930z);
    }

    public Object t() {
        if (isShowing()) {
            return this.f8907c.getSelectedItem();
        }
        return null;
    }

    public long u() {
        if (isShowing()) {
            return this.f8907c.getSelectedItemId();
        }
        return Long.MIN_VALUE;
    }

    public int v() {
        if (isShowing()) {
            return this.f8907c.getSelectedItemPosition();
        }
        return -1;
    }

    public View w() {
        if (isShowing()) {
            return this.f8907c.getSelectedView();
        }
        return null;
    }

    public int x() {
        return this.f8909e;
    }

    public boolean y() {
        return this.f8904F.getInputMethodMode() == 2;
    }

    public boolean z() {
        return this.f8903E;
    }

    public F(Context context, AttributeSet attributeSet, int i10) {
        this(context, attributeSet, i10, 0);
    }

    public F(Context context, AttributeSet attributeSet, int i10, int i11) {
        this.f8908d = -2;
        this.f8909e = -2;
        this.f8912h = 1002;
        this.f8916l = 0;
        this.f8917m = false;
        this.f8918n = false;
        this.f8919o = Integer.MAX_VALUE;
        this.f8921q = 0;
        this.f8927w = new i();
        this.f8928x = new h();
        this.f8929y = new g();
        this.f8930z = new e();
        this.f8901C = new Rect();
        this.f8905a = context;
        this.f8900B = new Handler(context.getMainLooper());
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ListPopupWindow, i10, i11);
        this.f8910f = typedArrayObtainStyledAttributes.getDimensionPixelOffset(R$styleable.ListPopupWindow_android_dropDownHorizontalOffset, 0);
        int dimensionPixelOffset = typedArrayObtainStyledAttributes.getDimensionPixelOffset(R$styleable.ListPopupWindow_android_dropDownVerticalOffset, 0);
        this.f8911g = dimensionPixelOffset;
        if (dimensionPixelOffset != 0) {
            this.f8913i = true;
        }
        typedArrayObtainStyledAttributes.recycle();
        C1302o c1302o = new C1302o(context, attributeSet, i10, i11);
        this.f8904F = c1302o;
        c1302o.setInputMethodMode(1);
    }
}
