package com.tencent.bugly.crashreport.crash;

import Z7.C1143o;
import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.bugly.crashreport.common.info.PlugInBean;
import java.util.Map;
import java.util.UUID;

/* loaded from: classes4.dex */
public class CrashDetailBean implements Parcelable, Comparable<CrashDetailBean> {
    public static final Parcelable.Creator<CrashDetailBean> CREATOR = new a();

    /* renamed from: A, reason: collision with root package name */
    public String f31470A;

    /* renamed from: B, reason: collision with root package name */
    public String f31471B;

    /* renamed from: C, reason: collision with root package name */
    public long f31472C;

    /* renamed from: D, reason: collision with root package name */
    public long f31473D;

    /* renamed from: E, reason: collision with root package name */
    public long f31474E;

    /* renamed from: F, reason: collision with root package name */
    public long f31475F;

    /* renamed from: G, reason: collision with root package name */
    public long f31476G;

    /* renamed from: H, reason: collision with root package name */
    public long f31477H;

    /* renamed from: I, reason: collision with root package name */
    public long f31478I;

    /* renamed from: J, reason: collision with root package name */
    public long f31479J;

    /* renamed from: K, reason: collision with root package name */
    public long f31480K;

    /* renamed from: L, reason: collision with root package name */
    public String f31481L;

    /* renamed from: M, reason: collision with root package name */
    public String f31482M;

    /* renamed from: N, reason: collision with root package name */
    public String f31483N;

    /* renamed from: O, reason: collision with root package name */
    public String f31484O;

    /* renamed from: P, reason: collision with root package name */
    public String f31485P;

    /* renamed from: Q, reason: collision with root package name */
    public long f31486Q;

    /* renamed from: R, reason: collision with root package name */
    public boolean f31487R;

    /* renamed from: S, reason: collision with root package name */
    public Map<String, String> f31488S;

    /* renamed from: T, reason: collision with root package name */
    public Map<String, String> f31489T;

    /* renamed from: U, reason: collision with root package name */
    public int f31490U;

    /* renamed from: V, reason: collision with root package name */
    public int f31491V;

    /* renamed from: W, reason: collision with root package name */
    public Map<String, String> f31492W;

    /* renamed from: X, reason: collision with root package name */
    public Map<String, String> f31493X;

    /* renamed from: Y, reason: collision with root package name */
    public byte[] f31494Y;

    /* renamed from: Z, reason: collision with root package name */
    public String f31495Z;

    /* renamed from: a, reason: collision with root package name */
    public long f31496a;

    /* renamed from: aa, reason: collision with root package name */
    public String f31497aa;

    /* renamed from: b, reason: collision with root package name */
    public int f31498b;

    /* renamed from: c, reason: collision with root package name */
    public String f31499c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f31500d;

    /* renamed from: e, reason: collision with root package name */
    public String f31501e;

    /* renamed from: f, reason: collision with root package name */
    public String f31502f;

    /* renamed from: g, reason: collision with root package name */
    public String f31503g;

    /* renamed from: h, reason: collision with root package name */
    public Map<String, PlugInBean> f31504h;

    /* renamed from: i, reason: collision with root package name */
    public Map<String, PlugInBean> f31505i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f31506j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f31507k;

    /* renamed from: l, reason: collision with root package name */
    public int f31508l;

    /* renamed from: m, reason: collision with root package name */
    public String f31509m;

    /* renamed from: n, reason: collision with root package name */
    public String f31510n;

    /* renamed from: o, reason: collision with root package name */
    public String f31511o;

    /* renamed from: p, reason: collision with root package name */
    public String f31512p;

    /* renamed from: q, reason: collision with root package name */
    public String f31513q;

    /* renamed from: r, reason: collision with root package name */
    public long f31514r;

    /* renamed from: s, reason: collision with root package name */
    public String f31515s;

    /* renamed from: t, reason: collision with root package name */
    public int f31516t;

    /* renamed from: u, reason: collision with root package name */
    public String f31517u;

    /* renamed from: v, reason: collision with root package name */
    public String f31518v;

    /* renamed from: w, reason: collision with root package name */
    public String f31519w;

    /* renamed from: x, reason: collision with root package name */
    public String f31520x;

    /* renamed from: y, reason: collision with root package name */
    public byte[] f31521y;

