package com.bytedance.apm.d.c;

import java.util.List;
import org.json.JSONObject;

/* JADX INFO: compiled from: ActionRecord.java */
/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile a f4567a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private com.bytedance.apm.n.a<JSONObject> f4568b;

    private a() {
        this.f4568b = new com.bytedance.apm.n.a(20);
    }

    public static a a() {
        if (f4567a != null) goto L15;
        monitor-enter(a.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f4567a != null) goto L9;
        f4567a = new a();     // Catch: Throwable -> L11
    L9:
        monitor-exit(a.class);     // Catch: Throwable -> L11
    L15:
        return f4567a;
    }

    public void a(JSONObject r1) {
        this.f4568b.a(r1);
    }

    public List<JSONObject> b() {
        return this.f4568b.a();
    }
}
