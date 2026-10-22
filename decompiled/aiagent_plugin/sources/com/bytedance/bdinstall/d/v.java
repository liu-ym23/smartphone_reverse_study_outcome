package com.bytedance.bdinstall.d;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.bdinstall.an;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: OldSpMigrater.java */
/* JADX INFO: loaded from: classes.dex */
class v {
    static void a(Context r2, com.bytedance.bdinstall.u r3, an r4) {
        SharedPreferences r5 = com.bytedance.bdinstall.j.j.a((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin"), r4);
        SharedPreferences r6 = r3.a(r4);
        if (r5.getBoolean("dr_install_migrate", false) == false) goto L5;
        return;
    L5:
        a(r4, r6);
        r5.edit().putBoolean("dr_install_migrate", true).apply();
    }

    private static void a(an r9, SharedPreferences r10) {
        SharedPreferences r11 = (SharedPreferences) ZeusTransformUtils.wrapperContextForParams(r10, SharedPreferences.class, "com.obric.aiagent.plugin");
        SharedPreferences r12 = r9.v();
        String r2 = r12.getString("device_id", null);
        String r4 = r12.getString("bd_did", null);
        String r6 = r12.getString("install_id", null);
        String r13 = r12.getString("ssid", null);
        SharedPreferences.Editor r14 = r11.edit();
        boolean r8 = true;
        if (TextUtils.isEmpty(r2) == true) goto L5;
        r14.putString("device_id", r2);
        boolean r0 = true;
    L7:
        if (TextUtils.isEmpty(r4) == true) goto L10;
        r14.putString("bd_did", r4);
        r0 = true;
    L10:
        if (TextUtils.isEmpty(r6) == true) goto L13;
        r14.putString("install_id", r6);
        r0 = true;
    L13:
        if (TextUtils.isEmpty(r13) == true) goto L15;
        r14.putString("ssid", r13);
    L16:
        if (r8 == false) goto L19;
        r14.apply();
        return;
    L19:
        return;
    L15:
        r8 = r0;
        goto L16
    L5:
        r0 = false;
        goto L7
    }
}
