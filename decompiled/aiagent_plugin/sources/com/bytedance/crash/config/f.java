package com.bytedance.crash.config;

import android.text.TextUtils;

/* JADX INFO: compiled from: NetConfig.java */
/* JADX INFO: loaded from: classes.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final f f7293a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f7294b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f7295c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f7296d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f7297e;
    private String f;
    private String g;
    private String h;
    private String i;
    private String j;
    private String k;
    private String l;
    private String m;
    private String n;
    private String o;
    private String p;

    static {
        f7293a = new f();
    }

    public static f a() {
        return f7293a;
    }

    private f() {
        this.f7294b = com.bytedance.crash.runtime.a.a();
        n();
    }

    private void n() {
        this.f7295c = this.f7294b + "/monitor/collect/c/rapheal_file_collect";
        this.f7296d = this.f7294b + "/monitor/collect/c/core_dump_collect";
        this.f7297e = this.f7294b + "/monitor/collect/c/core_dump_upload_check";
        this.f = this.f7294b + "/monitor/collect/c/crash";
        this.g = this.f7294b + "/monitor/collect/c/exception/dump_collection";
        this.h = this.f7294b + "/monitor/collect/c/exception";
        this.j = this.f7294b + "/monitor/collect/c/exception/dump_collection";
        this.k = this.f7294b + "/monitor/collect/batch/";
        this.l = this.f7294b + "/monitor/collect/c/native_bin_crash";
        this.m = this.f7294b + "/monitor/collect/c/logcollect";
        this.n = this.f7294b + "/monitor/appmonitor/v3/settings";
        this.o = this.f7294b + "/monitor/collect/quota_status";
        this.p = this.f7294b + "/monitor/collect/c/logcollect";
        this.i = this.f7294b + "/monitor/collect/c/biz_exception";
    }

    public void a(String r8) {
        if (TextUtils.isEmpty(r8) == false) goto L5;
        return;
    L5:
        this.h = r8;
        int r0 = r8.indexOf("//");
        if (r0 != (-1)) goto L8;
        this.g = r8.substring(0, r8.indexOf("/") + 1) + "monitor/collect/c/exception/dump_collection";
        this.j = r8.substring(0, r8.indexOf("/") + 1) + "monitor/collect/c/custom_exception/zip";
        return;
    L8:
        int r1 = r0 + 2;
        this.g = r8.substring(0, r8.indexOf("/", r1) + 1) + "monitor/collect/c/exception/dump_collection";
        this.j = r8.substring(0, r8.indexOf("/", r1) + 1) + "monitor/collect/c/custom_exception/zip";
    }

    public void b(String r2) {
        if (TextUtils.isEmpty(r2) == false) goto L5;
        return;
    L5:
        this.l = r2;
    }

    public void c(String r2) {
        if (TextUtils.isEmpty(r2) == false) goto L5;
        return;
    L5:
        this.m = r2;
    }

    public void d(String r2) {
        if (TextUtils.isEmpty(r2) == false) goto L5;
        return;
    L5:
        this.f = r2;
    }

    public void e(String r2) {
        if (TextUtils.isEmpty(r2) == false) goto L5;
        return;
    L5:
        this.n = r2;
    }

    public static String b() {
        return f7293a.o;
    }

    public static String c() {
        return f7293a.n;
    }

    public static String d() {
        return f7293a.l;
    }

    public static String e() {
        return f7293a.g;
    }

    public static String f() {
        return f7293a.h;
    }

    public static String g() {
        return f7293a.i;
    }

    public static String h() {
        return f7293a.j;
    }

    public static String i() {
        return f7293a.k;
    }

    public static String j() {
        return f7293a.f;
    }

    public static String k() {
        return f7293a.f7296d;
    }

    public static String l() {
        return d();
    }

    public static String m() {
        return f7293a.m;
    }
}
