package com.obric.oui.texteffects.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: TextEffectProtocol.kt */
/* JADX INFO: loaded from: classes4.dex */
public final enum b extends Enum<b> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f36363a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b f36364b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final b f36365c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final b f36366d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final /* synthetic */ b[] f36367e = null;

    private static final /* synthetic */ b[] a() {
        return new b[]{f36363a, f36364b, f36365c, f36366d};
    }

    public static b valueOf(String r2) {
        return (b) ZeusTransformUtils.preCheckCast(Enum.valueOf(b.class, r2), b.class, "com.obric.aiagent.plugin");
    }

    public static b[] values() {
        return (b[]) ZeusTransformUtils.preCheckCast(f36367e.clone(), b[].class, "com.obric.aiagent.plugin");
    }

    private b(String r1, int r2) {
        super(r1, r2);
    }

    static {
        f36363a = new b("LeftToRight", 0);
        f36364b = new b("RightToLeft", 1);
        f36365c = new b("TopToBottom", 2);
        f36366d = new b("BottomToTop", 3);
        f36367e = a();
    }
}
