package com.bytedance.android.shopping.mall.homepage.jsb;

import android.content.res.Resources;
import android.view.View;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes13.dex */
public final class p {
    public static final int a(int r100) {
        Resources r101 = Resources.getSystem();
        return MathKt.roundToInt(r100 / WindowDisplayMetricsOverride.apply(r101, r101.getDisplayMetrics()).density);
    }

    public static final void b(Map<String, Object> r100, Function0<? extends View> r110) {
        Intrinsics.checkNotNullParameter(r100, "result");
        Intrinsics.checkNotNullParameter(r110, "tabViewProvider");
        HashMap r101 = new HashMap();
        r101.put("x", 0);
        r101.put("y", 0);
        r101.put("width", 0);
        r101.put("height", 0);
        Gson r102 = new Gson();
        View r111 = r110.invoke();     // Catch: Exception -> L8
        if (r111 == null) goto L6;
        int[] r103 = {0, 0};     // Catch: Exception -> L8
        r111.getLocationOnScreen(r103);     // Catch: Exception -> L8
        r101.put("x", Integer.valueOf(a(r103[0])));     // Catch: Exception -> L8
        r101.put("y", Integer.valueOf(a(r103[1])));     // Catch: Exception -> L8
        r101.put("width", Integer.valueOf(a(r111.getWidth())));     // Catch: Exception -> L8
        r101.put("height", Integer.valueOf(a(r111.getHeight())));     // Catch: Exception -> L8
    L6:
        r100.put("tabFrame", GsonProtectorUtils.toJson(r102, r101));
    }
}
