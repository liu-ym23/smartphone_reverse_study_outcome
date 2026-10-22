package com.bytedance.apm;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: FluencySwitchManager.java */
/* JADX INFO: loaded from: classes.dex */
public class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static List<h> f4654a;

    static {
        f4654a = new ArrayList(2);
    }

    public static synchronized void a(h r3) {
        monitor-enter(i.class);
        h r4 = (h) ZeusTransformUtils.wrapperContextForParams(r3, h.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L7
        f4654a.add(r4);     // Catch: Throwable -> L7
        monitor-exit(i.class);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static synchronized void a(com.bytedance.apm.config.e r5) {
        monitor-enter(i.class);
        Iterator<h> r1 = f4654a.iterator();     // Catch: Throwable -> L13
    L6:
        if (r1.hasNext() == false) goto L11;
        h r2 = (h) ZeusTransformUtils.preCheckCast(r1.next(), h.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L13
        if (r2 == null) goto L6;
        r2.a(r5);     // Catch: Throwable -> L13
        goto L6
    L11:
        monitor-exit(i.class);
        return;
    L13:
        th = move-exception;
        throw th;
    }
}
