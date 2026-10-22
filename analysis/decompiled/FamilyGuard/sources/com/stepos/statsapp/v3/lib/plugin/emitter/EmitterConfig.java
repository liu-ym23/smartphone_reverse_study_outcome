package com.stepos.statsapp.v3.lib.plugin.emitter;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class EmitterConfig implements Parcelable {
    public static final Parcelable.Creator<EmitterConfig> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    boolean f15878a;

    /* renamed from: b, reason: collision with root package name */
    boolean f15879b;

    /* renamed from: c, reason: collision with root package name */
    boolean f15880c;

    /* renamed from: d, reason: collision with root package name */
    boolean f15881d;

    /* renamed from: e, reason: collision with root package name */
    boolean f15882e;

    /* renamed from: f, reason: collision with root package name */
    long f15883f;

    /* renamed from: g, reason: collision with root package name */
    int f15884g;

    /* renamed from: h, reason: collision with root package name */
    long f15885h;

    /* renamed from: i, reason: collision with root package name */
    int f15886i;

    /* renamed from: j, reason: collision with root package name */
    private String f15887j;

    /* renamed from: k, reason: collision with root package name */
    private String f15888k;

    class a implements Parcelable.Creator<EmitterConfig> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public EmitterConfig createFromParcel(Parcel parcel) {
            return new EmitterConfig(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public EmitterConfig[] newArray(int i5) {
            return new EmitterConfig[i5];
        }
    }

    public EmitterConfig(String str, String str2) {
        this.f15878a = true;
        this.f15880c = true;
        this.f15881d = true;
        this.f15882e = true;
        this.f15883f = 1800000L;
        this.f15884g = 50;
        this.f15885h = 2097152L;
        this.f15886i = 10;
        this.f15887j = str;
        this.f15888k = str2;
    }

    public String a() {
        return this.f15887j;
    }

    public String c() {
        return this.f15888k;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean f() {
        return this.f15878a;
    }

    public String toString() {
        return "EmitterConfig{active=" + this.f15878a + ", flushOnStart=" + this.f15880c + ", flushOnCharge=" + this.f15881d + ", flushOnReconnect=" + this.f15882e + ", flushDelayInterval=" + this.f15883f + ", flushCacheLimit=" + this.f15884g + ", flushMobileTrafficLimit=" + this.f15885h + ", neartimeInterval=" + this.f15886i + ", appID='" + this.f15887j + "', channel='" + this.f15888k + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i5) {
        parcel.writeByte(this.f15879b ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f15878a ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f15880c ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f15881d ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f15882e ? (byte) 1 : (byte) 0);
        parcel.writeLong(this.f15883f);
        parcel.writeInt(this.f15884g);
        parcel.writeLong(this.f15885h);
        parcel.writeString(this.f15887j);
        parcel.writeString(this.f15888k);
    }

    protected EmitterConfig(Parcel parcel) {
        this.f15878a = true;
        this.f15880c = true;
        this.f15881d = true;
        this.f15882e = true;
        this.f15883f = 1800000L;
        this.f15884g = 50;
        this.f15885h = 2097152L;
        this.f15886i = 10;
        this.f15879b = parcel.readByte() != 0;
        this.f15878a = parcel.readByte() != 0;
        this.f15880c = parcel.readByte() != 0;
        this.f15881d = parcel.readByte() != 0;
        this.f15882e = parcel.readByte() != 0;
        this.f15883f = parcel.readLong();
        this.f15884g = parcel.readInt();
        this.f15885h = parcel.readLong();
        this.f15887j = parcel.readString();
        this.f15888k = parcel.readString();
    }
}
