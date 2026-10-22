package com.obric.oui.texteffects.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: TextEffectProtocol.kt */
/* JADX INFO: loaded from: classes4.dex */
public final enum e extends Enum<e> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f36385a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final e f36386b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final e f36387c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final e f36388d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final e f36389e = null;
    public static final e f = null;
    public static final e g = null;
    private static final /* synthetic */ e[] h = null;

    private static final /* synthetic */ e[] a() {
        return new e[]{f36385a, f36386b, f36387c, f36388d, f36389e, f, g};
    }

    public static e valueOf(String r2) {
        return (e) ZeusTransformUtils.preCheckCast(Enum.valueOf(e.class, r2), e.class, "com.obric.aiagent.plugin");
    }

    public static e[] values() {
        return (e[]) ZeusTransformUtils.preCheckCast(h.clone(), e[].class, "com.obric.aiagent.plugin");
    }

    private e(String r1, int r2) {
        super(r1, r2);
    }

    static {
        f36385a = new e("Alpha", 0);
        f36386b = new e("BlurRadius", 1);
        f36387c = new e("TranslationX", 2);
        f36388d = new e("TranslationY", 3);
        f36389e = new e("Tracking", 4);
        f = new e("GradientAlphaScan", 5);
        g = new e("Visibility", 6);
        h = a();
    }
}
