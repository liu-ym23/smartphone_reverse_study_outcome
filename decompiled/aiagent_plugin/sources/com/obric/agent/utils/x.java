package com.obric.agent.utils;

import com.obric.autogui.common.api.AOThermalManager;
import com.obric.autogui.common.api.platform.thermal.IAutoActionThermalStateApi;
import org.json.JSONObject;

/* JADX INFO: compiled from: ClientPhoneEnvInfo.kt */
/* JADX INFO: loaded from: classes2.dex */
final class x extends c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final x f16079a = null;

    static {
        f16079a = new x();
    }

    private x() {
        super("thermal", 10000);
    }

    @Override // com.obric.agent.utils.c
    public void a(JSONObject r1, long r2) {
        d.h.b.o.e(r1, "env");
        IAutoActionThermalStateApi.ThermalLevelState r0 = AOThermalManager.INSTANCE.getThermalLevelState();
        if (r0 == null) goto L6;
        JSONObject r3 = new JSONObject();
        r3.put("level", r0.getLevel().name());
        d.x r4 = d.x.f38692a;
        r1.put("thermal", r3);
        return;
    }
}
