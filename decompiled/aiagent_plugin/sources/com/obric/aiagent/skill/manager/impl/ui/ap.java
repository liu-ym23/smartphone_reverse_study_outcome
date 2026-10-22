package com.obric.aiagent.skill.manager.impl.ui;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: SkillFormFileState.kt */
/* JADX INFO: loaded from: classes3.dex */
public final enum ap extends Enum<ap> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ap f20549a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ap f20550b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final /* synthetic */ ap[] f20551c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final /* synthetic */ d.d.a f20552d = null;

    private static final /* synthetic */ ap[] a() {
        return new ap[]{f20549a, f20550b};
    }

    private ap(String r1, int r2) {
        super(r1, r2);
    }

    static {
        f20549a = new ap("EDITABLE", 0);
        f20550b = new ap("READ_ONLY", 1);
        ap[] r0 = a();
        f20551c = r0;
        f20552d = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
    }

    public static ap valueOf(String r2) {
        return (ap) ZeusTransformUtils.preCheckCast(Enum.valueOf(ap.class, r2), ap.class, "com.obric.aiagent.plugin");
    }

    public static ap[] values() {
        return (ap[]) ZeusTransformUtils.preCheckCast(f20551c.clone(), ap[].class, "com.obric.aiagent.plugin");
    }
}
