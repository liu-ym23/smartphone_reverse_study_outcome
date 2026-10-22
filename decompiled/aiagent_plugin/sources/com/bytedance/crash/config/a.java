package com.bytedance.crash.config;

import android.content.Context;
import com.bytedance.crash.i;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

/* JADX INFO: compiled from: BitsConfig.java */
/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile a f7279a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map<String, Object> f7280b;

    private static a c() {
        if (f7279a != null) goto L6;
        f7279a = new a();
    L6:
        return f7279a;
    }

    a() {
        this.f7280b = new HashMap();
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(i.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L5;
        return;
    L5:
        Properties r2 = new Properties();
        r2.load(r0.getAssets().open("slardar.properties"));     // Catch: Exception -> L12
        Iterator r1 = r2.entrySet().iterator();     // Catch: Exception -> L12
    L8:
        if (r1.hasNext() == false) goto L17;
        Map.Entry r3 = (Map.Entry) ZeusTransformUtils.preCheckCast(r1.next(), Map.Entry.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L12
        this.f7280b.put(String.valueOf(r3.getKey()), r3.getValue());     // Catch: Exception -> L12
    L17:
        return;
    }

    public static Map<String, Object> a() {
        return c().f7280b;
    }

    public static String b() {
        Object r0 = a().get("release_build");
        if (r0 == null) goto L7;
        String r1 = String.valueOf(r0);
        if (r1.length() < 16) goto L9;
        return r1;
    L9:
        return "invalid";
    L7:
        return "invalid";
    }
}
