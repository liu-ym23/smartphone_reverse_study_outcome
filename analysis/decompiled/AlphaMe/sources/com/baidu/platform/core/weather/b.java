package com.baidu.platform.core.weather;

import android.text.TextUtils;
import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.base.LanguageType;
import com.baidu.mapapi.search.weather.WeatherDataType;
import com.baidu.mapapi.search.weather.WeatherSearchOption;
import com.baidu.mapapi.search.weather.WeatherServerType;
import com.baidu.mapsdkplatform.comapi.util.CoordTrans;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.baidu.platform.comapi.map.MapController;

/* loaded from: classes.dex */
public class b extends com.baidu.platform.base.c {

    /* renamed from: e, reason: collision with root package name */
    WeatherSearchOption f9397e;

    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f9398a;

        /* renamed from: b, reason: collision with root package name */
        static final /* synthetic */ int[] f9399b;

        /* renamed from: c, reason: collision with root package name */
        static final /* synthetic */ int[] f9400c;

        static {
            int[] iArr = new int[LanguageType.values().length];
            f9400c = iArr;
            try {
                iArr[LanguageType.LanguageTypeEnglish.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f9400c[LanguageType.LanguageTypeChinese.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            int[] iArr2 = new int[CoordType.values().length];
            f9399b = iArr2;
            try {
                iArr2[CoordType.BD09LL.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f9399b[CoordType.GCJ02.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr3 = new int[WeatherDataType.values().length];
            f9398a = iArr3;
            try {
                iArr3[WeatherDataType.WEATHER_DATA_TYPE_REAL_TIME.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f9398a[WeatherDataType.WEATHER_DATA_TYPE_FORECASTS_FOR_DAY.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f9398a[WeatherDataType.WEATHER_DATA_TYPE_FORECASTS_FOR_HOUR.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f9398a[WeatherDataType.WEATHER_DATA_TYPE_LIFE_INDEX.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f9398a[WeatherDataType.WEATHER_DATA_TYPE_ALERT.ordinal()] = 5;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f9398a[WeatherDataType.WEATHER_DATA_TYPE_ALL.ordinal()] = 6;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    public b(WeatherSearchOption weatherSearchOption) {
        this.f9397e = weatherSearchOption;
        a(weatherSearchOption);
    }

    private void a(WeatherSearchOption weatherSearchOption) {
        if (!TextUtils.isEmpty(weatherSearchOption.getDistrictID())) {
            this.f8580d.a("district_id", weatherSearchOption.getDistrictID());
        }
        if (weatherSearchOption.getLocation() != null) {
            LatLng latLng = new LatLng(weatherSearchOption.getLocation().latitude, weatherSearchOption.getLocation().longitude);
            if (SDKInitializer.getCoordType() == CoordType.GCJ02) {
                latLng = CoordTrans.gcjToBaidu(latLng);
            }
            this.f8580d.a(MapController.LOCATION_LAYER_TAG, latLng.longitude + "," + latLng.latitude);
            this.f8580d.a("coordtype", a(CoordType.BD09LL));
        }
        if (weatherSearchOption.getDataType() != null) {
            this.f8580d.a("data_type", a(weatherSearchOption.getDataType()));
        }
        if (weatherSearchOption.getLanguageType() != null) {
            this.f8580d.a("language", a(weatherSearchOption.getLanguageType()));
        }
    }

    @Override // com.baidu.platform.base.c
    public String a(com.baidu.platform.domain.b bVar) {
        WeatherSearchOption weatherSearchOption = this.f9397e;
        if (weatherSearchOption == null) {
            return "";
        }
        if (weatherSearchOption.getServerType() == WeatherServerType.LANGUAGE_SERVER_TYPE_ABROAD) {
            return bVar.g();
        }
        return bVar.k();
    }

    private String a(WeatherDataType weatherDataType) {
        switch (a.f9398a[weatherDataType.ordinal()]) {
            case 1:
                return "now";
            case 2:
                return "fc";
            case 3:
                return "fc_hour";
            case 4:
                return MapBundleKey.MapObjKey.OBJ_SL_INDEX;
            case 5:
                return "alert";
            case 6:
                return "all";
            default:
                return "";
        }
    }

    private String a(CoordType coordType) {
        int i4 = a.f9399b[coordType.ordinal()];
        return i4 != 1 ? i4 != 2 ? "" : "gcj02" : "bd09ll";
    }

    private String a(LanguageType languageType) {
        int i4 = a.f9400c[languageType.ordinal()];
        return i4 != 1 ? i4 != 2 ? "" : "cn" : "en";
    }
}
