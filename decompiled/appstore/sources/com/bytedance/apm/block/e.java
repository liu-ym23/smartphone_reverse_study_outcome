package com.bytedance.apm.block;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static List f6394a;

    static {
        f6394a = new ArrayList(2);
    }

    public static synchronized void a(EvilMethodSwitchListener r10) {
        monitor-enter(e.class);
        f6394a.add(r10);     // Catch: Throwable -> L7
        monitor-exit(e.class);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static synchronized void b(boolean r10, long r11) {
        monitor-enter(e.class);
        Iterator r12 = f6394a.iterator();     // Catch: Throwable -> L11
    L6:
        if (r12.hasNext() == false) goto L13;
        EvilMethodSwitchListener r13 = (EvilMethodSwitchListener) r12.next();     // Catch: Throwable -> L11
        if (r13 == null) goto L6;
        r13.onRefresh(r10, r11);     // Catch: Throwable -> L11
        goto L6
    L13:
        monitor-exit(e.class);
        return;
    L11:
        th = move-exception;
        throw th;
    }
}
