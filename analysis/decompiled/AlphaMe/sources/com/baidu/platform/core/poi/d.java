package com.baidu.platform.core.poi;

import android.util.Log;
import ch.qos.logback.core.joran.action.Action;
import ch.qos.logback.core.rolling.helper.DateTokenConverter;
import com.baidu.mapapi.http.wrapper.annotation.BodyData;
import com.baidu.mapapi.search.base.LanguageType;
import com.baidu.mapapi.search.poi.PoiDetailSearchOption;

/* loaded from: classes.dex */
public class d extends com.baidu.platform.base.c {
    public d(PoiDetailSearchOption poiDetailSearchOption) {
        a(poiDetailSearchOption);
    }

    private void a(PoiDetailSearchOption poiDetailSearchOption) {
        if (poiDetailSearchOption == null) {
            Log.e(DateTokenConverter.CONVERTER_KEY, "Option is null");
            return;
        }
        if (!poiDetailSearchOption.isSearchByUids()) {
            poiDetailSearchOption.poiUids(poiDetailSearchOption.getUid());
        }
        if (poiDetailSearchOption.mLanguageType == LanguageType.LanguageTypeEnglish) {
            this.f8580d.a("language", "en");
        }
        this.f8580d.a("photo_show", poiDetailSearchOption.isShowPhoto() ? "true" : "false");
        this.f8580d.a("uids", poiDetailSearchOption.getUids());
        this.f8580d.a("extensions_adcode", poiDetailSearchOption.isExtendAdcode() ? "true" : "false");
        this.f8580d.a("output", BodyData.TYPE_JSON);
        this.f8580d.a(Action.SCOPE_ATTRIBUTE, "2");
    }

    @Override // com.baidu.platform.base.c
    public String a(com.baidu.platform.domain.b bVar) {
        return bVar.v();
    }
}
