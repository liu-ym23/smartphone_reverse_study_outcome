package com.stepos.digitalwellbeing.server.data;

import Y1.l;
import android.os.Parcel;
import android.os.Parcelable;
import com.stepos.digitalwellbeing.server.limit.data.room.PackageLimit;
import com.stepos.familyguard.db.entity.PackageLimitCache;

/* loaded from: classes.dex */
public class PackageLimitInfo extends LimitInfo {
    public static final Parcelable.Creator<PackageLimitInfo> CREATOR = new a();
    private String mPackageName;

    class a implements Parcelable.Creator<PackageLimitInfo> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public PackageLimitInfo createFromParcel(Parcel parcel) {
            return new PackageLimitInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public PackageLimitInfo[] newArray(int i5) {
            return new PackageLimitInfo[i5];
        }
    }

    public PackageLimitInfo(int i5, long j5, long j6, long j7, long j8, boolean z5, boolean z6, boolean z7, String str) {
        super(i5, j5, j6, j7, j8, z5, z6, z7);
        setPackageName(str);
    }

    @Override // com.stepos.digitalwellbeing.server.data.LimitInfo, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getPackageName() {
        return this.mPackageName;
    }

    public final void setPackageName(String str) {
        this.mPackageName = str;
    }

    @Override // com.stepos.digitalwellbeing.server.data.LimitInfo
    public String toString() {
        String string = super.toString();
        int length = string.length();
        return new StringBuilder(string).replace(length - 2, length, ", mPackageName = " + getPackageName() + " }").toString();
    }

    @Override // com.stepos.digitalwellbeing.server.data.LimitInfo, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i5) {
        super.writeToParcel(parcel, i5);
        parcel.writeString(this.mPackageName);
    }

    public PackageLimitInfo(PackageLimitCache packageLimitCache) {
        this(packageLimitCache.toPackageLimit(), packageLimitCache.getLastHandleTime());
    }

    public PackageLimitInfo(PackageLimit packageLimit, long j5) {
        super(packageLimit.getInterval(), j5, 0L, packageLimit.getWorkdayLimit(), packageLimit.getOffDayLimit(), packageLimit.isEnable(), packageLimit.isNotifyOnly(), l.T0(packageLimit.getPackageName()));
        setPackageName(packageLimit.getPackageName());
    }

    protected PackageLimitInfo(Parcel parcel) {
        super(parcel);
        setPackageName(parcel.readString());
    }
}
