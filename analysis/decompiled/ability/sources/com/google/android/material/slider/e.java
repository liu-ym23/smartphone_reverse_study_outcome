package com.google.android.material.slider;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes3.dex */
public final class e implements Parcelable.Creator {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2523a;

    public /* synthetic */ e(int i) {
        this.f2523a = i;
    }

    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        switch (this.f2523a) {
            case 0:
                return new BaseSlider$SliderState(parcel, null);
            default:
                return new RangeSlider$RangeSliderState(parcel);
        }
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i) {
        switch (this.f2523a) {
            case 0:
                return new BaseSlider$SliderState[i];
            default:
                return new RangeSlider$RangeSliderState[i];
        }
    }
}
