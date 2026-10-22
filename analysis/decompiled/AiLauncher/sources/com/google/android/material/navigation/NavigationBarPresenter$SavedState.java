package com.google.android.material.navigation;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.material.internal.ParcelableSparseArray;

/* loaded from: classes2.dex */
class NavigationBarPresenter$SavedState implements Parcelable {
    public static final Parcelable.Creator<NavigationBarPresenter$SavedState> CREATOR = new a();
    ParcelableSparseArray badgeSavedStates;
    int selectedItemId;

    public class a implements Parcelable.Creator<NavigationBarPresenter$SavedState> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public NavigationBarPresenter$SavedState createFromParcel(Parcel parcel) {
            return new NavigationBarPresenter$SavedState(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public NavigationBarPresenter$SavedState[] newArray(int i10) {
            return new NavigationBarPresenter$SavedState[i10];
        }
    }

    public NavigationBarPresenter$SavedState() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.selectedItemId);
        parcel.writeParcelable(this.badgeSavedStates, 0);
    }

    public NavigationBarPresenter$SavedState(Parcel parcel) {
        this.selectedItemId = parcel.readInt();
        this.badgeSavedStates = (ParcelableSparseArray) parcel.readParcelable(getClass().getClassLoader());
    }
}
