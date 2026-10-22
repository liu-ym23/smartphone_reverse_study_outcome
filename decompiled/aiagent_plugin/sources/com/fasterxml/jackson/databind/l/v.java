package com.fasterxml.jackson.databind.l;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;

/* JADX INFO: compiled from: RootNameLookup.java */
/* JADX INFO: loaded from: classes2.dex */
public class v implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected transient n<com.fasterxml.jackson.databind.k.b, com.fasterxml.jackson.databind.x> f13067a;

    public v() {
        this.f13067a = new n(20, 200);
    }

    public com.fasterxml.jackson.databind.x a(com.fasterxml.jackson.databind.k r1, com.fasterxml.jackson.databind.a.m<?> r2) {
        return a(r1.e(), r2);
    }

    public com.fasterxml.jackson.databind.x a(Class<?> r5, com.fasterxml.jackson.databind.a.m<?> r6) {
        com.fasterxml.jackson.databind.k.b r0 = new com.fasterxml.jackson.databind.k.b(r5);
        com.fasterxml.jackson.databind.x r1 = (com.fasterxml.jackson.databind.x) ZeusTransformUtils.preCheckCast(this.f13067a.a(r0), com.fasterxml.jackson.databind.x.class, "com.obric.aiagent.plugin");
        if (r1 == null) goto L5;
        return r1;
    L5:
        com.fasterxml.jackson.databind.c r2 = r6.c(r5);
        com.fasterxml.jackson.databind.x r7 = r6.j().a(r2.c());
        if (r7 != null) goto L8;
    L9:
        r7 = com.fasterxml.jackson.databind.x.a(r5.getSimpleName());
    L10:
        this.f13067a.a(r0, r7);
        return r7;
    L8:
        if (r7.c() == true) goto L10;
        goto L9
    }
}
