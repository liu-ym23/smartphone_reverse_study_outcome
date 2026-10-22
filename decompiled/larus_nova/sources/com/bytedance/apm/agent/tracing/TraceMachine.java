package com.bytedance.apm.agent.tracing;

import com.bytedance.android.ec.core.event.a;
import com.bytedance.apm.agent.logging.AgentLog;
import com.bytedance.apm.agent.logging.AgentLogManager;
import com.bytedance.apm.constant.UploadTypeInf;
import com.bytedance.apm.util.u;
import java.util.HashSet;
import java.util.Stack;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes14.dex */
public class TraceMachine {
    private static final String TAG = "TraceMachine";
    private static AgentLog log;
    private static HashSet<String> sMethodSet;
    private static ThreadLocal<Stack<Trace>> traceStackThreadLocal;

    public TraceMachine() {
    }

    static {
        traceStackThreadLocal = new ThreadLocal();
        sMethodSet = new HashSet(32);
        log = AgentLogManager.getAgentLog();
    }

    public static void exitMethod() {
        exitMethod("");
    }

    public static void exitMethod(String r100) {
        if (traceStackThreadLocal.get() != null) goto L5;
        return;
    L5:
        Stack<Trace> r101 = traceStackThreadLocal.get();
        if (r101.isEmpty() == true) goto L9;
        Trace r102 = r101.pop();
        r102.setExitTime(System.currentTimeMillis());
        r102.setExtraData(r100);
        handleCost(r102);
        return;
    }

    private static void handleCost(Trace r110) {
        long r100 = r110.entryTime;     // Catch: Exception -> L19
        long r101 = r110.exitTime;     // Catch: Exception -> L19
        long r102 = Long.valueOf(r101 - r100).longValue();     // Catch: Exception -> L19
        if (r102 <= 0) goto L24;
        JSONObject r103 = new JSONObject();     // Catch: Exception -> L19
        r103.put("begin_time", r100);     // Catch: Exception -> L19
        r103.put("end_time", r101);     // Catch: Exception -> L19
        JSONObject r104 = new JSONObject();     // Catch: Exception -> L19
        if (UploadTypeInf.PAGE_LOAD.equals(r110.traceType) == false) goto L8;
        r104.put(r110.methodName, r102);     // Catch: Exception -> L19
    L9:
        JSONObject r105 = new JSONObject();     // Catch: Exception -> L19
        if (UploadTypeInf.PAGE_LOAD.equals(r110.traceType) == false) goto L16;
        r105.put("scene", r110.scene);     // Catch: Exception -> L19
        if (sMethodSet.contains(r110.className + r110.methodName) == true) goto L14;
        boolean r106 = true;
    L15:
        r105.put(a.KEY_IS_FIRST, r106);     // Catch: Exception -> L19
        sMethodSet.add(r110.className + r110.methodName);     // Catch: Exception -> L19
    L17:
        r103.put("extra_data", r110.extraData);     // Catch: Exception -> L19
        return;
    L14:
        r106 = false;
        goto L15
    L16:
        r105.put("is_main", u.a());     // Catch: Exception -> L19
        goto L17
    L8:
        r104.put(r110.className + "#" + r110.methodName, r102);     // Catch: Exception -> L19
        goto L9
    L24:
        return;
    L19:
        e = move-exception;
        e.printStackTrace();
    }

    public static void enterMethod(String r100, String r101, String r102) {
        enterMethod(r100, r100, r101, r102);
    }

    public static void enterMethod(String r100, String r101, String r110, String r111) {
        Trace r102 = new Trace(r100, r101, r110, System.currentTimeMillis(), r111);
        if (traceStackThreadLocal.get() != null) goto L5;
        Stack<Trace> r103 = new Stack();
        r103.push(r102);
        traceStackThreadLocal.set(r103);
        return;
    L5:
        traceStackThreadLocal.get().push(r102);
    }
}
