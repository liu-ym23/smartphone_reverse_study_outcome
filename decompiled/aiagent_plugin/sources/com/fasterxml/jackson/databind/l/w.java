package com.fasterxml.jackson.databind.l;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collections;
import java.util.Iterator;

/* JADX INFO: compiled from: SimpleBeanPropertyDefinition.java */
/* JADX INFO: loaded from: classes2.dex */
public class w extends com.fasterxml.jackson.databind.e.t {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final com.fasterxml.jackson.databind.b f13068b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected final com.fasterxml.jackson.databind.e.j f13069c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected final com.fasterxml.jackson.databind.w f13070d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected final com.fasterxml.jackson.databind.x f13071e;
    protected final JsonInclude.Value f;

    @Override // com.fasterxml.jackson.databind.e.t
    public boolean d() {
        return false;
    }

    @Override // com.fasterxml.jackson.databind.e.t
    public boolean e() {
        return false;
    }

    public w(com.fasterxml.jackson.databind.b r1, com.fasterxml.jackson.databind.e.j r2, com.fasterxml.jackson.databind.x r3, com.fasterxml.jackson.databind.w r4, JsonInclude.Value r5) {
        this.f13068b = r1;
        this.f13069c = r2;
        this.f13071e = r3;
        if (r4 != null) goto L5;
        r4 = com.fasterxml.jackson.databind.w.f13126b;
    L5:
        this.f13070d = r4;
        this.f = r5;
    }

    public static w a(com.fasterxml.jackson.databind.a.m<?> r2, com.fasterxml.jackson.databind.e.j r3, com.fasterxml.jackson.databind.x r4) {
        return a(r2, r3, r4, null, f12668a);
    }

    public static w a(com.fasterxml.jackson.databind.a.m<?> r6, com.fasterxml.jackson.databind.e.j r7, com.fasterxml.jackson.databind.x r8, com.fasterxml.jackson.databind.w r9, JsonInclude.Include r10) {
        if (r10 != null) goto L4;
    L7:
        JsonInclude.Value r11 = f12668a;
    L8:
        com.fasterxml.jackson.databind.b r1 = r6.j();
        return new w(r1, r7, r8, r9, r11);
    L4:
        if (r10 == JsonInclude.Include.USE_DEFAULTS) goto L7;
        r11 = JsonInclude.Value.construct(r10, null);
        goto L8
    }

    public static w a(com.fasterxml.jackson.databind.a.m<?> r7, com.fasterxml.jackson.databind.e.j r8, com.fasterxml.jackson.databind.x r9, com.fasterxml.jackson.databind.w r10, JsonInclude.Value r11) {
        return new w(r7.j(), r8, r9, r10, r11);
    }

    @Override // com.fasterxml.jackson.databind.e.t, com.fasterxml.jackson.databind.l.r
    public String a() {
        return this.f13071e.b();
    }

    @Override // com.fasterxml.jackson.databind.e.t
    public com.fasterxml.jackson.databind.x b() {
        return this.f13071e;
    }

    @Override // com.fasterxml.jackson.databind.e.t
    public boolean a(com.fasterxml.jackson.databind.x r1) {
        return this.f13071e.equals(r1);
    }

    @Override // com.fasterxml.jackson.databind.e.t
    public com.fasterxml.jackson.databind.x c() {
        com.fasterxml.jackson.databind.b r0 = this.f13068b;
        if (r0 == null) goto L9;
        com.fasterxml.jackson.databind.e.j r1 = this.f13069c;
        if (r1 != null) goto L8;
        return null;
    L8:
        return r0.g(r1);
    L9:
        return null;
    }

    @Override // com.fasterxml.jackson.databind.e.t
    public com.fasterxml.jackson.databind.w h() {
        return this.f13070d;
    }

    @Override // com.fasterxml.jackson.databind.e.t
    public com.fasterxml.jackson.databind.k f() {
        com.fasterxml.jackson.databind.e.j r0 = this.f13069c;
        if (r0 != null) goto L7;
        return com.fasterxml.jackson.databind.k.o.c();
    L7:
        return r0.getType();
    }

