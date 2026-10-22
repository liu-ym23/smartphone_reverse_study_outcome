package x4;

/* renamed from: x4.H, reason: case insensitive filesystem */
/* loaded from: classes.dex */
final /* synthetic */ class C1296H {

    /* renamed from: a, reason: collision with root package name */
    private static final int f23834a = Runtime.getRuntime().availableProcessors();

    public static final int a() {
        return f23834a;
    }

    public static final String b(String str) {
        try {
            return System.getProperty(str);
        } catch (SecurityException unused) {
            return null;
        }
    }
}
