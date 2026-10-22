package com.stepos.statsapp.v3.lib.plugin.emitter;

import Z5.b;
import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes2.dex */
public class EmitterConfig implements Parcelable {
    public static final Parcelable.Creator<EmitterConfig> CREATOR = new Parcelable.Creator<EmitterConfig>() { // from class: com.stepos.statsapp.v3.lib.plugin.emitter.EmitterConfig.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public EmitterConfig createFromParcel(Parcel parcel) {
            return new EmitterConfig(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public EmitterConfig[] newArray(int i10) {
            return new EmitterConfig[i10];
        }
    };
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
        this.flushDelayInterval = b.IDLE_AGENT_PERIOD;
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
        return "EmitterConfig{active=" + this.active + ", flushOnStart=" + this.flushOnStart + ", flushOnCharge=" + this.flushOnCharge + ", flushOnReconnect=" + this.flushOnReconnect + ", flushDelayInterval=" + this.flushDelayInterval + ", flushCacheLimit=" + this.flushCacheLimit + ", flushMobileTrafficLimit=" + this.flushMobileTrafficLimit + ", neartimeInterval=" + this.neartimeInterval + ", appID='" + this.appID + "', channel='" + this.channel + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
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
        this.flushDelayInterval = b.IDLE_AGENT_PERIOD;
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
