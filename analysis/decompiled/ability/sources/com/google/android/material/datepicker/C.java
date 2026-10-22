package com.google.android.material.datepicker;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes3.dex */
public final class C implements Parcelable.Creator {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2409a;

    public /* synthetic */ C(int i) {
        this.f2409a = i;
    }

    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        switch (this.f2409a) {
            case 0:
                return Month.create(parcel.readInt(), parcel.readInt());
            case 1:
                RangeDateSelector rangeDateSelector = new RangeDateSelector();
                rangeDateSelector.selectedStartItem = (Long) parcel.readValue(Long.class.getClassLoader());
                rangeDateSelector.selectedEndItem = (Long) parcel.readValue(Long.class.getClassLoader());
                return rangeDateSelector;
            default:
                SingleDateSelector singleDateSelector = new SingleDateSelector();
                singleDateSelector.selectedItem = (Long) parcel.readValue(Long.class.getClassLoader());
                return singleDateSelector;
        }
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i) {
        switch (this.f2409a) {
            case 0:
                return new Month[i];
            case 1:
                return new RangeDateSelector[i];
            default:
                return new SingleDateSelector[i];
        }
    }
}
