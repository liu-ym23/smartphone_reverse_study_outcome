package com.amap.api.col.s;

import android.content.Context;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.core.LatLonSharePoint;
import com.amap.api.services.core.PoiItem;
import com.amap.api.services.interfaces.IShareSearch;
import com.amap.api.services.share.ShareSearch;

/* JADX INFO: loaded from: classes28.dex */
public final class bf implements IShareSearch {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static String f26160b = "http://wb.amap.com/?r=%f,%f,%s,%f,%f,%s,%d,%d,%d,%s,%s,%s&sourceapplication=openapi/0";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static String f26161c = "http://wb.amap.com/?q=%f,%f,%s&sourceapplication=openapi/0";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static String f26162d = "http://wb.amap.com/?n=%f,%f,%f,%f,%d&sourceapplication=openapi/0";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static String f26163e = "http://wb.amap.com/?p=%s,%f,%f,%s,%s&sourceapplication=openapi/0";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String f26164f = "";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f26165a;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private ShareSearch.OnShareSearchListener f26166g;

    public bf(Context r100) {
        this.f26165a = r100;
    }

    public static /* synthetic */ ShareSearch.OnShareSearchListener a(bf r100) {
        return r100.f26166g;
    }

    @Override // com.amap.api.services.interfaces.IShareSearch
    public final String searchBusRouteShareUrl(ShareSearch.ShareBusRouteQuery r110) throws AMapException {
        if (r110 == null) goto L15;
        int r100 = r110.getBusMode();     // Catch: AMapException -> L12
        ShareSearch.ShareFromAndTo r111 = r110.getShareFromAndTo();     // Catch: AMapException -> L12
        if (r111.getFrom() == null) goto L11;
        if (r111.getTo() == null) goto L11;
        LatLonPoint r101 = r111.getFrom();     // Catch: AMapException -> L12
        LatLonPoint r102 = r111.getTo();     // Catch: AMapException -> L12
        String r103 = r111.getFromName();     // Catch: AMapException -> L12
        String r112 = r111.getToName();     // Catch: AMapException -> L12
        String r104 = f26160b;     // Catch: AMapException -> L12
        String r113 = f26164f;     // Catch: AMapException -> L12
        return new ak(this.f26165a, String.format(r104, new Object[]{Double.valueOf(r101.getLatitude()), Double.valueOf(r101.getLongitude()), r103, Double.valueOf(r102.getLatitude()), Double.valueOf(r102.getLongitude()), r112, Integer.valueOf(r100), 1, 0, r113, r113, r113})).b();
    L11:
        throw new AMapException(AMapException.AMAP_CLIENT_INVALID_PARAMETER);     // Catch: AMapException -> L12
    L15:
        throw new AMapException(AMapException.AMAP_CLIENT_INVALID_PARAMETER);     // Catch: AMapException -> L12
    L12:
        e = move-exception;
        i.a(e, "ShareSearch", "searchBusRouteShareUrl");
        throw e;
    }

    @Override // com.amap.api.services.interfaces.IShareSearch
    public final void searchBusRouteShareUrlAsyn(final ShareSearch.ShareBusRouteQuery r100) {
        an.a().a(new AnonymousClass2(this, r100));     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        th.printStackTrace();
    }

    @Override // com.amap.api.services.interfaces.IShareSearch
    public final String searchDrivingRouteShareUrl(ShareSearch.ShareDrivingRouteQuery r110) throws AMapException {
        if (r110 == null) goto L15;
        int r100 = r110.getDrivingMode();     // Catch: AMapException -> L12
        ShareSearch.ShareFromAndTo r111 = r110.getShareFromAndTo();     // Catch: AMapException -> L12
        if (r111.getFrom() == null) goto L11;
        if (r111.getTo() == null) goto L11;
        LatLonPoint r101 = r111.getFrom();     // Catch: AMapException -> L12
        LatLonPoint r102 = r111.getTo();     // Catch: AMapException -> L12
        String r103 = r111.getFromName();     // Catch: AMapException -> L12
        String r112 = r111.getToName();     // Catch: AMapException -> L12
        String r104 = f26160b;     // Catch: AMapException -> L12
        String r113 = f26164f;     // Catch: AMapException -> L12
        return new ak(this.f26165a, String.format(r104, new Object[]{Double.valueOf(r101.getLatitude()), Double.valueOf(r101.getLongitude()), r103, Double.valueOf(r102.getLatitude()), Double.valueOf(r102.getLongitude()), r112, Integer.valueOf(r100), 0, 0, r113, r113, r113})).b();
    L11:
        throw new AMapException(AMapException.AMAP_CLIENT_INVALID_PARAMETER);     // Catch: AMapException -> L12
    L15:
        throw new AMapException(AMapException.AMAP_CLIENT_INVALID_PARAMETER);     // Catch: AMapException -> L12
    L12:
        e = move-exception;
        i.a(e, "ShareSearch", "searchDrivingRouteShareUrl");
        throw e;
    }

    @Override // com.amap.api.services.interfaces.IShareSearch
    public final void searchDrivingRouteShareUrlAsyn(final ShareSearch.ShareDrivingRouteQuery r100) {
        an.a().a(new AnonymousClass4(this, r100));     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        th.printStackTrace();
    }

    @Override // com.amap.api.services.interfaces.IShareSearch
    public final String searchLocationShareUrl(LatLonSharePoint r100) throws AMapException {
        if (r100 == null) goto L8;
        return new ak(this.f26165a, String.format(f26161c, new Object[]{Double.valueOf(r100.getLatitude()), Double.valueOf(r100.getLongitude()), r100.getSharePointName()})).b();
    L8:
        throw new AMapException(AMapException.AMAP_CLIENT_INVALID_PARAMETER);     // Catch: AMapException -> L5
    L5:
        e = move-exception;
        i.a(e, "ShareSearch", "searchLocationShareUrl");
        throw e;
    }

