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
import androidx.appcompat.widget.U;
import java.util.ArrayList;
import java.util.Iterator;
import stepos.support.v7.appcompat.R$attr;
import stepos.support.v7.appcompat.R$dimen;
import stepos.support.v7.appcompat.R$id;
import stepos.support.v7.appcompat.R$layout;
import stepos.support.v7.appcompat.R$styleable;
import u0.C5566a;

/* loaded from: classes5.dex */
public class h extends LinearLayoutCompat {

    /* renamed from: a, reason: collision with root package name */
    public final TextView f41625a;

    /* renamed from: b, reason: collision with root package name */
    public final TextView f41626b;

    /* renamed from: c, reason: collision with root package name */
    public View f41627c;

    /* renamed from: d, reason: collision with root package name */
    public View f41628d;

    /* renamed from: e, reason: collision with root package name */
    public View f41629e;

    /* renamed from: f, reason: collision with root package name */
    public int f41630f;

    /* renamed from: g, reason: collision with root package name */
    public int f41631g;

    /* renamed from: h, reason: collision with root package name */
    public int f41632h;

    /* renamed from: i, reason: collision with root package name */
    public int f41633i;

    /* renamed from: j, reason: collision with root package name */
    public CharSequence f41634j;

    /* renamed from: k, reason: collision with root package name */
    public CharSequence f41635k;

    /* renamed from: l, reason: collision with root package name */
    public int f41636l;

    /* renamed from: m, reason: collision with root package name */
    public int f41637m;

    /* renamed from: n, reason: collision with root package name */
    public int f41638n;

    /* renamed from: o, reason: collision with root package name */
    public com.stepos.common.animator.f f41639o;

    /* renamed from: p, reason: collision with root package name */
    public ArrayList<a> f41640p;

    public interface a {
        void a(CharSequence charSequence);

        void b(CharSequence charSequence);
    }

    public h(Context context) {
        this(context, null);
    }

    public static int k(int i10, int i11, boolean z10) {
        return z10 ? i10 - i11 : i10 + i11;
    }

    private void setBackgroundHotspotBounds(View view) {
        Drawable background = view.getBackground();
        if (background != null) {
            int paddingLeft = view.getPaddingLeft();
            int paddingRight = view.getPaddingRight();
            int width = view.getWidth();
            int i10 = ((paddingLeft - paddingRight) + width) / 2;
            int i11 = ((width - paddingLeft) - paddingRight) / 2;
            C5566a.l(background, i10 - i11, 0, i10 + i11, view.getHeight());
        }
    }

    public void g(a aVar) {
        if (this.f41640p == null) {
            this.f41640p = new ArrayList<>();
        }
        this.f41640p.add(aVar);
    }

    public View getNegativeItemView() {
        return this.f41627c;
    }

    public View getPositiveItemView() {
        return this.f41628d;
    }

    public CharSequence getSubTitle() {
        return this.f41635k;
    }

    public CharSequence getTitle() {
        return this.f41634j;
    }

    public TextView getTitleView() {
        return this.f41625a;
    }

    public final boolean h(int i10, int i11, int i12, int i13, boolean z10) {
        return z10 ? i11 + i10 >= i12 || i10 <= i13 : i10 <= i12 || i10 + i11 >= i13;
    }

    public final void i() {
        this.f41625a.setText(this.f41634j);
        this.f41626b.setText(this.f41635k);
        boolean zIsEmpty = TextUtils.isEmpty(this.f41634j);
        boolean zIsEmpty2 = TextUtils.isEmpty(this.f41635k);
        this.f41626b.setVisibility(!zIsEmpty2 ? 0 : 8);
        this.f41629e.setVisibility((zIsEmpty && zIsEmpty2) ? 8 : 0);
    }

    public int j(View view, int i10, int i11, int i12) {
        view.measure(View.MeasureSpec.makeMeasureSpec(i10, Integer.MIN_VALUE), i11);
        return view.getMeasuredWidth() + i12;
    }

    public int l(View view, int i10, int i11, int i12, boolean z10) {
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        int i13 = i11 + ((i12 - measuredHeight) / 2);
        if (z10) {
            view.layout(i10 - measuredWidth, i13, i10, measuredHeight + i13);
        } else {
            view.layout(i10, i13, i10 + measuredWidth, measuredHeight + i13);
        }
        return z10 ? -measuredWidth : measuredWidth;
    }

    public void m(a aVar) {
        ArrayList<a> arrayList = this.f41640p;
        if (arrayList == null) {
            return;
        }
        arrayList.remove(aVar);
    }

