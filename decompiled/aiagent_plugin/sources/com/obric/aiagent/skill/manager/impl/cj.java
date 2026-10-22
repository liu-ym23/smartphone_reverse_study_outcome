package com.obric.aiagent.skill.manager.impl;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: SkillInstallTracking.kt */
/* JADX INFO: loaded from: classes3.dex */
public final enum cj extends Enum<cj> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final cj f19665a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final cj f19666b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final cj f19667c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final cj f19668d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final cj f19669e = null;
    public static final cj f = null;
    private static final /* synthetic */ cj[] g = null;
    private static final /* synthetic */ d.d.a h = null;

    private static final /* synthetic */ cj[] a() {
        return new cj[]{f19665a, f19666b, f19667c, f19668d, f19669e, f};
    }

    private cj(String r1, int r2) {
        super(r1, r2);
    }

    static {
        f19665a = new cj("REMOTE_DOWNLOAD", 0);
        f19666b = new cj("TEMP_FILE_WRITE", 1);
        f19667c = new cj("STORE_PACKAGE_PERSIST", 2);
        f19668d = new cj("CREATE_PERSIST", 3);
        f19669e = new cj("UPDATE_PERSIST", 4);
        f = new cj("IMPORT_PERSIST", 5);
        cj[] r0 = a();
        g = r0;
        h = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
    }

    public static cj valueOf(String r2) {
        return (cj) ZeusTransformUtils.preCheckCast(Enum.valueOf(cj.class, r2), cj.class, "com.obric.aiagent.plugin");
    }

    public static cj[] values() {
        return (cj[]) ZeusTransformUtils.preCheckCast(g.clone(), cj[].class, "com.obric.aiagent.plugin");
    }
}
