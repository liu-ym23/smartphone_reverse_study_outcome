package com.bytedance.apm.util;

/* JADX INFO: compiled from: ObjectsCompat.java */
/* JADX INFO: loaded from: classes.dex */
public class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final a f4987a = null;

    /* JADX INFO: renamed from: com.bytedance.apm.util.n$1, reason: invalid class name */
    /* JADX INFO: compiled from: ObjectsCompat.java */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* JADX INFO: compiled from: ObjectsCompat.java */
    private static class a {
        private a() {
        }

        /* synthetic */ a(AnonymousClass1 r1) {
            this();
        }

        public boolean a(Object r1, Object r2) {
            if (r1 == r2) goto L8;
            if (r1 != null) goto L5;
        L7:
            return false;
        L5:
            if (r1.equals(r2) == false) goto L7;
        L8:
            return true;
        }
    }

    static {
        f4987a = new a(null);
    }

    public static boolean a(Object r1, Object r2) {
        return f4987a.a(r1, r2);
    }
}
