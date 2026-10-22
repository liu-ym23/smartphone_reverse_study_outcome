package com.fasterxml.jackson.databind.c;

import com.fasterxml.jackson.a.k;
import com.fasterxml.jackson.databind.m;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: MismatchedInputException.java */
/* JADX INFO: loaded from: classes2.dex */
public class f extends m {
    protected Class<?> f;

    public f(k r4, String r5) {
        this(r4, r5, (com.fasterxml.jackson.databind.k) ZeusTransformUtils.preCheckCast(null, com.fasterxml.jackson.databind.k.class, "com.obric.aiagent.plugin"));
    }

    public f(k r1, String r2, com.fasterxml.jackson.a.i r3) {
        super(r1, r2, r3);
    }

    public f(k r1, String r2, Class<?> r3) {
        super(r1, r2);
        this.f = r3;
    }

    public f(k r1, String r2, com.fasterxml.jackson.databind.k r3) {
        super(r1, r2);
        this.f = com.fasterxml.jackson.databind.l.h.a(r3);
    }

    public static f a(k r1, com.fasterxml.jackson.databind.k r2, String r3) {
        return new f(r1, r3, r2);
    }

    public static f a(k r1, Class<?> r2, String r3) {
        return new f(r1, r3, r2);
    }

    public f a(com.fasterxml.jackson.databind.k r1) {
        this.f = r1.e();
        return this;
    }
}
