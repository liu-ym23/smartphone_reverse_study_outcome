package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.LinearLayout;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;

/* JADX INFO: loaded from: classes2.dex */
public class ButtonBarLayout extends LinearLayout {
    private static final int PEEK_BUTTON_DP = 16;
    private boolean mAllowStacking;
    private int mLastWidthSize;
    private int mMinimumHeight;

    @Override // android.view.View
    public int getMinimumHeight() {
        return Math.max(this.mMinimumHeight, super.getMinimumHeight());
    }

    private boolean isStacked() {
        if (getOrientation() == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public static DisplayMetrics INVOKEVIRTUAL_androidx_appcompat_widget_ButtonBarLayout_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r100) {
        return WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics());
    }

    private int getNextVisibleChildIndex(int r100) {
        int r101 = getChildCount();
    L3:
        if (r100 >= r101) goto L8;
        if (getChildAt(r100).getVisibility() == 0) goto L6;
        r100 = r100 + 1;
        goto L3
    L6:
        return r100;
    L8:
        return -1;
    }

    private void setStacked(boolean r100) {
        setOrientation(r100 ? 1 : 0);
        if (r100 == false) goto L5;
        int r101 = GravityCompat.END;
    L6:
        setGravity(r101);
        View r102 = findViewById(R.id.spacer);
        if (r102 == null) goto L12;
        if (r100 == false) goto L10;
        int r103 = 8;
    L11:
        r102.setVisibility(r103);
        goto L12
    L10:
        r103 = 4;
    L12:
        int r104 = getChildCount() - 2;
    L13:
        if (r104 < 0) goto L15;
        bringChildToFront(getChildAt(r104));
        r104 = r104 - 1;
        goto L13
    L15:
        return;
    L5:
        r101 = 80;
        goto L6
    }

    public void setAllowStacking(boolean r100) {
        if (this.mAllowStacking == r100) goto L11;
        this.mAllowStacking = r100;
        if (r100 == false) goto L7;
    L9:
        requestLayout();
        return;
    L7:
        if (getOrientation() != 1) goto L9;
        setStacked(false);
        goto L9
    }

    public ButtonBarLayout(Context r110, AttributeSet r111) {
        super(r110, r111);
        this.mLastWidthSize = -1;
        this.mMinimumHeight = 0;
        TypedArray r100 = r110.obtainStyledAttributes(r111, new int[]{R.attr.allowStacking});
        ViewCompat.saveAttributeDataForStyleable(this, r110, new int[]{R.attr.allowStacking}, r111, r100, 0, 0);
        this.mAllowStacking = r100.getBoolean(0, true);
        r100.recycle();
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int r100, int r101) {
        int r102 = View.MeasureSpec.getSize(r100);
        int r103 = 0;
        if (this.mAllowStacking == false) goto L11;
        if (r102 > this.mLastWidthSize) goto L7;
    L9:
        this.mLastWidthSize = r102;
        goto L11
    L7:
        if (isStacked() == false) goto L9;
        setStacked(false);
    L11:
        if (isStacked() == false) goto L13;
    L15:
        int r104 = r100;
        boolean r105 = false;
    L16:
        super.onMeasure(r104, r101);
        if (this.mAllowStacking == true) goto L19;
    L26:
        if (r105 == false) goto L28;
        super.onMeasure(r100, r101);
    L28:
        int r106 = getNextVisibleChildIndex(0);
        if (r106 < 0) goto L38;
        View r107 = getChildAt(r106);
        LinearLayout.LayoutParams r108 = (LinearLayout.LayoutParams) r107.getLayoutParams();
        int r109 = (((getPaddingTop() + r107.getMeasuredHeight()) + r108.topMargin) + r108.bottomMargin) + 0;
        if (isStacked() == false) goto L36;
        int r110 = getNextVisibleChildIndex(r106 + 1);
        if (r110 < 0) goto L35;
        r109 = r109 + (getChildAt(r110).getPaddingTop() + ((int) (INVOKEVIRTUAL_androidx_appcompat_widget_ButtonBarLayout_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(getResources()).density * 16.0f)));
    L35:
        r103 = r109;
        goto L38
    L36:
        r103 = r109 + getPaddingBottom();
    L38:
        if (ViewCompat.getMinimumHeight(this) == r103) goto L41;
        setMinimumHeight(r103);
        return;
    L41:
        return;
    L19:
        if (isStacked() == true) goto L26;
        if ((getMeasuredWidthAndState() & (-16777216)) != 16777216) goto L23;
        boolean r111 = true;
    L24:
        if (r111 == false) goto L26;
        setStacked(true);
        r105 = true;
        goto L26
    L23:
        r111 = false;
        goto L24
    L13:
        if (View.MeasureSpec.getMode(r100) != 1073741824) goto L15;
        r104 = View.MeasureSpec.makeMeasureSpec(r102, Integer.MIN_VALUE);
        r105 = true;
        goto L16
    }
}
