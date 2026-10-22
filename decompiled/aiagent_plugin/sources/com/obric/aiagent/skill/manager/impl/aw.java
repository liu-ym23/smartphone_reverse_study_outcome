package com.obric.aiagent.skill.manager.impl;

import com.bytedance.security.zenmobile.io.SensitiveType;
import com.obric.aiagent.skill.virt.impl.Virt;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: SkillSigningRepository.kt */
/* JADX INFO: loaded from: classes3.dex */
public final enum aw extends Enum<aw> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final aw f19530a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final aw f19531b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final aw f19532c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final aw f19533d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final aw f19534e = null;
    public static final aw f = null;
    public static final aw g = null;
    private static final /* synthetic */ aw[] i = null;
    private static final /* synthetic */ d.d.a j = null;
    private final String h;

    private static final /* synthetic */ aw[] b() {
        return new aw[]{f19530a, f19531b, f19532c, f19533d, f19534e, f, g};
    }

    private aw(String r1, int r2, String r3) {
        super(r1, r2);
        this.h = r3;
    }

    public final String a() {
        return this.h;
    }

    static {
        f19530a = new aw("UNKNOWN", 0, SensitiveType.UNKNOWN);
        f19531b = new aw("STARTUP", 1, Virt.TRIGGER_STARTUP);
        f19532c = new aw("LIFECYCLE", 2, "lifecycle");
        f19533d = new aw("DETAIL", 3, "detail");
        f19534e = new aw("APPLY_CHANGE", 4, "apply_change");
        f = new aw("MANAGEMENT", 5, "management");
        g = new aw("MANAGEMENT_SEARCH", 6, "management_search");
        aw[] r0 = b();
        i = r0;
        j = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
    }

    public static aw valueOf(String r2) {
        return (aw) ZeusTransformUtils.preCheckCast(Enum.valueOf(aw.class, r2), aw.class, "com.obric.aiagent.plugin");
    }

    public static aw[] values() {
        return (aw[]) ZeusTransformUtils.preCheckCast(i.clone(), aw[].class, "com.obric.aiagent.plugin");
    }
}
