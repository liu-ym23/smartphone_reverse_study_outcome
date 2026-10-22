package com.android.contacts.quickcontact;

import android.R;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.Checkable;
import android.widget.ImageView;

/* JADX INFO: loaded from: classes2.dex */
public class CheckableImageView extends ImageView implements Checkable {
    private static final int[] CHECKED_STATE_SET = null;
    private boolean mChecked;

    static {
        CHECKED_STATE_SET = new int[]{R.attr.state_checked};
    }

    public CheckableImageView(Context r1, AttributeSet r2) {
        super(r1, r2);
    }

    @Override // android.widget.ImageView, android.view.View
    public int[] onCreateDrawableState(int r1) {
        int[] r2 = super.onCreateDrawableState(r1 + 1);
        if (isChecked() == false) goto L5;
        mergeDrawableStates(r2, CHECKED_STATE_SET);
    L5:
        return r2;
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
        if (this.mChecked == r2) goto L6;
        this.mChecked = r2;
        refreshDrawableState();
        return;
    }
}
