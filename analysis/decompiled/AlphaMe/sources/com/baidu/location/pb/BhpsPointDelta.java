package com.baidu.location.pb;

import L1.b;
import L1.d;
import L1.e;
import L1.f;
import java.io.IOException;

/* loaded from: classes.dex */
public final class BhpsPointDelta extends f {
    public static final int ALTITUDE_FIELD_NUMBER = 12;
    public static final int DELTA_LATITUDE_FIELD_NUMBER = 2;
    public static final int DELTA_LONGITUDE_FIELD_NUMBER = 1;
    public static final int DRIVER_STATE_FIELD_NUMBER = 9;
    public static final int GPS_ANGLE_FIELD_NUMBER = 4;
    public static final int GPS_SPEED_FIELD_NUMBER = 3;
    public static final int GPS_STAT_FIELD_NUMBER = 6;
    public static final int GPS_TIME_FIELD_NUMBER = 5;
    public static final int HEIGHT_FIELD_NUMBER = 11;
    public static final int LOCATION_RADIUS_FIELD_NUMBER = 10;
    public static final int TURN_DIR_FIELD_NUMBER = 7;
    public static final int TURN_DIST_FIELD_NUMBER = 8;
    public static final int WALKING_STATE_FIELD_NUMBER = 13;
    private boolean hasAltitude;
    private boolean hasDeltaLatitude;
    private boolean hasDeltaLongitude;
    private boolean hasDriverState;
    private boolean hasGpsAngle;
    private boolean hasGpsSpeed;
    private boolean hasGpsStat;
    private boolean hasGpsTime;
    private boolean hasHeight;
    private boolean hasLocationRadius;
    private boolean hasTurnDir;
    private boolean hasTurnDist;
    private boolean hasWalkingState;
    private double deltaLongitude_ = 0.0d;
    private double deltaLatitude_ = 0.0d;
    private double gpsSpeed_ = 0.0d;
    private double gpsAngle_ = 0.0d;
    private long gpsTime_ = 0;
    private int gpsStat_ = 0;
    private int turnDir_ = 0;
    private int turnDist_ = 0;
    private int driverState_ = 0;
    private int locationRadius_ = 0;
    private int height_ = 0;
    private int altitude_ = 0;
    private int walkingState_ = 0;
    private int cachedSize = -1;

    public static BhpsPointDelta parseFrom(b bVar) throws IOException {
        return new BhpsPointDelta().mergeFrom(bVar);
    }

    public final BhpsPointDelta clear() {
        clearDeltaLongitude();
        clearDeltaLatitude();
        clearGpsSpeed();
        clearGpsAngle();
        clearGpsTime();
        clearGpsStat();
        clearTurnDir();
        clearTurnDist();
        clearDriverState();
        clearLocationRadius();
        clearHeight();
        clearAltitude();
        clearWalkingState();
        this.cachedSize = -1;
        return this;
    }

    public BhpsPointDelta clearAltitude() {
        this.hasAltitude = false;
        this.altitude_ = 0;
        return this;
    }

    public BhpsPointDelta clearDeltaLatitude() {
        this.hasDeltaLatitude = false;
        this.deltaLatitude_ = 0.0d;
        return this;
    }

    public BhpsPointDelta clearDeltaLongitude() {
        this.hasDeltaLongitude = false;
        this.deltaLongitude_ = 0.0d;
        return this;
    }

    public BhpsPointDelta clearDriverState() {
        this.hasDriverState = false;
        this.driverState_ = 0;
        return this;
    }

    public BhpsPointDelta clearGpsAngle() {
        this.hasGpsAngle = false;
        this.gpsAngle_ = 0.0d;
        return this;
    }

    public BhpsPointDelta clearGpsSpeed() {
        this.hasGpsSpeed = false;
        this.gpsSpeed_ = 0.0d;
        return this;
    }

    public BhpsPointDelta clearGpsStat() {
        this.hasGpsStat = false;
        this.gpsStat_ = 0;
        return this;
    }

    public BhpsPointDelta clearGpsTime() {
        this.hasGpsTime = false;
        this.gpsTime_ = 0L;
        return this;
    }

    public BhpsPointDelta clearHeight() {
        this.hasHeight = false;
        this.height_ = 0;
        return this;
    }

    public BhpsPointDelta clearLocationRadius() {
        this.hasLocationRadius = false;
        this.locationRadius_ = 0;
        return this;
    }

