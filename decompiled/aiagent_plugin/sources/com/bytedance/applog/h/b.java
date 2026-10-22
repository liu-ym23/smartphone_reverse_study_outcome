package com.bytedance.applog.h;

import com.bytedance.applog.l;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collections;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: compiled from: LaunchObserverHolder.java */
/* JADX INFO: loaded from: classes.dex */
public class b implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.bytedance.applog.c f5643a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final CopyOnWriteArraySet<l> f5644b;

    public b(com.bytedance.applog.c r2) {
        this.f5644b = new CopyOnWriteArraySet();
        this.f5643a = r2;
    }

    @Override // com.bytedance.applog.l
    public void a(String r7, long r8, boolean r10) {
        Iterator<l> r0 = this.f5644b.iterator();
    L4:
        if (r0.hasNext() == false) goto L10;
        ((l) ZeusTransformUtils.preCheckCast(r0.next(), l.class, "com.obric.aiagent.plugin")).a(r7, r8, r10);     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        this.f5643a.Z().a(Collections.singletonList("LaunchObserverHolder"), "invoke onLaunch callback failed", th, new Object[0]);
        goto L4
    }
}
