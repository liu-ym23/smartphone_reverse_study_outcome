package com.obric.agent.intents.skill.d;

import com.obric.aiagent.skill.manager.api.al;
import com.obric.aiagent.skill.manager.api.r;
import com.obric.aiagent.skill.manager.api.s;
import com.obric.aiagent.skill.manager.api.t;
import com.obric.aiagent.skill.manager.api.u;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import d.n;

/* JADX INFO: compiled from: SystemSkillFailure.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final g f15171a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final g f15172b = null;

    /* JADX INFO: compiled from: SystemSkillFailure.kt */
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f15173a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f15174b = null;

        static {
            int[] r0 = new int[com.obric.aiagent.skill.ovirt.api.a.b.values().length];
            r0[com.obric.aiagent.skill.ovirt.api.a.b.f20950e.ordinal()] = 1;     // Catch: NoSuchFieldError -> L46
        L95:
            r0[com.obric.aiagent.skill.ovirt.api.a.b.f20948c.ordinal()] = 2;     // Catch: NoSuchFieldError -> L47
        L105:
            r0[com.obric.aiagent.skill.ovirt.api.a.b.f20946a.ordinal()] = 3;     // Catch: NoSuchFieldError -> L48
        L113:
            r0[com.obric.aiagent.skill.ovirt.api.a.b.f20947b.ordinal()] = 4;     // Catch: NoSuchFieldError -> L49
        L115:
            r0[com.obric.aiagent.skill.ovirt.api.a.b.f.ordinal()] = 5;     // Catch: NoSuchFieldError -> L50
        L121:
            r0[com.obric.aiagent.skill.ovirt.api.a.b.g.ordinal()] = 6;     // Catch: NoSuchFieldError -> L51
        L129:
            r0[com.obric.aiagent.skill.ovirt.api.a.b.h.ordinal()] = 7;     // Catch: NoSuchFieldError -> L52
        L81:
            r0[com.obric.aiagent.skill.ovirt.api.a.b.i.ordinal()] = 8;     // Catch: NoSuchFieldError -> L53
        L97:
            r0[com.obric.aiagent.skill.ovirt.api.a.b.j.ordinal()] = 9;     // Catch: NoSuchFieldError -> L54
        L99:
            r0[com.obric.aiagent.skill.ovirt.api.a.b.k.ordinal()] = 10;     // Catch: NoSuchFieldError -> L55
        L107:
            r0[com.obric.aiagent.skill.ovirt.api.a.b.f20949d.ordinal()] = 11;     // Catch: NoSuchFieldError -> L56
        L125:
            r0[com.obric.aiagent.skill.ovirt.api.a.b.l.ordinal()] = 12;     // Catch: NoSuchFieldError -> L57
        L26:
            f15173a = r0;
            int[] r1 = new int[r.values().length];
            r1[r.f19300a.ordinal()] = 1;     // Catch: NoSuchFieldError -> L58
        L87:
            r1[r.f19301b.ordinal()] = 2;     // Catch: NoSuchFieldError -> L59
        L93:
            r1[r.f19302c.ordinal()] = 3;     // Catch: NoSuchFieldError -> L60
        L103:
            r1[r.f19303d.ordinal()] = 4;     // Catch: NoSuchFieldError -> L61
        L109:
            r1[r.f19304e.ordinal()] = 5;     // Catch: NoSuchFieldError -> L62
        L119:
            r1[r.f.ordinal()] = 6;     // Catch: NoSuchFieldError -> L63
        L127:
            r1[r.g.ordinal()] = 7;     // Catch: NoSuchFieldError -> L64
        L131:
            r1[r.h.ordinal()] = 8;     // Catch: NoSuchFieldError -> L65
        L77:
            r1[r.i.ordinal()] = 9;     // Catch: NoSuchFieldError -> L66
        L85:
            r1[r.j.ordinal()] = 10;     // Catch: NoSuchFieldError -> L67
        L91:
            r1[r.k.ordinal()] = 11;     // Catch: NoSuchFieldError -> L68
        L101:
            r1[r.l.ordinal()] = 12;     // Catch: NoSuchFieldError -> L69
        L111:
            r1[r.m.ordinal()] = 13;     // Catch: NoSuchFieldError -> L70
        L117:
            r1[r.n.ordinal()] = 14;     // Catch: NoSuchFieldError -> L71
        L123:
            r1[r.o.ordinal()] = 15;     // Catch: NoSuchFieldError -> L72
        L75:
            r1[r.p.ordinal()] = 16;     // Catch: NoSuchFieldError -> L73
        L89:
            r1[r.q.ordinal()] = 17;     // Catch: NoSuchFieldError -> L74
        L44:
            f15174b = r1;
        }
    }

    static {
        f15171a = new g("IMPORT_SKILL_DISABLED", "当前尚未支持为豆包的 ‘手机任务’ 模式安装技能，该功能在计划中了。");
        f15172b = new g("CREATE_SKILL_DISABLED", "当前尚未支持为豆包的 ‘手机任务’ 模式创建或更新技能，该功能在计划中了。");
    }

    public static final g a() {
        return f15171a;
    }

    public static final g b() {
        return f15172b;
    }

    public static final g a(u.a r3) {
        o.e(r3, "<this>");
        s r0 = r3.d();
        if (r0 == null) goto L5;
        t r1 = r0.a();
    L7:
        if (r1 == t.R) goto L9;
        if (r0 == null) goto L15;
        t r2 = r0.a();
        if (r2 == null) goto L15;
        String r4 = r2.name();
        if (r4 == null) goto L15;
    L16:
        if (r0 == null) goto L19;
        String r5 = r0.b();
        if (r5 == null) goto L19;
    L21:
        return a(r4, r5);
    L19:
        r5 = b(r3.a());
    L15:
        r4 = r3.a().name();
        goto L16
    L9:
        return new g(r0.a().name(), r0.b());
    L5:
        r1 = null;
        goto L7
    }

    public static final g a(r r1) {
        o.e(r1, "<this>");
        return a(r1.name(), b(r1));
    }

    public static final g a(String r6, String r7) {
        o.e(r6, MonitorConstants.CODE);
        o.e(r7, "reason");
        CharSequence r8 = (CharSequence) ZeusTransformUtils.preCheckCast(d.o.o.c(d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.aiagent.plugin")).toString(), new char[]{'.'}), CharSequence.class, "com.obric.aiagent.plugin");
        if (d.o.o.d(r8) == false) goto L6;
        r8 = "The Skill operation failed";
    L6:
        return new g(r6, ((String) ZeusTransformUtils.preCheckCast(r8, String.class, "com.obric.aiagent.plugin")) + ". Suggested action: " + d.o.o.c(d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(a(r6), CharSequence.class, "com.obric.aiagent.plugin")).toString(), new char[]{'.'}) + '.');
    }

    public static final g a(Throwable r6) {
        o.e(r6, "<this>");
        Object r1 = null;
        if (ZeusTransformUtils.instanceOf(r6, com.obric.aiagent.skill.ovirt.api.a.a.class) == false) goto L5;
        com.obric.aiagent.skill.ovirt.api.a.a r0 = (com.obric.aiagent.skill.ovirt.api.a.a) ZeusTransformUtils.preCheckCast(r6, com.obric.aiagent.skill.ovirt.api.a.a.class, "com.obric.aiagent.plugin");
    L7:
        if (r0 == null) goto L9;
        n.a r5 = n.f38560a;     // Catch: Throwable -> L12
        com.obric.aiagent.skill.ovirt.api.a.a r7 = (com.obric.aiagent.skill.ovirt.api.a.a) ZeusTransformUtils.preCheckCast(r6, com.obric.aiagent.skill.ovirt.api.a.a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L12
        Object r8 = n.f(al.f19195a.a());     // Catch: Throwable -> L12
    L15:
        if (n.b(r8) == true) goto L18;
        r1 = r8;
    L18:
        al r9 = (al) ZeusTransformUtils.preCheckCast(r1, al.class, "com.obric.aiagent.plugin");
        switch(a.f15173a[r0.a().ordinal()]) {
            case 1: goto L47;
            case 2: goto L47;
            case 3: goto L57;
            case 4: goto L56;
            case 5: goto L56;
            case 6: goto L55;
            case 7: goto L38;
            case 8: goto L33;
            case 9: goto L28;
            case 10: goto L23;
            case 11: goto L50;
            case 12: goto L50;
            default: goto L21;
        };
    L23:
        if (r9 == null) goto L26;
        String r10 = "Skill package exceeds the " + a(r9.k()) + " size limit";
        if (r10 == null) goto L26;
    L51:
        return a("SOURCE_FILE_TOO_LARGE", r10);
    L26:
        r10 = "Skill package exceeds the configured size limit";
        goto L51
    L28:
        if (r9 == null) goto L31;
        String r11 = "Extracted Skill package exceeds the " + a(r9.n()) + " size limit";
        if (r11 == null) goto L31;
    L52:
        return a("ZIP_PACKAGE_TOO_LARGE", r11);
    L31:
        r11 = "Extracted Skill package exceeds the configured size limit";
        goto L52
    L33:
        if (r9 == null) goto L36;
        String r12 = "A ZIP entry exceeds the " + a(r9.m()) + " size limit";
        if (r12 == null) goto L36;
    L53:
        return a("ZIP_ENTRY_TOO_LARGE", r12);
    L36:
        r12 = "A ZIP entry exceeds the configured size limit";
        goto L53
    L38:
        if (r9 == null) goto L41;
        String r13 = "Skill package contains more than " + r9.l() + " entries";
        if (r13 == null) goto L41;
    L54:
        return a("ZIP_TOO_MANY_ENTRIES", r13);
    L41:
        r13 = "Skill package contains too many entries";
        goto L54
    L21:
        throw new d.k();
    L50:
        return a("SKILL_OVIRT_EXPORT_FAILED", "The Skill directory could not be exported from OVirt");
    L55:
        return a("SKILL_DIRECTORY_CHANGED", "The Skill directory changed while it was being archived");
    L56:
        return a("SKILL_DIRECTORY_UNSAFE", "The projected Skill directory contains unsafe or reserved content");
    L57:
        return a("SKILL_PATH_INVALID", "skill_path is not a valid projected Skill root");
    L47:
        return a("SKILL_DIRECTORY_NOT_FOUND", "The projected Skill directory is unavailable in the current OVirt task");
    L12:
        th = move-exception;
        n.a r14 = n.f38560a;
        r8 = n.f(d.o.a(th));
        goto L15
    L9:
        return a("SKILL_OVIRT_EXPORT_FAILED", "The Skill directory could not be exported from OVirt");
    L5:
        r0 = null;
        goto L7
    }

    public static final g b(Throwable r3) {
        o.e(r3, "<this>");
        if (ZeusTransformUtils.instanceOf(r3, com.obric.aiagent.skill.ovirt.api.a.a.class) == false) goto L5;
        com.obric.aiagent.skill.ovirt.api.a.a r4 = (com.obric.aiagent.skill.ovirt.api.a.a) ZeusTransformUtils.preCheckCast(r3, com.obric.aiagent.skill.ovirt.api.a.a.class, "com.obric.aiagent.plugin");
    L7:
        if (r4 == null) goto L9;
        com.obric.aiagent.skill.ovirt.api.a.b r5 = r4.a();
        int r6 = a.f15173a[r5.ordinal()];
        if (r6 == 1) goto L22;
        if (r6 == 2) goto L22;
        if (r6 == 3) goto L25;
        if (r6 == 4) goto L24;
        return a("SKILL_OVIRT_EXPORT_FAILED", "The Skill package could not be exported from OVirt");
    L24:
        return a("SKILL_OVIRT_PATH_NOT_ALLOWED", "package_path is outside the OVirt export roots");
    L25:
        return a("PACKAGE_PATH_INVALID", "package_path is not a valid OVirt ZIP path");
    L22:
        return a("FILE_UNAVAILABLE", "Skill package file is unavailable");
    L9:
        return a("SKILL_OVIRT_EXPORT_FAILED", "The Skill package could not be exported from OVirt");
    L5:
        r4 = null;
        goto L7
    }

    public static final g c() {
        return a("SCAN_SUBMISSION_FAILED", "The Skill was saved, but security scanning could not be started");
    }

    private static final String b(r r1) {
        switch(a.f15174b[r1.ordinal()]) {
            case 1: goto L22;
            case 2: goto L21;
            case 3: goto L20;
            case 4: goto L19;
            case 5: goto L18;
            case 6: goto L17;
            case 7: goto L16;
            case 8: goto L15;
            case 9: goto L14;
            case 10: goto L13;
            case 11: goto L12;
            case 12: goto L11;
            case 13: goto L10;
            case 14: goto L9;
            case 15: goto L8;
            case 16: goto L7;
            case 17: goto L6;
            default: goto L5;
        };
    L6:
        return "The Skill operation failed";
    L7:
        return "The Skill OVirt operation failed";
    L8:
        return "The Skill could not be saved";
    L9:
        return "The Skill operation failed because of a network error";
    L10:
        return "Skill service is unavailable";
    L11:
        return "Skill package is invalid";
    L12:
        return "The maximum number of enabled Skills has been reached";
    L13:
        return "The Skill is blocked by security policy";
    L14:
        return "The Skill security status could not be refreshed";
    L15:
        return "The Skill security result is unavailable";
    L16:
        return "Security scanning failed for the current Skill version";
    L17:
        return "Security scanning has not started for the current Skill version";
    L18:
        return "The Skill security scan is still in progress";
    L19:
        return "This Skill cannot be edited";
    L20:
        return "The Skill conflicts with an existing change";
    L21:
        return "The Skill was not found";
    L22:
        return "The Skill request is invalid";
    L5:
        throw new d.k();
    }

    private static final String a(String r1) {
        switch(r1.hashCode()) {
            case -2144068265: goto L273;
            case -2139298426: goto L269;
            case -2127879370: goto L265;
            case -1955730415: goto L261;
            case -1888706710: goto L257;
            case -1848787437: goto L253;
            case -1743525391: goto L249;
            case -1704249536: goto L245;
            case -1496556947: goto L241;
            case -1473077418: goto L237;
            case -1438230838: goto L233;
            case -1401827044: goto L229;
            case -1339470991: goto L225;
            case -1302617528: goto L221;
            case -1175668274: goto L217;
            case -1122374247: goto L213;
            case -1108655294: goto L209;
            case -1026256236: goto L205;
            case -867934530: goto L201;
            case -800450540: goto L197;
            case -689477319: goto L193;
            case -684816241: goto L189;
            case -671994257: goto L185;
            case -667787795: goto L181;
            case -560227630: goto L177;
            case -498539674: goto L173;
            case -382211278: goto L169;
            case -297809177: goto L165;
            case -207738434: goto L161;
            case -197168090: goto L157;
            case -15647795: goto L153;
            case 25943296: goto L149;
            case 31823151: goto L145;
            case 106609264: goto L141;
            case 111795641: goto L137;
            case 202578898: goto L133;
            case 222232952: goto L129;
            case 308590623: goto L125;
            case 376705039: goto L121;
            case 439424986: goto L117;
            case 494362345: goto L114;
            case 578654053: goto L110;
            case 611833280: goto L106;
            case 642574422: goto L102;
            case 696544716: goto L98;
            case 697890940: goto L94;
            case 710671115: goto L90;
            case 764815692: goto L86;
            case 768057734: goto L82;
            case 849809595: goto L79;
            case 897207458: goto L75;
            case 985422905: goto L72;
            case 990025551: goto L68;
            case 1023286998: goto L64;
            case 1201095833: goto L60;
            case 1230712712: goto L56;
            case 1270392710: goto L53;
            case 1360297297: goto L49;
            case 1382925253: goto L45;
            case 1443902359: goto L41;
            case 1521018507: goto L37;
            case 1563985619: goto L33;
            case 1572693782: goto L29;
            case 1658297669: goto L25;
            case 1662355720: goto L22;
            case 1873612264: goto L18;
            case 1907405646: goto L14;
            case 1954402716: goto L10;
            case 2068650001: goto L6;
            default: goto L276;
        };
    L276:
        return "Stop and handle this error code before continuing";
    L6:
        if (r1.equals("FRONTMATTER_MISSING") == false) goto L276;
        return "Add YAML frontmatter at the beginning of SKILL.md";
    L10:
        if (r1.equals("BODY_REQUIRED") == false) goto L276;
        return "Add a non-empty instruction body after SKILL.md frontmatter";
    L14:
        if (r1.equals("SCAN_SUBMISSION_FAILED") == false) goto L276;
        return "Do not submit the change again because it is already saved; report that scanning did not start";
    L18:
        if (r1.equals("INTERNAL_FAILURE") == false) goto L276;
        return "Retry once; if it still fails, stop and report this error code";
    L22:
        if (r1.equals("STORE_SERVICE_UNAVAILABLE") == false) goto L276;
    L271:
        return "Retry after the Skill service becomes available";
    L25:
        if (r1.equals("SCAN_IN_PROGRESS") == false) goto L276;
        return "Wait for the current security scan to finish before modifying the Skill again";
    L29:
        if (r1.equals("SKILL_PATH_SLUG_MISMATCH") == false) goto L276;
        return "Use the final skill_path directory segment as skill_slug and retry";
    L33:
        if (r1.equals("NAME_REQUIRED") == false) goto L276;
        return "Add a non-empty name to SKILL.md frontmatter";
    L37:
        if (r1.equals("SKILL_OVIRT_PATH_NOT_ALLOWED") == false) goto L276;
        return "Move the ZIP under the current OVirt HOME, SHARE, or /tmp export root and retry";
    L41:
        if (r1.equals("STORE_RESPONSE_INVALID") == false) goto L276;
        return "Retry later; if it persists, report the Skill Store response error";
    L45:
        if (r1.equals("DOWNLOAD_URL_REJECTED") == false) goto L276;
        return "Use an allowed public HTTPS package URL";
    L49:
        if (r1.equals("STORE_ONLY_PACKAGE") == false) goto L276;
        return "Install this Skill by its exact Skill Store Slug instead";
    L53:
        if (r1.equals("STORAGE_FAILURE") == false) goto L276;
    L175:
        return "Free storage if needed and retry; do not assume the Skill was saved";
    L56:
        if (r1.equals("DOWNLOAD_HTTP_ERROR") == false) goto L276;
        return "Verify the package is publicly downloadable, then retry";
    L60:
        if (r1.equals("INVALID_ZIP") == false) goto L276;
        return "Provide a valid ZIP archive and retry";
    L64:
        if (r1.equals("NOT_FOUND") == false) goto L276;
        return "Verify the Skill identifier and stop if it is no longer available";
    L68:
        if (r1.equals("DOWNLOAD_SERVICE_UNAVAILABLE") == false) goto L276;
        return "Retry after the package download service becomes available";
    L72:
        if (r1.equals("NETWORK_FAILURE") == false) goto L276;
    L151:
        return "Check network availability and retry";
    L75:
        if (r1.equals("DESCRIPTION_REQUIRED") == false) goto L276;
        return "Add a non-empty description to SKILL.md frontmatter";
    L79:
        if (r1.equals("STORE_NETWORK_FAILURE") == true) goto L151;
    L82:
        if (r1.equals("PACKAGE_HASH_MISMATCH") == false) goto L276;
        return "Download or export the package again and retry with its matching expected_sha256";
    L86:
        if (r1.equals("MULTIPLE_SKILL_MARKDOWN") == false) goto L276;
        return "Keep exactly one SKILL.md and retry";
    L90:
        if (r1.equals("SKILL_PATH_INVALID") == false) goto L276;
        return "Use the exact projected root ~/.agents/skills/<slug> and retry";
    L94:
        if (r1.equals("SKILL_NAME_IMMUTABLE") == false) goto L276;
        return "Restore the original SKILL.md name and add or change display_name instead";
    L98:
        if (r1.equals("BLOCKED") == false) goto L276;
        return "Wait for the active Shell operation to finish, then retry";
    L102:
        if (r1.equals("SKILL_DIRECTORY_NOT_FOUND") == false) goto L276;
        return "Stop this edit and retry in a new phone-operation task so OVirt projects the Skill again; do not call load_skill to repair projection";
    L106:
        if (r1.equals("SECURITY_SCAN_FAILED") == false) goto L276;
        return "Retry after the security scan is restarted successfully; do not bypass the security check";
    L110:
        if (r1.equals("ZIP_ENTRY_TOO_LARGE") == false) goto L276;
        return "Reduce or remove the oversized ZIP entry and retry";
    L114:
        if (r1.equals("PROCESSING_FAILED") == false) goto L276;
    L203:
        return "Rebuild the Skill package from a clean source and retry";
    L117:
        if (r1.equals("FRONTMATTER_UNCLOSED") == false) goto L276;
        return "Close the YAML frontmatter with a second --- line";
    L121:
        if (r1.equals("INVALID_SKILL_MARKDOWN_LOCATION") == false) goto L276;
        return "Move SKILL.md to the ZIP root or one top-level directory and retry";
    L125:
        if (r1.equals("SKILL_OVIRT_EXPORT_FAILED") == false) goto L276;
        return "Retry once in the current OVirt; if it still fails, stop and report this error code";
    L129:
        if (r1.equals("SKILL_NAME_CONFLICT") == false) goto L276;
        return "Choose a different name or update the existing Skill instead";
    L133:
        if (r1.equals("CONFLICT") == false) goto L276;
        return "Refresh the current state before retrying; do not overwrite the newer change";
    L137:
        if (r1.equals("ZIP_PACKAGE_TOO_LARGE") == false) goto L276;
        return "Reduce the extracted package size below the stated limit and retry";
    L141:
        if (r1.equals("NOT_EDITABLE") == false) goto L276;
        return "Stop editing this Skill and choose a user-created or imported Skill";
    L145:
        if (r1.equals("OVIRT_FAILURE") == false) goto L276;
        return "Retry in a new phone-operation task with a fresh OVirt";
    L149:
        if (r1.equals("DOWNLOAD_NETWORK_ERROR") == true) goto L151;
    L153:
        if (r1.equals("SECURITY_BLOCKED") == false) goto L276;
        return "Stop the operation and do not bypass the security decision";
    L157:
        if (r1.equals("SKILL_DIRECTORY_UNSAFE") == false) goto L276;
        return "Remove the unsafe, symbolic-link, special, or reserved entry; do not bypass the check";
    L161:
        if (r1.equals("SKILL_NOT_EDITABLE") == false) goto L276;
        return "Do not retry editing; only user-created or imported Skills can be edited";
    L165:
        if (r1.equals("SKILL_OVIRT_UNAVAILABLE") == false) goto L276;
        return "Run this operation in the same phone-operation task that owns the current OVirt";
    L169:
        if (r1.equals("SECURITY_SCAN_NOT_STARTED") == false) goto L276;
        return "Retry after security scanning has started; do not bypass the security check";
    L173:
        if (r1.equals("DOWNLOAD_IO_ERROR") == true) goto L175;
    L177:
        if (r1.equals("ENABLE_LIMIT_REACHED") == false) goto L276;
        return "Disable another Skill before enabling this one; the installed Skill may remain disabled";
    L181:
        if (r1.equals("FILE_UNAVAILABLE") == false) goto L276;
        return "Verify the ZIP still exists and is a readable regular file, then retry";
    L185:
        if (r1.equals("SECURITY_STATUS_REFRESH_FAILED") == false) goto L276;
        return "Check network availability and retry once";
    L189:
        if (r1.equals("SKILL_MARKDOWN_CONTENT_TOO_LONG") == false) goto L276;
        return "Shorten SKILL.md below the stated character limit and retry";
    L193:
        if (r1.equals("ZIP_TOO_MANY_ENTRIES") == false) goto L276;
        return "Reduce the number of files and directories below the stated limit and retry";
    L197:
        if (r1.equals("SKILL_DIRECTORY_CHANGED") == false) goto L276;
        return "Wait until editing has finished, then export and apply the Skill again";
    L201:
        if (r1.equals("PACKAGE_INVALID") == true) goto L203;
    L205:
        if (r1.equals("SKILL_AVAILABILITY_UNKNOWN") == false) goto L276;
        return "Retry after Skill settings and OVirt capability checks are ready";
    L209:
        if (r1.equals("INVALID_INPUT") == false) goto L276;
        return "Correct the request using the documented parameters and retry";
    L213:
        if (r1.equals("DOWNLOAD_TOO_MANY_REDIRECTS") == false) goto L276;
        return "Use the final direct public HTTPS package URL";
    L217:
        if (r1.equals("SKILL_MARKDOWN_TOO_LARGE") == false) goto L276;
        return "Reduce the SKILL.md file size below the stated limit and retry";
    L221:
        if (r1.equals("SKILL_NOT_FOUND") == false) goto L276;
        return "Stop the update and verify the Slug from the projected Skill directory; do not create";
    L225:
        if (r1.equals("SKILL_NAME_INVALID") == false) goto L276;
        return "Use a valid Skill name and retry";
    L229:
        if (r1.equals("UNSAFE_ZIP_PATH") == false) goto L276;
        return "Remove unsafe paths from the ZIP; do not bypass the check";
    L233:
        if (r1.equals("STORE_SKILL_NOT_FOUND") == false) goto L276;
        return "Search the Skill Store again and retry with an exact returned Slug";
    L237:
        if (r1.equals("MISSING_SKILL_MARKDOWN") == false) goto L276;
        return "Add exactly one SKILL.md at the ZIP root or one top-level directory";
    L241:
        if (r1.equals("SECURITY_RESULT_UNAVAILABLE") == false) goto L276;
        return "Refresh the Skill security status and retry; do not treat the Skill as safe";
    L245:
        if (r1.equals("DUPLICATE_ZIP_ENTRY") == false) goto L276;
        return "Remove duplicate ZIP entries and retry";
    L249:
        if (r1.equals("SOURCE_FILE_TOO_LARGE") == false) goto L276;
        return "Reduce the source ZIP size below the stated limit and retry";
    L253:
        if (r1.equals("SKILL_FEATURE_DISABLED") == false) goto L276;
        return "Enable the Skill feature before retrying";
    L257:
        if (r1.equals("SKILL_EXTENSION_DISABLED") == false) goto L276;
        return "Enable the user Skill extension switch before retrying";
    L261:
        if (r1.equals("DUPLICATE_FRONTMATTER_FIELD") == false) goto L276;
        return "Keep only one value for the named frontmatter field";
    L265:
        if (r1.equals("PACKAGE_PATH_INVALID") == false) goto L276;
        return "Use an absolute OVirt path to a ZIP file and retry";
    L269:
        if (r1.equals("SERVICE_UNAVAILABLE") == true) goto L271;
    L273:
        if (r1.equals("SKILL_CAPABILITY_UNAVAILABLE") == false) goto L276;
        return "Use a device and build that support the OVirt capability";
    }

    private static final String a(long r7) {
        if (r7 < DownloadConstants.GB) goto L8;
        if ((r7 % DownloadConstants.GB) != 0) goto L8;
        return (r7 / DownloadConstants.GB) + " GB";
    L8:
        if (r7 < 1048576) goto L13;
        if ((r7 % 1048576) != 0) goto L13;
        return (r7 / 1048576) + " MB";
    L13:
        if (r7 < 1024) goto L18;
        if ((r7 % 1024) != 0) goto L18;
        return (r7 / 1024) + " KB";
    L18:
        return r7 + " B";
    }
}
