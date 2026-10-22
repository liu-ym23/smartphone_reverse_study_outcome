package a7;

import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Method f61a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Method f62b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Method f63c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static Method f64d;

    static {
        Method[] r10 = Class.forName("android.os.SystemProperties").getMethods();     // Catch: ClassNotFoundException -> L7
        int r11 = r10.length;     // Catch: ClassNotFoundException -> L7
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L29;
        Method r13 = r10[r12];     // Catch: ClassNotFoundException -> L7
        String r14 = r13.getName();     // Catch: ClassNotFoundException -> L7
        if (r14.equals("get") == false) goto L10;
        f61a = r13;     // Catch: ClassNotFoundException -> L7
    L18:
        r12 = r12 + 1;
        goto L3
    L10:
        if (r14.equals("set") == false) goto L13;
        f64d = r13;     // Catch: ClassNotFoundException -> L7
        goto L18
    L13:
        if (r14.equals("getLong") == false) goto L16;
        f62b = r13;     // Catch: ClassNotFoundException -> L7
        goto L18
    L16:
        if (r14.equals("getInt") == false) goto L18;
        f63c = r13;     // Catch: ClassNotFoundException -> L7
        goto L18
    L29:
        return;
    L7:
        e = move-exception;
        e.printStackTrace();
    }

    public static String a(String r10, String r11) {
        Method r12 = f61a;
        if (r12 != null) goto L17;
        return r11;
    L17:
        return (String) r12.invoke(null, new Object[]{r10, r11});
    L9:
        e = move-exception;
        e.printStackTrace();
    L16:
        return r11;
    L11:
        e = move-exception;
        e.printStackTrace();
    L7:
        e = move-exception;
        e.printStackTrace();
        goto L16
    }
}
