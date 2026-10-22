package com.stepos.ability.mcpserver.endpoint;

import M.d;
import android.util.Log;
import androidx.autofill.HintConstants;
import com.stepos.ability.commoninternal.AgentCache;
import com.stepos.ability.commoninternal.Key;
import com.stepos.ability.mcpserver.model.BatchRequest;
import com.stepos.ability.mcpserver.model.BatchResult;
import com.stepos.ability.mcpserver.model.BatchTask;
import com.stepos.ability.mcpserver.model.ExecutionPlan;
import com.stepos.ability.mcpserver.model.McpErrorCode;
import com.stepos.ability.mcpserver.model.McpRequest;
import com.stepos.ability.mcpserver.model.McpResponse;
import com.stepos.ability.mcpserver.model.McpSession;
import com.stepos.ability.mcpserver.model.TaskResult;
import com.stepos.ability.mcpserver.model.ToolDescription;
import com.stepos.ability.mcpserver.model.ToolSearchResult;
import com.stepos.ability.mcpserver.security.RateLimiter$buckets$1;
import com.stepos.taskrobot.llmapi.stepfun.InjectExperienceResult;
import f4.C1434a;
import i4.C1554b;
import j4.C1596a;
import j4.C1598c;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import k4.u;
import k4.v;
import k4.w;
import kotlin.Pair;
import kotlin.collections.EmptyList;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.internal.k;
import m9.AbstractC1683A;
import stepai.android.llm.base.twoway.FlowType;

