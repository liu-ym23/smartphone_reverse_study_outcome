package stepos.support.v7.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.appcompat.widget.a0;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class i extends LinearLayoutCompat {

    /* renamed from: A, reason: collision with root package name */
    private int f22056A;

    /* renamed from: B, reason: collision with root package name */
    private int f22057B;

    /* renamed from: C, reason: collision with root package name */
    private int f22058C;

    /* renamed from: D, reason: collision with root package name */
    private I1.f f22059D;

    /* renamed from: E, reason: collision with root package name */
    private ArrayList<a> f22060E;

    /* renamed from: p, reason: collision with root package name */
    private final TextView f22061p;

    /* renamed from: q, reason: collision with root package name */
    private final TextView f22062q;

    /* renamed from: r, reason: collision with root package name */
    private View f22063r;

    /* renamed from: s, reason: collision with root package name */
    private View f22064s;

    /* renamed from: t, reason: collision with root package name */
    private View f22065t;

    /* renamed from: u, reason: collision with root package name */
    private int f22066u;

    /* renamed from: v, reason: collision with root package name */
    private int f22067v;

    /* renamed from: w, reason: collision with root package name */
    private int f22068w;

    /* renamed from: x, reason: collision with root package name */
    private int f22069x;

    /* renamed from: y, reason: collision with root package name */
    private CharSequence f22070y;

    /* renamed from: z, reason: collision with root package name */
    private CharSequence f22071z;

    public interface a {
        void a(CharSequence charSequence);

        void b(CharSequence charSequence);
    }

    public i(Context context) {
        this(context, null);
    }

    private boolean C(int i5, int i6, int i7, int i8, boolean z5) {
        return z5 ? i6 + i5 >= i7 || i5 <= i8 : i5 <= i7 || i5 + i6 >= i8;
    }

    private void D() {
        this.f22061p.setText(this.f22070y);
        this.f22062q.setText(this.f22071z);
        boolean zIsEmpty = TextUtils.isEmpty(this.f22070y);
        boolean zIsEmpty2 = TextUtils.isEmpty(this.f22071z);
        this.f22062q.setVisibility(!zIsEmpty2 ? 0 : 8);
        this.f22065t.setVisibility((zIsEmpty && zIsEmpty2) ? 8 : 0);
    }

    protected static int F(int i5, int i6, boolean z5) {
        return z5 ? i5 - i6 : i5 + i6;
    }

    private void setBackgroundHotspotBounds(View view) {
        Drawable background = view.getBackground();
        if (background != null) {
            int paddingLeft = view.getPaddingLeft();
            int paddingRight = view.getPaddingRight();
            int width = view.getWidth();
            int i5 = ((paddingLeft - paddingRight) + width) / 2;
            int i6 = ((width - paddingLeft) - paddingRight) / 2;
            androidx.core.graphics.drawable.a.l(background, i5 - i6, 0, i5 + i6, view.getHeight());
        }
    }

    public void B(a aVar) {
        if (this.f22060E == null) {
            this.f22060E = new ArrayList<>();
        }
        this.f22060E.add(aVar);
    }

    protected int E(View view, int i5, int i6, int i7) {
        view.measure(View.MeasureSpec.makeMeasureSpec(i5, Integer.MIN_VALUE), i6);
        return view.getMeasuredWidth() + i7;
    }

    protected int G(View view, int i5, int i6, int i7, boolean z5) {
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        int i8 = i6 + ((i7 - measuredHeight) / 2);
        if (z5) {
            view.layout(i5 - measuredWidth, i8, i5, measuredHeight + i8);
        } else {
            view.layout(i5, i8, i5 + measuredWidth, measuredHeight + i8);
        }
        return z5 ? -measuredWidth : measuredWidth;
    }

    public void H(a aVar) {
        ArrayList<a> arrayList = this.f22060E;
        if (arrayList == null) {
            return;
        }
        arrayList.remove(aVar);
    }

    public void I(int i5, CharSequence charSequence, Drawable drawable, View.OnClickListener onClickListener) {
        try {
            TextView textView = (TextView) (i5 == 1 ? this.f22064s : this.f22063r);
            textView.setText(charSequence);
            if (drawable != null) {
                boolean zIsEmpty = TextUtils.isEmpty(charSequence);
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                textView.setCompoundDrawables(zIsEmpty ? drawable : null, zIsEmpty ? null : drawable, null, null);
            }
            textView.setOnClickListener(onClickListener);
            if (TextUtils.isEmpty(charSequence) && drawable == null) {
                textView.setVisibility(8);
            }
        } catch (ClassCastException unused) {
            throw new IllegalStateException("the item view of ControlTitleBar is not a TextView, please check the style of StepOSControlTitleBarStyle ");
        }
    }

    public View getNegativeItemView() {
        return this.f22063r;
    }

    public View getPositiveItemView() {
        return this.f22064s;
    }

    public CharSequence getSubTitle() {
        return this.f22071z;
    }

    public CharSequence getTitle() {
        return this.f22070y;
    }

    public TextView getTitleView() {
        return this.f22061p;
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z5, int i5, int i6, int i7, int i8) {
        int paddingRight;
        int i9;
        int paddingLeft;
        boolean zM = C.m(this);
        int paddingRight2 = zM ? (i7 - i5) - getPaddingRight() : getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingTop2 = ((i8 - i6) - getPaddingTop()) - getPaddingBottom();
        View view = this.f22063r;
        if (view == null || view.getVisibility() == 8) {
            paddingRight = zM ? (i7 - i5) - getPaddingRight() : getPaddingLeft();
        } else {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f22063r.getLayoutParams();
            int i10 = zM ? marginLayoutParams.rightMargin : marginLayoutParams.leftMargin;
            int i11 = zM ? marginLayoutParams.leftMargin : marginLayoutParams.rightMargin;
            int iF = F(paddingRight2, i10, zM);
            paddingRight = F(iF + G(this.f22063r, iF, paddingTop, paddingTop2, zM), i11, zM);
            setBackgroundHotspotBounds(this.f22063r);
        }
        int i12 = paddingRight;
        int paddingLeft2 = zM ? getPaddingLeft() : (i7 - i5) - getPaddingRight();
        View view2 = this.f22064s;
        if (view2 == null || view2.getVisibility() == 8) {
            i9 = paddingTop;
            paddingLeft = zM ? getPaddingLeft() : (i7 - i5) - getPaddingRight();
        } else {
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.f22064s.getLayoutParams();
            int i13 = zM ? marginLayoutParams2.rightMargin : marginLayoutParams2.leftMargin;
            int iF2 = F(paddingLeft2, zM ? marginLayoutParams2.leftMargin : marginLayoutParams2.rightMargin, !zM);
            i9 = paddingTop;
            paddingLeft = F(iF2 + G(this.f22064s, iF2, i9, paddingTop2, !zM), i13, !zM);
            setBackgroundHotspotBounds(this.f22064s);
        }
        int i14 = paddingLeft;
        View view3 = this.f22065t;
        if (view3 == null || view3.getVisibility() == 8) {
            return;
        }
        int measuredWidth = this.f22065t.getMeasuredWidth();
        int i15 = (this.f22056A & 7) == 1 ? ((i7 - i5) - measuredWidth) / 2 : 0;
        if (C(i15, measuredWidth, i12, i14, zM)) {
            G(this.f22065t, i12, i9, paddingTop2, zM);
        } else {
            G(this.f22065t, i15, i9, paddingTop2, false);
        }
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.View
    protected void onMeasure(int i5, int i6) {
        View view;
        int iE;
        int i7;
        int i8;
        int size = View.MeasureSpec.getSize(i5);
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i6) - paddingTop, Integer.MIN_VALUE);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f22064s.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.f22063r.getLayoutParams();
        View view2 = this.f22063r;
        int iE2 = (view2 == null || view2.getVisibility() == 8) ? 0 : E(this.f22063r, paddingLeft, iMakeMeasureSpec, 0) + marginLayoutParams2.leftMargin + marginLayoutParams2.rightMargin;
        View view3 = this.f22064s;
        int iE3 = (view3 == null || view3.getVisibility() == 8) ? 0 : E(this.f22064s, paddingLeft, iMakeMeasureSpec, 0) + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin;
        View view4 = this.f22063r;
        if (view4 != null && (view = this.f22064s) != null && iE2 + iE3 > paddingLeft) {
            if (iE2 < iE3) {
                int i9 = paddingLeft / 2;
                if (iE2 <= i9) {
                    iE3 = marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + E(view, ((paddingLeft - iE2) - marginLayoutParams.leftMargin) - marginLayoutParams.rightMargin, iMakeMeasureSpec, 0);
                } else {
                    int iE4 = E(view, (i9 - marginLayoutParams.leftMargin) - marginLayoutParams.rightMargin, iMakeMeasureSpec, 0) + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin;
                    iE2 = E(this.f22063r, (i9 - marginLayoutParams2.leftMargin) - marginLayoutParams2.rightMargin, iMakeMeasureSpec, 0) + marginLayoutParams2.leftMargin + marginLayoutParams2.rightMargin;
                    iE3 = iE4;
                }
            } else {
                int i10 = paddingLeft / 2;
                if (iE3 <= i10) {
                    iE = E(view4, ((paddingLeft - iE3) - marginLayoutParams2.leftMargin) - marginLayoutParams2.rightMargin, iMakeMeasureSpec, 0);
                    i7 = marginLayoutParams2.leftMargin;
                    i8 = marginLayoutParams2.rightMargin;
                } else {
                    iE3 = E(view, (i10 - marginLayoutParams.leftMargin) - marginLayoutParams.rightMargin, iMakeMeasureSpec, 0) + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin;
                    iE = E(this.f22063r, (i10 - marginLayoutParams2.leftMargin) - marginLayoutParams2.rightMargin, iMakeMeasureSpec, 0);
                    i7 = marginLayoutParams2.leftMargin;
                    i8 = marginLayoutParams2.rightMargin;
                }
                iE2 = i7 + i8 + iE;
            }
        }
        if (this.f22063r != null) {
            paddingLeft -= iE2;
        }
        if (this.f22064s != null) {
            paddingLeft -= iE3;
        }
        if (paddingLeft <= this.f22058C) {
            paddingLeft = 0;
        }
        View view5 = this.f22065t;
        if (view5 != null) {
            E(view5, paddingLeft, iMakeMeasureSpec, 0);
        }
        int childCount = getChildCount();
        int i11 = 0;
        for (int i12 = 0; i12 < childCount; i12++) {
            int measuredHeight = getChildAt(i12).getMeasuredHeight() + paddingTop;
            if (measuredHeight > i11) {
                i11 = measuredHeight;
            }
        }
        setMeasuredDimension(size, i11);
    }

    public void setItemMaxWidth(int i5) {
        this.f22057B = i5;
    }

    public void setOnNegativeItemClickListener(View.OnClickListener onClickListener) {
        View view = this.f22063r;
        if (view != null) {
            view.setOnClickListener(onClickListener);
        }
    }

    public void setOnPositiveItemClickListener(View.OnClickListener onClickListener) {
        View view = this.f22064s;
        if (view != null) {
            view.setOnClickListener(onClickListener);
        }
    }

    public void setSubTitle(CharSequence charSequence) {
        if (TextUtils.equals(this.f22071z, charSequence)) {
            return;
        }
        this.f22071z = charSequence;
        D();
        ArrayList<a> arrayList = this.f22060E;
        if (arrayList != null) {
            int size = arrayList.size();
            int i5 = 0;
            while (i5 < size) {
                a aVar = arrayList.get(i5);
                i5++;
                aVar.a(this.f22071z);
            }
        }
    }

    public void setTitle(CharSequence charSequence) {
        if (TextUtils.equals(this.f22070y, charSequence)) {
            return;
        }
        this.f22070y = charSequence;
        D();
        ArrayList<a> arrayList = this.f22060E;
        if (arrayList != null) {
            int size = arrayList.size();
            int i5 = 0;
            while (i5 < size) {
                a aVar = arrayList.get(i5);
                i5++;
                aVar.b(this.f22070y);
            }
        }
    }

    public void setTitleColor(int i5) {
        TextView textView = this.f22061p;
        if (textView == null || TextUtils.isEmpty(textView.getText())) {
            return;
        }
        this.f22061p.setTextColor(i5);
    }

    public i(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, X4.a.f5844t);
    }

    public i(Context context, AttributeSet attributeSet, int i5) {
        super(context, attributeSet, i5);
        this.f22056A = 17;
        this.f22059D = new I1.f();
        a0 a0VarV = a0.v(context, attributeSet, X4.l.f6195T3, i5, 0);
        this.f22068w = a0VarV.n(X4.l.f6219X3, 0);
        this.f22069x = a0VarV.n(X4.l.f6213W3, 0);
        this.f22066u = a0VarV.n(X4.l.f6201U3, X4.h.f6040l);
        this.f22067v = a0VarV.n(X4.l.f6207V3, X4.h.f6041m);
        a0VarV.x();
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(context);
        this.f22058C = getResources().getDimensionPixelSize(X4.d.f5890a);
        View viewInflate = layoutInflaterFrom.inflate(this.f22066u, (ViewGroup) this, false);
        this.f22063r = viewInflate;
        addView(viewInflate);
        View viewInflate2 = layoutInflaterFrom.inflate(this.f22067v, (ViewGroup) this, false);
        this.f22064s = viewInflate2;
        addView(viewInflate2);
        this.f22059D.f(this.f22063r, false, I1.f.f2929e | I1.f.f2931g);
        this.f22059D.f(this.f22064s, false, I1.f.f2929e | I1.f.f2931g);
        View viewInflate3 = layoutInflaterFrom.inflate(X4.h.f6037i, (ViewGroup) this, false);
        this.f22065t = viewInflate3;
        addView(viewInflate3);
        TextView textView = (TextView) this.f22065t.findViewById(X4.f.f5989f);
        this.f22061p = textView;
        TextView textView2 = (TextView) this.f22065t.findViewById(X4.f.f5987e);
        this.f22062q = textView2;
        if (this.f22068w != 0) {
            textView.setTextAppearance(getContext(), this.f22068w);
        }
        if (this.f22069x != 0) {
            textView2.setTextAppearance(getContext(), this.f22069x);
        }
        this.f22057B = (int) (getResources().getDisplayMetrics().density * 104.0f);
    }
}
