package com.baidu.mshield.x6.e;

import android.content.Context;

/* loaded from: classes.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    public static h f8497a = null;

    /* renamed from: b, reason: collision with root package name */
    public static volatile boolean f8498b = false;

    /* renamed from: c, reason: collision with root package name */
    public static volatile boolean f8499c = false;

    /* renamed from: d, reason: collision with root package name */
    public static int f8500d;

    /* renamed from: e, reason: collision with root package name */
    public Context f8501e;

    public class a extends com.baidu.mshield.x6.f.m.a {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f8502b;

        public a(int i4) {
            this.f8502b = i4;
        }

        @Override // com.baidu.mshield.x6.f.m.a
        public void a() {
            new com.baidu.mshield.x6.e.c(h.this.f8501e, this.f8502b).b();
        }
    }

    public class b extends com.baidu.mshield.x6.f.m.a {
        public b() {
        }

        @Override // com.baidu.mshield.x6.f.m.a
        public void a() {
            new com.baidu.mshield.x6.e.d(h.this.f8501e).a();
        }
    }

    public class c extends com.baidu.mshield.x6.f.m.a {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f8505b;

        public c(int i4) {
            this.f8505b = i4;
        }

        @Override // com.baidu.mshield.x6.f.m.a
        public void a() {
            new com.baidu.mshield.x6.e.e(h.this.f8501e, this.f8505b).a();
        }
    }

    public class d extends com.baidu.mshield.x6.f.m.a {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f8507b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f8508c;

        public d(int i4, int i5) {
            this.f8507b = i4;
            this.f8508c = i5;
        }

        @Override // com.baidu.mshield.x6.f.m.a
        public void a() {
            new com.baidu.mshield.x6.e.e(h.this.f8501e, this.f8507b, this.f8508c).a();
        }
    }

    public class e extends com.baidu.mshield.x6.f.m.a {
        public e() {
        }

        @Override // com.baidu.mshield.x6.f.m.a
        public void a() {
            new com.baidu.mshield.x6.e.b(h.this.f8501e).a();
        }
    }

    public h(Context context) {
        this.f8501e = context;
    }

    public void b() {
        try {
            com.baidu.mshield.x6.f.m.c.b().a(new b());
        } catch (Throwable th) {
            com.baidu.mshield.x6.f.f.b(th);
        }
    }

    public static synchronized h a(Context context) {
        try {
            if (f8497a == null) {
                f8497a = new h(context);
            }
        } catch (Throwable th) {
            throw th;
        }
        return f8497a;
    }

    public void a(int i4, boolean z4) {
        try {
            if (f8499c) {
                return;
            }
            f8499c = true;
            com.baidu.mshield.x6.b.b bVar = new com.baidu.mshield.x6.b.b(this.f8501e);
            if (!z4 && com.baidu.mshield.x6.f.f.c().equals(bVar.c())) {
                f8499c = false;
            } else {
                com.baidu.mshield.x6.f.m.c.b().a(new a(i4));
            }
        } catch (Throwable th) {
            f8499c = false;
            com.baidu.mshield.x6.f.f.b(th);
        }
    }

    public void a(int i4) {
        try {
            com.baidu.mshield.x6.f.m.c.b().a(new c(i4));
            a(5, false);
        } catch (Throwable th) {
            com.baidu.mshield.x6.f.f.b(th);
        }
    }

    public void a(int i4, int i5) {
        try {
            com.baidu.mshield.x6.f.m.c.b().a(new d(i4, i5));
            a(5, false);
        } catch (Throwable th) {
            com.baidu.mshield.x6.f.f.b(th);
        }
    }

    public void a() {
        try {
            com.baidu.mshield.x6.f.m.c.b().a(new e());
        } catch (Throwable th) {
            com.baidu.mshield.x6.f.f.b(th);
        }
    }
}
