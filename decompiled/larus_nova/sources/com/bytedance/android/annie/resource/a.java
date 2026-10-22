package com.bytedance.android.annie.resource;

import com.bytedance.android.annie.api.card.IHybridComponent;
import com.bytedance.android.annie.service.setting.AnnieConfigSettingKeys;
import com.bytedance.forest.chain.fetchers.GeckoXAdapter;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class a implements p9.h {
    public a() {
    }

    @Override // p9.h
    public final Map a(String r100, IHybridComponent.HybridType r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "url");
        if (r101 != IHybridComponent.HybridType.H5) goto L12;
        if (AnnieConfigSettingKeys.DISABLE_MULTI_VERSION_QUERY.a().booleanValue() == true) goto L12;
        if (n.j(r100, r101, r102) == true) goto L12;
        GeckoXAdapter.Companion r103 = GeckoXAdapter.Companion;
        if (r103.isCDNMultiVersionResource(r100) == false) goto L12;
        return r103.getCDNMultiVersionCommonParams();
    L12:
        return new LinkedHashMap();
    }
}
