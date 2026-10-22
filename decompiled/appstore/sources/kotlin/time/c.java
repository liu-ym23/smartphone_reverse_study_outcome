package kotlin.time;

/* JADX INFO: loaded from: classes4.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final boolean f21277a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ThreadLocal[] f21278b = null;

    static {
        ThreadLocal[] r10 = new ThreadLocal[4];
        int r11 = 0;
    L3:
        if (r11 >= 4) goto L5;
        r10[r11] = new ThreadLocal();
        r11 = r11 + 1;
        goto L3
    L5:
        f21278b = r10;
    }

    public static final boolean a() {
        return f21277a;
    }
}
