package com.google.android.material.navigation;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes3.dex */
public final class a implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        return new NavigationBarPresenter$SavedState(parcel);
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i) {
        return new NavigationBarPresenter$SavedState[i];
    }
}
