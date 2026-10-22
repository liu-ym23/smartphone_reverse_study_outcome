package com.obric.autoaction.vdplayer.d;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: VDPlayerUIState.kt */
/* JADX INFO: loaded from: classes3.dex */
public final enum e extends Enum<e> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f25475a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final e f25476b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final e f25477c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final /* synthetic */ e[] f25478d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final /* synthetic */ d.d.a f25479e = null;

    private static final /* synthetic */ e[] a() {
        return new e[]{f25475a, f25476b, f25477c};
    }

    private e(String r1, int r2) {
        super(r1, r2);
    }

    static {
        f25475a = new e("GONE", 0);
        f25476b = new e("LAUNCHER_COVER", 1);
        f25477c = new e("LAST_SCREEN_COVER", 2);
        e[] r0 = a();
        f25478d = r0;
        f25479e = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
    }

    public static e valueOf(String r2) {
        return (e) ZeusTransformUtils.preCheckCast(Enum.valueOf(e.class, r2), e.class, "com.obric.aiagent.plugin");
    }

    public static e[] values() {
        return (e[]) ZeusTransformUtils.preCheckCast(f25478d.clone(), e[].class, "com.obric.aiagent.plugin");
    }
}
