package com.google.android.material.slider;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import java.util.ArrayList;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
class BaseSlider$SliderState extends View.BaseSavedState {
    public static final Parcelable.Creator<BaseSlider$SliderState> CREATOR = new a();
    boolean hasFocus;
    float stepSize;
    float valueFrom;
    float valueTo;
    ArrayList<Float> values;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class a implements Parcelable.Creator<BaseSlider$SliderState> {
        @Override // android.os.Parcelable.Creator
        public final BaseSlider$SliderState createFromParcel(Parcel parcel) {
            return new BaseSlider$SliderState(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        public final BaseSlider$SliderState[] newArray(int i10) {
            return new BaseSlider$SliderState[i10];
        }
    }

    public /* synthetic */ BaseSlider$SliderState(Parcel parcel, com.google.android.material.slider.a aVar) {
        this(parcel);
    }

    @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        super.writeToParcel(parcel, i10);
        parcel.writeFloat(this.valueFrom);
        parcel.writeFloat(this.valueTo);
        parcel.writeList(this.values);
        parcel.writeFloat(this.stepSize);
        parcel.writeBooleanArray(new boolean[]{this.hasFocus});
    }

    public BaseSlider$SliderState(Parcelable parcelable) {
        super(parcelable);
    }

    private BaseSlider$SliderState(Parcel parcel) {
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
