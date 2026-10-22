package com.stepos.digitalwellbeing.server.data;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import f2.C0718w;

/* loaded from: classes.dex */
public class LimitInfo implements Parcelable {
    public static final Parcelable.Creator<LimitInfo> CREATOR = new a();
    private boolean mEnable;
    private int mInterval;
    private boolean mLimitable;
    private boolean mNotifyOnly;
    private long mOffDayLimit;
    private long mRemaining;
    private long mStartTime;
    private long mUpdateTime;
    private long mWorkdayLimit;

    class a implements Parcelable.Creator<LimitInfo> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public LimitInfo createFromParcel(Parcel parcel) {
            return new LimitInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public LimitInfo[] newArray(int i5) {
            return new LimitInfo[i5];
        }
    }

    public LimitInfo(int i5, long j5, long j6, long j7, long j8, boolean z5, boolean z6, boolean z7) {
        this.mInterval = i5;
        this.mUpdateTime = j5;
        this.mStartTime = j6;
        this.mWorkdayLimit = j7;
        this.mOffDayLimit = j8;
        this.mEnable = z5;
        this.mNotifyOnly = z6;
        this.mLimitable = z7;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public long getCurrentLimit(Context context) {
        return C0718w.g().i() ? getWorkdayLimit() : getOffDayLimit();
    }

    public int getInterval() {
        return this.mInterval;
    }

    public long getOffDayLimit() {
        return this.mOffDayLimit;
    }

    public long getRemaining() {
        return this.mRemaining;
    }

    public long getStartTime() {
        return this.mStartTime;
    }

    public long getUpdateTime() {
        return this.mUpdateTime;
    }

    public long getWorkdayLimit() {
        return this.mWorkdayLimit;
    }

    public boolean isEnable() {
        return this.mEnable;
    }

    public boolean isLimitable() {
        return this.mLimitable;
    }

    public boolean isNotifyOnly() {
        return this.mNotifyOnly;
    }

    public void setEnable(boolean z5) {
        this.mEnable = z5;
    }

    public void setInterval(int i5) {
        this.mInterval = i5;
    }

    public void setLimitable(boolean z5) {
        this.mLimitable = z5;
    }

    public void setNotifyOnly(boolean z5) {
        this.mNotifyOnly = z5;
    }

    public void setOffDayLimit(long j5) {
        this.mOffDayLimit = j5;
    }

    public void setRemaining(long j5) {
        this.mRemaining = j5;
    }

    public void setStartTime(long j5) {
        this.mStartTime = j5;
    }

    public void setUpdateTime(long j5) {
        this.mUpdateTime = j5;
    }

    public void setWorkdayLimit(long j5) {
        this.mWorkdayLimit = j5;
    }

    public String toString() {
        return getClass().getSimpleName() + " [#" + hashCode() + "]  {mInterval=" + this.mInterval + ", mUpdateTime=" + this.mUpdateTime + ", mStartTime=" + this.mStartTime + ", mWorkdayLimit=" + this.mWorkdayLimit + ", mOffDayLimit=" + this.mOffDayLimit + ", mRemaining=" + this.mRemaining + ", mEnable=" + this.mEnable + ", mNotifyOnly=" + this.mNotifyOnly + ", mLimitable=" + this.mLimitable + " }";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i5) {
        parcel.writeInt(getInterval());
        parcel.writeLong(getStartTime());
        parcel.writeLong(getUpdateTime());
        parcel.writeLong(getWorkdayLimit());
        parcel.writeLong(getOffDayLimit());
        parcel.writeLong(getRemaining());
        parcel.writeInt(isEnable() ? 1 : 0);
        parcel.writeInt(isNotifyOnly() ? 1 : 0);
        parcel.writeInt(isLimitable() ? 1 : 0);
    }

    protected LimitInfo(Parcel parcel) {
        setInterval(parcel.readInt());
        setStartTime(parcel.readLong());
        setUpdateTime(parcel.readLong());
        setWorkdayLimit(parcel.readLong());
        setOffDayLimit(parcel.readLong());
        setRemaining(parcel.readLong());
        setEnable(parcel.readInt() > 0);
        setNotifyOnly(parcel.readInt() > 0);
        setLimitable(parcel.readInt() > 0);
    }
}
