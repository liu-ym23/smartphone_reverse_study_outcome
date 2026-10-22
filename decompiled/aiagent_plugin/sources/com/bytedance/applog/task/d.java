package com.bytedance.applog.task;

import android.text.TextUtils;
import com.bytedance.applog.engine.e;
import com.bytedance.applog.log.m;
import com.bytedance.applog.util.p;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: TaskSession.java */
/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f6022a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f6023b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f6024c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f6025d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f6026e;
    private String f;
    private long g;
    private long h;
    private long i;

    public boolean a() {
        return !TextUtils.isEmpty(this.f6025d);
    }

    public boolean b() {
        return !TextUtils.isEmpty(this.f);
    }

    public String c() {
        return this.f6025d;
    }

    public String d() {
        return this.f;
    }

    public String e() {
        JSONObject r0 = new JSONObject();
        r0.put("start_time", this.f6022a);     // Catch: JSONException -> L5
        r0.put("session_id", this.f6023b);     // Catch: JSONException -> L5
        r0.put("is_front_continuous", this.f6024c);     // Catch: JSONException -> L5
        r0.put("front_session_id", this.f6025d);     // Catch: JSONException -> L5
        r0.put("is_end_continuous", this.f6026e);     // Catch: JSONException -> L5
        r0.put("end_session_id", this.f);     // Catch: JSONException -> L5
        r0.put("latest_end_time", this.g);     // Catch: JSONException -> L5
        r0.put("non_task_time", this.h);     // Catch: JSONException -> L5
        r0.put("tea_event_index", this.i);     // Catch: JSONException -> L5
        return r0.toString();
    L5:
        e = move-exception;
        e.printStackTrace();
        return "";
    }

    public static d a(String r7) {
        if (TextUtils.isEmpty(r7) == false) goto L11;
        return null;
    L11:
        JSONObject r3 = new JSONObject(r7);     // Catch: Throwable -> L8
        String r8 = r3.optString("session_id", "");     // Catch: Throwable -> L8
        d r4 = new d();     // Catch: Throwable -> L8
        r4.f6023b = r8;     // Catch: Throwable -> L8
        r4.f6022a = p.a(r3, "start_time");     // Catch: Throwable -> L8
        r4.f6024c = r3.optBoolean("is_front_continuous", false);     // Catch: Throwable -> L8
        r4.f6025d = r3.optString("front_session_id", "");     // Catch: Throwable -> L8
        r4.f6026e = r3.optBoolean("is_end_continuous", false);     // Catch: Throwable -> L8
        r4.f = r3.optString("end_session_id", "");     // Catch: Throwable -> L8
        r4.g = p.a(r3, "latest_end_time");     // Catch: Throwable -> L8
        r4.h = p.a(r3, "non_task_time");     // Catch: Throwable -> L8
        r4.i = p.a(r3, "tea_event_index");     // Catch: Throwable -> L8
        return r4;
    L8:
        th = move-exception;
        m.a().a("[Task] get session from string failed", th, new Object[0]);
        return null;
    }

    private d() {
        this.f6024c = false;
        this.f6025d = null;
        this.f6026e = false;
        this.f = null;
        this.h = 0;
        this.i = 0;
    }

    public d(long r3, long r5) {
        this.f6024c = false;
        this.f6025d = null;
        this.f6026e = false;
        this.f = null;
        this.h = 0;
        this.i = 0;
        this.f6022a = r3;
        this.f6023b = e.a();
        this.i = r5;
    }

    public String f() {
        return this.f6023b;
    }

    public int g() {
        boolean r0 = this.f6024c;
        boolean r1 = this.f6026e;
        if (r0 == true) goto L7;
        if (r1 == true) goto L7;
        return 1;
    L7:
        if (r0 == false) goto L11;
        if (r1 == true) goto L11;
        return 2;
    L11:
        if (r0 == true) goto L14;
        return 3;
    L14:
        return 4;
    }

    public void b(String r2) {
        this.f6024c = true;
        this.f6025d = r2;
    }

    public void c(String r2) {
        this.f6026e = true;
        this.f = r2;
    }

    public void a(long r1) {
        this.g = r1;
    }

    public long h() {
        return this.g;
    }

    public void b(long r3) {
        this.h += r3;
    }

    public long i() {
        return Math.max(0, (this.g - this.f6022a) - this.h);
    }

    public String toString() {
        return e();
    }

    public long j() {
        return this.f6022a;
    }
}
