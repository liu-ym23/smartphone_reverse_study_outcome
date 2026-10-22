package com.bytedance.android.live.core.utils;

import com.android.ttcjpaysdk.base.theme.CJPayColorConstants;
import com.bytedance.ee.bear.document.customheader.CustomHeaderConfig;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.ss.android.bytedcert.config.ThemeConfig;
import java.util.HashMap;

/* JADX INFO: loaded from: classes45.dex */
public final class u {
    public static HashMap<String, Object> a() {
        HashMap<String, Object> r100 = new HashMap();
        if (fm3.d.b() == false) goto L5;
        r100.put(ThemeConfig.PROGRESS_BG_COLOR, Integer.valueOf(ColorProtector.parseColor("#14FFFFFF")));
        r100.put(ThemeConfig.PROGRESS_COLOR, Integer.valueOf(ColorProtector.parseColor(CJPayColorConstants.CJ_PAY_STROKE_RED)));
        r100.put(ThemeConfig.TEXT_COLOR, Integer.valueOf(ColorProtector.parseColor("#161823")));
        r100.put(ThemeConfig.SCREEN_COLOR, Integer.valueOf(ColorProtector.parseColor(CustomHeaderConfig.COLOR_LIGHT)));
    L6:
        return r100;
    L5:
        r100.put(ThemeConfig.PROGRESS_BG_COLOR, Integer.valueOf(ColorProtector.parseColor("#1E161823")));
        r100.put(ThemeConfig.PROGRESS_COLOR, Integer.valueOf(ColorProtector.parseColor(CJPayColorConstants.CJ_PAY_STROKE_RED)));
        r100.put(ThemeConfig.TEXT_COLOR, Integer.valueOf(ColorProtector.parseColor("#E6FFFFFF")));
        r100.put(ThemeConfig.SCREEN_COLOR, Integer.valueOf(ColorProtector.parseColor("#161823")));
        goto L6
    }
}
