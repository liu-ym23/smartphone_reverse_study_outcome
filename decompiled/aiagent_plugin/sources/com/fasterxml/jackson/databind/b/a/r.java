package com.fasterxml.jackson.databind.b.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;

/* JADX INFO: compiled from: NullsFailProvider.java */
/* JADX INFO: loaded from: classes2.dex */
public class r implements com.fasterxml.jackson.databind.b.s, Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final com.fasterxml.jackson.databind.x f12326a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final com.fasterxml.jackson.databind.k f12327b;

    public r(com.fasterxml.jackson.databind.x r1, com.fasterxml.jackson.databind.k r2) {
        this.f12326a = r1;
        this.f12327b = r2;
    }

    public static r a(com.fasterxml.jackson.databind.d r2) {
        com.fasterxml.jackson.databind.d r3 = (com.fasterxml.jackson.databind.d) ZeusTransformUtils.wrapperContextForParams(r2, com.fasterxml.jackson.databind.d.class, "com.obric.aiagent.plugin");
        return a(r3, r3.getType());
    }

    public static r a(com.fasterxml.jackson.databind.d r2, com.fasterxml.jackson.databind.k r3) {
        return new r(((com.fasterxml.jackson.databind.d) ZeusTransformUtils.wrapperContextForParams(r2, com.fasterxml.jackson.databind.d.class, "com.obric.aiagent.plugin")).b(), r3);
    }

    public static r a(com.fasterxml.jackson.databind.k r2) {
        return new r(null, r2);
    }

    @Override // com.fasterxml.jackson.databind.b.s
    public Object a(com.fasterxml.jackson.databind.h r2) {
        throw com.fasterxml.jackson.databind.c.d.a(r2, this.f12326a, this.f12327b);
    }
}
