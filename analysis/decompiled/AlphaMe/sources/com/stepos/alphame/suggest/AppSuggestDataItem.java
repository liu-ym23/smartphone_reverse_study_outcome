package com.stepos.alphame.suggest;

import com.alibaba.fastjson.JSON;
import com.stepos.alphame.NotProguard;
import com.stepos.alphame.data.DataItem;

/* loaded from: classes.dex */
public class AppSuggestDataItem extends DataItem {
    private String mAppInstalledList;
    private String mClsName;
    private String mDate;
    private int mDriving;
    private int mEarphone;
    private int mEnergy;
    private String mExtend1;
    private String mExtend2;
    private int mId;
    private String mLatitude;
    private String mLongitude;
    private String mPkgName;
    private String mPosition;
    private int mPositionType;
    private int mReported;
    private String mTime;
    private long mTimestamp;
    private int mType;
    private int mWifi;

    @NotProguard
    public void create(String str, String str2, int i4, String str3, String str4, long j4, String str5, int i5, int i6, String str6, String str7, String str8, int i7, int i8, int i9, int i10, String str9, String str10) {
        this.mPkgName = str;
        this.mClsName = str2;
        this.mType = i4;
        this.mDate = str3;
        this.mTime = str4;
        this.mTimestamp = j4;
        this.mAppInstalledList = str5;
        this.mDriving = i5;
        this.mPositionType = i6;
        this.mPosition = str6;
        this.mLatitude = str7;
        this.mLongitude = str8;
        this.mWifi = i7;
        this.mEnergy = i8;
        this.mEarphone = i9;
        this.mReported = i10;
        this.mExtend1 = str9;
        this.mExtend2 = str10;
    }

    @NotProguard
    public void fill(String str) {
    }

    @NotProguard
    public void generate(int i4, String str, String str2, int i5, String str3, String str4, long j4, String str5, int i6, int i7, String str6, String str7, String str8, int i8, int i9, int i10, int i11, String str9, String str10) {
        this.mId = i4;
        this.mPkgName = str;
        this.mClsName = str2;
        this.mType = i5;
        this.mDate = str3;
        this.mTime = str4;
        this.mTimestamp = j4;
        this.mAppInstalledList = str5;
        this.mDriving = i6;
        this.mPositionType = i7;
        this.mPosition = str6;
        this.mLatitude = str7;
        this.mLongitude = str8;
        this.mWifi = i8;
        this.mEnergy = i9;
        this.mEarphone = i10;
        this.mReported = i11;
        this.mExtend1 = str9;
        this.mExtend2 = str10;
    }

    public String getAppInstalledList() {
        return this.mAppInstalledList;
    }

    public String getClsName() {
        return this.mClsName;
    }

    public String getDate() {
        return this.mDate;
    }

    public int getDriving() {
        return this.mDriving;
    }

    public int getEarphone() {
        return this.mEarphone;
    }

    public int getEnergy() {
        return this.mEnergy;
    }

    public String getExtend1() {
        return this.mExtend1;
    }

    public String getExtend2() {
        return this.mExtend2;
    }

    public int getId() {
        return this.mId;
    }

    public String getLatitude() {
        return this.mLatitude;
    }

    public String getLongitude() {
        return this.mLongitude;
    }

    public String getPkgName() {
        return this.mPkgName;
    }

    public String getPosition() {
        return this.mPosition;
    }

    public int getPositionType() {
        return this.mPositionType;
    }

    public int getReported() {
        return this.mReported;
    }

    public String getTime() {
        return this.mTime;
    }

    public long getTimestamp() {
        return this.mTimestamp;
    }

    public int getType() {
        return this.mType;
    }

    public int getWifi() {
        return this.mWifi;
    }

    public void setAppInstalledList(String str) {
        this.mAppInstalledList = str;
    }

    public void setClsName(String str) {
        this.mClsName = str;
    }

    public void setDate(String str) {
        this.mDate = str;
    }

    public void setDriving(int i4) {
        this.mDriving = i4;
    }

    public void setEarphone(int i4) {
        this.mEarphone = i4;
    }

    public void setEnergy(int i4) {
        this.mEnergy = i4;
    }

    public void setExtend1(String str) {
        this.mExtend1 = str;
    }

    public void setExtend2(String str) {
        this.mExtend2 = str;
    }

    public void setId(int i4) {
        this.mId = i4;
    }

    public void setLatitude(String str) {
        this.mLatitude = str;
    }

    public void setLongitude(String str) {
        this.mLongitude = str;
    }

    public void setPkgName(String str) {
        this.mPkgName = str;
    }

    public void setPosition(String str) {
        this.mPosition = str;
    }

    public void setPositionType(int i4) {
        this.mPositionType = i4;
    }

    public void setReported(int i4) {
        this.mReported = i4;
    }

    public void setTime(String str) {
        this.mTime = str;
    }

    public void setTimestamp(long j4) {
        this.mTimestamp = j4;
    }

    public void setType(int i4) {
        this.mType = i4;
    }

    public void setWifi(int i4) {
        this.mWifi = i4;
    }

    public String toString() {
        try {
            return JSON.toJSONString(this);
        } catch (Exception e4) {
            e4.printStackTrace();
            return "";
        }
    }
}
