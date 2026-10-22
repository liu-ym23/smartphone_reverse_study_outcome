package l6;

import com.bytedance.common.utility.reflect.Reflect;

/* JADX INFO: loaded from: classes.dex */
public abstract class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile boolean f21878a = true;

    static {
    }

    public static void a() {
        if (f21878a == true) goto L10;
        return;
    L10:
        Reflect.on(Class.forName("com.bytedance.crash.Npth").newInstance()).call("registerSdk", new Class[]{Integer.TYPE, String.class}, new Object[]{2616, "4.1.79.42-pico"});     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        th.printStackTrace();
    }
}
