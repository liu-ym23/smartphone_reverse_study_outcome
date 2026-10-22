package com.c.a.h.b;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: compiled from: FileUploadInfo.java */
/* JADX INFO: loaded from: classes.dex */
public class a extends b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected String f11939a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected com.c.a.h.a.a f11940b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected boolean f11941c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected boolean f11942d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected boolean f11943e;
    protected boolean f;
    protected boolean g;
    private List<String> o;

    public a(String r7, long r8, boolean r10, String r11, com.c.a.h.a.a r12, HashMap<String, String> r13) {
        com.c.a.h.a.a r14 = (com.c.a.h.a.a) ZeusTransformUtils.wrapperContextForParams(r12, com.c.a.h.a.a.class, "com.obric.aiagent.plugin");
        super(r8, r10, r11, r13);
        this.f11941c = true;
        this.f11942d = true;
        this.f11943e = true;
        this.f = false;
        this.g = false;
        this.f11939a = r7;
        this.f11940b = r14;
    }

    public String a() {
        return this.f11939a;
    }

    public com.c.a.h.a.a b() {
        return this.f11940b;
    }

    public boolean c() {
        return this.f11941c;
    }

    public boolean d() {
        return this.f11942d;
    }

    public void a(boolean r1) {
        this.f11942d = r1;
    }

    public boolean e() {
        return this.f11943e;
    }

    public boolean f() {
        return this.f;
    }

    public void b(boolean r1) {
        this.f = r1;
    }

    public List<String> g() {
        return this.o;
    }

    public void a(List<String> r3) {
        this.o = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
    }

    public boolean h() {
        return this.g;
    }

    public void c(boolean r1) {
        this.g = r1;
    }
}
