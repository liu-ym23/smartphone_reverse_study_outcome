package com.a.c;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: CronType.java */
/* JADX INFO: loaded from: classes.dex */
public final enum c extends Enum<c> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f3138a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final c f3139b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final c f3140c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final c f3141d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final c f3142e = null;
    private static final /* synthetic */ c[] f = null;

    private c(String r1, int r2) {
        super(r1, r2);
    }

    public static c valueOf(String r2) {
        return (c) ZeusTransformUtils.preCheckCast(Enum.valueOf(c.class, r2), c.class, "com.obric.aiagent.plugin");
    }

    public static c[] values() {
        return (c[]) ZeusTransformUtils.preCheckCast(f.clone(), c[].class, "com.obric.aiagent.plugin");
    }

    static {
        c r0 = new c("CRON4J", 0);
        f3138a = r0;
        c r1 = new c("QUARTZ", 1);
        f3139b = r1;
        c r3 = new c("UNIX", 2);
        f3140c = r3;
        c r5 = new c("SPRING", 3);
        f3141d = r5;
        c r7 = new c("SPRING53", 4);
        f3142e = r7;
        f = new c[]{r0, r1, r3, r5, r7};
    }
}
