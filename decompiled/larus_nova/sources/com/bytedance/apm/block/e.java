package com.bytedance.apm.block;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List<d> f190343a = null;

    static {
        f190343a = new ArrayList(2);
    }

    public static synchronized void a(boolean r100, long r101) {
        monitor-enter(e.class);
        Iterator r102 = ((ArrayList) f190343a).iterator();     // Catch: Throwable -> L13
    L6:
        if (r102.hasNext() == false) goto L11;
        d r103 = (d) r102.next();     // Catch: Throwable -> L13
        if (r103 == null) goto L6;
        r103.b(r100, r101);     // Catch: Throwable -> L13
        goto L6
    L11:
        monitor-exit(e.class);
        return;
    L13:
        th = move-exception;
        throw th;
    }
}
