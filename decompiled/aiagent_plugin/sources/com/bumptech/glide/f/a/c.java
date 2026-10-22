package com.bumptech.glide.f.a;

/* JADX INFO: compiled from: StateVerifier.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class c {

    /* JADX INFO: renamed from: com.bumptech.glide.f.a.c$1, reason: invalid class name */
    /* JADX INFO: compiled from: StateVerifier.java */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* JADX INFO: compiled from: StateVerifier.java */
    private static class a extends c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private volatile boolean f3319a;

        a() {
            super(null);
        }

        @Override // com.bumptech.glide.f.a.c
        public void b() {
            if (this.f3319a == true) goto L6;
            return;
        L6:
            throw new IllegalStateException("Already released");
        }

        @Override // com.bumptech.glide.f.a.c
        public void a(boolean r1) {
            this.f3319a = r1;
        }
    }

    abstract void a(boolean r1);

    public abstract void b();

    /* synthetic */ c(AnonymousClass1 r1) {
        this();
    }

    public static c a() {
        return new a();
    }

    private c() {
    }
}
