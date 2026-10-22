package com.google.android.material.slider;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.AbsSavedState;

/* loaded from: classes3.dex */
class RangeSlider$RangeSliderState extends AbsSavedState {
    public static final Parcelable.Creator<RangeSlider$RangeSliderState> CREATOR = new e(1);
    private float minSeparation;
    private int separationUnit;

    @Override // android.view.AbsSavedState, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeFloat(this.minSeparation);
        parcel.writeInt(this.separationUnit);
    }

    public RangeSlider$RangeSliderState(Parcelable parcelable) {
        super(parcelable);
    }

    private RangeSlider$RangeSliderState(Parcel parcel) {
        super(parcel.readParcelable(RangeSlider$RangeSliderState.class.getClassLoader()));
        this.minSeparation = parcel.readFloat();
        this.separationUnit = parcel.readInt();
    }
}
