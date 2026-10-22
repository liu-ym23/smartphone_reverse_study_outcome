package com.obric.autoaction.vdplayer.legacy.d;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: VDPlayerUIState.kt */
/* JADX INFO: loaded from: classes3.dex */
public final enum e extends Enum<e> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f25882a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final e f25883b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final e f25884c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final /* synthetic */ e[] f25885d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final /* synthetic */ d.d.a f25886e = null;

    private static final /* synthetic */ e[] a() {
        return new e[]{f25882a, f25883b, f25884c};
    }

    private e(String r1, int r2) {
        super(r1, r2);
    }

    static {
        f25882a = new e("GONE", 0);
        f25883b = new e("LAUNCHER_COVER", 1);
        f25884c = new e("LAST_SCREEN_COVER", 2);
        e[] r0 = a();
        f25885d = r0;
        f25886e = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
    }

    public static e valueOf(String r2) {
        return (e) ZeusTransformUtils.preCheckCast(Enum.valueOf(e.class, r2), e.class, "com.obric.aiagent.plugin");
    }

    public static e[] values() {
        return (e[]) ZeusTransformUtils.preCheckCast(f25885d.clone(), e[].class, "com.obric.aiagent.plugin");
    }
}
