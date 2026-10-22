package com.bytedance.applog.log;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: compiled from: LogProcessorHolder.java */
/* JADX INFO: loaded from: classes.dex */
public class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final CopyOnWriteArraySet<g> f5716a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Map<String, g> f5717b = null;

    static {
        f5716a = new CopyOnWriteArraySet();
        f5717b = new ConcurrentHashMap();
    }

    public static void a(String r2, g r3) {
        g r4 = (g) ZeusTransformUtils.wrapperContextForParams(r3, g.class, "com.obric.aiagent.plugin");
        f5717b.put(r2, r4);
    }

    public static boolean a() {
        if (f5716a.isEmpty() == true) goto L5;
    L7:
        return false;
    L5:
        if (f5717b.isEmpty() == false) goto L7;
        return true;
    }

    public static Iterator<g> b() {
        return f5716a.iterator();
    }

    public static Iterator<g> c() {
        return f5717b.values().iterator();
    }

    public static g a(String r2) {
        if (b(r2) == true) goto L5;
        return null;
    L5:
        return (g) ZeusTransformUtils.preCheckCast(f5717b.get(r2), g.class, "com.obric.aiagent.plugin");
    }

    public static void a(h r4) {
        if (r4 != null) goto L5;
        return;
    L5:
        if (f5716a.isEmpty() == false) goto L7;
        return;
    L7:
        Iterator<g> r0 = b();
    L9:
        if (r0.hasNext() == false) goto L11;
        ((g) ZeusTransformUtils.preCheckCast(r0.next(), g.class, "com.obric.aiagent.plugin")).a(r4);
        goto L9
    }

    private static boolean b(String r0) {
        if (r0 != null) goto L4;
    L6:
        return false;
    L4:
        if (r0.length() <= 0) goto L6;
        return true;
    }
}
