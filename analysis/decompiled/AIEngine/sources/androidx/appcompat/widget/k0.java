package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.PopupWindow;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class k0 implements l.f {
    public Rect A;
    public boolean B;
    public PopupWindow C;

    /* renamed from: a, reason: collision with root package name */
    public final Context f862a;

    /* renamed from: b, reason: collision with root package name */
    public ListAdapter f863b;

    /* renamed from: c, reason: collision with root package name */
    public g0 f864c;
    public int h;

    /* renamed from: j, reason: collision with root package name */
    public int f867j;

    /* renamed from: l, reason: collision with root package name */
    public boolean f869l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f870m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f871n;

    /* renamed from: q, reason: collision with root package name */
    public d f874q;
    public View r;

    /* renamed from: s, reason: collision with root package name */
    public AdapterView.OnItemClickListener f875s;

    /* renamed from: t, reason: collision with root package name */
    public AdapterView.OnItemSelectedListener f876t;

    /* renamed from: y, reason: collision with root package name */
    public final Handler f881y;

    /* renamed from: d, reason: collision with root package name */
    public final int f865d = -2;

    /* renamed from: e, reason: collision with root package name */
    public int f866e = -2;

    /* renamed from: k, reason: collision with root package name */
    public final int f868k = 1002;

    /* renamed from: o, reason: collision with root package name */
    public int f872o = 0;

    /* renamed from: p, reason: collision with root package name */
    public final int f873p = Integer.MAX_VALUE;

    /* renamed from: u, reason: collision with root package name */
    public final g f877u = new g();

    /* renamed from: v, reason: collision with root package name */
    public final f f878v = new f();

    /* renamed from: w, reason: collision with root package name */
    public final e f879w = new e();

    /* renamed from: x, reason: collision with root package name */
    public final c f880x = new c();
    public final Rect z = new Rect();

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class a {
        public static int a(PopupWindow popupWindow, View view, int i10, boolean z) {
            return popupWindow.getMaxAvailableHeight(view, i10, z);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class b {
        public static void a(PopupWindow popupWindow, Rect rect) {
            popupWindow.setEpicenterBounds(rect);
        }

        public static void b(PopupWindow popupWindow, boolean z) {
            popupWindow.setIsClippedToScreen(z);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            g0 g0Var = k0.this.f864c;
            if (g0Var != null) {
                g0Var.setListSelectionHidden(true);
                g0Var.requestLayout();
            }
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class d extends DataSetObserver {
        public d() {
        }

        @Override // android.database.DataSetObserver
        public final void onChanged() {
            k0 k0Var = k0.this;
            if (k0Var.C.isShowing()) {
                k0Var.show();
            }
        }

        @Override // android.database.DataSetObserver
        public final void onInvalidated() {
            k0.this.dismiss();
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class f implements View.OnTouchListener {
        public f() {
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View view, MotionEvent motionEvent) {
            PopupWindow popupWindow;
            int action = motionEvent.getAction();
            int x3 = (int) motionEvent.getX();
            int y3 = (int) motionEvent.getY();
            k0 k0Var = k0.this;
            if (action == 0 && (popupWindow = k0Var.C) != null && popupWindow.isShowing() && x3 >= 0 && x3 < k0Var.C.getWidth() && y3 >= 0 && y3 < k0Var.C.getHeight()) {
                k0Var.f881y.postDelayed(k0Var.f877u, 250L);
                return false;
            }
            if (action != 1) {
                return false;
            }
            k0Var.f881y.removeCallbacks(k0Var.f877u);
            return false;
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class g implements Runnable {
        public g() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            k0 k0Var = k0.this;
            g0 g0Var = k0Var.f864c;
            if (g0Var == null || !g0Var.isAttachedToWindow() || k0Var.f864c.getCount() <= k0Var.f864c.getChildCount() || k0Var.f864c.getChildCount() > k0Var.f873p) {
                return;
            }
            k0Var.C.setInputMethodMode(2);
            k0Var.show();
        }
    }

    public k0(Context context, AttributeSet attributeSet, int i10, int i11) {
        int resourceId;
        this.f862a = context;
        this.f881y = new Handler(context.getMainLooper());
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, g.a.f8934o, i10, 0);
        this.h = typedArrayObtainStyledAttributes.getDimensionPixelOffset(0, 0);
        int dimensionPixelOffset = typedArrayObtainStyledAttributes.getDimensionPixelOffset(1, 0);
        this.f867j = dimensionPixelOffset;
        if (dimensionPixelOffset != 0) {
            this.f869l = true;
        }
        typedArrayObtainStyledAttributes.recycle();
        r rVar = new r(context, attributeSet, i10, 0);
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, g.a.f8937s, i10, 0);
        if (typedArrayObtainStyledAttributes2.hasValue(2)) {
            rVar.setOverlapAnchor(typedArrayObtainStyledAttributes2.getBoolean(2, false));
        }
        rVar.setBackgroundDrawable((!typedArrayObtainStyledAttributes2.hasValue(0) || (resourceId = typedArrayObtainStyledAttributes2.getResourceId(0, 0)) == 0) ? typedArrayObtainStyledAttributes2.getDrawable(0) : androidx.datastore.preferences.protobuf.b1.L(resourceId, context));
        typedArrayObtainStyledAttributes2.recycle();
        this.C = rVar;
        rVar.setInputMethodMode(1);
    }

    public g0 d(Context context, boolean z) {
        return new g0(context, z);
    }

    @Override // l.f
    public final void dismiss() {
        this.C.dismiss();
        this.C.setContentView(null);
        this.f864c = null;
        this.f881y.removeCallbacks(this.f877u);
    }

    public final void e(int i10) {
        Drawable background = this.C.getBackground();
        if (background == null) {
            this.f866e = i10;
            return;
        }
        Rect rect = this.z;
        background.getPadding(rect);
        this.f866e = rect.left + rect.right + i10;
    }

    public final Drawable getBackground() {
        return this.C.getBackground();
    }

    public final int getHorizontalOffset() {
        return this.h;
    }

    @Override // l.f
    public final g0 getListView() {
        return this.f864c;
    }

    public final int getVerticalOffset() {
        if (this.f869l) {
            return this.f867j;
        }
        return 0;
    }

    @Override // l.f
    public final boolean isShowing() {
        return this.C.isShowing();
    }

    public void setAdapter(ListAdapter listAdapter) {
        d dVar = this.f874q;
        if (dVar == null) {
            this.f874q = new d();
        } else {
            ListAdapter listAdapter2 = this.f863b;
            if (listAdapter2 != null) {
                listAdapter2.unregisterDataSetObserver(dVar);
            }
        }
        this.f863b = listAdapter;
        if (listAdapter != null) {
            listAdapter.registerDataSetObserver(this.f874q);
        }
        g0 g0Var = this.f864c;
        if (g0Var != null) {
            g0Var.setAdapter(this.f863b);
        }
    }

    public final void setBackgroundDrawable(Drawable drawable) {
        this.C.setBackgroundDrawable(drawable);
    }

    public final void setHorizontalOffset(int i10) {
        this.h = i10;
    }

    public final void setVerticalOffset(int i10) {
        this.f867j = i10;
        this.f869l = true;
    }

    @Override // l.f
    public void show() {
        int i10;
        int paddingBottom;
        g0 g0Var;
        g0 g0Var2 = this.f864c;
        Context context = this.f862a;
        if (g0Var2 == null) {
            g0 g0VarD = d(context, !this.B);
            this.f864c = g0VarD;
            g0VarD.setAdapter(this.f863b);
            this.f864c.setOnItemClickListener(this.f875s);
            this.f864c.setFocusable(true);
            this.f864c.setFocusableInTouchMode(true);
            this.f864c.setOnItemSelectedListener(new j0(this));
            this.f864c.setOnScrollListener(this.f879w);
            AdapterView.OnItemSelectedListener onItemSelectedListener = this.f876t;
            if (onItemSelectedListener != null) {
                this.f864c.setOnItemSelectedListener(onItemSelectedListener);
            }
            this.C.setContentView(this.f864c);
        }
        Drawable background = this.C.getBackground();
        Rect rect = this.z;
        if (background != null) {
            background.getPadding(rect);
            int i11 = rect.top;
            i10 = rect.bottom + i11;
            if (!this.f869l) {
                this.f867j = -i11;
            }
        } else {
            rect.setEmpty();
            i10 = 0;
        }
        int iA = a.a(this.C, this.r, this.f867j, this.C.getInputMethodMode() == 2);
        int i12 = this.f865d;
        if (i12 == -1) {
            paddingBottom = iA + i10;
        } else {
            int i13 = this.f866e;
            int iA2 = this.f864c.a(i13 != -2 ? i13 != -1 ? View.MeasureSpec.makeMeasureSpec(i13, 1073741824) : View.MeasureSpec.makeMeasureSpec(context.getResources().getDisplayMetrics().widthPixels - (rect.left + rect.right), 1073741824) : View.MeasureSpec.makeMeasureSpec(context.getResources().getDisplayMetrics().widthPixels - (rect.left + rect.right), Integer.MIN_VALUE), iA);
            paddingBottom = iA2 + (iA2 > 0 ? this.f864c.getPaddingBottom() + this.f864c.getPaddingTop() + i10 : 0);
        }
        boolean z = this.C.getInputMethodMode() == 2;
        this.C.setWindowLayoutType(this.f868k);
        if (this.C.isShowing()) {
            if (this.r.isAttachedToWindow()) {
                int width = this.f866e;
                if (width == -1) {
                    width = -1;
                } else if (width == -2) {
                    width = this.r.getWidth();
                }
                if (i12 == -1) {
                    i12 = z ? paddingBottom : -1;
                    if (z) {
                        this.C.setWidth(this.f866e == -1 ? -1 : 0);
                        this.C.setHeight(0);
                    } else {
                        this.C.setWidth(this.f866e == -1 ? -1 : 0);
                        this.C.setHeight(-1);
                    }
                } else if (i12 == -2) {
                    i12 = paddingBottom;
                }
                this.C.setOutsideTouchable(true);
                this.C.update(this.r, this.h, this.f867j, width < 0 ? -1 : width, i12 < 0 ? -1 : i12);
                return;
            }
            return;
        }
        int width2 = this.f866e;
        if (width2 == -1) {
            width2 = -1;
        } else if (width2 == -2) {
            width2 = this.r.getWidth();
        }
        if (i12 == -1) {
            i12 = -1;
        } else if (i12 == -2) {
            i12 = paddingBottom;
        }
        this.C.setWidth(width2);
        this.C.setHeight(i12);
        b.b(this.C, true);
        this.C.setOutsideTouchable(true);
        this.C.setTouchInterceptor(this.f878v);
        if (this.f871n) {
            this.C.setOverlapAnchor(this.f870m);
        }
        b.a(this.C, this.A);
        this.C.showAsDropDown(this.r, this.h, this.f867j, this.f872o);
        this.f864c.setSelection(-1);
        if ((!this.B || this.f864c.isInTouchMode()) && (g0Var = this.f864c) != null) {
            g0Var.setListSelectionHidden(true);
            g0Var.requestLayout();
        }
        if (this.B) {
            return;
        }
        this.f881y.post(this.f880x);
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class e implements AbsListView.OnScrollListener {
        public e() {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public final void onScrollStateChanged(AbsListView absListView, int i10) {
            k0 k0Var = k0.this;
            g gVar = k0Var.f877u;
            if (i10 != 1 || k0Var.C.getInputMethodMode() == 2 || k0Var.C.getContentView() == null) {
                return;
            }
            k0Var.f881y.removeCallbacks(gVar);
            gVar.run();
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public final void onScroll(AbsListView absListView, int i10, int i11, int i12) {
        }
    }
}
