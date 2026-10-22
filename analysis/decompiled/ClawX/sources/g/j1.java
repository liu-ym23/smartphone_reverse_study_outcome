package g;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class j1 implements f1, f.r {

    /* renamed from: a, reason: collision with root package name */
    public final Context f2737a;

    /* renamed from: b, reason: collision with root package name */
    public ListAdapter f2738b;

    /* renamed from: c, reason: collision with root package name */
    public i1 f2739c;

    /* renamed from: e, reason: collision with root package name */
    public int f2740e;

    /* renamed from: f, reason: collision with root package name */
    public int f2741f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f2742g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f2743h;

    /* renamed from: j, reason: collision with root package name */
    public boolean f2744j;

    /* renamed from: l, reason: collision with root package name */
    public c1 f2746l;

    /* renamed from: m, reason: collision with root package name */
    public View f2747m;

    /* renamed from: n, reason: collision with root package name */
    public f.l f2748n;

    /* renamed from: s, reason: collision with root package name */
    public final Handler f2753s;

    /* renamed from: u, reason: collision with root package name */
    public Rect f2755u;

    /* renamed from: v, reason: collision with root package name */
    public boolean f2756v;

    /* renamed from: w, reason: collision with root package name */
    public final x f2757w;

    /* renamed from: x, reason: collision with root package name */
    public androidx.emoji2.text.m f2758x;
    public int d = -2;

    /* renamed from: k, reason: collision with root package name */
    public int f2745k = 0;

    /* renamed from: o, reason: collision with root package name */
    public final b1 f2749o = new b1(this, 1);

    /* renamed from: p, reason: collision with root package name */
    public final e1 f2750p = new e1(this);

    /* renamed from: q, reason: collision with root package name */
    public final d1 f2751q = new d1(this);

    /* renamed from: r, reason: collision with root package name */
    public final b1 f2752r = new b1(this, 0);

    /* renamed from: t, reason: collision with root package name */
    public final Rect f2754t = new Rect();

    public j1(Context context, int i8) {
        int resourceId;
        this.f2737a = context;
        this.f2753s = new Handler(context.getMainLooper());
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(null, c.a.f1024l, i8, 0);
        this.f2740e = typedArrayObtainStyledAttributes.getDimensionPixelOffset(0, 0);
        int dimensionPixelOffset = typedArrayObtainStyledAttributes.getDimensionPixelOffset(1, 0);
        this.f2741f = dimensionPixelOffset;
        if (dimensionPixelOffset != 0) {
            this.f2742g = true;
        }
        typedArrayObtainStyledAttributes.recycle();
        x xVar = new x(context, null, i8, 0);
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(null, c.a.f1028p, i8, 0);
        if (typedArrayObtainStyledAttributes2.hasValue(2)) {
            xVar.setOverlapAnchor(typedArrayObtainStyledAttributes2.getBoolean(2, false));
        }
        xVar.setBackgroundDrawable((!typedArrayObtainStyledAttributes2.hasValue(0) || (resourceId = typedArrayObtainStyledAttributes2.getResourceId(0, 0)) == 0) ? typedArrayObtainStyledAttributes2.getDrawable(0) : b8.h.p(context, resourceId));
        typedArrayObtainStyledAttributes2.recycle();
        this.f2757w = xVar;
        xVar.setInputMethodMode(1);
    }

    @Override // f.r
    public final void a() {
        int i8;
        i1 i1Var;
        i1 i1Var2 = this.f2739c;
        Context context = this.f2737a;
        x xVar = this.f2757w;
        if (i1Var2 == null) {
            i1 i1Var3 = new i1(context, !this.f2756v);
            i1Var3.setHoverListener(this);
            this.f2739c = i1Var3;
            i1Var3.setAdapter(this.f2738b);
            this.f2739c.setOnItemClickListener(this.f2748n);
            this.f2739c.setFocusable(true);
            this.f2739c.setFocusableInTouchMode(true);
            this.f2739c.setOnItemSelectedListener(new y0(this));
            this.f2739c.setOnScrollListener(this.f2751q);
            xVar.setContentView(this.f2739c);
        }
        Drawable background = xVar.getBackground();
        Rect rect = this.f2754t;
        if (background != null) {
            background.getPadding(rect);
            int i9 = rect.top;
            i8 = rect.bottom + i9;
            if (!this.f2742g) {
                this.f2741f = -i9;
            }
        } else {
            rect.setEmpty();
            i8 = 0;
        }
        int iA = z0.a(xVar, this.f2747m, this.f2741f, xVar.getInputMethodMode() == 2);
        int i10 = this.d;
        int iA2 = this.f2739c.a(i10 != -2 ? i10 != -1 ? View.MeasureSpec.makeMeasureSpec(i10, 1073741824) : View.MeasureSpec.makeMeasureSpec(context.getResources().getDisplayMetrics().widthPixels - (rect.left + rect.right), 1073741824) : View.MeasureSpec.makeMeasureSpec(context.getResources().getDisplayMetrics().widthPixels - (rect.left + rect.right), Integer.MIN_VALUE), iA);
        int paddingBottom = iA2 + (iA2 > 0 ? this.f2739c.getPaddingBottom() + this.f2739c.getPaddingTop() + i8 : 0);
        xVar.getInputMethodMode();
        xVar.setWindowLayoutType(1002);
        if (xVar.isShowing()) {
            if (this.f2747m.isAttachedToWindow()) {
                int width = this.d;
                if (width == -1) {
                    width = -1;
                } else if (width == -2) {
                    width = this.f2747m.getWidth();
                }
                xVar.setOutsideTouchable(true);
                xVar.update(this.f2747m, this.f2740e, this.f2741f, width < 0 ? -1 : width, paddingBottom < 0 ? -1 : paddingBottom);
                return;
            }
            return;
        }
        int width2 = this.d;
        if (width2 == -1) {
            width2 = -1;
        } else if (width2 == -2) {
            width2 = this.f2747m.getWidth();
        }
        xVar.setWidth(width2);
        xVar.setHeight(paddingBottom);
        a1.b(xVar, true);
        xVar.setOutsideTouchable(true);
        xVar.setTouchInterceptor(this.f2750p);
        if (this.f2744j) {
            xVar.setOverlapAnchor(this.f2743h);
        }
        a1.a(xVar, this.f2755u);
        xVar.showAsDropDown(this.f2747m, this.f2740e, this.f2741f, this.f2745k);
        this.f2739c.setSelection(-1);
        if ((!this.f2756v || this.f2739c.isInTouchMode()) && (i1Var = this.f2739c) != null) {
            i1Var.setListSelectionHidden(true);
            i1Var.requestLayout();
        }
        if (this.f2756v) {
            return;
        }
        this.f2753s.post(this.f2752r);
    }

    public final void b(ListAdapter listAdapter) {
        c1 c1Var = this.f2746l;
        if (c1Var == null) {
            this.f2746l = new c1(this);
        } else {
            ListAdapter listAdapter2 = this.f2738b;
            if (listAdapter2 != null) {
                listAdapter2.unregisterDataSetObserver(c1Var);
            }
        }
        this.f2738b = listAdapter;
        if (listAdapter != null) {
            listAdapter.registerDataSetObserver(this.f2746l);
        }
        i1 i1Var = this.f2739c;
        if (i1Var != null) {
            i1Var.setAdapter(this.f2738b);
        }
    }

    @Override // f.r
    public final void dismiss() {
        x xVar = this.f2757w;
        xVar.dismiss();
        xVar.setContentView(null);
        this.f2739c = null;
        this.f2753s.removeCallbacks(this.f2749o);
    }

    @Override // f.r
    public final ListView g() {
        return this.f2739c;
    }

    @Override // g.f1
    public final void h(f.j jVar, MenuItem menuItem) {
        androidx.emoji2.text.m mVar = this.f2758x;
        if (mVar != null) {
            mVar.h(jVar, menuItem);
        }
    }

    @Override // g.f1
    public final void i(f.j jVar, f.k kVar) {
        androidx.emoji2.text.m mVar = this.f2758x;
        if (mVar != null) {
            mVar.i(jVar, kVar);
        }
    }

    @Override // f.r
    public final boolean k() {
        return this.f2757w.isShowing();
    }
}
