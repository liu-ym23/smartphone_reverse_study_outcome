package stepos.support.v7.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.a0;
import androidx.core.view.T;
import stepos.support.v7.app.a;
import stepos.support.v7.widget.y;

/* loaded from: classes.dex */
public class w extends ViewGroup {

    /* renamed from: a, reason: collision with root package name */
    private boolean f22264a;

    /* renamed from: b, reason: collision with root package name */
    private v f22265b;

    /* renamed from: c, reason: collision with root package name */
    private y f22266c;

    /* renamed from: d, reason: collision with root package name */
    private Context f22267d;

    /* renamed from: e, reason: collision with root package name */
    private int f22268e;

    /* renamed from: f, reason: collision with root package name */
    private int f22269f;

    /* renamed from: g, reason: collision with root package name */
    private final Paint f22270g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f22271h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f22272i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f22273j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f22274k;

    /* renamed from: l, reason: collision with root package name */
    private Drawable f22275l;

    /* renamed from: m, reason: collision with root package name */
    private TextView f22276m;

    /* renamed from: n, reason: collision with root package name */
    private int f22277n;

    /* renamed from: o, reason: collision with root package name */
    private int f22278o;

    /* renamed from: p, reason: collision with root package name */
    private boolean f22279p;

    /* renamed from: q, reason: collision with root package name */
    private boolean f22280q;

    /* renamed from: r, reason: collision with root package name */
    private T f22281r;

    class a implements T {
        a() {
        }

        @Override // androidx.core.view.T
        public void c(View view) {
        }

        @Override // androidx.core.view.T
        public void d(View view) {
            w.a(w.this);
        }

