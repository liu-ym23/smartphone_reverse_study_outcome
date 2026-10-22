package com.obric.autoaction.vdplayer.d;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: VDPlayerUIState.kt */
/* JADX INFO: loaded from: classes3.dex */
public final enum m extends Enum<m> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final m f25512a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final m f25513b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final m f25514c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final /* synthetic */ m[] f25515d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final /* synthetic */ d.d.a f25516e = null;

    private static final /* synthetic */ m[] a() {
        return new m[]{f25512a, f25513b, f25514c};
    }

    private m(String r1, int r2) {
        super(r1, r2);
    }

    static {
        f25512a = new m("SHOW_SECURE_WITH_COVER", 0);
        f25513b = new m("SHOW_SECURE", 1);
        f25514c = new m("NOT_SHOW", 2);
        m[] r0 = a();
        f25515d = r0;
        f25516e = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
    }

    public static m valueOf(String r2) {
        return (m) ZeusTransformUtils.preCheckCast(Enum.valueOf(m.class, r2), m.class, "com.obric.aiagent.plugin");
    }

    public static m[] values() {
        return (m[]) ZeusTransformUtils.preCheckCast(f25515d.clone(), m[].class, "com.obric.aiagent.plugin");
    }
}
