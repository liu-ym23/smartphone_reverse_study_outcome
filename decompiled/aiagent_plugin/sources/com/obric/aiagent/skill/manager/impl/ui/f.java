package com.obric.aiagent.skill.manager.impl.ui;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: InstalledSkillListAdapter.kt */
/* JADX INFO: loaded from: classes3.dex */
public final enum f extends Enum<f> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f20776a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final f f20777b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final /* synthetic */ f[] f20778c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final /* synthetic */ d.d.a f20779d = null;

    private static final /* synthetic */ f[] a() {
        return new f[]{f20776a, f20777b};
    }

    private f(String r1, int r2) {
        super(r1, r2);
    }

    static {
        f20776a = new f("SKILL_COVER", 0);
        f20777b = new f("APP_FUNCTION_PACKAGE", 1);
        f[] r0 = a();
        f20778c = r0;
        f20779d = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
    }

    public static f valueOf(String r2) {
        return (f) ZeusTransformUtils.preCheckCast(Enum.valueOf(f.class, r2), f.class, "com.obric.aiagent.plugin");
    }

    public static f[] values() {
        return (f[]) ZeusTransformUtils.preCheckCast(f20778c.clone(), f[].class, "com.obric.aiagent.plugin");
    }
}
