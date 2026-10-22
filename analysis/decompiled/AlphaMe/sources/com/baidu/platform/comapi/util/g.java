package com.baidu.platform.comapi.util;

import android.text.TextUtils;
import com.baidu.mapapi.map.EncodePointType;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapsdkplatform.comapi.map.t;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class g {

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private static g f9306a = new g();
    }

    public static g a() {
        return a.f9306a;
    }

    private ArrayList<LatLng> c(String str) {
        return new t().e(str);
    }

    public ArrayList<LatLng> b(String str) {
        return new t().d(str);
    }

    public ArrayList<LatLng> a(String str, int i4) {
        if (TextUtils.isEmpty(str) || i4 == EncodePointType.NONE.ordinal()) {
            return null;
        }
        if (i4 == EncodePointType.BUILDINGINFO.ordinal()) {
            return b(str);
        }
        if (i4 == EncodePointType.AOI.ordinal()) {
            return a(str);
        }
        if (i4 == EncodePointType.RECOGNIZE_AOI.ordinal()) {
            return c(str);
        }
        return null;
    }

    private ArrayList<LatLng> a(String str) {
        return new t().b(str);
    }
}
