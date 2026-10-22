package com.fasterxml.jackson.a.h;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.ref.SoftReference;

/* JADX INFO: compiled from: BufferRecyclers.java */
/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected static final ThreadLocal<SoftReference<a>> f12091a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final p f12092b = null;

    static {
        boolean r0 = "true".equals(System.getProperty("com.fasterxml.jackson.core.util.BufferRecyclers.trackReusableBuffers"));     // Catch: SecurityException -> L4
    L5:
        if (r0 == false) goto L7;
        p r1 = p.a();
    L8:
        f12092b = r1;
        f12091a = new ThreadLocal();
        return;
    L7:
        r1 = null;
    L4:
        r0 = false;
        goto L5
    }

    public static a a() {
        ThreadLocal<SoftReference<a>> r0 = f12091a;
        SoftReference r1 = (SoftReference) ZeusTransformUtils.preCheckCast(r0.get(), SoftReference.class, "com.obric.aiagent.plugin");
        if (r1 != null) goto L5;
        a r2 = null;
    L6:
        if (r2 != null) goto L12;
        r2 = new a();
        p r3 = f12092b;
        if (r3 == null) goto L10;
        SoftReference<a> r4 = r3.a(r2);
    L11:
        r0.set(r4);
        goto L12
    L10:
        r4 = new SoftReference(r2);
    L12:
        return r2;
    L5:
        r2 = (a) ZeusTransformUtils.preCheckCast(r1.get(), a.class, "com.obric.aiagent.plugin");
        goto L6
    }
}
