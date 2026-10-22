package androidx.constraintlayout.a;

/* JADX INFO: compiled from: Pools.java */
/* JADX INFO: loaded from: classes.dex */
final class f {

    /* JADX INFO: compiled from: Pools.java */
    interface a<T> {
        T a();

        void a(T[] r1, int r2);

        boolean a(T r1);
    }

    /* JADX INFO: compiled from: Pools.java */
    static class b<T> implements a<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Object[] f800a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f801b;

        b(int r1) {
            if (r1 <= 0) goto L7;
            this.f800a = new Object[r1];
            return;
        L7:
            throw new IllegalArgumentException("The max pool size must be > 0");
        }

        @Override // androidx.constraintlayout.a.f.a
        public T a() {
            int r0 = this.f801b;
            if (r0 <= 0) goto L6;
            int r2 = r0 - 1;
            Object[] r3 = this.f800a;
            T r4 = (T) r3[r2];
            r3[r2] = null;
            this.f801b = r0 - 1;
            return r4;
        L6:
            return null;
        }

        @Override // androidx.constraintlayout.a.f.a
        public boolean a(T r4) {
            int r0 = this.f801b;
            Object[] r1 = this.f800a;
            if (r0 >= r1.length) goto L6;
            r1[r0] = r4;
            this.f801b = r0 + 1;
            return true;
        L6:
            return false;
        }

        @Override // androidx.constraintlayout.a.f.a
        public void a(T[] r6, int r7) {
            if (r7 <= r6.length) goto L5;
            r7 = r6.length;
        L5:
            int r0 = 0;
        L6:
            if (r0 >= r7) goto L11;
            T r1 = r6[r0];
            int r2 = this.f801b;
            Object[] r3 = this.f800a;
            if (r2 >= r3.length) goto L10;
            r3[r2] = r1;
            this.f801b = r2 + 1;
        L10:
            r0 = r0 + 1;
            goto L6
        }
    }
}
