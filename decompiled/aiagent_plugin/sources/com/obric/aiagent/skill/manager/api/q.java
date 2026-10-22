package com.obric.aiagent.skill.manager.api;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: SkillSource.kt */
/* JADX INFO: loaded from: classes3.dex */
public final enum q extends Enum<q> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final q f19295a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final q f19296b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final q f19297c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final q f19298d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final q f19299e = null;
    public static final q f = null;
    public static final q g = null;
    public static final q h = null;
    public static final q i = null;
    private static final /* synthetic */ q[] k = null;
    private static final /* synthetic */ d.d.a l = null;
    private final String j;

    private static final /* synthetic */ q[] b() {
        return new q[]{f19295a, f19296b, f19297c, f19298d, f19299e, f, g, h, i};
    }

    private q(String r1, int r2, String r3) {
        super(r1, r2);
        this.j = r3;
    }

    public final String a() {
        return this.j;
    }

    static {
        f19295a = new q("APP_FUNCTION_IMPORT", 0, "app_function_import");
        f19296b = new q("NL_CREATE_SKILL", 1, "nl_create_skill");
        f19297c = new q("NL_EDIT_SKILL", 2, "nl_edit_skill");
        f19298d = new q("NL_IMPORT_SKILL_BY_LINK", 3, "nl_import_skill_by_link");
        f19299e = new q("NL_IMPORT_SKILL_BY_PATH", 4, "nl_import_skill_by_path");
        f = new q("STORE_INSTALL", 5, "store_install");
        g = new q("GUI_FORM_CREATE", 6, "gui_form_create");
        h = new q("GUI_FILE_UPLOAD", 7, "gui_file_upload");
        i = new q("GUI_LINK_PARSE", 8, "gui_link_parse");
        q[] r0 = b();
        k = r0;
        l = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
    }

    public static q valueOf(String r2) {
        return (q) ZeusTransformUtils.preCheckCast(Enum.valueOf(q.class, r2), q.class, "com.obric.aiagent.plugin");
    }

    public static q[] values() {
        return (q[]) ZeusTransformUtils.preCheckCast(k.clone(), q[].class, "com.obric.aiagent.plugin");
    }
}
