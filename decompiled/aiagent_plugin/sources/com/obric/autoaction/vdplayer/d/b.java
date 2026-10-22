package com.obric.autoaction.vdplayer.d;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: VDPlayerUIState.kt */
/* JADX INFO: loaded from: classes3.dex */
public final enum b extends Enum<b> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f25464a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b f25465b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final b f25466c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final b f25467d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final b f25468e = null;
    public static final b f = null;
    public static final b g = null;
    public static final b h = null;
    public static final b i = null;
    public static final b j = null;
    private static final /* synthetic */ b[] k = null;
    private static final /* synthetic */ d.d.a l = null;

    private static final /* synthetic */ b[] a() {
        return new b[]{f25464a, f25465b, f25466c, f25467d, f25468e, f, g, h, i, j};
    }

    private b(String r1, int r2) {
        super(r1, r2);
    }

    static {
        f25464a = new b("Clarify", 0);
        f25465b = new b("Supplement", 1);
        f25466c = new b("Supplement_Other", 2);
        f25467d = new b("TakeOver", 3);
        f25468e = new b("ManualOP", 4);
        f = new b("Stop", 5);
        g = new b("Feedback", 6);
        h = new b("Share", 7);
        i = new b("Replay", 8);
        j = new b("Exit", 9);
        b[] r0 = a();
        k = r0;
        l = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
    }

    public static b valueOf(String r2) {
        return (b) ZeusTransformUtils.preCheckCast(Enum.valueOf(b.class, r2), b.class, "com.obric.aiagent.plugin");
    }

    public static b[] values() {
        return (b[]) ZeusTransformUtils.preCheckCast(k.clone(), b[].class, "com.obric.aiagent.plugin");
    }
}
