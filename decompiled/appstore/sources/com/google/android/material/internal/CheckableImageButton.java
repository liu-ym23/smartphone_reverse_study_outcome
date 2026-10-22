package com.google.android.material.internal;

import android.R;
import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.widget.Checkable;
import android.widget.ImageButton;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R$attr;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.core.view.ViewCompat;
import androidx.customview.view.AbsSavedState;

/* JADX INFO: loaded from: classes3.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class CheckableImageButton extends AppCompatImageButton implements Checkable {
    private static final int[] DRAWABLE_STATE_CHECKED = null;
    private boolean checkable;
    private boolean checked;
    private boolean pressable;

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;
        boolean checked;

        static {
            CREATOR = new AnonymousClass1();
        }

        public SavedState(Parcelable r10) {
            super(r10);
        }

        private void readFromParcel(@NonNull Parcel r10) {
            boolean r11 = true;
            if (r10.readInt() == 1) goto L6;
            r11 = false;
        L6:
            this.checked = r11;
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(@NonNull Parcel r10, int r11) {
            super.writeToParcel(r10, r11);
            r10.writeInt(this.checked ? 1 : 0);
        }

        public SavedState(@NonNull Parcel r10, ClassLoader r11) {
            super(r10, r11);
            readFromParcel(r10);
        }
    }

    static {
        DRAWABLE_STATE_CHECKED = new int[]{R.attr.state_checked};
    }

    public CheckableImageButton(Context r10) {
        this(r10, null);
    }

    public boolean isCheckable() {
        return this.checkable;
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.checked;
    }

    public boolean isPressable() {
        return this.pressable;
    }

    @Override // android.widget.ImageView, android.view.View
    public int[] onCreateDrawableState(int r10) {
        if (this.checked == false) goto L7;
        int[] r11 = DRAWABLE_STATE_CHECKED;
        return ImageButton.mergeDrawableStates(super.onCreateDrawableState(r10 + r11.length), r11);
    L7:
        return super.onCreateDrawableState(r10);
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable r10) {
        if ((r10 instanceof SavedState) == true) goto L6;
        super.onRestoreInstanceState(r10);
        return;
    L6:
        SavedState r11 = (SavedState) r10;
        super.onRestoreInstanceState(r11.getSuperState());
        setChecked(r11.checked);
    }

    @Override // android.view.View
    @NonNull
    public Parcelable onSaveInstanceState() {
        SavedState r10 = new SavedState(super.onSaveInstanceState());
        r10.checked = this.checked;
        return r10;
    }

    public void setCheckable(boolean r10) {
        if (this.checkable == r10) goto L6;
        this.checkable = r10;
        sendAccessibilityEvent(0);
        return;
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean r10) {
        if (this.checkable == true) goto L5;
        return;
    L5:
        if (this.checked == r10) goto L9;
        this.checked = r10;
        refreshDrawableState();
        sendAccessibilityEvent(2048);
        return;
    }

    public void setPressable(boolean r10) {
        this.pressable = r10;
    }

    @Override // android.view.View
    public void setPressed(boolean r10) {
        if (this.pressable == false) goto L6;
        super.setPressed(r10);
        return;
    }

    @Override // android.widget.Checkable
    public void toggle() {
        setChecked(!this.checked);
    }

    public CheckableImageButton(Context r10, AttributeSet r11) {
        this(r10, r11, R$attr.imageButtonStyle);
    }

    public CheckableImageButton(Context r10, AttributeSet r11, int r12) {
        super(r10, r11, r12);
        this.checkable = true;
        this.pressable = true;
        ViewCompat.p0(this, new AnonymousClass1(this));
    }
}
