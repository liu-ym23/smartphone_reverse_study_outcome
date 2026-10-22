package com.stepos.ability.calltool.handler;

import O3.d;
import android.content.Context;
import android.util.Log;
import androidx.core.app.NotificationCompat;
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
public final class a implements ICallToolHandler {

    /* renamed from: a, reason: collision with root package name */
    public final Context f3072a;
    public final IReportManager b;

    public a(Context context, IReportManager iReportManager) {
        k.f(context, "context");
        k.f(iReportManager, "iReportManager");
        this.f3072a = context;
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

    public static M3.b f(LinkedHashMap linkedHashMap) {
        LinkedHashMap linkedHashMapA = N3.a.a(linkedHashMap.get("_meta"));
        if (!linkedHashMap.containsKey("success") || (!linkedHashMap.containsKey("code") && !linkedHashMap.containsKey("message"))) {
            return new M3.b(0, null, linkedHashMap, linkedHashMapA);
        }
        Object obj = linkedHashMap.get("code");
        Integer num = obj instanceof Integer ? (Integer) obj : null;
        int iIntValue = num != null ? num.intValue() : 0;
        Object obj2 = linkedHashMap.get("message");
        return new M3.b(iIntValue, obj2 instanceof String ? (String) obj2 : null, linkedHashMap.get(SettingsConfig.KEY_DATA), linkedHashMapA);
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
            if (M3.a.y(th)) {
                Integer numValueOf2 = Integer.valueOf(M3.a.c(th).getErrorCode());
                String strValueOf = String.valueOf(M3.a.c(th).getErrorCategory());
                String errorMessage = M3.a.c(th).getErrorMessage();
                triple = new Triple(numValueOf2, strValueOf, errorMessage != null ? errorMessage : "UNKNOWN");
            } else if (th instanceof FunctionCallException) {
                FunctionCallException functionCallException = (FunctionCallException) th;
                int i = functionCallException.f3068a;
                Integer numValueOf3 = Integer.valueOf(i);
                String strValueOf2 = String.valueOf(i);
                String str7 = functionCallException.b;
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
        this.b.reportLogEvent(new LogEvent(str3, str4, LogEventType.END_CALL, LogLevel.ERROR, androidx.constraintlayout.core.dsl.a.c(iIntValue, "AppFunctionsCallToolHandler, errorCode=", " errorMsg=", str9), S0.b.p1(th), null, 500, 64, null));
        return FunctionCallResult.Companion.error$default(FunctionCallResult.INSTANCE, iIntValue, str9, null, null, map == null ? kotlin.collections.a.R(new Pair("errCode", str8), new Pair(NotificationCompat.CATEGORY_SERVICE, str), new Pair(GuiTaskProgressKt.GuiTaskProgress_KEY_METHOD, str2)) : map, 12, null);
    }

    public final FunctionCallResult d(String str, String str2, String str3, String str4, String str5) {
        Log.i("AppFunctionsCallToolHandler", "notFoundResult errorMsg: " + str3);
        this.b.reportLogEvent(new LogEvent(str4, str5, LogEventType.END_CALL, LogLevel.ERROR, "AppFunctionsCallToolHandler, errorCode=20004 errorMsg=未找到对应原子能力", null, null, 500, 96, null));
        return FunctionCallResult.Companion.error$default(FunctionCallResult.INSTANCE, 20004, "未找到对应原子能力", null, null, kotlin.collections.a.R(new Pair("errCode", "ABILITY_NOT_FOUND"), new Pair(NotificationCompat.CATEGORY_SERVICE, str), new Pair(GuiTaskProgressKt.GuiTaskProgress_KEY_METHOD, str2)), 12, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object e(com.stepos.ability.api.ability.calltool.CallToolRequest r8, java.lang.String r9, java.lang.String r10, kotlin.coroutines.jvm.internal.ContinuationImpl r11) {
        /*
            r7 = this;
            boolean r0 = r11 instanceof com.stepos.ability.calltool.handler.AppFunctionsCallToolHandler$resolveEntry$1
            if (r0 == 0) goto L13
            r0 = r11
            com.stepos.ability.calltool.handler.AppFunctionsCallToolHandler$resolveEntry$1 r0 = (com.stepos.ability.calltool.handler.AppFunctionsCallToolHandler$resolveEntry$1) r0
            int r1 = r0.e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.e = r1
            goto L18
        L13:
            com.stepos.ability.calltool.handler.AppFunctionsCallToolHandler$resolveEntry$1 r0 = new com.stepos.ability.calltool.handler.AppFunctionsCallToolHandler$resolveEntry$1
            r0.<init>(r7, r11)
        L18:
            java.lang.Object r11 = r0.c
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r2 = r0.e
            java.lang.String r3 = " functionId="
            java.lang.String r4 = "AppFunctionsCallToolHandler"
            r5 = 0
            r6 = 1
            if (r2 == 0) goto L38
            if (r2 != r6) goto L30
            java.lang.String r10 = r0.b
            java.lang.String r9 = r0.f3066a
            kotlin.b.b(r11)
            goto L96
        L30:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L38:
            kotlin.b.b(r11)
            com.stepos.ability.appfunctions.ExecutionExtra r11 = com.stepos.ability.appfunctions.ExecutionExtra.INSTANCE
            java.util.Map r8 = r8.getExtra()
            com.stepos.ability.appfunctions.DirectAppFunctions$Entry r8 = r11.entryFromExtra(r8, r9, r10)
            if (r8 == 0) goto L6e
            java.lang.String r11 = r8.getResponseTypeRef()
            if (r11 == 0) goto L53
            boolean r11 = j9.m.s0(r11)
            if (r11 == 0) goto L54
        L53:
            r8 = r5
        L54:
            if (r8 == 0) goto L6e
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r11 = "resolveEntry from extra pkg="
            r7.<init>(r11)
            r7.append(r9)
            r7.append(r3)
            r7.append(r10)
            java.lang.String r7 = r7.toString()
            android.util.Log.i(r4, r7)
            return r8
        L6e:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            java.lang.String r11 = "resolveEntry fallback scan pkg="
            r8.<init>(r11)
            r8.append(r9)
            r8.append(r3)
            r8.append(r10)
            java.lang.String r8 = r8.toString()
            android.util.Log.i(r4, r8)
            com.stepos.ability.appfunctions.DirectAppFunctions r8 = com.stepos.ability.appfunctions.DirectAppFunctions.INSTANCE
            r0.f3066a = r9
            r0.b = r10
            r0.e = r6
            android.content.Context r7 = r7.f3072a
            java.lang.Object r11 = r8.scan(r7, r9, r0)
            if (r11 != r1) goto L96
            return r1
        L96:
            java.lang.Iterable r11 = (java.lang.Iterable) r11
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            java.util.Iterator r8 = r11.iterator()
        La1:
            boolean r11 = r8.hasNext()
            if (r11 == 0) goto Lcb
            java.lang.Object r11 = r8.next()
            r0 = r11
            com.stepos.ability.appfunctions.DirectAppFunctions$Entry r0 = (com.stepos.ability.appfunctions.DirectAppFunctions.Entry) r0
            boolean r1 = r0.getEnabledByDefault()
            if (r1 != 0) goto Lc1
            java.lang.String r1 = r0.getPkg()
            java.lang.String r2 = r0.getFunctionId()
            java.lang.String r6 = "AppFunction not enabledByDefault pkg="
            androidx.constraintlayout.core.dsl.a.x(r6, r1, r3, r2, r4)
        Lc1:
            boolean r0 = r0.getEnabledByDefault()
            if (r0 == 0) goto La1
            r7.add(r11)
            goto La1
        Lcb:
            java.util.Iterator r7 = r7.iterator()
        Lcf:
            boolean r8 = r7.hasNext()
            if (r8 == 0) goto Lf1
            java.lang.Object r8 = r7.next()
            r11 = r8
            com.stepos.ability.appfunctions.DirectAppFunctions$Entry r11 = (com.stepos.ability.appfunctions.DirectAppFunctions.Entry) r11
            java.lang.String r0 = r11.getPkg()
            boolean r0 = kotlin.jvm.internal.k.b(r0, r9)
            if (r0 == 0) goto Lcf
            java.lang.String r11 = r11.getFunctionId()
            boolean r11 = kotlin.jvm.internal.k.b(r11, r10)
            if (r11 == 0) goto Lcf
            return r8
        Lf1:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ability.calltool.handler.a.e(com.stepos.ability.api.ability.calltool.CallToolRequest, java.lang.String, java.lang.String, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:117:0x02f7 A[Catch: all -> 0x028c, TRY_LEAVE, TryCatch #7 {all -> 0x028c, blocks: (B:107:0x0287, B:116:0x029b, B:117:0x02f7), top: B:147:0x0204 }] */
    /* JADX WARN: Removed duplicated region for block: B:145:0x0111 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:160:0x0206 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:167:0x0195 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00f5 A[Catch: all -> 0x00db, Exception -> 0x00de, TRY_LEAVE, TryCatch #11 {Exception -> 0x00de, blocks: (B:32:0x00d0, B:43:0x00e2, B:45:0x00f5), top: B:154:0x00d0, outer: #15 }] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x01c0  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
    /* JADX WARN: Type inference failed for: r10v0 */
    /* JADX WARN: Type inference failed for: r10v15 */
    /* JADX WARN: Type inference failed for: r10v16 */
    /* JADX WARN: Type inference failed for: r10v18 */
    /* JADX WARN: Type inference failed for: r10v19 */
    /* JADX WARN: Type inference failed for: r10v20 */
    /* JADX WARN: Type inference failed for: r10v23 */
    /* JADX WARN: Type inference failed for: r10v29 */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v19, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v26 */
    /* JADX WARN: Type inference failed for: r9v10 */
    /* JADX WARN: Type inference failed for: r9v11, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r9v33 */
    /* JADX WARN: Type inference failed for: r9v34 */
    /* JADX WARN: Type inference failed for: r9v35 */
    @Override // com.stepos.ability.calltool.handler.ICallToolHandler
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object handle(com.stepos.ability.api.ability.calltool.CallToolRequest r31, S7.k r32, H7.c r33) {
        /*
            Method dump skipped, instructions count: 889
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ability.calltool.handler.a.handle(com.stepos.ability.api.ability.calltool.CallToolRequest, S7.k, H7.c):java.lang.Object");
    }
}
