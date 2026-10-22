package com.bytedance.android.sdk.bdticketguard.math;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes12.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f163967a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b f163968b = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Mac f163969a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public SecretKeySpec f163970b;

        public a() {
            this.f163969a = Mac.getInstance("HmacSHA256");
        }
    }

    public static final class b extends ThreadLocal<a> {
        @Override // java.lang.ThreadLocal
        public final a initialValue() {
            return new a();
        L4:
            e = move-exception;
            throw new RuntimeException(e);
        }

        public b() {
        }
    }

    public static final class c extends ThreadLocal<Mac> {
        @Override // java.lang.ThreadLocal
        public final Mac initialValue() {
            return Mac.getInstance("HmacSHA256");
        L4:
            e = move-exception;
            throw new RuntimeException(e);
        }

        public c() {
        }
    }

    static {
        f163967a = new c();
        f163968b = new b();
    }
}
