package com.baidu.platform.comjni.tools;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes39.dex */
public class ParcelItem implements Parcelable {
    public static final Parcelable.Creator<ParcelItem> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Bundle f33491a;

    public static class a implements Parcelable.Creator<ParcelItem> {
        public a() {
        }

        public ParcelItem a(Parcel r100) {
            ParcelItem r101 = new ParcelItem();
            r101.setBundle(r100.readBundle());
            return r101;
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ ParcelItem createFromParcel(Parcel r100) {
            return a(r100);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ ParcelItem[] newArray(int r100) {
            return a(r100);
        }

        public ParcelItem[] a(int r100) {
            return new ParcelItem[r100];
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    public ParcelItem() {
    }

    public Bundle getBundle() {
        return this.f33491a;
    }

    public void setBundle(Bundle r100) {
        this.f33491a = r100;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeBundle(this.f33491a);
    }
}
