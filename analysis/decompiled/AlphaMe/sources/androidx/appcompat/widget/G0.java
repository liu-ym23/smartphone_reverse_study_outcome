package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import g.AbstractC0560a;
import k.InterfaceC0644E;

/* loaded from: classes.dex */
public class G0 implements InterfaceC0644E {

    /* renamed from: a, reason: collision with root package name */
    public final Context f2821a;

    /* renamed from: b, reason: collision with root package name */
    public ListAdapter f2822b;

    /* renamed from: c, reason: collision with root package name */
    public C0229u0 f2823c;

    /* renamed from: f, reason: collision with root package name */
    public int f2826f;

    /* renamed from: g, reason: collision with root package name */
    public int f2827g;

    /* renamed from: i, reason: collision with root package name */
    public boolean f2829i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f2830j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f2831k;

    /* renamed from: n, reason: collision with root package name */
    public D0 f2834n;

    /* renamed from: o, reason: collision with root package name */
    public View f2835o;

    /* renamed from: p, reason: collision with root package name */
    public AdapterView.OnItemClickListener f2836p;

    /* renamed from: q, reason: collision with root package name */
    public AdapterView.OnItemSelectedListener f2837q;

    /* renamed from: v, reason: collision with root package name */
    public final Handler f2842v;

    /* renamed from: x, reason: collision with root package name */
    public Rect f2844x;

    /* renamed from: y, reason: collision with root package name */
    public boolean f2845y;

    /* renamed from: z, reason: collision with root package name */
    public PopupWindow f2846z;

    /* renamed from: d, reason: collision with root package name */
    public final int f2824d = -2;

    /* renamed from: e, reason: collision with root package name */
    public int f2825e = -2;

    /* renamed from: h, reason: collision with root package name */
    public final int f2828h = 1002;

    /* renamed from: l, reason: collision with root package name */
    public int f2832l = 0;

    /* renamed from: m, reason: collision with root package name */
    public final int f2833m = Integer.MAX_VALUE;

    /* renamed from: r, reason: collision with root package name */
    public final RunnableC0239z0 f2838r = new RunnableC0239z0(this, 2);

    /* renamed from: s, reason: collision with root package name */
    public final F0 f2839s = new F0(this);

    /* renamed from: t, reason: collision with root package name */
    public final E0 f2840t = new E0(this);

    /* renamed from: u, reason: collision with root package name */
    public final RunnableC0239z0 f2841u = new RunnableC0239z0(this, 1);

    /* renamed from: w, reason: collision with root package name */
    public final Rect f2843w = new Rect();

