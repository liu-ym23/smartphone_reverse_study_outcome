package com.google.android.material.internal;

import K.S;
import android.R;
import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Checkable;
import androidx.annotation.RestrictTo;
import androidx.appcompat.widget.E;
import androidx.customview.view.AbsSavedState;
import e.EnumC0546d;

@RestrictTo({EnumC0546d.f12493b})
/* loaded from: classes.dex */
public class CheckableImageButton extends E implements Checkable {

    /* renamed from: g, reason: collision with root package name */
    public static final int[] f10750g = {R.attr.state_checked};

    /* renamed from: d, reason: collision with root package name */
    public boolean f10751d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f10752e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f10753f;

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* renamed from: a, reason: collision with root package name */
        public boolean f10754a;

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f10754a = parcel.readInt() == 1;
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i4) {
            super.writeToParcel(parcel, i4);
            parcel.writeInt(this.f10754a ? 1 : 0);
        }
    }

    public CheckableImageButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, com.stepos.alphame.R.attr.imageButtonStyle);
        this.f10752e = true;
        this.f10753f = true;
        S.h(this, new r0.d(2, this));
    }

    @Override // android.widget.Checkable
    public final boolean isChecked() {
        return this.f10751d;
    }

    @Override // android.widget.ImageView, android.view.View
    public final int[] onCreateDrawableState(int i4) {
        return this.f10751d ? View.mergeDrawableStates(super.onCreateDrawableState(i4 + 1), f10750g) : super.onCreateDrawableState(i4);
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setChecked(savedState.f10754a);
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f10754a = this.f10751d;
        return savedState;
    }

    public void setCheckable(boolean z4) {
        if (this.f10752e != z4) {
            this.f10752e = z4;
            sendAccessibilityEvent(0);
        }
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z4) {
        if (!this.f10752e || this.f10751d == z4) {
            return;
        }
        this.f10751d = z4;
        refreshDrawableState();
        sendAccessibilityEvent(2048);
    }

    public void setPressable(boolean z4) {
        this.f10753f = z4;
    }

    @Override // android.view.View
    public void setPressed(boolean z4) {
        if (this.f10753f) {
            super.setPressed(z4);
        }
    }

    @Override // android.widget.Checkable
    public final void toggle() {
        setChecked(!this.f10751d);
    }
}
