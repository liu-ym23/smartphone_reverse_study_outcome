package com.google.android.material.badge;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.maps.model.c;
import java.util.Locale;

/* loaded from: classes.dex */
public final class BadgeState$State implements Parcelable {
    public static final Parcelable.Creator<BadgeState$State> CREATOR = new c(29);

    /* renamed from: A, reason: collision with root package name */
    public Integer f10341A;

    /* renamed from: B, reason: collision with root package name */
    public Integer f10342B;

    /* renamed from: C, reason: collision with root package name */
    public Boolean f10343C;

    /* renamed from: D, reason: collision with root package name */
    public Integer f10344D;

    /* renamed from: a, reason: collision with root package name */
    public int f10345a;

    /* renamed from: b, reason: collision with root package name */
    public Integer f10346b;

    /* renamed from: c, reason: collision with root package name */
    public Integer f10347c;

    /* renamed from: d, reason: collision with root package name */
    public Integer f10348d;

    /* renamed from: e, reason: collision with root package name */
    public Integer f10349e;

    /* renamed from: f, reason: collision with root package name */
    public Integer f10350f;

    /* renamed from: g, reason: collision with root package name */
    public Integer f10351g;

    /* renamed from: h, reason: collision with root package name */
    public Integer f10352h;

    /* renamed from: i, reason: collision with root package name */
    public int f10353i;

    /* renamed from: j, reason: collision with root package name */
    public String f10354j;

    /* renamed from: k, reason: collision with root package name */
    public int f10355k;

    /* renamed from: l, reason: collision with root package name */
    public int f10356l;

    /* renamed from: m, reason: collision with root package name */
    public int f10357m;

    /* renamed from: n, reason: collision with root package name */
    public Locale f10358n;

    /* renamed from: o, reason: collision with root package name */
    public String f10359o;

    /* renamed from: p, reason: collision with root package name */
    public String f10360p;

    /* renamed from: q, reason: collision with root package name */
    public int f10361q;

    /* renamed from: r, reason: collision with root package name */
    public Integer f10362r;

    /* renamed from: s, reason: collision with root package name */
    public Boolean f10363s;

    /* renamed from: t, reason: collision with root package name */
    public Integer f10364t;

    /* renamed from: u, reason: collision with root package name */
    public Integer f10365u;

    /* renamed from: v, reason: collision with root package name */
    public Integer f10366v;

    /* renamed from: w, reason: collision with root package name */
    public Integer f10367w;

    /* renamed from: x, reason: collision with root package name */
    public Integer f10368x;

    /* renamed from: y, reason: collision with root package name */
    public Integer f10369y;

    /* renamed from: z, reason: collision with root package name */
    public Integer f10370z;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        parcel.writeInt(this.f10345a);
        parcel.writeSerializable(this.f10346b);
        parcel.writeSerializable(this.f10347c);
        parcel.writeSerializable(this.f10348d);
        parcel.writeSerializable(this.f10349e);
        parcel.writeSerializable(this.f10350f);
        parcel.writeSerializable(this.f10351g);
        parcel.writeSerializable(this.f10352h);
        parcel.writeInt(this.f10353i);
        parcel.writeString(this.f10354j);
        parcel.writeInt(this.f10355k);
        parcel.writeInt(this.f10356l);
        parcel.writeInt(this.f10357m);
        String str = this.f10359o;
        if (str == null) {
            str = null;
        }
        parcel.writeString(str);
        String str2 = this.f10360p;
        parcel.writeString(str2 != null ? str2 : null);
        parcel.writeInt(this.f10361q);
        parcel.writeSerializable(this.f10362r);
        parcel.writeSerializable(this.f10364t);
        parcel.writeSerializable(this.f10365u);
        parcel.writeSerializable(this.f10366v);
        parcel.writeSerializable(this.f10367w);
        parcel.writeSerializable(this.f10368x);
        parcel.writeSerializable(this.f10369y);
        parcel.writeSerializable(this.f10342B);
        parcel.writeSerializable(this.f10370z);
        parcel.writeSerializable(this.f10341A);
        parcel.writeSerializable(this.f10363s);
        parcel.writeSerializable(this.f10358n);
        parcel.writeSerializable(this.f10343C);
        parcel.writeSerializable(this.f10344D);
    }
}
