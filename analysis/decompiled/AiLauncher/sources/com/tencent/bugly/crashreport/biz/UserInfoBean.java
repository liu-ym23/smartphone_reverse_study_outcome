package com.tencent.bugly.crashreport.biz;

import Z7.C1143o;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.Map;

/* loaded from: classes4.dex */
public class UserInfoBean implements Parcelable {
    public static final Parcelable.Creator<UserInfoBean> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    public long f31425a;

    /* renamed from: b, reason: collision with root package name */
    public int f31426b;

    /* renamed from: c, reason: collision with root package name */
    public String f31427c;

    /* renamed from: d, reason: collision with root package name */
    public String f31428d;

    /* renamed from: e, reason: collision with root package name */
    public long f31429e;

    /* renamed from: f, reason: collision with root package name */
    public long f31430f;

    /* renamed from: g, reason: collision with root package name */
    public long f31431g;

    /* renamed from: h, reason: collision with root package name */
    public long f31432h;

    /* renamed from: i, reason: collision with root package name */
    public long f31433i;

    /* renamed from: j, reason: collision with root package name */
    public String f31434j;

    /* renamed from: k, reason: collision with root package name */
    public long f31435k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f31436l;

    /* renamed from: m, reason: collision with root package name */
    public String f31437m;

    /* renamed from: n, reason: collision with root package name */
    public String f31438n;

    /* renamed from: o, reason: collision with root package name */
    public int f31439o;

    /* renamed from: p, reason: collision with root package name */
    public int f31440p;

    /* renamed from: q, reason: collision with root package name */
    public int f31441q;

    /* renamed from: r, reason: collision with root package name */
    public Map<String, String> f31442r;

    /* renamed from: s, reason: collision with root package name */
    public Map<String, String> f31443s;

    public static class a implements Parcelable.Creator<UserInfoBean> {
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ UserInfoBean createFromParcel(Parcel parcel) {
            return new UserInfoBean(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ UserInfoBean[] newArray(int i10) {
            return new UserInfoBean[i10];
        }
    }

    public UserInfoBean() {
        this.f31435k = 0L;
        this.f31436l = false;
        this.f31437m = "unknown";
        this.f31440p = -1;
        this.f31441q = -1;
        this.f31442r = null;
        this.f31443s = null;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.f31426b);
        parcel.writeString(this.f31427c);
        parcel.writeString(this.f31428d);
        parcel.writeLong(this.f31429e);
        parcel.writeLong(this.f31430f);
        parcel.writeLong(this.f31431g);
        parcel.writeLong(this.f31432h);
        parcel.writeLong(this.f31433i);
        parcel.writeString(this.f31434j);
        parcel.writeLong(this.f31435k);
        parcel.writeByte(this.f31436l ? (byte) 1 : (byte) 0);
        parcel.writeString(this.f31437m);
        parcel.writeInt(this.f31440p);
        parcel.writeInt(this.f31441q);
        C1143o.D(parcel, this.f31442r);
        C1143o.D(parcel, this.f31443s);
        parcel.writeString(this.f31438n);
        parcel.writeInt(this.f31439o);
    }

    public UserInfoBean(Parcel parcel) {
        this.f31435k = 0L;
        this.f31436l = false;
        this.f31437m = "unknown";
        this.f31440p = -1;
        this.f31441q = -1;
        this.f31442r = null;
        this.f31443s = null;
        this.f31426b = parcel.readInt();
        this.f31427c = parcel.readString();
        this.f31428d = parcel.readString();
        this.f31429e = parcel.readLong();
        this.f31430f = parcel.readLong();
        this.f31431g = parcel.readLong();
        this.f31432h = parcel.readLong();
        this.f31433i = parcel.readLong();
        this.f31434j = parcel.readString();
        this.f31435k = parcel.readLong();
        this.f31436l = parcel.readByte() == 1;
        this.f31437m = parcel.readString();
        this.f31440p = parcel.readInt();
        this.f31441q = parcel.readInt();
        this.f31442r = C1143o.B(parcel);
        this.f31443s = C1143o.B(parcel);
        this.f31438n = parcel.readString();
        this.f31439o = parcel.readInt();
    }
}
