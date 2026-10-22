package com.obric.aiagent.skill.manager.api;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: SkillManagerContracts.kt */
/* JADX INFO: loaded from: classes3.dex */
public final enum j extends Enum<j> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j f19267a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final j f19268b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final /* synthetic */ j[] f19269c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final /* synthetic */ d.d.a f19270d = null;

    private static final /* synthetic */ j[] a() {
        return new j[]{f19267a, f19268b};
    }

    private j(String r1, int r2) {
        super(r1, r2);
    }

    static {
        f19267a = new j("CREATE", 0);
        f19268b = new j("UPDATE", 1);
        j[] r0 = a();
        f19269c = r0;
        f19270d = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
    }

    public static j valueOf(String r2) {
        return (j) ZeusTransformUtils.preCheckCast(Enum.valueOf(j.class, r2), j.class, "com.obric.aiagent.plugin");
    }

    public static j[] values() {
        return (j[]) ZeusTransformUtils.preCheckCast(f19269c.clone(), j[].class, "com.obric.aiagent.plugin");
    }
}
