package com.stepos.alphame.location;

import B0.f;
import B0.g;
import F1.n;
import android.annotation.SuppressLint;
import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.PowerManager;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.platform.comapi.map.MapController;
import com.stepos.alphame.ApplicationImpl;
import com.stepos.alphame.NotProguard;
import com.stepos.alphame.awareness.AwarenessDataItem;
import com.stepos.alphame.awareness.AwarenessDataSource;
import com.stepos.alphame.awareness.AwarenessStorable;
import com.stepos.alphame.awareness.TimetableTracker;
import com.stepos.alphame.data.DataItem;
import com.stepos.alphame.engine.EngineBase;
import com.stepos.alphame.engine.EngineFunc;
import com.stepos.alphame.manager.ActionManager;
import com.stepos.alphame.persona.data.config.PersonalPreferenceConfigs;
import com.stepos.alphame.request.CountryInfoBean;
import com.stepos.alphame.request.RequestManager;
import com.stepos.alphame.request.ResponseListener;
import com.stepos.alphame.systemstate.SystemStateMachine;
import com.stepos.alphame.utils.AlphaMeLogger;
import com.stepos.alphame.utils.Consts;
import com.stepos.alphame.utils.LocalConsts;
import com.stepos.alphame.utils.NetworkHelper;
import com.stepos.alphame.utils.Property;
import com.stepos.alphame.utils.StringUtil;
import com.stepos.alphame.utils.TelephonyUtils;
import com.stepos.alphame.utils.ThreadPool;
import com.stepos.alphame.utils.UsageStatsUtils;
import com.stepos.alphame.utils.Utils;
import com.stepos.alphame.wifi.WifiEngine;
import com.stepos.common.alphame.b;
import com.stepos.common.alphame.c;
import com.stepos.policy.sdk.util.PolicySdkPermissionManifestUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* loaded from: classes.dex */
public class LocationEngine extends EngineBase implements MapLocationListener {
    private static final String DEFAULT_COUNTRY_LANGUAGE = "zh";
    private static final double GEOCODE_MIN_DISTANCE_M = 100.0d;
    private static final long GEOCODE_THROTTLE_MS = 300000;
    private static final long HOME_COMPANY_AREA = 1000;
    private static final int IDX_MAP_COUNTRY = 0;
    private static final int IDX_SYSTEM_COUNTRY_CODE = 1;
    private static final int IDX_SYSTEM_COUNTRY_UTC = 2;
    public static final String KEY_COUNTRY_SETTING = "zyql_region";
    private static final long LOCATION_TIME_OUT_BLUETOOTH = 30000;
    private static final long LOCATION_TIME_OUT_NORMAL = 8000;
    private static final long MOVE_MIN_DURATION = 1800000;
    protected static final String TAG = "Location";
    private static long UPDATE_MIN_DURATION = 60000;
    private static long UPDATE_MIN_DURATION_LOCATION = 3600000;

    @SuppressLint({"StaticFieldLeak"})
    private static LocationEngine sInstance;
    SettingsValueChangeContentObserver mContentOb;
    private Context mContext;
    private String[] mDebugQueryHomeCompanyResult;
    private Geocoder mGeocoder;
    private Handler mHandler;
    private LocationRecord mLocationRecord;
    private LocationListener mPassiveLocationListener;
    private b mScreenEventReceiver;
    private android.location.LocationManager mSysLocationManager;
    private b mSystemStateReceiver;
    private long mLastUpdateTime = 0;
    private MapLocationClient mlocationClient = null;
    private long mLastLocationTime = 0;
    private MapLocation mLastLocation = null;
    private String mCity = null;
    private boolean mSettingRegionChanged = true;
    private final ArrayList<x3.b> mPendingLocationAction = new ArrayList<>();
    private boolean mPassiveLocationRegistered = false;
    private double mLastGeocodeLat = 0.0d;
    private double mLastGeocodeLon = 0.0d;
    private long mLastGeocodeTime = 0;
    private boolean mUpdateWaiting = false;
    private int mLocationFrom = -1;

    public class ChooseCompany extends EngineFunc {
        public ChooseCompany(EngineBase engineBase) {
            super(engineBase);
            this.name = LocalConsts.FUNC_CHOOSE_COMPANY;
            this.argsType = new byte[]{6, 6};
            this.argsName = new String[]{"coord", "addr"};
            this.returnType = (byte) 0;
            this.annotation = new String[]{"手动选择公司地址", "输入参数：地址坐标，具体地址", "@author  lxh"};
        }
    }

    public class ChooseHome extends EngineFunc {
        public ChooseHome(EngineBase engineBase) {
            super(engineBase);
            this.name = LocalConsts.FUNC_CHOOSE_HOME;
            this.argsType = new byte[]{6, 6};
            this.argsName = new String[]{"coord", "addr"};
            this.returnType = (byte) 0;
            this.annotation = new String[]{"手动选择家地址", "输入参数：地址坐标，具体地址", "@author  lxh"};
        }
    }

    public class GetAllWifiInfo extends EngineFunc {
        public GetAllWifiInfo(EngineBase engineBase) {
            super(engineBase);
            this.name = LocalConsts.FUNC_GET_ALL_WIFI;
            this.argsType = new byte[]{0};
            this.argsName = new String[]{""};
            this.returnType = (byte) 6;
            this.annotation = new String[]{"获取所有的WiFi信息", "@return：WiFi信息", "@author  lyj"};
        }
    }

    public class GetChosenCompany extends EngineFunc {
        public GetChosenCompany(EngineBase engineBase) {
            super(engineBase);
            this.name = LocalConsts.FUNC_GET_CHOSEN_COMPANY;
            this.argsType = new byte[]{0};
            this.argsName = new String[]{""};
            this.returnType = (byte) 9;
            this.annotation = new String[]{"手动选择公司地址", "@return {'公司坐标，公司地址'}", "@author  lxh"};
        }
    }

    public class GetChosenHome extends EngineFunc {
        public GetChosenHome(EngineBase engineBase) {
            super(engineBase);
            this.name = LocalConsts.FUNC_GET_CHOSEN_HOME;
            this.argsType = new byte[]{0};
            this.argsName = new String[]{""};
            this.returnType = (byte) 9;
            this.annotation = new String[]{"手动选择家地址", "@return {'家坐标，家地址'}", "@author  lxh"};
        }
    }

