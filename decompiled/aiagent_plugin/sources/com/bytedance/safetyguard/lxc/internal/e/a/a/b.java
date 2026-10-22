package com.bytedance.safetyguard.lxc.internal.e.a.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: OAuthPollingModels.kt */
/* JADX INFO: loaded from: classes.dex */
public final enum b extends Enum<b> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f10301a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b f10302b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final b f10303c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final /* synthetic */ b[] f10304d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final /* synthetic */ d.d.a f10305e = null;

    private static final /* synthetic */ b[] a() {
        return new b[]{f10301a, f10302b, f10303c};
    }

    public static b valueOf(String r2) {
        return (b) ZeusTransformUtils.preCheckCast(Enum.valueOf(b.class, r2), b.class, "com.obric.aiagent.plugin");
    }

    public static b[] values() {
        return (b[]) ZeusTransformUtils.preCheckCast(f10304d.clone(), b[].class, "com.obric.aiagent.plugin");
    }

    private b(String r1, int r2) {
        super(r1, r2);
    }

    static {
        f10301a = new b("NORMAL", 0);
        f10302b = new b("IMMEDIATE", 1);
        f10303c = new b("SLOW_DOWN", 2);
        b[] r0 = a();
        f10304d = r0;
        f10305e = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
    }
}
