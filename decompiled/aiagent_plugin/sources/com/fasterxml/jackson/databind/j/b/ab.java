package com.fasterxml.jackson.databind.j.b;

import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: SerializableSerializer.java */
/* JADX INFO: loaded from: classes2.dex */
@JacksonStdImpl
public class ab extends aj<com.fasterxml.jackson.databind.o> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ab f12867a = null;

    @Override // com.fasterxml.jackson.databind.j.b.aj, com.fasterxml.jackson.databind.p
    public /* synthetic */ void a(Object r3, com.fasterxml.jackson.a.h r4, com.fasterxml.jackson.databind.ac r5) {
        a((com.fasterxml.jackson.databind.o) ZeusTransformUtils.preCheckCast(r3, com.fasterxml.jackson.databind.o.class, "com.obric.aiagent.plugin"), r4, r5);
    }

    @Override // com.fasterxml.jackson.databind.p
    public /* synthetic */ void a(Object r3, com.fasterxml.jackson.a.h r4, com.fasterxml.jackson.databind.ac r5, com.fasterxml.jackson.databind.h.h r6) {
        a((com.fasterxml.jackson.databind.o) ZeusTransformUtils.preCheckCast(r3, com.fasterxml.jackson.databind.o.class, "com.obric.aiagent.plugin"), r4, r5, r6);
    }

    @Override // com.fasterxml.jackson.databind.p
    public /* synthetic */ boolean a(com.fasterxml.jackson.databind.ac r3, Object r4) {
        return a(r3, (com.fasterxml.jackson.databind.o) ZeusTransformUtils.preCheckCast(r4, com.fasterxml.jackson.databind.o.class, "com.obric.aiagent.plugin"));
    }

    static {
        f12867a = new ab();
    }

    public ab() {
        super(com.fasterxml.jackson.databind.o.class);
    }

    public boolean a(com.fasterxml.jackson.databind.ac r2, com.fasterxml.jackson.databind.o r3) {
        com.fasterxml.jackson.databind.o r1 = (com.fasterxml.jackson.databind.o) ZeusTransformUtils.wrapperContextForParams(r3, com.fasterxml.jackson.databind.o.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r1, com.fasterxml.jackson.databind.o.a.class) == true) goto L5;
        return false;
    L5:
        return ((com.fasterxml.jackson.databind.o.a) ZeusTransformUtils.preCheckCast(r1, com.fasterxml.jackson.databind.o.a.class, "com.obric.aiagent.plugin")).a(r2);
    }

    public void a(com.fasterxml.jackson.databind.o r2, com.fasterxml.jackson.a.h r3, com.fasterxml.jackson.databind.ac r4) {
        ((com.fasterxml.jackson.databind.o) ZeusTransformUtils.wrapperContextForParams(r2, com.fasterxml.jackson.databind.o.class, "com.obric.aiagent.plugin")).a(r3, r4);
    }

    public final void a(com.fasterxml.jackson.databind.o r2, com.fasterxml.jackson.a.h r3, com.fasterxml.jackson.databind.ac r4, com.fasterxml.jackson.databind.h.h r5) {
        ((com.fasterxml.jackson.databind.o) ZeusTransformUtils.wrapperContextForParams(r2, com.fasterxml.jackson.databind.o.class, "com.obric.aiagent.plugin")).a(r3, r4, r5);
    }
}
