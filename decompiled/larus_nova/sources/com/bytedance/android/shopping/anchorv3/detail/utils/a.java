package com.bytedance.android.shopping.anchorv3.detail.utils;

import android.content.res.Resources;
import android.util.DisplayMetrics;
import cl.d;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.ec.sdk.helper.k;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;

/* JADX INFO: loaded from: classes12.dex */
public final class a {
    public static boolean a() {
        if (ECAppInfoService.f48114e.isLocalTest() == false) goto L7;
        d r100 = k.a();
        if (r100 == null) goto L7;
        r100.q();
    L7:
        Resources r101 = Resources.getSystem();
        DisplayMetrics r102 = WindowDisplayMetricsOverride.apply(r101, r101.getDisplayMetrics());
        float r103 = 1.0f;
        if (r102 == null) goto L12;
        r103 = (r102.heightPixels * 1.0f) / r102.widthPixels;
    L12:
        if (r103 >= 1.8f) goto L14;
        return true;
    L14:
        return false;
    }

    static {
    }
}
