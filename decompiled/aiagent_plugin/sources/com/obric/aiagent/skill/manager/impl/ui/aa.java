package com.obric.aiagent.skill.manager.impl.ui;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: SkillDetailLoadCoordinator.kt */
/* JADX INFO: loaded from: classes3.dex */
public final enum aa extends Enum<aa> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final aa f20483a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final aa f20484b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final /* synthetic */ aa[] f20485c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final /* synthetic */ d.d.a f20486d = null;

    private static final /* synthetic */ aa[] a() {
        return new aa[]{f20483a, f20484b};
    }

    private aa(String r1, int r2) {
        super(r1, r2);
    }

    static {
        f20483a = new aa("CHECKING", 0);
        f20484b = new aa("UPDATING", 1);
        aa[] r0 = a();
        f20485c = r0;
        f20486d = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
    }

    public static aa valueOf(String r2) {
        return (aa) ZeusTransformUtils.preCheckCast(Enum.valueOf(aa.class, r2), aa.class, "com.obric.aiagent.plugin");
    }

    public static aa[] values() {
        return (aa[]) ZeusTransformUtils.preCheckCast(f20485c.clone(), aa[].class, "com.obric.aiagent.plugin");
    }
}
