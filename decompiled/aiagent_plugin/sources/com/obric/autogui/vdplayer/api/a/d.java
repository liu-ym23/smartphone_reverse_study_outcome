package com.obric.autogui.vdplayer.api.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: AgentAction.kt */
/* JADX INFO: loaded from: classes3.dex */
public final enum d extends Enum<d> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f31701a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final d f31702b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final /* synthetic */ d[] f31703c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final /* synthetic */ d.d.a f31704d = null;

    private static final /* synthetic */ d[] a() {
        return new d[]{f31701a, f31702b};
    }

    private d(String r1, int r2) {
        super(r1, r2);
    }

    static {
        f31701a = new d("KEEP_ALIVE", 0);
        f31702b = new d("DROP_ON_MAJOR_CHANGE", 1);
        d[] r0 = a();
        f31703c = r0;
        f31704d = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
    }

    public static d valueOf(String r2) {
        return (d) ZeusTransformUtils.preCheckCast(Enum.valueOf(d.class, r2), d.class, "com.obric.aiagent.plugin");
    }

    public static d[] values() {
        return (d[]) ZeusTransformUtils.preCheckCast(f31703c.clone(), d[].class, "com.obric.aiagent.plugin");
    }
}
