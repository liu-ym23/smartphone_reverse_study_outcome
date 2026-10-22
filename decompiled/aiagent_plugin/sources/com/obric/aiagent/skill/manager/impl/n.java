package com.obric.aiagent.skill.manager.impl;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: CliUpdateRepository.kt */
/* JADX INFO: loaded from: classes3.dex */
public final enum n extends Enum<n> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final n f20133a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final n f20134b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final n f20135c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final n f20136d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final /* synthetic */ n[] f20137e = null;
    private static final /* synthetic */ d.d.a f = null;

    private static final /* synthetic */ n[] a() {
        return new n[]{f20133a, f20134b, f20135c, f20136d};
    }

    private n(String r1, int r2) {
        super(r1, r2);
    }

    static {
        f20133a = new n("UPDATED", 0);
        f20134b = new n("UP_TO_DATE", 1);
        f20135c = new n("FAILED", 2);
        f20136d = new n("INVALID_NAME", 3);
        n[] r0 = a();
        f20137e = r0;
        f = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
    }

    public static n valueOf(String r2) {
        return (n) ZeusTransformUtils.preCheckCast(Enum.valueOf(n.class, r2), n.class, "com.obric.aiagent.plugin");
    }

    public static n[] values() {
        return (n[]) ZeusTransformUtils.preCheckCast(f20137e.clone(), n[].class, "com.obric.aiagent.plugin");
    }
}
