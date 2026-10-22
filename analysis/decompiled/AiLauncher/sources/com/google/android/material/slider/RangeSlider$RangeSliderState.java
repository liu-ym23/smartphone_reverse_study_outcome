package com.google.android.material.slider;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.AbsSavedState;

/* loaded from: classes2.dex */
class RangeSlider$RangeSliderState extends AbsSavedState {
    public static final Parcelable.Creator<RangeSlider$RangeSliderState> CREATOR = new a();
    private float minSeparation;
    private int separationUnit;

    public class a implements Parcelable.Creator<RangeSlider$RangeSliderState> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public RangeSlider$RangeSliderState createFromParcel(Parcel parcel) {
            return new RangeSlider$RangeSliderState(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public RangeSlider$RangeSliderState[] newArray(int i10) {
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
