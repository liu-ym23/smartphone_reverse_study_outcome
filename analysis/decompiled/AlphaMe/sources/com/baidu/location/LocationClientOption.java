package com.baidu.location;

import B0.g;
import android.text.TextUtils;
import androidx.room.AbstractC0351g;

/* loaded from: classes.dex */
public final class LocationClientOption {
    public static final int FUZZY_MODE = 4;
    public static final int GPS_FIRST = 1;
    public static final int GPS_ONLY = 2;
    public static final int LOC_SENSITIVITY_HIGHT = 1;
    public static final int LOC_SENSITIVITY_LOW = 3;
    public static final int LOC_SENSITIVITY_MIDDLE = 2;
    public static final int MIN_AUTO_NOTIFY_INTERVAL = 10000;
    public static final int MIN_SCAN_SPAN = 1000;
    public static final int NETWORK_FIRST = 3;

    /* renamed from: a, reason: collision with root package name */
    protected LocationMode f5068a;
    public String addrType;
    public float autoNotifyLocSensitivity;
    public int autoNotifyMaxInterval;
    public int autoNotifyMinDistance;
    public int autoNotifyMinTimeInterval;
    public String coorType;
    public boolean disableLocCache;
    public boolean enableSimulateGps;
    public FirstLocType firstLocType;
    public boolean isEnableBeidouMode;
    public boolean isIgnoreCacheException;
    public boolean isIgnoreKillProcess;
    public boolean isNeedAltitude;
    public boolean isNeedAptag;
    public boolean isNeedAptagd;
    public boolean isNeedNewVersionRgc;
    public boolean isNeedPoiRegion;
    public boolean isNeedRegular;
    public boolean isOnceLocation;
    public int locLegalStatus;
    public boolean location_change_notify;
    public boolean mIsNeedDeviceDirect;
    public String mPassword;
    public String mProxyHost;
    public int mProxyPort;
    public String mUsername;
    public boolean openGps;
    public int priority;
    public String prodName;
    public int scanSpan;
    public String serviceName;
    public int timeOut;
    public int wifiCacheTimeOut;

