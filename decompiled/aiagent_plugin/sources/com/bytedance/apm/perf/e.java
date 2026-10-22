package com.bytedance.apm.perf;

import android.text.TextUtils;
import com.bytedance.apm.core.ActivityLifeObserver;
import com.bytedance.apm.util.j;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: PerfFilterManager.java */
/* JADX INFO: loaded from: classes.dex */
public class e {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile e f4797c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private CopyOnWriteArraySet<String> f4798a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ConcurrentHashMap<String, String> f4799b;

    private e() {
        this.f4798a = new CopyOnWriteArraySet();
        this.f4799b = new ConcurrentHashMap();
    }

    public static e a() {
        if (f4797c != null) goto L15;
        monitor-enter(e.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f4797c != null) goto L9;
        f4797c = new e();     // Catch: Throwable -> L11
    L9:
        monitor-exit(e.class);     // Catch: Throwable -> L11
    L15:
        return f4797c;
    }

    public void a(String r1, String r2) {
        this.f4799b.put(r1, r2);
    }

    public JSONObject a(boolean r6) {
        JSONObject r1 = new JSONObject();
        Iterator<Map.Entry<String, String>> r5 = this.f4799b.entrySet().iterator();     // Catch: JSONException -> L10
    L5:
        if (r5.hasNext() == false) goto L7;
        Map.Entry r2 = (Map.Entry) ZeusTransformUtils.preCheckCast(r5.next(), Map.Entry.class, "com.obric.aiagent.plugin");     // Catch: JSONException -> L10
        r1.put((String) ZeusTransformUtils.preCheckCast(r2.getKey(), String.class, "com.obric.aiagent.plugin"), r2.getValue());     // Catch: JSONException -> L10
        goto L5
    L7:
        if (r6 == false) goto L9;
        com.bytedance.apm.util.d.a().e(r1);     // Catch: JSONException -> L10
        com.bytedance.apm.util.d.a().f(r1);     // Catch: JSONException -> L10
    L9:
        return r1;
    }

    public String b() {
        String r1 = j.a(this.f4798a.toArray(), "#");
        if (TextUtils.isEmpty(r1) == true) goto L5;
        return r1;
    L5:
        return ActivityLifeObserver.getInstance().getTopActivityClassName();
    }
}
