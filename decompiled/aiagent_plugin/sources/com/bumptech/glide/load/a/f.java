package com.bumptech.glide.load.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: DataRewinderRegistry.java */
/* JADX INFO: loaded from: classes.dex */
public class f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final e.a<?> f3373b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<Class<?>, e.a<?>> f3374a;

    /* JADX INFO: compiled from: DataRewinderRegistry.java */
    private static final class a implements e<Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Object f3375a;

        @Override // com.bumptech.glide.load.a.e
        public void b() {
        }

        a(Object r1) {
            this.f3375a = r1;
        }

        @Override // com.bumptech.glide.load.a.e
        public Object a() {
            return this.f3375a;
        }
    }

    public f() {
        this.f3374a = new HashMap();
    }

    static {
        f3373b = new AnonymousClass1();
    }

    public synchronized void a(e.a<?> r3) {
        monitor-enter(this);
        e.a<?> r4 = (e.a) ZeusTransformUtils.wrapperContextForParams(r3, e.a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L6
        this.f3374a.put(r4.a(), r4);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized <T> e<T> a(T r6) {
        monitor-enter(this);
        com.bumptech.glide.f.j.a(r6);     // Catch: Throwable -> L16
        e.a<?> r0 = (e.a) ZeusTransformUtils.preCheckCast(this.f3374a.get(r6.getClass()), e.a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L16
        if (r0 != null) goto L11;
        Iterator<e.a<?>> r1 = this.f3374a.values().iterator();     // Catch: Throwable -> L16
    L7:
        if (r1.hasNext() == false) goto L11;
        e.a<?> r2 = (e.a) ZeusTransformUtils.preCheckCast(r1.next(), e.a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L16
        if (r2.a().isAssignableFrom(r6.getClass()) == false) goto L7;
        r0 = r2;
    L11:
        if (r0 != null) goto L13;
        r0 = f3373b;     // Catch: Throwable -> L16
    L13:
        e<T> r7 = r0.a(r6);     // Catch: Throwable -> L16
        monitor-exit(this);
        return r7;
    L16:
        th = move-exception;
        throw th;
    }
}
