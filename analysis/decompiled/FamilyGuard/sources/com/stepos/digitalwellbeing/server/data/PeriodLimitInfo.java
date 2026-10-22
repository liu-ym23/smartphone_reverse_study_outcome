package com.stepos.digitalwellbeing.server.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.stepos.digitalwellbeing.server.limit.data.room.PeriodLimit;
import com.stepos.familyguard.db.entity.PeriodLimitCache;

/* loaded from: classes.dex */
public class PeriodLimitInfo implements Parcelable {
    public static final Parcelable.Creator<PeriodLimitInfo> CREATOR = new a();
    private static final String TAG = "PeriodLimitInfo";
    private long adminId;
    private long categoryId;
    private boolean enable;
    private long id;
    private boolean notifyOnly;
    private String packageName;
    private int type;

    class a implements Parcelable.Creator<PeriodLimitInfo> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public PeriodLimitInfo createFromParcel(Parcel parcel) {
            return new PeriodLimitInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public PeriodLimitInfo[] newArray(int i5) {
            return new PeriodLimitInfo[i5];
        }
    }

    protected PeriodLimitInfo(Parcel parcel) {
        this.id = parcel.readLong();
        this.type = parcel.readInt();
        this.packageName = parcel.readString();
        this.categoryId = parcel.readLong();
        this.adminId = parcel.readLong();
        this.notifyOnly = parcel.readByte() != 0;
        this.enable = parcel.readByte() != 0;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public long getAdminId() {
        return this.adminId;
    }

    public long getCategoryId() {
        return this.categoryId;
    }

    public long getId() {
        return this.id;
    }

    public String getPackageName() {
        return this.packageName;
    }

    public int getType() {
        return this.type;
    }

    public boolean isEnable() {
        return this.enable;
    }

    public boolean isNotifyOnly() {
        return this.notifyOnly;
    }

    public void setAdminId(long j5) {
        this.adminId = j5;
    }

    public void setCategoryId(long j5) {
        this.categoryId = j5;
    }

    public void setEnable(boolean z5) {
        this.enable = z5;
    }

    public void setId(long j5) {
        this.id = j5;
    }

    public void setNotifyOnly(boolean z5) {
        this.notifyOnly = z5;
    }

    public void setPackageName(String str) {
        this.packageName = str;
    }

    public void setType(int i5) {
        this.type = i5;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i5) {
        parcel.writeLong(this.id);
        parcel.writeInt(this.type);
        parcel.writeString(this.packageName);
        parcel.writeLong(this.categoryId);
        parcel.writeLong(this.adminId);
        parcel.writeByte(this.notifyOnly ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.enable ? (byte) 1 : (byte) 0);
    }

    public PeriodLimitInfo(long j5, int i5, String str, long j6, long j7, boolean z5, boolean z6) {
        this.id = j5;
        this.type = i5;
        this.packageName = str;
        this.categoryId = j6;
        this.adminId = j7;
        this.notifyOnly = z5;
        this.enable = z6;
    }

    public PeriodLimitInfo(PeriodLimit periodLimit) {
        this(periodLimit.getId(), periodLimit.getType(), periodLimit.getPackageName(), periodLimit.getCategoryId(), periodLimit.getAdminId(), periodLimit.isNotifyOnly(), periodLimit.isEnable());
    }

    public PeriodLimitInfo(PeriodLimitCache periodLimitCache) {
        this(periodLimitCache.getPeriodLimitId(), periodLimitCache.getType(), periodLimitCache.getPackageName(), periodLimitCache.getCategoryId(), periodLimitCache.getRelationId(), periodLimitCache.isNotifyOnly(), periodLimitCache.isEnable());
    }
}
