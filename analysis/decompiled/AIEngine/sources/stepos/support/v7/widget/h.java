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
import com.stepos.aiengine.R;
import java.util.ArrayList;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class h extends LinearLayoutCompat {
    public final int A;
    public ArrayList<a> B;

    /* renamed from: s, reason: collision with root package name */
    public final TextView f12799s;

    /* renamed from: t, reason: collision with root package name */
    public final TextView f12800t;

    /* renamed from: u, reason: collision with root package name */
    public final View f12801u;

    /* renamed from: v, reason: collision with root package name */
    public final View f12802v;

    /* renamed from: w, reason: collision with root package name */
    public final View f12803w;

    /* renamed from: x, reason: collision with root package name */
    public CharSequence f12804x;

    /* renamed from: y, reason: collision with root package name */
    public CharSequence f12805y;
    public final int z;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public interface a {
        void a(CharSequence charSequence);
    }

    public h(Context context) {
        super(context, null, R.attr.steposControlTitleBarStyle);
        this.z = 17;
        com.stepos.common.animator.g gVar = new com.stepos.common.animator.g();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(null, ce.a.f3418g, R.attr.steposControlTitleBarStyle, 0);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(3, 0);
        int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(2, 0);
        int resourceId3 = typedArrayObtainStyledAttributes.getResourceId(0, R.layout.stepos_control_title_bar_negative_item);
        int resourceId4 = typedArrayObtainStyledAttributes.getResourceId(1, R.layout.stepos_control_title_bar_positive_item);
        typedArrayObtainStyledAttributes.recycle();
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(context);
        this.A = getResources().getDimensionPixelSize(R.dimen.stepos_action_bar_control_title_bar_min_title_width);
        View viewInflate = layoutInflaterFrom.inflate(resourceId3, (ViewGroup) this, false);
        this.f12801u = viewInflate;
        addView(viewInflate);
        View viewInflate2 = layoutInflaterFrom.inflate(resourceId4, (ViewGroup) this, false);
        this.f12802v = viewInflate2;
        addView(viewInflate2);
        gVar.b(viewInflate, 5, false);
        gVar.b(viewInflate2, 5, false);
        View viewInflate3 = layoutInflaterFrom.inflate(R.layout.stepos_action_bar_title_item, (ViewGroup) this, false);
        this.f12803w = viewInflate3;
        addView(viewInflate3);
        TextView textView = (TextView) viewInflate3.findViewById(R.id.action_bar_title);
        this.f12799s = textView;
        TextView textView2 = (TextView) viewInflate3.findViewById(R.id.action_bar_subtitle);
        this.f12800t = textView2;
        if (resourceId != 0) {
            textView.setTextAppearance(getContext(), resourceId);
        }
        if (resourceId2 != 0) {
            textView2.setTextAppearance(getContext(), resourceId2);
        }
        float f8 = getResources().getDisplayMetrics().density;
    }

    public static int m(View view, int i10, int i11) {
        view.measure(View.MeasureSpec.makeMeasureSpec(i10, Integer.MIN_VALUE), i11);
        return view.getMeasuredWidth();
    }

    public static int n(int i10, int i11, int i12, View view, boolean z) {
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        int i13 = ((i12 - measuredHeight) / 2) + i11;
        if (z) {
            view.layout(i10 - measuredWidth, i13, i10, measuredHeight + i13);
        } else {
            view.layout(i10, i13, i10 + measuredWidth, measuredHeight + i13);
        }
        return z ? -measuredWidth : measuredWidth;
    }

    private void setBackgroundHotspotBounds(View view) {
        Drawable background = view.getBackground();
        if (background != null) {
            int paddingLeft = view.getPaddingLeft();
            int paddingRight = view.getPaddingRight();
            int width = view.getWidth();
            int i10 = ((paddingLeft - paddingRight) + width) / 2;
            int i11 = ((width - paddingLeft) - paddingRight) / 2;
            background.setHotspotBounds(i10 - i11, 0, i10 + i11, view.getHeight());
        }
    }

    public View getNegativeItemView() {
        return this.f12801u;
    }

    public View getPositiveItemView() {
        return this.f12802v;
    }

    public CharSequence getSubTitle() {
        return this.f12805y;
    }

    public CharSequence getTitle() {
        return this.f12804x;
    }

    public TextView getTitleView() {
        return this.f12799s;
    }

    public final void l() {
        this.f12799s.setText(this.f12804x);
        CharSequence charSequence = this.f12805y;
        TextView textView = this.f12800t;
        textView.setText(charSequence);
        boolean zIsEmpty = TextUtils.isEmpty(this.f12804x);
        boolean zIsEmpty2 = TextUtils.isEmpty(this.f12805y);
        textView.setVisibility(!zIsEmpty2 ? 0 : 8);
        this.f12803w.setVisibility((zIsEmpty && zIsEmpty2) ? 8 : 0);
    }

    public final void o(int i10, String str, Drawable drawable, View.OnClickListener onClickListener) {
        try {
            TextView textView = (TextView) (i10 == 1 ? this.f12802v : this.f12801u);
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

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i10, int i11, int i12, int i13) {
        int paddingRight;
        int paddingLeft;
        boolean zB = g0.b(this);
        int paddingRight2 = zB ? (i12 - i10) - getPaddingRight() : getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingTop2 = ((i13 - i11) - getPaddingTop()) - getPaddingBottom();
        View view = this.f12801u;
        if (view == null || view.getVisibility() == 8) {
            paddingRight = zB ? (i12 - i10) - getPaddingRight() : getPaddingLeft();
        } else {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
            int i14 = zB ? marginLayoutParams.rightMargin : marginLayoutParams.leftMargin;
            int i15 = zB ? marginLayoutParams.leftMargin : marginLayoutParams.rightMargin;
            int i16 = zB ? paddingRight2 - i14 : paddingRight2 + i14;
            int iN = n(i16, paddingTop, paddingTop2, view, zB) + i16;
            paddingRight = zB ? iN - i15 : iN + i15;
            setBackgroundHotspotBounds(view);
        }
        int paddingLeft2 = zB ? getPaddingLeft() : (i12 - i10) - getPaddingRight();
        View view2 = this.f12802v;
        if (view2 == null || view2.getVisibility() == 8) {
            paddingLeft = zB ? getPaddingLeft() : (i12 - i10) - getPaddingRight();
        } else {
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) view2.getLayoutParams();
            int i17 = zB ? marginLayoutParams2.rightMargin : marginLayoutParams2.leftMargin;
            int i18 = zB ? marginLayoutParams2.leftMargin : marginLayoutParams2.rightMargin;
            boolean z3 = !zB;
            int i19 = !zB ? paddingLeft2 - i18 : paddingLeft2 + i18;
            int iN2 = n(i19, paddingTop, paddingTop2, view2, z3) + i19;
            paddingLeft = !zB ? iN2 - i17 : iN2 + i17;
            setBackgroundHotspotBounds(view2);
        }
        View view3 = this.f12803w;
        if (view3 == null || view3.getVisibility() == 8) {
            return;
        }
        int measuredWidth = view3.getMeasuredWidth();
        int i20 = (this.z & 7) == 1 ? ((i12 - i10) - measuredWidth) / 2 : 0;
        if (!zB ? !(i20 <= paddingRight || measuredWidth + i20 >= paddingLeft) : !(measuredWidth + i20 >= paddingRight || i20 <= paddingLeft)) {
            n(paddingRight, paddingTop, paddingTop2, view3, zB);
        } else {
            n(i20, paddingTop, paddingTop2, view3, false);
        }
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.View
    public final void onMeasure(int i10, int i11) {
        int iM;
        int i12;
        int i13;
        int size = View.MeasureSpec.getSize(i10);
        int paddingBottom = getPaddingBottom() + getPaddingTop();
        int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i11) - paddingBottom, Integer.MIN_VALUE);
        View view = this.f12802v;
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        View view2 = this.f12801u;
        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) view2.getLayoutParams();
        int iM2 = view2.getVisibility() != 8 ? marginLayoutParams2.leftMargin + marginLayoutParams2.rightMargin + m(view2, paddingLeft, iMakeMeasureSpec) : 0;
        int iM3 = view.getVisibility() != 8 ? marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + m(view, paddingLeft, iMakeMeasureSpec) : 0;
        if (iM2 + iM3 > paddingLeft) {
            if (iM2 < iM3) {
                int i14 = paddingLeft / 2;
                if (iM2 <= i14) {
                    iM3 = marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + m(view, ((paddingLeft - iM2) - marginLayoutParams.leftMargin) - marginLayoutParams.rightMargin, iMakeMeasureSpec);
                } else {
                    iM3 = marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + m(view, (i14 - marginLayoutParams.leftMargin) - marginLayoutParams.rightMargin, iMakeMeasureSpec);
                    iM = m(view2, (i14 - marginLayoutParams2.leftMargin) - marginLayoutParams2.rightMargin, iMakeMeasureSpec);
                    i12 = marginLayoutParams2.leftMargin;
                    i13 = marginLayoutParams2.rightMargin;
                }
            } else {
                int i15 = paddingLeft / 2;
                if (iM3 <= i15) {
                    iM = m(view2, ((paddingLeft - iM3) - marginLayoutParams2.leftMargin) - marginLayoutParams2.rightMargin, iMakeMeasureSpec);
                    i12 = marginLayoutParams2.leftMargin;
                    i13 = marginLayoutParams2.rightMargin;
                } else {
                    iM3 = marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + m(view, (i15 - marginLayoutParams.leftMargin) - marginLayoutParams.rightMargin, iMakeMeasureSpec);
                    iM = m(view2, (i15 - marginLayoutParams2.leftMargin) - marginLayoutParams2.rightMargin, iMakeMeasureSpec);
                    i12 = marginLayoutParams2.leftMargin;
                    i13 = marginLayoutParams2.rightMargin;
                }
            }
            iM2 = i12 + i13 + iM;
        }
        int i16 = (paddingLeft - iM2) - iM3;
        if (i16 <= this.A) {
            i16 = 0;
        }
        View view3 = this.f12803w;
        if (view3 != null) {
            m(view3, i16, iMakeMeasureSpec);
        }
        int childCount = getChildCount();
        int i17 = 0;
        for (int i18 = 0; i18 < childCount; i18++) {
            int measuredHeight = getChildAt(i18).getMeasuredHeight() + paddingBottom;
            if (measuredHeight > i17) {
                i17 = measuredHeight;
            }
        }
        setMeasuredDimension(size, i17);
    }

    public void setOnNegativeItemClickListener(View.OnClickListener onClickListener) {
        View view = this.f12801u;
        if (view != null) {
            view.setOnClickListener(onClickListener);
        }
    }

    public void setOnPositiveItemClickListener(View.OnClickListener onClickListener) {
        View view = this.f12802v;
        if (view != null) {
            view.setOnClickListener(onClickListener);
        }
    }

    public void setSubTitle(CharSequence charSequence) {
        if (TextUtils.equals(this.f12805y, charSequence)) {
            return;
        }
        this.f12805y = charSequence;
        l();
        ArrayList<a> arrayList = this.B;
        if (arrayList != null) {
            int size = arrayList.size();
            int i10 = 0;
            while (i10 < size) {
                a aVar = arrayList.get(i10);
                i10++;
                aVar.getClass();
            }
        }
    }

    public void setTitle(CharSequence charSequence) {
        if (TextUtils.equals(this.f12804x, charSequence)) {
            return;
        }
        this.f12804x = charSequence;
        l();
        ArrayList<a> arrayList = this.B;
        if (arrayList != null) {
            int size = arrayList.size();
            int i10 = 0;
            while (i10 < size) {
                a aVar = arrayList.get(i10);
                i10++;
                aVar.a(this.f12804x);
            }
        }
    }

    public void setTitleColor(int i10) {
        TextView textView = this.f12799s;
        if (textView == null || TextUtils.isEmpty(textView.getText())) {
            return;
        }
        textView.setTextColor(i10);
    }

    public void setItemMaxWidth(int i10) {
    }
}
