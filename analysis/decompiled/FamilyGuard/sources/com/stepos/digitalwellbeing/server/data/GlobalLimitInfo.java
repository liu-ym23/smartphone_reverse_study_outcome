package com.stepos.digitalwellbeing.server.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.stepos.digitalwellbeing.server.limit.data.room.GlobalLimit;
import com.stepos.familyguard.db.entity.GlobalLimitCache;

/* loaded from: classes.dex */
public class GlobalLimitInfo extends LimitInfo {
    public static final Parcelable.Creator<GlobalLimitInfo> CREATOR = new a();

    class a implements Parcelable.Creator<GlobalLimitInfo> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public GlobalLimitInfo createFromParcel(Parcel parcel) {
            return new GlobalLimitInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public GlobalLimitInfo[] newArray(int i5) {
            return new GlobalLimitInfo[i5];
        }
    }

    public GlobalLimitInfo(int i5, long j5, long j6, long j7, long j8, boolean z5, boolean z6, boolean z7) {
        super(i5, j5, j6, j7, j8, z5, z6, z7);
    }

    @Override // com.stepos.digitalwellbeing.server.data.LimitInfo, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.stepos.digitalwellbeing.server.data.LimitInfo
    public String toString() {
        String string = super.toString();
        int length = string.length();
        return new StringBuilder(string).replace(length - 2, length, " }").toString();
    }

    @Override // com.stepos.digitalwellbeing.server.data.LimitInfo, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i5) {
        super.writeToParcel(parcel, i5);
    }

    public GlobalLimitInfo(GlobalLimitCache globalLimitCache) {
        this(globalLimitCache.toGlobalLimit(), globalLimitCache.getLastHandleTime());
    }

    public GlobalLimitInfo(GlobalLimit globalLimit, long j5) {
        super(globalLimit.getInterval(), j5, 0L, globalLimit.getWorkdayLimit(), globalLimit.getOffDayLimit(), globalLimit.isEnable(), globalLimit.isNotifyOnly(), true);
    }

    protected GlobalLimitInfo(Parcel parcel) {
        super(parcel);
    }
}
