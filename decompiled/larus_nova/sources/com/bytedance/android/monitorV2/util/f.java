package com.bytedance.android.monitorV2.util;

import com.bytedance.android.monitorV2.InternalWatcher;
import com.ss.ttvideoengine.selector.strategy.GearStrategy;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes12.dex */
public final class f {
    public static void b(Throwable r100) {
        a("default_handle", r100);
    }

    public static void a(String r100, Throwable r101) {
        HashMap r102 = new HashMap();
        StringWriter r103 = new StringWriter();
        r101.printStackTrace(new PrintWriter(r103));
        r102.put("error_error_msg", r103.toString());
        r102.put(GearStrategy.GEAR_STRATEGY_KEY_ERROR_DESC, r100);
        Map<String, Map<String, String>> r104 = InternalWatcher.f162982a;
        InternalWatcher.a(null, "internal_error", r102, null);
        com.bytedance.android.monitorV2.g.e().getClass();
    }
}
