package ci7;

import com.bytedance.ug.sdk.deeplink.interfaces.IExecutor;
import java.util.HashMap;

/* JADX INFO: loaded from: classes3.dex */
public final class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final HashMap<String, HashMap<Object, ?>> f23893a = null;

    static {
        f23893a = new HashMap();
        b(IExecutor.class, IExecutor.DEFAULT);
    }

    public static <T> T a(Class<T> r100) {
        HashMap<String, HashMap<Object, ?>> r101 = f23893a;
        monitor-enter(r101);
        HashMap<Object, ?> r102 = r101.get(r100.getName());     // Catch: Throwable -> L12
        if (r102 == null) goto L9;
        T r103 = (T) r102.get("DEFAULT_KEY");
        monitor-exit(r101);     // Catch: Throwable -> L12
        return r103;
    L9:
        monitor-exit(r101);     // Catch: Throwable -> L12
        return null;
    L12:
        th = move-exception;
        throw th;
    }

    public static <T, K extends T> void b(Class<T> r100, K r101) {
        if (r100 == null) goto L16;
        if (r101 == null) goto L19;
        HashMap<String, HashMap<Object, ?>> r102 = f23893a;
        monitor-enter(r102);
        String r103 = r100.getName();     // Catch: Throwable -> L13
        HashMap<Object, ?> r104 = r102.get(r103);     // Catch: Throwable -> L13
        if (r104 != null) goto L10;
        r104 = new HashMap();     // Catch: Throwable -> L13
        r102.put(r103, r104);     // Catch: Throwable -> L13
    L10:
        r104.put("DEFAULT_KEY", r101);     // Catch: Throwable -> L13
        monitor-exit(r102);     // Catch: Throwable -> L13
        return;
    L13:
        th = move-exception;
        throw th;
    L19:
        return;
    }
}
