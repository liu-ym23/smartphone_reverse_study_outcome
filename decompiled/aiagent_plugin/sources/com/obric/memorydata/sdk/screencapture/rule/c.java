package com.obric.memorydata.sdk.screencapture.rule;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: AppAccessibilityEventRule.kt */
/* JADX INFO: loaded from: classes4.dex */
public final enum c extends Enum<c> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f33886a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final c f33887b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final c f33888c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final /* synthetic */ c[] f33889d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final /* synthetic */ d.d.a f33890e = null;

    private static final /* synthetic */ c[] a() {
        return new c[]{f33886a, f33887b, f33888c};
    }

    private c(String r1, int r2) {
        super(r1, r2);
    }

    static {
        f33886a = new c("OR", 0);
        f33887b = new c("AND", 1);
        f33888c = new c("EXPRESSION", 2);
        c[] r0 = a();
        f33889d = r0;
        f33890e = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
    }

    public static c valueOf(String r2) {
        return (c) ZeusTransformUtils.preCheckCast(Enum.valueOf(c.class, r2), c.class, "com.obric.aiagent.plugin");
    }

    public static c[] values() {
        return (c[]) ZeusTransformUtils.preCheckCast(f33889d.clone(), c[].class, "com.obric.aiagent.plugin");
    }
}
