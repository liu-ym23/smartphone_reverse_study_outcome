package com.bytedance.android.gamecp.common.utils;

import java.util.LinkedHashMap;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
public final class GameCPSafeConvertUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f57158a = 0;

    static {
    }

    public static Boolean b(final Object r100) {
        return (Boolean) a(r100, "toSafeBoolean", new GameCPSafeConvertUtils$toSafeBoolean$1(r100));
    }

    public static Float c(final Object r100) {
        return (Float) a(r100, "toSafeFloat", new GameCPSafeConvertUtils$toSafeFloat$1(r100));
    }

    public static Integer d(final Object r100) {
        return (Integer) a(r100, "toSafeInt", new GameCPSafeConvertUtils$toSafeInt$1(r100));
    }

    public static String e(final Object r100) {
        return (String) a(r100, "toSafeString", new GameCPSafeConvertUtils$toSafeString$1(r100));
    }

    public static Object a(Object r110, String r111, Function0 r112) {
        if (r110 == null) goto L32;
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L5
        return r112.invoke();
    L5:
        th = move-exception;
        Result.Companion r101 = Result.Companion;
        Throwable r113 = Result.m9452exceptionOrNullimpl(Result.m9449constructorimpl(ResultKt.createFailure(th)));
        if (r113 != null) goto L26;
        return null;
    L26:
        StringBuilder r102 = new StringBuilder();     // Catch: Throwable -> L20
        r102.append(r113.toString() + "\n");     // Catch: Throwable -> L20
        StackTraceElement[] r114 = r113.getStackTrace();     // Catch: Throwable -> L20
        int r103 = r114.length;     // Catch: Throwable -> L20
        int r104 = 0;
        int r105 = 0;
    L10:
        if (r104 >= r103) goto L18;
        StackTraceElement r106 = r114[r104];     // Catch: Throwable -> L20
        int r115 = r105 + 1;     // Catch: Throwable -> L20
        if (3 <= r105) goto L15;
    L17:
        r104 = r104 + 1;     // Catch: Throwable -> L20
        r105 = r115;
        goto L10
    L15:
        if (20 < r105) goto L17;
        r102.append(r106.toString() + "\n");     // Catch: Throwable -> L20
        goto L17
    L18:
        String r116 = r102.toString();     // Catch: Throwable -> L20
        LinkedHashMap r107 = new LinkedHashMap();     // Catch: Throwable -> L20
        r107.put("origin_value", String.valueOf(r110));     // Catch: Throwable -> L20
        r107.put("type", r111);     // Catch: Throwable -> L20
        r107.put("stack_trace", r116);     // Catch: Throwable -> L20
        com.bytedance.android.gamecp.host_api.a.b().getLogService().logV3("dygame_tech_type_convert_error", r107);     // Catch: Throwable -> L20
        bw.k r108 = com.bytedance.android.gamecp.host_api.a.b().getHostMonitorService();     // Catch: Throwable -> L20
        JSONObject r109 = new JSONObject();     // Catch: Throwable -> L20
        r109.put("type", r111);     // Catch: Throwable -> L20
        Unit r117 = Unit.INSTANCE;     // Catch: Throwable -> L20
        JSONObject r118 = new JSONObject();     // Catch: Throwable -> L20
        r118.put("origin_value", String.valueOf(r110));     // Catch: Throwable -> L20
        JSONObject r119 = new JSONObject();     // Catch: Throwable -> L20
        r119.put("stack_trace", r116);     // Catch: Throwable -> L20
        r108.monitorEvent("dygame_tech_type_convert_error", r109, r118, r119);     // Catch: Throwable -> L20
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L20
        return null;
    L20:
        th = move-exception;
        Result.Companion r120 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        return null;
    L32:
        return null;
    }
}
