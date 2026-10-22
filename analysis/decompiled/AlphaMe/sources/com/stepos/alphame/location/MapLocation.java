package com.stepos.alphame.location;

import android.location.Location;
import com.baidu.location.BDLocation;

/* loaded from: classes.dex */
public class MapLocation {
    public static final int LOCATION_TYPE_CACHE = 65;
    private float accuracy;
    private String address;
    private String city;
    private String country;
    private String district;
    private int errorCode;
    private String errorInfo;
    private double latitude;
    private int locationType;
    private double longitude;
    private String provider;
    private String province;
    private long time;
    private int trustedLevel;

    public MapLocation() {
        this.errorCode = -1;
        this.provider = "baidu";
    }

    public static MapLocation from(BDLocation bDLocation) {
        MapLocation mapLocation = new MapLocation();
        if (bDLocation == null) {
            mapLocation.errorCode = -1;
            mapLocation.errorInfo = "location is null";
            return mapLocation;
        }
        int locType = bDLocation.getLocType();
        mapLocation.locationType = locType;
        if (locType == 0 || locType == 62 || locType == 167) {
            mapLocation.errorCode = locType;
            mapLocation.errorInfo = bDLocation.getLocTypeDescription();
        } else {
            mapLocation.errorCode = 0;
        }
        mapLocation.latitude = bDLocation.getLatitude();
        mapLocation.longitude = bDLocation.getLongitude();
        mapLocation.accuracy = bDLocation.getRadius();
        mapLocation.address = bDLocation.getAddrStr();
        mapLocation.country = bDLocation.getCountry();
        mapLocation.province = bDLocation.getProvince();
        mapLocation.city = bDLocation.getCity();
        mapLocation.district = bDLocation.getDistrict();
        mapLocation.time = System.currentTimeMillis();
        mapLocation.provider = "baidu";
        return mapLocation;
    }

    public float getAccuracy() {
        return this.accuracy;
    }

    public String getAddress() {
        return this.address;
    }

    public String getCity() {
        return this.city;
    }

    public String getCountry() {
        return this.country;
    }

    public String getDistrict() {
        return this.district;
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public String getErrorInfo() {
        return this.errorInfo;
    }

    public double getLatitude() {
        return this.latitude;
    }

    public int getLocationType() {
        return this.locationType;
    }

    public double getLongitude() {
        return this.longitude;
    }

    public String getProvider() {
        return this.provider;
    }

    public String getProvince() {
        return this.province;
    }

    public long getTime() {
        return this.time;
    }

    public int getTrustedLevel() {
        return this.trustedLevel;
    }

    public void setAccuracy(float f4) {
        this.accuracy = f4;
    }

    public void setAddress(String str) {
        this.address = str;
    }

    public void setCity(String str) {
        this.city = str;
    }

    public void setCountry(String str) {
        this.country = str;
    }

    public void setDistrict(String str) {
        this.district = str;
    }

    public void setLatitude(double d4) {
        this.latitude = d4;
    }

    public void setLongitude(double d4) {
        this.longitude = d4;
    }

    public void setProvince(String str) {
        this.province = str;
    }

    public MapLocation(String str) {
        this.errorCode = -1;
        this.provider = str;
    }

    public static MapLocation from(Location location) {
        MapLocation mapLocation = new MapLocation(location.getProvider());
        mapLocation.errorCode = 0;
        mapLocation.locationType = 0;
        mapLocation.latitude = location.getLatitude();
        mapLocation.longitude = location.getLongitude();
        mapLocation.accuracy = location.getAccuracy();
        mapLocation.time = location.getTime() > 0 ? location.getTime() : System.currentTimeMillis();
        return mapLocation;
    }
}
