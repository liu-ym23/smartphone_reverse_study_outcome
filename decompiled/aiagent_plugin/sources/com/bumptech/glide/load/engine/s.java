package com.bumptech.glide.load.engine;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: Jobs.java */
/* JADX INFO: loaded from: classes.dex */
final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<com.bumptech.glide.load.g, l<?>> f3728a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map<com.bumptech.glide.load.g, l<?>> f3729b;

    s() {
        this.f3728a = new HashMap();
        this.f3729b = new HashMap();
    }

    l<?> a(com.bumptech.glide.load.g r3, boolean r4) {
        com.bumptech.glide.load.g r5 = (com.bumptech.glide.load.g) ZeusTransformUtils.wrapperContextForParams(r3, com.bumptech.glide.load.g.class, "com.obric.aiagent.plugin");
        return (l) ZeusTransformUtils.preCheckCast(a(r4).get(r5), l.class, "com.obric.aiagent.plugin");
    }

    void a(com.bumptech.glide.load.g r3, l<?> r4) {
        com.bumptech.glide.load.g r5 = (com.bumptech.glide.load.g) ZeusTransformUtils.wrapperContextForParams(r3, com.bumptech.glide.load.g.class, "com.obric.aiagent.plugin");
        a(r4.a()).put(r5, r4);
    }

    void b(com.bumptech.glide.load.g r3, l<?> r4) {
        com.bumptech.glide.load.g r5 = (com.bumptech.glide.load.g) ZeusTransformUtils.wrapperContextForParams(r3, com.bumptech.glide.load.g.class, "com.obric.aiagent.plugin");
        Map<com.bumptech.glide.load.g, l<?>> r2 = a(r4.a());
        if (r4.equals(r2.get(r5)) == false) goto L6;
        r2.remove(r5);
        return;
    }

    private Map<com.bumptech.glide.load.g, l<?>> a(boolean r1) {
        if (r1 == false) goto L5;
        return this.f3729b;
    L5:
        return this.f3728a;
    }
}
