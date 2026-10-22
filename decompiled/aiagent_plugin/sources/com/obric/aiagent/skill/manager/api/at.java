package com.obric.aiagent.skill.manager.api;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: SkillManagerContracts.kt */
/* JADX INFO: loaded from: classes3.dex */
public final enum at extends Enum<at> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final at f19229a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final at f19230b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final at f19231c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final /* synthetic */ at[] f19232d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final /* synthetic */ d.d.a f19233e = null;

    private static final /* synthetic */ at[] a() {
        return new at[]{f19229a, f19230b, f19231c};
    }

    private at(String r1, int r2) {
        super(r1, r2);
    }

    static {
        f19229a = new at("INSTALLED", 0);
        f19230b = new at("UPDATED", 1);
        f19231c = new at("ALREADY_INSTALLED", 2);
        at[] r0 = a();
        f19232d = r0;
        f19233e = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
    }

    public static at valueOf(String r2) {
        return (at) ZeusTransformUtils.preCheckCast(Enum.valueOf(at.class, r2), at.class, "com.obric.aiagent.plugin");
    }

    public static at[] values() {
        return (at[]) ZeusTransformUtils.preCheckCast(f19232d.clone(), at[].class, "com.obric.aiagent.plugin");
    }
}
