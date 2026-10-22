package com.obric.aiagent.skill.manager.impl.ui;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: SkillShopPageFragment.kt */
/* JADX INFO: loaded from: classes3.dex */
final enum bt extends Enum<bt> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final bt f20669a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final bt f20670b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final bt f20671c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final bt f20672d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final /* synthetic */ bt[] f20673e = null;
    private static final /* synthetic */ d.d.a f = null;

    private static final /* synthetic */ bt[] a() {
        return new bt[]{f20669a, f20670b, f20671c, f20672d};
    }

    private bt(String r1, int r2) {
        super(r1, r2);
    }

    static {
        f20669a = new bt("SINGLE", 0);
        f20670b = new bt("TOP", 1);
        f20671c = new bt("MIDDLE", 2);
        f20672d = new bt("BOTTOM", 3);
        bt[] r0 = a();
        f20673e = r0;
        f = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
    }

    public static bt valueOf(String r2) {
        return (bt) ZeusTransformUtils.preCheckCast(Enum.valueOf(bt.class, r2), bt.class, "com.obric.aiagent.plugin");
    }

    public static bt[] values() {
        return (bt[]) ZeusTransformUtils.preCheckCast(f20673e.clone(), bt[].class, "com.obric.aiagent.plugin");
    }
}
