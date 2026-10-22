package com.bytedance.agentrobots.policy;

import org.json.JSONObject;

/* JADX INFO: compiled from: EffectivePolicyResolver.java */
/* JADX INFO: loaded from: classes.dex */
final class a {

    /* JADX INFO: renamed from: com.bytedance.agentrobots.policy.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: EffectivePolicyResolver.java */
    static final class C0103a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final JSONObject f4041a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f4042b;

        private C0103a(JSONObject r1, boolean r2) {
            this.f4041a = r1;
            this.f4042b = r2;
        }

        static C0103a a(JSONObject r2) {
            return new C0103a(r2, false);
        }

        static C0103a a() {
            return new C0103a(null, true);
        }

        JSONObject b() {
            return this.f4041a;
        }

        boolean c() {
            return this.f4042b;
        }
    }

    static C0103a a(JSONObject r2, JSONObject r3) {
        if (r2 == null) goto L4;
        if (r3 != null) goto L7;
    L14:
        JSONObject r4 = r2.optJSONObject("scope");
        if (a(r4) == false) goto L18;
        r4 = r2.optJSONObject("default_policy");
    L18:
        return C0103a.a(r4);
    L7:
        if (r3.optBoolean("bypass_policy", false) == true) goto L9;
        JSONObject r5 = r3.optJSONObject("policy");
        if (r5 == null) goto L14;
        return C0103a.a(r5);
    L9:
        return C0103a.a();
    L4:
        return C0103a.a(null);
    }

    static boolean a(C0103a r2) {
        if (r2 != null) goto L5;
        return false;
    L5:
        if (r2.c() == true) goto L21;
        JSONObject r3 = r2.b();
        if (r3 == null) goto L10;
        JSONObject r4 = r3.optJSONObject("app");
    L11:
        if (r4 != null) goto L13;
        return false;
    L13:
        if (r4.optBoolean("global_disable", false) == false) goto L15;
    L16:
        return true;
    L15:
        if (r4.optBoolean("screenshot_disable", false) == true) goto L16;
        return false;
    L10:
        r4 = null;
        goto L11
    L21:
        return false;
    }

    private static boolean a(JSONObject r1) {
        if (r1 != null) goto L4;
    L11:
        return true;
    L4:
        if (r1.optJSONObject("app") == null) goto L6;
    L10:
        return false;
    L6:
        if (r1.optJSONObject("activities") != null) goto L10;
        if (r1.optJSONObject("agent_intents") != null) goto L10;
        goto L10
    }
}
