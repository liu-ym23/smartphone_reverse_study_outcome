package com.stepos.digitalwellbeing.server.data;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class UsingTimeStats extends StepOSUsageStats {
    public static final Parcelable.Creator<UsingTimeStats> CREATOR = new a();
    private long mUsingTime;

    class a implements Parcelable.Creator<UsingTimeStats> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public UsingTimeStats createFromParcel(Parcel parcel) {
            return new UsingTimeStats(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public UsingTimeStats[] newArray(int i5) {
            return new UsingTimeStats[i5];
        }
    }

    public UsingTimeStats() {
    }

    @Override // com.stepos.digitalwellbeing.server.data.StepOSUsageStats, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public long getUsingTime() {
        return this.mUsingTime;
    }

    public void setUsingTime(long j5) {
        this.mUsingTime = j5;
    }

    @Override // com.stepos.digitalwellbeing.server.data.StepOSUsageStats
    public String toString() {
        String string = super.toString();
        int length = string.length();
        return new StringBuilder(string).replace(length - 2, length, ", mUsingTime = " + getUsingTime() + " }").toString();
    }

    @Override // com.stepos.digitalwellbeing.server.data.StepOSUsageStats, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i5) {
        super.writeToParcel(parcel, i5);
        parcel.writeLong(getUsingTime());
    }

    public UsingTimeStats(int i5, long j5, long j6, long j7) {
        super(i5, j5, j6);
        setUsingTime(j7);
    }

    protected UsingTimeStats(Parcel parcel) {
        super(parcel);
        setUsingTime(parcel.readLong());
    }
}
