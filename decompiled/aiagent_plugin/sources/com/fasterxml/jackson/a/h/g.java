package com.fasterxml.jackson.a.h;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: InternCache.java */
/* JADX INFO: loaded from: classes2.dex */
public final class g extends ConcurrentHashMap<String, String> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f12107a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Object f12108b;

    static {
        f12107a = new g();
    }

    private g() {
        super(180, 0.8f, 4);
        this.f12108b = new Object();
    }

    public String a(String r4) {
        String r0 = (String) ZeusTransformUtils.preCheckCast(get(r4), String.class, "com.obric.aiagent.plugin");
        if (r0 == null) goto L6;
        return r0;
    L6:
        if (size() < 180) goto L17;
        Object r1 = this.f12108b;
        monitor-enter(r1);
    L14:
        th = move-exception;
        throw th;
    L10:
        if (size() < 180) goto L12;
        clear();     // Catch: Throwable -> L14
    L12:
        monitor-exit(r1);     // Catch: Throwable -> L14
    L17:
        String r5 = r4.intern();
        put(r5, r5);
        return r5;
    }
}
