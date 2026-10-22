package com.android.contacts.list;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.android.contacts.R;

/* JADX INFO: loaded from: classes2.dex */
public class ContactListPinnedHeaderView extends ViewGroup {
    private final int mContactsCountTextColor;
    protected final Context mContext;
    private TextView mCountTextView;
    private final int mCountViewTextSize;
    private int mHeaderBackgroundHeight;
    private View mHeaderDivider;
    private final int mHeaderTextColor;
    private final int mHeaderTextIndent;
    private final int mHeaderTextSize;
    private TextView mHeaderTextView;
    private final int mHeaderUnderlineColor;
    private final int mHeaderUnderlineHeight;
    private final int mPaddingLeft;
    private final int mPaddingRight;

    public ContactListPinnedHeaderView(Context r10, AttributeSet r11) {
        super(r10, r11);
        this.mCountTextView = null;
        this.mContext = r10;
        TypedArray r12 = getContext().obtainStyledAttributes(r11, R.styleable.ContactListItemView);
        this.mHeaderTextIndent = r12.getDimensionPixelOffset(10, 0);
        int r0 = r12.getColor(9, -16777216);
        this.mHeaderTextColor = r0;
        int r3 = r12.getDimensionPixelSize(11, 12);
        this.mHeaderTextSize = r3;
        this.mHeaderUnderlineHeight = r12.getDimensionPixelSize(13, 1);
        int r5 = r12.getColor(12, 0);
        this.mHeaderUnderlineColor = r5;
        this.mHeaderBackgroundHeight = r12.getDimensionPixelSize(8, 30);
        this.mPaddingLeft = r12.getDimensionPixelOffset(19, 0);
        this.mPaddingRight = r12.getDimensionPixelOffset(20, 0);
        this.mContactsCountTextColor = r12.getColor(2, -16777216);
        this.mCountViewTextSize = r12.getDimensionPixelSize(3, 12);
        r12.recycle();
        TextView r13 = new TextView(r10);
        this.mHeaderTextView = r13;
        r13.setTextColor(r0);
        this.mHeaderTextView.setTextSize(0, r3);
        TextView r14 = this.mHeaderTextView;
        r14.setTypeface(r14.getTypeface(), 1);
        this.mHeaderTextView.setGravity(16);
        this.mHeaderTextView.setAllCaps(true);
        addView(this.mHeaderTextView);
        View r15 = new View(r10);
        this.mHeaderDivider = r15;
        r15.setBackgroundColor(r5);
        addView(this.mHeaderDivider);
    }

    @Override // android.view.View
    protected void onMeasure(int r5, int r6) {
        int r7 = resolveSize(0, r5);
        this.mHeaderTextView.measure(View.MeasureSpec.makeMeasureSpec(r7, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(this.mHeaderBackgroundHeight, 1073741824));
        if (isViewMeasurable(this.mCountTextView) == false) goto L5;
        this.mCountTextView.measure(View.MeasureSpec.makeMeasureSpec(r7, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(this.mHeaderBackgroundHeight, 1073741824));
    L5:
        setMeasuredDimension(r7, this.mHeaderBackgroundHeight + this.mHeaderUnderlineHeight);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean r2, int r3, int r4, int r5, int r6) {
        int r7 = r5 - r3;
        TextView r8 = this.mHeaderTextView;
        r8.layout(this.mHeaderTextIndent + this.mPaddingLeft, 0, (r8.getMeasuredWidth() + this.mHeaderTextIndent) + this.mPaddingLeft, this.mHeaderBackgroundHeight);
        if (isViewMeasurable(this.mCountTextView) == false) goto L5;
        TextView r9 = this.mCountTextView;
        r9.layout((r7 - this.mPaddingRight) - r9.getMeasuredWidth(), 0, r7 - this.mPaddingRight, this.mHeaderBackgroundHeight);
    L5:
        View r10 = this.mHeaderDivider;
        int r11 = this.mPaddingLeft;
        int r12 = this.mHeaderBackgroundHeight;
        r10.layout(r11, r12, r7 - this.mPaddingRight, this.mHeaderUnderlineHeight + r12);
    }

    public void setSectionHeader(String r2) {
        if (TextUtils.isEmpty(r2) == true) goto L5;
        this.mHeaderTextView.setText(r2);
        this.mHeaderTextView.setVisibility(0);
        this.mHeaderDivider.setVisibility(0);
        return;
    L5:
        this.mHeaderTextView.setVisibility(8);
        this.mHeaderDivider.setVisibility(8);
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        super.requestLayout();
        forceLayout();
    }

    public void setCountView(String r4) {
        if (this.mCountTextView != null) goto L5;
        TextView r0 = new TextView(this.mContext);
        this.mCountTextView = r0;
        r0.setTextColor(this.mContactsCountTextColor);
        this.mCountTextView.setTextSize(0, this.mCountViewTextSize);
        this.mCountTextView.setGravity(16);
        addView(this.mCountTextView);
    L5:
        this.mCountTextView.setText(r4);
        if (r4 != null) goto L8;
    L11:
        this.mCountTextView.setVisibility(8);
        return;
    L8:
        if (r4.isEmpty() == true) goto L11;
        this.mCountTextView.setVisibility(0);
    }

    private boolean isViewMeasurable(View r1) {
        if (r1 != null) goto L4;
    L6:
        return false;
    L4:
        if (r1.getVisibility() != 0) goto L6;
        return true;
    }
}
