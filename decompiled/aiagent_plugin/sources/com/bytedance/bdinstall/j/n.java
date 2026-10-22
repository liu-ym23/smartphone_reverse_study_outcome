package com.bytedance.bdinstall.j;

import android.text.TextUtils;
import com.bytedance.bdinstall.an;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: OptionsForCommonParamProxy.java */
/* JADX INFO: loaded from: classes.dex */
public class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.bytedance.bdinstall.g f6324a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private an f6325b;

    public n(an r1) {
        this.f6325b = r1;
    }

    public n(com.bytedance.bdinstall.g r3) {
        this.f6324a = (com.bytedance.bdinstall.g) ZeusTransformUtils.wrapperContextForParams(r3, com.bytedance.bdinstall.g.class, "com.obric.aiagent.plugin");
    }

    public String a() {
        an r0 = this.f6325b;
        if (r0 == null) goto L7;
        String r1 = r0.l();
        if (TextUtils.isEmpty(r1) == true) goto L15;
        return r1;
    L15:
        return this.f6325b.k();
    L7:
        com.bytedance.bdinstall.g r2 = this.f6324a;
        if (r2 == null) goto L12;
        String r3 = r2.d();
        if (TextUtils.isEmpty(r3) == true) goto L17;
        return r3;
    L17:
        return this.f6324a.c();
    L12:
        return null;
    }

    public long b() {
        an r0 = this.f6325b;
        if (r0 == null) goto L7;
        int r2 = r0.a();
    L6:
        return r2;
    L7:
        com.bytedance.bdinstall.g r3 = this.f6324a;
        if (r3 == null) goto L10;
        r2 = r3.h();
        goto L6
    L10:
        return 0;
    }

    public String c() {
        an r0 = this.f6325b;
        if (r0 != null) goto L5;
        com.bytedance.bdinstall.g r1 = this.f6324a;
        if (r1 != null) goto L9;
        return null;
    L9:
        return r1.a();
    L5:
        return r0.j();
    }

    public long d() {
        an r0 = this.f6325b;
        if (r0 != null) goto L5;
        com.bytedance.bdinstall.g r2 = this.f6324a;
        if (r2 != null) goto L9;
        return 0;
    L9:
        return r2.e();
    L5:
        return r0.g();
    }

    public String e() {
        an r0 = this.f6325b;
        if (r0 != null) goto L5;
        com.bytedance.bdinstall.g r1 = this.f6324a;
        if (r1 != null) goto L9;
        return null;
    L9:
        return r1.b();
    L5:
        return r0.e();
    }

    public long f() {
        an r0 = this.f6325b;
        if (r0 != null) goto L5;
        com.bytedance.bdinstall.g r2 = this.f6324a;
        if (r2 != null) goto L9;
        return 0;
    L9:
        return r2.g();
    L5:
        return r0.i();
    }

    public long g() {
        an r0 = this.f6325b;
        if (r0 != null) goto L5;
        com.bytedance.bdinstall.g r2 = this.f6324a;
        if (r2 != null) goto L9;
        return 0;
    L9:
        return r2.f();
    L5:
        return r0.h();
    }
}
