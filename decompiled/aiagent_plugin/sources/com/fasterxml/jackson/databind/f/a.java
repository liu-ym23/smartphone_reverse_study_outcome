package com.fasterxml.jackson.databind.f;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.e.f;
import com.fasterxml.jackson.databind.g;
import com.fasterxml.jackson.databind.h;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: JDK14Util.java */
/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: com.fasterxml.jackson.databind.f.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: JDK14Util.java */
    static class C0272a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        protected final com.fasterxml.jackson.databind.c f12691a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        protected final g f12692b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        protected final com.fasterxml.jackson.databind.b f12693c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        protected final List<f> f12694d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        protected final f f12695e;
        protected final b[] f;

        C0272a(h r5, com.fasterxml.jackson.databind.c r6) {
            this.f12691a = r6;
            this.f12693c = r5.f();
            this.f12692b = r5.c();
            b[] r7 = c.a().b(r6.a());
            this.f = r7;
            int r8 = r7.length;
            if (r8 != 0) goto L5;
            f r9 = r6.n();
            this.f12694d = Collections.singletonList(r9);
        L19:
            if (r9 == null) goto L23;
            this.f12695e = r9;
            return;
        L23:
            throw new IllegalArgumentException("Failed to find the canonical Record constructor of type " + com.fasterxml.jackson.databind.l.h.b(this.f12691a.getType()));
        L5:
            List<f> r10 = r6.j();
            this.f12694d = r10;
            Iterator<f> r11 = r10.iterator();
        L7:
            if (r11.hasNext() == false) goto L18;
            f r0 = (f) ZeusTransformUtils.preCheckCast(r11.next(), f.class, "com.obric.aiagent.plugin");
            if (r0.e() != r8) goto L7;
            int r1 = 0;
        L12:
            if (r1 >= r8) goto L17;
            if (r0.a(r1).equals(this.f[r1].f12696a) == false) goto L7;
            r1 = r1 + 1;
            goto L12
        L17:
            r9 = r0;
            goto L19
        L18:
            r9 = null;
            goto L19
        }

        public f a(List<String> r7) {
            List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.aiagent.plugin");
            Iterator<f> r0 = this.f12694d.iterator();
        L4:
            if (r0.hasNext() == false) goto L16;
            f r2 = (f) ZeusTransformUtils.preCheckCast(r0.next(), f.class, "com.obric.aiagent.plugin");
            JsonCreator.Mode r3 = this.f12693c.d(this.f12692b, r2);
            if (r3 == null) goto L4;
            if (JsonCreator.Mode.DISABLED == r3) goto L4;
            if (JsonCreator.Mode.DELEGATING == r3) goto L12;
            if (r2 == this.f12695e) goto L4;
            return null;
        L12:
            return null;
        L16:
            b[] r1 = this.f;
            int r4 = r1.length;
            int r5 = 0;
        L17:
            if (r5 >= r4) goto L20;
            r8.add(r1[r5].f12697b);
            r5 = r5 + 1;
            goto L17
        L20:
            return this.f12695e;
        }
    }

    /* JADX INFO: compiled from: JDK14Util.java */
    static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Class<?> f12696a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f12697b;

        public b(Class<?> r1, String r2) {
            this.f12696a = r1;
            this.f12697b = r2;
        }
    }

    /* JADX INFO: compiled from: JDK14Util.java */
    static class c {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final c f12698d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final RuntimeException f12699e = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Method f12700a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Method f12701b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Method f12702c;

        static {
            c r0 = null;
            e = null;
            r0 = new c();     // Catch: RuntimeException -> L5
        L6:
            f12698d = r0;
            f12699e = e;
            return;
        L5:
            e = e;
            goto L6
        }

        private c() {
            this.f12700a = Class.class.getMethod("getRecordComponents", new Class[0]);     // Catch: Exception -> L5
            Class r1 = ZeusTransformUtils.forName("java.lang.reflect.RecordComponent", "com.obric.aiagent.plugin");     // Catch: Exception -> L5
            this.f12701b = r1.getMethod("getName", new Class[0]);     // Catch: Exception -> L5
            this.f12702c = r1.getMethod("getType", new Class[0]);     // Catch: Exception -> L5
            return;
        L5:
            e = move-exception;
            throw new RuntimeException(String.format("Failed to access Methods needed to support `java.lang.Record`: (%s) %s", new Object[]{e.getClass().getName(), e.getMessage()}), e);
        }

        public static c a() {
            RuntimeException r0 = f12699e;
            if (r0 == null) goto L5;
            throw r0;
        L5:
            return f12698d;
        }

        public String[] a(Class<?> r8) {
            Object[] r0 = c(r8);
            String[] r1 = new String[r0.length];
            int r3 = 0;
        L4:
            if (r3 >= r0.length) goto L10;
            r1[r3] = (String) ZeusTransformUtils.preCheckCast(this.f12701b.invoke(r0[r3], new Object[0]), String.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L7
            r3 = r3 + 1;
        L7:
            e = move-exception;
            throw new IllegalArgumentException(String.format("Failed to access name of field #%d (of %d) of Record type %s", new Object[]{Integer.valueOf(r3), Integer.valueOf(r0.length), com.fasterxml.jackson.databind.l.h.h(r8)}), e);
        L10:
            return r1;
        }

        public b[] b(Class<?> r13) {
            Object[] r1 = c(r13);
            b[] r2 = new b[r1.length];
            int r4 = 0;
        L4:
            if (r4 >= r1.length) goto L15;
            r2[r4] = new b((Class) ZeusTransformUtils.preCheckCast(this.f12702c.invoke(r1[r4], new Object[0]), Class.class, "com.obric.aiagent.plugin"), (String) ZeusTransformUtils.preCheckCast(this.f12701b.invoke(r1[r4], new Object[0]), String.class, "com.obric.aiagent.plugin"));
            r4 = r4 + 1;
        L9:
            e = move-exception;
            throw new IllegalArgumentException(String.format("Failed to access type of field #%d (of %d) of Record type %s", new Object[]{Integer.valueOf(r4), Integer.valueOf(r1.length), com.fasterxml.jackson.databind.l.h.h(r13)}), e);
        L12:
            e = move-exception;
            throw new IllegalArgumentException(String.format("Failed to access name of field #%d (of %d) of Record type %s", new Object[]{Integer.valueOf(r4), Integer.valueOf(r1.length), com.fasterxml.jackson.databind.l.h.h(r13)}), e);
        L15:
            return r2;
        }

        public Object[] c(Class<?> r3) {
            return (Object[]) ZeusTransformUtils.preCheckCast((Object[]) ZeusTransformUtils.preCheckCast(this.f12700a.invoke(r3, new Object[0]), Object[].class, "com.obric.aiagent.plugin"), Object[].class, "com.obric.aiagent.plugin");
        L6:
            throw new IllegalArgumentException("Failed to access RecordComponents of type " + com.fasterxml.jackson.databind.l.h.h(r3));
        }
    }

    public static String[] a(Class<?> r1) {
        return c.a().a(r1);
    }

    public static f a(h r2, com.fasterxml.jackson.databind.c r3, List<String> r4) {
        List<String> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        return new C0272a(r2, r3).a(r5);
    }
}
