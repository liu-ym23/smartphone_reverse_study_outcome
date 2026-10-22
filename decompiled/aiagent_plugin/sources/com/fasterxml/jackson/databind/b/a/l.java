package com.fasterxml.jackson.databind.b.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: JavaUtilCollectionsDeserializers.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class l {

    /* JADX INFO: compiled from: JavaUtilCollectionsDeserializers.java */
    private static class a implements com.fasterxml.jackson.databind.l.j<Object, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final com.fasterxml.jackson.databind.k f12313a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f12314b;

        a(int r1, com.fasterxml.jackson.databind.k r2) {
            this.f12313a = r2;
            this.f12314b = r1;
        }

        @Override // com.fasterxml.jackson.databind.l.j
        public Object a(Object r3) {
            if (r3 != null) goto L6;
            return null;
        L6:
            switch(this.f12314b) {
                case 1: goto L26;
                case 2: goto L24;
                case 3: goto L22;
                case 4: goto L21;
                case 5: goto L19;
                case 6: goto L17;
                case 7: goto L15;
                case 8: goto L13;
                case 9: goto L11;
                case 10: goto L9;
                default: goto L7;
            };
        L7:
            return r3;
        L22:
            Map r4 = (Map) ZeusTransformUtils.preCheckCast(r3, Map.class, "com.obric.aiagent.plugin");
            a(r4.size());
            Map.Entry r2 = (Map.Entry) ZeusTransformUtils.preCheckCast(r4.entrySet().iterator().next(), Map.Entry.class, "com.obric.aiagent.plugin");
            return Collections.singletonMap(r2.getKey(), r2.getValue());
        L24:
            List r5 = (List) ZeusTransformUtils.preCheckCast(r3, List.class, "com.obric.aiagent.plugin");
            a(r5.size());
            return Collections.singletonList(r5.get(0));
        L26:
            Set r6 = (Set) ZeusTransformUtils.preCheckCast(r3, Set.class, "com.obric.aiagent.plugin");
            a(r6.size());
            return Collections.singleton(r6.iterator().next());
        L9:
            return Collections.synchronizedMap((Map) ZeusTransformUtils.preCheckCast(r3, Map.class, "com.obric.aiagent.plugin"));
        L11:
            return Collections.synchronizedList((List) ZeusTransformUtils.preCheckCast(r3, List.class, "com.obric.aiagent.plugin"));
        L13:
            return Collections.synchronizedCollection((Collection) ZeusTransformUtils.preCheckCast(r3, Collection.class, "com.obric.aiagent.plugin"));
        L15:
            return Collections.synchronizedSet((Set) ZeusTransformUtils.preCheckCast(r3, Set.class, "com.obric.aiagent.plugin"));
        L17:
            return Collections.unmodifiableMap((Map) ZeusTransformUtils.preCheckCast(r3, Map.class, "com.obric.aiagent.plugin"));
        L19:
            return Collections.unmodifiableList((List) ZeusTransformUtils.preCheckCast(r3, List.class, "com.obric.aiagent.plugin"));
        L21:
            return Collections.unmodifiableSet((Set) ZeusTransformUtils.preCheckCast(r3, Set.class, "com.obric.aiagent.plugin"));
        }

        @Override // com.fasterxml.jackson.databind.l.j
        public com.fasterxml.jackson.databind.k a(com.fasterxml.jackson.databind.k.o r1) {
            return this.f12313a;
        }

        @Override // com.fasterxml.jackson.databind.l.j
        public com.fasterxml.jackson.databind.k b(com.fasterxml.jackson.databind.k.o r1) {
            return this.f12313a;
        }

        private void a(int r3) {
            if (r3 != 1) goto L6;
            return;
        L6:
            throw new IllegalArgumentException("Can not deserialize Singleton container from " + r3 + " entries");
        }
    }

    public static com.fasterxml.jackson.databind.l<?> a(com.fasterxml.jackson.databind.h r6, com.fasterxml.jackson.databind.k r7) {
        String r8 = r7.e().getName();
        if (r8.startsWith("java.util.") == true) goto L5;
        return null;
    L5:
        String r0 = b(r8);
        if (r0 == null) goto L39;
        String r9 = f(r0);
        if (r9 != null) goto L10;
        String r10 = d(r0);
        if (r10 != null) goto L18;
        String r11 = e(r0);
        if (r11 != null) goto L26;
    L34:
        a r12 = null;
    L35:
        if (r12 != null) goto L38;
        return null;
    L38:
        return new com.fasterxml.jackson.databind.b.b.aa(r12);
    L26:
        if (r11.endsWith("Set") == false) goto L29;
        r12 = a(7, r7, Set.class);
        goto L35
    L29:
        if (r11.endsWith("List") == false) goto L32;
        r12 = a(9, r7, List.class);
        goto L35
    L32:
        if (r11.endsWith("Collection") == false) goto L34;
        r12 = a(8, r7, Collection.class);
        goto L35
    L18:
        if (r10.endsWith("Set") == false) goto L21;
        r12 = a(1, r7, Set.class);
        goto L35
    L21:
        if (r10.endsWith("List") == false) goto L34;
        r12 = a(2, r7, List.class);
        goto L35
    L10:
        if (r9.endsWith("Set") == false) goto L13;
        r12 = a(4, r7, Set.class);
        goto L35
    L13:
        if (r9.endsWith("List") == false) goto L34;
        r12 = a(5, r7, List.class);
        goto L35
    L39:
        String r1 = a(r8);
        if (r1 != null) goto L42;
        String r13 = c(r8);
        if (r13 != null) goto L49;
    L56:
        return null;
    L49:
        if (r13.contains("List") == false) goto L53;
        return new com.fasterxml.jackson.databind.b.b.aa(a(11, r7, List.class));
    L53:
        if (r13.contains("Set") == false) goto L56;
        return new com.fasterxml.jackson.databind.b.b.aa(a(4, r7, Set.class));
    L42:
        if (r1.contains("List") == true) goto L44;
        return null;
    L44:
        return new com.fasterxml.jackson.databind.b.b.aa(a(11, r7, List.class));
    }

    public static com.fasterxml.jackson.databind.l<?> b(com.fasterxml.jackson.databind.h r4, com.fasterxml.jackson.databind.k r5) {
        String r6 = r5.e().getName();
        String r0 = b(r6);
        if (r0 == null) goto L19;
        String r7 = f(r0);
        if (r7 != null) goto L7;
        String r8 = d(r0);
        if (r8 != null) goto L12;
        String r9 = e(r0);
        if (r9 != null) goto L17;
    L24:
        a r10 = null;
    L25:
        if (r10 != null) goto L28;
        return null;
    L28:
        return new com.fasterxml.jackson.databind.b.b.aa(r10);
    L17:
        if (r9.contains("Map") == false) goto L24;
        r10 = a(10, r5, Map.class);
        goto L25
    L12:
        if (r8.contains("Map") == false) goto L24;
        r10 = a(3, r5, Map.class);
        goto L25
    L7:
        if (r7.contains("Map") == false) goto L24;
        r10 = a(6, r5, Map.class);
        goto L25
    L19:
        String r11 = c(r6);
        if (r11 == null) goto L24;
        if (r11.contains("Map") == false) goto L24;
        r10 = a(6, r5, Map.class);
        goto L25
    }

    static a a(int r1, com.fasterxml.jackson.databind.k r2, Class<?> r3) {
        return new a(r1, r2.d(r3));
    }

    private static String a(String r1) {
        if (r1.startsWith("java.util.Arrays$") == true) goto L5;
        return null;
    L5:
        return r1.substring(17);
    }

    private static String b(String r1) {
        if (r1.startsWith("java.util.Collections$") == true) goto L5;
        return null;
    L5:
        return r1.substring(22);
    }

    private static String c(String r1) {
        if (r1.startsWith("java.util.ImmutableCollections$") == true) goto L5;
        return null;
    L5:
        return r1.substring(31);
    }

    private static String d(String r1) {
        if (r1.startsWith("Singleton") == true) goto L7;
        return null;
    L7:
        return r1.substring(9);
    }

    private static String e(String r1) {
        if (r1.startsWith("Synchronized") == true) goto L7;
        return null;
    L7:
        return r1.substring(12);
    }

    private static String f(String r1) {
        if (r1.startsWith("Unmodifiable") == true) goto L7;
        return null;
    L7:
        return r1.substring(12);
    }
}
