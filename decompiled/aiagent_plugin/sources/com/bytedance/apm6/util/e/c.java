package com.bytedance.apm6.util.e;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: AsyncTaskManagerType.java */
/* JADX INFO: loaded from: classes.dex */
public final enum c extends Enum<c> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f5473a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final c f5474b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final c f5475c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final c f5476d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final /* synthetic */ c[] f5477e = null;

    private c(String r1, int r2) {
        super(r1, r2);
    }

    public static c valueOf(String r2) {
        return (c) ZeusTransformUtils.preCheckCast(Enum.valueOf(c.class, r2), c.class, "com.obric.aiagent.plugin");
    }

    public static c[] values() {
        return (c[]) ZeusTransformUtils.preCheckCast(f5477e.clone(), c[].class, "com.obric.aiagent.plugin");
    }

    static {
        c r0 = new c("IO", 0);
        f5473a = r0;
        c r1 = new c("LIGHT_WEIGHT", 1);
        f5474b = r1;
        c r3 = new c("TIME_SENSITIVE", 2);
        f5475c = r3;
        c r5 = new c("CPU", 3);
        f5476d = r5;
        f5477e = new c[]{r0, r1, r3, r5};
    }
}
