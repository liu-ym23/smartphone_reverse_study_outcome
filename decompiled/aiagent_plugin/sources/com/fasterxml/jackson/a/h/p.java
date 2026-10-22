package com.fasterxml.jackson.a.h;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: ThreadLocalBufferManager.java */
/* JADX INFO: loaded from: classes2.dex */
class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f12125a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map<SoftReference<com.fasterxml.jackson.a.h.a>, Boolean> f12126b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ReferenceQueue<com.fasterxml.jackson.a.h.a> f12127c;

    /* JADX INFO: compiled from: ThreadLocalBufferManager.java */
    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final p f12128a = null;

        static {
            f12128a = new p();
        }
    }

    p() {
        this.f12125a = new Object();
        this.f12126b = new ConcurrentHashMap();
        this.f12127c = new ReferenceQueue();
    }

    public static p a() {
        return a.f12128a;
    }

    public SoftReference<com.fasterxml.jackson.a.h.a> a(com.fasterxml.jackson.a.h.a r3) {
        SoftReference<com.fasterxml.jackson.a.h.a> r0 = new SoftReference(r3, this.f12127c);
        this.f12126b.put(r0, true);
        b();
        return r0;
    }

    private void b() {
    L2:
        SoftReference r0 = (SoftReference) ZeusTransformUtils.preCheckCast(this.f12127c.poll(), SoftReference.class, "com.obric.aiagent.plugin");
        if (r0 == null) goto L5;
        this.f12126b.remove(r0);
        goto L2
    }
}
