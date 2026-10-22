package com.baidu.platform.core.geocode;

import com.baidu.mapapi.http.wrapper.annotation.BodyData;
import com.baidu.mapapi.search.geocode.GeoCodeOption;

/* loaded from: classes.dex */
public class c extends com.baidu.platform.base.c {
    public c(GeoCodeOption geoCodeOption) {
        a(geoCodeOption);
    }

    private void a(GeoCodeOption geoCodeOption) {
        this.f8580d.a("city", geoCodeOption.mCity);
        this.f8580d.a("address", geoCodeOption.mAddress);
        this.f8580d.a("output", BodyData.TYPE_JSON);
        this.f8580d.a("ret_coordtype", "bd09ll");
        this.f8580d.a("from", "android_map_sdk");
    }

    @Override // com.baidu.platform.base.c
    public String a(com.baidu.platform.domain.b bVar) {
        return bVar.m();
    }
}
