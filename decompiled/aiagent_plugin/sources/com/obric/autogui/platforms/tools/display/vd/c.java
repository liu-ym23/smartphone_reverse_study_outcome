package com.obric.autogui.platforms.tools.display.vd;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: TaskFrontLiveTopGate.kt */
/* JADX INFO: loaded from: classes3.dex */
public final enum c extends Enum<c> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f30194a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final c f30195b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final c f30196c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final c f30197d = null;
    private static final /* synthetic */ c[] f = null;
    private static final /* synthetic */ d.d.a g = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final boolean f30198e;

    private static final /* synthetic */ c[] b() {
        return new c[]{f30194a, f30195b, f30196c, f30197d};
    }

    private c(String r1, int r2, boolean r3) {
        super(r1, r2);
        this.f30198e = r3;
    }

    public final boolean a() {
        return this.f30198e;
    }

    static {
        f30194a = new c("ACCEPT_EXACT_TASK", 0, true);
        f30195b = new c("ACCEPT_EQUIVALENT_COMPONENT", 1, true);
        f30196c = new c("REJECT_DIFFERENT_COMPONENT", 2, false);
        f30197d = new c("UNVERIFIED", 3, false);
        c[] r0 = b();
        f = r0;
        g = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
    }

    public static c valueOf(String r2) {
        return (c) ZeusTransformUtils.preCheckCast(Enum.valueOf(c.class, r2), c.class, "com.obric.aiagent.plugin");
    }

    public static c[] values() {
        return (c[]) ZeusTransformUtils.preCheckCast(f.clone(), c[].class, "com.obric.aiagent.plugin");
    }
}
