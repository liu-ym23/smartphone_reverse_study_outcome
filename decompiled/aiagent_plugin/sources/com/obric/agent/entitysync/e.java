package com.obric.agent.entitysync;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: AppEntitySyncModels.kt */
/* JADX INFO: loaded from: classes2.dex */
public final enum e extends Enum<e> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f14501a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final e f14502b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final e f14503c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final e f14504d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final /* synthetic */ e[] f14505e = null;
    private static final /* synthetic */ d.d.a f = null;

    private static final /* synthetic */ e[] a() {
        return new e[]{f14501a, f14502b, f14503c, f14504d};
    }

    private e(String r1, int r2) {
        super(r1, r2);
    }

    static {
        f14501a = new e("PRESERVE", 0);
        f14502b = new e("NORMAL", 1);
        f14503c = new e("DELETED", 2);
        f14504d = new e("DISABLED", 3);
        e[] r0 = a();
        f14505e = r0;
        f = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
    }

    public static e valueOf(String r2) {
        return (e) ZeusTransformUtils.preCheckCast(Enum.valueOf(e.class, r2), e.class, "com.obric.aiagent.plugin");
    }

    public static e[] values() {
        return (e[]) ZeusTransformUtils.preCheckCast(f14505e.clone(), e[].class, "com.obric.aiagent.plugin");
    }
}
