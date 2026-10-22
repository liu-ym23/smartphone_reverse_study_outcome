package com.baidu.mapapi.map.offline;

import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapsdkplatform.comapi.map.j;
import com.baidu.mapsdkplatform.comapi.map.l;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class OfflineMapUtil {
    public static MKOLSearchRecord getSearchRecordFromLocalCityInfo(j jVar) {
        if (jVar == null) {
            return null;
        }
        MKOLSearchRecord mKOLSearchRecord = new MKOLSearchRecord();
        mKOLSearchRecord.cityID = jVar.f8059a;
        mKOLSearchRecord.cityName = jVar.f8060b;
        mKOLSearchRecord.cityType = jVar.f8062d;
        long j4 = 0;
        if (jVar.a() != null) {
            ArrayList<MKOLSearchRecord> arrayList = new ArrayList<>();
            Iterator<j> it = jVar.a().iterator();
            while (it.hasNext()) {
                arrayList.add(getSearchRecordFromLocalCityInfo(it.next()));
                j4 += r5.f8061c;
                mKOLSearchRecord.childCities = arrayList;
            }
        }
        if (mKOLSearchRecord.cityType == 1) {
            mKOLSearchRecord.dataSize = j4;
        } else {
            mKOLSearchRecord.dataSize = jVar.f8061c;
        }
        return mKOLSearchRecord;
    }

    public static MKOLUpdateElement getUpdatElementFromLocalMapElement(l lVar) {
        if (lVar == null) {
            return null;
        }
        MKOLUpdateElement mKOLUpdateElement = new MKOLUpdateElement();
        mKOLUpdateElement.cityID = lVar.f8069a;
        mKOLUpdateElement.cityName = lVar.f8070b;
        GeoPoint geoPoint = lVar.f8075g;
        if (geoPoint != null) {
            mKOLUpdateElement.geoPt = CoordUtil.mc2ll(geoPoint);
        }
        mKOLUpdateElement.level = lVar.f8073e;
        int i4 = lVar.f8077i;
        mKOLUpdateElement.ratio = i4;
        int i5 = lVar.f8076h;
        mKOLUpdateElement.serversize = i5;
        if (i4 == 100) {
            mKOLUpdateElement.size = i5;
        } else {
            mKOLUpdateElement.size = (i5 / 100) * i4;
        }
        mKOLUpdateElement.status = lVar.f8080l;
        mKOLUpdateElement.update = lVar.f8078j;
        return mKOLUpdateElement;
    }
}
