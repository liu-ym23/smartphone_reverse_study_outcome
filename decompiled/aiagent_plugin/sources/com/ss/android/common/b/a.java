package com.ss.android.common.b;

import com.ss.android.common.applog.TeaThread;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONObject;

/* JADX INFO: compiled from: AppLogNewUtils.java */
/* JADX INFO: loaded from: classes4.dex */
public class a {
    public static void a(String r0, JSONObject r1) {
        b(r0, a(r1));
    }

    public static void b(final String r4, final JSONObject r5) {
        final long r0 = System.currentTimeMillis();
        TeaThread.getInst().ensureTeaThreadLite(new AnonymousClass1(r4, r5, r0));
    }

    public static JSONObject a(JSONObject r4) {
        if (r4 != null) goto L5;
        return null;
    L5:
        LinkedList r0 = new LinkedList();
        Iterator<String> r1 = r4.keys();
    L7:
        if (r1.hasNext() == false) goto L14;
        r0.add(r1.next());
        goto L7
    L14:
        return new JSONObject(r4, (String[]) ZeusTransformUtils.preCheckCast(r0.toArray(new String[0]), String[].class, "com.obric.aiagent.plugin"));
    L11:
        e = move-exception;
        e.printStackTrace();
        return r4;
    }
}
