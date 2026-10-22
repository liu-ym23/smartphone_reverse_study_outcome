package com.bytedance.reparo.core.g;

import android.text.TextUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;

/* JADX INFO: compiled from: PatchRecordInfo.java */
/* JADX INFO: loaded from: classes.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private transient File f9233a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f9234b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private transient File f9235c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f9236d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f9237e;
    private transient File f;
    private String g;
    private String h;
    private String i;
    private String j;
    private String k;
    private boolean l;
    private boolean m;
    private boolean n;

    public h() {
        this.f9237e = false;
        this.l = true;
        this.n = false;
    }

    public h a() {
        h r0 = new h();
        r0.f9233a = this.f9233a;
        r0.f9234b = this.f9234b;
        r0.f9235c = this.f9235c;
        r0.f9236d = this.f9236d;
        r0.f9237e = this.f9237e;
        r0.f = this.f;
        r0.g = this.g;
        r0.j = this.j;
        r0.h = this.h;
        r0.i = this.i;
        r0.k = this.k;
        r0.l = this.l;
        r0.m = this.m;
        r0.n = this.n;
        return r0;
    }

    public File b() {
        return this.f9233a;
    }

    public String c() {
        File r0 = this.f9233a;
        if (r0 != null) goto L7;
        return "";
    L7:
        return r0.getAbsolutePath();
    }

    public void a(File r1) {
        this.f9233a = r1;
    }

    public boolean d() {
        return this.f9234b;
    }

    public void a(boolean r1) {
        this.f9234b = r1;
    }

    public String e() {
        File r0 = this.f9235c;
        if (r0 != null) goto L7;
        return "";
    L7:
        return r0.getAbsolutePath();
    }

    public void b(File r1) {
        this.f9235c = r1;
    }

    public File f() {
        return this.f9235c;
    }

    public boolean g() {
        return this.f9236d;
    }

    public boolean h() {
        return this.f9237e;
    }

    public void b(boolean r1) {
        this.f9236d = r1;
    }

    public void c(boolean r1) {
        this.f9237e = r1;
    }

    public File i() {
        return this.f;
    }

    public String j() {
        File r0 = this.f;
        if (r0 != null) goto L7;
        return "";
    L7:
        return r0.getAbsolutePath();
    }

    public void c(File r1) {
        this.f = r1;
    }

    public String k() {
        return this.g;
    }

    public void a(String r1) {
        this.g = r1;
    }

    public void b(String r1) {
        this.h = r1;
    }

    public String l() {
        return this.h;
    }

    public String m() {
        return this.i;
    }

    public void c(String r1) {
        this.i = r1;
    }

    public String n() {
        return this.j;
    }

    public void d(String r1) {
        this.j = r1;
    }

    public String o() {
        return this.k;
    }

    public void e(String r1) {
        this.k = r1;
    }

    public void p() {
        this.k += "_illegal";
        this.n = true;
    }

    public boolean q() {
        return this.n;
    }

    public boolean r() {
        return this.l;
    }

    public void d(boolean r1) {
        this.l = r1;
    }

    public boolean s() {
        return this.m;
    }

    public void e(boolean r1) {
        this.m = r1;
    }

    boolean t() {
        boolean r0 = com.bytedance.reparo.core.a.b.b.b(b());
        if (this.f9234b == false) goto L8;
        if (com.bytedance.reparo.core.a.b.b.d(f()) == false) goto L8;
        r0 = false;
    L8:
        if (this.f9236d == false) goto L13;
        if (com.bytedance.reparo.core.a.b.b.b(i()) == true) goto L13;
        return false;
    L13:
        return r0;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append("{").append("issueId = ").append(this.h).append(", ").append("patchId = ").append(this.j).append(", ").append("md5 = ").append(this.g).append(", ").append("hostAppVersion = ").append(this.k).append(", ").append("isAsyncLoad = ").append(this.l).append(", ").append("isSupportSubProcess = ").append(this.m).append(", ").append("installPath = ").append(com.bytedance.reparo.core.a.b.e.a(this.f9233a)).append(", ").append("hasJavaPatch = ").append(this.f9234b).append(", ").append("hasSoLibraries = ").append(this.f9236d).append("}");
        return r0.toString();
    }

    public int hashCode() {
        return 527 + this.g.hashCode();
    }

    public boolean equals(Object r4) {
        if (r4 != null) goto L6;
        return false;
    L6:
        if (ZeusTransformUtils.instanceOf(r4, h.class) == true) goto L8;
        return false;
    L8:
        h r5 = (h) ZeusTransformUtils.preCheckCast(r4, h.class, "com.obric.aiagent.plugin");
        if (com.bytedance.reparo.core.a.b.b.b(this.f9233a, r5.f9233a) == true) goto L11;
        return false;
    L11:
        if (this.f9234b == r5.f9234b) goto L13;
        return false;
    L13:
        if (com.bytedance.reparo.core.a.b.b.b(this.f9235c, r5.f9235c) == true) goto L15;
        return false;
    L15:
        if (this.f9236d == r5.f9236d) goto L17;
        return false;
    L17:
        if (com.bytedance.reparo.core.a.b.b.b(this.f, r5.f) == true) goto L19;
        return false;
    L19:
        if (TextUtils.equals(this.g, r5.g) == true) goto L21;
        return false;
    L21:
        if (TextUtils.equals(this.j, r5.j) == true) goto L23;
        return false;
    L23:
        if (TextUtils.equals(this.h, r5.h) == true) goto L25;
        return false;
    L25:
        if (TextUtils.equals(this.i, r5.i) == true) goto L27;
        return false;
    L27:
        if (TextUtils.equals(this.k, r5.k) == true) goto L29;
        return false;
    L29:
        if (this.l == r5.l) goto L31;
        return false;
    L31:
        if (this.m != r5.m) goto L45;
        return true;
    L45:
        return false;
    }
}