    @Override // com.fasterxml.jackson.databind.e.t
    public Class<?> g() {
        com.fasterxml.jackson.databind.e.j r0 = this.f13069c;
        if (r0 != null) goto L7;
        return Object.class;
    L7:
        return r0.c();
    }

    @Override // com.fasterxml.jackson.databind.e.t
    public JsonInclude.Value B() {
        return this.f;
    }

    @Override // com.fasterxml.jackson.databind.e.t
    public boolean k() {
        if (o() == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.fasterxml.jackson.databind.e.t
    public boolean l() {
        return ZeusTransformUtils.instanceOf(this.f13069c, com.fasterxml.jackson.databind.e.h.class);
    }

    @Override // com.fasterxml.jackson.databind.e.t
    public boolean m() {
        return ZeusTransformUtils.instanceOf(this.f13069c, com.fasterxml.jackson.databind.e.n.class);
    }

    @Override // com.fasterxml.jackson.databind.e.t
    public com.fasterxml.jackson.databind.e.k n() {
        if (ZeusTransformUtils.instanceOf(this.f13069c, com.fasterxml.jackson.databind.e.k.class) == true) goto L5;
        return null;
    L5:
        if (((com.fasterxml.jackson.databind.e.k) ZeusTransformUtils.preCheckCast(this.f13069c, com.fasterxml.jackson.databind.e.k.class, "com.obric.aiagent.plugin")).e() == 0) goto L7;
        return null;
    L7:
        return (com.fasterxml.jackson.databind.e.k) ZeusTransformUtils.preCheckCast(this.f13069c, com.fasterxml.jackson.databind.e.k.class, "com.obric.aiagent.plugin");
    }

    @Override // com.fasterxml.jackson.databind.e.t
    public com.fasterxml.jackson.databind.e.k o() {
        if (ZeusTransformUtils.instanceOf(this.f13069c, com.fasterxml.jackson.databind.e.k.class) == true) goto L5;
        return null;
    L5:
        if (((com.fasterxml.jackson.databind.e.k) ZeusTransformUtils.preCheckCast(this.f13069c, com.fasterxml.jackson.databind.e.k.class, "com.obric.aiagent.plugin")).e() == 1) goto L7;
        return null;
    L7:
        return (com.fasterxml.jackson.databind.e.k) ZeusTransformUtils.preCheckCast(this.f13069c, com.fasterxml.jackson.databind.e.k.class, "com.obric.aiagent.plugin");
    }

    @Override // com.fasterxml.jackson.databind.e.t
    public com.fasterxml.jackson.databind.e.h p() {
        if (ZeusTransformUtils.instanceOf(this.f13069c, com.fasterxml.jackson.databind.e.h.class) == true) goto L7;
        return null;
    L7:
        return (com.fasterxml.jackson.databind.e.h) ZeusTransformUtils.preCheckCast(this.f13069c, com.fasterxml.jackson.databind.e.h.class, "com.obric.aiagent.plugin");
    }

    @Override // com.fasterxml.jackson.databind.e.t
    public com.fasterxml.jackson.databind.e.n q() {
        if (ZeusTransformUtils.instanceOf(this.f13069c, com.fasterxml.jackson.databind.e.n.class) == true) goto L7;
        return null;
    L7:
        return (com.fasterxml.jackson.databind.e.n) ZeusTransformUtils.preCheckCast(this.f13069c, com.fasterxml.jackson.databind.e.n.class, "com.obric.aiagent.plugin");
    }

    @Override // com.fasterxml.jackson.databind.e.t
    public Iterator<com.fasterxml.jackson.databind.e.n> r() {
        com.fasterxml.jackson.databind.e.n r0 = q();
        if (r0 != null) goto L7;
        return h.a();
    L7:
        return Collections.singleton(r0).iterator();
    }

    @Override // com.fasterxml.jackson.databind.e.t
    public com.fasterxml.jackson.databind.e.j v() {
        return this.f13069c;
    }
}
