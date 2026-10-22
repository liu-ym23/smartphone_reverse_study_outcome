package com.stepos.digitalwellbeing.server.data;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class PickupTimesStats extends StepOSUsageStats {
    public static final Parcelable.Creator<PickupTimesStats> CREATOR = new a();
    private int mPickupTimes;

    class a implements Parcelable.Creator<PickupTimesStats> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public PickupTimesStats createFromParcel(Parcel parcel) {
            return new PickupTimesStats(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public PickupTimesStats[] newArray(int i5) {
            return new PickupTimesStats[i5];
        }
    }

    public PickupTimesStats(int i5, long j5, long j6, int i6) {
        super(i5, j5, j6);
        setPickupTimes(i6);
    }

    @Override // com.stepos.digitalwellbeing.server.data.StepOSUsageStats, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getPickupTimes() {
        return this.mPickupTimes;
    }

    public void setPickupTimes(int i5) {
        this.mPickupTimes = i5;
    }

    @Override // com.stepos.digitalwellbeing.server.data.StepOSUsageStats
    public String toString() {
        String string = super.toString();
        int length = string.length();
        return new StringBuilder(string).replace(length - 2, length, ", mPickupTimes = " + getPickupTimes() + " }").toString();
    }

    @Override // com.stepos.digitalwellbeing.server.data.StepOSUsageStats, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i5) {
        super.writeToParcel(parcel, i5);
        parcel.writeInt(getPickupTimes());
    }

    protected PickupTimesStats(Parcel parcel) {
        super(parcel);
        setPickupTimes(parcel.readInt());
    }
}
