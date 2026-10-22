package com.bytedance.dataplatform;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: compiled from: CacheRepository.java */
/* JADX INFO: loaded from: classes.dex */
public class a {
    static /* synthetic */ SharedPreferences b(Context r2, String r3) {
        return c((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin"), r3);
    }

    private static SharedPreferences c(Context r4, String r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        return r6.getSharedPreferences(r5, 0);
    L6:
        if (Build.VERSION.SDK_INT < 24) goto L10;
        return ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r6.createDeviceProtectedStorageContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getSharedPreferences(r5, 0);
    L10:
        throw new RuntimeException("abtest SharedPreferences :" + r5);
    }

    public static Map<String, Integer> a(Context r4, String r5) {
        SharedPreferences r6 = c((Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin"), r5);
        ConcurrentHashMap r7 = new ConcurrentHashMap();
        Iterator<Map.Entry<String, ?>> r8 = r6.getAll().entrySet().iterator();
    L4:
        if (r8.hasNext() == false) goto L8;
        Map.Entry r0 = (Map.Entry) ZeusTransformUtils.preCheckCast(r8.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r0.getValue(), Integer.class) == false) goto L4;
        r7.put(r0.getKey(), (Integer) ZeusTransformUtils.preCheckCast(r0.getValue(), Integer.class, "com.obric.aiagent.plugin"));
        goto L4
    L8:
        return r7;
    }

    public static void a(Context r2, final String r3, final String r4, final JSONObject r5) {
        final Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        m.a(new AnonymousClass1(r6, r3, r4, r5));
    }

    public static void a(Context r2, final String r3, final String r4, final int r5) {
        final Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        m.a(new AnonymousClass2(r6, r3, r4, r5));
    }

    public static void a(Context r2, final String r3, final String r4, Set<String> r5) {
        final Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        final Set r7 = (Set) ZeusTransformUtils.wrapperContextForParams(r5, Set.class, "com.obric.aiagent.plugin");
        m.a(new AnonymousClass3(r6, r3, r4, r7));
    }

    public static void a(Context r2, final String r3, final String r4, final String r5) {
        final Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        m.a(new AnonymousClass4(r5, r6, r3, r4));
    }

    public static void a(Context r2, final String r3, Map<String, String> r4) {
        final Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        final Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.aiagent.plugin");
        m.a(new AnonymousClass5(r5, r3, r6));
    }

    public static void a(Context r2, final String r3, final String r4) {
        final Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        m.a(new AnonymousClass6(r5, r3, r4));
    }
}
