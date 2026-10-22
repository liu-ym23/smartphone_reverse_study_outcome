package com.bytedance.apm.agent.tracing;

import com.bytedance.apm.agent.logging.AgentLog;
import com.bytedance.apm.agent.logging.AgentLogManager;
import com.bytedance.apm.util.u;
import java.util.HashSet;
import java.util.Stack;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class TraceMachine {
    private static final String TAG = "TraceMachine";
    private static AgentLog log;
    private static HashSet<String> sMethodSet;
    private static ThreadLocal<Stack<Trace>> traceStackThreadLocal;

    static {
        traceStackThreadLocal = new ThreadLocal();
        sMethodSet = new HashSet(32);
        log = AgentLogManager.getAgentLog();
    }

    public TraceMachine() {
    }

    public static void enterMethod(String r10, String r11, String r12, String r13) {
        Trace r14 = new Trace(r10, r11, r12, System.currentTimeMillis(), r13);
        if (traceStackThreadLocal.get() != null) goto L5;
        Stack<Trace> r15 = new Stack();
        r15.push(r14);
        traceStackThreadLocal.set(r15);
        return;
    L5:
        traceStackThreadLocal.get().push(r14);
    }

    public static void exitMethod() {
        exitMethod("");
    }

    @Deprecated
    private static void handleCost(Trace r10) {
        long r11 = r10.entryTime;     // Catch: Exception -> L8
        long r12 = r10.exitTime;     // Catch: Exception -> L8
        long r13 = r12 - r11;     // Catch: Exception -> L8
        if (r13 <= 0) goto L21;
        JSONObject r14 = new JSONObject();     // Catch: Exception -> L8
        r14.put("begin_time", r11);     // Catch: Exception -> L8
        r14.put("end_time", r12);     // Catch: Exception -> L8
        JSONObject r15 = new JSONObject();     // Catch: Exception -> L8
        if ("page_load".equals(r10.traceType) == false) goto L10;
        r15.put(r10.methodName, r13);     // Catch: Exception -> L8
    L11:
        JSONObject r16 = new JSONObject();     // Catch: Exception -> L8
        if ("page_load".equals(r10.traceType) == false) goto L14;
        r16.put("scene", r10.scene);     // Catch: Exception -> L8
        r16.put("is_first", !sMethodSet.contains(r10.className + r10.methodName));     // Catch: Exception -> L8
        sMethodSet.add(r10.className + r10.methodName);     // Catch: Exception -> L8
    L15:
        r14.put("extra_data", r10.extraData);     // Catch: Exception -> L8
        return;
    L14:
        r16.put("is_main", u.a());     // Catch: Exception -> L8
        goto L15
    L10:
        r15.put(r10.className + "#" + r10.methodName, r13);     // Catch: Exception -> L8
        goto L11
    L21:
        return;
    L8:
        e = move-exception;
        e.printStackTrace();
    }

    public static void exitMethod(String r10) {
        if (traceStackThreadLocal.get() != null) goto L5;
        return;
    L5:
        Stack<Trace> r11 = traceStackThreadLocal.get();
        if (r11.isEmpty() == true) goto L9;
        Trace r12 = r11.pop();
        r12.setExitTime(System.currentTimeMillis());
        r12.setExtraData(r10);
        handleCost(r12);
        return;
    }

    public static void enterMethod(String r10, String r11, String r12) {
        enterMethod(r10, r10, r11, r12);
    }
}
