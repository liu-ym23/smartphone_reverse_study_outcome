package com.obric.aiagent.skill.manager.api;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: SkillManagerContracts.kt */
/* JADX INFO: loaded from: classes3.dex */
public final enum p extends Enum<p> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final p f19290a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final p f19291b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final p f19292c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final p f19293d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final p f19294e = null;
    public static final p f = null;
    public static final p g = null;
    private static final /* synthetic */ p[] h = null;
    private static final /* synthetic */ d.d.a i = null;

    private static final /* synthetic */ p[] a() {
        return new p[]{f19290a, f19291b, f19292c, f19293d, f19294e, f, g};
    }

    private p(String r1, int r2) {
        super(r1, r2);
    }

    static {
        f19290a = new p("APP_FUNCTION_IMPORT", 0);
        f19291b = new p("NL_CREATE_SKILL", 1);
        f19292c = new p("NL_IMPORT_SKILL_BY_LINK", 2);
        f19293d = new p("NL_IMPORT_SKILL_BY_PATH", 3);
        f19294e = new p("GUI_FILE_UPLOAD", 4);
        f = new p("GUI_LINK_PARSE", 5);
        g = new p("GUI_FORM_CREATE", 6);
        p[] r0 = a();
        h = r0;
        i = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
    }

    public static p valueOf(String r2) {
        return (p) ZeusTransformUtils.preCheckCast(Enum.valueOf(p.class, r2), p.class, "com.obric.aiagent.plugin");
    }

    public static p[] values() {
        return (p[]) ZeusTransformUtils.preCheckCast(h.clone(), p[].class, "com.obric.aiagent.plugin");
    }
}
