package com.bytedance.android.livesdk.log;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes10.dex */
public final class o {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static o f153416b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, String> f153417a;

    public static synchronized o a() {
        monitor-enter(o.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (f153416b != null) goto L7;
        f153416b = new o();     // Catch: Throwable -> L10
    L7:
        o r100 = f153416b;     // Catch: Throwable -> L10
        monitor-exit(o.class);
        return r100;
    }

    public o() {
        this.f153417a = new HashMap();
    }

    public final void b(long r100, String r101) {
        ((HashMap) this.f153417a).put(r100 + com.bytedance.android.ec.core.event.a.KEY_SORD_TYPE, r101);
    }
}
