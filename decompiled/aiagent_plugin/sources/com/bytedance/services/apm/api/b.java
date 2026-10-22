package com.bytedance.services.apm.api;

import org.json.JSONObject;

/* JADX INFO: compiled from: EventConfig.java */
/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f11168a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f11169b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private JSONObject f11170c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private JSONObject f11171d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private JSONObject f11172e;
    private boolean f;

    /* JADX INFO: renamed from: com.bytedance.services.apm.api.b$1, reason: invalid class name */
    /* JADX INFO: compiled from: EventConfig.java */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* JADX INFO: compiled from: EventConfig.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f11173a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f11174b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private JSONObject f11175c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private JSONObject f11176d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private JSONObject f11177e;
        private boolean f;

        /* synthetic */ a(AnonymousClass1 r1) {
            this();
        }

        static /* synthetic */ String a(a r0) {
            return r0.f11173a;
        }

        static /* synthetic */ int b(a r0) {
            return r0.f11174b;
        }

        static /* synthetic */ JSONObject c(a r0) {
            return r0.f11175c;
        }

        static /* synthetic */ JSONObject d(a r0) {
            return r0.f11176d;
        }

        static /* synthetic */ JSONObject e(a r0) {
            return r0.f11177e;
        }

        static /* synthetic */ boolean f(a r0) {
            return r0.f;
        }

        private a() {
        }

        public a a(String r1) {
            this.f11173a = r1;
            return this;
        }

        public a a(JSONObject r1) {
            this.f11175c = r1;
            return this;
        }

        public a a(boolean r1) {
            this.f = r1;
            return this;
        }

        public b a() {
            return new b(this);
        }
    }

    public String a() {
        return this.f11168a;
    }

    public JSONObject b() {
        return this.f11170c;
    }

    public JSONObject c() {
        return this.f11171d;
    }

    public int d() {
        return this.f11169b;
    }

    public JSONObject e() {
        return this.f11172e;
    }

    public boolean f() {
        return this.f;
    }

    public static a g() {
        return new a(null);
    }

    public b(a r2) {
        this.f11168a = a.a(r2);
        this.f11169b = a.b(r2);
        this.f11170c = a.c(r2);
        this.f11171d = a.d(r2);
        this.f11172e = a.e(r2);
        this.f = a.f(r2);
    }
}
