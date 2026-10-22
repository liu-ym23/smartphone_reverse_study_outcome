package m;

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
import com.google.crypto.tink.shaded.protobuf.Reader;
import java.lang.invoke.VarHandle;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public class w1 implements l.b0 {
    public final Rect A;
    public Rect B;
    public boolean C;
    public PopupWindow D;

    /* renamed from: c, reason: collision with root package name */
    public final Context f8114c;

    /* renamed from: f, reason: collision with root package name */
    public ListAdapter f8115f;

    /* renamed from: g, reason: collision with root package name */
    public j1 f8116g;

    /* renamed from: j, reason: collision with root package name */
    public int f8118j;

    /* renamed from: k, reason: collision with root package name */
    public int f8119k;

    /* renamed from: m, reason: collision with root package name */
    public boolean f8121m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f8122n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f8123o;

    /* renamed from: r, reason: collision with root package name */
    public t1 f8126r;

    /* renamed from: s, reason: collision with root package name */
    public View f8127s;

    /* renamed from: t, reason: collision with root package name */
    public AdapterView.OnItemClickListener f8128t;

    /* renamed from: u, reason: collision with root package name */
    public AdapterView.OnItemSelectedListener f8129u;

    /* renamed from: v, reason: collision with root package name */
    public final s1 f8130v;

    /* renamed from: w, reason: collision with root package name */
    public final v1 f8131w;

    /* renamed from: x, reason: collision with root package name */
    public final u1 f8132x;

    /* renamed from: y, reason: collision with root package name */
    public final s1 f8133y;

    /* renamed from: z, reason: collision with root package name */
    public final Handler f8134z;

    /* renamed from: h, reason: collision with root package name */
    public final int f8117h = -2;
    public int i = -2;

    /* renamed from: l, reason: collision with root package name */
    public final int f8120l = 1002;

    /* renamed from: p, reason: collision with root package name */
    public int f8124p = 0;

    /* renamed from: q, reason: collision with root package name */
    public final int f8125q = Reader.READ_DONE;

    public w1(Context context, AttributeSet attributeSet, int i, int i3) {
        int resourceId;
        s1 s1Var = new s1(1);
        s1Var.f8076f = this;
        VarHandle.storeStoreFence();
        this.f8130v = s1Var;
        v1 v1Var = new v1();
        v1Var.f8096c = this;
        VarHandle.storeStoreFence();
        this.f8131w = v1Var;
        u1 u1Var = new u1();
        u1Var.f8086a = this;
        VarHandle.storeStoreFence();
        this.f8132x = u1Var;
        s1 s1Var2 = new s1(0);
        s1Var2.f8076f = this;
        VarHandle.storeStoreFence();
        this.f8133y = s1Var2;
        this.A = new Rect();
        this.f8114c = context;
        this.f8134z = new Handler(context.getMainLooper());
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, g.a.f4111o, i, 0);
        this.f8118j = typedArrayObtainStyledAttributes.getDimensionPixelOffset(0, 0);
        int dimensionPixelOffset = typedArrayObtainStyledAttributes.getDimensionPixelOffset(1, 0);
        this.f8119k = dimensionPixelOffset;
        if (dimensionPixelOffset != 0) {
            this.f8121m = true;
        }
        typedArrayObtainStyledAttributes.recycle();
        z zVar = new z(context, attributeSet, i, 0);
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, g.a.f4115s, i, 0);
        if (typedArrayObtainStyledAttributes2.hasValue(2)) {
            zVar.setOverlapAnchor(typedArrayObtainStyledAttributes2.getBoolean(2, false));
        }
        zVar.setBackgroundDrawable((!typedArrayObtainStyledAttributes2.hasValue(0) || (resourceId = typedArrayObtainStyledAttributes2.getResourceId(0, 0)) == 0) ? typedArrayObtainStyledAttributes2.getDrawable(0) : id.k.v(resourceId, context));
        typedArrayObtainStyledAttributes2.recycle();
        this.D = zVar;
        zVar.setInputMethodMode(1);
    }

    public final int a() {
        return this.f8118j;
    }

    @Override // l.b0
    public final boolean b() {
        return this.D.isShowing();
    }

    public final void c(int i) {
        this.f8118j = i;
    }

    @Override // l.b0
    public final void dismiss() {
        this.D.dismiss();
        this.D.setContentView(null);
        this.f8116g = null;
        this.f8134z.removeCallbacks(this.f8130v);
    }

    public final Drawable e() {
        return this.D.getBackground();
    }

    @Override // l.b0
    public void f() {
        int i;
        int paddingBottom;
        j1 j1Var;
        j1 j1Var2 = this.f8116g;
        Context context = this.f8114c;
        if (j1Var2 == null) {
            j1 j1VarQ = q(context, !this.C);
            this.f8116g = j1VarQ;
            j1VarQ.setAdapter(this.f8115f);
            this.f8116g.setOnItemClickListener(this.f8128t);
            this.f8116g.setFocusable(true);
            this.f8116g.setFocusableInTouchMode(true);
            j1 j1Var3 = this.f8116g;
            p1 p1Var = new p1();
            p1Var.f8046c = this;
            VarHandle.storeStoreFence();
            j1Var3.setOnItemSelectedListener(p1Var);
            this.f8116g.setOnScrollListener(this.f8132x);
            AdapterView.OnItemSelectedListener onItemSelectedListener = this.f8129u;
            if (onItemSelectedListener != null) {
                this.f8116g.setOnItemSelectedListener(onItemSelectedListener);
            }
            this.D.setContentView(this.f8116g);
        }
        Drawable background = this.D.getBackground();
        Rect rect = this.A;
        if (background != null) {
            background.getPadding(rect);
            int i3 = rect.top;
            i = rect.bottom + i3;
            if (!this.f8121m) {
                this.f8119k = -i3;
            }
        } else {
            rect.setEmpty();
            i = 0;
        }
        int iA = q1.a(this.D, this.f8127s, this.f8119k, this.D.getInputMethodMode() == 2);
        int i10 = this.f8117h;
        if (i10 == -1) {
            paddingBottom = iA + i;
        } else {
            int i11 = this.i;
            int iA2 = this.f8116g.a(i11 != -2 ? i11 != -1 ? View.MeasureSpec.makeMeasureSpec(i11, 1073741824) : View.MeasureSpec.makeMeasureSpec(context.getResources().getDisplayMetrics().widthPixels - (rect.left + rect.right), 1073741824) : View.MeasureSpec.makeMeasureSpec(context.getResources().getDisplayMetrics().widthPixels - (rect.left + rect.right), Integer.MIN_VALUE), iA);
            paddingBottom = iA2 + (iA2 > 0 ? this.f8116g.getPaddingBottom() + this.f8116g.getPaddingTop() + i : 0);
        }
        boolean z10 = this.D.getInputMethodMode() == 2;
        this.D.setWindowLayoutType(this.f8120l);
        if (this.D.isShowing()) {
            if (this.f8127s.isAttachedToWindow()) {
                int width = this.i;
                if (width == -1) {
                    width = -1;
                } else if (width == -2) {
                    width = this.f8127s.getWidth();
                }
                if (i10 == -1) {
                    i10 = z10 ? paddingBottom : -1;
                    PopupWindow popupWindow = this.D;
                    int i12 = this.i;
                    if (z10) {
                        popupWindow.setWidth(i12 == -1 ? -1 : 0);
                        this.D.setHeight(0);
                    } else {
                        popupWindow.setWidth(i12 == -1 ? -1 : 0);
                        this.D.setHeight(-1);
                    }
                } else if (i10 == -2) {
                    i10 = paddingBottom;
                }
                this.D.setOutsideTouchable(true);
                this.D.update(this.f8127s, this.f8118j, this.f8119k, width < 0 ? -1 : width, i10 < 0 ? -1 : i10);
                return;
            }
            return;
        }
        int width2 = this.i;
        if (width2 == -1) {
            width2 = -1;
        } else if (width2 == -2) {
            width2 = this.f8127s.getWidth();
        }
        if (i10 == -1) {
            i10 = -1;
        } else if (i10 == -2) {
            i10 = paddingBottom;
        }
        this.D.setWidth(width2);
        this.D.setHeight(i10);
        r1.b(this.D, true);
        this.D.setOutsideTouchable(true);
        this.D.setTouchInterceptor(this.f8131w);
        if (this.f8123o) {
            this.D.setOverlapAnchor(this.f8122n);
        }
        r1.a(this.D, this.B);
        this.D.showAsDropDown(this.f8127s, this.f8118j, this.f8119k, this.f8124p);
        this.f8116g.setSelection(-1);
        if ((!this.C || this.f8116g.isInTouchMode()) && (j1Var = this.f8116g) != null) {
            j1Var.setListSelectionHidden(true);
            j1Var.requestLayout();
        }
        if (this.C) {
            return;
        }
        this.f8134z.post(this.f8133y);
    }

    @Override // l.b0
    public final j1 h() {
        return this.f8116g;
    }

    public final void j(Drawable drawable) {
        this.D.setBackgroundDrawable(drawable);
    }

    public final void k(int i) {
        this.f8119k = i;
        this.f8121m = true;
    }

    public final int o() {
        if (this.f8121m) {
            return this.f8119k;
        }
        return 0;
    }

    public void p(ListAdapter listAdapter) {
        t1 t1Var = this.f8126r;
        if (t1Var == null) {
            this.f8126r = new t1(this);
        } else {
            ListAdapter listAdapter2 = this.f8115f;
            if (listAdapter2 != null) {
                listAdapter2.unregisterDataSetObserver(t1Var);
            }
        }
        this.f8115f = listAdapter;
        if (listAdapter != null) {
            listAdapter.registerDataSetObserver(this.f8126r);
        }
        j1 j1Var = this.f8116g;
        if (j1Var != null) {
            j1Var.setAdapter(this.f8115f);
        }
    }

    public j1 q(Context context, boolean z10) {
        return new j1(context, z10);
    }

    public final void r(int i) {
        Drawable background = this.D.getBackground();
        if (background == null) {
            this.i = i;
            return;
        }
        Rect rect = this.A;
        background.getPadding(rect);
        this.i = rect.left + rect.right + i;
    }
}
