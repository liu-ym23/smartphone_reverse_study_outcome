package com.autonavi.aps.amapapi;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class AMapLocationStaticsEntity implements Parcelable {
    public static final String CONTINUE_LOCATE = "conitue";
    public static final Parcelable.Creator<AMapLocationStaticsEntity> CREATOR = new Parcelable.Creator<AMapLocationStaticsEntity>() { // from class: com.autonavi.aps.amapapi.AMapLocationStaticsEntity.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AMapLocationStaticsEntity createFromParcel(Parcel parcel) {
            AMapLocationStaticsEntity aMapLocationStaticsEntity = new AMapLocationStaticsEntity();
            aMapLocationStaticsEntity.setDNSStaus(parcel.readString());
            aMapLocationStaticsEntity.setDominStatus(parcel.readString());
            aMapLocationStaticsEntity.setLocationType(parcel.readString());
            aMapLocationStaticsEntity.setReason(parcel.readString());
            aMapLocationStaticsEntity.setIP(parcel.readString());
            aMapLocationStaticsEntity.setStartTime(parcel.readLong());
            aMapLocationStaticsEntity.setEndTime(parcel.readLong());
            aMapLocationStaticsEntity.setNetStartTime(parcel.readLong());
            aMapLocationStaticsEntity.setNetEndTime(parcel.readLong());
            aMapLocationStaticsEntity.setStackType(parcel.readString());
            return aMapLocationStaticsEntity;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AMapLocationStaticsEntity[] newArray(int i10) {
            return new AMapLocationStaticsEntity[i10];
        }
    };
    public static final String FAIL_STATUS = "FAIL";
    public static final String FIRST_LOCATE = "first";
    public static final String IPV4 = "v4";
    public static final String IPV6 = "v6";
    public static final String STATICS_LOCATE = "statics";
    public static final String SUCCESS_STATUS = "SUCCESS";

    /* renamed from: e, reason: collision with root package name */
    private String f18184e;

    /* renamed from: f, reason: collision with root package name */
    private String f18185f;

    /* renamed from: a, reason: collision with root package name */
    private long f18180a = 0;

    /* renamed from: b, reason: collision with root package name */
    private long f18181b = 0;

    /* renamed from: c, reason: collision with root package name */
    private long f18182c = 0;

    /* renamed from: d, reason: collision with root package name */
    private long f18183d = 0;

    /* renamed from: g, reason: collision with root package name */
    private String f18186g = FIRST_LOCATE;

    /* renamed from: h, reason: collision with root package name */
    private String f18187h = "";

    /* renamed from: i, reason: collision with root package name */
    private String f18188i = "";

    /* renamed from: j, reason: collision with root package name */
    private String f18189j = null;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public long getContinueTime() {
        long j10 = this.f18181b;
        long j11 = this.f18180a;
        if (j10 <= j11) {
            return 0L;
        }
        return j10 - j11;
    }

    public String getDNSStaus() {
        return this.f18184e;
    }

    public String getDominStatus() {
        return this.f18185f;
    }

    public long getEndTime() {
        return this.f18181b;
    }

    public String getIP() {
        return this.f18189j;
    }

    public String getLocationType() {
        return this.f18186g;
    }

    public long getNetEndTime() {
        return this.f18183d;
    }

    public long getNetStartTime() {
        return this.f18182c;
    }

    public long getNetUseTime() {
        long j10 = this.f18183d - this.f18182c;
        if (j10 <= 0) {
            return 0L;
        }
        return j10;
    }

    public String getReason() {
        return this.f18187h;
    }

    public String getStackType() {
        return this.f18188i;
    }

    public long getStartTime() {
        return this.f18180a;
    }

    public void setDNSStaus(String str) {
        this.f18184e = str;
    }

    public void setDominStatus(String str) {
        this.f18185f = str;
    }

    public void setEndTime(long j10) {
        this.f18181b = j10;
    }

    public void setIP(String str) {
        this.f18189j = str;
    }

    public void setLocationType(String str) {
        this.f18186g = str;
    }

    public void setNetEndTime(long j10) {
        this.f18183d = j10;
    }

    public void setNetStartTime(long j10) {
        this.f18182c = j10;
    }

    public void setReason(String str) {
        this.f18187h = str;
    }

    public void setStackType(String str) {
        this.f18188i = str;
    }

    public void setStartTime(long j10) {
        this.f18180a = j10;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        try {
            parcel.writeString(this.f18184e);
            parcel.writeString(this.f18185f);
            parcel.writeString(this.f18186g);
            parcel.writeString(this.f18187h);
            parcel.writeString(this.f18189j);
            parcel.writeLong(this.f18180a);
            parcel.writeLong(this.f18181b);
            parcel.writeLong(this.f18182c);
            parcel.writeLong(this.f18183d);
            parcel.writeString(this.f18188i);
        } catch (Throwable unused) {
        }
    }
}