    public class GetCityHistory extends EngineFunc {
        public GetCityHistory(EngineBase engineBase) {
            super(engineBase);
            this.name = LocalConsts.FUNC_GET_CITY_HISTORY;
            this.argsType = new byte[]{5, 5};
            this.argsName = new String[]{"start", "end"};
            this.returnType = (byte) 12;
            this.annotation = new String[]{"获取指定时间范围内的城市变化记录", "输入参数：开始和结束时间", "@author  lxh", "@return 城市吧变化信息 , List<String>格式,['珠海市,进入城市时间','广州市,进入城市时间',...]"};
        }
    }

    public class GetCompanyWifiList extends EngineFunc {
        public GetCompanyWifiList(EngineBase engineBase) {
            super(engineBase);
            this.name = LocalConsts.FUNC_GET_COMPANY_WIFI_LIST;
            this.argsType = new byte[]{0};
            this.argsName = new String[]{""};
            this.returnType = (byte) 6;
            this.annotation = new String[]{"获取公司的所有的WiFi信息", "@return：WiFi信息", "@author  lyj"};
        }
    }

    public class GetFrequentLocations extends EngineFunc {
        public GetFrequentLocations(EngineBase engineBase) {
            super(engineBase);
            this.name = LocalConsts.FUNC_GET_FREQUENT_LOCATIONS;
            this.argsType = new byte[]{13};
            this.argsName = new String[]{"frequent"};
            this.returnType = (byte) 12;
            this.annotation = new String[]{"获取常去地址列表", "输入参数：frequent，范围0到0.8f，建议使用0.4f", "@author  lxh", "@return {'经度,纬度,位置类型', '经度,纬度,位置类型'......}"};
        }
    }

    public class GetHomeWifiList extends EngineFunc {
        public GetHomeWifiList(EngineBase engineBase) {
            super(engineBase);
            this.name = LocalConsts.FUNC_GET_HOME_WIFI_LIST;
            this.argsType = new byte[]{0};
            this.argsName = new String[]{""};
            this.returnType = (byte) 6;
            this.annotation = new String[]{"获取家的所有的WiFi信息", "@return：WiFi信息", "@author  lyj"};
        }
    }

    public class GetLastLocation extends EngineFunc {
        public GetLastLocation(EngineBase engineBase) {
            super(engineBase);
            this.name = "getLastLocation";
            this.argsType = new byte[]{0};
            this.argsName = new String[]{""};
            this.returnType = (byte) 9;
            this.annotation = new String[]{"获取上次定位位置", "输入参数：无", "@author  lxh", "@return 获取上次定位位置 , String[]格式,[国家，省份，城市，地址全文，坐标，上次地址获取的时间，精准度]"};
        }
    }

    public class GetLocationByID extends EngineFunc {
        public GetLocationByID(EngineBase engineBase) {
            super(engineBase);
            this.name = LocalConsts.FUNC_GET_LOCATION_INFO_BY_ID;
            this.argsType = new byte[]{4};
            this.argsName = new String[]{"type"};
            this.returnType = (byte) 9;
            this.annotation = new String[]{"获取家或公司的信息", "输入参数：0 家， 1 公司", "@author  lxh", "@return 家或公司的信息 , String[]格式,[全地址，坐标，国家，省份，城市]"};
        }
    }

    public class HomeAndCompany extends EngineFunc {
        public HomeAndCompany(EngineBase engineBase) {
            super(engineBase);
            this.name = "getHomeAndCompany";
            this.argsType = new byte[]{13};
            this.argsName = new String[]{"chance"};
            this.returnType = (byte) 12;
            this.annotation = new String[]{"获取家和公司地址", "@author lipan", "@return 用户所有可能家和公司地址 , ArrayList<String>格式"};
        }
    }

    public class LocationInfo extends EngineFunc {
        public LocationInfo(EngineBase engineBase) {
            super(engineBase);
            this.name = "getLocationInfos";
            this.argsType = new byte[]{6};
            this.argsName = new String[]{"currentCoord"};
            this.returnType = (byte) 9;
            this.annotation = new String[]{"获取用户位置信息", "输入参数：当前经纬度（log,lat）", "@author lipan", "@return 用户常用地址 , String[]格式,[家地址，家经纬度，公司地址，公司经纬度，当前位置类型（家0，公司1，其它-1）]"};
        }
    }

    public class LocationRecord {
        private final String SPLITTER = ";";
        long lastLocTime;
        int locAcc_0;
        int locAcc_100;
        int locAcc_20;
        int locAcc_200;
        int locAcc_50;
        int locAcc_500;
        int locAcc_fail;
        long locInterval_avg;
        long locInterval_max;
        int locNum;

        public LocationRecord() {
        }

        public void onLocationChanged(MapLocation mapLocation) {
            if (mapLocation == null) {
                return;
            }
            if (mapLocation.getErrorCode() != 0) {
                this.locAcc_fail++;
            } else if (mapLocation.getAccuracy() <= 20.0f) {
                this.locAcc_0++;
            } else if (mapLocation.getAccuracy() <= 50.0f) {
                this.locAcc_20++;
            } else if (mapLocation.getAccuracy() <= 100.0f) {
                this.locAcc_50++;
            } else if (mapLocation.getAccuracy() <= 200.0f) {
                this.locAcc_100++;
            } else if (mapLocation.getAccuracy() <= 500.0f) {
                this.locAcc_200++;
            } else {
                this.locAcc_500++;
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            long j4 = this.lastLocTime;
            if (j4 > 0) {
                long j5 = jCurrentTimeMillis - j4;
                this.locInterval_max = Math.max(this.locInterval_max, j5);
                long j6 = this.locInterval_avg;
                this.locInterval_avg = ((j6 * (r9 - 1)) + j5) / this.locNum;
            } else {
                this.locInterval_avg = 0L;
                this.locInterval_max = 0L;
            }
            this.lastLocTime = jCurrentTimeMillis;
            this.locNum++;
        }
    }

    public class MakeLocation extends EngineFunc {
        public MakeLocation(EngineBase engineBase) {
            super(engineBase);
            this.name = LocalConsts.FUNC_MAKE_LOCATION;
            this.argsType = new byte[]{6, 6};
            this.argsName = new String[]{"start", "end"};
            this.returnType = (byte) 12;
            this.annotation = new String[]{"插入自己制造的位置数据", "输入参数：位置坐标（113.378682,22.552414），位置地址（42.0,广东省中山市民科西路20号靠近景城幼儿园,中国,广东省,中山市）", "@author  lxh", "@return 无"};
        }
    }

