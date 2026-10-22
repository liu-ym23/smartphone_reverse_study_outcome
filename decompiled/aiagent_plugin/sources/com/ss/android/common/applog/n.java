package com.ss.android.common.applog;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: compiled from: LaunchObserverHolder.java */
/* JADX INFO: loaded from: classes4.dex */
public class n implements m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile n f37191a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final CopyOnWriteArraySet<m> f37192b;

    public static n a() {
        if (f37191a != null) goto L15;
        monitor-enter(n.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f37191a != null) goto L9;
        f37191a = new n();     // Catch: Throwable -> L11
    L9:
        monitor-exit(n.class);     // Catch: Throwable -> L11
    L15:
        return f37191a;
    }

    private n() {
        this.f37192b = new CopyOnWriteArraySet();
    }

    @Override // com.ss.android.common.applog.m
    public void a(String r4, long r5, boolean r7) {
        Iterator<m> r3 = this.f37192b.iterator();
    L4:
        if (r3.hasNext() == false) goto L9;
        ((m) ZeusTransformUtils.preCheckCast(r3.next(), m.class, "com.obric.aiagent.plugin")).a(r4, r5, r7);     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        th.printStackTrace();
        goto L4
    }
}
