package com.google.android.material.slider;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.AbsSavedState;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
class RangeSlider$RangeSliderState extends AbsSavedState {
    public static final Parcelable.Creator<RangeSlider$RangeSliderState> CREATOR = new a();
    private float minSeparation;
    private int separationUnit;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class a implements Parcelable.Creator<RangeSlider$RangeSliderState> {
        @Override // android.os.Parcelable.Creator
        public final RangeSlider$RangeSliderState createFromParcel(Parcel parcel) {
            return new RangeSlider$RangeSliderState(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final RangeSlider$RangeSliderState[] newArray(int i10) {
            return new RangeSlider$RangeSliderState[i10];
        }
    }

    @Override // android.view.AbsSavedState, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        super.writeToParcel(parcel, i10);
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
