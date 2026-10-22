package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import androidx.core.view.ViewCompat;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.aiagent.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public class ButtonBarLayout extends LinearLayout {
    private static final int PEEK_BUTTON_DP = 16;
    private boolean mAllowStacking;
    private int mLastWidthSize;
    private boolean mStacked;

    public ButtonBarLayout(Context r10, AttributeSet r11) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r5 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r11, AttributeSet.class, "com.obric.aiagent.plugin");
        super(r3, r5);
        this.mLastWidthSize = -1;
        TypedArray r12 = r3.obtainStyledAttributes(r5, R.styleable.ButtonBarLayout);
        ViewCompat.a(this, r3, R.styleable.ButtonBarLayout, r5, r12, 0, 0);
        this.mAllowStacking = r12.getBoolean(ZeusTransformUtils.mapRes(R.styleable.ButtonBarLayout_allowStacking, "styleable", "ButtonBarLayout_allowStacking"), true);
        r12.recycle();
        if (getOrientation() != 1) goto L6;
        setStacked(this.mAllowStacking);
        return;
    }

    public void setAllowStacking(boolean r2) {
        if (this.mAllowStacking == r2) goto L11;
        this.mAllowStacking = r2;
        if (r2 == false) goto L7;
    L9:
        requestLayout();
        return;
    L7:
        if (isStacked() == false) goto L9;
        setStacked(false);
        goto L9
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int r8, int r9) {
        int r0 = View.MeasureSpec.getSize(r8);
        int r2 = 0;
        if (this.mAllowStacking == false) goto L11;
        if (r0 > this.mLastWidthSize) goto L7;
    L9:
        this.mLastWidthSize = r0;
        goto L11
    L7:
        if (isStacked() == false) goto L9;
        setStacked(false);
    L11:
        if (isStacked() == false) goto L13;
    L15:
        int r1 = r8;
        boolean r3 = false;
    L16:
        super.onMeasure(r1, r9);
        if (this.mAllowStacking == true) goto L19;
    L26:
        if (r3 == false) goto L28;
        super.onMeasure(r8, r9);
    L28:
        int r4 = getNextVisibleChildIndex(0);
        if (r4 < 0) goto L38;
        View r5 = getChildAt(r4);
        LinearLayout.LayoutParams r6 = (LinearLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r5.getLayoutParams(), LinearLayout.LayoutParams.class, "com.obric.aiagent.plugin");
        int r7 = (((getPaddingTop() + r5.getMeasuredHeight()) + r6.topMargin) + r6.bottomMargin) + 0;
        if (isStacked() == false) goto L36;
        int r10 = getNextVisibleChildIndex(r4 + 1);
        if (r10 < 0) goto L35;
        r7 = r7 + (getChildAt(r10).getPaddingTop() + ((int) (ZeusTransformUtils.getResources(this, "com.obric.aiagent.plugin").getDisplayMetrics().density * 16.0f)));
    L35:
        r2 = r7;
        goto L38
    L36:
        r2 = r7 + getPaddingBottom();
    L38:
        if (ViewCompat.o(this) == r2) goto L43;
        setMinimumHeight(r2);
        if (r9 != 0) goto L44;
        super.onMeasure(r8, r9);
        return;
    L44:
        return;
    L43:
        return;
    L19:
        if (isStacked() == true) goto L26;
        if ((getMeasuredWidthAndState() & (-16777216)) != 16777216) goto L23;
        boolean r11 = true;
    L24:
        if (r11 == false) goto L26;
        setStacked(true);
        r3 = true;
        goto L26
    L23:
        r11 = false;
        goto L24
    L13:
        if (View.MeasureSpec.getMode(r8) != 1073741824) goto L15;
        r1 = View.MeasureSpec.makeMeasureSpec(r0, Integer.MIN_VALUE);
        r3 = true;
        goto L16
    }

    private int getNextVisibleChildIndex(int r3) {
        int r0 = getChildCount();
    L3:
        if (r3 >= r0) goto L8;
        if (getChildAt(r3).getVisibility() == 0) goto L6;
        r3 = r3 + 1;
        goto L3
    L6:
        return r3;
    L8:
        return -1;
    }

    private void setStacked(boolean r4) {
        if (this.mStacked == r4) goto L20;
        if (r4 == true) goto L6;
    L7:
        this.mStacked = r4;
        setOrientation(r4 ? 1 : 0);
        if (r4 == false) goto L10;
        int r0 = 8388613;
    L11:
        setGravity(r0);
        View r1 = findViewById(ZeusTransformUtils.mapRes(R.id.spacer, DbHelper.COL_ID, "spacer"));
        if (r1 == null) goto L17;
        if (r4 == false) goto L15;
        int r5 = 8;
    L16:
        r1.setVisibility(r5);
        goto L17
    L15:
        r5 = 4;
    L17:
        int r6 = getChildCount() - 2;
    L18:
        if (r6 < 0) goto L23;
        bringChildToFront(getChildAt(r6));
        r6 = r6 - 1;
        goto L18
    L23:
        return;
    L10:
        r0 = 80;
        goto L11
    L6:
        if (this.mAllowStacking == true) goto L7;
        return;
    }

    private boolean isStacked() {
        return this.mStacked;
    }
}
