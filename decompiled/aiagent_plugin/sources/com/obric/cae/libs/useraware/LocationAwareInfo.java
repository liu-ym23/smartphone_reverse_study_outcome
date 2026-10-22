package com.obric.cae.libs.useraware;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes3.dex */
public class LocationAwareInfo implements Parcelable {
    public static final Parcelable.Creator<LocationAwareInfo> CREATOR = null;
    private static final int VERSION = 1;
    private float mAltitudeAccuracyMeters;
    private double mAltitudeMeters;
    private float mBearingAccuracyDegrees;
    private float mBearingDegrees;
    private float mHorizontalAccuracyMeters;
    private double mLatitudeDegrees;
    private double mLongitudeDegrees;
    private String mProvider;
    private float mSpeedAccuracyMetersPerSecond;
    private float mSpeedMetersPerSecond;
    private long mTimestamp;

    public static class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f31786a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f31787b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public double f31788c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public double f31789d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public float f31790e;
        public double f;
        public float g;
        public float h;
        public float i;
        public float j;
        public float k;

        public Builder() {
        }

        public static /* synthetic */ long a(Builder r2) {
            return r2.f31786a;
        }

        public static /* synthetic */ String b(Builder r0) {
            return r0.f31787b;
        }

        public static /* synthetic */ float c(Builder r0) {
            return r0.k;
        }

        public static /* synthetic */ double d(Builder r2) {
            return r2.f31788c;
        }

        public static /* synthetic */ double e(Builder r2) {
            return r2.f31789d;
        }

        public static /* synthetic */ float f(Builder r0) {
            return r0.f31790e;
        }

        public static /* synthetic */ double g(Builder r2) {
            return r2.f;
        }

        public static /* synthetic */ float h(Builder r0) {
            return r0.g;
        }

        public static /* synthetic */ float i(Builder r0) {
            return r0.h;
        }

        public static /* synthetic */ float j(Builder r0) {
            return r0.i;
        }

        public static /* synthetic */ float k(Builder r0) {
            return r0.j;
        }

        public LocationAwareInfo build() {
            return new LocationAwareInfo(this);
        }

        public Builder setAltitudeAccuracyMeters(float r1) {
            this.g = r1;
            return this;
        }

        public Builder setAltitudeMeters(double r1) {
            this.f = r1;
            return this;
        }

        public Builder setBearingAccuracyDegrees(float r1) {
            this.k = r1;
            return this;
        }

        public Builder setBearingDegrees(float r1) {
            this.j = r1;
            return this;
        }

        public Builder setHorizontalAccuracyMeters(float r1) {
            this.f31790e = r1;
            return this;
        }

        public Builder setLatitudeDegrees(double r1) {
            this.f31788c = r1;
            return this;
        }

        public Builder setLongitudeDegrees(double r1) {
            this.f31789d = r1;
            return this;
        }

        public Builder setProvider(String r1) {
            this.f31787b = r1;
            return this;
        }

        public Builder setSpeedAccuracyMetersPerSecond(float r1) {
            this.i = r1;
            return this;
        }

        public Builder setSpeedMetersPerSecond(float r1) {
            this.h = r1;
            return this;
        }

