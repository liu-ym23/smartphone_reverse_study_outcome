package com.obric.autogui.agents.vlm.models.omni;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: OmniActionEffectEvaluationWire.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final m f28435a = null;

    /* JADX INFO: compiled from: OmniActionEffectEvaluationWire.kt */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final JsonObject f28436a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f28437b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f28438c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final String f28439d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final boolean f28440e;
        private final String f;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin");
            if (d.h.b.o.a(this.f28436a, r6.f28436a) == true) goto L12;
            return false;
        L12:
            if (this.f28437b == r6.f28437b) goto L15;
            return false;
        L15:
            if (d.h.b.o.a(this.f28438c, r6.f28438c) == true) goto L18;
            return false;
        L18:
            if (d.h.b.o.a(this.f28439d, r6.f28439d) == true) goto L21;
            return false;
        L21:
            if (this.f28440e == r6.f28440e) goto L24;
            return false;
        L24:
            if (d.h.b.o.a(this.f, r6.f) == true) goto L26;
            return false;
        L26:
            return true;
        }

        public int hashCode() {
            int r0 = ((this.f28436a.hashCode() * 31) + Boolean.hashCode(this.f28437b)) * 31;
            String r1 = this.f28438c;
            int r2 = 0;
            if (r1 != null) goto L5;
            int r3 = 0;
        L6:
            int r4 = (r0 + r3) * 31;
            String r5 = this.f28439d;
            if (r5 != null) goto L9;
            int r6 = 0;
        L10:
            int r7 = (((r4 + r6) * 31) + Boolean.hashCode(this.f28440e)) * 31;
            String r8 = this.f;
            if (r8 == null) goto L15;
            r2 = r8.hashCode();
        L15:
            return r7 + r2;
        L9:
            r6 = r5.hashCode();
            goto L10
        L5:
            r3 = r1.hashCode();
            goto L6
        }

        public String toString() {
            return "AttachResult(result=" + this.f28436a + ", attached=" + this.f28437b + ", firstEvaluation=" + this.f28438c + ", endEvaluation=" + this.f28439d + ", defaultUsed=" + this.f28440e + ", failureType=" + this.f + ')';
        }

        public a(JsonObject r2, boolean r3, String r4, String r5, boolean r6, String r7) {
            d.h.b.o.e(r2, "result");
            this.f28436a = r2;
            this.f28437b = r3;
            this.f28438c = r4;
            this.f28439d = r5;
            this.f28440e = r6;
            this.f = r7;
        }

        public /* synthetic */ a(JsonObject r10, boolean r11, String r12, String r13, boolean r14, String r15, int r16, d.h.b.h r17) {
            if ((r16 & 4) == 0) goto L5;
            String r5 = null;
        L7:
            if ((r16 & 8) == 0) goto L9;
            String r6 = null;
        L11:
            if ((r16 & 32) == 0) goto L13;
            String r8 = null;
        L14:
            this(r10, r11, r5, r6, r14, r8);
            return;
        L13:
            r8 = r15;
            goto L14
        L9:
            r6 = r13;
            goto L11
        L5:
            r5 = r12;
            goto L7
        }

        public final JsonObject a() {
            return this.f28436a;
        }

        public final boolean b() {
            return this.f28437b;
        }

        public final String c() {
            return this.f28438c;
        }

        public final String d() {
            return this.f28439d;
        }

        public final boolean e() {
            return this.f28440e;
        }

        public final String f() {
            return this.f;
        }
    }

    static {
        f28435a = new m();
    }

    private m() {
    }

    public final a a(JsonObject r17, f r18, ab r19, Boolean r20, Boolean r21) {
        d.h.b.o.e(r17, "result");
        d.h.b.o.e(r18, "evaluation");
        b r0 = r18.o();
        g r4 = r18.l();
        boolean r15 = !r0.b();
        JsonElement r6 = r17.get("hyper_params");
        if (r6 == null) goto L5;
        boolean r7 = r6.isJsonObject();
        if (r7 == true) goto L15;
        if (r6.isJsonPrimitive() == false) goto L51;
        if (r6.getAsJsonPrimitive().isString() == false) goto L51;
        r6 = JsonParser.parseString(r6.getAsString());     // Catch: Exception -> L47
    L47:
        e = move-exception;
        return a(r17, r15, a(e));
    L51:
        return a(r17, r15, "HyperParamsUnsupportedType");
    L15:
        if (r6.isJsonObject() == false) goto L17;
        JsonObject r8 = r6.getAsJsonObject().deepCopy();     // Catch: Exception -> L44
        r8.addProperty("first_effect_evaluation", r4.a());     // Catch: Exception -> L44
        r8.addProperty("end_effect_evaluation", r4.b());     // Catch: Exception -> L44
        if (r19 == null) goto L23;
        Boolean r9 = r19.c();     // Catch: Exception -> L44
        if (r9 == null) goto L23;
        r8.addProperty("image_changed", Boolean.valueOf(r9.booleanValue()));     // Catch: Exception -> L44
    L23:
        if (r19 == null) goto L27;
        Boolean r10 = r19.b();     // Catch: Exception -> L44
        if (r10 == null) goto L27;
        r8.addProperty("viewtree_changed", Boolean.valueOf(r10.booleanValue()));     // Catch: Exception -> L44
    L27:
        if (r19 == null) goto L31;
        Boolean r11 = r19.a();     // Catch: Exception -> L44
        if (r11 == null) goto L31;
        r8.addProperty("activity_changed", Boolean.valueOf(r11.booleanValue()));     // Catch: Exception -> L44
    L31:
        if (r20 == null) goto L33;
        r8.addProperty("top_activity_in_system_animation", Boolean.valueOf(r20.booleanValue()));     // Catch: Exception -> L44
    L33:
        if (r21 == null) goto L36;
        r8.addProperty("is_white_screen", Boolean.valueOf(r21.booleanValue()));     // Catch: Exception -> L44
    L36:
        if (d.h.b.o.a(r18.j(), true) == false) goto L38;
        r8.addProperty("page_scene", "dynamic_surface");     // Catch: Exception -> L44
    L38:
        JsonObject r3 = r17.deepCopy();     // Catch: Exception -> L44
        if (r7 == false) goto L41;
        r3.add("hyper_params", (JsonElement) ZeusTransformUtils.preCheckCast(r8, JsonElement.class, "com.obric.aiagent.plugin"));     // Catch: Exception -> L44
    L42:
        d.h.b.o.a(r3);     // Catch: Exception -> L44
        return new a(r3, true, r4.a(), r4.b(), r15, null, 32, null);
    L41:
        r3.addProperty("hyper_params", r8.toString());     // Catch: Exception -> L44
    L44:
        e = move-exception;
        return a(r17, r15, a(e));
    L17:
        return a(r17, r15, "HyperParamsNotObject");
    L5:
        return a(r17, r15, "HyperParamsMissing");
    }

    private final a a(JsonObject r10, boolean r11, String r12) {
        return new a(r10, false, null, null, r11, r12, 12, null);
    }

    private final String a(Exception r4) {
        CharSequence r3 = (CharSequence) ZeusTransformUtils.preCheckCast(r4.getClass().getSimpleName(), CharSequence.class, "com.obric.aiagent.plugin");
        if (d.o.o.d(r3) == false) goto L6;
        String r5 = r4.getClass().getName();
        d.h.b.o.c(r5, "getName(...)");
        r3 = d.o.o.c(r5, '.', null, 2, null);
    L6:
        return (String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin");
    }
}
