package com.ss.android.common.applog;

import android.content.Context;
import android.util.Pair;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ConcurrentModificationException;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: TaskSessionDao.java */
/* JADX INFO: loaded from: classes4.dex */
public class ab {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile ab f37148a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Context f37149b;

    private ab(Context r3) {
        this.f37149b = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin")).getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin");
    }

    public static ab a(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        if (f37148a != null) goto L15;
        monitor-enter(ab.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f37148a != null) goto L9;
        f37148a = new ab(r3);     // Catch: Throwable -> L11
    L9:
        monitor-exit(ab.class);     // Catch: Throwable -> L11
    L15:
        return f37148a;
    }

    public void a(com.ss.android.common.applog.task.d r2) {
        com.ss.android.common.applog.task.d r3 = com.ss.android.common.applog.task.d.a(r2);
        if (r3 == null) goto L8;
        u r0 = new u();
        r0.f37235a = r3;
        a r1 = a.a(this.f37149b);
        if (r1 == null) goto L9;
        r1.a(r0);
        return;
    L9:
        return;
    }

    public Pair<Long, String> a(com.ss.android.common.applog.task.d r7, JSONObject r8) {
        if (r7 != null) goto L5;
        return null;
    L5:
        JSONObject r1 = new JSONObject();
        r1.put("magic_tag", "ss_app_log");     // Catch: Throwable -> L18
        r1.put("header", r8);     // Catch: Throwable -> L18
        JSONArray r9 = new JSONArray();     // Catch: Throwable -> L18
        JSONObject r2 = new JSONObject();     // Catch: Throwable -> L18
        r2.put("datetime", a.a(r7.k()));     // Catch: Throwable -> L18
        r2.put("local_time_ms", System.currentTimeMillis());     // Catch: Throwable -> L18
        r2.put("session_id", r7.f());     // Catch: Throwable -> L18
        r2.put("bg_session", 1);     // Catch: Throwable -> L18
        if (r7.a() == false) goto L10;
        r2.put("from_session", r7.c());     // Catch: Throwable -> L18
    L10:
        if (r7.b() == false) goto L12;
        r2.put("to_session", r7.d());     // Catch: Throwable -> L18
    L12:
        r2.put("duration", r7.j());     // Catch: Throwable -> L18
        r2.put("session_type", r7.g());     // Catch: Throwable -> L18
        r2.put("is_background", false);     // Catch: Throwable -> L18
        a.a(r2);     // Catch: Throwable -> L18
        r9.put(r2);     // Catch: Throwable -> L18
        r1.put("terminate", r9);     // Catch: Throwable -> L18
        com.ss.android.common.util.f.a.c("save task session to db : " + r7.toString());     // Catch: Throwable -> L18
        String r10 = r1.toString();     // Catch: ConcurrentModificationException -> L15 Throwable -> L18
    L16:
        return Pair.create(Long.valueOf(DBHelper.a(this.f37149b).a(r10, 0)), r10);
    L15:
        r10 = r1.toString();     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    public static String a() {
        return a.y();
    }

    public static long b() {
        return a.w();
    }
}
