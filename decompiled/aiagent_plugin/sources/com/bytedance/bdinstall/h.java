package com.bytedance.bdinstall;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: AppVersionCompat.java */
/* JADX INFO: loaded from: classes.dex */
final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f6252a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f6253b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f6254c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final long f6255d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final long f6256e;
    private final Context f;
    private final com.bytedance.bdinstall.j.r<PackageInfo> g;

    static /* synthetic */ Context a(h r0) {
        return r0.f;
    }

    h(m r3) {
        this.g = new AnonymousClass1(this);
        this.f = ZeusTransformUtils.wrapperContext(r3.n, "com.obric.aiagent.plugin");
        this.f6252a = r3.q;
        if (TextUtils.isEmpty(r3.r) == false) goto L5;
        String r0 = "";
    L6:
        this.f6253b = r0;
        this.f6254c = r3.s;
        this.f6255d = r3.t;
        this.f6256e = r3.u;
        return;
    L5:
        r0 = r3.r;
        goto L6
    }

    public String a() {
        if (TextUtils.isEmpty(this.f6252a) == false) goto L9;
        PackageInfo r0 = (PackageInfo) ZeusTransformUtils.preCheckCast(this.g.c(new Object[0]), PackageInfo.class, "com.obric.aiagent.plugin");
        if (r0 == null) goto L9;
        return r0.versionName;
    L9:
        return this.f6252a;
    }

    public String b() {
        return this.f6253b;
    }

    public long c() {
        if (this.f6254c != 0) goto L9;
        PackageInfo r0 = (PackageInfo) ZeusTransformUtils.preCheckCast(this.g.c(new Object[0]), PackageInfo.class, "com.obric.aiagent.plugin");
        if (r0 == null) goto L9;
        return r0.versionCode;
    L9:
        return this.f6254c;
    }

    public long d() {
        if (this.f6255d != 0) goto L9;
        PackageInfo r0 = (PackageInfo) ZeusTransformUtils.preCheckCast(this.g.c(new Object[0]), PackageInfo.class, "com.obric.aiagent.plugin");
        if (r0 == null) goto L9;
        return r0.versionCode;
    L9:
        return this.f6255d;
    }

    public long e() {
        if (this.f6256e != 0) goto L9;
        PackageInfo r0 = (PackageInfo) ZeusTransformUtils.preCheckCast(this.g.c(new Object[0]), PackageInfo.class, "com.obric.aiagent.plugin");
        if (r0 == null) goto L9;
        return r0.versionCode;
    L9:
        return this.f6256e;
    }
}
