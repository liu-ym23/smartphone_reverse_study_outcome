package com.baidu.platform.core.share;

import B0.g;
import com.baidu.mapapi.http.HttpClient;
import com.baidu.mapapi.search.share.PoiDetailShareURLOption;
import com.baidu.platform.comapi.map.MapBundleKey;

/* loaded from: classes.dex */
public class b extends com.baidu.platform.base.c {
    public b(PoiDetailShareURLOption poiDetailShareURLOption) {
        a(poiDetailShareURLOption);
    }

    private void a(PoiDetailShareURLOption poiDetailShareURLOption) {
        StringBuilder sbS = g.s(g.r(new StringBuilder("https://wapmap.baidu.com/s?tn=Detail&pid="), poiDetailShareURLOption.mUid, "&smsf=3"));
        sbS.append(HttpClient.getPhoneInfo());
        this.f8580d.a(MapBundleKey.MapObjKey.OBJ_URL, sbS.toString());
        b(false);
        a(false);
    }

    @Override // com.baidu.platform.base.c
    public String a(com.baidu.platform.domain.b bVar) {
        return bVar.r();
    }
}
