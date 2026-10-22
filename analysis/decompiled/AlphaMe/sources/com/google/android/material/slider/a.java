package com.google.android.material.slider;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.AbsSavedState;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class a implements Parcelable.Creator {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10908a;

    public /* synthetic */ a(int i4) {
        this.f10908a = i4;
    }

    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(final Parcel parcel) {
        switch (this.f10908a) {
            case 0:
                BaseSlider$SliderState baseSlider$SliderState = new BaseSlider$SliderState(parcel);
                baseSlider$SliderState.f10901a = parcel.readFloat();
                baseSlider$SliderState.f10902b = parcel.readFloat();
                ArrayList arrayList = new ArrayList();
                baseSlider$SliderState.f10903c = arrayList;
                parcel.readList(arrayList, Float.class.getClassLoader());
                baseSlider$SliderState.f10904d = parcel.readFloat();
                baseSlider$SliderState.f10905e = parcel.createBooleanArray()[0];
                return baseSlider$SliderState;
            default:
                return new AbsSavedState(parcel) { // from class: com.google.android.material.slider.RangeSlider$RangeSliderState
                    public static final Parcelable.Creator<RangeSlider$RangeSliderState> CREATOR = new a(1);

                    /* renamed from: a, reason: collision with root package name */
                    public final float f10906a;

                    /* renamed from: b, reason: collision with root package name */
                    public final int f10907b;

                    {
                        super(parcel.readParcelable(RangeSlider$RangeSliderState.class.getClassLoader()));
                        this.f10906a = parcel.readFloat();
                        this.f10907b = parcel.readInt();
                    }

                    @Override // android.view.AbsSavedState, android.os.Parcelable
                    public final void writeToParcel(Parcel parcel2, int i4) {
                        super.writeToParcel(parcel2, i4);
                        parcel2.writeFloat(this.f10906a);
                        parcel2.writeInt(this.f10907b);
                    }
                };
        }
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i4) {
        switch (this.f10908a) {
            case 0:
                return new BaseSlider$SliderState[i4];
            default:
                return new RangeSlider$RangeSliderState[i4];
        }
    }
}
