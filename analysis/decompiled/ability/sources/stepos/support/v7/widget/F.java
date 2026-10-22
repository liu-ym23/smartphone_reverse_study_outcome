package stepos.support.v7.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.graphics.drawable.DrawableCompat;
import com.stepos.ability.R;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes4.dex */
public final class F extends LinearLayoutCompat {

    /* renamed from: a, reason: collision with root package name */
    public final TextView f6457a;
    public final TextView b;
    public final View c;
    public final View d;
    public final View e;
    public CharSequence f;
    public CharSequence g;
    public final int h;
    public final int i;

    /* renamed from: j, reason: collision with root package name */
    public ArrayList f6458j;

    public F(Context context, int i) {
        super(context, null, R.attr.steposControlTitleBarStyle);
        this.h = 17;
        com.stepos.common.animator.m mVar = new com.stepos.common.animator.m();
        TintTypedArray tintTypedArrayObtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context, null, Ra.a.e, R.attr.steposControlTitleBarStyle, 0);
        int resourceId = tintTypedArrayObtainStyledAttributes.getResourceId(3, 0);
        int resourceId2 = tintTypedArrayObtainStyledAttributes.getResourceId(2, 0);
        int resourceId3 = tintTypedArrayObtainStyledAttributes.getResourceId(0, R.layout.stepos_control_title_bar_negative_item);
        int resourceId4 = tintTypedArrayObtainStyledAttributes.getResourceId(1, R.layout.stepos_control_title_bar_positive_item);
        tintTypedArrayObtainStyledAttributes.recycle();
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(context);
        this.i = getResources().getDimensionPixelSize(R.dimen.stepos_action_bar_control_title_bar_min_title_width);
        View viewInflate = layoutInflaterFrom.inflate(resourceId3, (ViewGroup) this, false);
        this.c = viewInflate;
        addView(viewInflate);
        View viewInflate2 = layoutInflaterFrom.inflate(resourceId4, (ViewGroup) this, false);
        this.d = viewInflate2;
        addView(viewInflate2);
        mVar.b(viewInflate, 5, false);
        mVar.b(viewInflate2, 5, false);
        View viewInflate3 = layoutInflaterFrom.inflate(R.layout.stepos_action_bar_title_item, (ViewGroup) this, false);
        this.e = viewInflate3;
        addView(viewInflate3);
        TextView textView = (TextView) viewInflate3.findViewById(R.id.action_bar_title);
        this.f6457a = textView;
        TextView textView2 = (TextView) viewInflate3.findViewById(R.id.action_bar_subtitle);
        this.b = textView2;
        if (resourceId != 0) {
            textView.setTextAppearance(getContext(), resourceId);
        }
        if (resourceId2 != 0) {
            textView2.setTextAppearance(getContext(), resourceId2);
        }
        float f = getResources().getDisplayMetrics().density;
    }

    public static int d(View view, int i, int i6) {
        view.measure(View.MeasureSpec.makeMeasureSpec(i, Integer.MIN_VALUE), i6);
        return view.getMeasuredWidth();
    }

    public static int e(View view, int i, int i6, int i10, boolean z10) {
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        int i11 = ((i10 - measuredHeight) / 2) + i6;
        if (z10) {
            view.layout(i - measuredWidth, i11, i, measuredHeight + i11);
        } else {
            view.layout(i, i11, i + measuredWidth, measuredHeight + i11);
        }
        return z10 ? -measuredWidth : measuredWidth;
    }

    private void setBackgroundHotspotBounds(View view) {
        Drawable background = view.getBackground();
        if (background != null) {
            int paddingLeft = view.getPaddingLeft();
            int paddingRight = view.getPaddingRight();
            int width = view.getWidth();
            int i = ((paddingLeft - paddingRight) + width) / 2;
            int i6 = ((width - paddingLeft) - paddingRight) / 2;
            DrawableCompat.setHotspotBounds(background, i - i6, 0, i + i6, view.getHeight());
        }
    }

    public final void c() {
        this.f6457a.setText(this.f);
        CharSequence charSequence = this.g;
        TextView textView = this.b;
        textView.setText(charSequence);
        boolean zIsEmpty = TextUtils.isEmpty(this.f);
        boolean zIsEmpty2 = TextUtils.isEmpty(this.g);
        textView.setVisibility(!zIsEmpty2 ? 0 : 8);
        this.e.setVisibility((zIsEmpty && zIsEmpty2) ? 8 : 0);
    }

    public final void f(int i, String str, Drawable drawable, View.OnClickListener onClickListener) {
        try {
            TextView textView = (TextView) (i == 1 ? this.d : this.c);
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

    public View getNegativeItemView() {
        return this.c;
    }

    public View getPositiveItemView() {
        return this.d;
    }

    public CharSequence getSubTitle() {
        return this.g;
    }

    public CharSequence getTitle() {
        return this.f;
    }

    public TextView getTitleView() {
        return this.f6457a;
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z10, int i, int i6, int i10, int i11) {
        int paddingRight;
        int paddingLeft;
        boolean zB = I0.b(this);
        int paddingRight2 = zB ? (i10 - i) - getPaddingRight() : getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingTop2 = ((i11 - i6) - getPaddingTop()) - getPaddingBottom();
        View view = this.c;
        if (view == null || view.getVisibility() == 8) {
            paddingRight = zB ? (i10 - i) - getPaddingRight() : getPaddingLeft();
        } else {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
            int i12 = zB ? marginLayoutParams.rightMargin : marginLayoutParams.leftMargin;
            int i13 = zB ? marginLayoutParams.leftMargin : marginLayoutParams.rightMargin;
            int i14 = zB ? paddingRight2 - i12 : paddingRight2 + i12;
            int iE = e(this.c, i14, paddingTop, paddingTop2, zB) + i14;
            paddingRight = zB ? iE - i13 : iE + i13;
            setBackgroundHotspotBounds(view);
        }
        int paddingLeft2 = zB ? getPaddingLeft() : (i10 - i) - getPaddingRight();
        View view2 = this.d;
        if (view2 == null || view2.getVisibility() == 8) {
            paddingLeft = zB ? getPaddingLeft() : (i10 - i) - getPaddingRight();
        } else {
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) view2.getLayoutParams();
            int i15 = zB ? marginLayoutParams2.rightMargin : marginLayoutParams2.leftMargin;
            int i16 = zB ? marginLayoutParams2.leftMargin : marginLayoutParams2.rightMargin;
            boolean z11 = !zB;
            int i17 = !zB ? paddingLeft2 - i16 : paddingLeft2 + i16;
            int iE2 = e(this.d, i17, paddingTop, paddingTop2, z11) + i17;
            paddingLeft = !zB ? iE2 - i15 : iE2 + i15;
            setBackgroundHotspotBounds(view2);
        }
        View view3 = this.e;
        if (view3 == null || view3.getVisibility() == 8) {
            return;
        }
        int measuredWidth = view3.getMeasuredWidth();
        int i18 = (this.h & 7) == 1 ? ((i10 - i) - measuredWidth) / 2 : 0;
        if (!zB ? !(i18 <= paddingRight || measuredWidth + i18 >= paddingLeft) : !(measuredWidth + i18 >= paddingRight || i18 <= paddingLeft)) {
            e(this.e, paddingRight, paddingTop, paddingTop2, zB);
        } else {
            e(this.e, i18, paddingTop, paddingTop2, false);
        }
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.View
    public final void onMeasure(int i, int i6) {
        int iD;
        int i10;
        int i11;
        int size = View.MeasureSpec.getSize(i);
        int paddingBottom = getPaddingBottom() + getPaddingTop();
        int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i6) - paddingBottom, Integer.MIN_VALUE);
        View view = this.d;
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        View view2 = this.c;
        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) view2.getLayoutParams();
        int iD2 = view2.getVisibility() != 8 ? marginLayoutParams2.leftMargin + marginLayoutParams2.rightMargin + d(view2, paddingLeft, iMakeMeasureSpec) : 0;
        int iD3 = view.getVisibility() != 8 ? marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + d(view, paddingLeft, iMakeMeasureSpec) : 0;
        if (iD2 + iD3 > paddingLeft) {
            if (iD2 < iD3) {
                int i12 = paddingLeft / 2;
                if (iD2 <= i12) {
                    iD3 = marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + d(view, ((paddingLeft - iD2) - marginLayoutParams.leftMargin) - marginLayoutParams.rightMargin, iMakeMeasureSpec);
                } else {
                    iD3 = marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + d(view, (i12 - marginLayoutParams.leftMargin) - marginLayoutParams.rightMargin, iMakeMeasureSpec);
                    iD = d(view2, (i12 - marginLayoutParams2.leftMargin) - marginLayoutParams2.rightMargin, iMakeMeasureSpec);
                    i10 = marginLayoutParams2.leftMargin;
                    i11 = marginLayoutParams2.rightMargin;
                }
            } else {
                int i13 = paddingLeft / 2;
                if (iD3 <= i13) {
                    iD = d(view2, ((paddingLeft - iD3) - marginLayoutParams2.leftMargin) - marginLayoutParams2.rightMargin, iMakeMeasureSpec);
                    i10 = marginLayoutParams2.leftMargin;
                    i11 = marginLayoutParams2.rightMargin;
                } else {
                    iD3 = marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + d(view, (i13 - marginLayoutParams.leftMargin) - marginLayoutParams.rightMargin, iMakeMeasureSpec);
                    iD = d(view2, (i13 - marginLayoutParams2.leftMargin) - marginLayoutParams2.rightMargin, iMakeMeasureSpec);
                    i10 = marginLayoutParams2.leftMargin;
                    i11 = marginLayoutParams2.rightMargin;
                }
            }
            iD2 = i10 + i11 + iD;
        }
        int i14 = (paddingLeft - iD2) - iD3;
        if (i14 <= this.i) {
            i14 = 0;
        }
        View view3 = this.e;
        if (view3 != null) {
            d(view3, i14, iMakeMeasureSpec);
        }
        int childCount = getChildCount();
        int i15 = 0;
        for (int i16 = 0; i16 < childCount; i16++) {
            int measuredHeight = getChildAt(i16).getMeasuredHeight() + paddingBottom;
            if (measuredHeight > i15) {
                i15 = measuredHeight;
            }
        }
        setMeasuredDimension(size, i15);
    }

    public void setItemMaxWidth(int i) {
    }

    public void setOnNegativeItemClickListener(View.OnClickListener onClickListener) {
        View view = this.c;
        if (view != null) {
            view.setOnClickListener(onClickListener);
        }
    }

    public void setOnPositiveItemClickListener(View.OnClickListener onClickListener) {
        View view = this.d;
        if (view != null) {
            view.setOnClickListener(onClickListener);
        }
    }

    public void setSubTitle(CharSequence charSequence) {
        if (TextUtils.equals(this.g, charSequence)) {
            return;
        }
        this.g = charSequence;
        c();
        ArrayList arrayList = this.f6458j;
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((C1980b0) it.next()).getClass();
            }
        }
    }

    public void setTitle(CharSequence charSequence) {
        if (TextUtils.equals(this.f, charSequence)) {
            return;
        }
        this.f = charSequence;
        c();
        ArrayList arrayList = this.f6458j;
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                C1980b0 c1980b0 = (C1980b0) it.next();
                c1980b0.f6603a.k.n(this.f);
            }
        }
    }

    public void setTitleColor(int i) {
        TextView textView = this.f6457a;
        if (textView == null || TextUtils.isEmpty(textView.getText())) {
            return;
        }
        textView.setTextColor(i);
    }
}
