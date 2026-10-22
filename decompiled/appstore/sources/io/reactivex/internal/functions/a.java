package io.reactivex.internal.functions;

import io.reactivex.functions.BiPredicate;

/* JADX INFO: loaded from: classes4.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final BiPredicate f20610a = null;

    /* JADX INFO: renamed from: io.reactivex.internal.functions.a$a, reason: collision with other inner class name */
    public static final class C0272a implements BiPredicate {
        public C0272a() {
        }

        @Override // io.reactivex.functions.BiPredicate
        public boolean test(Object r10, Object r11) {
            return a.a(r10, r11);
        }
    }

    static {
        f20610a = new C0272a();
    }

    public static boolean a(Object r10, Object r11) {
        if (r10 == r11) goto L8;
        if (r10 != null) goto L5;
    L7:
        return false;
    L5:
        if (r10.equals(r11) == false) goto L7;
    L8:
        return true;
    }

    public static Object b(Object r10, String r11) {
        if (r10 == null) goto L5;
        return r10;
    L5:
        throw new NullPointerException(r11);
    }

    public static int c(int r10, String r11) {
        if (r10 <= 0) goto L5;
        return r10;
    L5:
        throw new IllegalArgumentException(r11 + " > 0 required but it was " + r10);
    }

    public static long d(long r10, String r11) {
        if (r10 <= 0) goto L6;
        return r10;
    L6:
        throw new IllegalArgumentException(r11 + " > 0 required but it was " + r10);
    }
}
