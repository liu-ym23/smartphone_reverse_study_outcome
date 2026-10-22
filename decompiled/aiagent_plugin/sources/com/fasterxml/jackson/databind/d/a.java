package com.fasterxml.jackson.databind.d;

import com.fasterxml.jackson.databind.l;
import com.fasterxml.jackson.databind.l.h;
import com.fasterxml.jackson.databind.p;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: Java7Handlers.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final a f12562a = null;

    public abstract l<?> a(Class<?> r1);

    public abstract p<?> b(Class<?> r1);

    public a() {
    }

    static {
        a r0 = (a) ZeusTransformUtils.preCheckCast(h.b(ZeusTransformUtils.forName("com.fasterxml.jackson.databind.ext.Java7HandlersImpl", "com.obric.aiagent.plugin"), false), a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L5
    L6:
        f12562a = r0;
        return;
    L5:
        r0 = null;
        goto L6
    }

    public static a a() {
        return f12562a;
    }
}
