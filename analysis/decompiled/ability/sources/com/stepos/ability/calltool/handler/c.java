package com.stepos.ability.calltool.handler;

import O3.d;
import android.content.Context;
import android.util.Log;
import androidx.appfunctions.AppFunctionException;
import androidx.core.app.NotificationCompat;
import com.stepos.ability.appfunctions.JetpackAppFunctionExceptionExt;
import com.stepos.ability.beaninternal.ability.FunctionCallResult;
import com.stepos.ability.beaninternal.task.GuiTaskProgressKt;
import com.stepos.ability.common.AbilityException;
import com.stepos.ability.report.IReportManager;
import com.stepos.ability.report.event.LogEvent;
import com.stepos.ability.report.event.LogEventType;
import com.stepos.ability.report.event.LogLevel;
import com.stepos.taskrobot.settingsprovider.SettingsConfig;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.jvm.internal.k;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class c implements ICallToolHandler {

    /* renamed from: a, reason: collision with root package name */
    public final Context f3074a;
    public final IReportManager b;

    public c(Context context, IReportManager iReportManager) {
        k.f(context, "context");
        k.f(iReportManager, "iReportManager");
        this.f3074a = context;
        this.b = iReportManager;
    }

    public static LinkedHashMap b(JSONObject jSONObject) {
        LinkedHashMap linkedHashMap = new LinkedHashMap(jSONObject.length());
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            linkedHashMap.put(next, c(jSONObject.opt(next)));
        }
        return linkedHashMap;
    }

    public static Object c(Object obj) {
        if (obj == null || obj.equals(JSONObject.NULL)) {
            return null;
        }
        if (obj instanceof JSONObject) {
            return b((JSONObject) obj);
        }
        if (!(obj instanceof JSONArray)) {
            return obj;
        }
        JSONArray jSONArray = (JSONArray) obj;
        ArrayList arrayList = new ArrayList(jSONArray.length());
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            arrayList.add(c(jSONArray.opt(i)));
        }
        return arrayList;
    }

    public static M3.c f(LinkedHashMap linkedHashMap) {
        LinkedHashMap linkedHashMapA = N3.a.a(linkedHashMap.get("_meta"));
        if (!linkedHashMap.containsKey("success") || (!linkedHashMap.containsKey("code") && !linkedHashMap.containsKey("message"))) {
            return new M3.c(0, null, linkedHashMap, linkedHashMapA);
        }
        Object obj = linkedHashMap.get("code");
        Integer num = obj instanceof Integer ? (Integer) obj : null;
        int iIntValue = num != null ? num.intValue() : 0;
        Object obj2 = linkedHashMap.get("message");
        return new M3.c(iIntValue, obj2 instanceof String ? (String) obj2 : null, linkedHashMap.get(SettingsConfig.KEY_DATA), linkedHashMapA);
    }

    public final FunctionCallResult a(String str, String str2, Throwable th, String str3, String str4, Map map) {
        Triple triple;
        if (th instanceof AbilityException) {
            AbilityException abilityException = (AbilityException) th;
            d dVar = abilityException.f3075a;
            Integer numValueOf = Integer.valueOf(dVar.c);
            String str5 = dVar.f1034a;
            String str6 = abilityException.b;
            if (str6 == null) {
                str6 = dVar.b;
            }
            triple = new Triple(numValueOf, str5, str6);
        } else {
            if (th instanceof AppFunctionException) {
                JetpackAppFunctionExceptionExt jetpackAppFunctionExceptionExt = JetpackAppFunctionExceptionExt.INSTANCE;
                AppFunctionException appFunctionException = (AppFunctionException) th;
                Integer numValueOf2 = Integer.valueOf(jetpackAppFunctionExceptionExt.errorCode(appFunctionException));
                String strValueOf = String.valueOf(jetpackAppFunctionExceptionExt.errorCategory(appFunctionException));
                String errorMessage = appFunctionException.getErrorMessage();
                triple = new Triple(numValueOf2, strValueOf, errorMessage != null ? errorMessage : "UNKNOWN");
            } else if (th instanceof JetpackFunctionCallException) {
                JetpackFunctionCallException jetpackFunctionCallException = (JetpackFunctionCallException) th;
                int i = jetpackFunctionCallException.f3071a;
                Integer numValueOf3 = Integer.valueOf(i);
                String strValueOf2 = String.valueOf(i);
                String str7 = jetpackFunctionCallException.b;
                triple = new Triple(numValueOf3, strValueOf2, str7 != null ? str7 : "UNKNOWN");
            } else {
                String message = th.getMessage();
                if (message == null) {
                    message = "未知错误";
                }
                triple = new Triple(-1, "UNKNOWN", message);
            }
        }
        int iIntValue = ((Number) triple.f4891a).intValue();
        String str8 = (String) triple.b;
        String str9 = (String) triple.c;
        this.b.reportLogEvent(new LogEvent(str3, str4, LogEventType.END_CALL, LogLevel.ERROR, androidx.constraintlayout.core.dsl.a.c(iIntValue, "JetpackAppFunctionsCallToolHandler, errorCode=", " errorMsg=", str9), S0.b.p1(th), null, 500, 64, null));
        return FunctionCallResult.Companion.error$default(FunctionCallResult.INSTANCE, iIntValue, str9, null, null, map == null ? kotlin.collections.a.R(new Pair("errCode", str8), new Pair(NotificationCompat.CATEGORY_SERVICE, str), new Pair(GuiTaskProgressKt.GuiTaskProgress_KEY_METHOD, str2)) : map, 12, null);
    }

    public final FunctionCallResult d(String str, String str2, String str3, String str4, String str5) {
        Log.d("JetpackAppFunctionsCallToolHandler", "notFoundResult errorMsg: " + str3);
        this.b.reportLogEvent(new LogEvent(str4, str5, LogEventType.END_CALL, LogLevel.ERROR, "JetpackAppFunctionsCallToolHandler, errorCode=20004 errorMsg=未找到对应原子能力", null, null, 500, 96, null));
        return FunctionCallResult.Companion.error$default(FunctionCallResult.INSTANCE, 20004, "未找到对应原子能力", null, null, kotlin.collections.a.R(new Pair("errCode", "ABILITY_NOT_FOUND"), new Pair(NotificationCompat.CATEGORY_SERVICE, str), new Pair(GuiTaskProgressKt.GuiTaskProgress_KEY_METHOD, str2)), 12, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object e(com.stepos.ability.api.ability.calltool.CallToolRequest r6, java.lang.String r7, java.lang.String r8, kotlin.coroutines.jvm.internal.ContinuationImpl r9) {
        /*
            r5 = this;
            boolean r0 = r9 instanceof com.stepos.ability.calltool.handler.JetpackAppFunctionsCallToolHandler$resolveMetadata$1
            if (r0 == 0) goto L13
            r0 = r9
            com.stepos.ability.calltool.handler.JetpackAppFunctionsCallToolHandler$resolveMetadata$1 r0 = (com.stepos.ability.calltool.handler.JetpackAppFunctionsCallToolHandler$resolveMetadata$1) r0
            int r1 = r0.e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.e = r1
            goto L18
        L13:
            com.stepos.ability.calltool.handler.JetpackAppFunctionsCallToolHandler$resolveMetadata$1 r0 = new com.stepos.ability.calltool.handler.JetpackAppFunctionsCallToolHandler$resolveMetadata$1
            r0.<init>(r5, r9)
        L18:
            java.lang.Object r9 = r0.c
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r2 = r0.e
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            java.lang.String r8 = r0.b
            java.lang.String r7 = r0.f3070a
            kotlin.b.b(r9)
            goto L86
        L2b:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L33:
            kotlin.b.b(r9)
            com.stepos.ability.appfunctions.JetpackAppFunctionsExt r9 = com.stepos.ability.appfunctions.JetpackAppFunctionsExt.INSTANCE
            java.util.Map r6 = r6.getExtra()
            androidx.appfunctions.metadata.AppFunctionMetadata r6 = r9.metadataFromExtra(r6, r7, r8)
            java.lang.String r9 = " functionId="
            java.lang.String r2 = "JetpackAppFunctionsCallToolHandler"
            if (r6 == 0) goto L5e
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r0 = "resolveMetadata from extra pkg="
            r5.<init>(r0)
            r5.append(r7)
            r5.append(r9)
            r5.append(r8)
            java.lang.String r5 = r5.toString()
            android.util.Log.i(r2, r5)
            return r6
        L5e:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            java.lang.String r4 = "resolveMetadata fallback scan pkg="
            r6.<init>(r4)
            r6.append(r7)
            r6.append(r9)
            r6.append(r8)
            java.lang.String r6 = r6.toString()
            android.util.Log.i(r2, r6)
            com.stepos.ability.appfunctions.JetpackAppFunctions r6 = com.stepos.ability.appfunctions.JetpackAppFunctions.INSTANCE
            r0.f3070a = r7
            r0.b = r8
            r0.e = r3
            android.content.Context r5 = r5.f3074a
            java.lang.Object r9 = r6.scan(r5, r7, r0)
            if (r9 != r1) goto L86
            return r1
        L86:
            java.lang.Iterable r9 = (java.lang.Iterable) r9
            D7.t r5 = D7.v.s0(r9)
            Ba.f r6 = new Ba.f
            r9 = 18
            r6.<init>(r9)
            i9.f r5 = kotlin.sequences.a.f0(r5, r6)
            i9.e r6 = new i9.e
            r6.<init>(r5)
        L9c:
            boolean r5 = r6.hasNext()
            if (r5 == 0) goto Lbe
            java.lang.Object r5 = r6.next()
            r9 = r5
            androidx.appfunctions.metadata.AppFunctionMetadata r9 = (androidx.appfunctions.metadata.AppFunctionMetadata) r9
            java.lang.String r0 = r9.getPackageName()
            boolean r0 = kotlin.jvm.internal.k.b(r0, r7)
            if (r0 == 0) goto L9c
            java.lang.String r9 = r9.getId()
            boolean r9 = kotlin.jvm.internal.k.b(r9, r8)
            if (r9 == 0) goto L9c
            return r5
        Lbe:
            r5 = 0
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ability.calltool.handler.c.e(com.stepos.ability.api.ability.calltool.CallToolRequest, java.lang.String, java.lang.String, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:104:0x02a8 A[Catch: all -> 0x0238, TRY_LEAVE, TryCatch #8 {all -> 0x0238, blocks: (B:88:0x01d6, B:90:0x01dc, B:92:0x020a, B:94:0x0233, B:97:0x023d, B:103:0x0253, B:104:0x02a8), top: B:126:0x01d6 }] */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0187 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00e8 A[Catch: all -> 0x00cf, Exception -> 0x00d1, TRY_LEAVE, TryCatch #2 {Exception -> 0x00d1, blocks: (B:31:0x00c4, B:42:0x00d5, B:44:0x00e8), top: B:116:0x00c4, outer: #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0104 A[Catch: all -> 0x011d, TRY_LEAVE, TryCatch #12 {all -> 0x011d, blocks: (B:29:0x00be, B:47:0x00f6, B:49:0x0104), top: B:133:0x00be }] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0121 A[Catch: all -> 0x0117, TRY_LEAVE, TryCatch #7 {all -> 0x0117, blocks: (B:51:0x0112, B:57:0x0121, B:68:0x0143), top: B:125:0x0102 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0021  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x01b4 A[Catch: all -> 0x02e2, TRY_ENTER, TRY_LEAVE, TryCatch #0 {all -> 0x02e2, blocks: (B:72:0x0183, B:82:0x01b4), top: B:112:0x0183 }] */
    /* JADX WARN: Removed duplicated region for block: B:90:0x01dc A[Catch: all -> 0x0238, TryCatch #8 {all -> 0x0238, blocks: (B:88:0x01d6, B:90:0x01dc, B:92:0x020a, B:94:0x0233, B:97:0x023d, B:103:0x0253, B:104:0x02a8), top: B:126:0x01d6 }] */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4, types: [int] */
    /* JADX WARN: Type inference failed for: r2v5, types: [java.lang.String] */
    @Override // com.stepos.ability.calltool.handler.ICallToolHandler
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object handle(com.stepos.ability.api.ability.calltool.CallToolRequest r28, S7.k r29, H7.c r30) {
        /*
            Method dump skipped, instructions count: 779
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ability.calltool.handler.c.handle(com.stepos.ability.api.ability.calltool.CallToolRequest, S7.k, H7.c):java.lang.Object");
    }
}
