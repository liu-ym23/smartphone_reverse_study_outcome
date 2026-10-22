package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes28.dex */
public class Railway implements Parcelable {
    public static final Parcelable.Creator<Railway> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f29111a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f29112b;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new AnonymousClass1();
    }

    public Railway() {
    }

    public String getID() {
        return this.f29111a;
    }

    public String getName() {
        return this.f29112b;
    }

    public Railway(Parcel r100) {
        this.f29111a = r100.readString();
        this.f29112b = r100.readString();
    }

    public void setID(String r100) {
        this.f29111a = r100;
    }

    public void setName(String r100) {
        this.f29112b = r100;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeString(this.f29111a);
        r100.writeString(this.f29112b);
    }
}