        public Builder setTimestamp(long r1) {
            this.f31786a = r1;
            return this;
        }
    }

    public class a implements Parcelable.Creator<LocationAwareInfo> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final LocationAwareInfo createFromParcel(Parcel r1) {
            return new LocationAwareInfo(r1);
        }

        @Override // android.os.Parcelable.Creator
        public final LocationAwareInfo[] newArray(int r1) {
            return new LocationAwareInfo[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    public LocationAwareInfo() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public float getAltitudeAccuracyMeters() {
        return this.mAltitudeAccuracyMeters;
    }

    public double getAltitudeMeters() {
        return this.mAltitudeMeters;
    }

    public float getBearingAccuracyDegrees() {
        return this.mBearingAccuracyDegrees;
    }

    public float getBearingDegrees() {
        return this.mBearingDegrees;
    }

    public float getHorizontalAccuracyMeters() {
        return this.mHorizontalAccuracyMeters;
    }

    public double getLatitudeDegrees() {
        return this.mLatitudeDegrees;
    }

    public double getLongitudeDegrees() {
        return this.mLongitudeDegrees;
    }

    public String getProvider() {
        return this.mProvider;
    }

    public float getSpeedAccuracyMetersPerSecond() {
        return this.mSpeedAccuracyMetersPerSecond;
    }

    public float getSpeedMetersPerSecond() {
        return this.mSpeedMetersPerSecond;
    }

    public long getTimestamp() {
        return this.mTimestamp;
    }

    public int getVersion() {
        return 1;
    }

    public void readFromParcel(Parcel r3) {
        this.mTimestamp = r3.readLong();
        this.mProvider = r3.readString();
        this.mLatitudeDegrees = r3.readDouble();
        this.mLongitudeDegrees = r3.readDouble();
        this.mHorizontalAccuracyMeters = r3.readFloat();
        this.mAltitudeMeters = r3.readDouble();
        this.mAltitudeAccuracyMeters = r3.readFloat();
        this.mSpeedMetersPerSecond = r3.readFloat();
        this.mSpeedAccuracyMetersPerSecond = r3.readFloat();
        this.mBearingDegrees = r3.readFloat();
        this.mBearingAccuracyDegrees = r3.readFloat();
    }

    public boolean sameLocation(LocationAwareInfo r5) {
        if (r5 != null) goto L4;
    L10:
        return false;
    L4:
        if (r5.mLatitudeDegrees != this.mLatitudeDegrees) goto L10;
        if (r5.mLongitudeDegrees != this.mLongitudeDegrees) goto L10;
        if (r5.mHorizontalAccuracyMeters != this.mHorizontalAccuracyMeters) goto L10;
        return true;
    }

    public String toString() {
        return "LocationAwareInfo[1," + this.mTimestamp + "," + this.mProvider + "," + this.mLatitudeDegrees + "," + this.mLongitudeDegrees + "," + this.mHorizontalAccuracyMeters + "," + this.mAltitudeMeters + "," + this.mAltitudeAccuracyMeters + "," + this.mSpeedMetersPerSecond + "," + this.mSpeedAccuracyMetersPerSecond + "," + this.mBearingDegrees + "," + this.mBearingAccuracyDegrees + ']';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r3, int r4) {
        r3.writeLong(this.mTimestamp);
        r3.writeString(this.mProvider);
        r3.writeDouble(this.mLatitudeDegrees);
        r3.writeDouble(this.mLongitudeDegrees);
        r3.writeFloat(this.mHorizontalAccuracyMeters);
        r3.writeDouble(this.mAltitudeMeters);
        r3.writeFloat(this.mAltitudeAccuracyMeters);
        r3.writeFloat(this.mSpeedMetersPerSecond);
        r3.writeFloat(this.mSpeedAccuracyMetersPerSecond);
        r3.writeFloat(this.mBearingDegrees);
        r3.writeFloat(this.mBearingAccuracyDegrees);
    }

    public LocationAwareInfo(LocationAwareInfo r3) {
        this.mTimestamp = r3.getTimestamp();
        this.mProvider = r3.getProvider();
        this.mLatitudeDegrees = r3.getLatitudeDegrees();
        this.mLongitudeDegrees = r3.getLongitudeDegrees();
        this.mHorizontalAccuracyMeters = r3.getHorizontalAccuracyMeters();
        this.mAltitudeMeters = r3.getAltitudeMeters();
        this.mAltitudeAccuracyMeters = r3.getAltitudeAccuracyMeters();
        this.mSpeedMetersPerSecond = r3.getSpeedMetersPerSecond();
        this.mSpeedAccuracyMetersPerSecond = r3.getSpeedAccuracyMetersPerSecond();
        this.mBearingDegrees = r3.getBearingDegrees();
        this.mBearingAccuracyDegrees = r3.getBearingAccuracyDegrees();
    }

    public LocationAwareInfo(long r1, String r3, double r4, double r6, float r8, double r9, float r11, float r12, float r13, float r14, float r15) {
        this.mTimestamp = r1;
        this.mProvider = r3;
        this.mLatitudeDegrees = r4;
        this.mLongitudeDegrees = r6;
        this.mHorizontalAccuracyMeters = r8;
        this.mAltitudeMeters = r9;
        this.mAltitudeAccuracyMeters = r11;
        this.mSpeedMetersPerSecond = r12;
        this.mSpeedAccuracyMetersPerSecond = r13;
        this.mBearingDegrees = r14;
        this.mBearingAccuracyDegrees = r15;
    }

    public LocationAwareInfo(Builder r3) {
        this.mTimestamp = Builder.a(r3);
        this.mProvider = Builder.b(r3);
        this.mLatitudeDegrees = Builder.d(r3);
        this.mLongitudeDegrees = Builder.e(r3);
        this.mHorizontalAccuracyMeters = Builder.f(r3);
        this.mAltitudeMeters = Builder.g(r3);
        this.mAltitudeAccuracyMeters = Builder.h(r3);
        this.mSpeedMetersPerSecond = Builder.i(r3);
        this.mSpeedAccuracyMetersPerSecond = Builder.j(r3);
        this.mBearingDegrees = Builder.k(r3);
        this.mBearingAccuracyDegrees = Builder.c(r3);
    }

    public LocationAwareInfo(Parcel r3) {
        this.mTimestamp = r3.readLong();
        this.mProvider = r3.readString();
        this.mLatitudeDegrees = r3.readDouble();
        this.mLongitudeDegrees = r3.readDouble();
        this.mHorizontalAccuracyMeters = r3.readFloat();
        this.mAltitudeMeters = r3.readDouble();
        this.mAltitudeAccuracyMeters = r3.readFloat();
        this.mSpeedMetersPerSecond = r3.readFloat();
        this.mSpeedAccuracyMetersPerSecond = r3.readFloat();
        this.mBearingDegrees = r3.readFloat();
        this.mBearingAccuracyDegrees = r3.readFloat();
    }
}
