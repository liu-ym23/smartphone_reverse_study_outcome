package com.android.contacts.common.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.Checkable;
import android.widget.ImageView;
import com.android.contacts.common.R;

/* JADX INFO: loaded from: classes.dex */
public class CheckableImageView extends ImageView implements Checkable {
    private int mCheckMarkBackgroundColor;
    private boolean mChecked;
    private CheckableFlipDrawable mDrawable;

    public CheckableImageView(Context r2) {
        super(r2);
        this.mChecked = false;
        init(r2);
    }

    public CheckableImageView(Context r1, AttributeSet r2) {
        super(r1, r2);
        this.mChecked = false;
        init(r1);
    }

    public CheckableImageView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        this.mChecked = false;
        init(r1);
    }

    public CheckableImageView(Context r1, AttributeSet r2, int r3, int r4) {
        super(r1, r2, r3, r4);
        this.mChecked = false;
        init(r1);
    }

    private void init(Context r2) {
        setCheckMarkBackgroundColor(r2.getResources().getColor(R.color.photo_selected_color));
    }

    public void setCheckMarkBackgroundColor(int r1) {
        this.mCheckMarkBackgroundColor = r1;
        CheckableFlipDrawable r0 = this.mDrawable;
        if (r0 == null) goto L6;
        r0.setCheckMarkBackgroundColor(r1);
        return;
    }

    @Override // android.widget.Checkable
    public void toggle() {
        setChecked(!this.mChecked);
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.mChecked;
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean r2) {
        setChecked(r2, true);
    }

    public void setChecked(boolean r2, boolean r3) {
        if (this.mChecked != r2) goto L5;
        return;
    L5:
        this.mChecked = r2;
        applyCheckState(r3);
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable r5) {
        if (r5 == null) goto L8;
        CheckableFlipDrawable r0 = this.mDrawable;
        if (r0 != null) goto L6;
        this.mDrawable = new CheckableFlipDrawable(r5, getResources(), this.mCheckMarkBackgroundColor, 150);
        applyCheckState(false);
    L7:
        r5 = this.mDrawable;
        goto L8
    L6:
        r0.setFront(r5);
    L8:
        super.setImageDrawable(r5);
    }

    private void applyCheckState(boolean r3) {
        this.mDrawable.flipTo(!this.mChecked);
        if (r3 == true) goto L6;
        this.mDrawable.reset();
        return;
    }
}
