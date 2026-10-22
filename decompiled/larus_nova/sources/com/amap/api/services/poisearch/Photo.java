package com.amap.api.services.poisearch;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes28.dex */
public final class Photo implements Parcelable {
    public static final Parcelable.Creator<Photo> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f28992a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f28993b;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    static {
        CREATOR = new AnonymousClass1();
    }

    public Photo() {
    }

    public final String getTitle() {
        return this.f28992a;
    }

    public final String getUrl() {
        return this.f28993b;
    }

    public Photo(Parcel r100) {
        this.f28992a = r100.readString();
        this.f28993b = r100.readString();
    }

    public final void setTitle(String r100) {
        this.f28992a = r100;
    }

    public final void setUrl(String r100) {
        this.f28993b = r100;
    }

    public Photo(String r100, String r101) {
        this.f28992a = r100;
        this.f28993b = r101;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        r100.writeString(this.f28992a);
        r100.writeString(this.f28993b);
    }
}
