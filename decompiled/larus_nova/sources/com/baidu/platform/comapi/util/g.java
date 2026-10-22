package com.baidu.platform.comapi.util;

import android.text.TextUtils;
import com.baidu.mapapi.map.EncodePointType;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapsdkplatform.comapi.map.t;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes39.dex */
public class g {

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static g f33426a;

        static {
            f33426a = new g();
        }

        public static /* synthetic */ g a() {
            return f33426a;
        }
    }

    public static g a() {
        return a.a();
    }

    public g() {
    }

    private ArrayList<LatLng> a(String r100) {
        return new t().b(r100);
    }

    private ArrayList<LatLng> c(String r100) {
        return new t().e(r100);
    }

    public ArrayList<LatLng> b(String r100) {
        return new t().d(r100);
    }

    public ArrayList<LatLng> a(String r100, int r101) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return null;
    L5:
        if (r101 != EncodePointType.NONE.ordinal()) goto L8;
        return null;
    L8:
        if (r101 != EncodePointType.BUILDINGINFO.ordinal()) goto L11;
        return b(r100);
    L11:
        if (r101 != EncodePointType.AOI.ordinal()) goto L14;
        return a(r100);
    L14:
        if (r101 == EncodePointType.RECOGNIZE_AOI.ordinal()) goto L16;
        return null;
    L16:
        return c(r100);
    }
}
