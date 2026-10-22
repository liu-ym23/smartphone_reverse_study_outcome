package com.stepos.common.widget;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;

/* loaded from: classes3.dex */
class CustomTimePicker$SavedState extends View.BaseSavedState {
    public static final Parcelable.Creator<CustomTimePicker$SavedState> CREATOR = new C1098c(1);
    private final int d;
    private final int h;
    private final int leapmonth;
    private final int lunar;
    private final int min;
    private final int mon;
    private final int y;

    @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.h);
        parcel.writeInt(this.min);
        parcel.writeInt(this.y);
        parcel.writeInt(this.mon);
        parcel.writeInt(this.d);
        parcel.writeInt(this.lunar);
        parcel.writeInt(this.leapmonth);
    }

    private CustomTimePicker$SavedState(Parcelable parcelable, int i, int i6, int i10, int i11, int i12, boolean z10, boolean z11) {
        super(parcelable);
        this.h = i;
        this.min = i6;
        this.y = i10;
        this.mon = i11;
        this.d = i12;
        this.lunar = z10 ? 1 : 0;
        this.leapmonth = z11 ? 1 : 0;
    }

    private CustomTimePicker$SavedState(Parcel parcel) {
        super(parcel);
        this.h = parcel.readInt();
        this.min = parcel.readInt();
        this.y = parcel.readInt();
        this.mon = parcel.readInt();
        this.d = parcel.readInt();
        this.lunar = parcel.readInt();
        this.leapmonth = parcel.readInt();
    }
}
