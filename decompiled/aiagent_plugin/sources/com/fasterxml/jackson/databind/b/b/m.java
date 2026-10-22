package com.fasterxml.jackson.databind.b.b;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.EnumSet;
import java.util.Objects;

/* JADX INFO: compiled from: EnumSetDeserializer.java */
/* JADX INFO: loaded from: classes2.dex */
public class m extends ab<EnumSet<?>> implements com.fasterxml.jackson.databind.b.i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final com.fasterxml.jackson.databind.k f12439a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected com.fasterxml.jackson.databind.l<Enum<?>> f12440b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected final com.fasterxml.jackson.databind.b.s f12441c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected final boolean f12442d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected final Boolean f12443e;

    @Override // com.fasterxml.jackson.databind.l
    public /* synthetic */ Object a(com.fasterxml.jackson.a.k r1, com.fasterxml.jackson.databind.h r2) {
        return b(r1, r2);
    }

    @Override // com.fasterxml.jackson.databind.l
    public /* synthetic */ Object a(com.fasterxml.jackson.a.k r3, com.fasterxml.jackson.databind.h r4, Object r5) {
        return a(r3, r4, (EnumSet) ZeusTransformUtils.preCheckCast(r5, EnumSet.class, "com.obric.aiagent.plugin"));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public m(com.fasterxml.jackson.databind.k r2, com.fasterxml.jackson.databind.l<?> r3) {
        super(EnumSet.class);
        this.f12439a = r2;
        if (r2.k() == false) goto L7;
        this.f12440b = r3;
        this.f12443e = null;
        this.f12441c = null;
        this.f12442d = false;
        return;
    L7:
        throw new IllegalArgumentException("Type " + r2 + " not Java Enum type");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public m(m r3, com.fasterxml.jackson.databind.l<?> r4, com.fasterxml.jackson.databind.b.s r5, Boolean r6) {
        com.fasterxml.jackson.databind.b.s r7 = (com.fasterxml.jackson.databind.b.s) ZeusTransformUtils.wrapperContextForParams(r5, com.fasterxml.jackson.databind.b.s.class, "com.obric.aiagent.plugin");
        super(r3);
        this.f12439a = r3.f12439a;
        this.f12440b = r4;
        this.f12441c = r7;
        this.f12442d = com.fasterxml.jackson.databind.b.a.q.a(r7);
        this.f12443e = r6;
    }

    public m a(com.fasterxml.jackson.databind.l<?> r3, com.fasterxml.jackson.databind.b.s r4, Boolean r5) {
        com.fasterxml.jackson.databind.b.s r6 = (com.fasterxml.jackson.databind.b.s) ZeusTransformUtils.wrapperContextForParams(r4, com.fasterxml.jackson.databind.b.s.class, "com.obric.aiagent.plugin");
        if (Objects.equals(this.f12443e, r5) == false) goto L10;
        if (this.f12440b != r3) goto L10;
        if (this.f12441c != r3) goto L10;
        return this;
    L10:
        return new m(this, r3, r6, r5);
    }

    @Override // com.fasterxml.jackson.databind.l
    public boolean c() {
        if (this.f12439a.D() == null) goto L6;
        return false;
    L6:
        return true;
    }

    @Override // com.fasterxml.jackson.databind.l
    public com.fasterxml.jackson.databind.k.f b() {
        return com.fasterxml.jackson.databind.k.f.f12968b;
    }

    @Override // com.fasterxml.jackson.databind.l
    public Boolean a(com.fasterxml.jackson.databind.g r1) {
        return Boolean.TRUE;
    }

    @Override // com.fasterxml.jackson.databind.l
    public Object c(com.fasterxml.jackson.databind.h r1) {
        return h();
    }

    @Override // com.fasterxml.jackson.databind.l
    public com.fasterxml.jackson.databind.l.a e() {
        return com.fasterxml.jackson.databind.l.a.f12996c;
    }

    @Override // com.fasterxml.jackson.databind.b.i
    public com.fasterxml.jackson.databind.l<?> a(com.fasterxml.jackson.databind.h r4, com.fasterxml.jackson.databind.d r5) {
        com.fasterxml.jackson.databind.d r6 = (com.fasterxml.jackson.databind.d) ZeusTransformUtils.wrapperContextForParams(r5, com.fasterxml.jackson.databind.d.class, "com.obric.aiagent.plugin");
        Boolean r0 = a(r4, r6, EnumSet.class, JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
        com.fasterxml.jackson.databind.l<Enum<?>> r1 = this.f12440b;
        if (r1 != null) goto L5;
        com.fasterxml.jackson.databind.l<?> r2 = r4.a(this.f12439a, r6);
    L7:
        return a(r2, b(r4, r6, r2), r0);
    L5:
        r2 = r4.b(r1, r6, this.f12439a);
        goto L7
    }

    public EnumSet<?> b(com.fasterxml.jackson.a.k r3, com.fasterxml.jackson.databind.h r4) {
        EnumSet r0 = h();
        if (r3.q() == true) goto L7;
        return c(r3, r4, r0);
    L7:
        return b(r3, r4, r0);
    }

    public EnumSet<?> a(com.fasterxml.jackson.a.k r2, com.fasterxml.jackson.databind.h r3, EnumSet<?> r4) {
        if (r2.q() == true) goto L7;
        return c(r2, r3, r4);
    L7:
        return b(r2, r3, r4);
    }

    public final EnumSet<?> b(com.fasterxml.jackson.a.k r4, com.fasterxml.jackson.databind.h r5, EnumSet r6) {
    L19:
        com.fasterxml.jackson.a.n r0 = r4.g();     // Catch: Exception -> L16
        if (r0 == com.fasterxml.jackson.a.n.f12155e) goto L15;
        if (r0 != com.fasterxml.jackson.a.n.m) goto L11;
        if (this.f12442d == true) goto L19;
        Enum r1 = (Enum) ZeusTransformUtils.preCheckCast(this.f12441c.a(r5), Enum.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L16
    L12:
        if (r1 == null) goto L19;
        r6.add(r1);     // Catch: Exception -> L16
        goto L19
    L11:
        r1 = (Enum) ZeusTransformUtils.preCheckCast(this.f12440b.a(r4, r5), Enum.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L16
        goto L12
    L15:
        return r6;
    L16:
        e = move-exception;
        throw com.fasterxml.jackson.databind.m.a(e, r6, r6.size());
    }

    @Override // com.fasterxml.jackson.databind.b.b.ab, com.fasterxml.jackson.databind.l
    public Object a(com.fasterxml.jackson.a.k r1, com.fasterxml.jackson.databind.h r2, com.fasterxml.jackson.databind.h.e r3) {
        return r3.b(r1, r2);
    }

    private EnumSet h() {
        return EnumSet.noneOf(this.f12439a.e());
    }

    public EnumSet<?> c(com.fasterxml.jackson.a.k r3, com.fasterxml.jackson.databind.h r4, EnumSet r5) {
        if (this.f12443e != Boolean.TRUE) goto L5;
    L10:
        boolean r0 = true;
    L12:
        if (r0 == true) goto L16;
        return (EnumSet) ZeusTransformUtils.preCheckCast(r4.a(EnumSet.class, r3), EnumSet.class, "com.obric.aiagent.plugin");
    L16:
        if (r3.a(com.fasterxml.jackson.a.n.m) == true) goto L18;
        Enum r2 = (Enum) ZeusTransformUtils.preCheckCast(this.f12440b.a(r3, r4), Enum.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L23
        if (r2 == null) goto L22;
        r5.add(r2);     // Catch: Exception -> L23
    L22:
        return r5;
    L23:
        e = move-exception;
        throw com.fasterxml.jackson.databind.m.a(e, r5, r5.size());
    L18:
        return (EnumSet) ZeusTransformUtils.preCheckCast(r4.a(this.f12439a, r3), EnumSet.class, "com.obric.aiagent.plugin");
    L5:
        if (this.f12443e == null) goto L7;
    L9:
        r0 = false;
        goto L12
    L7:
        if (r4.a(com.fasterxml.jackson.databind.i.q) == false) goto L9;
        goto L9
    }
}
