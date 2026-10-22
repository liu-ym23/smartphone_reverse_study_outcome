package com.fasterxml.jackson.databind.j.b;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Objects;

/* JADX INFO: compiled from: ObjectArraySerializer.java */
/* JADX INFO: loaded from: classes2.dex */
@JacksonStdImpl
public class y extends a<Object[]> implements com.fasterxml.jackson.databind.j.j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final boolean f12936a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final com.fasterxml.jackson.databind.k f12937b;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected final com.fasterxml.jackson.databind.h.h f12938e;
    protected com.fasterxml.jackson.databind.p<Object> f;
    protected com.fasterxml.jackson.databind.j.a.k g;

    @Override // com.fasterxml.jackson.databind.j.b.a, com.fasterxml.jackson.databind.j.b.aj, com.fasterxml.jackson.databind.p
    public /* synthetic */ void a(Object r3, com.fasterxml.jackson.a.h r4, com.fasterxml.jackson.databind.ac r5) {
        a((Object[]) ZeusTransformUtils.preCheckCast(r3, Object[].class, "com.obric.aiagent.plugin"), r4, r5);
    }

    @Override // com.fasterxml.jackson.databind.p
    public /* synthetic */ boolean a(com.fasterxml.jackson.databind.ac r3, Object r4) {
        return a(r3, (Object[]) ZeusTransformUtils.preCheckCast(r4, Object[].class, "com.obric.aiagent.plugin"));
    }

    @Override // com.fasterxml.jackson.databind.j.i
    public /* synthetic */ boolean a(Object r3) {
        return a((Object[]) ZeusTransformUtils.preCheckCast(r3, Object[].class, "com.obric.aiagent.plugin"));
    }

    @Override // com.fasterxml.jackson.databind.j.b.a
    public /* synthetic */ void b(Object[] r3, com.fasterxml.jackson.a.h r4, com.fasterxml.jackson.databind.ac r5) {
        b2((Object[]) ZeusTransformUtils.preCheckCast(r3, Object[].class, "com.obric.aiagent.plugin"), r4, r5);
    }

    public y(com.fasterxml.jackson.databind.k r2, boolean r3, com.fasterxml.jackson.databind.h.h r4, com.fasterxml.jackson.databind.p<Object> r5) {
        super(Object[].class);
        this.f12937b = r2;
        this.f12936a = r3;
        this.f12938e = r4;
        this.g = com.fasterxml.jackson.databind.j.a.k.a();
        this.f = r5;
    }

    public y(y r3, com.fasterxml.jackson.databind.d r4, com.fasterxml.jackson.databind.h.h r5, com.fasterxml.jackson.databind.p<?> r6, Boolean r7) {
        super(r3, (com.fasterxml.jackson.databind.d) ZeusTransformUtils.wrapperContextForParams(r4, com.fasterxml.jackson.databind.d.class, "com.obric.aiagent.plugin"), r7);
        this.f12937b = r3.f12937b;
        this.f12938e = r5;
        this.f12936a = r3.f12936a;
        this.g = com.fasterxml.jackson.databind.j.a.k.a();
        this.f = r6;
    }

    @Override // com.fasterxml.jackson.databind.j.b.a
    public com.fasterxml.jackson.databind.p<?> a(com.fasterxml.jackson.databind.d r7, Boolean r8) {
        return new y(this, (com.fasterxml.jackson.databind.d) ZeusTransformUtils.wrapperContextForParams(r7, com.fasterxml.jackson.databind.d.class, "com.obric.aiagent.plugin"), this.f12938e, this.f, r8);
    }

    @Override // com.fasterxml.jackson.databind.j.i
    public com.fasterxml.jackson.databind.j.i<?> b(com.fasterxml.jackson.databind.h.h r4) {
        return new y(this.f12937b, this.f12936a, r4, this.f);
    }

    public y a(com.fasterxml.jackson.databind.d r7, com.fasterxml.jackson.databind.h.h r8, com.fasterxml.jackson.databind.p<?> r9, Boolean r10) {
        com.fasterxml.jackson.databind.d r2 = (com.fasterxml.jackson.databind.d) ZeusTransformUtils.wrapperContextForParams(r7, com.fasterxml.jackson.databind.d.class, "com.obric.aiagent.plugin");
        if (this.f12859c != r2) goto L12;
        if (r9 != this.f) goto L12;
        if (this.f12938e != r8) goto L12;
        if (Objects.equals(this.f12860d, r10) == false) goto L12;
        return this;
    L12:
        return new y(this, r2, r8, r9, r10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.fasterxml.jackson.databind.j.b.a, com.fasterxml.jackson.databind.j.j
    public com.fasterxml.jackson.databind.p<?> a(com.fasterxml.jackson.databind.ac r6, com.fasterxml.jackson.databind.d r7) {
        com.fasterxml.jackson.databind.d r8 = (com.fasterxml.jackson.databind.d) ZeusTransformUtils.wrapperContextForParams(r7, com.fasterxml.jackson.databind.d.class, "com.obric.aiagent.plugin");
        com.fasterxml.jackson.databind.h.h r0 = this.f12938e;
        if (r0 == null) goto L5;
        r0 = r0.a(r8);
    L5:
        Boolean r1 = null;
        if (r8 == null) goto L12;
        com.fasterxml.jackson.databind.e.j r2 = r8.d();
        com.fasterxml.jackson.databind.b r3 = r6.d();
        if (r2 == null) goto L12;
        Object r4 = r3.o(r2);
        if (r4 == null) goto L12;
        com.fasterxml.jackson.databind.p<Object> r5 = r6.b(r2, r4);
    L13:
        JsonFormat.Value r9 = a(r6, r8, a());
        if (r9 == null) goto L16;
        r1 = r9.getFeature(JsonFormat.Feature.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED);
    L16:
        if (r5 != null) goto L18;
        r5 = this.f;
    L18:
        com.fasterxml.jackson.databind.p<?> r10 = a(r6, r8, r5);
        if (r10 != null) goto L28;
        com.fasterxml.jackson.databind.k r11 = this.f12937b;
        if (r11 == null) goto L28;
        if (this.f12936a == false) goto L28;
        if (r11.t() == true) goto L28;
        r10 = r6.c(this.f12937b, r8);
    L28:
        return a(r8, r0, r10, r1);
    L12:
        r5 = null;
        goto L13
    }

    public boolean a(com.fasterxml.jackson.databind.ac r1, Object[] r2) {
        if (r2.length != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean a(Object[] r1) {
        if (r1.length == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public final void a(Object[] r4, com.fasterxml.jackson.a.h r5, com.fasterxml.jackson.databind.ac r6) {
        int r0 = r4.length;
        if (r0 == 1) goto L5;
    L12:
        r5.a(r4, r0);
        b2(r4, r5, r6);
        r5.i();
        return;
    L5:
        if (this.f12860d != null) goto L9;
        if (r6.a(com.fasterxml.jackson.databind.ab.u) == false) goto L9;
    L10:
        b2(r4, r5, r6);
        return;
    L9:
        if (this.f12860d != Boolean.TRUE) goto L12;
        goto L10
    }

    /* JADX INFO: renamed from: b, reason: avoid collision after fix types in other method */
    public void b2(Object[] r7, com.fasterxml.jackson.a.h r8, com.fasterxml.jackson.databind.ac r9) {
        int r0 = r7.length;
        if (r0 != 0) goto L5;
        return;
    L5:
        com.fasterxml.jackson.databind.p<Object> r1 = this.f;
        if (r1 == null) goto L10;
        a(r7, r8, r9, r1);
        return;
    L10:
        if (this.f12938e == null) goto L13;
        c(r7, r8, r9);
        return;
    L13:
        int r2 = 0;
        Object r3 = null;
        com.fasterxml.jackson.databind.j.a.k r4 = this.g;     // Catch: Exception -> L27
    L15:
        if (r2 >= r0) goto L35;
        r3 = r7[r2];     // Catch: Exception -> L27
        if (r3 != null) goto L19;
        r9.a(r8);     // Catch: Exception -> L27
    L26:
        r2 = r2 + 1;
        goto L15
    L19:
        Class<?> r5 = r3.getClass();     // Catch: Exception -> L27
        com.fasterxml.jackson.databind.p<Object> r6 = r4.a(r5);     // Catch: Exception -> L27
        if (r6 == null) goto L22;
    L25:
        r6.a(r3, r8, r9);     // Catch: Exception -> L27
        goto L26
    L22:
        if (this.f12937b.v() == false) goto L24;
        r6 = a(r4, r9.a(this.f12937b, r5), r9);     // Catch: Exception -> L27
        goto L25
    L24:
        r6 = a(r4, r5, r9);     // Catch: Exception -> L27
        goto L25
    L35:
        return;
    L27:
        e = move-exception;
        a(r9, e, r3, r2);
    }

    public void a(Object[] r5, com.fasterxml.jackson.a.h r6, com.fasterxml.jackson.databind.ac r7, com.fasterxml.jackson.databind.p<Object> r8) {
        int r0 = r5.length;
        com.fasterxml.jackson.databind.h.h r1 = this.f12938e;
        int r2 = 0;
        Object r3 = null;
    L3:
        if (r2 >= r0) goto L20;
        r3 = r5[r2];     // Catch: Exception -> L11
        if (r3 != null) goto L7;
        r7.a(r6);     // Catch: Exception -> L11
    L10:
        r2 = r2 + 1;
        goto L3
    L7:
        if (r1 != null) goto L9;
        r8.a(r3, r6, r7);     // Catch: Exception -> L11
        goto L10
    L9:
        r8.a(r3, r6, r7, r1);     // Catch: Exception -> L11
    L11:
        e = move-exception;
        a(r7, e, r3, r2);
        return;
    }

    public void c(Object[] r8, com.fasterxml.jackson.a.h r9, com.fasterxml.jackson.databind.ac r10) {
        int r0 = r8.length;
        com.fasterxml.jackson.databind.h.h r1 = this.f12938e;
        int r2 = 0;
        Object r3 = null;
        com.fasterxml.jackson.databind.j.a.k r4 = this.g;     // Catch: Exception -> L13
    L4:
        if (r2 >= r0) goto L21;
        r3 = r8[r2];     // Catch: Exception -> L13
        if (r3 != null) goto L8;
        r10.a(r9);     // Catch: Exception -> L13
    L12:
        r2 = r2 + 1;
        goto L4
    L8:
        Class<?> r5 = r3.getClass();     // Catch: Exception -> L13
        com.fasterxml.jackson.databind.p<Object> r6 = r4.a(r5);     // Catch: Exception -> L13
        if (r6 != null) goto L11;
        r6 = a(r4, r5, r10);     // Catch: Exception -> L13
    L11:
        r6.a(r3, r9, r10, r1);     // Catch: Exception -> L13
        goto L12
    L21:
        return;
    L13:
        e = move-exception;
        a(r10, e, r3, r2);
    }

    public final com.fasterxml.jackson.databind.p<Object> a(com.fasterxml.jackson.databind.j.a.k r2, Class<?> r3, com.fasterxml.jackson.databind.ac r4) {
        com.fasterxml.jackson.databind.j.a.k.d r5 = r2.b(r3, r4, this.f12859c);
        if (r2 == r5.f12828b) goto L6;
        this.g = r5.f12828b;
    L6:
        return r5.f12827a;
    }

    public final com.fasterxml.jackson.databind.p<Object> a(com.fasterxml.jackson.databind.j.a.k r2, com.fasterxml.jackson.databind.k r3, com.fasterxml.jackson.databind.ac r4) {
        com.fasterxml.jackson.databind.j.a.k.d r5 = r2.b(r3, r4, this.f12859c);
        if (r2 == r5.f12828b) goto L6;
        this.g = r5.f12828b;
    L6:
        return r5.f12827a;
    }
}
