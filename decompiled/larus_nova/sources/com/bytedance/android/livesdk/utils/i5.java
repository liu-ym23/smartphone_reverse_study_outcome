package com.bytedance.android.livesdk.utils;

import androidx.lifecycle.LiveData;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.strategy.api.IStrategyService;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class i5 {
    static {
    }

    public static boolean a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        if (tb1.c.f545229a == false) goto L14;
        LinkedHashMap r101 = new LinkedHashMap();
        IStrategyService r102 = (IStrategyService) jc1.k.f(IStrategyService.class);
        if (r102 == null) goto L9;
        LiveData r103 = IStrategyService.a.a(r102, "live_preload", r101, false, 12);
        if (r103 == null) goto L9;
        Map r104 = (Map) r103.getValue();
    L10:
        if (r104 == null) goto L14;
        Boolean r105 = (Boolean) r104.get(r100);
        if (r105 == null) goto L14;
        boolean r106 = r105.booleanValue();
    L15:
        ALogger.i("PreloadStrategyManager", "Current requestKey " + r100 + " value is " + r106);
        return r106;
    L9:
        r104 = null;
    L14:
        r106 = true;
        goto L15
    }
}
