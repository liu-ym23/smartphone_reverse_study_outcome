package androidx.media;

import android.os.Build;

/* JADX INFO: compiled from: VolumeProviderCompat.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f2229a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f2230b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f2231c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private a f2232d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Object f2233e;

    /* JADX INFO: compiled from: VolumeProviderCompat.java */
    public static abstract class a {
        public a() {
        }
    }

    public void a(int r1) {
    }

    public void b(int r1) {
    }

    public final int a() {
        return this.f2231c;
    }

    public final int b() {
        return this.f2229a;
    }

    public final int c() {
        return this.f2230b;
    }

    public void a(a r1) {
        this.f2232d = r1;
    }

    public Object d() {
        if (this.f2233e != null) goto L8;
        if (Build.VERSION.SDK_INT < 21) goto L8;
        this.f2233e = g.a(this.f2229a, this.f2230b, this.f2231c, new AnonymousClass1(this));
    L8:
        return this.f2233e;
    }
}
