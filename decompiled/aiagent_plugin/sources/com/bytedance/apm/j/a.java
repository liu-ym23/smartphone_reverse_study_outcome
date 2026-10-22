package com.bytedance.apm.j;

import com.bytedance.apm.c;
import com.bytedance.apm6.util.c.b;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.CopyOnWriteArraySet;
import org.json.JSONObject;

/* JADX INFO: compiled from: LogObserver.java */
/* JADX INFO: loaded from: classes.dex */
public class a {
    private static final String TAG = "LogObserver";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile a f4708b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    CopyOnWriteArraySet<com.bytedance.apm.g.a> f4709a;

    private a() {
        this.f4709a = new CopyOnWriteArraySet();
    }

    public static a a() {
        if (f4708b != null) goto L15;
        monitor-enter(a.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f4708b != null) goto L9;
        f4708b = new a();     // Catch: Throwable -> L11
    L9:
        monitor-exit(a.class);     // Catch: Throwable -> L11
    L15:
        return f4708b;
    }

    public void a(final String r3, final String r4, final JSONObject r5) {
        if (c.i() == false) goto L6;
        b.a(TAG, "logObserverList:" + this.f4709a.size());
    L6:
        if (this.f4709a.size() != 0) goto L8;
        return;
    L8:
        com.bytedance.apm.thread.b.a().c(new AnonymousClass1(this, r3, r4, r5));
    }

    public void a(com.bytedance.apm.g.a r3) {
        com.bytedance.apm.g.a r4 = (com.bytedance.apm.g.a) ZeusTransformUtils.wrapperContextForParams(r3, com.bytedance.apm.g.a.class, "com.obric.aiagent.plugin");
        if (r4 == null) goto L9;
        this.f4709a.add(r4);     // Catch: Throwable -> L6
        return;
    L10:
        return;
    }
}
