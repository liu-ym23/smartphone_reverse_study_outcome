package com.tencent.bugly.crashreport.common.strategy;

import Z7.C1143o;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.Map;

/* loaded from: classes4.dex */
public class StrategyBean implements Parcelable {
    public static final Parcelable.Creator<StrategyBean> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    public static String f31447a = "https://android.bugly.qq.com/rqd/async";

    /* renamed from: b, reason: collision with root package name */
    public static String f31448b = "https://android.bugly.qq.com/rqd/async";

    /* renamed from: c, reason: collision with root package name */
    public static String f31449c;

    /* renamed from: d, reason: collision with root package name */
    public long f31450d;

    /* renamed from: e, reason: collision with root package name */
    public long f31451e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f31452f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f31453g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f31454h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f31455i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f31456j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f31457k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f31458l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f31459m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f31460n;

    /* renamed from: o, reason: collision with root package name */
    public long f31461o;

    /* renamed from: p, reason: collision with root package name */
    public long f31462p;

    /* renamed from: q, reason: collision with root package name */
    public String f31463q;

    /* renamed from: r, reason: collision with root package name */
    public String f31464r;

    /* renamed from: s, reason: collision with root package name */
    public String f31465s;

    /* renamed from: t, reason: collision with root package name */
    public Map<String, String> f31466t;

    /* renamed from: u, reason: collision with root package name */
    public int f31467u;

    /* renamed from: v, reason: collision with root package name */
    public long f31468v;

    /* renamed from: w, reason: collision with root package name */
    public long f31469w;

    public static class a implements Parcelable.Creator<StrategyBean> {
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ StrategyBean createFromParcel(Parcel parcel) {
            return new StrategyBean(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ StrategyBean[] newArray(int i10) {
            return new StrategyBean[i10];
        }
    }

    public StrategyBean() {
        this.f31450d = -1L;
        this.f31451e = -1L;
        this.f31452f = true;
        this.f31453g = true;
        this.f31454h = true;
        this.f31455i = true;
        this.f31456j = false;
        this.f31457k = true;
        this.f31458l = true;
        this.f31459m = true;
        this.f31460n = true;
        this.f31462p = 30000L;
        this.f31463q = f31447a;
        this.f31464r = f31448b;
        this.f31467u = 10;
        this.f31468v = 300000L;
        this.f31469w = -1L;
        this.f31451e = System.currentTimeMillis();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("S(@L@L@)");
        f31449c = sb2.toString();
        sb2.setLength(0);
        sb2.append("*^@K#K@!");
        this.f31465s = sb2.toString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeLong(this.f31451e);
        parcel.writeByte(this.f31452f ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f31453g ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f31454h ? (byte) 1 : (byte) 0);
        parcel.writeString(this.f31463q);
        parcel.writeString(this.f31464r);
        parcel.writeString(this.f31465s);
        C1143o.D(parcel, this.f31466t);
        parcel.writeByte(this.f31455i ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f31456j ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f31459m ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f31460n ? (byte) 1 : (byte) 0);
        parcel.writeLong(this.f31462p);
        parcel.writeByte(this.f31457k ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f31458l ? (byte) 1 : (byte) 0);
        parcel.writeLong(this.f31461o);
        parcel.writeInt(this.f31467u);
        parcel.writeLong(this.f31468v);
        parcel.writeLong(this.f31469w);
    }

    public StrategyBean(Parcel parcel) {
        this.f31450d = -1L;
        this.f31451e = -1L;
        boolean z10 = true;
        this.f31452f = true;
        this.f31453g = true;
        this.f31454h = true;
        this.f31455i = true;
        this.f31456j = false;
        this.f31457k = true;
        this.f31458l = true;
        this.f31459m = true;
        this.f31460n = true;
        this.f31462p = 30000L;
        this.f31463q = f31447a;
        this.f31464r = f31448b;
        this.f31467u = 10;
        this.f31468v = 300000L;
        this.f31469w = -1L;
        try {
            f31449c = "S(@L@L@)";
            this.f31451e = parcel.readLong();
            this.f31452f = parcel.readByte() == 1;
            this.f31453g = parcel.readByte() == 1;
            this.f31454h = parcel.readByte() == 1;
            this.f31463q = parcel.readString();
            this.f31464r = parcel.readString();
            this.f31465s = parcel.readString();
            this.f31466t = C1143o.B(parcel);
            this.f31455i = parcel.readByte() == 1;
            this.f31456j = parcel.readByte() == 1;
            this.f31459m = parcel.readByte() == 1;
            this.f31460n = parcel.readByte() == 1;
            this.f31462p = parcel.readLong();
            this.f31457k = parcel.readByte() == 1;
            if (parcel.readByte() != 1) {
                z10 = false;
            }
            this.f31458l = z10;
            this.f31461o = parcel.readLong();
            this.f31467u = parcel.readInt();
            this.f31468v = parcel.readLong();
            this.f31469w = parcel.readLong();
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }
}
