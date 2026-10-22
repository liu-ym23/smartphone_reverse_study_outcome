package com.fasterxml.jackson.databind.j;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ac;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;

/* JADX INFO: compiled from: VirtualBeanPropertyWriter.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class t extends d implements Serializable {
    public abstract t a(com.fasterxml.jackson.databind.a.m<?> r1, com.fasterxml.jackson.databind.e.d r2, com.fasterxml.jackson.databind.e.t r3, com.fasterxml.jackson.databind.k r4);

    public abstract Object e(Object r1, com.fasterxml.jackson.a.h r2, ac r3);

    public t() {
    }

    public t(com.fasterxml.jackson.databind.e.t r13, com.fasterxml.jackson.databind.l.b r14, com.fasterxml.jackson.databind.k r15, com.fasterxml.jackson.databind.p<?> r16, com.fasterxml.jackson.databind.h.h r17, com.fasterxml.jackson.databind.k r18, JsonInclude.Value r19, Class<?>[] r20) {
        com.fasterxml.jackson.databind.l.b r4 = (com.fasterxml.jackson.databind.l.b) ZeusTransformUtils.wrapperContextForParams(r14, com.fasterxml.jackson.databind.l.b.class, "com.obric.aiagent.plugin");
        super(r13, r13.v(), r4, r15, r16, r17, r18, a(r19), b(r19), r20);
    }

    public static boolean a(JsonInclude.Value r2) {
        if (r2 != null) goto L5;
        return false;
    L5:
        JsonInclude.Include r3 = r2.getValueInclusion();
        if (r3 != JsonInclude.Include.ALWAYS) goto L8;
        return false;
    L8:
        if (r3 == JsonInclude.Include.USE_DEFAULTS) goto L12;
        return true;
    L12:
        return false;
    }

    public static Object b(JsonInclude.Value r1) {
        if (r1 == null) goto L4;
        JsonInclude.Include r2 = r1.getValueInclusion();
        if (r2 != JsonInclude.Include.ALWAYS) goto L8;
        return null;
    L8:
        if (r2 != JsonInclude.Include.NON_NULL) goto L10;
        return null;
    L10:
        if (r2 != JsonInclude.Include.USE_DEFAULTS) goto L13;
        return null;
    L13:
        return f12939c;
    L4:
        return false;
    }

    @Override // com.fasterxml.jackson.databind.j.d, com.fasterxml.jackson.databind.j.o
    public void a(Object r5, com.fasterxml.jackson.a.h r6, ac r7) {
        Object r0 = e(r5, r6, r7);
        if (r0 == null) goto L5;
        com.fasterxml.jackson.databind.p<?> r1 = this.m;
        if (r1 != null) goto L15;
        Class<?> r2 = r0.getClass();
        com.fasterxml.jackson.databind.j.a.k r3 = this.p;
        com.fasterxml.jackson.databind.p<?> r4 = r3.a(r2);
        if (r4 != null) goto L13;
        r1 = a(r3, r2, r7);
        goto L15
    L13:
        r1 = r4;
    L15:
        if (this.r != null) goto L17;
    L24:
        if (r0 == r5) goto L26;
    L28:
        r6.b(this.f12940d);
        if (this.o != null) goto L31;
        r1.a(r0, r6, r7);
        return;
    L31:
        r1.a(r0, r6, r7, this.o);
        return;
    L26:
        if (a(r5, r6, r7, r1) == false) goto L28;
        return;
    L17:
        if (f12939c != this.r) goto L22;
        if (r1.a(r7, r0) == false) goto L24;
        return;
    L22:
        if (this.r.equals(r0) == false) goto L24;
        return;
    L5:
        if (this.n == null) goto L33;
        r6.b(this.f12940d);
        this.n.a(null, r6, r7);
        return;
    }

    @Override // com.fasterxml.jackson.databind.j.d
    public void c(Object r5, com.fasterxml.jackson.a.h r6, ac r7) {
        Object r0 = e(r5, r6, r7);
        if (r0 == null) goto L5;
        com.fasterxml.jackson.databind.p<?> r1 = this.m;
        if (r1 != null) goto L16;
        Class<?> r2 = r0.getClass();
        com.fasterxml.jackson.databind.j.a.k r3 = this.p;
        com.fasterxml.jackson.databind.p<?> r4 = r3.a(r2);
        if (r4 != null) goto L14;
        r1 = a(r3, r2, r7);
        goto L16
    L14:
        r1 = r4;
    L16:
        if (this.r != null) goto L18;
    L27:
        if (r0 != r5) goto L32;
        if (a(r5, r6, r7, r1) == false) goto L32;
        return;
    L32:
        if (this.o != null) goto L34;
        r1.a(r0, r6, r7);
        return;
    L34:
        r1.a(r0, r6, r7, this.o);
        return;
    L18:
        if (f12939c != this.r) goto L24;
        if (r1.a(r7, r0) == false) goto L27;
        d(r5, r6, r7);
        return;
    L24:
        if (this.r.equals(r0) == false) goto L27;
        d(r5, r6, r7);
        return;
    L5:
        if (this.n == null) goto L7;
        this.n.a(null, r6, r7);
        return;
    L7:
        r6.l();
    }
}
