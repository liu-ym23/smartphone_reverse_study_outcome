package com.obric.oui.texteffects.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: TextEffectProtocol.kt */
/* JADX INFO: loaded from: classes4.dex */
public final enum o extends Enum<o> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final o f36425a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final o f36426b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final o f36427c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final /* synthetic */ o[] f36428d = null;

    private static final /* synthetic */ o[] a() {
        return new o[]{f36425a, f36426b, f36427c};
    }

    public static o valueOf(String r2) {
        return (o) ZeusTransformUtils.preCheckCast(Enum.valueOf(o.class, r2), o.class, "com.obric.aiagent.plugin");
    }

    public static o[] values() {
        return (o[]) ZeusTransformUtils.preCheckCast(f36428d.clone(), o[].class, "com.obric.aiagent.plugin");
    }

    private o(String r1, int r2) {
        super(r1, r2);
    }

    static {
        f36425a = new o("Current", 0);
        f36426b = new o("Old", 1);
        f36427c = new o("New", 2);
        f36428d = a();
    }
}
