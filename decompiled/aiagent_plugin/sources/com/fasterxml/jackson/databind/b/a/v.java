package com.fasterxml.jackson.databind.b.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* JADX INFO: compiled from: PropertyBasedCreator.java */
/* JADX INFO: loaded from: classes2.dex */
public final class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final int f12337a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final com.fasterxml.jackson.databind.b.y f12338b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected final HashMap<String, com.fasterxml.jackson.databind.b.v> f12339c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected final com.fasterxml.jackson.databind.b.v[] f12340d;

    /* JADX INFO: compiled from: PropertyBasedCreator.java */
    static class a extends HashMap<String, com.fasterxml.jackson.databind.b.v> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        protected final Locale f12341a;

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public /* synthetic */ Object get(Object r1) {
            return a(r1);
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public /* synthetic */ Object put(Object r3, Object r4) {
            return a((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin"), (com.fasterxml.jackson.databind.b.v) ZeusTransformUtils.preCheckCast(r4, com.fasterxml.jackson.databind.b.v.class, "com.obric.aiagent.plugin"));
        }

        @Deprecated
        public a() {
            this(Locale.getDefault());
        }

        public a(Locale r1) {
            this.f12341a = r1;
        }

        public static a a(Locale r1) {
            return new a(r1);
        }

        public com.fasterxml.jackson.databind.b.v a(Object r3) {
            return (com.fasterxml.jackson.databind.b.v) ZeusTransformUtils.preCheckCast(super.get(((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin")).toLowerCase(this.f12341a)), com.fasterxml.jackson.databind.b.v.class, "com.obric.aiagent.plugin");
        }

        public com.fasterxml.jackson.databind.b.v a(String r2, com.fasterxml.jackson.databind.b.v r3) {
            return (com.fasterxml.jackson.databind.b.v) ZeusTransformUtils.preCheckCast(super.put(r2.toLowerCase(this.f12341a), r3), com.fasterxml.jackson.databind.b.v.class, "com.obric.aiagent.plugin");
        }
    }

    public v(com.fasterxml.jackson.databind.h r7, com.fasterxml.jackson.databind.b.y r8, com.fasterxml.jackson.databind.b.v[] r9, boolean r10, boolean r11) {
        this.f12338b = r8;
        if (r10 == false) goto L5;
        this.f12339c = a.a(r7.c().s());
    L6:
        int r12 = r9.length;
        this.f12337a = r12;
        this.f12340d = new com.fasterxml.jackson.databind.b.v[r12];
        int r13 = 0;
        if (r11 == false) goto L19;
        com.fasterxml.jackson.databind.g r14 = r7.c();
        int r15 = r9.length;
        int r0 = 0;
    L9:
        if (r0 >= r15) goto L19;
        com.fasterxml.jackson.databind.b.v r1 = r9[r0];
        if (r1.f() == true) goto L18;
        List<com.fasterxml.jackson.databind.x> r2 = r1.a(r14);
        if (r2.isEmpty() == true) goto L18;
        Iterator<com.fasterxml.jackson.databind.x> r3 = r2.iterator();
    L16:
        if (r3.hasNext() == false) goto L18;
        this.f12339c.put(((com.fasterxml.jackson.databind.x) ZeusTransformUtils.preCheckCast(r3.next(), com.fasterxml.jackson.databind.x.class, "com.obric.aiagent.plugin")).b(), r1);
    L18:
        r0 = r0 + 1;
    L19:
        if (r13 >= r12) goto L24;
        com.fasterxml.jackson.databind.b.v r16 = r9[r13];
        this.f12340d[r13] = r16;
        if (r16.f() == true) goto L23;
        this.f12339c.put(r16.a(), r16);
    L23:
        r13 = r13 + 1;
        goto L19
    L24:
        return;
    L5:
        this.f12339c = new HashMap();
        goto L6
    }

    public static v a(com.fasterxml.jackson.databind.h r7, com.fasterxml.jackson.databind.b.y r8, com.fasterxml.jackson.databind.b.v[] r9, c r10) {
        int r0 = r9.length;
        com.fasterxml.jackson.databind.b.v[] r4 = new com.fasterxml.jackson.databind.b.v[r0];
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L11;
        com.fasterxml.jackson.databind.b.v r2 = r9[r1];
        if (r2.m() == true) goto L9;
        if (r2.i() == true) goto L9;
        r2 = r2.a(r7.a(r2.getType(), r2));
    L9:
        r4[r1] = r2;
        r1 = r1 + 1;
        goto L3
    L11:
        return new v(r7, r8, r4, r10.c(), true);
    }

    public static v a(com.fasterxml.jackson.databind.h r7, com.fasterxml.jackson.databind.b.y r8, com.fasterxml.jackson.databind.b.v[] r9, boolean r10) {
        int r0 = r9.length;
        com.fasterxml.jackson.databind.b.v[] r4 = new com.fasterxml.jackson.databind.b.v[r0];
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L9;
        com.fasterxml.jackson.databind.b.v r2 = r9[r1];
        if (r2.m() == true) goto L7;
        r2 = r2.a(r7.a(r2.getType(), r2));
    L7:
        r4[r1] = r2;
        r1 = r1 + 1;
        goto L3
    L9:
        return new v(r7, r8, r4, r10, false);
    }

    public com.fasterxml.jackson.databind.b.v a(String r2) {
        return (com.fasterxml.jackson.databind.b.v) ZeusTransformUtils.preCheckCast(this.f12339c.get(r2), com.fasterxml.jackson.databind.b.v.class, "com.obric.aiagent.plugin");
    }

    public y a(com.fasterxml.jackson.a.k r2, com.fasterxml.jackson.databind.h r3, s r4) {
        return new y(r2, r3, this.f12337a, r4);
    }

    public Object a(com.fasterxml.jackson.databind.h r2, y r3) {
        Object r1 = this.f12338b.a(r2, this.f12340d, r3);
        if (r1 == null) goto L7;
        r1 = r3.a(r2, r1);
        x r4 = r3.a();
    L5:
        if (r4 == null) goto L7;
        r4.a(r1);
        r4 = r4.f12342a;
    L7:
        return r1;
    }
}
