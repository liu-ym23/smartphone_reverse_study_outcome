package com.fasterxml.jackson.databind.a;

import com.fasterxml.jackson.databind.r;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.util.Map;

/* JADX INFO: compiled from: CoercionConfigs.java */
/* JADX INFO: loaded from: classes2.dex */
public class d implements Serializable {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final int f12193e = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected b f12194a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final o f12195b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected o[] f12196c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected Map<Class<?>, o> f12197d;

    /* JADX INFO: renamed from: com.fasterxml.jackson.databind.a.d$1, reason: invalid class name */
    /* JADX INFO: compiled from: CoercionConfigs.java */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f12198a = null;

        static {
            int[] r0 = new int[e.values().length];
            f12198a = r0;
            r0[e.h.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            f12198a[e.f12202d.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            f12198a[e.f12201c.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    static {
        f12193e = com.fasterxml.jackson.databind.k.f.values().length;
    }

    public d() {
        this(b.f12186b, new o(), null, null);
    }

    public d(b r3, o r4, o[] r5, Map<Class<?>, o> r6) {
        Map<Class<?>, o> r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.aiagent.plugin");
        this.f12195b = r4;
        this.f12194a = r3;
        this.f12196c = r5;
        this.f12197d = r7;
    }

    public b a(com.fasterxml.jackson.databind.g r3, com.fasterxml.jackson.databind.k.f r4, Class<?> r5, e r6) {
        Map<Class<?>, o> r0 = this.f12197d;
        if (r0 == null) goto L10;
        if (r5 == null) goto L10;
        o r7 = (o) ZeusTransformUtils.preCheckCast(r0.get(r5), o.class, "com.obric.aiagent.plugin");
        if (r7 == null) goto L10;
        b r8 = r7.a(r6);
        if (r8 == null) goto L10;
        return r8;
    L10:
        o[] r9 = this.f12196c;
        if (r9 == null) goto L18;
        if (r4 == null) goto L18;
        o r10 = r9[r4.ordinal()];
        if (r10 == null) goto L18;
        b r11 = r10.a(r6);
        if (r11 == null) goto L18;
        return r11;
    L18:
        b r12 = this.f12195b.a(r6);
        if (r12 == null) goto L21;
        return r12;
    L21:
        int r13 = AnonymousClass1.f12198a[r6.ordinal()];
        if (r13 == 1) goto L64;
        if (r13 == 2) goto L35;
        if (r13 == 3) goto L29;
    L41:
        boolean r14 = a(r4);
        if (r14 == false) goto L48;
        if (r3.a(r.B) == true) goto L48;
        return b.f12185a;
    L48:
        if (r6 != e.j) goto L62;
        if (r14 == true) goto L60;
        if (r3.a(com.fasterxml.jackson.databind.i.t) == true) goto L60;
        if (r4 != com.fasterxml.jackson.databind.k.f.m) goto L58;
        return b.f12186b;
    L58:
        return b.f12185a;
    L60:
        return b.f12187c;
    L62:
        return this.f12194a;
    L29:
        if (r4 != com.fasterxml.jackson.databind.k.f.i) goto L41;
        if (r3.a(com.fasterxml.jackson.databind.i.g) == false) goto L41;
        return b.f12185a;
    L35:
        if (r4 != com.fasterxml.jackson.databind.k.f.f) goto L41;
        if (r3.a(com.fasterxml.jackson.databind.i.v) == false) goto L40;
        return b.f12186b;
    L40:
        return b.f12185a;
    L64:
        if (r3.a(com.fasterxml.jackson.databind.i.u) == false) goto L67;
        return b.f12187c;
    L67:
        return b.f12185a;
    }

    public b a(com.fasterxml.jackson.databind.g r4, com.fasterxml.jackson.databind.k.f r5, Class<?> r6, b r7) {
        Map<Class<?>, o> r0 = this.f12197d;
        Boolean r1 = null;
        if (r0 == null) goto L8;
        if (r6 == null) goto L8;
        o r8 = (o) ZeusTransformUtils.preCheckCast(r0.get(r6), o.class, "com.obric.aiagent.plugin");
        if (r8 == null) goto L8;
        r1 = r8.a();
        b r9 = r8.a(e.j);
    L9:
        o[] r2 = this.f12196c;
        if (r2 == null) goto L18;
        if (r5 == null) goto L18;
        o r3 = r2[r5.ordinal()];
        if (r3 == null) goto L18;
        if (r1 != null) goto L16;
        r1 = r3.a();
    L16:
        if (r9 != null) goto L18;
        r9 = r3.a(e.j);
    L18:
        if (r1 != null) goto L20;
        r1 = this.f12195b.a();
    L20:
        if (r9 != null) goto L23;
        r9 = this.f12195b.a(e.j);
    L23:
        if (Boolean.FALSE.equals(r1) == false) goto L25;
        return r7;
    L25:
        if (r9 == null) goto L28;
        return r9;
    L28:
        if (a(r5) == false) goto L32;
        return b.f12187c;
    L32:
        if (r4.a(com.fasterxml.jackson.databind.i.t) == true) goto L34;
        return r7;
    L34:
        return b.f12187c;
    L8:
        r9 = null;
        goto L9
    }

    public boolean a(com.fasterxml.jackson.databind.k.f r1) {
        if (r1 != com.fasterxml.jackson.databind.k.f.g) goto L5;
    L12:
        return true;
    L5:
        if (r1 == com.fasterxml.jackson.databind.k.f.f) goto L12;
        if (r1 == com.fasterxml.jackson.databind.k.f.h) goto L12;
        if (r1 == com.fasterxml.jackson.databind.k.f.l) goto L12;
        return false;
    }
}