    public class QueryIsHomeCompanyAsync extends EngineFunc {
        public QueryIsHomeCompanyAsync(EngineBase engineBase) {
            super(engineBase);
            this.name = "queryIsHomeCompanyAsync";
            this.argsType = new byte[]{4};
            this.argsName = new String[]{"locationExpiredMs"};
            this.returnType = (byte) 0;
            this.annotation = new String[]{"判断是为公司或家", "输入参数：定位失效时长，单位ms", "@author zuoyong", "@return 结果从广播 ACTION_QUERY_HOME_COMPANY_RESULT 中返回。格式为 String[]格式,[当前位置类型（家0，公司1，其它-1）, 当前位置经纬度，当前地址，家经纬度，家地址，公司经纬度，公司地址]"};
        }
    }

    public class SettingsValueChangeContentObserver extends ContentObserver {
        public SettingsValueChangeContentObserver() {
            super(new Handler(Looper.getMainLooper()));
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z4) {
            super.onChange(z4);
            AlphaMeLogger.iLog("SettingsValueChangeContentObserver onChange");
            LocationEngine.this.mSettingRegionChanged = true;
            if (TextUtils.isEmpty(Property.getCountryInfo())) {
                LocationEngine.this.startLocation(10);
            } else {
                LocationEngine.this.checkCountryChange(null, null);
            }
        }
    }

    public class StartLocation extends EngineFunc {
        public StartLocation(EngineBase engineBase) {
            super(engineBase);
            this.name = "startLocation";
            this.argsType = new byte[]{0};
            this.argsName = new String[]{""};
            this.returnType = (byte) 0;
            this.annotation = new String[]{"申请定位", "输入参数：无", "@author  lxh", "@return 无，通过监听地理位置变化（ACTION_LOCATION_CHANGED）来获得定位结果"};
        }
    }

