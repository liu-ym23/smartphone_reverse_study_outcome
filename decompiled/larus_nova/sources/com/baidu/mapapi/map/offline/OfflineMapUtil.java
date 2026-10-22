package com.baidu.mapapi.map.offline;

import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapsdkplatform.comapi.map.j;
import com.baidu.mapsdkplatform.comapi.map.l;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes39.dex */
public class OfflineMapUtil {
    public OfflineMapUtil() {
    }

    public static MKOLSearchRecord getSearchRecordFromLocalCityInfo(j r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        MKOLSearchRecord r101 = new MKOLSearchRecord();
        r101.cityID = r100.f32160a;
        r101.cityName = r100.f32161b;
        r101.cityType = r100.f32163d;
        long r102 = 0;
        if (r100.a() == null) goto L12;
        ArrayList<MKOLSearchRecord> r103 = new ArrayList();
        Iterator<j> r104 = r100.a().iterator();
    L9:
        if (r104.hasNext() == false) goto L12;
        j r105 = r104.next();
        r103.add(getSearchRecordFromLocalCityInfo(r105));
        r102 = r102 + ((long) r105.f32162c);
        r101.childCities = r103;
    L12:
        if (r101.cityType != 1) goto L14;
        r101.dataSize = r102;
    L15:
        return r101;
    L14:
        r101.dataSize = r100.f32162c;
        goto L15
    }

    public static MKOLUpdateElement getUpdatElementFromLocalMapElement(l r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        MKOLUpdateElement r101 = new MKOLUpdateElement();
        r101.cityID = r100.f32170a;
        r101.cityName = r100.f32171b;
        GeoPoint r102 = r100.f32176g;
        if (r102 == null) goto L8;
        r101.geoPt = CoordUtil.mc2ll(r102);
    L8:
        r101.level = r100.f32174e;
        int r103 = r100.f32178i;
        r101.ratio = r103;
        int r104 = r100.f32177h;
        r101.serversize = r104;
        if (r103 != 100) goto L11;
        r101.size = r104;
    L12:
        r101.status = r100.f32181l;
        r101.update = r100.f32179j;
        return r101;
    L11:
        r101.size = (r104 / 100) * r103;
        goto L12
    }
}
