package com.baidu.platform.core.district;

import com.baidu.mapapi.http.wrapper.annotation.BodyData;
import com.baidu.mapapi.search.district.DistrictSearchOption;

/* loaded from: classes.dex */
public class a extends com.baidu.platform.base.c {
    public a(DistrictSearchOption districtSearchOption) {
        a(districtSearchOption);
    }

    private void a(DistrictSearchOption districtSearchOption) {
        if (districtSearchOption == null) {
            return;
        }
        this.f8580d.a("qt", "con");
        this.f8580d.a("rp_format", BodyData.TYPE_JSON);
        this.f8580d.a("rp_filter", "mobile");
        this.f8580d.a("area_res", "true");
        this.f8580d.a("addr_identify", "1");
        this.f8580d.a("ie", "utf-8");
        this.f8580d.a("pn", "0");
        this.f8580d.a("rn", "10");
        this.f8580d.a("c", districtSearchOption.mCityName);
        String str = districtSearchOption.mDistrictName;
        if (str == null || str.equals("")) {
            this.f8580d.a("wd", districtSearchOption.mCityName);
        } else {
            this.f8580d.a("wd", districtSearchOption.mDistrictName);
        }
    }

    @Override // com.baidu.platform.base.c
    public String a(com.baidu.platform.domain.b bVar) {
        return bVar.j();
    }
}
