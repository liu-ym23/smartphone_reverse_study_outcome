package androidx.webkit.internal;

import android.os.Build;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: compiled from: ApiFeature.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class a implements androidx.webkit.internal.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Set<a> f2981a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f2982b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f2983c;

    /* JADX INFO: renamed from: androidx.webkit.internal.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ApiFeature.java */
    private static class C0079a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final Set<String> f2984a = null;

        static {
            f2984a = new HashSet(Arrays.asList(q.a().c()));
        }
    }

    /* JADX INFO: compiled from: ApiFeature.java */
    public static class b extends a {
        b(String r1, String r2) {
            super(r1, r2);
        }

        @Override // androidx.webkit.internal.a
        public final boolean c() {
            if (Build.VERSION.SDK_INT < 23) goto L5;
            return true;
        L5:
            return false;
        }
    }

    /* JADX INFO: compiled from: ApiFeature.java */
    public static class c extends a {
        c(String r1, String r2) {
            super(r1, r2);
        }

        @Override // androidx.webkit.internal.a
        public final boolean c() {
            if (Build.VERSION.SDK_INT < 24) goto L5;
            return true;
        L5:
            return false;
        }
    }

    /* JADX INFO: compiled from: ApiFeature.java */
    public static class d extends a {
        @Override // androidx.webkit.internal.a
        public final boolean c() {
            return false;
        }

        d(String r1, String r2) {
            super(r1, r2);
        }
    }

    /* JADX INFO: compiled from: ApiFeature.java */
    public static class e extends a {
        e(String r1, String r2) {
            super(r1, r2);
        }

        @Override // androidx.webkit.internal.a
        public final boolean c() {
            if (Build.VERSION.SDK_INT < 26) goto L5;
            return true;
        L5:
            return false;
        }
    }

    /* JADX INFO: compiled from: ApiFeature.java */
    public static class f extends a {
        f(String r1, String r2) {
            super(r1, r2);
        }

        @Override // androidx.webkit.internal.a
        public final boolean c() {
            if (Build.VERSION.SDK_INT < 27) goto L5;
            return true;
        L5:
            return false;
        }
    }

    /* JADX INFO: compiled from: ApiFeature.java */
    public static class g extends a {
        g(String r1, String r2) {
            super(r1, r2);
        }

        @Override // androidx.webkit.internal.a
        public final boolean c() {
            if (Build.VERSION.SDK_INT < 28) goto L5;
            return true;
        L5:
            return false;
        }
    }

    /* JADX INFO: compiled from: ApiFeature.java */
    public static class h extends a {
        h(String r1, String r2) {
            super(r1, r2);
        }

        @Override // androidx.webkit.internal.a
        public final boolean c() {
            if (Build.VERSION.SDK_INT < 29) goto L5;
            return true;
        L5:
            return false;
        }
    }

    /* JADX INFO: compiled from: ApiFeature.java */
    public static class i extends a {
        i(String r1, String r2) {
            super(r1, r2);
        }

        @Override // androidx.webkit.internal.a
        public final boolean c() {
            if (Build.VERSION.SDK_INT < 33) goto L5;
            return true;
        L5:
            return false;
        }
    }

    public abstract boolean c();

    static {
        f2981a = new HashSet();
    }

    a(String r1, String r2) {
        this.f2982b = r1;
        this.f2983c = r2;
        f2981a.add(this);
    }

    @Override // androidx.webkit.internal.g
    public String a() {
        return this.f2982b;
    }

    @Override // androidx.webkit.internal.g
    public boolean b() {
        if (c() == false) goto L5;
    L8:
        return true;
    L5:
        if (d() == true) goto L8;
        return false;
    }

    public boolean d() {
        return org.chromium.support_lib_boundary.a.a.a(C0079a.f2984a, this.f2983c);
    }

    public static Set<a> e() {
        return Collections.unmodifiableSet(f2981a);
    }
}
