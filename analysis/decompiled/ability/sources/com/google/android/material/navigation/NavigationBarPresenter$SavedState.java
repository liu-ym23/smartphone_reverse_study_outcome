package com.google.android.material.navigation;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.internal.ParcelableSparseArray;

/* loaded from: classes3.dex */
class NavigationBarPresenter$SavedState implements Parcelable {
    public static final Parcelable.Creator<NavigationBarPresenter$SavedState> CREATOR = new a();

    @Nullable
    ParcelableSparseArray badgeSavedStates;
    int selectedItemId;

    public NavigationBarPresenter$SavedState() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeInt(this.selectedItemId);
        parcel.writeParcelable(this.badgeSavedStates, 0);
    }

    public NavigationBarPresenter$SavedState(@NonNull Parcel parcel) {
        this.selectedItemId = parcel.readInt();
        this.badgeSavedStates = (ParcelableSparseArray) parcel.readParcelable(getClass().getClassLoader());
    }
}
