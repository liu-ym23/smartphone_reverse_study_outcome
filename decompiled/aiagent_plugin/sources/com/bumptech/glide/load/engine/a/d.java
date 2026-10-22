package com.bumptech.glide.load.engine.a;

import com.bumptech.glide.load.engine.a.m;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Queue;

/* JADX INFO: compiled from: BaseKeyPool.java */
/* JADX INFO: loaded from: classes.dex */
abstract class d<T extends m> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Queue<T> f3530a;

    abstract T b();

    d() {
        this.f3530a = com.bumptech.glide.f.k.a(20);
    }

    T c() {
        T r0 = (T) ZeusTransformUtils.preCheckCast(this.f3530a.poll(), m.class, "com.obric.aiagent.plugin");
        if (r0 == null) goto L5;
        return r0;
    L5:
        return (T) b();
    }

    public void a(T r3) {
        m r4 = (m) ZeusTransformUtils.wrapperContextForParams(r3, m.class, "com.obric.aiagent.plugin");
        if (this.f3530a.size() >= 20) goto L6;
        this.f3530a.offer((T) r4);
        return;
    }
}
