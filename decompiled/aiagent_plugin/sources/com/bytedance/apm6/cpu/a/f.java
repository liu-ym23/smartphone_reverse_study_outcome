package com.bytedance.apm6.cpu.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: InitiativeCpuCollectManager.java */
/* JADX INFO: loaded from: classes.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Map<String, Object> f5214a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static List<e> f5215b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile boolean f5216c;

    static {
        f5214a = new HashMap();
        f5215b = new LinkedList();
        f5216c = false;
    }

    public static synchronized void a() {
        monitor-enter(f.class);
        f5216c = true;     // Catch: Throwable -> L14
        if (f5215b.isEmpty() == true) goto L12;
        Iterator<e> r1 = f5215b.iterator();     // Catch: Throwable -> L14
    L9:
        if (r1.hasNext() == false) goto L11;
        com.bytedance.apm6.monitor.a.a((e) ZeusTransformUtils.preCheckCast(r1.next(), e.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L14
        goto L9
    L11:
        f5215b.clear();     // Catch: Throwable -> L14
    L12:
        monitor-exit(f.class);
        return;
    L14:
        th = move-exception;
        throw th;
    }
}
