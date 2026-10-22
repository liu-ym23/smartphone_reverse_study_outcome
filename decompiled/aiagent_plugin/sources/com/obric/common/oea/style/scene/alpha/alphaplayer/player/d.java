package com.obric.common.oea.style.scene.alpha.alphaplayer.player;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: PlayerState.kt */
/* JADX INFO: loaded from: classes4.dex */
public final enum d extends Enum<d> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f32521a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final d f32522b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final d f32523c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final d f32524d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final d f32525e = null;
    public static final d f = null;
    private static final /* synthetic */ d[] g = null;

    static {
        d r1 = new d("NOT_PREPARED", 0);
        f32521a = r1;
        d r2 = new d("PREPARED", 1);
        f32522b = r2;
        d r3 = new d("STARTED", 2);
        f32523c = r3;
        d r4 = new d("PAUSED", 3);
        f32524d = r4;
        d r5 = new d("STOPPED", 4);
        f32525e = r5;
        d r6 = new d("RELEASE", 5);
        f = r6;
        g = new d[]{r1, r2, r3, r4, r5, r6};
    }

    public static d valueOf(String r2) {
        return (d) ZeusTransformUtils.preCheckCast(Enum.valueOf(d.class, r2), d.class, "com.obric.aiagent.plugin");
    }

    public static d[] values() {
        return (d[]) ZeusTransformUtils.preCheckCast(g.clone(), d[].class, "com.obric.aiagent.plugin");
    }

    private d(String r1, int r2) {
        super(r1, r2);
    }
}
