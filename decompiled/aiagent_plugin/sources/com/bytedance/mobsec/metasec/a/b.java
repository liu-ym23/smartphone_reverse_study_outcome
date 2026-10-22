package com.bytedance.mobsec.metasec.a;

import android.content.Context;
import android.text.TextUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class b {
    protected static String LIBNAME;

    public b() {
    }

    public static synchronized void a(Context r7, int r8, Map<String, String> r9) {
        monitor-enter(b.class);
        Context r10 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L18
        Map r11 = (Map) ZeusTransformUtils.wrapperContextForParams(r9, Map.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L18
        f.a(r10, LIBNAME);     // Catch: Throwable -> L18
        ArrayList r12 = new ArrayList();     // Catch: Throwable -> L18
        String[] r1 = null;
        if (r11 == null) goto L15;
        Iterator r13 = r11.entrySet().iterator();     // Catch: Throwable -> L18
    L8:
        if (r13.hasNext() == false) goto L14;
        Map.Entry r2 = (Map.Entry) ZeusTransformUtils.preCheckCast(r13.next(), Map.Entry.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L18
        String r3 = (String) ZeusTransformUtils.preCheckCast(r2.getKey(), String.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L18
        String r4 = (String) ZeusTransformUtils.preCheckCast(r2.getValue(), String.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L18
        if (TextUtils.isEmpty(r3) == true) goto L8;
        if (TextUtils.isEmpty(r4) == true) goto L8;
        r12.add(r3);     // Catch: Throwable -> L18
        r12.add(r4);     // Catch: Throwable -> L18
        goto L8
    L14:
        r1 = (String[]) ZeusTransformUtils.preCheckCast(r12.toArray(new String[0]), String[].class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L18
    L15:
        com.bytedance.mobsec.matrix.a.a(83886081, r8, 0, null, r1);     // Catch: Throwable -> L18
        monitor-exit(b.class);
        return;
    L18:
        th = move-exception;
        throw th;
    }
}
