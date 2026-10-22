package com.byted.mgl.merge.base.service.protocol.media.entity;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes43.dex */
public class BdpMediaEntity implements Parcelable {
    public static final Parcelable.Creator<BdpMediaEntity> CREATOR = null;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    public int f33887id;
    public int mediaType;
    public String name;
    public String parentDir;
    public String path;
    public long size;
    public long time;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new AnonymousClass1();
    }

    public BdpMediaEntity(Parcel r100) {
        this.path = r100.readString();
        this.name = r100.readString();
        this.time = r100.readLong();
        this.mediaType = r100.readInt();
        this.size = r100.readLong();
        this.f33887id = r100.readInt();
        this.parentDir = r100.readString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeString(this.path);
        r100.writeString(this.name);
        r100.writeLong(this.time);
        r100.writeInt(this.mediaType);
        r100.writeLong(this.size);
        r100.writeInt(this.f33887id);
        r100.writeString(this.parentDir);
    }

    public BdpMediaEntity(String r100, String r101, long r102, int r103, long r104, int r105, String r106) {
        this.path = r100;
        this.name = r101;
        this.time = r102;
        this.mediaType = r103;
        this.size = r104;
        this.f33887id = r105;
        this.parentDir = r106;
    }
}
