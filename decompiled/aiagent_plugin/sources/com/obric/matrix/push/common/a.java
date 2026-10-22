package com.obric.matrix.push.common;

import android.content.Context;
import com.obric.matrix.push.common.cross_process.a.c;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import d.x;

/* JADX INFO: compiled from: CommonSupport.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f33752a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static c f33753b;

    static {
        f33752a = new a();
    }

    private a() {
    }

    public final c a(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        o.e(r4, "context");
        if (f33753b != null) goto L14;
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L6:
        if (f33753b != null) goto L8;
        f33753b = (c) ZeusTransformUtils.preCheckCast(new com.obric.matrix.push.common.cross_process.a(r4), c.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L11
    L8:
        x r5 = x.f38692a;     // Catch: Throwable -> L11
        monitor-exit(this);
    L14:
        c r2 = f33753b;
        o.a(r2);
        return r2;
    }
}
