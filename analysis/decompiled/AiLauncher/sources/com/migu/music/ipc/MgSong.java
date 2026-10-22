package com.migu.music.ipc;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes2.dex */
public class MgSong implements Parcelable {
    public static final Parcelable.Creator<MgSong> CREATOR = new a();
    public String album;
    public String contentId;
    public String copyrightId;
    public String coverUrl;
    public int duration;
    public boolean isVip;
    public String resourceType;
    public String singer;
    public String songId;
    public String songName;

    public class a implements Parcelable.Creator<MgSong> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public MgSong createFromParcel(Parcel parcel) {
            return new MgSong(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public MgSong[] newArray(int i10) {
            return new MgSong[i10];
        }
    }

    public MgSong() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "MgSong{songId='" + this.songId + "', contentId='" + this.contentId + "', songName='" + this.songName + "', singer='" + this.singer + "', album='" + this.album + "', duration=" + this.duration + ", resourceType='" + this.resourceType + "', isVip=" + this.isVip + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.songId);
        parcel.writeString(this.contentId);
        parcel.writeString(this.songName);
        parcel.writeString(this.singer);
        parcel.writeString(this.album);
        parcel.writeInt(this.duration);
        parcel.writeString(this.coverUrl);
        parcel.writeString(this.copyrightId);
        parcel.writeString(this.resourceType);
        parcel.writeInt(this.isVip ? 1 : 0);
    }

    public MgSong(Parcel parcel) {
        this.songId = parcel.readString();
        this.contentId = parcel.readString();
        this.songName = parcel.readString();
        this.singer = parcel.readString();
        this.album = parcel.readString();
        this.duration = parcel.readInt();
        this.coverUrl = parcel.readString();
        this.copyrightId = parcel.readString();
        this.resourceType = parcel.readString();
        this.isVip = parcel.readInt() != 0;
    }
}
