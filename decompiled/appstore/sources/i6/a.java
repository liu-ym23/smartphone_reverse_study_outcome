package i6;

import com.bytedance.services.apm.api.IEnsure;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static IEnsure f20514a;

    public static void a(String r10) {
        IEnsure r11 = f20514a;
        if (r11 != null) goto L5;
        return;
    L5:
        r11.ensureNotReachHere(r10);
    }

    public static void b(String r10, Map r11) {
        IEnsure r12 = f20514a;
        if (r12 != null) goto L5;
        return;
    L5:
        r12.ensureNotReachHere(r10, r11);
    }

    public static void c(Throwable r10) {
        IEnsure r11 = f20514a;
        if (r11 != null) goto L5;
        return;
    L5:
        r11.ensureNotReachHere(r10);
    }

    public static void d(Throwable r10, String r11) {
        IEnsure r12 = f20514a;
        if (r12 != null) goto L5;
        return;
    L5:
        r12.ensureNotReachHere(r10, r11);
    }

    public static void e(Throwable r10, String r11, Map r12) {
        IEnsure r13 = f20514a;
        if (r13 != null) goto L5;
        return;
    L5:
        r13.ensureNotReachHere(r10, r11, r12);
    }

    public static void f(int r10, Throwable r11, String r12, boolean r13) {
        IEnsure r14 = f20514a;
        if (r14 != null) goto L5;
        return;
    L5:
        r14.reportLogException(r10, r11, r12);
    }
}
