package com.obric.aiagent.skill.manager.impl.ui;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: InstalledSkillListAdapter.kt */
/* JADX INFO: loaded from: classes3.dex */
public final enum j extends Enum<j> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j f20789a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final j f20790b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final j f20791c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final j f20792d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final j f20793e = null;
    private static final /* synthetic */ j[] f = null;
    private static final /* synthetic */ d.d.a g = null;

    private static final /* synthetic */ j[] a() {
        return new j[]{f20789a, f20790b, f20791c, f20792d, f20793e};
    }

    private j(String r1, int r2) {
        super(r1, r2);
    }

    static {
        f20789a = new j("CARD", 0);
        f20790b = new j("COVER", 1);
        f20791c = new j("TEXT", 2);
        f20792d = new j("SOURCE", 3);
        f20793e = new j("CONTROL", 4);
        j[] r0 = a();
        f = r0;
        g = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
    }

    public static j valueOf(String r2) {
        return (j) ZeusTransformUtils.preCheckCast(Enum.valueOf(j.class, r2), j.class, "com.obric.aiagent.plugin");
    }

    public static j[] values() {
        return (j[]) ZeusTransformUtils.preCheckCast(f.clone(), j[].class, "com.obric.aiagent.plugin");
    }
}
