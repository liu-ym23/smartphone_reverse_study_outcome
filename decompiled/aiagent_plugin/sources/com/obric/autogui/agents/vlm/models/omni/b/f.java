package com.obric.autogui.agents.vlm.models.omni.b;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: OmniGuiToolTraceSchema.kt */
/* JADX INFO: loaded from: classes3.dex */
public final enum f extends Enum<f> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f28226a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final f f28227b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final f f28228c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final f f28229d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final f f28230e = null;
    private static final /* synthetic */ f[] g = null;
    private static final /* synthetic */ d.d.a h = null;
    private final boolean f;

    private static final /* synthetic */ f[] b() {
        return new f[]{f28226a, f28227b, f28228c, f28229d, f28230e};
    }

    private f(String r1, int r2, boolean r3) {
        super(r1, r2);
        this.f = r3;
    }

    public final boolean a() {
        return this.f;
    }

    static {
        f28226a = new f("ACCEPTED", 0, false);
        f28227b = new f("DEQUEUED", 1, false);
        f28228c = new f("ACTION_FINISHED", 2, true);
        f28229d = new f("POST_ACTION_CHECK_FINISHED", 3, true);
        f28230e = new f("FINISHED", 4, true);
        f[] r0 = b();
        g = r0;
        h = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
    }

    public static f valueOf(String r2) {
        return (f) ZeusTransformUtils.preCheckCast(Enum.valueOf(f.class, r2), f.class, "com.obric.aiagent.plugin");
    }

    public static f[] values() {
        return (f[]) ZeusTransformUtils.preCheckCast(g.clone(), f[].class, "com.obric.aiagent.plugin");
    }
}
