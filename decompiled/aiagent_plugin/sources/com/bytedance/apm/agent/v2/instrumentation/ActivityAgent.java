package com.bytedance.apm.agent.v2.instrumentation;

import android.text.TextUtils;
import com.bytedance.apm.agent.a.b;
import com.bytedance.apm.agent.tracing.AutoPageTraceHelper;
import com.bytedance.apm.agent.v2.a;

/* JADX INFO: loaded from: classes.dex */
public class ActivityAgent {
    private static final String TAG = "ActivityInstrumentation";

    public ActivityAgent() {
    }

    public static void onTrace(String r1, String r2, boolean r3) {
        if (r3 == false) goto L9;
        if (a.f4140a == false) goto L9;
        if (TextUtils.equals("onResume", r2) == false) goto L9;
        b.a(r1, true);
    L9:
        if (a.f4141b == true) goto L11;
        return;
    L11:
        AutoPageTraceHelper.onTrace(r1, r2, r3);
    }
}
