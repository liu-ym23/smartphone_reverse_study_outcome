package com.stepos.digitalwellbeing.server.data;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class NotificationTimesStats extends StepOSUsageStats {
    public static final Parcelable.Creator<NotificationTimesStats> CREATOR = new a();
    private int mNotificationTimes;

    class a implements Parcelable.Creator<NotificationTimesStats> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public NotificationTimesStats createFromParcel(Parcel parcel) {
            return new NotificationTimesStats(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public NotificationTimesStats[] newArray(int i5) {
            return new NotificationTimesStats[i5];
        }
    }

    public NotificationTimesStats(int i5, long j5, long j6, int i6) {
        super(i5, j5, j6);
        setNotificationTimes(i6);
    }

    @Override // com.stepos.digitalwellbeing.server.data.StepOSUsageStats, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getNotificationTimes() {
        return this.mNotificationTimes;
    }

    public void setNotificationTimes(int i5) {
        this.mNotificationTimes = i5;
    }

    @Override // com.stepos.digitalwellbeing.server.data.StepOSUsageStats
    public String toString() {
        String string = super.toString();
        int length = string.length();
        return new StringBuilder(string).replace(length - 2, length, ", mNotificationTimes = " + getNotificationTimes() + " }").toString();
    }

    @Override // com.stepos.digitalwellbeing.server.data.StepOSUsageStats, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i5) {
        super.writeToParcel(parcel, i5);
        parcel.writeInt(getNotificationTimes());
    }

    protected NotificationTimesStats(Parcel parcel) {
        super(parcel);
        setNotificationTimes(parcel.readInt());
    }
}
