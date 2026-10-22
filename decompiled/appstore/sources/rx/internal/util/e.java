package rx.internal.util;

/* JADX INFO: loaded from: classes4.dex */
public abstract class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f24422a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final boolean f24423b = false;

    static {
        int r10 = c();
        f24422a = r10;
        if (r10 == 0) goto L5;
        boolean r11 = true;
    L6:
        f24423b = r11;
        return;
    L5:
        r11 = false;
        goto L6
    }

    public static int a() {
        return f24422a;
    }

    public static boolean b() {
        return f24423b;
    }

    public static int c() {
        return ((Integer) Class.forName("android.os.Build$VERSION").getField("SDK_INT").get(null)).intValue();
    L4:
        return 0;
    }
}
