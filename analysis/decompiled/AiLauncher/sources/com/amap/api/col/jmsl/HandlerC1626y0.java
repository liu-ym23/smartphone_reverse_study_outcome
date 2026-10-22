package com.amap.api.col.jmsl;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.amap.api.services.auto.AutoTChargeStationResult;
import com.amap.api.services.auto.AutoTSearch;
import com.amap.api.services.busline.BusLineResult;
import com.amap.api.services.busline.BusLineSearch;
import com.amap.api.services.busline.BusStationResult;
import com.amap.api.services.busline.BusStationSearch;
import com.amap.api.services.cloud.CloudItemDetail;
import com.amap.api.services.cloud.CloudResult;
import com.amap.api.services.cloud.CloudSearch;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.PoiItem;
import com.amap.api.services.core.PoiItemV2;
import com.amap.api.services.district.DistrictResult;
import com.amap.api.services.district.DistrictSearch;
import com.amap.api.services.geocoder.GeocodeResult;
import com.amap.api.services.geocoder.GeocodeSearch;
import com.amap.api.services.geocoder.RegeocodeResult;
import com.amap.api.services.help.Inputtips;
import com.amap.api.services.nearby.NearbySearch;
import com.amap.api.services.nearby.NearbySearchResult;
import com.amap.api.services.poisearch.PoiResult;
import com.amap.api.services.poisearch.PoiResultV2;
import com.amap.api.services.poisearch.PoiSearch;
import com.amap.api.services.poisearch.PoiSearchV2;
import com.amap.api.services.poisearch.VisualSearchResult;
import com.amap.api.services.route.BusRouteResult;
import com.amap.api.services.route.BusRouteResultV2;
import com.amap.api.services.route.DistanceResult;
import com.amap.api.services.route.DistanceSearch;
import com.amap.api.services.route.DriveRoutePlanResult;
import com.amap.api.services.route.DriveRouteResult;
import com.amap.api.services.route.DriveRouteResultV2;
import com.amap.api.services.route.RideRouteResult;
import com.amap.api.services.route.RideRouteResultV2;
import com.amap.api.services.route.RouteSearch;
import com.amap.api.services.route.RouteSearchV2;
import com.amap.api.services.route.TruckRouteRestult;
import com.amap.api.services.route.WalkRouteResult;
import com.amap.api.services.route.WalkRouteResultV2;
import com.amap.api.services.routepoisearch.RoutePOISearch;
import com.amap.api.services.routepoisearch.RoutePOISearchResult;
import com.amap.api.services.share.ShareSearch;
import com.amap.api.services.weather.LocalWeatherForecastResult;
import com.amap.api.services.weather.LocalWeatherLiveResult;
import com.amap.api.services.weather.WeatherSearch;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.amap.api.col.jmsl.y0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class HandlerC1626y0 extends Handler {

    /* renamed from: a, reason: collision with root package name */
    public static HandlerC1626y0 f17034a;

    /* renamed from: com.amap.api.col.jmsl.y0$a */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public AutoTChargeStationResult f17035a;

        /* renamed from: b, reason: collision with root package name */
        public AutoTSearch.OnChargeStationListener f17036b;
    }

    /* renamed from: com.amap.api.col.jmsl.y0$b */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public BusLineResult f17037a;

        /* renamed from: b, reason: collision with root package name */
        public BusLineSearch.OnBusLineSearchListener f17038b;
    }

    /* renamed from: com.amap.api.col.jmsl.y0$c */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public BusStationResult f17039a;

        /* renamed from: b, reason: collision with root package name */
        public BusStationSearch.OnBusStationSearchListener f17040b;
    }

    /* renamed from: com.amap.api.col.jmsl.y0$d */
    public static class d {

        /* renamed from: a, reason: collision with root package name */
        public CloudItemDetail f17041a;

        /* renamed from: b, reason: collision with root package name */
        public CloudSearch.OnCloudSearchListener f17042b;
    }

    /* renamed from: com.amap.api.col.jmsl.y0$e */
    public static class e {

        /* renamed from: a, reason: collision with root package name */
        public CloudResult f17043a;

        /* renamed from: b, reason: collision with root package name */
        public CloudSearch.OnCloudSearchListener f17044b;
    }

    /* renamed from: com.amap.api.col.jmsl.y0$f */
    public static class f {

        /* renamed from: a, reason: collision with root package name */
        public GeocodeResult f17045a;

        /* renamed from: b, reason: collision with root package name */
        public GeocodeSearch.OnGeocodeSearchListener f17046b;
    }

    /* renamed from: com.amap.api.col.jmsl.y0$g */
    public static class g {

        /* renamed from: a, reason: collision with root package name */
        public List<NearbySearch.NearbyListener> f17047a;

        /* renamed from: b, reason: collision with root package name */
        public NearbySearchResult f17048b;
    }

    /* renamed from: com.amap.api.col.jmsl.y0$h */
    public static class h {

        /* renamed from: a, reason: collision with root package name */
        public PoiItem f17049a;

        /* renamed from: b, reason: collision with root package name */
        public PoiSearch.OnPoiSearchListener f17050b;
    }

    /* renamed from: com.amap.api.col.jmsl.y0$i */
    public static class i {

        /* renamed from: a, reason: collision with root package name */
        public PoiItemV2 f17051a;

        /* renamed from: b, reason: collision with root package name */
        public PoiSearchV2.OnPoiSearchListener f17052b;
    }

    /* renamed from: com.amap.api.col.jmsl.y0$j */
    public static class j {

        /* renamed from: a, reason: collision with root package name */
        public PoiResult f17053a;

        /* renamed from: b, reason: collision with root package name */
        public PoiSearch.OnPoiSearchListener f17054b;
    }

    /* renamed from: com.amap.api.col.jmsl.y0$k */
    public static class k {

        /* renamed from: a, reason: collision with root package name */
        public PoiResultV2 f17055a;

        /* renamed from: b, reason: collision with root package name */
        public PoiSearchV2.OnPoiSearchListener f17056b;
    }

    /* renamed from: com.amap.api.col.jmsl.y0$l */
    public static class l {

        /* renamed from: a, reason: collision with root package name */
        public RegeocodeResult f17057a;

        /* renamed from: b, reason: collision with root package name */
        public GeocodeSearch.OnGeocodeSearchListener f17058b;
    }

    /* renamed from: com.amap.api.col.jmsl.y0$m */
    public static class m {

        /* renamed from: a, reason: collision with root package name */
        public RoutePOISearchResult f17059a;

        /* renamed from: b, reason: collision with root package name */
        public RoutePOISearch.OnRoutePOISearchListener f17060b;
    }

    /* renamed from: com.amap.api.col.jmsl.y0$n */
    public static class n {

        /* renamed from: a, reason: collision with root package name */
        public VisualSearchResult f17061a;

        /* renamed from: b, reason: collision with root package name */
        public PoiSearchV2.OnPoiSearchListener f17062b;
    }

    /* renamed from: com.amap.api.col.jmsl.y0$o */
    public static class o {

        /* renamed from: a, reason: collision with root package name */
        public LocalWeatherForecastResult f17063a;

        /* renamed from: b, reason: collision with root package name */
        public WeatherSearch.OnWeatherSearchListener f17064b;
    }

    /* renamed from: com.amap.api.col.jmsl.y0$p */
    public static class p {

        /* renamed from: a, reason: collision with root package name */
        public LocalWeatherLiveResult f17065a;

        /* renamed from: b, reason: collision with root package name */
        public WeatherSearch.OnWeatherSearchListener f17066b;
    }

    public HandlerC1626y0() {
    }

    public static synchronized HandlerC1626y0 a() {
        try {
            if (f17034a == null) {
                if (Looper.myLooper() == null || Looper.myLooper() != Looper.getMainLooper()) {
                    f17034a = new HandlerC1626y0(Looper.getMainLooper());
                } else {
                    f17034a = new HandlerC1626y0();
                }
            }
        } catch (Throwable th) {
            throw th;
        }
        return f17034a;
    }

    public final void b(Message message) {
        h hVar;
        PoiSearch.OnPoiSearchListener onPoiSearchListener;
        Bundle data;
        int i10 = message.what;
        if (i10 == 600) {
            j jVar = (j) message.obj;
            if (jVar == null || (onPoiSearchListener = jVar.f17054b) == null || (data = message.getData()) == null) {
                return;
            }
            onPoiSearchListener.onPoiSearched(jVar.f17053a, data.getInt("errorCode"));
            return;
        }
        if (i10 != 602 || (hVar = (h) message.obj) == null) {
            return;
        }
        PoiSearch.OnPoiSearchListener onPoiSearchListener2 = hVar.f17050b;
        Bundle data2 = message.getData();
        if (data2 != null) {
            onPoiSearchListener2.onPoiItemSearched(hVar.f17049a, data2.getInt("errorCode"));
        }
    }

    public final void c(Message message) {
        n nVar;
        PoiSearchV2.OnPoiSearchListener onPoiSearchListener;
        Bundle data;
        PoiSearchV2.OnPoiSearchListener onPoiSearchListener2;
        Bundle data2;
        int i10 = message.what;
        if (i10 == 603) {
            k kVar = (k) message.obj;
            if (kVar == null || (onPoiSearchListener2 = kVar.f17056b) == null || (data2 = message.getData()) == null) {
                return;
            }
            onPoiSearchListener2.onPoiSearched(kVar.f17055a, data2.getInt("errorCode"));
            return;
        }
        if (i10 != 604) {
            if (i10 != 605 || (nVar = (n) message.obj) == null || (onPoiSearchListener = nVar.f17062b) == null || (data = message.getData()) == null) {
                return;
            }
            onPoiSearchListener.onVisualSearched(nVar.f17061a, data.getInt("errorCode"));
            return;
        }
        i iVar = (i) message.obj;
        if (iVar == null) {
            return;
        }
        PoiSearchV2.OnPoiSearchListener onPoiSearchListener3 = iVar.f17052b;
        Bundle data3 = message.getData();
        if (data3 != null) {
            onPoiSearchListener3.onPoiItemSearched(iVar.f17051a, data3.getInt("errorCode"));
        }
    }

    public final void d(Message message) {
        Bundle data;
        RouteSearch.OnRouteSearchListener onRouteSearchListener = (RouteSearch.OnRouteSearchListener) message.obj;
        if (onRouteSearchListener == null) {
            return;
        }
        int i10 = message.what;
        if (i10 == 100) {
            Bundle data2 = message.getData();
            if (data2 != null) {
                onRouteSearchListener.onBusRouteSearched((BusRouteResult) message.getData().getParcelable("result"), data2.getInt("errorCode"));
                return;
            }
            return;
        }
        if (i10 == 101) {
            Bundle data3 = message.getData();
            if (data3 != null) {
                onRouteSearchListener.onDriveRouteSearched((DriveRouteResult) message.getData().getParcelable("result"), data3.getInt("errorCode"));
                return;
            }
            return;
        }
        if (i10 == 102) {
            Bundle data4 = message.getData();
            if (data4 != null) {
                onRouteSearchListener.onWalkRouteSearched((WalkRouteResult) message.getData().getParcelable("result"), data4.getInt("errorCode"));
                return;
            }
            return;
        }
        if (i10 == 103) {
            Bundle data5 = message.getData();
            if (data5 != null) {
                onRouteSearchListener.onRideRouteSearched((RideRouteResult) message.getData().getParcelable("result"), data5.getInt("errorCode"));
                return;
            }
            return;
        }
        if (i10 != 104 || (data = message.getData()) == null) {
            return;
        }
        onRouteSearchListener.onRideRouteSearched((RideRouteResult) message.getData().getParcelable("result"), data.getInt("errorCode"));
    }

    public final void e(Message message) {
        Bundle data;
        RouteSearchV2.OnRouteSearchListener onRouteSearchListener = (RouteSearchV2.OnRouteSearchListener) message.obj;
        if (onRouteSearchListener == null) {
            return;
        }
        int i10 = message.what;
        if (i10 == 101) {
            Bundle data2 = message.getData();
            if (data2 != null) {
                onRouteSearchListener.onDriveRouteSearched((DriveRouteResultV2) message.getData().getParcelable("result"), data2.getInt("errorCode"));
                return;
            }
            return;
        }
        if (i10 == 100) {
            Bundle data3 = message.getData();
            if (data3 != null) {
                onRouteSearchListener.onBusRouteSearched((BusRouteResultV2) message.getData().getParcelable("result"), data3.getInt("errorCode"));
                return;
            }
            return;
        }
        if (i10 == 102) {
            Bundle data4 = message.getData();
            if (data4 != null) {
                onRouteSearchListener.onWalkRouteSearched((WalkRouteResultV2) message.getData().getParcelable("result"), data4.getInt("errorCode"));
                return;
            }
            return;
        }
        if (i10 != 103 || (data = message.getData()) == null) {
            return;
        }
        onRouteSearchListener.onRideRouteSearched((RideRouteResultV2) message.getData().getParcelable("result"), data.getInt("errorCode"));
    }

    public final void f(Message message) {
        o oVar;
        WeatherSearch.OnWeatherSearchListener onWeatherSearchListener;
        Bundle data;
        WeatherSearch.OnWeatherSearchListener onWeatherSearchListener2;
        Bundle data2;
        int i10 = message.what;
        if (i10 == 1301) {
            p pVar = (p) message.obj;
            if (pVar == null || (onWeatherSearchListener2 = pVar.f17066b) == null || (data2 = message.getData()) == null) {
                return;
            }
            onWeatherSearchListener2.onWeatherLiveSearched(pVar.f17065a, data2.getInt("errorCode"));
            return;
        }
        if (i10 != 1302 || (oVar = (o) message.obj) == null || (onWeatherSearchListener = oVar.f17064b) == null || (data = message.getData()) == null) {
            return;
        }
        onWeatherSearchListener.onWeatherForecastSearched(oVar.f17063a, data.getInt("errorCode"));
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        f fVar;
        GeocodeSearch.OnGeocodeSearchListener onGeocodeSearchListener;
        GeocodeSearch.OnGeocodeSearchListener onGeocodeSearchListener2;
        BusLineSearch.OnBusLineSearchListener onBusLineSearchListener;
        BusStationSearch.OnBusStationSearchListener onBusStationSearchListener;
        List<NearbySearch.NearbyListener> list;
        d dVar;
        RoutePOISearch.OnRoutePOISearchListener onRoutePOISearchListener;
        Bundle data;
        Bundle data2;
        Bundle data3;
        Bundle data4;
        a aVar;
        try {
            int i10 = message.arg1;
            if (i10 == 101) {
                e(message);
                return;
            }
            switch (i10) {
                case 1:
                    d(message);
                    break;
                case 2:
                    int i11 = message.what;
                    if (i11 != 201) {
                        if (i11 == 200 && (fVar = (f) message.obj) != null && (onGeocodeSearchListener = fVar.f17046b) != null) {
                            onGeocodeSearchListener.onGeocodeSearched(fVar.f17045a, message.arg2);
                            break;
                        }
                    } else {
                        l lVar = (l) message.obj;
                        if (lVar != null && (onGeocodeSearchListener2 = lVar.f17058b) != null) {
                            onGeocodeSearchListener2.onRegeocodeSearched(lVar.f17057a, message.arg2);
                            break;
                        }
                    }
                    break;
                case 3:
                    b bVar = (b) message.obj;
                    if (bVar != null && (onBusLineSearchListener = bVar.f17038b) != null) {
                        int i12 = message.what;
                        onBusLineSearchListener.onBusLineSearched(i12 == 1000 ? bVar.f17037a : null, i12);
                        break;
                    }
                    break;
                case 4:
                    DistrictSearch.OnDistrictSearchListener onDistrictSearchListener = (DistrictSearch.OnDistrictSearchListener) message.obj;
                    if (onDistrictSearchListener != null) {
                        onDistrictSearchListener.onDistrictSearched((DistrictResult) message.getData().getParcelable("result"));
                        break;
                    } else {
                        break;
                    }
                case 5:
                    Inputtips.InputtipsListener inputtipsListener = (Inputtips.InputtipsListener) message.obj;
                    if (inputtipsListener != null) {
                        inputtipsListener.onGetInputtips(message.what == 1000 ? message.getData().getParcelableArrayList("result") : null, message.what);
                        break;
                    } else {
                        break;
                    }
                case 6:
                    b(message);
                    break;
                case 7:
                    c cVar = (c) message.obj;
                    if (cVar != null && (onBusStationSearchListener = cVar.f17040b) != null) {
                        int i13 = message.what;
                        onBusStationSearchListener.onBusStationSearched(i13 == 1000 ? cVar.f17039a : null, i13);
                        break;
                    }
                    break;
                case 8:
                    List list2 = (List) message.obj;
                    if (list2 != null && list2.size() != 0) {
                        Iterator it = list2.iterator();
                        while (it.hasNext()) {
                            ((NearbySearch.NearbyListener) it.next()).onUserInfoCleared(message.what);
                        }
                        break;
                    }
                    break;
                case 9:
                    g gVar = (g) message.obj;
                    if (gVar != null && (list = gVar.f17047a) != null && list.size() != 0) {
                        NearbySearchResult nearbySearchResult = message.what == 1000 ? gVar.f17048b : null;
                        Iterator<NearbySearch.NearbyListener> it2 = list.iterator();
                        while (it2.hasNext()) {
                            it2.next().onNearbyInfoSearched(nearbySearchResult, message.what);
                        }
                        break;
                    }
                    break;
                case 10:
                    List list3 = (List) message.obj;
                    if (list3 != null && list3.size() != 0) {
                        Iterator it3 = list3.iterator();
                        while (it3.hasNext()) {
                            ((NearbySearch.NearbyListener) it3.next()).onNearbyInfoUploaded(message.what);
                        }
                        break;
                    }
                    break;
                case 11:
                    int i14 = message.arg2;
                    ShareSearch.OnShareSearchListener onShareSearchListener = (ShareSearch.OnShareSearchListener) message.obj;
                    String string = message.getData().getString("shareurlkey");
                    if (onShareSearchListener != null) {
                        switch (message.what) {
                            case AMapException.CODE_AMAP_ENGINE_RESPONSE_ERROR /* 1100 */:
                                onShareSearchListener.onPoiShareUrlSearched(string, i14);
                                break;
                            case AMapException.CODE_AMAP_ENGINE_RESPONSE_DATA_ERROR /* 1101 */:
                                onShareSearchListener.onLocationShareUrlSearched(string, i14);
                                break;
                            case AMapException.CODE_AMAP_ENGINE_CONNECT_TIMEOUT /* 1102 */:
                                onShareSearchListener.onNaviShareUrlSearched(string, i14);
                                break;
                            case AMapException.CODE_AMAP_ENGINE_RETURN_TIMEOUT /* 1103 */:
                                onShareSearchListener.onBusRouteShareUrlSearched(string, i14);
                                break;
                            case 1104:
                                onShareSearchListener.onDrivingRouteShareUrlSearched(string, i14);
                                break;
                            case 1105:
                                onShareSearchListener.onWalkRouteShareUrlSearched(string, i14);
                                break;
                        }
                    } else {
                        break;
                    }
                case 12:
                    int i15 = message.what;
                    if (i15 != 700) {
                        if (i15 == 701 && (dVar = (d) message.obj) != null) {
                            dVar.f17042b.onCloudItemDetailSearched(dVar.f17041a, message.arg2);
                            break;
                        }
                    } else {
                        e eVar = (e) message.obj;
                        if (eVar != null) {
                            eVar.f17044b.onCloudSearched(eVar.f17043a, message.arg2);
                            break;
                        } else {
                            break;
                        }
                    }
                    break;
                case 13:
                    f(message);
                    break;
                case 14:
                    m mVar = (m) message.obj;
                    if (mVar != null && (onRoutePOISearchListener = mVar.f17060b) != null && (data = message.getData()) != null) {
                        onRoutePOISearchListener.onRoutePoiSearched(mVar.f17059a, data.getInt("errorCode"));
                        break;
                    }
                    break;
                default:
                    switch (i10) {
                        case 16:
                            DistanceSearch.OnDistanceSearchListener onDistanceSearchListener = (DistanceSearch.OnDistanceSearchListener) message.obj;
                            if (onDistanceSearchListener != null && message.what == 400 && (data2 = message.getData()) != null) {
                                onDistanceSearchListener.onDistanceSearched((DistanceResult) message.getData().getParcelable("result"), data2.getInt("errorCode"));
                                break;
                            }
                            break;
                        case 17:
                            RouteSearch.OnTruckRouteSearchListener onTruckRouteSearchListener = (RouteSearch.OnTruckRouteSearchListener) message.obj;
                            if (onTruckRouteSearchListener != null && message.what == 104 && (data3 = message.getData()) != null) {
                                onTruckRouteSearchListener.onTruckRouteSearched((TruckRouteRestult) message.getData().getParcelable("result"), data3.getInt("errorCode"));
                                break;
                            }
                            break;
                        case 18:
                            RouteSearch.OnRoutePlanSearchListener onRoutePlanSearchListener = (RouteSearch.OnRoutePlanSearchListener) message.obj;
                            if (onRoutePlanSearchListener != null && message.what == 105 && (data4 = message.getData()) != null) {
                                onRoutePlanSearchListener.onDriveRoutePlanSearched((DriveRoutePlanResult) message.getData().getParcelable("result"), data4.getInt("errorCode"));
                                break;
                            }
                            break;
                        case 19:
                            c(message);
                            break;
                        case 20:
                            if (message.what == 600 && (aVar = (a) message.obj) != null) {
                                AutoTSearch.OnChargeStationListener onChargeStationListener = aVar.f17036b;
                                Bundle data5 = message.getData();
                                if (data5 != null) {
                                    int i16 = data5.getInt("errorCode");
                                    if (onChargeStationListener != null) {
                                        onChargeStationListener.onChargeStationSearched(aVar.f17035a, i16);
                                        break;
                                    }
                                }
                            }
                            break;
                    }
            }
        } catch (Throwable th) {
            C1631z1.o(th, "MessageHandler", "handleMessage");
        }
    }

    public HandlerC1626y0(Looper looper) {
        super(looper);
    }
}
