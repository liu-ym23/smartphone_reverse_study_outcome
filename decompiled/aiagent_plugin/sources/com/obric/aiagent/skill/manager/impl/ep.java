package com.obric.aiagent.skill.manager.impl;

import com.bytedance.security.zenmobile.io.SensitiveType;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;

/* JADX INFO: compiled from: SkillTrackingSchema.kt */
/* JADX INFO: loaded from: classes3.dex */
public final enum ep extends Enum<ep> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f19833a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ep f19834b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ep f19835c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ep f19836d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final ep f19837e = null;
    public static final ep f = null;
    public static final ep g = null;
    public static final ep h = null;
    public static final ep i = null;
    public static final ep j = null;
    public static final ep k = null;
    public static final ep l = null;
    private static final /* synthetic */ ep[] n = null;
    private static final /* synthetic */ d.d.a o = null;
    private final String m;

    /* JADX INFO: compiled from: SkillTrackingSchema.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }

        public final ep a(String r5) {
            Object r4 = null;
            if (r5 == null) goto L5;
            String r6 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.aiagent.plugin")).toString();
        L6:
            if (r6 != null) goto L8;
            r6 = "";
        L8:
            int r1 = r6.hashCode();
            if (r1 == 991615227) goto L23;
            if (r1 == 991828715) goto L19;
            if (r1 == 992063518) goto L16;
        L24:
            Iterator r2 = ((Iterable) ZeusTransformUtils.preCheckCast(ep.b(), Iterable.class, "com.obric.aiagent.plugin")).iterator();
        L26:
            if (r2.hasNext() == false) goto L30;
            Object r3 = r2.next();
            if (d.h.b.o.a(((ep) ZeusTransformUtils.preCheckCast(r3, ep.class, "com.obric.aiagent.plugin")).a(), r6) == false) goto L26;
            r4 = r3;
        L30:
            ep r7 = (ep) ZeusTransformUtils.preCheckCast(r4, ep.class, "com.obric.aiagent.plugin");
            if (r7 == null) goto L41;
            return r7;
        L41:
            return ep.l;
        L16:
            if (r6.equals("natural_language_text") == false) goto L24;
            return ep.f19835c;
        L19:
            if (r6.equals("natural_language_link") == false) goto L24;
            return ep.f19837e;
        L23:
            if (r6.equals("natural_language_edit") == false) goto L24;
            return ep.f19836d;
        L5:
            r6 = null;
            goto L6
        }
    }

    public static d.d.a<ep> b() {
        return o;
    }

    private static final /* synthetic */ ep[] c() {
        return new ep[]{f19834b, f19835c, f19836d, f19837e, f, g, h, i, j, k, l};
    }

    private ep(String r1, int r2, String r3) {
        super(r1, r2);
        this.m = r3;
    }

    public final String a() {
        return this.m;
    }

    static {
        f19834b = new ep("APP_FUNCTION_IMPORT", 0, "app_function_import");
        f19835c = new ep("NL_CREATE_SKILL", 1, "nl_create_skill");
        f19836d = new ep("NL_EDIT_SKILL", 2, "nl_edit_skill");
        f19837e = new ep("NL_IMPORT_SKILL_BY_LINK", 3, "nl_import_skill_by_link");
        f = new ep("NL_IMPORT_SKILL_BY_PATH", 4, "nl_import_skill_by_path");
        g = new ep("STORE_INSTALL", 5, "store_install");
        h = new ep("GUI_FILE_UPLOAD", 6, "gui_file_upload");
        i = new ep("GUI_LINK_PARSE", 7, "gui_link_parse");
        j = new ep("GUI_FORM_CREATE", 8, "gui_form_create");
        k = new ep("GUI_FORM_EDIT", 9, "gui_form_edit");
        l = new ep("UNKNOWN", 10, SensitiveType.UNKNOWN);
        ep[] r0 = c();
        n = r0;
        o = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
        f19833a = new a(null);
    }

    public static ep valueOf(String r2) {
        return (ep) ZeusTransformUtils.preCheckCast(Enum.valueOf(ep.class, r2), ep.class, "com.obric.aiagent.plugin");
    }

    public static ep[] values() {
        return (ep[]) ZeusTransformUtils.preCheckCast(n.clone(), ep[].class, "com.obric.aiagent.plugin");
    }
}
