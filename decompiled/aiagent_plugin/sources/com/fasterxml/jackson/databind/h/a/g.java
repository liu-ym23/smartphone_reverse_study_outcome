package com.fasterxml.jackson.databind.h.a;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.l.y;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: AsPropertyTypeDeserializer.java */
/* JADX INFO: loaded from: classes2.dex */
public class g extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final JsonTypeInfo.As f12717a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final String f12718b;

    public g(com.fasterxml.jackson.databind.k r7, com.fasterxml.jackson.databind.h.f r8, String r9, boolean r10, com.fasterxml.jackson.databind.k r11, JsonTypeInfo.As r12) {
        super(r7, (com.fasterxml.jackson.databind.h.f) ZeusTransformUtils.wrapperContextForParams(r8, com.fasterxml.jackson.databind.h.f.class, "com.obric.aiagent.plugin"), r9, r10, r11);
        if (this.f12737e != null) goto L5;
        String r13 = String.format("missing type id property '%s'", new Object[]{this.g});
    L6:
        this.f12718b = r13;
        this.f12717a = r12;
        return;
    L5:
        r13 = String.format("missing type id property '%s' (for POJO property '%s')", new Object[]{this.g, this.f12737e.a()});
        goto L6
    }

    public g(g r4, com.fasterxml.jackson.databind.d r5) {
        super(r4, (com.fasterxml.jackson.databind.d) ZeusTransformUtils.wrapperContextForParams(r5, com.fasterxml.jackson.databind.d.class, "com.obric.aiagent.plugin"));
        if (this.f12737e != null) goto L5;
        String r6 = String.format("missing type id property '%s'", new Object[]{this.g});
    L6:
        this.f12718b = r6;
        this.f12717a = r4.f12717a;
        return;
    L5:
        r6 = String.format("missing type id property '%s' (for POJO property '%s')", new Object[]{this.g, this.f12737e.a()});
        goto L6
    }

    @Override // com.fasterxml.jackson.databind.h.a.a, com.fasterxml.jackson.databind.h.e
    public com.fasterxml.jackson.databind.h.e a(com.fasterxml.jackson.databind.d r3) {
        com.fasterxml.jackson.databind.d r4 = (com.fasterxml.jackson.databind.d) ZeusTransformUtils.wrapperContextForParams(r3, com.fasterxml.jackson.databind.d.class, "com.obric.aiagent.plugin");
        if (r4 != this.f12737e) goto L6;
        return this;
    L6:
        return new g(this, r4);
    }

    @Override // com.fasterxml.jackson.databind.h.a.a, com.fasterxml.jackson.databind.h.e
    public JsonTypeInfo.As a() {
        return this.f12717a;
    }

    @Override // com.fasterxml.jackson.databind.h.a.a, com.fasterxml.jackson.databind.h.e
    public Object a(com.fasterxml.jackson.a.k r5, com.fasterxml.jackson.databind.h r6) {
        if (r5.T() == false) goto L8;
        Object r0 = r5.V();
        if (r0 == null) goto L8;
        return a(r5, r6, r0);
    L8:
        com.fasterxml.jackson.a.n r1 = r5.l();
        y r2 = null;
        if (r1 != com.fasterxml.jackson.a.n.f12152b) goto L12;
        r1 = r5.g();
    L15:
        boolean r3 = r6.a(com.fasterxml.jackson.databind.r.v);
    L17:
        if (r1 != com.fasterxml.jackson.a.n.f) goto L31;
        String r4 = r5.w();
        r5.g();
        if (r4.equals(this.g) == true) goto L23;
        if (r3 == true) goto L22;
    L27:
        if (r2 != null) goto L29;
        r2 = r6.a(r5);
    L29:
        r2.a(r4);
        r2.b(r5);
        r1 = r5.g();
        goto L17
    L22:
        if (r4.equalsIgnoreCase(this.g) == false) goto L27;
    L23:
        String r7 = r5.R();
        if (r7 == null) goto L27;
        return a(r5, r6, r2, r7);
    L31:
        return b(r5, r6, r2, this.f12718b);
    L12:
        if (r1 == com.fasterxml.jackson.a.n.f) goto L15;
        return b(r5, r6, null, this.f12718b);
    }

    public Object a(com.fasterxml.jackson.a.k r2, com.fasterxml.jackson.databind.h r3, y r4, String r5) {
        com.fasterxml.jackson.databind.l<Object> r0 = a(r3, r5);
        if (this.h == false) goto L7;
        if (r4 != null) goto L6;
        r4 = r3.a(r2);
    L6:
        r4.a(r2.w());
        r4.b(r5);
    L7:
        if (r4 == null) goto L10;
        r2.u();
        r2 = com.fasterxml.jackson.a.h.k.a(false, r4.d(r2), r2);
    L10:
        if (r2.l() == com.fasterxml.jackson.a.n.f12153c) goto L13;
        r2.g();
    L13:
        return r0.a(r2, r3);
    }

    public Object b(com.fasterxml.jackson.a.k r3, com.fasterxml.jackson.databind.h r4, y r5, String r6) {
        if (e() == true) goto L18;
        Object r0 = com.fasterxml.jackson.databind.h.e.a(r3, r4, this.f12736d);
        if (r0 == null) goto L8;
        return r0;
    L8:
        if (r3.q() == false) goto L12;
        return super.d(r3, r4);
    L12:
        if (r3.a(com.fasterxml.jackson.a.n.h) == false) goto L18;
        if (r4.a(com.fasterxml.jackson.databind.i.t) == false) goto L18;
        if (r3.x().trim().isEmpty() == false) goto L18;
        return null;
    L18:
        com.fasterxml.jackson.databind.l<Object> r1 = a(r4);
        if (r1 != null) goto L24;
        com.fasterxml.jackson.databind.k r7 = c(r4, r6);
        if (r7 != null) goto L23;
        return null;
    L23:
        r1 = r4.a(r7, this.f12737e);
    L24:
        if (r5 == null) goto L27;
        r5.k();
        r3 = r5.d(r3);
        r3.g();
    L27:
        return r1.a(r3, r4);
    }

    @Override // com.fasterxml.jackson.databind.h.a.a, com.fasterxml.jackson.databind.h.e
    public Object d(com.fasterxml.jackson.a.k r2, com.fasterxml.jackson.databind.h r3) {
        if (r2.a(com.fasterxml.jackson.a.n.f12154d) == false) goto L7;
        return super.b(r2, r3);
    L7:
        return a(r2, r3);
    }
}
