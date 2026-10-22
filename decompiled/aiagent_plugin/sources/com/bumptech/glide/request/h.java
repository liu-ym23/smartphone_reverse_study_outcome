package com.bumptech.glide.request;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: RequestOptions.java */
/* JADX INFO: loaded from: classes.dex */
public class h extends a<h> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static h f3928a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static h f3929b;

    public h() {
    }

    public static h b(com.bumptech.glide.load.engine.j r2) {
        return (h) ZeusTransformUtils.preCheckCast(new h().a(r2), h.class, "com.obric.aiagent.plugin");
    }

    public static h c(boolean r3) {
        if (r3 == false) goto L10;
        if (f3928a != null) goto L8;
        f3928a = (h) ZeusTransformUtils.preCheckCast(((h) ZeusTransformUtils.preCheckCast(new h().b(true), h.class, "com.obric.aiagent.plugin")).j(), h.class, "com.obric.aiagent.plugin");
    L8:
        return f3928a;
    L10:
        if (f3929b != null) goto L13;
        f3929b = (h) ZeusTransformUtils.preCheckCast(((h) ZeusTransformUtils.preCheckCast(new h().b(false), h.class, "com.obric.aiagent.plugin")).j(), h.class, "com.obric.aiagent.plugin");
    L13:
        return f3929b;
    }

    public static h b(com.bumptech.glide.load.g r2) {
        com.bumptech.glide.load.g r3 = (com.bumptech.glide.load.g) ZeusTransformUtils.wrapperContextForParams(r2, com.bumptech.glide.load.g.class, "com.obric.aiagent.plugin");
        return (h) ZeusTransformUtils.preCheckCast(new h().a(r3), h.class, "com.obric.aiagent.plugin");
    }

    public static h b(Class<?> r2) {
        return (h) ZeusTransformUtils.preCheckCast(new h().a(r2), h.class, "com.obric.aiagent.plugin");
    }
}
