package com.google.android.material.timepicker;

import android.content.res.Resources;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

/* loaded from: classes.dex */
class e implements Parcelable {
    public static final Parcelable.Creator<e> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    private final b f13497a;

    /* renamed from: b, reason: collision with root package name */
    private final b f13498b;

    /* renamed from: c, reason: collision with root package name */
    final int f13499c;

    /* renamed from: d, reason: collision with root package name */
    int f13500d;

    /* renamed from: e, reason: collision with root package name */
    int f13501e;

    /* renamed from: f, reason: collision with root package name */
    int f13502f;

    /* renamed from: g, reason: collision with root package name */
    int f13503g;

    class a implements Parcelable.Creator<e> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public e createFromParcel(Parcel parcel) {
            return new e(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public e[] newArray(int i5) {
            return new e[i5];
        }
    }

    public e() {
        this(0);
    }

    public static String a(Resources resources, CharSequence charSequence) {
        return c(resources, charSequence, "%02d");
    }

    public static String c(Resources resources, CharSequence charSequence, String str) {
        try {
            return String.format(resources.getConfiguration().locale, str, Integer.valueOf(Integer.parseInt(String.valueOf(charSequence))));
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    private static int f(int i5) {
        return i5 >= 12 ? 1 : 0;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        return this.f13500d == eVar.f13500d && this.f13501e == eVar.f13501e && this.f13499c == eVar.f13499c && this.f13502f == eVar.f13502f;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f13499c), Integer.valueOf(this.f13500d), Integer.valueOf(this.f13501e), Integer.valueOf(this.f13502f)});
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i5) {
        parcel.writeInt(this.f13500d);
        parcel.writeInt(this.f13501e);
        parcel.writeInt(this.f13502f);
        parcel.writeInt(this.f13499c);
    }

    public e(int i5) {
        this(0, 0, 10, i5);
    }

    public e(int i5, int i6, int i7, int i8) {
        this.f13500d = i5;
        this.f13501e = i6;
        this.f13502f = i7;
        this.f13499c = i8;
        this.f13503g = f(i5);
        this.f13497a = new b(59);
        this.f13498b = new b(i8 == 1 ? 23 : 12);
    }

    protected e(Parcel parcel) {
        this(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt());
    }
}