    public void n(int i10, CharSequence charSequence, Drawable drawable, View.OnClickListener onClickListener) {
        try {
            TextView textView = (TextView) (i10 == 1 ? this.f41628d : this.f41627c);
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

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        int paddingRight;
        int i14;
        int paddingLeft;
        boolean zM = y.m(this);
        int paddingRight2 = zM ? (i12 - i10) - getPaddingRight() : getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingTop2 = ((i13 - i11) - getPaddingTop()) - getPaddingBottom();
        View view = this.f41627c;
        if (view == null || view.getVisibility() == 8) {
            paddingRight = zM ? (i12 - i10) - getPaddingRight() : getPaddingLeft();
        } else {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f41627c.getLayoutParams();
            int i15 = zM ? marginLayoutParams.rightMargin : marginLayoutParams.leftMargin;
            int i16 = zM ? marginLayoutParams.leftMargin : marginLayoutParams.rightMargin;
            int iK = k(paddingRight2, i15, zM);
            paddingRight = k(iK + l(this.f41627c, iK, paddingTop, paddingTop2, zM), i16, zM);
            setBackgroundHotspotBounds(this.f41627c);
        }
        int i17 = paddingRight;
        int paddingLeft2 = zM ? getPaddingLeft() : (i12 - i10) - getPaddingRight();
        View view2 = this.f41628d;
        if (view2 == null || view2.getVisibility() == 8) {
            i14 = paddingTop;
            paddingLeft = zM ? getPaddingLeft() : (i12 - i10) - getPaddingRight();
        } else {
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.f41628d.getLayoutParams();
            int i18 = zM ? marginLayoutParams2.rightMargin : marginLayoutParams2.leftMargin;
            int iK2 = k(paddingLeft2, zM ? marginLayoutParams2.leftMargin : marginLayoutParams2.rightMargin, !zM);
            i14 = paddingTop;
            paddingLeft = k(iK2 + l(this.f41628d, iK2, i14, paddingTop2, !zM), i18, !zM);
            setBackgroundHotspotBounds(this.f41628d);
        }
        int i19 = paddingLeft;
        View view3 = this.f41629e;
        if (view3 == null || view3.getVisibility() == 8) {
            return;
        }
        int measuredWidth = this.f41629e.getMeasuredWidth();
        int i20 = (this.f41636l & 7) == 1 ? ((i12 - i10) - measuredWidth) / 2 : 0;
        if (h(i20, measuredWidth, i17, i19, zM)) {
            l(this.f41629e, i17, i14, paddingTop2, zM);
        } else {
            l(this.f41629e, i20, i14, paddingTop2, false);
        }
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.View
    public void onMeasure(int i10, int i11) {
        View view;
        int iJ;
        int i12;
        int i13;
        int size = View.MeasureSpec.getSize(i10);
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i11) - paddingTop, Integer.MIN_VALUE);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f41628d.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.f41627c.getLayoutParams();
        View view2 = this.f41627c;
        int iJ2 = (view2 == null || view2.getVisibility() == 8) ? 0 : j(this.f41627c, paddingLeft, iMakeMeasureSpec, 0) + marginLayoutParams2.leftMargin + marginLayoutParams2.rightMargin;
        View view3 = this.f41628d;
        int iJ3 = (view3 == null || view3.getVisibility() == 8) ? 0 : j(this.f41628d, paddingLeft, iMakeMeasureSpec, 0) + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin;
        View view4 = this.f41627c;
        if (view4 != null && (view = this.f41628d) != null && iJ2 + iJ3 > paddingLeft) {
            if (iJ2 < iJ3) {
                int i14 = paddingLeft / 2;
                if (iJ2 <= i14) {
                    iJ3 = marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + j(view, ((paddingLeft - iJ2) - marginLayoutParams.leftMargin) - marginLayoutParams.rightMargin, iMakeMeasureSpec, 0);
                } else {
                    int iJ4 = j(view, (i14 - marginLayoutParams.leftMargin) - marginLayoutParams.rightMargin, iMakeMeasureSpec, 0) + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin;
                    iJ2 = j(this.f41627c, (i14 - marginLayoutParams2.leftMargin) - marginLayoutParams2.rightMargin, iMakeMeasureSpec, 0) + marginLayoutParams2.leftMargin + marginLayoutParams2.rightMargin;
                    iJ3 = iJ4;
                }
            } else {
                int i15 = paddingLeft / 2;
                if (iJ3 <= i15) {
                    iJ = j(view4, ((paddingLeft - iJ3) - marginLayoutParams2.leftMargin) - marginLayoutParams2.rightMargin, iMakeMeasureSpec, 0);
                    i12 = marginLayoutParams2.leftMargin;
                    i13 = marginLayoutParams2.rightMargin;
                } else {
                    iJ3 = j(view, (i15 - marginLayoutParams.leftMargin) - marginLayoutParams.rightMargin, iMakeMeasureSpec, 0) + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin;
                    iJ = j(this.f41627c, (i15 - marginLayoutParams2.leftMargin) - marginLayoutParams2.rightMargin, iMakeMeasureSpec, 0);
                    i12 = marginLayoutParams2.leftMargin;
                    i13 = marginLayoutParams2.rightMargin;
                }
                iJ2 = i12 + i13 + iJ;
            }
        }
        if (this.f41627c != null) {
            paddingLeft -= iJ2;
        }
        if (this.f41628d != null) {
            paddingLeft -= iJ3;
        }
        if (paddingLeft <= this.f41638n) {
            paddingLeft = 0;
        }
        View view5 = this.f41629e;
        if (view5 != null) {
            j(view5, paddingLeft, iMakeMeasureSpec, 0);
        }
        int childCount = getChildCount();
        int i16 = 0;
        for (int i17 = 0; i17 < childCount; i17++) {
            int measuredHeight = getChildAt(i17).getMeasuredHeight() + paddingTop;
            if (measuredHeight > i16) {
                i16 = measuredHeight;
            }
        }
        setMeasuredDimension(size, i16);
    }

