package com.obric.autogui.agents.scripted.impl;

import com.obric.autogui.resourcemanage.ac;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.json.JSONObject;

/* JADX INFO: compiled from: ScriptResourceVersionProvider.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final w f27103a = null;

    /* JADX INFO: compiled from: ScriptResourceVersionProvider.kt */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Integer f27104a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Integer f27105b;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin");
            if (d.h.b.o.a(this.f27104a, r6.f27104a) == true) goto L12;
            return false;
        L12:
            if (d.h.b.o.a(this.f27105b, r6.f27105b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            Integer r0 = this.f27104a;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = r2 * 31;
            Integer r4 = this.f27105b;
            if (r4 == null) goto L11;
            r1 = r4.hashCode();
        L11:
            return r3 + r1;
        L5:
            r2 = r0.hashCode();
            goto L6
        }

        public String toString() {
            return "ScriptVersionSnapshot(scriptVerCode=" + this.f27104a + ", engineVerCode=" + this.f27105b + ')';
        }

        public a(Integer r1, Integer r2) {
            this.f27104a = r1;
            this.f27105b = r2;
        }

        public final Integer a() {
            return this.f27104a;
        }

        public final Integer b() {
            return this.f27105b;
        }

        public final void a(JSONObject r4) {
            d.h.b.o.e(r4, "json");
            Integer r0 = this.f27104a;
            if (r0 == null) goto L5;
            r4.put("script_version", ((Number) ZeusTransformUtils.preCheckCast(r0, Number.class, "com.obric.aiagent.plugin")).intValue());
        L5:
            Integer r3 = this.f27105b;
            if (r3 == null) goto L9;
            r4.put("engine_version", ((Number) ZeusTransformUtils.preCheckCast(r3, Number.class, "com.obric.aiagent.plugin")).intValue());
            return;
        }
    }

    static {
        f27103a = new w();
    }

    private w() {
    }

    public final a a() {
        if (com.obric.autogui.agents.scripted.c.b.f26918a.g() == true) goto L7;
        return null;
    L7:
        return b();
    }

    public final a b() {
        return new a(a("com.obric.ability.script"), a("com.obric.script_engine"));
    }

    public final Integer a(String r3) {
        d.h.b.o.e(r3, "packageName");
        com.obric.autogui.resourcemanage.o r2 = ac.f30597a.a(r3);
        if (r2 == null) goto L11;
        Integer r4 = Integer.valueOf(r2.e());
        if (((Number) ZeusTransformUtils.preCheckCast(r4, Number.class, "com.obric.aiagent.plugin")).intValue() <= 0) goto L7;
        boolean r0 = true;
    L8:
        if (r0 == true) goto L10;
        return null;
    L10:
        return r4;
    L7:
        r0 = false;
        goto L8
    L11:
        return null;
    }

    public final String c() {
        StringBuilder r4 = new StringBuilder();
        w r0 = f27103a;
        StringBuilder r1 = r4.append(r0.a("Script", "com.obric.ability.script"));
        d.h.b.o.c(r1, "append(...)");
        d.h.b.o.c(r1.append('\n'), "append(...)");
        r4.append(r0.a("Engine", "com.obric.script_engine"));
        String r5 = r4.toString();
        d.h.b.o.c(r5, "toString(...)");
        return r5;
    }

    public final String d() {
        StringBuilder r4 = new StringBuilder();
        w r0 = f27103a;
        StringBuilder r1 = r4.append(r0.b("Script", "com.obric.ability.script"));
        d.h.b.o.c(r1, "append(...)");
        d.h.b.o.c(r1.append('\n'), "append(...)");
        r4.append(r0.b("Engine", "com.obric.script_engine"));
        String r5 = r4.toString();
        d.h.b.o.c(r5, "toString(...)");
        return r5;
    }

    private final String a(String r1, String r2) {
        Integer r0 = a(r2);
        if (r0 != null) goto L5;
        StringBuilder r3 = new StringBuilder().append(r1).append(": Not installed");
    L7:
        return r3.toString();
    L5:
        r3 = new StringBuilder().append(r1).append(": v").append(r0);
        goto L7
    }

    private final String b(String r3, String r4) {
        com.obric.autogui.resourcemanage.o r2 = ac.f30597a.a(r4);
        if (r2 == null) goto L5;
        JSONObject r0 = new JSONObject();
        r0.put("packageName", r4);
        r0.put("verCode", r2.e());
        r0.put("md5", r2.f());
        String r5 = r2.c();
        if (r5 != null) goto L9;
        r5 = "";
    L9:
        r0.put("installDirPath", r5);
        return r3 + ": " + r0;
    L5:
        return r3 + ": Not installed";
    }
}
