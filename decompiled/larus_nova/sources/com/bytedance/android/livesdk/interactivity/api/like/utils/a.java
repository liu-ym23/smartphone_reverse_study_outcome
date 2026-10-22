package com.bytedance.android.livesdk.interactivity.api.like.utils;

import androidx.lifecycle.LiveData;
import com.bytedance.android.live.strategy.api.IStrategyService;
import com.bytedance.android.livesdk.config.pn;
import com.bytedance.android.livesdk.utils.z0;
import java.util.LinkedHashMap;
import java.util.Map;
import jc1.k;

/* JADX INFO: loaded from: classes9.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f133292a = 0;

    static {
    }

    public static boolean a(boolean r100) {
        double r101 = z0.b(r100);
        pn r102 = pn.f120993a;
        if (r101 >= r102.getValue().b()) goto L5;
    L9:
        boolean r103 = false;
    L10:
        LinkedHashMap r104 = new LinkedHashMap();
        IStrategyService r105 = (IStrategyService) k.f(IStrategyService.class);
        if (r105 == null) goto L15;
        LiveData r106 = IStrategyService.a.a(r105, "live_ui_degrade", r104, false, 12);
        if (r106 == null) goto L15;
        Map r107 = (Map) r106.getValue();
    L16:
        if (r107 == null) goto L20;
        Boolean r108 = (Boolean) r107.get("digg_hide");
        if (r108 == null) goto L20;
        r103 = r108.booleanValue();
    L20:
        if (r100 == true) goto L24;
        if (r103 == false) goto L25;
        return true;
    L25:
        return false;
    L24:
        return false;
    L15:
        r107 = null;
        goto L16
    L5:
        if (r101 > r102.getValue().a()) goto L9;
        if (r102.getValue().c() == false) goto L9;
        r103 = true;
        goto L10
    }
}
