package com.android.contacts.detail;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import com.android.contacts.R;

/* JADX INFO: loaded from: classes.dex */
public class ContactDetailPrimaryActionView extends RelativeLayout {
    private View mDivider;
    private View mStar;
    private View mType;

    public ContactDetailPrimaryActionView(Context r1, AttributeSet r2) {
        super(r1, r2);
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        this.mType = findViewById(R.id.type);
        this.mDivider = findViewById(R.id.divider);
        this.mStar = findViewById(R.id.starCheckbox);
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean r5, int r6, int r7, int r8, int r9) {
        super.onLayout(r5, r6, r7, r8, r9);
        View r10 = this.mType;
        View r11 = this.mDivider;
        View r4 = this.mStar;
        int r12 = r10.getMeasuredHeight();
        if (r11 != null) goto L5;
        int r13 = 0;
    L6:
        int r14 = r4.getMeasuredHeight();
        int r0 = Math.max(Math.max(r12, r13), r14);
        if (r0 <= r12) goto L9;
        int r1 = r10.getTop() + ((r0 - r12) / 2);
        r10.layout(r10.getLeft(), r1, r10.getRight(), r12 + r1);
    L9:
        if (r11 == null) goto L12;
        if (r0 <= r13) goto L12;
        int r15 = r11.getTop() + ((r0 - r13) / 2);
        r11.layout(r11.getLeft(), r15, r11.getRight(), r13 + r15);
    L12:
        if (r0 <= r14) goto L15;
        int r16 = r4.getTop() + ((r0 - r14) / 2);
        r4.layout(r4.getLeft(), r16, r4.getRight(), r14 + r16);
        return;
    L15:
        return;
    L5:
        r13 = r11.getMeasuredHeight();
        goto L6
    }
}
