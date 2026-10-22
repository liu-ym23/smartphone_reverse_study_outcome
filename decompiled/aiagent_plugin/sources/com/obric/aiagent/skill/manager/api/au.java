package com.obric.aiagent.skill.manager.api;

import com.bytedance.security.zenmobile.io.SensitiveType;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: SkillManagerContracts.kt */
/* JADX INFO: loaded from: classes3.dex */
public final enum au extends Enum<au> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final au f19234a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final au f19235b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final au f19236c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final au f19237d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final au f19238e = null;
    public static final au f = null;
    public static final au g = null;
    public static final au h = null;
    public static final au i = null;
    private static final /* synthetic */ au[] k = null;
    private static final /* synthetic */ d.d.a l = null;
    private final String j;

    private static final /* synthetic */ au[] b() {
        return new au[]{f19234a, f19235b, f19236c, f19237d, f19238e, f, g, h, i};
    }

    private au(String r1, int r2, String r3) {
        super(r1, r2);
        this.j = r3;
    }

    public final String a() {
        return this.j;
    }

    static {
        f19234a = new au("UNKNOWN", 0, SensitiveType.UNKNOWN);
        f19235b = new au("DEFAULT_PREINSTALL", 1, "default_preinstall");
        f19236c = new au("MALL", 2, "mall");
        f19237d = new au("SEARCH", 3, "search");
        f19238e = new au("COLLECTION", 4, "collection");
        f = new au("DETAIL_ACTION", 5, "detail_action");
        g = new au("DETAIL_AUTO_REFRESH", 6, "detail_auto_refresh");
        h = new au("LOAD_AUTO_REFRESH", 7, "load_auto_refresh");
        i = new au("NATURAL_LANGUAGE", 8, "natural_language");
        au[] r0 = b();
        k = r0;
        l = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
    }

    public static au valueOf(String r2) {
        return (au) ZeusTransformUtils.preCheckCast(Enum.valueOf(au.class, r2), au.class, "com.obric.aiagent.plugin");
    }

    public static au[] values() {
        return (au[]) ZeusTransformUtils.preCheckCast(k.clone(), au[].class, "com.obric.aiagent.plugin");
    }
}
