package com.ss.android.common.applog.task;

import android.text.TextUtils;
import com.ss.android.common.applog.ab;
import com.ss.android.common.applog.ad;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: TaskSession.java */
/* JADX INFO: loaded from: classes4.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f37230a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f37231b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f37232c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f37233d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f37234e;
    private String f;
    private long g;
    private long h;
    private long i;

    public boolean a() {
        return !TextUtils.isEmpty(this.f37233d);
    }

    public boolean b() {
        return !TextUtils.isEmpty(this.f);
    }

    public String c() {
        return this.f37233d;
    }

    public String d() {
        return this.f;
    }

    public static d a(d r3) {
        if (r3 != null) goto L5;
        return null;
    L5:
        d r0 = new d();
        r0.f37230a = r3.f37230a;
        r0.f37231b = r3.f37231b;
        r0.f37232c = r3.f37232c;
        r0.f37233d = r3.f37233d;
        r0.f37234e = r3.f37234e;
        r0.f = r3.f;
        r0.g = r3.g;
        r0.h = r3.h;
        r0.i = r3.i;
        return r0;
    }

    public String e() {
        JSONObject r0 = new JSONObject();
        r0.put("start_time", this.f37230a);     // Catch: JSONException -> L5
        r0.put("session_id", this.f37231b);     // Catch: JSONException -> L5
        r0.put("is_front_continuous", this.f37232c);     // Catch: JSONException -> L5
        r0.put("front_session_id", this.f37233d);     // Catch: JSONException -> L5
        r0.put("is_end_continuous", this.f37234e);     // Catch: JSONException -> L5
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

    public static d a(String r6) {
        if (TextUtils.isEmpty(r6) == false) goto L10;
        return null;
    L10:
        JSONObject r1 = new JSONObject(r6);     // Catch: JSONException -> L7
        String r7 = r1.optString("session_id", "");     // Catch: JSONException -> L7
        d r3 = new d();     // Catch: JSONException -> L7
        r3.f37231b = r7;     // Catch: JSONException -> L7
        r3.f37230a = ad.a(r1, "start_time");     // Catch: JSONException -> L7
        r3.f37232c = r1.optBoolean("is_front_continuous", false);     // Catch: JSONException -> L7
        r3.f37233d = r1.optString("front_session_id", "");     // Catch: JSONException -> L7
        r3.f37234e = r1.optBoolean("is_end_continuous", false);     // Catch: JSONException -> L7
        r3.f = r1.optString("end_session_id", "");     // Catch: JSONException -> L7
        r3.g = ad.a(r1, "latest_end_time");     // Catch: JSONException -> L7
        r3.h = ad.a(r1, "non_task_time");     // Catch: JSONException -> L7
        r3.i = ad.a(r1, "tea_event_index");     // Catch: JSONException -> L7
        return r3;
    L7:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    private d() {
        this.f37232c = false;
        this.f37233d = null;
        this.f37234e = false;
        this.f = null;
        this.h = 0;
        this.i = 0;
    }

    public d(long r3) {
        this.f37232c = false;
        this.f37233d = null;
        this.f37234e = false;
        this.f = null;
        this.h = 0;
        this.i = 0;
        this.f37230a = r3;
        this.f37231b = ab.a();
        this.i = ab.b();
    }

    public String f() {
        return this.f37231b;
    }

    public int g() {
        boolean r0 = this.f37232c;
        boolean r1 = this.f37234e;
        if (r0 == true) goto L7;
        if (r1 == true) goto L7;
        return 1;
    L7:
        if (r0 == false) goto L11;
        if (r1 == true) goto L11;
        return 2;
    L11:
        if (r0 == true) goto L15;
        if (r1 == false) goto L17;
        return 3;
    L17:
        return 4;
    L15:
        return 4;
    }

    public void b(String r2) {
        this.f37232c = true;
        this.f37233d = r2;
    }

    public void c(String r2) {
        this.f37234e = true;
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
        return Math.max(0, (this.g - this.f37230a) - this.h);
    }

    public long j() {
        return Math.max(1, i() / 1000);
    }

    public String toString() {
        return e();
    }

    public long k() {
        return this.f37230a;
    }
}
