package com.google.android.material.internal;

import android.R;
import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.widget.Checkable;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.core.view.ViewCompat;
import androidx.customview.view.AbsSavedState;

/* JADX INFO: loaded from: classes2.dex */
public class CheckableImageButton extends AppCompatImageButton implements Checkable {
    private static final int[] DRAWABLE_STATE_CHECKED = null;
    private boolean checkable;
    private boolean checked;
    private boolean pressable;

    static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;
        boolean checked;

        public SavedState(Parcelable r1) {
            super(r1);
        }

        public SavedState(Parcel r1, ClassLoader r2) {
            super(r1, r2);
            readFromParcel(r1);
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel r1, int r2) {
            super.writeToParcel(r1, r2);
            r1.writeInt(this.checked ? 1 : 0);
        }

        private void readFromParcel(Parcel r2) {
            boolean r0 = true;
            if (r2.readInt() == 1) goto L6;
            r0 = false;
        L6:
            this.checked = r0;
        }

        static {
            CREATOR = new AnonymousClass1();
        }
    }

    static {
        DRAWABLE_STATE_CHECKED = new int[]{R.attr.state_checked};
    }

    public CheckableImageButton(Context r2) {
        this(r2, null);
    }

    public CheckableImageButton(Context r2, AttributeSet r3) {
        this(r2, r3, androidx.appcompat.R.attr.imageButtonStyle);
    }

    public CheckableImageButton(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        this.checkable = true;
        this.pressable = true;
        ViewCompat.setAccessibilityDelegate(this, new AnonymousClass1(this));
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean r2) {
        if (this.checkable == true) goto L5;
        return;
    L5:
        if (this.checked == r2) goto L9;
        this.checked = r2;
        refreshDrawableState();
        sendAccessibilityEvent(2048);
        return;
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.checked;
    }

    @Override // android.widget.Checkable
    public void toggle() {
        setChecked(!this.checked);
    }

    @Override // android.view.View
    public void setPressed(boolean r2) {
        if (this.pressable == false) goto L6;
        super.setPressed(r2);
        return;
    }

    @Override // android.widget.ImageView, android.view.View
    public int[] onCreateDrawableState(int r3) {
        if (this.checked == false) goto L7;
        int[] r0 = DRAWABLE_STATE_CHECKED;
        return mergeDrawableStates(super.onCreateDrawableState(r3 + r0.length), r0);
    L7:
        return super.onCreateDrawableState(r3);
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        SavedState r1 = new SavedState(super.onSaveInstanceState());
        r1.checked = this.checked;
        return r1;
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable r2) {
        if ((r2 instanceof SavedState) == true) goto L6;
        super.onRestoreInstanceState(r2);
        return;
    L6:
        SavedState r3 = (SavedState) r2;
        super.onRestoreInstanceState(r3.getSuperState());
        setChecked(r3.checked);
    }

    public void setCheckable(boolean r2) {
        if (this.checkable == r2) goto L6;
        this.checkable = r2;
        sendAccessibilityEvent(0);
        return;
    }

    public boolean isCheckable() {
        return this.checkable;
    }

    public void setPressable(boolean r1) {
        this.pressable = r1;
    }

    public boolean isPressable() {
        return this.pressable;
    }
}
