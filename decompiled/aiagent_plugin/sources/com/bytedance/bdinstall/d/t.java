package com.bytedance.bdinstall.d;

import android.content.Context;
import android.content.SharedPreferences;
import com.bytedance.bdinstall.an;
import com.bytedance.bdinstall.ba;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: MigrateClear.java */
/* JADX INFO: loaded from: classes.dex */
final class t {
    public static void a(Context r9, an r10, com.bytedance.bdinstall.u r11) {
        Context r12 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        com.bytedance.bdinstall.j.f.a(r12, r10);
        ba.a(r10.v(), new String[]{"device_id", "bd_did", "install_id", "device_token"});
        if (r11 == null) goto L13;
        SharedPreferences r13 = r11.a(r10);
        if (r13 == null) goto L13;
        ba.a(r13, new String[]{"device_id", "bd_did", "install_id", "device_token"});
    L13:
        ba.a(r12.getSharedPreferences("snssdk_openudid", 0), new String[]{"clientudid", "openudid", "serial_number"});     // Catch: Exception -> L9
    L11:
        ba.a(com.bytedance.bdinstall.j.j.a(r12, r10), new String[]{"clientudid", "openudid", "serial_number"});
        com.bytedance.bdinstall.n.a(r12, r10);
        com.bytedance.bdinstall.oaid.j.a(r12).f();
        return;
    L9:
        e = move-exception;
        e.printStackTrace();
        goto L11
    }
}
