package com.obric.aiagent.skill.manager.impl;

import com.bytedance.bdturing.localstorage.DbHelper;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: SkillSettingsServiceImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class fd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final a f19867a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.obric.aiagent.skill.manager.api.al f19868b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final AtomicReference<com.obric.aiagent.skill.manager.api.al> f19869c;

    /* JADX INFO: compiled from: SkillSettingsServiceImpl.kt */
    private static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }
    }

    static {
        f19867a = new a(null);
    }

    public fd() {
        com.obric.aiagent.skill.manager.api.al r15 = new com.obric.aiagent.skill.manager.api.al(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, false, false, false, false, false, false, false, false, false, false, false, false, false, null, false, null, 0, -1, 31, null);
        this.f19868b = r15;
        this.f19869c = new AtomicReference(r15);
    }

    public final com.obric.aiagent.skill.manager.api.al a() {
        com.obric.aiagent.skill.manager.api.al r2 = this.f19869c.get();
        d.h.b.o.c(r2, "get(...)");
        return (com.obric.aiagent.skill.manager.api.al) ZeusTransformUtils.preCheckCast(r2, com.obric.aiagent.skill.manager.api.al.class, "com.obric.aiagent.plugin");
    }

    public final void b() {
        this.f19869c.set(this.f19868b);
    }

    public final void a(JSONObject r2) {
        d.h.b.o.e(r2, "json");
        this.f19869c.set(b(r2));
    }

    private final com.obric.aiagent.skill.manager.api.al b(JSONObject r99) {
        com.obric.aiagent.skill.manager.api.al r51 = new com.obric.aiagent.skill.manager.api.al(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, false, false, false, false, false, false, false, false, false, false, false, false, false, null, false, null, 0, -1, 31, null);
        long r2 = r99.optLong("shell_default_timeout_ms", r51.r());
        long r4 = r99.optLong("shell_hard_timeout_ms", r51.s());
        long r6 = r99.optLong("shell_hard_timeout_margin_ms", r51.t());
        int r53 = r99.optInt("load_skill_content_limit_chars", r51.a());
        int r54 = a(r99, "max_enabled_skill_count", r51.b());
        int r55 = a(r99, "create_skill_max_name_chars", r51.c());
        int r56 = a(r99, "create_skill_max_description_chars", r51.d());
        int r57 = a(r99, "import_skill_max_name_chars", r51.e());
        int r58 = a(r99, "import_skill_max_description_chars", r51.f());
        int r59 = a(r99, "import_skill_description_preview_limit_chars", r51.g());
        int r60 = a(r99, "import_skill_body_preview_limit_chars", r51.h());
        int r61 = a(r99, "max_skill_markdown_chars", r51.i());
        int r62 = a(r99, "max_assisted_skill_markdown_chars", r51.j());
        long r63 = a(r99, "max_local_skill_package_bytes", r51.k());
        int r65 = a(r99, "max_skill_package_entries", r51.l());
        long r66 = a(r99, "max_skill_package_entry_bytes", r51.m());
        long r68 = a(r99, "max_skill_package_uncompressed_bytes", r51.n());
        long r70 = a(r99, "max_skill_markdown_bytes", r51.o());
        long r72 = a(r99, "max_skill_cover_bytes", r51.p());
        int r74 = r99.optInt("shell_output_limit_chars", r51.q());
        Long r3 = Long.valueOf(r2);
        boolean r9 = true;
        if (((Number) ZeusTransformUtils.preCheckCast(r3, Number.class, "com.obric.aiagent.plugin")).longValue() <= 0) goto L5;
        boolean r5 = true;
    L6:
        Long r13 = null;
        if (r5 == true) goto L10;
        r3 = null;
    L10:
        if (r3 == null) goto L12;
        long r7 = r3.longValue();
    L13:
        long r75 = r7;
        Long r8 = Long.valueOf(r4);
        if (((Number) ZeusTransformUtils.preCheckCast(r8, Number.class, "com.obric.aiagent.plugin")).longValue() <= 0) goto L16;
        boolean r10 = true;
    L17:
        if (r10 == true) goto L20;
        r8 = null;
    L20:
        if (r8 == null) goto L22;
        long r11 = r8.longValue();
    L23:
        long r77 = r11;
        Long r12 = Long.valueOf(r6);
        if (((Number) ZeusTransformUtils.preCheckCast(r12, Number.class, "com.obric.aiagent.plugin")).longValue() > 0) goto L27;
        r9 = false;
    L27:
        if (r9 == false) goto L29;
        r13 = r12;
    L29:
        if (r13 == null) goto L31;
        long r14 = r13.longValue();
    L32:
        long r79 = r14;
        boolean r81 = r99.optBoolean("export_files_enable_media_info", r51.u());
        boolean r82 = r99.optBoolean("import_files_restrict_host_path_to_external_files_dir", r51.v());
        boolean r83 = r99.optBoolean("skill_enabled", r51.w());
        boolean r84 = r99.optBoolean("create_skill_enabled", r51.x());
        boolean r85 = r99.optBoolean("import_skill_enabled", r51.y());
        boolean r86 = r99.optBoolean("import_link_enabled", r51.z());
        boolean r87 = r99.optBoolean("security_appeal_enabled", r51.A());
        boolean r88 = r99.optBoolean("security_scanning_warning_enabled", r51.B());
        boolean r89 = r99.optBoolean("skill_shop_use_boe", r51.C());
        boolean r90 = r99.optBoolean("automatic_maintenance_enabled", r51.D());
        boolean r91 = r99.optBoolean("network_retry_and_polling_enabled", r51.E());
        boolean r92 = r99.optBoolean("shell_enabled", r51.F());
        boolean r93 = r99.optBoolean("shell_management_entry_enabled", r51.G());
        String r15 = r99.optString("shell_env", r51.H());
        d.h.b.o.c(r15, "optString(...)");
        return new com.obric.aiagent.skill.manager.api.al(r53, r54, r55, r56, r57, r58, r59, r60, r61, r62, r63, r65, r66, r68, r70, r72, r74, r75, r77, r79, r81, r82, r83, r84, r85, r86, r87, r88, r89, r90, r91, r92, r93, r15, r99.optBoolean("shell_output_sanitise_enabled", r51.I()), a(r99.optJSONObject("purge"), r51.J()), a(r99, "security_scan_processing_report_threshold", r51.K()));
    L31:
        r14 = r51.t();
        goto L32
    L22:
        r11 = r51.s();
        goto L23
    L16:
        r10 = false;
        goto L17
    L12:
        r7 = r51.r();
        goto L13
    L5:
        r5 = false;
        goto L6
    }

    private final int a(JSONObject r5, String r6, int r7) {
        Long r4 = a(r5, r6);
        if (r4 == null) goto L15;
        Long r8 = Long.valueOf(r4.longValue());
        long r9 = ((Number) ZeusTransformUtils.preCheckCast(r8, Number.class, "com.obric.aiagent.plugin")).longValue();
        boolean r1 = false;
        if (1 <= r9) goto L7;
    L9:
        if (r1 == true) goto L12;
        r8 = null;
    L12:
        if (r8 != null) goto L14;
        return r7;
    L14:
        return (int) r8.longValue();
    L7:
        if (r9 >= 2147483648L) goto L9;
        r1 = true;
        goto L9
    L15:
        return r7;
    }

    private final long a(JSONObject r3, String r4, long r5) {
        Long r2 = a(r3, r4);
        if (r2 == null) goto L14;
        Long r6 = Long.valueOf(r2.longValue());
        if (((Number) ZeusTransformUtils.preCheckCast(r6, Number.class, "com.obric.aiagent.plugin")).longValue() <= 0) goto L7;
        boolean r7 = true;
    L8:
        if (r7 == true) goto L11;
        r6 = null;
    L11:
        if (r6 != null) goto L13;
        return r5;
    L13:
        return r6.longValue();
    L7:
        r7 = false;
        goto L8
    L14:
        return r5;
    }

    private final Long a(JSONObject r1, String r2) {
        Object r0 = r1.opt(r2);
        if (ZeusTransformUtils.instanceOf(r0, Byte.class) == false) goto L6;
        return Long.valueOf(((Number) ZeusTransformUtils.preCheckCast(r0, Number.class, "com.obric.aiagent.plugin")).byteValue());
    L6:
        if (ZeusTransformUtils.instanceOf(r0, Short.class) == false) goto L9;
        return Long.valueOf(((Number) ZeusTransformUtils.preCheckCast(r0, Number.class, "com.obric.aiagent.plugin")).shortValue());
    L9:
        if (ZeusTransformUtils.instanceOf(r0, Integer.class) == false) goto L12;
        return Long.valueOf(((Number) ZeusTransformUtils.preCheckCast(r0, Number.class, "com.obric.aiagent.plugin")).intValue());
    L12:
        if (ZeusTransformUtils.instanceOf(r0, Long.class) == true) goto L19;
        return null;
    L19:
        return (Long) ZeusTransformUtils.preCheckCast(r0, Long.class, "com.obric.aiagent.plugin");
    }

    private final com.obric.aiagent.skill.manager.api.ai a(JSONObject r2, com.obric.aiagent.skill.manager.api.ai r3) {
        if (r2 != null) goto L4;
        return r3;
    L4:
        JSONArray r4 = r2.optJSONArray("rules");
        if (r4 != null) goto L8;
        return r3;
    L8:
        return new com.obric.aiagent.skill.manager.api.ai(a(r4));
    }

    private final List<com.obric.aiagent.skill.manager.api.ah> a(JSONArray r5) {
        List<com.obric.aiagent.skill.manager.api.ah> r0 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
        int r1 = r5.length();
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L12;
        JSONObject r3 = r5.optJSONObject(r2);
        if (r3 == null) goto L11;
        com.obric.aiagent.skill.manager.api.ah r4 = a(r3, r2);
        if (r4 == null) goto L11;
        r0.add(r4);
    L11:
        r2 = r2 + 1;
        goto L3
    L12:
        return r0;
    }

    private final com.obric.aiagent.skill.manager.api.ah a(JSONObject r19, int r20) {
        String r0 = r19.optString("root");
        d.h.b.o.c(r0, "optString(...)");
        String r1 = d.o.o.a(d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.aiagent.plugin")).toString(), "-", "_", false, 4, null).toUpperCase(Locale.ROOT);
        d.h.b.o.c(r1, "toUpperCase(...)");
        String r8 = null;
        if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.aiagent.plugin")) == false) goto L41;
        Enum r2 = null;
    L13:
        com.obric.aiagent.skill.manager.api.ag r11 = (com.obric.aiagent.skill.manager.api.ag) ZeusTransformUtils.preCheckCast(r2, com.obric.aiagent.skill.manager.api.ag.class, "com.obric.aiagent.plugin");
        if (r11 != null) goto L16;
        return null;
    L16:
        String r3 = r19.optString("operation");
        d.h.b.o.c(r3, "optString(...)");
        Object r7 = (Enum) ZeusTransformUtils.preCheckCast(com.obric.aiagent.skill.manager.api.af.f19166a, Enum.class, "com.obric.aiagent.plugin");
        String r4 = d.o.o.a(d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin")).toString(), "-", "_", false, 4, null).toUpperCase(Locale.ROOT);
        d.h.b.o.c(r4, "toUpperCase(...)");
        if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.aiagent.plugin")) == false) goto L39;
    L28:
        com.obric.aiagent.skill.manager.api.af r5 = (com.obric.aiagent.skill.manager.api.af) ZeusTransformUtils.preCheckCast(r7, com.obric.aiagent.skill.manager.api.af.class, "com.obric.aiagent.plugin");
        if (r5 != null) goto L31;
        r5 = com.obric.aiagent.skill.manager.api.af.f19166a;
    L31:
        com.obric.aiagent.skill.manager.api.af r13 = r5;
        String r6 = r19.optString(DbHelper.COL_ID);
        d.h.b.o.a(r6);
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L34;
        r8 = r6;
    L34:
        if (r8 != null) goto L36;
        String r10 = "rule-" + r20;
    L37:
        String r12 = r19.optString("relative_path", "");
        d.h.b.o.c(r12, "optString(...)");
        return new com.obric.aiagent.skill.manager.api.ah(r10, r11, r12, r13, b(r19.optJSONArray("excludes")));
    L36:
        r10 = r8;
        goto L37
    L39:
        d.n.a r9 = d.n.f38560a;     // Catch: Throwable -> L21
        fd r14 = (fd) ZeusTransformUtils.preCheckCast(this, fd.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L21
        Object r15 = d.n.f(com.obric.aiagent.skill.manager.api.af.valueOf(r4));     // Catch: Throwable -> L21
    L24:
        if (d.n.b(r15) == true) goto L27;
        r7 = r15;
    L27:
        r7 = (Enum) ZeusTransformUtils.preCheckCast(r7, Enum.class, "com.obric.aiagent.plugin");
    L21:
        th = move-exception;
        d.n.a r16 = d.n.f38560a;
        r15 = d.n.f(d.o.a(th));
        goto L24
    L41:
        d.n.a r17 = d.n.f38560a;     // Catch: Throwable -> L7
        fd r18 = (fd) ZeusTransformUtils.preCheckCast(this, fd.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L7
        Object r21 = d.n.f(com.obric.aiagent.skill.manager.api.ag.valueOf(r1));     // Catch: Throwable -> L7
    L10:
        if (d.n.b(r21) == false) goto L12;
        r21 = null;
    L12:
        r2 = (Enum) ZeusTransformUtils.preCheckCast(r21, Enum.class, "com.obric.aiagent.plugin");
    L7:
        th = move-exception;
        d.n.a r22 = d.n.f38560a;
        r21 = d.n.f(d.o.a(th));
        goto L10
    }

    private final List<String> b(JSONArray r6) {
        if (r6 == null) goto L4;
        List<String> r5 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
        int r0 = 0;
        int r2 = r6.length();
    L6:
        if (r0 >= r2) goto L15;
        String r3 = r6.optString(r0);
        d.h.b.o.a(r3);
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L11;
        r3 = null;
    L11:
        if (r3 == null) goto L14;
        r5.add(r3);
    L14:
        r0 = r0 + 1;
        goto L6
    L15:
        return r5;
    L4:
        return d.a.p.b();
    }
}
