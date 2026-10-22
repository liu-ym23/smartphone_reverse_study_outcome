package com.stepos.common.widget;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;

/* loaded from: classes3.dex */
class CustomTimePicker$SavedState extends View.BaseSavedState {
    public static final Parcelable.Creator<CustomTimePicker$SavedState> CREATOR = new a();

    /* renamed from: d, reason: collision with root package name */
    private final int f29516d;

    /* renamed from: h, reason: collision with root package name */
    private final int f29517h;
    private final int leapmonth;
    private final int lunar;
    private final int min;
    private final int mon;

    /* renamed from: y, reason: collision with root package name */
    private final int f29518y;

    public class a implements Parcelable.Creator<CustomTimePicker$SavedState> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public CustomTimePicker$SavedState createFromParcel(Parcel parcel) {
            return new CustomTimePicker$SavedState(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public CustomTimePicker$SavedState[] newArray(int i10) {
            return new CustomTimePicker$SavedState[i10];
        }
    }

    @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        super.writeToParcel(parcel, i10);
        parcel.writeInt(this.f29517h);
        parcel.writeInt(this.min);
        parcel.writeInt(this.f29518y);
        parcel.writeInt(this.mon);
        parcel.writeInt(this.f29516d);
        parcel.writeInt(this.lunar);
        parcel.writeInt(this.leapmonth);
    }

    private CustomTimePicker$SavedState(Parcelable parcelable, int i10, int i11, int i12, int i13, int i14, boolean z10, boolean z11) {
        super(parcelable);
        this.f29517h = i10;
        this.min = i11;
        this.f29518y = i12;
        this.mon = i13;
        this.f29516d = i14;
        this.lunar = z10 ? 1 : 0;
        this.leapmonth = z11 ? 1 : 0;
    }

    private CustomTimePicker$SavedState(Parcel parcel) {
        super(parcel);
        this.f29517h = parcel.readInt();
        this.min = parcel.readInt();
        this.f29518y = parcel.readInt();
        this.mon = parcel.readInt();
        this.f29516d = parcel.readInt();
        this.lunar = parcel.readInt();
        this.leapmonth = parcel.readInt();
    }
}
