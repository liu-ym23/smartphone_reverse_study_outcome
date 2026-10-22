package com.bytedance.android.gamecp.common.download;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
import wu.n0;

/* JADX INFO: loaded from: classes44.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final JSONObject f56527a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public JSONObject f56528b;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final i f56529a = null;

        static {
            f56529a = new i();
        }
    }

    public i() {
        String r100 = n0.f561354a.getValue();
        if (TextUtils.isEmpty(r100) == true) goto L11;
        JSONObject r101 = new JSONObject(r100);     // Catch: JSONException -> L6
        this.f56527a = r101;     // Catch: JSONException -> L6
        com.bytedance.android.gamecp.host_api.a.b().getHostContext().getAppContext().getSharedPreferences("sp_gamecp_game_config", 0).edit().putString("gamecp_game_config", r101.toString()).apply();     // Catch: JSONException -> L6
        return;
    L6:
        e = move-exception;
        yr.c.b("GameCenterSettings", e.getMessage());
        return;
    }
}
