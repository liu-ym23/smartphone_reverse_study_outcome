package androidx.core.util;

/* JADX INFO: compiled from: Pools.java */
/* JADX INFO: loaded from: classes.dex */
public final class f {

    /* JADX INFO: compiled from: Pools.java */
    public interface a<T> {
        T a();

        boolean a(T r1);
    }

    /* JADX INFO: compiled from: Pools.java */
    public static class b<T> implements a<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Object[] f1373a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f1374b;

        public b(int r1) {
            if (r1 <= 0) goto L7;
            this.f1373a = new Object[r1];
            return;
        L7:
            throw new IllegalArgumentException("The max pool size must be > 0");
        }

        @Override // androidx.core.util.f.a
        public T a() {
            int r0 = this.f1374b;
            if (r0 <= 0) goto L6;
            int r2 = r0 - 1;
            Object[] r3 = this.f1373a;
            T r4 = (T) r3[r2];
            r3[r2] = null;
            this.f1374b = r0 - 1;
            return r4;
        L6:
            return null;
        }

        @Override // androidx.core.util.f.a
        public boolean a(T r4) {
            if (b(r4) == true) goto L11;
            int r0 = this.f1374b;
            Object[] r1 = this.f1373a;
            if (r0 >= r1.length) goto L8;
            r1[r0] = r4;
            this.f1374b = r0 + 1;
            return true;
        L8:
            return false;
        L11:
            throw new IllegalStateException("Already in the pool!");
        }

        private boolean b(T r4) {
            int r1 = 0;
        L4:
            if (r1 >= this.f1374b) goto L10;
            if (this.f1373a[r1] == r4) goto L7;
            r1 = r1 + 1;
            goto L4
        L7:
            return true;
        L10:
            return false;
        }
    }

    /* JADX INFO: compiled from: Pools.java */
    public static class c<T> extends b<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Object f1375a;

        public c(int r1) {
            super(r1);
            this.f1375a = new Object();
        }

        @Override // androidx.core.util.f.b, androidx.core.util.f.a
        public T a() {
            Object r0 = this.f1375a;
            monitor-enter(r0);
            T r1 = (T) super.a();
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // androidx.core.util.f.b, androidx.core.util.f.a
        public boolean a(T r2) {
            Object r0 = this.f1375a;
            monitor-enter(r0);
            boolean r1 = super.a(r2);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }
    }
}
