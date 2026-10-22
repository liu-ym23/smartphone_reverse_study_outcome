package com.stepos.common.widget;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
class CustomTimePicker$SavedState extends View.BaseSavedState {
    public static final Parcelable.Creator<CustomTimePicker$SavedState> CREATOR = new a();

    /* renamed from: d, reason: collision with root package name */
    private final int f6831d;
    private final int h;
    private final int leapmonth;
    private final int lunar;
    private final int min;
    private final int mon;

    /* renamed from: y, reason: collision with root package name */
    private final int f6832y;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class a implements Parcelable.Creator<CustomTimePicker$SavedState> {
        @Override // android.os.Parcelable.Creator
        public final CustomTimePicker$SavedState createFromParcel(Parcel parcel) {
            return new CustomTimePicker$SavedState(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final CustomTimePicker$SavedState[] newArray(int i10) {
            return new CustomTimePicker$SavedState[i10];
        }
    }

    @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        super.writeToParcel(parcel, i10);
        parcel.writeInt(this.h);
        parcel.writeInt(this.min);
        parcel.writeInt(this.f6832y);
        parcel.writeInt(this.mon);
        parcel.writeInt(this.f6831d);
        parcel.writeInt(this.lunar);
        parcel.writeInt(this.leapmonth);
    }

    private CustomTimePicker$SavedState(Parcelable parcelable, int i10, int i11, int i12, int i13, int i14, boolean z, boolean z3) {
        super(parcelable);
        this.h = i10;
        this.min = i11;
        this.f6832y = i12;
        this.mon = i13;
        this.f6831d = i14;
        this.lunar = z ? 1 : 0;
        this.leapmonth = z3 ? 1 : 0;
    }

    private CustomTimePicker$SavedState(Parcel parcel) {
        super(parcel);
        this.h = parcel.readInt();
        this.min = parcel.readInt();
        this.f6832y = parcel.readInt();
        this.mon = parcel.readInt();
        this.f6831d = parcel.readInt();
        this.lunar = parcel.readInt();
        this.leapmonth = parcel.readInt();
    }
}
