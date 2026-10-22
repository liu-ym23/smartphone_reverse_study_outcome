package com.autonavi.aps.amapapi.trans;

import android.content.Context;
import com.amap.api.col.jmsl.C1532a1;
import com.amap.api.col.jmsl.C1540c1;
import com.amap.api.col.jmsl.C1567j0;
import com.amap.api.col.jmsl.C1577l2;
import com.amap.api.col.jmsl.C1604s2;
import com.amap.api.col.jmsl.C1607t1;
import com.amap.api.col.jmsl.J0;
import com.amap.api.col.jmsl.L1;
import com.amap.api.col.jmsl.s7;
import com.amap.api.location.DPoint;
import com.amap.api.services.core.ServiceSettings;
import com.autonavi.aps.amapapi.config.Const;
import com.autonavi.aps.amapapi.utils.CoreUtil;
import com.autonavi.aps.amapapi.utils.OffsetUtil;
import com.autonavi.aps.amapapi.utils.Utils;
import com.stepos.statsapp.v3.lib.plugin.net.multipart.e;
import java.util.HashMap;
import java.util.Locale;

/* loaded from: classes.dex */
public class LocNetManager {

    /* renamed from: f, reason: collision with root package name */
    private static LocNetManager f18387f;

    /* renamed from: g, reason: collision with root package name */
    private static final String[] f18388g = {ServiceSettings.CHINESE, "zh-Hant-HK", "en", "es", "pt", Const.SP_KEY_FIRSTLOC_RELOC, "de", "th", "ja", "ko", "ar", "tr", "he", "it", "ru", Const.SP_KEY_GSM_UPLOAD_MXSIZE, "id", "vi", "pl", "cs", "uk", "az"};

    /* renamed from: a, reason: collision with root package name */
    C1540c1 f18389a;

    /* renamed from: b, reason: collision with root package name */
    private Context f18390b;

    /* renamed from: c, reason: collision with root package name */
    private int f18391c = CoreUtil.iTo;

    /* renamed from: d, reason: collision with root package name */
    private boolean f18392d = false;

    /* renamed from: e, reason: collision with root package name */
    private int f18393e = 0;

    private LocNetManager(Context context) {
        this.f18389a = null;
        this.f18390b = null;
        try {
            C1607t1.a().b(context);
        } catch (Throwable unused) {
        }
        this.f18390b = context;
        this.f18389a = C1540c1.b();
    }

    public static LocNetManager getInstance(Context context) {
        if (f18387f == null) {
            f18387f = new LocNetManager(context);
        }
        return f18387f;
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0111 A[Catch: all -> 0x012c, TryCatch #1 {all -> 0x012c, blocks: (B:4:0x0012, B:6:0x0035, B:8:0x003e, B:10:0x007d, B:11:0x0084, B:16:0x0094, B:18:0x009b, B:22:0x00e2, B:24:0x00e8, B:25:0x00ed, B:28:0x00f3, B:30:0x00f8, B:32:0x0114, B:34:0x0125, B:31:0x0111, B:21:0x00de), top: B:41:0x0012 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.autonavi.aps.amapapi.trans.LocationRequest createLocationRequest(android.content.Context r9, byte[] r10, java.lang.String r11, java.lang.String r12, boolean r13, java.lang.String r14) {
        /*
            Method dump skipped, instructions count: 301
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autonavi.aps.amapapi.trans.LocNetManager.createLocationRequest(android.content.Context, byte[], java.lang.String, java.lang.String, boolean, java.lang.String):com.autonavi.aps.amapapi.trans.LocationRequest");
    }

    public int getTimeOut() {
        return this.f18391c;
    }

    public String postReGeo(Context context, double d10, double d11, boolean z10) {
        int i10;
        try {
            if (CoreUtil.isChina(d10, d11) && !z10) {
                DPoint dPointOffset = OffsetUtil.offset(context, new DPoint(d10, d11));
                double latitude = dPointOffset.getLatitude();
                double longitude = dPointOffset.getLongitude();
                d10 = latitude;
                d11 = longitude;
            }
            HashMap map = new HashMap(16);
            LocationRequest locationRequest = new LocationRequest(context, CoreUtil.getSDKInfo());
            map.clear();
            map.put(e.f30851j, e.f30858q);
            map.put(e.f30853l, CoreUtil.HTTP_HEADER_USER_AGENT);
            HashMap map2 = new HashMap(16);
            map2.put("custom", "26260A1F00020002");
            map2.put("key", C1567j0.n(context));
            if (C1567j0.o() || ((i10 = this.f18393e) > 0 && i10 < f18388g.length)) {
                int i11 = this.f18393e;
                if (i11 < 0 || i11 >= f18388g.length) {
                    i11 = 0;
                }
                map2.put("langCode", f18388g[i11]);
            } else {
                map2.remove("langCode");
            }
            map2.put("curLocationType", Utils.isCoarsePermOpen(this.f18390b) ? "coarseLoc" : "fineLoc");
            String strB = J0.b();
            String strD = J0.d(context, strB, C1604s2.c(map2));
            map2.put("ts", strB);
            map2.put("scode", strD);
            locationRequest.setAesEntity(("output=json&radius=1000&extensions=all&location=" + d11 + Const.STR_MART_COMMA + d10).getBytes("UTF-8"));
            locationRequest.setLocRequest(false);
            locationRequest.setIsXinfo(true);
            locationRequest.setPlatinfo(String.format(Locale.US, "platform=Android&sdkversion=%s&product=%s&loc_channel=%s", CoreUtil.STR_CONFIG_VERSION, "loc", 3));
            locationRequest.setParamsMap(map2);
            locationRequest.setHead(map);
            locationRequest.setProxy(L1.d(context));
            locationRequest.setConnectionTimeout(CoreUtil.iTo);
            locationRequest.setSoTimeout(CoreUtil.iTo);
            try {
                C1532a1 c1532a1C = C1532a1.c(context);
                String str = "http://" + c1532a1C.a(42);
                String str2 = str + "/v3/geocode/regeo";
                if (str.contains("restsdk.amap.com")) {
                    map.put("Content-Type", "application/x-www-form-urlencoded");
                } else {
                    map.put("Content-Type", "application/octet-stream");
                }
                locationRequest.setIPV6Url(("http://" + c1532a1C.a(42)) + "/v3/geocode/regeo");
                locationRequest.setUrl(str2);
                if (this.f18392d) {
                    locationRequest.setHttpProtocol(s7.c.HTTPS);
                }
                return new String(this.f18389a.d(locationRequest).f16719a, "utf-8");
            } catch (Throwable th) {
                CoreUtil.reportError(th, "LocNetManager", "post");
                return null;
            }
        } catch (Throwable unused) {
            return null;
        }
    }

    public C1577l2 req(LocationRequest locationRequest) throws Throwable {
        if (this.f18392d) {
            locationRequest.setHttpProtocol(s7.c.HTTPS);
        }
        return this.f18389a.d(locationRequest);
    }

    public void setOption(long j10, boolean z10, int i10) {
        try {
            this.f18392d = z10;
            this.f18391c = Long.valueOf(j10).intValue();
            this.f18393e = i10;
        } catch (Throwable th) {
            CoreUtil.reportError(th, "LocNetManager", "setOption");
        }
    }

    public C1577l2 req(LocationRequest locationRequest, int i10) throws Throwable {
        if (this.f18392d) {
            locationRequest.setHttpProtocol(s7.c.HTTPS);
        }
        return this.f18389a.d(locationRequest);
    }
}
