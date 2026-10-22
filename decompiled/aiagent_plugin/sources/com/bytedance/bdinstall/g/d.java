package com.bytedance.bdinstall.g;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: ServiceManager.java */
/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap<String, d> f6249a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ConcurrentHashMap<Class, Object> f6250b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ConcurrentHashMap<Class, Object> f6251c;

    public d() {
        this.f6250b = new ConcurrentHashMap();
        this.f6251c = new ConcurrentHashMap();
    }

    static {
        f6249a = new ConcurrentHashMap();
    }

    public static <T> T a(Class<T> r2, String r3) {
        d r4 = (d) ZeusTransformUtils.preCheckCast(f6249a.get(r3), d.class, "com.obric.aiagent.plugin");
        if (r4 != null) goto L5;
        return null;
    L5:
        return (T) r4.f6250b.get(r2);
    }

    public static <T> void a(Class<T> r4, T r5, String r6) {
        ConcurrentHashMap<String, d> r0 = f6249a;
        d r1 = (d) ZeusTransformUtils.preCheckCast(r0.get(r6), d.class, "com.obric.aiagent.plugin");
        if (r1 != null) goto L5;
        r1 = new d();
        r0.put(r6, r1);
    L5:
        r1.f6250b.put(r4, r5);
    }
}
