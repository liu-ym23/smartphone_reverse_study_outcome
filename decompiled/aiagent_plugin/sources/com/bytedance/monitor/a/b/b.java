package com.bytedance.monitor.a.b;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: AsyncTaskType.java */
/* JADX INFO: loaded from: classes.dex */
public final enum b extends Enum<b> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f8907a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b f8908b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final b f8909c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final /* synthetic */ b[] f8910d = null;

    public static b valueOf(String r2) {
        return (b) ZeusTransformUtils.preCheckCast(Enum.valueOf(b.class, r2), b.class, "com.obric.aiagent.plugin");
    }

    public static b[] values() {
        return (b[]) ZeusTransformUtils.preCheckCast(f8910d.clone(), b[].class, "com.obric.aiagent.plugin");
    }

    static {
        b r0 = new b("IO", 0);
        f8907a = r0;
        b r1 = new b("TIME_SENSITIVE", 1);
        f8908b = r1;
        b r3 = new b("LIGHT_WEIGHT", 2);
        f8909c = r3;
        f8910d = new b[]{r0, r1, r3};
    }

    private b(String r1, int r2) {
        super(r1, r2);
    }
}
