package com.obric.oui.banner;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: OBanner.kt */
/* JADX INFO: loaded from: classes4.dex */
public final enum c extends Enum<c> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f34042a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final c f34043b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final c f34044c = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final /* synthetic */ c[] f34045e = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f34046d;

    private static final /* synthetic */ c[] a() {
        return new c[]{f34042a, f34043b, f34044c};
    }

    public static c valueOf(String r2) {
        return (c) ZeusTransformUtils.preCheckCast(Enum.valueOf(c.class, r2), c.class, "com.obric.aiagent.plugin");
    }

    public static c[] values() {
        return (c[]) ZeusTransformUtils.preCheckCast(f34045e.clone(), c[].class, "com.obric.aiagent.plugin");
    }

    private c(String r1, int r2, int r3) {
        super(r1, r2);
        this.f34046d = r3;
    }

    static {
        f34042a = new c("FILL", 0, 0);
        f34043b = new c("INDENT", 1, 1);
        f34044c = new c("TRIPTYCH", 2, 2);
        f34045e = a();
    }
}
