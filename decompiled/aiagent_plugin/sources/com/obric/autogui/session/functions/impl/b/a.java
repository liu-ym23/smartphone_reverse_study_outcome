package com.obric.autogui.session.functions.impl.b;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: UserOperateRecorder.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f31063a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final C0851a<String, Long> f31064b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final C0851a<String, Long> f31065c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final C0851a<String, Long> f31066d = null;

    /* JADX INFO: renamed from: com.obric.autogui.session.functions.impl.b.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: UserOperateRecorder.kt */
    private static final class C0851a<K, V> extends LinkedHashMap<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f31067a;

        public C0851a(int r1) {
            super(r1);
            this.f31067a = r1;
        }

        public Collection<Object> a() {
            return super.values();
        }

        public int b() {
            return super.size();
        }

        public Set<Map.Entry<Object, Object>> c() {
            return super.entrySet();
        }

        public Set<Object> d() {
            return super.keySet();
        }

        @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final Set<Map.Entry<K, V>> entrySet() {
            return (Set<Map.Entry<K, V>>) c();
        }

        @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final Set<K> keySet() {
            return (Set<K>) d();
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final int size() {
            return b();
        }

        @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final Collection<V> values() {
            return (Collection<V>) a();
        }

        @Override // java.util.LinkedHashMap
        public boolean removeEldestEntry(Map.Entry<K, V> r3) {
            o.e((Map.Entry) ZeusTransformUtils.wrapperContextForParams(r3, Map.Entry.class, "com.obric.aiagent.plugin"), "eldest");
            if (size() <= this.f31067a) goto L5;
            return true;
        L5:
            return false;
        }
    }

    private a() {
    }

    static {
        f31063a = new a();
        f31064b = new C0851a(16);
        f31065c = new C0851a(16);
        f31066d = new C0851a(16);
    }

    public final void a(String r5, long r6) {
        o.e(r5, "omniTaskId");
        C0851a<String, Long> r4 = f31064b;
        Long r0 = r4.getOrDefault(r5, 0L);
        o.c(r0, "getOrDefault(...)");
        long r1 = ((Number) ZeusTransformUtils.preCheckCast(r0, Number.class, "com.obric.aiagent.plugin")).longValue();
        ((Map) ZeusTransformUtils.preCheckCast(r4, Map.class, "com.obric.aiagent.plugin")).put(r5, Long.valueOf(r1 + r6));
    }

    public final void b(String r5, long r6) {
        o.e(r5, "omniTaskId");
        C0851a<String, Long> r4 = f31065c;
        Long r0 = r4.getOrDefault(r5, 0L);
        o.c(r0, "getOrDefault(...)");
        long r1 = ((Number) ZeusTransformUtils.preCheckCast(r0, Number.class, "com.obric.aiagent.plugin")).longValue();
        ((Map) ZeusTransformUtils.preCheckCast(r4, Map.class, "com.obric.aiagent.plugin")).put(r5, Long.valueOf(r1 + r6));
    }

    public final void c(String r5, long r6) {
        o.e(r5, "omniTaskId");
        C0851a<String, Long> r4 = f31066d;
        Long r0 = r4.getOrDefault(r5, 0L);
        o.c(r0, "getOrDefault(...)");
        long r1 = ((Number) ZeusTransformUtils.preCheckCast(r0, Number.class, "com.obric.aiagent.plugin")).longValue();
        ((Map) ZeusTransformUtils.preCheckCast(r4, Map.class, "com.obric.aiagent.plugin")).put(r5, Long.valueOf(r1 + r6));
    }

    public final long a(String r3) {
        o.e(r3, "omniTaskId");
        Long r2 = f31064b.getOrDefault(r3, 0L);
        o.c(r2, "getOrDefault(...)");
        return ((Number) ZeusTransformUtils.preCheckCast(r2, Number.class, "com.obric.aiagent.plugin")).longValue();
    }

    public final long b(String r3) {
        o.e(r3, "omniTaskId");
        Long r2 = f31065c.getOrDefault(r3, 0L);
        o.c(r2, "getOrDefault(...)");
        return ((Number) ZeusTransformUtils.preCheckCast(r2, Number.class, "com.obric.aiagent.plugin")).longValue();
    }

    public final long c(String r3) {
        o.e(r3, "omniTaskId");
        Long r2 = f31066d.getOrDefault(r3, 0L);
        o.c(r2, "getOrDefault(...)");
        return ((Number) ZeusTransformUtils.preCheckCast(r2, Number.class, "com.obric.aiagent.plugin")).longValue();
    }

    public final long d(String r5) {
        o.e(r5, "omniTaskId");
        return (a(r5) + b(r5)) + c(r5);
    }
}
