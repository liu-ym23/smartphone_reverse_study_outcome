package com.obric.oui.constraintlayout.a;

/* JADX INFO: compiled from: Pools.java */
/* JADX INFO: loaded from: classes4.dex */
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
        private final Object[] f34782a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f34783b;

        b(int r1) {
            if (r1 <= 0) goto L7;
            this.f34782a = new Object[r1];
            return;
        L7:
            throw new IllegalArgumentException("The max pool size must be > 0");
        }

        @Override // com.obric.oui.constraintlayout.a.f.a
        public T a() {
            int r0 = this.f34783b;
            if (r0 <= 0) goto L6;
            int r2 = r0 - 1;
            Object[] r3 = this.f34782a;
            T r4 = (T) r3[r2];
            r3[r2] = null;
            this.f34783b = r0 - 1;
            return r4;
        L6:
            return null;
        }

        @Override // com.obric.oui.constraintlayout.a.f.a
        public boolean a(T r4) {
            int r0 = this.f34783b;
            Object[] r1 = this.f34782a;
            if (r0 >= r1.length) goto L6;
            r1[r0] = r4;
            this.f34783b = r0 + 1;
            return true;
        L6:
            return false;
        }

        @Override // com.obric.oui.constraintlayout.a.f.a
        public void a(T[] r6, int r7) {
            if (r7 <= r6.length) goto L5;
            r7 = r6.length;
        L5:
            int r0 = 0;
        L6:
            if (r0 >= r7) goto L11;
            T r1 = r6[r0];
            int r2 = this.f34783b;
            Object[] r3 = this.f34782a;
            if (r2 >= r3.length) goto L10;
            r3[r2] = r1;
            this.f34783b = r2 + 1;
        L10:
            r0 = r0 + 1;
            goto L6
        }
    }
}
