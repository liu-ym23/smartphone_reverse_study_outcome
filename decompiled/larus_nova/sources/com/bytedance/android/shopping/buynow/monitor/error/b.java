package com.bytedance.android.shopping.buynow.monitor.error;

import com.bytedance.android.ec.sdk.helper.g;
import com.bytedance.android.shopping.buynow.tracker.BuyNowLog;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f170996a = 0;

    static {
    }

    public static void a(com.bytedance.android.shopping.buynow.tracker.a r100, String r101, String r102, Map r103) {
        Intrinsics.checkNotNullParameter(r101, "errorType");
        Intrinsics.checkNotNullParameter(r103, "extraParams");
        Lazy r104 = BuyNowLog.f171168a;
        BuyNowLog.c("BuyNowErrorUtils", "logForError errorType = " + r101 + ", errorMsg is " + r102);
        JSONObject r105 = new JSONObject();
        if (r100 == null) goto L8;
        Iterator<Map.Entry<String, Object>> r106 = r100.d().entrySet().iterator();
    L6:
        if (r106.hasNext() == false) goto L8;
        Map.Entry<String, Object> r107 = r106.next();
        r105.put(r107.getKey(), r107.getValue());
    L8:
        Iterator r108 = r103.entrySet().iterator();
    L10:
        if (r108.hasNext() == false) goto L13;
        Map.Entry r109 = (Map.Entry) r108.next();
        r105.put((String) r109.getKey(), r109.getValue());
        goto L10
    L13:
        if (r100 == null) goto L21;
        LinkedHashMap r110 = new LinkedHashMap();
        r110.put("error_type", r101);
        r110.put("error_msg", r102);
        r110.put("extra", r105);
        Unit r111 = Unit.INSTANCE;
        r100.b("buynow_error_monitor", r110);
        return;
    L21:
        Result.Companion r112 = Result.Companion;     // Catch: Throwable -> L17
        g r113 = g.f48122a;     // Catch: Throwable -> L17
        JSONObject r114 = new JSONObject();     // Catch: Throwable -> L17
        r114.put("error_type", r101);     // Catch: Throwable -> L17
        r114.put("error_msg", r102);     // Catch: Throwable -> L17
        r114.put("extra", r105);     // Catch: Throwable -> L17
        Unit r115 = Unit.INSTANCE;     // Catch: Throwable -> L17
        r113.logV3("buynow_error_monitor", r114);     // Catch: Throwable -> L17
        Object r116 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L17
    L19:
        Result.m9448boximpl(r116);
        return;
    L17:
        th = move-exception;
        Result.Companion r117 = Result.Companion;
        r116 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L19
    }
}
