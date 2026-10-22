package com.obric.autogui.session.b;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: CCBizLifecycleHandler.kt */
/* JADX INFO: loaded from: classes3.dex */
public final enum c extends Enum<c> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f30769a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final c f30770b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final c f30771c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final c f30772d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final c f30773e = null;
    public static final c f = null;
    public static final c g = null;
    private static final /* synthetic */ c[] i = null;
    private static final /* synthetic */ d.d.a j = null;
    private final boolean h;

    private static final /* synthetic */ c[] b() {
        return new c[]{f30769a, f30770b, f30771c, f30772d, f30773e, f, g};
    }

    private c(String r1, int r2, boolean r3) {
        super(r1, r2);
        this.h = r3;
    }

    public final boolean a() {
        return this.h;
    }

    static {
        f30769a = new c("ClosedBeforeCreated", 0, false);
        f30770b = new c("CallerInitiated", 1, false);
        f30771c = new c("NotOngoingSession", 2, true);
        f30772d = new c("DeferredToSpaceValidation", 3, true);
        f30773e = new c("TerminationAlreadyActive", 4, true);
        f = new c("AlreadyHandled", 5, true);
        g = new c("Terminate", 6, true);
        c[] r0 = b();
        i = r0;
        j = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
    }

    public static c valueOf(String r2) {
        return (c) ZeusTransformUtils.preCheckCast(Enum.valueOf(c.class, r2), c.class, "com.obric.aiagent.plugin");
    }

    public static c[] values() {
        return (c[]) ZeusTransformUtils.preCheckCast(i.clone(), c[].class, "com.obric.aiagent.plugin");
    }
}
