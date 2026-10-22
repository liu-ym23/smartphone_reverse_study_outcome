package androidx.room.b;

/* JADX INFO: compiled from: StringUtil.java */
/* JADX INFO: loaded from: classes.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String[] f2622a = null;

    static {
        f2622a = new String[0];
    }

    public static StringBuilder a() {
        return new StringBuilder();
    }

    public static void a(StringBuilder r2, int r3) {
        int r0 = 0;
    L3:
        if (r0 >= r3) goto L8;
        r2.append("?");
        if (r0 >= (r3 - 1)) goto L7;
        r2.append(",");
    L7:
        r0 = r0 + 1;
        goto L3
    }
}
