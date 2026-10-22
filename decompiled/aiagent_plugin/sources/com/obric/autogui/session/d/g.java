package com.obric.autogui.session.d;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: VDSpacePreloader.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class g<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AtomicReference<T> f30897a;

    /* JADX INFO: compiled from: VDSpacePreloader.kt */
    public static final class a<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final T f30898a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f30899b;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin");
            if (o.a(this.f30898a, r6.f30898a) == true) goto L12;
            return false;
        L12:
            if (this.f30899b == r6.f30899b) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (this.f30898a.hashCode() * 31) + Boolean.hashCode(this.f30899b);
        }

        public String toString() {
            return "ReleaseClaim(resource=" + this.f30898a + ", ownsActiveResource=" + this.f30899b + ')';
        }

        public a(T r2, boolean r3) {
            o.e(r2, "resource");
            this.f30898a = r2;
            this.f30899b = r3;
        }

        public final T a() {
            return this.f30898a;
        }

        public final boolean b() {
            return this.f30899b;
        }
    }

    public g() {
        this.f30897a = new AtomicReference(null);
    }

    public final void a(T r2) {
        o.e(r2, "resource");
        this.f30897a.set(r2);
    }

    public final T a() {
        return this.f30897a.get();
    }

    public final a<T> b(T r2) {
        T r1 = this.f30897a.getAndSet(null);
        if (r1 != null) goto L6;
        return null;
    L6:
        if (r1 != r2) goto L8;
        boolean r3 = true;
    L10:
        return new a(r1, r3);
    L8:
        r3 = false;
        goto L10
    }
}
