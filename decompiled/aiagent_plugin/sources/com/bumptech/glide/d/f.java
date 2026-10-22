package com.bumptech.glide.d;

import com.bumptech.glide.load.l;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: ResourceEncoderRegistry.java */
/* JADX INFO: loaded from: classes.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<a<?>> f3291a;

    /* JADX INFO: compiled from: ResourceEncoderRegistry.java */
    private static final class a<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final l<T> f3292a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Class<T> f3293b;

        a(Class<T> r3, l<T> r4) {
            l<T> r5 = (l) ZeusTransformUtils.wrapperContextForParams(r4, l.class, "com.obric.aiagent.plugin");
            this.f3293b = r3;
            this.f3292a = r5;
        }

        boolean a(Class<?> r1) {
            return this.f3293b.isAssignableFrom(r1);
        }
    }

    public f() {
        this.f3291a = new ArrayList();
    }

    public synchronized <Z> void a(Class<Z> r3, l<Z> r4) {
        monitor-enter(this);
        l r5 = (l) ZeusTransformUtils.wrapperContextForParams(r4, l.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L6
        this.f3291a.add(new a(r3, r5));     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized <Z> l<Z> a(Class<Z> r6) {
        monitor-enter(this);
        int r0 = 0;
        int r1 = this.f3291a.size();     // Catch: Throwable -> L15
    L5:
        if (r0 >= r1) goto L13;
        a r2 = (a) ZeusTransformUtils.preCheckCast(this.f3291a.get(r0), a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L15
        if (r2.a(r6) == true) goto L8;
        r0 = r0 + 1;
        goto L5
    L8:
        l<Z> r7 = (l<Z>) r2.f3292a;
        monitor-exit(this);
        return r7;
    L13:
        monitor-exit(this);
        return null;
    L15:
        th = move-exception;
        throw th;
    }
}
