package com.bytedance.safetyguard.lxc.internal.e.c;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: SidecarHttpDiagnostics.kt */
/* JADX INFO: loaded from: classes.dex */
public final enum d extends Enum<d> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f10726a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final d f10727b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final /* synthetic */ d[] f10728c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final /* synthetic */ d.d.a f10729d = null;

    private static final /* synthetic */ d[] a() {
        return new d[]{f10726a, f10727b};
    }

    public static d valueOf(String r2) {
        return (d) ZeusTransformUtils.preCheckCast(Enum.valueOf(d.class, r2), d.class, "com.obric.aiagent.plugin");
    }

    public static d[] values() {
        return (d[]) ZeusTransformUtils.preCheckCast(f10728c.clone(), d[].class, "com.obric.aiagent.plugin");
    }

    private d(String r1, int r2) {
        super(r1, r2);
    }

    static {
        f10726a = new d("ROOT", 0);
        f10727b = new d("DATA", 1);
        d[] r0 = a();
        f10728c = r0;
        f10729d = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
    }
}
