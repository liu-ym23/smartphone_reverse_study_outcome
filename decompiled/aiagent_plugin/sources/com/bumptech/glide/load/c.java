package com.bumptech.glide.load;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: EncodeStrategy.java */
/* JADX INFO: loaded from: classes.dex */
public final enum c extends Enum<c> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f3506a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final c f3507b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final c f3508c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final /* synthetic */ c[] f3509d = null;

    private c(String r1, int r2) {
        super(r1, r2);
    }

    public static c valueOf(String r2) {
        return (c) ZeusTransformUtils.preCheckCast(Enum.valueOf(c.class, r2), c.class, "com.obric.aiagent.plugin");
    }

    public static c[] values() {
        return (c[]) ZeusTransformUtils.preCheckCast(f3509d.clone(), c[].class, "com.obric.aiagent.plugin");
    }

    static {
        c r0 = new c("SOURCE", 0);
        f3506a = r0;
        c r1 = new c("TRANSFORMED", 1);
        f3507b = r1;
        c r3 = new c("NONE", 2);
        f3508c = r3;
        f3509d = new c[]{r0, r1, r3};
    }
}
