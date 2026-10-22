package com.amap.api.maps.offlinemap;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes28.dex */
public class OfflineMapCity extends City {
    public static final Parcelable.Creator<OfflineMapCity> CREATOR = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f28706f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private long f28707g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f28708h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private String f28709i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f28710j;

    public static class a implements Parcelable.Creator<OfflineMapCity> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public OfflineMapCity createFromParcel(Parcel r100) {
            return new OfflineMapCity(r100);
        }

        @Override // android.os.Parcelable.Creator
        public OfflineMapCity[] newArray(int r100) {
            return new OfflineMapCity[r100];
        }
    }

    @Override // com.amap.api.maps.offlinemap.City, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    public OfflineMapCity() {
        this.f28706f = "";
        this.f28707g = 0;
        this.f28708h = 6;
        this.f28709i = "";
        this.f28710j = 0;
    }

    public long getSize() {
        return this.f28707g;
    }

    public int getState() {
        return this.f28708h;
    }

    public String getUrl() {
        return this.f28706f;
    }

    public String getVersion() {
        return this.f28709i;
    }

    public int getcompleteCode() {
        return this.f28710j;
    }

    public OfflineMapCity(Parcel r100) {
        super(r100);
        this.f28706f = "";
        this.f28707g = 0;
        this.f28708h = 6;
        this.f28709i = "";
        this.f28710j = 0;
        this.f28706f = r100.readString();
        this.f28707g = r100.readLong();
        this.f28708h = r100.readInt();
        this.f28709i = r100.readString();
        this.f28710j = r100.readInt();
    }

    public void setCompleteCode(int r100) {
        this.f28710j = r100;
    }

    public void setSize(long r100) {
        this.f28707g = r100;
    }

    public void setState(int r100) {
        this.f28708h = r100;
    }

    public void setUrl(String r100) {
        this.f28706f = r100;
    }

    public void setVersion(String r100) {
        this.f28709i = r100;
    }

    @Override // com.amap.api.maps.offlinemap.City, android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        super.writeToParcel(r100, r101);
        r100.writeString(this.f28706f);
        r100.writeLong(this.f28707g);
        r100.writeInt(this.f28708h);
        r100.writeString(this.f28709i);
        r100.writeInt(this.f28710j);
    }
}
