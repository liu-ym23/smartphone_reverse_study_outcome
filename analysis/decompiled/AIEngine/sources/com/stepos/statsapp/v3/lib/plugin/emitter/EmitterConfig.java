package com.stepos.statsapp.v3.lib.plugin.emitter;

import android.os.Parcel;
import android.os.Parcelable;
import com.stepos.core.ota.process.OtaIdleExitPolicy;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class EmitterConfig implements Parcelable {
    public static final Parcelable.Creator<EmitterConfig> CREATOR = new a();
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

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class a implements Parcelable.Creator<EmitterConfig> {
        @Override // android.os.Parcelable.Creator
        public final EmitterConfig createFromParcel(Parcel parcel) {
            return new EmitterConfig(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final EmitterConfig[] newArray(int i10) {
            return new EmitterConfig[i10];
        }
    }

    public EmitterConfig(String str, String str2) {
        this.active = true;
        this.flushOnStart = true;
        this.flushOnCharge = true;
        this.flushOnReconnect = true;
        this.flushDelayInterval = OtaIdleExitPolicy.TERMINAL_IDLE_MS;
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
        StringBuilder sb2 = new StringBuilder("EmitterConfig{active=");
        sb2.append(this.active);
        sb2.append(", flushOnStart=");
        sb2.append(this.flushOnStart);
        sb2.append(", flushOnCharge=");
        sb2.append(this.flushOnCharge);
        sb2.append(", flushOnReconnect=");
        sb2.append(this.flushOnReconnect);
        sb2.append(", flushDelayInterval=");
        sb2.append(this.flushDelayInterval);
        sb2.append(", flushCacheLimit=");
        sb2.append(this.flushCacheLimit);
        sb2.append(", flushMobileTrafficLimit=");
        sb2.append(this.flushMobileTrafficLimit);
        sb2.append(", neartimeInterval=");
        sb2.append(this.neartimeInterval);
        sb2.append(", appID='");
        sb2.append(this.appID);
        sb2.append("', channel='");
        return ai.onnxruntime.a.o(sb2, this.channel, "'}");
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
        this.flushDelayInterval = OtaIdleExitPolicy.TERMINAL_IDLE_MS;
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