    @Override // com.amap.api.services.interfaces.IShareSearch
    public final void searchLocationShareUrlAsyn(final LatLonSharePoint r100) {
        an.a().a(new AnonymousClass6(this, r100));     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        th.printStackTrace();
    }

    @Override // com.amap.api.services.interfaces.IShareSearch
    public final String searchNaviShareUrl(ShareSearch.ShareNaviQuery r110) throws AMapException {
        if (r110 == null) goto L17;
        ShareSearch.ShareFromAndTo r100 = r110.getFromAndTo();     // Catch: AMapException -> L14
        if (r100.getTo() == null) goto L13;
        LatLonPoint r101 = r100.getFrom();     // Catch: AMapException -> L14
        LatLonPoint r102 = r100.getTo();     // Catch: AMapException -> L14
        int r111 = r110.getNaviMode();     // Catch: AMapException -> L14
        if (r100.getFrom() != null) goto L9;
        String r112 = String.format(f26162d, new Object[]{null, null, Double.valueOf(r102.getLatitude()), Double.valueOf(r102.getLongitude()), Integer.valueOf(r111)});     // Catch: AMapException -> L14
    L11:
        return new ak(this.f26165a, r112).b();
    L9:
        r112 = String.format(f26162d, new Object[]{Double.valueOf(r101.getLatitude()), Double.valueOf(r101.getLongitude()), Double.valueOf(r102.getLatitude()), Double.valueOf(r102.getLongitude()), Integer.valueOf(r111)});     // Catch: AMapException -> L14
        goto L11
    L13:
        throw new AMapException(AMapException.AMAP_CLIENT_INVALID_PARAMETER);     // Catch: AMapException -> L14
    L17:
        throw new AMapException(AMapException.AMAP_CLIENT_INVALID_PARAMETER);     // Catch: AMapException -> L14
    L14:
        e = move-exception;
        i.a(e, "ShareSearch", "searchNaviShareUrl");
        throw e;
    }

    @Override // com.amap.api.services.interfaces.IShareSearch
    public final void searchNaviShareUrlAsyn(final ShareSearch.ShareNaviQuery r100) {
        an.a().a(new AnonymousClass5(this, r100));     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        th.printStackTrace();
    }

    @Override // com.amap.api.services.interfaces.IShareSearch
    public final String searchPoiShareUrl(PoiItem r100) throws AMapException {
        if (r100 == null) goto L8;
    L9:
        e = move-exception;
        i.a(e, "ShareSearch", "searchPoiShareUrl");
        throw e;
    L4:
        if (r100.getLatLonPoint() == null) goto L8;
        LatLonPoint r101 = r100.getLatLonPoint();     // Catch: AMapException -> L9
        return new ak(this.f26165a, String.format(f26163e, new Object[]{r100.getPoiId(), Double.valueOf(r101.getLatitude()), Double.valueOf(r101.getLongitude()), r100.getTitle(), r100.getSnippet()})).b();
    L8:
        throw new AMapException(AMapException.AMAP_CLIENT_INVALID_PARAMETER);     // Catch: AMapException -> L9
    }

    @Override // com.amap.api.services.interfaces.IShareSearch
    public final void searchPoiShareUrlAsyn(final PoiItem r100) {
        an.a().a(new AnonymousClass1(this, r100));     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        th.printStackTrace();
    }

    @Override // com.amap.api.services.interfaces.IShareSearch
    public final String searchWalkRouteShareUrl(ShareSearch.ShareWalkRouteQuery r110) throws AMapException {
        if (r110 == null) goto L15;
        int r100 = r110.getWalkMode();     // Catch: AMapException -> L12
        ShareSearch.ShareFromAndTo r111 = r110.getShareFromAndTo();     // Catch: AMapException -> L12
        if (r111.getFrom() == null) goto L11;
        if (r111.getTo() == null) goto L11;
        LatLonPoint r101 = r111.getFrom();     // Catch: AMapException -> L12
        LatLonPoint r102 = r111.getTo();     // Catch: AMapException -> L12
        String r103 = r111.getFromName();     // Catch: AMapException -> L12
        String r112 = r111.getToName();     // Catch: AMapException -> L12
        String r104 = f26160b;     // Catch: AMapException -> L12
        String r113 = f26164f;     // Catch: AMapException -> L12
        return new ak(this.f26165a, String.format(r104, new Object[]{Double.valueOf(r101.getLatitude()), Double.valueOf(r101.getLongitude()), r103, Double.valueOf(r102.getLatitude()), Double.valueOf(r102.getLongitude()), r112, Integer.valueOf(r100), 2, 0, r113, r113, r113})).b();
    L11:
        throw new AMapException(AMapException.AMAP_CLIENT_INVALID_PARAMETER);     // Catch: AMapException -> L12
    L15:
        throw new AMapException(AMapException.AMAP_CLIENT_INVALID_PARAMETER);     // Catch: AMapException -> L12
    L12:
        e = move-exception;
        i.a(e, "ShareSearch", "searchWalkRouteShareUrl");
        throw e;
    }

    @Override // com.amap.api.services.interfaces.IShareSearch
    public final void searchWalkRouteShareUrlAsyn(final ShareSearch.ShareWalkRouteQuery r100) {
        an.a().a(new AnonymousClass3(this, r100));     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        th.printStackTrace();
    }

    @Override // com.amap.api.services.interfaces.IShareSearch
    public final void setOnShareSearchListener(ShareSearch.OnShareSearchListener r100) {
        this.f26166g = r100;
    }
}
