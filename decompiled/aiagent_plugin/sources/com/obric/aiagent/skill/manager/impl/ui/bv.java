package com.obric.aiagent.skill.manager.impl.ui;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: SkillShopPageFragment.kt */
/* JADX INFO: loaded from: classes3.dex */
final enum bv extends Enum<bv> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final bv f20683a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final bv f20684b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final bv f20685c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final bv f20686d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final bv f20687e = null;
    private static final /* synthetic */ bv[] f = null;
    private static final /* synthetic */ d.d.a g = null;

    private static final /* synthetic */ bv[] a() {
        return new bv[]{f20683a, f20684b, f20685c, f20686d, f20687e};
    }

    private bv(String r1, int r2) {
        super(r1, r2);
    }

    static {
        f20683a = new bv("BUTTON_ADD", 0);
        f20684b = new bv("PROGRESSING", 1);
        f20685c = new bv("SUCCEED_CHECK", 2);
        f20686d = new bv("BUTTON_USE", 3);
        f20687e = new bv("BUTTON_USE_DISABLED", 4);
        bv[] r0 = a();
        f = r0;
        g = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
    }

    public static bv valueOf(String r2) {
        return (bv) ZeusTransformUtils.preCheckCast(Enum.valueOf(bv.class, r2), bv.class, "com.obric.aiagent.plugin");
    }

    public static bv[] values() {
        return (bv[]) ZeusTransformUtils.preCheckCast(f.clone(), bv[].class, "com.obric.aiagent.plugin");
    }
}
