package com.byted.mgl.merge.service.model;

import android.location.Location;
import android.os.Build;
import androidx.camera.video.AudioStats;
import androidx.core.location.LocationCompat;
import com.amap.api.services.district.DistrictSearchQuery;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.bdp.bdpbase.manager.BdpManager;
import com.bytedance.bdp.serviceapi.defaults.log.BdpLogService;
import com.huawei.hms.support.feature.result.CommonConstant;
import com.ss.android.ugc.aweme.shortvideo.ShortVideoSegments;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
public class BdpLocation extends Location implements Cloneable {
    public static final int STATUS_ERROR_TYPE_NETWORK_ERROR = 3;
    public static final int STATUS_ERROR_TYPE_OTHERS = 1;
    public static final int STATUS_ERROR_TYPE_PERMISSION_ERROR = 4;
    public static final int STATUS_ERROR_TYPE_TIME_OUT = 2;
    public static final int STATUS_NO_ENOUGH_LOCATE_SIGNAL = 5;
    public static final int STATUS_SUCCESS = 0;
    private final String TAG;
    private String address;
    private String city;
    private String cityCode;
    private String country;
    private String countryCode;
    private String district;
    private String districtCode;
    private String errorMsg;
    private int mLocType;
    private int mRawImplStatusCode;
    private int mStatusCode;
    private String name;
    private String province;
    private String provinceCode;

    public JSONObject toJson() {
        JSONObject r100 = new JSONObject();
        r100.putOpt(ShortVideoSegments.KEY_PROP_PROVIDER, getProvider());     // Catch: JSONException -> L9
        r100.putOpt("latitude", Double.valueOf(getLatitude()));     // Catch: JSONException -> L9
        r100.putOpt("longitude", Double.valueOf(getLongitude()));     // Catch: JSONException -> L9
        r100.putOpt("loc_time", Long.valueOf(getTime()));     // Catch: JSONException -> L9
        r100.putOpt("speed", Float.valueOf(getSpeed()));     // Catch: JSONException -> L9
        r100.putOpt(LocationMonitorConst.ACCURACY, Float.valueOf(getAccuracy()));     // Catch: JSONException -> L9
        r100.putOpt("altitude", Double.valueOf(getAltitude()));     // Catch: JSONException -> L9
        r100.putOpt("statusCode", Integer.valueOf(getStatusCode()));     // Catch: JSONException -> L9
        r100.putOpt("rawImplStatusCode", Integer.valueOf(getRawImplStatusCode()));     // Catch: JSONException -> L9
        r100.putOpt("name", getName());     // Catch: JSONException -> L9
        r100.putOpt("address", getAddress());     // Catch: JSONException -> L9
        r100.putOpt(DistrictSearchQuery.KEYWORDS_COUNTRY, getCountry());     // Catch: JSONException -> L9
        r100.putOpt("province", getProvince());     // Catch: JSONException -> L9
        r100.putOpt("city", getCity());     // Catch: JSONException -> L9
        r100.putOpt(DistrictSearchQuery.KEYWORDS_DISTRICT, getDistrict());     // Catch: JSONException -> L9
        r100.putOpt("loctype", Integer.valueOf(getLocType()));     // Catch: JSONException -> L9
        r100.putOpt(CommonConstant.KEY_COUNTRY_CODE, getCountryCode());     // Catch: JSONException -> L9
        r100.putOpt("provinceCode", getProvinceCode());     // Catch: JSONException -> L9
        r100.putOpt("cityCode", getCityCode());     // Catch: JSONException -> L9
        r100.putOpt("districtCode", getDistrictCode());     // Catch: JSONException -> L9
        r100.putOpt("errorMsg", getErrorMsg());     // Catch: JSONException -> L9
        if (Build.VERSION.SDK_INT < 26) goto L6;
        float r101 = getVerticalAccuracyMeters();     // Catch: JSONException -> L9
    L7:
        r100.put(LocationCompat.EXTRA_VERTICAL_ACCURACY, r101);     // Catch: JSONException -> L9
    L11:
        return r100;
    L6:
        r101 = 0.0f;
    L9:
        e = move-exception;
        ((BdpLogService) BdpManager.getInst().getService(BdpLogService.class)).e("bdp_BdpLocation", e.getMessage());
        goto L11
    }

    @Override // android.location.Location
    public String toString() {
        return "TMALocation{mStatusCode=" + this.mStatusCode + ", mRawImplStatusCode=" + this.mRawImplStatusCode + ", name='" + this.name + "', address='" + this.address + "', country='" + this.country + "', countryCode='" + this.countryCode + "', province='" + this.province + "', provinceCode='" + this.provinceCode + "', city='" + this.city + "', cityCode='" + this.cityCode + "', district='" + this.district + "', districtCode='" + this.districtCode + "', mLocType=" + this.mLocType + '}';
    }

    public Object clone() {
        return (BdpLocation) super.clone();
    L4:
        return null;
    }

    public float getHorizontalAccuracy() {
        return getAccuracy();
    }

    public String getAddress() {
        return this.address;
    }

    public String getCity() {
        return this.city;
    }

    public String getCityCode() {
        return this.cityCode;
    }

