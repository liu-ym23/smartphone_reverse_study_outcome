package com.bumptech.glide.load.b;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: MultiModelLoaderFactory.java */
/* JADX INFO: loaded from: classes.dex */
public class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final c f3480a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final n<Object, Object> f3481b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List<b<?, ?>> f3482c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final c f3483d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Set<b<?, ?>> f3484e;
    private final androidx.core.util.f.a<List<Throwable>> f;

    /* JADX INFO: compiled from: MultiModelLoaderFactory.java */
    private static class a implements n<Object, Object> {
        @Override // com.bumptech.glide.load.b.n
        public n.a<Object> a(Object r1, int r2, int r3, com.bumptech.glide.load.i r4) {
            return null;
        }

        @Override // com.bumptech.glide.load.b.n
        public boolean a(Object r1) {
            return false;
        }

        a() {
        }
    }

    /* JADX INFO: compiled from: MultiModelLoaderFactory.java */
    private static class b<Model, Data> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Class<Data> f3485a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final o<? extends Model, ? extends Data> f3486b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Class<Model> f3487c;

        public b(Class<Model> r3, Class<Data> r4, o<? extends Model, ? extends Data> r5) {
            o<? extends Model, ? extends Data> r6 = (o) ZeusTransformUtils.wrapperContextForParams(r5, o.class, "com.obric.aiagent.plugin");
            this.f3487c = r3;
            this.f3485a = r4;
            this.f3486b = r6;
        }

        public boolean a(Class<?> r1, Class<?> r2) {
            if (a(r1) == true) goto L5;
        L7:
            return false;
        L5:
            if (this.f3485a.isAssignableFrom(r2) == false) goto L7;
            return true;
        }

        public boolean a(Class<?> r1) {
            return this.f3487c.isAssignableFrom(r1);
        }
    }

    /* JADX INFO: compiled from: MultiModelLoaderFactory.java */
    static class c {
        c() {
        }

        public <Model, Data> q<Model, Data> a(List<n<Model, Data>> r2, androidx.core.util.f.a<List<Throwable>> r3) {
            return new q((List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin"), (androidx.core.util.f.a) ZeusTransformUtils.wrapperContextForParams(r3, androidx.core.util.f.a.class, "com.obric.aiagent.plugin"));
        }
    }

    static {
        f3480a = new c();
        f3481b = new a();
    }

    public r(androidx.core.util.f.a<List<Throwable>> r3) {
        this((androidx.core.util.f.a) ZeusTransformUtils.wrapperContextForParams(r3, androidx.core.util.f.a.class, "com.obric.aiagent.plugin"), f3480a);
    }

    r(androidx.core.util.f.a<List<Throwable>> r3, c r4) {
        androidx.core.util.f.a<List<Throwable>> r5 = (androidx.core.util.f.a) ZeusTransformUtils.wrapperContextForParams(r3, androidx.core.util.f.a.class, "com.obric.aiagent.plugin");
        this.f3482c = new ArrayList();
        this.f3484e = new HashSet();
        this.f = r5;
        this.f3483d = r4;
    }

    synchronized <Model, Data> void a(Class<Model> r3, Class<Data> r4, o<? extends Model, ? extends Data> r5) {
        monitor-enter(this);
        a(r3, r4, (o) ZeusTransformUtils.wrapperContextForParams(r5, o.class, "com.obric.aiagent.plugin"), true);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    private <Model, Data> void a(Class<Model> r3, Class<Data> r4, o<? extends Model, ? extends Data> r5, boolean r6) {
        b<?, ?> r0 = new b(r3, r4, (o) ZeusTransformUtils.wrapperContextForParams(r5, o.class, "com.obric.aiagent.plugin"));
        List<b<?, ?>> r2 = this.f3482c;
        if (r6 == false) goto L5;
        int r7 = r2.size();
    L6:
        r2.add(r7, r0);
        return;
    L5:
        r7 = 0;
        goto L6
    }

    synchronized <Model> List<n<Model, ?>> a(Class<Model> r6) {
        monitor-enter(this);
        ArrayList r0 = new ArrayList();     // Catch: Throwable -> L15
        Iterator<b<?, ?>> r1 = this.f3482c.iterator();     // Catch: Throwable -> L15
    L5:
        if (r1.hasNext() == false) goto L13;
        b<?, ?> r2 = (b) ZeusTransformUtils.preCheckCast(r1.next(), b.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L15
        if (this.f3484e.contains(r2) == true) goto L5;
        if (r2.a(r6) == false) goto L5;
        this.f3484e.add(r2);     // Catch: Throwable -> L15
        r0.add(a(r2));     // Catch: Throwable -> L15
        this.f3484e.remove(r2);     // Catch: Throwable -> L15
        goto L5
    L13:
        monitor-exit(this);
        return r0;
    L15:
        th = move-exception;
        this.f3484e.clear();     // Catch: Throwable -> L18
        throw th;     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        throw th;
    }

    synchronized List<Class<?>> b(Class<?> r6) {
        monitor-enter(this);
        ArrayList r0 = new ArrayList();     // Catch: Throwable -> L14
        Iterator<b<?, ?>> r1 = this.f3482c.iterator();     // Catch: Throwable -> L14
    L5:
        if (r1.hasNext() == false) goto L12;
        b r2 = (b) ZeusTransformUtils.preCheckCast(r1.next(), b.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L14
        if (r0.contains(r2.f3485a) == true) goto L5;
        if (r2.a(r6) == false) goto L5;
        r0.add(r2.f3485a);     // Catch: Throwable -> L14
        goto L5
    L12:
        monitor-exit(this);
        return r0;
    L14:
        th = move-exception;
        throw th;
    }

    public synchronized <Model, Data> n<Model, Data> a(Class<Model> r9, Class<Data> r10) {
        monitor-enter(this);
        ArrayList r0 = new ArrayList();     // Catch: Throwable -> L28
        Iterator<b<?, ?>> r1 = this.f3482c.iterator();     // Catch: Throwable -> L28
        boolean r4 = false;
    L5:
        if (r1.hasNext() == false) goto L13;
        b<?, ?> r5 = (b) ZeusTransformUtils.preCheckCast(r1.next(), b.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L28
        if (this.f3484e.contains(r5) == true) goto L8;
        if (r5.a(r9, r10) == false) goto L5;
        this.f3484e.add(r5);     // Catch: Throwable -> L28
        r0.add(a(r5));     // Catch: Throwable -> L28
        this.f3484e.remove(r5);     // Catch: Throwable -> L28
        goto L5
    L8:
        r4 = true;
        goto L5
    L13:
        if (r0.size() <= 1) goto L18;
        q<Model, Data> r11 = this.f3483d.a(r0, this.f);     // Catch: Throwable -> L28
        monitor-exit(this);
        return r11;
    L18:
        if (r0.size() != 1) goto L22;
        n<Model, Data> r12 = (n) ZeusTransformUtils.preCheckCast(r0.get(0), n.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L28
        monitor-exit(this);
        return r12;
    L22:
        if (r4 == false) goto L27;
        n<Model, Data> r13 = a();     // Catch: Throwable -> L28
        monitor-exit(this);
        return r13;
    L27:
        throw new com.bumptech.glide.f.c(r9, r10);     // Catch: Throwable -> L28
    L28:
        th = move-exception;
        this.f3484e.clear();     // Catch: Throwable -> L31
        throw th;     // Catch: Throwable -> L31
    L31:
        th = move-exception;
        throw th;
    }

    private <Model, Data> n<Model, Data> a(b<?, ?> r2) {
        return (n) ZeusTransformUtils.preCheckCast(com.bumptech.glide.f.j.a(r2.f3486b.a(this)), n.class, "com.obric.aiagent.plugin");
    }

    private static <Model, Data> n<Model, Data> a() {
        return (n<Model, Data>) f3481b;
    }
}
