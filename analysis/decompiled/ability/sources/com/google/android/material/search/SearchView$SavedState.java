package com.google.android.material.search;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import androidx.customview.view.AbsSavedState;

/* loaded from: classes3.dex */
class SearchView$SavedState extends AbsSavedState {
    public static final Parcelable.Creator<SearchView$SavedState> CREATOR = new a(1);
    String text;
    int visibility;

    public SearchView$SavedState(Parcel parcel) {
        this(parcel, null);
    }

    @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.text);
        parcel.writeInt(this.visibility);
    }

    public SearchView$SavedState(Parcel parcel, @Nullable ClassLoader classLoader) {
        super(parcel, classLoader);
        this.text = parcel.readString();
        this.visibility = parcel.readInt();
    }

    public SearchView$SavedState(Parcelable parcelable) {
        super(parcelable);
    }
}
