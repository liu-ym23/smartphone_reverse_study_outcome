package com.obric.agent;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: IntentCardDisplayPolicy.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final n f15202a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Object f15203b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final b f15204c = null;

    /* JADX INFO: compiled from: IntentCardDisplayPolicy.kt */
    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f15205a;

        public boolean equals(Object r7) {
            if (this != r7) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r7, a.class) == true) goto L8;
            return false;
        L8:
            a r8 = (a) ZeusTransformUtils.preCheckCast(r7, a.class, "com.obric.aiagent.plugin");
            if (this.f15205a == r8.f15205a) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return Long.hashCode(this.f15205a);
        }

        public String toString() {
            return "CachedPolicy(expiresAtMillis=" + this.f15205a + ')';
        }

        public a(long r1) {
            this.f15205a = r1;
        }

        public final long a() {
            return this.f15205a;
        }
    }

    /* JADX INFO: compiled from: IntentCardDisplayPolicy.kt */
    public static final class b extends LinkedHashMap<String, a> {
        b() {
            super(256, 0.75f, true);
        }

        public a a(String r2) {
            return (a) ZeusTransformUtils.preCheckCast(super.get(r2), a.class, "com.obric.aiagent.plugin");
        }

        public a a(String r1, a r2) {
            return (a) ZeusTransformUtils.preCheckCast(super.getOrDefault(r1, r2), a.class, "com.obric.aiagent.plugin");
        }

        public Collection<a> a() {
            return super.values();
        }

        public boolean a(a r1) {
            return super.containsValue(r1);
        }

        public int b() {
            return super.size();
        }

        public boolean b(String r1) {
            return super.containsKey(r1);
        }

        public boolean b(String r1, a r2) {
            return super.remove(r1, r2);
        }

        public a c(String r2) {
            return (a) ZeusTransformUtils.preCheckCast(super.remove(r2), a.class, "com.obric.aiagent.plugin");
        }

        public Set<Map.Entry<String, a>> c() {
            return super.entrySet();
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final boolean containsKey(Object r3) {
            if (ZeusTransformUtils.instanceOf(r3, String.class) == true) goto L7;
            return false;
        L7:
            return b((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin"));
        }

        @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final boolean containsValue(Object r3) {
            if (ZeusTransformUtils.instanceOf(r3, a.class) == true) goto L7;
            return false;
        L7:
            return a((a) ZeusTransformUtils.preCheckCast(r3, a.class, "com.obric.aiagent.plugin"));
        }

        public Set<String> d() {
            return super.keySet();
        }

        @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final Set<Map.Entry<String, a>> entrySet() {
            return c();
        }

        @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* synthetic */ Object get(Object r3) {
            if (ZeusTransformUtils.instanceOf(r3, String.class) == true) goto L7;
            return null;
        L7:
            return a((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin"));
        }

        @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.Map
        public final /* synthetic */ Object getOrDefault(Object r3, Object r4) {
            if (ZeusTransformUtils.instanceOf(r3, String.class) == true) goto L6;
            return r4;
        L6:
            return a((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin"), (a) ZeusTransformUtils.preCheckCast(r4, a.class, "com.obric.aiagent.plugin"));
        }

        @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final Set<String> keySet() {
            return d();
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* synthetic */ Object remove(Object r3) {
            if (ZeusTransformUtils.instanceOf(r3, String.class) == true) goto L7;
            return null;
        L7:
            return c((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin"));
        }

        @Override // java.util.HashMap, java.util.Map
        public final boolean remove(Object r3, Object r4) {
            if (ZeusTransformUtils.instanceOf(r3, String.class) == true) goto L6;
            return false;
        L6:
            if (ZeusTransformUtils.instanceOf(r4, a.class) == true) goto L9;
            return false;
        L9:
            return b((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin"), (a) ZeusTransformUtils.preCheckCast(r4, a.class, "com.obric.aiagent.plugin"));
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final int size() {
            return b();
        }

        @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final Collection<a> values() {
            return a();
        }

        @Override // java.util.LinkedHashMap
        public boolean removeEldestEntry(Map.Entry<String, a> r3) {
            Map.Entry r4 = (Map.Entry) ZeusTransformUtils.wrapperContextForParams(r3, Map.Entry.class, "com.obric.aiagent.plugin");
            if (size() <= 256) goto L5;
            return true;
        L5:
            return false;
        }
    }

    public static /* synthetic */ boolean lambda$nFUIHofWS9DkiYqkjWAsI9Rn5zk(long r0, Map.Entry r2) {
        return a(r0, r2);
    }

    private n() {
    }

    static {
        f15202a = new n();
        f15203b = new Object();
        f15204c = new b();
    }

    public final boolean a(Map<String, String> r2) {
        Map r1 = (Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.aiagent.plugin");
        if (r1 == null) goto L5;
        String r3 = (String) ZeusTransformUtils.preCheckCast(r1.get("o_skill_decode_card"), String.class, "com.obric.aiagent.plugin");
    L7:
        return d.h.b.o.a(r3, "1");
    L5:
        r3 = null;
        goto L7
    }

    public static /* synthetic */ void a(n r6, long r7, Map r9, long r10, int r12, Object r13) {
        Map<String, String> r3 = (Map) ZeusTransformUtils.wrapperContextForParams(r9, Map.class, "com.obric.aiagent.plugin");
        if ((r12 & 4) == 0) goto L5;
        r10 = System.currentTimeMillis();
    L5:
        r6.a(r7, r3, r10);
    }

    public final void a(long r3, Map<String, String> r5, long r6) {
        Map r2 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.aiagent.plugin");
        if (r3 >= 0) goto L5;
        return;
    L5:
        if (r2 == null) goto L20;
        String r4 = (String) ZeusTransformUtils.preCheckCast(r2.get("o_skill_decode_card"), String.class, "com.obric.aiagent.plugin");
        if (r4 == null) goto L22;
        String r7 = String.valueOf(r3);
        Object r8 = f15203b;
        monitor-enter(r8);
        f15202a.a(r6);     // Catch: Throwable -> L17
        if (d.h.b.o.a(r4, "1") == false) goto L14;
        ((Map) ZeusTransformUtils.preCheckCast(f15204c, Map.class, "com.obric.aiagent.plugin")).put(r7, new a(r6 + 1800000));     // Catch: Throwable -> L17
        d.x r9 = d.x.f38692a;     // Catch: Throwable -> L17
    L15:
        monitor-exit(r8);
        return;
    L14:
        f15204c.remove(r7);     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        throw th;
    L22:
        return;
    }

    public static /* synthetic */ boolean a(n r0, String r1, long r2, int r4, Object r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = System.currentTimeMillis();
    L6:
        return r0.a(r1, r2);
    }

    public final boolean a(String r7, long r8) {
        boolean r6 = false;
        if (r7 != null) goto L5;
    L25:
        return false;
    L5:
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L8;
        r7 = null;
    L8:
        if (r7 == null) goto L25;
        Object r0 = f15203b;
        monitor-enter(r0);
        b r2 = f15204c;     // Catch: Throwable -> L22
        a r3 = (a) ZeusTransformUtils.preCheckCast(r2.get(r7), a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L22
        if (r3 != null) goto L16;
    L20:
        monitor-exit(r0);
        return r6;
    L16:
        if (r3.a() > r8) goto L19;
        r2.remove(r7);     // Catch: Throwable -> L22
        goto L20
    L19:
        r6 = true;
    L22:
        th = move-exception;
        throw th;
    }

    public static /* synthetic */ boolean b(n r0, String r1, long r2, int r4, Object r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = System.currentTimeMillis();
    L6:
        return r0.b(r1, r2);
    }

    public final boolean b(String r1, long r2) {
        return a(r1, r2);
    }

    private final void a(final long r3) {
        Set<Map.Entry<String, a>> r2 = f15204c.entrySet();
        d.h.b.o.c(r2, "<get-entries>(...)");
        d.a.p.a((Iterable) ZeusTransformUtils.preCheckCast(r2, Iterable.class, "com.obric.aiagent.plugin"), new $$Lambda$n$nFUIHofWS9DkiYqkjWAsI9Rn5zk(r3));
    }

    private static final boolean a(long r2, Map.Entry r4) {
        Map.Entry r5 = (Map.Entry) ZeusTransformUtils.wrapperContextForParams(r4, Map.Entry.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r5, "it");
        if (((a) ZeusTransformUtils.preCheckCast(r5.getValue(), a.class, "com.obric.aiagent.plugin")).a() > r2) goto L5;
        return true;
    L5:
        return false;
    }
}
