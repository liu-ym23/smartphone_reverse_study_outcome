package com.obric.autogui.resourcemanage;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: WifiEligibility.kt */
/* JADX INFO: loaded from: classes3.dex */
public final enum af extends Enum<af> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final af f30599a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final af f30600b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final af f30601c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final /* synthetic */ af[] f30602d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final /* synthetic */ d.d.a f30603e = null;

    private static final /* synthetic */ af[] a() {
        return new af[]{f30599a, f30600b, f30601c};
    }

    private af(String r1, int r2) {
        super(r1, r2);
    }

    static {
        f30599a = new af("UNCHANGED", 0);
        f30600b = new af("BECAME_ELIGIBLE", 1);
        f30601c = new af("BECAME_INELIGIBLE", 2);
        af[] r0 = a();
        f30602d = r0;
        f30603e = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
    }

    public static af valueOf(String r2) {
        return (af) ZeusTransformUtils.preCheckCast(Enum.valueOf(af.class, r2), af.class, "com.obric.aiagent.plugin");
    }

    public static af[] values() {
        return (af[]) ZeusTransformUtils.preCheckCast(f30602d.clone(), af[].class, "com.obric.aiagent.plugin");
    }
}
