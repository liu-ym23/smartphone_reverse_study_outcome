package com.bytedance.librarian;

import android.content.Context;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: Librarian.java */
/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static Context f8730a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static volatile String f8731b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static c f8732c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Object f8733d = null;

    static {
        f8733d = new Object();
    }

    public static void a(String r2, Context r3) {
        a(r2, false, true, (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"));
    }

    private static void a(String r2, boolean r3, boolean r4, Context r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin");
        if (r4 == true) goto L5;
    L7:
        b r7 = b.f8748a;
        if (r7 == null) goto L10;
        r7.a(r2, r3);
        return;
    L10:
        c r8 = f8732c;
        if (r8 == null) goto L13;
        r8.c(r2);
        return;
    L13:
        System.loadLibrary(r2);
        return;
    L5:
        if (f8730a != null) goto L7;
        f8730a = r6;
        goto L7
    }

    public static UnsatisfiedLinkError[] a() {
        return d.a();
    }
}
