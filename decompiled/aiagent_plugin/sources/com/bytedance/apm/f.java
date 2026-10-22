package com.bytedance.apm;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: CommonParams.java */
/* JADX INFO: loaded from: classes.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f4595a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f4596b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f4597c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f4598d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f4599e;
    private String f;
    private int g;
    private int h;
    private String i;
    private String j;
    private JSONObject k;
    private Map<String, String> l;

    public f() {
    }

    public int a() {
        return this.f4595a;
    }

    public void a(int r1) {
        this.f4595a = r1;
    }

    public String b() {
        return this.f4596b;
    }

    public void a(String r1) {
        this.f4596b = r1;
    }

    public long c() {
        if (c.r() != null) goto L5;
        return 0;
    L5:
        return c.r().c();
    }

    public String d() {
        if (c.r() != null) goto L5;
        return null;
    L5:
        return c.r().b();
    }

    public void b(String r1) {
        this.f4597c = r1;
    }

    public String e() {
        return this.f4598d;
    }

    public void c(String r1) {
        this.f4598d = r1;
    }

    public int f() {
        return this.f4599e;
    }

    public void b(int r1) {
        this.f4599e = r1;
    }

    public String g() {
        return this.f;
    }

    public void d(String r1) {
        this.f = r1;
    }

    public int h() {
        return this.g;
    }

    public void c(int r1) {
        this.g = r1;
    }

    public void d(int r1) {
        this.h = r1;
    }

    public String i() {
        return this.i;
    }

    public void e(String r1) {
        this.i = r1;
    }

    public String j() {
        return this.j;
    }

    public void f(String r1) {
        this.j = r1;
    }

    public JSONObject k() {
        return this.k;
    }

    public void a(JSONObject r1) {
        this.k = r1;
    }

    public Map<String, String> l() {
        return this.l;
    }

    public void a(Map<String, String> r3) {
        this.l = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
    }
}