    public LocationEngine(Context context) {
        AlphaMeLogger.dLog("LocationEngine new");
        this.mContext = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void broadcastCountryChanged(final String str, String str2, final String[] strArr) {
        if (NetworkHelper.isConnectionAvailable(this.mContext)) {
            RequestManager.getInstance(this.mContext).requestCountryInfo(TAG, str2, null, new ResponseListener<CountryInfoBean>() { // from class: com.stepos.alphame.location.LocationEngine.8
                @Override // com.stepos.alphame.request.ResponseListener
                public void onFailed(int i4, Exception exc) {
                    AlphaMeLogger.dLog("check country change failed,  " + exc.toString());
                    LocationEngine.this.mSettingRegionChanged = false;
                }

                @Override // com.stepos.alphame.request.ResponseListener
                public void onSuccess(int i4, CountryInfoBean countryInfoBean) {
                    AlphaMeLogger.dLog(countryInfoBean.getCn() + ", " + countryInfoBean.getUtc());
                    ActionManager actionManager = ActionManager.getInstance();
                    String cn = countryInfoBean.getCn();
                    String utc = countryInfoBean.getUtc();
                    String[] strArr2 = strArr;
                    actionManager.broadcast(LocalConsts.ACTION_COUNTRY_CHANGED, new String[]{cn, utc, strArr2[1], strArr2[2]});
                    if (!TextUtils.isEmpty(str)) {
                        strArr[0] = str;
                    }
                    LocationEngine.this.saveCountryInfo(strArr);
                    LocationEngine.this.mSettingRegionChanged = false;
                }
            });
        }
    }

    private boolean canUsePassiveLocation() {
        if (!PersonalPreferenceConfigs.INSTANCE.getAutoLearningState() || !Utils.isPermissionAllowed(this.mContext)) {
            return false;
        }
        if (f.i(this.mContext, PolicySdkPermissionManifestUtils.ACCESS_FINE_LOCATION) != 0 && f.i(this.mContext, PolicySdkPermissionManifestUtils.ACCESS_COARSE_LOCATION) != 0) {
            return false;
        }
        PowerManager powerManager = (PowerManager) this.mContext.getSystemService("power");
        return (powerManager == null || powerManager.isInteractive()) && SystemStateMachine.getInstance().getTrackedSystemState() < 4;
    }

    private void checkPositionChange(MapLocation mapLocation) {
        if (mapLocation == null) {
            return;
        }
        if (mapLocation.getAccuracy() > 100.0f) {
            checkCityChange(mapLocation.getCity());
        }
        checkCountryChange(mapLocation.getCountry(), null);
    }

    private void ensureLocationManager() {
        if (this.mSysLocationManager == null) {
            this.mSysLocationManager = (android.location.LocationManager) this.mContext.getSystemService(MapController.LOCATION_LAYER_TAG);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getAddressStrFromAddressLine(Address address) {
        int maxAddressLineIndex = address.getMaxAddressLineIndex();
        String string = "";
        if (maxAddressLineIndex < 0) {
            return "";
        }
        for (int i4 = 0; i4 <= maxAddressLineIndex; i4++) {
            StringBuilder sbS = g.s(string);
            sbS.append(address.getAddressLine(i4));
            string = sbS.toString();
        }
        return string;
    }

    public static String getCountryName(Context context, String str) {
        return new Locale(DEFAULT_COUNTRY_LANGUAGE, str).getDisplayCountry(Locale.getDefault());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int getHomeCompanyType(FrequentLocation frequentLocation, FrequentLocation frequentLocation2, MapLocation mapLocation) {
        if (frequentLocation != null && mapLocation != null) {
            try {
                if (FrequentLocationManager.distanceOfTwoPoints(String.valueOf(mapLocation.getLongitude()), String.valueOf(mapLocation.getLatitude()), frequentLocation.getLongitude(), frequentLocation.getLatitude()) < 1000.0d) {
                    return 0;
                }
            } catch (Exception e4) {
                Log.w(TAG, "getHomeCompanyType error: " + e4.getMessage());
            }
        }
        if (frequentLocation2 == null || mapLocation == null) {
            return -1;
        }
        try {
            return FrequentLocationManager.distanceOfTwoPoints(String.valueOf(mapLocation.getLongitude()), String.valueOf(mapLocation.getLatitude()), frequentLocation2.getLongitude(), frequentLocation2.getLatitude()) < 1000.0d ? 1 : -1;
        } catch (Exception e5) {
            Log.w(TAG, "getHomeCompanyType error: " + e5.getMessage());
            return -1;
        }
    }

    public static LocationEngine getInstance(Context context) {
        if (sInstance == null) {
            sInstance = new LocationEngine(context);
        }
        return sInstance;
    }

    public static String getSystemCountryCode(Context context) {
        return Settings.System.getString(context.getContentResolver(), KEY_COUNTRY_SETTING);
    }

    public static String getSystemCountryName(Context context) {
        return getCountryName(context, getSystemCountryCode(context));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handlePassiveLocationChanged(Location location) {
        Log.d(TAG, "PASSIVE_PROVIDER onLocationChanged " + location);
        this.mLastLocationTime = System.currentTimeMillis();
        MapLocation mapLocationFrom = MapLocation.from(location);
        this.mLastLocation = mapLocationFrom;
        mapLocationFrom.setAccuracy(location.getAccuracy());
        if (shouldRunGeocode(location)) {
            final double latitude = location.getLatitude();
            final double longitude = location.getLongitude();
            final float accuracy = location.getAccuracy();
            final String provider = location.getProvider();
            ThreadPool.getInstance().submit(new ThreadPool.Job<Boolean>() { // from class: com.stepos.alphame.location.LocationEngine.2
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.stepos.alphame.utils.ThreadPool.Job
                public Boolean run() throws IOException {
                    List<Address> fromLocation;
                    try {
                        fromLocation = LocationEngine.this.mGeocoder.getFromLocation(latitude, longitude, 1);
                    } catch (Exception e4) {
                        AlphaMeLogger.exceptionLog("PASSIVE_PROVIDER error!!", e4);
                    }
                    if (fromLocation != null && !fromLocation.isEmpty()) {
                        Address address = fromLocation.get(0);
                        String str = longitude + "," + latitude;
                        AlphaMeLogger.dLog("location service, address " + address.toString());
                        ActionManager.getInstance().broadcast(LocalConsts.ACTION_LOCATION_CHANGED, new String[]{String.valueOf(11), str, accuracy + "," + LocationEngine.this.getAddressStrFromAddressLine(address) + "," + address.getCountryName() + "," + address.getAdminArea() + "," + address.getLocality() + "," + address.getSubAdminArea() + "," + provider, String.valueOf(FrequentLocationManager.getInstance(LocationEngine.this.mContext).getLocationType(str))});
                        LocationEngine.this.mLastLocation.setAddress(LocationEngine.this.getAddressStrFromAddressLine(address));
                        LocationEngine.this.mLastLocation.setCountry(address.getCountryName());
                        LocationEngine.this.mLastLocation.setProvince(address.getAdminArea());
                        LocationEngine.this.mLastLocation.setCity(address.getSubAdminArea());
                        LocationEngine.this.mLastLocation.setDistrict(address.getLocality());
                        return Boolean.TRUE;
                    }
                    return Boolean.FALSE;
                }
            });
        }
    }

    private void initLocalCountryInfo(final String str, final String str2, final String[] strArr) {
        strArr[0] = "unknown";
        strArr[1] = getSystemCountryCode(this.mContext);
        RequestManager.getInstance(this.mContext).requestCountryInfo(TAG, null, strArr[1], new ResponseListener<CountryInfoBean>() { // from class: com.stepos.alphame.location.LocationEngine.7
            @Override // com.stepos.alphame.request.ResponseListener
            public void onFailed(int i4, Exception exc) {
                AlphaMeLogger.dLog("init local country info failed, " + exc.toString());
            }

            @Override // com.stepos.alphame.request.ResponseListener
            public void onSuccess(int i4, CountryInfoBean countryInfoBean) {
                strArr[2] = countryInfoBean.getUtc();
                LocationEngine.this.saveCountryInfo(strArr);
                AlphaMeLogger.dLog("init local country info: " + Arrays.toString(strArr));
                LocationEngine.this.broadcastCountryChanged(str, str2, strArr);
            }
        });
    }

    private void registerPowerStateReceivers() {
        this.mScreenEventReceiver = new b("SCREEN_EVENT") { // from class: com.stepos.alphame.location.LocationEngine.3
            @Override // com.stepos.common.alphame.b
            public void onReceiver(String str, Object obj) {
                if (obj == null) {
                    return;
                }
                int iIntValue = ((Integer) obj).intValue();
                if (iIntValue == 0) {
                    LocationEngine.this.stopPassiveLocation();
                } else if (iIntValue == 1) {
                    LocationEngine.this.startPassiveLocationIfNeeded();
                }
            }
        };
        this.mSystemStateReceiver = new b("SYSTEM_STATE_CHANGED") { // from class: com.stepos.alphame.location.LocationEngine.4
            @Override // com.stepos.common.alphame.b
            public void onReceiver(String str, Object obj) {
                if (obj == null) {
                    return;
                }
                if (((Integer) obj).intValue() >= 4) {
                    LocationEngine.this.stopPassiveLocation();
                } else {
                    LocationEngine.this.startPassiveLocationIfNeeded();
                }
            }
        };
        com.stepos.common.alphame.f fVar = c.f11224a;
        fVar.f(this.mScreenEventReceiver);
        fVar.f(this.mSystemStateReceiver);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void saveCountryInfo(String[] strArr) {
        Property.setCountryInfo(strArr[0] + Consts.SPLITTER_DETAIL + strArr[1] + Consts.SPLITTER_DETAIL + strArr[2]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendQueryHomeCompanyResult(FrequentLocation frequentLocation, FrequentLocation frequentLocation2, int i4, String str, String str2) {
        String str3;
        String str4;
        String[] strArr = new String[7];
        strArr[0] = String.valueOf(i4);
        strArr[1] = str;
        strArr[2] = str2;
        if (frequentLocation == null) {
            str3 = null;
        } else {
            str3 = frequentLocation.getLongitude() + "," + frequentLocation.getLatitude();
        }
        strArr[3] = str3;
        strArr[4] = frequentLocation == null ? null : frequentLocation.getAddress();
        if (frequentLocation2 == null) {
            str4 = null;
        } else {
            str4 = frequentLocation2.getLongitude() + "," + frequentLocation2.getLatitude();
        }
        strArr[5] = str4;
        strArr[6] = frequentLocation2 != null ? frequentLocation2.getAddress() : null;
        Log.d(TAG, "queryIsHomeCompanyAsync broadcast ACTION_QUERY_HOME_COMPANY_RESULT, args=" + Arrays.toString(strArr));
        ActionManager.getInstance().broadcast(LocalConsts.ACTION_QUERY_HOME_COMPANY_RESULT, strArr);
    }

    private boolean shouldRunGeocode(Location location) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j4 = this.mLastGeocodeTime;
        if (j4 > 0 && jCurrentTimeMillis - j4 < 300000 && FrequentLocationManager.distanceOfTwoPoints(this.mLastGeocodeLat, this.mLastGeocodeLon, location.getLatitude(), location.getLongitude()) < GEOCODE_MIN_DISTANCE_M) {
            return false;
        }
        this.mLastGeocodeTime = jCurrentTimeMillis;
        this.mLastGeocodeLat = location.getLatitude();
        this.mLastGeocodeLon = location.getLongitude();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startPassiveLocationIfNeeded() {
        if (this.mPassiveLocationRegistered || !canUsePassiveLocation()) {
            return;
        }
        ensureLocationManager();
        if (this.mSysLocationManager == null) {
            return;
        }
        if (this.mGeocoder == null) {
            this.mGeocoder = new Geocoder(this.mContext);
        }
        if (this.mPassiveLocationListener == null) {
            this.mPassiveLocationListener = new LocationListener() { // from class: com.stepos.alphame.location.LocationEngine.1
                @Override // android.location.LocationListener
                public void onLocationChanged(Location location) {
                    LocationEngine.this.handlePassiveLocationChanged(location);
                }

                @Override // android.location.LocationListener
                public void onProviderDisabled(String str) {
                    AlphaMeLogger.dLog("PASSIVE_PROVIDER onProviderDisabled " + str);
                }

                @Override // android.location.LocationListener
                public void onProviderEnabled(String str) {
                    AlphaMeLogger.dLog("PASSIVE_PROVIDER onProviderEnabled " + str);
                }

                @Override // android.location.LocationListener
                public void onStatusChanged(String str, int i4, Bundle bundle) {
                    AlphaMeLogger.dLog("PASSIVE_PROVIDER onStatusChanged " + str + ", status = " + i4);
                }
            };
        }
        this.mSysLocationManager.requestLocationUpdates("passive", UPDATE_MIN_DURATION_LOCATION, 1000.0f, this.mPassiveLocationListener);
        this.mPassiveLocationRegistered = true;
        AlphaMeLogger.dLog("startPassiveLocation registered");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopPassiveLocation() {
        android.location.LocationManager locationManager;
        LocationListener locationListener;
        if (!this.mPassiveLocationRegistered || (locationManager = this.mSysLocationManager) == null || (locationListener = this.mPassiveLocationListener) == null) {
            this.mPassiveLocationRegistered = false;
            return;
        }
        locationManager.removeUpdates(locationListener);
        this.mPassiveLocationRegistered = false;
        AlphaMeLogger.dLog("stopPassiveLocation unregistered");
    }

    private void unregisterPowerStateReceivers() {
        b bVar = this.mScreenEventReceiver;
        if (bVar != null) {
            c.f11224a.g(bVar);
            this.mScreenEventReceiver = null;
        }
        b bVar2 = this.mSystemStateReceiver;
        if (bVar2 != null) {
            c.f11224a.g(bVar2);
            this.mSystemStateReceiver = null;
        }
    }

    public void checkCityChange(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String lastCity = Property.getLastCity();
        if (TextUtils.isEmpty(lastCity)) {
            Property.setLastCity(str);
        } else {
            if (TextUtils.equals(str, lastCity)) {
                return;
            }
            Property.setLastCity(str);
            ActionManager.getInstance().broadcast(LocalConsts.ACTION_CITY_CHANGED, new String[]{lastCity, str});
        }
    }

    public void checkCountryChange(String str, String str2) {
        if (!TextUtils.isEmpty(str) || this.mSettingRegionChanged) {
            String countryInfo = Property.getCountryInfo();
            if (TextUtils.isEmpty(countryInfo)) {
                initLocalCountryInfo(str, str2, new String[3]);
                return;
            }
            String[] strArrSplit = countryInfo.split("\\|");
            if (!TextUtils.equals(strArrSplit[0], str) || this.mSettingRegionChanged) {
                if (TextUtils.equals(strArrSplit[1], getSystemCountryCode(this.mContext))) {
                    broadcastCountryChanged(str, str2, strArrSplit);
                } else {
                    initLocalCountryInfo(str, str2, strArrSplit);
                }
            }
        }
    }

    @NotProguard
    public void chooseCompany(String str, String str2) {
        Property.setChosenCompanyCoord(str);
        Property.setChosenCompanyAddr(str2);
    }

    @NotProguard
    public void chooseHome(String str, String str2) {
        Property.setChosenHomeCoord(str);
        Property.setChosenHomeAddr(str2);
    }

    @NotProguard
    public String getAllWifiInfo() {
        return new n().g(TimetableTracker.getInstance().getWifiEvents());
    }

    @NotProguard
    public String[] getChosenCompany() {
        return new String[]{Property.getChosenCompanyCoord(), Property.getChosenCompanyAddr()};
    }

    @NotProguard
    public String[] getChosenHome() {
        return new String[]{Property.getChosenHomeCoord(), Property.getChosenHomeAddr()};
    }

    public String getCity() {
        MapLocationClient mapLocationClient = this.mlocationClient;
        if (mapLocationClient == null || mapLocationClient.getLastKnownLocation() == null) {
            return null;
        }
        return this.mlocationClient.getLastKnownLocation().getCity();
    }

    @NotProguard
    public List<String> getCityHistory(long j4, long j5) throws Throwable {
        AwarenessStorable awarenessStorable;
        Cursor cursor;
        ArrayList arrayList = new ArrayList();
        if (!PersonalPreferenceConfigs.INSTANCE.getAutoLearningState()) {
            AlphaMeLogger.dLog("getCityHistory failed");
            return arrayList;
        }
        Cursor cursor2 = null;
        String str = null;
        cursor2 = null;
        try {
            try {
                awarenessStorable = (AwarenessStorable) AwarenessDataSource.getInstance().getStorable();
                cursor = AwarenessStorable.getCursor("scene=? and date>? and date<?", new String[]{String.valueOf(2), String.valueOf(j4), String.valueOf(j5)}, "date", null);
            } catch (Exception e4) {
                e = e4;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            if (cursor.getCount() > 0) {
                cursor.moveToFirst();
                AwarenessDataItem awarenessDataItem = new AwarenessDataItem();
                do {
                    awarenessStorable.fillItem(cursor, (DataItem) awarenessDataItem);
                    String data1 = awarenessDataItem.getData1();
                    String data2 = awarenessDataItem.getData2();
                    if (StringUtil.hasSplitter(data2) && FrequentLocationManager.getInstance(this.mContext).isAvailableLocation(data1, data2)) {
                        String[] strArrSplit = data2.split(",");
                        if (strArrSplit.length >= 5) {
                            String str2 = strArrSplit[4];
                            if (!TextUtils.equals(str, str2)) {
                                arrayList.add(str2 + "," + awarenessDataItem.getDate());
                                str = str2;
                            }
                        }
                    }
                } while (cursor.moveToNext());
            }
            cursor.close();
        } catch (Exception e5) {
            e = e5;
            cursor2 = cursor;
            AlphaMeLogger.exceptionLog(LocalConsts.FUNC_GET_CITY_HISTORY, e);
            if (cursor2 != null) {
                cursor2.close();
            }
            return arrayList;
        } catch (Throwable th2) {
            th = th2;
            cursor2 = cursor;
            if (cursor2 != null) {
                cursor2.close();
            }
            throw th;
        }
        return arrayList;
    }

    @NotProguard
    public String getCompanyWifiList() {
        FrequentLocation home = FrequentLocationManager.getInstance(this.mContext).getHome();
        FrequentWifi mostFrequentWifi = home != null ? home.getMostFrequentWifi() : null;
        FrequentLocation company = FrequentLocationManager.getInstance(this.mContext).getCompany();
        if (company == null) {
            return "";
        }
        List<FrequentWifi> frequentWifiList = company.getFrequentWifiList();
        ArrayList arrayList = new ArrayList();
        for (FrequentWifi frequentWifi : frequentWifiList) {
            if (mostFrequentWifi != null && !mostFrequentWifi.getSsid().equals(frequentWifi.getSsid())) {
                arrayList.add(frequentWifi);
            }
        }
        return new n().g(arrayList);
    }

    @NotProguard
    public List<String> getFrequentLocations(float f4) {
        if (PersonalPreferenceConfigs.INSTANCE.getAutoLearningState()) {
            return FrequentLocationManager.getInstance(this.mContext).getAllFrequent(f4);
        }
        AlphaMeLogger.dLog("getFrequentLocations failed");
        return new ArrayList();
    }

    @NotProguard
    public List<String> getHomeAndCompany(float f4) {
        if (PersonalPreferenceConfigs.INSTANCE.getAutoLearningState()) {
            return FrequentLocationManager.getInstance(ApplicationImpl.getApplication()).getHomeAndCompany(f4);
        }
        AlphaMeLogger.dLog("getHomeAndCompany failed");
        return new ArrayList();
    }

    @NotProguard
    public String getHomeWifiList() {
        FrequentLocation company = FrequentLocationManager.getInstance(this.mContext).getCompany();
        FrequentWifi mostFrequentWifi = company != null ? company.getMostFrequentWifi() : null;
        FrequentLocation home = FrequentLocationManager.getInstance(this.mContext).getHome();
        if (home == null) {
            return "";
        }
        List<FrequentWifi> frequentWifiList = home.getFrequentWifiList();
        ArrayList arrayList = new ArrayList();
        for (FrequentWifi frequentWifi : frequentWifiList) {
            if (mostFrequentWifi != null && !mostFrequentWifi.getSsid().equals(frequentWifi.getSsid())) {
                arrayList.add(frequentWifi);
            }
        }
        return new n().g(arrayList);
    }

    @NotProguard
    public String[] getLastLocation() {
        if (!PersonalPreferenceConfigs.INSTANCE.getAutoLearningState()) {
            AlphaMeLogger.dLog("getLastLocation failed");
            return null;
        }
        MapLocation mapLocation = this.mLastLocation;
        if (mapLocation == null) {
            return null;
        }
        return new String[]{mapLocation.getCountry(), this.mLastLocation.getProvince(), this.mLastLocation.getCity(), this.mLastLocation.getAddress(), this.mLastLocation.getLongitude() + "," + this.mLastLocation.getLatitude(), String.valueOf(this.mLastLocationTime), String.valueOf(this.mLastLocation.getAccuracy())};
    }

    @NotProguard
    public String[] getLocationInfoByID(int i4) {
        Log.d(TAG, "getLocationInfos ");
        String[] strArr = new String[6];
        if (!PersonalPreferenceConfigs.INSTANCE.getAutoLearningState()) {
            AlphaMeLogger.dLog("getLocationInfoByID failed");
            return strArr;
        }
        FrequentLocationManager frequentLocationManager = FrequentLocationManager.getInstance(this.mContext);
        FrequentLocation home = i4 == 0 ? frequentLocationManager.getHome() : frequentLocationManager.getCompany();
        if (home != null) {
            strArr[0] = home.getAddress();
            strArr[1] = home.getLongitude() + "," + home.getLatitude();
            strArr[2] = home.getCountry();
            strArr[3] = home.getProvince();
            strArr[4] = home.getCity();
            strArr[5] = home.getDistrict();
        }
        return strArr;
    }

    @NotProguard
    public String[] getLocationInfos(String str) {
        AlphaMeLogger.debugLog(TAG, "getLocationInfos ");
        String[] strArr = new String[5];
        if (!PersonalPreferenceConfigs.INSTANCE.getAutoLearningState()) {
            AlphaMeLogger.dLog("getLocationInfo failed");
            return strArr;
        }
        FrequentLocationManager frequentLocationManager = FrequentLocationManager.getInstance(this.mContext);
        FrequentLocation home = frequentLocationManager.getHome();
        if (home != null) {
            strArr[0] = home.getAddress();
            strArr[1] = home.getLongitude() + "," + home.getLatitude();
        }
        FrequentLocation company = frequentLocationManager.getCompany();
        if (company != null) {
            strArr[2] = company.getAddress();
            strArr[3] = company.getLongitude() + "," + company.getLatitude();
        }
        if (TextUtils.isEmpty(str)) {
            strArr[4] = String.valueOf(-1);
        } else {
            strArr[4] = String.valueOf(frequentLocationManager.getLocationType(str));
        }
        return strArr;
    }

    public LocationRecord getLocationRecord() {
        if (this.mLocationRecord == null) {
            this.mLocationRecord = new LocationRecord();
        }
        return this.mLocationRecord;
    }

    @NotProguard
    public void makeLocation(String str, String str2) {
        ActionManager.getInstance().broadcast(LocalConsts.ACTION_LOCATION_CHANGED, new String[]{String.valueOf(9), str, str2, String.valueOf(FrequentLocationManager.getInstance(this.mContext).getLocationType(str))});
        if (StringUtil.hasSplitter(str2)) {
            String[] strArrSplit = str2.split(",");
            if (strArrSplit.length >= 5) {
                String str3 = strArrSplit[4];
                String str4 = strArrSplit[2];
                checkCityChange(str3);
                checkCountryChange(str4, null);
                MapLocation mapLocation = this.mLastLocation;
                MapLocation mapLocation2 = new MapLocation(mapLocation == null ? "lbs" : mapLocation.getProvider());
                mapLocation2.setAccuracy(Float.parseFloat(strArrSplit[0]));
                mapLocation2.setAddress(strArrSplit[1]);
                mapLocation2.setCountry(strArrSplit[2]);
                mapLocation2.setProvince(strArrSplit[3]);
                mapLocation2.setCity(strArrSplit[4]);
                String[] strArrSplit2 = str.split(",");
                mapLocation2.setLongitude(Double.parseDouble(strArrSplit2[0]));
                mapLocation2.setLatitude(Double.parseDouble(strArrSplit2[1]));
                this.mLastLocation = mapLocation2;
                long jCurrentTimeMillis = System.currentTimeMillis();
                this.mLastLocationTime = jCurrentTimeMillis;
                this.mLastUpdateTime = jCurrentTimeMillis;
                getLocationRecord().onLocationChanged(mapLocation2);
            }
        }
    }

    @Override // com.stepos.alphame.location.MapLocationListener
    public void onLocationChanged(MapLocation mapLocation) {
        if (mapLocation != null) {
            ArrayList arrayList = null;
            if (mapLocation.getErrorCode() != 0 || mapLocation.getLocationType() == 65) {
                AlphaMeLogger.dLog("location Error, ErrCode: " + mapLocation.getErrorCode() + ", errInfo: " + mapLocation.getErrorInfo());
                ActionManager.getInstance().broadcast(LocalConsts.ACTION_LOCATION_CHANGED, new String[]{String.valueOf(this.mLocationFrom), null, mapLocation.getErrorCode() + ", " + mapLocation.getErrorInfo()});
                if (!TextUtils.isEmpty(mapLocation.getCountry())) {
                    checkCountryChange(mapLocation.getCountry(), null);
                }
            } else {
                String str = mapLocation.getLongitude() + "," + mapLocation.getLatitude();
                AlphaMeLogger.dLog("onLocationChanged: " + mapLocation.getAccuracy() + AwarenessDataItem.PERMISSION_SPLITTER + mapLocation.getLocationType());
                ActionManager.getInstance().broadcast(LocalConsts.ACTION_LOCATION_CHANGED, new String[]{String.valueOf(this.mLocationFrom), str, mapLocation.getAccuracy() + "," + mapLocation.getAddress() + "," + mapLocation.getCountry() + "," + mapLocation.getProvince() + "," + mapLocation.getCity() + "," + mapLocation.getDistrict() + "," + mapLocation.getLocationType() + "," + mapLocation.getTrustedLevel(), String.valueOf(FrequentLocationManager.getInstance(this.mContext).getLocationType(str))});
                this.mLastLocationTime = System.currentTimeMillis();
                this.mLastLocation = mapLocation;
                checkPositionChange(mapLocation);
                synchronized (this.mPendingLocationAction) {
                    try {
                        if (this.mPendingLocationAction.size() > 0) {
                            arrayList = new ArrayList(this.mPendingLocationAction);
                            this.mPendingLocationAction.clear();
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                if (arrayList != null) {
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        ((x3.b) it.next()).call(mapLocation);
                    }
                }
            }
            getLocationRecord().onLocationChanged(mapLocation);
        }
        Property.restoreWifiScanAlwaysAvailableState(this.mContext);
    }

    @Override // com.stepos.alphame.engine.EngineBase
    public void onStart() {
        try {
            Log.i(TAG, "locationEngine onStart");
            super.onStart();
            MapLocationClient.initPrivacyAndSdk(ApplicationImpl.getApplication());
            MapLocationClient mapLocationClient = new MapLocationClient(this.mContext);
            this.mlocationClient = mapLocationClient;
            mapLocationClient.setLocationListener(this);
            this.mContentOb = new SettingsValueChangeContentObserver();
            this.mContext.getContentResolver().registerContentObserver(Settings.System.getUriFor(KEY_COUNTRY_SETTING), true, this.mContentOb);
            ensureLocationManager();
            registerPowerStateReceivers();
            startPassiveLocationIfNeeded();
            Log.i(TAG, "locationEngine addFunc");
            EngineBase.addFunc(new LocationInfo(this));
            EngineBase.addFunc(new HomeAndCompany(this));
            EngineBase.addFunc(new StartLocation(this));
            EngineBase.addFunc(new GetLastLocation(this));
            EngineBase.addFunc(new GetLocationByID(this));
            EngineBase.addFunc(new GetCityHistory(this));
            EngineBase.addFunc(new MakeLocation(this));
            EngineBase.addFunc(new GetFrequentLocations(this));
            EngineBase.addFunc(new ChooseHome(this));
            EngineBase.addFunc(new ChooseCompany(this));
            EngineBase.addFunc(new GetChosenHome(this));
            EngineBase.addFunc(new GetChosenCompany(this));
            EngineBase.addFunc(new QueryIsHomeCompanyAsync(this));
            EngineBase.addFunc(new GetHomeWifiList(this));
            EngineBase.addFunc(new GetCompanyWifiList(this));
            EngineBase.addFunc(new GetAllWifiInfo(this));
        } catch (Exception e4) {
            e4.printStackTrace();
            Log.i(TAG, "locationEngine onstart exception");
        }
    }

    @Override // com.stepos.alphame.engine.EngineBase
    public void onStop() {
        unregisterPowerStateReceivers();
        stopPassiveLocation();
        this.mlocationClient.unRegisterLocationListener(this);
        this.mlocationClient.stopLocation();
        this.mContext.getContentResolver().unregisterContentObserver(this.mContentOb);
    }

    @NotProguard
    public void queryIsHomeCompanyAsync(int i4) {
        String[] strArr = this.mDebugQueryHomeCompanyResult;
        if (strArr != null && strArr.length > 0) {
            Log.d(TAG, "queryIsHomeCompanyAsync send debug result. broadcast ACTION_QUERY_HOME_COMPANY_RESULT, args=" + Arrays.toString(strArr));
            ActionManager.getInstance().broadcast(LocalConsts.ACTION_QUERY_HOME_COMPANY_RESULT, strArr);
            return;
        }
        if (!PersonalPreferenceConfigs.INSTANCE.getAutoLearningState()) {
            AlphaMeLogger.dLog("queryIsHomeCompanyAsync failed");
            sendQueryHomeCompanyResult(null, null, -1, null, null);
            return;
        }
        FrequentLocationManager frequentLocationManager = FrequentLocationManager.getInstance(this.mContext);
        final FrequentLocation home = frequentLocationManager.getHome();
        final FrequentLocation company = frequentLocationManager.getCompany();
        Log.d(TAG, "queryIsHomeCompanyAsync(" + i4 + "). home={" + home + "}, \ncompany={" + company + "}");
        if (home == null && company == null) {
            Log.d(TAG, "queryIsHomeCompanyAsync home and company is null!");
            sendQueryHomeCompanyResult(null, null, -1, null, null);
            return;
        }
        MapLocationClient mapLocationClient = this.mlocationClient;
        MapLocation lastKnownLocation = mapLocationClient != null ? mapLocationClient.getLastKnownLocation() : null;
        if (lastKnownLocation == null || Math.abs(lastKnownLocation.getTime() - System.currentTimeMillis()) >= i4) {
            this.mPendingLocationAction.add(new x3.b() { // from class: com.stepos.alphame.location.LocationEngine.6
                @Override // x3.b
                public void call(MapLocation mapLocation) {
                    String str = mapLocation.getLongitude() + "," + mapLocation.getLatitude();
                    int homeCompanyType = LocationEngine.getHomeCompanyType(home, company, mapLocation);
                    g.z("queryIsHomeCompanyAsync from new locate. currentType=", homeCompanyType, LocationEngine.TAG);
                    LocationEngine.this.sendQueryHomeCompanyResult(home, company, homeCompanyType, str, mapLocation.getAddress());
                }
            });
            Log.d(TAG, "queryIsHomeCompanyAsync startLocation");
            startLocation();
            return;
        }
        String str = lastKnownLocation.getLongitude() + "," + lastKnownLocation.getLatitude();
        int homeCompanyType = getHomeCompanyType(home, company, lastKnownLocation);
        Log.d(TAG, "queryIsHomeCompanyAsync from cache. currentType=" + homeCompanyType);
        sendQueryHomeCompanyResult(home, company, homeCompanyType, str, lastKnownLocation.getAddress());
    }

    public void setDebugIsHomeCompany(String[] strArr) {
        this.mDebugQueryHomeCompanyResult = strArr;
    }

    public void setLocDuration(long j4) {
        UPDATE_MIN_DURATION = j4;
    }

    public void startLocation(final int i4) {
        if (!PersonalPreferenceConfigs.INSTANCE.getAutoLearningState()) {
            AlphaMeLogger.dLog("startLocation failed");
            return;
        }
        String networkCountryIso = TelephonyUtils.getNetworkCountryIso(ApplicationImpl.getApplication());
        AlphaMeLogger.debugLog(TAG, "networkCountryIso " + networkCountryIso);
        if (TextUtils.isEmpty(networkCountryIso) || !"cn".equals(networkCountryIso)) {
            AlphaMeLogger.debugLog(TAG, "in foreign");
            return;
        }
        if (this.mlocationClient == null || !Utils.isPermissionAllowed(this.mContext)) {
            AlphaMeLogger.wLog("startLocation mlocationClient failed");
            return;
        }
        ensureLocationManager();
        startPassiveLocationIfNeeded();
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis < this.mLastUpdateTime) {
            this.mLastUpdateTime = 0L;
        }
        long jMax = Math.max(0L, jCurrentTimeMillis - this.mLastUpdateTime);
        if (i4 != 7 || (!WifiEngine.getInstance(this.mContext).isWifiOn() && jMax >= 1800000)) {
            if (jMax < UPDATE_MIN_DURATION) {
                AlphaMeLogger.dLog("startLocation mUpdateWaiting = " + this.mUpdateWaiting);
                if (this.mUpdateWaiting) {
                    return;
                }
                this.mUpdateWaiting = true;
                if (this.mHandler == null) {
                    this.mHandler = new Handler(this.mContext.getMainLooper());
                }
                long j4 = UPDATE_MIN_DURATION - jMax;
                AlphaMeLogger.dLog("startLocation delayed = " + j4);
                this.mHandler.postDelayed(new Runnable() { // from class: com.stepos.alphame.location.LocationEngine.5
                    @Override // java.lang.Runnable
                    public void run() {
                        LocationEngine.this.mUpdateWaiting = false;
                        LocationEngine.this.startLocation(i4);
                    }
                }, j4);
                return;
            }
            AlphaMeLogger.dLog("startLocation " + i4);
            this.mLastUpdateTime = jCurrentTimeMillis;
            this.mLocationFrom = i4;
            Property.saveWifiScanAlwaysAvailableState(this.mContext);
            if (i4 == 2) {
                this.mlocationClient.setHighAccuracyMode();
                this.mlocationClient.setLocationCacheEnable(false);
                this.mlocationClient.setHttpTimeOut(LOCATION_TIME_OUT_BLUETOOTH);
            } else {
                this.mlocationClient.setBatterySavingMode();
                this.mlocationClient.setHttpTimeOut(LOCATION_TIME_OUT_NORMAL);
                this.mlocationClient.setLocationCacheEnable(true);
            }
            this.mlocationClient.startLocation();
        }
    }

    public void uploadLocationRecord() {
        HashMap map = new HashMap();
        map.put(UsageStatsUtils.KEY_LOCATION_NUM, String.valueOf(getLocationRecord().locNum));
        map.put(UsageStatsUtils.KEY_LOCATION_ACC_0_20, String.valueOf(getLocationRecord().locAcc_0));
        map.put(UsageStatsUtils.KEY_LOCATION_ACC_21_50, String.valueOf(getLocationRecord().locAcc_20));
        map.put(UsageStatsUtils.KEY_LOCATION_ACC_51_100, String.valueOf(getLocationRecord().locAcc_50));
        map.put(UsageStatsUtils.KEY_LOCATION_ACC_101_200, String.valueOf(getLocationRecord().locAcc_100));
        map.put(UsageStatsUtils.KEY_LOCATION_ACC_201_500, String.valueOf(getLocationRecord().locAcc_200));
        map.put(UsageStatsUtils.KEY_LOCATION_ACC_501_MORE, String.valueOf(getLocationRecord().locAcc_500));
        map.put(UsageStatsUtils.KEY_LOCATION_FAIL, String.valueOf(getLocationRecord().locAcc_fail));
        map.put(UsageStatsUtils.KEY_LOCATION_INTERVAL_AVG, String.valueOf(getLocationRecord().locInterval_avg));
        map.put(UsageStatsUtils.KEY_LOCATION_INTERVAL_MAX, String.valueOf(getLocationRecord().locInterval_max));
        UsageStatsUtils.onEvent(UsageStatsUtils.EVENT_ONEMIND_LOCATION, null, map);
        this.mLocationRecord = null;
    }

    @NotProguard
    public void startLocation() {
        startLocation(9);
    }
}
