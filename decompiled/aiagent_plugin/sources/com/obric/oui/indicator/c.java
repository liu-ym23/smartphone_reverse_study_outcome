package com.obric.oui.indicator;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: IndicatorViewportState.kt */
/* JADX INFO: loaded from: classes4.dex */
public final enum c extends Enum<c> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f35386a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final c f35387b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final c f35388c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final c f35389d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final /* synthetic */ c[] f35390e = null;

    private static final /* synthetic */ c[] a() {
        return new c[]{f35386a, f35387b, f35388c, f35389d};
    }

    public static c valueOf(String r2) {
        return (c) ZeusTransformUtils.preCheckCast(Enum.valueOf(c.class, r2), c.class, "com.obric.aiagent.plugin");
    }

    public static c[] values() {
        return (c[]) ZeusTransformUtils.preCheckCast(f35390e.clone(), c[].class, "com.obric.aiagent.plugin");
    }

    private c(String r1, int r2) {
        super(r1, r2);
    }

    static {
        f35386a = new c("ACTIVE", 0);
        f35387b = new c("NORMAL", 1);
        f35388c = new c("EDGE", 2);
        f35389d = new c("HIDDEN", 3);
        f35390e = a();
    }
}
