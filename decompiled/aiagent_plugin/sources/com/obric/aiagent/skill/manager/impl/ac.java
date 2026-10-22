package com.obric.aiagent.skill.manager.impl;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;

/* JADX INFO: compiled from: ObricSkillPackageMetadata.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class ac {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final a f19439a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ca f19440b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ed f19441c;

    /* JADX INFO: compiled from: ObricSkillPackageMetadata.kt */
    private static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }
    }

    static {
        f19439a = new a(null);
    }

    public ac(ca r3, ed r4) {
        ca r5 = (ca) ZeusTransformUtils.wrapperContextForParams(r3, ca.class, "com.obric.aiagent.plugin");
        ed r6 = (ed) ZeusTransformUtils.wrapperContextForParams(r4, ed.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r5, "fileStore");
        d.h.b.o.e(r6, "logger");
        this.f19440b = r5;
        this.f19441c = r6;
    }

    public /* synthetic */ ac(ca r2, ed r3, int r4, d.h.b.h r5) {
        ca r6 = (ca) ZeusTransformUtils.wrapperContextForParams(r2, ca.class, "com.obric.aiagent.plugin");
        ed r7 = (ed) ZeusTransformUtils.wrapperContextForParams(r3, ed.class, "com.obric.aiagent.plugin");
        if ((r4 & 2) == 0) goto L5;
        r7 = (ed) ZeusTransformUtils.preCheckCast(ad.f19442a, ed.class, "com.obric.aiagent.plugin");
    L5:
        this(r6, r7);
    }

    public final ab a(String r2) {
        d.h.b.o.e(r2, "slug");
        return a(this.f19440b.a(r2), r2);
    }

    public final ab a(File r4, String r5) {
        d.h.b.o.e(r4, "packageRoot");
        d.h.b.o.e(r5, "diagnosticSlug");
        File r0 = new File(new File(r4, ".obric"), "manifest.json");
        if (this.f19440b.b(r0) == false) goto L5;
        return b(r4, this.f19440b.f(r0));
    L8:
        e = move-exception;
        this.f19441c.a("Obric manifest read failed: slug=" + r5, (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        return (ab) ZeusTransformUtils.preCheckCast(new ab.a("manifest_read_failed", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin")), ab.class, "com.obric.aiagent.plugin");
    L5:
        return (ab) ZeusTransformUtils.preCheckCast(ab.b.f19436a, ab.class, "com.obric.aiagent.plugin");
    }

    public final String a(String r5, ab.c r6) {
        d.h.b.o.e(r5, "slug");
        d.h.b.o.e(r6, "validPackage");
        String r0 = r6.b().a();
        if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.aiagent.plugin")) == false) goto L5;
        return "";
    L5:
        File r7 = new File(r6.a(), ".obric").getCanonicalFile();
        File r1 = new File(r7, r0).getCanonicalFile();
        d.h.b.o.a(r1);
        d.h.b.o.a(r7);
        if (a(r1, r7) == true) goto L8;
    L12:
        this.f19441c.a("Obric tool schema skipped: slug=" + r5 + " reason=missing_or_escaped");
        return "";
    L8:
        if (this.f19440b.b(r1) == false) goto L12;
        String r8 = this.f19440b.f(r1);
        this.f19441c.a("Obric tool schema loaded: slug=" + r5 + " chars=" + r8.length());
        return r8;
    }

    private final ab b(File r9, String r10) {
        JsonElement r11 = JsonParser.parseString(r10);
        if (r11.isJsonObject() == false) goto L5;
        JsonObject r12 = r11.getAsJsonObject();
        d.h.b.o.a(r12);
        Integer r0 = a(r12, "obric_skill_version", 1);
        if (r0 == null) goto L33;
        int r1 = r0.intValue();
        if (r1 != 1) goto L11;
        Boolean r5 = a(r12, "is_secret");
        if (r5 == null) goto L31;
        boolean r6 = r5.booleanValue();
        String r7 = b(r12, "obric_skill_tool_schema");
        if (r7 != null) goto L19;
        return (ab) ZeusTransformUtils.preCheckCast(new ab.a("invalid_tool_schema", null, 2, null), ab.class, "com.obric.aiagent.plugin");
    L19:
        if ((true ^ d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L21;
    L24:
        List<String> r8 = a(r12);
        if (r8 != null) goto L29;
        return (ab) ZeusTransformUtils.preCheckCast(new ab.a("invalid_require_bins", null, 2, null), ab.class, "com.obric.aiagent.plugin");
    L29:
        return (ab) ZeusTransformUtils.preCheckCast(new ab.c(r9, new aa(r1, r6, r7, r8)), ab.class, "com.obric.aiagent.plugin");
    L21:
        if (b(r7) == true) goto L24;
        return (ab) ZeusTransformUtils.preCheckCast(new ab.a("unsafe_tool_schema_path", null, 2, null), ab.class, "com.obric.aiagent.plugin");
    L31:
        return (ab) ZeusTransformUtils.preCheckCast(new ab.a("invalid_is_secret", null, 2, null), ab.class, "com.obric.aiagent.plugin");
    L11:
        return (ab) ZeusTransformUtils.preCheckCast(new ab.a("unsupported_version", null, 2, null), ab.class, "com.obric.aiagent.plugin");
    L33:
        return (ab) ZeusTransformUtils.preCheckCast(new ab.a("invalid_version", null, 2, null), ab.class, "com.obric.aiagent.plugin");
    L5:
        return (ab) ZeusTransformUtils.preCheckCast(new ab.a("manifest_not_object", null, 2, null), ab.class, "com.obric.aiagent.plugin");
    }

    private final Integer a(JsonObject r1, String r2, int r3) {
        JsonElement r0 = r1.get(r2);
        if (r0 != null) goto L7;
        return Integer.valueOf(r3);
    L7:
        if (r0.isJsonPrimitive() == true) goto L9;
        return null;
    L9:
        if (r0.getAsJsonPrimitive().isNumber() == false) goto L15;
        String r4 = r0.getAsJsonPrimitive().getAsString();
        d.h.b.o.c(r4, "getAsString(...)");
        return d.o.o.d(d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.aiagent.plugin")).toString());
    L15:
        return null;
    }

    private final Boolean a(JsonObject r1, String r2) {
        JsonElement r0 = r1.get(r2);
        if (r0 != null) goto L6;
        return null;
    L6:
        if (r0.isJsonPrimitive() == true) goto L8;
    L12:
        return null;
    L8:
        if (r0.getAsJsonPrimitive().isBoolean() == false) goto L12;
        return Boolean.valueOf(r0.getAsBoolean());
    }

    private final String b(JsonObject r1, String r2) {
        JsonElement r0 = r1.get(r2);
        if (r0 != null) goto L7;
        return "";
    L7:
        if (r0.isJsonPrimitive() == true) goto L9;
        return null;
    L9:
        if (r0.getAsJsonPrimitive().isString() == false) goto L15;
        String r3 = r0.getAsString();
        d.h.b.o.c(r3, "getAsString(...)");
        return d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin")).toString();
    L15:
        return null;
    }

    private final List<String> a(JsonObject r2) {
        JsonElement r3 = r2.get("require_bins");
        if (r3 != null) goto L7;
        return d.a.p.b();
    L7:
        if (r3.isJsonArray() == true) goto L10;
        return null;
    L10:
        JsonArray r4 = r3.getAsJsonArray();
        d.h.b.o.c(r4, "getAsJsonArray(...)");
        return a(r4);
    }

    private final List<String> a(JsonArray r6) {
        LinkedHashSet r5 = new LinkedHashSet();
        Iterator<JsonElement> r7 = r6.iterator();
        d.h.b.o.c(r7, "iterator(...)");
    L4:
        if (r7.hasNext() == false) goto L21;
        JsonElement r0 = (JsonElement) ZeusTransformUtils.preCheckCast(r7.next(), JsonElement.class, "com.obric.aiagent.plugin");
        if (r0.isJsonPrimitive() == false) goto L19;
        if (r0.getAsJsonPrimitive().isString() == false) goto L19;
        String r1 = r0.getAsString();
        d.h.b.o.c(r1, "getAsString(...)");
        String r2 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.aiagent.plugin")).toString();
        d.n.a r3 = d.n.f38560a;     // Catch: Throwable -> L13
        i.f20120a.a(r2);     // Catch: Throwable -> L13
        Object r4 = d.n.f(d.x.f38692a);     // Catch: Throwable -> L13
    L16:
        if (d.n.b(r4) == true) goto L17;
        ((Collection) ZeusTransformUtils.preCheckCast(r5, Collection.class, "com.obric.aiagent.plugin")).add(r2);
        goto L4
    L17:
        return null;
    L13:
        th = move-exception;
        d.n.a r8 = d.n.f38560a;
        r4 = d.n.f(d.o.a(th));
    L19:
        return null;
    L21:
        return d.a.p.o((Iterable) ZeusTransformUtils.preCheckCast(r5, Iterable.class, "com.obric.aiagent.plugin"));
    }

    private final boolean b(String r9) {
        if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.aiagent.plugin")) == false) goto L5;
        return false;
    L5:
        if (d.o.o.b(r9, "/", false, 2, null) == false) goto L7;
        return false;
    L7:
        if (d.o.o.c((CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.aiagent.plugin"), 0, false, 2, null) == true) goto L35;
        Iterable r8 = (Iterable) ZeusTransformUtils.preCheckCast(d.o.o.b((CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.aiagent.plugin"), new String[]{"/"}, false, 0, 6, null), Iterable.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r8, Collection.class) == true) goto L12;
    L14:
        Iterator r10 = r8.iterator();
    L16:
        if (r10.hasNext() == false) goto L34;
        String r11 = (String) ZeusTransformUtils.preCheckCast(r10.next(), String.class, "com.obric.aiagent.plugin");
        if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.aiagent.plugin")) == false) goto L20;
    L25:
        boolean r12 = true;
    L26:
        if (r12 == false) goto L16;
        return false;
    L20:
        if (d.h.b.o.a(r11, ".") == true) goto L25;
        if (d.h.b.o.a(r11, DownloadConstants.VULNERABILITY_PATH) == true) goto L25;
        r12 = false;
    L34:
        return true;
    L12:
        if (((Collection) ZeusTransformUtils.preCheckCast(r8, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L14;
    L35:
        return false;
    }

    private final boolean a(File r4, File r5) {
        String r3 = r4.getAbsolutePath();
        String r6 = r5.getAbsolutePath();
        d.h.b.o.c(r6, "getAbsolutePath(...)");
        String r7 = d.o.o.c(r6, new char[]{File.separatorChar});
        if (d.h.b.o.a(r3, r7) == true) goto L9;
        d.h.b.o.a(r3);
        if (d.o.o.b(r3, r7 + File.separator, false, 2, null) == false) goto L8;
        return true;
    L8:
        return false;
    L9:
        return true;
    }
}
