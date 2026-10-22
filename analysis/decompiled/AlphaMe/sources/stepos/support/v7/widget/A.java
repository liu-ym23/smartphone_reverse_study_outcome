package stepos.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import com.stepos.alphame.R;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes2.dex */
public final class A extends LinearLayoutCompat {

    /* renamed from: p, reason: collision with root package name */
    public final TextView f14694p;

    /* renamed from: q, reason: collision with root package name */
    public final TextView f14695q;

    /* renamed from: r, reason: collision with root package name */
    public final View f14696r;

    /* renamed from: s, reason: collision with root package name */
    public final View f14697s;

    /* renamed from: t, reason: collision with root package name */
    public final View f14698t;

    /* renamed from: u, reason: collision with root package name */
    public CharSequence f14699u;

    /* renamed from: v, reason: collision with root package name */
    public CharSequence f14700v;

    /* renamed from: w, reason: collision with root package name */
    public final int f14701w;

    /* renamed from: x, reason: collision with root package name */
    public final int f14702x;

    /* renamed from: y, reason: collision with root package name */
    public ArrayList f14703y;

    public A(Context context) {
        super(context, null, R.attr.steposControlTitleBarStyle);
        this.f14701w = 17;
        com.stepos.common.animator.m mVar = new com.stepos.common.animator.m();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(null, I3.a.f845e, R.attr.steposControlTitleBarStyle, 0);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(3, 0);
        int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(2, 0);
        int resourceId3 = typedArrayObtainStyledAttributes.getResourceId(0, R.layout.stepos_control_title_bar_negative_item);
        int resourceId4 = typedArrayObtainStyledAttributes.getResourceId(1, R.layout.stepos_control_title_bar_positive_item);
        typedArrayObtainStyledAttributes.recycle();
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(context);
        this.f14702x = getResources().getDimensionPixelSize(R.dimen.stepos_action_bar_control_title_bar_min_title_width);
        View viewInflate = layoutInflaterFrom.inflate(resourceId3, (ViewGroup) this, false);
        this.f14696r = viewInflate;
        addView(viewInflate);
        View viewInflate2 = layoutInflaterFrom.inflate(resourceId4, (ViewGroup) this, false);
        this.f14697s = viewInflate2;
        addView(viewInflate2);
        mVar.b(viewInflate, 5, false);
        mVar.b(viewInflate2, 5, false);
        View viewInflate3 = layoutInflaterFrom.inflate(R.layout.stepos_action_bar_title_item, (ViewGroup) this, false);
        this.f14698t = viewInflate3;
        addView(viewInflate3);
        TextView textView = (TextView) viewInflate3.findViewById(R.id.action_bar_title);
        this.f14694p = textView;
        TextView textView2 = (TextView) viewInflate3.findViewById(R.id.action_bar_subtitle);
        this.f14695q = textView2;
        if (resourceId != 0) {
            textView.setTextAppearance(getContext(), resourceId);
        }
        if (resourceId2 != 0) {
            textView2.setTextAppearance(getContext(), resourceId2);
        }
        float f4 = getResources().getDisplayMetrics().density;
    }

    public static int o(View view, int i4, int i5) {
        view.measure(View.MeasureSpec.makeMeasureSpec(i4, Integer.MIN_VALUE), i5);
        return view.getMeasuredWidth();
    }

    public static int p(int i4, int i5, int i6, View view, boolean z4) {
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        int i7 = ((i6 - measuredHeight) / 2) + i5;
        if (z4) {
            view.layout(i4 - measuredWidth, i7, i4, measuredHeight + i7);
        } else {
            view.layout(i4, i7, i4 + measuredWidth, measuredHeight + i7);
        }
        return z4 ? -measuredWidth : measuredWidth;
    }

    private void setBackgroundHotspotBounds(View view) {
        Drawable background = view.getBackground();
        if (background != null) {
            int paddingLeft = view.getPaddingLeft();
            int paddingRight = view.getPaddingRight();
            int width = view.getWidth();
            int i4 = ((paddingLeft - paddingRight) + width) / 2;
            int i5 = ((width - paddingLeft) - paddingRight) / 2;
            E.a.f(background, i4 - i5, 0, i4 + i5, view.getHeight());
        }
    }

    public View getNegativeItemView() {
        return this.f14696r;
    }

