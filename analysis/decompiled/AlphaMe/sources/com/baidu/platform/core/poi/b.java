package com.baidu.platform.core.poi;

import com.baidu.mapapi.search.poi.PoiIndoorOption;
import com.baidu.platform.comapi.map.MapBundleKey;

/* loaded from: classes.dex */
public class b extends com.baidu.platform.base.c {
    public b(PoiIndoorOption poiIndoorOption) {
        a(poiIndoorOption);
    }

    private void a(PoiIndoorOption poiIndoorOption) {
        this.f8580d.a("qt", "indoor_s");
        this.f8580d.a("x", "0");
        this.f8580d.a("y", "0");
        this.f8580d.a("from", "android_map_sdk");
        String str = poiIndoorOption.bid;
        if (str != null && !str.equals("")) {
            this.f8580d.a(MapBundleKey.MapObjKey.OBJ_BID, str);
        }
        String str2 = poiIndoorOption.wd;
        if (str2 != null && !str2.equals("")) {
            this.f8580d.a("wd", str2);
        }
        String str3 = poiIndoorOption.floor;
        if (str3 != null && !str3.equals("")) {
            this.f8580d.a("floor", str3);
        }
        this.f8580d.a("current", poiIndoorOption.currentPage + "");
        this.f8580d.a("pageSize", poiIndoorOption.pageSize + "");
    }

    @Override // com.baidu.platform.base.c
    public String a(com.baidu.platform.domain.b bVar) {
        return bVar.c();
    }
}
