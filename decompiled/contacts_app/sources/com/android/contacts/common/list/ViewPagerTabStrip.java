package com.android.contacts.common.list;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.android.contacts.common.R;

/* JADX INFO: loaded from: classes.dex */
public class ViewPagerTabStrip extends LinearLayout {
    private int mIndexForSelection;
    private final Paint mSelectedUnderlinePaint;
    private int mSelectedUnderlineThickness;
    private float mSelectionOffset;

    public ViewPagerTabStrip(Context r2) {
        this(r2, null);
    }

    public ViewPagerTabStrip(Context r2, AttributeSet r3) {
        super(r2, r3);
        Resources r4 = r2.getResources();
        this.mSelectedUnderlineThickness = r4.getDimensionPixelSize(R.dimen.tab_selected_underline_height);
        int r5 = r4.getColor(R.color.tab_selected_underline_color);
        int r6 = r4.getColor(R.color.actionbar_background_color);
        Paint r0 = new Paint();
        this.mSelectedUnderlinePaint = r0;
        r0.setColor(r5);
        setBackgroundColor(r6);
        setWillNotDraw(false);
    }

    void onPageScrolled(int r1, float r2, int r3) {
        this.mIndexForSelection = r1;
        this.mSelectionOffset = r2;
        invalidate();
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onDraw(Canvas r10) {
        if (getChildCount() <= 0) goto L24;
        View r0 = getChildAt(this.mIndexForSelection);
        if (r0 != null) goto L7;
        return;
    L7:
        int r1 = r0.getLeft();
        int r2 = r0.getRight();
        boolean r3 = isRtl();
        boolean r4 = false;
        int r5 = 1;
        if (r3 == false) goto L13;
        if (this.mIndexForSelection <= 0) goto L16;
    L14:
        r4 = true;
    L16:
        if (this.mSelectionOffset <= 0.0f) goto L22;
        if (r4 == false) goto L22;
        int r6 = this.mIndexForSelection;
        if (r3 == false) goto L21;
        r5 = -1;
    L21:
        View r7 = getChildAt(r6 + r5);
        int r8 = r7.getLeft();
        int r9 = r7.getRight();
        float r11 = this.mSelectionOffset;
        r1 = (int) ((r8 * r11) + ((1.0f - r11) * r1));
        r2 = (int) ((r9 * r11) + ((1.0f - r11) * r2));
    L22:
        int r12 = getHeight();
        r10.drawRect(r1, r12 - this.mSelectedUnderlineThickness, r2, r12, this.mSelectedUnderlinePaint);
        return;
    L13:
        if (this.mIndexForSelection >= (getChildCount() - 1)) goto L16;
    }

    private boolean isRtl() {
        if (getLayoutDirection() == 1) goto L7;
        return false;
    L7:
        return true;
    }
}
