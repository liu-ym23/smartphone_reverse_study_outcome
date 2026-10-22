package com.obric.agent.utils;

import com.google.gson.Gson;
import com.obric.aiagent.platform.depend.ISecureLogDepend;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: SafeGsonParseUtil.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class u {
    private static final String TAG = "SafeGsonParseUtil";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final u f16076a = null;

    static {
        f16076a = new u();
    }

    private u() {
    }

    private final void a(String r3, Throwable r4) {
        ISecureLogDepend.Companion.e(TAG, "SafeJson failed tag=" + r3 + " err=" + r4.getClass().getSimpleName());
    }

    public final <T> T a(Gson r2, String r3, Class<T> r4, String r5) {
        d.h.b.o.e(r2, "gson");
        d.h.b.o.e(r4, "clazz");
        d.h.b.o.e(r5, "tag");
        CharSequence r1 = (CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin");
        if (r1 != null) goto L5;
    L8:
        boolean r6 = true;
    L10:
        if (r6 == false) goto L24;
        return null;
    L24:
        d.n.a r7 = d.n.f38560a;     // Catch: Throwable -> L14
        Object r8 = d.n.f(r2.fromJson(r3, r4));     // Catch: Throwable -> L14
    L16:
        Throwable r9 = d.n.c(r8);
        if (r9 == null) goto L20;
        f16076a.a(r5, r9);
    L20:
        if (d.n.b(r8) == false) goto L23;
        return null;
    L23:
        return (T) r8;
    L14:
        th = move-exception;
        d.n.a r10 = d.n.f38560a;
        r8 = d.n.f(d.o.a(th));
        goto L16
    L5:
        if (r1.length() == 0) goto L8;
        r6 = false;
        goto L10
    }

    public final <T> T a(Gson r2, String r3, Class<T> r4, T r5, String r6) {
        d.h.b.o.e(r2, "gson");
        d.h.b.o.e(r4, "clazz");
        d.h.b.o.e(r6, "tag");
        T r1 = (T) a(r2, r3, r4, r6);
        if (r1 != null) goto L6;
        return r5;
    L6:
        return r1;
    }
}
