package com.bumptech.glide.load.b;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: ModelLoaderRegistry.java */
/* JADX INFO: loaded from: classes.dex */
public class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final r f3469a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final a f3470b;

    /* JADX INFO: compiled from: ModelLoaderRegistry.java */
    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Map<Class<?>, C0090a<?>> f3471a;

        /* JADX INFO: renamed from: com.bumptech.glide.load.b.p$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: ModelLoaderRegistry.java */
        private static class C0090a<Model> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final List<n<Model, ?>> f3472a;

            public C0090a(List<n<Model, ?>> r3) {
                this.f3472a = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
            }
        }

        a() {
            this.f3471a = new HashMap();
        }

        public void a() {
            this.f3471a.clear();
        }

        public <Model> void a(Class<Model> r3, List<n<Model, ?>> r4) {
            if (((C0090a) ZeusTransformUtils.preCheckCast(this.f3471a.put(r3, new C0090a((List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin"))), C0090a.class, "com.obric.aiagent.plugin")) != null) goto L6;
            return;
        L6:
            throw new IllegalStateException("Already cached loaders for model: " + r3);
        }

        public <Model> List<n<Model, ?>> a(Class<Model> r2) {
            C0090a r1 = (C0090a) ZeusTransformUtils.preCheckCast(this.f3471a.get(r2), C0090a.class, "com.obric.aiagent.plugin");
            if (r1 != null) goto L6;
            return null;
        L6:
            return r1.f3472a;
        }
    }

    public p(androidx.core.util.f.a<List<Throwable>> r3) {
        this(new r((androidx.core.util.f.a) ZeusTransformUtils.wrapperContextForParams(r3, androidx.core.util.f.a.class, "com.obric.aiagent.plugin")));
    }

    private p(r r2) {
        this.f3470b = new a();
        this.f3469a = r2;
    }

    public synchronized <Model, Data> void a(Class<Model> r3, Class<Data> r4, o<? extends Model, ? extends Data> r5) {
        monitor-enter(this);
        o<? extends Model, ? extends Data> r6 = (o) ZeusTransformUtils.wrapperContextForParams(r5, o.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L6
        this.f3469a.a(r3, r4, r6);     // Catch: Throwable -> L6
        this.f3470b.a();     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public <A> List<n<A, ?>> a(A r9) {
        List<n<A, ?>> r8 = b(b(r9));
        if (r8.isEmpty() == true) goto L18;
        int r0 = r8.size();
        List<n<A, ?>> r1 = Collections.emptyList();
        boolean r3 = true;
        int r4 = 0;
    L5:
        if (r4 >= r0) goto L13;
        n<A, ?> r5 = (n) ZeusTransformUtils.preCheckCast(r8.get(r4), n.class, "com.obric.aiagent.plugin");
        if (r5.a(r9) == false) goto L11;
        if (r3 == false) goto L10;
        r1 = new ArrayList(r0 - r4);
        r3 = false;
    L10:
        r1.add(r5);
    L11:
        r4 = r4 + 1;
        goto L5
    L13:
        if (r1.isEmpty() == true) goto L16;
        return r1;
    L16:
        throw new com.bumptech.glide.f.c(r9, r8);
    L18:
        throw new com.bumptech.glide.f.c(r9);
    }

    public synchronized List<Class<?>> a(Class<?> r2) {
        monitor-enter(this);
        List<Class<?>> r3 = this.f3469a.b(r2);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r3;
    L6:
        th = move-exception;
        throw th;
    }

    private synchronized <A> List<n<A, ?>> b(Class<A> r3) {
        monitor-enter(this);
        List<n<A, ?>> r0 = this.f3470b.a(r3);     // Catch: Throwable -> L8
        if (r0 != null) goto L6;
        r0 = Collections.unmodifiableList(this.f3469a.a(r3));     // Catch: Throwable -> L8
        this.f3470b.a(r3, r0);     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
        return r0;
    L8:
        th = move-exception;
        throw th;
    }

    private static <A> Class<A> b(A r0) {
        return (Class<A>) r0.getClass();
    }
}
