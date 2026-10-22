package com.baidu.mshield.x6.e;

import android.content.Context;

/* JADX INFO: loaded from: classes39.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static h f32596a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile boolean f32597b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile boolean f32598c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static int f32599d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Context f32600e;

    public class a extends com.baidu.mshield.x6.f.m.a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f32601b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ h f32602c;

        @Override // com.baidu.mshield.x6.f.m.a
        public void a() {
            new com.baidu.mshield.x6.e.c(h.a(this.f32602c), this.f32601b).b();
        }

        public a(h r100, int r101) {
            this.f32602c = r100;
            this.f32601b = r101;
        }
    }

    public class b extends com.baidu.mshield.x6.f.m.a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ h f32603b;

        @Override // com.baidu.mshield.x6.f.m.a
        public void a() {
            new com.baidu.mshield.x6.e.d(h.a(this.f32603b)).a();
        }

        public b(h r100) {
            this.f32603b = r100;
        }
    }

    public class c extends com.baidu.mshield.x6.f.m.a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f32604b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ h f32605c;

        @Override // com.baidu.mshield.x6.f.m.a
        public void a() {
            new com.baidu.mshield.x6.e.e(h.a(this.f32605c), this.f32604b).a();
        }

        public c(h r100, int r101) {
            this.f32605c = r100;
            this.f32604b = r101;
        }
    }

    public class d extends com.baidu.mshield.x6.f.m.a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f32606b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f32607c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ h f32608d;

        @Override // com.baidu.mshield.x6.f.m.a
        public void a() {
            new com.baidu.mshield.x6.e.e(h.a(this.f32608d), this.f32606b, this.f32607c).a();
        }

        public d(h r100, int r101, int r102) {
            this.f32608d = r100;
            this.f32606b = r101;
            this.f32607c = r102;
        }
    }

    public class e extends com.baidu.mshield.x6.f.m.a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ h f32609b;

        @Override // com.baidu.mshield.x6.f.m.a
        public void a() {
            new com.baidu.mshield.x6.e.b(h.a(this.f32609b)).a();
        }

        public e(h r100) {
            this.f32609b = r100;
        }
    }

    public void a() {
        com.baidu.mshield.x6.f.m.c.b().a(new e(this));     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        com.baidu.mshield.x6.f.f.b(th);
    }

    public void b() {
        com.baidu.mshield.x6.f.m.c.b().a(new b(this));     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        com.baidu.mshield.x6.f.f.b(th);
    }

    public h(Context r100) {
        this.f32600e = r100;
    }

    public void a(int r100) {
        com.baidu.mshield.x6.f.m.c.b().a(new c(this, r100));     // Catch: Throwable -> L4
        a(5, false);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        com.baidu.mshield.x6.f.f.b(th);
    }

    public static synchronized h a(Context r100) {
        monitor-enter(h.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (f32596a != null) goto L7;
        f32596a = new h(r100);     // Catch: Throwable -> L10
    L7:
        h r101 = f32596a;     // Catch: Throwable -> L10
        monitor-exit(h.class);
        return r101;
    }

    public static /* synthetic */ Context a(h r100) {
        return r100.f32600e;
    }

    public void a(int r100, boolean r101) {
    L14:
        th = move-exception;
        f32598c = false;
        com.baidu.mshield.x6.f.f.b(th);
        return;
    L4:
        if (f32598c == false) goto L6;
        return;
    L6:
        f32598c = true;     // Catch: Throwable -> L14
        com.baidu.mshield.x6.b.b r102 = new com.baidu.mshield.x6.b.b(this.f32600e);     // Catch: Throwable -> L14
        if (r101 == false) goto L9;
    L12:
        com.baidu.mshield.x6.f.m.c.b().a(new a(this, r100));     // Catch: Throwable -> L14
        return;
    L9:
        if (com.baidu.mshield.x6.f.f.c().equals(r102.c()) == false) goto L12;
        f32598c = false;     // Catch: Throwable -> L14
    }

    public void a(int r100, int r101) {
        com.baidu.mshield.x6.f.m.c.b().a(new d(this, r100, r101));     // Catch: Throwable -> L4
        a(5, false);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        com.baidu.mshield.x6.f.f.b(th);
    }
}
