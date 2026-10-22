package com.google.android.material.navigation;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.customview.view.AbsSavedState;

/* loaded from: classes3.dex */
class NavigationBarView$SavedState extends AbsSavedState {
    public static final Parcelable.Creator<NavigationBarView$SavedState> CREATOR = new b(0);

    @Nullable
    Bundle menuPresenterState;

    public NavigationBarView$SavedState(Parcelable parcelable) {
        super(parcelable);
    }

    private void readFromParcel(@NonNull Parcel parcel, ClassLoader classLoader) {
        this.menuPresenterState = parcel.readBundle(classLoader);
    }

    @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeBundle(this.menuPresenterState);
    }

    public NavigationBarView$SavedState(@NonNull Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        readFromParcel(parcel, classLoader == null ? getClass().getClassLoader() : classLoader);
    }
}