    /* renamed from: com.baidu.location.LocationClientOption$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f5069a;

        static {
            int[] iArr = new int[LocationMode.values().length];
            f5069a = iArr;
            try {
                iArr[LocationMode.Hight_Accuracy.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f5069a[LocationMode.Battery_Saving.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f5069a[LocationMode.Device_Sensors.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f5069a[LocationMode.Fuzzy_Locating.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public enum BDLocationPurpose {
        SignIn,
        Sport,
        Transport
    }

    public enum FirstLocType {
        SPEED_IN_FIRST_LOC,
        ACCURACY_IN_FIRST_LOC
    }

    public enum LocationMode {
        Hight_Accuracy,
        Battery_Saving,
        Device_Sensors,
        Fuzzy_Locating
    }

    public LocationClientOption() {
        this.coorType = "gcj02";
        this.addrType = "noaddr";
        this.openGps = false;
        this.scanSpan = 0;
        this.timeOut = 12000;
        this.prodName = "SDK6.0";
        this.priority = 1;
        this.location_change_notify = false;
        this.disableLocCache = true;
        this.enableSimulateGps = false;
        this.serviceName = "com.baidu.location.service_v2.9";
        this.isIgnoreCacheException = true;
        this.isIgnoreKillProcess = true;
        this.mIsNeedDeviceDirect = false;
        this.isNeedAptag = false;
        this.isNeedAptagd = false;
        this.isNeedPoiRegion = false;
        this.isNeedRegular = false;
        this.isNeedAltitude = false;
        this.isNeedNewVersionRgc = true;
        this.isOnceLocation = false;
        this.autoNotifyMaxInterval = 0;
        this.autoNotifyLocSensitivity = 0.5f;
        this.autoNotifyMinTimeInterval = 0;
        this.autoNotifyMinDistance = 0;
        this.wifiCacheTimeOut = Integer.MAX_VALUE;
        this.locLegalStatus = 1;
        this.isEnableBeidouMode = false;
        this.firstLocType = FirstLocType.SPEED_IN_FIRST_LOC;
        this.mProxyHost = null;
        this.mProxyPort = -1;
        this.mUsername = null;
        this.mPassword = null;
    }

    public void SetIgnoreCacheException(boolean z4) {
        this.isIgnoreCacheException = z4;
    }

    public int a() {
        return this.autoNotifyMaxInterval;
    }

    public float b() {
        return this.autoNotifyLocSensitivity;
    }

    @Deprecated
    public void disableCache(boolean z4) {
        this.disableLocCache = z4;
    }

    public String getAddrType() {
        return this.addrType;
    }

    public int getAutoNotifyMinDistance() {
        return this.autoNotifyMinDistance;
    }

    public int getAutoNotifyMinTimeInterval() {
        return this.autoNotifyMinTimeInterval;
    }

    public String getCoorType() {
        return this.coorType;
    }

    public LocationMode getLocationMode() {
        return this.f5068a;
    }

    public int getPriority() {
        return this.priority;
    }

    public String getProdName() {
        return this.prodName;
    }

    public int getScanSpan() {
        return this.scanSpan;
    }

    @Deprecated
    public String getServiceName() {
        return this.serviceName;
    }

    @Deprecated
    public int getTimeOut() {
        return this.timeOut;
    }

    @Deprecated
    public boolean isDisableCache() {
        return this.disableLocCache;
    }

    public boolean isLocationNotify() {
        return this.location_change_notify;
    }

    public boolean isOnceLocation() {
        return this.isOnceLocation;
    }

    public boolean isOpenGnss() {
        return this.openGps;
    }

    @Deprecated
    public boolean isOpenGps() {
        return this.openGps;
    }

    public boolean optionEquals(LocationClientOption locationClientOption) {
        return this.coorType.equals(locationClientOption.coorType) && this.addrType.equals(locationClientOption.addrType) && this.openGps == locationClientOption.openGps && this.scanSpan == locationClientOption.scanSpan && this.timeOut == locationClientOption.timeOut && this.prodName.equals(locationClientOption.prodName) && this.location_change_notify == locationClientOption.location_change_notify && this.priority == locationClientOption.priority && this.disableLocCache == locationClientOption.disableLocCache && this.isIgnoreCacheException == locationClientOption.isIgnoreCacheException && this.isNeedNewVersionRgc == locationClientOption.isNeedNewVersionRgc && this.isIgnoreKillProcess == locationClientOption.isIgnoreKillProcess && this.isNeedAptag == locationClientOption.isNeedAptag && this.isNeedAptagd == locationClientOption.isNeedAptagd && this.isNeedPoiRegion == locationClientOption.isNeedPoiRegion && this.isNeedRegular == locationClientOption.isNeedRegular && this.mIsNeedDeviceDirect == locationClientOption.mIsNeedDeviceDirect && this.autoNotifyMaxInterval == locationClientOption.autoNotifyMaxInterval && this.autoNotifyLocSensitivity == locationClientOption.autoNotifyLocSensitivity && this.autoNotifyMinTimeInterval == locationClientOption.autoNotifyMinTimeInterval && this.autoNotifyMinDistance == locationClientOption.autoNotifyMinDistance && this.wifiCacheTimeOut == locationClientOption.wifiCacheTimeOut && this.isOnceLocation == locationClientOption.isOnceLocation && this.locLegalStatus == locationClientOption.locLegalStatus && this.isEnableBeidouMode == locationClientOption.isEnableBeidouMode && this.isNeedAltitude == locationClientOption.isNeedAltitude && this.f5068a == locationClientOption.f5068a && this.enableSimulateGps == locationClientOption.enableSimulateGps && this.firstLocType == locationClientOption.firstLocType;
    }

    @Deprecated
    public void setAddrType(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        setIsNeedAddress("all".equals(str));
    }

    public void setCoorType(String str) {
        String lowerCase = str.toLowerCase();
        if (lowerCase.equals("gcj02") || lowerCase.equals("bd09") || lowerCase.equals("bd09ll")) {
            this.coorType = lowerCase;
        }
    }

    public void setEnableSimulateGnss(boolean z4) {
        this.enableSimulateGps = z4;
    }

    @Deprecated
    public void setEnableSimulateGps(boolean z4) {
        this.enableSimulateGps = z4;
    }

    public void setFirstLocType(FirstLocType firstLocType) {
        this.firstLocType = firstLocType;
    }

    public void setHttpProxyUsernameAndPassword(String str, String str2) {
        this.mUsername = str;
        this.mPassword = str2;
    }

    public void setIgnoreKillProcess(boolean z4) {
        this.isIgnoreKillProcess = z4;
    }

    public void setIsEnableBeidouMode(boolean z4) {
        this.isEnableBeidouMode = z4;
    }

    public void setIsNeedAddress(boolean z4) {
        this.addrType = z4 ? "all" : "noaddr";
    }

    public void setIsNeedAltitude(boolean z4) {
        this.isNeedAltitude = z4;
    }

    public void setIsNeedLocationDescribe(boolean z4) {
        this.isNeedAptag = z4;
    }

    public void setIsNeedLocationPoiList(boolean z4) {
        this.isNeedAptagd = z4;
    }

    public void setLocStatus(boolean z4) {
        this.locLegalStatus = z4 ? 1 : !z4 ? -2 : 0;
    }

    public void setLocationMode(LocationMode locationMode) {
        int i4 = AnonymousClass1.f5069a[locationMode.ordinal()];
        if (i4 == 1) {
            this.openGps = true;
            this.priority = 1;
        } else if (i4 == 2) {
            this.openGps = false;
            this.priority = 3;
        } else if (i4 == 3) {
            this.priority = 2;
            this.openGps = true;
        } else {
            if (i4 != 4) {
                throw new IllegalArgumentException("Illegal this mode : " + locationMode);
            }
            this.priority = 4;
            this.openGps = false;
        }
        this.f5068a = locationMode;
    }

    public void setLocationNotify(boolean z4) {
        this.location_change_notify = z4;
    }

    public void setLocationPurpose(BDLocationPurpose bDLocationPurpose) {
        if (bDLocationPurpose != null) {
            if (bDLocationPurpose == BDLocationPurpose.SignIn) {
                setLocationMode(LocationMode.Hight_Accuracy);
                setLocationNotify(false);
                setScanSpan(0);
                setNeedNewVersionRgc(true);
                setIsNeedAddress(true);
                setIsNeedLocationPoiList(true);
                setIsNeedAltitude(true);
                setIsNeedLocationDescribe(true);
                setWifiCacheTimeOut(10000);
                return;
            }
            if (bDLocationPurpose == BDLocationPurpose.Sport) {
                setLocationMode(LocationMode.Hight_Accuracy);
                setLocationNotify(true);
                setScanSpan(3000);
            } else {
                if (bDLocationPurpose != BDLocationPurpose.Transport) {
                    return;
                }
                setLocationMode(LocationMode.Hight_Accuracy);
                setLocationNotify(true);
                setScanSpan(1000);
            }
            setNeedNewVersionRgc(true);
            setIsNeedAddress(true);
            setIsNeedLocationPoiList(false);
            setIsNeedAltitude(true);
            setIsNeedLocationDescribe(false);
            setWifiCacheTimeOut(1000);
        }
    }

    public void setNeedDeviceDirect(boolean z4) {
        this.mIsNeedDeviceDirect = z4;
    }

    public void setNeedNewVersionRgc(boolean z4) {
        this.isNeedNewVersionRgc = z4;
    }

    public void setOnceLocation(boolean z4) {
        this.isOnceLocation = z4;
    }

    public void setOpenAutoNotifyMode() {
        setOpenAutoNotifyMode(0, 0, 1);
    }

    public void setOpenGnss(boolean z4) {
        this.openGps = z4;
    }

    @Deprecated
    public void setOpenGps(boolean z4) {
        this.openGps = z4;
    }

    @Deprecated
    public void setPriority(int i4) {
        if (i4 == 1 || i4 == 3) {
            this.priority = i4;
        }
    }

    public void setProdName(String str) {
        if (str.length() > 64) {
            str = str.substring(0, 64);
        }
        this.prodName = str;
    }

    public void setProxy(String str, int i4) {
        this.mProxyHost = str;
        this.mProxyPort = i4;
    }

    public void setScanSpan(int i4) {
        if (i4 >= 0) {
            this.scanSpan = i4;
        }
    }

    @Deprecated
    public void setSema(boolean z4, boolean z5, boolean z6) {
        this.isNeedAptag = z4;
        this.isNeedPoiRegion = z5;
        this.isNeedRegular = z6;
    }

    @Deprecated
    public void setServiceName(String str) {
        this.serviceName = str;
    }

    @Deprecated
    public void setTimeOut(int i4) {
        this.timeOut = i4;
    }

    public void setWifiCacheTimeOut(int i4) {
        if (i4 >= 10000) {
            this.wifiCacheTimeOut = i4;
        }
    }

    public LocationClientOption(LocationClientOption locationClientOption) {
        this.coorType = "gcj02";
        this.addrType = "noaddr";
        this.openGps = false;
        this.scanSpan = 0;
        this.timeOut = 12000;
        this.prodName = "SDK6.0";
        this.priority = 1;
        this.location_change_notify = false;
        this.disableLocCache = true;
        this.enableSimulateGps = false;
        this.serviceName = "com.baidu.location.service_v2.9";
        this.isIgnoreCacheException = true;
        this.isIgnoreKillProcess = true;
        this.mIsNeedDeviceDirect = false;
        this.isNeedAptag = false;
        this.isNeedAptagd = false;
        this.isNeedPoiRegion = false;
        this.isNeedRegular = false;
        this.isNeedAltitude = false;
        this.isNeedNewVersionRgc = true;
        this.isOnceLocation = false;
        this.autoNotifyMaxInterval = 0;
        this.autoNotifyLocSensitivity = 0.5f;
        this.autoNotifyMinTimeInterval = 0;
        this.autoNotifyMinDistance = 0;
        this.wifiCacheTimeOut = Integer.MAX_VALUE;
        this.locLegalStatus = 1;
        this.isEnableBeidouMode = false;
        this.firstLocType = FirstLocType.SPEED_IN_FIRST_LOC;
        this.mProxyHost = null;
        this.mProxyPort = -1;
        this.mUsername = null;
        this.mPassword = null;
        this.coorType = locationClientOption.coorType;
        this.addrType = locationClientOption.addrType;
        this.openGps = locationClientOption.openGps;
        this.scanSpan = locationClientOption.scanSpan;
        this.timeOut = locationClientOption.timeOut;
        this.prodName = locationClientOption.prodName;
        this.priority = locationClientOption.priority;
        this.location_change_notify = locationClientOption.location_change_notify;
        this.serviceName = locationClientOption.serviceName;
        this.disableLocCache = locationClientOption.disableLocCache;
        this.isIgnoreCacheException = locationClientOption.isIgnoreCacheException;
        this.isIgnoreKillProcess = locationClientOption.isIgnoreKillProcess;
        this.enableSimulateGps = locationClientOption.enableSimulateGps;
        this.f5068a = locationClientOption.f5068a;
        this.isNeedAptag = locationClientOption.isNeedAptag;
        this.isNeedAptagd = locationClientOption.isNeedAptagd;
        this.isNeedPoiRegion = locationClientOption.isNeedPoiRegion;
        this.isNeedRegular = locationClientOption.isNeedRegular;
        this.mIsNeedDeviceDirect = locationClientOption.mIsNeedDeviceDirect;
        this.isNeedAltitude = locationClientOption.isNeedAltitude;
        this.autoNotifyMaxInterval = locationClientOption.autoNotifyMaxInterval;
        this.autoNotifyLocSensitivity = locationClientOption.autoNotifyLocSensitivity;
        this.autoNotifyMinTimeInterval = locationClientOption.autoNotifyMinTimeInterval;
        this.autoNotifyMinDistance = locationClientOption.autoNotifyMinDistance;
        this.wifiCacheTimeOut = locationClientOption.wifiCacheTimeOut;
        this.isNeedNewVersionRgc = locationClientOption.isNeedNewVersionRgc;
        this.isOnceLocation = locationClientOption.isOnceLocation;
        this.locLegalStatus = locationClientOption.locLegalStatus;
        this.isEnableBeidouMode = locationClientOption.isEnableBeidouMode;
        this.firstLocType = locationClientOption.firstLocType;
        this.mProxyHost = locationClientOption.mProxyHost;
        this.mProxyPort = locationClientOption.mProxyPort;
        this.mUsername = locationClientOption.mUsername;
        this.mPassword = locationClientOption.mPassword;
    }

    public void setOpenAutoNotifyMode(int i4, int i5, int i6) {
        float f4;
        int i7 = i4 > 180000 ? i4 + 1000 : 180000;
        if (i7 < 10000) {
            throw new IllegalArgumentException(g.j("Illegal this maxLocInterval : ", i7, " , maxLocInterval must >= 10000"));
        }
        if (i6 == 1) {
            f4 = 0.5f;
        } else {
            if (i6 != 2) {
                if (i6 != 3) {
                    throw new IllegalArgumentException(AbstractC0351g.m("Illegal this locSensitivity : ", i6));
                }
                this.autoNotifyLocSensitivity = 0.1f;
                this.autoNotifyMaxInterval = i7;
                this.autoNotifyMinTimeInterval = i4;
                this.autoNotifyMinDistance = i5;
            }
            f4 = 0.3f;
        }
        this.autoNotifyLocSensitivity = f4;
        this.autoNotifyMaxInterval = i7;
        this.autoNotifyMinTimeInterval = i4;
        this.autoNotifyMinDistance = i5;
    }
}
