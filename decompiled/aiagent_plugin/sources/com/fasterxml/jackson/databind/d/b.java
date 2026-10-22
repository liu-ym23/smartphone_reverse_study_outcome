package com.fasterxml.jackson.databind.d;

import com.fasterxml.jackson.databind.e.n;
import com.fasterxml.jackson.databind.l.h;
import com.fasterxml.jackson.databind.x;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: Java7Support.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final b f12563a = null;

    public abstract x a(n r1);

    public abstract Boolean a(com.fasterxml.jackson.databind.e.b r1);

    public abstract Boolean b(com.fasterxml.jackson.databind.e.b r1);

    public b() {
    }

    static {
        b r0 = (b) ZeusTransformUtils.preCheckCast(h.b(ZeusTransformUtils.forName("com.fasterxml.jackson.databind.ext.Java7SupportImpl", "com.obric.aiagent.plugin"), false), b.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L5
    L6:
        f12563a = r0;
        return;
    L5:
        r0 = null;
        goto L6
    }

    public static b a() {
        return f12563a;
    }
}
