package com.ss.android.agilelogger;

import android.content.Context;
import android.text.TextUtils;
import com.obric.capabilitykit.common.UiType;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: ALogConfig.java */
/* JADX INFO: loaded from: classes4.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f37073a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f37074b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f37075c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f37076d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f37077e;
    private String f;
    private boolean g;
    private boolean h;
    private int i;
    private String j;
    private boolean k;
    private boolean l;
    private boolean m;
    private boolean n;
    private boolean o;
    private int p;
    private float q;
    private boolean r;

    /* JADX INFO: renamed from: com.ss.android.agilelogger.b$1, reason: invalid class name */
    /* JADX INFO: compiled from: ALogConfig.java */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* JADX INFO: compiled from: ALogConfig.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Context f37078a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f37079b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f37080c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private float f37081d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f37082e;
        private String f;
        private String g;
        private boolean h;
        private boolean i;
        private int j;
        private String k;
        private boolean l;
        private boolean m;
        private boolean n;
        private boolean o;
        private boolean p;
        private int q;
        private boolean r;

        public a(Context r4) {
            Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
            this.f37079b = 14;
            this.f37080c = 20971520;
            this.f37081d = 0.1f;
            this.f37082e = UiType.FLAG_REMOTE_CARD;
            this.h = true;
            this.i = true;
            this.j = 3;
            this.k = "fecbb32b759120b672045f74edc41d159b6a426ffc863b9e0be9ad4be12824546f549959b838993a430344f15197221e87bd362298814c75f5068148b980306f";
            this.l = true;
            this.m = false;
            this.n = false;
            this.o = false;
            this.p = false;
            this.q = 64;
            this.r = false;
            if (r5 == null) goto L10;
            Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r5.getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
            if (r0 == null) goto L7;
            r5 = r0;
        L7:
            this.f37078a = ZeusTransformUtils.wrapperContext(r5, "com.obric.aiagent.plugin");
            return;
        L10:
            throw new RuntimeException("context must not be null");
        }

        public a a(int r1) {
            this.f37080c = r1;
            return this;
        }

        public a a(float r1) {
            this.f37081d = r1;
            return this;
        }

        public a b(int r1) {
            this.f37082e = r1;
            return this;
        }

        public a a(String r1) {
            this.g = r1;
            return this;
        }

        public a c(int r1) {
            this.j = r1;
            return this;
        }

        public a a(boolean r1) {
            this.m = r1;
            return this;
        }

        public a b(boolean r1) {
            this.n = r1;
            return this;
        }

        public a c(boolean r1) {
            this.o = r1;
            return this;
        }

        public b a() {
            b r0 = new b(null);
            r0.a(this.f37078a);
            r0.a(this.f37079b);
            r0.b(this.f37080c);
            r0.a(this.f37081d);
            r0.c(this.f37082e);
            if (TextUtils.isEmpty(this.f) == false) goto L5;
            String r1 = com.ss.android.agilelogger.b.a.b(this.f37078a);
        L6:
            r0.a(r1);
            if (TextUtils.isEmpty(this.g) == false) goto L9;
            String r2 = com.ss.android.agilelogger.b.a.a(this.f37078a).getAbsolutePath();
        L10:
            r0.b(r2);
            r0.a(this.h);
            r0.b(this.i);
            r0.d(this.j);
            r0.c(this.k);
            r0.c(this.l);
            r0.d(this.m);
            r0.e(this.n);
            r0.f(this.p);
            r0.g(this.o);
            r0.h(this.r);
            r0.e(this.q);
            return r0;
        L9:
            r2 = this.g;
            goto L10
        L5:
            r1 = this.f;
            goto L6
        }
    }

    /* synthetic */ b(AnonymousClass1 r1) {
        this();
    }

    private b() {
    }

    public Context getContext() {
        return this.f37073a;
    }

    public void a(Context r3) {
        this.f37073a = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin");
    }

    public int a() {
        return this.f37074b;
    }

    public void a(int r1) {
        this.f37074b = r1;
    }

    public int b() {
        return this.f37075c;
    }

    public void b(int r1) {
        this.f37075c = r1;
    }

    public void a(float r1) {
        this.q = r1;
    }

    public float c() {
        return this.q;
    }

    public int d() {
        return this.f37076d;
    }

    public void c(int r1) {
        this.f37076d = r1;
    }

    public String e() {
        return this.f37077e;
    }

    public void a(String r1) {
        this.f37077e = r1;
    }

    public String f() {
        return this.f;
    }

    public void b(String r1) {
        this.f = r1;
    }

    public boolean g() {
        return this.g;
    }

    public void a(boolean r1) {
        this.g = r1;
    }

    public boolean h() {
        return this.h;
    }

    public void b(boolean r1) {
        this.h = r1;
    }

    public int i() {
        return this.i;
    }

    public void d(int r1) {
        this.i = r1;
    }

    public String j() {
        return this.j;
    }

    public void c(String r1) {
        this.j = r1;
    }

    public boolean k() {
        return this.k;
    }

    public void c(boolean r1) {
        this.k = r1;
    }

    public void d(boolean r1) {
        this.l = r1;
    }

    public boolean l() {
        return this.l;
    }

    public void e(boolean r1) {
        this.m = r1;
    }

    public boolean m() {
        return this.m;
    }

    public void f(boolean r1) {
        this.o = r1;
    }

    public boolean n() {
        return this.o;
    }

    public void g(boolean r1) {
        this.n = r1;
    }

    public void h(boolean r1) {
        this.r = r1;
    }

    public boolean o() {
        return this.r;
    }

    public boolean p() {
        return this.n;
    }

    public int q() {
        return this.p;
    }

    public void e(int r1) {
        this.p = r1;
    }
}
