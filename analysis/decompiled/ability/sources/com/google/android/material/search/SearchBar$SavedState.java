package com.google.android.material.search;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import androidx.customview.view.AbsSavedState;

/* loaded from: classes3.dex */
class SearchBar$SavedState extends AbsSavedState {
    public static final Parcelable.Creator<SearchBar$SavedState> CREATOR = new a(0);
    String text;

    public SearchBar$SavedState(Parcel parcel) {
        this(parcel, null);
    }

    @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.text);
    }

    public SearchBar$SavedState(Parcel parcel, @Nullable ClassLoader classLoader) {
        super(parcel, classLoader);
        this.text = parcel.readString();
    }

    public SearchBar$SavedState(Parcelable parcelable) {
        super(parcelable);
    }
}