    public G0(Context context, AttributeSet attributeSet, int i4, int i5) {
        int resourceId;
        this.f2821a = context;
        this.f2842v = new Handler(context.getMainLooper());
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC0560a.f12602o, i4, i5);
        this.f2826f = typedArrayObtainStyledAttributes.getDimensionPixelOffset(0, 0);
        int dimensionPixelOffset = typedArrayObtainStyledAttributes.getDimensionPixelOffset(1, 0);
        this.f2827g = dimensionPixelOffset;
        if (dimensionPixelOffset != 0) {
            this.f2829i = true;
        }
        typedArrayObtainStyledAttributes.recycle();
        I i6 = new I(context, attributeSet, i4, i5);
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, AbstractC0560a.f12606s, i4, i5);
        if (typedArrayObtainStyledAttributes2.hasValue(2)) {
            androidx.core.widget.k.c(i6, typedArrayObtainStyledAttributes2.getBoolean(2, false));
        }
        i6.setBackgroundDrawable((!typedArrayObtainStyledAttributes2.hasValue(0) || (resourceId = typedArrayObtainStyledAttributes2.getResourceId(0, 0)) == 0) ? typedArrayObtainStyledAttributes2.getDrawable(0) : Z2.I.o(context, resourceId));
        typedArrayObtainStyledAttributes2.recycle();
        this.f2846z = i6;
        i6.setInputMethodMode(1);
    }

    public C0229u0 b(Context context, boolean z4) {
        return new C0229u0(context, z4);
    }

    public final void d(Drawable drawable) {
        this.f2846z.setBackgroundDrawable(drawable);
    }

    @Override // k.InterfaceC0644E
    public final void dismiss() {
        this.f2846z.dismiss();
        this.f2846z.setContentView(null);
        this.f2823c = null;
        this.f2842v.removeCallbacks(this.f2838r);
    }

    @Override // k.InterfaceC0644E
    public final boolean e() {
        return this.f2846z.isShowing();
    }

    public final int f() {
        return this.f2826f;
    }

    @Override // k.InterfaceC0644E
    public void g() {
        int i4;
        int paddingBottom;
        C0229u0 c0229u0;
        C0229u0 c0229u02 = this.f2823c;
        Context context = this.f2821a;
        if (c0229u02 == null) {
            C0229u0 c0229u0B = b(context, !this.f2845y);
            this.f2823c = c0229u0B;
            c0229u0B.setAdapter(this.f2822b);
            this.f2823c.setOnItemClickListener(this.f2836p);
            this.f2823c.setFocusable(true);
            this.f2823c.setFocusableInTouchMode(true);
            this.f2823c.setOnItemSelectedListener(new A0(this));
            this.f2823c.setOnScrollListener(this.f2840t);
            AdapterView.OnItemSelectedListener onItemSelectedListener = this.f2837q;
            if (onItemSelectedListener != null) {
                this.f2823c.setOnItemSelectedListener(onItemSelectedListener);
            }
            this.f2846z.setContentView(this.f2823c);
        }
        Drawable background = this.f2846z.getBackground();
        Rect rect = this.f2843w;
        if (background != null) {
            background.getPadding(rect);
            int i5 = rect.top;
            i4 = rect.bottom + i5;
            if (!this.f2829i) {
                this.f2827g = -i5;
            }
        } else {
            rect.setEmpty();
            i4 = 0;
        }
        int iA = B0.a(this.f2846z, this.f2835o, this.f2827g, this.f2846z.getInputMethodMode() == 2);
        int i6 = this.f2824d;
        if (i6 == -1) {
            paddingBottom = iA + i4;
        } else {
            int i7 = this.f2825e;
            int iA2 = this.f2823c.a(i7 != -2 ? i7 != -1 ? View.MeasureSpec.makeMeasureSpec(i7, 1073741824) : View.MeasureSpec.makeMeasureSpec(context.getResources().getDisplayMetrics().widthPixels - (rect.left + rect.right), 1073741824) : View.MeasureSpec.makeMeasureSpec(context.getResources().getDisplayMetrics().widthPixels - (rect.left + rect.right), Integer.MIN_VALUE), iA);
            paddingBottom = iA2 + (iA2 > 0 ? this.f2823c.getPaddingBottom() + this.f2823c.getPaddingTop() + i4 : 0);
        }
        boolean z4 = this.f2846z.getInputMethodMode() == 2;
        androidx.core.widget.k.d(this.f2846z, this.f2828h);
        if (this.f2846z.isShowing()) {
            if (this.f2835o.isAttachedToWindow()) {
                int width = this.f2825e;
                if (width == -1) {
                    width = -1;
                } else if (width == -2) {
                    width = this.f2835o.getWidth();
                }
                if (i6 == -1) {
                    i6 = z4 ? paddingBottom : -1;
                    if (z4) {
                        this.f2846z.setWidth(this.f2825e == -1 ? -1 : 0);
                        this.f2846z.setHeight(0);
                    } else {
                        this.f2846z.setWidth(this.f2825e == -1 ? -1 : 0);
                        this.f2846z.setHeight(-1);
                    }
                } else if (i6 == -2) {
                    i6 = paddingBottom;
                }
                this.f2846z.setOutsideTouchable(true);
                this.f2846z.update(this.f2835o, this.f2826f, this.f2827g, width < 0 ? -1 : width, i6 < 0 ? -1 : i6);
                return;
            }
            return;
        }
        int width2 = this.f2825e;
        if (width2 == -1) {
            width2 = -1;
        } else if (width2 == -2) {
            width2 = this.f2835o.getWidth();
        }
        if (i6 == -1) {
            i6 = -1;
        } else if (i6 == -2) {
            i6 = paddingBottom;
        }
        this.f2846z.setWidth(width2);
        this.f2846z.setHeight(i6);
        C0.b(this.f2846z, true);
        this.f2846z.setOutsideTouchable(true);
        this.f2846z.setTouchInterceptor(this.f2839s);
        if (this.f2831k) {
            androidx.core.widget.k.c(this.f2846z, this.f2830j);
        }
        C0.a(this.f2846z, this.f2844x);
        this.f2846z.showAsDropDown(this.f2835o, this.f2826f, this.f2827g, this.f2832l);
        this.f2823c.setSelection(-1);
        if ((!this.f2845y || this.f2823c.isInTouchMode()) && (c0229u0 = this.f2823c) != null) {
            c0229u0.setListSelectionHidden(true);
            c0229u0.requestLayout();
        }
        if (this.f2845y) {
            return;
        }
        this.f2842v.post(this.f2841u);
    }

    public final Drawable h() {
        return this.f2846z.getBackground();
    }

    @Override // k.InterfaceC0644E
    public final C0229u0 i() {
        return this.f2823c;
    }

    public final void k(int i4) {
        this.f2827g = i4;
        this.f2829i = true;
    }

    public final void m(int i4) {
        this.f2826f = i4;
    }

    public final int o() {
        if (this.f2829i) {
            return this.f2827g;
        }
        return 0;
    }

    public void q(ListAdapter listAdapter) {
        D0 d02 = this.f2834n;
        if (d02 == null) {
            this.f2834n = new D0(this);
        } else {
            ListAdapter listAdapter2 = this.f2822b;
            if (listAdapter2 != null) {
                listAdapter2.unregisterDataSetObserver(d02);
            }
        }
        this.f2822b = listAdapter;
        if (listAdapter != null) {
            listAdapter.registerDataSetObserver(this.f2834n);
        }
        C0229u0 c0229u0 = this.f2823c;
        if (c0229u0 != null) {
            c0229u0.setAdapter(this.f2822b);
        }
    }

    public final void r(int i4) {
        Drawable background = this.f2846z.getBackground();
        if (background == null) {
            this.f2825e = i4;
            return;
        }
        Rect rect = this.f2843w;
        background.getPadding(rect);
        this.f2825e = rect.left + rect.right + i4;
    }
}
