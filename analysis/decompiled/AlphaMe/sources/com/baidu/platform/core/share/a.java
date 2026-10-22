package com.baidu.platform.core.share;

import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.search.share.LocationShareURLOption;
import com.baidu.platform.comapi.basestruct.Point;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.stepos.alphame.utils.Consts;

/* loaded from: classes.dex */
public class a extends com.baidu.platform.base.c {
    public a(LocationShareURLOption locationShareURLOption) {
        a(locationShareURLOption);
    }

    private void a(LocationShareURLOption locationShareURLOption) {
        this.f8580d.a("qt", "cs");
        Point pointLl2point = CoordUtil.ll2point(locationShareURLOption.mLocation);
        this.f8580d.a(MapBundleKey.MapObjKey.OBJ_GEO, pointLl2point.f8600x + Consts.SPLITTER_DETAIL + pointLl2point.f8601y);
        this.f8580d.a("t", locationShareURLOption.mName);
        this.f8580d.a("cnt", locationShareURLOption.mSnippet);
        b(false);
        a(false);
    }

    @Override // com.baidu.platform.base.c
    public String a(com.baidu.platform.domain.b bVar) {
        return bVar.h();
    }
}
