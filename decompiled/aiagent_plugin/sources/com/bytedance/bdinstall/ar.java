package com.bytedance.bdinstall;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: Level.java */
/* JADX INFO: loaded from: classes.dex */
public final enum ar extends Enum<ar> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ar f6144a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ar f6145b = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final /* synthetic */ ar[] f6146d = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f6147c;

    public static ar valueOf(String r2) {
        return (ar) ZeusTransformUtils.preCheckCast(Enum.valueOf(ar.class, r2), ar.class, "com.obric.aiagent.plugin");
    }

    public static ar[] values() {
        return (ar[]) ZeusTransformUtils.preCheckCast(f6146d.clone(), ar[].class, "com.obric.aiagent.plugin");
    }

    static {
        ar r0 = new ar("L0", 0, 0);
        f6144a = r0;
        ar r1 = new ar("L1", 1, 1);
        f6145b = r1;
        f6146d = new ar[]{r0, r1};
    }

    private ar(String r1, int r2, int r3) {
        super(r1, r2);
        this.f6147c = r3;
    }
}