        @Override // androidx.core.view.T
        public void e(View view) {
            w.a(w.this);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public w(Context context) throws Resources.NotFoundException {
        int i5 = X4.a.f5833i;
        super(context, null, i5);
        this.f22272i = false;
        this.f22273j = false;
        this.f22274k = true;
        this.f22281r = new a();
        a0 a0VarV = a0.v(context, null, X4.l.f6111F3, i5, 0);
        this.f22264a = a0VarV.a(X4.l.f6117G3, false);
        a0VarV.x();
        a0 a0VarV2 = a0.v(context, null, X4.l.f6123H3, X4.a.f5834j, 0);
        this.f22269f = a0VarV2.b(X4.l.f6171P3, getResources().getColor(X4.c.f5856b));
        this.f22268e = a0VarV2.f(X4.l.f6177Q3, getResources().getDimensionPixelSize(X4.d.f5912l));
        this.f22278o = a0VarV2.b(X4.l.f6147L3, getResources().getColor(H1.e.f2078F));
        this.f22277n = a0VarV2.n(X4.l.f6153M3, X4.k.f6073a);
        a0VarV2.x();
        this.f22267d = context;
        Paint paint = new Paint();
        this.f22270g = paint;
        paint.setColor(this.f22269f);
        int dimensionPixelSize = getResources().getDimensionPixelSize(X4.d.f5865B);
        setPadding(dimensionPixelSize, 0, dimensionPixelSize, 0);
    }

    static /* synthetic */ a.h a(w wVar) {
        wVar.getClass();
        return null;
    }

    private void b() {
        if (this.f22266c == null) {
            this.f22266c = new y(this.f22267d);
        }
        if (this.f22266c.getParent() != this) {
            addView(this.f22266c);
            ViewGroup.LayoutParams layoutParams = this.f22266c.getLayoutParams();
            layoutParams.width = -2;
            layoutParams.height = -1;
        }
        this.f22266c.setOnTabCollapseButtonClickListener(null);
        Drawable drawable = this.f22275l;
        if (drawable != null) {
            this.f22266c.setImageDrawable(drawable);
        }
        this.f22266c.setVisibility(0);
        if (this.f22273j) {
            this.f22266c.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        } else {
            setPadding(getResources().getDimensionPixelSize(X4.d.f5865B), 0, 0, 0);
            this.f22266c.setScaleType(ImageView.ScaleType.MATRIX);
        }
        if (this.f22280q) {
            this.f22266c.setImageDrawable(getContext().getDrawable(X4.e.f5952z));
            this.f22266c.setPadding((int) N1.i.a(16.0f, getContext()), 0, (int) N1.i.a(16.0f, getContext()), 0);
            this.f22266c.setScaleType(ImageView.ScaleType.CENTER);
        }
    }

    private void c() throws Resources.NotFoundException {
        y yVar = this.f22266c;
        if (yVar != null) {
            yVar.setVisibility(8);
        }
        TextView textView = this.f22276m;
        if (textView != null) {
            textView.setVisibility(8);
        }
        if (this.f22273j) {
            setPadding(0, 0, 0, 0);
        } else {
            int dimensionPixelSize = getResources().getDimensionPixelSize(X4.d.f5865B);
            setPadding(dimensionPixelSize, 0, dimensionPixelSize, 0);
        }
    }

    private void d(View view, int i5, boolean z5, boolean z6) {
        b bVar = (b) view.getLayoutParams();
        int i6 = z5 ? ((ViewGroup.MarginLayoutParams) bVar).rightMargin : ((ViewGroup.MarginLayoutParams) bVar).leftMargin;
        int i7 = z5 ? ((ViewGroup.MarginLayoutParams) bVar).leftMargin : ((ViewGroup.MarginLayoutParams) bVar).rightMargin;
        int paddingTop = getPaddingTop();
        int measuredHeight = getMeasuredHeight() - getPaddingBottom();
        int measuredWidth = z5 ? (i5 - i7) - view.getMeasuredWidth() : i5 + i6;
        int i8 = bVar.f22283a;
        if (i8 == -1) {
            i8 = 8388659;
        }
        int i9 = i8 & 112;
        int measuredHeight2 = view.getMeasuredHeight();
        int measuredHeight3 = i9 != 48 ? i9 != 80 ? ((paddingTop + (((measuredHeight - paddingTop) - measuredHeight2) / 2)) + ((ViewGroup.MarginLayoutParams) bVar).topMargin) - ((ViewGroup.MarginLayoutParams) bVar).bottomMargin : (measuredHeight - measuredHeight2) - ((ViewGroup.MarginLayoutParams) bVar).bottomMargin : paddingTop + ((ViewGroup.MarginLayoutParams) bVar).topMargin;
        if (z6) {
            measuredHeight3 = (getMeasuredHeight() - view.getMeasuredHeight()) / 2;
        }
        view.layout(measuredWidth, measuredHeight3, view.getMeasuredWidth() + measuredWidth, measuredHeight2 + measuredHeight3);
    }

    private boolean e(View view) {
        return (view == null || view.getParent() != this || view.getVisibility() == 8) ? false : true;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) throws Resources.NotFoundException {
        super.draw(canvas);
        if (this.f22273j || this.f22268e <= 0) {
            return;
        }
        canvas.drawRect(getResources().getDimensionPixelSize(X4.d.f5864A), 0.0f, getMeasuredWidth() - r0, this.f22268e, this.f22270g);
    }

    public void f(boolean z5) {
        this.f22265b.L(z5);
        if (this.f22273j != z5) {
            this.f22273j = z5;
            if (!z5) {
                TextView textView = this.f22276m;
                if (textView == null || textView.getLayoutParams() == null) {
                    return;
                }
                ((b) this.f22276m.getLayoutParams()).f22283a = 48;
                return;
            }
            setPadding(0, 0, 0, 0);
            TextView textView2 = this.f22276m;
            if (textView2 == null || textView2.getLayoutParams() == null) {
                return;
            }
            ((b) this.f22276m.getLayoutParams()).f22283a = 16;
        }
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new b(-1, -2);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new b(getContext(), attributeSet);
    }

    int getContentStart() {
        return getPaddingStart() + this.f22265b.getContentStart();
    }

    public v getTabView() {
        return this.f22265b;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z5, int i5, int i6, int i7, int i8) {
        boolean zM = C.m(this);
        int paddingRight = zM ? (i7 - i5) - getPaddingRight() : getPaddingLeft();
        if (e(this.f22265b)) {
            d(this.f22265b, paddingRight, zM, false);
        }
        if (e(this.f22276m)) {
            d(this.f22276m, paddingRight, zM, true);
        }
        if (e(this.f22266c)) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f22266c.getLayoutParams();
            int paddingLeft = zM ? getPaddingLeft() + (zM ? marginLayoutParams.rightMargin : marginLayoutParams.leftMargin) : ((getMeasuredWidth() - getPaddingRight()) - (zM ? marginLayoutParams.leftMargin : marginLayoutParams.rightMargin)) - this.f22266c.getMeasuredWidth();
            y yVar = this.f22266c;
            yVar.layout(paddingLeft, 0, yVar.getMeasuredWidth() + paddingLeft, this.f22266c.getMeasuredHeight());
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i5, int i6) throws Resources.NotFoundException {
        int measuredHeight;
        int measuredWidth;
        if (View.MeasureSpec.getMode(i6) == 0) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used with android:layout_height=\"wrap_content\"");
        }
        int size = View.MeasureSpec.getSize(i5);
        int paddingTop = getPaddingTop() + getPaddingBottom();
        boolean z5 = false;
        int dimensionPixelSize = !this.f22273j ? getResources().getDimensionPixelSize(X4.d.f5865B) : 0;
        boolean z6 = true;
        if (this.f22272i) {
            this.f22265b.setEqualTabWidth(false);
        } else if (!this.f22274k) {
            this.f22265b.setEqualTabWidth(true);
        }
        if (e(this.f22265b)) {
            this.f22265b.setNeedCollapse(false);
            int i7 = dimensionPixelSize * 2;
            this.f22265b.measure(View.MeasureSpec.makeMeasureSpec(size - i7, View.MeasureSpec.getMode(i5)), i6);
            if (!this.f22264a || (size >= this.f22265b.getTabStripWidth() + i7 && !this.f22272i)) {
                z6 = false;
            } else {
                z5 = true;
            }
            measuredHeight = this.f22265b.getMeasuredHeight();
        } else {
            measuredHeight = 0;
            z6 = false;
        }
        if (z5 != this.f22271h) {
            if (z5) {
                b();
            } else {
                c();
            }
            this.f22271h = z5;
        }
        if (!this.f22279p) {
            if (z5) {
                this.f22265b.setTabsGravity(3);
            } else {
                this.f22265b.setTabsGravity(17);
            }
        }
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(measuredHeight, Integer.MIN_VALUE);
        if (e(this.f22266c)) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f22266c.getLayoutParams();
            this.f22266c.measure(View.MeasureSpec.makeMeasureSpec(size, Integer.MIN_VALUE), ViewGroup.getChildMeasureSpec(View.MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824), getPaddingTop() + getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin, marginLayoutParams.height));
            measuredWidth = size - ((this.f22266c.getMeasuredWidth() + getPaddingLeft()) + getPaddingRight());
        } else {
            measuredWidth = size;
        }
        if (e(this.f22276m)) {
            this.f22276m.measure(View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824), iMakeMeasureSpec);
        }
        if (z6 && e(this.f22265b)) {
            this.f22265b.setNeedCollapse(z5);
            this.f22265b.measure(View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824), iMakeMeasureSpec);
        }
        setMeasuredDimension(size, measuredHeight + paddingTop);
    }

    public void setAdaptTabWidth(boolean z5) {
        v vVar = this.f22265b;
        if (vVar != null) {
            vVar.setAdaptTabWidthNoScroll(z5);
        }
    }

    public void setAllowCollapse(boolean z5) {
        if (this.f22264a != z5) {
            this.f22264a = z5;
            requestLayout();
        }
    }

    public void setCapsuleStyleEnable(boolean z5) {
        this.f22280q = z5;
    }

    public void setCollapseButtonClickListener(y.b bVar) {
        y yVar = this.f22266c;
        if (yVar != null) {
            yVar.setOnTabCollapseButtonClickListener(bVar);
        }
    }

    public void setCollapseButtonDrawable(Drawable drawable) {
        this.f22275l = drawable;
        y yVar = this.f22266c;
        if (yVar == null || drawable == null) {
            return;
        }
        yVar.setImageDrawable(drawable);
    }

    public void setIsForceCollapse(boolean z5) {
        if (this.f22272i != z5) {
            this.f22272i = z5;
            requestLayout();
        }
    }

    public void setPreventEqualWidth(boolean z5) {
        this.f22274k = z5;
    }

    public void setScrollTabsExpendTitle(CharSequence charSequence) throws Resources.NotFoundException {
        if (TextUtils.isEmpty(charSequence)) {
            TextView textView = this.f22276m;
            if (textView != null) {
                removeView(textView);
                this.f22276m = null;
            }
        } else if (this.f22276m == null) {
            Context context = getContext();
            TextView textView2 = new TextView(context);
            this.f22276m = textView2;
            textView2.setSingleLine();
            this.f22276m.setEllipsize(TextUtils.TruncateAt.END);
            this.f22276m.setMaxWidth(context.getResources().getDimensionPixelSize(X4.d.f5909j0));
            int i5 = this.f22277n;
            if (i5 != 0) {
                this.f22276m.setTextAppearance(context, i5);
            }
            int i6 = this.f22278o;
            if (i6 != 0) {
                this.f22276m.setTextColor(i6);
            }
            this.f22276m.setVisibility(8);
            addView(this.f22276m);
            int dimensionPixelSize = getResources().getDimensionPixelSize(X4.d.f5891a0);
            this.f22276m.setPadding(getResources().getDimensionPixelSize(X4.d.f5889Z), dimensionPixelSize, 0, dimensionPixelSize);
            b bVar = (b) this.f22276m.getLayoutParams();
            if (this.f22273j) {
                bVar.f22283a = 16;
            } else {
                bVar.f22283a = 48;
            }
        }
        TextView textView3 = this.f22276m;
        if (textView3 != null) {
            textView3.setText(charSequence);
        }
    }

    public void setScrollTabsExpendTitleTextAppearance(int i5) {
        this.f22277n = i5;
        if (this.f22276m != null) {
            this.f22276m.setTextAppearance(getContext(), i5);
        }
    }

    public void setScrollTabsExpendTitleTextColor(int i5) {
        this.f22278o = i5;
        TextView textView = this.f22276m;
        if (textView != null) {
            textView.setTextColor(i5);
        }
    }

    public void setTabView(v vVar) {
        v vVar2 = this.f22265b;
        if (vVar2 == vVar && vVar2.getParent() == this) {
            return;
        }
        v vVar3 = this.f22265b;
        if (vVar3 != null) {
            removeView(vVar3);
        }
        this.f22265b = vVar;
        if (vVar != null) {
            addView(vVar);
            vVar.setAllowCollapse(false);
        }
    }

    public void setTabsContentHeight(int i5) {
        v vVar = this.f22265b;
        if (vVar != null) {
            vVar.setContentHeight(i5);
        }
    }

    public void setTabsGravity(int i5) {
        this.f22279p = true;
        v vVar = this.f22265b;
        if (vVar != null) {
            vVar.setTabsGravity(i5);
        }
    }

    public static class b extends ViewGroup.MarginLayoutParams {

        /* renamed from: a, reason: collision with root package name */
        public int f22283a;

        public b(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f22283a = 16;
        }

        public b(int i5, int i6) {
            super(i5, i6);
            this.f22283a = 16;
        }
    }
}
