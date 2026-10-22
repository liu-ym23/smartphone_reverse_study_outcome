package com.bumptech.glide.d;

import com.bumptech.glide.f.i;
import com.bumptech.glide.load.engine.t;
import com.bumptech.glide.load.resource.d.g;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: LoadPathCache.java */
/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final t<?, ?, ?> f3281a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final androidx.b.a<i, t<?, ?, ?>> f3282b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final AtomicReference<i> f3283c;

    public c() {
        this.f3282b = new androidx.b.a();
        this.f3283c = new AtomicReference();
    }

    static {
        f3281a = new t(Object.class, Object.class, Object.class, Collections.singletonList(new com.bumptech.glide.load.engine.i(Object.class, Object.class, Object.class, Collections.emptyList(), new g(), null)), null);
    }

    public boolean a(t<?, ?, ?> r1) {
        return f3281a.equals(r1);
    }

    public <Data, TResource, Transcode> t<Data, TResource, Transcode> a(Class<Data> r3, Class<TResource> r4, Class<Transcode> r5) {
        i r6 = b(r3, r4, r5);
        androidx.b.a<i, t<?, ?, ?>> r7 = this.f3282b;
        monitor-enter(r7);
        t<Data, TResource, Transcode> r8 = (t) ZeusTransformUtils.preCheckCast(this.f3282b.get(r6), t.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L8
        monitor-exit(r7);     // Catch: Throwable -> L8
        this.f3283c.set(r6);
        return r8;
    L8:
        th = move-exception;
        throw th;
    }

    public void a(Class<?> r3, Class<?> r4, Class<?> r5, t<?, ?, ?> r6) {
        androidx.b.a<i, t<?, ?, ?>> r0 = this.f3282b;
        monitor-enter(r0);
        androidx.b.a<i, t<?, ?, ?>> r2 = this.f3282b;     // Catch: Throwable -> L11
        i r1 = new i(r3, r4, r5);     // Catch: Throwable -> L11
        if (r6 != null) goto L8;
        r6 = f3281a;     // Catch: Throwable -> L11
    L8:
        r2.put(r1, r6);     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    }

    private i b(Class<?> r3, Class<?> r4, Class<?> r5) {
        i r2 = (i) ZeusTransformUtils.preCheckCast(this.f3283c.getAndSet(null), i.class, "com.obric.aiagent.plugin");
        if (r2 != null) goto L5;
        r2 = new i();
    L5:
        r2.a(r3, r4, r5);
        return r2;
    }
}
