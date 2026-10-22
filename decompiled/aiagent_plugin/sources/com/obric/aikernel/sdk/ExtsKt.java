package com.obric.aikernel.sdk;

import android.os.Parcel;
import com.obric.aikernel.core.log.AIKLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.d;
import d.h.a.b;
import d.h.b.o;
import d.n;
import d.x;

/* JADX INFO: compiled from: Exts.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class ExtsKt {
    public static final <T> T safeRead(Parcel r2, b<? super Parcel, ? extends T> r3) {
        b r4 = (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.aiagent.plugin");
        o.e(r2, "<this>");
        o.e(r4, "block");
        if (r2.dataAvail() > 0) goto L7;
        return null;
    L7:
        return (T) r4.invoke(r2);
    }

    public static final <T> void resume(d<? super T> r2, T r3) {
        d r4 = (d) ZeusTransformUtils.wrapperContextForParams(r2, d.class, "com.obric.aiagent.plugin");
        o.e(r4, "<this>");
        n.a r0 = n.f38560a;     // Catch: Throwable -> L5
        n.a r1 = n.f38560a;     // Catch: Throwable -> L5
        r4.resumeWith(n.f(r3));     // Catch: Throwable -> L5
        Object r5 = n.f(x.f38692a);     // Catch: Throwable -> L5
    L7:
        Throwable r6 = n.c(r5);
        if (r6 == null) goto L13;
        AIKLog.INSTANCE.w("Continuation", "resume failed, " + r6);
        return;
    L13:
        return;
    L5:
        th = move-exception;
        n.a r7 = n.f38560a;
        r5 = n.f(d.o.a(th));
        goto L7
    }
}