    public void setItemMaxWidth(int i10) {
        this.f41637m = i10;
    }

    public void setOnNegativeItemClickListener(View.OnClickListener onClickListener) {
        View view = this.f41627c;
        if (view != null) {
            view.setOnClickListener(onClickListener);
        }
    }

    public void setOnPositiveItemClickListener(View.OnClickListener onClickListener) {
        View view = this.f41628d;
        if (view != null) {
            view.setOnClickListener(onClickListener);
        }
    }

    public void setSubTitle(CharSequence charSequence) {
        if (TextUtils.equals(this.f41635k, charSequence)) {
            return;
        }
        this.f41635k = charSequence;
        i();
        ArrayList<a> arrayList = this.f41640p;
        if (arrayList != null) {
            Iterator<a> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().a(this.f41635k);
            }
        }
    }

    public void setTitle(CharSequence charSequence) {
        if (TextUtils.equals(this.f41634j, charSequence)) {
            return;
        }
        this.f41634j = charSequence;
        i();
        ArrayList<a> arrayList = this.f41640p;
        if (arrayList != null) {
            Iterator<a> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().b(this.f41634j);
            }
        }
    }

    public void setTitleColor(int i10) {
        TextView textView = this.f41625a;
        if (textView == null || TextUtils.isEmpty(textView.getText())) {
            return;
        }
        this.f41625a.setTextColor(i10);
    }

    public h(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.steposControlTitleBarStyle);
    }

    public h(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f41636l = 17;
        this.f41639o = new com.stepos.common.animator.f();
        U uV = U.v(context, attributeSet, R$styleable.StepOSControlTitleBar, i10, 0);
        this.f41632h = uV.n(R$styleable.StepOSControlTitleBar_titleTextStyle, 0);
        this.f41633i = uV.n(R$styleable.StepOSControlTitleBar_subtitleTextStyle, 0);
        this.f41630f = uV.n(R$styleable.StepOSControlTitleBar_steposNegativeButtonLayout, R$layout.stepos_control_title_bar_negative_item);
        this.f41631g = uV.n(R$styleable.StepOSControlTitleBar_steposPositiveButtonLayout, R$layout.stepos_control_title_bar_positive_item);
        uV.x();
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(context);
        this.f41638n = getResources().getDimensionPixelSize(R$dimen.stepos_action_bar_control_title_bar_min_title_width);
        View viewInflate = layoutInflaterFrom.inflate(this.f41630f, (ViewGroup) this, false);
        this.f41627c = viewInflate;
        addView(viewInflate);
        View viewInflate2 = layoutInflaterFrom.inflate(this.f41631g, (ViewGroup) this, false);
        this.f41628d = viewInflate2;
        addView(viewInflate2);
        this.f41639o.f(this.f41627c, false, com.stepos.common.animator.f.CUSTOM_PRESS_EFFECT_SCALE | com.stepos.common.animator.f.CUSTOM_PRESS_EFFECT_ALPHA);
        this.f41639o.f(this.f41628d, false, com.stepos.common.animator.f.CUSTOM_PRESS_EFFECT_SCALE | com.stepos.common.animator.f.CUSTOM_PRESS_EFFECT_ALPHA);
        View viewInflate3 = layoutInflaterFrom.inflate(R$layout.stepos_action_bar_title_item, (ViewGroup) this, false);
        this.f41629e = viewInflate3;
        addView(viewInflate3);
        TextView textView = (TextView) this.f41629e.findViewById(R$id.action_bar_title);
        this.f41625a = textView;
        TextView textView2 = (TextView) this.f41629e.findViewById(R$id.action_bar_subtitle);
        this.f41626b = textView2;
        if (this.f41632h != 0) {
            textView.setTextAppearance(getContext(), this.f41632h);
        }
        if (this.f41633i != 0) {
            textView2.setTextAppearance(getContext(), this.f41633i);
        }
        this.f41637m = (int) (getResources().getDisplayMetrics().density * 104.0f);
    }
}
