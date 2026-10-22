package com.bytedance.android.livesdk.user;

import java.util.HashMap;

/* JADX INFO: loaded from: classes11.dex */
public class b extends com.bytedance.android.livesdk.user.a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f158640d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f158641e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f158642f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final HashMap<String, String> f158643g;

    public static abstract class a<T extends a<T>> extends com.bytedance.android.livesdk.user.a.AbstractC2426a<a<T>> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f158644d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public long f158645e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public HashMap<String, String> f158646f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public boolean f158647g;

        public abstract b d();

        public abstract T e();

        public a() {
            this.f158644d = "";
        }

        @Override // com.bytedance.android.livesdk.user.a.AbstractC2426a
        public /* bridge */ /* synthetic */ com.bytedance.android.livesdk.user.a.AbstractC2426a a() {
            return e();
        }

        public final T f(HashMap<String, String> r100) {
            this.f158646f = r100;
            return (T) e();
        }

        public final T g(String r100) {
            this.f158644d = r100;
            return (T) e();
        }

        public final T h(long r100) {
            this.f158645e = r100;
            return (T) e();
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.user.b$b, reason: collision with other inner class name */
    public static final class C2427b<T extends a<T>> extends a<T> {
        @Override // com.bytedance.android.livesdk.user.b.a, com.bytedance.android.livesdk.user.a.AbstractC2426a
        public final com.bytedance.android.livesdk.user.a.AbstractC2426a a() {
            return this;
        }

        @Override // com.bytedance.android.livesdk.user.b.a
        public final T e() {
            return this;
        }

        @Override // com.bytedance.android.livesdk.user.b.a
        public final b d() {
            return new b(this);
        }

        public C2427b() {
        }
    }

    public static final class c extends a<c> {
        @Override // com.bytedance.android.livesdk.user.b.a, com.bytedance.android.livesdk.user.a.AbstractC2426a
        public final com.bytedance.android.livesdk.user.a.AbstractC2426a a() {
            return this;
        }

        @Override // com.bytedance.android.livesdk.user.b.a
        public final a e() {
            return this;
        }

        @Override // com.bytedance.android.livesdk.user.b.a
        public final b d() {
            return new b(this);
        }

        public c() {
        }
    }

    public b(a r100) {
        super(r100);
        this.f158640d = r100.f158644d;
        this.f158641e = r100.f158645e;
        this.f158643g = r100.f158646f;
        this.f158642f = r100.f158647g;
    }
}
