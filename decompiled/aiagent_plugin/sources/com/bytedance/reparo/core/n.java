package com.bytedance.reparo.core;

import android.text.TextUtils;
import java.io.File;

/* JADX INFO: compiled from: UpdateRequest.java */
/* JADX INFO: loaded from: classes.dex */
public class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private File f9326a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f9327b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f9328c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f9329d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f9330e;
    private String f;
    private boolean g;
    private boolean h;

    /* JADX INFO: renamed from: com.bytedance.reparo.core.n$1, reason: invalid class name */
    /* JADX INFO: compiled from: UpdateRequest.java */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* JADX INFO: compiled from: UpdateRequest.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private File f9331a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f9332b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private String f9333c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private String f9334d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private String f9335e;
        private String f;
        private boolean g;
        private boolean h;

        public a() {
            this.g = true;
        }

        public a a(File r1) {
            this.f9331a = r1;
            return this;
        }

        public a a(String r1) {
            this.f9332b = r1;
            return this;
        }

        public a b(String r1) {
            this.f9333c = r1;
            return this;
        }

        public a c(String r1) {
            this.f9334d = r1;
            return this;
        }

        public a d(String r1) {
            this.f9335e = r1;
            return this;
        }

        public a e(String r1) {
            this.f = r1;
            return this;
        }

        public a a(boolean r1) {
            this.g = r1;
            return this;
        }

        public a b(boolean r1) {
            this.h = r1;
            return this;
        }

        public n a() {
            b();
            n r0 = new n(null);
            n.a(r0, this.f9331a);
            n.a(r0, this.f9332b);
            n.b(r0, this.f9333c);
            n.c(r0, this.f9334d);
            n.d(r0, this.f9335e);
            n.e(r0, this.f);
            n.a(r0, this.g);
            n.b(r0, this.h);
            return r0;
        }

        private void b() {
            if (this.f9331a == null) goto L14;
            if (TextUtils.isEmpty(this.f9332b) == true) goto L12;
            if (TextUtils.isEmpty(this.f) == true) goto L10;
            return;
        L10:
            throw new IllegalArgumentException("host app version is empty");
        L12:
            throw new IllegalArgumentException("patch md5 is empty");
        L14:
            throw new IllegalArgumentException("patch file is null");
        }
    }

    /* synthetic */ n(AnonymousClass1 r1) {
        this();
    }

    static /* synthetic */ File a(n r0, File r1) {
        r0.f9326a = r1;
        return r1;
    }

    static /* synthetic */ String a(n r0, String r1) {
        r0.f9327b = r1;
        return r1;
    }

    static /* synthetic */ boolean a(n r0, boolean r1) {
        r0.g = r1;
        return r1;
    }

    static /* synthetic */ String b(n r0, String r1) {
        r0.f9328c = r1;
        return r1;
    }

    static /* synthetic */ boolean b(n r0, boolean r1) {
        r0.h = r1;
        return r1;
    }

    static /* synthetic */ String c(n r0, String r1) {
        r0.f9329d = r1;
        return r1;
    }

    static /* synthetic */ String d(n r0, String r1) {
        r0.f9330e = r1;
        return r1;
    }

    static /* synthetic */ String e(n r0, String r1) {
        r0.f = r1;
        return r1;
    }

    private n() {
        this.f9327b = "";
        this.f9328c = "";
        this.f9329d = "";
        this.f9330e = "";
        this.f = "";
        this.g = true;
    }

    public File a() {
        return this.f9326a;
    }

    public String b() {
        return this.f9327b;
    }

    public String c() {
        return this.f9328c;
    }

    public String d() {
        return this.f9329d;
    }

    public String e() {
        return this.f9330e;
    }

    public String f() {
        return this.f;
    }

    public boolean g() {
        return this.g;
    }

    public boolean h() {
        return this.h;
    }

    public com.bytedance.reparo.core.g.h i() {
        com.bytedance.reparo.core.g.h r0 = new com.bytedance.reparo.core.g.h();
        r0.a(b());
        r0.c(c());
        r0.d(d());
        r0.b(e());
        r0.e(f());
        r0.d(g());
        r0.e(h());
        return r0;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append("{").append("patchId = ").append(this.f9329d).append(", ").append("issueId = ").append(this.f9330e).append(", ").append("md5 = ").append(this.f9327b).append(", ").append("hostAppVersion = ").append(this.f).append(", ").append("isAsyncLoad = ").append(this.g).append(", ").append("isSupportSubProcess = ").append(this.h).append("}");
        return r0.toString();
    }

    String j() {
        StringBuilder r0 = new StringBuilder().append(com.bytedance.reparo.core.a.b.e.a(b())).append("_").append(com.bytedance.reparo.core.a.b.e.a(f())).append("_").append(com.bytedance.reparo.core.a.b.e.a(d())).append("_").append(com.bytedance.reparo.core.a.b.e.a(c())).append("_");
        String r3 = "1";
        if (g() == false) goto L5;
        String r2 = "1";
    L6:
        StringBuilder r1 = r0.append(r2).append("_");
        if (h() == true) goto L11;
        r3 = "0";
    L11:
        return r1.append(r3).toString();
    L5:
        r2 = "0";
        goto L6
    }

    public boolean a(com.bytedance.reparo.core.g.h r3) {
        if (TextUtils.equals(b(), r3.k()) == true) goto L5;
    L17:
        return false;
    L5:
        if (TextUtils.equals(f(), r3.o()) == false) goto L17;
        if (TextUtils.equals(d(), r3.n()) == false) goto L17;
        if (TextUtils.equals(e(), r3.l()) == false) goto L17;
        if (TextUtils.equals(c(), r3.m()) == false) goto L17;
        if (g() != r3.r()) goto L17;
        if (h() != r3.s()) goto L17;
        return true;
    }
}
