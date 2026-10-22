package com.bytedance.android.shopping.card_list.monitor.error;

import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class CardListRunCatchExtKt {
    public static final void a(String r100, String r101, Function0<Unit> r102) {
        Intrinsics.checkNotNullParameter(r101, "errorMonitorType");
        Intrinsics.checkNotNullParameter(r102, "task");
        b(r100, r101, r102, CardListRunCatchExtKt$cardListRunCatch$1.INSTANCE);
    }

    public static final void b(String r100, String r101, Function0<Unit> r102, Function0<Unit> r103) {
        Intrinsics.checkNotNullParameter(r101, "errorMonitorType");
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
        Map<String, a> r104 = a.f171685b;
        if (r100 != null) goto L11;
        r100 = "";
    L11:
        Intrinsics.checkNotNullParameter(r100, "id");
        a r105 = (a) ((LinkedHashMap) a.f171685b).get(r100);
        if (r105 == null) goto L14;
        r105.b(CardListErrorMonitorType.CRASH, "[errorMonitorType" + r101 + "]:" + th.getMessage(), null);
    L14:
        ECExceptionMonitor.f(th, "card_List-KIT-" + CardListErrorMonitorType.CRASH.getValue());
        r103.invoke();
    }
}
