package com.bytedance.bdinstall;

import android.content.Context;
import android.text.TextUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;

/* JADX INFO: compiled from: ApiParamsForFlavor.java */
/* JADX INFO: loaded from: classes.dex */
final class e {
    static void a(Context r2, Map<String, String> r3, boolean r4, an r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        Map r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
        if (r5 != null) goto L5;
    L12:
        String r8 = com.bytedance.bdinstall.d.a.a().b();
        if (TextUtils.isEmpty(r8) == true) goto L15;
        r7.put("aliyun_uuid", r8);
    L15:
        if (r4 == false) goto L25;
        String r9 = com.bytedance.bdinstall.oaid.j.a(r6).c();     // Catch: Throwable -> L20
        if (TextUtils.isEmpty(r9) == true) goto L26;
        r7.put("oaid", r9);     // Catch: Throwable -> L20
        return;
    L26:
        return;
    L20:
        th = move-exception;
        th.printStackTrace();
        return;
    L25:
        return;
    L5:
        if (r5.M() == true) goto L12;
        String r0 = com.bytedance.bdinstall.j.q.h(r6, r5);
        if (TextUtils.isEmpty(r0) == true) goto L9;
        r7.put("mac_address", r0);
    L9:
        String r10 = com.bytedance.bdinstall.j.q.a(r6, r5);
        if (ba.b(r10) == true) goto L12;
        r7.put("uuid", r10);
        goto L12
    }

    static void a(Context r3, an r4, StringBuilder r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        if (r4.M() == true) goto L15;
        d.a(r5, "build_serial", com.bytedance.bdinstall.j.q.g(r6, r4));
        if (r4.z() == false) goto L15;
        String[] r7 = com.bytedance.bdinstall.j.q.c(r6, r4);
        if (r7 == null) goto L15;
        if (r7.length <= 0) goto L15;
        String r0 = r7[0];
        int r1 = 1;
    L12:
        if (r1 >= r7.length) goto L14;
        r0 = r0 + "," + r7[r1];
        r1 = r1 + 1;
        goto L12
    L14:
        d.a(r5, "sim_serial_number", r0);
    L15:
        com.bytedance.bdinstall.oaid.j.a(r6).c();
    }

    public static void a(boolean r2, Context r3, an r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        if (r4 != null) goto L5;
        return;
    L5:
        aa r6 = i.a(r4.b());
        if (r6 == null) goto L12;
        boolean r7 = r6.k().b();
        if (r2 == false) goto L13;
        if (r7 == false) goto L14;
        com.bytedance.bdinstall.oaid.j.a(r5).a();
        return;
    L14:
        return;
    L13:
        return;
    }
}
