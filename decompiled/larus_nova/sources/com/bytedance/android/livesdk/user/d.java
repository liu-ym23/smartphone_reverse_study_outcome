package com.bytedance.android.livesdk.user;

/* JADX INFO: loaded from: classes11.dex */
public final class d extends com.bytedance.android.livesdk.user.b {

    public static abstract class a<T extends com.bytedance.android.livesdk.user.b.a<T>> extends com.bytedance.android.livesdk.user.b.a<T> {
        public a() {
        }
    }

    public static final class b<T extends a<T>> extends a<T> {
        @Override // com.bytedance.android.livesdk.user.b.a, com.bytedance.android.livesdk.user.a.AbstractC2426a
        public final com.bytedance.android.livesdk.user.a.AbstractC2426a a() {
            return this;
        }

        @Override // com.bytedance.android.livesdk.user.b.a
        public final com.bytedance.android.livesdk.user.b.a e() {
            return this;
        }

        @Override // com.bytedance.android.livesdk.user.b.a
        public final com.bytedance.android.livesdk.user.b d() {
            return new d(this);
        }

        public b() {
        }
    }

    public static final class c extends a<c> {
        @Override // com.bytedance.android.livesdk.user.b.a, com.bytedance.android.livesdk.user.a.AbstractC2426a
        public final com.bytedance.android.livesdk.user.a.AbstractC2426a a() {
            return this;
        }

        @Override // com.bytedance.android.livesdk.user.b.a
        public final com.bytedance.android.livesdk.user.b.a e() {
            return this;
        }

        @Override // com.bytedance.android.livesdk.user.b.a
        public final com.bytedance.android.livesdk.user.b d() {
            return new d(this);
        }

        public c() {
        }
    }

    public d(a r100) {
        super(r100);
    }
}
