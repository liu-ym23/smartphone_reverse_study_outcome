package com.bytedance.bdinstall.d;

import com.bytedance.crash.general.RomInfo;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: HarmonyLoader.java */
/* JADX INFO: loaded from: classes.dex */
final class q {
    q() {
    }

    void a(JSONObject r3) {
        boolean r2 = com.bytedance.bdinstall.j.p.D();
        if (r2 == false) goto L6;
        Object r1 = "Harmony";
    L23:
        r3.put(RomInfo.KEY_OS_TYPE, r1);     // Catch: JSONException -> L9
    L11:
        if (r2 == true) goto L13;
        return;
    L13:
        JSONObject r4 = new JSONObject();
        r4.put(RomInfo.KEY_ROM_OS_API, com.bytedance.bdinstall.j.u.a("hw_sc.build.os.apiversion"));     // Catch: Throwable -> L16
        r4.put(RomInfo.KEY_ROM_OS_VERSION, com.bytedance.bdinstall.j.u.a("hw_sc.build.platform.version"));     // Catch: Throwable -> L16
        r4.put("release_type", com.bytedance.bdinstall.j.u.a("hw_sc.build.os.releasetype"));     // Catch: Throwable -> L16
    L25:
        r3.put("harmony", r4);     // Catch: JSONException -> L20
        return;
    L20:
        e = move-exception;
        e.printStackTrace();
        return;
    L16:
        th = move-exception;
        th.printStackTrace();
    L9:
        e = move-exception;
        e.printStackTrace();
        goto L11
    L6:
        r1 = "Android";
        goto L23
    }
}
