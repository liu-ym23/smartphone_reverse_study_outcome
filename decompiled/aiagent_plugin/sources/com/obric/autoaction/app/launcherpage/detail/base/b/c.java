package com.obric.autoaction.app.launcherpage.detail.base.b;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: DetailMode.kt */
/* JADX INFO: loaded from: classes3.dex */
public final enum c extends Enum<c> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f23285a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final c f23286b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final c f23287c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final /* synthetic */ c[] f23288d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final /* synthetic */ d.d.a f23289e = null;

    private static final /* synthetic */ c[] a() {
        return new c[]{f23285a, f23286b, f23287c};
    }

    private c(String r1, int r2) {
        super(r1, r2);
    }

    static {
        f23285a = new c("CREATE", 0);
        f23286b = new c("READ", 1);
        f23287c = new c("EDIT", 2);
        c[] r0 = a();
        f23288d = r0;
        f23289e = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
    }

    public static c valueOf(String r2) {
        return (c) ZeusTransformUtils.preCheckCast(Enum.valueOf(c.class, r2), c.class, "com.obric.aiagent.plugin");
    }

    public static c[] values() {
        return (c[]) ZeusTransformUtils.preCheckCast(f23288d.clone(), c[].class, "com.obric.aiagent.plugin");
    }
}
