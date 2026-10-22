package com.google.android.material.slider;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import androidx.annotation.NonNull;
import java.util.ArrayList;

/* loaded from: classes3.dex */
class BaseSlider$SliderState extends View.BaseSavedState {
    public static final Parcelable.Creator<BaseSlider$SliderState> CREATOR = new e(0);
    boolean hasFocus;
    float stepSize;
    float valueFrom;
    float valueTo;
    ArrayList<Float> values;

    public /* synthetic */ BaseSlider$SliderState(Parcel parcel, c cVar) {
        this(parcel);
    }

    @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeFloat(this.valueFrom);
        parcel.writeFloat(this.valueTo);
        parcel.writeList(this.values);
        parcel.writeFloat(this.stepSize);
        parcel.writeBooleanArray(new boolean[]{this.hasFocus});
    }

    public BaseSlider$SliderState(Parcelable parcelable) {
        super(parcelable);
    }

    private BaseSlider$SliderState(@NonNull Parcel parcel) {
        super(parcel);
        this.valueFrom = parcel.readFloat();
        this.valueTo = parcel.readFloat();
        ArrayList<Float> arrayList = new ArrayList<>();
        this.values = arrayList;
        parcel.readList(arrayList, Float.class.getClassLoader());
        this.stepSize = parcel.readFloat();
        this.hasFocus = parcel.createBooleanArray()[0];
    }
}
