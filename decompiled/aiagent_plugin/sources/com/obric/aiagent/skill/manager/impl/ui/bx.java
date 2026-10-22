package com.obric.aiagent.skill.manager.impl.ui;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: SkillShopPageFragment.kt */
/* JADX INFO: loaded from: classes3.dex */
final enum bx extends Enum<bx> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final bx f20694a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final /* synthetic */ bx[] f20695b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final /* synthetic */ d.d.a f20696c = null;

    private static final /* synthetic */ bx[] a() {
        return new bx[]{f20694a};
    }

    private bx(String r1, int r2) {
        super(r1, r2);
    }

    static {
        f20694a = new bx("ACTION", 0);
        bx[] r0 = a();
        f20695b = r0;
        f20696c = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
    }

    public static bx valueOf(String r2) {
        return (bx) ZeusTransformUtils.preCheckCast(Enum.valueOf(bx.class, r2), bx.class, "com.obric.aiagent.plugin");
    }

    public static bx[] values() {
        return (bx[]) ZeusTransformUtils.preCheckCast(f20695b.clone(), bx[].class, "com.obric.aiagent.plugin");
    }
}
