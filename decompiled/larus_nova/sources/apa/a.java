package apa;

/* JADX INFO: loaded from: classes5.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile b f15862a;

    public static void a(String r100, String r101) {
        if (f15862a != null) goto L5;
        return;
    L5:
        f15862a.d(r100, r101);
    }

    public static void b(String r100, String r101) {
        if (f15862a != null) goto L5;
        return;
    L5:
        f15862a.e(r100, r101);
    }

    public static void c(String r100, String r101, Throwable r102) {
        if (f15862a != null) goto L5;
        return;
    L5:
        f15862a.e(r100, r101, r102);
    }
}
