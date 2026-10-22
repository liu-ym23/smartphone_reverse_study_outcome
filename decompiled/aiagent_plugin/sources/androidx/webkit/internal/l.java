package androidx.webkit.internal;

import java.util.HashSet;
import java.util.Set;

/* JADX INFO: compiled from: StartupApiFeature.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final /* synthetic */ boolean f2991a = true;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Set<l> f2992b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f2993c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f2994d;

    /* JADX INFO: compiled from: StartupApiFeature.java */
    public static class a extends l {
        a(String r1, String r2) {
            super(r1, r2);
        }
    }

    /* JADX INFO: compiled from: StartupApiFeature.java */
    public static class b extends l {
        b(String r1, String r2) {
            super(r1, r2);
        }
    }

    static {
        f2992b = new HashSet();
    }

    l(String r1, String r2) {
        this.f2993c = r1;
        this.f2994d = r2;
        f2992b.add(this);
    }
}
