package com.bytedance.android.live.core.performance;

import com.larus.apm.impl.protector.RunnableProtector;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
public class MemSampler extends BaseSampler<JSONObject> {
    public MemSampler() {
        throw null;
    }

    public final void a() {
        new JSONObject();
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