/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final com.stepos.ability.mcpserver.search.b f3178a;
    public final com.stepos.ability.mcpserver.describe.a b;
    public final com.stepos.ability.mcpserver.executor.b c;
    public final C1434a d;
    public final com.stepos.ability.mcpserver.executor.a e;
    public final b f;
    public final C1554b g;
    public final w h;

    public a(com.stepos.ability.mcpserver.search.b searchEngine, com.stepos.ability.mcpserver.describe.a describeEngine, com.stepos.ability.mcpserver.executor.b toolBridge, C1434a dagScheduler, com.stepos.ability.mcpserver.executor.a batchExecutor, b sessionManager, C1554b monitor, w rateLimiter) {
        k.f(searchEngine, "searchEngine");
        k.f(describeEngine, "describeEngine");
        k.f(toolBridge, "toolBridge");
        k.f(dagScheduler, "dagScheduler");
        k.f(batchExecutor, "batchExecutor");
        k.f(sessionManager, "sessionManager");
        k.f(monitor, "monitor");
        k.f(rateLimiter, "rateLimiter");
        this.f3178a = searchEngine;
        this.b = describeEngine;
        this.c = toolBridge;
        this.d = dagScheduler;
        this.e = batchExecutor;
        this.f = sessionManager;
        this.g = monitor;
        this.h = rateLimiter;
    }

    public final McpResponse a(McpRequest mcpRequest, McpSession mcpSession, u uVar, String callerKey) {
        Object next;
        boolean z10;
        v vVar;
        Map<String, Object> params = mcpRequest.getParams();
        if (params == null) {
            return McpResponse.Companion.error$default(McpResponse.INSTANCE, mcpRequest.getId(), -32602, "Missing params", null, 8, null);
        }
        Object obj = params.get("tasks");
        List list = obj instanceof List ? (List) obj : null;
        if (list == null) {
            return McpResponse.Companion.error$default(McpResponse.INSTANCE, mcpRequest.getId(), -32602, "Missing 'tasks'", null, 8, null);
        }
        List<Map> list2 = list;
        ArrayList arrayList = new ArrayList(D7.w.c0(list2, 10));
        for (Map map : list2) {
            Object obj2 = map.get("id");
            String string = obj2 instanceof String ? (String) obj2 : null;
            if (string == null) {
                string = UUID.randomUUID().toString();
                k.e(string, "toString(...)");
            }
            Object obj3 = map.get(AgentCache.AGENT_CACHE_TASK_TYPE_TOOL);
            String str = obj3 instanceof String ? (String) obj3 : null;
            if (str == null) {
                return McpResponse.Companion.error$default(McpResponse.INSTANCE, mcpRequest.getId(), -32602, "Task missing 'tool'", null, 8, null);
            }
            Object obj4 = map.get("params");
            Map mapM = obj4 instanceof Map ? (Map) obj4 : null;
            if (mapM == null) {
                mapM = kotlin.collections.a.M();
            }
            Object obj5 = map.get("depends_on");
            arrayList.add(new BatchTask(string, str, mapM, obj5 instanceof List ? (List) obj5 : null));
        }
        Iterator it = arrayList.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (!uVar.a(((BatchTask) next).getTool())) {
                break;
            }
        }
        BatchTask batchTask = (BatchTask) next;
        if (batchTask != null) {
            androidx.constraintlayout.core.dsl.a.w("Out of scope in batch: ", batchTask.getTool(), "JsonRpcRouter");
            return McpResponse.Companion.error$default(McpResponse.INSTANCE, mcpRequest.getId(), 403, B7.a.k("Tool out of caller scope: ", batchTask.getTool()), null, 8, null);
        }
        Object obj6 = params.get(Key.KEY_TIMEOUT_MS);
        Number number = obj6 instanceof Number ? (Number) obj6 : null;
        try {
            ExecutionPlan executionPlanA = this.d.a(new BatchRequest(arrayList, number != null ? Long.valueOf(number.longValue()) : null));
            w wVar = this.h;
            int size = arrayList.size() - 1;
            long jCurrentTimeMillis = System.currentTimeMillis();
            wVar.getClass();
            k.f(callerKey, "callerKey");
            if (size > 0) {
                double rateLimitBurst = wVar.f4817a.getRateLimitBurst();
                synchronized (wVar.b) {
                    try {
                        RateLimiter$buckets$1 rateLimiter$buckets$1 = wVar.b;
                        Object vVar2 = rateLimiter$buckets$1.get(callerKey);
                        if (vVar2 == null) {
                            vVar2 = new v(rateLimitBurst, jCurrentTimeMillis);
                            rateLimiter$buckets$1.put(callerKey, vVar2);
                        }
                        vVar = (v) vVar2;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                synchronized (vVar) {
                    long j5 = jCurrentTimeMillis - vVar.b;
                    if (j5 < 0) {
                        j5 = 0;
                    }
                    double dMin = Math.min(rateLimitBurst, ((wVar.f4817a.getRateLimitPerMinute() / 60000.0d) * j5) + vVar.f4816a);
                    vVar.b = jCurrentTimeMillis;
                    vVar.f4816a = dMin - size;
                }
            }
            BatchResult batchResult = (BatchResult) AbstractC1683A.r(EmptyCoroutineContext.f4908a, new JsonRpcRouter$handleToolsBatch$batchResult$1(this, executionPlanA, mcpSession, null));
            McpResponse.Companion companion = McpResponse.INSTANCE;
            Object id = mcpRequest.getId();
            Collection<TaskResult> collectionValues = batchResult.getTaskResults().values();
            if ((collectionValues instanceof Collection) && collectionValues.isEmpty()) {
                z10 = true;
            } else {
                Iterator<T> it2 = collectionValues.iterator();
                while (it2.hasNext()) {
                    if (!((TaskResult) it2.next()).getSuccess()) {
                        z10 = false;
                        break;
                    }
                }
                z10 = true;
            }
            Pair pair = new Pair("success", Boolean.valueOf(z10));
            Map<String, TaskResult> taskResults = batchResult.getTaskResults();
            LinkedHashMap linkedHashMap = new LinkedHashMap(kotlin.collections.a.P(taskResults.size()));
            Iterator<T> it3 = taskResults.entrySet().iterator();
            while (it3.hasNext()) {
                Map.Entry entry = (Map.Entry) it3.next();
                Object key = entry.getKey();
                TaskResult taskResult = (TaskResult) entry.getValue();
                linkedHashMap.put(key, kotlin.collections.a.R(new Pair("status", taskResult.getSuccess() ? "success" : FlowType.FAILED), new Pair("result", taskResult.getResult()), new Pair("error", taskResult.getErrorMsg())));
            }
            return companion.success(id, kotlin.collections.a.R(pair, new Pair("tasks", linkedHashMap), new Pair("metrics", kotlin.collections.a.R(new Pair("total_time_ms", Long.valueOf(batchResult.getMetrics().getTotalTimeMs())), new Pair("success_count", Integer.valueOf(batchResult.getMetrics().getSuccessCount())), new Pair("failed_count", Integer.valueOf(batchResult.getMetrics().getFailedCount())))), new Pair("request_id", batchResult.getRequestId())));
        } catch (IllegalArgumentException e) {
            McpResponse.Companion companion2 = McpResponse.INSTANCE;
            Object id2 = mcpRequest.getId();
            String message = e.getMessage();
            if (message == null) {
                message = "Invalid batch";
            }
            return McpResponse.Companion.error$default(companion2, id2, -32602, message, null, 8, null);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:134:0x0294  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x0300  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x0335  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x0340  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x01a4  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x01b8  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x01c3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.stepos.ability.mcpserver.model.McpResponse b(com.stepos.ability.mcpserver.model.McpRequest r25, com.stepos.ability.mcpserver.model.McpSession r26, k4.u r27) {
        /*
            Method dump skipped, instructions count: 963
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ability.mcpserver.endpoint.a.b(com.stepos.ability.mcpserver.model.McpRequest, com.stepos.ability.mcpserver.model.McpSession, k4.u):com.stepos.ability.mcpserver.model.McpResponse");
    }

    public final McpResponse c(McpRequest mcpRequest, u uVar) {
        Map<String, Object> params = mcpRequest.getParams();
        if (params == null) {
            return McpResponse.Companion.error$default(McpResponse.INSTANCE, mcpRequest.getId(), -32602, "Missing params", null, 8, null);
        }
        Object obj = params.get(HintConstants.AUTOFILL_HINT_NAME);
        String str = obj instanceof String ? (String) obj : null;
        if (str == null) {
            return McpResponse.Companion.error$default(McpResponse.INSTANCE, mcpRequest.getId(), -32602, "Missing 'name'", null, 8, null);
        }
        if (uVar.a(str)) {
            ToolDescription toolDescription = (ToolDescription) AbstractC1683A.r(EmptyCoroutineContext.f4908a, new JsonRpcRouter$handleToolsDescribe$desc$1(this, str, null));
            return toolDescription == null ? McpResponse.Companion.error$default(McpResponse.INSTANCE, mcpRequest.getId(), McpErrorCode.TOOL_NOT_FOUND, "Tool not found: ".concat(str), null, 8, null) : McpResponse.INSTANCE.success(mcpRequest.getId(), kotlin.collections.a.R(new Pair(HintConstants.AUTOFILL_HINT_NAME, toolDescription.getName()), new Pair("display_name", toolDescription.getDisplayName()), new Pair("description", toolDescription.getDescription()), new Pair("input_schema", toolDescription.getInputSchema()), new Pair("output_schema", toolDescription.getOutputSchema()), new Pair("permissions", toolDescription.getPermissions()), new Pair(InjectExperienceResult.REASON_TIMEOUT, Integer.valueOf(toolDescription.getTimeout())), new Pair("package_name", toolDescription.getPackageName()), new Pair("function_name", toolDescription.getFunctionName()), new Pair("call_type", toolDescription.getCallType()), new Pair("ability_id", Integer.valueOf(toolDescription.getAbilityId())), new Pair("extra", toolDescription.getExtra())));
        }
        Log.w("JsonRpcRouter", "Out of scope: ".concat(str));
        return McpResponse.Companion.error$default(McpResponse.INSTANCE, mcpRequest.getId(), 403, "Tool out of caller scope: ".concat(str), null, 8, null);
    }

    public final McpResponse d(McpRequest mcpRequest, u uVar) {
        Iterable iterable = (Iterable) AbstractC1683A.r(EmptyCoroutineContext.f4908a, new JsonRpcRouter$handleToolsList$tools$1(this, null));
        ArrayList arrayList = new ArrayList();
        for (Object obj : iterable) {
            if (uVar.a(((ToolDescription) obj).getName())) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(D7.w.c0(arrayList, 10));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ToolDescription toolDescription = (ToolDescription) it.next();
            arrayList2.add(kotlin.collections.a.R(new Pair(HintConstants.AUTOFILL_HINT_NAME, toolDescription.getName()), new Pair("description", toolDescription.getDescription()), new Pair("inputSchema", toolDescription.getInputSchema()), new Pair("outputSchema", toolDescription.getOutputSchema()), new Pair("permissions", toolDescription.getPermissions()), new Pair(InjectExperienceResult.REASON_TIMEOUT, Integer.valueOf(toolDescription.getTimeout())), new Pair("packageName", toolDescription.getPackageName())));
        }
        return McpResponse.INSTANCE.success(mcpRequest.getId(), kotlin.collections.a.Q(new Pair("tools", arrayList2)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v0, types: [java.lang.Object, java.util.Map] */
    /* JADX WARN: Type inference failed for: r1v13, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r1v22, types: [kotlin.collections.EmptyList] */
    /* JADX WARN: Type inference failed for: r1v23 */
    /* JADX WARN: Type inference failed for: r1v29, types: [kotlin.collections.EmptyList] */
    /* JADX WARN: Type inference failed for: r5v10, types: [java.lang.Object, java.util.Map] */
    /* JADX WARN: Type inference failed for: r8v3, types: [java.lang.Object, java.util.Map] */
    /* JADX WARN: Type inference failed for: r9v0, types: [java.lang.Object, java.util.Map] */
    /* JADX WARN: Type inference failed for: r9v2, types: [java.lang.Object, java.util.Map] */
    public final McpResponse e(McpRequest mcpRequest, u uVar) {
        ?? arrayList;
        String str;
        Map<String, Object> params = mcpRequest.getParams();
        if (params == null) {
            return McpResponse.Companion.error$default(McpResponse.INSTANCE, mcpRequest.getId(), -32602, "Missing params", null, 8, null);
        }
        Object obj = params.get("query");
        String str2 = obj instanceof String ? (String) obj : null;
        if (str2 == null) {
            return McpResponse.Companion.error$default(McpResponse.INSTANCE, mcpRequest.getId(), -32602, "Missing 'query'", null, 8, null);
        }
        Object obj2 = params.get("top_k");
        Number number = obj2 instanceof Number ? (Number) obj2 : null;
        int iIntValue = number != null ? number.intValue() : 10;
        com.stepos.ability.mcpserver.search.b bVar = this.f3178a;
        bVar.getClass();
        C1598c c1598c = bVar.c;
        synchronized (c1598c) {
            if (c1598c.c == 0) {
                Log.w("BM25Index", "search: docCount=0, index empty");
                arrayList = EmptyList.f4893a;
            } else {
                ArrayList arrayListB = C1598c.b(str2);
                Log.d("BM25Index", "search: queryLen=" + str2.length() + " termCount=" + arrayListB.size() + " indexSize=" + c1598c.f4774a.size());
                if (arrayListB.isEmpty()) {
                    arrayList = EmptyList.f4893a;
                } else {
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    Iterator it = arrayListB.iterator();
                    int i = 0;
                    while (it.hasNext()) {
                        String str3 = (String) it.next();
                        List<C1596a> list = (List) c1598c.f4774a.get(str3);
                        if (list != null) {
                            i++;
                            Integer num = (Integer) c1598c.b.get(str3);
                            if (num != null) {
                                double dLog = Math.log((((c1598c.c - r7) + 0.5d) / (num.intValue() + 0.5d)) + 1.0d);
                                for (C1596a c1596a : list) {
                                    String str4 = c1596a.f4772a;
                                    int i6 = c1596a.b;
                                    double d = i6;
                                    LinkedHashMap linkedHashMap2 = linkedHashMap;
                                    double d6 = dLog;
                                    double dIntValue = (d6 * (2.5d * d)) / ((((((((Integer) c1598c.e.get(str4)) != null ? r12.intValue() : 1) * 0.75d) / c1598c.d) + 0.25d) * 1.5d) + d);
                                    Double d10 = (Double) linkedHashMap2.get(str4);
                                    linkedHashMap2.put(str4, Double.valueOf((d10 != null ? d10.doubleValue() : 0.0d) + dIntValue));
                                    linkedHashMap = linkedHashMap2;
                                    dLog = d6;
                                }
                            }
                            linkedHashMap = linkedHashMap;
                        }
                    }
                    LinkedHashMap linkedHashMap3 = linkedHashMap;
                    Log.d("BM25Index", "search: matchedTerms=" + i + " scoredDocs=" + linkedHashMap3.size());
                    List<Map.Entry> listA1 = D7.v.a1(D7.v.Z0(linkedHashMap3.entrySet(), new d(13)), iIntValue);
                    arrayList = new ArrayList(D7.w.c0(listA1, 10));
                    for (Map.Entry entry : listA1) {
                        arrayList.add(new Pair(entry.getKey(), Float.valueOf((float) ((Number) entry.getValue()).doubleValue())));
                    }
                }
            }
        }
        Iterable<Pair> iterable = (Iterable) arrayList;
        ArrayList arrayList2 = new ArrayList(D7.w.c0(iterable, 10));
        for (Pair pair : iterable) {
            String toolName = (String) pair.f4886a;
            float fFloatValue = ((Number) pair.b).floatValue();
            C1598c c1598c2 = bVar.c;
            c1598c2.getClass();
            k.f(toolName, "toolName");
            J3.a aVar = (J3.a) c1598c2.f.get(toolName);
            if (aVar == null || (str = aVar.e) == null) {
                str = "";
            }
            arrayList2.add(new ToolSearchResult(toolName, str, fFloatValue));
        }
        ArrayList arrayList3 = new ArrayList();
        Iterator it2 = arrayList2.iterator();
        while (it2.hasNext()) {
            Object next = it2.next();
            if (uVar.a(((ToolSearchResult) next).getName())) {
                arrayList3.add(next);
            }
        }
        McpResponse.Companion companion = McpResponse.INSTANCE;
        Object id = mcpRequest.getId();
        ArrayList arrayList4 = new ArrayList(D7.w.c0(arrayList3, 10));
        Iterator it3 = arrayList3.iterator();
        while (it3.hasNext()) {
            ToolSearchResult toolSearchResult = (ToolSearchResult) it3.next();
            arrayList4.add(kotlin.collections.a.R(new Pair(HintConstants.AUTOFILL_HINT_NAME, toolSearchResult.getName()), new Pair("description", toolSearchResult.getDescription()), new Pair("score", Float.valueOf(toolSearchResult.getScore()))));
        }
        return companion.success(id, arrayList4);
    }
}
