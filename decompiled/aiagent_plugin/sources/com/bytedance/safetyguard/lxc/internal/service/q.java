package com.bytedance.safetyguard.lxc.internal.service;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: ProxySessionRegistry.kt */
/* JADX INFO: loaded from: classes.dex */
public interface q {

    /* JADX INFO: compiled from: ProxySessionRegistry.kt */
    public static final class a implements q {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean f11044a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final d.h.a.a<d.x> f11045b;

        public a(boolean r3, d.h.a.a<d.x> r4) {
            d.h.a.a<d.x> r5 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.a.class, "com.obric.aiagent.plugin");
            d.h.b.o.e(r5, "runAfterRegistration");
            this.f11044a = r3;
            this.f11045b = r5;
        }

        public final d.h.a.a<d.x> a() {
            return this.f11045b;
        }
    }

    /* JADX INFO: compiled from: ProxySessionRegistry.kt */
    public static final class b implements q {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f11046a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f11047b;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
            return false;
        L8:
            b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.aiagent.plugin");
            if (this.f11046a == r6.f11046a) goto L12;
            return false;
        L12:
            if (d.h.b.o.a(this.f11047b, r6.f11047b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (Integer.hashCode(this.f11046a) * 31) + this.f11047b.hashCode();
        }

        public String toString() {
            return "Rejected(errorCode=" + this.f11046a + ", message=" + this.f11047b + ')';
        }

        public b(int r2, String r3) {
            d.h.b.o.e(r3, "message");
            this.f11046a = r2;
            this.f11047b = r3;
        }

        public final int a() {
            return this.f11046a;
        }

        public final String b() {
            return this.f11047b;
        }
    }
}
