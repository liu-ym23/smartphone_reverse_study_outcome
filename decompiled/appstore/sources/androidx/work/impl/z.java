package androidx.work.impl;

/* JADX INFO: loaded from: classes.dex */
public abstract class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f5901a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String[] f5902b = null;

    static {
        String r10 = androidx.work.i.i("WrkDbPathHelper");
        kotlin.jvm.internal.q.f(r10, "tagWithPrefix(\"WrkDbPathHelper\")");
        f5901a = r10;
        f5902b = new String[]{"-journal", "-shm", "-wal"};
    }

    public static final /* synthetic */ String[] a() {
        return f5902b;
    }

    public static final /* synthetic */ String b() {
        return f5901a;
    }
}
