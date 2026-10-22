package com.fasterxml.jackson.databind.b.b;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.Objects;

/* JADX INFO: compiled from: StringCollectionDeserializer.java */
/* JADX INFO: loaded from: classes2.dex */
@JacksonStdImpl
public final class ah extends i<Collection<String>> implements com.fasterxml.jackson.databind.b.i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final com.fasterxml.jackson.databind.l<String> f12397a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final com.fasterxml.jackson.databind.b.y f12398b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected final com.fasterxml.jackson.databind.l<Object> f12399c;

    @Override // com.fasterxml.jackson.databind.l
    public /* synthetic */ Object a(com.fasterxml.jackson.a.k r1, com.fasterxml.jackson.databind.h r2) {
        return b(r1, r2);
    }

    @Override // com.fasterxml.jackson.databind.l
    public /* synthetic */ Object a(com.fasterxml.jackson.a.k r3, com.fasterxml.jackson.databind.h r4, Object r5) {
        return a(r3, r4, (Collection) ZeusTransformUtils.preCheckCast(r5, Collection.class, "com.obric.aiagent.plugin"));
    }

    public ah(com.fasterxml.jackson.databind.k r8, com.fasterxml.jackson.databind.l<?> r9, com.fasterxml.jackson.databind.b.y r10) {
        this(r8, r10, null, r9, r9, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ah(com.fasterxml.jackson.databind.k r3, com.fasterxml.jackson.databind.b.y r4, com.fasterxml.jackson.databind.l<?> r5, com.fasterxml.jackson.databind.l<?> r6, com.fasterxml.jackson.databind.b.s r7, Boolean r8) {
        super(r3, (com.fasterxml.jackson.databind.b.s) ZeusTransformUtils.wrapperContextForParams(r7, com.fasterxml.jackson.databind.b.s.class, "com.obric.aiagent.plugin"), r8);
        this.f12397a = r6;
        this.f12398b = r4;
        this.f12399c = r5;
    }

    public ah a(com.fasterxml.jackson.databind.l<?> r8, com.fasterxml.jackson.databind.l<?> r9, com.fasterxml.jackson.databind.b.s r10, Boolean r11) {
        com.fasterxml.jackson.databind.b.s r5 = (com.fasterxml.jackson.databind.b.s) ZeusTransformUtils.wrapperContextForParams(r10, com.fasterxml.jackson.databind.b.s.class, "com.obric.aiagent.plugin");
        if (Objects.equals(this.h, r11) == false) goto L12;
        if (this.f != r5) goto L12;
        if (this.f12397a != r9) goto L12;
        if (this.f12399c != r8) goto L12;
        return this;
    L12:
        return new ah(this.f12422e, this.f12398b, r8, r9, r5, r11);
    }

    @Override // com.fasterxml.jackson.databind.l
    public boolean c() {
        if (this.f12397a == null) goto L5;
    L7:
        return false;
    L5:
        if (this.f12399c != null) goto L7;
        return true;
    }

    @Override // com.fasterxml.jackson.databind.l
    public com.fasterxml.jackson.databind.k.f b() {
        return com.fasterxml.jackson.databind.k.f.f12968b;
    }

    @Override // com.fasterxml.jackson.databind.b.i
    public com.fasterxml.jackson.databind.l<?> a(com.fasterxml.jackson.databind.h r6, com.fasterxml.jackson.databind.d r7) {
        com.fasterxml.jackson.databind.d r8 = (com.fasterxml.jackson.databind.d) ZeusTransformUtils.wrapperContextForParams(r7, com.fasterxml.jackson.databind.d.class, "com.obric.aiagent.plugin");
        com.fasterxml.jackson.databind.b.y r0 = this.f12398b;
        com.fasterxml.jackson.databind.l<?> r1 = null;
        if (r0 != null) goto L5;
    L10:
        com.fasterxml.jackson.databind.l<?> r2 = null;
    L11:
        com.fasterxml.jackson.databind.l<String> r3 = this.f12397a;
        com.fasterxml.jackson.databind.k r4 = this.f12422e.x();
        if (r3 != null) goto L16;
        com.fasterxml.jackson.databind.l<?> r5 = a(r6, r8, r3);
        if (r5 != null) goto L17;
        r5 = r6.a(r4, r8);
    L17:
        Boolean r9 = a(r6, r8, Collection.class, JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
        com.fasterxml.jackson.databind.b.s r10 = b(r6, r8, r5);
        if (a(r5) == true) goto L22;
        r1 = r5;
    L22:
        return a(r2, r1, r10, r9);
    L16:
        r5 = r6.b(r3, r8, r4);
        goto L17
    L5:
        if (r0.q() == null) goto L8;
        r2 = a(r6, this.f12398b.c(r6.c()), r8);
        goto L11
    L8:
        if (this.f12398b.p() == null) goto L10;
        r2 = a(r6, this.f12398b.b(r6.c()), r8);
        goto L11
    }

    @Override // com.fasterxml.jackson.databind.b.b.i
    public com.fasterxml.jackson.databind.l<Object> h() {
        return this.f12397a;
    }

    @Override // com.fasterxml.jackson.databind.b.b.ab
    public com.fasterxml.jackson.databind.b.y k() {
        return this.f12398b;
    }

    public Collection<String> b(com.fasterxml.jackson.a.k r4, com.fasterxml.jackson.databind.h r5) {
        com.fasterxml.jackson.databind.l<Object> r0 = this.f12399c;
        if (r0 == null) goto L7;
        return (Collection) ZeusTransformUtils.preCheckCast(this.f12398b.a(r5, r0.a(r4, r5)), Collection.class, "com.obric.aiagent.plugin");
    L7:
        return a(r4, r5, (Collection) ZeusTransformUtils.preCheckCast(this.f12398b.a(r5), Collection.class, "com.obric.aiagent.plugin"));
    }

    public Collection<String> a(com.fasterxml.jackson.a.k r4, com.fasterxml.jackson.databind.h r5, Collection<String> r6) {
        Collection<String> r7 = (Collection) ZeusTransformUtils.wrapperContextForParams(r6, Collection.class, "com.obric.aiagent.plugin");
        if (r4.q() == false) goto L5;
        com.fasterxml.jackson.databind.l<String> r0 = this.f12397a;
        if (r0 != null) goto L9;
    L28:
        String r1 = r4.j();     // Catch: Exception -> L25
        if (r1 != null) goto L12;
        com.fasterxml.jackson.a.n r2 = r4.l();     // Catch: Exception -> L25
        if (r2 == com.fasterxml.jackson.a.n.f12155e) goto L15;
        if (r2 != com.fasterxml.jackson.a.n.m) goto L22;
        if (this.g == true) goto L28;
        String r3 = (String) ZeusTransformUtils.preCheckCast(this.f.a(r5), String.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L25
    L23:
        r7.add(r3);     // Catch: Exception -> L25
        goto L28
    L22:
        r3 = B(r4, r5);     // Catch: Exception -> L25
        goto L23
    L15:
        return r7;
    L12:
        r7.add(r1);     // Catch: Exception -> L25
    L25:
        e = move-exception;
        throw com.fasterxml.jackson.databind.m.a(e, r7, r7.size());
    L9:
        return a(r4, r5, r7, r0);
    L5:
        return b(r4, r5, r7);
    }

    private Collection<String> a(com.fasterxml.jackson.a.k r4, com.fasterxml.jackson.databind.h r5, Collection<String> r6, com.fasterxml.jackson.databind.l<String> r7) {
        Collection<String> r8 = (Collection) ZeusTransformUtils.wrapperContextForParams(r6, Collection.class, "com.obric.aiagent.plugin");
    L21:
        if (r4.j() != null) goto L15;
        com.fasterxml.jackson.a.n r0 = r4.l();     // Catch: Exception -> L18
        if (r0 == com.fasterxml.jackson.a.n.f12155e) goto L7;
        if (r0 != com.fasterxml.jackson.a.n.m) goto L14;
        if (this.g == true) goto L21;
        String r1 = (String) ZeusTransformUtils.preCheckCast(this.f.a(r5), String.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L18
    L16:
        r8.add(r1);     // Catch: Exception -> L18
        goto L21
    L14:
        r1 = (String) ZeusTransformUtils.preCheckCast(r7.a(r4, r5), String.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L18
        goto L16
    L7:
        return r8;
    L15:
        r1 = (String) ZeusTransformUtils.preCheckCast(r7.a(r4, r5), String.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L18
    L18:
        e = move-exception;
        throw com.fasterxml.jackson.databind.m.a(e, r8, r8.size());
    }

    @Override // com.fasterxml.jackson.databind.b.b.ab, com.fasterxml.jackson.databind.l
    public Object a(com.fasterxml.jackson.a.k r1, com.fasterxml.jackson.databind.h r2, com.fasterxml.jackson.databind.h.e r3) {
        return r3.b(r1, r2);
    }

    private final Collection<String> b(com.fasterxml.jackson.a.k r5, com.fasterxml.jackson.databind.h r6, Collection<String> r7) {
        Collection<String> r8 = (Collection) ZeusTransformUtils.wrapperContextForParams(r7, Collection.class, "com.obric.aiagent.plugin");
        if (this.h != Boolean.TRUE) goto L5;
    L10:
        boolean r0 = true;
    L11:
        if (r0 == false) goto L13;
        com.fasterxml.jackson.databind.l<String> r1 = this.f12397a;
        if (r5.l() == com.fasterxml.jackson.a.n.m) goto L21;
        if (r1 != null) goto L26;
        String r4 = B(r5, r6);     // Catch: Exception -> L29
    L32:
    L27:
        r8.add(r4);
        return r8;
    L26:
        r4 = (String) ZeusTransformUtils.preCheckCast(r1.a(r5, r6), String.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L29
    L29:
        e = move-exception;
        throw com.fasterxml.jackson.databind.m.a(e, r8, r8.size());
    L21:
        if (this.g == false) goto L23;
        return r8;
    L23:
        r4 = (String) ZeusTransformUtils.preCheckCast(this.f.a(r6), String.class, "com.obric.aiagent.plugin");
        goto L27
    L13:
        if (r5.a(com.fasterxml.jackson.a.n.h) == false) goto L17;
        return (Collection) ZeusTransformUtils.preCheckCast(r(r5, r6), Collection.class, "com.obric.aiagent.plugin");
    L17:
        return (Collection) ZeusTransformUtils.preCheckCast(r6.a(this.f12422e, r5), Collection.class, "com.obric.aiagent.plugin");
    L5:
        if (this.h == null) goto L7;
    L9:
        r0 = false;
        goto L11
    L7:
        if (r6.a(com.fasterxml.jackson.databind.i.q) == false) goto L9;
        goto L9
    }
}
