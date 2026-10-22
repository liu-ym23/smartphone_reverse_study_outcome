package com.obric.aiagent.skill.manager.impl;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: SkillTrackingSchema.kt */
/* JADX INFO: loaded from: classes3.dex */
public final enum bf extends Enum<bf> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final bf f19556a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final bf f19557b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final bf f19558c = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final /* synthetic */ bf[] f19559e = null;
    private static final /* synthetic */ d.d.a f = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f19560d;

    public static d.d.a<bf> b() {
        return f;
    }

    private static final /* synthetic */ bf[] c() {
        return new bf[]{f19556a, f19557b, f19558c};
    }

    private bf(String r1, int r2, String r3) {
        super(r1, r2);
        this.f19560d = r3;
    }

    public final String a() {
        return this.f19560d;
    }

    static {
        f19556a = new bf("NAME", 0, "name");
        f19557b = new bf("DESCRIPTION", 1, "desc");
        f19558c = new bf("CONTENT", 2, "content");
        bf[] r0 = c();
        f19559e = r0;
        f = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
    }

    public static bf valueOf(String r2) {
        return (bf) ZeusTransformUtils.preCheckCast(Enum.valueOf(bf.class, r2), bf.class, "com.obric.aiagent.plugin");
    }

    public static bf[] values() {
        return (bf[]) ZeusTransformUtils.preCheckCast(f19559e.clone(), bf[].class, "com.obric.aiagent.plugin");
    }
}
