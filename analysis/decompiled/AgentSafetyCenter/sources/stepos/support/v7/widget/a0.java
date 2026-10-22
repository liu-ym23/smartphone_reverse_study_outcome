package stepos.support.v7.widget;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.ArrayList;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public final class a0 extends m.o1 {
    public int A;
    public int B;
    public ArrayList C;

    /* renamed from: t, reason: collision with root package name */
    public TextView f12718t;

    /* renamed from: u, reason: collision with root package name */
    public TextView f12719u;

    /* renamed from: v, reason: collision with root package name */
    public View f12720v;

    /* renamed from: w, reason: collision with root package name */
    public View f12721w;

    /* renamed from: x, reason: collision with root package name */
    public View f12722x;

    /* renamed from: y, reason: collision with root package name */
    public CharSequence f12723y;

    /* renamed from: z, reason: collision with root package name */
    public CharSequence f12724z;

    public static int l(View view, int i, int i3) {
        view.measure(View.MeasureSpec.makeMeasureSpec(i, Integer.MIN_VALUE), i3);
        return view.getMeasuredWidth();
    }

    public static int m(View view, int i, int i3, int i10, boolean z10) {
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        int i11 = ((i10 - measuredHeight) / 2) + i3;
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
            int i3 = ((width - paddingLeft) - paddingRight) / 2;
            background.setHotspotBounds(i - i3, 0, i + i3, view.getHeight());
        }
    }

    public View getNegativeItemView() {
        return this.f12720v;
    }

    public View getPositiveItemView() {
        return this.f12721w;
    }

    public CharSequence getSubTitle() {
        return this.f12724z;
    }

    public CharSequence getTitle() {
        return this.f12723y;
    }

    public TextView getTitleView() {
        return this.f12718t;
    }

    public final void k() {
        this.f12718t.setText(this.f12723y);
        TextView textView = this.f12719u;
        textView.setText(this.f12724z);
        boolean zIsEmpty = TextUtils.isEmpty(this.f12723y);
        boolean zIsEmpty2 = TextUtils.isEmpty(this.f12724z);
        textView.setVisibility(!zIsEmpty2 ? 0 : 8);
        this.f12722x.setVisibility((zIsEmpty && zIsEmpty2) ? 8 : 0);
    }

    public final void n(int i, String str, Drawable drawable, View.OnClickListener onClickListener) {
        try {
            TextView textView = (TextView) (i == 1 ? this.f12721w : this.f12720v);
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
            od.f.e("the item view of ControlTitleBar is not a TextView, please check the style of StepOSControlTitleBarStyle ");
        }
    }

    @Override // m.o1, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z10, int i, int i3, int i10, int i11) {
        int paddingRight;
        int paddingLeft;
        View view = this.f12722x;
        View view2 = this.f12721w;
        View view3 = this.f12720v;
        boolean zB = x1.b(this);
        int paddingRight2 = zB ? (i10 - i) - getPaddingRight() : getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingTop2 = ((i11 - i3) - getPaddingTop()) - getPaddingBottom();
        if (view3 == null || view3.getVisibility() == 8) {
            paddingRight = zB ? (i10 - i) - getPaddingRight() : getPaddingLeft();
        } else {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view3.getLayoutParams();
            int i12 = zB ? marginLayoutParams.rightMargin : marginLayoutParams.leftMargin;
            int i13 = zB ? marginLayoutParams.leftMargin : marginLayoutParams.rightMargin;
            int i14 = zB ? paddingRight2 - i12 : paddingRight2 + i12;
            int iM = m(view3, i14, paddingTop, paddingTop2, zB) + i14;
            paddingRight = zB ? iM - i13 : iM + i13;
            setBackgroundHotspotBounds(view3);
        }
        int paddingLeft2 = zB ? getPaddingLeft() : (i10 - i) - getPaddingRight();
        if (view2 == null || view2.getVisibility() == 8) {
            paddingLeft = zB ? getPaddingLeft() : (i10 - i) - getPaddingRight();
        } else {
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) view2.getLayoutParams();
            int i15 = zB ? marginLayoutParams2.rightMargin : marginLayoutParams2.leftMargin;
            int i16 = zB ? marginLayoutParams2.leftMargin : marginLayoutParams2.rightMargin;
            boolean z11 = !zB;
            int i17 = !zB ? paddingLeft2 - i16 : paddingLeft2 + i16;
            int iM2 = m(view2, i17, paddingTop, paddingTop2, z11) + i17;
            paddingLeft = !zB ? iM2 - i15 : iM2 + i15;
            setBackgroundHotspotBounds(view2);
        }
        if (view == null || view.getVisibility() == 8) {
            return;
        }
        int measuredWidth = view.getMeasuredWidth();
        int i18 = (this.A & 7) == 1 ? ((i10 - i) - measuredWidth) / 2 : 0;
        if (!zB ? !(i18 <= paddingRight || measuredWidth + i18 >= paddingLeft) : !(measuredWidth + i18 >= paddingRight || i18 <= paddingLeft)) {
            m(view, paddingRight, paddingTop, paddingTop2, zB);
        } else {
            m(view, i18, paddingTop, paddingTop2, false);
        }
    }

    @Override // m.o1, android.view.View
    public final void onMeasure(int i, int i3) {
        int iL;
        int i10;
        int i11;
        int size = View.MeasureSpec.getSize(i);
        int paddingBottom = getPaddingBottom() + getPaddingTop();
        int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i3) - paddingBottom, Integer.MIN_VALUE);
        View view = this.f12721w;
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        View view2 = this.f12720v;
        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) view2.getLayoutParams();
        int iL2 = view2.getVisibility() != 8 ? marginLayoutParams2.leftMargin + marginLayoutParams2.rightMargin + l(view2, paddingLeft, iMakeMeasureSpec) : 0;
        int iL3 = view.getVisibility() != 8 ? marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + l(view, paddingLeft, iMakeMeasureSpec) : 0;
        if (iL2 + iL3 > paddingLeft) {
            if (iL2 < iL3) {
                int i12 = paddingLeft / 2;
                if (iL2 <= i12) {
                    iL3 = marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + l(view, ((paddingLeft - iL2) - marginLayoutParams.leftMargin) - marginLayoutParams.rightMargin, iMakeMeasureSpec);
                } else {
                    iL3 = marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + l(view, (i12 - marginLayoutParams.leftMargin) - marginLayoutParams.rightMargin, iMakeMeasureSpec);
                    iL = l(view2, (i12 - marginLayoutParams2.leftMargin) - marginLayoutParams2.rightMargin, iMakeMeasureSpec);
                    i10 = marginLayoutParams2.leftMargin;
                    i11 = marginLayoutParams2.rightMargin;
                }
            } else {
                int i13 = paddingLeft / 2;
                if (iL3 <= i13) {
                    iL = l(view2, ((paddingLeft - iL3) - marginLayoutParams2.leftMargin) - marginLayoutParams2.rightMargin, iMakeMeasureSpec);
                    i10 = marginLayoutParams2.leftMargin;
                    i11 = marginLayoutParams2.rightMargin;
                } else {
                    iL3 = marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + l(view, (i13 - marginLayoutParams.leftMargin) - marginLayoutParams.rightMargin, iMakeMeasureSpec);
                    iL = l(view2, (i13 - marginLayoutParams2.leftMargin) - marginLayoutParams2.rightMargin, iMakeMeasureSpec);
                    i10 = marginLayoutParams2.leftMargin;
                    i11 = marginLayoutParams2.rightMargin;
                }
            }
            iL2 = i10 + i11 + iL;
        }
        int i14 = (paddingLeft - iL2) - iL3;
        if (i14 <= this.B) {
            i14 = 0;
        }
        View view3 = this.f12722x;
        if (view3 != null) {
            l(view3, i14, iMakeMeasureSpec);
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

    public void setOnNegativeItemClickListener(View.OnClickListener onClickListener) {
        View view = this.f12720v;
        if (view != null) {
            view.setOnClickListener(onClickListener);
        }
    }

    public void setOnPositiveItemClickListener(View.OnClickListener onClickListener) {
        View view = this.f12721w;
        if (view != null) {
            view.setOnClickListener(onClickListener);
        }
    }

    public void setSubTitle(CharSequence charSequence) {
        if (TextUtils.equals(this.f12724z, charSequence)) {
            return;
        }
        this.f12724z = charSequence;
        k();
        ArrayList arrayList = this.C;
        if (arrayList != null) {
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayList.get(i);
                i++;
                ((t0) obj).getClass();
            }
        }
    }

    public void setTitle(CharSequence charSequence) {
        if (TextUtils.equals(this.f12723y, charSequence)) {
            return;
        }
        this.f12723y = charSequence;
        k();
        ArrayList arrayList = this.C;
        if (arrayList != null) {
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayList.get(i);
                i++;
                ((t0) obj).f12833a.f12913o.n(this.f12723y);
            }
        }
    }

    public void setTitleColor(int i) {
        TextView textView = this.f12718t;
        if (textView == null || TextUtils.isEmpty(textView.getText())) {
            return;
        }
        textView.setTextColor(i);
    }

    public void setItemMaxWidth(int i) {
    }
}
