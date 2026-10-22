package com.google.android.material.navigation;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.material.internal.ParcelableSparseArray;

/* loaded from: classes.dex */
class NavigationBarPresenter$SavedState implements Parcelable {
    public static final Parcelable.Creator<NavigationBarPresenter$SavedState> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    public int f10868a;

    /* renamed from: b, reason: collision with root package name */
    public ParcelableSparseArray f10869b;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        parcel.writeInt(this.f10868a);
        parcel.writeParcelable(this.f10869b, 0);
    }
}
