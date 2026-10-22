package com.fasterxml.jackson.databind.b.b;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;

/* JADX INFO: compiled from: FactoryBasedEnumDeserializer.java */
/* JADX INFO: loaded from: classes2.dex */
class n extends ab<Object> implements com.fasterxml.jackson.databind.b.i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final com.fasterxml.jackson.databind.k f12444a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final com.fasterxml.jackson.databind.e.k f12445b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected final com.fasterxml.jackson.databind.l<?> f12446c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected final com.fasterxml.jackson.databind.b.y f12447d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected final com.fasterxml.jackson.databind.b.v[] f12448e;
    protected final boolean f;
    private transient com.fasterxml.jackson.databind.b.a.v g;

    @Override // com.fasterxml.jackson.databind.l
    public boolean c() {
        return true;
    }

    public n(Class<?> r1, com.fasterxml.jackson.databind.e.k r2, com.fasterxml.jackson.databind.k r3, com.fasterxml.jackson.databind.b.y r4, com.fasterxml.jackson.databind.b.v[] r5) {
        super(r1);
        this.f12445b = r2;
        this.f = true;
        if (r3.a(String.class) == false) goto L5;
    L6:
        r3 = null;
    L7:
        this.f12444a = r3;
        this.f12446c = null;
        this.f12447d = r4;
        this.f12448e = r5;
        return;
    L5:
        if (r3.a(CharSequence.class) == false) goto L7;
        goto L6
    }

    public n(Class<?> r1, com.fasterxml.jackson.databind.e.k r2) {
        super(r1);
        this.f12445b = r2;
        this.f = false;
        this.f12444a = null;
        this.f12446c = null;
        this.f12447d = null;
        this.f12448e = null;
    }

    public n(n r2, com.fasterxml.jackson.databind.l<?> r3) {
        super(r2.B);
        this.f12444a = r2.f12444a;
        this.f12445b = r2.f12445b;
        this.f = r2.f;
        this.f12447d = r2.f12447d;
        this.f12448e = r2.f12448e;
        this.f12446c = r3;
    }

    @Override // com.fasterxml.jackson.databind.b.i
    public com.fasterxml.jackson.databind.l<?> a(com.fasterxml.jackson.databind.h r3, com.fasterxml.jackson.databind.d r4) {
        com.fasterxml.jackson.databind.d r5 = (com.fasterxml.jackson.databind.d) ZeusTransformUtils.wrapperContextForParams(r4, com.fasterxml.jackson.databind.d.class, "com.obric.aiagent.plugin");
        if (this.f12446c == null) goto L5;
    L10:
        return this;
    L5:
        if (this.f12444a == null) goto L10;
        if (this.f12448e != null) goto L10;
        return new n(this, r3.a(this.f12444a, r5));
    }

    @Override // com.fasterxml.jackson.databind.l
    public Boolean a(com.fasterxml.jackson.databind.g r1) {
        return Boolean.FALSE;
    }

    @Override // com.fasterxml.jackson.databind.l
    public com.fasterxml.jackson.databind.k.f b() {
        return com.fasterxml.jackson.databind.k.f.i;
    }

    @Override // com.fasterxml.jackson.databind.b.b.ab
    public com.fasterxml.jackson.databind.b.y k() {
        return this.f12447d;
    }

    @Override // com.fasterxml.jackson.databind.l
    public Object a(com.fasterxml.jackson.a.k r6, com.fasterxml.jackson.databind.h r7) {
        com.fasterxml.jackson.databind.l<?> r0 = this.f12446c;
        if (r0 == null) goto L6;
        Object r8 = r0.a(r6, r7);
    L41:
        return this.f12445b.a(this.B, new Object[]{r8});
    L25:
        e = move-exception;
        Throwable r1 = com.fasterxml.jackson.databind.l.h.e(e);
        if (ZeusTransformUtils.instanceOf(r1, IllegalArgumentException.class) == false) goto L32;
        if (r7.a(com.fasterxml.jackson.databind.i.x) == false) goto L32;
        return null;
    L32:
        return r7.a(this.B, r8, r1);
    L6:
        if (this.f == true) goto L8;
        r6.k();
        return this.f12445b.call();
    L36:
        e = move-exception;
        return r7.a(this.B, null, com.fasterxml.jackson.databind.l.h.e(e));
    L8:
        if (this.f12448e != null) goto L10;
        com.fasterxml.jackson.a.n r2 = r6.l();
        if (r2 != null) goto L20;
    L22:
        r8 = r6.R();
        goto L41
    L20:
        if (r2.g() == true) goto L22;
        r6.k();
        r8 = "";
        goto L41
    L10:
        if (r6.r() == true) goto L13;
        com.fasterxml.jackson.databind.k r3 = f(r7);
        r7.a(r3, "Input mismatch reading Enum %s: properties-based `@JsonCreator` (%s) expects JSON Object (JsonToken.START_OBJECT), got JsonToken.%s", new Object[]{com.fasterxml.jackson.databind.l.h.b(r3), this.f12445b, r6.l()});
    L13:
        if (this.g != null) goto L15;
        this.g = com.fasterxml.jackson.databind.b.a.v.a(r7, this.f12447d, this.f12448e, r7.a(com.fasterxml.jackson.databind.r.v));
    L15:
        r6.g();
        return a(r6, r7, this.g);
    }

    @Override // com.fasterxml.jackson.databind.b.b.ab, com.fasterxml.jackson.databind.l
    public Object a(com.fasterxml.jackson.a.k r2, com.fasterxml.jackson.databind.h r3, com.fasterxml.jackson.databind.h.e r4) {
        if (this.f12446c != null) goto L7;
        return a(r2, r3);
    L7:
        return r4.d(r2, r3);
    }

    public Object a(com.fasterxml.jackson.a.k r4, com.fasterxml.jackson.databind.h r5, com.fasterxml.jackson.databind.b.a.v r6) {
        com.fasterxml.jackson.databind.b.a.y r0 = r6.a(r4, r5, null);
        com.fasterxml.jackson.a.n r1 = r4.l();
    L4:
        if (r1 != com.fasterxml.jackson.a.n.f) goto L14;
        String r2 = r4.w();
        r4.g();
        com.fasterxml.jackson.databind.b.v r3 = r6.a(r2);
        if (r0.a(r2) == false) goto L9;
        if (r3 != null) goto L9;
    L12:
        r1 = r4.g();
    L9:
        if (r3 == null) goto L11;
        r0.a(r3, a(r4, r5, r3));
        goto L12
    L11:
        r4.k();
        goto L12
    L14:
        return r6.a(r5, r0);
    }

    public final Object a(com.fasterxml.jackson.a.k r2, com.fasterxml.jackson.databind.h r3, com.fasterxml.jackson.databind.b.v r4) {
        return r4.a(r2, r3);
    L4:
        e = move-exception;
        return a(e, a(), r4.a(), r3);
    }

    public Object a(Throwable r1, Object r2, String r3, com.fasterxml.jackson.databind.h r4) {
        throw com.fasterxml.jackson.databind.m.a(a(r1, r4), r2, r3);
    }

    private Throwable a(Throwable r1, com.fasterxml.jackson.databind.h r2) {
        Throwable r0 = com.fasterxml.jackson.databind.l.h.d(r1);
        com.fasterxml.jackson.databind.l.h.a(r0);
        if (r2 != null) goto L5;
    L8:
        boolean r3 = true;
    L10:
        if (ZeusTransformUtils.instanceOf(r0, IOException.class) == false) goto L17;
        if (r3 == false) goto L16;
        if (ZeusTransformUtils.instanceOf(r0, com.fasterxml.jackson.a.e.class) == false) goto L16;
    L19:
        return r0;
    L16:
        throw ((IOException) ZeusTransformUtils.preCheckCast(r0, IOException.class, "com.obric.aiagent.plugin"));
    L17:
        if (r3 == true) goto L19;
        com.fasterxml.jackson.databind.l.h.b(r0);
        goto L19
    L5:
        if (r2.a(com.fasterxml.jackson.databind.i.p) == true) goto L8;
        r3 = false;
        goto L10
    }
}
