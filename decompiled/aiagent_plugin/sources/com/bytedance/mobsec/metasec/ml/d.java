package com.bytedance.mobsec.metasec.ml;

import android.content.Context;
import com.bytedance.mobsec.metasec.a.e;
import com.bytedance.mobsec.metasec.a.f;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public final class d {

    public interface a {
        int a();
    }

    public static synchronized c a(String r2) {
        monitor-enter(d.class);
        e r3 = f.a(r2);     // Catch: Throwable -> L11
        if (r3 == null) goto L8;
        c r1 = new c(r3);     // Catch: Throwable -> L11
    L9:
        monitor-exit(d.class);
        return r1;
    L8:
        r1 = null;
    L11:
        th = move-exception;
        throw th;
    }

    public static synchronized boolean a(Context r3, b r4) {
        monitor-enter(d.class);
        boolean r5 = f.a((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), r4.b());     // Catch: Throwable -> L7
        monitor-exit(d.class);
        return r5;
    L7:
        th = move-exception;
        throw th;
    }
}
