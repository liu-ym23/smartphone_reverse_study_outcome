package com.bytedance.applog.f;

import android.text.TextUtils;
import com.bytedance.applog.log.m;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: EventForward.java */
/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f5637a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f5638b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Set<String> f5639c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f5640d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f5641e;
    private int f;
    private String g;

    public a() {
        this.f5637a = 0;
        this.f5638b = 60000;
        this.f5639c = new HashSet();
        this.f = 0;
    }

    public static a a(JSONObject r7) {
        a r0 = new a();
        int r2 = 0;
        r0.a(r7.optInt("version", 0));
        int r1 = r7.optInt("interval", -1);
        if (r1 < 0) goto L5;
        long r3 = ((long) r1) * 1000;
    L6:
        r0.a(r3);
        r0.c(r7.optString("forward_report_path"));
        r0.b(r7.optString("forward_report_host"));
        r0.b(r7.optInt("forward_open", 0));
        JSONArray r8 = r7.optJSONArray("events");
        if (r8 != null) goto L9;
    L11:
        return r0;
    L9:
        if (r2 >= r8.length()) goto L11;
        r0.a(r8.optString(r2));
        r2 = r2 + 1;
        goto L9
    L5:
        r3 = 60000;
        goto L6
    }

    public int a() {
        return this.f5637a;
    }

    public void a(int r1) {
        this.f5637a = r1;
    }

    public long b() {
        return this.f5638b;
    }

    public void a(long r1) {
        this.f5638b = r1;
    }

    public Set<String> c() {
        return this.f5639c;
    }

    public void a(Set<String> r3) {
        Set r4 = (Set) ZeusTransformUtils.wrapperContextForParams(r3, Set.class, "com.obric.aiagent.plugin");
        this.f5639c.addAll(r4);
    }

    public void a(String r1) {
        this.f5639c.add(r1);
    }

    public String d() {
        return this.f5640d;
    }

    public void b(String r1) {
        this.f5640d = r1;
    }

    public String e() {
        return this.f5641e;
    }

    public void c(String r1) {
        this.f5641e = r1;
    }

    public int f() {
        return this.f;
    }

    public void b(int r1) {
        this.f = r1;
    }

    public boolean g() {
        if (this.f == 1) goto L5;
    L13:
        return false;
    L5:
        if (TextUtils.isEmpty(this.f5640d) == true) goto L13;
        if (TextUtils.isEmpty(this.f5641e) == true) goto L13;
        if (this.f5639c.isEmpty() == true) goto L13;
        if (this.f5638b <= 0) goto L13;
        return true;
    }

    public JSONObject h() {
        JSONObject r0 = new JSONObject();
        r0.put("version", a());     // Catch: Throwable -> L9
        r0.put("interval", b());     // Catch: Throwable -> L9
        r0.put("forward_report_path", e());     // Catch: Throwable -> L9
        r0.put("forward_report_host", d());     // Catch: Throwable -> L9
        r0.put("forward_open", f());     // Catch: Throwable -> L9
        JSONArray r1 = new JSONArray();     // Catch: Throwable -> L9
        Iterator<String> r5 = c().iterator();     // Catch: Throwable -> L9
    L5:
        if (r5.hasNext() == false) goto L7;
        r1.put((String) ZeusTransformUtils.preCheckCast(r5.next(), String.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L9
        goto L5
    L7:
        r0.put("events", r1);     // Catch: Throwable -> L9
    L11:
        return r0;
    L9:
        th = move-exception;
        m.a().a("put json object for event forward failed", th, new Object[0]);
        goto L11
    }

    public boolean d(String r1) {
        return this.f5639c.contains(r1);
    }

    public String i() {
        if (f() != 0) goto L5;
    L30:
        return null;
    L5:
        if (TextUtils.isEmpty(d()) == true) goto L30;
        if (TextUtils.isEmpty(this.g) == false) goto L29;
        if (d().startsWith("https://") == true) goto L12;
    L14:
        String r0 = null;
    L16:
        if (TextUtils.isEmpty(r0) == false) goto L20;
        this.g = null;
        return null;
    L20:
        if (TextUtils.isEmpty(e()) == false) goto L22;
    L26:
        String r1 = "/service/2/app_log/";
    L27:
        this.g = r0 + r1;
        goto L29
    L22:
        if (e().startsWith("/") == false) goto L26;
        if (e().endsWith("/") == false) goto L26;
        r1 = e();
        goto L27
    L12:
        if (d().endsWith("/") == true) goto L14;
        r0 = d();
    L29:
        return this.g;
    }

    public boolean equals(Object r5) {
        if (ZeusTransformUtils.instanceOf(r5, a.class) == false) goto L22;
        a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin");
        if (r6.a() == a()) goto L7;
    L19:
        return false;
    L7:
        if (r6.b() != b()) goto L19;
        if (TextUtils.equals(r6.d(), d()) == false) goto L19;
        if (TextUtils.equals(r6.e(), e()) == false) goto L19;
        if (r6.f() != f()) goto L19;
        if (r6.c().containsAll(c()) == false) goto L19;
        if (c().containsAll(r6.c()) == false) goto L19;
        return true;
    L22:
        return super.equals(r5);
    }
}
