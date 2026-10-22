package com.bytedance.frameworks.baselib.network.h;

import com.bytedance.common.utility.reflect.Reflect;
import com.bytedance.retrofit2.af;

/* JADX INFO: compiled from: ReflectWrap.java */
/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile boolean f8113a = false;

    /* JADX INFO: renamed from: com.bytedance.frameworks.baselib.network.h.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ReflectWrap.java */
    private static class C0181a implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Reflect f8114a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final af f8115b;

        C0181a(Reflect r1, af r2) {
            this.f8114a = r1;
            this.f8115b = r2;
        }

        @Override // com.bytedance.frameworks.baselib.network.h.a.b
        public b call(String r9) {
            long r0 = System.nanoTime();
            this.f8114a = this.f8114a.call(r9);     // Catch: Throwable -> L11 Exception -> L13
            af r10 = this.f8115b;
            if (r10 != null) goto L7;
        L10:
            return this;
        L7:
            if (r10.aF.g.f9615d != (-1)) goto L9;
            this.f8115b.aF.g.f9615d = 0;
        L9:
            this.f8115b.aF.g.f9615d += System.nanoTime() - r0;
            goto L10
        L13:
            e = move-exception;
            throw new d(e.getMessage(), e.getCause());     // Catch: Throwable -> L11
        L11:
            th = move-exception;
            af r6 = this.f8115b;
            if (r6 != null) goto L19;
        L22:
            throw th;
        L19:
            if (r6.aF.g.f9615d != (-1)) goto L21;
            this.f8115b.aF.g.f9615d = 0;
        L21:
            this.f8115b.aF.g.f9615d += System.nanoTime() - r0;
            goto L22
        }

        @Override // com.bytedance.frameworks.baselib.network.h.a.b
        public b call(String r8, Class<?>[] r9, Object... r10) {
            long r0 = System.nanoTime();
            this.f8114a = this.f8114a.call(r8, r9, r10);     // Catch: Throwable -> L11 Exception -> L13
            af r11 = this.f8115b;
            if (r11 != null) goto L7;
        L10:
            return this;
        L7:
            if (r11.aF.g.f9615d != (-1)) goto L9;
            this.f8115b.aF.g.f9615d = 0;
        L9:
            this.f8115b.aF.g.f9615d += System.nanoTime() - r0;
            goto L10
        L13:
            e = move-exception;
            throw new d(e.getMessage(), e.getCause());     // Catch: Throwable -> L11
        L11:
            th = move-exception;
            af r12 = this.f8115b;
            if (r12 != null) goto L19;
        L22:
            throw th;
        L19:
            if (r12.aF.g.f9615d != (-1)) goto L21;
            this.f8115b.aF.g.f9615d = 0;
        L21:
            this.f8115b.aF.g.f9615d += System.nanoTime() - r0;
            goto L22
        }

        @Override // com.bytedance.frameworks.baselib.network.h.a.b
        public <T> T a() {
            return (T) this.f8114a.get();
        }
    }

    /* JADX INFO: compiled from: ReflectWrap.java */
    public interface b {
        <T> T a();

        b call(String r1);

        b call(String r1, Class<?>[] r2, Object... r3);
    }

    /* JADX INFO: compiled from: ReflectWrap.java */
    private static class c implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private com.bytedance.frameworks.baselib.network.h.b f8116a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final af f8117b;

        c(com.bytedance.frameworks.baselib.network.h.b r1, af r2) {
            this.f8116a = r1;
            this.f8117b = r2;
        }

        @Override // com.bytedance.frameworks.baselib.network.h.a.b
        public b call(String r9) {
            long r0 = System.nanoTime();
            this.f8116a = this.f8116a.call(r9);     // Catch: Throwable -> L11 Exception -> L13
            af r10 = this.f8117b;
            if (r10 != null) goto L7;
        L10:
            return this;
        L7:
            if (r10.aF.g.f9615d != (-1)) goto L9;
            this.f8117b.aF.g.f9615d = 0;
        L9:
            this.f8117b.aF.g.f9615d += System.nanoTime() - r0;
            goto L10
        L13:
            e = move-exception;
            throw new d(e.getMessage(), e.getCause());     // Catch: Throwable -> L11
        L11:
            th = move-exception;
            af r6 = this.f8117b;
            if (r6 != null) goto L19;
        L22:
            throw th;
        L19:
            if (r6.aF.g.f9615d != (-1)) goto L21;
            this.f8117b.aF.g.f9615d = 0;
        L21:
            this.f8117b.aF.g.f9615d += System.nanoTime() - r0;
            goto L22
        }

        @Override // com.bytedance.frameworks.baselib.network.h.a.b
        public b call(String r8, Class<?>[] r9, Object... r10) {
            long r0 = System.nanoTime();
            this.f8116a = this.f8116a.call(r8, r9, r10);     // Catch: Throwable -> L11 Exception -> L13
            af r11 = this.f8117b;
            if (r11 != null) goto L7;
        L10:
            return this;
        L7:
            if (r11.aF.g.f9615d != (-1)) goto L9;
            this.f8117b.aF.g.f9615d = 0;
        L9:
            this.f8117b.aF.g.f9615d += System.nanoTime() - r0;
            goto L10
        L13:
            e = move-exception;
            throw new d(e.getMessage(), e.getCause());     // Catch: Throwable -> L11
        L11:
            th = move-exception;
            af r12 = this.f8117b;
            if (r12 != null) goto L19;
        L22:
            throw th;
        L19:
            if (r12.aF.g.f9615d != (-1)) goto L21;
            this.f8117b.aF.g.f9615d = 0;
        L21:
            this.f8117b.aF.g.f9615d += System.nanoTime() - r0;
            goto L22
        }

        @Override // com.bytedance.frameworks.baselib.network.h.a.b
        public <T> T a() {
            return (T) this.f8116a.a();
        }
    }

    static {
    }

    public static void a(boolean r0) {
        f8113a = r0;
    }

    public static b a(String r2) {
        return a(r2, null);
    L5:
        e = move-exception;
        throw new d(e.getMessage(), e.getCause());
    }

    public static b a(String r1, af r2) {
    L8:
        e = move-exception;
        throw new d(e.getMessage(), e.getCause());
    L3:
        if (f8113a == false) goto L7;
        return new c(com.bytedance.frameworks.baselib.network.h.b.a(r1), r2);
    L7:
        return new C0181a(Reflect.on(r1), r2);
    }

    public static b a(Class<?> r2) {
        return a(r2, null);
    L5:
        e = move-exception;
        throw new d(e.getMessage(), e.getCause());
    }

    public static b a(Class<?> r1, af r2) {
    L8:
        e = move-exception;
        throw new d(e.getMessage(), e.getCause());
    L3:
        if (f8113a == false) goto L7;
        return new c(com.bytedance.frameworks.baselib.network.h.b.a(r1), r2);
    L7:
        return new C0181a(Reflect.on(r1), r2);
    }

    public static b a(Object r2) {
        return a(r2, null);
    L5:
        e = move-exception;
        throw new d(e.getMessage(), e.getCause());
    }

    public static b a(Object r1, af r2) {
    L8:
        e = move-exception;
        throw new d(e.getMessage(), e.getCause());
    L3:
        if (f8113a == false) goto L7;
        return new c(com.bytedance.frameworks.baselib.network.h.b.a(r1), r2);
    L7:
        return new C0181a(Reflect.on(r1), r2);
    }
}
