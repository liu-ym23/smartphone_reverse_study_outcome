package com.stepos.statsapp.v3.lib.plugin.emitter;

import L.g;
import android.os.Parcel;
import android.os.Parcelable;
import com.zyql.common.utils.upload.TOSUploader;

/* loaded from: classes3.dex */
public class EmitterConfig implements Parcelable {
    public static final Parcelable.Creator<EmitterConfig> CREATOR = new g(8);
    boolean active;
    private String appID;
    private String channel;
    int flushCacheLimit;
    long flushDelayInterval;
    long flushMobileTrafficLimit;
    boolean flushOnCharge;
    boolean flushOnReconnect;
    boolean flushOnStart;
    int neartimeInterval;
    boolean sampling;

    public EmitterConfig(String str, String str2) {
        this.active = true;
        this.flushOnStart = true;
        this.flushOnCharge = true;
        this.flushOnReconnect = true;
        this.flushDelayInterval = TOSUploader.EXPIRED_TIMES;
        this.flushCacheLimit = 50;
        this.flushMobileTrafficLimit = 2097152L;
        this.neartimeInterval = 10;
        this.appID = str;
        this.channel = str2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAppId() {
        return this.appID;
    }

    public String getChannel() {
        return this.channel;
    }

    public int getFlushCacheLimit() {
        return this.flushCacheLimit;
    }

    public long getFlushDelayInterval() {
        return this.flushDelayInterval;
    }

    public long getFlushMobileTrafficLimit() {
        return this.flushMobileTrafficLimit;
    }

    public int getNeartimeInterval() {
        return this.neartimeInterval;
    }

    public boolean isActive() {
        return this.active;
    }

    public boolean isFlushOnCharge() {
        return this.flushOnCharge;
    }

    public boolean isFlushOnReconnect() {
        return this.flushOnReconnect;
    }

    public boolean isFlushOnStart() {
        return this.flushOnStart;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("EmitterConfig{active=");
        sb.append(this.active);
        sb.append(", flushOnStart=");
        sb.append(this.flushOnStart);
        sb.append(", flushOnCharge=");
        sb.append(this.flushOnCharge);
        sb.append(", flushOnReconnect=");
        sb.append(this.flushOnReconnect);
        sb.append(", flushDelayInterval=");
        sb.append(this.flushDelayInterval);
        sb.append(", flushCacheLimit=");
        sb.append(this.flushCacheLimit);
        sb.append(", flushMobileTrafficLimit=");
        sb.append(this.flushMobileTrafficLimit);
        sb.append(", neartimeInterval=");
        sb.append(this.neartimeInterval);
        sb.append(", appID='");
        sb.append(this.appID);
        sb.append("', channel='");
        return B7.a.q(sb, this.channel, "'}");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeByte(this.sampling ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.active ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.flushOnStart ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.flushOnCharge ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.flushOnReconnect ? (byte) 1 : (byte) 0);
        parcel.writeLong(this.flushDelayInterval);
        parcel.writeInt(this.flushCacheLimit);
        parcel.writeLong(this.flushMobileTrafficLimit);
        parcel.writeString(this.appID);
        parcel.writeString(this.channel);
    }

    public EmitterConfig(Parcel parcel) {
        this.active = true;
        this.flushOnStart = true;
        this.flushOnCharge = true;
        this.flushOnReconnect = true;
        this.flushDelayInterval = TOSUploader.EXPIRED_TIMES;
        this.flushCacheLimit = 50;
        this.flushMobileTrafficLimit = 2097152L;
        this.neartimeInterval = 10;
        this.sampling = parcel.readByte() != 0;
        this.active = parcel.readByte() != 0;
        this.flushOnStart = parcel.readByte() != 0;
        this.flushOnCharge = parcel.readByte() != 0;
        this.flushOnReconnect = parcel.readByte() != 0;
        this.flushDelayInterval = parcel.readLong();
        this.flushCacheLimit = parcel.readInt();
        this.flushMobileTrafficLimit = parcel.readLong();
        this.appID = parcel.readString();
        this.channel = parcel.readString();
    }
}