    public BhpsPointDelta clearTurnDir() {
        this.hasTurnDir = false;
        this.turnDir_ = 0;
        return this;
    }

    public BhpsPointDelta clearTurnDist() {
        this.hasTurnDist = false;
        this.turnDist_ = 0;
        return this;
    }

    public BhpsPointDelta clearWalkingState() {
        this.hasWalkingState = false;
        this.walkingState_ = 0;
        return this;
    }

    public int getAltitude() {
        return this.altitude_;
    }

    @Override // L1.f
    public int getCachedSize() {
        if (this.cachedSize < 0) {
            getSerializedSize();
        }
        return this.cachedSize;
    }

    public double getDeltaLatitude() {
        return this.deltaLatitude_;
    }

    public double getDeltaLongitude() {
        return this.deltaLongitude_;
    }

    public int getDriverState() {
        return this.driverState_;
    }

    public double getGpsAngle() {
        return this.gpsAngle_;
    }

    public double getGpsSpeed() {
        return this.gpsSpeed_;
    }

    public int getGpsStat() {
        return this.gpsStat_;
    }

    public long getGpsTime() {
        return this.gpsTime_;
    }

    public int getHeight() {
        return this.height_;
    }

    public int getLocationRadius() {
        return this.locationRadius_;
    }

    @Override // L1.f
    public int getSerializedSize() {
        int iE;
        if (hasDeltaLongitude()) {
            getDeltaLongitude();
            iE = d.d(1);
        } else {
            iE = 0;
        }
        if (hasDeltaLatitude()) {
            getDeltaLatitude();
            iE += d.d(2);
        }
        if (hasGpsSpeed()) {
            getGpsSpeed();
            iE += d.d(3);
        }
        if (hasGpsAngle()) {
            getGpsAngle();
            iE += d.d(4);
        }
        if (hasGpsTime()) {
            long gpsTime = getGpsTime();
            iE += d.j(gpsTime) + d.n(5);
        }
        if (hasGpsStat()) {
            iE += d.o(6, getGpsStat());
        }
        if (hasTurnDir()) {
            iE += d.o(7, getTurnDir());
        }
        if (hasTurnDist()) {
            iE += d.o(8, getTurnDist());
        }
        if (hasDriverState()) {
            iE += d.o(9, getDriverState());
        }
        if (hasLocationRadius()) {
            iE += d.o(10, getLocationRadius());
        }
        if (hasHeight()) {
            iE += d.o(11, getHeight());
        }
        if (hasAltitude()) {
            iE += d.e(12, getAltitude());
        }
        if (hasWalkingState()) {
            iE += d.e(13, getWalkingState());
        }
        this.cachedSize = iE;
        return iE;
    }

    public int getTurnDir() {
        return this.turnDir_;
    }

    public int getTurnDist() {
        return this.turnDist_;
    }

    public int getWalkingState() {
        return this.walkingState_;
    }

    public boolean hasAltitude() {
        return this.hasAltitude;
    }

    public boolean hasDeltaLatitude() {
        return this.hasDeltaLatitude;
    }

    public boolean hasDeltaLongitude() {
        return this.hasDeltaLongitude;
    }

    public boolean hasDriverState() {
        return this.hasDriverState;
    }

    public boolean hasGpsAngle() {
        return this.hasGpsAngle;
    }

    public boolean hasGpsSpeed() {
        return this.hasGpsSpeed;
    }

    public boolean hasGpsStat() {
        return this.hasGpsStat;
    }

    public boolean hasGpsTime() {
        return this.hasGpsTime;
    }

    public boolean hasHeight() {
        return this.hasHeight;
    }

    public boolean hasLocationRadius() {
        return this.hasLocationRadius;
    }

    public boolean hasTurnDir() {
        return this.hasTurnDir;
    }

    public boolean hasTurnDist() {
        return this.hasTurnDist;
    }

    public boolean hasWalkingState() {
        return this.hasWalkingState;
    }

    public final boolean isInitialized() {
        return this.hasDeltaLongitude && this.hasDeltaLatitude && this.hasGpsTime && this.hasGpsStat && this.hasHeight;
    }

    public BhpsPointDelta setAltitude(int i4) {
        this.hasAltitude = true;
        this.altitude_ = i4;
        return this;
    }

    public BhpsPointDelta setDeltaLatitude(double d4) {
        this.hasDeltaLatitude = true;
        this.deltaLatitude_ = d4;
        return this;
    }

