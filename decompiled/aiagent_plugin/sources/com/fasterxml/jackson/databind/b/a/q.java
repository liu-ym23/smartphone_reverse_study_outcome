package com.fasterxml.jackson.databind.b.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;

/* JADX INFO: compiled from: NullsConstantProvider.java */
/* JADX INFO: loaded from: classes2.dex */
public class q implements com.fasterxml.jackson.databind.b.s, Serializable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final q f12322c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final q f12323d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final Object f12324a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final com.fasterxml.jackson.databind.l.a f12325b;

    static {
        f12322c = new q(null);
        f12323d = new q(null);
    }

    public q(Object r1) {
        this.f12324a = r1;
        if (r1 != null) goto L5;
        com.fasterxml.jackson.databind.l.a r2 = com.fasterxml.jackson.databind.l.a.f12994a;
    L6:
        this.f12325b = r2;
        return;
    L5:
        r2 = com.fasterxml.jackson.databind.l.a.f12995b;
        goto L6
    }

    public static q a() {
        return f12322c;
    }

    public static q b() {
        return f12323d;
    }

    public static q a(Object r1) {
        if (r1 != null) goto L6;
        return f12323d;
    L6:
        return new q(r1);
    }

    public static boolean a(com.fasterxml.jackson.databind.b.s r2) {
        if (((com.fasterxml.jackson.databind.b.s) ZeusTransformUtils.wrapperContextForParams(r2, com.fasterxml.jackson.databind.b.s.class, "com.obric.aiagent.plugin")) != f12322c) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.fasterxml.jackson.databind.b.s
    public Object a(com.fasterxml.jackson.databind.h r1) {
        return this.f12324a;
    }
}
