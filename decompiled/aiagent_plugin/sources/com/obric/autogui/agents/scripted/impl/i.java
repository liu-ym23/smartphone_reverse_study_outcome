package com.obric.autogui.agents.scripted.impl;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: ResourceUpdateRoundGate.kt */
/* JADX INFO: loaded from: classes3.dex */
public final enum i extends Enum<i> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i f27000a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final i f27001b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final i f27002c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final /* synthetic */ i[] f27003d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final /* synthetic */ d.d.a f27004e = null;

    private static final /* synthetic */ i[] a() {
        return new i[]{f27000a, f27001b, f27002c};
    }

    private i(String r1, int r2) {
        super(r1, r2);
    }

    static {
        f27000a = new i("IGNORED", 0);
        f27001b = new i("PARTICIPANT_COMPLETED", 1);
        f27002c = new i("ROUND_COMPLETED", 2);
        i[] r0 = a();
        f27003d = r0;
        f27004e = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
    }

    public static i valueOf(String r2) {
        return (i) ZeusTransformUtils.preCheckCast(Enum.valueOf(i.class, r2), i.class, "com.obric.aiagent.plugin");
    }

    public static i[] values() {
        return (i[]) ZeusTransformUtils.preCheckCast(f27003d.clone(), i[].class, "com.obric.aiagent.plugin");
    }
}
