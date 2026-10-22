package com.fasterxml.jackson.databind.l;

import java.io.Serializable;

/* JADX INFO: compiled from: ViewMatcher.java */
/* JADX INFO: loaded from: classes2.dex */
public class ab implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected static final ab f13002a = null;

    /* JADX INFO: compiled from: ViewMatcher.java */
    private static final class a extends ab implements Serializable {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Class<?>[] f13003b;

        public a(Class<?>[] r1) {
            this.f13003b = r1;
        }

        @Override // com.fasterxml.jackson.databind.l.ab
        public boolean a(Class<?> r5) {
            int r0 = this.f13003b.length;
            int r2 = 0;
        L3:
            if (r2 >= r0) goto L12;
            Class<?> r3 = this.f13003b[r2];
            if (r5 == r3) goto L10;
            if (r3.isAssignableFrom(r5) == true) goto L16;
            r2 = r2 + 1;
            goto L3
        L16:
            return true;
        L10:
            return true;
        L12:
            return false;
        }
    }

    /* JADX INFO: compiled from: ViewMatcher.java */
    private static final class b extends ab {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Class<?> f13004b;

        public b(Class<?> r1) {
            this.f13004b = r1;
        }

        @Override // com.fasterxml.jackson.databind.l.ab
        public boolean a(Class<?> r1) {
            Class<?> r0 = this.f13004b;
            if (r1 != r0) goto L5;
        L8:
            return true;
        L5:
            if (r0.isAssignableFrom(r1) == true) goto L8;
            return false;
        }
    }

    public boolean a(Class<?> r1) {
        return false;
    }

    public ab() {
    }

    static {
        f13002a = new ab();
    }

    public static ab a(Class<?>[] r2) {
        if (r2 == null) goto L4;
        int r0 = r2.length;
        if (r0 == 0) goto L14;
        if (r0 == 1) goto L12;
        return new a(r2);
    L12:
        return new b(r2[0]);
    L14:
        return f13002a;
    L4:
        return f13002a;
    }
}
