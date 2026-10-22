package com.bytedance.crypto.obfuscated;

import android.content.Context;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile n f7871a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final m f7872b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Context f7873c;

    public n(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        this.f7873c = ZeusTransformUtils.wrapperContext(r4, "com.obric.aiagent.plugin");
        this.f7872b = m.a(r4);
    }

    public static j a(j r2) {
        j r0 = new j();
        r0.f7863a = r2.f7863a;
        r0.f7864b = r2.f7864b;
        r0.f7865c = r2.f7865c;
        r0.f7866d = r2.f7866d;
        r0.f7867e = r2.f7867e;
        r0.f = r2.f;
        r0.g = r2.g;
        r0.h = r2.h;
        r0.i = r2.i;
        r0.j = r2.j;
        r0.k = r2.k;
        r0.l = r2.l;
        r0.m = r2.m;
        return r0;
    }

    public static n a(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        if (f7871a != null) goto L15;
        monitor-enter(n.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f7871a != null) goto L9;
        f7871a = new n(r3);     // Catch: Throwable -> L11
    L9:
        monitor-exit(n.class);     // Catch: Throwable -> L11
    L15:
        return f7871a;
    }
}
