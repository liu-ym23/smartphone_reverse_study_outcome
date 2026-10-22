package com.bytedance.apm.agent.instrumentation;

import com.bytedance.apm.agent.tracing.TraceMachine;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes14.dex */
public class JSONObjectInstrumentation {
    private static final String TAG = "JSONInstrumentation";

    public JSONObjectInstrumentation() {
    }

    public static JSONObject init(String r100) throws Exception {
        TraceMachine.enterMethod("JSONObject", "init", "json_trace");
        JSONObject r101 = new JSONObject(r100);
        TraceMachine.exitMethod();
        return r101;
    }
}
