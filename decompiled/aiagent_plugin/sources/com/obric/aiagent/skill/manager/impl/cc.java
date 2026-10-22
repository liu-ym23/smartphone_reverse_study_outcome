package com.obric.aiagent.skill.manager.impl;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: SkillFileFailure.kt */
/* JADX INFO: loaded from: classes3.dex */
public final enum cc extends Enum<cc> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final cc f19640a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final cc f19641b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final cc f19642c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final /* synthetic */ cc[] f19643d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final /* synthetic */ d.d.a f19644e = null;

    private static final /* synthetic */ cc[] a() {
        return new cc[]{f19640a, f19641b, f19642c};
    }

    private cc(String r1, int r2) {
        super(r1, r2);
    }

    static {
        f19640a = new cc("NAME", 0);
        f19641b = new cc("DISPLAY_NAME", 1);
        f19642c = new cc("DESCRIPTION", 2);
        cc[] r0 = a();
        f19643d = r0;
        f19644e = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
    }

    public static cc valueOf(String r2) {
        return (cc) ZeusTransformUtils.preCheckCast(Enum.valueOf(cc.class, r2), cc.class, "com.obric.aiagent.plugin");
    }

    public static cc[] values() {
        return (cc[]) ZeusTransformUtils.preCheckCast(f19643d.clone(), cc[].class, "com.obric.aiagent.plugin");
    }
}
