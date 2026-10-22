package com.bumptech.glide.load.engine.a;

import com.bumptech.glide.load.engine.a.m;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: GroupedLinkedMap.java */
/* JADX INFO: loaded from: classes.dex */
class h<K extends m, V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final a<K, V> f3531a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map<K, a<K, V>> f3532b;

    /* JADX INFO: compiled from: GroupedLinkedMap.java */
    private static class a<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final K f3533a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        a<K, V> f3534b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        a<K, V> f3535c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private List<V> f3536d;

        a() {
            this(null);
        }

        a(K r1) {
            this.f3535c = this;
            this.f3534b = this;
            this.f3533a = r1;
        }

        public V a() {
            int r0 = b();
            if (r0 > 0) goto L7;
            return null;
        L7:
            return this.f3536d.remove(r0 - 1);
        }

        public int b() {
            List<V> r0 = this.f3536d;
            if (r0 != null) goto L7;
            return 0;
        L7:
            return r0.size();
        }

        public void a(V r2) {
            if (this.f3536d != null) goto L5;
            this.f3536d = new ArrayList();
        L5:
            this.f3536d.add(r2);
        }
    }

    h() {
        this.f3531a = new a();
        this.f3532b = new HashMap();
    }

    public void a(K r4, V r5) {
        m r6 = (m) ZeusTransformUtils.wrapperContextForParams(r4, m.class, "com.obric.aiagent.plugin");
        a<K, V> r0 = (a) ZeusTransformUtils.preCheckCast(this.f3532b.get(r6), a.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L5;
        r0 = new a(r6);
        b(r0);
        this.f3532b.put((K) r6, r0);
    L6:
        r0.a(r5);
        return;
    L5:
        r6.a();
        goto L6
    }

    public V a(K r4) {
        m r5 = (m) ZeusTransformUtils.wrapperContextForParams(r4, m.class, "com.obric.aiagent.plugin");
        a<K, V> r0 = (a) ZeusTransformUtils.preCheckCast(this.f3532b.get(r5), a.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L5;
        r0 = new a(r5);
        this.f3532b.put((K) r5, r0);
    L6:
        a(r0);
        return r0.a();
    L5:
        r5.a();
        goto L6
    }

    public V a() {
        a r0 = this.f3531a.f3535c;
    L4:
        if (r0.equals(this.f3531a) == true) goto L9;
        V r1 = (V) r0.a();
        if (r1 != null) goto L7;
        d(r0);
        this.f3532b.remove(r0.f3533a);
        ((m) ZeusTransformUtils.preCheckCast(r0.f3533a, m.class, "com.obric.aiagent.plugin")).a();
        r0 = r0.f3535c;
        goto L4
    L7:
        return r1;
    L9:
        return null;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder("GroupedLinkedMap( ");
        a r1 = this.f3531a.f3534b;
        boolean r2 = false;
    L4:
        if (r1.equals(this.f3531a) == true) goto L6;
        r2 = true;
        r0.append('{').append(r1.f3533a).append(':').append(r1.b()).append("}, ");
        r1 = r1.f3534b;
        goto L4
    L6:
        if (r2 == false) goto L9;
        r0.delete(r0.length() - 2, r0.length());
    L9:
        return r0.append(" )").toString();
    }

    private void a(a<K, V> r2) {
        d(r2);
        r2.f3535c = this.f3531a;
        r2.f3534b = this.f3531a.f3534b;
        c(r2);
    }

    private void b(a<K, V> r2) {
        d(r2);
        r2.f3535c = this.f3531a.f3535c;
        r2.f3534b = this.f3531a;
        c(r2);
    }

    private static <K, V> void c(a<K, V> r1) {
        r1.f3534b.f3535c = r1;
        r1.f3535c.f3534b = r1;
    }

    private static <K, V> void d(a<K, V> r2) {
        a<K, V> r0 = r2.f3535c;
        r0.f3534b = r2.f3534b;
        a<K, V> r1 = r2.f3534b;
        r1.f3535c = r2.f3535c;
    }
}
