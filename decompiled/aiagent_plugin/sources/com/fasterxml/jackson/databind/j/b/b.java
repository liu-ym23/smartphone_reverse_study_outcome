package com.fasterxml.jackson.databind.j.b;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Objects;

/* JADX INFO: compiled from: AsArraySerializerBase.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class b<T> extends com.fasterxml.jackson.databind.j.i<T> implements com.fasterxml.jackson.databind.j.j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final com.fasterxml.jackson.databind.k f12888a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final com.fasterxml.jackson.databind.d f12889b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected final boolean f12890c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected final Boolean f12891d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected final com.fasterxml.jackson.databind.h.h f12892e;
    protected final com.fasterxml.jackson.databind.p<Object> f;
    protected com.fasterxml.jackson.databind.j.a.k g;

    public abstract b<T> b(com.fasterxml.jackson.databind.d r1, com.fasterxml.jackson.databind.h.h r2, com.fasterxml.jackson.databind.p<?> r3, Boolean r4);

    public abstract void b(T r1, com.fasterxml.jackson.a.h r2, com.fasterxml.jackson.databind.ac r3);

    public b(Class<?> r9, com.fasterxml.jackson.databind.k r10, boolean r11, com.fasterxml.jackson.databind.h.h r12, com.fasterxml.jackson.databind.p<Object> r13) {
        this(r9, r10, r11, r12, null, r13, null);
    }

    public b(Class<?> r3, com.fasterxml.jackson.databind.k r4, boolean r5, com.fasterxml.jackson.databind.h.h r6, com.fasterxml.jackson.databind.d r7, com.fasterxml.jackson.databind.p<?> r8, Boolean r9) {
        com.fasterxml.jackson.databind.d r10 = (com.fasterxml.jackson.databind.d) ZeusTransformUtils.wrapperContextForParams(r7, com.fasterxml.jackson.databind.d.class, "com.obric.aiagent.plugin");
        boolean r0 = false;
        super(r3, false);
        this.f12888a = r4;
        if (r5 == true) goto L7;
        if (r4 != null) goto L6;
    L8:
        this.f12890c = r0;
        this.f12892e = r6;
        this.f12889b = r10;
        this.f = r8;
        this.g = com.fasterxml.jackson.databind.j.a.k.a();
        this.f12891d = r9;
        return;
    L6:
        if (r4.p() == false) goto L8;
    L7:
        r0 = true;
        goto L8
    }

    public b(b<?> r3, com.fasterxml.jackson.databind.d r4, com.fasterxml.jackson.databind.h.h r5, com.fasterxml.jackson.databind.p<?> r6, Boolean r7) {
        com.fasterxml.jackson.databind.d r8 = (com.fasterxml.jackson.databind.d) ZeusTransformUtils.wrapperContextForParams(r4, com.fasterxml.jackson.databind.d.class, "com.obric.aiagent.plugin");
        super(r3);
        this.f12888a = r3.f12888a;
        this.f12890c = r3.f12890c;
        this.f12892e = r5;
        this.f12889b = r8;
        this.f = r6;
        this.g = com.fasterxml.jackson.databind.j.a.k.a();
        this.f12891d = r7;
    }

    @Override // com.fasterxml.jackson.databind.j.j
    public com.fasterxml.jackson.databind.p<?> a(com.fasterxml.jackson.databind.ac r6, com.fasterxml.jackson.databind.d r7) {
        com.fasterxml.jackson.databind.d r8 = (com.fasterxml.jackson.databind.d) ZeusTransformUtils.wrapperContextForParams(r7, com.fasterxml.jackson.databind.d.class, "com.obric.aiagent.plugin");
        com.fasterxml.jackson.databind.h.h r0 = this.f12892e;
        if (r0 == null) goto L5;
        r0 = r0.a(r8);
    L5:
        Boolean r1 = null;
        if (r8 == null) goto L12;
        com.fasterxml.jackson.databind.b r2 = r6.d();
        com.fasterxml.jackson.databind.e.j r3 = r8.d();
        if (r3 == null) goto L12;
        Object r4 = r2.o(r3);
        if (r4 == null) goto L12;
        com.fasterxml.jackson.databind.p<Object> r5 = r6.b(r3, r4);
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
        com.fasterxml.jackson.databind.k r11 = this.f12888a;
        if (r11 == null) goto L28;
        if (this.f12890c == false) goto L28;
        if (r11.t() == true) goto L28;
        r10 = r6.c(this.f12888a, r8);
    L28:
        if (r10 != this.f) goto L38;
        if (r8 != this.f12889b) goto L38;
        if (this.f12892e != r0) goto L38;
        if (Objects.equals(this.f12891d, r1) == false) goto L38;
        return this;
    L38:
        return b(r8, r0, r10, r1);
    L12:
        r5 = null;
        goto L13
    }

    @Override // com.fasterxml.jackson.databind.j.b.aj, com.fasterxml.jackson.databind.p
    public void a(T r2, com.fasterxml.jackson.a.h r3, com.fasterxml.jackson.databind.ac r4) {
        if (r4.a(com.fasterxml.jackson.databind.ab.u) == true) goto L5;
    L8:
        r3.b(r2);
        b(r2, r3, r4);
        r3.i();
        return;
    L5:
        if (a(r2) == false) goto L8;
        b(r2, r3, r4);
    }

    @Override // com.fasterxml.jackson.databind.p
    public void a(T r2, com.fasterxml.jackson.a.h r3, com.fasterxml.jackson.databind.ac r4, com.fasterxml.jackson.databind.h.h r5) {
        com.fasterxml.jackson.a.g.b r0 = r5.a(r3, r5.a(r2, com.fasterxml.jackson.a.n.f12154d));
        r3.a(r2);
        b(r2, r3, r4);
        r5.b(r3, r0);
    }

    public final com.fasterxml.jackson.databind.p<Object> a(com.fasterxml.jackson.databind.j.a.k r2, Class<?> r3, com.fasterxml.jackson.databind.ac r4) {
        com.fasterxml.jackson.databind.j.a.k.d r5 = r2.b(r3, r4, this.f12889b);
        if (r2 == r5.f12828b) goto L6;
        this.g = r5.f12828b;
    L6:
        return r5.f12827a;
    }

    public final com.fasterxml.jackson.databind.p<Object> a(com.fasterxml.jackson.databind.j.a.k r2, com.fasterxml.jackson.databind.k r3, com.fasterxml.jackson.databind.ac r4) {
        com.fasterxml.jackson.databind.j.a.k.d r5 = r2.b(r3, r4, this.f12889b);
        if (r2 == r5.f12828b) goto L6;
        this.g = r5.f12828b;
    L6:
        return r5.f12827a;
    }
}
