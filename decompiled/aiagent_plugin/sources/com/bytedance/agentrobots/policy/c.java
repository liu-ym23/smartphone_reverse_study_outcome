package com.bytedance.agentrobots.policy;

import android.content.Context;
import android.util.Log;
import android.util.LruCache;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.nio.charset.StandardCharsets;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: PolicyCacheManager.java */
/* JADX INFO: loaded from: classes.dex */
class c {
    private static final String TAG = "PolicyCacheManager";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final LruCache<String, JSONObject> f4045a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final LruCache<String, byte[]> f4046b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final LocalPolicyRepository f4047c;

    c(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        this.f4045a = new LruCache(100);
        final int r1 = 1048576;
        this.f4046b = new PolicyCacheManager$1(this, r1);
        this.f4047c = new LocalPolicyRepository(r4);
    }

    JSONObject a(String r5) {
        JSONObject r0 = (JSONObject) ZeusTransformUtils.preCheckCast(this.f4045a.get(r5), JSONObject.class, "com.obric.aiagent.plugin");
        if (r0 == null) goto L5;
        return r0;
    L5:
        byte[] r1 = (byte[]) ZeusTransformUtils.preCheckCast(this.f4046b.get(r5), byte[].class, "com.obric.aiagent.plugin");
        if (r1 != null) goto L17;
    L11:
        JSONObject r2 = this.f4047c.find(r5);
        if (r2 == null) goto L15;
        this.f4046b.put(r5, r2.toString().getBytes(StandardCharsets.UTF_8));
        this.f4045a.put(r5, r2);
        return r2;
    L15:
        return null;
    L17:
        JSONObject r3 = new JSONObject(new String(r1, StandardCharsets.UTF_8));     // Catch: JSONException -> L9
        this.f4045a.put(r5, r3);     // Catch: JSONException -> L9
        return r3;
    L9:
        e = move-exception;
        a(TAG, "Error parsing policy from L2 cache", e);
        goto L11
    }

    void a(String r4, JSONObject r5) {
        if (r4 == null) goto L7;
        if (r5 == null) goto L8;
        this.f4045a.put(r4, r5);
        this.f4046b.put(r4, r5.toString().getBytes(StandardCharsets.UTF_8));
        this.f4047c.save(r4, r5);
        return;
    L8:
        return;
    }

    void b(String r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        this.f4045a.remove(r2);
        this.f4046b.remove(r2);
        this.f4047c.delete(r2);
    }

    void a() {
        this.f4045a.evictAll();
        this.f4046b.evictAll();
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r0, String r1, Throwable r2) {
        return Log.e(r0, r1, r2);
    }
}
