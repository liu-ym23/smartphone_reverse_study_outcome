package com.bumptech.glide.d;

import com.bumptech.glide.load.k;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: ResourceDecoderRegistry.java */
/* JADX INFO: loaded from: classes.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<String> f3286a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map<String, List<a<?, ?>>> f3287b;

    /* JADX INFO: compiled from: ResourceDecoderRegistry.java */
    private static class a<T, R> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Class<R> f3288a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final k<T, R> f3289b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Class<T> f3290c;

        public a(Class<T> r3, Class<R> r4, k<T, R> r5) {
            k<T, R> r6 = (k) ZeusTransformUtils.wrapperContextForParams(r5, k.class, "com.obric.aiagent.plugin");
            this.f3290c = r3;
            this.f3288a = r4;
            this.f3289b = r6;
        }

        public boolean a(Class<?> r2, Class<?> r3) {
            if (this.f3290c.isAssignableFrom(r2) == true) goto L5;
        L7:
            return false;
        L5:
            if (r3.isAssignableFrom(this.f3288a) == false) goto L7;
            return true;
        }
    }

    public e() {
        this.f3286a = new ArrayList();
        this.f3287b = new HashMap();
    }

    public synchronized void a(List<String> r6) {
        monitor-enter(this);
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L16
        ArrayList r0 = new ArrayList(this.f3286a);     // Catch: Throwable -> L16
        this.f3286a.clear();     // Catch: Throwable -> L16
        Iterator r1 = r7.iterator();     // Catch: Throwable -> L16
    L5:
        if (r1.hasNext() == false) goto L7;
        String r2 = (String) ZeusTransformUtils.preCheckCast(r1.next(), String.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L16
        this.f3286a.add(r2);     // Catch: Throwable -> L16
        goto L5
    L7:
        Iterator r3 = r0.iterator();     // Catch: Throwable -> L16
    L8:
        if (r3.hasNext() == false) goto L14;
        String r4 = (String) ZeusTransformUtils.preCheckCast(r3.next(), String.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L16
        if (r7.contains(r4) == true) goto L8;
        this.f3286a.add(r4);     // Catch: Throwable -> L16
        goto L8
    L14:
        monitor-exit(this);
        return;
    L16:
        th = move-exception;
        throw th;
    }

    public synchronized <T, R> List<k<T, R>> a(Class<T> r7, Class<R> r8) {
        monitor-enter(this);
        ArrayList r0 = new ArrayList();     // Catch: Throwable -> L18
        Iterator<String> r1 = this.f3286a.iterator();     // Catch: Throwable -> L18
    L5:
        if (r1.hasNext() == false) goto L16;
        String r2 = (String) ZeusTransformUtils.preCheckCast(r1.next(), String.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L18
        List r3 = (List) ZeusTransformUtils.preCheckCast(this.f3287b.get(r2), List.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L18
        if (r3 == null) goto L5;
        Iterator r4 = r3.iterator();     // Catch: Throwable -> L18
    L11:
        if (r4.hasNext() == false) goto L5;
        a r5 = (a) ZeusTransformUtils.preCheckCast(r4.next(), a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L18
        if (r5.a(r7, r8) == false) goto L11;
        r0.add(r5.f3289b);     // Catch: Throwable -> L18
        goto L11
    L16:
        monitor-exit(this);
        return r0;
    L18:
        th = move-exception;
        throw th;
    }

    public synchronized <T, R> List<Class<R>> b(Class<T> r7, Class<R> r8) {
        monitor-enter(this);
        ArrayList r0 = new ArrayList();     // Catch: Throwable -> L20
        Iterator<String> r1 = this.f3286a.iterator();     // Catch: Throwable -> L20
    L5:
        if (r1.hasNext() == false) goto L18;
        String r2 = (String) ZeusTransformUtils.preCheckCast(r1.next(), String.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L20
        List r3 = (List) ZeusTransformUtils.preCheckCast(this.f3287b.get(r2), List.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L20
        if (r3 == null) goto L5;
        Iterator r4 = r3.iterator();     // Catch: Throwable -> L20
    L11:
        if (r4.hasNext() == false) goto L5;
        a r5 = (a) ZeusTransformUtils.preCheckCast(r4.next(), a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L20
        if (r5.a(r7, r8) == false) goto L11;
        if (r0.contains(r5.f3288a) == true) goto L11;
        r0.add(r5.f3288a);     // Catch: Throwable -> L20
        goto L11
    L18:
        monitor-exit(this);
        return r0;
    L20:
        th = move-exception;
        throw th;
    }

    public synchronized <T, R> void a(String r3, k<T, R> r4, Class<T> r5, Class<R> r6) {
        monitor-enter(this);
        k r7 = (k) ZeusTransformUtils.wrapperContextForParams(r4, k.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L6
        a(r3).add(new a(r5, r6, r7));     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    private synchronized List<a<?, ?>> a(String r4) {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (this.f3286a.contains(r4) == true) goto L6;
        this.f3286a.add(r4);     // Catch: Throwable -> L11
    L6:
        List<a<?, ?>> r0 = (List) ZeusTransformUtils.preCheckCast(this.f3287b.get(r4), List.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L11
        if (r0 != null) goto L9;
        r0 = new ArrayList();     // Catch: Throwable -> L11
        this.f3287b.put(r4, r0);     // Catch: Throwable -> L11
    L9:
        monitor-exit(this);
        return r0;
    }
}
