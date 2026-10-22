package com.stepos.digitalwellbeing.server.data;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class PackageUsingTimeStats extends UsingTimeStats {
    public static final Parcelable.Creator<PackageUsingTimeStats> CREATOR = new a();
    private String mPackageName;

    class a implements Parcelable.Creator<PackageUsingTimeStats> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public PackageUsingTimeStats createFromParcel(Parcel parcel) {
            return new PackageUsingTimeStats(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public PackageUsingTimeStats[] newArray(int i5) {
            return new PackageUsingTimeStats[i5];
        }
    }

    public PackageUsingTimeStats() {
    }

    @Override // com.stepos.digitalwellbeing.server.data.UsingTimeStats, com.stepos.digitalwellbeing.server.data.StepOSUsageStats, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getPackageName() {
        return this.mPackageName;
    }

    public final void setPackageName(String str) {
        this.mPackageName = str;
    }

    @Override // com.stepos.digitalwellbeing.server.data.UsingTimeStats, com.stepos.digitalwellbeing.server.data.StepOSUsageStats
    public String toString() {
        String string = super.toString();
        int length = string.length();
        return new StringBuilder(string).replace(length - 2, length, ", mPackageName = " + getPackageName() + " }").toString();
    }

    @Override // com.stepos.digitalwellbeing.server.data.UsingTimeStats, com.stepos.digitalwellbeing.server.data.StepOSUsageStats, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i5) {
        super.writeToParcel(parcel, i5);
        parcel.writeString(getPackageName());
    }

    public PackageUsingTimeStats(int i5, long j5, long j6, long j7, String str) {
        super(i5, j5, j6, j7);
        setPackageName(str);
    }

    protected PackageUsingTimeStats(Parcel parcel) {
        super(parcel);
        setPackageName(parcel.readString());
    }
}
