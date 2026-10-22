package com.tonyodev.fetch2core;

import android.os.Parcel;
import android.os.Parcelable;
import h0.e;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class DownloadBlockInfo implements DownloadBlock {
    public static final a CREATOR = new a();
    private int downloadId = -1;
    private int blockPosition = -1;
    private long startByte = -1;
    private long endByte = -1;
    private long downloadedBytes = -1;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class a implements Parcelable.Creator<DownloadBlockInfo> {
        @Override // android.os.Parcelable.Creator
        public final DownloadBlockInfo createFromParcel(Parcel source) {
            g.f(source, "source");
            DownloadBlockInfo downloadBlockInfo = new DownloadBlockInfo();
            downloadBlockInfo.setDownloadId(source.readInt());
            downloadBlockInfo.setBlockPosition(source.readInt());
            downloadBlockInfo.setStartByte(source.readLong());
            downloadBlockInfo.setEndByte(source.readLong());
            downloadBlockInfo.setDownloadedBytes(source.readLong());
            return downloadBlockInfo;
        }

        @Override // android.os.Parcelable.Creator
        public final DownloadBlockInfo[] newArray(int i10) {
            return new DownloadBlockInfo[i10];
        }
    }

    @Override // com.tonyodev.fetch2core.DownloadBlock
    public DownloadBlock copy() {
        DownloadBlockInfo downloadBlockInfo = new DownloadBlockInfo();
        downloadBlockInfo.setDownloadId(getDownloadId());
        downloadBlockInfo.setBlockPosition(getBlockPosition());
        downloadBlockInfo.setStartByte(getStartByte());
        downloadBlockInfo.setEndByte(getEndByte());
        downloadBlockInfo.setDownloadedBytes(getDownloadedBytes());
        return downloadBlockInfo;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!DownloadBlockInfo.class.equals(obj != null ? obj.getClass() : null)) {
            return false;
        }
        g.d(obj, "null cannot be cast to non-null type com.tonyodev.fetch2core.DownloadBlockInfo");
        DownloadBlockInfo downloadBlockInfo = (DownloadBlockInfo) obj;
        return getDownloadId() == downloadBlockInfo.getDownloadId() && getBlockPosition() == downloadBlockInfo.getBlockPosition() && getStartByte() == downloadBlockInfo.getStartByte() && getEndByte() == downloadBlockInfo.getEndByte() && getDownloadedBytes() == downloadBlockInfo.getDownloadedBytes();
    }

    @Override // com.tonyodev.fetch2core.DownloadBlock
    public int getBlockPosition() {
        return this.blockPosition;
    }

    @Override // com.tonyodev.fetch2core.DownloadBlock
    public int getDownloadId() {
        return this.downloadId;
    }

    @Override // com.tonyodev.fetch2core.DownloadBlock
    public long getDownloadedBytes() {
        return this.downloadedBytes;
    }

    @Override // com.tonyodev.fetch2core.DownloadBlock
    public long getEndByte() {
        return this.endByte;
    }

    @Override // com.tonyodev.fetch2core.DownloadBlock
    public int getProgress() {
        return b.c(getDownloadedBytes(), getEndByte() - getStartByte());
    }

    @Override // com.tonyodev.fetch2core.DownloadBlock
    public long getStartByte() {
        return this.startByte;
    }

    public int hashCode() {
        return Long.hashCode(getDownloadedBytes()) + ((Long.hashCode(getEndByte()) + ((Long.hashCode(getStartByte()) + ((getBlockPosition() + (getDownloadId() * 31)) * 31)) * 31)) * 31);
    }

    public void setBlockPosition(int i10) {
        this.blockPosition = i10;
    }

    public void setDownloadId(int i10) {
        this.downloadId = i10;
    }

    public void setDownloadedBytes(long j10) {
        this.downloadedBytes = j10;
    }

    public void setEndByte(long j10) {
        this.endByte = j10;
    }

    public void setStartByte(long j10) {
        this.startByte = j10;
    }

    public String toString() {
        int downloadId = getDownloadId();
        int blockPosition = getBlockPosition();
        long startByte = getStartByte();
        long endByte = getEndByte();
        long downloadedBytes = getDownloadedBytes();
        StringBuilder sbD = e.d(downloadId, "DownloadBlock(downloadId=", blockPosition, ", blockPosition=", ", startByte=");
        sbD.append(startByte);
        a0.a.s(endByte, ", endByte=", ", downloadedBytes=", sbD);
        return ai.onnxruntime.a.m(sbD, downloadedBytes, ")");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int i10) {
        g.f(dest, "dest");
        dest.writeInt(getDownloadId());
        dest.writeInt(getBlockPosition());
        dest.writeLong(getStartByte());
        dest.writeLong(getEndByte());
        dest.writeLong(getDownloadedBytes());
    }
}
