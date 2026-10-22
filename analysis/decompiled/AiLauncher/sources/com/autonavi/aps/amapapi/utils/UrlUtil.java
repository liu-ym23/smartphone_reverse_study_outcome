package com.autonavi.aps.amapapi.utils;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.col.jmsl.C1532a1;
import com.amap.api.col.jmsl.C1567j0;
import com.amap.api.col.jmsl.C1572k1;
import com.amap.api.col.jmsl.C1604s2;
import java.net.MalformedURLException;
import java.net.URL;

/* loaded from: classes.dex */
public class UrlUtil {
    public static final String AMAP_HOST_ALOC_CONTROL_PLUS_AMAP_COM = "aloc-control-plus.amap.com";
    public static final String AMAP_HOST_ALOC_MODELDATA_AMAP_COM = "aloc-modeldata.amap.com";
    public static final String AMAP_HOST_ALOC_OFFLINE_AMAP_COM = "aloc-offline.amap.com";
    public static final String AMAP_HOST_APS_AMAP_COM = "aps.amap.com";
    public static final String AMAP_HOST_CGICOL_AMAP_COM = "cgicol.amap.com";
    public static final String AMAP_PATH_ALOC_UPDATABLE = "/aloc/updatable";
    public static final String AMAP_PATH_APS_R = "/APS/r";
    public static final String AMAP_PATH_COLLECTION_COLLECTDATA = "/collection/collectData";
    public static final String AMAP_PATH_DATAPIPELINE_UPLOADDATA = "/dataPipeline/uploadData";
    public static final String AMAP_PATH_LOADOFFLINEDATA_REPEATDATA = "/LoadOfflineData/repeatData";
    public static final String AMAP_PATH_MODEL_GET = "/model/get";
    public static final String OPEN_HOST_OUTOFCN_SERVER = "abroad.apilocate.amap.com";
    public static final String OPEN_HOST_PRE = "apilocate-pre-test.amap.com";
    public static final String OPEN_HOST_REL_V4 = "apilocate.amap.com";
    public static final String OPEN_HOST_REL_V6 = "dualstack-a.apilocate.amap.com";
    public static final String OPEN_PATH_ALOC_UPDATABLE = "/v5/aloc/updatable";
    public static final String OPEN_PATH_COLLECTION_COLLECTDATA = "/v5/collection/collectData";
    public static final String OPEN_PATH_DATAPIPELINE_UPLOADDATA = "/v5/dataPipeline/uploadData";
    public static final String OPEN_PATH_LOADOFFLINEDATA_REPEATDATA = "/v5/LoadOfflineData/repeatData";
    public static final String OPEN_PATH_MOBILE_BINARY = "/v5/mobile/binary";
    public static final String OPEN_PATH_MODEL_GET = "/v5/model/get";
    public static final int TYPE_IPV4 = 0;
    public static final int TYPE_IPV6 = 1;

    private static String a(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return "?&key=" + C1567j0.n(context);
        }
        return "?" + str + "&key=" + C1567j0.n(context);
    }

    public static String getHost(Context context, int i10) {
        C1532a1 c1532a1C = C1532a1.c(context);
        String strA = c1532a1C.a(43);
        String[] strArr = C1604s2.f16918a;
        return C1572k1.a(context, false) ? c1532a1C.a(40) : i10 != 1 ? strA : c1532a1C.a(44);
    }

    public static boolean isNeedTransform(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.contains(AMAP_PATH_APS_R) || str.contains(AMAP_PATH_LOADOFFLINEDATA_REPEATDATA) || str.contains(AMAP_PATH_DATAPIPELINE_UPLOADDATA) || str.contains(AMAP_PATH_MODEL_GET) || str.contains(AMAP_PATH_COLLECTION_COLLECTDATA) || str.contains(AMAP_PATH_ALOC_UPDATABLE);
    }

    public static String urlTransform(Context context, int i10, String str) {
        StringBuilder sb2 = new StringBuilder();
        try {
            URL url = new URL(str);
            String host = url.getHost();
            String path = url.getPath();
            String query = url.getQuery();
            sb2.append(url.getProtocol());
            sb2.append("://");
            if (TextUtils.equals(AMAP_HOST_APS_AMAP_COM, host) || TextUtils.equals(AMAP_HOST_ALOC_OFFLINE_AMAP_COM, host) || TextUtils.equals(AMAP_HOST_CGICOL_AMAP_COM, host) || TextUtils.equals(AMAP_HOST_ALOC_MODELDATA_AMAP_COM, host) || TextUtils.equals(AMAP_HOST_ALOC_CONTROL_PLUS_AMAP_COM, host)) {
                String host2 = getHost(context, i10);
                host = host2;
            }
            sb2.append(host);
            if (TextUtils.equals(AMAP_PATH_APS_R, path)) {
                path = OPEN_PATH_MOBILE_BINARY;
            } else if (TextUtils.equals(AMAP_PATH_LOADOFFLINEDATA_REPEATDATA, path)) {
                path = OPEN_PATH_LOADOFFLINEDATA_REPEATDATA;
            } else if (TextUtils.equals(AMAP_PATH_DATAPIPELINE_UPLOADDATA, path)) {
                path = OPEN_PATH_DATAPIPELINE_UPLOADDATA;
            } else if (TextUtils.equals(AMAP_PATH_MODEL_GET, path)) {
                path = OPEN_PATH_MODEL_GET;
            } else if (TextUtils.equals(AMAP_PATH_COLLECTION_COLLECTDATA, path)) {
                path = OPEN_PATH_COLLECTION_COLLECTDATA;
            } else if (TextUtils.equals(AMAP_PATH_ALOC_UPDATABLE, path)) {
                path = OPEN_PATH_ALOC_UPDATABLE;
            }
            sb2.append(path);
            sb2.append(a(context, query));
            return sb2.toString();
        } catch (MalformedURLException e10) {
            throw new RuntimeException(e10);
        }
    }
}
