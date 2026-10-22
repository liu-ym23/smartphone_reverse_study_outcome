package com.bytedance.ttnet.b;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: CronetDropReasonAccess.java */
/* JADX INFO: loaded from: classes.dex */
public class c extends Observable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile c f11388a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile boolean f11389b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private CopyOnWriteArrayList<Integer> f11390c;

    public c() {
        this.f11390c = new CopyOnWriteArrayList();
    }

    public static c a() {
        if (f11388a != null) goto L15;
        monitor-enter(c.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f11388a != null) goto L9;
        f11388a = new c();     // Catch: Throwable -> L11
    L9:
        monitor-exit(c.class);     // Catch: Throwable -> L11
    L15:
        return f11388a;
    }

    public void a(boolean r3, List<Integer> r4) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        this.f11389b = r3;
        this.f11390c.clear();
        this.f11390c.addAll(r5);
        HashMap r6 = new HashMap();
        r6.put("user_blocked_state", Boolean.valueOf(this.f11389b));
        r6.put("drop_reason_list", this.f11390c);
        a(r6);
    }

    private void a(Map<String, Object> r3) {
        Map r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
        setChanged();
        notifyObservers(r4);
    }
}
