package com.google.android.material.datepicker;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public final class x implements Parcelable.Creator {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10732a;

    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        switch (this.f10732a) {
            case 0:
                return Month.c(parcel.readInt(), parcel.readInt());
            case 1:
                return new DateValidatorPointBackward(parcel.readLong());
            case 2:
                return new DateValidatorPointForward(parcel.readLong());
            case 3:
                RangeDateSelector rangeDateSelector = new RangeDateSelector();
                rangeDateSelector.f10665b = null;
                rangeDateSelector.f10666c = null;
                rangeDateSelector.f10667d = null;
                rangeDateSelector.f10668e = null;
                rangeDateSelector.f10665b = (Long) parcel.readValue(Long.class.getClassLoader());
                rangeDateSelector.f10666c = (Long) parcel.readValue(Long.class.getClassLoader());
                return rangeDateSelector;
            default:
                SingleDateSelector singleDateSelector = new SingleDateSelector();
                singleDateSelector.f10669a = (Long) parcel.readValue(Long.class.getClassLoader());
                return singleDateSelector;
        }
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i4) {
        switch (this.f10732a) {
            case 0:
                return new Month[i4];
            case 1:
                return new DateValidatorPointBackward[i4];
            case 2:
                return new DateValidatorPointForward[i4];
            case 3:
                return new RangeDateSelector[i4];
            default:
                return new SingleDateSelector[i4];
        }
    }
}
