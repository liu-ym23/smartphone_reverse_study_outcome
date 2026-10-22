package com.google.android.material.bottomappbar;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.customview.view.AbsSavedState;

/* loaded from: classes3.dex */
class BottomAppBar$SavedState extends AbsSavedState {
    public static final Parcelable.Creator<BottomAppBar$SavedState> CREATOR = new b();
    int fabAlignmentMode;
    boolean fabAttached;

    public BottomAppBar$SavedState(Parcelable parcelable) {
        super(parcelable);
    }

    @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.fabAlignmentMode);
        parcel.writeInt(this.fabAttached ? 1 : 0);
    }

    public BottomAppBar$SavedState(@NonNull Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        this.fabAlignmentMode = parcel.readInt();
        this.fabAttached = parcel.readInt() != 0;
    }
}
