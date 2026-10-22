package com.obric.aiagent.skill.manager.impl.ui;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: SkillFormFileState.kt */
/* JADX INFO: loaded from: classes3.dex */
public final enum av extends Enum<av> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final av f20576a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final av f20577b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final /* synthetic */ av[] f20578c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final /* synthetic */ d.d.a f20579d = null;

    private static final /* synthetic */ av[] a() {
        return new av[]{f20576a, f20577b};
    }

    private av(String r1, int r2) {
        super(r1, r2);
    }

    static {
        f20576a = new av("IMPORT", 0);
        f20577b = new av("UPLOAD", 1);
        av[] r0 = a();
        f20578c = r0;
        f20579d = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
    }

    public static av valueOf(String r2) {
        return (av) ZeusTransformUtils.preCheckCast(Enum.valueOf(av.class, r2), av.class, "com.obric.aiagent.plugin");
    }

    public static av[] values() {
        return (av[]) ZeusTransformUtils.preCheckCast(f20578c.clone(), av[].class, "com.obric.aiagent.plugin");
    }
}
