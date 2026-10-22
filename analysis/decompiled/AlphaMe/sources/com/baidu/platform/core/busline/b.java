package com.baidu.platform.core.busline;

import android.text.TextUtils;
import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.search.base.LanguageType;
import com.baidu.mapapi.search.busline.BusLineSearchOption;

/* loaded from: classes.dex */
public class b extends com.baidu.platform.base.c {
    public b(BusLineSearchOption busLineSearchOption) {
        a(busLineSearchOption);
    }

    private void a(BusLineSearchOption busLineSearchOption) {
        this.f8580d.a("uid", busLineSearchOption.mUid);
        if (!TextUtils.isEmpty(busLineSearchOption.mStartUid)) {
            this.f8580d.a("suid", busLineSearchOption.mStartUid);
        }
        if (!TextUtils.isEmpty(busLineSearchOption.mEndUid)) {
            this.f8580d.a("euid", busLineSearchOption.mEndUid);
        }
        if (busLineSearchOption.mLanguageType == LanguageType.LanguageTypeEnglish) {
            this.f8580d.a("language", "en");
        }
        if (SDKInitializer.getCoordType() == CoordType.GCJ02) {
            this.f8580d.a("ret_coordtype", "gcj02ll");
        } else {
            this.f8580d.a("ret_coordtype", "bd09ll");
        }
    }

    @Override // com.baidu.platform.base.c
    public String a(com.baidu.platform.domain.b bVar) {
        return bVar.f();
    }
}
