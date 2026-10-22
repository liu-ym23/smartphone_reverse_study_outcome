package com.bumptech.glide.d;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: EncoderRegistry.java */
/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<C0084a<?>> f3277a;

    /* JADX INFO: renamed from: com.bumptech.glide.d.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: EncoderRegistry.java */
    private static final class C0084a<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final com.bumptech.glide.load.d<T> f3278a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Class<T> f3279b;

        C0084a(Class<T> r3, com.bumptech.glide.load.d<T> r4) {
            com.bumptech.glide.load.d<T> r5 = (com.bumptech.glide.load.d) ZeusTransformUtils.wrapperContextForParams(r4, com.bumptech.glide.load.d.class, "com.obric.aiagent.plugin");
            this.f3279b = r3;
            this.f3278a = r5;
        }

        boolean a(Class<?> r1) {
            return this.f3279b.isAssignableFrom(r1);
        }
    }

    public a() {
        this.f3277a = new ArrayList();
    }

    public synchronized <T> com.bumptech.glide.load.d<T> a(Class<T> r5) {
        monitor-enter(this);
        Iterator<C0084a<?>> r0 = this.f3277a.iterator();     // Catch: Throwable -> L14
    L5:
        if (r0.hasNext() == false) goto L12;
        C0084a r1 = (C0084a) ZeusTransformUtils.preCheckCast(r0.next(), C0084a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L14
        if (r1.a(r5) == false) goto L5;
        com.bumptech.glide.load.d<T> r6 = r1.f3278a;     // Catch: Throwable -> L14
        monitor-exit(this);
        return r6;
    L12:
        monitor-exit(this);
        return null;
    L14:
        th = move-exception;
        throw th;
    }

    public synchronized <T> void a(Class<T> r3, com.bumptech.glide.load.d<T> r4) {
        monitor-enter(this);
        com.bumptech.glide.load.d r5 = (com.bumptech.glide.load.d) ZeusTransformUtils.wrapperContextForParams(r4, com.bumptech.glide.load.d.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L6
        this.f3277a.add(new C0084a(r3, r5));     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }
}