    public BhpsPointDelta setDeltaLongitude(double d4) {
        this.hasDeltaLongitude = true;
        this.deltaLongitude_ = d4;
        return this;
    }

    public BhpsPointDelta setDriverState(int i4) {
        this.hasDriverState = true;
        this.driverState_ = i4;
        return this;
    }

    public BhpsPointDelta setGpsAngle(double d4) {
        this.hasGpsAngle = true;
        this.gpsAngle_ = d4;
        return this;
    }

    public BhpsPointDelta setGpsSpeed(double d4) {
        this.hasGpsSpeed = true;
        this.gpsSpeed_ = d4;
        return this;
    }

    public BhpsPointDelta setGpsStat(int i4) {
        this.hasGpsStat = true;
        this.gpsStat_ = i4;
        return this;
    }

    public BhpsPointDelta setGpsTime(long j4) {
        this.hasGpsTime = true;
        this.gpsTime_ = j4;
        return this;
    }

    public BhpsPointDelta setHeight(int i4) {
        this.hasHeight = true;
        this.height_ = i4;
        return this;
    }

    public BhpsPointDelta setLocationRadius(int i4) {
        this.hasLocationRadius = true;
        this.locationRadius_ = i4;
        return this;
    }

    public BhpsPointDelta setTurnDir(int i4) {
        this.hasTurnDir = true;
        this.turnDir_ = i4;
        return this;
    }

    public BhpsPointDelta setTurnDist(int i4) {
        this.hasTurnDist = true;
        this.turnDist_ = i4;
        return this;
    }

    public BhpsPointDelta setWalkingState(int i4) {
        this.hasWalkingState = true;
        this.walkingState_ = i4;
        return this;
    }

    @Override // L1.f
    public void writeTo(d dVar) throws IOException {
        if (hasDeltaLongitude()) {
            dVar.r(1, getDeltaLongitude());
        }
        if (hasDeltaLatitude()) {
            dVar.r(2, getDeltaLatitude());
        }
        if (hasGpsSpeed()) {
            dVar.r(3, getGpsSpeed());
        }
        if (hasGpsAngle()) {
            dVar.r(4, getGpsAngle());
        }
        if (hasGpsTime()) {
            long gpsTime = getGpsTime();
            dVar.B(5, 0);
            dVar.y(gpsTime);
        }
        if (hasGpsStat()) {
            dVar.C(6, getGpsStat());
        }
        if (hasTurnDir()) {
            dVar.C(7, getTurnDir());
        }
        if (hasTurnDist()) {
            dVar.C(8, getTurnDist());
        }
        if (hasDriverState()) {
            dVar.C(9, getDriverState());
        }
        if (hasLocationRadius()) {
            dVar.C(10, getLocationRadius());
        }
        if (hasHeight()) {
            dVar.C(11, getHeight());
        }
        if (hasAltitude()) {
            dVar.s(12, getAltitude());
        }
        if (hasWalkingState()) {
            dVar.s(13, getWalkingState());
        }
    }

    public static BhpsPointDelta parseFrom(byte[] bArr) throws e {
        return (BhpsPointDelta) new BhpsPointDelta().mergeFrom(bArr);
    }

    @Override // L1.f
    public BhpsPointDelta mergeFrom(b bVar) throws IOException {
        while (true) {
            int iO = bVar.o();
            switch (iO) {
                case 0:
                    return this;
                case 9:
                    setDeltaLongitude(bVar.c());
                    break;
                case 17:
                    setDeltaLatitude(bVar.c());
                    break;
                case 25:
                    setGpsSpeed(bVar.c());
                    break;
                case 33:
                    setGpsAngle(bVar.c());
                    break;
                case 40:
                    setGpsTime(bVar.l());
                    break;
                case 48:
                    setGpsStat(bVar.k());
                    break;
                case 56:
                    setTurnDir(bVar.k());
                    break;
                case 64:
                    setTurnDist(bVar.k());
                    break;
                case 72:
                    setDriverState(bVar.k());
                    break;
                case 80:
                    setLocationRadius(bVar.k());
                    break;
                case 88:
                    setHeight(bVar.k());
                    break;
                case 96:
                    setAltitude(bVar.k());
                    break;
                case 104:
                    setWalkingState(bVar.k());
                    break;
                default:
                    if (!parseUnknownField(bVar, iO)) {
                        return this;
                    }
                    break;
            }
        }
    }
}
