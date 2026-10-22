package com.bytedance.android.livesdk.service;

/* JADX INFO: loaded from: classes11.dex */
public final class b implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public k.c f157987a;

    public static final class a implements k.b<g> {
        public a() {
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [R, com.bytedance.android.livesdk.service.b] */
        @Override // com.bytedance.android.livesdk.service.k.b
        public final k.b.a<g> setup(k.b.a<g> r100) {
            r100.f158001a = new b();
            r100.f158002b = true;
            return r100;
        }
    }

    public b() {
    }

    @Override // com.bytedance.android.livesdk.service.g
    public final <T> T a(Class<T> r100) {
        if (k.f157996b != null) goto L15;
        monitor-enter(k.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (k.f157996b != null) goto L9;
        k.f157996b = new k();     // Catch: Throwable -> L11
    L9:
        monitor-exit(k.class);     // Catch: Throwable -> L11
    L15:
        return (T) k.f157996b.a(r100, false);
    }

    public final <T> void b(Class<T> r100, k.b<T> r101) {
        this.f157987a.f158003a.c(r100, r101);
    }
}
