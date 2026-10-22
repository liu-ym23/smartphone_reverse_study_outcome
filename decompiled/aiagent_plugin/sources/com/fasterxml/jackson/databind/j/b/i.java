package com.fasterxml.jackson.databind.j.b;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: ClassSerializer.java */
/* JADX INFO: loaded from: classes2.dex */
public class i extends ai<Class<?>> {
    @Override // com.fasterxml.jackson.databind.j.b.aj, com.fasterxml.jackson.databind.p
    public /* synthetic */ void a(Object r3, com.fasterxml.jackson.a.h r4, com.fasterxml.jackson.databind.ac r5) {
        a((Class) ZeusTransformUtils.preCheckCast(r3, Class.class, "com.obric.aiagent.plugin"), r4, r5);
    }

    public i() {
        super(Class.class, false);
    }

    public void a(Class<?> r1, com.fasterxml.jackson.a.h r2, com.fasterxml.jackson.databind.ac r3) {
        r2.b(r1.getName());
    }
}
