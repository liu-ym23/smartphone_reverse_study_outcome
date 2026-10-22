package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes2.dex */
public class AlertDialogLayout extends LinearLayoutCompat {
    public AlertDialogLayout(Context r100) {
        super(r100);
    }

    private static int resolveMinimumHeight(View r100) {
        int r101 = ViewCompat.getMinimumHeight(r100);
        if (r101 <= 0) goto L6;
        return r101;
    L6:
        if ((r100 instanceof ViewGroup) == false) goto L11;
        ViewGroup r102 = (ViewGroup) r100;
        if (r102.getChildCount() != 1) goto L11;
        return resolveMinimumHeight(r102.getChildAt(0));
    L11:
        return 0;
    }

    public AlertDialogLayout(Context r100, AttributeSet r101) {
        super(r100, r101);
    }

    private void forceUniformWidth(int r110, int r111) {
        int r100 = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824);
        int r101 = 0;
    L3:
        if (r101 >= r110) goto L10;
        View r102 = getChildAt(r101);
        if (r102.getVisibility() == 8) goto L9;
        LinearLayoutCompat.LayoutParams r103 = (LinearLayoutCompat.LayoutParams) r102.getLayoutParams();
        if (((LinearLayout.LayoutParams) r103).width != (-1)) goto L9;
        int r104 = ((LinearLayout.LayoutParams) r103).height;
        ((LinearLayout.LayoutParams) r103).height = r102.getMeasuredHeight();
        measureChildWithMargins(r102, r100, 0, r111, 0);
        ((LinearLayout.LayoutParams) r103).height = r104;
    L9:
        r101 = r101 + 1;
        goto L3
    }

    private boolean tryOnMeasure(int r110, int r111) {
        int r100 = getChildCount();
        View r101 = null;
        View r102 = null;
        View r103 = null;
        int r104 = 0;
    L4:
        if (r104 >= r100) goto L24;
        View r112 = getChildAt(r104);
        if (r112.getVisibility() == 8) goto L23;
        int r105 = r112.getId();
        if (r105 != R.id.topPanel) goto L12;
        r101 = r112;
        goto L23
    L12:
        if (r105 != R.id.buttonPanel) goto L15;
        r102 = r112;
        goto L23
    L15:
        if (r105 != R.id.contentPanel) goto L17;
    L20:
        if (r103 != null) goto L21;
        r103 = r112;
        goto L23
    L21:
        return false;
    L17:
        if (r105 == R.id.customPanel) goto L20;
        return false;
    L23:
        r104 = r104 + 1;
        goto L4
    L24:
        int r106 = View.MeasureSpec.getMode(r111);
        int r113 = View.MeasureSpec.getSize(r111);
        int r114 = View.MeasureSpec.getMode(r110);
        int r115 = getPaddingTop() + getPaddingBottom();
        if (r101 == null) goto L27;
        r101.measure(r110, 0);
        r115 = r115 + r101.getMeasuredHeight();
        int r107 = View.combineMeasuredStates(0, r101.getMeasuredState());
    L28:
        if (r102 == null) goto L30;
        r102.measure(r110, 0);
        int r116 = resolveMinimumHeight(r102);
        int r117 = r102.getMeasuredHeight() - r116;
        r115 = r115 + r116;
        r107 = View.combineMeasuredStates(r107, r102.getMeasuredState());
    L31:
        if (r103 == null) goto L36;
        if (r106 != 0) goto L34;
        int r118 = 0;
    L35:
        r103.measure(r110, r118);
        int r119 = r103.getMeasuredHeight();
        r115 = r115 + r119;
        r107 = View.combineMeasuredStates(r107, r103.getMeasuredState());
    L37:
        int r120 = r113 - r115;
        if (r102 == null) goto L43;
        int r121 = r115 - r116;
        int r122 = Math.min(r120, r117);
        if (r122 <= 0) goto L42;
        r120 = r120 - r122;
        r116 = r116 + r122;
    L42:
        r102.measure(r110, View.MeasureSpec.makeMeasureSpec(r116, 1073741824));
        r115 = r121 + r102.getMeasuredHeight();
        r107 = View.combineMeasuredStates(r107, r102.getMeasuredState());
    L43:
        if (r103 == null) goto L46;
        if (r120 <= 0) goto L46;
        r103.measure(r110, View.MeasureSpec.makeMeasureSpec(r119 + r120, r106));
        r115 = (r115 - r119) + r103.getMeasuredHeight();
        r107 = View.combineMeasuredStates(r107, r103.getMeasuredState());
    L46:
        int r108 = 0;
        int r109 = 0;
    L47:
        if (r108 >= r100) goto L52;
        View r123 = getChildAt(r108);
        if (r123.getVisibility() == 8) goto L51;
        r109 = Math.max(r109, r123.getMeasuredWidth());
    L51:
        r108 = r108 + 1;
        goto L47
    L52:
        setMeasuredDimension(View.resolveSizeAndState(r109 + (getPaddingLeft() + getPaddingRight()), r110, r107), View.resolveSizeAndState(r115, r111, 0));
        if (r114 == 1073741824) goto L67;
        forceUniformWidth(r100, r111);
        return true;
    L67:
        return true;
    L34:
        r118 = View.MeasureSpec.makeMeasureSpec(Math.max(0, r113 - r115), r106);
        goto L35
    L36:
        r119 = 0;
        goto L37
    L30:
        r116 = 0;
        r117 = 0;
        goto L31
    L27:
        r107 = 0;
        goto L28
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.View
    public void onMeasure(int r100, int r101) {
        if (tryOnMeasure(r100, r101) == true) goto L6;
        super.onMeasure(r100, r101);
        return;
    }

    private void setChildFrame(View r100, int r101, int r102, int r103, int r104) {
        r100.layout(r101, r102, r103 + r101, r104 + r102);
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup, android.view.View
    public void onLayout(boolean r110, int r111, int r210, int r211, int r212) {
        int r100 = getPaddingLeft();
        int r101 = r211 - r111;
        int r102 = r101 - getPaddingRight();
        int r103 = (r101 - r100) - getPaddingRight();
        int r104 = getMeasuredHeight();
        int r112 = getChildCount();
        int r105 = getGravity();
        int r106 = r105 & 112;
        int r113 = r105 & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK;
        if (r106 != 16) goto L5;
        int r107 = getPaddingTop() + (((r212 - r210) - r104) / 2);
    L9:
        Drawable r108 = getDividerDrawable();
        if (r108 != null) goto L12;
        int r114 = 0;
    L13:
        int r115 = 0;
    L14:
        if (r115 >= r112) goto L35;
        View r109 = getChildAt(r115);
        if (r109 == null) goto L34;
        if (r109.getVisibility() == 8) goto L34;
        int r116 = r109.getMeasuredWidth();
        int r117 = r109.getMeasuredHeight();
        LinearLayoutCompat.LayoutParams r118 = (LinearLayoutCompat.LayoutParams) r109.getLayoutParams();
        int r119 = ((LinearLayout.LayoutParams) r118).gravity;
        if (r119 >= 0) goto L22;
        r119 = r113;
    L22:
        int r120 = GravityCompat.getAbsoluteGravity(r119, ViewCompat.getLayoutDirection(this)) & 7;
        if (r120 != 1) goto L25;
        int r121 = (((r103 - r116) / 2) + r100) + ((LinearLayout.LayoutParams) r118).leftMargin;
        int r122 = ((LinearLayout.LayoutParams) r118).rightMargin;
    L29:
        int r123 = r121 - r122;
    L31:
        if (hasDividerBeforeChildAt(r115) == false) goto L33;
        r107 = r107 + r114;
    L33:
        int r124 = r107 + ((LinearLayout.LayoutParams) r118).topMargin;
        setChildFrame(r109, r123, r124, r116, r117);
        r107 = r124 + (r117 + ((LinearLayout.LayoutParams) r118).bottomMargin);
        goto L34
    L25:
        if (r120 == 5) goto L27;
        r123 = ((LinearLayout.LayoutParams) r118).leftMargin + r100;
        goto L31
    L27:
        r121 = r102 - r116;
        r122 = ((LinearLayout.LayoutParams) r118).rightMargin;
    L34:
        r115 = r115 + 1;
        goto L14
    L35:
        return;
    L12:
        r114 = r108.getIntrinsicHeight();
        goto L13
    L5:
        if (r106 == 80) goto L7;
        r107 = getPaddingTop();
        goto L9
    L7:
        r107 = ((getPaddingTop() + r212) - r210) - r104;
        goto L9
    }
}
