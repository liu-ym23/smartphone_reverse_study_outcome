package com.fasterxml.jackson.databind.b.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: ExternalTypeHandler.java */
/* JADX INFO: loaded from: classes2.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.fasterxml.jackson.databind.k f12292a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final b[] f12293b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Map<String, Object> f12294c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String[] f12295d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final com.fasterxml.jackson.databind.l.y[] f12296e;

    /* JADX INFO: compiled from: ExternalTypeHandler.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final com.fasterxml.jackson.databind.k f12297a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final List<b> f12298b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Map<String, Object> f12299c;

        public a(com.fasterxml.jackson.databind.k r2) {
            this.f12298b = new ArrayList();
            this.f12299c = new HashMap();
            this.f12297a = r2;
        }

        public void a(com.fasterxml.jackson.databind.b.v r4, com.fasterxml.jackson.databind.h.e r5) {
            Integer r0 = Integer.valueOf(this.f12298b.size());
            this.f12298b.add(new b(r4, r5));
            a(r4.a(), r0);
            a(r5.b(), r0);
        }

        private void a(String r3, Integer r4) {
            Object r0 = this.f12299c.get(r3);
            if (r0 != null) goto L6;
            this.f12299c.put(r3, r4);
            return;
        L6:
            if (ZeusTransformUtils.instanceOf(r0, List.class) == false) goto L8;
            ((List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.aiagent.plugin")).add(r4);
            return;
        L8:
            LinkedList r1 = new LinkedList();
            r1.add(r0);
            r1.add(r4);
            this.f12299c.put(r3, r1);
        }

        public g a(c r8) {
            int r0 = this.f12298b.size();
            b[] r3 = new b[r0];
            int r1 = 0;
        L3:
            if (r1 >= r0) goto L9;
            b r2 = (b) ZeusTransformUtils.preCheckCast(this.f12298b.get(r1), b.class, "com.obric.aiagent.plugin");
            com.fasterxml.jackson.databind.b.v r4 = r8.a(r2.c());
            if (r4 == null) goto L7;
            r2.a(r4);
        L7:
            r3[r1] = r2;
            r1 = r1 + 1;
            goto L3
        L9:
            return new g(this.f12297a, r3, this.f12299c, null, null);
        }
    }

    /* JADX INFO: compiled from: ExternalTypeHandler.java */
    private static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final com.fasterxml.jackson.databind.b.v f12300a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final com.fasterxml.jackson.databind.h.e f12301b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f12302c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private com.fasterxml.jackson.databind.b.v f12303d;

        public b(com.fasterxml.jackson.databind.b.v r1, com.fasterxml.jackson.databind.h.e r2) {
            this.f12300a = r1;
            this.f12301b = r2;
            this.f12302c = r2.b();
        }

        public void a(com.fasterxml.jackson.databind.b.v r1) {
            this.f12303d = r1;
        }

        public boolean a(String r1) {
            return r1.equals(this.f12302c);
        }

        public boolean a() {
            return this.f12301b.e();
        }

        public String b() {
            Class<?> r0 = this.f12301b.d();
            if (r0 != null) goto L6;
            return null;
        L6:
            return this.f12301b.c().a(null, r0);
        }

        public String c() {
            return this.f12302c;
        }

        public com.fasterxml.jackson.databind.b.v d() {
            return this.f12300a;
        }

        public com.fasterxml.jackson.databind.b.v e() {
            return this.f12303d;
        }
    }

    public g(com.fasterxml.jackson.databind.k r3, b[] r4, Map<String, Object> r5, String[] r6, com.fasterxml.jackson.databind.l.y[] r7) {
        Map<String, Object> r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.aiagent.plugin");
        this.f12292a = r3;
        this.f12293b = r4;
        this.f12294c = r8;
        this.f12295d = r6;
        this.f12296e = r7;
    }

    public g(g r2) {
        this.f12292a = r2.f12292a;
        b[] r0 = r2.f12293b;
        this.f12293b = r0;
        this.f12294c = r2.f12294c;
        int r3 = r0.length;
        this.f12295d = new String[r3];
        this.f12296e = new com.fasterxml.jackson.databind.l.y[r3];
    }

    public static a a(com.fasterxml.jackson.databind.k r1) {
        return new a(r1);
    }

    public g a() {
        return new g(this);
    }

    public boolean a(com.fasterxml.jackson.a.k r12, com.fasterxml.jackson.databind.h r13, String r14, Object r15) {
        Object r0 = this.f12294c.get(r14);
        boolean r1 = false;
        if (r0 != null) goto L5;
        return false;
    L5:
        String r9 = r12.x();
        if (ZeusTransformUtils.instanceOf(r0, List.class) == false) goto L15;
        Iterator r2 = ((List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.aiagent.plugin")).iterator();
    L9:
        if (r2.hasNext() == false) goto L13;
        if (a(r12, r13, r14, r15, r9, ((Integer) ZeusTransformUtils.preCheckCast(r2.next(), Integer.class, "com.obric.aiagent.plugin")).intValue()) == false) goto L9;
        r1 = true;
        goto L9
    L13:
        return r1;
    L15:
        return a(r12, r13, r14, r15, r9, ((Integer) ZeusTransformUtils.preCheckCast(r0, Integer.class, "com.obric.aiagent.plugin")).intValue());
    }

    private final boolean a(com.fasterxml.jackson.a.k r7, com.fasterxml.jackson.databind.h r8, String r9, Object r10, String r11, int r12) {
        boolean r0 = false;
        if (this.f12293b[r12].a(r9) == true) goto L6;
        return false;
    L6:
        if (r10 != null) goto L8;
    L10:
        if (r0 == false) goto L12;
        a(r7, r8, r10, r12, r11);
        this.f12296e[r12] = null;
    L13:
        return true;
    L12:
        this.f12295d[r12] = r11;
        goto L13
    L8:
        if (this.f12296e[r12] == null) goto L10;
        r0 = true;
        goto L10
    }

    public boolean b(com.fasterxml.jackson.a.k r11, com.fasterxml.jackson.databind.h r12, String r13, Object r14) {
        Object r0 = this.f12294c.get(r13);
        boolean r1 = false;
        if (r0 != null) goto L6;
        return false;
    L6:
        if (ZeusTransformUtils.instanceOf(r0, List.class) == false) goto L18;
        Iterator r15 = ((List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.aiagent.plugin")).iterator();
        Integer r2 = (Integer) ZeusTransformUtils.preCheckCast(r15.next(), Integer.class, "com.obric.aiagent.plugin");
        if (this.f12293b[r2.intValue()].a(r13) == false) goto L13;
        String r16 = r11.x();
        r11.k();
        this.f12295d[r2.intValue()] = r16;
    L11:
        if (r15.hasNext() == false) goto L17;
        this.f12295d[((Integer) ZeusTransformUtils.preCheckCast(r15.next(), Integer.class, "com.obric.aiagent.plugin")).intValue()] = r16;
    L17:
        return true;
    L13:
        com.fasterxml.jackson.databind.l.y r17 = r12.b(r11);
        this.f12296e[r2.intValue()] = r17;
    L15:
        if (r15.hasNext() == false) goto L17;
        this.f12296e[((Integer) ZeusTransformUtils.preCheckCast(r15.next(), Integer.class, "com.obric.aiagent.plugin")).intValue()] = r17;
        goto L15
    L18:
        int r3 = ((Integer) ZeusTransformUtils.preCheckCast(r0, Integer.class, "com.obric.aiagent.plugin")).intValue();
        if (this.f12293b[r3].a(r13) == false) goto L25;
        this.f12295d[r3] = r11.R();
        r11.k();
        if (r14 != null) goto L23;
    L30:
        if (r1 == false) goto L32;
        String[] r18 = this.f12295d;
        String r9 = r18[r3];
        r18[r3] = null;
        a(r11, r12, r14, r3, r9);
        this.f12296e[r3] = null;
    L32:
        return true;
    L23:
        if (this.f12296e[r3] == null) goto L30;
    L24:
        r1 = true;
        goto L30
    L25:
        this.f12296e[r3] = r12.b(r11);
        if (r14 == null) goto L30;
        if (this.f12295d[r3] == null) goto L30;
        goto L30
    }

    public Object a(com.fasterxml.jackson.a.k r10, com.fasterxml.jackson.databind.h r11, Object r12) {
        int r0 = this.f12293b.length;
        int r8 = 0;
    L3:
        if (r8 >= r0) goto L30;
        String r2 = this.f12295d[r8];
        b r3 = this.f12293b[r8];
        if (r2 != null) goto L21;
        com.fasterxml.jackson.databind.l.y r5 = this.f12296e[r8];
        if (r5 == null) goto L29;
        if (r5.q().g() == false) goto L15;
        com.fasterxml.jackson.a.k r6 = r5.d(r10);
        r6.g();
        com.fasterxml.jackson.databind.b.v r7 = r3.d();
        Object r9 = com.fasterxml.jackson.databind.h.e.a(r6, r11, r7.getType());
        if (r9 == null) goto L15;
        r7.a(r12, r9);
    L15:
        if (r3.a() == true) goto L17;
        r11.a(this.f12292a, r3.d().a(), "Missing external type id property '%s' (and no 'defaultImpl' specified)", new Object[]{r3.c()});
    L28:
        a(r10, r11, r12, r8, r2);
        goto L29
    L17:
        r2 = r3.b();
        if (r2 != null) goto L28;
        r11.a(this.f12292a, r3.d().a(), "Invalid default type id for property '%s': `null` returned by TypeIdResolver", new Object[]{r3.c()});
    L29:
        r8 = r8 + 1;
        goto L3
    L21:
        if (this.f12296e[r8] != null) goto L28;
        com.fasterxml.jackson.databind.b.v r13 = r3.d();
        if (r13.s() == false) goto L25;
    L26:
        r11.c(r12.getClass(), r13.a(), "Missing property '%s' for external type id '%s'", new Object[]{r13.a(), r3.c()});
    L27:
        return r12;
    L25:
        if (r11.a(com.fasterxml.jackson.databind.i.n) == false) goto L27;
    L30:
        return r12;
    }

    public Object a(com.fasterxml.jackson.a.k r12, com.fasterxml.jackson.databind.h r13, y r14, v r15) {
        int r0 = this.f12293b.length;
        Object[] r1 = new Object[r0];
        int r2 = 0;
        int r3 = 0;
    L3:
        if (r3 >= r0) goto L37;
        String r4 = this.f12295d[r3];
        b r5 = this.f12293b[r3];
        if (r4 != null) goto L15;
        com.fasterxml.jackson.databind.l.y r7 = this.f12296e[r3];
        if (r7 == null) goto L36;
        if (r7.q() == com.fasterxml.jackson.a.n.m) goto L36;
        if (r5.a() == true) goto L14;
        r13.a(this.f12292a, r5.d().a(), "Missing external type id property '%s'", new Object[]{r5.c()});
        String r6 = r4;
    L23:
        if (this.f12296e[r3] == null) goto L25;
        r1[r3] = a(r12, r13, r3, r6);
    L25:
        com.fasterxml.jackson.databind.b.v r8 = r5.d();
        if (r8.g() < 0) goto L36;
        r14.a(r8, r1[r3]);
        com.fasterxml.jackson.databind.b.v r9 = r5.e();
        if (r9 == null) goto L36;
        if (r9.g() < 0) goto L36;
        Object r10 = r6;
        if (r9.getType().a(String.class) == true) goto L35;
        com.fasterxml.jackson.databind.l.y r11 = r13.a(r12);
        r11.b(r6);
        Object r16 = r9.o().a(r11.p(), r13);
        r11.close();
        r10 = r16;
    L35:
        r14.a(r9, r10);
        goto L36
    L14:
        r6 = r5.b();
    L36:
        r3 = r3 + 1;
        goto L3
    L15:
        r6 = r4;
        if (this.f12296e[r3] != null) goto L23;
        com.fasterxml.jackson.databind.b.v r17 = r5.d();
        if (r17.s() == true) goto L21;
        r6 = r4;
        if (r13.a(com.fasterxml.jackson.databind.i.n) == false) goto L23;
    L21:
        r13.a(this.f12292a, r17.a(), "Missing property '%s' for external type id '%s'", new Object[]{r17.a(), this.f12293b[r3].c()});
        r6 = r4;
        goto L23
    L37:
        Object r18 = r15.a(r13, r14);
    L38:
        if (r2 >= r0) goto L43;
        com.fasterxml.jackson.databind.b.v r19 = this.f12293b[r2].d();
        if (r19.g() >= 0) goto L42;
        r19.a(r18, r1[r2]);
    L42:
        r2 = r2 + 1;
        goto L38
    L43:
        return r18;
    }

    public final Object a(com.fasterxml.jackson.a.k r4, com.fasterxml.jackson.databind.h r5, int r6, String r7) {
        com.fasterxml.jackson.a.k r0 = this.f12296e[r6].d(r4);
        if (r0.g() != com.fasterxml.jackson.a.n.m) goto L6;
        return null;
    L6:
        com.fasterxml.jackson.databind.l.y r1 = r5.a(r4);
        r1.h();
        r1.b(r7);
        r1.b(r0);
        r1.i();
        com.fasterxml.jackson.a.k r8 = r1.d(r4);
        r8.g();
        return this.f12293b[r6].d().a(r8, r5);
    }

    public final void a(com.fasterxml.jackson.a.k r4, com.fasterxml.jackson.databind.h r5, Object r6, int r7, String r8) {
        if (r8 != null) goto L4;
        r5.a(this.f12292a, "Internal error in external Type Id handling: `null` type id passed", new Object[0]);
    L4:
        com.fasterxml.jackson.a.k r0 = this.f12296e[r7].d(r4);
        if (r0.g() != com.fasterxml.jackson.a.n.m) goto L8;
        this.f12293b[r7].d().a(r6, null);
        return;
    L8:
        com.fasterxml.jackson.databind.l.y r1 = r5.a(r4);
        r1.h();
        r1.b(r8);
        r1.b(r0);
        r1.i();
        com.fasterxml.jackson.a.k r9 = r1.d(r4);
        r9.g();
        this.f12293b[r7].d().a(r9, r5, r6);
    }
}
