package com.bytedance.crash.monitor;

import android.text.TextUtils;
import com.bytedance.crash.ah;
import com.bytedance.crash.runtime.DefaultWorkThread;
import java.util.ArrayList;

/* JADX INFO: compiled from: CrashListener.java */
/* JADX INFO: loaded from: classes.dex */
public class d extends f {
    private static final ArrayList<d> o = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final CacheManager f7579a;
    private c n;

    static {
        o = new ArrayList();
    }

    d(ah r2) {
        super(r2);
        o.add(this);
        this.f7579a = new CacheManager(com.bytedance.crash.i.d());
    }

    d(ah r13, final String r14, final String r15, final long r16) {
        super(r13, r14, r15, r16, 0, 0);
        o.add(this);
        CacheManager r1 = new CacheManager(com.bytedance.crash.i.d(), r14);
        this.f7579a = r1;
        if (DefaultWorkThread.isCurrentThread() == false) goto L5;
        r1.b(r14);
        r1.a(r16, 0, 0, r15);
        return;
    L5:
        DefaultWorkThread.post(new AnonymousClass1(this, r14, r16, r15));
    }

    d(final String r10, final String r11, final long r12) {
        super(r10, r11, r12, 0, 0);
        o.add(this);
        CacheManager r1 = new CacheManager(com.bytedance.crash.i.d(), r10);
        this.f7579a = r1;
        if (DefaultWorkThread.isCurrentThread() == false) goto L5;
        r1.b(r10);
        r1.a(r12, 0, 0, r11);
        return;
    L5:
        DefaultWorkThread.post(new AnonymousClass2(this, r10, r12, r11));
    }

    static ArrayList<d> d() {
        return o;
    }

    @Override // com.bytedance.crash.monitor.f
    public String e() {
        if (this.f7595e == null) goto L6;
        return this.f7595e;
    L6:
        return this.f7579a.b();
    }

    @Override // com.bytedance.crash.monitor.f
    public String f() {
        if (this.h == null) goto L6;
        return this.h;
    L6:
        return this.f7579a.d();
    }

    @Override // com.bytedance.crash.monitor.f
    public String a(String r2) {
        if (TextUtils.isEmpty(this.g) == false) goto L5;
        String r1 = this.f7579a.a();
        if (TextUtils.isEmpty(r1) == false) goto L9;
        return r2;
    L9:
        return r1;
    L5:
        return this.g;
    }

    @Override // com.bytedance.crash.monitor.f
    public long g() {
        if (this.f == 0) goto L6;
        return this.f;
    L6:
        return this.f7579a.c();
    }

    @Override // com.bytedance.crash.monitor.f
    public c h() {
        c r0 = this.n;
        if (r0 == null) goto L6;
        return r0;
    L6:
        if (this.i != null) goto L8;
    L10:
        this.n = this.f7579a.e();
    L12:
        return this.n;
    L8:
        if (this.j == 0) goto L10;
        this.n = new c(this.j, this.l, this.k, this.i);
        goto L12
    }

    @Override // com.bytedance.crash.monitor.f
    public long i() {
        return h().b();
    }

    @Override // com.bytedance.crash.monitor.f
    public long j() {
        return h().a();
    }

    @Override // com.bytedance.crash.monitor.f
    public long k() {
        return h().c();
    }

    @Override // com.bytedance.crash.monitor.f
    public String l() {
        return h().d();
    }

    public String b(long r1) {
        return this.f7579a.b(r1);
    }

    public String c(long r1) {
        return this.f7579a.e(r1);
    }

    public String d(long r1) {
        String r0 = this.f7579a.a(r1);
        if (TextUtils.isEmpty(r0) == false) goto L6;
        return "0";
    L6:
        return r0;
    }

    public long e(long r1) {
        return this.f7579a.c(r1);
    }

    public c f(long r1) {
        return this.f7579a.f(r1);
    }

    @Override // com.bytedance.crash.monitor.f
    public void b(String r1) {
        this.h = r1;
        this.f7579a.c(r1);
    }

    @Override // com.bytedance.crash.monitor.f
    public void c(String r1) {
        this.g = r1;
        this.f7579a.a(r1);
    }

    @Override // com.bytedance.crash.monitor.f
    public void g(long r1) {
        this.f = r1;
        this.f7579a.d(r1);
    }
}
