package com.bytedance.frameworks.baselib.network.http.ok3.impl;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import okhttp3.ttnet.TTConfigManager;
import org.json.JSONObject;

/* JADX INFO: compiled from: MiscConfigManager.java */
/* JADX INFO: loaded from: classes.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile e f8475a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<String> f8476b;

    public static e a() {
        if (f8475a != null) goto L15;
        monitor-enter(e.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f8475a != null) goto L9;
        f8475a = new e();     // Catch: Throwable -> L11
    L9:
        monitor-exit(e.class);     // Catch: Throwable -> L11
    L15:
        return f8475a;
    }

    private e() {
        this.f8476b = new CopyOnWriteArrayList();
    }

    public void a(JSONObject r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        TTConfigManager.parseJsonArray(r2, "log_header_rm_list", this.f8476b);
    }

    public List<String> b() {
        return this.f8476b;
    }
}
