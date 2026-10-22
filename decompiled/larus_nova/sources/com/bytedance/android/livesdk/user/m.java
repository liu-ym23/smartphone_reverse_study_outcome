package com.bytedance.android.livesdk.user;

import java.util.HashMap;

/* JADX INFO: loaded from: classes11.dex */
public class m extends com.bytedance.android.livesdk.user.a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f158694d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f158695e;

    public static abstract class a<T extends a<T>> extends com.bytedance.android.livesdk.user.a.AbstractC2426a<T> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public long f158696d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f158697e;

        public abstract T d();

        public a() {
        }

        public final T e(HashMap<String, String> r100) {
            this.f158639c = r100;
            return (T) d();
        }

        public final T f(long r100) {
            this.f158696d = r100;
            return (T) d();
        }
    }

    public static final class b<T extends b<T>> extends a<T> {
        @Override // com.bytedance.android.livesdk.user.a.AbstractC2426a
        public final com.bytedance.android.livesdk.user.a.AbstractC2426a a() {
            return this;
        }

        @Override // com.bytedance.android.livesdk.user.m.a
        public final a d() {
            return this;
        }

        public b() {
        }
    }

    public static final class c extends a<c> {
        @Override // com.bytedance.android.livesdk.user.a.AbstractC2426a
        public final com.bytedance.android.livesdk.user.a.AbstractC2426a a() {
            return this;
        }

        @Override // com.bytedance.android.livesdk.user.m.a
        public final a d() {
            return this;
        }

        public c() {
        }
    }

    public m(a r100) {
        super(r100);
        this.f158694d = r100.f158696d;
        this.f158695e = r100.f158697e;
    }
}
