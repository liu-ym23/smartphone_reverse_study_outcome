package com.bytedance.agentrobots.b;

import android.util.Log;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SensitiveFieldSanitizer.java */
/* JADX INFO: loaded from: classes.dex */
public final class d {
    private static final String TAG = "SensitiveFieldSanitizer";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final a f4010a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile a f4011b;

    /* JADX INFO: compiled from: SensitiveFieldSanitizer.java */
    public interface a {
        String a(String r1);
    }

    static {
        a r0 = new AnonymousClass1();
        f4010a = r0;
        f4011b = r0;
    }

    public static void a(JSONObject r2, String r3) {
        if (r2 == null) goto L16;
        if (r3 != null) goto L5;
        return;
    L5:
        if (r2.has(r3) == true) goto L7;
        return;
    L7:
        if (r2.isNull(r3) == true) goto L19;
        r2.put(r3, a(r2.opt(r3)));     // Catch: Exception -> L11
        return;
    L11:
        e = move-exception;
        a(TAG, "sanitizeField failed for " + r3, e);
        return;
    L19:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v3, types: [org.json.JSONObject] */
    public static Object a(Object r5) {
        if (r5 != 0) goto L6;
        return null;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, String.class) == false) goto L10;
        return f4011b.a((String) ZeusTransformUtils.preCheckCast(r5, String.class, "com.obric.aiagent.plugin"));
    L10:
        if (ZeusTransformUtils.instanceOf(r5, JSONArray.class) == false) goto L18;
        JSONArray r6 = (JSONArray) ZeusTransformUtils.preCheckCast(r5, JSONArray.class, "com.obric.aiagent.plugin");
        int r0 = 0;
    L13:
        if (r0 >= r6.length()) goto L16;
        r6.put(r0, a(r6.opt(r0)));     // Catch: JSONException -> L30
    L15:
        r0 = r0 + 1;
        goto L13
    L16:
        return r6;
    L18:
        if (ZeusTransformUtils.instanceOf(r5, JSONObject.class) == false) goto L29;
        r5 = (JSONObject) ZeusTransformUtils.preCheckCast(r5, JSONObject.class, "com.obric.aiagent.plugin");
        Iterator<String> r1 = r5.keys();
        ArrayList r2 = new ArrayList();
    L21:
        if (r1.hasNext() == false) goto L23;
        r2.add((String) ZeusTransformUtils.preCheckCast(r1.next(), String.class, "com.obric.aiagent.plugin"));
        goto L21
    L23:
        Iterator r3 = r2.iterator();
    L25:
        if (r3.hasNext() == false) goto L29;
        String r4 = (String) ZeusTransformUtils.preCheckCast(r3.next(), String.class, "com.obric.aiagent.plugin");
        r5.put(r4, a(r5.opt(r4)));     // Catch: Exception -> L31
    L29:
        return r5;
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r1, String r2, Throwable r3) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.w(r1, r2, r3);
    }
}
