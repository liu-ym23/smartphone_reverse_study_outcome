package com.bytedance.dataplatform.a;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: DefaultAppLogService.java */
/* JADX INFO: loaded from: classes.dex */
class b implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile Method f7902a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map<String, JSONObject> f7903b;

    b() {
        this.f7903b = new HashMap();
    }

    @Override // com.bytedance.dataplatform.a.c
    public void a(String r2, JSONObject r3) {
        if (this.f7902a != null) goto L6;
        this.f7903b.put(r2, r3);
        return;
    L6:
        b(r2, r3);
    }

    private void b(String r4, JSONObject r5) {
        this.f7902a.invoke(null, new Object[]{r4, r5});     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        th.printStackTrace();
    }
}
