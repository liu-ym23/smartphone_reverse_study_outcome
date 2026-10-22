package com.stepos.digitalwellbeing.server.data;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public abstract class StepOSUsageStats implements Parcelable {
    private int mInterval;
    private long mStartTime;
    private long mUpdateTime;

    public StepOSUsageStats() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getInterval() {
        return this.mInterval;
    }

    public long getStartTime() {
        return this.mStartTime;
    }

    public long getUpdateTime() {
        return this.mUpdateTime;
    }

    public void setInterval(int i5) {
        this.mInterval = i5;
    }

    public void setStartTime(long j5) {
        this.mStartTime = j5;
    }

    public void setUpdateTime(long j5) {
        this.mUpdateTime = j5;
    }

    public String toString() {
        return getClass().getSimpleName() + " [#" + hashCode() + "]  {mInterval=" + this.mInterval + ", mStartTime=" + this.mStartTime + ", mUpdateTime=" + this.mUpdateTime + " }";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i5) {
        parcel.writeInt(getInterval());
        parcel.writeLong(getStartTime());
        parcel.writeLong(getUpdateTime());
    }

    public StepOSUsageStats(int i5, long j5, long j6) {
        this.mInterval = i5;
        this.mStartTime = j5;
        this.mUpdateTime = j6;
    }

    protected StepOSUsageStats(Parcel parcel) {
        setInterval(parcel.readInt());
        setStartTime(parcel.readLong());
        setUpdateTime(parcel.readLong());
    }
}
