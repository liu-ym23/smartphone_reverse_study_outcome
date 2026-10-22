package com.bytedance.android.annie.debug;

import com.bytedance.android.annie.api.card.IHybridComponent;
import com.bytedance.android.annie.service.setting.AnnieConfigSettingKeys;
import com.bytedance.forest.chain.fetchers.GeckoXAdapter;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import p9.h;

/* JADX INFO: loaded from: classes43.dex */
public final class b implements h {
    public b() {
    }

    @Override // p9.h
    public final Map a(String r100, IHybridComponent.HybridType r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "url");
        if (GeckoXAdapter.Companion.isCDNMultiVersionResource(r100) == true) goto L9;
        if (AnnieConfigSettingKeys.ADDING_ENV_TO_ALL_REQ.a().booleanValue() == true) goto L9;
        return MapsKt.emptyMap();
    L9:
        return d.a();
    }
}
