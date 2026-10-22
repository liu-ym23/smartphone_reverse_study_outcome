package com.obric.agent.intents.music.netease;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import org.json.JSONObject;
import org.json.JSONTokener;

/* JADX INFO: compiled from: UiEncryptHelper.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final n f14847a = null;

    static {
        f14847a = new n();
    }

    private n() {
    }

    public final String a() {
        String r2 = String.valueOf(System.currentTimeMillis());
        return j.f14836a.a(r2);
    }

    public final h a(String r4) {
        o.e(r4, "tokenSign");
        String r3 = j.f14836a.b(r4);
        h r5 = new h();
        if (r3 == null) goto L7;
        Object r6 = new JSONTokener(r3).nextValue();
        o.a(r6, "null cannot be cast to non-null type org.json.JSONObject");
        JSONObject r7 = (JSONObject) ZeusTransformUtils.preCheckCast(r6, JSONObject.class, "com.obric.aiagent.plugin");
        String r0 = r7.getString("sign");
        String r1 = r7.getString("ts");
        if (j.f14836a.a(r0, r1) == false) goto L7;
        String r2 = r7.getString("token");
        String r8 = r7.getString("expireTime");
        o.a(r2);
        r5.a(r2);
        o.a(r8);
        r5.b(r8);
    L7:
        return r5;
    }
}
