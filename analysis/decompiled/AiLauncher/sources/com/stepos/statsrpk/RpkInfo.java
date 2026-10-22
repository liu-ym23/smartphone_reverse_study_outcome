package com.stepos.statsrpk;

import android.os.Parcel;
import android.os.Parcelable;
import com.autonavi.aps.amapapi.config.Const;

/* loaded from: classes2.dex */
public class RpkInfo implements Parcelable {
    public static final Parcelable.Creator<RpkInfo> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    public String f31011a;

    /* renamed from: b, reason: collision with root package name */
    public String f31012b;

    /* renamed from: c, reason: collision with root package name */
    public int f31013c;

    /* renamed from: d, reason: collision with root package name */
    public String f31014d;

    /* renamed from: e, reason: collision with root package name */
    public String f31015e;

    public class a implements Parcelable.Creator<RpkInfo> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public RpkInfo createFromParcel(Parcel parcel) {
            return new RpkInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public RpkInfo[] newArray(int i10) {
            return new RpkInfo[i10];
        }
    }

    public RpkInfo() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "[" + this.f31011a + Const.STR_MART_COMMA + this.f31012b + Const.STR_MART_COMMA + this.f31013c + Const.STR_MART_COMMA + this.f31014d + Const.STR_MART_COMMA + this.f31015e + "]";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f31011a);
        parcel.writeString(this.f31012b);
        parcel.writeInt(this.f31013c);
        parcel.writeString(this.f31014d);
        parcel.writeString(this.f31015e);
    }

    public RpkInfo(Parcel parcel) {
        this.f31011a = parcel.readString();
        this.f31012b = parcel.readString();
        this.f31013c = parcel.readInt();
        this.f31014d = parcel.readString();
        this.f31015e = parcel.readString();
    }
}
