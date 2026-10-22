package h2;

import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static HashMap f20318a;

    static {
        f20318a = new HashMap();
        a();
    }

    public static void a() {
        b("xx", 12334);
    }

    public static void b(String r10, int r11) {
        f20318a.put(r10, Integer.valueOf(r11));
    }

    public static Integer c(String r10) {
        return (Integer) f20318a.get(r10);
    }
}
