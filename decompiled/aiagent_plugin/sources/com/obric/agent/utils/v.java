package com.obric.agent.utils;

import android.os.PowerManager;
import org.json.JSONObject;

/* JADX INFO: compiled from: ClientPhoneEnvInfo.kt */
/* JADX INFO: loaded from: classes2.dex */
final class v extends c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final v f16077a = null;

    static {
        f16077a = new v();
    }

    private v() {
        super("screen", 1000);
    }

    @Override // com.obric.agent.utils.c
    public void a(JSONObject r1, long r2) {
        d.h.b.o.e(r1, "env");
        JSONObject r0 = new JSONObject();
        PowerManager r3 = a.f15990a.b();
        if (r3 == null) goto L5;
        r0.put("power_save_mode", r3.isPowerSaveMode());
    L5:
        r0.put("on", com.obric.aiagent.utils.a.b.f22307a.a());
        d.x r4 = d.x.f38692a;
        r1.put("screen", r0);
    }
}
