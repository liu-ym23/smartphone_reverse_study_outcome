package com.amap.api.col.jmsl;

import android.content.Context;
import android.os.Bundle;
import android.os.Message;
import com.amap.api.col.jmsl.r5;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.core.LatLonSharePoint;
import com.amap.api.services.core.PoiItem;
import com.amap.api.services.interfaces.IShareSearch;
import com.amap.api.services.share.ShareSearch;

/* loaded from: classes.dex */
public class D implements IShareSearch {

    /* renamed from: c, reason: collision with root package name */
    public static String f15971c;

    /* renamed from: d, reason: collision with root package name */
    public static String f15972d;

    /* renamed from: e, reason: collision with root package name */
    public static String f15973e;

    /* renamed from: f, reason: collision with root package name */
    public static String f15974f;

    /* renamed from: a, reason: collision with root package name */
    public Context f15975a;

    /* renamed from: b, reason: collision with root package name */
    public ShareSearch.OnShareSearchListener f15976b;

    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PoiItem f15977a;

        public a(PoiItem poiItem) {
            this.f15977a = poiItem;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (D.this.f15976b == null) {
                return;
            }
            Message messageObtainMessage = HandlerC1626y0.a().obtainMessage();
            messageObtainMessage.arg1 = 11;
            messageObtainMessage.what = AMapException.CODE_AMAP_ENGINE_RESPONSE_ERROR;
            messageObtainMessage.obj = D.this.f15976b;
            try {
                try {
                    String strSearchPoiShareUrl = D.this.searchPoiShareUrl(this.f15977a);
                    Bundle bundle = new Bundle();
                    bundle.putString("shareurlkey", strSearchPoiShareUrl);
                    messageObtainMessage.setData(bundle);
                    messageObtainMessage.arg2 = 1000;
                } catch (AMapException e10) {
                    messageObtainMessage.arg2 = e10.getErrorCode();
                }
            } finally {
                HandlerC1626y0.a().sendMessage(messageObtainMessage);
            }
        }
    }

    public class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ShareSearch.ShareBusRouteQuery f15979a;

        public b(ShareSearch.ShareBusRouteQuery shareBusRouteQuery) {
            this.f15979a = shareBusRouteQuery;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (D.this.f15976b == null) {
                return;
            }
            Message messageObtainMessage = HandlerC1626y0.a().obtainMessage();
            messageObtainMessage.arg1 = 11;
            messageObtainMessage.what = AMapException.CODE_AMAP_ENGINE_RETURN_TIMEOUT;
            messageObtainMessage.obj = D.this.f15976b;
            try {
                try {
                    String strSearchBusRouteShareUrl = D.this.searchBusRouteShareUrl(this.f15979a);
                    Bundle bundle = new Bundle();
                    bundle.putString("shareurlkey", strSearchBusRouteShareUrl);
                    messageObtainMessage.setData(bundle);
                    messageObtainMessage.arg2 = 1000;
                } catch (AMapException e10) {
                    messageObtainMessage.arg2 = e10.getErrorCode();
                }
            } finally {
                HandlerC1626y0.a().sendMessage(messageObtainMessage);
            }
        }
    }

    public class c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ShareSearch.ShareWalkRouteQuery f15981a;

        public c(ShareSearch.ShareWalkRouteQuery shareWalkRouteQuery) {
            this.f15981a = shareWalkRouteQuery;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (D.this.f15976b == null) {
                return;
            }
            Message messageObtainMessage = HandlerC1626y0.a().obtainMessage();
            messageObtainMessage.arg1 = 11;
            messageObtainMessage.what = 1105;
            messageObtainMessage.obj = D.this.f15976b;
            try {
                try {
                    String strSearchWalkRouteShareUrl = D.this.searchWalkRouteShareUrl(this.f15981a);
                    Bundle bundle = new Bundle();
                    bundle.putString("shareurlkey", strSearchWalkRouteShareUrl);
                    messageObtainMessage.setData(bundle);
                    messageObtainMessage.arg2 = 1000;
                } catch (AMapException e10) {
                    messageObtainMessage.arg2 = e10.getErrorCode();
                }
            } finally {
                HandlerC1626y0.a().sendMessage(messageObtainMessage);
            }
        }
    }

    public class d implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ShareSearch.ShareDrivingRouteQuery f15983a;

        public d(ShareSearch.ShareDrivingRouteQuery shareDrivingRouteQuery) {
            this.f15983a = shareDrivingRouteQuery;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (D.this.f15976b == null) {
                return;
            }
            Message messageObtainMessage = HandlerC1626y0.a().obtainMessage();
            messageObtainMessage.arg1 = 11;
            messageObtainMessage.what = 1104;
            messageObtainMessage.obj = D.this.f15976b;
            try {
                try {
                    String strSearchDrivingRouteShareUrl = D.this.searchDrivingRouteShareUrl(this.f15983a);
                    Bundle bundle = new Bundle();
                    bundle.putString("shareurlkey", strSearchDrivingRouteShareUrl);
                    messageObtainMessage.setData(bundle);
                    messageObtainMessage.arg2 = 1000;
                } catch (AMapException e10) {
                    messageObtainMessage.arg2 = e10.getErrorCode();
                }
            } finally {
                HandlerC1626y0.a().sendMessage(messageObtainMessage);
            }
        }
    }

    public class e implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ShareSearch.ShareNaviQuery f15985a;

        public e(ShareSearch.ShareNaviQuery shareNaviQuery) {
            this.f15985a = shareNaviQuery;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (D.this.f15976b == null) {
                return;
            }
            Message messageObtainMessage = HandlerC1626y0.a().obtainMessage();
            messageObtainMessage.arg1 = 11;
            messageObtainMessage.what = AMapException.CODE_AMAP_ENGINE_CONNECT_TIMEOUT;
            messageObtainMessage.obj = D.this.f15976b;
            try {
                try {
                    String strSearchNaviShareUrl = D.this.searchNaviShareUrl(this.f15985a);
                    Bundle bundle = new Bundle();
                    bundle.putString("shareurlkey", strSearchNaviShareUrl);
                    messageObtainMessage.setData(bundle);
                    messageObtainMessage.arg2 = 1000;
                } catch (AMapException e10) {
                    messageObtainMessage.arg2 = e10.getErrorCode();
                }
            } finally {
                HandlerC1626y0.a().sendMessage(messageObtainMessage);
            }
        }
    }

    public class f implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LatLonSharePoint f15987a;

        public f(LatLonSharePoint latLonSharePoint) {
            this.f15987a = latLonSharePoint;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (D.this.f15976b == null) {
                return;
            }
            Message messageObtainMessage = HandlerC1626y0.a().obtainMessage();
            messageObtainMessage.arg1 = 11;
            messageObtainMessage.what = AMapException.CODE_AMAP_ENGINE_RESPONSE_DATA_ERROR;
            messageObtainMessage.obj = D.this.f15976b;
            try {
                try {
                    String strSearchLocationShareUrl = D.this.searchLocationShareUrl(this.f15987a);
                    Bundle bundle = new Bundle();
                    bundle.putString("shareurlkey", strSearchLocationShareUrl);
                    messageObtainMessage.setData(bundle);
                    messageObtainMessage.arg2 = 1000;
                } catch (AMapException e10) {
                    messageObtainMessage.arg2 = e10.getErrorCode();
                }
            } finally {
                HandlerC1626y0.a().sendMessage(messageObtainMessage);
            }
        }
    }

    public D(Context context) throws AMapException {
        C1537b2 c1537b2A = r5.a(context, T2.a(false));
        if (c1537b2A.f16534a != r5.e.SuccessCode) {
            String str = c1537b2A.f16535b;
            throw new AMapException(str, 1, str, c1537b2A.f16534a.f());
        }
        this.f15975a = context;
        C1631z1.l(context, "ShareSearchCore");
        String str2 = "https://" + C1532a1.c(context).a(63);
        f15971c = str2 + "/?r=%f,%f,%s,%f,%f,%s,%d,%d,%d,%s,%s,%s&sourceapplication=openapi/0";
        f15972d = str2 + "/?q=%f,%f,%s&sourceapplication=openapi/0";
        f15973e = str2 + "/?n=%f,%f,%f,%f,%d&sourceapplication=openapi/0";
        f15974f = str2 + "/?p=%s,%f,%f,%s,%s&sourceapplication=openapi/0";
    }

    @Override // com.amap.api.services.interfaces.IShareSearch
    public String searchBusRouteShareUrl(ShareSearch.ShareBusRouteQuery shareBusRouteQuery) throws AMapException {
        try {
            if (shareBusRouteQuery == null) {
                throw new AMapException("无效的参数 - IllegalArgumentException");
            }
            int busMode = shareBusRouteQuery.getBusMode();
            ShareSearch.ShareFromAndTo shareFromAndTo = shareBusRouteQuery.getShareFromAndTo();
            if (shareFromAndTo.getFrom() == null || shareFromAndTo.getTo() == null) {
                throw new AMapException("无效的参数 - IllegalArgumentException");
            }
            LatLonPoint from = shareFromAndTo.getFrom();
            LatLonPoint to = shareFromAndTo.getTo();
            String fromName = shareFromAndTo.getFromName();
            String toName = shareFromAndTo.getToName();
            return new T(this.f15975a, String.format(f15971c, Double.valueOf(from.getLatitude()), Double.valueOf(from.getLongitude()), fromName, Double.valueOf(to.getLatitude()), Double.valueOf(to.getLongitude()), toName, Integer.valueOf(busMode), 1, 0, "", "", "")).g();
        } catch (AMapException e10) {
            C1631z1.o(e10, "ShareSearch", "searchBusRouteShareUrl");
            throw e10;
        }
    }

    @Override // com.amap.api.services.interfaces.IShareSearch
    public void searchBusRouteShareUrlAsyn(ShareSearch.ShareBusRouteQuery shareBusRouteQuery) {
        try {
            C1535b0.c().b(new b(shareBusRouteQuery));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.services.interfaces.IShareSearch
    public String searchDrivingRouteShareUrl(ShareSearch.ShareDrivingRouteQuery shareDrivingRouteQuery) throws AMapException {
        try {
            if (shareDrivingRouteQuery == null) {
                throw new AMapException("无效的参数 - IllegalArgumentException");
            }
            int drivingMode = shareDrivingRouteQuery.getDrivingMode();
            ShareSearch.ShareFromAndTo shareFromAndTo = shareDrivingRouteQuery.getShareFromAndTo();
            if (shareFromAndTo.getFrom() == null || shareFromAndTo.getTo() == null) {
                throw new AMapException("无效的参数 - IllegalArgumentException");
            }
            LatLonPoint from = shareFromAndTo.getFrom();
            LatLonPoint to = shareFromAndTo.getTo();
            String fromName = shareFromAndTo.getFromName();
            String toName = shareFromAndTo.getToName();
            return new T(this.f15975a, String.format(f15971c, Double.valueOf(from.getLatitude()), Double.valueOf(from.getLongitude()), fromName, Double.valueOf(to.getLatitude()), Double.valueOf(to.getLongitude()), toName, Integer.valueOf(drivingMode), 0, 0, "", "", "")).g();
        } catch (AMapException e10) {
            C1631z1.o(e10, "ShareSearch", "searchDrivingRouteShareUrl");
            throw e10;
        }
    }

    @Override // com.amap.api.services.interfaces.IShareSearch
    public void searchDrivingRouteShareUrlAsyn(ShareSearch.ShareDrivingRouteQuery shareDrivingRouteQuery) {
        try {
            C1535b0.c().b(new d(shareDrivingRouteQuery));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.services.interfaces.IShareSearch
    public String searchLocationShareUrl(LatLonSharePoint latLonSharePoint) throws AMapException {
        try {
            if (latLonSharePoint == null) {
                throw new AMapException("无效的参数 - IllegalArgumentException");
            }
            return new T(this.f15975a, String.format(f15972d, Double.valueOf(latLonSharePoint.getLatitude()), Double.valueOf(latLonSharePoint.getLongitude()), latLonSharePoint.getSharePointName())).g();
        } catch (AMapException e10) {
            C1631z1.o(e10, "ShareSearch", "searchLocationShareUrl");
            throw e10;
        }
    }

    @Override // com.amap.api.services.interfaces.IShareSearch
    public void searchLocationShareUrlAsyn(LatLonSharePoint latLonSharePoint) {
        try {
            C1535b0.c().b(new f(latLonSharePoint));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.services.interfaces.IShareSearch
    public String searchNaviShareUrl(ShareSearch.ShareNaviQuery shareNaviQuery) throws AMapException {
        try {
            if (shareNaviQuery == null) {
                throw new AMapException("无效的参数 - IllegalArgumentException");
            }
            ShareSearch.ShareFromAndTo fromAndTo = shareNaviQuery.getFromAndTo();
            if (fromAndTo.getTo() == null) {
                throw new AMapException("无效的参数 - IllegalArgumentException");
            }
            LatLonPoint from = fromAndTo.getFrom();
            LatLonPoint to = fromAndTo.getTo();
            int naviMode = shareNaviQuery.getNaviMode();
            return new T(this.f15975a, fromAndTo.getFrom() == null ? String.format(f15973e, null, null, Double.valueOf(to.getLatitude()), Double.valueOf(to.getLongitude()), Integer.valueOf(naviMode)) : String.format(f15973e, Double.valueOf(from.getLatitude()), Double.valueOf(from.getLongitude()), Double.valueOf(to.getLatitude()), Double.valueOf(to.getLongitude()), Integer.valueOf(naviMode))).g();
        } catch (AMapException e10) {
            C1631z1.o(e10, "ShareSearch", "searchNaviShareUrl");
            throw e10;
        }
    }

    @Override // com.amap.api.services.interfaces.IShareSearch
    public void searchNaviShareUrlAsyn(ShareSearch.ShareNaviQuery shareNaviQuery) {
        try {
            C1535b0.c().b(new e(shareNaviQuery));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.services.interfaces.IShareSearch
    public String searchPoiShareUrl(PoiItem poiItem) throws AMapException {
        if (poiItem != null) {
            try {
                if (poiItem.getLatLonPoint() != null) {
                    LatLonPoint latLonPoint = poiItem.getLatLonPoint();
                    return new T(this.f15975a, String.format(f15974f, poiItem.getPoiId(), Double.valueOf(latLonPoint.getLatitude()), Double.valueOf(latLonPoint.getLongitude()), poiItem.getTitle(), poiItem.getSnippet())).g();
                }
            } catch (AMapException e10) {
                C1631z1.o(e10, "ShareSearch", "searchPoiShareUrl");
                throw e10;
            }
        }
        throw new AMapException("无效的参数 - IllegalArgumentException");
    }

    @Override // com.amap.api.services.interfaces.IShareSearch
    public void searchPoiShareUrlAsyn(PoiItem poiItem) {
        try {
            C1535b0.c().b(new a(poiItem));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.services.interfaces.IShareSearch
    public String searchWalkRouteShareUrl(ShareSearch.ShareWalkRouteQuery shareWalkRouteQuery) throws AMapException {
        try {
            if (shareWalkRouteQuery == null) {
                throw new AMapException("无效的参数 - IllegalArgumentException");
            }
            int walkMode = shareWalkRouteQuery.getWalkMode();
            ShareSearch.ShareFromAndTo shareFromAndTo = shareWalkRouteQuery.getShareFromAndTo();
            if (shareFromAndTo.getFrom() == null || shareFromAndTo.getTo() == null) {
                throw new AMapException("无效的参数 - IllegalArgumentException");
            }
            LatLonPoint from = shareFromAndTo.getFrom();
            LatLonPoint to = shareFromAndTo.getTo();
            String fromName = shareFromAndTo.getFromName();
            String toName = shareFromAndTo.getToName();
            return new T(this.f15975a, String.format(f15971c, Double.valueOf(from.getLatitude()), Double.valueOf(from.getLongitude()), fromName, Double.valueOf(to.getLatitude()), Double.valueOf(to.getLongitude()), toName, Integer.valueOf(walkMode), 2, 0, "", "", "")).g();
        } catch (AMapException e10) {
            C1631z1.o(e10, "ShareSearch", "searchWalkRouteShareUrl");
            throw e10;
        }
    }

    @Override // com.amap.api.services.interfaces.IShareSearch
    public void searchWalkRouteShareUrlAsyn(ShareSearch.ShareWalkRouteQuery shareWalkRouteQuery) {
        try {
            C1535b0.c().b(new c(shareWalkRouteQuery));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.services.interfaces.IShareSearch
    public void setOnShareSearchListener(ShareSearch.OnShareSearchListener onShareSearchListener) {
        this.f15976b = onShareSearchListener;
    }
}
