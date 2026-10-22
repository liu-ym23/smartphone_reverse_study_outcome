package com.baidu.naviapi.open;

import androidx.camera.video.AudioStats;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes39.dex */
public class LocInfo {
    public static final int GPS_TYPE = 1;
    public static final int LBS_TYPE = 3;
    public static final int NODE_TYPE_AUX_ROAD = 4;
    public static final int NODE_TYPE_IN_TUNNEL = 5;
    public static final int NODE_TYPE_MAIN_ROAD = 3;
    public static final int NODE_TYPE_NORMAL = 0;
    public static final int NODE_TYPE_OUT_TUNNEL = 6;
    public static final int NODE_TYPE_OVER_VIADUCT = 1;
    public static final int NODE_TYPE_UNDER_VIADUCT = 2;
    public static final int UNDEFINE = 0;
    public static final int WIFI_TYPE = 2;
    private long mCurTime;
    private Point mGeoPoint;
    private int mGpsDir;
    private long mGpsTime;
    private int mInRoom;
    private int mLocType;
    private Point mMMPoint;
    private int mRadius;
    private int mRoutePlanNodeType;
    private int mSatelliteSize;
    private int mSensorDir;
    private int mSpeed;
    private int state;

    @Retention(RetentionPolicy.CLASS)
    public @interface LocationType {
    }

    public static class Point {
        private final double alt;
        private final double lat;
        private final double lng;

        public String toString() {
            return "Point{lat=" + this.lat + ", lng=" + this.lng + ", alt=" + this.alt + '}';
        }

        public double getAlt() {
            return this.alt;
        }

        public double getLat() {
            return this.lat;
        }

        public double getLng() {
            return this.lng;
        }

        public Point(double r100, double r101, double r102) {
            this.lat = r100;
            this.lng = r101;
            this.alt = r102;
        }
    }

    public @interface RoutePlanNodeType {
    }

    public Point getMMPoint() {
        if (this.mMMPoint != null) goto L6;
        this.mMMPoint = new Point(AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE);
    L6:
        return this.mMMPoint;
    }

    public String toString() {
        return "LocationEntity{, mGpsDir=" + this.mGpsDir + ", mSensorDir=" + this.mSensorDir + ", mGeoPoint=" + this.mGeoPoint + ", mMMPoint=" + this.mMMPoint + ", mSpeed=" + this.mSpeed + ", mRadius=" + this.mRadius + ", mLocType=" + this.mLocType + ", mInRoom=" + this.mInRoom + ", mSatelliteSize=" + this.mSatelliteSize + ", mGpsTime=" + this.mGpsTime + ", mCurTime=" + this.mCurTime + ", state=" + this.state + ", mRoutePlanNodeType=" + this.mRoutePlanNodeType + '}';
    }

    public LocInfo() {
        this.state = 0;
    }

    public long getCurTime() {
        return this.mCurTime;
    }

    public Point getGeoPoint() {
        return this.mGeoPoint;
    }

    public int getGpsDir() {
        return this.mGpsDir;
    }

    public long getGpsTime() {
        return this.mGpsTime;
    }

    public int getInRoom() {
        return this.mInRoom;
    }

    public int getLocType() {
        return this.mLocType;
    }

    public int getRadius() {
        return this.mRadius;
    }

    public int getRoutePlanNodeType() {
        return this.mRoutePlanNodeType;
    }

    public int getSatelliteSize() {
        return this.mSatelliteSize;
    }

    public int getSensorDir() {
        return this.mSensorDir;
    }

    public int getSpeed() {
        return this.mSpeed;
    }

    public int getState() {
        return this.state;
    }

    public void setCurTime(long r100) {
        this.mCurTime = r100;
    }

    public void setGeoPoint(Point r100) {
        this.mGeoPoint = r100;
    }

    public void setGpsDir(int r100) {
        this.mGpsDir = r100;
    }

    public void setGpsTime(long r100) {
        this.mGpsTime = r100;
    }

    public void setInRoom(int r100) {
        this.mInRoom = r100;
    }

    public void setLocType(int r100) {
        this.mLocType = r100;
    }

    public void setMMPoint(Point r100) {
        this.mMMPoint = r100;
    }

    public void setRadius(int r100) {
        this.mRadius = r100;
    }

    public void setRoutePlanNodeType(int r100) {
        this.mRoutePlanNodeType = r100;
    }

    public void setSatelliteSize(int r100) {
        this.mSatelliteSize = r100;
    }

    public void setSensorDir(int r100) {
        this.mSensorDir = r100;
    }

    public void setSpeed(int r100) {
        this.mSpeed = r100;
    }

    public void setState(int r100) {
        this.state = r100;
    }
}
