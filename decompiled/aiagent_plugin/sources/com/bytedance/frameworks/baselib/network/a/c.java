package com.bytedance.frameworks.baselib.network.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: NetworkAsyncTaskType.java */
/* JADX INFO: loaded from: classes.dex */
public final enum c extends Enum<c> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f7963a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final /* synthetic */ c[] f7964b = null;

    private c(String r1, int r2) {
        super(r1, r2);
    }

    public static c valueOf(String r2) {
        return (c) ZeusTransformUtils.preCheckCast(Enum.valueOf(c.class, r2), c.class, "com.obric.aiagent.plugin");
    }

    public static c[] values() {
        return (c[]) ZeusTransformUtils.preCheckCast(f7964b.clone(), c[].class, "com.obric.aiagent.plugin");
    }

    static {
        c r0 = new c("NETWORK", 0);
        f7963a = r0;
        f7964b = new c[]{r0};
    }
}
