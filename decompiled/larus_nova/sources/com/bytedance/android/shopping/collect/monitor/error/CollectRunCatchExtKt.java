package com.bytedance.android.shopping.collect.monitor.error;

import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public final class CollectRunCatchExtKt {
    public static final void a(String r100, String r101, Function0<Unit> r102) {
        Intrinsics.checkNotNullParameter(r101, "errorTag");
        Intrinsics.checkNotNullParameter(r102, "task");
        CollectRunCatchExtKt$collectRunCatch$1 r103 = CollectRunCatchExtKt$collectRunCatch$1.INSTANCE;
        Intrinsics.checkNotNullParameter(r101, "errorTag");
        Intrinsics.checkNotNullParameter(r102, "task");
        Intrinsics.checkNotNullParameter(r103, "errorCatchTask");
        if (ECAppInfoService.f48114e.i() == false) goto L16;
        r102.invoke();
        return;
    L16:
        r102.invoke();     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        Map<String, a> r104 = a.f172238b;
        if (r100 != null) goto L11;
        r100 = "";
    L11:
        Intrinsics.checkNotNullParameter(r100, "id");
        a r105 = (a) ((LinkedHashMap) a.f172238b).get(r100);
        if (r105 != null) goto L14;
        JSONObject r106 = new JSONObject();
        r106.put(com.bytedance.android.ec.core.event.a.KEY_EVENT_ORIGIN_FEATURE, com.bytedance.android.ec.core.event.a.VALUE_TEMAI);
        r106.put("EVENT_PAGE_TECHNOLOGY", "YATA_Android");
        Unit r107 = Unit.INSTANCE;
        r105 = new a(r106);
    L14:
        r105.b(CollectErrorMonitorType.CRASH, "【" + r101 + "】: " + th.getMessage(), null);
        ECExceptionMonitor.f(th, "collect组件化-".concat(r101));
        r103.invoke();
    }
}