    /* renamed from: z, reason: collision with root package name */
    public Map<String, String> f31522z;

    public static class a implements Parcelable.Creator<CrashDetailBean> {
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ CrashDetailBean createFromParcel(Parcel parcel) {
            return new CrashDetailBean(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ CrashDetailBean[] newArray(int i10) {
            return new CrashDetailBean[i10];
        }
    }

    public CrashDetailBean() {
        this.f31496a = -1L;
        this.f31498b = 0;
        this.f31499c = UUID.randomUUID().toString();
        this.f31500d = false;
        this.f31501e = "";
        this.f31502f = "";
        this.f31503g = "";
        this.f31504h = null;
        this.f31505i = null;
        this.f31506j = false;
        this.f31507k = false;
        this.f31508l = 0;
        this.f31509m = "";
        this.f31510n = "";
        this.f31511o = "";
        this.f31512p = "";
        this.f31513q = "";
        this.f31514r = -1L;
        this.f31515s = null;
        this.f31516t = 0;
        this.f31517u = "";
        this.f31518v = "";
        this.f31519w = null;
        this.f31520x = null;
        this.f31521y = null;
        this.f31522z = null;
        this.f31470A = "";
        this.f31471B = "";
        this.f31472C = -1L;
        this.f31473D = -1L;
        this.f31474E = -1L;
        this.f31475F = -1L;
        this.f31476G = -1L;
        this.f31477H = -1L;
        this.f31478I = -1L;
        this.f31479J = -1L;
        this.f31480K = -1L;
        this.f31481L = "";
        this.f31482M = "";
        this.f31483N = "";
        this.f31484O = "";
        this.f31485P = "";
        this.f31486Q = -1L;
        this.f31487R = false;
        this.f31488S = null;
        this.f31489T = null;
        this.f31490U = -1;
        this.f31491V = -1;
        this.f31492W = null;
        this.f31493X = null;
        this.f31494Y = null;
        this.f31495Z = null;
        this.f31497aa = null;
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(CrashDetailBean crashDetailBean) {
        CrashDetailBean crashDetailBean2 = crashDetailBean;
        if (crashDetailBean2 == null) {
            return 1;
        }
        long j10 = this.f31514r - crashDetailBean2.f31514r;
        if (j10 <= 0) {
            return j10 < 0 ? -1 : 0;
        }
        return 1;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.f31498b);
        parcel.writeString(this.f31499c);
        parcel.writeByte(this.f31500d ? (byte) 1 : (byte) 0);
        parcel.writeString(this.f31501e);
        parcel.writeString(this.f31502f);
        parcel.writeString(this.f31503g);
        parcel.writeByte(this.f31506j ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f31507k ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.f31508l);
        parcel.writeString(this.f31509m);
        parcel.writeString(this.f31510n);
        parcel.writeString(this.f31511o);
        parcel.writeString(this.f31512p);
        parcel.writeString(this.f31513q);
        parcel.writeLong(this.f31514r);
        parcel.writeString(this.f31515s);
        parcel.writeInt(this.f31516t);
        parcel.writeString(this.f31517u);
        parcel.writeString(this.f31518v);
        parcel.writeString(this.f31519w);
        C1143o.D(parcel, this.f31522z);
        parcel.writeString(this.f31470A);
        parcel.writeString(this.f31471B);
        parcel.writeLong(this.f31472C);
        parcel.writeLong(this.f31473D);
        parcel.writeLong(this.f31474E);
        parcel.writeLong(this.f31475F);
        parcel.writeLong(this.f31476G);
        parcel.writeLong(this.f31477H);
        parcel.writeString(this.f31481L);
        parcel.writeString(this.f31482M);
        parcel.writeString(this.f31483N);
        parcel.writeString(this.f31484O);
        parcel.writeString(this.f31485P);
        parcel.writeLong(this.f31486Q);
        parcel.writeByte(this.f31487R ? (byte) 1 : (byte) 0);
        C1143o.D(parcel, this.f31488S);
        C1143o.r(parcel, this.f31504h);
        C1143o.r(parcel, this.f31505i);
        parcel.writeInt(this.f31490U);
        parcel.writeInt(this.f31491V);
        C1143o.D(parcel, this.f31492W);
        C1143o.D(parcel, this.f31493X);
        parcel.writeByteArray(this.f31494Y);
        parcel.writeByteArray(this.f31521y);
        parcel.writeString(this.f31495Z);
        parcel.writeString(this.f31497aa);
        parcel.writeString(this.f31520x);
        parcel.writeLong(this.f31478I);
        parcel.writeLong(this.f31479J);
        parcel.writeLong(this.f31480K);
    }

    public CrashDetailBean(Parcel parcel) {
        this.f31496a = -1L;
        this.f31498b = 0;
        this.f31499c = UUID.randomUUID().toString();
        this.f31500d = false;
        this.f31501e = "";
        this.f31502f = "";
        this.f31503g = "";
        this.f31504h = null;
        this.f31505i = null;
        this.f31506j = false;
        this.f31507k = false;
        this.f31508l = 0;
        this.f31509m = "";
        this.f31510n = "";
        this.f31511o = "";
        this.f31512p = "";
        this.f31513q = "";
        this.f31514r = -1L;
        this.f31515s = null;
        this.f31516t = 0;
        this.f31517u = "";
        this.f31518v = "";
        this.f31519w = null;
        this.f31520x = null;
        this.f31521y = null;
        this.f31522z = null;
        this.f31470A = "";
        this.f31471B = "";
        this.f31472C = -1L;
        this.f31473D = -1L;
        this.f31474E = -1L;
        this.f31475F = -1L;
        this.f31476G = -1L;
        this.f31477H = -1L;
        this.f31478I = -1L;
        this.f31479J = -1L;
        this.f31480K = -1L;
        this.f31481L = "";
        this.f31482M = "";
        this.f31483N = "";
        this.f31484O = "";
        this.f31485P = "";
        this.f31486Q = -1L;
        this.f31487R = false;
        this.f31488S = null;
        this.f31489T = null;
        this.f31490U = -1;
        this.f31491V = -1;
        this.f31492W = null;
        this.f31493X = null;
        this.f31494Y = null;
        this.f31495Z = null;
        this.f31497aa = null;
        this.f31498b = parcel.readInt();
        this.f31499c = parcel.readString();
        this.f31500d = parcel.readByte() == 1;
        this.f31501e = parcel.readString();
        this.f31502f = parcel.readString();
        this.f31503g = parcel.readString();
        this.f31506j = parcel.readByte() == 1;
        this.f31507k = parcel.readByte() == 1;
        this.f31508l = parcel.readInt();
        this.f31509m = parcel.readString();
        this.f31510n = parcel.readString();
        this.f31511o = parcel.readString();
        this.f31512p = parcel.readString();
        this.f31513q = parcel.readString();
        this.f31514r = parcel.readLong();
        this.f31515s = parcel.readString();
        this.f31516t = parcel.readInt();
        this.f31517u = parcel.readString();
        this.f31518v = parcel.readString();
        this.f31519w = parcel.readString();
        this.f31522z = C1143o.B(parcel);
        this.f31470A = parcel.readString();
        this.f31471B = parcel.readString();
        this.f31472C = parcel.readLong();
        this.f31473D = parcel.readLong();
        this.f31474E = parcel.readLong();
        this.f31475F = parcel.readLong();
        this.f31476G = parcel.readLong();
        this.f31477H = parcel.readLong();
        this.f31481L = parcel.readString();
        this.f31482M = parcel.readString();
        this.f31483N = parcel.readString();
        this.f31484O = parcel.readString();
        this.f31485P = parcel.readString();
        this.f31486Q = parcel.readLong();
        this.f31487R = parcel.readByte() == 1;
        this.f31488S = C1143o.B(parcel);
        this.f31504h = C1143o.p(parcel);
        this.f31505i = C1143o.p(parcel);
        this.f31490U = parcel.readInt();
        this.f31491V = parcel.readInt();
        this.f31492W = C1143o.B(parcel);
        this.f31493X = C1143o.B(parcel);
        this.f31494Y = parcel.createByteArray();
        this.f31521y = parcel.createByteArray();
        this.f31495Z = parcel.readString();
        this.f31497aa = parcel.readString();
        this.f31520x = parcel.readString();
        this.f31478I = parcel.readLong();
        this.f31479J = parcel.readLong();
        this.f31480K = parcel.readLong();
    }
}