    public View getPositiveItemView() {
        return this.f14697s;
    }

    public CharSequence getSubTitle() {
        return this.f14700v;
    }

    public CharSequence getTitle() {
        return this.f14699u;
    }

    public TextView getTitleView() {
        return this.f14694p;
    }

    public final void n() {
        this.f14694p.setText(this.f14699u);
        CharSequence charSequence = this.f14700v;
        TextView textView = this.f14695q;
        textView.setText(charSequence);
        boolean z4 = !TextUtils.isEmpty(this.f14699u);
        boolean z5 = !TextUtils.isEmpty(this.f14700v);
        textView.setVisibility(z5 ? 0 : 8);
        this.f14698t.setVisibility((z4 || z5) ? 0 : 8);
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z4, int i4, int i5, int i6, int i7) {
        int paddingRight;
        int paddingLeft;
        boolean zB = y0.b(this);
        int paddingRight2 = zB ? (i6 - i4) - getPaddingRight() : getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingTop2 = ((i7 - i5) - getPaddingTop()) - getPaddingBottom();
        View view = this.f14696r;
        if (view == null || view.getVisibility() == 8) {
            paddingRight = zB ? (i6 - i4) - getPaddingRight() : getPaddingLeft();
        } else {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
            int i8 = zB ? marginLayoutParams.rightMargin : marginLayoutParams.leftMargin;
            int i9 = zB ? marginLayoutParams.leftMargin : marginLayoutParams.rightMargin;
            int i10 = zB ? paddingRight2 - i8 : paddingRight2 + i8;
            int iP = p(i10, paddingTop, paddingTop2, this.f14696r, zB) + i10;
            paddingRight = zB ? iP - i9 : iP + i9;
            setBackgroundHotspotBounds(view);
        }
        int paddingLeft2 = zB ? getPaddingLeft() : (i6 - i4) - getPaddingRight();
        View view2 = this.f14697s;
        if (view2 == null || view2.getVisibility() == 8) {
            paddingLeft = zB ? getPaddingLeft() : (i6 - i4) - getPaddingRight();
        } else {
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) view2.getLayoutParams();
            int i11 = zB ? marginLayoutParams2.rightMargin : marginLayoutParams2.leftMargin;
            int i12 = zB ? marginLayoutParams2.leftMargin : marginLayoutParams2.rightMargin;
            boolean z5 = !zB;
            int i13 = z5 ? paddingLeft2 - i12 : paddingLeft2 + i12;
            int iP2 = p(i13, paddingTop, paddingTop2, this.f14697s, z5) + i13;
            paddingLeft = z5 ? iP2 - i11 : iP2 + i11;
            setBackgroundHotspotBounds(view2);
        }
        View view3 = this.f14698t;
        if (view3 == null || view3.getVisibility() == 8) {
            return;
        }
        int measuredWidth = view3.getMeasuredWidth();
        int i14 = (this.f14701w & 7) == 1 ? ((i6 - i4) - measuredWidth) / 2 : 0;
        if (!zB ? !(i14 <= paddingRight || measuredWidth + i14 >= paddingLeft) : !(measuredWidth + i14 >= paddingRight || i14 <= paddingLeft)) {
            p(paddingRight, paddingTop, paddingTop2, this.f14698t, zB);
        } else {
            p(i14, paddingTop, paddingTop2, this.f14698t, false);
        }
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.View
    public final void onMeasure(int i4, int i5) {
        int iO;
        int i6;
        int i7;
        int size = View.MeasureSpec.getSize(i4);
        int paddingBottom = getPaddingBottom() + getPaddingTop();
        int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i5) - paddingBottom, Integer.MIN_VALUE);
        View view = this.f14697s;
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        View view2 = this.f14696r;
        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) view2.getLayoutParams();
        int iO2 = view2.getVisibility() != 8 ? marginLayoutParams2.leftMargin + marginLayoutParams2.rightMargin + o(view2, paddingLeft, iMakeMeasureSpec) : 0;
        int iO3 = view.getVisibility() != 8 ? marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + o(view, paddingLeft, iMakeMeasureSpec) : 0;
        if (iO2 + iO3 > paddingLeft) {
            if (iO2 < iO3) {
                int i8 = paddingLeft / 2;
                if (iO2 <= i8) {
                    iO3 = marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + o(view, ((paddingLeft - iO2) - marginLayoutParams.leftMargin) - marginLayoutParams.rightMargin, iMakeMeasureSpec);
                } else {
                    iO3 = marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + o(view, (i8 - marginLayoutParams.leftMargin) - marginLayoutParams.rightMargin, iMakeMeasureSpec);
                    iO = o(view2, (i8 - marginLayoutParams2.leftMargin) - marginLayoutParams2.rightMargin, iMakeMeasureSpec);
                    i6 = marginLayoutParams2.leftMargin;
                    i7 = marginLayoutParams2.rightMargin;
                }
            } else {
                int i9 = paddingLeft / 2;
                if (iO3 <= i9) {
                    iO = o(view2, ((paddingLeft - iO3) - marginLayoutParams2.leftMargin) - marginLayoutParams2.rightMargin, iMakeMeasureSpec);
                    i6 = marginLayoutParams2.leftMargin;
                    i7 = marginLayoutParams2.rightMargin;
                } else {
                    iO3 = marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + o(view, (i9 - marginLayoutParams.leftMargin) - marginLayoutParams.rightMargin, iMakeMeasureSpec);
                    iO = o(view2, (i9 - marginLayoutParams2.leftMargin) - marginLayoutParams2.rightMargin, iMakeMeasureSpec);
                    i6 = marginLayoutParams2.leftMargin;
                    i7 = marginLayoutParams2.rightMargin;
                }
            }
            iO2 = i6 + i7 + iO;
        }
        int i10 = (paddingLeft - iO2) - iO3;
        if (i10 <= this.f14702x) {
            i10 = 0;
        }
        View view3 = this.f14698t;
        if (view3 != null) {
            o(view3, i10, iMakeMeasureSpec);
        }
        int childCount = getChildCount();
        int i11 = 0;
        for (int i12 = 0; i12 < childCount; i12++) {
            int measuredHeight = getChildAt(i12).getMeasuredHeight() + paddingBottom;
            if (measuredHeight > i11) {
                i11 = measuredHeight;
            }
        }
        setMeasuredDimension(size, i11);
    }

    public final void q(int i4, String str, Drawable drawable, View.OnClickListener onClickListener) {
        try {
            TextView textView = (TextView) (i4 == 1 ? this.f14697s : this.f14696r);
            textView.setText(str);
            if (drawable != null) {
                boolean zIsEmpty = TextUtils.isEmpty(str);
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                textView.setCompoundDrawables(zIsEmpty ? drawable : null, zIsEmpty ? null : drawable, null, null);
            }
            textView.setOnClickListener(onClickListener);
            if (TextUtils.isEmpty(str) && drawable == null) {
                textView.setVisibility(8);
            }
        } catch (ClassCastException unused) {
            throw new IllegalStateException("the item view of ControlTitleBar is not a TextView, please check the style of StepOSControlTitleBarStyle ");
        }
    }

    public void setItemMaxWidth(int i4) {
    }

    public void setOnNegativeItemClickListener(View.OnClickListener onClickListener) {
        View view = this.f14696r;
        if (view != null) {
            view.setOnClickListener(onClickListener);
        }
    }

    public void setOnPositiveItemClickListener(View.OnClickListener onClickListener) {
        View view = this.f14697s;
        if (view != null) {
            view.setOnClickListener(onClickListener);
        }
    }

    public void setSubTitle(CharSequence charSequence) {
        if (TextUtils.equals(this.f14700v, charSequence)) {
            return;
        }
        this.f14700v = charSequence;
        n();
        ArrayList arrayList = this.f14703y;
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((U) it.next()).getClass();
            }
        }
    }

    public void setTitle(CharSequence charSequence) {
        if (TextUtils.equals(this.f14699u, charSequence)) {
            return;
        }
        this.f14699u = charSequence;
        n();
        ArrayList arrayList = this.f14703y;
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                U u4 = (U) it.next();
                u4.f15048a.f15238k.n(this.f14699u);
            }
        }
    }

    public void setTitleColor(int i4) {
        TextView textView = this.f14694p;
        if (textView == null || TextUtils.isEmpty(textView.getText())) {
            return;
        }
        textView.setTextColor(i4);
    }
}
