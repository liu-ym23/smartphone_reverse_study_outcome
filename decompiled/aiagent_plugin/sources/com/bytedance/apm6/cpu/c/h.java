package com.bytedance.apm6.cpu.c;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: StateType.java */
/* JADX INFO: loaded from: classes.dex */
public final enum h extends Enum<h> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h f5271a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final h f5272b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final h f5273c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final h f5274d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final h f5275e = null;
    private static final /* synthetic */ h[] f = null;

    private h(String r1, int r2) {
        super(r1, r2);
    }

    public static h valueOf(String r2) {
        return (h) ZeusTransformUtils.preCheckCast(Enum.valueOf(h.class, r2), h.class, "com.obric.aiagent.plugin");
    }

    public static h[] values() {
        return (h[]) ZeusTransformUtils.preCheckCast(f.clone(), h[].class, "com.obric.aiagent.plugin");
    }

    static {
        h r0 = new h("PROCESS_DETECT", 0);
        f5271a = r0;
        h r1 = new h("PROCESS_DOUBLE_DETECT", 1);
        f5272b = r1;
        h r3 = new h("THREAD_DETECT", 2);
        f5273c = r3;
        h r5 = new h("COOL_DOWN", 3);
        f5274d = r5;
        h r7 = new h("IDLE", 4);
        f5275e = r7;
        f = new h[]{r0, r1, r3, r5, r7};
    }
}
