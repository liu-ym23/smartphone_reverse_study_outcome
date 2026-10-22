package com.bytedance.reparo.core.a.a;

import android.os.SystemClock;
import com.bytedance.reparo.core.a.b.e;
import com.bytedance.reparo.core.a.b.f;
import com.bytedance.reparo.core.b.d;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: Event.java */
/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile String f9146a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile Boolean f9147b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f9148c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f9149d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f9150e;
    private String f;
    private long g;
    private long h;
    private boolean i;
    private boolean j;
    private int k;
    private d l;
    private String m;
    private String n;
    private HashMap<String, Object> o;
    private HashMap<String, Object> p;
    private HashMap<String, Object> q;
    private b r;

    private String b(int r1) {
        if (r1 != 0) goto L6;
        return "msg";
    L6:
        if (r1 != 1) goto L10;
        return "error_msg";
    L10:
        if (r1 != 2) goto L13;
        return "error_exception";
    L13:
        return "";
    }

    public a() {
        this.f9148c = "";
        this.f9149d = 0;
        this.f9150e = "";
        this.f = "";
        this.g = -1;
        this.h = -1;
        this.i = false;
        this.j = true;
        this.k = 0;
        this.l = null;
        this.m = "";
        this.n = "";
        this.r = null;
        this.h = SystemClock.elapsedRealtime();
    }

    public a a(int r1) {
        this.f9149d = r1;
        return this;
    }

    public a a(String r1) {
        this.f9148c = r1;
        return this;
    }

    public a b(String r1) {
        this.f9150e = r1;
        return this;
    }

    public String a() {
        return this.f9150e;
    }

    public a a(long r1) {
        this.g = r1;
        return this;
    }

    public a b() {
        this.i = true;
        return this;
    }

    public a a(boolean r1) {
        this.j = r1;
        return this;
    }

    public a c(String r1) {
        this.m = r1;
        return this;
    }

    public a a(d r1) {
        this.l = r1;
        this.k = r1.a();
        return this;
    }

    public d c() {
        return this.l;
    }

    public a a(String r2, Object r3) {
        j().put(r2, r3);
        return this;
    }

    public a b(String r2, Object r3) {
        m().put(r2, r3);
        return this;
    }

    public a a(b r3) {
        this.r = (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.aiagent.plugin");
        return this;
    }

    public void d() {
        if (this.r != null) goto L6;
        return;
    L6:
        if (this.i == true) goto L8;
    L12:
        this.r.a(this);
        return;
    L8:
        if (this.g == (-1)) goto L12;
        if (this.h != (-1)) goto L12;
        this.h = SystemClock.elapsedRealtime();
        goto L12
    }

    public JSONObject e() {
        JSONObject r0 = new JSONObject();
        if (this.i == false) goto L7;
        long r1 = this.g;
        if (r1 == (-1)) goto L7;
        r0.putOpt("duration", Long.valueOf(this.h - r1));
    L7:
        HashMap<String, Object> r2 = this.o;
        if (r2 != null) goto L10;
    L16:
        return r0;
    L10:
        if (r2.size() == 0) goto L16;
        Iterator<Map.Entry<String, Object>> r5 = this.o.entrySet().iterator();
    L14:
        if (r5.hasNext() == false) goto L16;
        Map.Entry r3 = (Map.Entry) ZeusTransformUtils.preCheckCast(r5.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        r0.putOpt((String) ZeusTransformUtils.preCheckCast(r3.getKey(), String.class, "com.obric.aiagent.plugin"), r3.getValue());
        goto L14
    }

    public JSONObject f() {
        JSONObject r0 = new JSONObject();
        r0.putOpt("is_success", Boolean.valueOf(this.j));
        r0.putOpt("is_main_process", e.a(f9147b));
        HashMap<String, Object> r1 = this.p;
        if (r1 != null) goto L5;
    L11:
        return r0;
    L5:
        if (r1.size() == 0) goto L11;
        Iterator<Map.Entry<String, Object>> r5 = this.p.entrySet().iterator();
    L9:
        if (r5.hasNext() == false) goto L11;
        Map.Entry r2 = (Map.Entry) ZeusTransformUtils.preCheckCast(r5.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        r0.putOpt((String) ZeusTransformUtils.preCheckCast(r2.getKey(), String.class, "com.obric.aiagent.plugin"), r2.getValue());
        goto L9
    }

    public JSONObject g() {
        JSONObject r0 = new JSONObject();
        r0.putOpt("process_name", e.a(f9146a));
        r0.putOpt("tag", e.a(this.f9148c));
        r0.putOpt("step", e.a(this.f9150e));
        r0.putOpt("step_desc", e.a(this.f));
        long r1 = this.g;
        Object r6 = "";
        if (r1 != (-1)) goto L5;
        Object r2 = "";
    L6:
        r0.putOpt("start_time", r2);
        long r3 = this.h;
        if (r3 == (-1)) goto L10;
        r6 = Long.valueOf(r3);
    L10:
        r0.putOpt("end_time", r6);
        int r4 = this.f9149d;
        if (r4 != 2) goto L14;
        r0.putOpt("error_msg", f.a(this.l));
    L18:
        HashMap<String, Object> r5 = this.q;
        if (r5 != null) goto L21;
    L27:
        return r0;
    L21:
        if (r5.size() == 0) goto L27;
        Iterator<Map.Entry<String, Object>> r7 = this.q.entrySet().iterator();
    L25:
        if (r7.hasNext() == false) goto L27;
        Map.Entry r8 = (Map.Entry) ZeusTransformUtils.preCheckCast(r7.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        r0.putOpt((String) ZeusTransformUtils.preCheckCast(r8.getKey(), String.class, "com.obric.aiagent.plugin"), r8.getValue());
        goto L25
    L14:
        if (r4 != 1) goto L16;
        r0.putOpt("error_msg", e.a(this.n));
        goto L18
    L16:
        if (r4 != 0) goto L18;
        r0.putOpt("msg", e.a(this.m));
        goto L18
    L5:
        r2 = Long.valueOf(r1);
        goto L6
    }

    public long h() {
        if (this.i == true) goto L5;
    L11:
        return -1;
    L5:
        if (this.g == (-1)) goto L11;
        if (this.h != (-1)) goto L10;
        this.h = SystemClock.elapsedRealtime();
    L10:
        return this.h - this.g;
    }

    public String i() {
        int r0 = this.f9149d;
        if (r0 != 2) goto L7;
        return f.a(this.l);
    L7:
        if (r0 == 1) goto L9;
        return "";
    L9:
        return e.a(this.n);
    }

    public HashMap<String, Object> j() {
        if (this.o != null) goto L6;
        this.o = new HashMap();
    L6:
        return this.o;
    }

    public boolean k() {
        return this.j;
    }

    public int l() {
        if (this.j == false) goto L6;
        return 1;
    L6:
        return this.k;
    }

    public HashMap<String, Object> m() {
        if (this.p != null) goto L6;
        this.p = new HashMap();
    L6:
        return this.p;
    }

    public HashMap<String, Object> n() {
        if (this.q != null) goto L6;
        this.q = new HashMap();
    L6:
        return this.q;
    }

    public static void a(String r0, boolean r1) {
        f9146a = r0;
        f9147b = Boolean.valueOf(r1);
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append("{    \n");
        a(r0, "tag", this.f9148c, false);
        a(r0, "event_type", b(this.f9149d), false);
        a(r0, "step", this.f9150e, false);
        a(r0, "step_desc", this.f, false);
        a(r0, "start_time", Long.valueOf(this.g), false);
        a(r0, "end_time", Long.valueOf(this.h), false);
        a(r0, "collectDuration", Boolean.valueOf(this.i), false);
        a(r0, "is_success", Boolean.valueOf(this.j), false);
        a(r0, "msg", this.m, false);
        a(r0, "error_msg", this.n, false);
        a(r0, "metrics_map", this.o, false);
        a(r0, "category_map", this.p, false);
        a(r0, "extra_map", this.q, false);
        a(r0, "exception", this.l, true);
        r0.append("}");
        return r0.toString();
    }

    private void a(StringBuilder r2, String r3, Object r4, boolean r5) {
        r2.append("\"").append(r3).append("\"").append(":").append("\"").append(r4).append("\"");
        if (r5 == false) goto L5;
        r2.append("\n");
        return;
    L5:
        r2.append(",\n");
    }
}
