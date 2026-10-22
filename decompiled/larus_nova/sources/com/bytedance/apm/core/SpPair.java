package com.bytedance.apm.core;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class SpPair implements Parcelable {
    public static final Parcelable.Creator<SpPair> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f190511a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f190512b;

    /* JADX INFO: loaded from: classes3.dex */
    public static class a implements Parcelable.Creator<SpPair> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final SpPair createFromParcel(Parcel r100) {
            return new SpPair(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final SpPair[] newArray(int r100) {
            return new SpPair[r100];
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    public SpPair(Parcel r100) {
        this.f190511a = r100.readString();
        this.f190512b = r100.readValue(getClass().getClassLoader());
    }

    public SpPair(String r100, Object r101) {
        this.f190511a = r100;
        this.f190512b = r101;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        r100.writeString(this.f190511a);
        r100.writeValue(this.f190512b);
    }
}
