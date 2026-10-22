package com.obric.cae.libs.useraware;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes3.dex */
public class HarEventData implements Parcelable {
    public static final Parcelable.Creator<HarEventData> CREATOR = null;
    public static final int SNS_OEM_HAR_LEVEL2_STATE_CAR = 8;
    public static final int SNS_OEM_HAR_LEVEL2_STATE_CYCLING = 6;
    public static final int SNS_OEM_HAR_LEVEL2_STATE_ELECTRIC_BIKE = 7;
    public static final int SNS_OEM_HAR_LEVEL2_STATE_OTHER = 4;
    public static final int SNS_OEM_HAR_LEVEL2_STATE_RUNNING = 1;
    public static final int SNS_OEM_HAR_LEVEL2_STATE_STATIONARY = 0;
    public static final int SNS_OEM_HAR_LEVEL2_STATE_SUBWAY = 5;
    public static final int SNS_OEM_HAR_LEVEL2_STATE_WALKING = 2;
    private int mEvent;
    private long mTimestamp;

    public static class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f31782a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f31783b;

        public Builder() {
        }

        public HarEventData build() {
            return new HarEventData(this.f31782a, this.f31783b);
        }

        public Builder setEvent(int r1) {
            this.f31782a = r1;
            return this;
        }

        public Builder setTimestamp(long r1) {
            this.f31783b = r1;
            return this;
        }
    }

    public class a implements Parcelable.Creator<HarEventData> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final HarEventData createFromParcel(Parcel r1) {
            return new HarEventData(r1);
        }

        @Override // android.os.Parcelable.Creator
        public final HarEventData[] newArray(int r1) {
            return new HarEventData[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    public HarEventData() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getEvent() {
        return this.mEvent;
    }

    public long getTimestamp() {
        return this.mTimestamp;
    }

    public void readFromParcel(Parcel r3) {
        this.mEvent = r3.readInt();
        this.mTimestamp = r3.readLong();
    }

    public String toString() {
        return "HarEventData{event=" + this.mEvent + ", timestamp=" + this.mTimestamp + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r3, int r4) {
        r3.writeInt(this.mEvent);
        r3.writeLong(this.mTimestamp);
    }

    public HarEventData(HarEventData r3) {
        this.mEvent = r3.getEvent();
        this.mTimestamp = r3.getTimestamp();
    }

    public HarEventData(int r1, long r2) {
        this.mEvent = r1;
        this.mTimestamp = r2;
    }

    public HarEventData(Parcel r3) {
        this.mEvent = r3.readInt();
        this.mTimestamp = r3.readLong();
    }
}