    public String getCountry() {
        return this.country;
    }

    public String getCountryCode() {
        return this.countryCode;
    }

    public String getDistrict() {
        return this.district;
    }

    public String getDistrictCode() {
        return this.districtCode;
    }

    public String getErrorMsg() {
        return this.errorMsg;
    }

    public int getLocType() {
        return this.mLocType;
    }

    public String getName() {
        return this.name;
    }

    public String getProvince() {
        return this.province;
    }

    public String getProvinceCode() {
        return this.provinceCode;
    }

    public int getRawImplStatusCode() {
        return this.mRawImplStatusCode;
    }

    public int getStatusCode() {
        return this.mStatusCode;
    }

    public BdpLocation(BdpLocation r100) {
        super(r100);
        this.TAG = "bdp_BdpLocation";
        this.mStatusCode = 0;
        this.mRawImplStatusCode = 0;
        setStatusCode(r100.getStatusCode());
        setName(r100.getName());
        setAddress(r100.getAddress());
        setCountry(r100.getCountry());
        setProvider(r100.getProvince());
        setCity(r100.getCity());
        setDistrict(r100.getDistrict());
        setLocType(r100.getLocType());
        setCityCode(r100.getCountryCode());
        setProvinceCode(r100.getProvinceCode());
        setCityCode(r100.getCityCode());
        setDistrictCode(r100.getDistrictCode());
        setErrorMsg(r100.getErrorMsg());
    }

    public static BdpLocation fromJson(JSONObject r100) throws JSONException {
        if (r100 != null) goto L5;
        return null;
    L5:
        BdpLocation r101 = new BdpLocation(r100.optString(ShortVideoSegments.KEY_PROP_PROVIDER));
        r101.setLatitude(r100.optDouble("latitude"));
        r101.setLongitude(r100.optDouble("longitude"));
        r101.setTime(r100.optLong("loc_time"));
        r101.setSpeed((float) r100.optDouble("speed", AudioStats.AUDIO_AMPLITUDE_NONE));
        r101.setAccuracy((float) r100.optDouble(LocationMonitorConst.ACCURACY));
        r101.setAltitude(r100.optDouble("altitude"));
        r101.setStatusCode(r100.optInt("statusCode"));
        r101.setRawImplStatusCode(r100.optInt("rawImplStatusCode"));
        r101.setName(r100.optString("name"));
        r101.setAddress(r100.optString("address"));
        r101.setCountry(r100.optString(DistrictSearchQuery.KEYWORDS_COUNTRY));
        r101.setProvince(r100.optString("province"));
        r101.setCity(r100.optString("city"));
        r101.setDistrict(r100.optString(DistrictSearchQuery.KEYWORDS_DISTRICT));
        r101.setLocType(r100.optInt("loctype"));
        r101.setCityCode(r100.optString(CommonConstant.KEY_COUNTRY_CODE));
        r101.setProvinceCode(r100.optString("provinceCode"));
        r101.setCityCode(r100.optString("cityCode"));
        r101.setDistrictCode(r100.optString("districtCode"));
        r101.setErrorMsg(r100.optString("errorMsg"));
        if (Build.VERSION.SDK_INT < 26) goto L8;
        r101.setVerticalAccuracyMeters(0.0f);
    L8:
        return r101;
    }

    public static boolean isSuccess(BdpLocation r100) {
        if (r100 != null) goto L4;
    L6:
        return false;
    L4:
        if (r100.getStatusCode() != 0) goto L6;
        return true;
    }

    public void setAddress(String r100) {
        this.address = r100;
    }

    public void setCity(String r100) {
        this.city = r100;
    }

    public void setCityCode(String r100) {
        this.cityCode = r100;
    }

    public void setCountry(String r100) {
        this.country = r100;
    }

    public void setCountryCode(String r100) {
        this.countryCode = r100;
    }

    public void setDistrict(String r100) {
        this.district = r100;
    }

    public void setDistrictCode(String r100) {
        this.districtCode = r100;
    }

    public void setErrorMsg(String r100) {
        this.errorMsg = r100;
    }

    public void setLocType(int r100) {
        this.mLocType = r100;
    }

    public void setName(String r100) {
        this.name = r100;
    }

    public void setProvince(String r100) {
        this.province = r100;
    }

    public void setProvinceCode(String r100) {
        this.provinceCode = r100;
    }

    public void setRawImplStatusCode(int r100) {
        this.mRawImplStatusCode = r100;
    }

    public void setStatusCode(int r100) {
        this.mStatusCode = r100;
    }

    public BdpLocation(int r100) {
        super("");
        this.TAG = "bdp_BdpLocation";
        this.mRawImplStatusCode = 0;
        this.mStatusCode = r100;
    }

    public BdpLocation(Location r100) {
        super(r100);
        this.TAG = "bdp_BdpLocation";
        this.mStatusCode = 0;
        this.mRawImplStatusCode = 0;
    }

    public BdpLocation(String r100) {
        super(r100);
        this.TAG = "bdp_BdpLocation";
        this.mStatusCode = 0;
        this.mRawImplStatusCode = 0;
    }
}
