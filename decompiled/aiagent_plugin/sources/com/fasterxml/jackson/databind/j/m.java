package com.fasterxml.jackson.databind.j;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.aa;
import com.fasterxml.jackson.databind.ab;
import com.fasterxml.jackson.databind.ac;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: PropertyBuilder.java */
/* JADX INFO: loaded from: classes2.dex */
public class m {
    private static final Object g = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final aa f12948a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final com.fasterxml.jackson.databind.c f12949b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected final com.fasterxml.jackson.databind.b f12950c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected Object f12951d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected final JsonInclude.Value f12952e;
    protected final boolean f;

    /* JADX INFO: renamed from: com.fasterxml.jackson.databind.j.m$1, reason: invalid class name */
    /* JADX INFO: compiled from: PropertyBuilder.java */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f12953a = null;

        static {
            int[] r0 = new int[JsonInclude.Include.values().length];
            f12953a = r0;
            r0[JsonInclude.Include.NON_DEFAULT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L16:
            f12953a[JsonInclude.Include.NON_ABSENT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L20:
            f12953a[JsonInclude.Include.NON_EMPTY.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L26:
            f12953a[JsonInclude.Include.CUSTOM.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L18:
            f12953a[JsonInclude.Include.NON_NULL.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L22:
            f12953a[JsonInclude.Include.ALWAYS.ordinal()] = 6;     // Catch: NoSuchFieldError -> L15
            return;
        }
    }

    static {
        g = Boolean.FALSE;
    }

    public m(aa r3, com.fasterxml.jackson.databind.c r4) {
        this.f12948a = r3;
        this.f12949b = r4;
        JsonInclude.Value r5 = JsonInclude.Value.merge(r4.a(JsonInclude.Value.empty()), r3.a(r4.a(), JsonInclude.Value.empty()));
        this.f12952e = JsonInclude.Value.merge(r3.z(), r5);
        if (r5.getValueInclusion() != JsonInclude.Include.NON_DEFAULT) goto L5;
        boolean r6 = true;
    L6:
        this.f = r6;
        this.f12950c = r3.j();
        return;
    L5:
        r6 = false;
        goto L6
    }

    public d a(ac r16, com.fasterxml.jackson.databind.e.t r17, com.fasterxml.jackson.databind.k r18, com.fasterxml.jackson.databind.p<?> r19, com.fasterxml.jackson.databind.h.h r20, com.fasterxml.jackson.databind.h.h r21, com.fasterxml.jackson.databind.e.j r22, boolean r23) {
        boolean r3 = false;
        com.fasterxml.jackson.databind.k r4 = a(r22, r23, r18);     // Catch: com.fasterxml.jackson.databind.m -> L80
        if (r21 == null) goto L11;
        if (r4 != null) goto L8;
        r4 = r18;
    L8:
        if (r4.x() != null) goto L10;
        r16.a(this.f12949b, r17, "serialization type " + r4 + " has no content", new Object[0]);
    L10:
        com.fasterxml.jackson.databind.k r0 = r4.b(r21);
        r0.x();
        com.fasterxml.jackson.databind.k r8 = r0;
    L12:
        Object r5 = null;
        if (r8 != null) goto L15;
        com.fasterxml.jackson.databind.k r1 = r18;
    L16:
        com.fasterxml.jackson.databind.e.j r6 = r17.s();
        if (r6 == null) goto L19;
        JsonInclude.Value r2 = this.f12948a.a(r1.e(), r6.c(), this.f12952e).withOverrides(r17.B());
        JsonInclude.Include r7 = r2.getValueInclusion();
        if (r7 != JsonInclude.Include.USE_DEFAULTS) goto L23;
        r7 = JsonInclude.Include.ALWAYS;
    L23:
        int r9 = AnonymousClass1.f12953a[r7.ordinal()];
        if (r9 == 1) goto L54;
        if (r9 == 2) goto L49;
        if (r9 != 3) goto L30;
        Object r10 = d.f12939c;
    L47:
        Object r11 = r10;
    L52:
        boolean r12 = true;
    L70:
        Class<?>[] r13 = r17.w();
        if (r13 != null) goto L73;
        r13 = this.f12949b.x();
    L73:
        d r14 = a(r17, r22, this.f12949b.f(), r18, r19, r20, r8, r12, r11, r13);
        Object r15 = this.f12950c.p(r22);
        if (r15 == null) goto L76;
        r14.b(r16.b(r22, r15));
    L76:
        com.fasterxml.jackson.databind.l.q r24 = this.f12950c.c(r22);
        if (r24 != null) goto L79;
        return r14;
    L79:
        return r14.b(r24);
    L30:
        if (r9 != 4) goto L32;
        r10 = r16.a(r17, r2.getValueFilter());
        if (r10 == null) goto L47;
        r11 = r10;
        r12 = r16.b(r10);
        goto L70
    L32:
        if (r9 != 5) goto L35;
        r3 = true;
    L35:
        ab r25 = ab.t;
        if (r1.q() == true) goto L38;
    L41:
        r12 = r3;
        r11 = r5;
        goto L70
    L38:
        if (this.f12948a.a(r25) == true) goto L41;
        Object r26 = d.f12939c;
    L40:
        r11 = r26;
        r12 = r3;
        goto L70
    L49:
        if (r1.a() == false) goto L51;
        r10 = d.f12939c;
    L51:
        r11 = r5;
        goto L52
    L54:
        if (this.f == false) goto L64;
        Object r27 = a();
        if (r27 == null) goto L64;
        if (r16.a(com.fasterxml.jackson.databind.r.n) == false) goto L89;
        r22.a(this.f12948a.a(com.fasterxml.jackson.databind.r.o));
    L89:
        r5 = r22.b(r27);     // Catch: Exception -> L62
    L65:
        if (r5 == null) goto L51;
        if (r5.getClass().isArray() == false) goto L41;
        r26 = com.fasterxml.jackson.databind.l.c.a(r5);
    L62:
        e = move-exception;
        a(e, r17.a(), r27);
    L64:
        r5 = com.fasterxml.jackson.databind.l.e.a(r1);
        r3 = true;
        goto L65
    L19:
        return (d) ZeusTransformUtils.preCheckCast(r16.a(this.f12949b, r17, "could not determine property type", new Object[0]), d.class, "com.obric.aiagent.plugin");
    L15:
        r1 = r8;
        goto L16
    L11:
        r8 = r4;
    L80:
        e = move-exception;
        if (r17 != null) goto L86;
        return (d) ZeusTransformUtils.preCheckCast(r16.b(r18, com.fasterxml.jackson.databind.l.h.h(e)), d.class, "com.obric.aiagent.plugin");
    L86:
        return (d) ZeusTransformUtils.preCheckCast(r16.a(this.f12949b, r17, com.fasterxml.jackson.databind.l.h.h(e), new Object[0]), d.class, "com.obric.aiagent.plugin");
    }

    public d a(com.fasterxml.jackson.databind.e.t r13, com.fasterxml.jackson.databind.e.j r14, com.fasterxml.jackson.databind.l.b r15, com.fasterxml.jackson.databind.k r16, com.fasterxml.jackson.databind.p<?> r17, com.fasterxml.jackson.databind.h.h r18, com.fasterxml.jackson.databind.k r19, boolean r20, Object r21, Class<?>[] r22) {
        return new d(r13, r14, (com.fasterxml.jackson.databind.l.b) ZeusTransformUtils.wrapperContextForParams(r15, com.fasterxml.jackson.databind.l.b.class, "com.obric.aiagent.plugin"), r16, r17, r18, r19, r20, r21, r22);
    }

    public com.fasterxml.jackson.databind.k a(com.fasterxml.jackson.databind.e.b r4, boolean r5, com.fasterxml.jackson.databind.k r6) {
        com.fasterxml.jackson.databind.k r0 = this.f12950c.a(this.f12948a, r4, r6);
        boolean r1 = true;
        if (r0 == r6) goto L12;
        Class<?> r7 = r0.e();
        Class<?> r8 = r6.e();
        if (r7.isAssignableFrom(r8) == false) goto L8;
    L9:
        r6 = r0;
        r5 = true;
        goto L12
    L8:
        if (r8.isAssignableFrom(r7) == true) goto L9;
        throw new IllegalArgumentException("Illegal concrete-type annotation for method '" + r4.b() + "': class " + r7.getName() + " not a super-type of (declared) class " + r8.getName());
    L12:
        JsonSerialize.Typing r3 = this.f12950c.q(r4);
        if (r3 != null) goto L15;
    L21:
        if (r5 == true) goto L23;
        return null;
    L23:
        return r6.d();
    L15:
        if (r3 == JsonSerialize.Typing.DEFAULT_TYPING) goto L21;
        if (r3 == JsonSerialize.Typing.STATIC) goto L20;
        r1 = false;
    L20:
        r5 = r1;
        goto L21
    }

    public Object a() {
        Object r0 = this.f12951d;
        if (r0 != null) goto L9;
        r0 = this.f12949b.a(this.f12948a.g());
        if (r0 != null) goto L7;
        r0 = g;
    L7:
        this.f12951d = r0;
    L9:
        if (r0 != g) goto L12;
        return null;
    L12:
        return this.f12951d;
    }

    public Object a(Exception r2, String r3, Object r4) {
    L3:
        if (r2.getCause() == null) goto L5;
        Throwable r5 = r5.getCause();
        goto L3
    L5:
        com.fasterxml.jackson.databind.l.h.a(r5);
        com.fasterxml.jackson.databind.l.h.b(r5);
        throw new IllegalArgumentException("Failed to get property '" + r3 + "' of default " + r4.getClass().getName() + " instance");
    }
}
